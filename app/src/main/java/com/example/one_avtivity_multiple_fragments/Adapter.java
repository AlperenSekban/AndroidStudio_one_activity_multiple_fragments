package com.example.one_avtivity_multiple_fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.tanimla> {

    Context context;
    List<KisiModel> list;

    public Adapter(Context context, List<KisiModel> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public tanimla onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout, parent, false);
        return new tanimla(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final tanimla holder, final int position) {

        holder.gender.setImageResource(list.get(position).getGender());
        holder.person.setText(list.get(position).getPerson());
        holder.workingStatus.setImageResource(list.get(position).getWorkingstatus());
        holder.workingStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.workingStatus.getDrawable().getConstantState().equals(view.getResources().getDrawable(R.drawable.ic_action_calisiyor).getConstantState())){
                    holder.workingStatus.setImageResource(R.drawable.ic_action_calismiyor);
                    list.get(position).setWorkingstatus(R.drawable.ic_action_calismiyor);
                }
                else if(holder.workingStatus.getDrawable().getConstantState().equals(view.getResources().getDrawable(R.drawable.ic_action_calismiyor).getConstantState())) {
                    holder.workingStatus.setImageResource(R.drawable.ic_action_calisiyor);
                    list.get(position).setWorkingstatus(R.drawable.ic_action_calisiyor);
                }
                }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Person.fullName =list.get(position).getPerson();
                Person.gender=list.get(position).getGender();
                Person.workingStatus =list.get(position).getWorkingstatus();
                Person.position=position;
                ((FragmentActivity)context).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.activity_main_frameLayout,new DeleteFragment(),"deletefragment")
                        .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .addToBackStack("personListFragment")
                        .commit();
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

    public class tanimla extends RecyclerView.ViewHolder {
        final ImageView gender;
        final TextView person;
        final ImageView workingStatus;


        public tanimla(@NonNull View itemView) {
            super(itemView);
            gender = itemView.findViewById(R.id.listView_person_gender_imageView);
            person = itemView.findViewById(R.id.listView_person_information_textView);
            workingStatus = itemView.findViewById(R.id.listView_person_workingStatus_imageView);
        }
    }
}
