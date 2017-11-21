package com.example.android.mddeviantart.pojo.response.images_data;

public class Thumbs{
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
}
