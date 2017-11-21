package com.example.android.mddeviantart.pojo.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.internal.ParcelableSparseArray;

import com.example.android.mddeviantart.pojo.response.images_data.MainImageData;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ImagesResponse implements Parcelable {

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




	protected ImagesResponse(Parcel in) {
		hasMore = in.readByte() != 0;
		nextOffset = in.readInt();
	}

	public static final Creator<ImagesResponse> CREATOR = new Creator<ImagesResponse>() {
		@Override
		public ImagesResponse createFromParcel(Parcel in) {
			return new ImagesResponse(in);
		}

		@Override
		public ImagesResponse[] newArray(int size) {
			return new ImagesResponse[size];
		}
	};

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeByte((byte) (hasMore ? 1 : 0));
		parcel.writeInt(nextOffset);
	}
}
