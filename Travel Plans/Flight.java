/**
 * This class describes a flight, and it is a concrete implementation of Transportation.
 * @author Richard Hansel
 * @version 1.0
 */
public class Flight extends Transportation {
    private int connectors;

    /**
     * A constructor that takes in company, id, departDate, departTime, arrivalTime,
     * and connectors.
     * @param company - the name of the transportation company.
     * @param id - the transportation vehicle number identifier.
     * @param departDate - departure date and will be represented as “MM-DD-YYYY"
     * (month-day-year).
     * @param departTime - departure time and will be represented as “HHMM”.
     * @param arrivalTime - arrival time and will be represented as “HHMM”.
     * @param connectors - the number of connecting flights.
     */
    public Flight(String company, int id, String departDate, String departTime, String arrivalTime, int connectors) {
        super(company, id, departDate, departTime, arrivalTime);
        if (connectors < 0) {
            throw new IllegalArgumentException("Connectors must be greater than 0");
        } else {
            this.connectors = connectors;
        }
    }

    /**
     * Should properly override Transportation’s toString() method.
     * @return “Flight,{company},{id},{departDate},{departTime},{arrivalTime},
     * {connectors}”.
     */
    public String toString() {
        return "Flight," + company + "," + id + "," + departDate + "," + departTime + ","
            + arrivalTime + "," + connectors;
    }

    /**
     * Should properly override Transportation’s equals() method.
     * @param obj object to be compared with Flight object.
     * @return true if they have the same company, id, departDate,
     * departTime, arrivalTime, and connectors.
     */
    public boolean equals(Object obj) {
        Flight f;
        if (!(obj instanceof Flight)) {
            return false;
        } else {
            f = (Flight) obj;
            return super.equals(f) && this.connectors == connectors;
        }
    }
}