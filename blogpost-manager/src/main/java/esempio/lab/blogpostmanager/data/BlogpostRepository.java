package esempio.lab.blogpostmanager.data;

import blogpost.Blogpost;
import org.springframework.data.repository.CrudRepository;

public interface BlogpostRepository extends CrudRepository<Blogpost, Integer> {
    public Blogpost findByTitle(String title);
}
