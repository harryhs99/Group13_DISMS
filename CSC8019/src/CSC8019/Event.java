package CSC8019;

import java.time.LocalDateTime;

public abstract class Event implements Comparable<Event>{
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String[] participatedStudents;
    public Event(LocalDateTime startTime,LocalDateTime endTime){
        assert checkTimeIllegal():"endTime must be after the startTime";
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String toParticipatedStudentsString(){
        StringBuilder participantString= new StringBuilder();
        for (int i = 0; i < this.participatedStudents.length-1; i++) {
            participantString.append(this.participatedStudents[i]).append(";");
        }
        //append the last participant
        participantString.append(this.participatedStudents[this.participatedStudents.length-1]);
        return participantString.toString();
    }

    public boolean checkTimeConflict(Event eventToCompare){
        //check if the time of events are conflicting
        //return true if there is conflict, otherwise return false
        if(this.startTime.isBefore(eventToCompare.getEndTime()) &&
                !this.startTime.isBefore(eventToCompare.getStartTime())){
            return true;
        }
        else {
            if(this.endTime.isBefore(eventToCompare.getEndTime()) &&
                    !this.endTime.isBefore(eventToCompare.getStartTime())){
                return true;
            }
            else {
                return false;
            }
        }
    }

    //public abstract boolean checkParticipantsConflict(Event eventToCompare);

    public boolean checkTimeIllegal(){
        //check if the startTime is after the endTime
        if(this.startTime.isAfter(this.endTime)){
            return false;
        }
        else {
            return true;
        }
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public String[] getParticipatedStudents() {
        return participatedStudents;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setParticipatedStudents(String[] participatedStudents) {
        this.participatedStudents = participatedStudents;
    }

    @Override
    public int compareTo(Event eventToCompare) {
        //need to check if there is conflict before comparing
        //therefore no events can be the same because in this case they are conflicting
        //return 0 when two events are conflicting
        //return a negative integer if this event is before the event to be compared
        //return a positive integer if this event is after the event to be compared
        if(this.checkTimeConflict(eventToCompare)){
            //System.out.println("can't compare events with conflict");
            return 0;
        }
        else {
            return this.startTime.compareTo(eventToCompare.getStartTime());
        }
    }

    @Override
    public String toString() {
        return startTime.toString()+","+endTime.toString();
    }

    public abstract String toStudentEventString();
    public abstract String toModuleEventString() throws MyExceptions;
    public abstract String toStaffEventString();
}
