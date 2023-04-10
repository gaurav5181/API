package com.example.getapi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.getapi.Model.Addres;
import com.example.getapi.Model.Company;
import com.example.getapi.Model.Modelclass;
import com.example.getapi.R;

import java.util.ArrayList;
import java.util.List;

public class Recycleadpter extends RecyclerView.Adapter<Recycleadpter.ViewHolder> {

    Context context;
    List<Modelclass> modelclassList = new ArrayList<>();
    List<Addres> addresList=new ArrayList<>();
    List<Company> companyList=new ArrayList<>();

    public Recycleadpter(Context context, List<Modelclass> modelclassList, List<Addres> addresList, List<Company> companyList) {
        this.context = context;
        this.modelclassList = modelclassList;
        this.addresList = addresList;
        this.companyList = companyList;
    }

    @NonNull
    @Override
    public Recycleadpter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.datalayot,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Recycleadpter.ViewHolder holder, int position) {

        holder.txt1.setText(String.valueOf(modelclassList.get(position).getId()));
        holder.txt2.setText(modelclassList.get(position).getName());
        holder.txt3.setText(modelclassList.get(position).getUsername());
        holder.txt4.setText(modelclassList.get(position).getEmail());
        holder.txt5.setText(modelclassList.get(position).getPhone());
        holder.txt6.setText(modelclassList.get(position).getWebsite());
        holder.txt8.setText(addresList.get(position).getStreet());
        holder.txt9.setText(addresList.get(position).getCity());
        holder.txt10.setText(addresList.get(position).getZipcode());
        holder.txt11.setText(companyList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return modelclassList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txt1,txt2,txt3,txt4,txt5,txt6,txt8,txt9,txt10,txt11;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            txt1=itemView.findViewById(R.id.id);
            txt2=itemView.findViewById(R.id.name);
            txt3=itemView.findViewById(R.id.username);
            txt4=itemView.findViewById(R.id.email);
            txt5=itemView.findViewById(R.id.phone);
            txt6=itemView.findViewById(R.id.website);
            txt8=itemView.findViewById(R.id.street);
            txt9=itemView.findViewById(R.id.city);
            txt10=itemView.findViewById(R.id.zipcode);
            txt11=itemView.findViewById(R.id.company);

        }
    }
}
