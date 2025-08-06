package classdesign.practice.parkinglot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CommandLineInterface {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Map<String,Ticket> activeTickets = new HashMap<>();
    ParkingServices ps = new ParkingServices();

    public String readInput(){
        try {
            return reader.readLine();
        } catch (IOException e) {
            System.out.println("Error reading input: "+ e.getMessage());
            return "";
        }
    }
    public List<Floor> initializeParkingLot(){
        System.out.println("Enter no.of FLOORS");
        int fC = Integer.parseInt(readInput());
        System.out.println("Enter no.of SLOTS PER FLOOR");
        int spf = Integer.parseInt(readInput());
        ParkingLotInitializer pli = new ParkingLotInitializer(fC,spf);
        return pli.buildParkingLot();
    }

    private String  readRegistrationNo(){
        System.out.println("Enter your vehicle's registration number:");
        return readInput();
    }

    private VehicleType  readVehicleType(){
        System.out.println("Enter your vehicle's type: CAR/CYCLE/AUTO/BIKE/BUS");
        try{
            return VehicleType.valueOf(readInput().toUpperCase());
        }catch(IllegalArgumentException e) {
            System.out.println("Invalid Type.Defaulting to CAR");
            return VehicleType.CAR;
        }
    }


    public void parkVehicle(List<Floor> Building){
        try {
            String regNo = readRegistrationNo();
            VehicleType vType = readVehicleType();
            Vehicle v = new Vehicle(regNo,vType);
            Ticket t = ps.parkingVehicle(Building, v);
            activeTickets.put(t.getTicketId(),t);
            System.out.println(t);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    private Ticket readTicket(){
            System.out.println("Enter your Ticket ID:");
            String tId = readInput();
            Ticket ticket = activeTickets.get(tId);
            if(ticket == null){
                throw new IllegalArgumentException("Your Ticket Id is invalid,Please check and try again");
            }
            return ticket;
    }
    public void exitVehicle(List<Floor> Building){
        try {
            Ticket t = readTicket();
            Recipt r = ps.leavingVehicle(Building,t);
            activeTickets.remove(t.getTicketId());
            System.out.println(r);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    public void giveParkLotStatus(List<Floor> Building){
        ps.printStatus(Building);
    }
}
