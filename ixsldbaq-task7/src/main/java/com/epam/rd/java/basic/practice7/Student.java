package com.epam.rd.java.basic.practice7;

public class Student {
    private int id;
    private String firstName;
    private String secondName;
    private String initials;
    private int age;
    private int group;
    private String city;

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getInitials() {
        return initials;
    }

    public int getAge() {
        return age;
    }

    public int getGroup() {
        return group;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", initials='" + initials + '\'' +
                ", age=" + age +
                ", group=" + group +
                ", city='" + city + '\'' +
                '}';
    }
}
