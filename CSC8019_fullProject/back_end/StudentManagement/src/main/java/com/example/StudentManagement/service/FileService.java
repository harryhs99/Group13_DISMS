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

@Service
public class FileService {
    private static final String fileDirectory = "../files/";
    private static final String materialsDirectory = "materials";
    private static final String courseworkDirectory = "coursework";
    private static final String recapsDirectory = "recaps";



    public ResponseEntity<Map<String, String>> uploadMaterials(MultipartFile file, String moduleCode) {
        if (file.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            // get filename
            String filename = file.getOriginalFilename();

            // set filepath, coursework belongs to one module will be put in the same directory
            Path path = Paths.get(fileDirectory, moduleCode, materialsDirectory, filename);
//            System.out.println(path.toRealPath());
            System.out.println(path.toString());
            //System.out.println(System.getProperty("user.dir"));
            File directory = new File(path.getParent().toString());
            if (!directory.exists()) {
                //check if the directory exists, create one if not exists
                directory.mkdirs();
            }

            // check if the file already exists,
            // if exists add(1) after the filename
            File fileToBeSaved = new File(path.toString());
            while (fileToBeSaved.exists()) {
                String nameWithoutExtension = filename.substring(0, filename.lastIndexOf("."));
                String extension = filename.substring(filename.lastIndexOf("."));
                filename = nameWithoutExtension + "(1)" + extension;
//                path = Paths.get("C:/upload/" + moduleCode + "/" + filename);
                path = Paths.get(fileDirectory, moduleCode, materialsDirectory, filename);
                fileToBeSaved = new File(path.toString());
            }
            // 将文件保存到指定位置
            file.transferTo(new File(path.toAbsolutePath().toString()));

            // 创建一个Map来存储响应数据
            Map<String, String> response = new HashMap<>();
            response.put("message", "File uploaded successfully.");
            response.put("url", "/files/" + filename);
            response.put("filename", filename);

            // 返回文件的URL和文件名
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String, String>> uploadRecaps(MultipartFile file, String moduleCode) {
        if (file.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            // get filename
            String filename = file.getOriginalFilename();

            // set filepath, coursework belongs to one module will be put in the same directory
            Path path = Paths.get(fileDirectory, moduleCode, recapsDirectory, filename);
//            System.out.println(path.toRealPath());
            System.out.println(path.toString());
            //System.out.println(System.getProperty("user.dir"));
            File directory = new File(path.getParent().toString());
            if (!directory.exists()) {
                //check if the directory exists, create one if not exists
                directory.mkdirs();
            }

            // check if the file already exists,
            // if exists add(1) after the filename
            File fileToBeSaved = new File(path.toString());
            while (fileToBeSaved.exists()) {
                String nameWithoutExtension = filename.substring(0, filename.lastIndexOf("."));
                String extension = filename.substring(filename.lastIndexOf("."));
                filename = nameWithoutExtension + "(1)" + extension;
//                path = Paths.get("C:/upload/" + moduleCode + "/" + filename);
                path = Paths.get(fileDirectory, moduleCode, recapsDirectory, filename);
                fileToBeSaved = new File(path.toString());
            }
            // 将文件保存到指定位置
            file.transferTo(new File(path.toAbsolutePath().toString()));

            // 创建一个Map来存储响应数据
            Map<String, String> response = new HashMap<>();
            response.put("message", "File uploaded successfully.");
            response.put("url", "/files/" + filename);
            response.put("filename", filename);

            // 返回文件的URL和文件名
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<String>> getMaterials(String moduleCode){

        try {
            // 创建一个 Path 对象，表示目录的路径
            Path path = Paths.get(fileDirectory, moduleCode, materialsDirectory);

            // 使用 Files.list 方法获取目录下的所有文件和子目录
            // 使用 filter 方法过滤出文件（排除子目录）
            // 使用 map 方法将 Path 对象转换为文件名
            // 使用 collect 方法将结果收集到一个列表中
            List<String> filenames = Files.list(path)
                    .filter(Files::isRegularFile)
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(filenames,HttpStatus.OK);
            // 打印出文件名列表
//            System.out.println(filenames);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<List<String>> getRecaps(String moduleCode){

        try {
            // 创建一个 Path 对象，表示目录的路径
            Path path = Paths.get(fileDirectory, moduleCode, recapsDirectory);

            // 使用 Files.list 方法获取目录下的所有文件和子目录
            // 使用 filter 方法过滤出文件（排除子目录）
            // 使用 map 方法将 Path 对象转换为文件名
            // 使用 collect 方法将结果收集到一个列表中
            List<String> filenames = Files.list(path)
                    .filter(Files::isRegularFile)
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(filenames,HttpStatus.OK);
            // 打印出文件名列表
//            System.out.println(filenames);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<byte[]> downloadFile(Path path) throws IOException {
        File file = new File(path.toString());
        byte[] data = Files.readAllBytes(file.toPath());

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=test.docx");

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(data);
    }
}
