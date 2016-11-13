/**
 * Assignment 7, CS1A, Anand Venkataraman, Fall 2016
 * @author Paul Hayter
 */

public class Foothill
{
   public final static int ARRAY_SIZE = 10;

   public static void  main(String[] args)
   {   
      ITunes itune1 = new ITunes();
      ITunes itune2 = new ITunes("Stairway to Heaven",
            "Led Zeppelin", 64, 5 * 60 * 1000);
      ITunes itune3 = new ITunes("Lust for Life",
            "Iggy and the Stooges", 705, 3 * 60 * 1000);
      ITunes itune4 = new ITunes("Ave Maria", 
            "Chanticleer", 705, 4 * 60 * 1000 + 2000);
      
      System.out.println("Displaying original instantiated objects");
      itune1.display();
      itune2.display();
      itune3.display();
      itune4.display();
      
      // mutate objects
      itune1.setArtist("Beatles");
      itune1.setName("Here Comes the Sun");
      itune1.setBitrate(100);
      itune1.setTotaltime(1000 * 60 * 3 + 5000);
      
      itune3.setName("5 Foot 1");
      itune3.setArtist("Iggy Pop");
      
      System.out.println("\nDisplaying after mutations");
      itune1.display();
      itune2.display();
      itune3.display();
      itune4.display();
            
      // setDefault all objects
      itune1.setDefaults();
      itune2.setDefaults();
      itune3.setDefaults();
      itune4.setDefaults();

      System.out.println("\nDisplaying after invoking setDefaults");
      itune1.display();
      itune2.display();
      itune3.display();
      itune4.display();

      // test mutator's boolean returns
      System.out.println("\nTesting mutator's boolean returns");
      if (itune1.setArtist(""))
         System.out.println("Failed to reject bad setArtist mutation");
      else
         System.out.println("Correctly rejected bad setArtist mutation");
      
      if (itune1.setBitrate(0))
         System.out.println("Failed to reject bad setBitrate mutation");
      else
         System.out.println("Correctly rejected bad setBitrate mutation");      

      if (itune2.setBitrate(100))
         System.out.println("Correctly accepted good setBitrate mutation");
      else
         System.out.println("Failed to accept good setBitrate mutation");      
      
      if (itune2.setName("Run DMC"))
         System.out.println("Correctly accepted good setName mutation");
      else
         System.out.println("Failed to accept good setName mutation");
      
      // test with arrays
      System.out.println("\nTesting ITunes Class with arrays");
      String[] nameArray = {"Stairway to Heaven", "Lust for Life",
            "Ave Maria", "Here Comes the Sun", "Overture of 1812", "Roadrunner",
            "", "Fugue in D Minor", "Victory Dance", "Denis"};
      String[] artistArray = {"Led Zeppelin" , "Iggy and the Stooges",
            "Chanticleer", "Beatles", "Boston Pops", "Jonathon Richman",
            "50 Cent", "SF Philharmonic", "Elvis Costello", "Blondie"};
      int[] rateArray = {60, 705,
            100, 120, 700, 706,
            450, 705, 64, 63};
      int[] timeArray = { 5000, 4999,
           245000, 250000, 720000, 636000,
           388500, 737400, 3600000, 3600001};
      
      if (!inputSizesOK(nameArray, artistArray, rateArray, timeArray))
      {
         System.out.println("Error: not all input data arrays have length of "
               + ARRAY_SIZE);
         System.exit(1);
      }
      
      ITunes[] tunesArray = new ITunes[ARRAY_SIZE];
      for (int i = 0; i < nameArray.length; ++i)
      {
         tunesArray[i] = new ITunes(nameArray[i], artistArray[i],
               rateArray[i], timeArray[i]);
      }
      
      for (int i = 0; i < nameArray.length; ++i)
      {
         System.out.println("Array tune " + i + " is:");
         tunesArray[i].display();
         System.out.println();
      }
      
      System.exit(0);
   } // end main
   
   private static boolean inputSizesOK(String[] nameArr, String[] artistArr,
         int[] rateArr, int[] timeArr)
   {
      if (nameArr.length == ARRAY_SIZE && artistArr.length == ARRAY_SIZE
            && rateArr.length == ARRAY_SIZE && timeArr.length == ARRAY_SIZE)
         return true;
      return false;
   }
} // end class Foothill

