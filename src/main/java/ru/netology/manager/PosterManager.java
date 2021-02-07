package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.FilmItem;

@NoArgsConstructor
@Data
public class PosterManager {
    private FilmItem[] items = new FilmItem[0];
    private int amountItem = 10;

    public void add(FilmItem item) {
        // создаём новый массив размером на единицу больше
        int length = items.length + 1;
        FilmItem[] tmp = new FilmItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public FilmItem[] getAll() {
        if (amountItem > items.length) {
            amountItem = items.length;
        }
        FilmItem[] result = new FilmItem[amountItem];
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном

        for (int i = 0; i < amountItem; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}
