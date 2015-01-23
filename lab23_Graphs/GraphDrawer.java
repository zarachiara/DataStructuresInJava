import java.io.File;
import java.io.StringWriter;
import java.util.Scanner;

import org.jgrapht.DirectedGraph;
import org.jgrapht.ext.DOTExporter;
import org.jgrapht.ext.IntegerNameProvider;
import org.jgrapht.ext.StringNameProvider;
import org.jgrapht.ext.VertexNameProvider;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

public class GraphDrawer {

    /**
     * Creates a file named filename.png with a picture of the graph wg 
     * @param wg a graph of Wikipedia article titles
     * @param filename
     */
    public static void writePng(WikiGraph wg, String filename){
        DirectedGraph<String, DefaultEdge> g = convertToDirectedGraph(wg);
        
        VertexNameProvider<String> v = new IntegerNameProvider<String>();
        StringNameProvider<String> l = new StringNameProvider<String>();
        DOTExporter<String, DefaultEdge> d = new DOTExporter<String, DefaultEdge>(v, l, null);

        StringWriter w = new StringWriter();
        d.export(w, g);
        Scanner s = new Scanner(w.toString());
        s.useDelimiter("\n");
        
        GraphViz gv = new GraphViz();
        while (s.hasNext()){
            gv.addln(s.next());
        }
        s.close();

        String type = "png";
        File out = new File(filename + "." + type);
   
        gv.writeGraphToFile(gv.getGraph(gv.getDotSource(), type ),  out);         
    }
    
    /**
     * Creates a file out.png with a picture of the graph wg 
     * @param wg a graph of Wikipedia article titles
     */
    public static void writePng(WikiGraph wg){
        writePng(wg, "out");
    }
    
    public static DirectedGraph<String, DefaultEdge> convertToDirectedGraph(WikiGraph wg){
        DirectedGraph<String, DefaultEdge> g = new DefaultDirectedGraph<String, DefaultEdge>(DefaultEdge.class);
        for (String vertex: wg.getVertices()){
            if (vertex != null){
            	g.addVertex(vertex);
            }       
        }
        for (String vertex: wg.getVertices()){
            for (String prev: wg.prevTitles(vertex)){
                if (vertex != null && prev != null){
                    g.addEdge(prev, vertex);
                }
            }
        }    
        return g;
    }
}