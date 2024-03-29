package e2;

import java.util.Arrays;
import java.util.Iterator;

public class Matrix {
    private boolean iter;
    private int nColumnas;
    private int nFilas;
    private int[][] matriz ;//Atributos
    //Setters & Getters
    public int getnColumnas() {
        return nColumnas;
    }
    public int getnFilas() {
        return nFilas;
    }
    public void setnColumnas(int nColumnas) {
        this.nColumnas = nColumnas;
    }
    public void setnFilas(int nFilas) {
        this.nFilas = nFilas;
    }
    public int posi, posj;
    //Constructores
    public Matrix(int filas, int columnas){     //Contructor
        this.nColumnas = columnas;
        this.nFilas = filas;
        int m[][] = new int[filas][columnas];
        this.matriz = m;
        for(int i=0; i<nFilas; i++){
            for (int j = 0; j<nColumnas; j++){
                this.matriz[i][j] = 0;
            }
        }
    }
    public Matrix(int matriz1[][] ) throws Exception {
        this.nFilas = 0;
        this.nColumnas = 0;
        int nColumnasAux = matriz1[0].length;
        this.matriz = matriz1;

        boolean esRagged = false;

        for(int i = 0; i < matriz1.length || esRagged; i++){
            if(matriz1[i].length != nColumnasAux){
                esRagged = true;
                throw new Exception("Error, este vector no es rectangular");
            }
//            for(int j= 0; j < nColumnasAux; j++){
//                this.matriz[i][j] = matriz1[i][j];
//            }
            if(esRagged){
                this.nFilas = 0;
                this.nColumnas = 0;
                this.matriz = null;
                this.matriz = null;
            }
        }
        this.nColumnas = nColumnasAux;
        this.nFilas = matriz1.length;
    }
    //Metodos
    java.lang.Iterable<Integer> aIterable = new Iterable<Integer>() {
        public Iterator <Integer> iterator() {
            return new Iterator <Integer>() {
                private int filaN = posi ;
                private int columnaN = posj;
                public boolean hasNext() {
                    return (columnaN != matriz[0].length && filaN != matriz.length);
                }
                public Integer next(){
                    if(columnaN == matriz[0].length){
                        posj = 0;
                        columnaN = 0;
                        return matriz[filaN++][columnaN];
                    }
                    else{
                        return matriz[filaN][columnaN++];
                    }
                }
                public void remove() {
                    throw new UnsupportedOperationException("Cannot remove an element of an array.");
                }
            };
        }
    };
    java.lang.Iterable<Integer> bIterable = new Iterable<Integer>() {
        public Iterator <Integer> iterator(){
            return new Iterator <Integer>(){
                private int filaN ;
                private int columnaN ;
                public boolean hasNext() {
                    return (columnaN != matriz[0].length && filaN != matriz.length);
                }
                public Integer next() {
                    if(filaN == matriz.length){
                        filaN = 0;
                        return matriz[0][columnaN++];
                    }
                    else{
                        return matriz[filaN++][columnaN];
                    }
                }
                public void remove(){
                    throw new UnsupportedOperationException("Cannot remove an element of an array.");
                }
            };
        }
    };

    public int rowColumnIterator(int n) {
        posi = 0;
        posj = 0;
        int r = 0;
        if(n < nColumnas*nFilas ){
            for(int i = 0; i < n-1 ;i++){
                if(aIterable.iterator().hasNext()){
//                    aIterable.iterator().next();
                    r = this.aIterable.iterator().next();
//                    aIterable.iterator().next();
                    posj++;
                    if (posj == this.nColumnas-1){
                        posj = 0;
                        posi++;
                    }
                }
            }
            return r;
        }
        else{
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public int ColumnRowIterator(int n){
        if(n < nColumnas*nFilas ){
            for(int i = 0; i < n-1 ;i++){
                if(bIterable.iterator().hasNext()){
                    bIterable.iterator().next();
                }
            }
            return bIterable.iterator().next();
        }
        else{
            throw new ArrayIndexOutOfBoundsException();
        }
    }


    public String getNfilasNcolumnas(){
        String sb = "Esta matriz tiene " +
                getnFilas() +
                " filas y " +
                getnColumnas() +
                " columnas";
        return sb;
    }

    public int getElement(int filaN, int columnaN ) throws Exception {
        if(filaN >= nFilas || columnaN >= nColumnas){
            throw new Exception("La posicion no es válida");
        }
        else{
            return this.matriz[filaN-1][columnaN-1];
        }
    }

    public void setElement(int filaN, int columnaN, int replace) throws Exception {
        if(filaN > nFilas || columnaN > nColumnas){
            throw new Exception("La posicion no es válida");
        }
        else{
            this.matriz[filaN-1][columnaN-1] = replace;
        }

    }

    public String getRow(int filaN){
        StringBuilder sb = new StringBuilder();
        sb.append(Arrays.toString(this.matriz[filaN - 1]));
        return sb.toString();
    }

    public String getColumn(int columnaN){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0;i<this.nFilas;i++){
            sb.append(this.matriz[i][columnaN]);
            if(i != this.nFilas-1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public String getMatrix(){
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<=this.nFilas;i++){
            sb.append(getRow(i));
        }
        return sb.toString();
    }

    public static class MatrixAddition{
//        int[][] j1 = {{1, 2, 3, 4, 5, 6},
//                    {7, 8, 9, 10, 11, 12},
//                    {13, 14, 15, 16, 17, 18},
//                    {19, 20, 21, 22, 23, 24}};
//        int[][] j2 = {{2, 5, 3, 7, 5, 1},
//                {5, 5, 9, 14, 12, 20},
//                {0, 8, 1, 3, 21, 18},
//                {4, 20, 1, 22, 23, 9}};
//
//        Matrix m1 = new Matrix(j1);
//        Matrix m2 = new Matrix(j2);

        public Matrix matrixSumMatrix(Matrix m1, Matrix m2, boolean iter) throws Exception {
            if(m1.nFilas == m2.nFilas && m1.nColumnas == m2.nColumnas){
                Matrix m3 = new Matrix(m1.nFilas, m2.nColumnas);
                if(!iter){
//                    m3.matriz[0][0] = m1.matriz[0][0] + m2.matriz[0][0];
                    for(int i = 0; i < m3.nColumnas*m3.nFilas ;i++){
                        m3.setElement(i/m3.nColumnas+1,i%m3.nColumnas+1 , m1.rowColumnIterator(i) + m2.rowColumnIterator(i));
                    }

                }
                else{
                    for(int i = 0; i < m3.nColumnas*m3.nFilas ;i++){
                        m3.setElement(i%m3.nFilas+1,i/m3.nFilas+1 , m1.ColumnRowIterator(i) + m2.ColumnRowIterator(i));
                    }
                }
                return m3;
            }
            else{
                throw new ArithmeticException();
            }

        }


    }

    public static void main(String[] args) throws Exception {
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

        System.out.println(matrix.getNfilasNcolumnas());
        System.out.println(matrix.getElement(2, 5));
        System.out.println();
        matrix.setElement(4,4,0);
        System.out.println();
        System.out.println(matrix.getElement(2, 4));
        System.out.println();
        System.out.println(matrix.getRow(2));
        System.out.println();
        System.out.println(matrix.getColumn(4));
        System.out.println();
        matrix.getMatrix();
        System.out.println();
        m1.getMatrix();
        System.out.println();
        m2.getMatrix();
        System.out.println();
        MatrixAddition m3 = new MatrixAddition();
        m3.matrixSumMatrix(m1, m2, false).getMatrix();
    }

}