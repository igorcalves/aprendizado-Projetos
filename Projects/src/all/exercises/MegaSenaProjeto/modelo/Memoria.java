package all.exercises.MegaSenaProjeto.modelo;

import java.util.ArrayList;
import java.util.List;

public class Memoria {

    private static final Memoria intancia = new Memoria();
    
    private String textoAtual = "0";

    private final List<MemoriaObservador> observadores = new ArrayList<>();

    public static Memoria getIntancia() {
        return intancia;
    }

    public Memoria() {
    }

    public void adicionarObservador(MemoriaObservador observador) {
        observadores.add(observador);

    }

    public String getTextoAtual() {
        return textoAtual.isEmpty() ? "0" : textoAtual;
    }

    public void processarComando(String texto) {
        textoAtual = texto;
        observadores.forEach(o -> o.ValorAlterado(getTextoAtual()));
    }

}
