
// Defined as 2^ for bitwise operation flag usage
public enum RoomType {
    Single(1),
    Double(2),
    Twin(4),
    King(8),
    Queen(16);

    public final int value;

    RoomType(int value) {
        this.value = value;
    }
}
