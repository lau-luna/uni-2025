
/**
 * クラス NameGenerator の注釈をここに書きます.
 * 
 * @author (Lautaro Luna)
 * @version (バージョン番号もしくは日付)
 */
public class NameGenerator
{
    private String name;
    private String surname;
    private String motherSurname;
    private String birthCity;

    public NameGenerator(String name, String surname, String motherSurname, String birthCity){
        this.name = name;
        this.surname = surname;
        this.motherSurname = motherSurname;
        this.birthCity = birthCity;
    }

    public String generateStarWarsName(){
        String starWarsName = "";

        starWarsName = surname.substring(0, 3) + name.substring(0, 2).toLowerCase() + " " + motherSurname.substring(0, 2) + birthCity.substring(0, 3).toLowerCase();

        return starWarsName;
    }
}
