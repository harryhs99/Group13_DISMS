package com.example.StudentManagement;

import com.example.StudentManagement.dao.CourseworkRepository;
import com.example.StudentManagement.dao.ModuleRepository;
import com.example.StudentManagement.dao.TeachingRepository;
import com.example.StudentManagement.entity.Coursework;
import com.example.StudentManagement.entity.Modules;
import com.example.StudentManagement.entity.Teaching;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class StudentManagementApplicationTests {
	@Autowired
	private CourseworkRepository courseworkRepository;
	@Autowired
	private ModuleRepository moduleRepository;
	@Autowired
	private TeachingRepository teachingRepository;

	@Test
	public void AddDataTest() {
		//add some data to the database
//		Modules testModule = new Modules();
//		testModule.setModuleCode("CSC8019");
//		testModule.setTitle("Software Team Project");
//		moduleRepository.insert(testModule);
//		Teaching testTeaching = new Teaching();
//		testTeaching.setStaffID("testStaff1");
//		testTeaching.setModuleCode("CSC8019");
//		teachingRepository.insert(testTeaching);
//		Coursework testCoursework = new Coursework();
//		testCoursework.setStudentID("testUser1");
//		testCoursework.setAssessmentID("CSC8019CW1testUser1");
//		testCoursework.setModuleCode("CSC8019");
//		testCoursework.setTitle("Coursework1");
//		courseworkRepository.insert(testCoursework);
	}
	@Test
	public void selectCourseworkTest(){
		Coursework testCoursework = new Coursework();
		testCoursework.setStudentID("testUser1");
		testCoursework.setAssessmentID("CSC8019CW1testUser1");
		testCoursework.setModuleCode("CSC8019");
		testCoursework.setTitle("Coursework1");
		List<Coursework> courseworkList= courseworkRepository.select(testCoursework);
		System.out.println(courseworkList.get(0).getAssessmentID());

		testCoursework.setAssessmentID("testUser2");
		//select method will return an empty list if cannot find any result
		if(courseworkRepository.select(testCoursework).isEmpty()){System.out.println("cannot find testUser2");}

	}
	@Test
	public void updateCourseworkTest(){
		Coursework testCoursework = new Coursework();
		testCoursework.setStudentID("testUser1");
		testCoursework.setAssessmentID("CSC8019CW1testUser1");
		testCoursework.setModuleCode("CSC8019");
		System.out.println(testCoursework.getTitle());
		//testCoursework.setTitle("Coursework1");
		//return the number of columns updated
		//normally it should return 1 if updated successfully,
		//otherwise return 0
		System.out.println(courseworkRepository.updateByPrimaryKeySelective(testCoursework));
		testCoursework.setAssessmentID("CSC8019CW1testUser2");
		System.out.println(courseworkRepository.updateByPrimaryKeySelective(testCoursework));
	}
	@Test
	public void fileTest(){
		final String fileDirectory = "../files/";
		final String materialsDirectory = "materials";
		final String courseworkDirectory = "coursework";
//		Path path = Paths.get("../files/CSC8019");
//		File testFile = new File(path.toString());
//		System.out.println(testFile.getAbsolutePath());

		try {
			// 创建一个 Path 对象，表示目录的路径
			Path path = Paths.get(fileDirectory, "CSC8019", materialsDirectory);

			// 使用 Files.list 方法获取目录下的所有文件和子目录
			// 使用 filter 方法过滤出文件（排除子目录）
			// 使用 map 方法将 Path 对象转换为文件名
			// 使用 collect 方法将结果收集到一个列表中
			List<String> filenames = Files.list(path)
					.filter(Files::isRegularFile)
					.map(Path::getFileName)
					.map(Path::toString)
					.collect(Collectors.toList());

			// 打印出文件名列表
			System.out.println(filenames);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
