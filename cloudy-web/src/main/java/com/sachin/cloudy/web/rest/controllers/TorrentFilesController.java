package com.sachin.cloudy.web.rest.controllers;

import com.sachin.cloudy.common.logger.InjectLogger;
import com.sachin.cloudy.services.services.StorageClientService;
import com.sachin.cloudy.web.constants.CloudyWebConstants;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

/**
 * Created by sachinhooda on 26/10/17.
 */
@RestController
@RequestMapping(value = CloudyWebConstants.URLS.URL_BASE)
public class TorrentFilesController {

    StorageClientService storageClientService;

    @InjectLogger
    private Logger logger;

    @Autowired
    public TorrentFilesController(StorageClientService storageClientService) {
        this.storageClientService = storageClientService;
    }

    @RequestMapping(value = CloudyWebConstants.URLS.URL_USER + CloudyWebConstants.URLS.URL_TORRENT + CloudyWebConstants.URLS.URL_UPLOAD, method = RequestMethod.POST)
    public String saveTorrentFile(@RequestBody MultipartFile multipartFile) {


        return null;


    }

    @RequestMapping(value = CloudyWebConstants.URLS.URL_USER + CloudyWebConstants.URLS.URL_TORRENT, method = RequestMethod.GET)
    public String getTorrentsList(Principal principal) {


        return null;


    }
}
