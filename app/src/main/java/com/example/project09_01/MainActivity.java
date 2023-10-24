package com.example.project09_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button btnW, btnR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnW = (Button) findViewById(R.id.btnW);
        btnR = (Button) findViewById(R.id.btnR);

        btnW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileOutputStream outFs;
                try {
                    outFs = openFileOutput("file.txt", Context.MODE_PRIVATE);
                    String str = ("Android Class File");
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(getApplicationContext(), "file.txt 생성", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
//                    throw new RuntimeException(e);
                }
            }
        });

        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream inFs = openFileInput("file.txt");
                    byte[] txt = new byte[30];
                    inFs.read(txt);
                    String str = new String(txt);
                    Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                    inFs.close();
                } catch (IOException e) {
//                    throw new RuntimeException(e);
                    Toast.makeText(getApplicationContext(), "File Not Found", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}