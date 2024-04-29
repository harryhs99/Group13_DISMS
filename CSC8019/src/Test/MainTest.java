package Test;

import CSC8019.MyExceptions;
import CSC8019.Session;
import CSC8019.Timetable;

import java.time.LocalDateTime;

public class MainTest {
    public static final String LECTURE = "lecture";
    public static final String PRACTICAL = "practical";
    public static final String SEMINAR = "seminar";
    public static void main(String[] args) throws MyExceptions {
        LocalDateTime testTime1S = LocalDateTime.of(2024,4,29,9,30);
        LocalDateTime testTime1S_2 = LocalDateTime.of(2024,4,29,9,30);
        LocalDateTime testTime1E = LocalDateTime.of(2024,4,29,11,30);
        LocalDateTime testTime2S = LocalDateTime.of(2024,4,30,11,30);
        LocalDateTime testTime2E = LocalDateTime.of(2024,4,29,13,30);
        LocalDateTime testTime3S = LocalDateTime.of(2024,5,1,14,30);
        LocalDateTime testTime3E = LocalDateTime.of(2024,5,1,16,30);
        String testStudent1="testStudent1";
        String testStudent2="testStudent2";
        String testStudent3="testStudent3";
        String testStaff1="testStaff1";
        String testStaff2="testStaff2";
        String testStaff3="testStaff3";
        String[] testParticipants1 = {testStudent1,testStudent2};
        String[] testParticipants2 = {testStudent3};
        String[] testLecturers = {testStaff1,testStaff2};
        String[] testLecturers2= {testStaff3};
        String testModuleCode = "CSC8019";
        String testEventType = LECTURE;
        String testSiteID = "USB1007";
        Session testSession1 = new Session(testEventType,testTime1S,testTime1E,testSiteID,testLecturers,testModuleCode);
        testSession1.setParticipatedStudents(testParticipants1);
        Session testSession2 = new Session(testEventType,testTime2S,testTime2E,testSiteID,testLecturers,testModuleCode);
        testSession2.setParticipatedStudents(testParticipants1);
        Session testSession3 = new Session(testEventType,testTime1S,testTime1E,testSiteID,testLecturers2,testModuleCode);
        testSession3.setParticipatedStudents(testParticipants2);
        System.out.println(testSession1.toString());
        Timetable testTimetable = new Timetable();
        testTimetable.addModuleSession(testSession1);
        testTimetable.addModuleSession(testSession2);
        testTimetable.addModuleSession(testSession3);
        System.out.println(testTimetable.toString());
        System.out.println(testTimetable.toModuleTimetableString());
        Timetable testTimetable2 = Timetable.getModuleTimetableFromString(testModuleCode,testTimetable.toModuleTimetableString());
        System.out.println(testTimetable2.toString());
    }
}
