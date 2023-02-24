package com.shruti.anas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_Sub extends RecyclerView.Adapter<Adapter_Sub.Sub_ViewHolder> {

    ArrayList<String> arrSub;
    String Sec_Name="";


    public Adapter_Sub(ArrayList<String> arrSub,String Sec_Name) {
        this.arrSub = arrSub;
        this.Sec_Name = Sec_Name;
    }

    @NonNull
    @Override
    public Sub_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sub_row, parent, false);
        return new Sub_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Sub_ViewHolder holder, int position) {
        holder.txtSub.setText(arrSub.get(position));

        holder.sub_card.setOnClickListener(v -> {

            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            activity.getSupportFragmentManager().beginTransaction()
                    .replace(R.id.layFL, new StudentsFrag(Sec_Name,arrSub.get(position)))
                    .addToBackStack(null)
                    .commit();
            Toast.makeText(v.getContext(), arrSub.get(position), Toast.LENGTH_SHORT).show();
        });

    }

    @Override
    public int getItemCount() {
        return arrSub.size();
    }

    public class Sub_ViewHolder extends RecyclerView.ViewHolder {

        TextView txtSub;
        CardView sub_card;

        public Sub_ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtSub = itemView.findViewById(R.id.txtSub);
            sub_card = itemView.findViewById(R.id.sub_card);
        }
    }
}
