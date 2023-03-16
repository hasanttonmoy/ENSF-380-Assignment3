import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RobotDataLine implements Cloneable {
    private static final String DATE_REGEX = "\\[([0-9]{1,2})/([0-9]{1,2})/([0-9]{4})\\]";
    private static final Pattern DATE_PATTERN = Pattern.compile(DATE_REGEX);
    private static final String ROBOT_REGEX = "\\s([0-9]{3}[A-Z]{1})\\s";
    private static final Pattern ROBOT_PATTERN = Pattern.compile(ROBOT_REGEX);

    private String dataLine;
    private String robotID;
    private Sensor sensor;
    private Movement movement;
    private LocalDate date;

    public RobotDataLine(String line) {
        dataLine = line;

        Matcher robotMatcher = ROBOT_PATTERN.matcher(line);
        if (robotMatcher.find()) {
            robotID = robotMatcher.group(1);
        } else {
            throw new IllegalArgumentException("Invalid robot ID format");
        }

        Matcher dateMatcher = DATE_PATTERN.matcher(line);
        if (dateMatcher.find()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            date = LocalDate.parse(dateMatcher.group(1) + "/" + dateMatcher.group(2) + "/" + dateMatcher.group(3),
                    formatter);
        } else {
            throw new IllegalArgumentException("Invalid date format");
        }

        movement = new Movement(line);
        sensor = new Sensor(line);
    }

    public String getRobotID() {
        return robotID;
    }

    public String getDataLine() {
        return dataLine;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public Movement getMovement() {
        return movement;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public Object clone() {
        try {
            RobotDataLine cloned = (RobotDataLine) super.clone();
            cloned.sensor = (Sensor) this.sensor.clone();
            cloned.movement = (Movement) this.movement.clone();
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning not supported");
        }
    }
}
