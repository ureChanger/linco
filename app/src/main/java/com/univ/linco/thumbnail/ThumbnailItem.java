package com.univ.linco.thumbnail;

public class ThumbnailItem {
    String postId;
    String userId;
    String uploadDate;
    String category;
    Integer thumbnail;
    Integer link;
    String participants;
    String target;
    String title;


    public ThumbnailItem(String postId, String userId, String uploadDate, String category, Integer thumbnail, Integer link, String participants, String target, String title){
        this.thumbnail = thumbnail;
        this.link = link;
        this.participants = participants;
        this.target = target;
        this.title = title;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostId() {
        return postId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setThumbnail(Integer thumbnail){
        this.thumbnail = thumbnail;
    }

    public Integer getThumbnail() {
        return thumbnail;
    }

    public void setLink(Integer link) {
        this.link = link;
    }

    public Integer getLink() {
        return link;
    }

    public void setParticipants(String participants){
        this.participants = participants;
    }

    public String getParticipants() {
        return participants;
    }

    public void setTarget(String target){
        this.target = target;
    }

    public String getTarget() {
        return target;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
