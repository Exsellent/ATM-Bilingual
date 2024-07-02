package org.example;

import java.util.Date;
import java.util.Locale;
import java.text.SimpleDateFormat;

class Transaction {
    private final String type;
    private final double amount;
    private final Date date;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.date = new Date();
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.getDefault());
        return sdf.format(date) + " - " + type + ": " + String.format(Locale.ROOT, "%.2f", amount);
    }
}
