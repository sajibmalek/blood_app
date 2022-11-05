package com.malek.app.ui.OrderHistory;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.malek.app.R;


public class OrderHistoryFragment extends Fragment  {

    private OrderHistoryViewModel orderHistoryViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        orderHistoryViewModel =
                new ViewModelProvider(this).get(OrderHistoryViewModel.class);

        View root = inflater.inflate(R.layout.fragment_order_history, container, false);


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