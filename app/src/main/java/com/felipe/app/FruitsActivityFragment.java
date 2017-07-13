package com.felipe.app;

import android.app.ListFragment;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.felipe.app.adapters.FruitAdapter;
import com.felipe.app.models.Fruit;
import com.felipe.app.models.FruitsJSON;
import com.felipe.app.services.APIClient;
import com.felipe.app.services.FruitService;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A placeholder fragment containing a simple view.
 */
public class FruitsActivityFragment extends Fragment {

    private List<Fruit> fruits;
    private FruitAdapter fAdapter;
    private RecyclerView fruitList;
    private RecyclerView.LayoutManager layout;
    private CoordinatorLayout coordinatorLayout;


    public FruitsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fruits_list, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        onConfigure();
        getFruits();

    }

    public void getFruits(){
        Log.e("MUXI", "getFruits");
        Retrofit instance = APIClient.getInstance();
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
        fruits = new ArrayList<Fruit>();
        coordinatorLayout = (CoordinatorLayout) getActivity().findViewById(R.id.activity_base);
        fruitList = (RecyclerView) getActivity().findViewById(R.id.recycler);
        layout = new LinearLayoutManager(getActivity());
        fruitList.setLayoutManager(layout);
        fAdapter = new FruitAdapter(getActivity(), fruits);
        fruitList.setAdapter(fAdapter);
    }


}
