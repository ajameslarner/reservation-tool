import java.util.*;

public class Reservation implements ReservationProvider{
    private static final Map<Integer, Map<String, Object>> reservations = new HashMap<>();
    private final HotelRoomDataProvider hotelRoomDetails;
    private final GuestDetailsProvider guestDetailsProvider;

    public Reservation(HotelRoomDataProvider hotelRoomDetails, GuestDetailsProvider guestDetailsProvider) {
        this.hotelRoomDetails = hotelRoomDetails;
        this.guestDetailsProvider = guestDetailsProvider;
    }

    @Override
    public Map<Integer, Map<String, Object>> getReservations() {
        return new HashMap<>(reservations);
    }

    private static boolean isRoomAvailable(int roomNumber) {
        return !reservations.containsKey(roomNumber);
    }

    private boolean checkRoomValidity(String roomClass, String bedType) {
        Map<String, String> roomDetail = hotelRoomDetails.getRoomDetails().get(roomClass);
        if (roomDetail != null) {
            String validRoomType = roomDetail.get("RoomType");
            return validRoomType.contains(bedType);
        }
        return false;
    }

    private int findAvailableRoom(String roomClass, String bedType) {
        Map<String, String> roomDetail = hotelRoomDetails.getRoomDetails().get(roomClass);
        if (roomDetail != null) {
            String roomRange = roomDetail.get("RoomRange");
            int startRoomNumber = Integer.parseInt(roomRange.split("-")[0]);
            int endRoomNumber = Integer.parseInt(roomRange.split("-")[1]);

            for (int roomNumber = startRoomNumber; roomNumber <= endRoomNumber; roomNumber++) {
                if (isRoomAvailable(roomNumber) && checkRoomValidity(roomClass, bedType)) {
                    return roomNumber;
                }
            }
        }
        return -1;
    }

