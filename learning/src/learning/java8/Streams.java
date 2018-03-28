package learning.java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Streams {
    private enum Status{
            OPEN,CLOSED
    };
    
    private static final class Task{
        private final Status status;
        private final Integer points;
        
        @SuppressWarnings("unused")
        public Task(final Status status, final Integer points) {
            this.status = status;
            this.points = points;
        }

        @SuppressWarnings("unused")
        public Status getStatus() {
            return status;
        }

        @SuppressWarnings("unused")
        public Integer getPoints() {
            return points;
        }
        
        public String toString() {
            return String.format("[%s,%d]", status,points);
        }
    }
    
    final Collection<Task> tasks = Arrays.asList(new Task(Status.OPEN,5),new Task(Status.OPEN,13),new Task(Status.CLOSED,8));

    final long totalPointsOfOpenTasks = tasks
            .stream()
            .filter(taska -> taska.getStatus() == Status.OPEN)
            .mapToInt(Task::getPoints)
            .sum();
    
    final long totalPoints = tasks
            .stream()
            .parallel()
            .map(task -> task.getPoints())
            .reduce(0, Integer::sum);
    
    final Map<Status,List<Task>> map = tasks
            .stream()
            .collect(Collectors.groupingBy(Task::getStatus));
    
    public static void main(String[] args) {
        Streams streams = new Streams();
        System.out.println("total points:"+streams.totalPointsOfOpenTasks);
        System.out.println("total all points:"+streams.totalPoints);
        System.out.println(streams.map);
    }
}
