import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        var roomRates = new RoomRates();

        roomRates.addRoomRate("Standard", 1000);
        roomRates.addRoomRate("Deluxe", 1200);
        roomRates.addRoomRate("Superior", 1800);

        var hotelRoomDetail = new HotelRoomDetails(roomRates);

        hotelRoomDetail.addRoomDetails("Standard", "Comfortable and budget-friendly accommodation", "1-250", "Twin or Double");
        hotelRoomDetail.addRoomDetails("Deluxe", "Enhanced comfort and additional space", "251-500", "Queen-size bed");
        hotelRoomDetail.addRoomDetails("Superior", "Luxury and premium services", "501-530", "Queen or king-size bed");

        var guestDetails = new GuestDetails();

        guestDetails.addGuestDetails( "Qazi", "Zubair", 1, 255, "Deluxe", "Queen-size");
        guestDetails.addGuestDetails( "Oliver", "Barker", 3, 501, "Superior", "King-size");
        guestDetails.addGuestDetails( "Akram", "Khan", 20, 30, "Standard", "Double");
        guestDetails.addGuestDetails( "Jordan", "Robinson", 14, 45, "Standard", "Double");
        guestDetails.addGuestDetails( "Daniel", "Scott", 10, 22, "Standard", "Twin");

        var hotelReservation = new Reservation(hotelRoomDetail, guestDetails);
        var reportGenerator = new ReportGenerator(hotelRoomDetail, hotelReservation);

        while (true) {
//            hotelReservation.reserveRoom();
            hotelReservation.reserveGroupOfRooms();
            reportGenerator.generateIncomeReport();
            hotelReservation.searchGuestsByName();
            hotelReservation.cancelReservation();
        }

//        var roomTiers = new String[][] {
//                { "Standard", "Comfortable and budget-friendly accommodation", "1-250", "Twin or Double", "1000" },
//                { "Deluxe", "Enhanced comfort and additional space", "251-500", "Queen-size bed", "1200" },
//                { "Superior", "Luxury and premium services", "501-530", "Queen or king-size bed", "1800" },
//        };
//
//        // Let's get setup.
//        var scanner = new Scanner(System.in);
//        // How many hotel rooms do you have?
//
//        int totalRooms = -1;
//
//        while (true) {
//            System.out.print("How many rooms do you have: ");
//            if (scanner.hasNextInt()) {
//                totalRooms = scanner.nextInt();
//                break;
//            }
//            scanner.next();
//            System.out.println("Invalid number, please enter a valid number.");
//        }
//        var hotelRooms = new HashMap<Integer, HotelRoom>();
//
//        for (int i = 1; i <= totalRooms; i++) {
//            if (i <= 250) {
//                hotelRooms.put(i, new HotelRoom(new Classification("","Comfortable and budget-friendly accommodation", RoomType.Twin.value | RoomType.Double.value, 1000)));
//                continue;
//            }
//
//            if (i <= 500) {
//                hotelRooms.put(i, new HotelRoom(new Classification("", "Comfortable and budget-friendly accommodation", RoomType.Twin.value | RoomType.Double.value, 1000)));
//                continue;
//            }
//
//            hotelRooms.put(i, new HotelRoom(new Classification("", "Comfortable and budget-friendly accommodation", RoomType.Twin.value | RoomType.Double.value, 1000)));
//        }
//
////        for (String[] row : roomTiers) {
////            hotelRooms.put(row[0], new Classification(row[1], row[2], row[3]));
////        }
//
////        for (String[] row : tierPrices) {
////            var key = row[0];
////
////            if (!roomDetails.containsKey(key))
////                continue;
////
////            roomDetails.get(key).set
////        }
    }
}