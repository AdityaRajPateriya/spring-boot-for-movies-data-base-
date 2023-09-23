package dev.aditya.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies")
@Data                       //takes care of all getters and setters method
@AllArgsConstructor         //for creating a constructor that take all these private fields as arguments
@NoArgsConstructor          // another constructor that does not take any parameter
public class Movie {
    @Id                     // this will let framework know that this variable shoud be treated as uniqueId for each movie inside DB
    private  ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String treailerLink;
    private String poster;
    private List<String> genres;
    private List<String>  backdrop;
    @DocumentReference              //it will only store IDs of reviews in database while reviews will be stored separate collection
                                    //this is know as manual reference relationship
    private List<Review> reviewIds;
}
