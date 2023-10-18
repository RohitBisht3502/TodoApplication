package com.Application.TodoApplication.controller;

import com.Application.TodoApplication.model.Todo;
import com.Application.TodoApplication.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    TodoService todoService;

    @PostMapping("todos")
    public String addTodos(@RequestBody List<Todo> newTodos){
       return todoService.addTodos(newTodos);
    }

    @GetMapping("todos")
    public List<Todo> getAllTodos(){
        return todoService.getAllTodos();
    }

    @PutMapping("todos/id/{id}")
    public String updateTodoById(@PathVariable Integer id){
        return todoService.updateTodoById(id);
    }

    @DeleteMapping("todos/id/{id}")
    public String deleteTodoByTodoId(@PathVariable Integer id){
        return todoService.deleteTodoByTodoId(id);
    }

}
