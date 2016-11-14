/**
 * Assignment 7 Option B, CS1A, Anand Venkataraman, Fall 2016
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
      // instantiate 4 ITunes objects all with legal parameters
      ITunes itune1 = new ITunes();
      ITunes itune2 = new ITunes("Stairway to Heaven",
            "Led Zeppelin", 64, 5 * 60 * 1000);
      ITunes itune3 = new ITunes("Lust for Life",
            "Iggy and the Stooges", 705, 3 * 60 * 1000);
      ITunes itune4 = new ITunes("Ave Maria", 
            "Chanticleer", 705, 4 * 60 * 1000 + 2000);
      
      System.out.println("*** Display original instantiated objects");
      System.out.println("First object using default constructor and other"
            + " objects using legal parameters");
      System.out.println("\niTune1");
      itune1.display();
      System.out.println("\niTune2");
      itune2.display();
      System.out.println("\niTune3");
      itune3.display();
      System.out.println("\niTune4");
      itune4.display();
      
      // mutate objects
      itune1.setArtist("Beatles");
      itune1.setName("Here Comes the Sun");
      itune1.setBitrate(100);
      itune1.setTotaltime(1000 * 60 * 3 + 5000);
      
      itune2.setArtist("Chanticleer");
      
      itune3.setName("5 Foot 1");
      itune3.setArtist("Iggy Pop");
      
      itune4.setBitrate(600);
      
      System.out.println("\n*** Display after legal mutations in all objects");
      System.out.println("\niTune1, name, artist, bitrate & totalTime mutated");
      itune1.display();
      System.out.println("\niTune2 artist mutated");
      itune2.display();
      System.out.println("\niTune3, name and artist mutated");
      itune3.display();
      System.out.println("\niTune4 bitrate mutated");
      itune4.display();
            
      // setDefault all objects
      itune1.setDefaults();
      itune2.setDefaults();
      itune3.setDefaults();
      itune4.setDefaults();

      System.out.println("\n*** Display after invoking setDefaults");
      System.out.println("All objects should display their default values");
      System.out.println("\niTune1");
      itune1.display();
      System.out.println("\niTune2");
      itune2.display();
      System.out.println("\niTune3");
      itune3.display();
      System.out.println("\niTune4");
      itune4.display();

      // test mutator's boolean returns
      System.out.println("\n*** Testing mutator's boolean returns");
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
      System.out.println("\n*** Testing ITunes Class with arrays");
      System.out.println("Expected results are:");
      System.out.println("\ntune 0: illegal bitrate, use default bitrate: " 
            + ITunes.DEFAULT_BITRATE);
      System.out.println("tune 1: illegal totalTime, use default totalTime: " 
            + ITunes.DEFAULT_PLAY_TIME);
      System.out.println("tune 2: all legal parameters");
      System.out.println("tune 3: all legal parameters");
      System.out.println("tune 4: all legal parameters");
      System.out.println("tune 5: all legal parameters");
      System.out.println("tune 6: illegal name, use default name: "
            + ITunes.DEFAULT_STRING);
      System.out.println("tune 7: illegal artist, use default artist: "
            + ITunes.DEFAULT_STRING);
      System.out.println("tune 8: illegal bitrate, use default bitrate: " 
            + ITunes.DEFAULT_BITRATE);
      System.out.println("tune 9: illegal totalTime, use default totalTime: " 
            + ITunes.DEFAULT_PLAY_TIME);
      System.out.println();
      
      String[] nameArray = {"Stairway to Heaven", "Lust for Life",
            "Ave Maria", "Here Comes the Sun", "Overture of 1812", "Roadrunner",
            "", "Fugue in D Minor", "Victory Dance", "Denis"};
      String[] artistArray = {"Led Zeppelin" , "Iggy and the Stooges",
            "Chanticleer", "Beatles", "Boston Pops", "Jonathon Richman",
            "50 Cent", "", "Elvis Costello", "Blondie"};
      int[] rateArray = {60, 705,
            100, 120, 700, 706,
            450, 705, 63, 64};
      int[] timeArray = { 5000, 4999,
           245000, 250000, 720000, 636000,
           388500, 737400, 3600000, 3600001};
      
      if (!inputSizesOK(nameArray, artistArray, rateArray, timeArray))
      {
         System.out.println("Error: not all input data arrays have length of "
               + Foothill.ARRAY_SIZE);
         System.exit(1);
      }
      
      ITunes[] tunesArray = new ITunes[Foothill.ARRAY_SIZE];
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
      
      // tests for timeInMinutesAndSeconds()
      System.out.println("Tests for leading & trailing spaces & proper plurals "
            + "in timeInMinutesAndSeconds");
      System.out.println("The following should show:"
            + "\n(1)no leading or trailing spaces in totalTime values,"
            + "\n(2)a single space between minutes and seconds, and"
            + "\n(3)proper plurals on minutes and seconds");
      itune1.setTotaltime(5000);
      itune2.setTotaltime(2* 60 * 1000 + 1000);
      itune3.setTotaltime(60 * 60 * 1000);
      itune4.setTotaltime(60 * 1000);
      tunesArray[0].setTotaltime(2* 60 * 1000 + 5000);
      System.out.println("-->" + itune1.timeInMinutesAndSeconds() + "<--");
      System.out.println("-->" + itune2.timeInMinutesAndSeconds() + "<--");
      System.out.println("-->" + itune3.timeInMinutesAndSeconds() + "<--");
      System.out.println("-->" + itune4.timeInMinutesAndSeconds() + "<--");       
      System.out.println("-->" + tunesArray[0].timeInMinutesAndSeconds() 
            + "<--");       
            
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
      if (nameArr.length == Foothill.ARRAY_SIZE 
            && artistArr.length == Foothill.ARRAY_SIZE
            && rateArr.length == Foothill.ARRAY_SIZE 
            && timeArr.length == Foothill.ARRAY_SIZE)
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
         this.name = ITunes.DEFAULT_STRING;
      if (!setArtist(artist))
         this.artist = ITunes.DEFAULT_STRING;
      if (!setBitrate(bitrate))
         this.bitrate = ITunes.DEFAULT_BITRATE;
      if (!setTotaltime(totalTime))
         this.totalTime = ITunes.DEFAULT_PLAY_TIME;
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
      if (str.length() >= ITunes.MIN_STR_LENGTH 
            && str.length() <= ITunes.MAX_STR_LENGTH)
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
      if (bitrate >= ITunes.MIN_BITRATE && bitrate <= ITunes.MAX_BITRATE)
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
      if (totalTime >= ITunes.MIN_PLAY_TIME 
            && totalTime <= ITunes.MAX_PLAY_TIME)
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
      return "Title: \"" + name + "\""
            + " / Artist: " + artist
            + "\nPlaying Time: " + timeInMinutesAndSeconds()
            + " / Bit Rate: " + bitrate + "k"; 
   }
   
   /**
    * clears class object fields to defaults defined in DEFAULT_STRING, 
    * DEFAULT_BITRATE and DEFAULT_PLAY_TIME.
    */
   void setDefaults()
   {
      name = ITunes.DEFAULT_STRING;
      artist = ITunes.DEFAULT_STRING;
      bitrate = ITunes.DEFAULT_BITRATE;
      totalTime = ITunes.DEFAULT_PLAY_TIME;      
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
    * String has no leading or trailing spaces. Correctly uses plural on minutes 
    * and seconds.
    * @return specified String
    */
   String timeInMinutesAndSeconds()
   {
      int minutes = totalTime / ITunes.MILLISEC_PER_MIN;
      int seconds = (totalTime % ITunes.MILLISEC_PER_MIN) 
            / ITunes.MILLISEC_PER_SEC;
      String rtnStr = "";
      
      if (minutes != 0)
      {
         rtnStr += minutes + " minute" + (minutes > 1 ? "s" : "");
         if (seconds == 0)
            return rtnStr;
         else 
            rtnStr += " ";
      }
      return rtnStr + seconds + " second" + (seconds > 1 ? "s" : "");
   }
   
} // end class ITunes

