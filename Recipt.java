package classdesign.practice.parkinglot;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Recipt {
    private final Vehicle v;
    private final LocalDateTime parkedTime;
    private final LocalDateTime vacatedTime;
    private final long totalHoursParked;
    private final BigDecimal amountToPay;

    Recipt(Ticket ticket){
        this.v=ticket.getVehicle();
        this.parkedTime=ticket.getIssuedAt();
        this.vacatedTime=LocalDateTime.now();
        this.totalHoursParked=FeeCalculator.getTotalHours(parkedTime,vacatedTime);
        this.amountToPay=FeeCalculator.getParkingFee(v.getVType(),parkedTime,vacatedTime);
    }

    public LocalDateTime getParkedTime(){
        return parkedTime;
    }
    public LocalDateTime getVacatedTime(){
        return vacatedTime;
    }

    public Vehicle getVehicle(){
        return v;
    }

    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy, hh:mm");
        return "Your Recipt:"
                +" Vehicle-"+v.getVType()
                +" ParkedAt-"+parkedTime
                +" ExitAt-"+vacatedTime.format(formatter)
                +" TotalHoursParked-"+totalHoursParked
                +" TotalParkingAmount-"+amountToPay
                +" Thank You, See You Again!";
    }
}
