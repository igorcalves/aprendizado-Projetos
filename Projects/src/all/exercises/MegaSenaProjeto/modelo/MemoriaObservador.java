package all.exercises.MegaSenaProjeto.modelo;

@FunctionalInterface
public interface MemoriaObservador {
    
    public void ValorAlterado(String novoValor);
}