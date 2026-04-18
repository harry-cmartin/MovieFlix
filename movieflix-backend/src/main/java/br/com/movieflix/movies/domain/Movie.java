package br.com.movieflix.movies.domain;


import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_seq")
    @SequenceGenerator(
            name = "movie_seq",
            sequenceName = "movie_sequence",
            initialValue = 193610, // O próximo valor após o seu maior ID
            allocationSize = 1
    )
    @Column(name = "movieId")
    private Long movieId;

    @Column(name = "title")
    private String title;

    @Column(name = "genre")
    private String genres;


    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }
}
