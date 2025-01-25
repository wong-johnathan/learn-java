package playlist;

import java.util.*;

public class Album {

    private String name;
    private String artist;
    private LinkedList<Song> songs;

    public Album (String name, String artist){
        this.name = name;
        this.artist = artist;
    }

    public boolean addSong(String title, double duration){
        return false;
    }

    public Song findSong(String title){
        return null;
    }

    public boolean addToPlaylist(int trackNo, LinkedList<Song> list){
        return false;
    }

    public boolean addToPlaylist(String title, LinkedList<Song> list){
        return false;
    }
}
