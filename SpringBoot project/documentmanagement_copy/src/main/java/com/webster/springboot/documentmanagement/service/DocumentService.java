package com.webster.springboot.documentmanagement.service;

import com.webster.springboot.documentmanagement.entity.Document;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface DocumentService {
    public Document store(MultipartFile file) throws IOException;

    public Document findbyDocName(String fileName);
}
