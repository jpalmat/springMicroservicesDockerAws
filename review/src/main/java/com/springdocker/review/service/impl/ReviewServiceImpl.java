package com.springdocker.review.service.impl;

import java.util.List;

import com.springdocker.review.data.Review;
import com.springdocker.review.data.ReviewRepository;
import com.springdocker.review.service.ReviewService;

import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviewsByCompany(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        if (companyId != null && review != null) {
            review.setCompanyId(companyId);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review findReview(Long reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }

    @Override
    public boolean deleteReview(Long reviewId) {
        try {
            Review review = reviewRepository.findById(reviewId).orElse(null);
            if (review != null) {
                reviewRepository.delete(review);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateReview(Long reviewId, Review review_updated) {

        Review review = reviewRepository.findById(reviewId).orElse(null);
        if (review != null) {
            review.setTitle(review_updated.getTitle());
            review.setDescription(review_updated.getDescription());
            review.setRating(review_updated.getRating());
            review.setCompanyId(review_updated.getCompanyId());
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

}
