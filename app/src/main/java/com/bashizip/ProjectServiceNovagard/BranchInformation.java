package com.bashizip.ProjectServiceNovagard;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class BranchInformation extends AppCompatActivity {
    int id;
    String BranchName, PhoneNumber, Addresse;

    public BranchInformation(int id, String BranchName, String PhoneNumber,String Addresse) {
        this.id = id;
        this.BranchName = BranchName;
        this.PhoneNumber = PhoneNumber;
        this.Addresse = Addresse;
    }

    public BranchInformation(String BranchName, String PhoneNumber,String Addresse) {
        this.BranchName = BranchName;
        this.PhoneNumber = PhoneNumber;
        this.Addresse = Addresse;
    }
    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public void setName(String name){
        this.BranchName = BranchName;
    }

    public String getName(){
        return this.BranchName;
    }

    public void setPhoneNumber(String email){
        this.PhoneNumber= PhoneNumber;
    }

    public String getPhoneNumber(){
        return this.PhoneNumber;
    }

    public void setAddresse(String password){
        this.Addresse= Addresse;
    }

    public String getAddress(){
        return this.Addresse;
    }

}
