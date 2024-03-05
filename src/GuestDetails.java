import java.util.HashMap;
import java.util.Map;

public class GuestDetails {

    private final Map<Integer, Map<String, Object>> guestDetails;

    public GuestDetails() {
        this.guestDetails = new HashMap<>();
    }

    public void addGuestDetails(String firstName, String lastName, int lengthOfStay, int roomReserved, String roomClass, String bedType) {
        Map<String, Object> guestDetail = new HashMap<>();

        guestDetail.put("FirstName", firstName);
        guestDetail.put("LastName", lastName);
        guestDetail.put("LengthOfStay", lengthOfStay);
        guestDetail.put("RoomReserved", roomReserved);
        guestDetail.put("RoomClass", roomClass);
        guestDetail.put("BedType", bedType);

        guestDetails.put(roomReserved, guestDetail);
    }

    public Map<String, Object> getGuestDetails(int roomNumber) {
        return guestDetails.get(roomNumber);
    }
}
