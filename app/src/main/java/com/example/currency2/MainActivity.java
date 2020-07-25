package com.example.currency2;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner1, spinner2;
    private EditText from;
    private TextView to;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);
        from = (EditText) findViewById(R.id.InputEditText);
        to = (TextView) findViewById(R.id.OutputTextView);
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        List<String> list1 = new ArrayList<String>();
        list1.add("United States Dollar");
        list1.add("Armenian Dram");
        list1.add("Bitcoin");
        list1.add("Chinese Yuan");
        list1.add("Indian Rupee");
        list1.add("Kuwaiti Dinar");
        list1.add("Mexican Peso");
        list1.add("Omani Rial");
        list1.add("Bangladeshi Taka");

        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list1);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter1);


        spinner2 = (Spinner) findViewById(R.id.spinner2);
        List<String> list2 = new ArrayList<String>();

        list2.add("United States Dollar");
        list2.add("Armenian Dram");
        list2.add("Bitcoin");
        list2.add("Chinese Yuan");
        list2.add("Indian Rupee");
        list2.add("Kuwaiti Dinar");
        list2.add("Mexican Peso");
        list2.add("Omani Rial");
        list2.add("Bangladeshi Taka");

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list2);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter2);
    }


    public void onClick(View v) {

        int index1 = spinner1.getSelectedItemPosition();
        int index2 = spinner2.getSelectedItemPosition();
        float value = Float.parseFloat(from.getText().toString());

        /* We have 8 units to convert from and to.
         * that means 8*8 = 64 cases!
         * to minimize work we convert from any selected unit to BDT
         * then we convert from BDT to the desired unit.
         */
        // ratios from google convertor where 0.012 usd=1 tk

        float[] ratio = {0.012f, 5.73f, 0.0000012f, 0.083f, 0.88f, 0.0036f, 0.26f, 0.0045f, 1};
        float result;
        result = value / ratio[index1] * ratio[index2];
        to.setText(result+"");
    }
}