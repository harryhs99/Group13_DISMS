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

/**
 * @Description This class provides a controller for handling file-related requests.
 * It has methods to upload materials, upload recaps, get materials, get recaps, download materials, and download recaps.
 * @author Yangcheng Liu
 * @Date 07/05/2024
 */
@RestController
@CrossOrigin
@RequestMapping("/file")
public class FileController {
    // Pre-defined directories
    private static final String fileDirectory = "../files/";
    private static final String materialsDirectory = "materials";
    private static final String courseworkDirectory = "coursework";
    private static final String recapsDirectory = "recaps";

    @Autowired
    private FileService fileService;

    /**
     * Upload teaching materials from the website to the server.
     * @param file The file to be uploaded.
     * @param moduleCode The code of the module to which the file will be uploaded.
     * @return A ResponseEntity containing the response data.
     */
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

    /**
     * Upload recaps from the website to the server.
     * @param file The file to be uploaded.
     * @param moduleCode The code of the module to which the file will be uploaded.
     * @return A ResponseEntity containing the response data.
     */
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

    /**
     * Get the list of materials in the specified module directory.
     * @param moduleCode The code of the module.
     * @return A ResponseEntity containing the list of filenames.
     */
    @GetMapping("/getMaterials")
    public ResponseEntity<List<String>> getMaterials(@RequestParam("moduleCode") String moduleCode){
        return fileService.getMaterials(moduleCode);
    }

    /**
     * Get the list of recaps in the specified module directory.
     * @param moduleCode The code of the module.
     * @return A ResponseEntity containing the list of filenames.
     */
    @GetMapping("/getRecaps")
    public ResponseEntity<List<String>> getRecaps(@RequestParam("moduleCode") String moduleCode){
        return fileService.getRecaps(moduleCode);
    }

    /**
     * Download materials from the specified module directory.
     * @param filename The name of the file to be downloaded.
     * @param moduleCode The code of the module.
     * @return A ResponseEntity containing the file data.
     * @throws IOException If an I/O error occurs.
     */
    @GetMapping("/downloadMaterials")
    public ResponseEntity<byte[]> downloadMaterials(
            @RequestParam("filename") String filename,
            @RequestParam("moduleCode") String moduleCode) throws IOException {
        Path path = Paths.get(fileDirectory, moduleCode, materialsDirectory,filename);
        return fileService.downloadFile(path,filename);
    }

    /**
     * Download recaps from the specified module directory.
     * @param filename The name of the file to be downloaded.
     * @param moduleCode The code of the module.
     * @return A ResponseEntity containing the file data.
     * @throws IOException If an I/O error occurs.
     */
    @GetMapping("/downloadRecaps")
    public ResponseEntity<byte[]> downloadRecaps(
            @RequestParam("filename") String filename,
            @RequestParam("moduleCode") String moduleCode) throws IOException {
        Path path = Paths.get(fileDirectory, moduleCode, recapsDirectory,filename);
        return fileService.downloadFile(path,filename);
    }
}
