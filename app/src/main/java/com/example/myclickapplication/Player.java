package com.example.myclickapplication;

public class Player {

    private String name, nationality, club;
    private Integer rating, age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getRating() {
        return String.valueOf(rating);
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getAge() {
        return String.valueOf(age);
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

