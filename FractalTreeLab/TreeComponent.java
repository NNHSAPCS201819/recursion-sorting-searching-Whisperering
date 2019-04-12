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
    private final int PANEL_HEIGHT = 500;
    private int order;
    
    private final int PX1 = 400, PY1 = 400;
    private final int PX2 = 400, PY2 = 450;
    
    /**
     * Constructor for objects of class TreeComponent
     */
    public TreeComponent()
    {
        setBackground(Color.white);
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        order = 0;
    }

    public void drawFractal(int x1, int y1, int x2, int y2, Graphics g)
    {
        if(order == 1)
        {
            Line2D.Double line1 = new Line2D.Double(x1, y1, x2, y2);
            g.draw(line1);
            order++;
        }
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.red);
        drawFractal(PX1, PY1, PX2, PY1, g);
    }
}
