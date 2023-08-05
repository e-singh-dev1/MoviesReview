package dev.eshan.hustler.MoviesReview;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/api/v1/movie-list")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movie>> GetAllMovies()// Http Get endpoint which will return all movies from mongoDb
    {
        return  new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Optional<Movie>> GetSingleMovie(@PathVariable String id)
    {
        return  new ResponseEntity<Optional<Movie>>(movieService.singleMovie(id),HttpStatusCode.valueOf(200));
    }
}
