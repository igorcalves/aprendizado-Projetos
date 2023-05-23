package all.services;

import java.util.Random;

import all.exercises.MegaSenaProjeto.modelo.Memoria;




public class MegaSenaService {


    private Random random = new Random();
    private int numerosSorteadosMaquina[] = new int [6];
    private int numerosSorteadosJogador[] = new int [6];
    public  int tentativas = 0;
    private double preco = 0;
    private boolean ganhou = false;

    

    private void sortearNumeros(int numerosSorteados[]){
        int i =0;
        while (i < numerosSorteados.length) {
            int numeroSorteado = random.nextInt(1, 60);
            if (validations.repeatedNumbers(numerosSorteados, numeroSorteado)) {
                numerosSorteados[i] = numeroSorteado;
                i++;
            }
        }
    }

    public void jogar(){
        sortearNumeros(numerosSorteadosJogador);
        if(numerosSorteadosMaquina[1] ==0){
            sortearNumeros(numerosSorteadosMaquina);
            compararNumeros(numerosSorteadosMaquina, numerosSorteadosJogador);
        }else{
            loopSeletivo(numerosSorteadosMaquina);
        compararNumeros(numerosSorteadosMaquina, numerosSorteadosJogador);
       }

       }

    public void sortear(){
        sortearNumeros(numerosSorteadosMaquina);
    }

    
    private void compararNumeros(int vetorMaquina[], int vetorJogador[]) {     
        while (!ganhou) {
            sortearNumeros(numerosSorteadosJogador);
            tentativas++;
            Memoria.getIntancia().processarComando(Integer.toString(tentativas));
            preco +=5;
            int numerosCorrespondentes = validations.countMatchingNumbers(vetorMaquina, vetorJogador);
            if(numerosCorrespondentes >=4){
                System.out.println("Tentativa: " + tentativas);
                System.out.print("Números Sorteados da Mega Sena: ");
                loopSeletivo(numerosSorteadosMaquina);
                System.out.print("Números Jogados: ");
                loopSeletivo(numerosSorteadosJogador);
                System.out.println("Números correspondentes: " + numerosCorrespondentes);
            }
            if (numerosCorrespondentes == 6) {
                ganhou = true;
            }
        }
        
        System.out.println("Ganhou!");
        System.out.println("Gastou " + preco + " reais");
    }   
    
    
    
    private void loopSeletivo(int numerosSorteados[]){
        for (int i = 0; i < numerosSorteados.length; i++) {
            System.out.print(numerosSorteados[i]+ " ");
        }
    }

    public String getNumerosSorteadosMaquinaString(){
        String numerosMaquina = "";
        for (int i = 0; i < numerosSorteadosMaquina.length; i++) {
            numerosMaquina += numerosSorteadosMaquina[i]+ " ";
        }
        return numerosMaquina;
    }
    
    public String getTentativas() {
        tentativas++;
        return Integer.toString(tentativas);
    }

    public double getPreco() {
        return preco;
    }



}
