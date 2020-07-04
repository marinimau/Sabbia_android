/*
 * Sabbia copyright © 2020
 * Author: mauromarini - https://github.com/marinimau
 * Package: com.marinumau.sabbia.logic
 * Date: 03/07/2020
 */

package com.marinumau.sabbia.logic.BeachManager;

public class Beach {

    int id;
    String name;
    String location;

    /**
     *
     */
    public Beach() { }

    /**
     *
     * @param id the beach id
     * @param name the name of the beach
     * @param location the location of the beach
     */
    public Beach(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
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
}
