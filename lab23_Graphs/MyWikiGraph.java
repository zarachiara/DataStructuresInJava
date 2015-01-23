import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;


public class MyWikiGraph implements WikiGraph {
	// hashMap that stores the links with keys and strings as values
	private HashMap<String, String> links;
	
	// constructor 
	public MyWikiGraph() {
		// create a hashmap 
		links = new HashMap<String,String>();
	}

	// a set of all pages so far discovered using explore
	public void explore(String title) {
		// create a hashset that stores visited pages
		HashSet<String> visited = new HashSet<String>();
		// stores the firstlink of a wikipedia page
		String firstlink = new String();
		// while the hashmap does not contain the key string title
		while (!visited.contains(title)) {
			// get the firstlink of that title using the LinkFollower class
			firstlink = LinkFollower.getFirstLink(title);
			// puts the title of the key and its firstlink as the value 
			links.put(title, firstlink);
			// adds the title to the hashset 
			visited.add(title);
			// changes the pointer of title to the first link
			// which contains the first link of the page
			title = firstlink;
			// edge case: when title is null, just break
			if (title == null) {
				break;
			}
		}	
		// once visited contains the title from the beginning
		// ToAsk: loop back to the title to close the edge??
		links.put(title, LinkFollower.getFirstLink(title));
	}

	@Override
	// This method shouldn't have to use the internet
	// title The title of a Wikipedia article
	// The page that can be found by following the first link from title
	public Set<String> getVertices() {
		// create a set - A collection that contains no duplicate elements.
		// stores the vertices which are the titles 
		HashSet<String> vertices = new HashSet<String>();
		// loop through all of the keys in links
		// keySet returns a set of keys from links 
		for (String vertex: links.keySet()) {
			// add the keys to vertices
			vertices.add(vertex);
		}
		// return set with all the keys as titles 
		return vertices;
	}

	@Override
	// title The title of a Wikipedia article
	public String nextTitle(String title) {
		// get the value of title which is the next link page 
		return links.get(title);
	}

	@Override
	//title The title of a Wikipedia article
	//A set of pages we've found whose first link leads to title
	public Set<String> prevTitles(String title) {
		// store the previousTitle into a hashSet
		HashSet<String> prevTitles = new HashSet<String>();
		// loop through the keys of links 
		for (String vertex: links.keySet()) {
			// if links the title is not null and the key is not equal to title
			if (links.get(vertex) != null && links.get(vertex).equals(title)) {
				// keeping track of title of pages 
				prevTitles.add(vertex);
			}
		}
		// Why didn't we use this in explore? 
		// return the set of the title of pages. 
		return prevTitles;
	}

	// title The title of a Wikipedia article
	// Starting at title, the number of articles you can 
	// travel following the first link before you visit an 
	// article you have already seen before
	@Override
	public int distanceToCycle(String title) {
		// store the count of cycles
		int count = 0;
		// store the string title to loop through
		String currTitle = title;
		// create a hashSet with all the visited titles keys
		HashSet<String> visited = new HashSet<String>();
		// while visited hashSet does not contain the title 
		while (!visited.contains(currTitle)) {
			// keep adding the title to visited 
			visited.add(currTitle);
			// the title is not found in the hashMap 
			if(links.get(currTitle) == null)
			{
				// return 0
				return 0; 
			}
			// currTitle updates to the next title of the page
			currTitle = LinkFollower.getFirstLink(currTitle);
			// increase count 
			count++;
		}
		// return count 
		return count;
	}
	public static void main (String[] args) {
		
		MyWikiGraph g = new MyWikiGraph();
		// Created a scanner for testing purposes 
		if (args.length >= 0) {
			String command = args[0];
			// implement scanner. 
			Scanner input = new Scanner(System.in); 
			if (command.equals("explore")) {
				System.out.println("Would you like to explore Wiki links? yes/no");
				while (input.next().equals("yes")) {
					System.out.println("Explore what next?");
					g.explore(input.next());
					System.out.println("Would you like to continue?");
				}
			}
			System.out.println("Done exploring. What would you like to call your graph?");
			GraphDrawer.writePng(g, input.next());
			System.out.println("Finished making graph.");
		}
// 		Additional testing purposes
//		g.explore("Pokemon");
//		g.explore("The_Office");
//		String chain = "Pokemon";
//		HashSet<String> visited = new HashSet<String>();
//		while (!chain.equals(null) && !visited.contains(chain)) {
//			System.out.print(chain + " > ");
//			visited.add(chain);
//			chain = g.nextTitle(chain);	
//		}
//		System.out.print(chain + " > ");
//		System.out.println();
//		chain = "The_Office";
//		visited = new HashSet<String>();
//		while (!chain.equals(null) && !visited.contains(chain)) {
//			System.out.print(chain + " > ");
//			visited.add(chain);
//			chain = g.nextTitle(chain);	
//		}
//		System.out.print(chain + " > ");
//		System.out.println();
//		System.out.println("Knowledge cycles in this many titles: ");
//		System.out.println(g.distanceToCycle("Pokemon"));
//		System.out.println("These lead to knowledge:");
//		for (String prevTitle: g.prevTitles("Knowledge")) {
//		    System.out.println(prevTitle);
		
	}
	
}
