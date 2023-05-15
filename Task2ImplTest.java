package ru.tandemservice.test.task2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task2ImplTest {
    private final IElementNumberAssigner iElementNumberAssigner = Task2Impl.getInstance();
    private ElementExampleImpl.Context context;

    @BeforeEach
    void init() {
        context = new ElementExampleImpl.Context();
    }

    @Test
    void assignNumbers_FullSortingUsingPermutations() {
        IElement element1 = new ElementExampleImpl(context, 1);
        IElement element2 = new ElementExampleImpl(context, 2);
        IElement element3 = new ElementExampleImpl(context, 3);
        IElement element4 = new ElementExampleImpl(context, 4);
        IElement element5 = new ElementExampleImpl(context, 5);
        List<IElement> elements = Stream.of(
                element5, element4, element3, element2, element1
        ).collect(toList());
        iElementNumberAssigner.assignNumbers(elements);
        assertEquals(1, elements.get(0).getNumber());
        assertEquals(2, elements.get(1).getNumber());
        assertEquals(3, elements.get(2).getNumber());
        assertEquals(4, elements.get(3).getNumber());
        assertEquals(5, elements.get(4).getNumber());
        System.out.println(context.getOperationCount());
    }

    @Test
    void assignNumbers_NonFullSortingUsingPermutations() {
        IElement element1 = new ElementExampleImpl(context, 1);
        IElement element2 = new ElementExampleImpl(context, 2);
        IElement element3 = new ElementExampleImpl(context, 3);
        IElement element4 = new ElementExampleImpl(context, 4);
        IElement element5 = new ElementExampleImpl(context, 5);
        List<IElement> elements = Stream.of(
                element5, element1, element2, element3, element4
        ).collect(toList());
        iElementNumberAssigner.assignNumbers(elements);
        assertEquals(1, elements.get(0).getNumber());
        assertEquals(2, elements.get(1).getNumber());
        assertEquals(3, elements.get(2).getNumber());
        assertEquals(4, elements.get(3).getNumber());
        assertEquals(5, elements.get(4).getNumber());
        System.out.println(context.getOperationCount());
    }

    @Test
    void assignNumbers_NonFullSortingUsingPermutations_() {
        IElement element1 = new ElementExampleImpl(context, 1);
        IElement element2 = new ElementExampleImpl(context, 2);
        IElement element3 = new ElementExampleImpl(context, 3);
        IElement element4 = new ElementExampleImpl(context, 4);
        IElement element5 = new ElementExampleImpl(context, 5);
        List<IElement> elements = Stream.of(
                element5, element1, element3, element2, element4
        ).collect(toList());
        iElementNumberAssigner.assignNumbers(elements);
        assertEquals(1, elements.get(0).getNumber());
        assertEquals(2, elements.get(1).getNumber());
        assertEquals(3, elements.get(2).getNumber());
        assertEquals(4, elements.get(3).getNumber());
        assertEquals(5, elements.get(4).getNumber());
        System.out.println(context.getOperationCount());
    }

    @Test
    void assignNumbers_NonFullSortingUsingPermutations__() {
        IElement element1 = new ElementExampleImpl(context, -10);
        IElement element2 = new ElementExampleImpl(context, 15);
        IElement element3 = new ElementExampleImpl(context, -5);
        IElement element4 = new ElementExampleImpl(context, 1);
        IElement element5 = new ElementExampleImpl(context, 45);
        List<IElement> elements = Stream.of(
                element5, element1, element3, element2, element4
        ).collect(toList());
        iElementNumberAssigner.assignNumbers(elements);
        assertEquals(1, elements.get(0).getNumber());
        assertEquals(2, elements.get(1).getNumber());
        assertEquals(3, elements.get(2).getNumber());
        assertEquals(4, elements.get(3).getNumber());
        assertEquals(5, elements.get(4).getNumber());
        System.out.println(context.getOperationCount());
    }
}