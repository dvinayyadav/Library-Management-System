package com.example.Library_Management_System1.Controllers;

import com.example.Library_Management_System1.DTO.RequestDTO.RequestAuthorDto;
import com.example.Library_Management_System1.DTO.ResposeDTO.AuthorResponseDto;
import com.example.Library_Management_System1.DTO.ResposeDTO.BookResponseDto;
import com.example.Library_Management_System1.Entities.Author;
import com.example.Library_Management_System1.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public String addAuthor(@RequestBody RequestAuthorDto requestAuthorDto){
        return  authorService.addAuthor(requestAuthorDto);
    }
    @GetMapping("/allAuthor")
    public List<AuthorResponseDto> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @GetMapping("/getAuthorById")
    public AuthorResponseDto getAuthorById(@RequestParam("id") int id){

        return authorService.getAuthorById(id);
    }

    @GetMapping("/getAuthorByEmail")
    public AuthorResponseDto getAuthorById(@RequestParam("email") String email){
        return authorService.getAuthorByEmail(email);
    }

    @GetMapping("/getAllBooksByAuthor")
    public List<BookResponseDto> getAllBooksByAuthor(@RequestParam("name")String name){
       return authorService.getAllBooksByAuthor(name);
    }

    @DeleteMapping("/DelById")
    public String deleteById(@RequestParam("id") int id)throws Exception{
       return authorService.delById(id);
    }

    @DeleteMapping("/DelByName")
    public String deleteByName(@RequestParam("name") String name)throws  Exception{
        return authorService.delByName(name);
    }

    @DeleteMapping("/DeleteAllAuthors")
    public String deleteAllAuthors(){
        return authorService.deleteAllAuthors();
    }

    @PutMapping("/UpdateAuthorEmail")
    public String updateAuthorEmail(@RequestParam("id")int id,@RequestParam("email")String email)throws Exception{
        return authorService.updateAuthorEmail(id,email);
    }
}
