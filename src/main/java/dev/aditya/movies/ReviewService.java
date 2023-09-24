package dev.aditya.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    //we can create dynamic templates to execute complex queries which is not possible with inbuilt method
    @Autowired
    private MongoTemplate mongoTemplate;

    public  Review createReview(String reviewBody, String imdbId)
    {
        Review review=reviewRepository.insert(new Review(reviewBody));   // insert returns the data you just entered
        mongoTemplate.update(Movie.class).matching(Criteria.where("imdbId").is(imdbId)).apply(new Update().push("reviewIds").value(review)).first();
        // update call on Movie class by matching the imdbId then we apply this we created a new Update() definition. .first() ensures that we are only updating single movie
        return review;
    }
}
