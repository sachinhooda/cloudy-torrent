package com.sachin.cloudy.data.audit;

import com.sachin.cloudy.data.entities.User;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Service;

/**
 * Created by sachinhooda on 19/9/17.
 */

public interface CloudyDataAuditAware extends AuditorAware<User> {
}
