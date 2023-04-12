package tasks;

import java.util.Arrays;
import java.util.Objects;

public class DynamicArray<E> {
//Dynamic Array
    private static Object[] data = new Object[10];
    private int size;
    protected transient int modCount = 0;
    transient Object[] elementData = data;
//Adding an element to the end of the array
    public void addElement(E e){
        if (data.length <= size){
            Object[] tmp = data;
            data = new Object[size * 2];
            for (int i = 0; i < tmp.length; i++) {
                data[i] = tmp[i];
            }
        }
        data[size] = e;
        size++;
    }
//Adding an element by an arbitrary index.
    public void addElement(int index,E newElement) {
        Object[] elementData = data;
        //elementData[index] = elementData[index +1];
        elementData[index] = newElement;
        if (data.length <= size) {
            data = new Object[size * 2];
            for (int i = 0; i < elementData.length; i++) {
                elementData[i] = elementData[index];
            }
        }
        data[index] = elementData[index];
    }


    //toString переделать
    public static String toString(DynamicArray input){
        if (input == null){
            return "false";
        }
        int emptyArray = input.size - 1;
        if (emptyArray == -1){
            return "[]";
        }
        StringBuilder stringBuilderToString = new StringBuilder();
        stringBuilderToString.append("[");
        for (int i = 0; ; i++) {
            stringBuilderToString.append(data[i]);
            if (i == emptyArray){
                return stringBuilderToString.append("]").toString();
            }
            stringBuilderToString.append(",");
        }
    }
//Getting an element by index.
    public Object getElement(int index) {
        return data[index];
    }
//Getting the current size.
    public int getSize(){
        return size;
    }
//Overwriting an element by index.
    public E setElement(int removeValue,E newValue){
        Object[] elementData = data;
        E oldValue = elementData(removeValue);
        elementData[removeValue] =  newValue;
        return oldValue;
    }

    private E elementData(int someValue) {
        return null;
    }
//Deleting an arbitrary element by index.
    public boolean removeElement(Object removeIndex){
        final Object[] elementData = data;
        final int size = this.size;
        int i = 0;
        found: {
            if (removeIndex == null){
                for (;i<size;i++){
                    if (elementData[i] == null){
                        break found;
                    }
                }
            }
            else {
               for (;i<size;i++){
                   if (removeIndex.equals(elementData[i])){
                       break found;
                   }
               }
            }
        }
        fastRemove(elementData,i);
        return true;
    }
    private void fastRemove(Object[] es, int i) {
        modCount++;
        final int newSize;
        if ((newSize = size - 1) > i)
            System.arraycopy(es, i + 1, es, i, newSize - i);
        es[size = newSize] = null;
    }
//////////исправить и переместить в начало
    public void add(int index, E element) {
        modCount++;
        final int s;
        Object[] elementData;
        if ((s = size) == (elementData = this.elementData).length)
            data = new Object[size * 2];
        System.arraycopy(elementData, index,
                elementData, index + 1,
                s - index);
        elementData[index] = element;
        size = s + 1;
    }
//Checking for the occurrence of an element.
    public boolean containsElement(E element){
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            if (element == data[i]){
                count++;
            }
        }
        if (count > 0){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DynamicArray<?> that = (DynamicArray<?>) o;
        return size == that.size && modCount == that.modCount && Arrays.equals(elementData, that.elementData);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size, modCount);
        result = 31 * result + Arrays.hashCode(elementData);
        return result;
    }
    public String toString(){
        return Arrays.toString(getArray());
    }
    public Object[] getArray(){
        return Arrays.copyOfRange(data,0,size);
    }

    //Comparison with other objects.(equals and hashCode)
    public static void main(String[] args) {
        DynamicArray<String> arrayList = new DynamicArray<>();
        arrayList.addElement("a");
        arrayList.addElement("r");
        arrayList.addElement("4");
        arrayList.addElement("2");
        System.out.println((arrayList));
        System.out.println(arrayList.getSize());
        System.out.println(arrayList.getElement(3));
        arrayList.setElement(0,"3463");
        System.out.println(toString(arrayList));
        arrayList.addElement(0,"Hello from index two");
        System.out.println(toString(arrayList));
        arrayList.removeElement(3);
        System.out.println(toString(arrayList));
        arrayList.add(2,"Hello from second index");
        System.out.println(toString(arrayList));
        System.out.println(arrayList.containsElement("Hello from second index"));
    }
}