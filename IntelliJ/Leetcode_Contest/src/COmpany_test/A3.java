package COmpany_test;

import java.util.*;

public class A3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of buildings and number of queries
        int N = scanner.nextInt();
        int Q = scanner.nextInt();

        // Read the heights of the buildings
        int[] heights = new int[N];
        for (int i = 0; i < N; i++) {
            heights[i] = scanner.nextInt();
        }

        // Process each query
        for (int q = 0; q < Q; q++) {
            int J = scanner.nextInt() - 1; // Convert to 0-based index
            int M = scanner.nextInt() - 1; // Convert to 0-based index
            System.out.println(findMeetingBuilding(heights, J, M));
        }

        scanner.close();
    }

    private static int findMeetingBuilding(int[] heights, int J, int M) {
        Set<Integer> jPath = new HashSet<>();
        Set<Integer> mPath = new HashSet<>();

        // Collect all buildings Jatin can reach
        collectReachableBuildings(heights, J, jPath);

        // Collect all buildings Mano can reach
        collectReachableBuildings(heights, M, mPath);

        // Find the leftmost common building they can meet at
        for (int i = 0; i < heights.length; i++) {
            if (jPath.contains(i) && mPath.contains(i)) {
                return i + 1; // Convert to 1-based index
            }
        }

        return -1; // No meeting point found
    }

    private static void collectReachableBuildings(int[] heights, int start, Set<Integer> path) {
        path.add(start);
        for (int i = start + 1; i < heights.length; i++) {
            if (heights[i] > heights[start]) {
                path.add(i);
                start = i;
            }
        }
    }
}
