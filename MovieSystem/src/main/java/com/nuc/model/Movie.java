package com.nuc.model;

/**
 * Created by Jiayiwu on 18/5/6.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
public class Movie {

    int id;

    String name;

    String logoUrl;

    String description;

    String type;

    //影片长度
    int timeOfMovie;
    //0上映，1下架
    int status;

    public Movie() {
    }

    public Movie(String name, String logoUrl, String description, String type, int timeOfMovie) {
        this.name = name;
        this.logoUrl = logoUrl;
        this.description = description;
        this.type = type;
        this.timeOfMovie = timeOfMovie;
        this.status = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTimeOfMovie() {
        return timeOfMovie;
    }

    public void setTimeOfMovie(int timeOfMovie) {
        this.timeOfMovie = timeOfMovie;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
