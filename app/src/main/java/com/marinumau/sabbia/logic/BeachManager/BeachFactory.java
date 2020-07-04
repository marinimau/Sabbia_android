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
    private BeachFactory(){
        loadBeach();
    }

    /**
     *
     * @return the singleton instance
     */
    public static BeachFactory getInstance(){
        if (singleton == null) {
            singleton = new BeachFactory();
        }
        return singleton;
    }

    /**
     *
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

        Beach beach1 = new Beach(1, "S'archittu", "Cuglieri (OR)");
        beachList.add(beach1);

        Beach beach2 = new Beach(2, "Su Pallosu", "San Vero (OR)");
        beachList.add(beach2);

        Beach beach3 = new Beach(3, "Sa Rocca Tunda", "San Vero (OR)");
        beachList.add(beach3);

        Beach beach4 = new Beach(4, "Is arenas", "Narbolia (OR)");
        beachList.add(beach4);

        Beach beach5 = new Beach(5, "San Giovanni", "Cabras (OR)");
        beachList.add(beach5);

        Beach beach6 = new Beach(6, "Is Aruttas", "Cabras (OR)");
        beachList.add(beach6);

        Beach beach7 = new Beach(7, "Santa Caterina", "Cuglieri (OR)");
        beachList.add(beach7);

        Beach beach8 = new Beach(8, "Torregrande", "Oristano (OR)");
        beachList.add(beach8);

        Beach beach9 = new Beach(9, "Abbarossa", "Santa Giusta (OR)");
        beachList.add(beach9);
    }

}
