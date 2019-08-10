package com.example.simplerecyclerviewapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.ViewHolder> {
    MainActivity mainActivity;
    ArrayList memberList, selectedList;
    float textSize;
    @NonNull
    @Override
    public MemberAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater
            = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        MemberAdapter.ViewHolder viewHolder
            = new MemberAdapter.ViewHolder(inflater.inflate(R.layout.member_view_layout, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText((String) memberList.get(position));
        int color = (mainActivity.memberFlag[position]) ? 0xFF00BCD4 : 0xFFFFFFFF;
        holder.textView.setBackgroundColor(color);
//        holder.textView.setTextSize(textSize);
    }

    @Override
    public int getItemCount() {
        return memberList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.memberTextView);
//            textView.setTextSize(textSize);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int index = getAdapterPosition();
                    if(!mainActivity.memberFlag[index]){
                        String name = memberList.get(index).toString();
                        if(selectedList.size()<8){
                            mainActivity.selectedAdapter.memberJoin(name);
                            mainActivity.memberFlag[index] = true;
                        }
                        else
                            Toast.makeText(mainActivity.getApplicationContext(), "풀 파티군요!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        int removeIndex = selectedList.indexOf(memberList.get(index));
                        mainActivity.selectedAdapter.memberDismiss(removeIndex);
                        mainActivity.memberFlag[index] = false;
                    }
                    int color = (mainActivity.memberFlag[index]) ? 0xFF00BCD4 : 0xFFFFFFFF;
                    textView.setBackgroundColor(color);
                    mainActivity.totalView.setText(selectedList.size()+"/8");
                }
            });
        }
    }
    public MemberAdapter(MainActivity mainActivity, ArrayList list, ArrayList list2) {
        this.mainActivity = mainActivity;
        memberList = list;
        selectedList = list2;
        textSize = (10 * this.mainActivity.getResources().getDisplayMetrics().density);
    }
}
