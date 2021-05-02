package com.sanju.udemylearning.NoteApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.sanju.udemylearning.R;

import java.util.HashSet;

public class NoteEditorActivity extends AppCompatActivity {

    EditText editText;
    int noteId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editor);

        editText = findViewById(R.id.editText);

        Intent intent = getIntent();
        noteId = intent.getIntExtra("noteId", -1);

        if (noteId != -1){
            editText.setText(NoteUsingSharedPrefrenceActivity.notes.get(noteId));
        } else {
            NoteUsingSharedPrefrenceActivity.notes.add("");
            noteId = NoteUsingSharedPrefrenceActivity.notes.size() - 1;
            NoteUsingSharedPrefrenceActivity.arrayAdapter.notifyDataSetChanged();
        }

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                NoteUsingSharedPrefrenceActivity.notes.set(noteId, String.valueOf(s));
                NoteUsingSharedPrefrenceActivity.arrayAdapter.notifyDataSetChanged();

                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.sanju.udemylearning.NoteApp", Context.MODE_PRIVATE);

                HashSet<String> set = new HashSet<>(NoteUsingSharedPrefrenceActivity.notes);
                sharedPreferences.edit().putStringSet("notes", set).apply();


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}