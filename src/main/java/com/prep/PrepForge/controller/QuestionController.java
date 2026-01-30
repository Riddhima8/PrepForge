package com.prep.PrepForge.controller;

import com.prep.PrepForge.entity.Question;
import com.prep.PrepForge.repository.QuestionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    private final QuestionRepository repo;

    public QuestionController(QuestionRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public Page<Question> getAll(@RequestParam int page,
                                 @RequestParam int size) {
        return repo.findAll(PageRequest.of(page, size));
    }
}
