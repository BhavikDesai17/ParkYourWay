package com.example.bhavik.navigation;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Vehicle extends AppCompatActivity {
    private ImageView add;
    private TextView car;
    private TextView bike;
    private EditText numberp;
    private Button cancel;
    private Button set;
    private TextView text_number;
    private EditText editNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);
        add = (ImageView) findViewById(R.id.imgAdd);
        text_number = (TextView) findViewById(R.id.textNumberPlate);
        editNumber = (EditText) findViewById(R.id.editnumber);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            showCarDialog();
            }
        });
    }
    private void showCarDialog(){
        final Dialog d = new Dialog(Vehicle.this);
        d.setContentView(R.layout.add_vehicle);
        d.show();
       }

   }
