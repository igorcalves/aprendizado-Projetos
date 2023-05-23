package all.exercises.MegaSenaProjeto.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.Font;


public class TelaVitoria   {
    private JFrame frame;
    private JLabel label;

    public TelaVitoria() {
        frame = new JFrame("Tela de Vitória");
        frame.setSize(170, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setUndecorated(true);

        label = new JLabel("Você gastou:");
        label.setBounds(0, 10, 170, 30);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 12));
        frame.add(label);

        JButton button = new Botao("OK", Color.white, frame);
        button.setBounds(50, 50, 70, 30);

        frame.add(button);

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public void atualizarValor(String valor) {
        label.setText("Você gastou: " + valor + "Reais");
    }

}
