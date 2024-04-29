package CSC8019;

import java.time.LocalDateTime;

public class Session extends Event{
    //a teaching session can be a lecture,practical,or a seminar
    //for now these 3 kinds of sessions share the same function
    public static final String LECTURE = "lecture";
    public static final String PRACTICAL = "practical";
    public static final String SEMINAR = "seminar";
    private String eventType;
    private String moduleCode;
    private String siteID;
    private String[] lecturers;


    public Session(String eventType, LocalDateTime startTime, LocalDateTime endTime,String siteID,
                   String[] lecturers, String moduleCode) throws MyExceptions {
        super(startTime, endTime);
        switch (eventType){
            case LECTURE:
                this.eventType = LECTURE;
                break;
            case PRACTICAL:
                this.eventType = PRACTICAL;
                break;
            case SEMINAR:
                this.eventType = SEMINAR;
                break;
            default:
                throw new MyExceptions("invalid eventType");
        }
        this.lecturers = lecturers;
        this.moduleCode = moduleCode;
        this.siteID = siteID;
    }

    public boolean checkParticipantsConflict(Session eventToCompare) {
        //check if there is conflict within participated staff or students

        //Session eventToCompare = (Session) e;
        for (String staffToCompare:eventToCompare.getLecturers()) {
            for(String staff:this.getLecturers()){
                if(staff.equals(staffToCompare)){
                    System.out.println("conflict msg");
                    return true;
                }
            }
        }
        for (String participantToCompare:eventToCompare.getParticipatedStudents()) {
            for(String participant:this.getParticipatedStudents()){
                if(participant.equals(participantToCompare)){
                    System.out.println("conflict msg");
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return eventType+","+super.toString()+","+siteID+","+moduleCode+","
                +toLecturersString()+","+toParticipatedStudentsString()+"#";
    }

    public String toLecturersString(){
        StringBuilder lecturersString= new StringBuilder();
        for (int i = 0; i < this.lecturers.length-1; i++) {
            lecturersString.append(this.lecturers[i]).append(";");
        }
        //append the last participant
        lecturersString.append(this.lecturers[this.lecturers.length-1]);
        return lecturersString.toString();
    }
    @Override
    public String toModuleEventString(){
        //generate this event string of a module timetable to store in the database
        return eventType+","+super.toString()+","+siteID+","
                +toLecturersString()+","+toParticipatedStudentsString()+"#";
    }

    @Override
    public String toStaffEventString() {
        return this.toString();
    }

    @Override
    public String toStudentEventString(){
        return eventType+","+super.toString()+","+siteID+","+moduleCode+","
                +toLecturersString()+"#";
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public void setEventType(String eventType) throws MyExceptions {
        switch (eventType){
            case LECTURE:
                this.eventType = LECTURE;
                break;
            case PRACTICAL:
                this.eventType = PRACTICAL;
                break;
            case SEMINAR:
                this.eventType = SEMINAR;
                break;
            default:
                throw new MyExceptions("invalid eventType");
        }
    }

    public void setSiteID(String siteID) {
        this.siteID = siteID;
    }

    public void setLecturers(String[] lecturers) {
        this.lecturers = lecturers;
    }

    public String getEventType() {
        return eventType;
    }

    public String[] getLecturers() {
        return lecturers;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public String getSiteID() {
        return siteID;
    }
}

