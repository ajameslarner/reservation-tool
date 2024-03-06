### Algorithm: StoreRoomDetails

Plain text english
```
Initialise room_details as an empty key-value data structure

Function add_room_detail(room_class, room_description, room_numbers, room_type):
    Initialise room_detail as an empty key-value data structure
    add new key-value pair to room_detail with "Description" as the key and room_description as the value
    add new key-value pair to room_detail with "RoomNumbers" as the key and room_numbers as the value
    add new key-value pair to room_detail with "RoomType" as the key and room_type as the value
    
    Add new key-value pair to room_details with room_class as the key and room_detail as the value
    
add_room_detail("Standard", "Comfortable and budget-friendly accommodation", "1-250", "Twin or Double")
add_room_detail("Deluxe", "Enhanced comfort and additional space", "251-500", "Queen-size bed")
add_room_detail("Superior", "Luxury and premium services", "501-530", "Queen or king-size bed")
```

Pseudo-code
```
Initialise roomDetails as an empty hashmap

Function addRoomDetail(roomClass, roomDescription, roomNumbers, roomType):
    roomDetails[roomClass] = {
        "Description": roomDescription,
        "RoomNumbers": roomNumbers,
        "roomType": roomType
    }
    
addRoomDetail("Standard", "Comfortable and budget-friendly accommodation", "1-250", "Twin or Double")
addRoomDetail("Deluxe", "Enhanced comfort and additional space", "251-500", "Queen-size bed")
addRoomDetail("Superior", "Luxury and premium services", "501-530", "Queen or king-size bed")
```
### Algorithm: StoreRoomRates

Plain text english
```
Initialise room_rates as an empty key-value data structure

Function add_room_rate(room_class, room_rate):
    Add new key-value pair to room_rates with room_class as the key with room_rate as the value
    
add_room_rate("Standard", 1000)
add_room_rate("Deluxe", 1200)
add_room_rate("Superior", 1800)
```
Pseudo-code
```
Initialise roomRates as an empty hashmap

Function addRoomRate(roomClass, roomRate):
    roomRates[roomClass] = roomRate
    
addRoomRate("Standard", 1000)
addRoomRate("Deluxe", 1200)
addRoomRate("Superior", 1800)
```

### Algorithm: StoreGuestDetails

Plain text english
```
Initialise guest_details as an empty key-value pair data structure

Function add_guest_details(first_name, last_name, length_of_stay, room_reserved, room_class, bed_type):
    Initialise guest_detail as an empty key-value data structure
    add new key-value pair to guest_detail with "FirstName" as the key and first_name as the value
    add new key-value pair to guest_detail with "LastName" as the key and last_name as the value
    add new key-value pair to guest_detail with "LengthOfStay" as the key and length_of_stay as the value
    add new key-value pair to guest_detail with "RoomReserved" as the key and room_reserved as the value
    add new key-value pair to guest_detail with "RoomClass" as the key and room_class as the value
    add new key-value pair to guest_detail with "BedType" as the key and bed_type as the value
    
    Add new key-value pair to guest_details with room_reserved as the key and guest_detail as the value

add_guest_details("Qazi", "Zubair", "1", "255", "Deluxe", "Queen-size bed")
...
...
```

Pseudo-code
```
Initialise guestDetails as an empty hashmap

Function addGuestDetails(firstName, lastName, lengthOfStay, roomReserved, roomClass, roomType):
    guestDetails[roomReserved] = {
        "FirstName": firstName,
        "LastName": lastName,
        "LengthOfStay": lengthOfStay,
        "RoomReserved": roomReserved,
        "RoomClass": roomClass,
        "RoomType": roomType
    }
    
addGuestDetails("Qazi", "Zubair", "1", "255", "Deluxe", "Queen-size bed")
...
...
...
```

### Algorithm: ReserveRoomForGuest

