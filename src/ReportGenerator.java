import java.util.Map;

public class ReportGenerator {
    private final HotelRoomDataProvider hotelRoomDataProvider;
    private final ReservationProvider reservationProvider;

    public ReportGenerator(HotelRoomDataProvider hotelRoomDataProvider, ReservationProvider reservationProvider) {
        this.hotelRoomDataProvider = hotelRoomDataProvider;
        this.reservationProvider = reservationProvider;
    }

    public void generateIncomeReport() {
        Map<Integer, Map<String, Object>> reservations = reservationProvider.getReservations();

        double totalSuperiorIncome = 0;
        double totalStandardIncome = 0;
        double totalDeluxeIncome = 0;

        for (Map<String, Object> reservation : reservations.values()) {
            String roomClass = (String) reservation.get("Class");
            int roomNumber = (int) reservation.get("RoomReserved");
            int lengthOfStay = (int) reservation.get("LengthOfStay");

            double roomRate = hotelRoomDataProvider.getRoomRate(roomClass);

            double totalIncome = roomRate * lengthOfStay;

            switch (roomClass) {
                case "Superior":
                    totalSuperiorIncome += totalIncome;
                    break;
                case "Standard":
                    totalStandardIncome += totalIncome;
                    break;
                case "Deluxe":
                    totalDeluxeIncome += totalIncome;
                    break;
            }
        }

        System.out.println("Class\t\tNumber of rooms\tTotal income generated");
        System.out.println("Superior\t" + getNumberOfRooms("Superior") + "\t\t\t\t£" + totalSuperiorIncome);
        System.out.println("Standard\t" + getNumberOfRooms("Standard") + "\t\t\t\t£" + totalStandardIncome);
        System.out.println("Deluxe\t\t" + getNumberOfRooms("Deluxe") + "\t\t\t\t£" + totalDeluxeIncome);

    }

    // Inside the ReportGenerator class
    private int getNumberOfRooms(String roomClass) {
        Map<Integer, Map<String, Object>> reservations = reservationProvider.getReservations();

        int numberOfRooms = 0;

        for (Map<String, Object> reservation : reservations.values()) {
            String reservationRoomClass = (String) reservation.get("Class");

            // Check if the reservation matches the specified room class
            if (reservationRoomClass.equals(roomClass)) {
                numberOfRooms++;
            }
        }

        return numberOfRooms;
    }
}