package all.exercises.MegaSenaProjeto.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class Labels extends JLabel{

    public Labels(String texto){
        setText(texto);
        setForeground(Color.GREEN);
        setFont(new Font("courier", Font.PLAIN, 12));

    }
    public Labels(String texto,Color color){
        setText(texto);
        setForeground(color);
        setFont(new Font("courier", Font.PLAIN, 12));

    }
}
