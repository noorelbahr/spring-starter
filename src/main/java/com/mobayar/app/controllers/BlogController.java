package com.mobayar.app.controllers;

import com.mobayar.app.entities.Blog;
import com.mobayar.app.repositories.BlogRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;

import java.util.List;

@RestController
public class BlogController {
    @Autowired
    BlogRespository blogRespository;

    @GetMapping("blog")
    public List<Blog> index(){
        return blogRespository.findAll();
    }

    @GetMapping("blog/{id}")
    public ResponseEntity<Blog> show(@PathVariable int id){
        try {
            Blog blog = blogRespository.findById(id).orElse(null);
            if(blog == null)
                throw new RestClientException("Data not found");

            return new ResponseEntity(blog, HttpStatus.FOUND);
        }catch (RestClientException e)
        {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("blog")
    public ResponseEntity create(@RequestParam String title, @RequestParam String content){
        try {
            Blog blog = new Blog();
            blog.setTitle(title);
            blog.setContent(content);
            blogRespository.save(blog);

            return new ResponseEntity(blog, HttpStatus.OK);

        }catch (RestClientException e)
        {
            return new ResponseEntity(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping("blog/{id}")
    public ResponseEntity update(@PathVariable int id, @RequestParam String title, @RequestParam String content){
        try {
            Blog blog = blogRespository.findById(id).orElse(null);
            if(blog == null)
                throw new RestClientException("Data not found");

            blog.setTitle(title);
            blog.setContent(content);
            blogRespository.save(blog);

            return new ResponseEntity(blog, HttpStatus.OK);

        }catch (RestClientException e)
        {
            return new ResponseEntity(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping("blog/{id}")
    public ResponseEntity delete(@PathVariable int id){
        try {
            Blog blog = blogRespository.findById(id).orElse(null);
            if(blog == null)
                throw new RestClientException("Data not found");

            blogRespository.deleteById(id);

            return new ResponseEntity(blog, HttpStatus.OK);

        }catch (RestClientException e)
        {
            return new ResponseEntity(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }
}
