package com.felipe.app;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import com.felipe.app.adapters.FruitAdapter;
import com.felipe.app.models.pojos.Fruit;
import com.felipe.app.models.schemas.FruitsJSON;
import com.felipe.app.services.RestClient;
import com.felipe.app.services.FruitService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * A placeholder fragment containing a simple view.
 */
public class FruitsActivity extends BaseActivity implements ActivityAction {

    private List<Fruit> fruits;
    private FruitAdapter fAdapter;
    private RecyclerView fruitList;
    private ProgressBar progBarSm;


    public FruitsActivity() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits);
        onConfigure();
        getFruits();

    }

    public void getFruits(){
        changeProgressBar();
        Retrofit instance = RestClient.getInstance();
        FruitService service = instance.create(FruitService.class);
        Observable<FruitsJSON> fruitsObservable = service.listFruits();

        fruitsObservable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {
                    fruits.addAll(result.getFruits());
                    fAdapter.notifyDataSetChanged();
                    changeProgressBar();
                });

    }

    @Override
    public void onConfigure(){
        configWidgets(R.id.recycler);
        configWidgets(R.id.pb_progress_small);
        configureToolbar();

        fruits = new ArrayList<Fruit>();
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this);
        fruitList.setLayoutManager(layout);
        fAdapter = new FruitAdapter(this, fruits);
        fruitList.setAdapter(fAdapter);
    }

    @Override
    public void configWidgets(int vid) {

        switch (vid){
            case R.id.recycler:
                fruitList = (RecyclerView) findViewById(vid);
                break;

            case R.id.pb_progress_small:
                progBarSm = (ProgressBar) findViewById(vid);
                break;
        }

    }

    @Override
    public void configureToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    protected void changeProgressBar(){
        if (progBarSm.getVisibility() == View.INVISIBLE){
            progBarSm.setVisibility(View.VISIBLE);

        } else {
            progBarSm.setVisibility(View.INVISIBLE);
        }
    }


}
