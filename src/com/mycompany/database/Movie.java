package com.mycompany.database;

import java.util.List;

public class Movie {
    private String id;
    private String title;
    private List<Cinema> cinemas;
    private List<String> showDates;
    private String genre;
    private String imagePath;
    private String director;
    private String description;
    private int duration;
    private String releaseDate;
    private String mainActors;

    public Movie(String id, String title, List<Cinema> cinemas, List<String> showDates, String genre, String imagePath, String director, String description, int duration, String releaseDate, String mainActors) {
        this.id = id;
        this.title = title;
        this.cinemas = cinemas;
        this.showDates = showDates;
        this.genre = genre;
        this.imagePath = imagePath;
        this.director = director;
        this.description = description;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.mainActors = mainActors;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public List<Cinema> getCinemas() { return cinemas; }
    public List<String> getShowDates() { return showDates; }
    public String getGenre() { return genre; }
    public String getImagePath() { return imagePath; }
    public String getDirector() { return director; }
    public String getDescription() { return description; }
    public int getDuration() { return duration; }
    public String getReleaseDate() { return releaseDate; }
    public String getMainActors() { return mainActors; }
}