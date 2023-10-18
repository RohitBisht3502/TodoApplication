package com.Application.TodoApplication.repo;

import com.Application.TodoApplication.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITodoRepo extends JpaRepository<Todo,Integer> {
}
