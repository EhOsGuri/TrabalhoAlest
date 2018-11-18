/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehosguri.maze;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author gabri
 */
public class App {

    public static void main(String[] args) throws IOException {
        /*final String[][] matrix = {
            {"1001", "1010", "1010", "0110"},
            {"0101", "1001", "1010", "1100"},
            {"0101", "0101", "1101", "0011"},
            {"0011", "0010", "0010", "1110"},};*/
        String[][] matrix = loadMatrix();
        printMatrix(matrix);
        String start = findStart(matrix);
        System.out.println("Start: " + start);
        System.out.println("End: " + findEnd(matrix,start));
    }

    static void printMatrix(String[][] maze) {

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }

    static String findStart(String[][] maze) {
        int cont = 0;
        while (cont < maze.length) {
            if (maze[0][cont].equals("1") || maze[0][cont].equals("2") || maze[0][cont].equals("3") || maze[0][cont].equals("4") || maze[0][cont].equals("5") || maze[0][cont].equals("6")) {
                return "Célula: 1" + (cont + 1);
            }
            if (maze[cont][0].equals("2") || maze[cont][0].equals("4") || maze[cont][0].equals("6") || maze[cont][0].equals("8") || maze[cont][0].equals("a") || maze[cont][0].equals("c")) {
                return "Célula: " + (cont + 1) + "1";
            }
            cont++;
        }
        return "Não encontrado";
    }

    static String findEnd(String[][] maze, String ini) {
        int cont = 0;
        while (cont < maze.length) {
            if (maze[maze.length - 1][cont].equals("1") || maze[maze.length - 1][cont].equals("4") || maze[maze.length - 1][cont].equals("5") || maze[maze.length - 1][cont].equals("8") || maze[maze.length - 1][cont].equals("9") || maze[maze.length - 1][cont].equals("c")){
                return "Célula: " + maze.length + "" + (cont + 1);
            }
            if (maze[cont][maze.length - 1].equals("1") || maze[cont][maze.length - 1].equals("2") || maze[cont][maze.length - 1].equals("3") || maze[cont][maze.length - 1].equals("8") || maze[cont][maze.length - 1].equals("9") || maze[cont][maze.length - 1].equals("a")){
                return "Célula: " + (cont + 1) + "" + maze.length;
            }
            if (maze[0][cont].equals("1") || maze[0][cont].equals("2") || maze[0][cont].equals("3") || maze[0][cont].equals("4") || maze[0][cont].equals("5") || maze[0][cont].equals("6")) {
                if(!ini.equals(ini))
                    return "Célula: 1" + (cont + 1);
            }
            if (maze[cont][0].equals("2") || maze[cont][0].equals("4") || maze[cont][0].equals("6") || maze[cont][0].equals("8") || maze[cont][0].equals("a") || maze[cont][0].equals("c")) {
                if(!ini.equals(ini))
                    return "Célula: " + (cont + 1) + "1";
            }
            cont++;
        }
        return "Sem saída";
    }
    
    static String[][] loadMatrix() throws FileNotFoundException, IOException {
        String[][] matrix = null;
        int cont = 0;
        try (BufferedReader in = new BufferedReader(new FileReader("src/t2-casos/caso500a.txt"))) {
            String str;
            while ((str = in.readLine()) != null) {
                String [] sep = str.split(" ");
                if(cont == 0){
                    int tam = Integer.parseInt(sep[0]);
                    matrix = new String[tam][tam];
                }else{
                    for(int i=0; i<sep.length; i++){
                        matrix[cont-1][i] = sep[i];
                    }
                }
                cont++;
            }
        }
        return matrix;
    }
}
