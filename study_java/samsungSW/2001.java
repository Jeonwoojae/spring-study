import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCases = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCases; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int subMatrixSize = Integer.parseInt(st.nextToken());

            int[][] matrix = new int[size + 1][size + 1];
            int[][] accumulatedSum = new int[size + 1][size + 1]; // Accumulated sum matrix

            for (int i = 1; i <= size; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= size; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                    accumulatedSum[i][j] = accumulatedSum[i][j - 1] + accumulatedSum[i - 1][j]
                            - accumulatedSum[i - 1][j - 1] + matrix[i][j]; // Calculate accumulated sum
                }
            }

            int maxSum = Integer.MIN_VALUE;
            for (int i = subMatrixSize; i <= size; i++) {
                for (int j = subMatrixSize; j <= size; j++) {
                    // Calculate sub-matrix sum using accumulated sum matrix
                    int subMatrixSum = accumulatedSum[i][j] - accumulatedSum[i][j - subMatrixSize]
                            - accumulatedSum[i - subMatrixSize][j] + accumulatedSum[i - subMatrixSize][j - subMatrixSize];
                    maxSum = Math.max(maxSum, subMatrixSum); // Update max sum
                }
            }

            bw.write("#" + t + " " + maxSum);
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
    }
}