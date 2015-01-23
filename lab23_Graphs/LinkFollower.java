import java.io.IOException;
import java.util.*;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class LinkFollower {

    /**
     * 
     * @param pageTitle The title of a wikipedia article, as it appears in the URL of the page (this means it includes underscores. Also, capitalization matters, though Wikipedia often redirects for you)
     * @return The title of the wikipedia article found at the first link not in parentheses in the body text of pageTitle
     *         Returns null if it encounters an error, or if it doesn't find a link
     */
    public static String getFirstLink(String pageTitle){
        String baseUrl = "http://en.wikipedia.org/w/index.php?action=render&title=";
        String htmlText;
        String linkText;
        String nextPageTitle = null;
        try{
            Document doc = Jsoup.connect(baseUrl + pageTitle).timeout(100000).userAgent("jmoghadam@berkeley.edu").get();
            
            Elements tables = doc.getElementsByTag("table");
            tables.remove();
            
            Elements paragraphs = doc.getElementsByTag("p");
            titleSearch: for (Element paragraph: paragraphs){
                htmlText = paragraph.html();
                htmlText = removeNestedText(htmlText);
                paragraph.html(htmlText);
                Elements links = paragraph.getElementsByTag("a");
                    for (Element link: links){
                        linkText = link.attr("href");
                        nextPageTitle = extractPageTitle(linkText);
                        if (nextPageTitle != null){
                            break titleSearch;
                        }
                    }
            }
            return nextPageTitle;

        } catch (IOException e){
            System.out.println("Couldn't connect to page " + pageTitle + "!");
            return null;
        }
        
    }
    
    private static boolean isValidLink(String link){
        return link.startsWith(("//en.wikipedia.org/wiki/")) && !link.contains(":");
    }
    
    /**
     * 
     * @param link A link with the form //en.wikipedia.org/wiki/title
     * @return title
     */
    private static String extractPageTitle(String link){
        if (!isValidLink(link)){
            return null;
        }
        String title = "";
        int i = link.length()-1;
        char c = link.charAt(i);
        while (c != '/'){
            title = c + title;
            i--;
            c = link.charAt(i);
        }
        return title;
    }
    
    /**
     * 
     * @param in html possibly containing text with (...) inside
     * @return the same html with all (...) removed, except those inside links
     */
    private static String removeNestedText(String in){
        String out = "";
        int i = 0;
        char c;
        int nesting = 0;
        while(i < in.length()){
            if (nesting ==0 & in.substring(i).startsWith("<a href=")){ //skip removal of (...) inside links
                out += in.substring(i, i+9);
                i += 9;
                c = '0';
                while (c != '"'){
                    c = in.charAt(i);
                    out += c;
                    i++;
                }
            }
            c = in.charAt(i);
            if (c == '('){
                nesting++;
            } else if (c == ')'){
                nesting--;
            } else if (nesting == 0){
                out += c;
            }
            i++;
        }
        return out;
    }
    
    /**
     * Given the title of a starting Wikipedia article, follows the first links until it finds a loop
     * Prints out the articles it visits along the way
     * @param args args[1] is the title of the start Wikipedia page
     */
    public static void main(String[] args) {
        String title = args[0];
        System.out.println(title);
        HashSet<String> visitedPages = new HashSet<String>();
        while (!visitedPages.contains(title.toLowerCase())){
            visitedPages.add(title.toLowerCase());
            title = getFirstLink(title);
            if (title == null){
                System.out.println("Couldn't finish loop.");
                return;
            }
            System.out.println(title);
        }    
    }

}