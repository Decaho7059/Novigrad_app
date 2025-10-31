package com.bashizip.ProjectServiceNovagard;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;


public class RegisterBranch  extends AppCompatActivity {

    private Button SaveBranch;

    BranchApproved helper = new BranchApproved(this);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch_profile);
        SaveBranch = (Button) findViewById(R.id.ButtonSaveProfile);

        SaveBranch.setOnClickListener(view -> onSignInClick());
    }


    public static boolean validCellPhone(String number) {
        if(!Pattern.matches("[a-zA-Z]+", number)) {
            return number.length() > 6 && number.length() <= 13;
        }
        return false;
    }

    // validate address
    public static boolean validateBranchAddress( String address )
    {
        return address.matches(
                "\\d{1,5}\\s\\w.\\s(\\b\\w*\\b\\s){1,2}\\w*\\." );
    } // end method validateAddress


    public static boolean validateBranchName(String nameInput) {
        if (nameInput.isEmpty()) {
            return false;
        } else if (!nameInput.matches("^[A-Za-z]+$")) {
            return false;
        } else {
            return true;
        }
    }

    public void onSignInClick() {
        EditText BranchName = (EditText) findViewById(R.id.BranchName);
        EditText BranchPhoneNumber = (EditText) findViewById(R.id.PhoneNumber);
        EditText BranchAddress = (EditText) findViewById(R.id.Addresse);

        String StringBranchName = BranchName.getText().toString();
        String StringBranchPhoneNumber = BranchPhoneNumber.getText().toString();
        String StringBranchAddress = BranchAddress.getText().toString();

        if (!validateBranchName(StringBranchName)) {
            BranchName.setError("Please enter a valid Branch Name!");
            Toast pass = Toast.makeText(RegisterBranch.this, "Please enter a valid Branch Name!", Toast.LENGTH_SHORT);
            pass.show();
        }

        if (!validCellPhone(StringBranchPhoneNumber)) {
            BranchPhoneNumber.setError("Please enter a valid Phone Number!");
            Toast pass = Toast.makeText(RegisterBranch.this, "Please enter a valid Phone Number!", Toast.LENGTH_SHORT);
            pass.show();
        }


        if (!validateBranchAddress(StringBranchAddress)) {
            BranchAddress.setError("Please enter a valid Address!");
            Toast pass = Toast.makeText(RegisterBranch.this, "Please enter a valid Address!", Toast.LENGTH_SHORT);
            pass.show();
        }

        if (validateBranchName(StringBranchName) && validCellPhone(StringBranchPhoneNumber) && validateBranchAddress(StringBranchAddress)) {
            BranchInformation branch = new BranchInformation(StringBranchName,StringBranchPhoneNumber,StringBranchAddress);
            helper.insertUser(branch);
            Toast pass01 = Toast.makeText(RegisterBranch.this, "You have successfully registered!", Toast.LENGTH_SHORT);
            pass01.show();
            Intent i = new Intent(this, BranchWelcomePage.class);
            startActivity(i);
        }
    }


}