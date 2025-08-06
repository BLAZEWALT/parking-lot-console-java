package classdesign.practice.parkinglot;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;

public class FeeCalculator {
    private static final Map<VehicleType,BigDecimal> rateCard =Map.of(
            VehicleType.BUS, BigDecimal.valueOf(50),
            VehicleType.CAR, BigDecimal.valueOf(40),
            VehicleType.AUTO, BigDecimal.valueOf(30),
            VehicleType.BIKE, BigDecimal.valueOf(20),
            VehicleType.CYCLE, BigDecimal.valueOf(10)
    );

    public static long getTotalHours(LocalDateTime entryTime,LocalDateTime exitTime){
        Duration totalParkedHrs = Duration.between(entryTime,exitTime);
        long mins = totalParkedHrs.toMinutes();
        return (mins + 59)/60;
    }

    public static BigDecimal getParkingFee(VehicleType v,LocalDateTime entryTime,LocalDateTime exitTime){
        return getRate(v).multiply(BigDecimal.valueOf(getTotalHours(entryTime, exitTime)));
    }

    public static BigDecimal getRate(VehicleType vType){
        return rateCard.getOrDefault(vType,BigDecimal.valueOf(40));
    }
}
