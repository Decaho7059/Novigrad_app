package com.bashizip.ProjectServiceNovagard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class ServiceDetailActivity extends AppCompatActivity {
    private EditText titleEditText, descEditText;
    private Button deleteButton;
    private Button saveButton;
    private Services selectedNote;
    private String role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_detail);
        role = getIntent().getStringExtra("roleUser");
        initWidgets();
        checkForEditNote();

    }

    private boolean validateTitle(EditText title) {
        String usernameInput = title.getEditableText().toString().trim();

        if (usernameInput.isEmpty()) {
            title.setError("Field can't be empty");
            Toast pass = Toast.makeText(ServiceDetailActivity.this, "Title can't be empty!", Toast.LENGTH_SHORT);
            pass.show();
            return false;
        } else if (usernameInput.length() > 30) {
            title.setError("Title is too long");
            Toast pass = Toast.makeText(ServiceDetailActivity.this, "Title is too long!", Toast.LENGTH_SHORT);
            pass.show();
            return false;
        } else {
            title.setError(null);
            return true;
        }
    }

    private boolean validateDescription(EditText description) {
        String usernameInput = description.getEditableText().toString().trim();

        if (usernameInput.isEmpty()) {
            description.setError("Field can't be empty");
            Toast pass = Toast.makeText(ServiceDetailActivity.this, "Description can't be empty!", Toast.LENGTH_SHORT);
            pass.show();
            return false;
        } else if (usernameInput.length() < 15) {
            description.setError("Description is too short");
            Toast pass = Toast.makeText(ServiceDetailActivity.this, "Description is too short!", Toast.LENGTH_SHORT);
            pass.show();
            return false;
        } else {
            description.setError(null);
            return true;
        }
    }

    private void initWidgets()
    {

        titleEditText = findViewById(R.id.titleEditText);
        descEditText = findViewById(R.id.descriptionEditText);
        deleteButton = findViewById(R.id.deleteNoteButton);
        saveButton = findViewById(R.id.buttonSave);
//        homeButton = findViewById(R.id.backArrow);
    }

    private void checkForEditNote()
    {
        Intent previousIntent = getIntent();

        int passedNoteID = previousIntent.getIntExtra(Services.NOTE_EDIT_EXTRA, -1);
        selectedNote = Services.getNoteForID(passedNoteID);
            if (selectedNote != null) {
                titleEditText.setText(selectedNote.gettitle());
                descEditText.setText(selectedNote.getDescription());
            } else {
                deleteButton.setVisibility(View.INVISIBLE);
            }
    }

    public void saveNote(View view) {
        SQLiteManager sqLiteManager = SQLiteManager.instanceOfDatabase(this);
        String title = String.valueOf(titleEditText.getText());
        String desc = String.valueOf(descEditText.getText());

        if (validateTitle(titleEditText) && validateDescription(descEditText)) {
            if (selectedNote == null) {
                int id = Services.noteArrayList.size();
                Services newNote = new Services(id, title, desc);
                Services.noteArrayList.add(newNote);
                sqLiteManager.addNoteToDatabase(newNote);
            } else {
                selectedNote.setTitle(title);
                selectedNote.setDescription(desc);
                sqLiteManager.updateNoteInDB(selectedNote);
            }
            finish();
        } else {
            if (!validateTitle(titleEditText)) {
                titleEditText.setError("Please enter a valid Title");
            }
            if (!validateDescription(descEditText)) {
                descEditText.setError("Please enter a valid Description");
            }

        }
    }

    public void deleteNote(View view)
    {
            selectedNote.setDeleted(new Date());
            SQLiteManager sqLiteManager = SQLiteManager.instanceOfDatabase(this);
            sqLiteManager.updateNoteInDB(selectedNote);
            finish();
    }

//    public void returnMainServicePage(View view){
//        Intent i = new Intent(ServiceDetailActivity.this, ShowAdminPage.class);
//        startActivity(i);
//    }

}