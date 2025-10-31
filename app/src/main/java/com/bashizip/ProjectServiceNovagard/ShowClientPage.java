package com.bashizip.ProjectServiceNovagard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowClientPage extends AppCompatActivity {
    private Button requestService,signOut;
    private String roleUser;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_welcome);
        String username = getIntent().getStringExtra("username");
        String role = getIntent().getStringExtra("role");

        TextView tv = findViewById(R.id.textViewUsername);
        tv.setText(username);
        TextView welcome = findViewById(R.id.textViewConnectedUser);
        welcome.setText("as a Client");
        roleUser = "client";

        signOut = (Button) findViewById(R.id.buttonsignOut);
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ShowClientPage.this, MainActivity.class);
                startActivity(i);
            }
        });
//        Service = (Button) findViewById(R.id.buttonServices);
//        Service.setOnClickListener(view -> startNoteClass());
    }

//    public void getRole(String username, String user){
////        Accounts = (Button) findViewById(R.id.buttonAccount);
////        Accounts.setVisibility(View.INVISIBLE);
////        Accounts.setEnabled(false);
//        TextView welcome = findViewById(R.id.textViewConnectedUser);
//        welcome.setText("as a Client");
//        roleUser = "client";
//    }

//    public void startNoteClass() {
//        Intent i = new Intent(ShowAdminPage.this, MainServiceActivity.class);
//        i.putExtra("roleUser",roleUser);
//        startActivity(i);
//    }

}
