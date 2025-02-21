package com.springdocker.review.service;

import java.util.List;

import com.springdocker.review.data.Review;

public interface ReviewService {
    List<Review> getAllReviewsByCompany(Long companyId);

    boolean addReview(Long companyId, Review review);

    Review findReview(Long reviewId);

    boolean deleteReview(Long reviewId);

    boolean updateReview(Long reviewId, Review review_updated);
}
