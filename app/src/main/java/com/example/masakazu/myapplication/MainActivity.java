package com.example.masakazu.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    //activity_main.xmlで作ったidを、ここで作ったアイテムに関連付ける
    @Bind(R.id.from_edit)
    EditText mFromEdit;  //mFromEditはfrom_editのidがついたEditTextの事ですよという意味
    @Bind(R.id.from_unit)
    Button mFromButton;
    @Bind(R.id.to_text)
    TextView mToText;
    @Bind(R.id.to_unit)
    Button mToButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.from_unit)
    void onClickFromUnitButton() {
        Intent intent = new Intent(this, CodeChooserActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.to_unit)
    void onClickToUnitButton() {
        Intent intent = new Intent(this, CodeChooserActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.button_calc)
    void onClickCalc() {
        Toast.makeText(this, "onClickCalc", Toast.LENGTH_SHORT).show();
    }
}
