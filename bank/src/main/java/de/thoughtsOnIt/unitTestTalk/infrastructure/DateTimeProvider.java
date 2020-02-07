package de.thoughtsOnIt.unitTestTalk.infrastructure;

import java.time.LocalDateTime;

public class DateTimeProvider {

    static private LocalDateTime stubLocalDateTime;

    public static LocalDateTime now(){

        if(DateTimeProvider.stubLocalDateTime != null){
            return DateTimeProvider.stubLocalDateTime;
        }

        return LocalDateTime.now();
    }

    /**
     * Beware of shared State Corruption!
     * @param stubLocalDateTime
     */
    public static void setStubLocalDateTime(LocalDateTime stubLocalDateTime) {
        DateTimeProvider.stubLocalDateTime = stubLocalDateTime;
    }

    public static void resetStubLocalDateTime() {
        DateTimeProvider.stubLocalDateTime = null;
    }
}
