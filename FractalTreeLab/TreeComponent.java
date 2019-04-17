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
        int nlen = (int)(length * .5);
        if(order == 1)
        {
            Line2D.Double line1 = new Line2D.Double(x, y, x, y - length);
            g2.draw(line1);
            order++;
            drawFractal(x, y - length, 45, nlen, 1, g);
        }
        else if(length > mleng)
        {
            int rat1 = (int)(Math.sin(Math.toRadians(angle)));
            int rat2 = (int)(Math.cos(Math.toRadians(angle)));
            int opp = rat1 * length;
            int adj = rat2 * length;
            Line2D.Double liner = new Line2D.Double(x, y, (x + adj), (y - opp));
            g2.draw(liner);
            // drawFractal(x + adj, y - opp, angle, nlen, 1, g);
            // drawFractal(x, y, angle, nlen, 1, g);
        }
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.red);
        drawFractal(PX1, PY1, 45, 200, 1, g);
    }
}
