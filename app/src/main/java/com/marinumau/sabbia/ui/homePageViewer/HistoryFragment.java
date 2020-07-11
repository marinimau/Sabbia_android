/*
 * Sabbia copyright © 2020
 * Author: mauromarini - https://github.com/marinimau
 * Package: com.marinumau.sabbia.ui.homePageViewer
 * Date: 11/07/2020
 */

package com.marinumau.sabbia.ui.homePageViewer;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.marinumau.sabbia.R;
import com.marinumau.sabbia.logic.BeachManager.BeachAdapter;
import com.marinumau.sabbia.logic.BeachManager.BeachFactory;

import java.util.Objects;

public class HistoryFragment extends BeachFragment {

    /**
     *
     * @param root the root view
     */
    public void populateBeachList(View root){
        BeachFactory beachFactory = BeachFactory.getInstance();
        RecyclerView recyclerView = root.findViewById(R.id.rv);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        BeachAdapter adapter = new BeachAdapter(getActivity(), Objects.requireNonNull(getActivity()).getApplicationContext(), beachFactory.getBeachList());
        recyclerView.setAdapter(adapter);
    }
}