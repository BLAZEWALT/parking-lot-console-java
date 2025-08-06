package classdesign.practice.parkinglot;


import java.util.List;

public class ParkingServices {

    public Ticket parkingVehicle(List<Floor> Building, Vehicle v){
        Slot toParkAt = null;
        for (Floor f : Building) {
            toParkAt = f.getFirstAvailableSlot();
            if (toParkAt != null) break;
        }
        if(toParkAt == null){
            throw new IllegalStateException("Currently the parking lot is full,Come again later");
        }
        return toParkAt.parkVehicle(v);
    }

    public Recipt leavingVehicle(List<Floor> Building, Ticket ticket){
        for(Floor f : Building){
            if(f.getFloorNo() == ticket.getFloor()){
                Slot sl = f.getSlotById(ticket.getSlotId());
                sl.vacateSlot();
                break;
            }
        }
        return new Recipt(ticket);
    }

    public void printStatus(List<Floor> Building){
        for(Floor f : Building){
            System.out.println("Floor "+f.getFloorNo()+":");
            for(Slot sl : f.getSlots()){
                System.out.print(sl.getSlotId()+" - ");
                if(sl.isAvailable()){
                    System.out.println("Available");
                }else{
                    System.out.println("Occupied ("+sl.getParkedVType()+" - "+sl.getParkedVRegNo()+" )");
                }
            }
        }
    }
}
