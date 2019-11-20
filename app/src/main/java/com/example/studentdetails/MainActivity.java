package com.example.studentdetails;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Spinner spincountry;
    AutoCompleteTextView autobatch;
    TextView tvoutput;
    Button btnsave;
    EditText etname;
    RadioButton rdomale,rdofemale,rdoothers;
AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spincountry=findViewById(R.id.spincountry);
        rdomale=findViewById(R.id.rdomale);
        rdofemale=findViewById(R.id.rdofemale);
        rdoothers=findViewById(R.id.rdoothers);
        btnsave=findViewById(R.id.btnsave);
        tvoutput=findViewById(R.id.tvoutput);
        etname=findViewById(R.id.etname);
        autobatch=findViewById(R.id.autobatch);
        builder=new AlertDialog.Builder(this);

        String batch[] = {"22a", "22b", "22c", "22d"};
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.select_dialog_item, batch);

        autobatch.setAdapter(stringArrayAdapter);
        autobatch.setThreshold(1);

        String countries[] = {"Nepal", "India", "China", "uk", "Us"};
        ArrayAdapter adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                countries
        );
        spincountry.setAdapter(adapter);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setMessage("Do you want to close this application")
                        .setCancelable(false)
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                String name=etname.getText().toString();
                                String gender;
                                if(rdomale.isChecked())
                                {
                                    gender="Male";
                                }
                                else if(rdofemale.isChecked())
                                {
                                    gender="Female";

                                }
                                else
                                {
                                    gender="Others";
                                }
                                String country=spincountry.getSelectedItem().toString();
                                String batch=autobatch.getText().toString();
                                tvoutput.setText("Name;"+""+name);
                                tvoutput.append("Gender:"+""+gender);
                                tvoutput.append("country;"+""+country);
                                tvoutput.append("batch;"+""+batch);
                                //finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();

                            }
                        });
                AlertDialog alert =builder.create();
            alert.setTitle("Student details");
            alert.show();

            }
        });



    }
}
