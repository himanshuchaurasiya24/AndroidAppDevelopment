package com.chaurasiya.myapplication.db.entity;

public class Contact {
    // Constants for database;
    public static final String TABLE_NAME = "contacts";
    public static final String COLUMN_ID = "column_id";
    public static final String COLUMN_NAME = "column_name";
    public static final String COLUMN_EMAIL = "column_email";
    // Variables;
    public String name;
    public String email;
    public int id;
    // Constructors
    public Contact(){

    }
    public Contact(String name , String email, int id){
        this.name = name ;
        this.email = email;
        this.id = id;
    }
    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    // SQL Query: Creating the table
    public static final String CREATE_TABLE = "CREATE TABLE "+
            TABLE_NAME+"("
            +COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
            +COLUMN_NAME+" TEXT,"
            +COLUMN_EMAIL+ " DATETIME DEFAULT CURRENT_TIMESTAMP"
            +")";
}
