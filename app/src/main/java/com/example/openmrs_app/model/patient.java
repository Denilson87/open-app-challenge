package com.example.openmrs_app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class patient {
    @SerializedName("display")
    @Expose
    private String display;
    @SerializedName("birthdate")
    @Expose
    private String birthdate;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("attributes")
    @Expose
    private String attributes;
    @Expose
    private String image;

    //Getters and setters
    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public String getImage() {
        return image;
    }

    public void setImageUrl(String imageUrl) {
        this.image = imageUrl;
    }


    @Override
    public String toString() {
        return "patient:" + getDisplay() +
                "\nbirthdate:" + getBirthdate()+
                "\ngender:" + getGender()+
                "\nattributes:" + getAttributes()+
                "\nimaggeurl:"+ getImageUrl();
    }
}
