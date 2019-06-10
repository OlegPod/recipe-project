package com.olehpodolin.recipeproject.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
public class ImageService {

    public void saveImageFile(Long recipeId, MultipartFile file) {

        log.debug("File Received");
    }
}
