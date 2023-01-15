package practise.patients.treatment;

import practise.patients.AppointmentCalendar;

public class Rooms {
    private final int roomNumber;
    private final TreatmentType treatmentType;
    private final AppointmentCalendar appointmentCalendar = new AppointmentCalendar();
    private static int currentRoomNumber = 1;
    private boolean open;

    /**
     * Creates a new room
     *
     * @param treatmentType type of treatments that can be performed in this room
     */
    public Rooms(TreatmentType treatmentType) {
    this.roomNumber = currentRoomNumber++;
    this.treatmentType = treatmentType;
    this.open = true;
    }

    public int getRoomNumber() {return roomNumber;}
    public TreatmentType getTreatmenttype() {return treatmentType;}
    public boolean isOpen() {return open;}

    /**
     * closes an open room
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

    public AppointmentCalendar getAppointmentCalendar() {return appointmentCalendar;}
}
