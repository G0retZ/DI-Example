package com.example.sergejmitrofanov.librarycatalogue.repository;

import androidx.annotation.NonNull;
import com.example.sergejmitrofanov.librarycatalogue.entity.Book;
import com.example.sergejmitrofanov.librarycatalogue.interactor.BooksSource;
import java.util.Arrays;
import java.util.List;

public class FavoritesBooksSource implements BooksSource {

  @NonNull
  @Override
  public List<Book> getBooks() {
    return Arrays.asList(
        new Book("Хорхе Луис Борхес", "Вымыслы", 9),
        new Book("Вирджиния Вулф", "Миссис Дэллоуэй", 8),
        new Book("Чинуа Ачебе", "И пришло разрушение", 10),
        new Book("Вьяса", "Махабхарата", 8),
        new Book("Кнут Гамсун", "Голод", 9),
        new Book("Оноре де Бальзак", "Отец Горио", 10),
        new Book("Габриэль Гарсиа Маркес", "Сто лет одиночества", 7),
        new Book("Эмили Бронте", "Грозовой перевал", 9),
        new Book("Сэмюэл Беккет", "Трилогия (Моллой, Мэлон умирает, Безымянный)", 9),
        new Book("Гомер", "Одиссея", 10),
        new Book("Данте Алигьери", "Божественная комедия", 10),
        new Book("Вальмики", "Рамаяна", 8),
        new Book("Ханс Кристиан Андерсен", "Сказки", 10),
        new Book("Вергилий", "Энеида", 8),
        new Book("Джованни Боккаччо", "Декамерон", 9),
        new Book("Джеймс Джойс", "Улисс", 7),
        new Book("Гюнтер Грасс", "Жестяной барабан", 9),
        new Book("Вирджиния Вулф", "На маяк", 8),
        new Book("Николай Васильевич Гоголь", "Мёртвые души", 7),
        new Book("Габриэль Гарсиа Маркес", "Любовь во время чумы", 7),
        new Book("Альфред Дёблин", "Берлин Александрплац", 8),
        new Book("Иоганн Вольфганг фон Гёте", "Фауст", 10),
        new Book("Федерико Гарсиа Лорка", "Цыганское романсеро", 7),
        new Book("Жуан Гимарайнс Роза", "Тропы по большому сертану", 9),
        new Book("Гомер", "Илиада", 7)
    );
  }
}
