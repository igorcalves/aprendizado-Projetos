package all.services;

import java.util.Random;

import all.exercises.MegaSenaProjeto.modelo.Memoria;
import all.exercises.MegaSenaProjeto.view.TelaVitoria;




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

        if(validations.checkarArrayVazio(numerosSorteadosMaquina)){
            sortearNumeros(numerosSorteadosMaquina);
            compararNumeros(numerosSorteadosMaquina, numerosSorteadosJogador);
        }else compararNumeros(numerosSorteadosMaquina, numerosSorteadosJogador);
       }

    public void sortear(){
        sortearNumeros(numerosSorteadosMaquina);
    }

    
    private void compararNumeros(int vetorMaquina[], int vetorJogador[]) {     
        while (!ganhou) {
            sortearNumeros(numerosSorteadosJogador);
            tentativas++;
            preco +=5;
            int numerosCorrespondentes = validations.countMatchingNumbers(vetorMaquina, vetorJogador);

            if (numerosCorrespondentes == 6) {
                Memoria.getIntancia().processarComando(Integer.toString(tentativas),true);
                Memoria.getIntancia().processarComando(getNumerosSorteadosJogadorString(),false);
                ganhou = true;
            }
        }
        TelaVitoria telaVitoria = new TelaVitoria();
        telaVitoria.atualizarValor(Double.toString(preco));
        ganhou = false ;
    }   
    

    public String getNumerosSorteadosMaquinaString(){
        String numerosMaquina = "";
        for (int i = 0; i < numerosSorteadosMaquina.length; i++) {
            numerosMaquina += numerosSorteadosMaquina[i]+ " ";
        }
        return numerosMaquina;
    }

    public String getNumerosSorteadosJogadorString(){
        String numeroJogador = "";
        for (int i = 0; i < numerosSorteadosJogador.length; i++) {
            numeroJogador += numerosSorteadosJogador[i]+ " ";
        }
        return numeroJogador;
    }
    
    public String getTentativas() {
        tentativas++;
        return Integer.toString(tentativas);
    }

    public double getPreco() {
        return preco;
    }

    public int[] getNumerosSorteadosMaquina() {
        return numerosSorteadosMaquina;
    }


}
