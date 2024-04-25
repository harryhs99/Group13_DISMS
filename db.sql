DROP DATABASE IF EXISTS disms;

CREATE DATABASE disms; 

USE DATABASE disms;

CREATE TABLE Staff ( 

    UserID VARCHAR(10) PRIMARY KEY, 

    UserPassword VARCHAR(100) NOT NULL, 

    FName VARCHAR(50) NOT NULL, 

    LName VARCHAR(50) NOT NULL, 

    Email VARCHAR(100) UNIQUE, 

    Address VARCHAR(255), 

    Telephone VARCHAR(20), 

    JoinedDate DATE, 

    Position VARCHAR(100), 

    Faculty VARCHAR(100) 

); 

 

CREATE TABLE Student ( 

    UserID VARCHAR(10) PRIMARY KEY, 

    UserPassword VARCHAR(100) NOT NULL, 

    FName VARCHAR(50) NOT NULL, 

    LName VARCHAR(50) NOT NULL, 

    Email VARCHAR(100) UNIQUE, 

    Address VARCHAR(255), 

    Telephone VARCHAR(20), 

    JoinedDate DATE, 

    Tutor VARCHAR(10), 

    FOREIGN KEY (Tutor) REFERENCES Staff (UserID) 

); 

 

CREATE TABLE TutorMeeting ( 

    RequestID INT PRIMARY KEY, 

    Student VARCHAR(10), 

    Status VARCHAR(50), 

    Tutor VARCHAR(10), 

    Date DATE, 

    Time TIME, 

    FOREIGN KEY (Tutor) REFERENCES Staff (UserID), 

    FOREIGN KEY (Student) REFERENCES Student (UserID) 

); 

 

CREATE TABLE Absence ( 

    RequestID INT PRIMARY KEY, 

    Student VARCHAR(10), 

    Status VARCHAR(50), 

    Module VARCHAR(10), 

    Date DATE, 

    Time TIME, 

    Justification VARCHAR (300), 

    FOREIGN KEY (Student) REFERENCES Student (UserID), 

    FOREIGN KEY (Module) REFERENCES Module (ModuleCode) 

); 

 

CREATE TABLE Extension ( 

    RequestID INT PRIMARY KEY, 

    Student VARCHAR(10), 

    Status VARCHAR(50), 

    Module VARCHAR(10), 

    Justification VARCHAR (300), 

    FOREIGN KEY (Student) REFERENCES Student (UserID), 

    FOREIGN KEY (Module) REFERENCES Module (ModuleCode) 

); 

 

CREATE TABLE Programme ( 

    ProgrammeCode VARCHAR(10) PRIMARY KEY, 

    Title VARCHAR(100) NOT NULL, 

    Duration VARCHAR(10) 

); 

 

CREATE TABLE Module ( 

    ModuleCode VARCHAR(10) PRIMARY KEY, 

    Lecturer VARCHAR(10), 

    Title VARCHAR(255) NOT NULL, 

    FOREIGN KEY (Lecturer) REFERENCES Staff (UserID) 

); 

 

CREATE TABLE Assessment ( 

    AssessmentID VARCHAR(10) PRIMARY KEY, 

    Title VARCHAR(255) NOT NULL, 

    Type VARCHAR(10), 

    Semester INT, 

    DueDate DATE, 

    Location VARCHAR(255), 

    Duration INT, 

    ModuleCode VARCHAR(10), 

    FOREIGN KEY (ModuleCode) REFERENCES Module(ModuleCode) 

); 

 

CREATE TABLE Timetable ( 

    Day VARCHAR (10), 

    Time TIME, 

    ModuleCode VARCHAR(20), 

    PRIMARY KEY (Day, Time), 

    FOREIGN KEY (ModuleCode) REFERENCES Module(ModuleCode) 

); 

 

CREATE TABLE Grade ( 

    StudentID INT, 

    ModuleID VARCHAR(10), 

    Grade VARCHAR(10), 

    PRIMARY KEY (StudentID, ModuleID) 

); 

 

CREATE TABLE Teaching ( 

    StaffID VARCHAR(10), 

    ModuleCode VARCHAR(10), 

    PRIMARY KEY (StaffID, ModuleCode) 

); 