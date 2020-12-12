package blogpost;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Blogpost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "A blog must have a title")
    private String title;

    @NotNull(message = "A blog must have a post")
    private String post;

    public Integer getId() {
        return id;
    }

    public Blogpost setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Blogpost setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getPost() {
        return post;
    }

    public Blogpost setPost(String post) {
        this.post = post;
        return this;
    }
}
