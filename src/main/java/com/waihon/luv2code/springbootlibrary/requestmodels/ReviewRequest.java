package com.waihon.luv2code.springbootlibrary.requestmodels;

import lombok.Data;

import java.util.Optional;

@Data
public class ReviewRequest {

    private double rating;

    private Long bookId;

    // Review description is not required when leaving a review for a book.
    private Optional<String> reviewDescription;
}
