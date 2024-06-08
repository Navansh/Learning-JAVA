package ETE_2_21_22;

class Matrix{
   private int[][] elements;
   private int row;
   private int column;

    public Matrix(int[][] elements,int row,int column){
        this.elements = elements;
        this.row = row;
        this.column = column;
    }
    public Matrix addMatrix(Matrix M)
    {
        int[][] result = new int[55][];
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements[i].length; j++) {
                result[i][j] = elements[i][j] + M.elements[i][j];
            }
        }
        return new Matrix(result, this.row+M.row, this.column+M.column);
    }
    public static Matrix addMatrix(Matrix M,Matrix N)
    {
        int[][] result = new int[55][];
        for (int i = 0; i < M.elements.length; i++) {
            for (int j = 0; j < M.elements[i].length; j++) {
                result[i][j] = M.elements[i][j] + N.elements[i][j];
            }
        }
        return new Matrix(result, N.row+M.row, N.column+M.column);
    }

}