package classdesign.practice.parkinglot;

import java.time.LocalDateTime;
import java.util.Set;

public class Slot {
    private final String slotId;
    private final int floor;
    //private Set<VehicleType> allowedVechiles;
    private Vehicle parkedVehicle;
    private boolean isOccupied=false;
    private LocalDateTime parkedAt;

    public Slot(String slotId,int floor){
        this.slotId=slotId;
        this.floor=floor;
        //this.allowedVechiles=allowedVechiles;
    }

    public boolean isAvailable(){
        return (!isOccupied);
    }
    /*public boolean canFit(VehicleType type){
        return (allowedVechiles.contains(type));
    }*/
    public Ticket parkVehicle(Vehicle v){
        if(isOccupied) throw new IllegalStateException("Slot already occupied");
        this.parkedVehicle=v;
        this.parkedAt=LocalDateTime.now();
        this.isOccupied=true;

        return new Ticket(slotId,floor,parkedVehicle);
    }

    public LocalDateTime getParkedAt(){
        return parkedAt;
    }

    public String getSlotId(){
        return slotId;
    }

    public void vacateSlot(){
        isOccupied=false;
        parkedVehicle=null;
        parkedAt=null;
    }

    public Vehicle getParkedVehicle(){
        return parkedVehicle;
    }

    public VehicleType getParkedVType(){
        return parkedVehicle.getVType();
    }

    public String getParkedVRegNo(){
        return parkedVehicle.getRegistrationNo();
    }
}
