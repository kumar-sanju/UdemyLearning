package com.sanju.udemylearning.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sanju.udemylearning.R;

public class GridRecyclerAdapter extends RecyclerView.Adapter<GridRecyclerAdapter.ViewHolder> {

    Context context;
    String[] programeNameList;
    String[] programeDescriptionList;
    int[] images;

    public GridRecyclerAdapter(Context context, String[] programeNameList, String[] programeDescriptionList, int[] images) {
        this.context = context;
        this.programeNameList = programeNameList;
        this.programeDescriptionList = programeDescriptionList;
        this.images = images;
    }

    @NonNull
    @Override
    public GridRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.grid_recyclerview_items, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.rowName.setText(programeNameList[position]);
        holder.rowDescription.setText(programeDescriptionList[position]);
        holder.rowImages.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return programeNameList.length;
    }

    // member variable
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView rowName;
        TextView rowDescription;
        ImageView rowImages;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rowName = itemView.findViewById(R.id.textView1);
            rowDescription = itemView.findViewById(R.id.textView2);
            rowImages = itemView.findViewById(R.id.imageView);
        }
    }

}