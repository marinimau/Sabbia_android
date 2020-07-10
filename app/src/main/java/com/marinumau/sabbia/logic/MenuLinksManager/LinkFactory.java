/*
 * Sabbia copyright © 2020
 * Author: mauromarini - https://github.com/marinimau
 * Package: com.marinumau.sabbia.logic.MenuLinksManager
 * Date: 10/07/2020
 */

package com.marinumau.sabbia.logic.MenuLinksManager;


import android.content.Context;

import java.util.ArrayList;

public class LinkFactory {

    private static LinkFactory singleton = null;
    private static ArrayList<Link> linkList = new ArrayList<>();

    /**
     *
     */
    private LinkFactory(){ loadLinks(); }

    /**
     *
     * @return the singleton
     */
    public static LinkFactory getInstance(){
        if(singleton==null){
            singleton = new LinkFactory();
        }
        return singleton;
    }

    /**
     *
     * @return the link list
     */
    public ArrayList<Link> getLinkList(){ return  linkList; }

    /**
     *
     */
    private void loadLinks(){
        linkList.clear();

        Link privacyPolicy = new Link("Privacy policy", "http://github.com/marinimau");
        linkList.add(privacyPolicy);

        Link donate = new Link("Dona", "http://github.com/marinimau");
        linkList.add(donate);

        Link rate = new Link("Lascia una recensione", "http://github.com/marinimau");
        linkList.add(rate);

        Link telegramChannel = new Link("Canale Telegram", "http://github.com/marinimau");
        linkList.add(telegramChannel);

        Link githubRepository = new Link("Codice sorgente", "http://github.com/marinimau");
        linkList.add(githubRepository);

    }
}

