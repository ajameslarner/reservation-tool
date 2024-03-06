import java.util.Map;

public interface HotelRoomDataProvider {
    Map<String, Map<String, String>> getRoomDetails();
    double getRoomRate(String roomClass);
}
