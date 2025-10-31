package com.bashizip.ProjectServiceNovagard;

import static com.bashizip.ProjectServiceNovagard.BranchHoursMainActivity.BH_LIST;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.bashizip.bhlib.BusinessHours;
import com.bashizip.bhlib.BusinessHoursWeekPicker;
import com.bashizip.bhlib.ValdationException;

import androidx.appcompat.app.AppCompatActivity;

import com.bashizip.bhlib.BusinessHours;

import java.util.List;


public class BranchWelcomePage extends AppCompatActivity {

    Button BranchService,BranchProfile,BranchHours,BranchRequet,Signout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        BusinessHoursWeekPicker bh_picker = findViewById(R.id.bh_picker);

        List<BusinessHours> savedList = (List<BusinessHours>) getIntent().getSerializableExtra(BH_LIST);
        if (savedList != null) {
            bh_picker.setBusinessHoursList(savedList);
        }
        setContentView(R.layout.activity_branch_welcome_page);
        String username = getIntent().getStringExtra("username");
        TextView tv = findViewById(R.id.textViewUsername);
        tv.setText(username);
        TextView welcome = findViewById(R.id.textViewConnectedUser);
        welcome.setText("You are logged in as a Employee");
        BranchService = (Button) findViewById(R.id.buttonServices);
        BranchService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BranchWelcomePage.this, MainServiceActivity.class);
                startActivity(i);
            }
        });

        BranchProfile = (Button) findViewById(R.id.buttonprofile);
        BranchProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BranchWelcomePage.this, RegisterBranch.class);
                startActivity(i);
            }
        });
        BranchHours = (Button) findViewById(R.id.buttonhour);
        BranchHours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BranchWelcomePage.this, BranchHoursMainActivity.class);
                startActivity(i);
            }
        });

        BranchRequet = (Button) findViewById(R.id.buttonRequests);
        BranchRequet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BranchWelcomePage.this, ViewBranchActivity.class);
                startActivity(i);
            }
        });
        Signout = (Button) findViewById(R.id.buttonsignOut);
        Signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BranchWelcomePage.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
    }


