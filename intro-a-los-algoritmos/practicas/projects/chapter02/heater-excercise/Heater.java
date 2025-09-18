
/**
 * A heater.
 *
 * @author (Lautaro Luna)
 * @version (a version number or a date)
 */
public class Heater {

    private double temperature; // Heater temperature
    private double min;
    private double max;
    private double increment;

    public Heater(double heaterMin, double heaterMax) {
        this.temperature = 50.0;
        this.min = heaterMin;
        this.max = heaterMax;
        this.increment = 5.0;
    }

    // Warmer increases the temperature by 5.0 or the value specified in
    // setIncrement
    public void warmer() {
        if (temperature + increment <= max) {
            this.temperature += increment;
        } else {
            System.out.println("You can't increase the temperature more than: " + this.max);
        }
    }

    // Cooler decreases the temperature by 5.0 or the value specified in
    // setIncrement
    public void cooler() {
        if (temperature - increment >= min) {
            this.temperature -= increment;
        } else {
            System.out.println("You can't decrease the temperature less than: " + this.min);
        }
    }

    // Return the temperature value
    public double getTemperature() {
        return this.temperature;
    }

    // Set an increment value
    public void setIncrement(double newIncrement) {
        if (newIncrement > 0) {
            this.increment = newIncrement;
        } else {
            System.out.println("Please specify another value for increment rather than " + newIncrement);
        }
    }
}
