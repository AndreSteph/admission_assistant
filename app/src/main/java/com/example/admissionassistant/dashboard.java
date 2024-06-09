package com.example.admissionassistant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.admissionassistant.databinding.ActivityDashboardBinding;

import java.util.ArrayList;

public class dashboard extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        RecyclerView courseRV = findViewById(R.id.idRVCourse);

        // Here, we have created new array list and added data to it
        ArrayList<University> courseModelArrayList = new ArrayList<University>();
        courseModelArrayList.add(new University("Mbarara University",R.drawable.must));
        courseModelArrayList.add(new University("Makerere University", R.drawable.muk));
        courseModelArrayList.add(new University("Gulu University", R.drawable.gulu));
        // we are initializing our adapter class and passing our arraylist to it.
        UniversityAdapter courseAdapter = new UniversityAdapter(this, courseModelArrayList);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        courseRV.setLayoutManager(linearLayoutManager);
        courseRV.setAdapter(courseAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        // Find the menu item by its ID
        MenuItem menuItem = menu.findItem(R.id.guide);

        // Set an OnClickListener on the menu item
        menuItem.getActionView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event here
                Mbarara();
            }
        });

        return true;
    }

    private void Mbarara() {
        // Implement the code to open Settings Activity here
        Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(dashboard.this, Mbarara.class);
        startActivity(intent);
    }
}