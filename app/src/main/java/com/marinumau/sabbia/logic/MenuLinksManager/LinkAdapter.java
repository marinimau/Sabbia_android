/*
 * Sabbia copyright © 2020
 * Author: mauromarini - https://github.com/marinimau
 * Package: com.marinumau.sabbia.logic.MenuLinksManager
 * Date: 10/07/2020
 */

package com.marinumau.sabbia.logic.MenuLinksManager;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.marinumau.sabbia.R;
import com.marinumau.sabbia.utils.UrlManager;

import java.util.ArrayList;

public class LinkAdapter extends RecyclerView.Adapter<LinkAdapter.ViewHolder>{

    private ArrayList<Link> linkItems;
    private LayoutInflater mInflater;
    private LinkAdapter.ItemClickListener mClickListener;
    private Context context;
    private Activity activity;

    /**
     * @param activity the calling activity
     * @param context the calling activity context
     * @param data the data to inflate
     */
    public LinkAdapter(Activity activity, Context context, ArrayList<Link> data) {
        this.mInflater = LayoutInflater.from(context);
        this.linkItems = data;
        this.context = context;
        this.activity = activity;
    }

    /**
     *
     * @param parent the parent layout
     * @param viewType the type of the view
     * @return the view holder
     */
    @Override
    @NonNull
    public LinkAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = mInflater.inflate(R.layout.link_item, parent, false);

        return new LinkAdapter.ViewHolder(view);
    }

    /**
     *
     * @param holder the view holder
     * @param position the current position
     */
    @Override
    public void onBindViewHolder(@NonNull LinkAdapter.ViewHolder holder, final int position) {
        holder.linkText.setText(linkItems.get(position).getTitle());

        holder.linkText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UrlManager.open_url(context, linkItems.get(position).getUrl());
            }
        });

    }


    /**
     *
     * @return the size of the list
     */
    @Override
    public int getItemCount() {
        return linkItems.size();
    }

    /**
     *
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView linkText;

        ViewHolder(View itemView) {
            super(itemView);
            linkText = itemView.findViewById(R.id.link_tv);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());

        }
    }

    /**
     *
     * @param position the position of the link in the list
     * @return the link at the given position
     */
    Link getItem(int position) {
        return linkItems.get(position);
    }

    /**
     *
     * @param itemClickListener click listener of the list item
     */
    void setClickListener(LinkAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    /**
     *
     */
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
