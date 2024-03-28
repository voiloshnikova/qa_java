package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    private Feline feline;
    private Lion lion;

    @Before
    public void init() throws Exception {
        MockitoAnnotations.openMocks(this);
        lion = new Lion("Самец", feline);
    }

    @Test
    public void getKittensTest() {
        Mockito.when(feline.getKittens()).thenReturn(1);
        Assert.assertEquals(1, lion.getKittens());
    }

    @Test
    public void getFoodTest() throws Exception {
        Mockito.when(feline.getFood(Mockito.anyString())).thenReturn(List.of("Мясо"));
        List<String> felineMenu = lion.getFood();
        List<String> testMenu = List.of("Мясо");
        boolean isListEquals = true;
        for (String element : felineMenu) {
            if (!testMenu.contains(element)) {
                isListEquals = false;
                break;
            }
        }
        Assert.assertTrue(isListEquals);
    }

    @Test
    public void getFoodTestWithException() throws Exception {
        Mockito.when(feline.getFood(Mockito.anyString())).thenThrow(new Exception());
        Assert.assertThrows(Exception.class, () -> lion.getFood());
    }

    @Test
    public void lionConstructorTest() throws Exception {
        Assert.assertThrows(Exception.class, () -> new Lion("Не самец", feline));
    }
}