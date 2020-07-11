package com.marinumau.sabbia;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.marinumau.sabbia.logic.MenuLinksManager.LinkAdapter;
import com.marinumau.sabbia.logic.MenuLinksManager.LinkFactory;
import com.marinumau.sabbia.utils.AlertManager;

import java.util.Objects;

public class Settings extends SabbiaActivity {

    /**
     *
     * @param savedInstanceState the saved instance
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        super.initActionBar();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        populateLinks();
        initUpdateUserData();
    }


    /**
     *
     */
    private void populateLinks(){
        LinkFactory linkFactory = LinkFactory.getInstance();
        RecyclerView recyclerView = findViewById(R.id.links_rv);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        dividerItemDecoration.setDrawable(Objects.requireNonNull(getDrawable(R.drawable.links_divider)));
        //recyclerView.addItemDecoration(dividerItemDecoration);

        LinkAdapter adapter = new LinkAdapter(this, this, linkFactory.getLinkList());
        recyclerView.setAdapter(adapter);

    }

    /**
     * 
     */
    private void initUpdateUserData(){
        TextView userDataMenuItem = findViewById(R.id.edit_user_tv);
        userDataMenuItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertManager.showSnackBarSimple(Settings.this, Settings.this, "Prova snackbar");
            }
        });
    }
}