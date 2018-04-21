package com.udacity.gradle.builditbigger.paid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.R;
import android.support.v4.util.Pair;
import android.widget.Button;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements EndpointsAsyncTask.FragmentListener {

    private ProgressBar mLoadingProgressBar;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main_paid, container, false);

        mLoadingProgressBar = root.findViewById(R.id.loading_pb);

        Button tellJoke = root.findViewById(R.id.tell_joke_btn);
        tellJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EndpointsAsyncTask task = new EndpointsAsyncTask();
                Pair pair = new Pair(getContext(), MainActivityFragment.this);
                task.execute(pair);
                mLoadingProgressBar.setVisibility(View.VISIBLE);
            }
        });

        return root;
    }

    @Override
    public void hideProgressBar() {
        mLoadingProgressBar.setVisibility(View.GONE);
    }
}
