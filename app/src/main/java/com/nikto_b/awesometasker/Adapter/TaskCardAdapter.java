package com.nikto_b.awesometasker.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nikto_b.awesometasker.DataModel.TaskDM;
import com.nikto_b.awesometasker.ViewHolder.SimpleTaskCardVH;

import java.util.ArrayList;

public class TaskCardAdapter extends RecyclerView.Adapter<SimpleTaskCardVH> {
    private ArrayList<TaskDM> dataset;
    private LayoutInflater localLayoutInflater;

    public TaskCardAdapter(@NonNull Context context, @NonNull ArrayList<TaskDM> dataset) {
        this.dataset = dataset;
        localLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public SimpleTaskCardVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = localLayoutInflater.inflate(SimpleTaskCardVH.layout_res, parent, false);
        return new SimpleTaskCardVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleTaskCardVH holder, int position) {
        holder.bind(dataset.get(position));
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
