package com.github.FilipeRobot.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.Serial;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class MenuUsuario extends JFrame {
    @Serial
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    int xMouse, yMouse;
    private JLabel labelExit;
    private JLabel labelRegistro;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MenuUsuario frame = new MenuUsuario();
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
    public MenuUsuario() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(MenuUsuario.class.getResource("/img/aH-40px.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 944, 609);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setUndecorated(true);

        JPanel header = new JPanel();
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

        JPanel panelMenu = new JPanel();
        panelMenu.setBackground(new Color(12, 138, 199));
        panelMenu.setBounds(0, 0, 257, 609);
        contentPane.add(panelMenu);
        panelMenu.setLayout(null);

        JPanel btnBuscar = new JPanel();
        btnBuscar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnBuscar.setBackground(new Color(118, 187, 223));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnBuscar.setBackground(new Color(12, 138, 199));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                Buscar buscar = new Buscar();
                buscar.setVisible(true);
                dispose();
            }
        });

        btnBuscar.setBounds(0, 312, 257, 56);
        btnBuscar.setBackground(new Color(12, 138, 199));
        btnBuscar.setLayout(null);
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelMenu.add(btnBuscar);

        JLabel lblBusquedaDeReservas = new JLabel("Buscar");
        lblBusquedaDeReservas.setIcon(new ImageIcon(Objects.requireNonNull(MenuUsuario.class.getResource("/img/pessoas.png"))));
        lblBusquedaDeReservas.setBounds(30, 11, 200, 34);
        lblBusquedaDeReservas.setHorizontalAlignment(SwingConstants.LEFT);
        lblBusquedaDeReservas.setForeground(Color.WHITE);
        lblBusquedaDeReservas.setFont(new Font("Roboto", Font.PLAIN, 18));
        btnBuscar.add(lblBusquedaDeReservas);

        JLabel logo = new JLabel("");
        logo.setBounds(50, 58, 150, 150);
        panelMenu.add(logo);
        logo.setIcon(new ImageIcon(Objects.requireNonNull(MenuUsuario.class.getResource("/img/aH-150px.png"))));

        JPanel btnRegistro = new JPanel();
        btnRegistro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnRegistro.setBackground(new Color(118, 187, 223));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnRegistro.setBackground(new Color(12, 138, 199));
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                ReservasView reservas = new ReservasView();
                reservas.setVisible(true);
                dispose();
            }
        });
        btnRegistro.setBounds(0, 255, 257, 56);
        btnRegistro.setBackground(new Color(12, 138, 199));
        panelMenu.add(btnRegistro);
        btnRegistro.setLayout(null);
        btnRegistro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        labelRegistro = new JLabel("Registro de reservas");
        labelRegistro.setIcon(new ImageIcon(Objects.requireNonNull(MenuUsuario.class.getResource("/img/reservado.png"))));
        labelRegistro.setForeground(SystemColor.text);
        labelRegistro.setBounds(25, 11, 205, 34);
        labelRegistro.setFont(new Font("Roboto", Font.PLAIN, 18));
        labelRegistro.setHorizontalAlignment(SwingConstants.LEFT);
        btnRegistro.add(labelRegistro);

        JSeparator separator = new JSeparator();
        separator.setBounds(26, 219, 201, 2);
        panelMenu.add(separator);
        header.setLayout(null);
        header.setBackground(Color.WHITE);
        header.setBounds(0, 0, 944, 36);
        contentPane.add(header);

        JPanel btnexit = new JPanel();
        btnexit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Login login = new Login();
                login.setVisible(true);
                dispose();
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
        btnexit.setBackground(Color.WHITE);
        btnexit.setBounds(891, 0, 53, 36);
        header.add(btnexit);

        labelExit = new JLabel("X");
        labelExit.setBounds(0, 0, 53, 36);
        btnexit.add(labelExit);
        labelExit.setHorizontalAlignment(SwingConstants.CENTER);
        labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));

        JPanel panelData = new JPanel();
        panelData.setBackground(new Color(118, 187, 223));
        panelData.setBounds(256, 84, 688, 121);
        contentPane.add(panelData);
        panelData.setLayout(null);

        JLabel lblTituloPrincipal = new JLabel("Sistema de reservas Hotel Alura");
        lblTituloPrincipal.setBounds(180, 11, 356, 42);
        panelData.add(lblTituloPrincipal);
        lblTituloPrincipal.setForeground(Color.WHITE);
        lblTituloPrincipal.setFont(new Font("Roboto", Font.PLAIN, 24));

        JLabel labelData = new JLabel("New label");
        labelData.setBounds(35, 64, 494, 36);
        panelData.add(labelData);
        labelData.setForeground(Color.WHITE);
        labelData.setFont(new Font("Roboto", Font.PLAIN, 33));
        Date dataAtual = new Date(); //data atual
        String dataComHora = "dd/MM/yyyy '-' HH:mm";
        String dataSemHora = "dd/MM/yyyy";
        String fecha = new SimpleDateFormat(dataSemHora).format(dataAtual); //formata a data numa string
        labelData.setText("Hoje é " + fecha); //estabelece a data na label

        JLabel lbltitulo = new JLabel("Bem-vindo");
        lbltitulo.setFont(new Font("Roboto", Font.BOLD, 24));
        lbltitulo.setBounds(302, 234, 147, 46);
        contentPane.add(lbltitulo);

        String textoDescripcion = "<html><body>Sistema de reservas de hotéis. Controle e gerencie de forma otimizada e fácil <br> o fluxo de reservas e hóspedes do hotel   </body></html>";
        JLabel labelDescripcion_0 = new JLabel(textoDescripcion);
        labelDescripcion_0.setFont(new Font("Roboto", Font.PLAIN, 17));

        labelDescripcion_0.setBounds(312, 291, 598, 66);
        contentPane.add(labelDescripcion_0);

        String textoDescricao1 = "<html><body> Esta ferramenta permitirá que você mantenha um controle completo e detalhado de suas reservas e hóspedes, você terá acesso a ferramentas especiais para tarefas específicas como:</body></html>";
        JLabel labelDescricao_1 = new JLabel(textoDescricao1);
        labelDescricao_1.setFont(new Font("Roboto", Font.PLAIN, 17));
        labelDescricao_1.setBounds(311, 345, 569, 88);
        contentPane.add(labelDescricao_1);

        JLabel labelDescricao_2 = new JLabel("- Registro de Reservas e Hóspedes");
        labelDescricao_2.setFont(new Font("Roboto", Font.PLAIN, 17));
        labelDescricao_2.setBounds(312, 444, 295, 27);
        contentPane.add(labelDescricao_2);

        JLabel labelDescricao_3 = new JLabel("- Edição de Reservas e Hóspedes existentes");
        labelDescricao_3.setFont(new Font("Roboto", Font.PLAIN, 17));
        labelDescricao_3.setBounds(312, 482, 355, 27);
        contentPane.add(labelDescricao_3);

        JLabel labelDescricao_4 = new JLabel("- Excluir todos os tipos de registros");
        labelDescricao_4.setFont(new Font("Roboto", Font.PLAIN, 17));
        labelDescricao_4.setBounds(312, 520, 295, 27);
        contentPane.add(labelDescricao_4);
    }

    //Código que permite movimentar a janela pela tela seguindo a posição de "x" e "y"
    private void headerMousePressed(java.awt.event.MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }
}
