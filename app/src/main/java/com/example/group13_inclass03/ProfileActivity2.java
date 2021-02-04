package com.example.group13_inclass03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ProfileActivity2 extends AppCompatActivity {
    TextView finalName;
    TextView finalEmail;
    TextView finalID;
    TextView finalDepartment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);

        //Initializing layout components
        finalName = findViewById(R.id.final_name);
        finalEmail = findViewById(R.id.final_email);
        finalID = findViewById(R.id.final_id);
        finalDepartment = findViewById(R.id.final_department);

        setTitle(R.string.profile);

        //Getting data from Registration Activity
        if (getIntent() != null && getIntent().getExtras() != null && getIntent().hasExtra(MainActivity.NEW_USER_KEY))  {
            Profile profile = (Profile)getIntent().getSerializableExtra(MainActivity.NEW_USER_KEY);

            finalName.setText(profile.name);
            finalEmail.setText(profile.email);
            finalID.setText(String.valueOf(profile.id));
            finalDepartment.setText(profile.department);
        }
    }
}