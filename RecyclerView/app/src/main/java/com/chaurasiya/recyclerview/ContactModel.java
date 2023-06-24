package com.chaurasiya.recyclerview;

public class ContactModel {
    int image;
    String contactName , contactNumber;

    public ContactModel(int image, String contactName, String contactNumber) {
        this.image = image;
        this.contactName = contactName;
        this.contactNumber = contactNumber;
    }
    public ContactModel(String contactName, String contactNumber){
        this.contactName= contactName;
        this.contactNumber = contactNumber;
    }
}
