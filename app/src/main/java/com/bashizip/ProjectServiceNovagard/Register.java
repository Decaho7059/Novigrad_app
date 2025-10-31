package com.bashizip.ProjectServiceNovagard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class Register  extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Button signUp;
    String role;
    String[] users = { "Client", "Employee"};

    DatabaseHelper helper = new DatabaseHelper(this);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        setContentView(R.layout.activity_signup);
        Spinner spin = (Spinner) findViewById(R.id.spinnerSignup);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, users);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(this);
        signUp = (Button) findViewById(R.id.ButtonRegister);
        signUp.setOnClickListener(view -> onSignUpClick());
    }

    public static final Pattern EMAIL_ADDRESS = Pattern.compile(

            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$");


    public static boolean validateEmail(String email) {
        if (email.isEmpty()) {
            return false;
        } else if (!EMAIL_ADDRESS.matcher(email).matches()) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean validatePassword(String passwordInput) {
        if (passwordInput.isEmpty()) {
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean validateUsername(String usernameInput) {
        if (usernameInput.isEmpty()) {
            return false;
        } else if (usernameInput.length() > 15) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean validatename(String nameInput) {
        if (nameInput.isEmpty()) {
            return false;
        } else if (!nameInput.matches("^[A-Za-z]+$")) {
            return false;
        } else {
            return true;
        }
    }


    public void onSignUpClick() {
        EditText email = (EditText) findViewById(R.id.editTextEmail);
        EditText name = (EditText) findViewById(R.id.editTextTextName);
        EditText username = (EditText) findViewById(R.id.Username);
        EditText password = (EditText) findViewById(R.id.EditTextPassword);
        EditText confirmPassword = (EditText) findViewById(R.id.editTextConfrmPassword);

        String stringName = name.getText().toString();
        String stringEmail = email.getText().toString();
        String stringPassword = password.getText().toString();
        String stringConfirmPassword = confirmPassword.getText().toString();
        String stringUsername = username.getText().toString();
        if (!stringPassword.equals(stringConfirmPassword)) {
            Toast pass = Toast.makeText(Register.this, "Password don't match!", Toast.LENGTH_SHORT);
            pass.show();
        }

        if (!validateUsername(stringUsername)) {
            username.setError("Please enter a valid username!");
            Toast pass1 = Toast.makeText(Register.this, "Please enter a valid username!", Toast.LENGTH_SHORT);
            pass1.show();
        }
        if (!validatename(stringName)) {
            name.setError("Please enter a valid name!");
            Toast pass2 = Toast.makeText(Register.this, "Please enter a valid name!", Toast.LENGTH_SHORT);
            pass2.show();
        }
        if (!validateEmail(stringEmail)) {
            email.setError("Please enter a valid email!");
            Toast pass3 = Toast.makeText(Register.this, "Please enter a valid email!", Toast.LENGTH_SHORT);
            pass3.show();
        }

        if (!validatePassword(stringPassword)) {
            password.setError("Please enter a valid password!");
            Toast pass4 = Toast.makeText(Register.this, "Please enter a valid password!", Toast.LENGTH_SHORT);
            pass4.show();
        }

        if (validatename(stringName) && validatePassword(stringPassword) && validateUsername(stringUsername) && validateEmail(stringEmail)&&stringPassword.equals(stringConfirmPassword)&&role!="") {
            UserInformation user = new UserInformation(stringName,stringEmail,stringPassword,stringUsername,role);
            helper.insertUser(user);
            Toast pass01 = Toast.makeText(Register.this, "You have successfully registered!", Toast.LENGTH_SHORT);
            pass01.show();
            Intent i = new Intent(this, MainActivity.class);
            i.putExtra("role",role);
            startActivity(i);
        }

    }


    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
        Toast.makeText(getApplicationContext(), "Selected User: "+users[position] ,Toast.LENGTH_SHORT).show();
        role = users[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}