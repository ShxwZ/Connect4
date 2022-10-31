/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conecta4.Logica;

import java.util.Arrays;

/**
 *
 * @author Shaw
 */
public class Comprobaciones {
    static int [][] matrizGanador = new int [5][7];


    /*
    * Comprobaciones basadas en la matriz de jugadas y el turno de jugador
     */
    public static int comprobarColumnas(int[][] matriz, int jugador) {
        for (int i = 0; i < matriz[0].length; i++) { // vamos por columnas
            int suma = 0;
            cleanMatriz();
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[j][i] == jugador) {
                    suma++;
                    matrizGanador[j][i] = jugador;
                }
                if (suma != 0 && matriz[j][i] != jugador) {
                    cleanMatriz();
                    break;
                }
                if (suma == 4) {
                    return jugador;
                }
            }
        }
        
        return -1;
    }

    public static int comprobarFilas(int[][] matriz, int jugador) {
        for (int i = 0; i < matriz.length; i++) { // vamos por las filas
            int suma = 0;
            cleanMatriz();
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == jugador) {
                    suma++;
                    matrizGanador[i][j] = jugador;
                }
                if (suma != 0 && matriz[i][j] != jugador) {
                    cleanMatriz();
                    break;
                }
                if (suma == 4) {
                    return jugador;
                }
            }
        }

        return -1;
    }

    public static int comprobarDiagonal(int[][] matriz, int jugador) { // Esto es lo mas coñazo
        for (int i = 0; i < 4; i++) { //comprobaciones acendente 4ta fila
            boolean comprobacion1 = (matriz[3][i] == matriz[3 - 1][i + 1]) && (matriz[3][i] == jugador);
            boolean comprobacion2 = (matriz[3 - 2][i + 2] == matriz[3 - 3][i + 3]) && (matriz[3 - 2][i + 2] == jugador);
            if (comprobacion1 && comprobacion2) {
                matrizGanador[3][i] = jugador;
                matrizGanador[3 - 1][i + 1] = jugador;
                matrizGanador[3 - 2][i + 2] = jugador;
                matrizGanador[3 - 3][i + 3] = jugador;
                return jugador;
            }
        }
        for (int i = 0; i < 4; i++) { //comprobaciones acendente 5ta fila
            boolean comprobacion1 = (matriz[4][i] == matriz[4 - 1][i + 1]) && (matriz[4][i] == jugador);
            boolean comprobacion2 = (matriz[4 - 2][i + 2] == matriz[4 - 3][i + 3]) && (matriz[4 - 2][i + 2] == jugador);
            if (comprobacion1 && comprobacion2) {
                matrizGanador[4][i] = jugador;
                matrizGanador[4 - 1][i + 1] = jugador;
                matrizGanador[4 - 2][i + 2] = jugador;
                matrizGanador[4 - 3][i + 3] = jugador;
                return jugador;
            }
        }
        for (int i = 0; i < 4; i++) { //comprobaciones descendente 1era fila
            boolean comprobacion1 = (matriz[0][0+i] == matriz[1][1+i]) && (matriz[0][0+i] == jugador);
            boolean comprobacion2 = (matriz[2][2+i] == matriz[3][3+i]) && (matriz[2][2+i] == jugador);
            if (comprobacion1 && comprobacion2) {
                matrizGanador[0][0+i] = jugador;
                matrizGanador[1][1+i] = jugador;
                matrizGanador[2][2+i] = jugador;
                matrizGanador[3][3+i] = jugador;
                return jugador;
            }
        }
        for (int i = 0; i < 4; i++) { //comprobaciones descendente 2nda fila
            boolean comprobacion1 = (matriz[1][0+i] == matriz[2][1+i]) && (matriz[1][0+i] == jugador);
            boolean comprobacion2 = (matriz[3][2+i] == matriz[4][3+i]) && (matriz[3][2+i] == jugador);
            if (comprobacion1 && comprobacion2) {
                matrizGanador[1][0+i] = jugador;
                matrizGanador[2][1+i] = jugador;
                matrizGanador[3][2+i] = jugador;
                matrizGanador[4][3+i] = jugador;
                return jugador;
            }
        }
        return -1;
    }

    public static boolean comprobarTodo(int[][] matriz, int jugador) {
        if (comprobarColumnas(matriz, jugador) != -1) {
            System.out.println("Comprobacion Columnas: " + comprobarColumnas(matriz, jugador));
            return true;
        }
        if (comprobarFilas(matriz, jugador) != -1) {
            System.out.println("Comprobacion Filas: " + comprobarFilas(matriz, jugador));
            return true;
        }
        if (comprobarDiagonal(matriz, jugador) != -1) {
            System.out.println("Comprobacion Diagonal: " + comprobarDiagonal(matriz, jugador));
            return true;
        }

        return false;
    }
    public static void cleanMatriz(){
        for (int i = 0; i < matrizGanador.length; i++) {
            for (int j = 0; j < matrizGanador[0].length; j++) {
                matrizGanador[i][j] = 0;
            }
        }
    }
    public static int[][] getMatriz() {
        return matrizGanador;
    }

    
}
