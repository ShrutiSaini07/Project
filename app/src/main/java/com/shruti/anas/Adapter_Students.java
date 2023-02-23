package com.shruti.anas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_Students extends RecyclerView.Adapter<Adapter_Students.Students_ViewHolder> {

    ArrayList<Model_Students> arrStudents;

    ArrayList<Model_Students> arrPresent=new ArrayList<>();
    ArrayList<Model_Students> arrAbsent=new ArrayList<>();

    public Adapter_Students(ArrayList<Model_Students> arrStudents) {
        this.arrStudents = arrStudents;
    }

    @NonNull
    @Override
    public Students_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.students_row,parent,false);
        return new Students_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Students_ViewHolder holder, int position) {
        holder.txtName.setText(arrStudents.get(position).getName());
        holder.txtUid.setText(arrStudents.get(position).getUid());

        arrAbsent.add(arrStudents.get(position));
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {

                CheckBox checkBox = (CheckBox) v;

                if (checkBox.isChecked()){
                    arrPresent.add(arrStudents.get(pos));
                    arrAbsent.remove(arrStudents.get(pos));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrStudents.size();
    }

    public class Students_ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView txtName,txtUid;
        CheckBox checkBox;
        ItemClickListener itemClickListener;

        public Students_ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName=itemView.findViewById(R.id.txtName);
            txtUid=itemView.findViewById(R.id.txtUid);
            checkBox=itemView.findViewById(R.id.checkBox);

            checkBox.setOnClickListener(this);
        }

        public void setItemClickListener(ItemClickListener ic){
            this.itemClickListener=ic;
        }
        @Override
        public void onClick (View v){
            this.itemClickListener.onItemClick(v,getLayoutPosition());
        }
    }
}
