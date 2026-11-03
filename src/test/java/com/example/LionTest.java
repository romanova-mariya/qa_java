package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LionTest {

    @Mock
    Feline feline;

    @Test
    public void lionConstructorTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertSame(feline, lion.feline);
    }

    @Test
    public void lionConstructorShouldThrowException() throws Exception {
        Throwable exception = assertThrows(
                Exception.class,
                () -> new Lion("Не определено", feline)
        );
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    public void getKittensCallsFelineGetKittens() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void doesHaveManeReturnHasMane() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertEquals(lion.hasMane, lion.doesHaveMane());
    }

    @Test
    public void getFoodCallsFelineGetFood() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getFood();
        Mockito.verify(feline).getFood("Хищник");
    }
}