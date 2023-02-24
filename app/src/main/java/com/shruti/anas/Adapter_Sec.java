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

public class Adapter_Sec extends RecyclerView.Adapter<Adapter_Sec.Sec_ViewHolder> {

    ArrayList<String> arrSec;

    public Adapter_Sec(ArrayList<String> arrSec) {
        this.arrSec = arrSec;
    }

    @NonNull
    @Override
    public Sec_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sec_row, parent, false);
        return new Sec_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Sec_ViewHolder holder, int position) {
        holder.txtSec.setText(arrSec.get(position));

        holder.sec_card.setOnClickListener(v -> {
            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            activity.getSupportFragmentManager().beginTransaction()
                    .replace(R.id.layFL, new SubFrag(arrSec.get(position)))
                    .addToBackStack(null)
                    .commit();
            Toast.makeText(v.getContext(), arrSec.get(position), Toast.LENGTH_SHORT).show();
        });

    }

    @Override
    public int getItemCount() {
        return arrSec.size();
    }

    public class Sec_ViewHolder extends RecyclerView.ViewHolder {
        TextView txtSec;
        CardView sec_card;

        public Sec_ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtSec = itemView.findViewById(R.id.txtSec);
            sec_card = itemView.findViewById(R.id.sec_card);
        }
    }
}
