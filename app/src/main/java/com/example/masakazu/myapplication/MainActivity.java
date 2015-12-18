package com.example.masakazu.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_FROM = 123;
    private static final int REQUEST_CODE_TO = 1234;
    private Code mFromCode = Code.USD;
    private Code mToCode = Code.JPY;
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

    private void getCurrency() {
        final KawaseApi kawaseApi = new RestAdapter.Builder()
                .setEndpoint("http://api.aoikujira.com/kawase")
                .build()
                .create(KawaseApi.class);
        kawaseApi.getCurrency("json", mFromCode, new Callback<HashMap<String, String>>() {
            @Override
            public void success(HashMap<String, String> map, Response response) {
                Log.d("", "");
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("", "");
            }
        });
    }


    @OnClick(R.id.from_unit)
    void onClickFromUnitButton() {
        Intent intent = new Intent(this, CodeChooserActivity.class);
        startActivityForResult(intent, REQUEST_CODE_FROM);
    }

    @OnClick(R.id.to_unit)
    void onClickToUnitButton() {
        Intent intent = new Intent(this, CodeChooserActivity.class);
        startActivityForResult(intent, REQUEST_CODE_TO);
    }

    @OnClick(R.id.button_calc)
    void onClickCalc() {
        Toast.makeText(this, "onClickCalc", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && data != null) {
            Code selectedCode = Code.valueOf(data.getStringExtra("value"));
            if (requestCode == REQUEST_CODE_FROM) {
                setFromCode(selectedCode);
            } else if (requestCode == REQUEST_CODE_TO) {
                setToCode(selectedCode);
            }

        }
    }

    private void setFromCode(Code code) {
        mFromCode = code;
        mFromButton.setText(code.getUnit());
    }

    private void setToCode(Code code) {
        mToCode = code;
        mToButton.setText(code.getUnit());
    }
}