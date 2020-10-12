package com.example.ma_ass1;

import android.os.Bundle;
import android.os.TestLooperManager;
import android.widget.TextView;
import java.lang.*;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;



public class DisplayMortgage extends AppCompatActivity {
    TextView mAmount;
    TextView iRates;
    TextView aPeriod;
    TextView pFrequency;
    TextView balText;
    String balText1;
    double irate1;
    double terms;
    double year;
    double amortization;
    TextView totpaid;

    int principal;
    double mnthly_payment;
    TextView pay_amt;
    String m_payment;
    double tot_paid;

    String tot_paid1;

    String amt1;
    String period1;
    String rates1;
    String frequency1;
    String text;
    double pay_term;

//method to get the amortization period
    public double amortization_period(){
        if(period1.equals("10 Years")){
            year = 10;
        }
        else if(period1.equals("15 Years")){
            year = 15;
        }
        else if(period1.equals("20 Years")){
            year = 20;
        }
        else if(period1.equals("25 Years")){
            year = 25;
        }

        return year;
    }

    public String balance_text(){
        if(rates1.equals("3 Year Fixed Rate Mortgage 2.14%")) {
            balText1 = "total paid after 3 years term";

        }


        else if(rates1.equals("5 Year Fixed Rate Mortgage 2.14%")) {
            balText1 = "total paid after 5 years term";

        }

        else if(rates1.equals("10 Year Fixed Rate Mortgage 2.14%")) {
            balText1 = "total paid after 10 years term";

        }
        return balText1;
    }
//method to get the mortgage term
    public double mortgage_term(){
        if(rates1.equals("3 Year Fixed Rate Mortgage 2.14%")) {
            terms = 3;

        }


        else if(rates1.equals("5 Year Fixed Rate Mortgage 2.14%")) {
            terms = 5;

        }

        else if(rates1.equals("10 Year Fixed Rate Mortgage 2.14%")) {
            terms = 10;

        }
        return terms;
    }
//monthly_payment = principal * ((irate1 * iratepow) / (iratepow - 1));
    //method to get the monthly payment
    public double monthly_payment(){
        principal = Integer.parseInt(amt1);
        amortization = amortization_period();
        irate1 = 2.14;
        double yr_to_months = amortization * 12;
        double irate_to_months = irate1 /100/ 12;
        double irate_to_months_pow = Math.pow((1 + irate_to_months), yr_to_months);
        double monthly_pay = principal * ((irate_to_months * irate_to_months_pow)/ (irate_to_months_pow - 1));

        return monthly_pay;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_mortgage);

        mAmount = (TextView) findViewById(R.id.eamt2);
        iRates = (TextView) findViewById(R.id.lblrate);
        aPeriod = (TextView) findViewById(R.id.am_period);
        pFrequency = (TextView) findViewById(R.id.pfreq);
        balText = (TextView) findViewById(R.id.balcalc);
        totpaid = (TextView) findViewById(R.id.totpaidamt);
        pay_amt = (TextView) findViewById(R.id.mnthlyamt);

        Bundle bundle = getIntent().getExtras();
        amt1 = bundle.get("amount").toString();
        rates1 = bundle.get("rates").toString();
        period1 = bundle.get("amortization_period").toString();
        frequency1 = bundle.get("payment_frequency").toString();

        text = balance_text();
        mnthly_payment = monthly_payment();
        m_payment = Double.toString(mnthly_payment);
        pay_term = mortgage_term();
        tot_paid = mnthly_payment * (pay_term * 12);
        tot_paid1 = Double.toString(tot_paid);

        //writing all the info into the textview
        mAmount.setText(amt1);
       iRates.setText(rates1);
        aPeriod.setText(period1);
       pFrequency.setText(frequency1);
       balText.setText(text);
        pay_amt.setText(m_payment);
        totpaid.setText(tot_paid1);


    }


}
