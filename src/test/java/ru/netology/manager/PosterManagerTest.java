package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.FilmItem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PosterManagerTest {
    PosterManager manager = new PosterManager();
    FilmItem first = new FilmItem(1, 1, "Бладшот", "боевик", ".jpg");
    FilmItem second = new FilmItem(2, 2, "Вперёд", "мультфильм", ".jpg");
    FilmItem third = new FilmItem(3, 3, "Отель Белград", "комедия", ".jpg");
    FilmItem forth = new FilmItem(4, 4, "Джентельмены", "боевик", ".jpg");
    FilmItem fifth = new FilmItem(5, 5, "Человек-нивидимка", "ужасы", ".jpg");
    FilmItem sixth = new FilmItem(6, 6, "Тролли", "мультфильм", ".jpg");
    FilmItem seventh = new FilmItem(7, 7, "Номер один", "комедия", ".jpg");
    FilmItem eighth = new FilmItem(8, 8, "Охотник на монстров", "боевик", ".jpg");
    FilmItem ninth = new FilmItem(9, 9, "Дьявол в деталях", "криминал", ".jpg");
    FilmItem tenth = new FilmItem(10, 10, "Душа", "драма", ".jpg");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
    }

    @Test
    public void shouldShowAllFilms() {
        FilmItem[] actual = manager.getAll();
        FilmItem[] expected = new FilmItem[]{tenth, ninth, eighth, seventh, sixth, fifth, forth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowFiveLastFilms(){
        manager.setAmountItem(5);
        FilmItem[] actual = manager.getAll();
        FilmItem[] expected = new FilmItem[]{tenth, ninth, eighth, seventh, sixth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowOneLastFilms(){
        manager.setAmountItem(1);
        FilmItem[] actual = manager.getAll();
        FilmItem[] expected = new FilmItem[]{tenth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowEmptyFilms(){
        manager.setAmountItem(0);
        FilmItem[] actual = manager.getAll();
        FilmItem[] expected = new FilmItem[]{};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowUpperFilms(){
        manager.setAmountItem(11);
        FilmItem[] actual = manager.getAll();
        FilmItem[] expected = new FilmItem[]{tenth, ninth, eighth, seventh, sixth, fifth, forth, third, second, first};
        assertArrayEquals(expected, actual);
    }

}


