/*
 * Sabbia copyright © 2020
 * Author: mauromarini - https://github.com/marinimau
 * Package: com.marinumau.sabbia.logic.PostManager
 * Date: 10/07/2020
 */

package com.marinumau.sabbia.logic.PostManager;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.marinumau.sabbia.R;
import com.marinumau.sabbia.utils.UIConfigurationManager;

import java.util.ArrayList;


public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder>{

    private ArrayList<Post> postItems;
    private LayoutInflater mInflater;
    private PostAdapter.ItemClickListener mClickListener;
    private Context context;
    private Activity activity;

    /**
     * @param activity the calling activity
     * @param context the calling activity context
     * @param data the data to inflate 
     */
    public PostAdapter(Activity activity, Context context, ArrayList<Post> data) {
        this.mInflater = LayoutInflater.from(context);
        this.postItems = data;
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
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = mInflater.inflate(R.layout.post_item, parent, false);

        return new PostAdapter.ViewHolder(view);
    }

    /**
     *
     * @param holder the view holder
     * @param position the current position
     */
    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, final int position) {
        holder.author.setText(postItems.get(position).getAuthor());
        holder.date.setText(postItems.get(position).getDate());
        holder.corpus.setText(postItems.get(position).getCorpus());

        if(UIConfigurationManager.getNightModeConfiguration(activity) == Configuration.UI_MODE_NIGHT_YES){
            holder.root.setCardBackgroundColor(activity.getColor(R.color.darkModeColorElevated));
        }

    }
    

    /**
     *
     * @return the size of the list
     */
    @Override
    public int getItemCount() {
        return postItems.size();
    }

    /**
     *
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView root;
        TextView author;
        TextView date;
        TextView corpus;

        ViewHolder(View itemView) {
            super(itemView);
            root = itemView.findViewById(R.id.card_container);
            author = itemView.findViewById(R.id.author);
            date = itemView.findViewById(R.id.date);
            corpus = itemView.findViewById(R.id.corpus);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());

        }
    }

    /**
     *
     * @param position the position of the post in the list
     * @return the post at the given position
     */
    Post getItem(int position) {
        return postItems.get(position);
    }

    /**
     *
     * @param itemClickListener click listener of the list item
     */
    void setClickListener(PostAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    /**
     *
     */
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
