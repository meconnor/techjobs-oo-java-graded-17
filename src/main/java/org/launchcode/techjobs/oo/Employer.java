package org.launchcode.techjobs.oo;

public class Employer extends JobField {

    public Employer(String value) {
        super(value);
    }

    @Override
    public String toString() {
        return (getValue().isEmpty() ? "Data not available" : getValue());
    }
}
