package com.nikto_b.awesometasker.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nikto_b.awesometasker.Adapter.TaskCardAdapter;
import com.nikto_b.awesometasker.DataModel.TaskDM;
import com.nikto_b.awesometasker.R;
import com.nikto_b.awesometasker.ViewHolder.SimpleTaskCardVH;

import java.util.ArrayList;

public class TaskListFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task_list, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        ArrayList<TaskDM> arrayList = new ArrayList<>();
        for(int i = 0; i < 50; i++) {
            arrayList.add(new TaskDM("title " + i, i + " days"));
        }
        TaskCardAdapter adapter = new TaskCardAdapter(view.getContext(), arrayList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
    }
}