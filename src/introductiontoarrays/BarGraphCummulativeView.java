/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introductiontoarrays;

import apcscvm.View;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author DSTIGANT
 */
public class BarGraphCummulativeView implements View<BarGraph>
{

    @Override
    public void paint(BarGraph bg, Graphics g, int w, int h)
    {
        // get the bars of the bar graph
        
        // create a new bars array of the same length
        
        // use a for loop to set the ith entry of the new bar array to the sum of the first i bars in the old array
        // hint: this is similar to an accumulation style for loop.  But instead of only being interested
        // in the final sum, you're storing each intermediate sum in a different element of an array
        
        // create a new bar graph from the new bars and the old labels
        
        // create a new BarGraphView and call its paint method with the new bar graph and the other parameters
        // passed to our paint function.
        
    }
    
}
