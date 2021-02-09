package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.FilmItem;
import ru.netology.repository.PosterRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PosterManagerTest {

    @Mock
    private PosterRepository repository;

    @InjectMocks
    private PosterManager manager;
    private FilmItem first = new FilmItem(1, 1, "Бладшот", "боевик", ".jpg");
    private FilmItem second = new FilmItem(2, 2, "Вперёд", "мультфильм", ".jpg");
    private FilmItem third = new FilmItem(3, 3, "Отель Белград", "комедия", ".jpg");
    private FilmItem forth = new FilmItem(4, 4, "Джентельмены", "боевик", ".jpg");
    private FilmItem fifth = new FilmItem(5, 5, "Человек-нивидимка", "ужасы", ".jpg");
    private FilmItem sixth = new FilmItem(6, 6, "Тролли", "мультфильм", ".jpg");
    private FilmItem seventh = new FilmItem(7, 7, "Номер один", "комедия", ".jpg");
    private FilmItem eighth = new FilmItem(8, 8, "Охотник на монстров", "боевик", ".jpg");
    private FilmItem ninth = new FilmItem(9, 9, "Дьявол в деталях", "криминал", ".jpg");
    private FilmItem tenth = new FilmItem(10, 10, "Душа", "драма", ".jpg");

    @Test
    public void shouldShowAllFilms() {
        FilmItem[] returned = new FilmItem[]{first, second, third, forth, fifth, sixth, seventh, eighth, ninth, tenth};
        doReturn(returned).when(repository).findAll();
        FilmItem[] actual = manager.getAll();
        FilmItem[] expected = new FilmItem[]{tenth, ninth, eighth, seventh, sixth, fifth, forth, third, second, first};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
        System.out.println("Method getAll of Project Manager and findAll of repository");
    }

    @Test
    public void shouldAddFilm() {
        FilmItem[] returned = new FilmItem[]{first, second, third, forth, fifth, sixth, seventh, eighth, ninth, tenth};
        doNothing().when(repository).save(first);
        manager.add(first);
        doReturn(returned).when(repository).findAll();
        FilmItem[] actual = manager.getAll();
        FilmItem[] expected = new FilmItem[]{tenth, ninth, eighth, seventh, sixth, fifth, forth, third, second, first};
        assertArrayEquals(expected, actual);
        verify(repository).save(first);
        System.out.println("Method add of Project Manager and save of repository");
    }

    @Test
    public void shouldRemoveByIdFilm() {
        FilmItem[] returned = new FilmItem[]{first, second, third, forth, fifth, sixth, seventh, eighth, ninth, tenth};
        doNothing().when(repository).removeById(1);
        manager.removeById(1);
        doReturn(returned).when(repository).findAll();
        FilmItem[] actual = manager.getAll();
        FilmItem[] expected = new FilmItem[]{tenth, ninth, eighth, seventh, sixth, fifth, forth, third, second, first};
        assertArrayEquals(expected, actual);
        verify(repository).removeById(1);
        System.out.println("Method removeById of Project Manager and removeById of repository");
    }

    @Test
    public void shouldFindByIdFilm() {
        FilmItem[] returned = new FilmItem[]{first, second, third, forth, fifth, sixth, seventh, eighth, ninth, tenth};
        doReturn(second).when(repository).findById(1);
        manager.findById(1);
        doReturn(returned).when(repository).findAll();
        FilmItem[] actual = manager.getAll();
        FilmItem[] expected = new FilmItem[]{tenth, ninth, eighth, seventh, sixth, fifth, forth, third, second, first};
        assertArrayEquals(expected, actual);
        verify(repository).findById(1);
        System.out.println("Method findById of Project Manager and findById of repository");
    }

    @Test
    public void shouldRemoveAllFilm() {
        FilmItem[] returned = new FilmItem[]{first, second, third, forth, fifth, sixth, seventh, eighth, ninth, tenth};
        doReturn(null).when(repository).removeAll();
        manager.removeAll();
        doReturn(returned).when(repository).findAll();
        FilmItem[] actual = manager.getAll();
        FilmItem[] expected = new FilmItem[]{tenth, ninth, eighth, seventh, sixth, fifth, forth, third, second, first};
        assertArrayEquals(expected, actual);
        verify(repository).removeAll();
        System.out.println("Method removeAll of Project Manager and removeAll of repository");
    }

}


