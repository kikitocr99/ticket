package com.pinhost.discountticketcondition.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/file")
public class UploadController {

    @GetMapping("/upload/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable("filename") final String filename) {
        Path path = Paths.get("uploads").resolve(filename).toAbsolutePath();
        Resource resource = null;
        try {
            resource = new UrlResource(path.toUri());
            if (!resource.exists() && !resource.isReadable()) {
                throw new RuntimeException("Error");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
