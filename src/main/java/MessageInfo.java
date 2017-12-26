import java.util.Set;

public class MessageInfo {
    private final Set<String> mentions;
    private final Set<String> emoticons;
    private final Set<Link> links;

    public MessageInfo(Set<String> mentions, Set<String> emoticons, Set<Link> links) {
        this.mentions = mentions;
        this.emoticons = emoticons;
        this.links = links;
    }

    public Set<String> getMentions() {
        return mentions;
    }

    public Set<String> getEmoticons() {
        return emoticons;
    }

    public Set<Link> getLinks() {
        return links;
    }
}
