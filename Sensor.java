import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sensor implements Cloneable {
    private static final String REGEX = "\\(([a-z]+)\\)";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    private String sensor;

    public Sensor(String sensor) {
        Matcher matcher = PATTERN.matcher(sensor);
        if (matcher.find()) {
            this.sensor = matcher.group(1);
        } else {
            throw new IllegalArgumentException("Invalid sensor format");
        }
    }

    public String getSensor() {
        return sensor;
    }

    public String getFormatted() {
        return "Sensor: " + sensor;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning not supported");
        }
    }
}
