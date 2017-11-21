package com.example.android.mddeviantart.pojo.response.images_data;

import android.os.Parcel;
import android.os.Parcelable;

public class Stats implements Parcelable {
	private int comments;
	private int favourites;



	public void setComments(int comments){
		this.comments = comments;
	}

	public int getComments(){
		return comments;
	}

	public void setFavourites(int favourites){
		this.favourites = favourites;
	}

	public int getFavourites(){
		return favourites;
	}

	@Override
 	public String toString(){
		return 
			"Stats{" + 
			"comments = '" + comments + '\'' + 
			",favourites = '" + favourites + '\'' + 
			"}";
		}


	protected Stats(Parcel in) {
		comments = in.readInt();
		favourites = in.readInt();
	}

	public static final Creator<Stats> CREATOR = new Creator<Stats>() {
		@Override
		public Stats createFromParcel(Parcel in) {
			return new Stats(in);
		}

		@Override
		public Stats[] newArray(int size) {
			return new Stats[size];
		}
	};
	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeInt(comments);
		parcel.writeInt(favourites);
	}
}
