import java.awt.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.*;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class PatternMaker extends Canvas{

    //Constants
    public static final int CANVAS_WIDTH = 800;
    public static final int CANVAS_HEIGHT = 800;

    public Cell cellTree = new Cell(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT, true);

    Color castro = new Color(80,0,26);
    Color burnham = new Color(0,41,21);
    Color blackRussian = new Color(21,0,41);
    Color daffodil = new Color(255,255,52);
    Color starship = new Color(245,245,82);
    Color difRed = new Color(1.0f,0,0, 0.5f);
    public static void main(String[] args) {
        JFrame frame = new JFrame("My Drawing");
        Canvas canvas = new PatternMaker();
        canvas.setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        //for (int i = 0; i < 100; i++) {
        g.setColor(Color.BLACK);
        g.fillRect(cellTree.origin.x, cellTree.origin.y, cellTree.width, cellTree.height);
        g.setColor(Color.WHITE);
        paintTree(g, cellTree);
        paintLines(g, cellTree);
//        }
    }

    private void paintTree(Graphics g, Cell cellTree){ //recursively traverse the tree and draw each cell
        //g.drawRect(cellTree.origin.x, cellTree.origin.y, cellTree.width, cellTree.height);
//        try {
//            TimeUnit.MILLISECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        if (cellTree.children.size() > 0){
            for (int i = 0; i < cellTree.children.size(); i++){
                paintTree(g, cellTree.children.get(i));
            }
        }
        else{
            int willColor = (int)(Math.random() * 10);
            if (willColor == 1) {
//                try {
//                    TimeUnit.MILLISECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                g.setColor(Color.ORANGE);
                g.fillRect(cellTree.origin.x, cellTree.origin.y, cellTree.width, cellTree.height);
                g.setColor(Color.WHITE);
            }
//            else if (willColor == 2) {
//                g.setColor(Color.RED);
//                g.fillRect(cellTree.origin.x, cellTree.origin.y, cellTree.width, cellTree.height);
//                g.setColor(Color.BLACK);
//            }
        }
    }

    private void paintLines(Graphics g, Cell cellTree){
        g.drawRect(cellTree.origin.x, cellTree.origin.y, cellTree.width, cellTree.height);
//        try {
//            TimeUnit.MICROSECONDS.sleep(50);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        if (cellTree.children.size() > 0){
            for (int i = 0; i < cellTree.children.size(); i++){
                paintLines(g, cellTree.children.get(i));
            }
        }
    }
}
