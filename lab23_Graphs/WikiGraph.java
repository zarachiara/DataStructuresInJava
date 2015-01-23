import java.util.*;

public interface WikiGraph {

    /**
     * Follows the first link of articles starting at title and adds pages it finds to the WikiGraph
     * @param title The title of a Wikipedia article
     */
    public void explore(String title);
    
    /**
     * 
     * @return a set of all pages so far discovered using explore
     */
    public Set<String> getVertices();
    
    /**
     * This method shouldn't have to use the internet
     * @param title The title of a Wikipedia article
     * @return The page that can be found by following the first link from title
     */
    public String nextTitle(String title);
    
    /**
     * 
     * @param title The title of a Wikipedia article
     * @return A set of pages we've found whose first link leads to title
     */
    public Set<String> prevTitles(String title);
    
    /**
     * 
     * @param title The title of a Wikipedia article
     * @return Starting at title, the number of articles you can travel following the first link before you visit an article you have already seen before 
     */
    public int distanceToCycle(String title);

}