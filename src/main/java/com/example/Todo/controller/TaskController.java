package com.example.Todo.controller;

import com.example.Todo.dto.TaskDto;
import com.example.Todo.entity.Task;
import com.example.Todo.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RestController("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;


    @PostMapping("/create-task")
    public ResponseEntity<?> CreatTask(@RequestBody TaskDto taskDto){
        TaskDto taskDto1 = taskService.CreateTask(taskDto);
        return new ResponseEntity<>(taskDto1, HttpStatus.ACCEPTED);
    }


    @GetMapping("/Task-list")
    public ResponseEntity<?> getAllTask() {
        List<Task> taskList = taskService.getAllTask();
        return new ResponseEntity<>(taskList, HttpStatus.OK);
    }


    @PutMapping("/update-task")
    public ResponseEntity<?> updateTask(@RequestBody TaskDto taskDto ) {
        taskService.upadteTask(taskDto);
        Map<String,String> str = new HashMap<String,String>();
        str.put("message","update successfully");
        return new ResponseEntity<>(str, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable("id")Long TaskId){
        taskService.deleteTask(TaskId);
        Map<String,String> str = new HashMap<String,String>();
        str.put("message","deleted successfully");
        return new ResponseEntity<>(str, HttpStatus.OK);
    }

    @PostMapping("/photo")
    public  ResponseEntity<?> uploadImage(@RequestParam("file")MultipartFile file){



}
