package spring;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {
	public static void calculateDifference(String dt1, String dt2) {
		
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime local = LocalDateTime.parse(dt1, formatter);
        LocalDateTime local1 = LocalDateTime.parse(dt2, formatter);

        Duration duration = Duration.between(local, local1);

        long days = duration.toDays();
        long hours = duration.toHours() % 24;
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.getSeconds() % 60;

        System.out.println("Difference between " + dt1 + " and " + dt2 + " is:");
        System.out.println(days + " days, " + hours + " hours, " + minutes + " minutes, " + seconds + " seconds.");
    }

    public static void main(String[] args) {
        String dt1 = "2025-03-27 14:30:00";
        String dt2 = "2025-03-28 16:45:30";

        calculateDifference(dt1, dt2);
    }

}
