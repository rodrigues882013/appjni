package com.felipe.app;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.felipe.app.adapters.FruitAdapter;
import com.felipe.app.helpers.ProccessValueListener;
import com.felipe.app.models.pojos.Fruit;
import com.felipe.app.models.schemas.FruitsJSON;
import com.felipe.app.services.FruitService;
import com.felipe.app.services.NativeAPI;
import com.felipe.app.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;


public class FruitsActivity extends BaseActivity implements ActivityAction,
        ProccessValueListener, SwipeRefreshLayout.OnRefreshListener {

    private List<Fruit> fruits;
    private FruitAdapter fAdapter;
    private RecyclerView fruitList;
    private ProgressBar progBarSm;
    private Disposable subscription;
    private SwipeRefreshLayout refreshLayout;

    @Inject
    @Named("native")
    NativeAPI nativeInstance;

    @Inject
    @Named("retrofit")
    Retrofit retrofitInstance;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i(Utils.MUXI_TAG, "Creating Fruits Activity (fruits list)");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits);

        ((CustomApplication)getApplication()).getNetworkComponent().inject(this);
        nativeInstance.setContext(this);

        onConfigure();
        getFruits();

    }

    @Override
    public void onConfigure(){
        Log.i(Utils.MUXI_TAG, "Configure Activity");
        configWidgets(R.id.recycler);
        configWidgets(R.id.pb_progress_small);
        configWidgets(R.id.refresh);
        configureToolbar();

        fruits = new ArrayList<Fruit>();
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this);
        fruitList.setLayoutManager(layout);
        fAdapter = new FruitAdapter(this, fruits);
        fruitList.setAdapter(fAdapter);
    }

    @Override
    public void configWidgets(int vid) {
        Log.i(Utils.MUXI_TAG, "Configure widgets");
        switch (vid){
            case R.id.recycler:
                fruitList = (RecyclerView) findViewById(vid);
                break;

            case R.id.pb_progress_small:
                progBarSm = (ProgressBar) findViewById(vid);
                break;

            case R.id.refresh:
                refreshLayout = (SwipeRefreshLayout) findViewById(vid);
                refreshLayout.setOnRefreshListener(this);
                break;
        }

    }

    @Override
    public void configureToolbar(){
        Log.i(Utils.MUXI_TAG, "Configure toolbar");
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


    @Override
    public void onCalculeComplete(double result, int position) {
        Log.i(Utils.MUXI_TAG, "Price was calculated from native code");
        Fruit f = fruits.get(position);
        f.setPriceReal(result);
        fruits.set(position, f);
        fAdapter.notifyDataSetChanged();

    }

    @Override
    protected void onResume() {
        super.onResume();
        fAdapter.notifyDataSetChanged();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Release resources to avoid memory leaks
        if (subscription != null && !subscription.isDisposed()){
            subscription.dispose();
        }
    }

    public void getFruits(){
        Log.i(Utils.MUXI_TAG, "Retrieve fruits list from API");

        FruitService service = retrofitInstance.create(FruitService.class);
        Observable<FruitsJSON> fruitsObservable = service.listFruits();

        subscription = fruitsObservable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        result -> {
                            int idx = 0;
                            fruits.clear();
                            for (Fruit f : result.getFruits()) {
                                fruits.add(f);
                                nativeInstance.asyncConvertToReal(f.getPrice(), idx);
                                idx += 1;
                            }
                            fAdapter.notifyDataSetChanged();
                            changeProgressBar();
                            refreshLayout.setRefreshing(false);
                        },
                        error -> {
                            Utils.onErrorHandler(this, error.toString());
                            TextView tv = (TextView) findViewById(R.id.no_data);
                            tv.setVisibility(View.VISIBLE);
                            changeProgressBar();
                            refreshLayout.setRefreshing(false);
                        }
                );
    }


    protected void changeProgressBar(){                                                                                                                                                                                                 
        progBarSm.setVisibility(View.GONE);
    }


    @Override
    public void onRefresh() {
        refreshLayout.setRefreshing(true);
        getFruits();
    }
}
