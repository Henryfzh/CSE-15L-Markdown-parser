//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);

            // break if there is a missing sign
            if (openBracket < 0 || closeBracket < 0 || openParen < 0 || 
                closeParen < 0) {
                break;
            }
		
	        // To handle if the link is empty
            if (markdown.substring(openParen + 1, closeParen).isEmpty()){
                System.out.println("The link is empty");
                break;
            } else{
                toReturn.add(markdown.substring(openParen + 1, closeParen));
            }
            currentIndex = closeParen + 1;
            }
        

        return toReturn;
        }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}
