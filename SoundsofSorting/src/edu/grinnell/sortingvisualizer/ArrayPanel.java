package edu.grinnell.sortingvisualizer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ArrayPanel extends JPanel {

    private NoteIndices notes;
    
    /**
     * Constructs a new ArrayPanel that renders the given note indices to
     * the screen.
     * @param notes the indices to render
     * @param width the width of the panel
     * @param height the height of the panel
     */
    public ArrayPanel(NoteIndices notes, int width, int height) {
        this.notes = notes;
        this.setPreferredSize(new Dimension(width, height));
    }

    @Override
    public void paintComponent(Graphics g) {
    	// initialize an empty plane
    	int width = this.getWidth();
    	int height = this.getHeight();
		g.setColor(Color.white);
        g.fillRect(0, 0, width, height);
        
        //draw bars with different colors according to their heights.
        Integer[] notesarray = notes.getNotes();
        int n = notesarray.length;
        int barwidth = width / n;
        int barheightunit = height / n;
        int barheight;
        for (int i = 0;i < n; i++){
        	barheight = barheightunit * (notesarray[i]+1);
        	if(notes.isHighlighted(i)){
        		//set highlighted bar to yellow
        		g.setColor(new Color (255,255,0));
        	}else{
        		//shorter bars are greener while higher bars are bluer
        		int green = (height-barheight) *180 /height + 75;
        		int blue = barheight * 180 / height + 75;
        		g.setColor(new Color (0,green,blue));
        	}
        	g.fillRect(i*barwidth, height-barheight, barwidth, barheight);
        	
        }
        
    }
}