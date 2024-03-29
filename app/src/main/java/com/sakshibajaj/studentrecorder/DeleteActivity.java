package com.sakshibajaj.studentrecorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DeleteActivity extends AppCompatActivity {

    EditText etDeleteRno;
    Button btnDeleteSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        etDeleteRno = findViewById(R.id.etDeleteRno);
        btnDeleteSave = findViewById(R.id.btnDeleteSave);

        btnDeleteSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rno = etDeleteRno.getText().toString();
                MainActivity.db.deleteStudent(Integer.parseInt(rno));
                etDeleteRno.setText("");
                etDeleteRno.requestFocus();
            }
        });


    }
}
