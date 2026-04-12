import java.util.Arrays;

class Solution {
    int[][][] memo;
    
    public int minimumDistance(String word) {
        // memo[index][finger1_pos][finger2_pos]
        // 26 represents a finger that hasn't been placed yet
        memo = new int[word.length()][27][27];
        for (int[][] mat : memo) {
            for (int[] row : mat) Arrays.fill(row, -1);
        }
        return solve(0, 26, 26, word);
    }
    
    private int solve(int idx, int f1, int f2, String word) {
        if (idx == word.length()) return 0;
        if (memo[idx][f1][f2] != -1) return memo[idx][f1][f2];
        
        int nextChar = word.charAt(idx) - 'A';
        
        // Option 1: Move Finger 1
        int moveF1 = getDist(f1, nextChar) + solve(idx + 1, nextChar, f2, word);
        
        // Option 2: Move Finger 2
        int moveF2 = getDist(f2, nextChar) + solve(idx + 1, f1, nextChar, word);
        
        return memo[idx][f1][f2] = Math.min(moveF1, moveF2);
    }
    
    private int getDist(int from, int to) {
        if (from == 26) return 0; // Free initial placement
        int r1 = from / 6, c1 = from % 6;
        int r2 = to / 6, c2 = to % 6;
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}