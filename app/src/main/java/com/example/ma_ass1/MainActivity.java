package com.example.ma_ass1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
EditText amt;
Spinner rates;
Spinner am_period;
Spinner p_freq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing interest rates spinner
        rates = (Spinner) findViewById(R.id.irList);
        ArrayAdapter<CharSequence> a = ArrayAdapter.createFromResource(this, R.array.rates, android.R.layout.simple_spinner_item);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rates.setAdapter(a);

        //initializing armotization period spinner
        am_period = (Spinner) findViewById(R.id.ampList);
        ArrayAdapter<CharSequence> b = ArrayAdapter.createFromResource(this, R.array.amortization_period, android.R.layout.simple_spinner_item);
        b.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        am_period.setAdapter(b);

        //initializing frequency spinner
        p_freq = (Spinner) findViewById(R.id.pfreqList);
        ArrayAdapter<CharSequence> c = ArrayAdapter.createFromResource(this, R.array.payment_freq, android.R.layout.simple_spinner_item);
        c.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p_freq.setAdapter(c);
    }

    public void sendData(View v){
        amt = (EditText) findViewById(R.id.eamt);
        Intent send = new Intent(this, DisplayMortgage.class);

        //getting the field values
        String amount = amt.getText().toString();
        String txtRates = rates.getSelectedItem().toString();
        String txtAm_period = am_period.getSelectedItem().toString();
        String txtP_freq = p_freq.getSelectedItem().toString();

        //putting the values in the intent
        send.putExtra("amount", amount);
        send.putExtra("rates", txtRates);
        send.putExtra("amortization_period", txtAm_period);
        send.putExtra("payment_frequency", txtP_freq);

        startActivity(send);
    }
}