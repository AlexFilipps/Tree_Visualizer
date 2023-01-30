import java.util.*;

public class Cell { //represents a space surrounded on all sides by lines (like a rectangle, but totally different and way cooler)
    List<Cell> children;
    Point origin;
    int width;
    int height;

    public Cell(int x, int y, int width, int height, boolean top){
        children = new ArrayList<Cell>();
        origin = new Point(x,y);
        this.width = width;
        this.height = height;
        populate(0);
    }

    public Cell(int x, int y, int width, int height){
        children = new ArrayList<Cell>();
        origin = new Point(x,y);
        this.width = width;
        this.height = height;
    }

    private void populate(int depth){
        int willIter = (int)(Math.random() * 4);
        if ((willIter != 1) && (depth != 8)){
            if (depth % 2 == 0){
                populateHor();
                for (int i = 0; i < children.size(); i++){
                    children.get(i).populate(depth+1);
                }
            }
            else{
                populateVert();
                for (int i = 0; i < children.size(); i++){
                    children.get(i).populate(depth+1);
                }
            }
        }
    }

    private void populateHor(){ //populates the subtree of a cell with a series of horizontally adjacent cells
        Cell childCell;
        int numIter = 3 + ((int)(Math.random() * 10));

        int randWidths[] = new int[numIter + 1];
        for (int i = 0; i < numIter - 1; i++){
            randWidths[i] = (int)(Math.random() * width);
        }
        randWidths[numIter - 1] = 0;
        randWidths[numIter] = width;
        Arrays.sort(randWidths);

        for (int i = 0; i < numIter; i++){
            childCell = new Cell(origin.x + randWidths[i], origin.y, (origin.x + randWidths[i+1]) - (origin.x + randWidths[i]), height);
            children.add(childCell);
        }
    }

    private void populateVert(){ //populates the subtree of a cell with a series of vertically adjacent cells
        Cell childCell;
        int numIter = 5;

        int randHeights[] = new int[numIter + 1];
        for (int i = 0; i < numIter - 1; i++){
            randHeights[i] = (int)(Math.random() * height);
        }
        randHeights[numIter - 1] = 0;
        randHeights[numIter] = height;
        Arrays.sort(randHeights);

        for (int i = 0; i < numIter; i++){
            childCell = new Cell(origin.x, origin.y + randHeights[i], width, (origin.y + randHeights[i+1]) - (origin.y + randHeights[i]));
            children.add(childCell);
        }
    }
}
