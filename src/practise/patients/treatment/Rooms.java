package practise.patients.treatment;

public class Rooms {
    private final int roomNumber;
    private final TreatmentType treatmenttype;
    private static int currentRoomNumber = 1;
    private boolean open;

    /**
     * Creates a new room
     *
     * @param treatmenttype type of treatments that can be performed in this room
     */
    public Rooms(TreatmentType treatmenttype) {
    this.roomNumber = currentRoomNumber++;
    this.treatmenttype = treatmenttype;
    this.open = true;
    }

    public int getRoomNumber() {return roomNumber;}
    public TreatmentType getTreatmenttype() {return treatmenttype;}
    public boolean isOpen() {return open;}

    /**
     * if a room is open this method closes it
     */
    public void closeRoom() {
        if(open){open = false;}
        }

    /**
     * opens a closed room
     */
    public void openRoom() {
        if(!open) {
            open = true;
        }
    }
}
