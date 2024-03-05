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