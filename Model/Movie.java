package Model;

public class Movie {
    int movieId;
    String name;
    String description;

    public Movie(int movieId, String name, String description) {
        this.movieId = movieId;
        this.name = name;
        this.description = description;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
