package ru.netology.manager;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.FilmItem;
import ru.netology.repository.PosterRepository;

@NoArgsConstructor
@Data
public class PosterManager {
    private PosterRepository repository;

    public PosterManager(PosterRepository repository) {
        this.repository = repository;
    }

    public void add(FilmItem item) {
        repository.save(item);
    }

    public FilmItem[] getAll() {
        FilmItem[] items = repository.findAll();
        FilmItem[] result = new FilmItem[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public void findById(int id) {
        repository.findById(id);
    }

    public void removeAll() {
        repository.removeAll();
    }
}
