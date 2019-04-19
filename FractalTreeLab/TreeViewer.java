import java.awt.*;
import javax.swing.*;
/**
 * Creates a JFrame object to which all desired components are
 * added especially the TreeComponent object which diplays
 * fractal trees.
 *
 * @author Evelina Mielko
 * @version 04/18/2019
 */
public class TreeViewer
{
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    private TreeComponent tBuilder;
    private JFrame frame;
    private JPanel panel;
    
    /**
     * Creates and adds all desired components to a JFrame type
     */
    public TreeViewer()
    {
        frame = new JFrame();
        panel = new JPanel();
        tBuilder = new TreeComponent();
        panel.add(tBuilder);
        frame.setTitle("Fractal Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.add(panel);
        frame.setVisible(true);
    }
    
    /**
     * Constructor for objects of class TreeViewer
     */
    public static void main(String[] args)
    {
        TreeViewer viewer = new TreeViewer();
    }
}
