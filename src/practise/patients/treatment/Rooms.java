package practise.patients.treatment;

public class Rooms {
    private final int roomNumber;
    private final TreatmentType treatmenttype;
    private boolean open;
    public Rooms(int roomNumber, TreatmentType treatmenttype) {
    this.roomNumber = roomNumber;
    this.treatmenttype = treatmenttype;
    this.open = true;
    }

    public int getRoomNumber() {return roomNumber;}
    public TreatmentType getTreatmenttype() {return treatmenttype;}
    public boolean isOpen() {return open;}

    public void closeRoom() {
        if(open){open = false;}
        }

    public void openRoom() {
        if(!open) {
            open = true;
        }
    }
}
