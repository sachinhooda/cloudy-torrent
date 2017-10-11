package com.sachin.cloudy.services.services.impl;

import com.sachin.cloudy.common.logger.InjectLogger;
import com.sachin.cloudy.services.constants.ServiceConstants;
import com.sachin.cloudy.services.exception.CloudyServiceException;
import com.sachin.cloudy.services.services.TemplatingService;
import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sachinhooda on 4/10/17.
 */
@Service
public class TemplatingServiceImpl implements TemplatingService {

    private static final Character TEMPLATE_PATH_BUILDER = '/';
    private static final String TEMPLATE_FILE_EXTENSION = ".ftl";

    @Autowired
    FreeMarkerConfigurer freeMarkerConfigurer;

    @InjectLogger
    private Logger logger;

    @Override
    public String resolveTemplate(Map<String, String> data,
                                  ServiceConstants.NotificationTargetType notificationTargetType,
                                  ServiceConstants.NotificationTemplate notificationTemplate) throws CloudyServiceException {

        Map<String, Object> convertedMap = new HashMap<>(data);
        String body = null;

        try {
            body = FreeMarkerTemplateUtils.processTemplateIntoString(freeMarkerConfigurer.getConfiguration().getTemplate(notificationTargetType.toString().toLowerCase() + TEMPLATE_PATH_BUILDER + notificationTemplate.toString().toLowerCase() + TEMPLATE_FILE_EXTENSION), convertedMap);
            return body;
        } catch (TemplateNotFoundException | TemplateException | MalformedTemplateNameException | ParseException me) {
            throw new CloudyServiceException(me.getMessage(), me);
        } catch (IOException ioe) {
            throw new CloudyServiceException(ioe.getMessage(), ioe);
        }

    }
}
