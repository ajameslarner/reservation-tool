### Algorithm: StoreRoomDetails

**Input:** Admin prompted configuration inputs

**Output:** Data structure containing room details

1. Initialise a HashMap data structure

For each room detail to be configured:
2. 
Supporting pseudo java code:

```java
var roomDetails = new HashMap<String, RoomDetail>();

for (String[] row : roomTiers) {
    roomDetails.put(row[0], new RoomDetail(row[1], row[2], row[3]));
}
```

    
