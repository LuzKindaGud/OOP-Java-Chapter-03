class MyTime{
    private int hour = 0;
    private int minute = 0;
    private int second = 0;

    public MyTime(){

    }

    public MyTime(int hour, int minute, int second){
        if (hour<0||hour>23||minute<0||minute>59||second<0||second>59){
            System.out.println("Invalid hour, minute, or second!");
        } else {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }
    }

    public void setTime(int hour, int minute, int second){
        if (hour<0||hour>23||minute<0||minute>59||second<0||second>59){
            System.out.println("Invalid hour, minute, or second!");
        } else {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getHour() {
        return hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getMinute() {
        return minute;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getSecond() {
        return second;
    }

    public String toString(){
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    public MyTime nextSecond(){
        second++;

        if (second == 60) {
            second = 0;
            minute++; // Increment minutes

            // Check for overflow of minutes
            if (minute == 60) {
                minute = 0;
                hour++; // Increment hours

                // Check for overflow of hours
                if (hour == 24) {
                    hour = 0; // Reset to 00 if it goes past 23
                }
            }
        }
        return this;
    }

    public MyTime nextMinute(){
        minute++;

        if (minute == 60) {
            minute = 0;
            hour++; // Increment hours

            // Check for overflow of hours
            if (hour == 24) {
                hour = 0; // Reset to 00 if it goes past 23
            }
        }
        return this;
    }

    public MyTime nextHour(){
        hour++;

        if (hour == 24) {
            hour = 0; // Reset to 00 if it goes past 23
        }

        return this;
    }

    public MyTime previousSecond(){
        second--;

        if (second == -1) {
            second = 59;
            minute--; // Increment minutes

            // Check for overflow of minutes
            if (minute == -1) {
                minute = 23;
                hour--; // Increment hours

                // Check for overflow of hours
                if (hour == -1) {
                    hour = 23; // Reset to 00 if it goes past 23
                }
            }
        }
        return this;
    }

    public MyTime previousMinute(){
        minute--; // Increment minutes

        // Check for overflow of minutes
        if (minute == -1) {
            minute = 23;
            hour--; // Increment hours

            // Check for overflow of hours
            if (hour == -1) {
                hour = 23; // Reset to 00 if it goes past 23
            }
        }
        return this;
    }

    public MyTime previousHour(){
        hour--; // Increment hours

        // Check for overflow of hours
        if (hour == -1) {
            hour = 23; // Reset to 00 if it goes past 23
        }
        return this;
    }
}
public class Ex3_04 {
    public static void main(String[] args) {
        // Test case 1: Default constructor
        MyTime time1 = new MyTime();
        System.out.println("Default constructor: " + time1); // Expected: 00:00:00

        // Test case 2: Parameterized constructor
        MyTime time2 = new MyTime(12, 30, 45);
        System.out.println("Parameterized constructor: " + time2); // Expected: 12:30:45

        // Test case 3: Set time valid input
        time2.setTime(10, 15, 30);
        System.out.println("Set time valid input: " + time2); // Expected: 10:15:30

        // Test case 4: Set time invalid input
        time2.setTime(25, 61, 70); // Expected: "Invalid hour, minute, or second!"

        // Test case 5: Next second
        time2.nextSecond();
        System.out.println("Next second: " + time2); // Expected: 10:15:31

        // Test case 6: Next minute
        time2.nextMinute();
        System.out.println("Next minute: " + time2); // Expected: 10:16:31

        // Test case 7: Next hour
        time2.nextHour();
        System.out.println("Next hour: " + time2); // Expected: 11:16:31

        // Test case 8: Next second overflow
        time2.setTime(23, 59, 59);
        time2.nextSecond();
        System.out.println("Next second overflow: " + time2); // Expected: 00:00:00

        // Test case 9: Previous second
        time2.previousSecond();
        System.out.println("Previous second: " + time2); // Expected: 23:59:59

        // Test case 10: Previous minute
        time2.previousMinute();
        System.out.println("Previous minute: " + time2); // Expected: 23:58:59

        // Test case 11: Previous hour
        time2.previousHour();
        System.out.println("Previous hour: " + time2); // Expected: 22:58:59

        // Test case 12: Previous second underflow
        time2.setTime(00, 00, 00);
        time2.previousSecond();
        System.out.println("Previous second underflow: " + time2); // Expected: 23:59:59

        // Test case 13: Previous minute underflow
        time2.setTime(00, 00, 00);
        time2.previousMinute();
        System.out.println("Previous minute underflow: " + time2); // Expected: 23:59:00

        // Test case 14: Previous hour underflow
        time2.setTime(00, 00, 00);
        time2.previousHour();
        System.out.println("Previous hour underflow: " + time2); // Expected: 23:00:00

        // Test case 15: Boundary test for hour
        time2.setHour(23);
        time2.nextHour();
        System.out.println("Boundary test for hour: " + time2); // Expected: 00:00:00

        // Test case 16: Boundary test for minute
        time2.setMinute(59);
        time2.nextMinute();
        System.out.println("Boundary test for minute: " + time2); // Expected: 00:00:00

        // Test case 17: Boundary test for second
        time2.setSecond(59);
        time2.nextSecond();
        System.out.println("Boundary test for second: " + time2); // Expected: 00:00:00
    }
}
