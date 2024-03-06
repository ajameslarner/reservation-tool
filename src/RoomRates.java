import java.util.HashMap;
import java.util.Map;

public class RoomRates implements RoomRatesProvider{

    private final Map<String, Integer> roomRates;

    public RoomRates() {
        this.roomRates = new HashMap<>();
    }

    @Override
    public void addRoomRate(String roomClass, int roomRate) {
        roomRates.put(roomClass, roomRate);
    }

    @Override
    public Integer getRoomRate(String roomClass) {
        return roomRates.get(roomClass);
    }
}
