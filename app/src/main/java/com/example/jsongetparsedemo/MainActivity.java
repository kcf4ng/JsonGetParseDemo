package com.example.jsongetparsedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private View.OnClickListener btnGet_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ActGetJSON process = new ActGetJSON();
            process.execute();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitialComponent();
    }

    private void InitialComponent() {
        btnGet = findViewById(R.id.btnGet);
        btnGet.setOnClickListener(btnGet_click);
        lbl1=findViewById(R.id.lbl1);
    }
    Button btnGet;
    public static TextView lbl1;
}
