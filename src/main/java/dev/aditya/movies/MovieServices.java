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
        return  movieRepository.findAll();   //predefined in MongoRepository which return list data type that we have passed in the class ex MongoRepository<Movie, ObjectId> here list of movies
    }
    public Optional<Movie> singleMovie(ObjectId id)
    {
        return movieRepository.findById(id);
    }
}
