/*
 * Sabbia copyright © 2020
 * Author: mauromarini - https://github.com/marinimau
 * Package: com.marinumau.sabbia.logic.BeachManager
 * Date: 03/07/2020
 */

package com.marinumau.sabbia.logic.BeachManager;

import java.util.ArrayList;

public class BeachFactory {

    private static BeachFactory singleton = null;
    private ArrayList<Beach> beachList = new ArrayList<>();

    /**
     *
     */
    private BeachFactory() {
        loadBeach();
    }

    /**
     * @return the singleton instance
     */
    public static BeachFactory getInstance() {
        if (singleton == null) {
            singleton = new BeachFactory();
        }
        return singleton;
    }

    /**
     * @return the list of the beach
     */
    public ArrayList<Beach> getBeachList() {
        return beachList;
    }

    /**
     *
     */
    private void loadBeach() {
        beachList.clear();

        Beach beach1 = new Beach(1, "S'Archittu (spiaggia)", "Cuglieri (OR)", "https://i1.wp.com/sardegnatoujours.com/wp-content/uploads/2018/03/WhatsApp-Image-2019-09-08-at-19.13.492.jpeg?fit=816%2C544");
        beachList.add(beach1);

        Beach beach9 = new Beach(9, "S'Archittu (caletta)", "Cuglieri (OR)", "https://i1.wp.com/sardegnatoujours.com/wp-content/uploads/2018/03/WhatsApp-Image-2019-09-08-at-19.13.492.jpeg?fit=816%2C544");
        beachList.add(beach9);

        Beach beach2 = new Beach(2, "Su Pallosu", "San Vero (OR)", "https://www.gooristano.com/sites/default/files/su_pallosu01.jpg");
        beachList.add(beach2);

        Beach beach3 = new Beach(3, "Sa Rocca Tunda", "San Vero (OR)", "https://i2.wp.com/sardegnatoujours.com/wp-content/uploads/2019/04/WhatsApp-Image-2019-04-18-at-21.53.031.jpeg?resize=616%2C411");
        beachList.add(beach3);

        Beach beach4 = new Beach(4, "Is Arenas", "Narbolia (OR)", "https://www.gelestatic.it/thimg/hDeDq7dxMVT7i_Y089XlJQdUIyI=/960x540/smart/https%3A//www.lanuovasardegna.it/image/contentid/policy%3A1.13816749%3A1571047148/image/image.jpg%3Ff%3Ddetail_558%26h%3D720%26w%3D1280%26%24p%24f%24h%24w%3Dd5eb06a");
        beachList.add(beach4);

        Beach beach5 = new Beach(5, "San Giovanni (lato torre)", "Cabras (OR)", "https://lh3.googleusercontent.com/proxy/h94P-YRFM2YJdn3h8BsX9e4lgJ4i4gvZV7n46hF_ptBB0as0vbPQA0EKmxPj02xW4vfulq28TCF7BuYUZoXcKEI-QI5F089QLDaD");
        beachList.add(beach5);

        Beach beach6 = new Beach(6, "Is Arutas", "Cabras (OR)", "https://www.sardiniapost.it/wp-content/uploads/2014/11/is-aruttas.jpg");
        beachList.add(beach6);

        Beach beach7 = new Beach(7, "Santa Caterina", "Cuglieri (OR)", "https://www.qspiagge.it/media/reviews/photos/original/3e/55/64/spiaggia-santa-caterina-di-pittinuri-58-1448444471.jpg");
        beachList.add(beach7);

        Beach beach8 = new Beach(8, "Torregrande", "Oristano (OR)", "https://lh3.googleusercontent.com/proxy/HHnKqd7gWP_QZbaUk8ndQg5M18Iy5fxZP2vEJadNJDn172VtTTr_uPhidkUf905GMeJsJIYMpEolW3kc8iK4JB95kwlpAohkX5Bv1I0-FeacnT7A-AHvo8E");
        beachList.add(beach8);


    }

}
