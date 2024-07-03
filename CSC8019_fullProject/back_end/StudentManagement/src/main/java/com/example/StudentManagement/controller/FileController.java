package com.example.StudentManagement.controller;

import com.example.StudentManagement.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/file")
public class FileController {
    private static final String fileDirectory = "../files/";
    private static final String materialsDirectory = "materials";
    private static final String courseworkDirectory = "coursework";
    private static final String recapsDirectory = "recaps";

    @Autowired
    private FileService fileService;

    @PostMapping("/uploadMaterials")
    public ResponseEntity<Map<String, String>> uploadFile(@RequestParam("uploadMaterials") MultipartFile file,
                                                          @RequestParam("moduleCode") String moduleCode) {
        if (file.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            ResponseEntity<Map<String, String>> response = fileService.uploadMaterials(file, moduleCode);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/uploadRecaps")
    public ResponseEntity<Map<String, String>> uploadRecaps(@RequestParam("uploadVideos") MultipartFile file,
                                                          @RequestParam("moduleCode") String moduleCode) {
        if (file.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            ResponseEntity<Map<String, String>> response = fileService.uploadRecaps(file, moduleCode);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping("/getMaterials")
    public ResponseEntity<List<String>> getMaterials(@RequestParam("moduleCode") String moduleCode){
        return fileService.getMaterials(moduleCode);
    }

    @GetMapping("/getRecaps")
    public ResponseEntity<List<String>> getRecaps(@RequestParam("moduleCode") String moduleCode){
        return fileService.getRecaps(moduleCode);
    }

    @GetMapping("/downloadMaterials")
    public ResponseEntity<byte[]> downloadMaterials(
            @RequestParam("filename") String filename,
            @RequestParam("moduleCode") String moduleCode) throws IOException {
        System.out.println(filename);
        System.out.println(moduleCode);
        Path path = Paths.get(fileDirectory, moduleCode, materialsDirectory,filename);
        return fileService.downloadFile(path);
    }

    @GetMapping("/downloadRecaps")
    public ResponseEntity<byte[]> downloadRecaps(
            @RequestParam("filename") String filename,
            @RequestParam("moduleCode") String moduleCode) throws IOException {
        System.out.println(filename);
        System.out.println(moduleCode);
        Path path = Paths.get(fileDirectory, moduleCode, recapsDirectory,filename);
        return fileService.downloadFile(path);
    }


    @GetMapping("/download")
    public ResponseEntity<byte[]> getFile() throws IOException {
        File file = new File("C:/upload/CSC8019/test.docx");
        byte[] data = Files.readAllBytes(file.toPath());

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=test.docx");

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(data);
    }
}