Pseudocode
```
Inject and initialise hotel_room_details as a dependency
Inject and initialise hotel_guest_details as a dependency

Initialise reservations as a key-value data structure

Function is_room_available(room_number):
    return reservations does not contain room_number
    
Function check_room_validity(room_number, room_class, bed_type):
    Initiliase room_detail as hotel_room_details get_room_details with room_class
    
    if room_detail is not null:
        Initialise valid_room_type with room_detail get "RoomType"
        return valid_room_type contains bed_type

    return false

Function find_available_room(room_class, bed_type):
    Initiliase room_detail as hotel_room_details get_room_details with room_class
    
    if room_detail is not null:
        Initialise room_range with room_detail get "RoomRange"
        Initialise start_room_number with parse room_range split at index 0
        Initialise start_room_number with parse room_range split at index 1

        for room_number from start_room_number to start_room_number:
            if is_room_available with room_umber and check_room_validity with room_number, room_class, bed_type):
                return roomNumber

    return -1


Function reserve_room():
    Initialise input_scanner as a new scanner
    create and set reserve_another_room to true

    do:
        print("New Reservation: (Press ESC to cancel at any point)")
        wait for input_scanner next line

        try:
            Initiliase room_class as an empty string
            do:
                print("Enter the choice of class (Standard, Deluxe, Superior): ")
                Wait and assign input_scanner next line to room_class

                if room_class is equal to "Exit":
                    print("Reservation canceled.")
                    return

                if get_room_details for hotel_room_details does not contain room_class:
                    print("Invalid room class. Please select Standard, Deluxe, or Superior.")
            while hotel_room_details does not contain room_class

            Initialise bed_type as an empty string
            do:
                print("Enter the choice of bed type: ")
                Wait and assign input_scanner next line to bed_type

                if bed_type is equal to "Exit":
                    print("Reservation canceled.")
                    return

                Initiliase room_details as hotel_room_details get_room_details with room_class
                 if room_details is not null:
                    if room_details get "RoomType" does not contain bed_type:
                        print("Invalid bed type for the selected room class. Please choose room_details get "RoomType")
            while hotel_room_details get_room_details with room_class get "RoomType" does not contain bed_type

            print("Enter the guest's first name: ")
            Wait and initialise input_scanner to first_name

            print("Enter the guest's last name: ")
            Wait and initialise input_scanner to last_name

            Initialise length_of_stay as an int of 0
            do:
                print("Enter the length of stay in nights: ")
                try:
                    Wait and parse input_scanner to length_of_stay
                    if length_of_stay <= 0:
                        print("Length of stay must be greater than 0.")
                catch InputMismatchException:
                    print("Invalid input. Please enter a valid numeric value for length of stay.")
                    length_of_stay = -1
            while length_of_stay <= 0

            Initialise and assign room_number by calling find_available_room with room_class and bed_type

            if roomNumber is not -1:
                Initialise reservation_details as a key-value data structure
                Add new key-value pair to reservation_details with "FirstName" as the key and first_name as value
                Add new key-value pair to reservation_details with "LastName" as the key and last_name as value
                Add new key-value pair to reservation_details with "LengthOfStay" as the key and length_of_stay as value
                Add new key-value pair to reservation_details with "RoomReserved" as the key and room_number as value
                Add new key-value pair to reservation_details with "Class" as the key and room_class as value
                Add new key-value pair to reservation_details with "BedType" as the key and bed_type as value
                
                Add new key-value pair to reservations with room_number as the key and reservation_details as the value
                
                Call add_guest_details from hotel_guest_details with first_name, last_name, length_of_stay, room_number, room_class, bed_type

                print("Reservation Details:")
                print(first_name)
                print(last_name)
                print(length_of_stay)
                print(roomN_number)
                print(room_class)
                print(bed_type)
            else:
                print("No available room found within the specified range for room_class.")
        catch NoSuchElementException:
            print("Input not found. Please enter all required information.")
        catch Exception:
            print("An unexpected error occurred. Please try again.")

        Wait for input_scanner next line

        Initialise response as an empty string
        do:
            print("Do you wish to reserve another room? Select Yes (Y) or No (N): ")
            Assign response with input_scanner next line
            if response does not equal "Y", "N" or "Exit":
                print("Invalid input. Please enter Y, N, or Exit.")
        while response does not equal "Y", "N" or "Exit"

        if response equals "Exit":
            print("Reservation canceled.")
            return

        if response equals "N":
            set reserve_another_room to false
            
    while reserve_another_room
```

### Algorithm: CancelRoomForGuest

