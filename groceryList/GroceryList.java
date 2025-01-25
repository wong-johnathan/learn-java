package groceryList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class GroceryList {

    private static Scanner scanner = new Scanner(System.in);

    private static void printAction() {
        String textBlock = """
                Available actions:
                0 - to shutdown
                1 - to add item(s) to list (comma delimited list)
                2 - to remove any items (comma delimited list)
                Enter a number for which action you want to do: """;
        System.out.print(textBlock + " ");
    }

    private static void addItems(ArrayList<String> groceries) {
        System.out.println("Add item(s) [separate items by comma]:");
        String input = scanner.nextLine().trim();
        if (!input.isEmpty()) {
            String[] items = input.split(",");
            for (String item : items) {
                String trimmed = item.trim();
                if (!trimmed.isEmpty() && !groceries.contains(trimmed)
                    
                ) {
                    groceries.add(trimmed);
                }
            }
        }
    }

    private static void removeItems(ArrayList<String> groceries) {
        System.out.println("Remove item(s) [separate items by comma]:");
        String input = scanner.nextLine().trim();
        if (!input.isEmpty()) {
            String[] items = input.split(",");
            for (String item : items) {
                String trimmed = item.trim();
                if (!trimmed.isEmpty() &&
                groceries.contains(trimmed)
                    
                ) {
                    groceries.remove(trimmed);
                }
            }
        }
    }

    public static void main(String[] args) {
        boolean flag = true;
        ArrayList<String> groceryList = new ArrayList<>();

        try {
            while (flag) {
                printAction();
                String input = scanner.nextLine().trim();
                try {
                    int action = Integer.parseInt(input);
                    switch (action) {
                        case 0 ->
                            flag = false;
                        case 1 ->
                            addItems(groceryList);
                        case 2 ->
                            removeItems(groceryList);
                        default ->
                            System.out.println("Please select a valid option");
                    }
                    groceryList.sort(Comparator.naturalOrder());
                    System.out.println(groceryList);
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number");
                }
            }
        } finally {
            scanner.close();
        }
    }
}
