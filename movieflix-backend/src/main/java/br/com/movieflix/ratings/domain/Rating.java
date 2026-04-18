package br.com.movieflix.ratings.domain;

import br.com.movieflix.movies.domain.Movie;
import br.com.movieflix.users.domain.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ratings")
public class Rating {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ratingId") // ou "rating_id" conforme o comando SQL que você rodar
    private Long id;

    @Column(name = "userid")
    private int userid;

    @Column(name = "movieid")
    private int movieid;

    @Column(name = "rating")
    private float rating;


    @Column(name = "timestamp")
    private long date;

    @PrePersist
    public void prePersist() {
        setDate(LocalDateTime.now().toEpochSecond(java.time.ZoneOffset.UTC));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getMovieid() {
        return movieid;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
}
