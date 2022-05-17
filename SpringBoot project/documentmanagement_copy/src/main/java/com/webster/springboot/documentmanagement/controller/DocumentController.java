package com.webster.springboot.documentmanagement.controller;

import com.webster.springboot.documentmanagement.entity.Document;
import com.webster.springboot.documentmanagement.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/document")
@RestController
public class DocumentController {

//    @Autowired
//    DocumentOperataionHelper documentOperataionHelper;

    @Autowired
    DocumentService documentService;

//    @GetMapping
//    private ResponseEntity<Object> getFiles() {
//        return documentService.getDocuments();
//    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadDocument(@RequestParam MultipartFile file, String sessioId) {

        //TODO session -> User
        //TODO user --> UserId --> Now u can identity which user upload this document
        //TODO Save document with userId (Document table)

        String message;

        try {
            documentService.store(file, );
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }

    @PostMapping("/api/document/{ravi}/{dilip}")
    @GetMapping("/download/{fileName:.+}")
    public ResponseEntity downloadDocument(@PathVariable("ravi") Long ravi, @PathVariable("dilip") Long @PathVariable String fileName) {

        Document document = documentService.findbyDocName(fileName);

        if (document != null) {
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(document.getDocType()))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + document.getDocName() + "\"")
                    .body(document.getData());
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No document present with this name.");

    }

    @GetMapping("/view/{fileName:.+}")
    public ResponseEntity showDocument(@PathVariable String fileName) {

        Document document = documentService.findbyDocName(fileName);

        if (document != null) {
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(document.getDocType()))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + document.getDocName() + "\"")
                    .body(document.getData());
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No document present with this name.");

    }


}
