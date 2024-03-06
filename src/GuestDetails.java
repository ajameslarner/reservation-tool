import java.util.HashMap;
import java.util.Map;

public class GuestDetails implements GuestDetailsProvider {

    private final Map<Integer, Map<String, Object>> guestDetails;

    public GuestDetails() {
        this.guestDetails = new HashMap<>();
    }

    @Override
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

    @Override
    public Map<String, Object> getGuestDetails(int roomNumber) {
        return guestDetails.get(roomNumber);
    }

    @Override
    public void removeGuestDetails(int roomNumber) {
        guestDetails.remove(roomNumber);
    }

    @Override
    public Map<Integer, Map<String, Object>> searchGuestsByName(String firstName, String lastName) {
        Map<Integer, Map<String, Object>> result = new HashMap<>();

        for (Map.Entry<Integer, Map<String, Object>> entry : guestDetails.entrySet()) {
            Map<String, Object> guestDetail = entry.getValue();
            if (firstName.equalsIgnoreCase((String) guestDetail.get("FirstName")) && lastName.equalsIgnoreCase((String) guestDetail.get("LastName"))) {
                result.put(entry.getKey(), guestDetail);
            }
        }

        return result;
    }
}