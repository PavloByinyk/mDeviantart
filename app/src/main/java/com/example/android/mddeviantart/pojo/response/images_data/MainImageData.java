package com.example.android.mddeviantart.pojo.response.images_data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class MainImageData implements Parcelable {
    private boolean allowsComments;
    private boolean isFavourited;
    private boolean isMature;
    private String title;
    private String url;
    private int downloadFilesize;
    private boolean isDeleted;
    private Object printid;
    private String categoryPath;
    private int publishedTime;
    private boolean isDownloadable;
    private String deviationid;
    private String category;
    private Author author;
    private Stats stats;
    private Preview preview;
    private Content content;
    private List<Thumbs> thumbs;


    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public Preview getPreview() {
        return preview;
    }

    public void setPreview(Preview preview) {
        this.preview = preview;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public List<Thumbs> getThumbs() {
        return thumbs;
    }

    public void setThumbs(List<Thumbs> thumbs) {
        this.thumbs = thumbs;
    }

    public void setAllowsComments(boolean allowsComments) {
        this.allowsComments = allowsComments;
    }

    public boolean isAllowsComments() {
        return allowsComments;
    }

    public void setIsFavourited(boolean isFavourited) {
        this.isFavourited = isFavourited;
    }

    public boolean isIsFavourited() {
        return isFavourited;
    }

    public void setIsMature(boolean isMature) {
        this.isMature = isMature;
    }

    public boolean isIsMature() {
        return isMature;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setDownloadFilesize(int downloadFilesize) {
        this.downloadFilesize = downloadFilesize;
    }

    public int getDownloadFilesize() {
        return downloadFilesize;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setPrintid(Object printid) {
        this.printid = printid;
    }

    public Object getPrintid() {
        return printid;
    }

    public void setCategoryPath(String categoryPath) {
        this.categoryPath = categoryPath;
    }

    public String getCategoryPath() {
        return categoryPath;
    }

    public void setPublishedTime(int publishedTime) {
        this.publishedTime = publishedTime;
    }

    public int getPublishedTime() {
        return publishedTime;
    }

    public void setIsDownloadable(boolean isDownloadable) {
        this.isDownloadable = isDownloadable;
    }

    public boolean isIsDownloadable() {
        return isDownloadable;
    }

    public void setDeviationid(String deviationid) {
        this.deviationid = deviationid;
    }

    public String getDeviationid() {
        return deviationid;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }


    protected MainImageData(Parcel in) {
        allowsComments = in.readByte() != 0;
        isFavourited = in.readByte() != 0;
        isMature = in.readByte() != 0;
        title = in.readString();
        url = in.readString();
        downloadFilesize = in.readInt();
        isDeleted = in.readByte() != 0;
        categoryPath = in.readString();
        publishedTime = in.readInt();
        isDownloadable = in.readByte() != 0;
        deviationid = in.readString();
        category = in.readString();
        author = in.readParcelable(Author.class.getClassLoader());
        stats = in.readParcelable(Stats.class.getClassLoader());
        preview = in.readParcelable(Preview.class.getClassLoader());
        content = in.readParcelable(Content.class.getClassLoader());
        thumbs = in.createTypedArrayList(Thumbs.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (allowsComments ? 1 : 0));
        dest.writeByte((byte) (isFavourited ? 1 : 0));
        dest.writeByte((byte) (isMature ? 1 : 0));
        dest.writeString(title);
        dest.writeString(url);
        dest.writeInt(downloadFilesize);
        dest.writeByte((byte) (isDeleted ? 1 : 0));
        dest.writeString(categoryPath);
        dest.writeInt(publishedTime);
        dest.writeByte((byte) (isDownloadable ? 1 : 0));
        dest.writeString(deviationid);
        dest.writeString(category);
        dest.writeParcelable(author, flags);
        dest.writeParcelable(stats, flags);
        dest.writeParcelable(preview, flags);
        dest.writeParcelable(content, flags);
        dest.writeTypedList(thumbs);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MainImageData> CREATOR = new Creator<MainImageData>() {
        @Override
        public MainImageData createFromParcel(Parcel in) {
            return new MainImageData(in);
        }

        @Override
        public MainImageData[] newArray(int size) {
            return new MainImageData[size];
        }
    };
}
