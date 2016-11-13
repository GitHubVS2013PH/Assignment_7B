/**
 * Assignment 7, CS1A, Anand Venkataraman, Fall 2016
 * @author Paul Hayter
 */
public class Foothill
{
   public final static int ARRAY_SIZE = 10;
/**
 * Test main for class ITunes including instantiation of individual objects and
 * objects in an array. Tests include instantiation with both default and
 * parameterized constructors, display(), toString(), setDefaults(), selected 
 * 'set' methods and timeInMinutesAndSeconds().
 * @param args not used
 */
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
   
   /**
    * Returns boolean true if the sizes of the four input arrays are each of
    * length ARRAY_SIZE, otherwise returns false.
    * @param nameArr String array of names
    * @param artistArr String array of artists
    * @param rateArr integer array of bitrates
    * @param timeArr integer array of totalTimes (play times)
    * @return the specified boolean
    */
   private static boolean inputSizesOK(String[] nameArr, String[] artistArr,
         int[] rateArr, int[] timeArr)
   {
      if (nameArr.length == ARRAY_SIZE && artistArr.length == ARRAY_SIZE
            && rateArr.length == ARRAY_SIZE && timeArr.length == ARRAY_SIZE)
         return true;
      return false;
   }
} // end class Foothill

/**
 * Class manages and displays four iTunes values for each object. These values 
 * are name for song name, artist for artist name, bitrate for digital recording
 * rate, and totalTime for play time (in milliseconds).
 * @author Paul Hayter
 */
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
   /**
    * Default constructor
    */
   ITunes()
   {
      setDefaults();
   }
   
   /**
    * Parameterized constructor. name and artist fields are subject to length
    * restrictions defined with MIN_STR_LENGTH and MAX_STR_LENGTH. bitrate field
    * subject to restrictions defined with MIN_BITRATE and MAX_BITRATE.
    * totalTime subject to restrictions defined with MIN_PLAY_TIME and 
    * MAX_PLAY_TIME.
    * @param name String with song name 
    * @param artist String with artist name
    * @param bitrate integer with bitrate of song recording
    * @param totalTime integer with song play time in milliseconds
    */
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
   /**
    * returns boolean true if input String str is between the minimum and
    * maximum lengths (inclusive) as defined by MIN_STR_LENGTH and 
    * MAX_STR_LENGTH, otherwise returns false.
    * @param str input String for length testing
    * @return specified boolean
    */
   static boolean validString(String str)
   {
      if (str.length() >= MIN_STR_LENGTH && str.length() <= MAX_STR_LENGTH)
         return true;
      return false;
   }
   
   /**
    * returns boolean true if input bitrate is between the minimum and
    * maximum rates (inclusive) as defined by MIN_BITRATE and MAX_BITRATE,
    * otherwise returns false.
    * @param bitrate input bitrate for rate testing
    * @return specified boolean
    */
   static boolean validBitrate(int bitrate)
   {
      if (bitrate >= MIN_BITRATE && bitrate <= MAX_BITRATE)
         return true;
      return false;
   }

   /**
    * returns boolean true if input totalTime is between the minimum and
    * maximum rates (inclusive) as defined by MIN_PLAY_TIME and MAX_PLAY_TIME,
    * otherwise returns false.
    * @param totalTime input totalTime for play time testing
    * @return specified boolean
    */
   static boolean validTotalTime(int totalTime)
   {
      if (totalTime >= MIN_PLAY_TIME && totalTime <= MAX_PLAY_TIME)
         return true;
      return false;
   }
   
   // mutators
   /**
    * if name is valid per validString() then sets name field to input name and
    * returns boolean true; otherwise returns false.
    * @param name String to set name field to
    * @return specified boolean
    */
   boolean setName(String name)
   {
      if (!ITunes.validString(name))
         return false;
      this.name = name;
      return true;
   }
   
   /**
    * if artist is valid per validString() then sets artist field to input 
    * artist and returns boolean true; otherwise returns false.
    * @param artist String to set artist field to
    * @return specified boolean
    */
   boolean setArtist(String artist)
   {
      if (!ITunes.validString(artist))
         return false;
      this.artist = artist;
      return true;
   }

   /**
    * if bitrate is valid per validBitrate() then sets bitrate field to input
    * bitrate and returns boolean true; otherwise returns false.
    * @param bitrate
    * @return specified boolean
    */
   boolean setBitrate(int bitrate)
   {
      if (!ITunes.validBitrate(bitrate))
         return false;
      this.bitrate = bitrate;
      return true;
   }
   
   /**
    * if totalTime is valid per validTotalTime() then sets totalTime field to 
    * input totalTime and returns boolean true; otherwise returns false.
    * @param totalTime
    * @return specified boolean
    */
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
   /**
    * returns a formatted string containing the name, artist, totalTime and
    * bitrate fields.
    * @return specified String
    */
   @Override
   public String toString()
   {
      return "Title: \"" + name
            + "\" / Artist: " + artist
            + "\nPlaying Time: " + timeInMinutesAndSeconds()
            + " / Bit Rate: " + bitrate + "k"; 
   }
   
   /**
    * clears class object fields to defaults defined in DEFAULT_STRING, 
    * DEFAULT_BITRATE and DEFAULT_PLAY_TIME.
    */
   void setDefaults()
   {
      name = DEFAULT_STRING;
      artist = DEFAULT_STRING;
      bitrate = DEFAULT_BITRATE;
      totalTime = DEFAULT_PLAY_TIME;      
   }
   
   /**
    * displays field values of one class object
    */
   void display()
   {
      System.out.println("ITunes song ------:\n" + toString());
   }
   
   /**
    * returns formatted String with totalTime shown in minutes and seconds.
    * String has no leading or trailing spaces.
    * @return specified String
    */
   String timeInMinutesAndSeconds()
   {
      int minutes = totalTime / MILLISEC_PER_MIN;
      int seconds = (totalTime % MILLISEC_PER_MIN) / MILLISEC_PER_SEC;
      String rtnStr = "";
      if (minutes != 0)
      {
         rtnStr += minutes + " minutes";
         if (seconds == 0)
            return rtnStr;
         else 
            rtnStr += " ";
      }
      return rtnStr + seconds + " seconds";
      // return (minutes == 0 ? "" : "" + minutes + " minutes") 
           // + (seconds == 0 ? "" : " " + seconds + " seconds");
   }
   
} // end class ITunes
