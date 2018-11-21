package com.example.vogan.tp1;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.opengl.Visibility;
import android.os.Bundle;
import android.os.Parcel;
import android.service.autofill.FillEventHistory;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.validey)
    Button validey;
    @BindView(R.id.day)
    EditText day;
    @BindView(R.id.month)
    EditText month;
    @BindView(R.id.year)
    EditText year;
    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.secondname)
    EditText pnom;
    @BindView(R.id.place)
    EditText place;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    public void validey(View v){
        String text = "Bonjour " + name.getText() + " " + pnom.getText() + " , néé le " + day.getText() + "/" + month.getText() + "/" + year.getText()
                + " dans la jolie ville de " + place.getText();
        Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG).show();
        Intent i = new Intent(getApplicationContext(),ActivitySecondaire.class);
        Personne p = new Personne(pnom.getText().toString(),place.getText().toString());
        i.putExtra("Text",p);
        startActivityForResult(i,0);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.res) {
            day.setText("");
            month.setText("");
            year.setText("");
            pnom.setText("");
            name.setText("");
            place.setText("");
        }
        else if(id == R.id.phone) {
            EditText edit = this.findViewById(R.id.edit);
            int s = edit.getVisibility();
            if (s == View.VISIBLE) {
                edit.setVisibility(View.INVISIBLE);
            } else {
                edit.setVisibility(View.VISIBLE);
            }
        }
        else if(id == R.id.intent){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://fr.wikipedia.org/wiki/" + place.getText()));
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
