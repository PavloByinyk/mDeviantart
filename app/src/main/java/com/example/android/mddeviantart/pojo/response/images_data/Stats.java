package com.example.android.mddeviantart.pojo.response.images_data;

public class Stats{
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
}
