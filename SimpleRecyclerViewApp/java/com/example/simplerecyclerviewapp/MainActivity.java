package com.example.simplerecyclerviewapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    RecyclerView selectedView, memberView;
    SelectedAdapter selectedAdapter;
    MemberAdapter memberAdapter;
    ArrayList memberList, selectedList;
    TextView totalView, textView, textView3;
    boolean[] memberFlag;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        textView = findViewById(R.id.textView);
        textView3 = findViewById(R.id.textView3);
        totalView = findViewById(R.id.totalView);
        selectedList = new ArrayList();
        memberList = new ArrayList(Arrays.asList(getResources().getStringArray(R.array.member)));
        memberFlag = new boolean[memberList.size()];
        Arrays.fill(memberFlag, false);
        selectedView = findViewById(R.id.selectedView);
        selectedAdapter = new SelectedAdapter(this,selectedList);
        selectedView.setLayoutManager(new GridLayoutManager(this,4));
        selectedView.setAdapter(selectedAdapter);
        memberView = findViewById(R.id.memberView);
        memberAdapter = new MemberAdapter(this, memberList, selectedList);
        memberView.setLayoutManager(new LinearLayoutManager(this));
        memberView.setAdapter(memberAdapter);
//        float textSize = (10 * this.getResources().getDisplayMetrics().density);
//        textView.setTextSize(textSize);
//        textView3.setTextSize(textSize);
//        totalView.setTextSize(textSize);
    }
}
