/*
 * Team NRT
 * Niels Delestinne
 * Robrecht Conjaerts
 * Tom Jaspers
 */
package namedqueries;

/**
 *
 * @author Niels
 */

public class event {
    
    public static final String LIVE_DATA_BY_ACCOUNT_AND_LAST_TIMESTAMP = 
            "SELECT e FROM EventVideo e "
            + "WHERE e.accountId = :accountId "
            + "AND e.timestamp > :timestamp";
    
}
