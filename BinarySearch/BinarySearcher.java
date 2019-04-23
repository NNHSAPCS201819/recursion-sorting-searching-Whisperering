/**
   A class for executing binary searches in an array.
*/
public class BinarySearcher
{  
   /**
      Finds a value in a range of a sorted array, using the binary
      search algorithm.
      @param a the array in which to search
      @param low the low index of the range
      @param high the high index of the range
      @param value the value to find
      @return the index at which the value occurs, or -1
      if it does not occur in the array
   */
   public static int search(int[] a, int low, int high, int value)
   {  
      int middle = (int)(low + high)/2;
      if(a[middle] == value)
      {
          return middle;
      }
      else if(low > high)
      {
          return (-1 * search(a, 0, a.length - 1, value - 1)) - 1;
      }
      else if(a[middle] < value)
      {
          
          return search(a, middle+1, high, value);
      }
      else if(a[middle] > value)
      {
          
          return search(a, low, middle-1, value);
      }
      return -1;
   }
}

