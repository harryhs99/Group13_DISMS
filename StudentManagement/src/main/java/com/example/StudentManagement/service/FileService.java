package com.example.StudentManagement.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description This class provides a file service for the application.
 * It has methods to upload and download files, and get the list of files in a directory.
 * @author Yangcheng Liu
 * @Date 07/05/2024
 */
@Service
public class FileService {
    // Pre-defined directories
    private static final String fileDirectory = "../files/";
    private static final String materialsDirectory = "materials";
    private static final String courseworkDirectory = "coursework";
    private static final String recapsDirectory = "recaps";

    /**
     * Upload materials to the specified module directory
     * @param file The file to be uploaded
     * @param moduleCode The code of the module to which the file will be uploaded
     * @return A ResponseEntity containing the response data
     */
    public ResponseEntity<Map<String, String>> uploadMaterials(MultipartFile file, String moduleCode) {
        return uploadFile(file, moduleCode, materialsDirectory);
    }

    /**
     * Upload recaps to the specified module directory
     * @param file The file to be uploaded
     * @param moduleCode The code of the module to which the file will be uploaded
     * @return A ResponseEntity containing the response data
     */
    public ResponseEntity<Map<String, String>> uploadRecaps(MultipartFile file, String moduleCode) {
        return uploadFile(file, moduleCode, recapsDirectory);
    }

    /**
     * Upload a file to the specified directory
     * @param file The file to be uploaded
     * @param moduleCode The code of the module to which the file will be uploaded
     * @param directoryName The name of the directory to which the file will be uploaded
     * @return A ResponseEntity containing the response data
     */
    private ResponseEntity<Map<String, String>> uploadFile(MultipartFile file, String moduleCode, String directoryName) {
        if (file.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            // Get the filename
            String filename = file.getOriginalFilename();

            // Set the file path. Coursework belonging to one module will be put in the same directory
            Path path = Paths.get(fileDirectory, moduleCode, directoryName, filename);
            File directory = new File(path.getParent().toString());
            if (!directory.exists()) {
                // Check if the directory exists, create one if it does not exist
                directory.mkdirs();
            }

            // Check if the file already exists,
            // if it exists add(1) after the filename
            File fileToBeSaved = new File(path.toString());
            while (fileToBeSaved.exists()) {
                String nameWithoutExtension = filename.substring(0, filename.lastIndexOf("."));
                String extension = filename.substring(filename.lastIndexOf("."));
                filename = nameWithoutExtension + "(1)" + extension;
                path = Paths.get(fileDirectory, moduleCode, directoryName, filename);
                fileToBeSaved = new File(path.toString());
            }
            // Save the file to the specified location
            file.transferTo(new File(path.toAbsolutePath().toString()));

            // Create a Map to store the response data
            Map<String, String> response = new HashMap<>();
            response.put("message", "File uploaded successfully.");
            response.put("url", "/files/" + filename);
            response.put("filename", filename);

            // Return the file's URL and filename
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get the list of materials in the specified module directory
     * @param moduleCode The code of the module
     * @return A ResponseEntity containing the list of filenames
     */
    public ResponseEntity<List<String>> getMaterials(String moduleCode){
        return getFiles(moduleCode, materialsDirectory);
    }

    /**
     * Get the list of recaps in the specified module directory
     * @param moduleCode The code of the module
     * @return A ResponseEntity containing the list of filenames
     */
    public ResponseEntity<List<String>> getRecaps(String moduleCode){
        return getFiles(moduleCode, recapsDirectory);
    }

    /**
     * Get the list of files in the specified directory
     * @param moduleCode The code of the module
     * @param directoryName The name of the directory
     * @return A ResponseEntity containing the list of filenames
     */
    private ResponseEntity<List<String>> getFiles(String moduleCode, String directoryName){
        try {
            // Create a Path object to represent the path of the directory
            Path path = Paths.get(fileDirectory, moduleCode, directoryName);

            // Use Files.list method to get all the files and subdirectories under this directory
            // Use filter method to filter the file (exclude the subdirectory)
            // Use map method to transfer Path object to filename
            // Use collect method to collect all the results into a list
            List<String> filenames = Files.list(path)
                    .filter(Files::isRegularFile)
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(filenames,HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Download a file from the server.
     * @param path The path of the file to be downloaded.
     * @param filename The name of the file to be downloaded.
     * @return A ResponseEntity containing the file data.
     * @throws IOException If an I/O error occurs.
     */
    public ResponseEntity<byte[]> downloadFile(Path path, String filename) throws IOException {
        // Create a File object for the file to be downloaded
        File file = new File(path.toString());
        // Read all bytes from the file into a byte array
        byte[] data = Files.readAllBytes(file.toPath());

        // Create HttpHeaders to set the response headers
        HttpHeaders headers = new HttpHeaders();
        // Set the Content-Disposition header to attachment and specify the filename
        String headerValue = "attachment; filename=" + filename;
        headers.add(HttpHeaders.CONTENT_DISPOSITION, headerValue);

        // Return a ResponseEntity with the file data and headers
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(data);
    }

}
