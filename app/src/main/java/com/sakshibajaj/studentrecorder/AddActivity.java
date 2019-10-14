package com.sakshibajaj.studentrecorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText etAddRno, etName;
    Button btnAddSave;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etAddRno = findViewById(R.id.etAddRno);
        etName = findViewById(R.id.etAddNmae);
        btnAddSave = findViewById(R.id.btnAddSave);


        btnAddSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rno = etAddRno.getText().toString();
                String name = etName.getText().toString();
                MainActivity.db.addStudent(Integer.parseInt(rno), name );
                etAddRno.setText("");
                etName.setText("");
                etAddRno.requestFocus();

            }
        });
    }
}
