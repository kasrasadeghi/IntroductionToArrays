/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introductiontoarrays;

import apcscvm.DefaultControl;
/**
 *
 * @author DSTIGANT
 */
public class SineWaveBarGraphController extends DefaultControl<BarGraph>
{
    private double t = 0;
    
    public double sin(double x) {
        return Math.sin(x);
    }
    
    public double sqrt(double x) {
        return Math.sqrt(x);
    }
    
    
    @Override
    public void handleTimePassage( BarGraph bg, int ea, int dt )
    {
        t += dt/100.0;
        double PI = Math.PI;
        
        // get the bars array from the bar graph
        // update the bars array to be 200 + 100sin((i+t)*2*PI/n) + 50*sin((i+t)*sqrt(5)*PI/n + 25*sin((i+t)*sqrt(10)*PI/n)
        // where i is the bar index, and n is the number of bars
        int[] bars = bg.getBars();
        int n = bars.length;
        for ( int i = 0; i < n; i++) {
            bars[i] = (int)(
                    200 
                  + 100*sin((2 * (i+t) + PI) / n)  
                  + 50*sin(((i+t) * PI * sqrt(5))/n)  
                  + 25*sin(((i+t) * PI * sqrt(10))/n)
                    );
        }
    }
}
