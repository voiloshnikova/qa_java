package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    private Feline feline;

    @Before
    public void init() {
        feline = new Feline();
    }

    @Test
    public void eatMeatTest() throws Exception {
        List<String> felineMenu = feline.eatMeat();
        List<String> testMenu = List.of("Животные", "Птицы", "Рыба");
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
    public void getFamilyTest() {
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensWithoutParametersTest() {
        Assert.assertEquals(1, feline.getKittens());
    }

    @Test
    public void getKittensWithParametersTest() {
        Assert.assertEquals(10, feline.getKittens(10));
    }
}
