public class Playlist {
   private Song head;   // A dummy node (a blank song object that will represent the first song in the playlist)
   private Song tail;   // A dummy node (a blank song object that will represent the last song in the playlist)
   private int size;    // The number of songs in the playlist
      
   // This no-arg constructor should also properly connect the head and tail nodes of the doubly linked list.
   public Playlist() {
      head = new Song();
      tail = new Song();
      size = 0;
      
      head.setNext(tail);
      tail.setPrevious(head);
   }

   //A method that accepts a Song object and adds it to the end of the Playlist.
   public void insertAtEnd(Song newSong){
   
      newSong.setPrevious(tail.getPrevious());
      newSong.setNext(tail);
      tail.getPrevious().setNext(newSong);
      tail.setPrevious(newSong);

      size++;      
      System.out.println("** Added at the end");
      //newSong.toString();
   }
   
   // A method that accepts 2 Song objects (a new Song to be added, and a Song that is currently playing from the playlist).
   // This method will insert the new Song into the playlist at the position directly after the Song that is currently playing.
   public void insertAfter(Song newSong, Song curSong) {
      
      if(curSong == tail){
         return;
      }else{
         Song temp = curSong.getNext();
         newSong.setNext(temp);
         newSong.setPrevious(curSong);
         curSong.setNext(newSong);
         temp.setPrevious(newSong);
         
         size++;
         System.out.println("** Added after current song");
      }
   }
   
   // A method that accepts a Song object, returns nothing, and removes the Song from the playlist.
   public void removeSong(Song curSong){
   
      if(curSong == head || curSong == tail){
         return;
      }else{
         Song temp = curSong.getNext();
         Song temp2 = curSong.getPrevious();
         
         temp.setPrevious(temp2);
         temp2.setNext(temp);
      
         size--;
         System.out.println("** Removed");
      }
   }
   
   public Song nextSong(Song curSong){
      Song newCurrentSong;
      
      if(curSong.getNext() == tail){
         newCurrentSong = head.getNext();
      }else{
         newCurrentSong = curSong.getNext();
      }
      return newCurrentSong;
   }
   
   public Song previousSong(Song curSong){
      Song newCurrentSong;
      
      if(curSong.getPrevious() == head){
         newCurrentSong = tail.getPrevious();
      }else{
         newCurrentSong = curSong.getPrevious();
      }
      return newCurrentSong;
   }
   
   public Song getTheFirstSong(){
      return head.getNext();
   }
      
   public int getSize() {
      return size;
   }
   
   // A toString method that prints out the contents of the Playlist.
   // This toString method should also calculate and display the number of songs in the playlist, as well as the length of the playlist in minutes and seconds.
   public String toString() {
      String tmpMessage = "";
      int totalLen = 0;
      Song temp = head.getNext();
      for(int i = 0; i < size; i++){
         totalLen = totalLen + temp.getLength();
         tmpMessage = tmpMessage + temp.toString() + "\n";
         temp = temp.getNext();
      }
      
      tmpMessage = tmpMessage + "--------------------------------------------\n";
      tmpMessage = tmpMessage + ">>> Total: " + size + " songs, " + totalLen + " seconds";
      
      return tmpMessage;
   }

}