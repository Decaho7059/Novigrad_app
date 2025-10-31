package com.bashizip.ProjectServiceNovagard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class ViewBranchActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch_account);

        recyclerView = findViewById(R.id.recyclerViewBranch);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        BranchApproved databaseHelperClass = new BranchApproved(this);
        List<BranchInformation> branchModelClasses = databaseHelperClass.getEmployeeList();

        if (branchModelClasses.size() > 0){
            BranchAdapterClass branchadapterclass = new   BranchAdapterClass(branchModelClasses, ViewBranchActivity.this);
            recyclerView.setAdapter(branchadapterclass);
        }else {
            Toast.makeText(this, "There is no request in the database", Toast.LENGTH_SHORT).show();
        }




    }
}
