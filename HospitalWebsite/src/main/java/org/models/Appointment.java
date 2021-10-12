package org.models;

public class Appointment {
    private Long id;
    private Registration registration;
    private String description;

    private enum Status {ATTENDED, NOT_ATTENDED, SICK, HEALTHY}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
