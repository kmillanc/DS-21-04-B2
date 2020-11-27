package e2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
    @Test
    void mainTest() throws Exception {
        int j [][]= {{1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24}};
        int[][] j1 = {{ 4, 5, 6},
                {10, 11, 12},
                {16, 17, 18},
                {22, 23, 24}};
        int[][] j2 = {{ 7, 5, 1},
                {14, 12, 20},
                {3, 21, 18},
                {22, 23, 9}};

        Matrix m1 = new Matrix(j1);
        Matrix m2 = new Matrix(j2);
        Matrix matrix  = new Matrix(j);

        assertEquals("Esta matriz tiene 4 filas y 6 columnas", matrix.getNfilasNcolumnas());
        assertEquals(11, matrix.getElement(2, 5));
        assertEquals(10,matrix.getElement(2, 4));
        matrix.setElement(4,4,0);
        assertEquals("[7, 8, 9, 10, 11, 12]",matrix.getRow(2).toString());
        assertEquals( "[5, 11, 17, 23]" ,matrix.getColumn(4).toString());
        assertEquals("[1, 2, 3, 4, 5, 6]" +
                "[7, 8, 9, 10, 11, 12]" +
                "[13, 14, 15, 16, 17, 18]" +
                "[19, 20, 21, 0, 23, 24]" , matrix.getMatrix());
        assertEquals("[4, 5, 6]" +
                "[10, 11, 12]" +
                "[16, 17, 18]" +
                "[22, 23, 24]" , m1.getMatrix());
        assertEquals("[7, 5, 1]" +
                "[14, 12, 20]" +
                "[3, 21, 18]" +
                "[22, 23, 9]" , m2.getMatrix());

        Matrix.MatrixAddition m3 = new Matrix.MatrixAddition();

    }
}