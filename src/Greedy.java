import java.io.*;
import java.util.*;

public class Greedy {

    public static void main(String[] args) {
        try {
            run(args[0]);
            randomInput(100);
            randomInput(500);
            randomInput(1000);
        }
        catch (IOException e) {
            System.out.println("The requested file could not be found");
            System.exit(1);
        }
    }

    public static void Greedy(int[] folders) {
        CustomList<Disk> disks = new CustomList<>();
        disks.add(new Disk());
        disks.get(0).id = 0;
        int numOfDisks = 1;
        MaxPQ diskSpaces = new MaxPQ(new IntegerComparator());
        diskSpaces.add(disks.get(0).getFreeSpace());
        for (int i = 0; i < folders.length; i++) {
            int temp = (int) diskSpaces.getMax();
            if (folders[i] <= temp) {
                for (int j = 0; j < numOfDisks; j++) {
                    if (temp == disks.get(j).getFreeSpace()) {
                        disks.get(j).folders.add(folders[i]);
                        break;
                    }
                }
            }
            else {
                disks.add(new Disk());
                disks.get(numOfDisks).id = numOfDisks;
                disks.get(numOfDisks).folders.add(folders[i]);
                numOfDisks++;
            }
            for (int a = 0; a < disks.size; a++) {
                diskSpaces.add((disks.get(a).getFreeSpace()));
            }
        }
        int sum = 0;
        for (int i = 0; i < folders.length; i++) {
            sum += folders[i];
            float floatSum = sum;
        }
        float x = 1000000;
        float totalSum = sum/x;
        System.out.println("% java Greedy folderSizes.txt");
        System.out.println("Sum of all folders = " + totalSum + " TB");
        System.out.println("Total number of disks used = " + disks.size);
        for (int i = 0; i < disks.size; i++) {
            System.out.println("id " + disks.get(i).id + " " + disks.get(i).getFreeSpace() + ": " + disks.get(i).folders);
        }
        System.out.println("\n");
    }

    public static int GreedyNoPrint(int[] folders) {
        CustomList<Disk> disks = new CustomList<>();
        disks.add(new Disk());
        disks.get(0).id = 0;
        int numOfDisks = 1;
        MaxPQ diskSpaces = new MaxPQ(new IntegerComparator());
        diskSpaces.add(disks.get(0).getFreeSpace());
        for (int i = 0; i < folders.length; i++) {
            int temp = (int) diskSpaces.getMax();
            if (folders[i] <= temp) {
                for (int j = 0; j < numOfDisks; j++) {
                    if (temp == disks.get(j).getFreeSpace()) {
                        disks.get(j).folders.add(folders[i]);
                        break;
                    }
                }
            } else {
                disks.add(new Disk());
                disks.get(numOfDisks).id = numOfDisks;
                disks.get(numOfDisks).folders.add(folders[i]);
                numOfDisks++;
            }
            for (int a = 0; a < disks.size; a++) {
                diskSpaces.add((disks.get(a).getFreeSpace()));
            }
        }
        return disks.size;
    }

    public static void GreedyDecreasing(int[] folders) {
        Sort mergeSort = new Sort();
        mergeSort.sort(folders, 0, folders.length-1);
        int temp;
        int start = 0;
        int end = folders.length - 1;
        while (start < end) {
            temp = folders[start];
            folders[start] = folders[end];
            folders[end] = temp;
            start++;
            end--;
        }
        CustomList<Disk> disks = new CustomList<>();
        disks.add(new Disk());
        disks.get(0).id = 0;
        int numOfDisks = 1;
        MaxPQ diskSpaces = new MaxPQ(new IntegerComparator());
        diskSpaces.add(disks.get(0).getFreeSpace());
        for (int i = 0; i < folders.length; i++) {
            int newTemp = (int) diskSpaces.getMax();
            if (folders[i] <= newTemp) {
                for (int j = 0; j < numOfDisks; j++) {
                    if (newTemp == disks.get(j).getFreeSpace()) {
                        disks.get(j).folders.add(folders[i]);
                        break;
                    }
                }
            }
            else {
                disks.add(new Disk());
                disks.get(numOfDisks).id = numOfDisks;
                disks.get(numOfDisks).folders.add(folders[i]);
                numOfDisks++;
            }
            for (int a = 0; a < disks.size; a++) {
                diskSpaces.getMax();
            }
            for (int a = 0; a < disks.size; a++) {
                diskSpaces.add((disks.get(a).getFreeSpace()));
            }
        }
        int sum = 0;
        for (int i = 0; i < folders.length; i++) {
            sum += folders[i];
            float floatSum = sum;
        }
        float x = 1000000;
        float totalSum = sum/x;
        System.out.println("% java GreedyDecreasing folderSizes.txt");
        System.out.println("Sum of all folders = " + totalSum + " TB");
        System.out.println("Total number of disks used = " + disks.size);
        for (int i = 0; i < disks.size; i++) {
            System.out.println("id " + disks.get(i).id + " " + disks.get(i).getFreeSpace() + ": " + disks.get(i).folders);
        }
    }

