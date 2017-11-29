package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    Map<Long, TimeEntry> timeEntryMap = new HashMap<Long, TimeEntry>();
    Long maxId = 0L;

    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(++maxId);
        timeEntryMap.put(timeEntry.getId(), timeEntry);
        return timeEntry;
    }

    public TimeEntry find(Long id) {
        return timeEntryMap.get(id);
    }

    public List<TimeEntry> list() {
        List<TimeEntry> listToReturn = new ArrayList<TimeEntry>();
        for (Long i = 1L; i <= timeEntryMap.size(); i++) {
            listToReturn.add(timeEntryMap.get(i));
        }
        return listToReturn;
    }

    public TimeEntry update(Long id, TimeEntry timeEntry) {
        timeEntry.setId(id);
        timeEntryMap.replace(id, timeEntry);
        return timeEntryMap.get(id);
    }

    public void delete(Long id) {
        timeEntryMap.remove(id);
    }
}