class ITunes
{
   private String name;
   private String artist;
   private int bitrate;
   private int totalTime;
   
   public static final int MIN_BITRATE = 64;
   public static final int MAX_BITRATE = 705;
   public static final int MIN_STR_LENGTH = 1;
   public static final int MAX_STR_LENGTH = 128;
   public static final int MIN_PLAY_TIME = 5000;
   public static final int MILLISEC_PER_SEC = 1000;
   public static final int SEC_PER_MIN = 60;
   public static final int MILLISEC_PER_MIN = MILLISEC_PER_SEC * SEC_PER_MIN;
   public static final int MAX_PLAY_TIME = MILLISEC_PER_MIN * 60;
   public static final int DEFAULT_BITRATE = 64;
   public static final int DEFAULT_PLAY_TIME = 5000;
   public static final String DEFAULT_STRING = " (undefined) ";
   
   // constructors
   ITunes()
   {
      setDefaults();
   }
   
   ITunes(String name, String artist, int bitrate, int totalTime)
   {
      if (!setName(name))
         this.name = DEFAULT_STRING;
      if (!setArtist(artist))
         this.artist = DEFAULT_STRING;
      if (!setBitrate(bitrate))
         this.bitrate = DEFAULT_BITRATE;
      if (!setTotaltime(totalTime))
         this.totalTime = DEFAULT_PLAY_TIME;
   }
   
   // validators
   static boolean validString(String str)
   {
      if (str.length() >= MIN_STR_LENGTH && str.length() <= MAX_STR_LENGTH)
         return true;
      return false;
   }
   
   static boolean validBitrate(int bitrate)
   {
      if (bitrate >= MIN_BITRATE && bitrate <= MAX_BITRATE)
         return true;
      return false;
   }

   static boolean validTotalTime(int totalTime)
   {
      if (totalTime >= MIN_PLAY_TIME && totalTime <= MAX_PLAY_TIME)
         return true;
      return false;
   }
   
   // mutators
   boolean setName(String name)
   {
      if (!ITunes.validString(name))
         return false;
      this.name = name;
      return true;
   }
   
   boolean setArtist(String artist)
   {
      if (!ITunes.validString(artist))
         return false;
      this.artist = artist;
      return true;
   }

   boolean setBitrate(int bitrate)
   {
      if (!ITunes.validBitrate(bitrate))
         return false;
      this.bitrate = bitrate;
      return true;
   }
   
   boolean setTotaltime(int totalTime)
   {
      if (!ITunes.validTotalTime(totalTime))
         return false;
      this.totalTime = totalTime;
      return true;
   }
   
   // accessors
   String getName() { return name; }
   String getArtist() { return artist; }
   int getBitrate() { return bitrate; }
   int getTotalTime() { return totalTime; }
   
   // supporting methods
   @Override
   public String toString()
   {
      return "Title: \"" + name
            + "\" / Artist: " + artist
            + "\nPlaying Time: " + timeInMinutesAndSeconds()
            + " / Bit Rate: " + bitrate + "k"; 
   }
   
   void setDefaults()
   {
      name = DEFAULT_STRING;
      artist = DEFAULT_STRING;
      bitrate = DEFAULT_BITRATE;
      totalTime = DEFAULT_PLAY_TIME;      
   }
   
   void display()
   {
      System.out.println("ITunes song ------:\n" + toString());
   }
   
   String timeInMinutesAndSeconds()
   {
      int minutes = totalTime / MILLISEC_PER_MIN;
      int seconds = (totalTime % MILLISEC_PER_MIN) / MILLISEC_PER_SEC;
      String rtnVal = "";
      if (minutes != 0)
      {
         rtnVal += minutes + " minutes";
         if (seconds == 0)
            return rtnVal;
         else 
            rtnVal += " ";
      }
      return rtnVal + seconds + " seconds";
      // return (minutes == 0 ? "" : "" + minutes + " minutes") 
           // + (seconds == 0 ? "" : " " + seconds + " seconds");
   }
   
} // end class ITunes
