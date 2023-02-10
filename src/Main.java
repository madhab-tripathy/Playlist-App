import java.util.*;

public class Main {
    public static void main(String[] args) {
        Album album1 = new Album("Late Nights","Jeremih");
        album1.addSongToAlbum("Planen",4.00);
        album1.addSongToAlbum("Pass Dat",2.53);
        album1.addSongToAlbum("Impatient",4.05);

        Album album2 = new Album("Justice","Justin Bieber");
        album2.addSongToAlbum("2 Much",2.32);
        album2.addSongToAlbum("Deserve You",3.32);
        album2.addSongToAlbum("As I Am",2.54);

        List<Song> playList1 = new LinkedList<>();
        System.out.println(album2.addSongToPlayListFromAlbum("2 Much",playList1));
        System.out.println(album2.addSongToPlayListFromAlbum("As I Am",playList1));
        System.out.println(album1.addSongToPlayListFromAlbum(1,playList1));
        play(playList1);
    }
    public static void play(List<Song> playList){
        ListIterator<Song> itr = playList.listIterator();
        // check for empty playlist
        if(playList.size() == 0){
            System.out.println("Your PlayList is empty.");
            return;
        }
        boolean isNext;
        System.out.println("Currently playing: ");
        System.out.println(itr.next());
        isNext = true;
        Scanner sc = new Scanner(System.in);
        printMenu();
        while(true){
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice){

                case 1:
                    if(!isNext){
                        itr.next();
                    }
                    if(itr.hasNext()){
                        System.out.println("Now playing: ");
                        System.out.println(itr.next());
                    }
                    else System.out.println("You have reached the end of list");
                    isNext = true;
                    break;
                case 2:
                    if(isNext){
                        itr.previous();
                    }
                    if(itr.hasPrevious()){
                        System.out.println("Now playing: ");
                        System.out.println(itr.previous());
                    }
                    else System.out.println("You are on first song already");
                    isNext = false;
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    printAllSongs(playList);
                    break;
                case 6:
                    printMenu();
                    break;
                case 7:  // exit
                    return;
            }
        }
    }
    static void printAllSongs(List<Song> playList){
        for(Song song: playList)
            System.out.println(song);
        return;
    }
    static void printMenu(){
        System.out.println("1. Play next song");
        System.out.println("2. Play previous song");
        System.out.println("3. Play current song again");
        System.out.println("4. Delete current song");
        System.out.println("5. Show all songs");
        System.out.println("6. Show menu again");
        System.out.println("7. Exit");
    }
}