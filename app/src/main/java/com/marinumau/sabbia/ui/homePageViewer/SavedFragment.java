/*
 * Sabbia copyright © 2020
 * Author: mauromarini - https://github.com/marinimau
 * Package: com.marinumau.sabbia.ui.homePageViewer
 * Date: 11/07/2020
 */

package com.marinumau.sabbia.ui.homePageViewer;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.marinumau.sabbia.logic.BeachManager.BeachAdapter;
import com.marinumau.sabbia.logic.BeachManager.BeachFactory;


import java.util.Objects;

public class SavedFragment extends BeachFragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     *
     * @param index the index of the fragment
     * @return the postFragment
     */
    public static SavedFragment newInstance(int index) {
        SavedFragment fragment = new SavedFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    /**
     *
     * @param root the root view
     */
    public void populateBeachList(View root){
        BeachFactory beachFactory = BeachFactory.getInstance();
        BeachAdapter adapter = new BeachAdapter(getActivity(), Objects.requireNonNull(getActivity()).getApplicationContext(), beachFactory.getBeachList());
        recyclerView.setAdapter(adapter);
    }
}

