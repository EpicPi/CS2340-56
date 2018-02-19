package com.sdcg3.sheltersearcher.model;

/**
 * Created by aballari on 2/19/18.
 */

import java.io.Serializable;

public enum AccountType implements Serializable {
    US ("USER", "US"),
    AD ("ADMIN", "AD");


    /** the full string representation of the class standing name */
    private final String name;

    /** the representation of the class standing name abbreviation - always 2 characters */
    private final String code;

    /**
     * Constructor for the enumeration
     *
     * @param pname   full name of the class standing
     * @param pcode   letter code / abbreviation for the class standing
     */
    AccountType(String pname, String pcode) {
        name = pname;
        code = pcode;
    }

    /**
     *
     * @return   the full class standing name
     */
    public String getName() { return name; }


    /**
     *
     * @return the abbreviation for the class standing
     */
    public String getCode() { return code; }

    /**
     *
     * @return the display string representation of the class standing
     */
    public String toString() { return code; }
}

