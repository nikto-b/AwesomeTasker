package com.nikto_b.awesometasker.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.transition.TransitionInflater;

import com.nikto_b.awesometasker.DataModel.TaskDM;
import com.nikto_b.awesometasker.R;

public class TaskViewFragment extends Fragment {
    private TextView titleTV, leftTV;
    private TaskDM taskData;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setSharedElementEnterTransition(TransitionInflater.from(view.getContext()).inflateTransition(android.R.transition.move));
        setSharedElementReturnTransition(TransitionInflater.from(view.getContext()).inflateTransition(android.R.transition.move));
        setExitTransition(TransitionInflater.from(view.getContext()).inflateTransition(android.R.transition.move));
        setReturnTransition(TransitionInflater.from(view.getContext()).inflateTransition(android.R.transition.move));

        Bundle args = getArguments();
        titleTV = view.findViewById(R.id.title_tv);
        leftTV  = view.findViewById(R.id.time_left_tv);

        titleTV.setText(args.getString("title"));
        leftTV.setText(args.getString("left"));
    }
}
