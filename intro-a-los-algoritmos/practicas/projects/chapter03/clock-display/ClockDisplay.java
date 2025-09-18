
/**
 * The ClockDisplay class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours and minutes. The
 * range of the clock is 00:00 (midnight) to 23:59 (one minute before
 * midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class ClockDisplay {
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString; // simulates the actual display
    private boolean is24hour;

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at 00:00.
     */
    public ClockDisplay() {
        hours = new NumberDisplay(24, 0);
        minutes = new NumberDisplay(60, 0);
        this.is24hour = true;
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the
     * parameters.
     * hour field must be greater than 0.
     */
    public ClockDisplay(int hour, int minute, boolean is24hour) {
        // assert hour > 0 : "La hora no puede ser 0 en el formato de 12 horas.";
        hours = new NumberDisplay(24, hour);
        minutes = new NumberDisplay(60, minute);
        this.is24hour = is24hour;
        setTime(hour, minute);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick() {
        minutes.increment();
        if (minutes.getValue() == 0) { // it just rolled over!
            hours.increment();
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute) {
        hours.setValue(hour);
        minutes.setValue(minute);
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime() {
        return displayString;
    }

    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay() {
        String format = "AM";
        if (is24hour) {
            displayString = hours.getDisplayValue(true) + ":" +
                    minutes.getDisplayValue(true);
        } else {
            if (hours.getValue() == 0) {
                format = "PM";
                displayString = 12 + ":" +
                        minutes.getDisplayValue(true) + format;
            } else {
                if (hours.getValue() > 12){
                    format = "PM";
                }
                displayString = hours.getDisplayValue(false) + ":" +
                        minutes.getDisplayValue(true) + format;
            }
        }
    }
}
