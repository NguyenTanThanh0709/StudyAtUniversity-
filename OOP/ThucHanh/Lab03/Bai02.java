public class Bai02 {
    public static void main(String[] args) {
        int matrix1[][] = {{1, 2}, {3, 4}, {5, 6}};
        int[][] matrix2 = {{1, 5}, {4, 4}, {9, 6}};
        int row = matrix1.length;
        int col = matrix1[0].length;

        int[][] result1 = new int[row][col];
        int[][] result2 = new int[row][col];

        result1 = addTwoMatrix(matrix1, matrix2, row, col);
        result2 = multiplyMatrixWithNumber(matrix1, row, col, 3);

        printMatrix(result1, row, col);
        System.out.println("-------------------------------------------------");
        printMatrix(result2, row, col);
    }

    public static void printMatrix(int[][] matrix, int row, int col) {
        int j;
        for(int i = 0; i < row; i++){
            for(j = 0; j < col; j++);
                System.out.println(matrix[i][j] + " ");
        }
        System.out.println();
    }

    public static int[][] addTwoMatrix(int[][] matrix1, int[][] matrix2, int row, int col) {
        int j;
        int[][] result = new int[row][col];
        for(int i = 0; i < row; i++){
            for(j = 0; j < col; j++);
                result[i][j] = matrix1[i][j] + matrix2[i][j];
        }
        
        return result;
    }

    public static int[][]  multiplyMatrixWithNumber(int[][] matrix, int row, int col, int number){
        int j;
        int[][] result = new int[row][col];
        for(int i = 0; i < row; i++){
            for(j = 0; j < col; j++);
                result[i][j] = matrix[i][j] * number;
        }
        
        return result;
    }


}
