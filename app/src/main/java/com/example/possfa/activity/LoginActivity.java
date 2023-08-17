package com.example.possfa.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.possfa.MainActivity;
import com.example.possfa.R;

public class LoginActivity extends AppCompatActivity {

    private EditText etUserName, etPassword;
    private LinearLayout btnLogin;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initUi();
    }

    private void initUi()
    {
        etUserName = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        context = this;

        populateUi();
    }

    private void populateUi()
    {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if (!(isValidEditText(etUserName) && isValidEditText(etPassword)))
                {
                    Toast.makeText(context, "Invalid input", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(context, "Login success", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, MainActivity.class);
                    startActivity(intent);
                    //login stuff

                    finish();
                }
            }
        });
    }

    private Boolean isValidEditText(EditText editText)
    {
        if (editText.getText().toString().isEmpty())
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}