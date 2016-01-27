package com.aiton.bamin.shenzhouzuche2016_1_26.model;

import java.io.Serializable;

/**
 * Created by zjb on 2016/1/26.
 */
public class CarInfo implements Serializable
{
    private int carImgID;
    private String carName;
    private int carPrice;

    public CarInfo(int carImgID, String carName, int carPrice) {
        this.carImgID = carImgID;
        this.carName = carName;
        this.carPrice = carPrice;
    }

    public int getCarImgID() {
        return carImgID;
    }

    public void setCarImgID(int carImgID) {
        this.carImgID = carImgID;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(int carPrice) {
        this.carPrice = carPrice;
    }
}
