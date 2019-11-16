package com.crud.tasks.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.trello.validator.TrelloValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidatorTestSuite {
    @Autowired
    private TrelloValidator trelloValidator;

    @Test
    public void testTrelloBoardsWithTestInName() {
        //Given
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("1", "test", new ArrayList<>()));

        //When
        List<TrelloBoard> resultedList = trelloValidator.validateTrelloBoards(trelloBoards);

        //Then
        Assert.assertEquals(0, resultedList.size());
    }

    @Test
    public void testTrelloBoardsWithNoTestInName() {
        //Given
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("1", "example", new ArrayList<>()));

        //When
        List<TrelloBoard> resultedList = trelloValidator.validateTrelloBoards(trelloBoards);

        //Then
        Assert.assertEquals(1, resultedList.size());
    }
}
