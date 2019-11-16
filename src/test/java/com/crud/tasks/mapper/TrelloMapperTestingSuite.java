package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
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
public class TrelloMapperTestingSuite {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    public void testMapToBoards() {
        //Given
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto();
        trelloBoardDto.setId("1");
        trelloBoardDto.setName("test");
        trelloBoardDto.setLists(new ArrayList<>());
        List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();
        trelloBoardDtoList.add(trelloBoardDto);

        //When
        List<TrelloBoard> resultList = trelloMapper.mapToBoards(trelloBoardDtoList);

        //Then
        Assert.assertEquals(trelloBoardDto.getName(), resultList.get(0).getName());
        Assert.assertEquals(trelloBoardDto.getId(), resultList.get(0).getId());
    }

    @Test
    public void testMapToList() {
        //Given
        TrelloListDto trelloListDto = new TrelloListDto();
        trelloListDto.setId("1");
        trelloListDto.setName("test");
        trelloListDto.setClosed(false);
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(trelloListDto);

        //When
        List<TrelloList> resultList = trelloMapper.mapToList(trelloListDtos);

        //Then
        resultList.forEach(trelloList -> {
            Assert.assertEquals(trelloListDto.getId(), trelloList.getId());
            Assert.assertEquals(trelloListDto.getName(), trelloList.getName());
            Assert.assertEquals(trelloListDto.isClosed(), trelloList.isClosed());
        });
    }

    @Test
    public void testMapToListDto() {
        //Given
        TrelloList trelloList = new TrelloList();
        trelloList.setId("1");
        trelloList.setName("test");
        trelloList.setClosed(false);
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(trelloList);

        //When
        List<TrelloListDto> resultList = trelloMapper.mapToListDto(trelloLists);

        //Then
        resultList.forEach(trelloListDto -> {
            Assert.assertEquals(trelloList.getId(), trelloListDto.getId());
            Assert.assertEquals(trelloList.getName(), trelloListDto.getName());
            Assert.assertEquals(trelloList.isClosed(), trelloListDto.isClosed());
        });
    }

    @Test
    public void testMapToBoardsDto() {
        //Given
        TrelloBoard trelloBoard = new TrelloBoard("1", "test", new ArrayList<>());
        List<TrelloBoard> trelloBoardList = new ArrayList<>();
        trelloBoardList.add(trelloBoard);

        //When
        List<TrelloBoardDto> resultList = trelloMapper.mapToBoardsDto(trelloBoardList);

        //Then
        Assert.assertEquals(trelloBoard.getName(), resultList.get(0).getName());
        Assert.assertEquals(trelloBoard.getId(), resultList.get(0).getId());
    }

    @Test
    public void testMapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("test", "test1", "test2", "1");

        //When
        TrelloCardDto resultedCard = trelloMapper.mapToCardDto(trelloCard);

        //Then
        Assert.assertEquals(trelloCard.getName(), resultedCard.getName());
    }

    @Test
    public void testMapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("Test", "test1", "test2", "1");

        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        //Then
        Assert.assertEquals(trelloCardDto.getDescription(), trelloCard.getDescription());
    }
}
