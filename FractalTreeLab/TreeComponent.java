import java.awt.*;
import javax.swing.JPanel;
import java.awt.geom.Line2D;
/**
 * Write a description of class TreeComponent here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TreeComponent extends JPanel
{
    private final int PANEL_WIDTH = 800;
    private final int PANEL_HEIGHT = 600;
    private int order;

    private final int PX1 = 400, PY1 = 550;

    /**
     * Constructor for objects of class TreeComponent
     */
    public TreeComponent()
    {
        setBackground(Color.white);
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        order = 1;
    }

    public void drawFractal(int x, int y, int angle, int length, int mleng, Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        double nlen = length * .7;
        if(length < mleng)
        {            
        }
        else
        {
            double opp = Math.sin(Math.toRadians(angle)) * length;
            double adj = Math.cos(Math.toRadians(angle))* length;
            double x2 = x + adj;
            double y2 = y - opp;
            Line2D.Double liner = new Line2D.Double(x, y, x2, y2);
            g2.draw(liner);
            drawFractal((int)x2, (int)y2, angle - 30, (int)nlen, 1, g);
            drawFractal((int)x2 , (int)y2, angle + 20, (int)nlen, 1, g);
        }
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.red);
        drawFractal(PX1, PY1, 90, 150, 1, g);
    }
}
