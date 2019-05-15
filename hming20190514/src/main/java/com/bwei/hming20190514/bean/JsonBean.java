package com.bwei.hming20190514.bean;

/**
 * @ Auther:Hming
 * @ Date: 2019.05.13
 * @ Description(功能) :实体类
 */
public class JsonBean {

    private String address;
    private String commentTotal;
    private String distance;
    private String followCinema;
    private String id;
    private String logo;
    private String name;

    public JsonBean() {
    }

    public JsonBean(String address, String commentTotal, String distance, String followCinema, String id, String logo, String name) {
        this.address = address;
        this.commentTotal = commentTotal;
        this.distance = distance;
        this.followCinema = followCinema;
        this.id = id;
        this.logo = logo;
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCommentTotal() {
        return commentTotal;
    }

    public void setCommentTotal(String commentTotal) {
        this.commentTotal = commentTotal;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getFollowCinema() {
        return followCinema;
    }

    public void setFollowCinema(String followCinema) {
        this.followCinema = followCinema;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "JsonBean{" +
                "address='" + address + '\'' +
                ", commentTotal='" + commentTotal + '\'' +
                ", distance='" + distance + '\'' +
                ", followCinema='" + followCinema + '\'' +
                ", id='" + id + '\'' +
                ", logo='" + logo + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
