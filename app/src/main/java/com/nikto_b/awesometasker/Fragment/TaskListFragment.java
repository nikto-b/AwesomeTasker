package com.nikto_b.awesometasker.Fragment;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.ActivityNavigator;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.Navigator;
import androidx.navigation.fragment.FragmentNavigator;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.transition.Explode;
import androidx.transition.Transition;
import androidx.transition.TransitionInflater;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;

import com.nikto_b.awesometasker.Adapter.TaskCardAdapter;
import com.nikto_b.awesometasker.DataModel.TaskDM;
import com.nikto_b.awesometasker.R;

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

    public void onViewCreated(@NonNull final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setSharedElementEnterTransition(TransitionInflater.from(view.getContext()).inflateTransition(android.R.transition.move));
        setSharedElementReturnTransition(TransitionInflater.from(view.getContext()).inflateTransition(android.R.transition.move));
        setExitTransition(TransitionInflater.from(view.getContext()).inflateTransition(android.R.transition.move));
        setReturnTransition(TransitionInflater.from(view.getContext()).inflateTransition(android.R.transition.move));


        final RecyclerView recyclerView = view.findViewById(R.id.recycler);
        final ArrayList<TaskDM> arrayList = new ArrayList<>();
        for(int i = 0; i < 50; i++) {
            arrayList.add(new TaskDM("title " + i, i + " days", i));
        }
        TaskCardAdapter adapter = new TaskCardAdapter(view.getContext(), arrayList);
        final StaggeredGridLayoutManager lm = new StaggeredGridLayoutManager(2, 1);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View clickedView) {
//                clickedView.setBackground(getResources().getDrawable(R.drawable.task_card_bg_warn));
                final TextView    titleTV = clickedView.findViewById(R.id.title_tv),
                                  leftTv  = clickedView.findViewById(R.id.time_left_tv);
                titleTV.setTransitionName("title");
                leftTv.setTransitionName("left");

                FragmentNavigator.Extras extras = new FragmentNavigator.Extras.Builder()
                        .addSharedElement(titleTV, titleTV.getTransitionName())
                        .addSharedElement(leftTv, leftTv.getTransitionName())
                        .build();

                Bundle args = new Bundle();
                final TaskDM data = arrayList.get(clickedView.getId());
                args.putString("title", data.getTitle());
                args.putString("left", data.getLeft());
                Navigation.findNavController(view)
                        .navigate(R.id.action_taskListFragment_to_taskViewFragment,
                                args,
                                null,
                                extras);
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(lm);
    }
}