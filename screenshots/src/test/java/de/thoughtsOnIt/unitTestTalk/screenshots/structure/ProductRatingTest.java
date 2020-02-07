package de.thoughtsOnIt.unitTestTalk.screenshots.structure;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProductRatingTest {

    @Test
    public void whenAProductIsRated_WithLessThanThreeStars_TheRatingIsNotPublished(){
        //Setup
        String productId= UUID.randomUUID().toString();
        int rating = 0;

        //Execution
        ProductRating productRating = new ProductRating(productId, rating);

        //Validation
        assertFalse(productRating.isPublished());
    }

    @Test
    public void whenAProductIsRated_WithAtLeastThreeStars_TheRatingIsAutomaticallyPublished(){
        String productId= UUID.randomUUID().toString();
        int rating = 3;

        ProductRating productRating = new ProductRating(productId, rating);

        assertTrue(productRating.isPublished());
    }
}
