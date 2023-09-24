// we will write database access methods in this class
// it uses repository class and talks to the database fetch the list of the movie and returns to api layer
package dev.aditya.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServices {
    @Autowired //first we have to initialise the instance of MovieRepository class using constructor or use @Autowired  it will tell the spring to instate this class here for us
    private MovieRepository movieRepository;

    public List<Movie> allMovies() {
        return movieRepository.findAll();   //predefined in MongoRepository which return list data type that we have passed in the class ex MongoRepository<Movie, ObjectId> here list of movies
    }
// here we are passing id thru URI but if we dont wanna do that then we have to add custome mathod in MovieRepository
//    public Optional<Movie> singleMovie(ObjectId id)
//    {
//        return movieRepository.findById(id);
//    }
// we dont wnat to expose ObjectId of our collection to the Public
    public Optional<Movie> singleMovie(String imdbId)
    {
        return movieRepository.findMovieByImdbId(imdbId);         //as defined in MoveRepository
    }
}
