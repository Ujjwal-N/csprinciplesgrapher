package grappha;



import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
 
/**
 * This program demonstrates how to draw lines using Graphics2D object.
 * @author www.codejava.net
 *
 */
public class MainGrapher extends JFrame {
	
	private static double a = 3;
	private static double b = 5;
	private static double c = 0;
	
    public MainGrapher() {
        super("Main Grapha");
 
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
 
    void drawLines(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        
        //Axes
        g2d.draw(new Line2D.Double(0, 250, 500, 250));
        g2d.draw(new Line2D.Double(250, 0, 250, 500));
        
        //Right tick marks
        for(int count = 1; count < 26; count++){
        	g2d.draw(new Line2D.Double(250 + (count * 10), 247, 250 + (count * 10), 253));
        }
        
        //Left tick marks
        for(int count = 1; count < 26; count++){
        	g2d.draw(new Line2D.Double((count * 10), 247, (count * 10), 253));
        }
        
        //Top tick marks
        for(int count = 1; count < 26; count++){
        	g2d.draw(new Line2D.Double(247, (count * 10), 253, (count * 10)));
        }
        
        //Bottom tick marks
        for(int count = 1; count < 26; count++){
        	g2d.draw(new Line2D.Double(247, 250 + (count * 10), 253, 250 + (count * 10)));
        }
        double startX = 250;
        double startY = 250 - (c * 10);
        double middleX = 300;
        double middleY = 250 - ((25 * a + 5 * b + c) * 10);
        double endX = 500;
        double endY = 250 - ((100 * a + 10 * b + c) * 10);
        QuadCurve2D.Double curve = new QuadCurve2D.Double(startX, startY, middleX, middleY, endX, endY);
        g2d.draw(curve);
    }
 
    public void paint(Graphics g) {
        super.paint(g);
        drawLines(g);
    }
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainGrapher().setVisible(true);
            }
        });
    }
}
