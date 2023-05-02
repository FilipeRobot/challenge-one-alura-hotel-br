package com.github.FilipeRobot.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class MenuPrincipal extends JFrame {

    private JPanel contentPane;
    private JLabel labelExit;
    int xMouse, yMouse;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MenuPrincipal frame = new MenuPrincipal();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public MenuPrincipal() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/img/aH-40px.png")));
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, 910, 537);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setUndecorated(true);

        Panel panel = new Panel();
        panel.setBackground(SystemColor.window);
        panel.setBounds(0, 0, 910, 537);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel imagenFondo = new JLabel("");
        imagenFondo.setBounds(-50, 0, 732, 501);
        imagenFondo.setIcon(new ImageIcon(
                Objects.requireNonNull(
                        MenuPrincipal.class.getResource("/img/menu-img.png")
                )
        ));
        panel.add(imagenFondo);

        JLabel logo = new JLabel("");
        logo.setBounds(722, 80, 150, 156);
        logo.setIcon(new ImageIcon(
                Objects.requireNonNull(
                        MenuPrincipal.class.getResource("/img/aH-150px.png")
                )
        ));
        panel.add(logo);

        JPanel footer = new JPanel();
        footer.setBounds(0, 500, 910, 37);
        footer.setBackground(new Color(12, 138, 199));
        panel.add(footer);
        footer.setLayout(null);

        JLabel lblCopyR = new JLabel("Desenvolvido por Filipe lemos © 2023");
        lblCopyR.setBounds(315, 11, 301, 19);
        lblCopyR.setForeground(new Color(240, 248, 255));
        lblCopyR.setFont(new Font("Roboto", Font.PLAIN, 16));
        footer.add(lblCopyR);

        //Barra superior da tela, para mover e fechar a janela
        JPanel header = new JPanel();
        header.setBounds(0, 0, 910, 36);
        header.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                headerMouseDragged(e);
            }
        });
        header.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                headerMousePressed(e);
            }
        });
        header.setLayout(null);
        header.setBackground(Color.WHITE);
        panel.add(header);

        //Botão sair
        JPanel btnexit = new JPanel();
        btnexit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                fechar(e);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                btnexit.setBackground(Color.red);
                labelExit.setForeground(Color.white);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnexit.setBackground(Color.white);
                labelExit.setForeground(Color.black);
            }
        });
        btnexit.setLayout(null);
        btnexit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnexit.setBackground(Color.WHITE);
        btnexit.setBounds(857, 0, 53, 36);
        header.add(btnexit);

        labelExit = new JLabel("X");
        labelExit.setBounds(0, 0, 53, 36);
        btnexit.add(labelExit);
        labelExit.setHorizontalAlignment(SwingConstants.CENTER);
        labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));

        //Botão Login
        JPanel btnLogin = new JPanel();
        btnLogin.setBounds(684, 291, 80, 70);
        btnLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Login login = new Login();
                    login.setVisible(true);
                    dispose();
                } catch (RuntimeException exception) {
                    JOptionPane.showMessageDialog(
                            null,
                            exception.getMessage(),
                            "ERRO",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });
        btnLogin.setLayout(null);
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.setBackground(SystemColor.window);
        panel.add(btnLogin);

        JLabel imageLogin = new JLabel("");
        imageLogin.setBounds(0, 0, 80, 70);
        btnLogin.add(imageLogin);
        imageLogin.setHorizontalAlignment(SwingConstants.CENTER);
        imageLogin.setIcon(new ImageIcon(Objects.requireNonNull(MenuPrincipal.class.getResource("/img/login.png"))));

        JLabel lblLogin = new JLabel("LOGIN");
        lblLogin.setBounds(680, 265, 83, 24);
        lblLogin.setBackground(SystemColor.window);
        panel.add(lblLogin);
        lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogin.setForeground(SystemColor.textHighlight);
        lblLogin.setFont(new Font("Roboto Light", Font.PLAIN, 20));

        // Botao Cadastrar
        JPanel btnCadastrar = new JPanel();
        btnCadastrar.setBounds(799, 291, 80, 70);
        btnCadastrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    CadastrarUsuario cadastrar = new CadastrarUsuario();
                    cadastrar.setVisible(true);
                } catch (RuntimeException exception) {
                    JOptionPane.showMessageDialog(
                            null,
                            exception.getMessage(),
                            "ERRO",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });
        btnCadastrar.setLayout(null);
        btnCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadastrar.setBackground(SystemColor.window);
        panel.add(btnCadastrar);

        JLabel imageCadastrar = new JLabel("");
        imageCadastrar.setBounds(0, 0, 80, 70);
        btnCadastrar.add(imageCadastrar);
        imageCadastrar.setHorizontalAlignment(SwingConstants.CENTER);
        imageCadastrar.setIcon(new ImageIcon(Objects.requireNonNull(MenuPrincipal.class.getResource("/img/cadastro.png"))));

        JLabel lblCadastrar = new JLabel("CADASTRAR");
        lblCadastrar.setBounds(773, 265, 127, 24);
        lblCadastrar.setBackground(SystemColor.window);
        panel.add(lblCadastrar);
        lblCadastrar.setHorizontalAlignment(SwingConstants.CENTER);
        lblCadastrar.setForeground(SystemColor.textHighlight);
        lblCadastrar.setFont(new Font("Roboto Light", Font.PLAIN, 20));
    }

    private void fechar(MouseEvent evt) {
        int sair = JOptionPane.showConfirmDialog(
                this,
                "Deseja fechar a aplicação?",
                "Sair",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE
        );

        if (sair == 0) {
            System.exit(0);
        }
    }

    //Código que permite movimentar a janela pela tela seguindo a posição de "x" e "y"
    private void headerMousePressed(MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }

    private void headerMouseDragged(MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }
}
