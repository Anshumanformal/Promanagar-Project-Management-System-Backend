package com.anshuman.repository;

import com.anshuman.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByIssueId(Long issueId);

}
