package dev.aditya.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews")
@Data                               //takes care of all the gatters and setters function
@AllArgsConstructor                 //for creating a constructor which takes all these private fields as argument
@NoArgsConstructor                  //another constructor that doesnot take any parameter
public class Review {
    @Id
    private ObjectId id;
    private String body;

    // as ids are auto generated we cannot pass id to this clas

    public Review(String body) {
        this.body = body;
    }
}
