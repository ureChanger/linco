package com.univ.linco.thumbnail;

public class ThumbnailItem {
    private String post_id;
    private String user_id;
    private String date;
    private String keyword;
    private String uri_image;
    private Integer drawable_image;
    private String title;
    private Integer target;
    private Integer people;
    private Integer img_link;

    public ThumbnailItem(String post_id, String user_id, String date, String keyword,
                         String uri_image, Integer drawable_image, String title,
                         Integer target, Integer people, Integer img_link) {
        this.post_id = post_id;
        this.user_id = user_id;
        this.date = date;
        this.keyword = keyword;
        this.uri_image = uri_image;
        this.drawable_image = drawable_image;
        this.title = title;
        this.target = target;
        this.people = people;
        this.img_link = img_link;
    }

    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getUri_image() {
        return uri_image;
    }

    public void setUri_image(String uri_image) {
        this.uri_image = uri_image;
    }

    public Integer getDrawable_image() {
        return drawable_image;
    }

    public void setDrawable_image(Integer drawable_image) {
        this.drawable_image = drawable_image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }

    public Integer getPeople() {
        return people;
    }

    public void setPeople(Integer people) {
        this.people = people;
    }

    public Integer getImg_link() {
        return img_link;
    }

    public void setImg_link(Integer img_link) {
        this.img_link = img_link;
    }
}
