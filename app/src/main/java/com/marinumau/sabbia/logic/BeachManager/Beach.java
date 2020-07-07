/*
 * Sabbia copyright © 2020
 * Author: mauromarini - https://github.com/marinimau
 * Package: com.marinumau.sabbia.logic
 * Date: 03/07/2020
 */

package com.marinumau.sabbia.logic.BeachManager;

public class Beach {

    private int id;
    private String name;
    private String location;
    private String imgUrl;

    /**
     *
     */
    public Beach() { }

    /**
     *
     * @param id the beach id
     * @param name the name of the beach
     * @param location the location of the beach
     * @param imgUrl the img url of the beach
     */
    public Beach(int id, String name, String location, String imgUrl) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.imgUrl = imgUrl;
    }

    /**
     *
     * @return the beach id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id the id of the beach
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return the name of the beach
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name the name of the beach
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return the name of the municipality
     */
    public String getLocation() {
        return location;
    }

    /**
     *
     * @param location the name of the municipality
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     *
     * @return the img url of the beach
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     *
     * @param imgUrl the img url for the beach
     */
    public void setImgUri(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
