package com.marinumau.sabbia.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.marinumau.sabbia.R;
import com.marinumau.sabbia.logic.BeachManager.BeachAdapter;
import com.marinumau.sabbia.logic.BeachManager.BeachFactory;

import java.util.Objects;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView beachHistory;

    /**
     *
     * @param inflater the inflater
     * @param container the container
     * @param savedInstanceState the savedInstances state
     * @return the rootView
     */
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        populateHystory(root);

        return root;
    }

    private void populateHystory(View root){
        BeachFactory beachFactory = BeachFactory.getInstance();
        RecyclerView recyclerView = root.findViewById(R.id.menuGrid);
        int numberOfColumns = 2;
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), numberOfColumns));
        BeachAdapter adapter = new BeachAdapter(Objects.requireNonNull(getActivity()).getApplicationContext(), beachFactory.getBeachList());
        //adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }
}