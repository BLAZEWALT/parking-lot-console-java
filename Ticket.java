package classdesign.practice.parkinglot;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket {
    private static int counter = 1000;
    private final String ticketId;
    private final String slotId;
    private final int floor;
    private final Vehicle v;
    private final LocalDateTime issuedAt;
    private final VehicleType vType;
    private final String registrationNo;

    public Ticket(String slotId,int floor,Vehicle v){
        this.slotId=slotId;
        this.floor=floor;
        this.v=v;
        this.vType=v.getVType();
        this.registrationNo=v.getRegistrationNo();
        this.issuedAt=LocalDateTime.now();
        this.ticketId=generateTicketId();
    }
    private static synchronized String generateTicketId(){
        return "Ticket-"+(counter++);
    }
    public String getTicketId(){
        return ticketId;
    }
    @Override
    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy, hh:mm");
        return "Ticket["+ticketId+"] - Slot:"+slotId+", Floor:"+floor+", Vehicle:"+vType+", RegistrationNo:"+registrationNo+", Time:"+issuedAt.format(formatter);
    }

    public Vehicle getVehicle(){
        return v;
    }

    public LocalDateTime getIssuedAt(){
        return issuedAt;
    }

    public VehicleType getVType(){
        return  v.getVType();
    }
    public String getSlotId(){
        return slotId;
    }

    public int getFloor(){
        return floor;
    }
}
