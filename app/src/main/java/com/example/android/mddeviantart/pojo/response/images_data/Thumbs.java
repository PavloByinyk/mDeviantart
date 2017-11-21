package com.example.android.mddeviantart.pojo.response.images_data;

import android.os.Parcel;
import android.os.Parcelable;

public class Thumbs implements Parcelable {
	private String src;
	private boolean transparency;
	private int width;
	private int height;


	public void setSrc(String src){
		this.src = src;
	}

	public String getSrc(){
		return src;
	}

	public void setTransparency(boolean transparency){
		this.transparency = transparency;
	}

	public boolean isTransparency(){
		return transparency;
	}

	public void setWidth(int width){
		this.width = width;
	}

	public int getWidth(){
		return width;
	}

	public void setHeight(int height){
		this.height = height;
	}

	public int getHeight(){
		return height;
	}

	@Override
 	public String toString(){
		return 
			"Thumbs{" + 
			"src = '" + src + '\'' + 
			",transparency = '" + transparency + '\'' + 
			",width = '" + width + '\'' + 
			",height = '" + height + '\'' + 
			"}";
		}


	protected Thumbs(Parcel in) {
		src = in.readString();
		transparency = in.readByte() != 0;
		width = in.readInt();
		height = in.readInt();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(src);
		dest.writeByte((byte) (transparency ? 1 : 0));
		dest.writeInt(width);
		dest.writeInt(height);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<Thumbs> CREATOR = new Creator<Thumbs>() {
		@Override
		public Thumbs createFromParcel(Parcel in) {
			return new Thumbs(in);
		}

		@Override
		public Thumbs[] newArray(int size) {
			return new Thumbs[size];
		}
	};
}
