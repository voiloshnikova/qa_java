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
public class CatTest {
    @Mock
    private Feline feline;
    private Cat cat;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
        cat = new Cat(feline);
    }

    @Test
    public void getSoundTest() {
        Assert.assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFoodTest() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Мясо"));
        List<String> felineMenu = cat.getFood();
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
        Mockito.when(feline.eatMeat()).thenThrow(new Exception());
        Assert.assertThrows(Exception.class, () -> cat.getFood());
    }
}