    public void reserveRoom() {
        Scanner scanner = new Scanner(System.in);
        boolean reserveAnotherRoom = true;

        do {
            System.out.println("New Reservation: (Enter EXIT at any point to cancel)");
            scanner.nextLine();

            try {
                String roomClass;
                do {
                    System.out.print("Enter the choice of class (Standard, Deluxe, Superior): ");
                    roomClass = scanner.nextLine();

                    if (roomClass.equalsIgnoreCase("Exit")) {
                        System.out.println("Reservation canceled.");
                        return;
                    }

                    if (!hotelRoomDetails.getRoomDetails().containsKey(roomClass)) {
                        System.out.println("Invalid room class. Please select Standard, Deluxe, or Superior.");
                    }
                } while (!hotelRoomDetails.getRoomDetails().containsKey(roomClass));

                String bedType;
                do {
                    System.out.print("Enter the choice of bed type: ");
                    bedType = scanner.nextLine();

                    if (bedType.equalsIgnoreCase("Exit")) {
                        System.out.println("Reservation canceled.");
                        return;
                    }

                    Map<String, String> roomDetail = hotelRoomDetails.getRoomDetails().get(roomClass);
                    if (roomDetail != null) {
                        if (!roomDetail.get("RoomType").contains(bedType)) {
                            System.out.println("Invalid bed type for the selected room class. Please choose " + roomDetail.get("RoomType") + ".");
                        }
                    }
                } while (!hotelRoomDetails.getRoomDetails().get(roomClass).get("RoomType").contains(bedType));

                System.out.print("Enter the guest's first name: ");
                String firstName = scanner.nextLine();

                System.out.print("Enter the guest's last name: ");
                String lastName = scanner.nextLine();

                int lengthOfStay;
                do {
                    System.out.print("Enter the length of stay in nights: ");
                    try {
                        lengthOfStay = scanner.nextInt();
                        if (lengthOfStay <= 0) {
                            System.out.println("Length of stay must be greater than 0.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid numeric value for length of stay.");
                        scanner.nextLine();
                        lengthOfStay = -1;
                    }
                } while (lengthOfStay <= 0);

                int roomNumber = findAvailableRoom(roomClass, bedType);

                if (roomNumber != -1) {
                    Map<String, Object> reservationDetails = new HashMap<>();
                    reservationDetails.put("FirstName", firstName);
                    reservationDetails.put("LastName", lastName);
                    reservationDetails.put("LengthOfStay", lengthOfStay);
                    reservationDetails.put("RoomReserved", roomNumber);
                    reservationDetails.put("Class", roomClass);
                    reservationDetails.put("BedType", bedType);

                    reservations.put(roomNumber, reservationDetails);

                    guestDetailsProvider.addGuestDetails(firstName, lastName, lengthOfStay, roomNumber, roomClass, bedType);

                    System.out.println("Reservation Details:");
                    System.out.println("FirstName: " + firstName);
                    System.out.println("LastName: " + lastName);
                    System.out.println("LengthOfStay: " + lengthOfStay);
                    System.out.println("RoomReserved: " + roomNumber);
                    System.out.println("Class: " + roomClass);
                    System.out.println("BedType: " + bedType);
                    System.out.println("--------------------------");
                } else {
                    System.out.println("No available room found within the specified range for " + roomClass + ".");
                }
            } catch (NoSuchElementException e) {
                System.out.println("Input not found. Please enter all required information.");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred. Please try again.");
            }

            scanner.nextLine();

            String response;
            do {
                System.out.print("Do you wish to reserve another room? Select Yes (Y) or No (N): ");
                response = scanner.nextLine();
                if (!response.equalsIgnoreCase("Y") && !response.equalsIgnoreCase("N") && !response.equalsIgnoreCase("Exit")) {
                    System.out.println("Invalid input. Please enter Y, N, or EXIT.");
                }
            } while (!response.equalsIgnoreCase("Y") && !response.equalsIgnoreCase("N") && !response.equalsIgnoreCase("Exit"));

            if (response.equalsIgnoreCase("Exit")) {
                System.out.println("Reservation canceled.");
                return;
            }

            if (response.equalsIgnoreCase("N")) {
                reserveAnotherRoom = false;
            }

        } while (reserveAnotherRoom);
    }

    public void cancelReservation() {
        Scanner scanner = new Scanner(System.in);
        boolean cancelAnotherRoom = true;

        do {
            System.out.println("Cancel Reservation: (Enter EXIT at any point to cancel)");
            scanner.nextLine();

            try {
                String roomNumber;
                    System.out.print("Enter the room number: ");
                    roomNumber = scanner.nextLine();

                    if (roomNumber.equalsIgnoreCase("Exit")) {
                        System.out.println("Cancellation canceled.");
                        return;
                    }

                    if (isNumeric(roomNumber)) {
                    int roomNumberValue = Integer.parseInt(roomNumber);
                    if (reservations.containsKey(roomNumberValue)) {
                        Map<String, Object> reservationDetails = reservations.get(roomNumberValue);
                        String lastName;
                        int lengthOfStay = -1;
                        String reservedRoomClass = (String) reservationDetails.get("Class");
                        String reservedBedType = (String) reservationDetails.get("BedType");

                        do {
                            System.out.print("Enter the guest’s last name: ");
                            lastName = scanner.nextLine();
                            if (!lastName.equalsIgnoreCase(reservationDetails.get("LastName").toString())) {
                                System.out.println("Invalid last name. Please enter the correct last name.");
                            }
                        } while (!lastName.equalsIgnoreCase(reservationDetails.get("LastName").toString()));

                        do {
                            System.out.print("Enter the length of stay (nights): ");
                            try {
                                lengthOfStay = scanner.nextInt();
                                if (lengthOfStay != (int) reservationDetails.get("LengthOfStay")) {
                                    System.out.println("Invalid length of stay. Please enter the correct length of stay.");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a valid numeric value for length of stay.");
                                scanner.nextLine();
                            }
                        } while (lengthOfStay != (int) reservationDetails.get("LengthOfStay"));

                        reservations.remove(roomNumberValue);
                        guestDetailsProvider.removeGuestDetails(roomNumberValue);
                        System.out.println("--------------------------");
                        System.out.println("Reservation canceled for:");
                        System.out.println("First name: " + reservationDetails.get("FirstName"));
                        System.out.println("Last name: " + reservationDetails.get("LastName"));
                        System.out.println("Length of stay: " + reservationDetails.get("LengthOfStay"));
                        System.out.println("Reserved room canceled: " + roomNumberValue);
                        System.out.println("Class: " + reservedRoomClass);
                        System.out.println("Type: " + reservedBedType);
                        System.out.println("--------------------------");
                    } else {
                        System.out.println("Invalid room number. No reservation found.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid room number or 'Exit'.");
                }

            } catch (NoSuchElementException e) {
                System.out.println("Input not found. Please enter all required information.");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred. Please try again.");
            }

            scanner.nextLine();

            String response;
            do {
                System.out.print("Do you wish to cancel another reservation? Select Yes (Y) or No (N): ");
                response = scanner.next();
                if (!response.equalsIgnoreCase("Y") && !response.equalsIgnoreCase("N") && !response.equalsIgnoreCase("Exit")) {
                    System.out.println("Invalid input. Please enter Y, N, or Exit.");
                }
            } while (!response.equalsIgnoreCase("Y") && !response.equalsIgnoreCase("N") && !response.equalsIgnoreCase("Exit"));

            if (response.equalsIgnoreCase("Exit")) {
                System.out.println("Cancellation canceled.");
                return;
            }

            if (response.equalsIgnoreCase("N")) {
                cancelAnotherRoom = false;
            }

        } while (cancelAnotherRoom);
    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void searchGuestsByName() {
        Scanner scanner = new Scanner(System.in);
        boolean searchAgain = true;

        do {
            System.out.println("Reservation Search: (Enter EXIT at any point to cancel)");
            scanner.nextLine();

            System.out.print("Enter the guest's first name: ");
            String firstName = scanner.nextLine();

            System.out.print("Enter the guest's last name: ");
            String lastName = scanner.nextLine();

            Map<Integer, Map<String, Object>> searchResults = guestDetailsProvider.searchGuestsByName(firstName, lastName);

            if (searchResults.isEmpty()) {
                System.out.println("No matching guests found.");
            } else {
                System.out.println(searchResults.size() + " Matching Guests:");

                for (Map.Entry<Integer, Map<String, Object>> entry : searchResults.entrySet()) {
                    int roomNumber = entry.getKey();
                    Map<String, Object> guestDetail = entry.getValue();

                    System.out.println("Room Number: " + roomNumber);
                    System.out.println("First Name: " + guestDetail.get("FirstName"));
                    System.out.println("Last Name: " + guestDetail.get("LastName"));
                    System.out.println("Length of Stay: " + guestDetail.get("LengthOfStay"));
                    System.out.println("Room Reserved: " + guestDetail.get("RoomReserved"));
                    System.out.println("Room Class: " + guestDetail.get("RoomClass"));
                    System.out.println("Bed Type: " + guestDetail.get("BedType"));
                    System.out.println("--------------------------");
                    System.out.println();
                }
            }

            String response;
            do {
                System.out.print("Do you want to search again? Select Yes (Y) or No (N): ");
                response = scanner.nextLine();
                if (!response.equalsIgnoreCase("Y") && !response.equalsIgnoreCase("N") && !response.equalsIgnoreCase("EXIT")) {
                    System.out.println("Invalid input. Please enter Y, N, or EXIT.");
                }
            } while (!response.equalsIgnoreCase("Y") && !response.equalsIgnoreCase("N") && !response.equalsIgnoreCase("EXIT"));

            if (response.equalsIgnoreCase("EXIT")) {
                System.out.println("Search canceled.");
                return;
            }

            if (response.equalsIgnoreCase("N")) {
                searchAgain = false;
            }

        } while (searchAgain);
    }

    public void reserveGroupOfRooms() {
        Scanner scanner = new Scanner(System.in);
        boolean reserveAnotherGroup = true;

        do {
            System.out.println("New Group Reservation: (Press ESC to restart at any point)");
            scanner.nextLine();

            try {
                String roomClass;
                do {
                    System.out.print("Enter the choice of class (Standard, Deluxe, Superior): ");
                    roomClass = scanner.nextLine();

                    if (roomClass.equalsIgnoreCase("Exit")) {
                        System.out.println("Group reservation canceled.");
                        return;
                    }

                    if (!hotelRoomDetails.getRoomDetails().containsKey(roomClass)) {
                        System.out.println("Invalid room class. Please select Standard, Deluxe, or Superior.");
                    }
                } while (!hotelRoomDetails.getRoomDetails().containsKey(roomClass));

                List<Integer> reservedRoomNumbers = new ArrayList<>();
                int numberOfRooms;
                do {
                    System.out.print("Enter the number of rooms to reserve (not more than 3): ");
                    try {
                        numberOfRooms = scanner.nextInt();
                        if (numberOfRooms <= 0 || numberOfRooms > 3) {
                            System.out.println("Number of rooms must be between 1 and 3.");
                            numberOfRooms = -1;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid numeric value for the number of rooms.");
                        scanner.nextLine();
                        numberOfRooms = -1;
                    }
                } while (numberOfRooms <= 0);

                for (int i = 1; i <= numberOfRooms; i++) {
                    String bedType;
                    do {
                        System.out.println("Enter the choice of bed type for Room " + i + ": ");
                        bedType = scanner.nextLine();

                        if (bedType.equalsIgnoreCase("Exit")) {
                            System.out.println("Group reservation canceled.");
                            return;
                        }

                        Map<String, String> roomDetails = hotelRoomDetails.getRoomDetails().get(roomClass);
                        if (roomDetails != null) {
                            if (roomDetails.get("RoomType").contains(bedType)) {
                                break;
                            }
                            System.out.println("Invalid bed type for the selected room class. Please choose " + roomDetails.get("RoomType") + ".");
                        }

                        System.out.println("Invalid bed type for the selected room class.");

                    } while (true);

                    int roomNumber = findAvailableRoom(roomClass, bedType);

                    if (roomNumber != -1) {
                        reservedRoomNumbers.add(roomNumber);
                    } else {
                        System.out.println("No available room found within the specified range for " + roomClass + ". Group reservation canceled.");
                        return;
                    }
                }

                for (int roomNumber : reservedRoomNumbers) {
                    Map<String, Object> reservationDetails = new HashMap<>();
                    reservationDetails.put("FirstName", "Group Reservation");
                    reservationDetails.put("LastName", "Group Reservation");
                    reservationDetails.put("LengthOfStay", 1);
                    reservationDetails.put("RoomReserved", roomNumber);
                    reservationDetails.put("Class", roomClass);

                    reservations.put(roomNumber, reservationDetails);

                    System.out.println("Reservation Details for Room " + roomNumber + ":");
                    System.out.println("FirstName: Group Reservation");
                    System.out.println("LastName: Group Reservation");
                    System.out.println("LengthOfStay: 1");
                    System.out.println("RoomReserved: " + roomNumber);
                    System.out.println("Class: " + roomClass);
                    System.out.println("--------------------------");
                    System.out.println();
                }

            } catch (NoSuchElementException e) {
                System.out.println("Input not found. Please enter all required information.");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred. Please try again.");
            }

            scanner.nextLine();

            String response;
            do {
                System.out.print("Do you wish to reserve another group of rooms? Select Yes (Y) or No (N): ");
                response = scanner.nextLine();
                if (!response.equalsIgnoreCase("Y") && !response.equalsIgnoreCase("N") && !response.equalsIgnoreCase("EXIT")) {
                    System.out.println("Invalid input. Please enter Y, N, or EXIT.");
                }
            } while (!response.equalsIgnoreCase("Y") && !response.equalsIgnoreCase("N") && !response.equalsIgnoreCase("EXIT"));

            if (response.equalsIgnoreCase("EXIT")) {
                System.out.println("Group reservation canceled.");
                return;
            }

            if (response.equalsIgnoreCase("N")) {
                reserveAnotherGroup = false;
            }

        } while (reserveAnotherGroup);
    }
}
