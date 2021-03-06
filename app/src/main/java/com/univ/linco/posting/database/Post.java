package com.univ.linco.posting.database;

import android.net.Uri;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Post {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int post_id;
    private String user_id;
    private String keyword;
    private String title;
    private String content;
    private Integer target;
    private Integer people;
    private String url;
    private String date;
    private String uri_image;
    private Integer id_drawable;
    private String channel;

    public Post(int post_id, String user_id, String keyword, String title, String content,
                Integer target, Integer people, String url, String date, String uri_image,
                Integer id_drawable, String channel) {
        this.id = id;
        this.post_id = post_id;
        this.user_id = user_id;
        this.keyword = keyword;
        this.title = title;
        this.content = content;
        this.target = target;
        this.people = people;
        this.url = url;
        this.date = date;
        this.uri_image = uri_image;
        this.id_drawable = id_drawable;
        this.channel = channel;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUri_image() {
        return uri_image;
    }

    public void setUri_image(String uri_image) {
        this.uri_image = uri_image;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Integer getId_drawable() {
        return id_drawable;
    }

    public void setId_drawable(Integer id_drawable) {
        this.id_drawable = id_drawable;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", user_id='" + user_id + '\'' +
                ", keyword='" + keyword + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", target=" + target +
                ", people=" + people +
                ", url='" + url + '\'' +
                ", date='" + date + '\'' +
                ", uri_image='" + uri_image + '\'' +
                ", id_drawable=" + id_drawable +
                ", channel='" + channel + '\'' +
                '}';
    }
}
