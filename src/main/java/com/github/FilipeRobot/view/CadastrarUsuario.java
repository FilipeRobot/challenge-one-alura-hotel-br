package com.github.FilipeRobot.view;

import com.github.FilipeRobot.controller.HotelController;
import com.github.FilipeRobot.model.DTO.DadosUsuario;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class CadastrarUsuario extends JFrame {
    private JPanel contentPane;
    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JPasswordField txtConfirmarSenha;
    int xMouse, yMouse;
    private JLabel labelExit;
    private final HotelController hotelController;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CadastrarUsuario frame = new CadastrarUsuario();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public CadastrarUsuario() {
        setResizable(false);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 420, 527);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);


        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 420, 527);
        panel.setBackground(Color.WHITE);
        contentPane.add(panel);
        panel.setLayout(null);

        JPanel btnexit = new JPanel();
        btnexit.setBounds(367, 0, 53, 36);
        panel.add(btnexit);
        btnexit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                btnexit.setBackground(Color.red);
                labelExit.setForeground(Color.white);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnexit.setBackground(new Color(12, 138, 199));
                labelExit.setForeground(Color.white);
            }
        });
        btnexit.setBackground(new Color(12, 138, 199));
        btnexit.setLayout(null);
        btnexit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        labelExit = new JLabel("X");
        labelExit.setBounds(0, 0, 53, 36);
        btnexit.add(labelExit);
        labelExit.setForeground(SystemColor.text);
        labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
        labelExit.setHorizontalAlignment(SwingConstants.CENTER);

        txtUsuario = new JTextField();
        txtUsuario.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (txtUsuario.getText().equals("Digite seu nome de usuário")) {
                    txtUsuario.setText("");
                    txtUsuario.setForeground(Color.black);
                }
                if (String.valueOf(txtSenha.getPassword()).isEmpty()) {
                    txtSenha.setText("********");
                    txtSenha.setForeground(Color.gray);
                }
            }
        });
        txtUsuario.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtUsuario.setText("Digite seu nome de usuário");
        txtUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        txtUsuario.setForeground(SystemColor.activeCaptionBorder);
        txtUsuario.setBounds(65, 139, 324, 32);
        panel.add(txtUsuario);
        txtUsuario.setColumns(10);

        JSeparator separator = new JSeparator();
        separator.setBackground(new Color(0, 120, 215));
        separator.setBounds(65, 175, 324, 2);
        panel.add(separator);

        JLabel labelTitulo = new JLabel("CADASTRO");
        labelTitulo.setForeground(SystemColor.textHighlight);
        labelTitulo.setFont(new Font("Roboto Black", Font.PLAIN, 26));
        labelTitulo.setBounds(140, 65, 155, 26);
        panel.add(labelTitulo);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBackground(SystemColor.textHighlight);
        separator_1.setBounds(65, 276, 324, 2);
        panel.add(separator_1);

        txtSenha = new JPasswordField();
        txtSenha.setText("********");
        txtSenha.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (String.valueOf(txtSenha.getPassword()).equals("********")) {
                    txtSenha.setText("");
                    txtSenha.setForeground(Color.black);
                }
                if (txtUsuario.getText().isEmpty()) {
                    txtUsuario.setText("Digite seu nome de usuário");
                    txtUsuario.setForeground(Color.gray);
                }
            }
        });
        txtSenha.setForeground(SystemColor.activeCaptionBorder);
        txtSenha.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtSenha.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        txtSenha.setBounds(65, 236, 324, 32);
        panel.add(txtSenha);

        txtConfirmarSenha = new JPasswordField();
        txtConfirmarSenha.setText("********");
        txtConfirmarSenha.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (String.valueOf(txtConfirmarSenha.getPassword()).equals("********")) {
                    txtConfirmarSenha.setText("");
                    txtConfirmarSenha.setForeground(Color.black);
                }
                if (txtUsuario.getText().isEmpty()) {
                    txtUsuario.setText("Digite seu nome de usuário");
                    txtUsuario.setForeground(Color.gray);
                }
            }
        });
        txtConfirmarSenha.setForeground(SystemColor.activeCaptionBorder);
        txtConfirmarSenha.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtConfirmarSenha.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        txtConfirmarSenha.setBounds(65, 336, 324, 32);
        panel.add(txtConfirmarSenha);
        
        JLabel LabelUsuario = new JLabel("USUÁRIO");
        LabelUsuario.setForeground(SystemColor.textInactiveText);
        LabelUsuario.setFont(new Font("Roboto Black", Font.PLAIN, 20));
        LabelUsuario.setBounds(65, 102, 107, 26);
        panel.add(LabelUsuario);

        JLabel lblSenha = new JLabel("SENHA");
        lblSenha.setForeground(SystemColor.textInactiveText);
        lblSenha.setFont(new Font("Roboto Black", Font.PLAIN, 20));
        lblSenha.setBounds(65, 199, 140, 26);
        panel.add(lblSenha);
        
        JLabel lblConfirmarSenha = new JLabel("CONFIRMAR SENHA");
        lblConfirmarSenha.setForeground(SystemColor.textInactiveText);
        lblConfirmarSenha.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblConfirmarSenha.setBounds(65, 299, 200, 26);
        panel.add(lblConfirmarSenha);

        JPanel btnCadastrar = new JPanel();
        btnCadastrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnCadastrar.setBackground(new Color(0, 156, 223));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnCadastrar.setBackground(SystemColor.textHighlight);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                cadastrar();
            }
        });
        btnCadastrar.setBackground(SystemColor.textHighlight);
        btnCadastrar.setBounds(65, 431, 140, 44);
        panel.add(btnCadastrar);
        btnCadastrar.setLayout(null);
        btnCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        JLabel lblCadastrar = new JLabel("CADASTRAR");
        lblCadastrar.setBounds(0, 0, 140, 44);
        btnCadastrar.add(lblCadastrar);
        lblCadastrar.setForeground(SystemColor.controlLtHighlight);
        lblCadastrar.setHorizontalAlignment(SwingConstants.CENTER);
        lblCadastrar.setFont(new Font("Roboto", Font.PLAIN, 18));

        JSeparator separator_2 = new JSeparator();
        separator_2.setBackground(SystemColor.textHighlight);
        separator_2.setBounds(65, 379, 324, 2);
        panel.add(separator_2);

        JPanel header = new JPanel();
        header.setBackground(new Color(12, 138, 199));
        header.setBounds(0, 0, 420, 36);
        panel.add(header);
        header.setLayout(null);
        hotelController = new HotelController();
    }

    private void cadastrar() {
        String senhaInformada = new String (txtSenha.getPassword());
        String senhaConfirmacaoInformada = new String(txtConfirmarSenha.getPassword());
        String loginInformado = txtUsuario.getText().trim();

        try {
            hotelController.cadastrar(new DadosUsuario(loginInformado, senhaInformada), senhaConfirmacaoInformada);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
}
