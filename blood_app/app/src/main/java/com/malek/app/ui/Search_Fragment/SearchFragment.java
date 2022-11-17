package com.malek.app.ui.Search_Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.malek.app.R;

public class SearchFragment extends Fragment  {

    private SearchViewModel searchViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        searchViewModel =
                new ViewModelProvider(this).get(SearchViewModel.class);

        View root = inflater.inflate(R.layout.home_layout_child, container, false);
        //finding components

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //binding = null;
    }

}