package CSC8019;

import java.time.LocalDateTime;
import java.util.Arrays;

public class TutorMeeting extends Event{
    private static final String eventType = "tutorMeeting";
    private String tutor;

    public TutorMeeting(LocalDateTime startTime, LocalDateTime endTime, String tutor) {
        super(startTime, endTime);
        this.tutor = tutor;
    }

    @Override
    public String toString() {
        String participantString = this.toParticipatedStudentsString();
        return eventType+","+super.toString()+","+tutor+","
                + participantString +"#";
    }

    @Override
    public String toStudentEventString() {
        String participantString = this.toParticipatedStudentsString();
        return eventType+","+super.toString()+","
                + participantString +"#";
    }


    @Override
    public String toModuleEventString() throws MyExceptions {
        throw new MyExceptions("shouldn't have tutorMeeting in module timetable");
    }

    @Override
    public String toStaffEventString() {
        String participantString = this.toParticipatedStudentsString();
        return eventType+","+super.toString()+","
                + participantString +"#";
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getTutor() {
        return tutor;
    }

    public static String getEventType() {
        return eventType;
    }
}
