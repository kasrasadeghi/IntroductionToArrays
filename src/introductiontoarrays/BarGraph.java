/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introductiontoarrays;

/**
 *
 * @author DSTIGANT
 */
public class BarGraph
{
    private int[] bars;
    private String [] labels;
    
    public BarGraph( int [] bs, String [] ls )
    {
        bars = bs;
        labels = ls;
    }
    
    public int [] getBars() { return bars; }
    public String [] getLabels() { return labels; }
}
