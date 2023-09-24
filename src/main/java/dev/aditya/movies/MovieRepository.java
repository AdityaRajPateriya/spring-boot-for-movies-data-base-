//repository layer is kind of data excess layer for our api it does the job of actually taking to the database  and getting the data back
package dev.aditya.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    Optional<Movie> findMovieByImdbId(String imdbId);
//this is a dynamic query we can define such for any property name in model class as long as they are unique
}