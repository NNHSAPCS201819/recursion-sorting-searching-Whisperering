import java.util.Scanner;

/**
   This class processes baby name records.
*/
public class RecordReader
{
   private double total;
   private double limit;
   private double births;

   /**
      Constructs a RecordReader with a zero total.
   */
   public RecordReader(double aLimit, Scanner in)
   {
      total = 0;
      limit = aLimit;
      births = (double)(Integer.parseInt(in.next().replaceAll(",", "")));
   }

   /**
      Reads an input record and prints the name if the current total is less 
      than the limit.
      @param in the input stream
   */
   public void process(Scanner in)
   {
      String name = in.next();
      int count = in.nextInt();
      double percent =  100 * (count / births);
      
      if (total < limit) { System.out.print(name + " "); }
      //total++;
      total = total + percent;
   }

   /**
      Checks whether there are more inputs to process
      @return true if the limit has not yet been reached
   */
   public boolean hasMore()
   {
      return total < limit;
   }
}
