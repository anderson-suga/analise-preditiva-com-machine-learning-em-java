package models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by suemareverton on 16/08/17.
 */
public class Fighter {

    public int id;
    public int wins;

    @SerializedName("first_name")
    public String firstName;

    @SerializedName("last_name")
    public String lastName;

    @SerializedName("profile_image")
    public String profileImage;
}
