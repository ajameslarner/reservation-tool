import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HotelRoomDetails implements HotelRoomDataProvider {

    private final Map<String, Map<String, String>> roomDetails;
    private final RoomRatesProvider roomRates;

    public HotelRoomDetails(RoomRatesProvider roomRates) {
        this.roomDetails = new HashMap<>();
        this.roomRates = roomRates;
    }

    public void addRoomDetails(String roomClass, String roomDescription, String roomRange, String roomType) {
        Map<String, String> roomDetail = new HashMap<>();

        roomDetail.put("Class", roomClass);
        roomDetail.put("Description", roomDescription);
        roomDetail.put("RoomRange", roomRange);
        roomDetail.put("RoomType", roomType);

        roomDetails.put(roomClass, roomDetail);
    }

    @Override
    public Map<String, Map<String, String>> getRoomDetails() {
        return Collections.unmodifiableMap(roomDetails);
    }

    @Override
    public double getRoomRate(String roomClass) {
        Integer rate = roomRates.getRoomRate(roomClass);

        if (rate != null) {
            return rate;
        } else {
            // Handle the case where the room rate for the specified class is not found
            throw new IllegalArgumentException("Room rate not available for class: " + roomClass);
        }
    }
}
