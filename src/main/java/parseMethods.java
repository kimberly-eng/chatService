import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class parseMethods {

    public static Set<String> parseMentions(String message) {
        Set<String> mentions = new HashSet<String>();

        int startPosition = message.indexOf("@");
        while (startPosition != -1  && (startPosition + 1) < message.length()) {
            int endPosition = message.indexOf(" ", startPosition + 1);
            if (endPosition == -1) {
                endPosition = message.length() - 1;
            }
            String name = message.substring(startPosition + 1, endPosition);
            mentions.add(name);

            startPosition = message.indexOf("@", endPosition + 1);
        }
        return mentions;
    }

    public static Set<String> parseEmoticons(String message) {
        Set<String> emoticons = new HashSet<String>();

        int startPosition = message.indexOf("(");
        while (startPosition != -1  && (startPosition + 1) < message.length()) {
            int endPosition = message.indexOf(")", startPosition + 1);
            if (endPosition == -1) {
                break;
            }
            String emoticon = message.substring(startPosition + 1, endPosition);
            emoticons.add(emoticon);

            startPosition = message.indexOf("@", endPosition + 1);
        }

        return emoticons;
    }

    public static Set<Link> parseLinks(String message) {
        Set<Link> links = new HashSet<>();

        int startPosition = message.indexOf("http");
        while (startPosition != -1  && (startPosition + 1) < message.length()) {
            int endPosition = message.indexOf(" ", startPosition + 1);
            if (endPosition == -1) {
                endPosition = message.length() - 1;
            }
            String url = message.substring(startPosition, endPosition - 1);

            try {
                Document doc = Jsoup.connect(url).get();
                if (doc != null) {
                    String title = doc.title();
                    Link link = new Link(url, title);
                    links.add(link);
                }
            } catch (IOException e) {
                // Just add url without description
                Link link = new Link(url, "");
                links.add(link);
            }

            startPosition = message.indexOf("@", endPosition + 1);
        }

        return links;
    }
}
