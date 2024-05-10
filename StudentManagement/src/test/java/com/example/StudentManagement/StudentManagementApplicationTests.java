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
/**
 * @Description This class is a unit test class for the StudentManagementApplication, used to test the methods in the application.
 * @author Yangcheng Liu
 * @Date 07/05/2024
 */
@SpringBootTest
class StudentManagementApplicationTests {
	@Autowired
	private CourseworkRepository courseworkRepository;
	@Autowired
	private ModuleRepository moduleRepository;
	@Autowired
	private TeachingRepository teachingRepository;
	/**
	 * @Description Tests the addition of data to the database.
	 */
	@Test
	public void AddDataTest() {
		//add some data to the database
		Modules testModule = new Modules();
		testModule.setModuleCode("CSC8019");
		testModule.setTitle("Software Team Project");
		moduleRepository.insert(testModule);
		Teaching testTeaching = new Teaching();
		testTeaching.setStaffID("testStaff1");
		testTeaching.setModuleCode("CSC8019");
		teachingRepository.insert(testTeaching);
		Coursework testCoursework = new Coursework();
		testCoursework.setStudentID("testUser1");
		testCoursework.setAssessmentID("CSC8019CW1testUser1");
		testCoursework.setModuleCode("CSC8019");
		testCoursework.setTitle("Coursework1");
		courseworkRepository.insert(testCoursework);
	}
	/**
	 * @Description Tests the selection of coursework from the database.
	 */
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
	/**
	 * @Description Tests the update of coursework in the database.
	 */
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
	/**
	 * @Description // Test for getting all filename in a specific directory
	 */
	@Test
	public void fileTest(){


		//pre-define the directory
		final String fileDirectory = "../files/";
		final String materialsDirectory = "materials";
		final String courseworkDirectory = "coursework";
//		Path path = Paths.get("../files/CSC8019");
//		File testFile = new File(path.toString());
//		System.out.println(testFile.getAbsolutePath());

		try {
			// create a Path object to represent the path of the directory
			Path path = Paths.get(fileDirectory, "CSC8019", materialsDirectory);

			// use Files.list method to get all the files and subDirectory under this directory
			// use filter method to filter the file(exclude the subDirectory)
			// use map method to transfer Path object to filename
			// use collect method to collect all the results into a list
			List<String> filenames = Files.list(path)
					.filter(Files::isRegularFile)
					.map(Path::getFileName)
					.map(Path::toString)
					.collect(Collectors.toList());

			// print the list of filename
			System.out.println(filenames);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
