package org.LLD.strategies.time;

import java.time.LocalDateTime;

public interface TimeComparisonStrategy {
    Boolean compare(LocalDateTime date1, LocalDateTime date2);
}
