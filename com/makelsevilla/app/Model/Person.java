package com.makelsevilla.app.Model;

public class Person {
    public String fname, lname;
    public int age;

    public Person(String fname, String lname, int age) {
        this.fname = fname;
        this.lname = lname;
        this.age = age;
    }

    public String getFullName() {
        return (this.fname + " " + this.lname);
    }
}
