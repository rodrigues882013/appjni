package com.felipe.app;

import android.support.design.widget.CoordinatorLayout;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.felipe.app.adapters.FruitAdapter;
import com.felipe.app.models.Fruit;
import com.felipe.app.models.FruitsJSON;
import com.felipe.app.services.EndPointManager;
import com.felipe.app.services.FruitService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A placeholder fragment containing a simple view.
 */
public class FruitsActivity extends BaseActivity {

    private List<Fruit> fruits;
    private FruitAdapter fAdapter;
    private RecyclerView fruitList;
    private RecyclerView.LayoutManager layout;
    private CoordinatorLayout coordinatorLayout;


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
        Log.e("MUXI", "getFruits");
        Retrofit instance = EndPointManager.getInstance();
        FruitService service = instance.create(FruitService.class);
        Call<FruitsJSON> call = service.listFruits();

        call.enqueue(new Callback<FruitsJSON>() {
            @Override
            public void onResponse(Call<FruitsJSON> call, Response<FruitsJSON> response) {
                FruitsJSON result = response.body();
                fruits.addAll(result.getFruits());
                fAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<FruitsJSON> call, Throwable t) {
                Log.e("MUXI", t.getMessage());
            }
        });
    }

    public void onConfigure(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fruits = new ArrayList<Fruit>();
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.activity_base);
        fruitList = (RecyclerView) findViewById(R.id.recycler);
        layout = new LinearLayoutManager(this);
        fruitList.setLayoutManager(layout);
        fAdapter = new FruitAdapter(this, fruits);
        fruitList.setAdapter(fAdapter);
    }


}
