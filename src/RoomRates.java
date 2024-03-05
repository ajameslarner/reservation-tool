import java.util.HashMap;
import java.util.Map;

public class RoomRates {

    private final Map<String, Integer> roomRates;

    public RoomRates() {
        this.roomRates = new HashMap<>();
    }

    public void addRoomRate(String roomClass, int roomRate) {
        roomRates.put(roomClass, roomRate);
    }

    public Integer getRoomRate(String roomClass) {
        return roomRates.get(roomClass);
    }
}
