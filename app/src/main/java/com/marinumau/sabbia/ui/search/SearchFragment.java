package com.marinumau.sabbia.ui.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.marinumau.sabbia.R;
import com.marinumau.sabbia.logic.BeachManager.BeachAdapter;
import com.marinumau.sabbia.logic.BeachManager.BeachFactory;

import java.util.Objects;

public class SearchFragment extends Fragment {

    private SearchViewModel searchViewModel;

    /**
     *
     * @param inflater the layout iflater
     * @param container the container
     * @param savedInstanceState the saved instances
     * @return the rendered fragment
     */
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        searchViewModel =
                ViewModelProviders.of(this).get(SearchViewModel.class);
        View root = inflater.inflate(R.layout.fragment_search, container, false);

        searchViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });

        populatePromoted(root);
        populateLastUpdated(root);


        return root;
    }

    /**
     *
     * @param root the root view
     */
    private void populatePromoted(View root){
        BeachFactory beachFactory = BeachFactory.getInstance();
        RecyclerView recyclerView = root.findViewById(R.id.promoted_rv);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(layoutManager);

        BeachAdapter adapter = new BeachAdapter(getActivity(), Objects.requireNonNull(getActivity()).getApplicationContext(), beachFactory.getBeachList(), 1);
        recyclerView.setAdapter(adapter);
    }

    /**
     *
     * @param root the root view
     */
    private void populateLastUpdated(View root){
        BeachFactory beachFactory = BeachFactory.getInstance();
        RecyclerView recyclerView = root.findViewById(R.id.last_update_rv);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);

        BeachAdapter adapter = new BeachAdapter(getActivity(), Objects.requireNonNull(getActivity()).getApplicationContext(), beachFactory.getBeachList(), 0);
        recyclerView.setAdapter(adapter);
    }
}