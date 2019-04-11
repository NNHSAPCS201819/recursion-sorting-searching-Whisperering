import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Write a description of class TreeViewer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TreeViewer
{
    // instance variables - replace the example below with your own
    private final int WIDTH = 800;
    private final int HEIGHT = 1000;
    private TreeComponent tBuilder;
    private JFrame frame;
    
    public TreeViewer()
    {
        frame = new JFrame();
        frame.setTitle("Fractal Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
    }
    
    /**
     * Constructor for objects of class TreeViewer
     */
    public static void main(String[] args)
    {
        TreeViewer viewer = new TreeViewer();
    }
    
    public void actionPerformed(ActionEvent event)
    {
    }
}
