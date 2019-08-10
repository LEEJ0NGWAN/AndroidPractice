package com.example.simplerecyclerviewapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SelectedAdapter extends RecyclerView.Adapter<SelectedAdapter.ViewHolder> {
    MainActivity mainActivity;
    ArrayList selectedList;
    float textSize;
    @NonNull
    @Override
    public SelectedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater
                = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        SelectedAdapter.ViewHolder viewHolder
                = new SelectedAdapter.ViewHolder(inflater.inflate(R.layout.selected_view_layout, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SelectedAdapter.ViewHolder holder, int position) {
        try {
            holder.textView.setText((String)selectedList.get(position));
//            holder.textView.setTextSize(textSize);
        } catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return selectedList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.selectedTextView);
//            textView.setTextSize(textSize);
        }
    }

    public SelectedAdapter(MainActivity mainActivity, ArrayList list) {
        this.mainActivity = mainActivity;
        selectedList = list;
        textSize = (10 * this.mainActivity.getResources().getDisplayMetrics().density);
    }

    public void memberJoin(String name){
        selectedList.add(name);
        int insertIndex = selectedList.size()-1;
        notifyItemInserted(insertIndex);
    }

    public void memberDismiss(int removeIndex) {
        selectedList.remove(removeIndex);
        notifyItemRemoved(removeIndex);
    }
}
