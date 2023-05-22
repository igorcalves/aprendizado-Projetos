package all.services;

import java.util.Random;
import java.util.Scanner;
/*
author: Igor alves
date: 21/05
version: 1.0

description:
this code are responsive for create a array[][] with entry values before fill this array with random values, entry with a especific position m,n and for each occurrence
on this value locate in m,n they print your neighbor up,down,left and right.
create array:
    functions - writeMatrizSizeMN(): the user entry with values M,N for create one array with the rize M,N 
    firt they instance the scanner for entry values in type String, use my class validations with methods especifics for 
    validate data input and to make sure they are INT type numbers, before all validate set values M,N in variables mFormated,NFormated,
    last line of the method create a array[mFormated][nFormated].
    functions - populateMatriz(): with array[mFormated][Nformated] they use iterator and for each position m,n entry with random value
    functions - matrizComplete(): with the matriz complete and fill print each position m,n in console. 
    functions - writePositionOnMatrizMN(): he user entry with values M,N for set a especific position in matriz and use my class validations for validade user data input
    with values validate set values in nPositionFormated and MpositionFormated.
    functions - instancePositionXY() it traverses the entire array and then looks for occurrences of values ​​allocated in position mFormated and nFormated and for each 
    value found within the array the function getNeighborXY() is called.
    functions getNeighborXY() - receives as argument the position m and n that corresponds to the value of i and j of the loop, uses this position to determine that the 
    value allocated there is equal to the value determined by the user then starts 4 validations to verify if its neighbors from up, down, right and left are valid and 
    existing through the Boolean method validPositionInMatriz(int matrix[][],int m,int n) if the method is true it prints on the console according to its position, finally 
    the value of 1 is added to the variable countInstances so that show how many times that number was found within the array.

     */


public class MatrizService {
    private Scanner sc = new Scanner(System.in);
    private Random random = new Random();

    private int mFormarted = 0;
    private int nFormated = 0;

    private int mPositionFormated = 0;
    private int nPositionFormated = 0;

    private int matriz[][];

    private int posUP = 0;
    private int posDown = 0;
    private int posLeft = 0;
    private int posRight = 0;
    private int countInstances = 1;
    
/*
Create the entire process: create an array and fill it with random values, find all neighboring positions above, below, left, right and print each occurrence to the 
console with its neighbor
*/
    public void atomicCreateMatrizAndPopulateAndRegistred(){
        createMatrizMN();
        instancePositionXY();
    }
    
    private void createMatrizMN(){
        if(matriz == null){
            writeMatrizSizeMN();
        }
        populateMatriz();
        matrizComplete();
        writePositiOnMatrizMN();
    
    sc.close();
    }

    private void writeMatrizSizeMN(){
        System.out.print("Digite o valor de M: ");
            String m = sc.nextLine();
            System.out.print("Digite o valor de N: ");
            String n = sc.nextLine();
            if(validations.IsValidNumeric(m) && validations.IsValidNumeric(n)){
                mFormarted = Integer.parseInt(m);
                nFormated = Integer.parseInt(n);
            }else {
                System.out.println("Valores invalidos certifique de que os valores sejam numeros inteiros:");
                createMatrizMN();
            }
            matriz = new int [mFormarted][nFormated];
    }

    private void writePositiOnMatrizMN(){
        System.out.println();
        System.out.print("Digite o valor da posição M: ");
        String mP = sc.nextLine();
        System.out.print("Digite o valor da posição N: ");
        String nP = sc.nextLine();

        if(validations.IsValidNumeric(mP) && validations.IsValidNumeric(nP)){
            mPositionFormated = Integer.parseInt(mP);
            nPositionFormated = Integer.parseInt(nP);
        }else {
            System.out.println("\nValores de posição invalidos certifique-se que:\n" +
            "que os valores sejam numeros inteiros\n"+
            "os valores devem conter em uma matriz = " + mFormarted + " por " + nFormated);
            createMatrizMN();
        }
        if(!validations.validPositionInMatriz(matriz, mPositionFormated, nPositionFormated)){
            System.out.println("posição invalida!!!!");
            createMatrizMN();
        }
    }

    private void populateMatriz(){
        for (int i = 0; i <mFormarted ; i++) { 
            for(int j = 0; j <nFormated; j++){ 
                matriz[i][j] = random.nextInt(10,99);
            }
        }

    }

    private void matrizComplete(){
        System.out.print("  " );
        for (int i = 0; i < matriz[0].length; i++) {
            if(i <10){
                System.out.print(+ i +"  ");
            }else{
                System.out.print(+ i +" ");
            }
        }
        for (int i = 0; i <mFormarted ; i++) { 
            System.out.println();
            System.out.print(i + " ");
            for(int j = 0; j <nFormated; j++){
                System.out.print(matriz[i][j] + " ");
            }
        }

    }

    
    public void instancePositionXY(){
        for (int i = 0; i <mFormarted ; i++) { 
            for(int j = 0; j <nFormated; j++){ 
                 if(matriz[i][j] == matriz[mPositionFormated][nPositionFormated]){
                    getNeighborXY(i, j);
                 }
            }
        }

    }
    // left right up down instances
    public void getNeighborXY(int m, int n){

        System.out.println(countInstances + "°" + "instancia do numero: " + matriz[m][n] + " na posição: " + m +","+n);
        if(validations.validPositionInMatriz(matriz, m -1, n)){
            posUP = matriz[m -1][n];
            System.out.println("position Up: " + posUP);
        } 
        if(validations.validPositionInMatriz(matriz, m +1, n)){
            posDown = matriz[m+1][n];
            System.out.println("position Down: "+ posDown );
        } 
        if(validations.validPositionInMatriz(matriz, m, n -1)){
            posLeft = matriz[m][n-1];
            System.out.println("position Left: " + posLeft);
        } 
        if(validations.validPositionInMatriz(matriz, m, n +1)){
            posRight = matriz[m][n+1];
            System.out.println("position Right: " + posRight);
        } 

    
        countInstances ++;
    }



    
}
