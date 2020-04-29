package com.kiarra.homeworkroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NewWordActivity extends AppCompatActivity {
    private EditText mTitleEditText;
    private EditText mContentEditText;
    private WordViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);
        mTitleEditText = findViewById(R.id.titleEditText);
        mContentEditText = findViewById(R.id.contentEditText);
        viewModel = ViewModelProviders.of(this).get(WordViewModel.class);
    }

    public void onSaveClick(View view){
        Word word = new Word(0, mTitleEditText.getText().toString(), mContentEditText.getText().toString());
        viewModel.insert(word);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onClearClick(View view){
        mTitleEditText.setText("");
        mContentEditText.setText("");
    }
}
