package com.aiton.bamin.shenzhouzuche2016_1_26.model.letter_list_city;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class City {

    @Expose
    private List<Hotcity> hotcity = new ArrayList<Hotcity>();
    @Expose
    private List<Allcity> allcity = new ArrayList<Allcity>();

    /**
     * 
     * @return
     *     The hotcity
     */
    public List<Hotcity> getHotcity() {
        return hotcity;
    }

    /**
     * 
     * @param hotcity
     *     The hotcity
     */
    public void setHotcity(List<Hotcity> hotcity) {
        this.hotcity = hotcity;
    }

    /**
     * 
     * @return
     *     The allcity
     */
    public List<Allcity> getAllcity() {
        return allcity;
    }

    /**
     * 
     * @param allcity
     *     The allcity
     */
    public void setAllcity(List<Allcity> allcity) {
        this.allcity = allcity;
    }

}
