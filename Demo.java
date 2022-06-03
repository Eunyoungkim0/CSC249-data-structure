import java.util.Scanner;
import java.util.LinkedList;

public class Demo {
   public static void main (String[] args) {
      Scanner scnr = new Scanner(System.in);

      Playlist playlist = new Playlist();
      Song currSong = new Song();

      String name, artist, album;
      String input = "";
      int length;
      int count = 0;
      boolean flag = true;
            
      do{
         if(flag == true){
            System.out.println("\nPlease choose between 1-8: ");
            System.out.println("\t1. Add a Song to the Playlist");
            System.out.println("\t2. Insert a new Song after the Song that is currently playing");
            System.out.println("\t3. Print the contents of the Playlist");
            System.out.println("\t4. Display the current Song");
            System.out.println("\t5. Remove the current song");
            System.out.println("\t6. Skip to the next song");
            System.out.println("\t7. Return to the previous song");
            System.out.println("\t8. Exit");
            System.out.print("==> Your choice: ");
            
            input = scnr.nextLine();
         }
         
         if(input.equals("1")){
            // Add a Song to the Playlist
            flag = true;
            System.out.print("What is the name of the song?: ");
            name = scnr.nextLine();
            System.out.print("Who is the artist of the song?: ");
            artist = scnr.nextLine();
            System.out.print("What is the name of the album?: ");
            album = scnr.nextLine();
            System.out.print("How long is the song?: ");
            length = scnr.nextInt();
            scnr.nextLine();
            
            Song s = new Song(name, artist, album, length);
            playlist.insertAtEnd(s);
            
            if(playlist.getSize() == 1){
               currSong = s;
            }
            
            //System.out.println(playlist.toString());
                  
         }else if(input.equals("2")){
            // Insert a new Song after the Song that is currently playing
            // If a song is being added/inserted to an empty playlist, that song should then be set to be the one that is currently playing.
            flag = true;
            System.out.print("What is the name of the song?: ");
            name = scnr.nextLine();
            System.out.print("Who is the artist of the song?: ");
            artist = scnr.nextLine();
            System.out.print("What is the name of the album?: ");
            album = scnr.nextLine();
            System.out.print("How long is the song?: ");
            length = scnr.nextInt();
            scnr.nextLine();
            
            Song s = new Song(name, artist, album, length);
            
            if(playlist.getSize() == 0){
               playlist.insertAtEnd(s);
               currSong = s;
            }else{
               playlist.insertAfter(s, currSong);
            }
            
            //System.out.println(playlist.toString());
            
         }else if(input.equals("3")){
            // Print the contents of the Playlist
            flag = true;
            if(playlist.getSize() == 0){
               System.out.println("(!) There are no songs in the playlist. Please add a new song first.");
            }else{
               System.out.println("------------------Playlist------------------");
               System.out.println(playlist.toString());
            }
         }else if(input.equals("4")){
            count++;
            // Display the current Song
            // When displaying the current song for the first time, the first song in the playlist should be displayed.
            // To accomplish this, create a Song reference variable and assign it the first Song in the Playlist
            flag = true;
            if(playlist.getSize() == 0){
               System.out.println("(!) There are no songs in the playlist. Please add a new song first. (No current song)");
            }else{
               Song firstSong = playlist.getTheFirstSong();
               System.out.println("-------------Now playing------------");
               System.out.println(currSong.toString());
               System.out.println("------------------------------------");
               if(count == 1){
                  System.out.println("---The first Song in the playlist---");
                  System.out.println(firstSong.toString());
                  System.out.println("------------------------------------");
               }
            }
         }else if(input.equals("5")){
            // Remove the current song
            // When removing the current song, the new current song will be the song that directly follows the removed song.
            flag = true;
            if(playlist.getSize() == 0){
               System.out.println("(!) There are no songs in the playlist. (Can't remove the current song)");
            }else{
               Song tempSong = playlist.nextSong(currSong);
               playlist.removeSong(currSong);
               currSong = tempSong;
            }
         }else if(input.equals("6")){
            // Skip to the next song
            // If you are at the end of the Playlist, the next Song should be the first Song in the playlist.
            flag = true;
            if(playlist.getSize() == 0){
               System.out.println("(!) There are no songs in the playlist. (Can't skip to the next song)");
            }else{
               if(playlist.getSize() == 1){
                  System.out.println("(!) There is only one song in the playlist, so the next song will be the same song.");
               }
               currSong = playlist.nextSong(currSong);
            }
         }else if(input.equals("7")){
            // Return to the previous song
            // If you are at the beginning of the Playlist, the previous Song should be the last Song in the playlist.
            flag = true;
            if(playlist.getSize() == 0){
               System.out.println("(!) There are no songs in the playlist. (Can't return to the previous song)");
            }else{
               if(playlist.getSize() == 1){
                  System.out.println("(!) There is only one song in the playlist, so the previous song will be the same song.");
               }
               currSong = playlist.previousSong(currSong);
            }
         }else if(input.equals("8")){
            // Exit
            flag = false;
            System.out.println("Bye! Have a good day!");
            System.exit(0);
         }else{
            flag = false;
            System.out.print("(!) Wrong selection. Plase select between 1-8: ");
            input = scnr.nextLine();
         }
         
      }while(!input.equals("8"));
   }
}