Pseudocode
```
Function cancel_reservation():
    Initialise input_scanner as a new scanner
    create and set cancel_another_room to true

    do:
        Print("Cancel Reservation: (Press EXIT to cancel at any point)")
        Wait for input_scanner next line

        try:
            Declare room_number as a string variable
            
            Print("Enter the choice of bed type or room number: ")
            Wait and assign input_scanner next line to room_number

            if bedTypeOrRoomNumber is equal to "Exit":
                Print("Cancellation canceled.")
                Return

            if is_numeric with room_number:
                Initialise room_number_value and parse room_number
                if reservations contains room_number_value:
                    Initialise reservation_details as a key-value data structure
                    Declare last_name as a string variable
                    Initialise length_of_stay as an int of -1
                    Initialise reserved_room_class from reservation_details get "Class"
                    Initialise reserved_bed_type from reservation_details get "BedType"

                    do:
                        Print("Enter the guest’s last name: ")
                        Wait and assign input_scanner next line to last_name
                        if last_name does not equal reservation_details get "LastName":
                            Print("Invalid last name. Please enter the correct last name.")
                    while last_name does not equal reservation_details get "LastName"

                    do:
                        Print("Enter the length of stay (nights): ")
                        Wait and assign input_scanner next line to length_of_stay
                        if length_of_stay does not equal reservation_details get "LengthOfStay":
                            Print("Invalid length of stay. Please enter the correct length of stay.")
                    while length_of_stay does not equal reservation_details get "LengthOfStay"

                    Remove from reservations using room_number_value
                    
                    Call hotel_guest_details remove_guest_details with room_number_value
                    
                    Print("Reservation canceled for:")
                    Print("First name: " + reservationDetails.get("FirstName"))
                    Print("Last name: " + reservationDetails.get("LastName"))
                    Print("Length of stay: " + reservationDetails.get("LengthOfStay"))
                    Print("Reserved room canceled: " + roomNumber)
                    Print("Class: " + reservedRoomClass)
                    Print("Type: " + reservedBedType)
                else:
                    Print("Invalid room number. No reservation found.")
            else:
                Print("Invalid input. Please enter a valid room number or 'Exit'.")
        catch NoSuchElementException:
            Print("Input not found. Please enter all required information.")
        catch Exception:
            Print("An unexpected error occurred. Please try again.")
            
        Declare response as a string variable
        do:
            Print("Do you wish to cancel another reservation? Select Yes (Y) or No (N): ")
            Wait and assign input_scanner next line to response
            
            if response does not equal "Y" and "N" and "EXIT":
                Print("Invalid input. Please enter Y, N, or Exit.")
        while response does not equal "Y" and "N" and "EXIT"

        if response equals "Exit":
            Print("Cancellation canceled.")
            return
           
        if response equals "N":
            set cancel_another_room to false

    while cancel_another_room
```

### Algorithm: SearchGuestReservations

Pseudocode
```
Function search_guests_by_name():
    Initialise scanner as a new Scanner
    Set search_again to true

    do:
        print("Reservation Search: (Enter EXIT at any point to cancel)")
        wait for scanner next line

        print("Enter the guest's first name: ")
        Initialise first_name as scanner next line

        print("Enter the guest's last name: ")
        Initialise last_name as scanner next line

        Initialise search_results as guest_details_provider search_guests_by_name with first_name, last_name

        if search_results is empty:
            print("No matching guests found.")
        else:
            print(search_results size + " Matching Guests:")

            for each entry in search_results:
                Initialise room_number as entry key
                Initialise guest_detail as entry value

                print("--------------------------")
                print("Room Number: " + room_number)
                print("First Name: " + guest_detail get "FirstName")
                print("Last Name: " + guest_detail get "LastName")
                print("Length of Stay: " + guest_detail get "LengthOfStay")
                print("Room Reserved: " + guest_detail get "RoomReserved")
                print("Room Class: " + guest_detail get "RoomClass")
                print("Bed Type: " + guest_detail get "BedType")
                print("--------------------------")
                print()

        Initialise response as an empty string
        do:
            print("Do you want to search again? Select Yes (Y) or No (N): ")
            Assign response with scanner next line
            if response does not equal "Y", "N" or "EXIT":
                print("Invalid input. Please enter Y, N, or EXIT.")
        while response does not equal "Y", "N" or "EXIT"

        if response equals "EXIT":
            print("Search canceled.")
            return

        if response equals "N":
            set search_again to false

    while search_again
```

### Algorithm: ReserveGroupByClass

