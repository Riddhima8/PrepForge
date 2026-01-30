package com.prep.PrepForge.repository;

import com.prep.PrepForge.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {

    @Query("""
        SELECT s.status, COUNT(s)
        FROM Submission s
        WHERE s.user.id = :userId
        GROUP BY s.status
    """)
    List<Object[]> submissionStats(@Param("userId") Long userId);
}
