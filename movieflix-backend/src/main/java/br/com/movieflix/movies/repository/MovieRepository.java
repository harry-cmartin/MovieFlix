package br.com.movieflix.movies.repository;


import br.com.movieflix.movies.domain.Movie;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MovieRepository implements PanacheRepository<Movie> {
}
