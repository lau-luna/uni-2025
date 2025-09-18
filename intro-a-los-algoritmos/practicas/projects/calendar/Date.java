
/**
 * Write a description of class Date here.
 *
 * @author (Lautaro Luna)
 * @version (5-22-25)
 */
public class Date {
    // Fields that represents day, month and year of a date.
    private int day;
    private int month;
    private int year;

    /**
     * Constructor for objects of class Date
     *
     * Postcondicion:
     * El campo day tiene asignado el parámetro day
     * El campo month tiene asignado el parámetro month
     * El campo day year asignado el parámetro year
     */
    public Date(int day, int month, int year) {
        assert (month == 2 && day > 0 && day <= 28 && year > 0)
                || ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
                        && day > 0 && day <= 31 && year > 0)
                || ((month == 4 || month == 6 || month == 9 || month == 11) && day > 0 && day <= 30 && year > 0)
                : "Invalid date";

        this.day = day;
        this.month = month;
        this.year = year;

        assert this.day == day && this.month == month && this.year == year;
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    /*
     * Postcondition: Devuelve true si la fecha es anterior a la fecha pasada como
     * parametro y false si no.
     */
    public boolean isEarlier(Date d) {
        assert d != null : "La otra fecha no puede ser null";

        if (this.year != d.getYear())
            return this.year < d.getYear();

        if (this.month != d.getMonth())
            return this.month < d.getMonth();

        return this.day < d.getDay();
    }
}
