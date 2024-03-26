package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    private Feline feline;

    @Before
    public void init() {
        feline = new Feline();
    }

    @Test
    public void eatMeatTest() throws Exception {
        Assert.assertEquals("Животные", feline.eatMeat().get(0));
        Assert.assertEquals("Птицы", feline.eatMeat().get(1));
        Assert.assertEquals("Рыба", feline.eatMeat().get(2));
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
