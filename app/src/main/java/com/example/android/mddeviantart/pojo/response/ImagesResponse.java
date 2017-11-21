package com.example.android.mddeviantart.pojo.response;

import com.example.android.mddeviantart.pojo.response.images_data.MainImageData;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ImagesResponse{

	@SerializedName("has_more")
	private boolean hasMore;

	@SerializedName("next_offset")
	private int nextOffset;
	private List<MainImageData> results;

	public List<MainImageData> getResults() {
		return results;
	}

	public void setResults(List<MainImageData> results) {
		this.results = results;
	}

	public void setHasMore(boolean hasMore){
		this.hasMore = hasMore;
	}

	public boolean isHasMore(){
		return hasMore;
	}

	public void setNextOffset(int nextOffset){
		this.nextOffset = nextOffset;
	}

	public int getNextOffset(){
		return nextOffset;
	}
}
