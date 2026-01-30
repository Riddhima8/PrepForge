package com.prep.PrepForge.repository;

import com.prep.PrepForge.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
