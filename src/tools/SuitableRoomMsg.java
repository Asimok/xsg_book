package tools;

public class SuitableRoomMsg {
    private String Time;
    private String BuildingNumber;
    private String RoomNumber;
    private String Size;
    private String Functions;
    private String IsMeeting;
    private String Days;

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getBuildingNumber() {
        return BuildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        BuildingNumber = buildingNumber;
    }

    public String getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        RoomNumber = roomNumber;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        Size = size;
    }

    public String getFunctions() {
        return Functions;
    }

    public void setFunctions(String functions) {
        Functions = functions;
    }

    public String getIsMeeting() {
        return IsMeeting;
    }

    public void setIsMeeting(String isMeeting) {
        IsMeeting = isMeeting;
    }

    public String getDays() {
        return Days;
    }

    public void setDays(String days) {
        Days = days;
    }

    public String toString() {
        return "Time£º" + Time +
                "Days£º" + Days +
                "Functions" + Functions +
                "RoomNumber£º" + RoomNumber +
                "Building£º" + BuildingNumber +
                "Size£º" + Size +
                "IsMeeting£º" + IsMeeting;
    }
}
