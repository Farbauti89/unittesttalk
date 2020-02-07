package de.thoughtsOnIt.unitTestTalk.screenshots.structure;

public class ProductRating {

    private String productId;
    private int rating;
    private boolean published;

    public ProductRating(String productId, int rating) {
        productId = productId;
        rating = rating;
        if (rating >= 3) {
            published = true;
        }
    }

    public String getProductId() {
        return productId;
    }

    public int getRating() {
        return rating;
    }

    public boolean isPublished() {
        return published;
    }
}
