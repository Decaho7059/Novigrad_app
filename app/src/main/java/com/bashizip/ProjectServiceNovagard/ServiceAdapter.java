package com.bashizip.ProjectServiceNovagard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ServiceAdapter extends ArrayAdapter<Services>
{
    public ServiceAdapter(Context context, ArrayList<Services> notes)
    {
        super(context, 0, notes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
         Services note = getItem(position);
        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.service_cell, parent, false);

        TextView title = convertView.findViewById(R.id.cellTitle);
        TextView desc = convertView.findViewById(R.id.cellDesc);

        title.setText(note.gettitle());
        desc.setText(note.getDescription());

        return convertView;
    }
}