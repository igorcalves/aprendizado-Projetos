package all.exercises.MegaSenaProjeto.view;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;


import all.exercises.MegaSenaProjeto.modelo.Memoria;
import all.exercises.MegaSenaProjeto.modelo.MemoriaObservador;

public class DisplayTentativas extends JPanel implements MemoriaObservador {

    private JLabel label;

    public DisplayTentativas(){
        Memoria.getIntancia().adicionarObservador(this);

        setBackground(new Color(50, 50, 50));
        label = new JLabel(Memoria.getIntancia().getTextoAtual());
        label.setForeground(Color.white);
        label.setFont(new Font("courier", Font.PLAIN, 12));
        setBorder(BorderFactory.createLineBorder(Color.black));


        add(label);

        }

    @Override
    public void ValorAlteradoDisplayTentativas(String novoValor) {
        label.setText(novoValor);
    }

    @Override
    public void ValorAlteradoDisplayJogador(String novoValor) {}
    
}
