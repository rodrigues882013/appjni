package com.felipe.app;

import android.app.ListFragment;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.felipe.app.adapters.FruitAdapter;
import com.felipe.app.models.Fruit;
import com.felipe.app.services.APIClient;
import com.felipe.app.services.FruitService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;

/**
 * A placeholder fragment containing a simple view.
 */
public class FruitsActivityFragment extends ListFragment {

    private List<Fruit> fruits;
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
        fruits = new ArrayList<Fruit>();
        FruitAdapter fAdapter = new FruitAdapter(getActivity(), fruits);
        setListAdapter(fAdapter);
    }

    public void getFruits(){
        Retrofit instance = APIClient.getInstance();
        FruitService service = instance.create(FruitService.class);
        //fruits.addAll(service.listFruits())
    }


}
