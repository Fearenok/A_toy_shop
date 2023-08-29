import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Raffle {

   private static ArrayList<Toy> toys = new ArrayList<>();
   private static PriorityQueue<Toy> prizes = new PriorityQueue<>();

   private static int idCounter = 0;

   public void addToy() {
        Scanner scan = new Scanner(System.in);
        String title;
        int frequency;
        while (true) {
            System.out.print("Enter Title: ");
            title = scan.nextLine();
            if (title.isEmpty()) {
                System.out.println("Incorrect input. Try again.");
                break;
            }
            System.out.print("Enter Frequency of dropping out: ");
            String value = scan.nextLine();
            if (isDigit(value)) {
                frequency = Integer.parseInt(value);
                if (frequency <= 0) {
                    System.out.println("Incorrect input. Try again.");
                } else {
                    Toy toy = new Toy(idCounter, title, frequency);
                    if (!toys.contains(toy) || toys.size() == 0) {
                        idCounter++;
                        toys.add(toy);
                        System.out.println("New toy was added");
                    } else {
                        System.out.println("This toy is already in the prize fund.");
                    }
                }
            } else {
                System.out.println("Incorrect input. Try again.");
            }
            break;
        }
    }