//this is rest api controller
// the main task of controller(API layer) is to get request form user and returning response
//Using service class it is delegating the function of fetching allMovies() nad giving it back to the api layer

package dev.aditya.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/movies")           //giving endpoint
public class MovieController {
    @Autowired                              //it will tell the spring to instate this class here for us
    private MovieServices movieServices;
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMoveis()
    {
        return new ResponseEntity<List<Movie>>(movieServices.allMovies(),HttpStatus.OK);
    }


    @GetMapping("/{imdbId}")        //id name need not to b same as original id name in place of imdbId we can use abc that will also work
    public  ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId)        //it tells spring that we will be passing the information we got in mapping as pathVariable
    {
        return new ResponseEntity<Optional<Movie>>(movieServices.singleMovie(imdbId), HttpStatus.OK);
    }



}
