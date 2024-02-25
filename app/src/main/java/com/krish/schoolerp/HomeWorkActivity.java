package com.krish.schoolerp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.krish.schoolerp.databinding.ActivityHomeWorkBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeWorkActivity extends DrawerBaseActivity {

    ActivityHomeWorkBinding activityHomeWorkBinding;


    private RecyclerView recyclerView;

    private List<DataModel> mList;
    private ItemAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHomeWorkBinding = ActivityHomeWorkBinding.inflate(getLayoutInflater());
        setContentView(activityHomeWorkBinding.getRoot());
        allocateActivityTitle("HomeWork");
        recyclerView = (RecyclerView) findViewById(R.id.mainRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mList = new ArrayList<>();

        List<String> nestedList1 = new ArrayList<>();
        nestedList1.add("English");
        nestedList1.add("Hindi");
        nestedList1.add("Maths");
        nestedList1.add("Science");
        nestedList1.add("Social Science");

        List<String> nestedList2 = new ArrayList<>();
        nestedList1.add("English");
        nestedList1.add("Hindi");
        nestedList1.add("Maths");
        nestedList1.add("Science");
        nestedList1.add("Social Science");

        List<String> nestedList3 = new ArrayList<>();
        nestedList1.add("English");
        nestedList1.add("Hindi");
        nestedList1.add("Maths");
        nestedList1.add("Science");
        nestedList1.add("Social Science");


        List<String> nestedList4 = new ArrayList<>();
        nestedList1.add("English");
        nestedList1.add("Hindi");
        nestedList1.add("Maths");
        nestedList1.add("Science");
        nestedList1.add("Social Science");


        List<String> nestedList5 = new ArrayList<>();
        nestedList1.add("English");
        nestedList1.add("Hindi");
        nestedList1.add("Maths");
        nestedList1.add("Science");
        nestedList1.add("Social Science");


        List<String> nestedList6 = new ArrayList<>();
        nestedList1.add("English");
        nestedList1.add("Hindi");
        nestedList1.add("Maths");
        nestedList1.add("Science");
        nestedList1.add("Social Science");






    }


}