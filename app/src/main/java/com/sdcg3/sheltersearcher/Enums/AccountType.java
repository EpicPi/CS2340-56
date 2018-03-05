package com.sdcg3.sheltersearcher.Enums;

/**
 * Created by aballari on 2/19/18.
 */

import java.io.Serializable;

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
     * @param pname   full name of the account type
     * @param pcode   letter code / abbreviation for the account type
     */
    AccountType(String pname, String pcode) {
        name = pname;
        code = pcode;
    }

    /**
     *
     * @return   the full account type name
     */
    public String getName() { return name; }


    /**
     *
     * @return the abbreviation for the account type
     */
    public String getCode() { return code; }

    /**
     *
     * @return the display string representation of the account type
     */
    public String toString() { return code; }
}

