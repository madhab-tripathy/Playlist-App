import java.util.List;
import java.util.ArrayList;
public class Album {
    private String name;
    private String artist;
    private List<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
    // Find song in album
    public boolean findSong(String title){
        for(Song song : songs){
            if(song.getTitle().equals(title)){
                return true;
            }
        }
        return false;
    }
    // Add song to your album
    public String addSongToAlbum(String title, double duration){
        if(!findSong(title)){
            Song song = new Song(title,duration);
            songs.add(song);
            return "You added "+title+" to your playlist";
        }
        return "You already added this song";
    }
    // concept
    public String addSongToPlayListFromAlbum(String title, List<Song> playList){
        if(findSong(title)){
            for(Song song : songs){
                if(song.getTitle().equals(title)){
                    playList.add(song);
                    return title+" is added to your PlayList";
                }
            }
        }
        return "Song is not present in your album";
    }

    public String addSongToPlayListFromAlbum(int trackNo, List<Song> playList){
        int index = trackNo-1;
        if(index >= 0 && index < this.songs.size()){
            playList.add(this.songs.get(index));
            return  "Song is added in your PlayList";
        }
        return "track Number is not valid";
    }
}
