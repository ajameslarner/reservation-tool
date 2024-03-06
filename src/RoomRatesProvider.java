public interface RoomRatesProvider {
    void addRoomRate(String roomClass, int roomRate);

    Integer getRoomRate(String roomClass);
}
