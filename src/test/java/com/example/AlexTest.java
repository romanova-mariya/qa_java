package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AlexTest {
    private Alex alex;

    @Mock
    Feline feline;

    @BeforeEach
    public void createAlex() throws Exception {
        alex = new Alex(feline);
    }

    @Test
    public void alexConstructorTest() {
        assertAll("Проверка заполнения полей класса Alex",
                () -> assertSame(feline, alex.feline, "Поле feline содержит некорректное  значение"),
                () -> assertTrue(alex.hasMane, "Поле hasMane должно быть true")
        );
    }

    @Test
    public void getKittensAlexShouldReturnZero() {
        assertEquals(0, alex.getKittens());
    }

    @Test
    public void getFriendsShouldReturnFriendsList() {
        List<String> expected = List.of("Марти", "Глория", "Мелман");
        assertEquals(expected, alex.getFriends());
    }

    @Test
    public void getPlaceOfLivingShouldReturnNewYorkZoo() {
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

}