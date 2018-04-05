package com.sdcg3.sheltersearcher.Enums;

/**
 * Created by pi on 3/4/18.
 * GENDER ENUM
 */

@SuppressWarnings("unused")
public enum GENDER {
    NA(""),MALE("men"),FEMALE("women");

    private final String value;

    GENDER(String s){
        value = s;
    }

    @Override
    public String toString() {
        return value;
    }
}
