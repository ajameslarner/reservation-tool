public class Classification {
    public final String Name;
    public final String Description;
    public final int RoomTypeFlags;
    public final int Rate;

    public Classification(String name, String description, int type, int rate) {
        this.Name = name;
        this.Description = description;
        this.RoomTypeFlags = type;
        this.Rate = rate;
    }
}

