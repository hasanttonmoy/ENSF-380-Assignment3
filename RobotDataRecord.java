import java.util.ArrayList;
import java.util.Arrays;

public class RobotDataRecord implements Cloneable {
    private ArrayList<RobotDataLine> log;

    public RobotDataRecord(String[] array) {
        log = new ArrayList<>();
        for (String line : array) {
            try {
                RobotDataLine dataLine = new RobotDataLine(line);
                log.add(dataLine);
            } catch (IllegalArgumentException e) {
                System.err.println("Invalid data line: " + line);
            }
        }
    }

    public RobotDataLine getLine(int index) {
        return log.get(index);
    }

    public ArrayList<RobotDataLine> getDataRecord() {
        return log;
    }

    @Override
    public Object clone() {
        try {
            RobotDataRecord cloned = (RobotDataRecord) super.clone();
            cloned.log = new ArrayList<>();
            for (RobotDataLine dataLine : log) {
                cloned.log.add((RobotDataLine) dataLine.clone());
            }
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning not supported");
        }
    }
}
