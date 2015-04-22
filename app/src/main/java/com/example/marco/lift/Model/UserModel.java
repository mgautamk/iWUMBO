package com.example.marco.lift.Model;

import com.google.gson.annotations.SerializedName;

import java.net.URI;
import java.security.Timestamp;

/**
 * Created by kting_000 on 3/12/2015.
 */
public class UserModel {
    @SerializedName("UserID")
    public int UserID;
    @SerializedName("Username")
    public String Username;
    //public float Rating;
    //public URI ProfilePicture;
    @SerializedName("Password")
    public String Password;
    @SerializedName("Email")
    public String Email;
    @SerializedName("PreferredGym")
    public String PreferredGym;
    @SerializedName("DateCreated")
    public String DateCreated;

}