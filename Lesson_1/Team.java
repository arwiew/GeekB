package Lesson_1;

public class Team {

    private String name;
    private Participant[] participants;

    public Team(String name, Participant[] participants) {
        this.name = name;
        this.participants = participants;
    }

    public Participant[] getParticipants() {
        return participants;
    }

}




