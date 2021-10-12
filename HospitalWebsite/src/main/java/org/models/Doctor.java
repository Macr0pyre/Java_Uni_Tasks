package org.models;

public class Doctor {
    private Long id;
    private String name;
    private String number;
    private String email;
    private String login;
    private String password;

    private enum Speciality {
        THERAPIST, OPHTHALMOLOGIST, PSYCHIATRIST, DERMATOLOGIST, ONCOLOGIST,
        NEUROLOGIST, GYNECOLOGIST, UROLOGIST, CARDIOLOGIST
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}