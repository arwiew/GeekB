package Lesson_3;

/*Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
        Посчитать, сколько раз встречается каждое слово.
*/
import java.util.*;

public class Main {

    public static void main(String[] args) {


        ArrayList<String> word = new ArrayList<>(10);
        word.add("Утка");
        word.add("Клещ");
        word.add("Утка");
        word.add("Телефон");
        word.add("Телевизор");
        word.add("Собака");
        word.add("Кошка");
        word.add("Клещ");
        word.add("Телек");
        word.add("Фотик");
        word.add("Свелка");
        word.add("Мокровь");
        word.add("Утес");

        HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
        for (int i = 0; i < word.size(); i++) {
            int freq = Collections.frequency(word, word.get(i));
            wordCount.put(word.get(i), freq);
        }
            System.out.println("Задание № 1 " +wordCount);


    //Задание № 2

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Шувалов", "+7 53 55");
        phoneBook.add("Герасименко", "+7 57 55");
        phoneBook.add("Плотко", "+7 59 55");
        phoneBook.add("Осипов", "+7 55 95");
        phoneBook.add("Шувало", "+7 55 45");
        phoneBook.add("Чемезов", "+7 55 65");

        System.out.println("Задание № 2: " + phoneBook.get("Шувалов"));

    }

}



