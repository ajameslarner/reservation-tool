import java.util.Map;

public interface ReservationProvider {
    Map<Integer, Map<String, Object>> getReservations();
}
