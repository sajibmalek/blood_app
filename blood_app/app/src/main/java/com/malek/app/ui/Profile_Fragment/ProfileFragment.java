package com.malek.app.ui.Profile_Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.malek.app.R;


public class ProfileFragment extends Fragment  {

    private ProfileViewModel ProfileViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ProfileViewModel =
                new ViewModelProvider(this).get(ProfileViewModel.class);

        View root = inflater.inflate(R.layout.home_fragment, container, false);


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //binding = null;
    }

    @Override
    public void onResume() {
        super.onResume();


    }
}