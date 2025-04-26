import java.util.ArrayList;
import java.util.List;

// User class
class User {
    private String username;
    private List<Playlist> playlists;

    public User(String username) {
        this.username = username;
        this.playlists = new ArrayList<>();
    }

    public void streamSong(Song song) {
        System.out.println(username + " is streaming song: " + song.getTitle());
        SongPlayerThread player = new SongPlayerThread(song);
        player.start();
    }

    public String getUsername() {
        return username;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void addPlaylist(Playlist playlist) {
        playlists.add(playlist);
    }
}

// PreelUser class (assuming this is a typo and should be FreeUser)
class PreelUser extends User {
    public PreelUser(String username) {
        super(username);
    }

    @Override
    public void streamSong(Song song) {
        System.out.println("Free user " + getUsername() + " is streaming with ads: " + song.getTitle());
        SongPlayerThread player = new SongPlayerThread(song);
        player.start();
        // Simulate ads for free users
        System.out.println("Playing advertisement...");
    }
}

// PremiumUser class
class PremiumUser extends User {
    public PremiumUser(String username) {
        super(username);
    }

    @Override
    public void streamSong(Song song) {
        System.out.println("Premium user " + getUsername() + " is streaming ad-free: " + song.getTitle());
        SongPlayerThread player = new SongPlayerThread(song);
        player.start();
    }
}

// Playlist class (assuming typo - should be Playlist)
class Playlist {
    private String name;
    private List<Song> songs;

    public Playlist(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public List<Song> getSongs() {
        return songs;
    }

    public String getName() {
        return name;
    }
}

// SongPlayerThread class
class SongPlayerThread extends Thread {
    private Song song;

    public SongPlayerThread(Song song) {
        this.song = song;
    }

    @Override
    public void run() {
        System.out.println("Now playing: " + song.getTitle() + " by " + song.getArtist());
        // Simulate song playback
        try {
            Thread.sleep(3000); // Simulate 3 seconds of playback
        } catch (InterruptedException e) {
            System.out.println("Playback interrupted");
        }
        System.out.println("Finished playing: " + song.getTitle());
    }
}

// Song class
class Song {
    private String title;
    private String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }
}

// Main class to demonstrate usage
public class musicstreamingapp {
    public static void main(String[] args) {
        // Create some songs
        Song song1 = new Song("Bohemian Rhapsody", "Queen");
        Song song2 = new Song("Imagine", "John Lennon");
        Song song3 = new Song("Blinding Lights", "The Weeknd");

        // Create a playlist
        Playlist myPlaylist = new Playlist("My Favorites");
        myPlaylist.addSong(song1);
        myPlaylist.addSong(song2);
        myPlaylist.addSong(song3);

        // Create users
        User freeUser = new PreelUser("FreeListener");
        User premiumUser = new PremiumUser("PremiumListener");

        // Add playlist to users
        freeUser.addPlaylist(myPlaylist);
        premiumUser.addPlaylist(myPlaylist);

        // Stream songs
        System.out.println("--- Free User Streaming ---");
        freeUser.streamSong(song1);
        
        System.out.println("\n--- Premium User Streaming ---");
        premiumUser.streamSong(song2);
    }
}