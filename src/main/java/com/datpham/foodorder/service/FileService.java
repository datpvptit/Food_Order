package com.datpham.foodorder.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    boolean saveFile(MultipartFile file, String target);
    Resource loadFile(String fileName, String target);
}