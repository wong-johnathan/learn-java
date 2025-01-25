package linkedList;

import java.util.*;

record Town(String name, int distance) {

    @Override
    public String toString() {
        return this.name + " - " + this.distance;
    }
}

public class MyLinkedList {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        LinkedList<Town> townLL = new LinkedList<>();

        addPlace(townLL, new Town("Adelaide", 1374));
        addPlace(townLL, new Town("Adelaide", 1374));
        addPlace(townLL, new Town("adelaide", 1374));
        addPlace(townLL, new Town("Alice Springs", 2771));
        addPlace(townLL, new Town("Brisbane", 917));
        addPlace(townLL, new Town("Drawin", 3972));
        addPlace(townLL, new Town("Melbourne", 877));
        addPlace(townLL, new Town("Perth", 3923));

        ListIterator<Town> iterator = townLL.listIterator();

        Boolean flag = true;
        
        printInstructions();

        while (flag) {
            System.out.print("Enter value: ");
            String actions = scanner.nextLine().toUpperCase().substring(0,1);
            switch (actions) {
                case "F" ->
                    moveForward(iterator);
                case "B"->
                    moveBackward(iterator);
                case "L" ->
                    System.out.println(townLL);
                case "M"-> printInstructions();
                default ->
                    flag = false;
            }
        }
    }

    private static void addPlace(LinkedList<Town> townLL, Town town) {
        if (townLL.contains(town)) {
            System.out.println("Found duplicate");
            return;
        }

        int index=0;
        for (Town t : townLL) {
            if (t.name().equalsIgnoreCase(town.name())) {
                System.out.println("Found duplicate");
                return;
            }
            if(t.distance()>town.distance()){
                townLL.add(index,town);
                return;
            }
            index++;
        }
        townLL.add(town);
    }

    private static void moveForward(ListIterator<Town> iterator) {
        if (iterator.hasNext()) {
            System.out.println(iterator.next());
        } else {
            System.out.println("Reached the end of LL");
        }

    }

    private static void moveBackward(ListIterator<Town> iterator) {
        if (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        } else {
            System.out.println("Already at the start of LL");
        }
    }

    private static void printInstructions() {
        String instructions = """
                Available actions (select word or letter):

                (F)orward

                (B)ackward

                (L)ist Places

                (M)enu

                (Q)uit""";
        System.out.println(instructions + " ");
    }

}
