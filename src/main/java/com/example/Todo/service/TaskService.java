package com.example.Todo.service;

import com.example.Todo.dto.TaskDto;
import com.example.Todo.entity.Task;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface TaskService {

    TaskDto CreateTask(TaskDto taskDto);

    void deleteTask(Long TaskId);

    TaskDto upadteTask(TaskDto taskDto);

    List<Task> getAllTask();


}
