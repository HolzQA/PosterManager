package ru.netology.manager;

import ru.netology.domain.Poster;
import ru.netology.repository.PosterRepository;


public class PosterManager {
    private PosterRepository repo;
    private int postersQuantity;

    //задает лимит менеджера = 10
    // и принимает ячейку типа PosterRepository
      public PosterManager(PosterRepository repo) {
        this.repo = repo;
        postersQuantity = 10;

    }
    //задает лимит менеджера из параметра конструктора
    // и принимает ячейку типа PosterRepository
    public PosterManager(int newPostersQuantity, PosterRepository repo) {
        this.repo = repo;
        if (newPostersQuantity >= 0) {
            postersQuantity = newPostersQuantity;
        }
    }

    //выводит заданное количество фильмов в обратном от добавления порядке
    public Poster[] findLast() {
          Poster[] all = repo.findAll();
          Poster[] reversed = new Poster[postersQuantity];
          for (int i = 0; i < reversed.length; i++) {
              reversed[i] = all[all.length - 1 - i];
          }
          return reversed;
    }
}
