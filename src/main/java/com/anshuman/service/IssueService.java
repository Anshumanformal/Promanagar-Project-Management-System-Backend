package com.anshuman.service;

import com.anshuman.model.Issue;
import com.anshuman.model.User;
import com.anshuman.request.IssueRequest;

import java.util.List;

public interface IssueService {

    Issue getIssueById(Long issueId) throws Exception;
    List<Issue> getIssueByProjectId(Long projectId) throws Exception;
    Issue createIssue(IssueRequest issueRequest, User user) throws Exception;
    void deleteIssue(Long issueId, Long userId) throws Exception;

    Issue addUserToIssue(Long issueId, Long userId) throws Exception;
    Issue updateStatus(Long issueId, String status) throws Exception;

}
