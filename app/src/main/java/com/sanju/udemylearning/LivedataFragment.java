package com.sanju.udemylearning;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class LivedataFragment extends Fragment {

    TextView tvResult;
    ModelViewModel modelViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_livedata, container, false);

        tvResult = view.findViewById(R.id.tv_result);

        if (getActivity() != null){
            modelViewModel = ViewModelProviders.of(getActivity())
                    .get(ModelViewModel.class);

            modelViewModel.getText().observe(getActivity(), new Observer<String>() {
                @Override
                public void onChanged(String s) {
                    tvResult.setText(s);
                }
            });
        }
        return view;
    }
}