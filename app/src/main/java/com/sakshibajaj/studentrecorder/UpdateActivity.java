package com.sakshibajaj.studentrecorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {
    EditText etUpdateRno , etUpdateName;
    Button btnSaveUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        etUpdateName = findViewById(R.id.etUpdateName);
        etUpdateRno = findViewById(R.id.etUpdateRno);
        btnSaveUpdate = findViewById(R.id.btnSaveUpdate);

        btnSaveUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rno = etUpdateRno.getText().toString();
                String name = etUpdateName.getText().toString();
                MainActivity.db.updateStudent(Integer.parseInt(rno), name);
                etUpdateRno.setText("");
                etUpdateName.setText("");
                etUpdateRno.requestFocus();

            }
        });
    }
}
