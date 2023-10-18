package com.Application.TodoApplication.service;

import com.Application.TodoApplication.model.Todo;
import com.Application.TodoApplication.repo.ITodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TodoService {
    @Autowired
    ITodoRepo todoRepo;

    public String addTodos(List<Todo> newTodos) {
        todoRepo.saveAll(newTodos);
        return "Todos Added";
    }

    public List<Todo> getAllTodos() {
        return todoRepo.findAll();
    }

    public String updateTodoById(Integer id) {
        todoRepo.deleteById(id);
        return "todo updated";
    }

    public String deleteTodoByTodoId(Integer id) {
        try {
            Todo todo = todoRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Todo not found with ID: " + id));
            todoRepo.deleteById(id);
            return "Todo deleted successfully";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
