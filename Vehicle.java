package classdesign.practice.parkinglot;

public class Vehicle {
    private final String registrationNo;
    private final VehicleType vType;

    Vehicle(String registrationNo, VehicleType vType){
        this.registrationNo=registrationNo;
        this.vType=vType;
    }

    public String getRegistrationNo(){
        return registrationNo;
    }

    public VehicleType getVType(){
        return vType;
    }
    @Override
    public String toString(){
        return vType+" with registration no: "+registrationNo;
    }
}
