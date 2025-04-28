package com;

public class Booking {
    private String customerName;
    private int tableSize;
    private String date; // Format: YYYY-MM-DD
    private String time; // Format: HH:MM (24-hour format)

    public Booking() {
        // Default constructor needed for JSON parsing
    }

    public Booking(String customerName, int tableSize, String date, String time) {
        this.customerName = customerName;
        this.tableSize = tableSize;
        this.date = date;
        this.time = time;
    }

    // Getters and Setters
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getTableSize() {
        return tableSize;
    }

    public void setTableSize(int tableSize) {
        this.tableSize = tableSize;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "customerName='" + customerName + '\'' +
                ", tableSize=" + tableSize +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}