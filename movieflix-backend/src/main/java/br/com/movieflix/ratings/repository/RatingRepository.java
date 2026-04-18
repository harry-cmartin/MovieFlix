package br.com.movieflix.ratings.repository;


import br.com.movieflix.ratings.domain.Rating;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RatingRepository implements PanacheRepository<Rating> {
}
