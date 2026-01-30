package com.prep.PrepForge.controller;

import com.prep.PrepForge.dto.SubmissionRequest;
import com.prep.PrepForge.service.SubmissionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/submissions")
public class SubmissionController {

    private final SubmissionService service;

    public SubmissionController(SubmissionService service) {
        this.service = service;
    }

    @PostMapping("/{userId}")
    public void submit(@PathVariable Long userId,
                       @RequestBody SubmissionRequest req) {
        service.submit(req, userId);
    }

    @GetMapping("/stats/{userId}")
    public List<Object[]> stats(@PathVariable Long userId) {
        return service.stats(userId);
    }
}
