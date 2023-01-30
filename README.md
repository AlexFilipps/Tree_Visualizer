# Tree_Visualizer
A small program which visualizes a randomized tree structure as a recursively drawn collection of rectangles.

  This program was created with the goal of creating an interesting visualization of a tree-like data structure. While in theory any tree based structure could be displayed, the one implemented in this program was designed to be quite varried in shape. Specifically, each node of the tree has a random number of children nodes (between 3 and 12), and the depth of branches in the tree is inconsistent (but is capped to a depth of 8). The reason for using this tree structure is that a less consistent distribution of data in the tree results in a more interesting final image. 
  
  
  
Above are a few example images that can be generated.
  
  The algorithm works by taking a canvas and recursively dividing its space based on the generated tree structure described above. Each node of the tree represents a division on the canvas, and each of its children a division of that division. For example if the root of our tree had 5 children, our canvas would be divided into 5 equal portions representing each child. There would then be a recursive call for each child to divide its canvas portion based on the number of children it had. By swapping the axis on which divisions take place at each new tree depth, we get the interesting psuedo grid-like pattern seen above. Some random recoloring of regions was also done because I thought it looked cool. :)   
