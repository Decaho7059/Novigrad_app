package com.bashizip.ProjectServiceNovagard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "employee.db";
    private static final String TABLE_NAME = "employee";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_ROLE = "role";
    SQLiteDatabase DataBase;
    private static final String TABLE_CREATE = "create table employee (id integer primary key not null, name text not null, email text not null, username text not null, password text not null,role text not null);";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase DataBase) {
        DataBase.execSQL(TABLE_CREATE);
        this.DataBase = DataBase;
    }

    public void insertUser(UserInformation c){
        DataBase = this.getWritableDatabase();
      //DataBase.execSQL("delete from contacts");
        ContentValues values = new ContentValues();
        String query = "select * from employee";
        Cursor cursor = DataBase.rawQuery(query,null);
        int counter= cursor.getCount();
        String sql = "select * from " + TABLE_NAME;
        values.put(COLUMN_ID,counter);
        values.put(COLUMN_NAME,c.getName());
        values.put(COLUMN_EMAIL,c.getEmail());
        values.put(COLUMN_PASSWORD,c.getPassword());
        values.put(COLUMN_USERNAME,c.getUsername());
        values.put(COLUMN_ROLE,c.getRole());
        System.out.println(cursor.move(5));

        DataBase.insert("employee",null,values);
        DataBase.close();
    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "DROP TABLE IF EXISTS employee";
        this.onCreate(DataBase);
    }

    public String searchPass(String str) {
        DataBase = this.getReadableDatabase();
        String query = "select username,password from employee";
        Cursor cursor = DataBase.rawQuery(query,null);
        String a,b;
        b = "Not Found";
        if(cursor.moveToFirst()){
            do {
                a=cursor.getString(0);

                if(a.equals(str)){
                    b = cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        return b;
    }

    public String searchRole(String str) {
        DataBase = this.getReadableDatabase();
        String query = "select username,role from employee";
        Cursor cursor = DataBase.rawQuery(query,null);
        String a,b;
        b = "Not Found";
        if(cursor.moveToFirst()){
            do {
                a=cursor.getString(0);

                if(a.equals(str)){
                    b = cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        return b;
    }


    public List<UserInformation> getEmployeeList(){
        String sql = "select * from " + TABLE_NAME;
        DataBase = this.getReadableDatabase();
        List<UserInformation> storeEmployee = new ArrayList<>();
        Cursor cursor = DataBase.rawQuery(sql,null);
        if (cursor.moveToNext()){
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                String email = cursor.getString(2);
                String password = cursor.getString(4);
                String username = cursor.getString(3);
                String role = cursor.getString(5);
                storeEmployee.add(new UserInformation(id,name,email,password,username,role));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storeEmployee;
    }


    public void updateEmployee(UserInformation employeeModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COLUMN_NAME,employeeModelClass.getName());
        contentValues.put(DatabaseHelper.COLUMN_EMAIL,employeeModelClass.getEmail());
        contentValues.put(DatabaseHelper.COLUMN_USERNAME,employeeModelClass.getUsername());
        contentValues.put(DatabaseHelper.COLUMN_PASSWORD,employeeModelClass.getPassword());
        contentValues.put(DatabaseHelper.COLUMN_ROLE,employeeModelClass.getPassword());
        DataBase = this.getWritableDatabase();
        DataBase.update(TABLE_NAME,contentValues,COLUMN_ID + " = ?" , new String[]
                {String.valueOf(employeeModelClass.getId())});
    }


    public void deleteEmployee(int id){
        DataBase = this.getWritableDatabase();
        DataBase.delete(TABLE_NAME, COLUMN_ID + " = ? ", new String[]
                {String.valueOf(id)});
    }
}


