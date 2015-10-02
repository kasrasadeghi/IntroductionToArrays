/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introductiontoarrays;

import apcscvm.GraphicsUtilityFunctions;
import apcscvm.Mouse;
import apcscvm.View;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author DSTIGANT
 */
public class BarGraphView implements View<BarGraph>
{
    private Color color;
    
    public BarGraphView()
    {
        color = Color.BLUE;
    }
    
    public BarGraphView( Color c )
    {
        color = c;
    }
    
    @Override
    public void paint(BarGraph bg, Graphics g, int w, int h)
    {
        // Calculate a few things before we start:
        // The ULC of the bar graph bounding box should be 5% in from the left side of the window
        // and 5% down from the top of the window.  Calculate the x and y coordinates of the ULC
        int tlx = w/20;
        int tly = h/20;
        // the total width of the bar graph should be 90% of the width of the window
        int bgw = (w*9)/10;
        // and the height should be 85% of the height of the window.
        int bgh = (85*h)/100;
        // get the bars and labels from the bar graph
        int[] bars = bg.getBars();
        String[] labels = bg.getLabels();
        // find the maximum bar height.  Hint: this is an accumulator style for loop.
        int maxBarHeight = 1;
        for (int bar : bars) if (bar > maxBarHeight) maxBarHeight = bar;
        // calculate the width of each bar (the width of the bar graph over the number of bars
        int barWidth = bgw / bars.length;
        
        int bly = tly + bgh;
        // iterate over the bars array
        for (int i = 0; i < bars.length; i++) { 
            // the screen height of the bar is the value of the bar * graph height/ max bar height
            // draw and outline a rectangle in color
            // you'll need to calculate where the ULC of each bar is based on its screen height
            // and the ULC of the bar graph and the height of the bar graph and the bar number
            // and the width of each bar
            
            g.setColor( color );
            g.fillRect(tlx + i *  barWidth, bly - bars[i] * bgh / maxBarHeight, barWidth, bars[i] * bgh / maxBarHeight);
            g.setColor( Color.BLACK );
            g.drawRect(tlx + i *  barWidth, bly - bars[i] * bgh / maxBarHeight, barWidth, bars[i] * bgh / maxBarHeight);
//            g.fillRect(w/2, h/2, 50, 50);
            
        }
        
        // next draw the labels.
        // get a font using the getFont function in GraphicsUtilityFunctions
        // the height of the font should be 5% of the height of the window
        Font font = GraphicsUtilityFunctions.getFont(h/20);
        for (int i = 0; i < labels.length; i++ )
            GraphicsUtilityFunctions.drawStringWithFontInRectangle(g, 
                    labels[i], 
                    font, 
                    tlx + i * barWidth, 
                    bly, 
                    barWidth, 
                    h/20);
        // for each label in the labels array
            // use the drawStringWithFontInRectangle to draw the label in a rectangle
            // below the corresponding bar
        
        // finally, use the Mouse class to get the x and y coordinates of the mouse cursor
        int mx = Mouse.getX();
        int my = Mouse.getY();
        // figure out which bar the mouse is on (use the x-coordinate)
        int mouseBarHover = -1;
        for (int i = 0; i < bars.length; i++ ) {
            if ( mx >= tlx + i *  barWidth && mx <= tlx + i *  barWidth + barWidth) {
                mouseBarHover = i;
                if ( my >= bly - bars[i] * bgh / maxBarHeight && my <= bly ) {
                    g.setColor( Color.YELLOW);
                    g.fillRect(mx, my, 100, h/20);
                    g.setColor ( Color.BLACK);
                    g.drawRect(mx, my, 100, h/20);
                    String tooltip = labels[i] + ": " + bars[i];
                    GraphicsUtilityFunctions.drawStringWithFontInRectangle(g, tooltip, font, mx, my, 100, h/20);
                }
            }
                
        }
//        System.out.println("mouseBarHover Testing: " + mouseBarHover);
        
        
        // and see if the mouse is over the bar (get the distance from the base line to the mouse cursor)
        
        // make sure that the bar index is valid and the mouse height is less than the corresponding bar's screen height
            // if so, draw and outline a yellow rectangle of width 100 and height 5% of the height of the window
        
            // and draw the text of the box: "<label> : <bar height>"
            
    }
    
}
