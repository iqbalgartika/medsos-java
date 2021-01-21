package medsos.post;

import org.springframework.data.annotation.Id;

public class Post {
    @Id
    private String id;
    private String title;
    private String content;

    protected Post() { }

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}