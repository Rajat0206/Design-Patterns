package org.LLD.strategies.time;

import java.time.LocalDateTime;

public class GreaterThanStrategy implements TimeComparisonStrategy {
    @Override
    public Boolean compare(LocalDateTime date1, LocalDateTime date2) {
        return date1.isAfter(date2);
    }
}
