package com.bashizip.ProjectServiceNovagard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;



public class MainServiceActivity extends AppCompatActivity
{
    private ListView noteListView;
    private String role ;
    private Button AddService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_activity_main);
        role = getIntent().getStringExtra("roleUser");
        Button backArrow =  (Button) findViewById(R.id.backArrowHome);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToAdminPage();
            }
        });
        initWidgets();
        loadFromDBToMemory();
        setNoteAdapter();
        setOnClickListener();
    }


    private void initWidgets()
    {
        noteListView = findViewById(R.id.noteListView);
    }

    private void loadFromDBToMemory()
    {
       SQLiteManager sqLiteManager = SQLiteManager.instanceOfDatabase(this);
        sqLiteManager.populateNoteListArray();
    }

    private void setNoteAdapter()
    {
        ServiceAdapter serviceAdapter = new ServiceAdapter(getApplicationContext(), Services.nonDeletedNotes());
        noteListView.setAdapter(serviceAdapter);
    }


    private void setOnClickListener()
    {
        noteListView.setOnItemClickListener((adapterView, view, position, l) -> {
            Services selectedNote = (Services) noteListView.getItemAtPosition(position);
            Intent editNoteIntent = new Intent(getApplicationContext(), ServiceDetailActivity.class);
            editNoteIntent.putExtra("roleUser",role);
            editNoteIntent.putExtra(Services.NOTE_EDIT_EXTRA, selectedNote.getId());
            startActivity(editNoteIntent);
        });
    }


    @Override
    protected void onResume()
    {
        super.onResume();
        setNoteAdapter();
    }

    public void backToAdminPage() {
        Intent i = new Intent(this, ShowAdminPage.class);
        startActivity(i);
    }


    public void addService(View view) {
        Intent i = new Intent(this, ServiceDetailActivity.class);
        startActivity(i);
    }

}