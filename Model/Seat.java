package Model;

public class Seat {
    SeatType seatType;
    int seatId;
    SeatAvailability seatAvailability;

    public Seat(int seatId, SeatAvailability seatAvailability, SeatType seatType) {
        this.seatType = seatType;
        this.seatId = seatId;
        this.seatAvailability = seatAvailability;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public SeatAvailability getSeatAvailability() {
        return seatAvailability;
    }

    public void setSeatAvailability(SeatAvailability seatAvailability) {
        this.seatAvailability = seatAvailability;
    }
}
