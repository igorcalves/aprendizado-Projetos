package all.services;

import java.util.Random;

public class MegaSenaService {
    private Random random = new Random();
    private int numerosSorteadosMaquina[] = {35,54,2,44,52,53};
    private int numerosSorteadosJogador[] = new int [6];
    

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
        compararNumeros(numerosSorteadosMaquina, numerosSorteadosJogador);
        
    }

    
    private void compararNumeros(int vetorMaquina[], int vetorJogador[]) {
        int tentativas = 0;
        boolean ganhou = false;
        
        while (!ganhou) {
            sortearNumeros(numerosSorteadosJogador);
            tentativas++;
            System.out.println("Tentativa: " + tentativas);
            System.out.print("Números Sorteados da Mega Sena: ");
            loopSeletivo(numerosSorteadosMaquina);
            System.out.print("Números Jogados: ");
            loopSeletivo(numerosSorteadosJogador);
            int numerosCorrespondentes = validations.countMatchingNumbers(vetorMaquina, vetorJogador);
            System.out.println("Números correspondentes: " + numerosCorrespondentes);
            if (numerosCorrespondentes == 6) {
                ganhou = true;
            }
        }
        
        System.out.println("Ganhou!");
    }
    
    
    
    private void loopSeletivo(int numerosSorteados[]){
        for (int i = 0; i < numerosSorteados.length; i++) {
            System.out.print(numerosSorteados[i]+ " ");
        }
    }
    
    
}
