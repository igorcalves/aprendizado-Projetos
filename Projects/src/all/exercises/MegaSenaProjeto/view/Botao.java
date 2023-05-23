package all.exercises.MegaSenaProjeto.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;

import all.exercises.MegaSenaProjeto.modelo.Memoria;
import all.services.MegaSenaService;

public class Botao extends JButton {

    
    public Botao(String texto, Color cor, JLabel componente,MegaSenaService service) {
        setText(texto);
        setBackground(cor);
        setFont(new Font("courier", Font.PLAIN, 12));
        setForeground(Color.BLACK);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        addActionListener(new ActionListener() {
            
        @Override
        public void actionPerformed(ActionEvent e) {
            service.sortear();
            componente.setText(service.getNumerosSorteadosMaquinaString());
        }
        });
    }

public Botao(String texto, Color cor,MegaSenaService service) {
    setText(texto);
    setBackground(cor);
    setFont(new Font("courier", Font.PLAIN, 12));
    setForeground(Color.BLACK);
    setBorder(BorderFactory.createLineBorder(Color.BLACK));
    addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            service.jogar();
        }
    });
}
}

