package com.example.Todo.service;

import com.example.Todo.dto.TaskDto;
import com.example.Todo.entity.Task;
import com.example.Todo.repo.TaskRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class TaskServiceImp implements TaskService{

    @Autowired
    private TaskRepo taskRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public TaskDto CreateTask(TaskDto taskDto) {
        Task task = modelMapper.map(taskDto, Task.class);
        taskRepo.save(task);
        return taskDto;
    }

    @Override
    public void deleteTask(Long TaskId) {
     taskRepo.deleteById(TaskId);
    }

    @Override
    public TaskDto upadteTask(TaskDto taskDto) {
        Task task = modelMapper.map(taskDto, Task.class);
        taskRepo.save(task);
        return taskDto;
    }

    @Override
    public List<Task> getAllTask() {
     return taskRepo.findAll();
    }



}
