package com.bashizip.ProjectServiceNovagard;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BranchAdapterClass extends RecyclerView.Adapter<BranchAdapterClass.ViewHolder> {

    List<BranchInformation> branch;
    Context context;
    BranchDatabase databaseHelperClass;

    public BranchAdapterClass(List<BranchInformation> branch, Context context) {
        this.branch = branch;
        this.context = context;
        databaseHelperClass = new BranchDatabase(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_branch_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        final BranchInformation branchModelClass = branch.get(position);

        holder.textViewID.setText(Integer.toString(branchModelClass.getId()));
        holder.editText_Name.setText(branchModelClass.getName());
//        holder.editText_Email.setText(employeeModelClass.getEmail());
//        holder.editText_username.setText(employeeModelClass.getUsername());
//        holder.editText_password.setText(employeeModelClass.getPassword());

        holder.button_Approved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.textViewID.setVisibility(View.INVISIBLE);
                holder.editText_Name.setVisibility(View.INVISIBLE);
                holder.editText_NameText.setVisibility(View.INVISIBLE);
            }
        });

        holder.button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelperClass.deleteEmployee(branchModelClass.getId());
                branch.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return branch.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewID;
        EditText editText_Name;
        EditText editText_NameText;
//        EditText editText_Email;
//        EditText editText_username;
//        EditText editText_password;
        Button button_Approved;
        Button button_delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewID = itemView.findViewById(R.id.text_idbranch);
            editText_Name = itemView.findViewById(R.id.edittext_nameBranch);
            editText_Name.setEnabled(false);
            editText_NameText = itemView.findViewById(R.id.editTextTextPersonName);
            editText_NameText.setEnabled(false);
            button_delete = itemView.findViewById(R.id.button_delete);
            button_Approved = itemView.findViewById(R.id.button_approve);

        }
    }
}