/**
 * Assignment #: HW01
 * File name: group#13_inclass03
 * Student: Carlos Del Carpio
 */
package com.example.group13_inclass03;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nameEntered;
    EditText emailEntered;
    EditText idEntered;
    TextView departmentEntered;
    Button submitButton;
    Button selectDepartmentButton;
    final static public String NEW_USER_KEY = "NEW_USER";
    final static public int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing layout components
        nameEntered = findViewById(R.id.entered_name);
        emailEntered = findViewById(R.id.entered_email_address);
        idEntered = findViewById(R.id.entered_id);
        submitButton = findViewById(R.id.submit_button);
        selectDepartmentButton = findViewById(R.id.select_department_button);
        departmentEntered = findViewById(R.id.department_ouput);

        setTitle(R.string.registration);

        //On click listener to call the Profile Activity. It checks to make sure all data is adequately added.
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nameEntered.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, R.string.no_name, Toast.LENGTH_SHORT).show();
                } else if (emailEntered.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, R.string.no_email, Toast.LENGTH_SHORT).show();
                } else if (idEntered.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, R.string.no_id, Toast.LENGTH_SHORT).show();
                } else if (departmentEntered.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, R.string.no_department, Toast.LENGTH_SHORT).show();
                } else {
                    Intent goToProfile = new Intent(MainActivity.this, ProfileActivity2.class);
                    Profile user = new Profile(nameEntered.getText().toString(), emailEntered.getText().toString(), Integer.parseInt(idEntered.getText().toString()), departmentEntered.getText().toString());
                    goToProfile.putExtra(MainActivity.NEW_USER_KEY, user);
                    startActivity(goToProfile);
                }
            }
        });

        //On click listener to go to Department Activity.
        selectDepartmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToDepartment = new Intent(MainActivity.this, Department.class);
                startActivityForResult(goToDepartment, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (data != null && data.hasExtra(Department.DEPARTMENT_NAME_KEY)) {
                departmentEntered.setText(data.getStringExtra(Department.DEPARTMENT_NAME_KEY));
            }
        }
    }
}