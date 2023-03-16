import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Movement implements Cloneable {
    private static final String REGEX = "\"([A-Z]+) - ([A-Z]{1,2})";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    private Actions action;
    private Directions direction;

    public Movement(String movement) {
        Matcher matcher = PATTERN.matcher(movement);
        if (matcher.find()) {
            action = Actions.valueOf(matcher.group(1));
            direction = Directions.valueOf(matcher.group(2));
        } else {
            throw new IllegalArgumentException("Invalid movement format");
        }
    }

    public Actions getAction() {
        return action;
    }

    public Directions getDirection() {
        return direction;
    }

    public String getFormatted() {
        return "Action: " + action + ", Direction: " + direction.toString();
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
