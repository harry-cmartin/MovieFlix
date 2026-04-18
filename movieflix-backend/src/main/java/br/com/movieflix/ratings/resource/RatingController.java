package br.com.movieflix.ratings.resource;

import br.com.movieflix.ratings.domain.Rating;
import br.com.movieflix.ratings.service.RatingService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/ratings")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RatingController {

    @Inject
    RatingService ratingService;

    @POST
    public Response createRating(  Rating rating) {
        Rating created = ratingService.create(rating);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteRating(@PathParam("id") Long id) {
        boolean deleted = ratingService.delete(id);
        if (deleted) {
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}