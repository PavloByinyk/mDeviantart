package com.example.android.mddeviantart.pojo.response.images_data;

import android.os.Parcel;
import android.os.Parcelable;

public class Preview implements Parcelable {
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
			"Preview{" + 
			"src = '" + src + '\'' + 
			",transparency = '" + transparency + '\'' + 
			",width = '" + width + '\'' + 
			",height = '" + height + '\'' + 
			"}";
		}



	protected Preview(Parcel in) {
		src = in.readString();
		transparency = in.readByte() != 0;
		width = in.readInt();
		height = in.readInt();
	}

	public static final Creator<Preview> CREATOR = new Creator<Preview>() {
		@Override
		public Preview createFromParcel(Parcel in) {
			return new Preview(in);
		}

		@Override
		public Preview[] newArray(int size) {
			return new Preview[size];
		}
	};
	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(src);
		parcel.writeByte((byte) (transparency ? 1 : 0));
		parcel.writeInt(width);
		parcel.writeInt(height);
	}
}
