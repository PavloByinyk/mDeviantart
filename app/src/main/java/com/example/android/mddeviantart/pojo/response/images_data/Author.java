package com.example.android.mddeviantart.pojo.response.images_data;

public class Author{
	private String usericon;
	private String type;
	private String userid;
	private String username;

	public void setUsericon(String usericon){
		this.usericon = usericon;
	}

	public String getUsericon(){
		return usericon;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setUserid(String userid){
		this.userid = userid;
	}

	public String getUserid(){
		return userid;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	@Override
 	public String toString(){
		return 
			"Author{" + 
			"usericon = '" + usericon + '\'' + 
			",type = '" + type + '\'' + 
			",userid = '" + userid + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}
