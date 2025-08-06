# Parking Lot Console Application

A simple, modular Java console application that simulates a multi-floor parking lot system, developed using a class-based design-first approach. Ideal for learning OOP principles, design patterns, and clean coding, just like in machine coding rounds (e.g., Zoho).

---

## 🚗 Features

- **Initialize Parking Lot**: Define the number of floors and slots per floor at startup.
- **Park Vehicle**: Supports cars, bikes, autos, buses, and cycles. Assigns the first available slot.
- **Leave Vehicle**: Vacates a slot using a ticket ID and generates a receipt with total hours and fee.
- **Real-Time Status**: Displays current occupancy for each floor and slot.
- **Robust Input Handling**: BufferedReader-based CLI with validation and meaningful error messages.
- **Fee Calculation**: Uses `BigDecimal` for money, rounds up partial hours to the next full hour.

---

## 📋 Prerequisites

- JDK 17 or higher installed
- Git for version control

---

## 🛠️ Build & Run

1. **Clone the repository**

   ```bash
   git clone https://github.com/BLAZEWALT/parking-lot-console-java.git
   cd parking-lot-console-java
   ```

2. **Compile Java sources**

   ```bash
   javac classdesign/practice/parkinglot/*.java
   ```

3. **Run the application**

   ```bash
   java classdesign.practice.parkinglot.Main
   ```

4. **Follow on-screen prompts**

   - Enter number of floors and slots per floor
   - Use commands: `park`, `leave`, `status`, `exit`

---

## 🏗️ Project Structure

```
src/
└── classdesign/practice/parkinglot/
    ├── Main.java                  # Entry point
    ├── CommandDispatcher.java     # CLI loop and command routing
    ├── CommandLineInterface.java  # Input handling & UI logic
    ├── ParkingLotInitializer.java # Bootstraps floors & slots
    ├── Floor.java                 # Represents one floor with multiple slots
    ├── Slot.java                  # Represents a parking slot
    ├── Vehicle.java               # Entity for parked vehicles
    ├── VehicleType.java           # Enum for supported vehicle types
    ├── Ticket.java                # Ticket entity with timestamp & ID
    ├── Recipt.java                # (Receipt) generates payment details
    ├── ParkingServices.java       # Business logic: park & leave
    └── FeeCalculator.java         # Utility: computes fees & durations
```

---

## 🎨 Design Highlights

- **Single Responsibility**: Each class has a clear purpose (e.g., I/O vs. business logic).
- **Separation of Concerns**: CLI, services, and data models are decoupled.
- **Exception Handling**: Uses `IllegalStateException`, `IllegalArgumentException` for predictable scenarios.
- **Extensibility**: Easy to add new commands or vehicle types.

---

## 📈 Future Improvements

- Add membership plans (monthly, yearly subscriptions).
- Implement overflow/temporary parking area.
- Support dynamic fee models (peak/off-peak, weekend rates).
- Replace console I/O with RESTful API endpoints.

---

## 🎓 Learning Outcomes

- Practice class-based design in Java.
- Apply OOP principles: encapsulation, composition, and clean interfaces.
- Build a console-based UI with command dispatching.
- Manage real-world concerns: input validation, exception handling, monetary calculations.

---

— *End of README*

