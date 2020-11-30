package com.example.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText email;
    EditText subject;
    EditText body;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.edit_text);
        subject = findViewById(R.id.edit_text_1);
        body = findViewById(R.id.edit_text_2);
        send = findViewById(R.id.btn_send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!email.getText().toString().isEmpty() && !subject.getText().toString().isEmpty()
                && !body.getText().toString().isEmpty()) {

                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email.getText().toString()});
                    intent.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
                    intent.putExtra(Intent.EXTRA_TEXT, body.getText().toString());
                    intent.setData(Uri.parse("mailto:"));
                    if (intent.resolveActivity(getPackageManager()) !=null){
                        startActivity(intent);
                    }else {
                        Toast.makeText(MainActivity.this, "there os np application that support this action",
                                Toast.LENGTH_SHORT);
                    }

                }else {
                    Toast.makeText(MainActivity.this, "please fill all the fields",
                    Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}