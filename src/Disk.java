public class Disk implements Comparable<Disk> {

    public int id;
    public int size = 1000000;
    CustomList<Integer> folders = new CustomList<>();
    public int getFreeSpace() {
        int sum = 0;
        for (int i = 0; i < folders.size; i++) {
            sum += folders.get(i);
        }
        int freeSpace = size - sum;
        return freeSpace;
    }
    public int compareTo(Disk disk) {
        if (getFreeSpace() > disk.getFreeSpace()) {
            return 1;
        }
        else if (getFreeSpace() < disk.getFreeSpace()) {
            return -1;
        }
        else {
            return 0;
        }
    }

}
