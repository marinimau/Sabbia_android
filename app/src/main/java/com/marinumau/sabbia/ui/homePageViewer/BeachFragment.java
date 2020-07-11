/*
 * Sabbia copyright © 2020
 * Author: mauromarini - https://github.com/marinimau
 * Package: com.marinumau.sabbia.ui.homePageViewer
 * Date: 11/07/2020
 */

package com.marinumau.sabbia.ui.homePageViewer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.marinumau.sabbia.R;
import com.marinumau.sabbia.logic.BeachManager.BeachAdapter;
import com.marinumau.sabbia.logic.BeachManager.BeachFactory;
import com.marinumau.sabbia.ui.detail.PageViewModel;

import java.util.Objects;

abstract public class BeachFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     *
     * @param index the index of the fragment
     * @return the postFragment
     */
    public static com.marinumau.sabbia.ui.detail.PostFragment newInstance(int index) {
        com.marinumau.sabbia.ui.detail.PostFragment fragment = new com.marinumau.sabbia.ui.detail.PostFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    /**
     *
     * @param savedInstanceState the saved instance
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.marinumau.sabbia.ui.detail.PageViewModel pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    /**
     *
     * @param inflater the layout inflater
     * @param container the container
     * @param savedInstanceState the staved instance
     * @return the root view
     */
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.home_beach_carusel, container, false);
        populateBeachList(root);

        return root;
    }

    /**
     *
     * @param root the root view
     */
    abstract public void populateBeachList(View root);

}