/******************************** RUN ******************************************
*** Display original instantiated objects
First object using default constructor and other objects using legal parameters

iTune1
ITunes song ------:
Title: " (undefined) " / Artist:  (undefined) 
Playing Time: 5 seconds / Bit Rate: 64k

iTune2
ITunes song ------:
Title: "Stairway to Heaven" / Artist: Led Zeppelin
Playing Time: 5 minutes / Bit Rate: 64k

iTune3
ITunes song ------:
Title: "Lust for Life" / Artist: Iggy and the Stooges
Playing Time: 3 minutes / Bit Rate: 705k

iTune4
ITunes song ------:
Title: "Ave Maria" / Artist: Chanticleer
Playing Time: 4 minutes 2 seconds / Bit Rate: 705k

*** Display after legal mutations in all objects

iTune1, name, artist, bitrate & totalTime mutated
ITunes song ------:
Title: "Here Comes the Sun" / Artist: Beatles
Playing Time: 3 minutes 5 seconds / Bit Rate: 100k

iTune2 artist mutated
ITunes song ------:
Title: "Stairway to Heaven" / Artist: Chanticleer
Playing Time: 5 minutes / Bit Rate: 64k

iTune3, name and artist mutated
ITunes song ------:
Title: "5 Foot 1" / Artist: Iggy Pop
Playing Time: 3 minutes / Bit Rate: 705k

iTune4 bitrate mutated
ITunes song ------:
Title: "Ave Maria" / Artist: Chanticleer
Playing Time: 4 minutes 2 seconds / Bit Rate: 600k

*** Display after invoking setDefaults
All objects should display their default values

iTune1
ITunes song ------:
Title: " (undefined) " / Artist:  (undefined) 
Playing Time: 5 seconds / Bit Rate: 64k

iTune2
ITunes song ------:
Title: " (undefined) " / Artist:  (undefined) 
Playing Time: 5 seconds / Bit Rate: 64k

iTune3
ITunes song ------:
Title: " (undefined) " / Artist:  (undefined) 
Playing Time: 5 seconds / Bit Rate: 64k

iTune4
ITunes song ------:
Title: " (undefined) " / Artist:  (undefined) 
Playing Time: 5 seconds / Bit Rate: 64k

*** Testing mutator's boolean returns
Correctly rejected bad setArtist mutation
Correctly rejected bad setBitrate mutation
Correctly accepted good setBitrate mutation
Correctly accepted good setName mutation

*** Testing ITunes Class with arrays
Expected results are:

tune 0: illegal bitrate, use default bitrate: 64
tune 1: illegal totalTime, use default totalTime: 5000
tune 2: all legal parameters
tune 3: all legal parameters
tune 4: all legal parameters
tune 5: all legal parameters
tune 6: illegal name, use default name:  (undefined) 
tune 7: illegal artist, use default artist:  (undefined) 
tune 8: illegal bitrate, use default bitrate: 64
tune 9: illegal totalTime, use default totalTime: 5000

Array tune 0 is:
ITunes song ------:
Title: "Stairway to Heaven" / Artist: Led Zeppelin
Playing Time: 5 seconds / Bit Rate: 64k

Array tune 1 is:
ITunes song ------:
Title: "Lust for Life" / Artist: Iggy and the Stooges
Playing Time: 5 seconds / Bit Rate: 705k

Array tune 2 is:
ITunes song ------:
Title: "Ave Maria" / Artist: Chanticleer
Playing Time: 4 minutes 5 seconds / Bit Rate: 100k

Array tune 3 is:
ITunes song ------:
Title: "Here Comes the Sun" / Artist: Beatles
Playing Time: 4 minutes 10 seconds / Bit Rate: 120k

Array tune 4 is:
ITunes song ------:
Title: "Overture of 1812" / Artist: Boston Pops
Playing Time: 12 minutes / Bit Rate: 700k

Array tune 5 is:
ITunes song ------:
Title: "Roadrunner" / Artist: Jonathon Richman
Playing Time: 10 minutes 36 seconds / Bit Rate: 64k

Array tune 6 is:
ITunes song ------:
Title: " (undefined) " / Artist: 50 Cent
Playing Time: 6 minutes 28 seconds / Bit Rate: 450k

Array tune 7 is:
ITunes song ------:
Title: "Fugue in D Minor" / Artist:  (undefined) 
Playing Time: 12 minutes 17 seconds / Bit Rate: 705k

Array tune 8 is:
ITunes song ------:
Title: "Victory Dance" / Artist: Elvis Costello
Playing Time: 60 minutes / Bit Rate: 64k

Array tune 9 is:
ITunes song ------:
Title: "Denis" / Artist: Blondie
Playing Time: 5 seconds / Bit Rate: 64k

Tests for leading & trailing spaces & proper plurals in timeInMinutesAndSeconds
The following should show:
(1)no leading or trailing spaces in totalTime values,
(2)a single space between minutes and seconds, and
(3)proper plurals on minutes and seconds
-->5 seconds<--
-->2 minutes 1 second<--
-->60 minutes<--
-->1 minute<--
-->2 minutes 5 seconds<--
*******************************************************************************/
