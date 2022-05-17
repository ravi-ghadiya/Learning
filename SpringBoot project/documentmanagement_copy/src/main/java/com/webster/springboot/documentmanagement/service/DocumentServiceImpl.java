package com.webster.springboot.documentmanagement.service;

import com.webster.springboot.documentmanagement.dao.DocumentRepository;
import com.webster.springboot.documentmanagement.entity.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    DocumentRepository documentRepository;

    @Override
    public Document store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Document document = new Document(fileName, file.getContentType(), file.getBytes());

        //TODO save user id --> documnt

        Document savedDoc = documentRepository.save(document);

//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/documents/")
//                .path(fileName)
//                .toUriString();

        return savedDoc;

    }

    @Override
    public Document findbyDocName(String fileName) {
        return documentRepository.findByDocName(fileName);
    }
}
