package com.example.vogan.tp1;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.ButterKnife;
import android.content.Intent;
public class ActivitySecondaire extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitysecondaire);
        TextView text = findViewById(R.id.text);
        Intent i = getIntent();
        text.setText(i.getStringExtra("Text"));
        TextView tv = findViewById(R.id.place2);
        tv.setText(i.getStringExtra("Place"));

    }
}
