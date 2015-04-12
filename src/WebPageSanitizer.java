import java.net.URL;

/**
 * Created by c4q-nali on 4/6/15.
 * Write a class called WebPageSanitizer which implements a static method called String sanitize(String html)
 * which removes all script tags and the information that they encapsulate and returns a sanitized version
 * of the HTML string.
 */

public class WebPageSanitizer {


    public static String sanitize(String html) {
        // Logic to sanitze the Html goes below

        int start = html.indexOf("<script>");
        int end = html.indexOf("</script>", start)+8;

//        System.out.println("Start: " + start);
//        System.out.println("End: " + end);
//        System.out.println("Total: " + html.length());

        int numberOfScript = 0;

        while (html.indexOf("<script")!= -1) {
            String toDelete = html.substring(start, end) ;
            //System.out.println(toDelete);

            html = html.replace(toDelete, "");


        }
        return html;
    }


    public static void main(String[] args) {

        URL url = HTTP.stringToURL("http://www.yahoo.com");
        String doc = HTTP.get(url);
        //System.out.println();
        System.out.println(sanitize(doc));
    }
}

