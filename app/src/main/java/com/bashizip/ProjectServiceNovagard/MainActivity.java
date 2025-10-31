package com.bashizip.ProjectServiceNovagard;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    String role;
    private Button signIn,signUp;
    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textViewUsername);

        setContentView(R.layout.activity_main);

        signIn = (Button)findViewById(R.id.SignIn);
        signIn.setOnClickListener(view -> startShowClass());
        signUp = (Button)findViewById(R.id.SignUp);
        signUp.setOnClickListener(view -> startRegisterClass());

    }

//    @Override
//    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
//        Toast.makeText(getApplicationContext(), "Selected User: "+users[position] ,Toast.LENGTH_SHORT).show();
//        role = users[position];
//    }
//    @Override
//    public void onNothingSelected(AdapterView<?> arg0) {
//        // TODO - Custom Code
//    }

    public void startShowClass(){
        EditText a = (EditText) findViewById(R.id.username);
        String str = a.getText().toString();

        EditText b = (EditText) findViewById(R.id.password);
        String pass = b.getText().toString();
        String password = helper.searchPass(str);
        role = helper.searchRole(str);
        if(pass.equals(password)||(pass.equals("admin123")&&str.equals("admin"))){
            Intent i = new Intent(MainActivity.this,ShowAdminPage.class);
            i.putExtra("username",str);
            i.putExtra("role",role);
            switch (role) {
                case "Employee":
                    Intent intent = new Intent(MainActivity.this, BranchWelcomePage.class);
                    intent.putExtra("username",str);
                    intent.putExtra("role",role);
                    startActivity(intent);
                    break;
                case "Client":
                    Intent intentClient = new Intent(MainActivity.this, ShowClientPage.class);
                    intentClient.putExtra("username", str);
                    intentClient.putExtra("role", role);
                    startActivity(intentClient);
                    break;
                default:
                    startActivity(i);
                    break;
            }
        }else{
            Toast temp = Toast.makeText(MainActivity.this,"Username and Password don't match!",Toast.LENGTH_SHORT);
            temp.show();
        }
    }


    public void startRegisterClass() {
        Intent i = new Intent(MainActivity.this,Register.class);
        startActivity(i);
    }


}
