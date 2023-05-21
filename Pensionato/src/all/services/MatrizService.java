package all.services;

import java.util.Random;
import java.util.Scanner;



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

 
    public void atomicCreateMatrizAndPopulateAndRegistred(){
        createMatrizMN();
        instancePositionXY();

        
    }
    
    private void createMatrizMN(){
        if(matriz == null){
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
        populateMatriz();
        matrizComplete();
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
    
    sc.close();
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

    public int countMatriz(){
        int count = 0;
        for (int i = 0; i <mFormarted ; i++) { 
            for(int j = 0; j <nFormated; j++){
                if(matriz[i][j] == matriz[mPositionFormated][nPositionFormated]) count ++;
            }
        }
        return count;
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
