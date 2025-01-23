package com.example.calculator;

import static java.lang.String.*;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        calculate(R.id.fifteenBtn, .15);
        calculate(R.id.eighteenBtn, .18);
        calculate(R.id.twentyBtn, .2);

    }

    public void calculate(int id, double percent){
        Button button = findViewById(id);
        button.setOnClickListener(l -> {

            EditText editText = findViewById(R.id.editTextNumberDecimal);
            double subtotal = Double.parseDouble(valueOf(editText.getText()));

            Calculate calc = new Calculate(subtotal, percent);

            TextView outputText = findViewById(R.id.outputDisplay);

            Resources res = getResources();
            String tip = res.getString(R.string.tipLabel, format("%.2f", calc.tip));

            String total = res.getString(R.string.totalLabel, format("%.2f", calc.total));

            outputText.setText(String.format("%s  %s", tip, total));
        });

    }

}