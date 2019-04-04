import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * Write a description of class Wc here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Wc
{
    public static void main (String args[]) throws FileNotFoundException
    {
        String str = "";
        String spaces = "";
        String periods = "";
        String file = "";
        if(args.length > 0)
        {
            ;file = args[0];
        }
        else
        {
            Scanner s = new Scanner(System.in);
            System.out.print("Enter a file name: ");
            file = s.next();
        }
        File newFile = new File(file);
        Scanner read = new Scanner(newFile);
        Scanner readw = new Scanner(newFile);
        Scanner readl = new Scanner(newFile);
        read.useDelimiter("[^A-Za-z]+");
        int characterCount = 0;
        while(read.hasNext())
        {
            str += read.next();
        }
        read.close();
        readw.useDelimiter("[^ ]");
        int wordCount = 0;
        while(readw.hasNext())
        {
            spaces += readw.next();
        }
        readw.close();
        readl.useDelimiter("[^.]");
        readl.useDelimiter("\n");
        int lineCount = 0;
        while(readl.hasNext())
        {
            readl.next();
            lineCount ++;
        }
        readl.close();
        characterCount = str.length();
        wordCount = spaces.length() + 1;
        System.out.println("There are " + characterCount + " characters.");
        System.out.println("There are " + wordCount + " words.");
        System.out.println("There are " + lineCount + " lines.");
    }
}
