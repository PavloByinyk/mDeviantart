package com.example.android.mddeviantart.pojo.response.images_data;

import android.os.Parcel;
import android.os.Parcelable;

public class Content implements Parcelable {
    private String src;
    private boolean transparency;
    private int width;
    private int filesize;
    private int height;


    public void setSrc(String src) {
        this.src = src;
    }

    public String getSrc() {
        return src;
    }

    public void setTransparency(boolean transparency) {
        this.transparency = transparency;
    }

    public boolean isTransparency() {
        return transparency;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setFilesize(int filesize) {
        this.filesize = filesize;
    }

    public int getFilesize() {
        return filesize;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return
                "Content{" +
                        "src = '" + src + '\'' +
                        ",transparency = '" + transparency + '\'' +
                        ",width = '" + width + '\'' +
                        ",filesize = '" + filesize + '\'' +
                        ",height = '" + height + '\'' +
                        "}";
    }

    protected Content(Parcel in) {
        src = in.readString();
        transparency = in.readByte() != 0;
        width = in.readInt();
        filesize = in.readInt();
        height = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(src);
        dest.writeByte((byte) (transparency ? 1 : 0));
        dest.writeInt(width);
        dest.writeInt(filesize);
        dest.writeInt(height);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Content> CREATOR = new Creator<Content>() {
        @Override
        public Content createFromParcel(Parcel in) {
            return new Content(in);
        }

        @Override
        public Content[] newArray(int size) {
            return new Content[size];
        }
    };
}
