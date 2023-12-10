package br.com.todolist.todolist.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.todolist.todolist.model.TaskModel;

@Repository
public interface TaskRepository extends CrudRepository<TaskModel, Integer>{
    
}
