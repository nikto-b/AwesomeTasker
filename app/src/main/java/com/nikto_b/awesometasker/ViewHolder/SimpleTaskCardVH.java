package com.nikto_b.awesometasker.ViewHolder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.nikto_b.awesometasker.DataModel.TaskDM;
import com.nikto_b.awesometasker.R;
import com.transitionseverywhere.Explode;
import com.transitionseverywhere.TransitionManager;

public class SimpleTaskCardVH extends RecyclerView.ViewHolder {
    public static final int layout_res = R.layout.layout_task;
    TextView titleTV, leftTV;
    private View itemView;
    private int id;

    public int getId() {
        return id;
    }

    public SimpleTaskCardVH(@NonNull View itemView) {
        super(itemView);
        this.itemView = itemView;
        titleTV = itemView.findViewById(R.id.title_tv);
        leftTV  = itemView.findViewById(R.id.time_left_tv);
        itemView.setVisibility(View.INVISIBLE);
    }

    public SimpleTaskCardVH(@NonNull View itemView, @Nullable View.OnClickListener clickListener) {
        this(itemView);
        itemView.setOnClickListener(clickListener);
    }

    public void bind(@NonNull TaskDM data, int id) {
        titleTV.setText(data.getTitle());
        leftTV.setText(data.getLeft());
        TransitionManager.beginDelayedTransition((ViewGroup)itemView.getRootView());
        itemView.setVisibility(View.VISIBLE);
        itemView.setTag(data);
        this.id = id;
        itemView.setId(id);
    }
}
