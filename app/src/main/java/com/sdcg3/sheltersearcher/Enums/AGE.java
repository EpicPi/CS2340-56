package com.sdcg3.sheltersearcher.Enums;

/**
 * Created by pi on 3/4/18.
 */

public enum AGE {
    NA(""),
    FAMILY_NEWBORN("families"),
    CHILDREN("children"),
    YOUNG_ADULTS("young adults"),
    ANYONE("anyone");

    private final String value;
    AGE(String s){
        value = s;
    }

    @Override
    public String toString() {
        return value;
    }
}
