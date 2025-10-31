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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmployeeAdapterClass extends RecyclerView.Adapter<EmployeeAdapterClass.ViewHolder> {

    List<UserInformation> employee;
    Context context;
    DatabaseHelper databaseHelperClass;

    public EmployeeAdapterClass(List<UserInformation> employee, Context context) {
        this.employee = employee;
        this.context = context;
        databaseHelperClass = new DatabaseHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_employee_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        final UserInformation employeeModelClass = employee.get(position);

        holder.textViewID.setText(Integer.toString(employeeModelClass.getId()));
        holder.editText_Name.setText(employeeModelClass.getName());
        holder.editText_Email.setText(employeeModelClass.getEmail());
        holder.editText_username.setText(employeeModelClass.getUsername());
        holder.editText_password.setText(employeeModelClass.getPassword());
        holder.editText_role.setText(employeeModelClass.getRole());
        holder.editText_role.setEnabled(false);



        holder.button_Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringUsername = holder.editText_username.getText().toString();
                String stringPassword = holder.editText_password.getText().toString();
                String stringName = holder.editText_Name.getText().toString();
                String stringEmail = holder.editText_Email.getText().toString();

                // register all the EditText fields with their IDs.

                Register register = new Register();
                if (register.validatename(stringName) && register.validatePassword(stringPassword) && register.validateUsername(stringUsername) && register.validateEmail(stringEmail)) {
                    databaseHelperClass.updateEmployee(new UserInformation(employeeModelClass.getId(), stringName, stringEmail, stringPassword, stringUsername));
                    notifyDataSetChanged();
                    ((Activity) context).finish();
                    context.startActivity(((Activity) context).getIntent());
                }else{
                    if (!register.validateUsername(stringUsername)) {
                        holder.editText_username.setError("Please enter a valid name!");
                    }
                    if (!register.validatename(stringName)) {
                        holder.editText_Name.setError("Please enter a valid name!");
                    }
                    if (!register.validateEmail(stringEmail)) {
                        holder.editText_Email.setError("Please enter a valid email!");
                    }
                    if (!register.validatePassword(stringPassword)) {
                         holder.editText_password.setError("Please enter a valid password!");
                    }
                }
            }
        });

        holder.button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelperClass.deleteEmployee(employeeModelClass.getId());
                employee.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return employee.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewID;
        EditText editText_Name;
        EditText editText_Email;
        EditText editText_username;
        EditText editText_password;
        EditText editText_role;
        Button button_Edit;
        Button button_delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewID = itemView.findViewById(R.id.text_id);
            editText_Name = itemView.findViewById(R.id.edittext_name);
            editText_Email = itemView.findViewById(R.id.edittext_email);
            editText_username = itemView.findViewById(R.id.edittext_username);
            editText_password = itemView.findViewById(R.id.edittext_password);
            editText_role = itemView.findViewById(R.id.edittext_role);
            button_delete = itemView.findViewById(R.id.button_delete);
            button_Edit = itemView.findViewById(R.id.button_edit);


        }
    }
}