package br.com.todolist.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.todolist.todolist.model.ResponseModel;
import br.com.todolist.todolist.model.TaskModel;
import br.com.todolist.todolist.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository tr;

    @Autowired
    private ResponseModel rm;

    // Método para retornar todas tarefas
    public Iterable<TaskModel> findAll() {
        return tr.findAll();
    }

    public ResponseEntity<?> registerChange(TaskModel tm, String action) {
        if(tm.getDescription().equals("")){
            rm.setMessage("A descrição é obrigatória.");
            return new ResponseEntity<ResponseModel>(rm, HttpStatus.BAD_REQUEST);
        } else {
            if(action.equals("register")){
                return new ResponseEntity<TaskModel>(tr.save(tm), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<TaskModel>(tr.save(tm), HttpStatus.OK);
            }
        }
    }

    public ResponseEntity<ResponseModel> delete(Integer id){
        tr.deleteById(id);
        rm.setMessage("Tarefa deletada com sucesso");
        return new ResponseEntity<ResponseModel>(rm, HttpStatus.OK);
    }
}
