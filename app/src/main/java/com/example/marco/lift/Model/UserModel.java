package com.example.marco.lift.Model;

import java.net.URI;

/**
 * Created by kting_000 on 3/12/2015.
 */
public class UserModel {
    private int UserID;
    private String Username;
    private Float Rating;
    private URI ProfilePicture;
    private String Password;
    private String Email;
    private String PreferredGym;

    public int getUserID(){
        return UserID;
    }

    public String getUsername() {
        return Username;
    }
    public void setUsername(String Username) {
        this.Username = Username;
    }

    public Float getRating() {
        return Rating;
    }
    public void setRating(Float Rating) {
        this.Rating = Rating;
    }

    public URI getProfilePicture() {
        return ProfilePicture;
    }
    public void setProfilePicture(URI ProfilePicture) {
        this.ProfilePicture = ProfilePicture;
    }

    public String getPassword() {
        return Password;
    }
    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getEmail() {
        return Email;
    }
    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPreferredGym() {
        return PreferredGym;
    }
    public void setPreferredGym(String PreferredGym) {
        this.PreferredGym = PreferredGym;
    }

}
