package com.example.cinedome.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.cinedome.R;
import com.example.cinedome.model.Horaires;
import java.util.List;
import androidx.recyclerview.widget.RecyclerView;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {
    private List<Horaires> mDataset;
    private OnContactClickedListener listener;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View mTextView;

        public MyViewHolder(View v) {
            super(v);
            mTextView = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MovieAdapter(List<Horaires> myDataset, OnContactClickedListener onContactClickedListener) {
        mDataset = myDataset;
        listener = onContactClickedListener;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MovieAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        TextView titre = holder.itemView.findViewById(R.id.title);
        titre.setText(mDataset.get(position).onShow.movie.title);

        TextView genre = holder.itemView.findViewById(R.id.genre);
        genre.setText(mDataset.get(position).onShow.movie.genre.get(0).name);

        holder.itemView.setOnClickListener(v -> listener.onContactClicked(mDataset.get(position)));

    }
    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface OnContactClickedListener {
        void onContactClicked(Horaires contact);
    }

}