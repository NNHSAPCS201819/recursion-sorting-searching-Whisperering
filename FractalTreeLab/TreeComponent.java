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

    private final int PX1 = 400, PY1 = 350;
    private final int PX2 = 400, PY2 = 550;

    /**
     * Constructor for objects of class TreeComponent
     */
    public TreeComponent()
    {
        setBackground(Color.white);
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        order = 1;
    }

    public void drawFractal(int x1, int y1, int x2, int y2, int angle, int length, int mleng, Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        int nlen = (int)(length * .5);
        if(order == 1)
        {
            Line2D.Double line1 = new Line2D.Double(x1, y1, x2, y2);
            g2.draw(line1);
            // Line2D.Double line2 = new Line2D.Double(x1, y1, x2, y2);
            // g2.draw(line2);
            // Line2D.Double line3 = new Line2D.Double(x1, y1, x2, y2);
            // g2.draw(line3);
            order++;
        }
        if(length > mleng)
        {
            int rat1 = (int)(Math.sin(Math.toRadians(angle)));
            int rat2 = (int)(Math.cos(Math.toRadians(angle)));
            int opp = rat1 * length;
            int adj = rat2 * length;
            Line2D.Double liner = new Line2D.Double(x1, y1, (x1 - adj), (y1 - opp));
            g2.draw(liner);
            // drawFractal(x2, y2, x2, y2, angle, nlen, 1, g);
            // drawFractal(x2, y2, x2, y2, angle, nlen, 1, g);
        }
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.red);
        drawFractal(PX1, PY1, PX2, PY2, 45, 200, 1, g);
    }
}
