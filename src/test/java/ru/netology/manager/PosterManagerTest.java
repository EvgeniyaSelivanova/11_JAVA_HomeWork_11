package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.FilmItem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PosterManagerTest {
    PosterManager manager = new PosterManager();
    PosterManager managerAmountOfItemLess = new PosterManager();
    PosterManager managerAmountNormItem = new PosterManager(5);
    PosterManager managerAmountOneItem = new PosterManager(1);
    PosterManager managerAmountEmptyItem = new PosterManager(0);

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

    @BeforeEach
    public void setUpAmountItemLess() {
        managerAmountOfItemLess.add(first);
        managerAmountOfItemLess.add(second);
        managerAmountOfItemLess.add(third);
        managerAmountOfItemLess.add(forth);
        managerAmountOfItemLess.add(fifth);
    }

    @BeforeEach
    public void setUpWithAmount() {
        managerAmountNormItem.add(first);
        managerAmountNormItem.add(second);
        managerAmountNormItem.add(third);
        managerAmountNormItem.add(forth);
        managerAmountNormItem.add(fifth);
        managerAmountNormItem.add(sixth);
        managerAmountNormItem.add(seventh);
        managerAmountNormItem.add(eighth);
        managerAmountNormItem.add(ninth);
        managerAmountNormItem.add(tenth);
    }

    @BeforeEach
    public void setUpWithAmountOne() {
        managerAmountOneItem.add(first);
        managerAmountOneItem.add(second);
        managerAmountOneItem.add(third);
        managerAmountOneItem.add(forth);
        managerAmountOneItem.add(fifth);
        managerAmountOneItem.add(sixth);
        managerAmountOneItem.add(seventh);
        managerAmountOneItem.add(eighth);
        managerAmountOneItem.add(ninth);
        managerAmountOneItem.add(tenth);
    }

    @BeforeEach
    public void setUpWithAmountEmpty() {
        managerAmountEmptyItem.add(first);
        managerAmountEmptyItem.add(second);
        managerAmountEmptyItem.add(third);
        managerAmountEmptyItem.add(forth);
        managerAmountEmptyItem.add(fifth);
        managerAmountEmptyItem.add(sixth);
        managerAmountEmptyItem.add(seventh);
        managerAmountEmptyItem.add(eighth);
        managerAmountEmptyItem.add(ninth);
        managerAmountEmptyItem.add(tenth);
    }

    @Test
    public void shouldShowAllFilms() {
        FilmItem[] actual = manager.getAll();
        FilmItem[] expected = new FilmItem[]{tenth, ninth, eighth, seventh, sixth, fifth, forth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowAmountItemLess() {
        FilmItem[] actual = managerAmountOfItemLess.getAll();
        FilmItem[] expected = new FilmItem[]{fifth, forth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowFiveLastFilms() {
        FilmItem[] actual = managerAmountNormItem.getAll();
        FilmItem[] expected = new FilmItem[]{tenth, ninth, eighth, seventh, sixth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowOneLastFilms() {
        FilmItem[] actual = managerAmountOneItem.getAll();
        FilmItem[] expected = new FilmItem[]{tenth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowEmptyFilms() {
        FilmItem[] actual = managerAmountEmptyItem.getAll();
        FilmItem[] expected = new FilmItem[]{};
        assertArrayEquals(expected, actual);
    }

}


