import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

/**
 * This class will hold various public static methods that will let you read and write to the database.
 * @author Richard Hansel
 * @version 1.0
 */
public class Booking {

    /**
     * Takes in a String object representing the file name to read from.
     * @param readFile the String object.
     * @return ArrayList of Transportation objects
     * @throws FileNotFoundException if the passed in file is null or nonexistent.
     * @throws InvalidBookingException if the booking is invalid.
     */
    public static ArrayList<Transportation> outputBookings(String readFile)
        throws FileNotFoundException, InvalidBookingException {
        ArrayList<Transportation> transportation = new ArrayList<Transportation>();

        if (readFile == null) {
            throw new FileNotFoundException("File not found");
        }
        File myFile = new File(readFile);
        if ((myFile.exists()) && (myFile.isFile()) && (myFile != null)) {

            Scanner myScan = new Scanner(myFile);

            while (myScan.hasNextLine()) {
                String line  = myScan.nextLine();
                String[] arrayValues = line.split(",");

                if (arrayValues[0].equals("Flight")) {
                    transportation.add(new Flight(arrayValues[1], Integer.parseInt(arrayValues[2]),
                            arrayValues[3], arrayValues[4], arrayValues[5], Integer.parseInt(arrayValues[6])));

                } else if (arrayValues[0].equals("Bus")) {
                    transportation.add(new Bus(arrayValues[1], Integer.parseInt(arrayValues[2]),
                            arrayValues[3], arrayValues[4], arrayValues[5], Integer.parseInt(arrayValues[6])));

                } else {
                    throw new InvalidBookingException("Invalid Booking");
                }
            }
            myScan.close();
        } else {
            throw new FileNotFoundException("File not found");
        }
        return transportation;
    }

    /**
     * Takes in a String object representing the file name to write to.
     * @param writeFile the String object that represents the file name to be written.
     * @param transportation the ArrayList of transportation.
     * @return a boolean value based on if the write is successful (true) or not (false).
     */
    public static boolean writeBookings(String writeFile, ArrayList<Transportation> transportation) {
        try {
            ArrayList<Transportation> temporary = outputBookings(writeFile);
            for (int i = 0; i < temporary.size(); i++) {
                transportation.add(temporary.get(i));
            }

            File file = new File(writeFile);
            PrintWriter output = new PrintWriter(file);

            for (int i = 0; i < transportation.size(); i++) {
                output.println(transportation.get(i));
            }

            output.close();
        } catch (FileNotFoundException FFE) {
            System.out.println(FFE.getMessage());
            return false;
        } catch (NullPointerException NPE) {
            System.out.println(NPE.getMessage());
            return false;
        } catch (InvalidBookingException IBE) {
            System.out.println(IBE.getMessage());
            return false;
        }
        return true;
    }

    /**
     * Takes in a String object representing the file name to read from.
     * @param readFile the String represents the name of the file to be read.
     * @param t the Object transportation.
     * @return an ArrayList of Integer objects.
     * @throws FileNotFoundException if the passed in file is null or nonexistent.
     * @throws InvalidBookingException if the booking is invalid.
     */
    public static ArrayList<Integer> readBookings(String readFile, Transportation t)
            throws FileNotFoundException, InvalidBookingException {

        ArrayList<Integer> linePosition = new ArrayList<Integer>();

        File myFile = new File(readFile);

        if ((myFile.exists()) && (myFile.isFile()) && (myFile != null)) {

            Scanner myScan = new Scanner(myFile);

            int count = 0;

            while (myScan.hasNextLine()) {
                count++;
                String line = myScan.nextLine();
                if (line.equals(t.toString())) {
                    linePosition.add(count);
                } else {
                    throw new InvalidBookingException("Invalid Booking");
                }
            }
            myScan.close();

        } else {
            throw new FileNotFoundException("File not found");
        }
        return linePosition;
    }

    /**
     * Main method as the driver of the program.
     * Create two flight and bus objects.
     * Write the objects into a file called “TestBooking.csv”.
     * Read the csv file using outputBookings() and print each object to a new line.
     * Create another flight object and add it to “TestBooking.csv”.
     * @param args - Array of string object for main method.
     */
    public static void main(String[] args) {
        try {
            Booking b = new Booking();
            Flight f1 = new Flight("JAL", 12345, "10-26-2021", "1524", "1721", 0);
            Bus b1 = new Bus("SQ", 11111, "09-23-2021", "0231", "0924", 1);

            ArrayList<Transportation> collectedTransportation = new ArrayList<Transportation>();

            collectedTransportation.add(f1);
            collectedTransportation.add(b1);

            b.writeBookings("TestBooking.csv", collectedTransportation);

            b.outputBookings("TestBooking.csv");

            Flight f2 = new Flight("ANA", 54321, "8-27-2021", "3243", "1543", 0);
            
            collectedTransportation.add(f2);
            
            b.writeBookings("TestBooking.csv", collectedTransportation);

        } catch (FileNotFoundException FNE) {
            System.out.println(FNE.getMessage());
        } catch (InvalidBookingException IBE) {
            System.out.println(IBE.getMessage());
        }
    }
}