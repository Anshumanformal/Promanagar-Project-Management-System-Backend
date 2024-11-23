package com.anshuman.service;

import com.anshuman.model.PlanType;
import com.anshuman.model.Subscription;
import com.anshuman.model.User;

public interface SubscriptionService {
    void createSubScription(User user) throws Exception;
    Subscription getUsersSubscription(Long userId) throws Exception;
    Subscription upgradeSubscription(Long userId, PlanType planType) throws Exception;
    boolean isValid(Subscription subscription);
}
