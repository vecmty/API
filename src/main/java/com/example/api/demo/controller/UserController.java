package com.example.api.demo.controller;

import com.example.api.demo.exception.MyNotFoundException;
import com.example.api.demo.model.User;
import com.example.api.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    /*
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        User dbUser = userService.create(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dbUser.getId())
                .toUri();
        return ResponseEntity.created(location).body(dbUser);
    }
 */

    @PostMapping
    public void create(@RequestBody User user) {
        userService.create(user);
    }


    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    /*
    @GetMapping("/{id}")
    ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.getById(id));
        } catch (MyNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

     */

    @GetMapping("/{id}")
    public User getById (@PathVariable(value = "id") Long id) throws MyNotFoundException {
        return userService.getById(id);
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }



/*
    @PutMapping("/{id}")
    User update(@RequestBody User user, @PathVariable Long id) {
        return userService.update(user, id);
    }


 */

}
