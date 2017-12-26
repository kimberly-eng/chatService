import java.util.Collections;
import java.util.Set;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageInfoController {

    @RequestMapping("/messageInfo")
    public MessageInfo messageInfo(@RequestParam(value="message") String message) {

        if (!message.isEmpty()) {
            Set<String> mentions = parseMethods.parseMentions(message);
            Set<String> emoticons = parseMethods.parseEmoticons(message);
            Set<Link> links = parseMethods.parseLinks(message);
            return new MessageInfo(mentions, emoticons, links);
        } else {
            return new MessageInfo(Collections.<String>emptySet(), Collections.<String>emptySet(), null);
        }
    }
}


