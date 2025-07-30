import java.util.ArrayList;
import java.util.Scanner;

public class Lab_02 {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        System.out.print("Enter Number of Vehicles: ");
        int n = s1.nextInt();
        s1.nextLine();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<Integer> wheels = new ArrayList<>();
        ArrayList<Integer> cc = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter Name of Vehicle " + (i + 1) + ": ");
            String veh = s1.nextLine();
            name.add(veh);

            System.out.println("Enter number of wheels for vehicle " + (i + 1) + ": ");
            int whe = s1.nextInt();
            wheels.add(whe);

            System.out.println("Enter the CC of the engine for vehicle " + (i + 1) + ": ");
            int eng = s1.nextInt();
            cc.add(eng);

            s1.nextLine();
        }
        System.out.print("Enter vehicle name to search: ");
        String access = s1.nextLine();
        int index = name.indexOf(access);
        if (index >= 0) {
            System.out.println("Vehicle Details:");
            System.out.println("Name   : " + name.get(index));
            System.out.println("Wheels : " + wheels.get(index));
            System.out.println("CC     : " + cc.get(index));
        } else {
            System.out.println("Vehicle not found...");
        }
        s1.close();
        long endTime = System.nanoTime();
        long startTime = 0;
        long duration = (endTime - startTime) / 1000000;
        System.out.println("Total program execution time: " + duration + " nanoseconds");
    }
}