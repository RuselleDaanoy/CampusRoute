import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ZoneRoom {

    private String roomsText, targetFloor;
    private HashMap<Integer, ArrayList<String>> floorZones;

    public ZoneRoom(String targetFloor) {
        this.targetFloor = targetFloor;
        this.floorZones = new HashMap<>();
        byFloor(targetFloor);
    }

    public void byFloor(String targetFloor) {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\thoby\\WALK\\src\\MainBuilding.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length >= 3 && parts[1].equals(targetFloor)) {
                    int floorZone = Integer.parseInt(parts[2]); // Parse zone as integer
                    ArrayList<String> rooms = floorZones.getOrDefault(floorZone, new ArrayList<>());
                    rooms.add(parts[0]);
                    floorZones.put(floorZone, rooms);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Sort floorZones map by key (zone)
        Map<Integer, ArrayList<String>> sortedFloorZones = new TreeMap<>(floorZones);

        StringBuilder builder = new StringBuilder();

        for (int zone : sortedFloorZones.keySet()) {
            builder.append(">>>");
            builder.append("Zone " + zone).append(" Room/s:\n");
            for (String room : sortedFloorZones.get(zone)) {
                builder.append("- ").append(room).append("\n");
            }
            builder.append("\n");
        }
        this.roomsText = builder.toString();
    }

    public String getRoomsText() {
        return roomsText;
    }

    public String getTargetFloor() {
        return targetFloor;
    }

    public void setTargetFloor(String targetFloor) {
        this.targetFloor = targetFloor;
        // Re-run byFloor method when targetFloor is changed
        byFloor(targetFloor);
    }
}
