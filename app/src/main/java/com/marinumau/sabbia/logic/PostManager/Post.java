/*
 * Sabbia copyright © 2020
 * Author: mauromarini - https://github.com/marinimau
 * Package: com.marinumau.sabbia.logic.PostManager
 * Date: 10/07/2020
 */

package com.marinumau.sabbia.logic.PostManager;

public class Post {

    private String id;
    private String author;
    private String date;
    private String corpus;

    /**
     * 
     * @param id the id of the post
     * @param author the author of the post
     * @param date the date of the post
     * @param corpus the corpus of the post
     */
    public Post(String id, String author, String date, String corpus) {
        this.id = id;
        this.author = author;
        this.date = date;
        this.corpus = corpus;
    }

    /**
     *
     * @return the post id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id the post id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return the author of the post
     */
    public String getAuthor() {
        return author;
    }

    /**
     *
     * @param author the author of the post
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 
     * @return the date of the post
     */
    public String getDate() {
        return date;
    }

    /**
     * 
     * @param date the date of the post
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * 
     * @return the corpus of the post
     */
    public String getCorpus() {
        return corpus;
    }

    /**
     * 
     * @param corpus the corpus of the post
     */
    public void setCorpus(String corpus) {
        this.corpus = corpus;
    }
}
