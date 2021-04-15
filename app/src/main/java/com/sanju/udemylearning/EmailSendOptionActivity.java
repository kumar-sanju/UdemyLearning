package com.sanju.udemylearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EmailSendOptionActivity extends AppCompatActivity {

    Button bt_send;
    EditText et_to,et_subject,et_messaage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_send_option);

        et_to = findViewById(R.id.et_to);
        et_subject = findViewById(R.id.et_subject);
        et_messaage = findViewById(R.id.et_messaage);
        bt_send = findViewById(R.id.bt_send);

        bt_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW
                , Uri.parse("mailto:" + et_to.getText().toString()));
                intent.putExtra(Intent.EXTRA_SUBJECT, et_subject.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, et_messaage.getText().toString());
                startActivity(intent);
            }
        });


    }
}