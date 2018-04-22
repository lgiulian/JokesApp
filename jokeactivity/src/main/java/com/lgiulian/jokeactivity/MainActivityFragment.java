package com.lgiulian.jokeactivity;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private String mJoke;

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mJoke = getArguments().getString(MainActivity.JOKE_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_joke, container, false);

        Bundle extras = getActivity().getIntent().getExtras();
        String joke = null;
        if (extras != null && extras.containsKey(MainActivity.JOKE_KEY)) {
            joke = extras.getString(MainActivity.JOKE_KEY, "");
        }

        TextView jokeTv = rootView.findViewById(R.id.joke_tv);
        jokeTv.setText(joke);

        return rootView;
    }

    public static MainActivityFragment newInstance(String joke) {
        MainActivityFragment fragment = new MainActivityFragment();
        Bundle args = new Bundle();
        args.putString(MainActivity.JOKE_KEY, joke);
        fragment.setArguments(args);
        return fragment;
    }
}
