import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.io.IOException;

public class SpeedReader {
	
    public static int breakIndex (String word){ //return the index of the letter to be emphasized
        if(word.length()<2){
            return 0;
        }
        else if(word.length()<6){
            return 1;
        }
        else if(word.length()<10){
            return 2;
        }
        else if(word.length()<14){
            return 3;
        }
        else {
            return 4;
        }
    }
	
	
    public static void printWords(String filename, int width, int height, int fontSize, int wpm) throws IOException,InterruptedException { //to print the words on a drawing panel
        DrawingPanel panel = new DrawingPanel(width, height);
        Graphics g = panel.getGraphics();
        Font f = new Font("Courier", Font.BOLD, fontSize);
        FontMetrics met = g.getFontMetrics(f);
        WordGenerator word = new WordGenerator(filename);
        int sleepTime = 60000 / wpm;
        while (word.hasNext()) {
            String str = word.next();
            int strXpos = (width - met.stringWidth(str))/2;
            int strYpos = (height - met.getHeight())/2 + met.getAscent();
            g.setFont(f);
            int index = breakIndex(str);
            g.drawString(str.substring(0,index), strXpos, strYpos); //coloring the first few letters with black
            Color orig = g.getColor(); //in order to get this color back
            g.setColor(Color.RED); //change the color to emphasize the character
            g.drawString(str.charAt(index)+"", strXpos+met.stringWidth(str.substring(0,index)), strYpos);
            g.setColor(orig); //change the color back to original
            g.drawString(str.substring(index+1), strXpos+met.stringWidth(str.substring(0, index+1)), strYpos); //print the rest of the string in black
            Thread.sleep(sleepTime); //add delay or pause according to the wpm
            g.setColor(Color.WHITE); 
            g.fillRect(0, 0, width, height); //draw a white rectangle to clear the screen
            g.setColor(orig);
        }
        String str = "Words read: "+word.wordCount;
        g.setFont(new Font("Courier", Font.BOLD, 20));
        g.drawString(str, 100, 100);
        g.drawString("Sentences Read: "+word.sentenceCount, 100, 150);
    }

    public static void main(String[] args) throws IOException,InterruptedException {
        if(args.length!=5){ //print an error message when wrong number of arguments are given
            System.out.println("Wrong number of arguments given!");
        }
        else{
            int width = Integer.parseInt(args[1]);
            int height = Integer.parseInt(args[2]);
            int fontSize = Integer.parseInt(args[3]);
            int wpm = Integer.parseInt(args[4]);
            printWords(args[0], width, height, fontSize, wpm);
        }

    }

}
