package com.sdcg3.sheltersearcher.Enums;

import java.io.Serializable;
/**
 * Represents an account type
 */

public enum AccountType implements Serializable {
    US ("USER"),
    AD ("ADMIN");


    /** the representation of the account type abbreviation - always 2 characters */
    private final String code;

    /**
     * Constructor for the enumeration
     *
     * @param name   full name of the account type
     * @param code   letter code / abbreviation for the account type
     */
    AccountType( String code) {
        /* the full string representation of the account type */
//        String name1 = name;
        this. code = code;
    }
// --Commented out by Inspection START (4/4/18 10:06 PM):
//    /**
//     * Returns full account type name
//     * @return   the full account type name
//     */
//    public String getName() { return name; }
// --Commented out by Inspection STOP (4/4/18 10:06 PM)


// --Commented out by Inspection START (4/4/18 10:06 PM):
//    /**
//     * Returns abbrev
//     * @return the abbreviation for the account type
//     */
//    public String getCode() { return code; }
// --Commented out by Inspection STOP (4/4/18 10:06 PM)

    /**
     * Returns display string rep
     * @return the display string representation of the account type
     */
    public String toString() { return code; }
}

