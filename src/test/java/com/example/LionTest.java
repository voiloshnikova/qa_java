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
        Mockito.when(feline.getFood(Mockito.anyString())).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
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