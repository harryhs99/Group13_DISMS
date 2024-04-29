package CSC8019;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

public class Timetable {
    public static final String STUDENT = "student";
    public static final String STAFF = "staff";
    ArrayList<Event> timetable = new ArrayList<Event>();

    public Timetable(){}

    public static Timetable readTimetableFromExcel(){
        //read excel files to get Timetable
        return null;
    }

    public boolean exportToExcel(){
        //export the timetable to an excel file
        return true;}

    public static Timetable GenerateTimetableForProgram(String programCode){
        //maybe no need to generate timetable for a program
        //generate the timetable for a program
        //by adding the timetable of its modules
        return null;
    }

    public static Timetable GenerateTimetableForSite(String siteID){
        //generate timetable for a specific teaching site
        //get timetable from all the modules
        //search all the events to get events that take place in this teaching site
        return null;
    }

    public static Timetable GenerateTimetableForStaff(String StaffID){
        //generate the timetable of a specific staff
        //search all modules this staff teaches and get the timetable of the module
        //then search all the tutor meeting this staff have
        //finally add all the timetable and tutor meeting event together to get the overall timetable of this staff
        return null;}

    public static Timetable GenerateTimetableForStudent(String studentID) throws MyExceptions {
        //generate the timetable of a specific student
        //search all modules this student have and get the timetable of the module
        //then search all the tutor meeting this student have
        //finally add all the timetable and tutor meeting event together to get the overall timetable of this student
        String[] modules = getStudentModules(studentID);
        Timetable timetable = new Timetable();
        assert modules != null :"this student doesn't have module";
        for (String i:modules) {
            assert getModuleTimetable(i) != null :"this module doesn't have timetable";
            Timetable curTimetable = getModuleTimetableFromString(i,getModuleTimetable(i));
            for (Event j: curTimetable.getTimetable()) {
                for (String participant: j.getParticipatedStudents()) {
                    //check if this student is within the participant list
                    if (participant.equals(studentID)){
                        timetable.addEvent(j);
                        break;
                    }
                }
            }
        }
        //tutor meeting
        return timetable;
    }

    @Override
    public String toString() {
        StringBuilder timetableString= new StringBuilder();
        for (Event i:this.timetable) {
            timetableString.append(i.toString());
        }
        return timetableString.toString();
    }
    public String toModuleTimetableString() throws MyExceptions {
        //generate the timetable string of a module timetable to store in the database
        StringBuilder timetableString = new StringBuilder();
        for (Event i:this.timetable) {
            timetableString.append(i.toModuleEventString());
        }
        return timetableString.toString();
    }
    public String toStudentTimetableString(){
        //generate the timetable string of a student timetable to store in the database
        StringBuilder timetableString = new StringBuilder();
        for (Event i:this.timetable) {
            timetableString.append(i.toStudentEventString());
        }
        return timetableString.toString();
    }
    public String toStaffTimetableString(){
        //generate the timetable string of a staff timetable to store in the database
        StringBuilder timetableString = new StringBuilder();
        for (Event i:this.timetable) {
            timetableString.append(i.toStaffEventString());
        }
        return timetableString.toString();
    }


    /*
        public boolean checkTimetableConflict(){
            //check if there is conflict in this timetable
            //assume that timetable is not sorted
            for (int i =0; i<this.timetable.size()-1; i++) {
                for (int k =i+1; k<this.timetable.size(); k++){
                    if (this.timetable.get(i).checkTimeConflict(this.timetable.get(k))){
                        System.out.println("message to be considered");
                        //also we can check all the conflict then return
                        return true;
                    }
                }
            }
            return false;
        }
         */
    public void addEvent(Event event) throws MyExceptions {
        // add an event to this sorted timetable
        // make sure there is no conflict and follow the ascending order
        // return true if successfully done, otherwise return false
        for(int i=0; i<this.timetable.size(); i++){
            int compareResult = event.compareTo(this.timetable.get(i));
            if(compareResult==0){
                System.out.println("conflict message");
                return;
            } else if (compareResult<0) {
                //insert the event here
                //we don't need to compare the latter events in the timetable
                //because the timetable is sorted
                this.timetable.add(i,event);
                return;
            }
        }
        //append to the end of the timetable
        this.timetable.add(event);
    }

