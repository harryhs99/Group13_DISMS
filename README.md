# Group13_DISMS

A Student Management System for the Dyson Institute

## 1. Project Overview

The aim of this project was to create an all-in-one student management system for Dyson Institute of
Technology an educational institute still in its infancy. This was to provide user interfaces and functionality for
both student and staff users in order to aid them in day-to-day tasks of running an educational institution.
The team undertook a waterfall approach to this project, due to this being the first time many in the team had
been a part of a project to develop a full stack application. The sequential approach of waterfall provided a
clearer pathway than other approaches such as agile which may have been a bit confusing in terms of scheduling
and planning for novices to the process. The waterfall methodology also enforces the need for documentation
which was a big part of the requirements of completing this project therefore it seemed like the clear choice for
this particular project. The total size of the final codebase is 4.9 MB.

## 2. Architecture and Components

### 2.1 Client-Server Architecture

The design of the system follows that of a standard client-server architecture model with users
interacting with a web-based user interface that communicates with a MVC Spring Boot server using
HTTP requests sent to the RESTful API altering data stored in a MySQL database. We managed to
deploy a locally hosted system with the front-end GUI interacting with the Spring Boot server through
fetch requests which in turn interacted with a local MySQL database. The aim was to fully deploy this
on an azure virtual machine that would have its own public IP however due to time constraints and
technical difficulties in working with the virtual machine this was not possible.

### 2.2 Front-end Client

The front-end is a web-based GUI built using a standard stack of HTML, CSS, and vanilla JavaScript.
This provides the client with interactive webpages in order to fulfil the functional requirements as set
out in the Requirements Specification.

### 2.3 Back-end Server

The back-end server is implemented using the Spring Boot framework following the MVC (Model,
View, Controller) architectural pattern. This handles HTTP requests sent from the front-end, executes
any logic required for data transferal and interacts with the MySQL database. It uses MyBatis for
database querying and data retrieval.

### 2.4 Database

The data for the student management system is stored in a relational database in this case using
MySQL as a local database server.

## 3. Technologies

### 3.1 Front-end Technologies

HTML/CSS - Selected due to being the standard languages used for displaying content on web pages
and structuring and styling components.
Vanilla JavaScript - Selected by the team due to the lack of knowledge of frameworks and therefore
wanted to learn the vanilla functionality of making dynamic pages. The thought process being that it
would make understanding the use of frameworks clearer and streamlined. It is also the standard
language of the web used for dynamic content, for rendering and event handling.

### 3.2 Back-end Technologies

Spring Boot - Chosen as the backend framework due to its opinionated nature meaning a streamlined
development experience due to its default and auto-configuration features. Many members of the team
were most comfortable using the Java language therefore Spring Boot seemed a natural choice for the
team. It also provides an embedded server meaning there was no need to configure our own server
worry about concurrency control simplifying deployment. It is also a widely used framework and
therefore well maintained and tested meaning we can trust it as a framework and there is a large
amount of documentation and community support to aid in learning and fixing bugs.
MySQL - Chosen as a database management software as it is an open-source free for use software that
is easily scalable and very reliable with optimised performance. There is a very large user base
meaning the is wide support and it is very well tested so easy to learn and resolve issues using
documentation.

## 4. Functions Implemented vs. Requirements

### 4.1 User Login Functionality

We managed to implement two login portals for a student and staff. This satisfies the requirement of
privilege levels as students will not be able to access the staff GUI as they will not be able to login
through that portal. The implementation also requires a username and password in accordance with the
requirements and provides feedback on successful and unsuccessful login attempts satisfying the non-
functional requirement.

### 4.2 Timetable Functionality

#### 4.2.1 Student Timetable

We managed to implement a basic timetable function that displays events in a grid format
with events being a certain time period to make the management of time simpler within the
database. This will retrieve the module events (if the student is enrolled in the module) created
by the Staff in the timetable builder from the database and display them to the screen. This
implementation does not necessarily reflect a real-world implementation of a timetable which
requires teams of people to work out scheduling and room allocations. However, this simple
design allows us to showcase the basic functionality of the timetable and meets the
requirements as set out within the requirements specification.

