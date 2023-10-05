package org.launchcode.codingevents.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import jdk.jfr.Timestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Objects;

public class Event {

    private int id;
    private static int nextId = 1;

    @NotBlank(message = "Please enter a valid name.")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters.")
    private String name;

    @Size(max = 500, message = "Description too long.")
    private String description;

    @NotBlank(message = "Please enter a valid email address.")
    @Email(message = "Invalid email. Try again.")
    private String contactEmail;

    @NotBlank(message = "Please enter a valid location.")
    @Size(max = 100, message = "Location name is too long")
    private String location;

    @NotBlank(message = "Please checkmark the box.")
    private String requiredRegistration;

    @Min(value = 1, message = "Please input a number greater than 0.")
    @Max(value = 200, message = "Please keep party attendees to less than 200 due to venue size.")
    private int numberOfAttendees;

    @NotNull(message = "Please select a date for your event.")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    public Event(String name, String description, String contactEmail, String location, String requiredRegistration, int numberOfAttendees, LocalDate startDate) {
        this();
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.location = location;
        this.requiredRegistration = requiredRegistration;
        this.numberOfAttendees = numberOfAttendees;
        this.startDate = startDate;

    }

    public Event(){
        this.id = nextId;
        nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRequiredRegistration() {
        return requiredRegistration;
    }

    public void setRequiredRegistration(String requiredRegistration) {
        this.requiredRegistration = requiredRegistration;
    }

    public int getNumberOfAttendees() {
        return numberOfAttendees;
    }

    public void setNumberOfAttendees(int numberOfAttendees) {
        this.numberOfAttendees = numberOfAttendees;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
