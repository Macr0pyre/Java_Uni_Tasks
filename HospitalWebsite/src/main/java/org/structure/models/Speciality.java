package org.structure.models;

public enum Speciality {
    THERAPIST("therapist"), OPHTHALMOLOGIST("ophthalmologist"), PSYCHIATRIST("psychiatrist"),
    DERMATOLOGIST("dermatologist"), ONCOLOGIST("oncologist"), NEUROLOGIST("neurologist"),
    GYNECOLOGIST("gynecologist"), UROLOGIST("urologist"), CARDIOLOGIST("cardiologist");

    private final String speciality;

    Speciality(String speciality) {
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }
}