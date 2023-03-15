package ru.netology.repository;

import ru.netology.domain.Poster;

public class PosterRepository {
    private Poster[] films = new Poster[0];

    //выводит все фильмы в порядке добавления
    public Poster[] findAll() {
        return films;
    }

    // //добавляет новый фильм в массив с фильмами
    public void save(Poster film) {
        Poster[] tmp = new Poster[films.length + 1];
        for (int i = 0; i < films.length; i++) {
            tmp[i] = films[i];
        }
        tmp[tmp.length - 1] = film;
        films = tmp;
    }

    //выводит фильм по идентификатору
    public String findById(int id) {
        int i = 0;
        boolean have = false;
        while (!have) {
            if (films[i].getId() == id) {
                have = true;
            }
            i++;
        }
        if (have) {
            films[i-1].getId();
            return films[i-1].toString();
        } else {
            return null;
        }
    }

    //удаляет фильм по идентификатору
    public void removeById(int id) {
        Poster[] tmp = new Poster[films.length - 1];
        int copyToIndex = 0;
        for (Poster film : films) {
            if (film.getId() != id) {
                tmp[copyToIndex] = film;
                copyToIndex++;
            }
        }
        films = tmp;
    }

    //полностью вычищает репозиторий
    public void removedAll() {
        for (int i = 0; i < films.length; i++) {
            films[i] = null;
        }
    }
}
