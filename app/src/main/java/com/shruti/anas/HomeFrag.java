package com.shruti.anas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class HomeFrag extends Fragment {

    RecyclerView vRV;
    ArrayList<String> arrSec =new ArrayList<>();
    Adapter_Sec adapter_sec;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        vRV=view.findViewById(R.id.vRV);
        vRV.setLayoutManager(new LinearLayoutManager(getActivity()));


        arrSec.add("720");
        arrSec.add("420");
        arrSec.add("810");
        arrSec.add("480");


        adapter_sec=new Adapter_Sec(arrSec);
        vRV.setAdapter(adapter_sec);




        return view;
    }
}