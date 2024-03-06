import java.util.Map;

public interface GuestDetailsProvider {
    void addGuestDetails(String firstName, String lastName, int lengthOfStay, int roomReserved, String roomClass, String bedType);

    Map<String, Object> getGuestDetails(int roomNumber);

    void removeGuestDetails(int roomNumber);

    Map<Integer, Map<String, Object>> searchGuestsByName(String firstName, String lastName);
}
