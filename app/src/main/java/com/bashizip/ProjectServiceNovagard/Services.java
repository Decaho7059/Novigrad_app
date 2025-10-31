package com.bashizip.ProjectServiceNovagard;

import android.app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Date;

public class Services extends Activity {
    public static ArrayList<Services> noteArrayList = new ArrayList<>();
    public static String NOTE_EDIT_EXTRA =  "noteEdit";

    private int id;
    private String title;
    private String description;
    private Date deleted;

    public Services(int id, String title, String description, Date deleted)
    {
        this.id = id;
        this.title = title;
        this.description = description;
        this.deleted = deleted;
    }

    public Services(int id, String title, String description)
    {
        this.id = id;
        this.title = title;
        this.description = description;
        deleted = null;
    }

    public static Services getNoteForID(int passedNoteID)
    {
        for (Services note : noteArrayList)
        {
            if(note.getId() == passedNoteID)
                return note;
        }

        return null;
    }

    public static ArrayList<Services> nonDeletedNotes()
    {
        ArrayList<Services> nonDeleted = new ArrayList<>();
        for(Services note : noteArrayList)
        {
            if(note.getDeleted() == null)
                nonDeleted.add(note);
        }

        return nonDeleted;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public  String gettitle() {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Date getDeleted()
    {
        return deleted;
    }

    public void setDeleted(Date deleted)
    {
        this.deleted = deleted;
    }
}