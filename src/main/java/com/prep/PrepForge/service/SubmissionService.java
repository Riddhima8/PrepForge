package com.prep.PrepForge.service;

import com.prep.PrepForge.dto.SubmissionRequest;
import com.prep.PrepForge.entity.Submission;
import com.prep.PrepForge.repository.QuestionRepository;
import com.prep.PrepForge.repository.SubmissionRepository;
import com.prep.PrepForge.repository.UserRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmissionService {

    private final SubmissionRepository submissionRepo;
    private final UserRepository userRepo;
    private final QuestionRepository questionRepo;

    public SubmissionService(SubmissionRepository submissionRepo,
                             UserRepository userRepo,
                             QuestionRepository questionRepo) {
        this.submissionRepo = submissionRepo;
        this.userRepo = userRepo;
        this.questionRepo = questionRepo;
    }

    @Async
    public void submit(SubmissionRequest req, Long userId) {
        Submission submission = new Submission();
        submission.setUser(userRepo.findById(userId).orElseThrow());
        submission.setQuestion(
                questionRepo.findById(req.getQuestionId()).orElseThrow()
        );
        submission.setStatus(req.getStatus());
        submission.setRuntime(req.getRuntime());

        submissionRepo.save(submission);
    }

    // ✅ THIS METHOD WAS MISSING / MISMATCHED
    public List<Object[]> stats(Long userId) {
        return submissionRepo.submissionStats(userId);
    }
}
