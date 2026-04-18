package br.com.movieflix.movies.resource;

import br.com.movieflix.movies.domain.Movie;
import br.com.movieflix.movies.service.MovieService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/movies")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MovieController {

    @Inject
    MovieService movieService;

    @POST
    public Response createMovie(Movie movie) {
        Movie created = movieService.create(movie);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteMovie(@PathParam("id") Long id) {
        boolean deleted = movieService.delete(id);
        if (deleted) {
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    //retorna todos os filmes
    public Response getMovies( ){

        Response movies = movieService.findAll();
        return movies;

    }


}