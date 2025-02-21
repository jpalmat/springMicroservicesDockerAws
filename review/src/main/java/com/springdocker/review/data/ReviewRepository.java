package com.springdocker.review.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByCompanyId(Long companyId);

    @Query("SELECT r FROM Review r WHERE r.company.id = ?1 AND r.id = ?2")
    Review findReviewByCompanyIdAndReviewId(Long companyId, Long reviewId);

}
