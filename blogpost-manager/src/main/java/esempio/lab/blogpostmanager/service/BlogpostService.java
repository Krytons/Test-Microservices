package esempio.lab.blogpostmanager.service;

import blogpost.Blogpost;
import esempio.lab.blogpostmanager.data.BlogpostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

@Service
@Transactional
public class BlogpostService {

    @Autowired
    BlogpostRepository repository;

    public Blogpost getBlogpost(Integer id){
        return repository.findById(id).orElse(null);
    }

    public Blogpost getBlogpost(String title){
        try{
            return repository.findByTitle(title);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There are no blogposts with that title");
        }
    }

    public Iterable<Blogpost> getAllBlogpost(){
        return repository.findAll();
    }

    public Blogpost insertBlogpost(Blogpost blogpost){
        try{
            return repository.save(blogpost);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This blogpost can't be inserted");
        }
    }

    public Blogpost updateBlogpost(Blogpost blogpost){
        try{
            Blogpost modify_blogpost = repository.findById(blogpost.getId()).get();
            modify_blogpost.setPost(blogpost.getPost());
            modify_blogpost.setTitle(blogpost.getTitle());
            return repository.save(modify_blogpost);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This blogpost can't be updated");
        }
    }


}
