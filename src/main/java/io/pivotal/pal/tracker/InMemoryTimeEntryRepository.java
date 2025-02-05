package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    Map<Long, TimeEntry> repository = new HashMap<>();
    private final AtomicLong count = new AtomicLong(0);

    @Override
    public TimeEntry create(TimeEntry timeEntry) {

        timeEntry.setId(count.incrementAndGet());

        repository.put(timeEntry.getId(), timeEntry);
        return timeEntry;
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
         TimeEntry nullEntry = repository.replace(id, timeEntry);
         if (nullEntry == null) return nullEntry;
         timeEntry.setId(id);
         return timeEntry;

    }

    @Override
    public void delete(Long timeEntryId) {
        repository.remove(timeEntryId);
    }
}
