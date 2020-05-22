package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.Objects;

public class TimeEntry {

    private Long id;
    private Long projectId;
    private Long userId;
    private LocalDate date;
    private Integer hours;

    public TimeEntry(Long projectId, Long userId, LocalDate date, Integer hours) {
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }

    public TimeEntry(Long id, Long projectId, Long userId, LocalDate date, Integer hours) {
        this.id = id;
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }

    public TimeEntry() {

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "TimeEntry{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", userId=" + userId +
                ", date=" + date +
                ", hours=" + hours +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeEntry timeEntry = (TimeEntry) o;
        return id.equals(timeEntry.id) &&
                projectId.equals(timeEntry.projectId) &&
                userId.equals(timeEntry.userId) &&
                Objects.equals(date, timeEntry.date) &&
                Objects.equals(hours, timeEntry.hours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
