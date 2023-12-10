package br.com.todolist.todolist.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.todolist.todolist.model.ResponseModel;
import br.com.todolist.todolist.model.TaskModel;
import br.com.todolist.todolist.service.TaskService;

@RestController
public class TaskControl {

    @Autowired
    private TaskService ts;

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ResponseModel> delete(@PathVariable Integer id){
        return ts.delete(id);
    }

    @PutMapping("/change/{id}")
    public ResponseEntity<?> change(@RequestBody TaskModel tm, @PathVariable Integer id){
        return ts.registerChange(tm, "change");
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> register(@RequestBody TaskModel tm) {
      return  ts.registerChange(tm, "register");
    }
    
    
    @GetMapping("/listar")
    public Iterable<TaskModel> findAll() {
        return ts.findAll();
    }

    @GetMapping("/")
    public String testarRota(){
        return "Olá mundo";
    }
}
