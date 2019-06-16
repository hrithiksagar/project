package com.example.loginpage;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup extends AppCompatActivity {
    private EditText txt1,txt2,txt3,txt4;
    private Button signup;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        txt1=(EditText)findViewById(R.id.txt1);
        txt2=(EditText)findViewById(R.id.txt2);
        txt3=(EditText)findViewById(R.id.txt3);
        txt4=(EditText)findViewById(R.id.txt4);
        signup=(Button)findViewById(R.id.signup);

        firebaseAuth=FirebaseAuth.getInstance();


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()){
                    //Uploads data to the database

                   String emailid=txt1.getText().toString().trim();
                   String username=txt2.getText().toString().trim();
                   String password=txt3.getText().toString().trim();

                   firebaseAuth.createUserWithEmailAndPassword(username,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {
                           if(task.isSuccessful()) {
                               Toast.makeText(Signup.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                               startActivity(new Intent(Signup.this,MainActivity.class));
                           }
                           else{
                               Toast.makeText(Signup.this, "Registration failed", Toast.LENGTH_SHORT).show();
                           }
                       }
                   });

                }
            }
        });


    }

    private boolean validate() {
        Boolean result = false;

        String name= txt2.getText().toString();
        String password=txt3.getText().toString();
        String email=txt1.getText().toString();

        if(name.isEmpty()||email.isEmpty()||password.isEmpty()){
            Toast.makeText(Signup.this,"Please Enter all the details",Toast.LENGTH_SHORT);
        }
        else{
            result=true;
        }
        return result;
    }

}
