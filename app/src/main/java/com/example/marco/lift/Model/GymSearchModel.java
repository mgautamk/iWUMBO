package com.example.marco.lift.Model;

/**
 * Created by Marco on 4/1/15.
 */
public class GymSearchModel {
    private String GymName; // in the api use the getName() function.
    private String Address; // getAddress()
    private String GymID;  // getID()
    private String LatLng; // getLatLng()

    public String getGymName() {
        return GymName;
    }
    public void setGymName(String gymName) {
        GymName = gymName;
    }

    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }

    public String getGymID() {
        return GymID;
    }
    public void setGymID(String gymID) {
        GymID = gymID;
    }

    public String getLatLng() {
        return LatLng;
    }
    public void setLatLng(String latLng) {
        LatLng = latLng;
    }



}
