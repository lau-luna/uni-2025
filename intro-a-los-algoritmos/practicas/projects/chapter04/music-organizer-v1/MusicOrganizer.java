import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class MusicOrganizer {
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer() {
        files = new ArrayList<>();
    }

    /**
     * Add a file to the collection.
     * 
     * @param filename The file to be added.
     */
    public void addFile(String filename) {
        files.add(filename);
    }

    /**
     * Return the number of files in the collection.
     * 
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles() {
        return files.size();
    }

    /**
     * List a file from the collection.
     * 
     * @param index The index of the file to be listed.
     */
    public void listFile(int index) {
        if (validIndex(index)) {
            String filename = files.get(index);
            System.out.println(filename);
        } else {
            System.out.println("Invalid index: " + index);
        }
    }

    /**
     * Remove a file from the collection.
     * 
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index) {
        // assert index < files.size() : "Invalid. index: " + index + ". List size: " +
        // files.size() + ".";
        if (validIndex(index)) {
            files.remove(index);
        } else {
            System.out.println("Invalid index: " + index);
        }
    }

    // Ejercicio 4.14: Metodo para chequear si un índice es válido.
    private void checkIndex(int index) {
        if ((index == 0 && files.size() == 0) || (index < 0 || index > files.size() - 1)) {
            System.out.println(index + " is not a valid index.");
        }
    }

    // Ejercicio 4.15: Metodo para chequear si un índice es válido.
    private boolean validIndex(int index) {
        boolean isValid = true;
        if ((index == 0 && files.size() == 0) || (index < 0 || index > files.size() - 1)) {
            isValid = false;
        }
        return isValid;
    }

    // Ejercicio 4.20: Prints all elements form files.
    public void listAllFiles() {
        if (files.size() > 0) {
            int pos = 1;
            for (String file : files) {
                System.out.println(pos + ". " + file);
                pos++;
            }
        } else {
            System.out.println("No songs stored.");
        }
    }

    /*E. 24.1 hanging for each to a while*/
    public void listFilesAll() {
        if (files.size() > 0) {
            int pos = 1;
            while(pos < files.size()) {
                System.out.println(pos + ". " + files.get(pos));
                pos++;
            }
        } else {
            System.out.println("No songs stored.");
        }
    }

    public void listMatching(String searchString) {
        boolean found = false;
        for (String filename : files) {
            if (filename.contains(searchString)) {
                System.out.println(filename);
                found = true;
            }
        }

        if (!found){
            System.out.println("No found coincidences for: " + searchString);
        }
    }

    /*
     *
     */
}
