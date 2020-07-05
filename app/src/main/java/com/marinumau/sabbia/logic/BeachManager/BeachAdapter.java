/*
 * Sabbia copyright © 2020
 * Author: mauromarini - https://github.com/marinimau
 * Package: com.marinumau.sabbia.logic.BeachManager
 * Date: 03/07/2020
 */

package com.marinumau.sabbia.logic.BeachManager;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.marinumau.sabbia.BeachDetail;
import com.marinumau.sabbia.R;

import java.util.ArrayList;

public class BeachAdapter extends RecyclerView.Adapter<BeachAdapter.ViewHolder>{

    private ArrayList<Beach> beachItems;
    private LayoutInflater mInflater;
    private BeachAdapter.ItemClickListener mClickListener;
    private Context context;
    private Activity activity;
    private int type;

    /**
     * @param activity the calling activity
     * @param context the calling activity context
     * @param data the data to inflate*/
    public BeachAdapter(Activity activity, Context context, ArrayList<Beach> data) {
        this.mInflater = LayoutInflater.from(context);
        this.beachItems = data;
        this.context = context;
        this.activity = activity;
        this.type = 0;
    }

    /**
     * @param activity the calling activity
     * @param context the calling activity context
     * @param data the data to inflate
     * @param type the type of the view required */
    public BeachAdapter(Activity activity, Context context, ArrayList<Beach> data, int type) {
        this.mInflater = LayoutInflater.from(context);
        this.beachItems = data;
        this.context = context;
        this.activity = activity;
        this.type = type;
    }

    /**
     *
     * @param parent the parent layout
     * @param viewType the type of the view
     * @return the view holder
     */
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (this.type){
            case 0:
                view = mInflater.inflate(R.layout.last_updated_beach_item, parent, false);
                break;
            case 1:
                view = mInflater.inflate(R.layout.promoted_beach_item, parent, false);
                break;
            default:
                view = mInflater.inflate(R.layout.home_activity_history_item, parent, false);
        }

        return new ViewHolder(view);
    }

    /**
     *
     * @param holder the view holder
     * @param position the current position
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.title.setText(beachItems.get(position).getName());
        holder.subtitle.setText(beachItems.get(position).getLocation());

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDetails(beachItems.get(position).getId(), view);
            }
        });
    }

    /**
     *
     * @param id the id of the beach
     */
    private void showDetails(int id, View view) {
        Intent myIntent = new Intent(activity, BeachDetail.class);
        myIntent.putExtra("beach_id", id);
        activity.startActivity(myIntent, ActivityOptions.makeSceneTransitionAnimation(activity).toBundle());
    }

    /**
     *
     * @return the size of the list
     */
    @Override
    public int getItemCount() {
        return beachItems.size();
    }

    /**
     *
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView container;
        TextView title;
        TextView subtitle;

        ViewHolder(View itemView) {
            super(itemView);
            container = itemView.findViewById(R.id.card_container);
            title = itemView.findViewById(R.id.title);
            subtitle = itemView.findViewById(R.id.subtitle);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());

        }
    }

    /**
     *
     * @param position the position of the beach in the list
     * @return the beach at the given position
     */
    Beach getItem(int position) {
        return beachItems.get(position);
    }

    /**
     *
     * @param itemClickListener click listener of the list item
     */
    void setClickListener(BeachAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    /**
     *
     */
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}

