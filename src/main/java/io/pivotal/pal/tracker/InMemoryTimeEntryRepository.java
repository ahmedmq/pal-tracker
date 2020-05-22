package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    Map<Long, TimeEntry> repository = new HashMap<>();

    @Override
    public TimeEntry create(TimeEntry timeEntry) {

        timeEntry.setId(repository.size() + 1L);

        return repository.put(timeEntry.getId(), timeEntry);
    }

    @Override
    public TimeEntry find(Long timeEntryId) {
        return repository.get(timeEntryId);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(repository.values());
    }

    @Override
    public TimeEntry update(Long id, TimeEntry timeEntry) {
        return repository.put(id, timeEntry);
    }

    @Override
    public void delete(Long timeEntryId) {
        repository.remove(timeEntryId);
    }
}
