/*
 * Sabbia copyright © 2020
 * Author: mauromarini - https://github.com/marinimau
 * Package: com.marinumau.sabbia.ui.detail
 * Date: 10/07/2020
 */

package com.marinumau.sabbia.ui.detail;

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
import com.marinumau.sabbia.logic.PostManager.PostAdapter;
import com.marinumau.sabbia.logic.PostManager.PostFactory;

import java.util.Objects;

public class PostFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     *
     * @param index the index of the fragment
     * @return the postFragment
     */
    public static PostFragment newInstance(int index) {
        PostFragment fragment = new PostFragment();
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
        PageViewModel pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
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

        View root = inflater.inflate(R.layout.fragment_beach_messages, container, false);
        populatePostList(root);

        return root;
    }

    /**
     *
     * @param root the root view
     */
    private void populatePostList(View root){
        PostFactory postFactory = PostFactory.getInstance();
        RecyclerView recyclerView = root.findViewById(R.id.post_rv);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        PostAdapter adapter = new PostAdapter(getActivity(), Objects.requireNonNull(getActivity()).getApplicationContext(), postFactory.getPostList());
        recyclerView.setAdapter(adapter);
    }
}