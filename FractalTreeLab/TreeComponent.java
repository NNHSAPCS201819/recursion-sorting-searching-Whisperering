import java.awt.*;
import javax.swing.JPanel;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;
/**
 * A JPanel type class with which fractal tree is drawn.
 *
 * @author Evelina Mielko
 * @version 04/18/2019
 */
public class TreeComponent extends JPanel

{
    private final int PANEL_WIDTH = 800;
    private final int PANEL_HEIGHT = 600;
    private final int PX = 400, PY = 550;

    /**
     * Constructor for objects of class TreeComponent
     */
    public TreeComponent()
    {
        setBackground(Color.black);
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    }

    /**
     * Recursive method:
     * Draws the fractal tree and for each branch sets branch a
     * different color and branch a different width according to 
     * a randomly generated value. Draws quadratic curves as a
     * terminating condition.
     * @param x     Starting x-coodinate of the fractal tree.
     * @param y     Starting y-coodinate of the fractal tree.
     * @param angle     Angle between the branches
     * @param length        Starting branch length
     * @param mleng     How much smaller the branches are
     * @param g     Graphics object for creating images
     * @param scale     How much smaller the branches will get
     */
    public void drawFractal(int x, int y, int angle, int length, int mleng, double scale, Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        double nlen = length * scale;
        if(length < mleng)
        {
            g2.setStroke(new BasicStroke(1));
            QuadCurve2D.Double terminate = new QuadCurve2D.Double(x-2, y-2, x, y, x+2, y+2);
            g2.draw(terminate);
        }
        else
        {
            double opp = Math.sin(Math.toRadians(angle)) * length;
            double adj = Math.cos(Math.toRadians(angle))* length;
            double x2 = x + adj;
            double y2 = y - opp;
            Line2D.Double liner = new Line2D.Double(x, y, x2, y2);
            g2.draw(liner);
            int rand = (int)(Math.random() * 4);
            int randw = (int)(Math.random() * 3);
            if(rand == 1)
            {
                g2.setColor(Color.red);
            }
            else if(rand == 2)
            {
                g2.setColor(Color.orange);
            }
            else
            {
                g2.setColor(Color.green);
            }
            if(randw == 1)
            {
                g2.setStroke(new BasicStroke(1));
            }
            else
            {
                g2.setStroke(new BasicStroke(2));
            }
            drawFractal((int)x2, (int)y2, angle - 30, (int)nlen, 1, .7, g);
            drawFractal((int)x2 , (int)y2, angle + 30, (int)nlen, 1, .7, g);
        }
    }

    /**
     * Invokes the fractalTree method and draws fractal trees.
     */
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.red);
        drawFractal(PX, PY, 90, 120, 1, .7, g);
        drawFractal(PX, PY - 120, 90, 120, 1, .7, g);
        drawFractal(PX, PY - 60, 45, 120, 1, .7, g);
        drawFractal(PX, PY - 60, 135, 120, 1, .7, g);
    }
}