    public void addModuleSession(Session session) throws MyExceptions{
        //similar to addEvent(), only this is used to add a session to a module
        for(int i=0; i<this.timetable.size(); i++){
            int compareResult = session.compareTo(this.timetable.get(i));
            if(compareResult==0){
                if(session.checkParticipantsConflict((Session) this.timetable.get(i))){
                    System.out.println("conflict message");
                    return;
                }
                else {
                    //if the time of two session conflicts but their participants don't conflict
                    //then these two sessions don't conflict
                    this.timetable.add(i,session);
                    return;
                }
            } else if (compareResult<0) {
                this.timetable.add(i,session);
                return;
            }
        }
        //append to the end of the timetable
        this.timetable.add(session);
    }

    public boolean removeEvent(LocalDateTime startTime){
        //remove an event from the timetable
        //search the event by its startTime
        //because no events within a timetable should have the same startTime or endTime
        //return true if remove successfully
        return true;
    }

    public void sort(){
        //incomplete. maybe unnecessary
        Collections.sort(this.timetable);
    }

    public static Timetable getModuleTimetableFromString(String moduleCode,String timetableString) throws MyExceptions {
        //read a timetable string of a module and get timetable from them
        Timetable timetable = new Timetable();
        String[] eventListString = timetableString.split("#");
        for(String i: eventListString){
            String[] curEventString = i.split(",");
            Session curEvent = new Session(curEventString[0],LocalDateTime.parse(curEventString[1]),
                    LocalDateTime.parse(curEventString[1]), curEventString[3],
                    curEventString[4].split(";"),moduleCode);
            curEvent.setParticipatedStudents(curEventString[5].split(";"));
            timetable.addModuleSession(curEvent);
        }
        return timetable;
    }

    public static Timetable getUserTimetableFromString(String userType,String userID, String timetableString) throws MyExceptions {
        //read a timetable string of a user and get timetable from them

        Timetable timetable = new Timetable();
        String[] eventListString = timetableString.split("#");
        String tutor;
        switch (userType){
            case STAFF:
                tutor = userID;
                break;
            case STUDENT:
                tutor = getStudentTutor(userID);
                break;
            default:
                throw new MyExceptions("invalid userType");
        }
        for (String i: eventListString) {
            String[] curEventString = i.split(",");
            Event curEvent;
            String curEventType = curEventString[0];
            switch (curEventType){
                case "tutorMeeting":
                    curEvent = new TutorMeeting(LocalDateTime.parse(curEventString[1]),
                            LocalDateTime.parse(curEventString[2]), tutor);
                    curEvent.setParticipatedStudents(curEventString[3].split(";"));
                    timetable.addEvent(curEvent);
                    break;
                case "lecture","practical","seminar":
                    curEvent = new Session(curEventType,LocalDateTime.parse(curEventString[1]),
                            LocalDateTime.parse(curEventString[2]),curEventString[3],
                            curEventString[5].split(";"), curEventString[4]);
                    if(userType.equals(STAFF)){curEvent.setParticipatedStudents(curEventString[6].split(";"));}
                    timetable.addEvent(curEvent);
                    break;
                default:
                    System.out.println("Invalid event type");
                    break;
            }
        }
        return timetable;
    }

    public ArrayList<Event> getTimetable() {
        return timetable;
    }


    public static String getModuleTimetable(String moduleCode){
        return null;
    }
    public static String[] getStudentModules(String studentID){
        return null;
    }
    public static String getStudentTutor(String studentID){
        //get the userID of the tutor of this student
        return null;
    }
}
