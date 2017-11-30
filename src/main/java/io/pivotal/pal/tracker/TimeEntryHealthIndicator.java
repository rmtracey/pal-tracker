package io.pivotal.pal.tracker;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TimeEntryHealthIndicator implements HealthIndicator {
    TimeEntryRepository timeEntryRepository;

    public TimeEntryHealthIndicator (TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @Override
    public Health health() {
        List<TimeEntry> timeEntryList = timeEntryRepository.list();
        if (timeEntryList.size() < 5) {
            return Health.up().build();
        }
        return Health.down().build();
    }
}
