# chatService
Provides /messageInfo REST GET api
Takes an input json string as follows:
Input: "@bob @john (success) such a cool feature; https://twitter.com/jdorfman/status/430511497475670016"
Returns JSON output as follows:
1. mentions - A way to mention a user. Always starts with an '@' and ends when hitting a non-word character. (https://confluence.atlassian.com/hipchat/get-teammates-attention-744328217.html)
2. Emoticons - For this exercise, you only need to consider 'custom' emoticons which are alphanumeric strings, no longer than 15 characters, contained in parenthesis. You can assume that anything matching this format is an emoticon. (https://www.hipchat.com/emoticons)
3. Links - Any URLs contained in the message, along with the page's title.

For example:
{
  "mentions": [
    "bob",
    "john"
  ],
  "emoticons": [
    "success"
  ],
  "links": [
    {
      "url": "https://twitter.com/jdorfman/status/430511497475670016",
      "title": "Justin Dorfman on Twitter: &quot;nice @littlebigdetail from @HipChat (shows hex colors when pasted in chat). http://t.co/7cI6Gjy5pq&quot;"
    }
  ]
}

NEEDS THE FOLLOWING IMPROVEMENTS:
1. Unit tests
2. Research into JSoup dependency - Haven't used previously
3. Full loop test client
4. Testing! :)
5. Better exception handling in parse methods