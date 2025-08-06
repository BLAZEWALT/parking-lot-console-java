package classdesign.practice.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotInitializer {
    private final int floorCount;
    private final int slotsPerFloor;

    public ParkingLotInitializer(int floorCount,int slotsPerFloor){
        this.floorCount=floorCount;
        this.slotsPerFloor=slotsPerFloor;
    }

    public List<Floor> buildParkingLot(){
        List<Floor> Building = new ArrayList<>();
        for(int i=1;i<=floorCount;i++){
            Floor f = new Floor(i);
            for(int j=1;j<=slotsPerFloor;j++){
                String sId = String.format("F%d-S%02d",i,j);
                Slot s = new Slot(sId,i);
                f.addSlot(s);
            }
            Building.add(f);
        }
        return Building;
    }

}
