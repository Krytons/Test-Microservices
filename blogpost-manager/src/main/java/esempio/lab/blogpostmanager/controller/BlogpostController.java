package esempio.lab.blogpostmanager.controller;

import blogpost.Blogpost;
import esempio.lab.blogpostmanager.service.BlogpostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/blogpost")
public class BlogpostController {

    @Autowired
    BlogpostService service;

    @GetMapping(path = "/id/{id}")
    public @ResponseBody
    Blogpost getBlogpost (@PathVariable Integer id){
        return service.getBlogpost(id);
    }

    @GetMapping(path = "/title/{title}")
    public @ResponseBody
    Blogpost getBlogpost (@PathVariable String title){
        return service.getBlogpost(title);
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Blogpost> getAllBlogpost (){
        return service.getAllBlogpost();
    }

    @PostMapping(path = "/insert")
    public @ResponseBody
    Blogpost insertBlogpost (@RequestBody Blogpost newBlogpost){
        return service.insertBlogpost(newBlogpost);
    }

    @PutMapping(path = "/update")
    public @ResponseBody
    Blogpost updateBlogpost (@RequestBody Blogpost updateBlogpost){
        return service.updateBlogpost(updateBlogpost);
    }


}
