package com.bashizip.ProjectServiceNovagard;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class JUnitTest {
    @Test
    public void EmailTest(){
        String email1 = "Joseph@gmail.com";
        boolean result1 = Register.validateEmail(email1);
        assertTrue(result1);

        String email2 = "Joseph";
        boolean result2 = Register.validateEmail(email2);
        assertFalse(result2);

        String email3 = "";
        boolean result3 = Register.validateEmail(email3);
        assertFalse(result3);

    }

    @Test
    public void UsernameTest(){
        String username1 = "JosephgmailcomtodayIatePinaples";
        boolean result1 = Register.validateUsername(username1);
        assertFalse(result1);

        String username2 = "";
        boolean result2 = Register.validateUsername(username2);
        assertFalse(result2);

        String username3 = "Joseph";
        boolean result3 = Register.validateUsername(username3);
        assertTrue(result3);

    }

    @Test
    public void NameTest(){
        String name1 = "Joseph.com";
        boolean result1 = Register.validatename(name1);
        assertFalse(result1);

        String name2 = "";
        boolean result2 = Register.validatename(name2);
        assertFalse(result2);

        String name3 = "Joseph";
        boolean result3 = Register.validatename(name3);
        assertTrue(result3);

    }

    @Test
    public void PasswordTest(){
        String pass1 = "Joseph12$$";
        boolean result1 = Register.validatePassword(pass1);
        assertTrue(result1);

        String pass2 = "";
        boolean result2 = Register.validatePassword(pass2);
        assertFalse(result2);

        String pass3 = "password";
        boolean result3 = Register.validatePassword(pass3);
        assertFalse(result3);

    }

    @Test
    public void BranchName(){
        String pass1 = "Joseph12$$";
        boolean result1 = RegisterBranch.validateBranchName(pass1);
        assertFalse(result1);

        String pass2 = "";
        boolean result2 = RegisterBranch.validateBranchName(pass2);
        assertFalse(result2);

        String pass3 = "BranchName";
        boolean result3 = RegisterBranch.validateBranchName(pass3);
        assertTrue(result3);

    }

    @Test
    public void BranchPhoneNumber(){
        String pass1 = "12";
        boolean result1 = RegisterBranch.validCellPhone(pass1);
        assertFalse(result1);

        String pass2 = "555";
        boolean result2 = RegisterBranch.validCellPhone(pass2);
        assertFalse(result2);

        String pass3 = "5146925170";
        boolean result3 = RegisterBranch.validCellPhone(pass3);
        assertTrue(result3);

    }

    @Test
    public void BranchAddresse(){
        String pass1 = "Joseph12$$";
        boolean result1 = RegisterBranch.validateBranchAddress(pass1);
        assertFalse(result1);

        String pass2 = "";
        boolean result2 = RegisterBranch.validateBranchAddress(pass2);
        assertFalse(result2);

        String pass3 = "253 N. Cherry St.";
        boolean result3 = RegisterBranch.validateBranchAddress(pass3);
        assertTrue(result3);
    }
}