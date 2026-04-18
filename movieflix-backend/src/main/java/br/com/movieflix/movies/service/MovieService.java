package br.com.movieflix.movies.service;

import br.com.movieflix.movies.domain.Movie;
import br.com.movieflix.movies.repository.MovieRepository;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class MovieService {

    @Inject
    MovieRepository movieRepository;

    @Transactional
    public Movie create(Movie movie) {
        movieRepository.persist(movie);
        return movie;
    }

    @Transactional
    public boolean delete(Long id) {
        return movieRepository.deleteById(id);
    }


    public Response findAll() {

        PanacheQuery<Movie> movies = movieRepository.findAll();
        return Response.ok(movies.list()).build();

    }

}