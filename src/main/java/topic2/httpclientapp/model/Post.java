package topic2.httpclientapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Post {
    public int id;
    public int userId;
    public String title;
    public String body;

    @Override
    public String toString() {
        return "Post{id=" + id + ", title='" + title + "'}";
    }
}
