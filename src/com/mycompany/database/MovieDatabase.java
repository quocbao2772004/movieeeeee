package com.mycompany.database;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

public class MovieDatabase {
    private final MongoCollection<Document> collection;

    public MovieDatabase() {
        MongoDatabase database = ConnectionManager.getDatabase();
        collection = database.getCollection("movies");
    }

    public void addMovie(String title, String cinema, String showTime, String showHour, String showDate, String genre, String imagePath, String director, String description, int duration, String releaseDate, String mainActors) {
        Document movie = new Document("title", title)
                            .append("cinema", cinema)
                            .append("showTime", showTime)
                            .append("showHour", showHour)
                            .append("showDate", showDate)
                            .append("genre", genre)
                            .append("imagePath", imagePath)
                            .append("director", director)
                            .append("description", description)
                            .append("duration", duration)
                            .append("releaseDate", releaseDate)
                            .append("mainActors", mainActors);
        collection.insertOne(movie);
    }

    public void updateMovie(String title, String newCinema, String newShowTime, String newShowHour, String newShowDate, String newGenre, String newImagePath, String newDirector, String newDescription, int newDuration, String newReleaseDate, String newMainActors) {
        Document query = new Document("title", title);
        Document update = new Document("$set", new Document("cinema", newCinema)
                                                .append("showTime", newShowTime)
                                                .append("showHour", newShowHour)
                                                .append("showDate", newShowDate)
                                                .append("genre", newGenre)
                                                .append("imagePath", newImagePath)
                                                .append("director", newDirector)
                                                .append("description", newDescription)
                                                .append("duration", newDuration)
                                                .append("releaseDate", newReleaseDate)
                                                .append("mainActors", newMainActors));
        collection.updateOne(query, update);
    }

    public void deleteMovie(String title) {
        Document query = new Document("title", title);
        collection.deleteOne(query);
    }

    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        try (MongoCursor<Document> cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                Movie movie = new Movie(
                    doc.getString("title"),
                    doc.getString("cinema"),
                    doc.getString("showTime"),
                    doc.getString("showHour"),
                    doc.getString("showDate"),
                    doc.getString("genre"),
                    doc.getString("imagePath"),
                    doc.getString("director"),
                    doc.getString("description"),
                    doc.getInteger("duration"),
                    doc.getString("releaseDate"),
                    doc.getString("mainActors")
                );
                movies.add(movie);
            }
        }
        return movies;
    }
}