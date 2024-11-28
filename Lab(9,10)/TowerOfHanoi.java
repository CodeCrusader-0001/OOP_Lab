public class TowerOfHanoi {
    public static void main(String[] args) {
        int n = 3; // Number of disks
        System.out.println("Solution for Tower of Hanoi with " + n + " disks:");
        solveTowerOfHanoi(n, 'A', 'C', 'B'); // A, C, B are names of rods
    }

    // Function to solve Tower of Hanoi
    public static void solveTowerOfHanoi(int n, char source, char target, char auxiliary) {
        // Base case: If there is only one disk, move it from source to target
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + source + " to rod " + target);
            return;
        }

        // Move n-1 disks from source to auxiliary, using target as auxiliary
        solveTowerOfHanoi(n - 1, source, auxiliary, target);

        // Move the nth disk from source to target
        System.out.println("Move disk " + n + " from rod " + source + " to rod " + target);

        // Move the n-1 disks from auxiliary to target, using source as auxiliary
        solveTowerOfHanoi(n - 1, auxiliary, target, source);
    }
}