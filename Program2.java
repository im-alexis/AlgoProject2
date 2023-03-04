/*
 * Name: Alexis Torres
 * EID: at39625
 */
//test

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
        
        ArrayList <Region> regions = problem.getRegions();
        ArrayList<Boolean> isInMST = new ArrayList<>(regions.size()); //This will be to check if an vertex is connected to the mst, indexed by region name
        ArrayList <Boolean> isInQ = new ArrayList<>(regions.size()); // This list will see if a vertex is Queue
        ArrayList <Integer> predecessor = new ArrayList<>(regions.size()); //This list will hold the predcessor of each reagion min dist

        for (int i = 0; i < regions.size(); i++){
            isInMST.add(false);
            isInQ.add(true);
            predecessor.add(null);
        }

     
        int minWeightLen = 0;
        
        while (heap.size() != 0){ 

            Region inspectedRegion = heap.remove(); // Remove minimum in Queue
            int inspectedRegionName = inspectedRegion.getName();
            ArrayList<Region> neighbors = inspectedRegion.getNeighbors();
            ArrayList<Integer> weights = inspectedRegion.getWeights();
            isInQ.set(inspectedRegionName, false); // mark that inspectedRegion not in the Queue



            if(!isInMST.get(inspectedRegionName)){ // Adding an edge to MST
                isInMST.set(inspectedRegionName, true);
                Integer edgeWeight = inspectedRegion.getMinDist();
                minWeightLen = minWeightLen + edgeWeight; //To keep track of aggegete edges
                if(!(predecessor.get(inspectedRegionName) == null)){ // check so only everything after the root noded gets an edge
                    int preInspectedRegionName = predecessor.get(inspectedRegionName);
                    Region preInspectedRegion = regions.get(preInspectedRegionName);
                    preInspectedRegion.getMST_Neighbors().add(inspectedRegion);
                    preInspectedRegion.getMST_Weights().add(edgeWeight);

                    inspectedRegion.getMST_Neighbors().add(preInspectedRegion);
                    inspectedRegion.getMST_Weights().add(edgeWeight);
                }

            }


            for (int i = 0; i < neighbors.size(); i++){ 
                Region adjRegion = neighbors.get(i);
                int adjRegionName = adjRegion.getName();
                int adjRegionEdgeWeight = weights.get(i);
                
                if(adjRegionEdgeWeight  < adjRegion.getMinDist() && isInQ.get(adjRegionName)){ // if an edge from inspected region is better than the current minDistance
                    //To rearrange in heap
                    adjRegion.setMinDist(adjRegionEdgeWeight);
                    heap.remove(adjRegion);
                    heap.add(adjRegion); 
                    predecessor.set(adjRegion.getName(), inspectedRegionName);
 //To keep track of aggegete edges
                }
            }
        }

 
        return minWeightLen;
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
