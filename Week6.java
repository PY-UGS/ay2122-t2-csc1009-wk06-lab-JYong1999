import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Week6 {
    public void addAndSort(LinkedList<Integer> list, int value) {
        System.out.println("LinkedList before inserting: \n" + Arrays.toString(list.toArray()));
        list.addLast(value);
        Collections.sort(list);
        System.out.println("LinkedList after inserting: \n" + Arrays.toString(list.toArray()));
    }

    public void swapValues(LinkedList<Integer> list, int firstIndex, int secondIndex) {
        int ele1 = list.get(firstIndex);
        int ele2 = list.get(secondIndex);
        list.set(firstIndex, ele2);
        list.set(secondIndex, ele1);
        System.out.println("LinkedList swapped values at index " + firstIndex + " and " + secondIndex + ": \n"  + Arrays.toString(list.toArray()));
    }

    public void addAndSortHash(HashMap<Integer, Integer> map, int value) {
        System.out.println("Hashmap before inserting: ");
        for (int i = 0; i < map.size(); i++) {
            System.out.print(map.get(i) + " ");
        }
        System.out.println("\nHashmap after inserting: ");
        map.put(map.size(), value);
        List<Integer> sorted = new ArrayList<Integer>(map.values());
        Collections.sort(sorted);
        for (int i = 0; i < map.size(); i++) {
            map.put(i, sorted.get(i));
            System.out.print(map.get(i) + " ");
        }
        System.out.println("");
    }

    public void swapValuesHash(HashMap<Integer, Integer> map, int firstIndex, int secondIndex) {
        int ele1 = map.get(firstIndex);
        int ele2 = map.get(secondIndex);
        map.put(firstIndex, ele2);
        map.put(secondIndex, ele1);
        System.out.println("Hashmap swapped values at index " + firstIndex + " and " + secondIndex + ": ");
        for (int i = 0; i < map.size(); i++) {
            System.out.print(map.get(i) + " ");
        }
        System.out.println("");
    }

    public int findValue(LinkedList<Integer> list, int searchVal) {
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == searchVal) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int findValueHash(HashMap<Integer, Integer> map, int searchVal) {
        int index = -1;
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i) == searchVal) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<Integer>(Arrays.asList(1, 2, 5, 7, 10, 13));
        Week6 test = new Week6();
        test.addAndSort((LinkedList<Integer>) list, 9);
        test.swapValues((LinkedList<Integer>) list, 3, 5);

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        map.put(1, 2);
        map.put(2, 5);
        map.put(3, 7);
        map.put(4, 10);
        map.put(5, 13);
        test.addAndSortHash(map, 9);
        test.swapValuesHash(map, 3, 5);

        List<Integer> randList = new LinkedList<Integer>();
        HashMap<Integer, Integer> randMap = new HashMap<>();
        int randNo;
        int randNo2 = ThreadLocalRandom.current().nextInt(1000, 9999+1);

        for (int i = 0; i < 500; i++) {
            randNo = ThreadLocalRandom.current().nextInt(1000, 9999+1);
            randList.add(randNo);
            randMap.put(i, randNo);
        }
        System.out.println("\nRandom number list: " + randList);
        System.out.println("Random number to search: " + randNo2);
        System.out.println("Index of random value in linked list: " + test.findValue((LinkedList<Integer>) randList, randNo2));
        System.out.println("Index of random value in hash map: " + test.findValueHash(randMap, randNo2));
    }
}