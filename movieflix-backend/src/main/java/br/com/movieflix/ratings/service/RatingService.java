package br.com.movieflix.ratings.service;

import br.com.movieflix.ratings.domain.Rating;
import br.com.movieflix.ratings.repository.RatingRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class RatingService {

    @Inject
    RatingRepository ratingRepository;

    @Transactional
    public Rating create(Rating rating) {
        ratingRepository.persist(rating);
        return rating;
    }

    @Transactional
    public boolean delete(Long id) {
        return ratingRepository.deleteById(id);
    }
}