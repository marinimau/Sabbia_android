/*
 * Sabbia copyright © 2020
 * Author: mauromarini - https://github.com/marinimau
 * Package: com.marinumau.sabbia.logic.MenuLinksManager
 * Date: 10/07/2020
 */

package com.marinumau.sabbia.logic.MenuLinksManager;

public class Link {

    private String title;
    private String url;

    /**
     *
     * @param title the link title
     * @param url the link url
     */
    public Link(String title, String url) {
        this.title = title;
        this.url = url;
    }

    /**
     *
     * @return the link title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title the link title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return the link url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url the link url
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
