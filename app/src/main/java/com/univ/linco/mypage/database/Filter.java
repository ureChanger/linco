package com.univ.linco.mypage.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Filter {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private boolean camping = true;
    private boolean beauty = true;
    private boolean wealth = true;
    private boolean sports = true;
    private boolean interior = true;
    private boolean kids = true;
    private boolean device = true;
    private boolean book = true;
    private boolean fashion = true;

    public Filter(boolean camping, boolean beauty, boolean wealth, boolean sports, boolean interior,
                  boolean kids, boolean device, boolean book, boolean fashion) {
        this.id = id;
        this.camping = camping;
        this.beauty = beauty;
        this.wealth = wealth;
        this.sports = sports;
        this.interior = interior;
        this.kids = kids;
        this.device = device;
        this.book = book;
        this.fashion = fashion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCamping() {
        return camping;
    }

    public void setCamping(boolean camping) {
        this.camping = camping;
    }

    public boolean isBeauty() {
        return beauty;
    }

    public void setBeauty(boolean beauty) {
        this.beauty = beauty;
    }

    public boolean isWealth() {
        return wealth;
    }

    public void setWealth(boolean wealth) {
        this.wealth = wealth;
    }

    public boolean isSports() {
        return sports;
    }

    public void setSports(boolean sports) {
        this.sports = sports;
    }

    public boolean isInterior() {
        return interior;
    }

    public void setInterior(boolean interior) {
        this.interior = interior;
    }

    public boolean isKids() {
        return kids;
    }

    public void setKids(boolean kids) {
        this.kids = kids;
    }

    public boolean isDevice() {
        return device;
    }

    public void setDevice(boolean device) {
        this.device = device;
    }

    public boolean isBook() {
        return book;
    }

    public void setBook(boolean book) {
        this.book = book;
    }

    public boolean isFashion() {
        return fashion;
    }

    public void setFashion(boolean fashion) {
        this.fashion = fashion;
    }

    @Override
    public String toString() {
        return "Filter{" +
                "id=" + id +
                ", camping=" + camping +
                ", beauty=" + beauty +
                ", wealth=" + wealth +
                ", sports=" + sports +
                ", interior=" + interior +
                ", kids=" + kids +
                ", device=" + device +
                ", book=" + book +
                ", fashion=" + fashion +
                '}';
    }


}
