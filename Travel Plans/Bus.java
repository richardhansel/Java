/**
 * This class describes a bus, and it is a concrete implementation of Transportation.
 * @author Richard Hansel
 * @version 1.0
 */
public class Bus extends Transportation {
    private int stops;

    /**
     * A constructor that takes in company, id, departDate, departTime, arrivalTime, and
     * stops.
     * @param company - the name of the transportation company.
     * @param id - the transportation vehicle number identifier.
     * @param departDate - departure date and will be represented as “MM-DD-YYYY"
     * (month-day-year).
     * @param departTime - departure time and will be represented as “HHMM”.
     * @param arrivalTime - arrival time and will be represented as “HHMM”.
     * @param stops – the number of stops the bus trip has
     */
    public Bus(String company, int id, String departDate, String departTime, String arrivalTime, int stops) {
        super(company, id, departDate, departTime, arrivalTime);
        if (stops < 0) {
            throw new IllegalArgumentException("Stops must be greater than 0");
        } else {
            this.stops = stops;
        }
    }

    /**
     * Should properly override Transportation’s toString() method.
     * @return “Bus,{company},{id},{departDate},{departTime},{arrivalTime},{stops}”.
     */
    public String toString() {
        return "Bus," + company + "," + id + "," + departDate + "," + departTime + ","
            + arrivalTime + "," + stops;
    }

    /**
     * Should properly override Transportation’s equals() method.
     * @param obj compare the object if it's instance of Bus.
     * @return true if they have the same company, id, departDate, departTime,
     * arrivalTime, and stops.
     */
    public boolean equals(Object obj) {
        Bus b;
        if (!(obj instanceof Bus)) {
            return false;
        } else {
            b = (Bus) obj;
            return super.equals(b) && this.stops == stops;
        }
    }
}