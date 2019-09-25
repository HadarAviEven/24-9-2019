package com.example.itaykan.a24919_b;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_id;
    int correct_id;

    EditText et_name;
    String correct_name;

    Person p1;

    MySQLiteHelper mySQL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(MySQLiteHelper.TABLE_NAME);
        mySQL = new MySQLiteHelper(this);

        et_id = findViewById(R.id.main_ET_id);

        et_name = findViewById(R.id.main_ET_name);

        Button btn = findViewById(R.id.main_btn_register);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                correct_id = Integer.valueOf(et_id.getText().toString());
                correct_name = et_name.getText().toString();

                p1 = new Person(correct_id, correct_name);

                if (mySQL.insertData(p1)) {
                    Toast.makeText(getBaseContext(), "הצלחנו P1", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getBaseContext(), "לא הצלחנו P1", Toast.LENGTH_SHORT).show();
                }
            }
        });

//        Person p1 = new Person(correct_id, correct_name);

//        Person p1 = new Person(1, "Menahem");
//        Person p2 = new Person(2, "Dvora");
//        Person p3 = new Person(3, "Silit");


//        if (mySQL.insertData(p1)) {
//            Toast.makeText(this, "הצלחנו P1", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(this, "לא הצלחנו P1", Toast.LENGTH_SHORT).show();
//        }
//        if (mySQL.insertData(p2)) {
//            Toast.makeText(this, "הצלחנו P2", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(this, "לא הצלחנו P2", Toast.LENGTH_SHORT).show();
//        }
//
//        if (mySQL.insertData(p3)) {
//            Toast.makeText(this, "הצלחנו P3", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(this, "לא הצלחנו P3", Toast.LENGTH_SHORT).show();
//        }


    }
}
