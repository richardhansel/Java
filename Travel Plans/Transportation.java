/**
 * This class represents a mode of Transportation, and it is an abstract class.
 * @author Richard Hansel
 * @version 1.0
 */
public abstract class Transportation {
    protected String company;
    protected int id;
    protected String departDate;
    protected String departTime;
    protected String arrivalTime;

    /**
     * A constructor that takes in company, id, departDate, departTime, and
     * arrivalTime.
     * @param company - the name of the transportation company.
     * @param id - the transportation vehicle number identifier.
     * @param departDate - departure date and will be represented as “MM-DD-YYYY"
     * (month-day-year).
     * @param departTime - departure time and will be represented as “HHMM”.
     * @param arrivalTime - arrival time and will be represented as “HHMM”.
     */
    public Transportation(String company, int id, String departDate, String departTime, String arrivalTime) {
        if ((company == null) || (departDate == null) || (departTime == null) || (arrivalTime == null)) {
            throw new IllegalArgumentException();
        }
        if ((company.equals("")) || (departDate.equals("")) || (departTime.equals("")) || (arrivalTime.equals(""))) {
            throw new IllegalArgumentException();
        }
        if (((id < 0)) || (String.valueOf(id).length() != 5)) {
            throw new IllegalArgumentException();
        } else {
            this.company = company;
            this.departDate = departDate;
            this.departTime = departTime;
            this.arrivalTime = arrivalTime;
            this.id = id;
        }
    }

    /**
     * Should properly override Object’s toString() method and return.
     * @return “{company},{id},{departDate},{departTime},{arrivalTime}”.
     */
    public String toString() {
        return company + "," + id + "," + departDate + "," + departTime + "," + arrivalTime;
    }

    /**
     * Should properly override Object’s equals() method.
     * @param obj an object to be compared with Transportation object.
     * @return true if they have the same company, id,
     * departDate, departTime, and arrivalTime.
     */
    public boolean equals(Object obj) {
        Transportation t;
        if (!(obj instanceof Transportation)) {
            return false;
        } else {
            t = (Transportation) obj;
            return company.equals(t.company) && this.id == t.id && departDate.equals(t.departDate)
                && departTime.equals(t.departTime) && arrivalTime.equals(t.arrivalTime);
        }
    }
}