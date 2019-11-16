package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDbService {
    @Autowired
    private DbService dbService;

    @Test
    public void testSaveTask() {
        //Given
        Task task = new Task();
        task.setTitle("test");
        task.setContent("testing");

        //When
        dbService.saveTask(task);

        //Then
        Optional<Task> getTask = dbService.getTask(task.getId());
        Assert.assertTrue(getTask.isPresent());

        //Clean Up
        dbService.deleteTask(task.getId());
    }

    @Test
    public void testGetAllTasks() {
        //Given
        Task task = new Task();
        task.setTitle("test");
        task.setContent("testing");

        //When
        dbService.saveTask(task);

        //Then
        List<Task> getTasks = dbService.getAllTasks();
        Assert.assertEquals(1, getTasks.size());

        //Clean Up
        dbService.deleteTask(task.getId());
    }
}
