package katas;

public class HumanReadableTime {

    public static String makeReadable(int seconds){

        int hour = seconds / 3600;
        seconds -= hour * 3600;

        int minute = seconds /60;
        seconds -= minute * 60;


        String stringHour =  hour < 10 ? String.format("0%d",hour) : Integer.toString(hour);
        String stringMinute =  minute < 10 ? String.format("0%d",minute) : Integer.toString(minute);
        String stringSecond =  seconds < 10 ? String.format("0%d",seconds) : Integer.toString(seconds);

        return String.format("%s:%s:%s", stringHour,stringMinute, stringSecond);
    }
}