#### 4.2.2 Staff Timetable Builder

The staff timetable builder functionality is also a simplification of a real-world example as in
reality it is unlikely that a module lecturer would be designing the timetable for the module,
and it would be a team designing the whole institutions timetable. However, this
implementation does meet the requirements as set out in the brief and in the requirements
specification. The staff member can choose the module they will be editing for and retrieve
the current timetable set for that module from the database. They can then edit this by clicking
on specific event slots and either editing, removing, or adding events for the module. They can
then publish this which submits it to the database and will reflect in the students timetables.

#### 4.3.3 Limitations

We were unable to implement adding booked tutor meetings to the timetable, this was not a
specific requirement of the system but did come up in the trade fair and would be a nice to
have if there was more time to implement this.

### 4.3 Student Functionalities

#### 4.3.1 Programme and Module Information

As per the requirements specification the students needed to be able to view programme and
module information. We have included this functionality across a few pages of the application
with students having the ability to view module announcements, and module content. We also
had plans to include ability for recap recordings and the ability to ask questions to the module
staff. This however was not fully implemented due to time constraints, although the front-end
layout can be seen.

#### 4.3.2 Coursework and Examinations

The coursework and exam functionality are completed in terms of front-end GUI capabilities
with pages for displaying coursework information and the ability to submit an extension form.
However, this has not been connected back-end server due to time constraints of the project.

#### 4.3.3 Absence and Meetings

This functionality has been completed within the project with students being able to book
meetings with their personal tutor and send absence notifications through a form which sends
an automated email to the tutor. However, functionality for the tutor to approve or deny this
has not been implemented.

#### 4.3.4 Programme Actions

Programme actions of being able to enrol, suspend or withdraw from a module have been
implemented as per the requirement specifications.

### 4.4 Staff Functionalities

#### 4.4.1 View Student Modules

The ability for staff to view the modules that a particular student has undertaken has been
fully implemented as per the requirements specification.

#### 4.4.2 Student Academic History

Functionality for Staff to view the academic history of student when inputting a particular
student number has been implemented as per requirements.

#### 4.4.3 Student Assignment

Functionality for Staff to be assigned up to 15 students as a personal tutor has been fully
implemented and the Staff can view their assigned students.

### 4.5 Accessibility Functionality

Due to time constraints of the project and the lower priority placement of this requirement in the
functional requirements, we were unable to implement this feature to the project.

## 5. Scalability

To be able to scale this system we could optimise database performance with indexing, caching, and sharding in
order to horizontally scale the database. We could also employ Spring Boot's caching, load balancing, and
horizontal scaling behind a load balancer for backend optimisation. Frontend enhancements include
minification, compression, content delivery network (CDN) usage, and lazy loading to reduce load times. This
would however take a lot of work especially as this is not something the team has done before so there would be
a large overhead in time spent learning these techniques to scale the system in order to handle a scaling number
of concurrent users.

## 6. Testing and Success

We created a test plan document (which can be found as part of the submission called
Team13_TestPlanDocument) as the first step along the way of the Testing block in the waterfall methodology
we undertook. For front-end testing we were able to test all files for validation using validation checkers that
checked the HTML, CSS, and JavaScript. We then planned to carry out unit tests on the JavaScript functions
implemented however due to time constraints of the project and with Testing being one of the later stages in
waterfall development this was not able to be implemented before the deadline. As per our testing document we
had planned unit, integration, database, and usability tests for our backend. This however was unfortunately not
able to be implemented before the deadline. For overall testing we had planned to do some usability testing of
our application using the concurrent think aloud method (CTA) to gauge any improvements to usability that
could be made. We also planned to try and get a selected group of people outside of the project to conduct a
closed-beta test to gather some user feedback. However, due to time constraints we were not able to undertake
these testing methods.

## Project Members
H. Hainsworth-Staples, S. Alimohammadi, R.J. Cheong, M. Hsueh, Z. Liang, J. Liu , Y. Liu, S. Yang

