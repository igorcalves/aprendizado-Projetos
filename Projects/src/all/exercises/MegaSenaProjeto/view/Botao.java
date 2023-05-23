package all.exercises.MegaSenaProjeto.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import all.services.MegaSenaService;
import all.services.validations;

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

public Botao(String texto, Color cor,MegaSenaService service,JLabel componente) {
    setText(texto);
    setBackground(cor);
    setFont(new Font("courier", Font.PLAIN, 12));
    setForeground(Color.BLACK);
    setBorder(BorderFactory.createLineBorder(Color.BLACK));
    addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(validations.checkarArrayVazio(service.getNumerosSorteadosMaquina())){
                service.sortear();
                componente.setText(service.getNumerosSorteadosMaquinaString());
                service.jogar();
            }else {
                componente.setText(service.getNumerosSorteadosMaquinaString());
                service.jogar();

            }
        }
    });
}

public Botao(String texto, Color cor,JFrame frame) {
    setText(texto);
    setBackground(cor);
    setFont(new Font("courier", Font.PLAIN, 12));
    setForeground(Color.BLACK);
    setBorder(BorderFactory.createLineBorder(Color.BLACK));
    addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
        }
    });
}
}

