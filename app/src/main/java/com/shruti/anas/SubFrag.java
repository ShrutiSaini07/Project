package com.shruti.anas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class SubFrag extends Fragment {

    String Sec_Name="";

    public SubFrag(String Sec_Name) {
        this.Sec_Name = Sec_Name;
    }

    RecyclerView Sub_vRV;
    ArrayList<String> arrSub;
    Adapter_Sub adapter_sub;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sub, container, false);




        Sub_vRV=view.findViewById(R.id.Sub_vRV);
        Sub_vRV.setLayoutManager(new LinearLayoutManager(getActivity()));

        arrSub=new ArrayList<>();

        arrSub.add("Science");
        arrSub.add("CS");
        arrSub.add("Maths");


        adapter_sub=new Adapter_Sub(arrSub,Sec_Name);
        Sub_vRV.setAdapter(adapter_sub);








        return view;
    }
}