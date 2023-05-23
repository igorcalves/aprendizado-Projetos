package all.exercises.MegaSenaProjeto.view;
import javax.swing.*;


import all.services.MegaSenaService;

import java.awt.*;


public class MegaSenaTela extends JFrame {
    private JLabel labelTitulo;
    private JButton buttonSorteio;
    private JLabel labelNumeroSorteio;
    private JLabel labelTentativas;
    private JLabel labelNumeroJogador;
    private JButton buttonJogar;



    MegaSenaService service = new MegaSenaService();

    public MegaSenaTela(MegaSenaService service) {
        
        // Configurações da janela principal
        setTitle("Mega-Sena");
        setSize(300, 300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());



        // Criação do painel principal com BoxLayout na orientação vertical
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBackground(new Color(50, 50, 50));
        add(panelPrincipal, BorderLayout.CENTER);

        // Criação dos componentes da primeira linha
        labelTitulo = new JLabel("MEGA SENA");
        labelTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelTitulo.setForeground(Color.BLACK);
        panelPrincipal.add(labelTitulo);

        // Criação dos componentes da segunda linha
        JPanel panelSorteio = new JPanel();
        panelSorteio.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel  displayNSorteio =  new Labels("0",Color.white);
        buttonSorteio = new Botao("Sortear", Color.green,displayNSorteio,service);
        
        labelNumeroSorteio = new Labels("N° Sorteio: ");

    

        panelSorteio.add(buttonSorteio);
        panelSorteio.add(labelNumeroSorteio);
        panelSorteio.add(displayNSorteio);
        panelSorteio.setBackground(new Color(50, 50, 50));
        panelPrincipal.add(panelSorteio);

        // Criação dos componentes da terceira linha
        JPanel panelTentativas = new JPanel();
        panelTentativas.setLayout(new FlowLayout(FlowLayout.CENTER));
        labelTentativas = new Labels("Tentativas: ");

        JPanel DisplayTentativas = new DisplayTentativas();

        panelTentativas.add(labelTentativas);
        panelTentativas.add(DisplayTentativas);
        panelTentativas.setBackground(new Color(50, 50, 50));
        panelPrincipal.add(panelTentativas);

        // Criação dos componentes da quarta linha
        JPanel panelNumeroJogador = new JPanel();
        panelNumeroJogador.setLayout(new FlowLayout(FlowLayout.CENTER));
        labelNumeroJogador = new Labels("N° Jogador: ");
        JPanel labelValorNumeroJogador = new DisplayJogador();

        panelNumeroJogador.add(labelNumeroJogador);
        panelNumeroJogador.add(labelValorNumeroJogador);
        panelNumeroJogador.setBackground(new Color(50, 50, 50));
        panelPrincipal.add(panelNumeroJogador);

        // Criação dos componentes da quinta linha
        JPanel panelJogar = new JPanel();
        panelJogar.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonJogar = new Botao("Jogar", Color.green,service,displayNSorteio);
        panelJogar.add(buttonJogar);
        panelJogar.setBackground(new Color(50, 50, 50));
        panelPrincipal.add(panelJogar);

        // Centraliza o painel principal na janela
        add(Box.createVerticalGlue(), BorderLayout.NORTH);
        add(Box.createVerticalGlue(), BorderLayout.SOUTH);
        add(Box.createHorizontalGlue(), BorderLayout.WEST);
        add(Box.createHorizontalGlue(), BorderLayout.EAST);

        // Exibe a janela
        setVisible(true);
        setLocationRelativeTo(null);

        
    }




    
    
}


