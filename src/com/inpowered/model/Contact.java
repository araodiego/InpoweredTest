package com.inpowered.model;

import java.time.LocalDate;
import java.util.Objects;

public class Contact {
    private String name;
    private Gender gender;
    private LocalDate birthDate;

    public Contact (String name, Gender gender, LocalDate birthDate){
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return Objects.equals(getName(), contact.getName()) && getGender() == contact.getGender() && Objects.equals(getBirthDate(), contact.getBirthDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getGender(), getBirthDate());
    }
}
