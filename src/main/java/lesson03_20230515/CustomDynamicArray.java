package lesson03_20230515;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class CustomDynamicArray implements Iterable<Integer> {

    private int[] array;
    private int size;
    private int count;

    public CustomDynamicArray() {
        array = new int[1];
        size = 1;
        count = 0;
    }

    public CustomDynamicArray(int capacity) {
        this.array = new int[capacity];
        this.size = capacity;
        this.count = 0;
    }

    public void add(int data) {
        if (count >= size) {
            growSize();
        }
        //            array[count] = data;
//            count++;
        // то же самое короче:
        array[count++] = data;
    }

    public void set(int data, int index) {
        if (index >= count)
            throw new IndexOutOfBoundsException();

        array[index] = data;
    }

    public void addAt(int data, int index) {
        if (index >= count)
            throw new IndexOutOfBoundsException();
        if (count >= size) {
            growSize();
        }

        for (int i = count - 1; i >= index ; i--) {
            array[i+1] = array[i];
        }

        array[index] = data;
        count++;
    }

    public void remove() {
        if (count == 0) throw new IndexOutOfBoundsException("No elements in collection");
        count--;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= count)
            throw new IndexOutOfBoundsException();

        for (int i = index; i < count - 1; i++) {
            array[i] = array[i+1];
        }

        count--;
    }

    public void shrinkSize() {
        if (count == size) return;

        int[] newArray = new int[count];

        for (int i = 0; i < count; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
        size = newArray.length;
    }

    public int get(int index) {
        if (index < 0 || index >= count)
            throw new IndexOutOfBoundsException();

        return array[index];
    }

    public void clear() {
        count = 0;
    }

    public boolean contains(int data) {
        for (int i = 0; i < count; i++) {
            if (array[i] == data) return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    private void growSize() {
        int[] newArray = new int[size * 2];
        for (int i = 0; i < count; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
        size = newArray.length;
    }

    public String printInnerStructure() {
        return "CustomDynamicArray{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                ", count=" + count +
                '}';
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("[");
        for (int i = 0; i < count; i++) {
            if (i > 0) s.append(", ");
            s.append(array[i]);
        }
        s.append("]");
        return "CustomDynamicArray{" +
                "array=" + s.toString() +
                ", size=" + size +
                ", count=" + count +
                '}';
    }

    public static void main(String[] args) {
        CustomDynamicArray dynamicArray = new CustomDynamicArray();

        dynamicArray.add(1);
        System.out.println(dynamicArray.printInnerStructure());
        dynamicArray.add(2);
        System.out.println(dynamicArray.printInnerStructure());
        dynamicArray.add(3);
        System.out.println(dynamicArray.printInnerStructure());
        dynamicArray.add(4);
        System.out.println(dynamicArray.printInnerStructure());
        dynamicArray.add(5);
        System.out.println(dynamicArray.printInnerStructure());
        dynamicArray.add(6);
        System.out.println(dynamicArray.printInnerStructure());
        dynamicArray.add(7);
        System.out.println(dynamicArray.printInnerStructure());

        dynamicArray.addAt(100, 0);
        System.out.println(dynamicArray.printInnerStructure());
        dynamicArray.addAt(100, 6);
        System.out.println(dynamicArray.printInnerStructure());

        System.out.println(dynamicArray);

    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Integer next() {
                return null;
            }
        };
    }
}