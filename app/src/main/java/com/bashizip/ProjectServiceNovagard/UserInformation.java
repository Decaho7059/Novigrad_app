package com.bashizip.ProjectServiceNovagard;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class UserInformation extends AppCompatActivity {
    int id;
    String name, email, username,password,role;

    public UserInformation(int id, String name, String email,String password, String username,String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public UserInformation(String name, String email,String password, String username,String role) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public UserInformation(int id, String name, String email,String password, String username) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setEmail(String email){
        this.email= email;
    }

    public String getEmail(){
        return this.email;
    }

    public void setPassword(String password){
        this.password= password;
    }

    public String getPassword(){
        return this.password;
    }

    public void setUsername(String username){
        this.username= username;
    }

    public String getUsername(){
        return this.username;
    }
    public void setRole(String role){
        this.role= role;
    }
    public String getRole(){
        return this.role;
    }
}