    public static int GreedyDecreasingNoPrint(int[] folders) {
        Sort mergeSort = new Sort();
        mergeSort.sort(folders, 0, folders.length-1);
        int temp;
        int start = 0;
        int end = folders.length - 1;
        while (start < end) {
            temp = folders[start];
            folders[start] = folders[end];
            folders[end] = temp;
            start++;
            end--;
        }
        CustomList<Disk> disks = new CustomList<>();
        disks.add(new Disk());
        disks.get(0).id = 0;
        int numOfDisks = 1;
        MaxPQ diskSpaces = new MaxPQ(new IntegerComparator());
        diskSpaces.add(disks.get(0).getFreeSpace());
        for (int i = 0; i < folders.length; i++) {
            int newTemp = (int) diskSpaces.getMax();
            if (folders[i] <= newTemp) {
                for (int j = 0; j < numOfDisks; j++) {
                    if (newTemp == disks.get(j).getFreeSpace()) {
                        disks.get(j).folders.add(folders[i]);
                        break;
                    }
                }
            }
            else {
                disks.add(new Disk());
                disks.get(numOfDisks).id = numOfDisks;
                disks.get(numOfDisks).folders.add(folders[i]);
                numOfDisks++;
            }
            for (int a = 0; a < disks.size; a++) {
                diskSpaces.add((disks.get(a).getFreeSpace()));
            }
        }
        return disks.size;
    }

    public static void randomInput(int numOfIntegers) throws IOException {
        File f;
        Random ran = new Random();
        float sum1 = 0f;
        float sum2 = 0f;
        int randint;
        for (int i = 0; i < 10; i++) {
            f = new File(numOfIntegers + " Integers  " + i + ".txt");
            f.createNewFile();
            BufferedWriter s = new BufferedWriter(new FileWriter(f));
            for (int j = 0; j < numOfIntegers; j++) {
                randint = ran.nextInt(1000000);
                s.write(String.valueOf(randint));
                s.newLine();
            }
            s.close();
            Scanner scanner = new Scanner(f);
            int[] oldFolderSizes = new int[1000];
            int w = 0;
            while (scanner.hasNextInt()) {
                oldFolderSizes[w++] = scanner.nextInt();
            }
            int numOfFolders = 0;
            for (int j = 0; j < oldFolderSizes.length; j++) {
                if (oldFolderSizes[j] != 0) {
                    numOfFolders++;
                }
            }
            int[] folderSizes = new int[numOfFolders];
            for (int j = 0; j < numOfFolders; j++) {
                folderSizes[j] = oldFolderSizes[j];
            }
            sum1 += GreedyNoPrint(folderSizes);
            sum2 += GreedyDecreasingNoPrint(folderSizes);
        }
        float result1 = sum1/numOfIntegers;
        float result2 = sum2/numOfIntegers;
        System.out.println("***********************************************************");
        System.out.println("Took data from " + numOfIntegers + " random integers from 10 different files");
        System.out.println("Algorithm 1 needed " + result1 + " disks on average");
        System.out.println("Algorithm 2 needed " + result2 + " disks on average");
        System.out.println("***********************************************************");
    }

    public static void run(String fileName) throws IOException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        int[] oldFolderSizes = new int[1000];
        int i = 0;
        while (scanner.hasNextInt()) {
            oldFolderSizes[i++] = scanner.nextInt();
        }
        int numOfFolders = 0;
        for (int j = 0; j < oldFolderSizes.length; j++) {
            if (oldFolderSizes[j] != 0) {
                numOfFolders++;
            }
        }
        int[] folderSizes = new int[numOfFolders];
        for (int j = 0; j < numOfFolders; j++) {
            folderSizes[j] = oldFolderSizes[j];
        }
        for (int j = 0; j < numOfFolders; j++) {
            if (folderSizes[j] > 1000000) {
                System.out.println("Certain folder(s) exceed(s) 1 TB.");
                System.exit(1);
            }
        }
        Greedy(folderSizes);
        GreedyDecreasing(folderSizes);
    }

}
