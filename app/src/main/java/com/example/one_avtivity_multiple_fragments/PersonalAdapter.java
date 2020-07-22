package com.example.one_avtivity_multiple_fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PersonalAdapter extends RecyclerView.Adapter<PersonalAdapter.Defination> {

    Context context;
    List<KisiModel> list;
    AdapterOnClick adapterOnClick;

    public PersonalAdapter(Context context, List<KisiModel> list, AdapterOnClick adapterOnClick) {
        this.context = context;
        this.list = list;
        this.adapterOnClick = adapterOnClick;
    }


    @NonNull
    @Override
    public Defination onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout, parent, false);
        return new Defination(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Defination holder, final int position) {

        holder.gender.setImageResource(list.get(position).getGender());
        holder.person.setText(list.get(position).getPerson());
        holder.workingStatus.setImageResource(list.get(position).getWorkingstatus());
        holder.workingStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.workingStatus.getDrawable().getConstantState().equals(view.getResources().getDrawable(R.drawable.ic_action_working).getConstantState())){
                    holder.workingStatus.setImageResource(R.drawable.ic_action_notworking);
                    list.get(position).setWorkingstatus(R.drawable.ic_action_notworking);
                }
                else if(holder.workingStatus.getDrawable().getConstantState().equals(view.getResources().getDrawable(R.drawable.ic_action_notworking).getConstantState())) {
                    holder.workingStatus.setImageResource(R.drawable.ic_action_working);
                    list.get(position).setWorkingstatus(R.drawable.ic_action_working);
                }
                }
        });



    }
    public void deletePerson(final int position){
        list.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,list.size());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Defination extends RecyclerView.ViewHolder {
        final ImageView gender;
        final TextView person;
        final ImageView workingStatus;


        public Defination(@NonNull View itemView) {
            super(itemView);
            gender = itemView.findViewById(R.id.listView_person_gender_imageView);
            person = itemView.findViewById(R.id.listView_person_information_textView);
            workingStatus = itemView.findViewById(R.id.listView_person_workingStatus_imageView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    adapterOnClick.onClick(getAdapterPosition());
                }
            });
        }

    }
}
