package com.example.android.mddeviantart.pojo.response.images_data;

import java.util.List;

public class MainImageData{
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

	public void setAllowsComments(boolean allowsComments){
		this.allowsComments = allowsComments;
	}

	public boolean isAllowsComments(){
		return allowsComments;
	}

	public void setIsFavourited(boolean isFavourited){
		this.isFavourited = isFavourited;
	}

	public boolean isIsFavourited(){
		return isFavourited;
	}

	public void setIsMature(boolean isMature){
		this.isMature = isMature;
	}

	public boolean isIsMature(){
		return isMature;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setDownloadFilesize(int downloadFilesize){
		this.downloadFilesize = downloadFilesize;
	}

	public int getDownloadFilesize(){
		return downloadFilesize;
	}

	public void setIsDeleted(boolean isDeleted){
		this.isDeleted = isDeleted;
	}

	public boolean isIsDeleted(){
		return isDeleted;
	}

	public void setPrintid(Object printid){
		this.printid = printid;
	}

	public Object getPrintid(){
		return printid;
	}

	public void setCategoryPath(String categoryPath){
		this.categoryPath = categoryPath;
	}

	public String getCategoryPath(){
		return categoryPath;
	}

	public void setPublishedTime(int publishedTime){
		this.publishedTime = publishedTime;
	}

	public int getPublishedTime(){
		return publishedTime;
	}

	public void setIsDownloadable(boolean isDownloadable){
		this.isDownloadable = isDownloadable;
	}

	public boolean isIsDownloadable(){
		return isDownloadable;
	}

	public void setDeviationid(String deviationid){
		this.deviationid = deviationid;
	}

	public String getDeviationid(){
		return deviationid;
	}

	public void setCategory(String category){
		this.category = category;
	}

	public String getCategory(){
		return category;
	}


}
