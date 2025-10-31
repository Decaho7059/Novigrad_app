package com.bashizip.ProjectServiceNovagard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowAdminPage extends AppCompatActivity {
    private Button Service,signOut,Accounts;
    private String roleUser;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_welcome_page);
        String username = getIntent().getStringExtra("username");
        String role = getIntent().getStringExtra("role");

        TextView tv = findViewById(R.id.textViewUsername);
        tv.setText(username);
        getRole(username,role);

        signOut = (Button) findViewById(R.id.buttonsignOut);
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ShowAdminPage.this, MainActivity.class);
                startActivity(i);
            }
        });
        Service = (Button) findViewById(R.id.buttonServices);
        Service.setOnClickListener(view -> startNoteClass());
    }

    public void getRole(String username, String user){
        Accounts = (Button) findViewById(R.id.buttonAccount);
//        Accounts.setVisibility(View.INVISIBLE);
//        Accounts.setEnabled(false);
        TextView welcome = findViewById(R.id.textViewConnectedUser);
        String string = "as an "+user;
        if(username.equals("admin")){
            welcome.setText("as an Administrator");
            roleUser = "admin";
            Accounts.setVisibility(View.VISIBLE);
            Accounts.setEnabled(true);
            Accounts.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(ShowAdminPage.this, ViewEmployeeActivity.class);
                    startActivity(i);
                }
            });
        }else if(user.equals("Administrator")){
            welcome.setText("as a client");
            roleUser = "client";
        }else{
            welcome.setText(string);
            roleUser = "client";
        }
    }

    public void startNoteClass() {
        Intent i = new Intent(ShowAdminPage.this, MainServiceActivity.class);
        i.putExtra("roleUser",roleUser);
        startActivity(i);
    }

}
