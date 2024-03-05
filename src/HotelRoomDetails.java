import java.util.HashMap;
import java.util.Map;

public class HotelRoomDetails {

    private final Map<String, Map<String, String>> roomDetails;

    public HotelRoomDetails() {
        this.roomDetails = new HashMap<>();
    }

    public void addRoomDetails(String roomClass, String roomDescription, String roomRange, String roomType) {
        Map<String, String> roomDetail = new HashMap<>();

        roomDetail.put("Class", roomClass);
        roomDetail.put("Description", roomDescription);
        roomDetail.put("RoomRange", roomRange);
        roomDetail.put("RoomType", roomType);

        roomDetails.put(roomClass, roomDetail);
    }
}
