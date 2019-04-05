import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BabyNames
{
    public static final double LIMIT = 50;

    public static void main(String[] args) throws FileNotFoundException
    {  
        Scanner s = new Scanner(System.in);
        String file = "";
        try
        {
            System.out.print("Enter file name: ");
            file = s.next();
        }
        catch(FileNotFoundException ex)
        {
        }
        
        Scanner in = new Scanner(new File(file));

        RecordReader boys = new RecordReader(LIMIT, in);
        RecordReader girls = new RecordReader(LIMIT, in);

        while (boys.hasMore() || girls.hasMore())
        {
            int rank = in.nextInt();
            System.out.print(rank + " ");
            boys.process(in);
            girls.process(in);
            System.out.println();
        }

        in.close();
    }
}	
