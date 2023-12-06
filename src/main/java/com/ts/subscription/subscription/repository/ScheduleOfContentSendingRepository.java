package com.ts.subscription.subscription.repository;

import com.ts.subscription.subscription.data.entity.ScheduleOfContentSending;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleOfContentSendingRepository extends JpaRepository<ScheduleOfContentSending, Integer> {
    
}
