/*
 * Sabbia copyright © 2020
 * Author: mauromarini - https://github.com/marinimau
 * Package: com.marinumau.sabbia.logic.BeachManager
 * Date: 03/07/2020
 */

package com.marinumau.sabbia.logic.BeachManager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.marinumau.sabbia.R;
import com.marinumau.sabbia.ui.home.HomeFragment;

import java.util.ArrayList;

public class BeachAdapter extends RecyclerView.Adapter<BeachAdapter.ViewHolder>{

    private ArrayList<Beach> beachItems;
    private LayoutInflater mInflater;
    private BeachAdapter.ItemClickListener mClickListener;
    private Context context;

    /**
     *  @param context the calling activity context
     * @param data the data to inflate*/
    public BeachAdapter(Context context, ArrayList<Beach> data) {
        this.mInflater = LayoutInflater.from(context);
        this.beachItems = data;
        this.context = context;
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
        View view = mInflater.inflate(R.layout.home_activity_history_item, parent, false);
        return new ViewHolder(view);
    }

    /**
     *
     * @param holder the view holder
     * @param position the current position
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(beachItems.get(position).name);
        holder.subtitle.setText(beachItems.get(position).location);
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
        TextView title;
        TextView subtitle;

        ViewHolder(View itemView) {
            super(itemView);
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

