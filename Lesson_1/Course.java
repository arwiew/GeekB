package Lesson_1;

import Lesson_1.Participant;

public class Course {

   Obstacle[] obstacles;
   public Course(Obstacle[] obstacles){
       this.obstacles = obstacles;
   }

    public void doIt(Participant[] participants) {
        for (Participant participant : participants) {
            for (Obstacle obstacle : obstacles) {
                obstacle.doIt(participant);
                if (!participant.isOnDistance()) {
                    break;
                }
            }
        }
    }

}