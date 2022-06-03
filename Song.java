public class Song {

   private String name;
   private String artist;
   private String album;
   private int length;     // the length of the song in seconds
   private Song next;      // a reference to the song that follows this song in the list
   private Song previous;  // a reference to the song that precedes this song in the list
   
   public Song(){
      name = "";
      artist = "";
      album = "";
      length = 0;
   }
   
   public Song(String name, String artist, String album, int length) {
      this.name = name;
      this.artist = artist;
      this.album = album;
      this.length = length;
   }
   
   public void setName(String name){
      this.name = name;
   }
   
   public void setArtist(String artist){
      this.artist = artist;
   }
   
   public void setAlbum(String album){
      this.album = album;
   }
   
   public void setLength(int length){
      this.length = length;
   }
   
   public void setNext(Song nextSong){
      this.next = nextSong;
   }
   
   public void setPrevious(Song previousSong){
      this.previous = previousSong;
   }
   
   public String getName(){
      return name;
   }
   
   public String getArtist(){
      return artist;
   }
   
   public String getAlbum(){
      return album;
   }
   
   public int getLength(){
      return length;
   }
   
   public Song getNext(){
      return next;
   }
   
   public Song getPrevious(){
      return previous;
   }
   
   public String toString(){
      return name + " - " + artist + " [" + album + "] (" + length + " seconds)";
   }
} 