package ru.tandemservice.test.task2;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

/**
 * <h1>Задание №2</h1>
 * Реализуйте интерфейс {@link IElementNumberAssigner}.
 *
 * <p>Помимо качества кода, мы будем обращать внимание на оптимальность предложенного алгоритма по времени работы
 * с учетом скорости выполнения операции присвоения номера:
 * большим плюсом (хотя это и не обязательно) будет оценка числа операций, доказательство оптимальности
 * или указание области, в которой алгоритм будет оптимальным.</p>
 */
public class Task2Impl implements IElementNumberAssigner {
    // ваша реализация должна работать, как singleton. даже при использовании из нескольких потоков.
    // Для реализации singleton использовался пятый вариант из источника: https://habr.com/ru/articles/27108/
    private static volatile Task2Impl instance;

    private Task2Impl() {
    }

    public static Task2Impl getInstance() {
        if (instance == null) {
            synchronized (Task2Impl.class) {
                if (instance == null) {
                    instance = new Task2Impl();
                }
            }
        }
        return instance;
    }
    // Нумерация элементов в списке начинается с одного, т.е. n >= 1
    // По итогу получается линейная сложность алгоритма Q(elements.size())
    @Override
    public void assignNumbers(final List<IElement> elements) {
        // Ключи, использованные номера; значения - индексы в исходной коллекции elements
        HashMap<Integer, Integer> usedNumbersAndIndexes = new HashMap<>();
        for (int i = 0; i < elements.size(); i++) {
            usedNumbersAndIndexes.put(elements.get(i).getNumber(), i);
        }
        // Используемый для освобождения номер, ранее не использовался
        int nextFreeNumber = nextFreeNumber(usedNumbersAndIndexes.keySet(), elements.size());
        for (int i = 0; i < elements.size(); i++) {
            IElement iElement = elements.get(i);
            if (iElement.getNumber() != i + 1) {
                // Если номер уже использовался раньше и не меньше того, который мы будем записывать (i + 1)
                if (usedNumbersAndIndexes.containsKey(i + 1)
                        && elements.get(usedNumbersAndIndexes.get(i + 1)).getNumber() >= i + 1) {
                    elements.get(usedNumbersAndIndexes.get(i + 1)).setupNumber(nextFreeNumber);
                }
                iElement.setupNumber(i + 1);
                nextFreeNumber++;
            }
        }
    }

    private int nextFreeNumber(Set<Integer> usedNumbers, int collectionSize) {
        int max = usedNumbers.stream().mapToInt(o -> o).max().orElseThrow(RuntimeException::new);
        if (max > collectionSize) {
            return max + 1;
        }
        return collectionSize + 1;
    }
}