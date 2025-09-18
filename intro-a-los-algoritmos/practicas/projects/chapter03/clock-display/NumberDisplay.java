
/**
 * The NumberDisplay class represents a digital number display that can hold
 * values from zero to a given limit. The limit can be specified when creating
 * the display. The values range from zero (inclusive) to limit-1. If used,
 * for example, for the seconds on a digital clock, the limit would be 60, 
 * resulting in display values from 0 to 59. When incremented, the display 
 * automatically rolls over to zero when reaching the limit.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class NumberDisplay
{
    private int limit;
    private int value;

    /**
     * Constructor for objects of class NumberDisplay.
     * Set the limit at which the display rolls over.
     */
    public NumberDisplay(int rollOverLimit, int value)
    {
        limit = rollOverLimit;
        this.value = value;
    }

    /**
     * Return the current value.
     */
    public int getValue()
    {
        return value;
    }

    public int getLimit(){
        return this.limit;
    }

    /**
     * Return the display value (that is, the current value as a two-digit
     * String. If the value is less than ten, it will be padded with a leading
     * zero).
     */
    public String getDisplayValue(boolean is24hour)
    {
        int value = this.value;

        if (!is24hour){
            if (value > 12){
                value -= 12;
            }
        }

        if(value < 10) {
            return "0" + value;
        }
        else {
            return value + "";
        }
    }

    /**
     * Set the value of the display to the new specified value. If the new
     * value is less than zero or over the limit, do nothing.
     */
    public void setValue(int replacementValue)
    {
        assert replacementValue >= 0 : "New value must be greater or equal than 0";
        assert replacementValue < limit : "New value must be lesser than the limit";
        value = replacementValue;
    }

    /**
     * Increment the display value by one, rolling over to zero if the
     * limit is reached.
     */
    public void increment()
    {
        value = (value + 1) % limit;
    }

}


/*
 * assert n <= 0 : "Error";
 * temp = n;
 *:
 */
