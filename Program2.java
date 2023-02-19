/*
 * Name: Jon Snow
 * EID: GoT0001
 */

// Implement your algorithms here
// Methods may be added to this file, but don't remove anything
// Include this file in your final submission

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Program2 {

    /**
     * findMinimumLength()
     * @param problem  - contains the regions of the graph.
     * 
     * @return The sum of all of the edges of the MST.
     * 
     * @function Should track the edges in the MST using region.mst_neighbors and region.mst_weights
     *  This function will not modify the mst_lists when run Gradescope if called in calculateDiameter()
     */
    public int findMinimumLength(Problem problem) {

        problem.getRegions().get(0).setMinDist(0);
        Queue<Region> heap = new PriorityQueue<>(problem.getRegions());

        // TODO: implement this function




        
        return -1;
    }

    

    /* calculateDiameter(Problem problem)
     * 
     * @param problem  - contains the regions of the problem. Each region has an adjacency list
     * defined by mst_neighbors and mst_weights, which defines the provided MST.
     * 
     */
    public int calculateDiameter(Problem problem) {
        
        // Call findMinimumLength in your code to get MST. In gradescope, we will provide the mst in each regions mst_neighbors nad mst_weights list
        int length = findMinimumLength(problem);
        
        // TODO: Implement this function



        
        return 0;
    }

    
}
