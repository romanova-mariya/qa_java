package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CatTest {

    @Mock
    Feline feline;

    @Test
    public void catConstructorTest() {
        Cat cat = new Cat(feline);
        assertSame(feline, cat.predator);
    }

    @Test
    public void getSoundShouldReturnMeow() {
        Cat cat = new Cat(feline);
        String actual = cat.getSound();
        assertEquals("Мяу", actual);
    }

    @Test
    public void getFoodCallsEatMeat() {
        Cat cat = new Cat(feline);
        try {
            cat.getFood();
            Mockito.verify(feline).eatMeat();
        } catch(Exception exception) {
            System.out.println("Ошибка в вызове метода eatMeat");
        }

    }

}