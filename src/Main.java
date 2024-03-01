import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        var roomTiers = new String[][] {
                { "Standard", "Comfortable and budget-friendly accommodation", "1-250", "Twin or Double", "1000" },
                { "Deluxe", "Enhanced comfort and additional space", "251-500", "Queen-size bed", "1200" },
                { "Superior", "Luxury and premium services", "501-530", "Queen or king-size bed", "1800" },
        };

        // Let's get setup.
        var scanner = new Scanner(System.in);
        // How many hotel rooms do you have?

        int totalRooms = -1;

        while (true) {
            System.out.print("How many rooms do you have: ");
            if (scanner.hasNextInt()) {
                totalRooms = scanner.nextInt();
                break;
            }
            scanner.next();
            System.out.println("Invalid number, please enter a valid number.");
        }

        var hotelRooms = new HashMap<Integer, HotelRoom>();

        for (int i = 1; i <= totalRooms; i++) {
            if (i <= 250) {
                hotelRooms.put(i, new HotelRoom(new Classification("","Comfortable and budget-friendly accommodation", RoomType.Twin.value | RoomType.Double.value, 1000)));
                continue;
            }

            if (i <= 500) {
                hotelRooms.put(i, new HotelRoom(new Classification("", "Comfortable and budget-friendly accommodation", RoomType.Twin.value | RoomType.Double.value, 1000)));
                continue;
            }

            hotelRooms.put(i, new HotelRoom(new Classification("", "Comfortable and budget-friendly accommodation", RoomType.Twin.value | RoomType.Double.value, 1000)));
        }

//        for (String[] row : roomTiers) {
//            hotelRooms.put(row[0], new Classification(row[1], row[2], row[3]));
//        }

//        for (String[] row : tierPrices) {
//            var key = row[0];
//
//            if (!roomDetails.containsKey(key))
//                continue;
//
//            roomDetails.get(key).set
//        }
    }
}