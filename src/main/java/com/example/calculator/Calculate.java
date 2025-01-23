package com.example.calculator;

import com.example.calculator.bases.TipPercent;

public class Calculate implements TipPercent {
    public double subtotal;
    public double percent;
    public double tip = 0.00;
    public double total = 0.00;

    public Calculate(double subtotal, double percent){
        this.subtotal = subtotal;
        this.percent = percent;

        calculateTip();
        calculateTotal();
    }

    @Override
    public void calculateTip() {
        this.tip = subtotal * percent;
    }


    @Override
    public void calculateTotal() {
        this.total = this.subtotal + this.tip;
    }
}
