package ru.netology.manager;

import ru.netology.domain.Poster;


public class PosterManager {
    private Poster[] films = new Poster[0];
    private int postersQuantity;

    //задает лимит менеджера = 10
    public PosterManager() {
        postersQuantity = 10;
    }

    //задает лимит менеджера из параметра конструктора
    public PosterManager(int newPostersQuantity) {
        if (newPostersQuantity >= 0) {
            postersQuantity = newPostersQuantity;
        }
    }

    //добавляет новый фильм в массив с фильмами
    public void add(Poster film) {
        Poster[] tmp = new Poster[films.length + 1];
        for (int i = 0; i < films.length; i++) {
            tmp[i] = films[i];
        }
        tmp[tmp.length - 1] = film;
        films = tmp;
    }

    //выводит все фильмы в порядке добавления
    public Poster[] findAll() {
        return films;
    }

    //выводит заданное количество фильмов в обратном от добавления порядке
    public Poster[] findLast() {
        Poster[] reversed = new Poster[postersQuantity];
        for (int i = 0; i < reversed.length; i++) {
            reversed[i] = films[films.length - 1 - i];
        }
        return reversed;
    }
}
