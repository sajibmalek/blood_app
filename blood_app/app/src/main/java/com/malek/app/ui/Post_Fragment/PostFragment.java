package com.malek.app.ui.Post_Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.malek.app.R;
import com.malek.app.ui.Home_Fragment.HomeViewModel;

public class PostFragment extends Fragment {

    //layout
private PostViewModel postViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        postViewModel =
                new ViewModelProvider(this).get(PostViewModel.class);


        View root = inflater.inflate(R.layout.home_fragment, container, false);
        //login pref

        return root;
    }

}