package topic1.day9;

public enum Day {
   MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    public static boolean isWeekend(Day d){
        return d == Day.SATURDAY || d == Day.SUNDAY;
    }
}
