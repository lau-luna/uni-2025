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
    // A player for the music files.
    private MusicPlayer player;

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer() {
        files = new ArrayList<>();
        player = new MusicPlayer();
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
        }
    }

    /**
     * Show a list of all the files in the collection.
     */
    public void listAllFiles() {
        int i = 0;
        while (i < files.size()) {
            System.out.println((i + 1) + ". " + files.get(i));
            i++;
        }
        if (files.size() == 0) {
            System.out.println("No songs stored.");
        }
    }

    /**
     * Remove a file from the collection.
     * 
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index) {
        if (validIndex(index)) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * 
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index) {
        if (validIndex(index)) {
            String filename = files.get(index);
            player.startPlaying(filename);
        }
    }

    /**
     * Stop the player.
     */
    public void stopPlaying() {
        player.stop();
    }

    /**
     * Play a file in the collection. Only return once playing has finished.
     * 
     * @param index The index of the file to be played.
     */
    public void playAndWait(int index) {
        if (validIndex(index)) {
            String filename = files.get(index);
            player.playSample(filename);
        }
    }

    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * 
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean validIndex(int index) {
        // The return value.
        // Set according to whether the index is valid or not.
        boolean valid;

        if (index < 0) {
            System.out.println("Index cannot be negative: " + index);
            valid = false;
        } else if (index >= files.size()) {
            System.out.println("Index is too large: " + index);
            valid = false;
        } else {
            valid = true;
        }
        return valid;
    }

    /*
     * Show a list of all the files in the collection
     */

    public void listMatching(String searchString) {
        boolean found = false;
        for (String filename : files) {
            if (filename.contains(searchString)) {
                System.out.println(filename);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matches for: " + searchString);
        }
    }

    public void removeFiles(String pattern) { 
        int i = 0;
        while(i < files.size()) {
            if (files.get(i).contains(pattern)) {
                files.remove(i);
            }else{
                i++;
            } 
        }
    }

    public void removeFilesBackwards(String pattern) { 
        int i = files.size()-1;
        while(i >=0) {
            if (files.get(i).contains(pattern)) {
                files.remove(i);
            }
            i--;
        }
    }

    public void removeCharacter(char c) { 
        for(String filename : files){
            for(int i = 0; i < filename.length(); i++){
                if(filename.charAt(i) == c){
                    System.out.println("Aca encontre.");
                }
            }
        } 
    }
}
