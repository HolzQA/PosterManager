package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Poster;

public class PosterManagerTest {

    Poster film1 = new Poster(1, "Бладшот", "боевик");
    Poster film2 = new Poster(2,"Вперед", "мультфильм");
    Poster film3 = new Poster(3,"Отель Белград", "комедия");
    Poster film4 = new Poster(4,"Джентельмены", "боевик");
    Poster film5 = new Poster(5,"Человек-невидимка", "ужасы");
    Poster film6 = new Poster(6,"Тролли. Мировой тур", "мультфильм");
    Poster film7 = new Poster(7,"Номер один", "комедия");
    Poster film8 = new Poster(8,"Домовой", "семейная комедия-фэнтези");
    Poster film9 = new Poster(9,"Балканский рубеж", "драма");
    Poster film10 = new Poster(10,"Форсаж 9", "криминал, приключения, экшн");
    Poster film11 = new Poster(11,"Девятаев", "драма, приключения");


    //Проверка пустого списка
    @Test
    public void shouldAddNoFilm() {
        PosterManager manager = new PosterManager(-2);

        Poster[] expected = {};
        Poster[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    //Проверка списка с одним добавленным фильмом
    @Test
    public void shouldAddOneFilm() {
        PosterManager manager = new PosterManager();

        manager.add(film1);

        Poster[] expected = { film1 };
        Poster[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    //Проверка списка с несколькими добавленными фильмами
    @Test
    public void shouldAddManyFilmsAndShowingInOrderAddition() {
        PosterManager manager = new PosterManager();

        manager.add(film1);
        manager.add(film2);
        manager.add(film3);
        manager.add(film4);
        manager.add(film5);
        manager.add(film6);

        Poster[] expected = { film1, film2, film3, film4, film5, film6 };
        Poster[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    //Вывод списка фильмов с 4 фильмами  в порядке добавления
    @Test
    public void ShowingReverseAFewAddition() {
        PosterManager manager = new PosterManager(4);

        manager.add(film1);
        manager.add(film2);
        manager.add(film3);
        manager.add(film4);
        manager.add(film5);
        manager.add(film6);
        manager.add(film7);
        manager.add(film8);
        manager.add(film9);
        manager.add(film10);
        manager.add(film11);

        Poster[] expected = { film11, film10, film9, film8 };
        Poster[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    //Вывод списка фильмов с 10 фильмов в порядке добавления
    @Test
    public void ShowingReverseAllAddition() {
        PosterManager manager = new PosterManager();

        manager.add(film1);
        manager.add(film2);
        manager.add(film3);
        manager.add(film4);
        manager.add(film5);
        manager.add(film6);
        manager.add(film7);
        manager.add(film8);
        manager.add(film9);
        manager.add(film10);
        manager.add(film11);

        Poster[] expected = { film11, film10, film9, film8, film7, film6, film5, film4, film3, film2 };
        Poster[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
