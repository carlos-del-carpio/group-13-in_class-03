package com.example.group13_inclass03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Department extends AppCompatActivity {
    Button cancelButton;
    Button selectButton;
    RadioGroup departmentRadioGroup;
    final static public String DEPARTMENT_NAME_KEY = "DEPARTMENT_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);

        //Initializing layout components
        cancelButton = findViewById(R.id.dept_cancel_button);
        selectButton = findViewById(R.id.dept_select_button);
        departmentRadioGroup = findViewById(R.id.department_radio_button);
        setTitle(R.string.department);

        //On click listener to go back to Registration Activity
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        //On click listener to pass back selection to Registration Activity
        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToMainActivity = new Intent(Department.this, MainActivity.class);

                if (departmentRadioGroup.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(Department.this, R.string.select_department, Toast.LENGTH_SHORT).show();
                } else {
                    int selectedRadioButtonID = departmentRadioGroup.getCheckedRadioButtonId();
                    RadioButton selecteRadioButton = (RadioButton) findViewById(selectedRadioButtonID);


                    goToMainActivity.putExtra(DEPARTMENT_NAME_KEY, selecteRadioButton.getText());
                    setResult(RESULT_OK, goToMainActivity);
                    finish();
                }
            }
        });
    }
}