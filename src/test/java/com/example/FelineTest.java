package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FelineTest {
    private Feline feline;

    @BeforeEach
    void createObject() {
        feline = new Feline();
    }

    @Test
    public void eatMeatCallsGetFoodWithPredatorKind() throws Exception {
        List<String> expected = feline.eatMeat();
        assertEquals(expected, feline.getFood("Хищник"));
    }

    @Test
    public void getFamilyShouldReturnCatFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensWithoutCountShouldReturnOne() {
        Feline felineSpy = Mockito.spy(feline);
        felineSpy.getKittens();
        Mockito.verify(felineSpy).getKittens(1);
    }

    @Test
    public void getKittensWithCountShouldReturnCount() {
        assertEquals(5, feline.getKittens(5));
    }
}