package classdesign.practice.parkinglot;

import java.util.List;

public class CommandDispatcher {
    CommandLineInterface cli = new CommandLineInterface();
    List<Floor> building = cli.initializeParkingLot();

    public void start() {
        while (true) {
            System.out.println("\nChoose an action: park | leave | status | exit");
            String command = cli.readInput().toLowerCase();
            switch (command) {
                case "park":
                    cli.parkVehicle(building);
                    break;
                case "leave":
                    cli.exitVehicle(building);
                    break;
                case "status":
                    cli.giveParkLotStatus(building);
                    break;
                case "exit":
                    System.out.println("Exiting..... GoodBye");
                    return;
                default:
                    System.out.println("Invalid command.Try again");
            }
        }
    }
}
