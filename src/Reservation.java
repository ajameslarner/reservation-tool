import java.util.UUID;

public class Reservation {
    public final String id;
    public Classification classification;
    public String lastName;
    public String firstName;
    public String bedType;
    public int lengthOfStay;
    public int roomNumber;

    public Reservation() {
        this.id = UUID.randomUUID().toString().substring(0,8);
    }
}