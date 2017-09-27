package com.sachin.cloudy.services.audit;

import com.sachin.cloudy.common.logger.InjectLogger;
import com.sachin.cloudy.data.audit.CloudyDataAuditAware;
import com.sachin.cloudy.data.entities.User;
import com.sachin.cloudy.services.exception.CloudyServiceException;
import com.sachin.cloudy.services.services.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


/**
 * Created by sachinhooda on 19/9/17.
 */
@Service
public class CloudyDataAuditAwareImpl implements AuditorAware<User> {

    @InjectLogger
    Logger logger;

    @Autowired
    private UserService userService;

    @Override
    public User getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()
                && !"anonymousUser".equals(authentication.getName())) {
            try {
                return this.userService.getUserByEmailId(authentication.getName());
            } catch (CloudyServiceException cse) {
                this.logger.error(cse.getMessage(), cse);
                return null;
            }
        } else {
            return null;
        }
    }
}
