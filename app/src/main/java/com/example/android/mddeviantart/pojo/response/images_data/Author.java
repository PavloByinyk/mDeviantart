package com.example.android.mddeviantart.pojo.response.images_data;

import android.os.Parcel;
import android.os.Parcelable;

public class Author implements Parcelable {
    private String usericon;
    private String type;
    private String userid;
    private String username;


    public void setUsericon(String usericon) {
        this.usericon = usericon;
    }

    public String getUsericon() {
        return usericon;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return
                "Author{" +
                        "usericon = '" + usericon + '\'' +
                        ",type = '" + type + '\'' +
                        ",userid = '" + userid + '\'' +
                        ",username = '" + username + '\'' +
                        "}";
    }


    protected Author(Parcel in) {
        usericon = in.readString();
        type = in.readString();
        userid = in.readString();
        username = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(usericon);
        dest.writeString(type);
        dest.writeString(userid);
        dest.writeString(username);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Author> CREATOR = new Creator<Author>() {
        @Override
        public Author createFromParcel(Parcel in) {
            return new Author(in);
        }

        @Override
        public Author[] newArray(int size) {
            return new Author[size];
        }
    };
}
