/*
 * Sabbia copyright © 2020
 * Author: mauromarini - https://github.com/marinimau
 * Package: com.marinumau.sabbia.logic.PostManager
 * Date: 10/07/2020
 */

package com.marinumau.sabbia.logic.PostManager;


import java.util.ArrayList;

public class PostFactory {

    private static PostFactory singleton = null;
    private ArrayList<Post> postList = new ArrayList<>();

    /**
     *
     */
    private PostFactory() {
        loadPost();
    }

    /**
     * @return the singleton instance
     */
    public static PostFactory getInstance() {
        if (singleton == null) {
            singleton = new PostFactory();
        }
        return singleton;
    }

    /**
     * @return the list of the posts
     */
    public ArrayList<Post> getBeachList() {
        return postList;
    }

    /**
     *
     */
    private void loadPost() {

        postList.clear();

        Post p = new Post("001", "Anonimo", "07-07-2020 10:20", "Prova Post ");

        for(int i = 0; i<7; i++){
            p.setCorpus("Prova post n"+ i);
            postList.add(p);
        }

    }

    /**
     *
     * @param id the id of the post
     * @return the post with the given id
     */
    public Post getPostById(String id){
        for (Post p: postList) {
            if(p.getId() != null && p.getId().equals(id)){
                return p;
            }
        }
        return null;
    }
}