Pseudocode
```
Function reserve_group_of_rooms():
    Initialise input_scanner as a new scanner
    Create and set reserve_another_group to true

    do:
        print("New Group Reservation: (Press ESC to restart at any point)")
        Wait for input_scanner next line

        try:
            Initialise room_class as an empty string
            do:
                print("Enter the choice of class (Standard, Deluxe, Superior): ")
                Wait and assign input_scanner next line to room_class

                if room_class is equal to "Exit":
                    print("Group reservation canceled.")
                    return

                if get_room_details for hotel_room_details does not contain room_class:
                    print("Invalid room class. Please select Standard, Deluxe, or Superior.")
            while hotel_room_details does not contain room_class

            Initialise reserved_room_numbers as an empty list
            Initialise number_of_rooms as 0
            do:
                print("Enter the number of rooms to reserve (not more than 3): ")
                try:
                    Wait and parse input_scanner to number_of_rooms
                    if number_of_rooms <= 0 or number_of_rooms > 3:
                        print("Number of rooms must be between 1 and 3.")
                        number_of_rooms = -1
                catch InputMismatchException:
                    print("Invalid input. Please enter a valid numeric value for the number of rooms.")
                    number_of_rooms = -1
            while number_of_rooms <= 0 or number_of_rooms > 3

            for i from 1 to number_of_rooms:
                Initialise bed_type as an empty string
                do:
                    print("Enter the choice of bed type for Room " + i + ": ")
                    Wait and assign input_scanner next line to bed_type

                    if bed_type is equal to "Exit":
                        print("Group reservation canceled.")
                        return

                    Map<String, String> room_details as hotel_room_details get_room_details with room_class
                    if room_details is not null:
                        if !room_details get "RoomType" contains bed_type:
                            print("Invalid bed type for the selected room class. Please choose " + room_details get "RoomType" + ".")
                            continue the loop
                    else:
                        print("Invalid room details. Group reservation canceled.")
                        return
                while true

                Initialise room_number by calling find_available_room with room_class and bed_type

                if room_number is not -1:
                    add room_number to reserved_room_numbers
                else:
                    print("No available room found within the specified range for " + room_class + ". Group reservation canceled.")
                    return

            for each room_number in reserved_room_numbers:
                Initialise reservation_details as a key-value data structure
                Add new key-value pair to reservation_details with "FirstName" as the key and "Group Reservation" as value
                Add new key-value pair to reservation_details with "LastName" as the key and "Group Reservation" as value
                Add new key-value pair to reservation_details with "LengthOfStay" as the key and 1 as value
                Add new key-value pair to reservation_details with "RoomReserved" as the key and room_number as value
                Add new key-value pair to reservation_details with "Class" as the key and room_class as value
                Add new key-value pair to reservation_details with "BedType" as the key and bed_type as value

                Add new key-value pair to reservations with room_number as the key and reservation_details as the value

                print("Reservation Details for Room " + room_number + ":")
                print("FirstName: Group Reservation")
                print("LastName: Group Reservation")
                print("LengthOfStay: 1")
                print("RoomReserved: " + room_number)
                print("Class: " + room_class)
                print("BedType: " + bed_type)
                print("--------------------------")
                print()

        catch NoSuchElementException:
            print("Input not found. Please enter all required information.")
        catch Exception:
            print("An unexpected error occurred. Please try again.")

        Wait for input_scanner next line

        Initialise response as an empty string
        do:
            print("Do you wish to reserve another group of rooms? Select Yes (Y) or No (N): ")
            Assign response with input_scanner next line
            if response does not equal "Y", "N" or "EXIT":
                print("Invalid input. Please enter Y, N, or EXIT.")
        while response does not equal "Y", "N" or "EXIT"

        if response equals "EXIT":
            print("Group reservation canceled.")
            return

        if response equals "N":
            set reserve_another_group to false
            
    while reserve_another_group
```

### Algorithm: GenerateIncomeReport

```
Funtion generate_income_report:
    reservations = reservation_provider.get_reservations

    total_superior_income = 0
    total_standard_income = 0
    total_deluxe_income = 0

    for each reservation in reservations.values:
        room_class = reservation["Class"]
        room_number = reservation["RoomReserved"]
        length_of_stay = reservation["LengthOfStay"]

        room_rate = hotel_room_data_provider.get_room_rate(room_class)

        total_income = room_rate * length_of_stay

        switch room_class:
            case "Superior":
                total_superior_income += total_income
                break
            case "Standard":
                total_standard_income += total_income
                break
            case "Deluxe":
                total_deluxe_income += total_income
                break

    print("Class\tNumber of rooms\tTotal income generated")
    print("Superior\t" + get_number_of_rooms("Superior") + "\t\t$" + total_superior_income)
    print("Standard\t" + get_number_of_rooms("Standard") + "\t\t$" + total_standard_income)
    print("Deluxe\t" + get_number_of_rooms("Deluxe") + "\t\t$" + total_deluxe_income)

```