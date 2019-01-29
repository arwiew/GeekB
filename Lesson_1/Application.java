package Lesson_1;

public class Application {

    public static void main(String[] args) {
        Participant[] participants = new Participant[] {
                new Cat("Кыся", 10, 12, 0),
                new Dog("Палкан", 20, 5, 15),
                new Cat("Рыся", 9, 14, 0),
                new Robot("Гобот", 50, 50, 50),
        };

        Obstacle[] obstacles = new Obstacle[] {
                new Cross(8),
                new Wall(4),
                new Water(15)
        };

        Team team = new Team("DremTeam", participants);
        Course course = new Course(obstacles);
        course.doIt(participants);
            System.out.println("Итоги:");
                for (Participant participant : participants) {
                System.out.println(participant);

        }
    }
}
