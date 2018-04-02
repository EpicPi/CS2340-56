package com.sdcg3.sheltersearcher.Enums;

import java.io.Serializable;
/**
 * Represents an account type
 */

public enum AccountType implements Serializable {
    US ("US","USER"),
    AD ("AD","ADMIN");


    /** the full string representation of the account type */
    private final String name;

    /** the representation of the account type abbreviation - always 2 characters */
    private final String code;

    /**
     * Constructor for the enumeration
     *
     * @param name   full name of the account type
     * @param code   letter code / abbreviation for the account type
     */
    AccountType(String name, String code) {
        this. name = name;
        this. code = code;
    }
    /**
     * Returns full account type name
     * @return   the full account type name
     */
    public String getName() { return name; }


    /**
     * Returns abbrev
     * @return the abbreviation for the account type
     */
    public String getCode() { return code; }

    /**
     * Returns display string rep
     * @return the display string representation of the account type
     */
    public String toString() { return code; }
}

