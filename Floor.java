package classdesign.practice.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private final int floorNo;
    private final List<Slot> slots = new ArrayList<>();

    public Floor(int floorNo){
        this.floorNo=floorNo;
    }

    public void addSlot(Slot sl){
        slots.add(sl);
    }

    public Slot getSlotById(String slotId){
        for(Slot s:slots){
            if(slotId.equals(s.getSlotId())) return s;
        }
        return null;
    }

    public Slot getFirstAvailableSlot(){
        for(Slot s : slots){
            if(s.isAvailable()) return s;
        }
        return null;
    }

    public int availableSlotsCount(){
        int availableSlots=0;
        for(Slot s:slots) if(s.isAvailable()) availableSlots++;
        return availableSlots;
    }

    public int totalSlots(){
        return slots.size();
    }

    public int getFloorNo(){ return floorNo;}

    public List<Slot> getSlots(){
        return slots;
    }
}
