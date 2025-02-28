package com.github.FilipeRobot.view;

import com.github.FilipeRobot.controller.HotelController;
import com.github.FilipeRobot.model.DTO.DadosCompletosHospede;
import com.github.FilipeRobot.model.DTO.DadosCompletosReserva;
import com.github.FilipeRobot.model.DTO.DadosHospede;
import com.github.FilipeRobot.model.DTO.DadosReserva;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("serial")
public class Buscar extends JFrame {
    private JPanel contentPane;
    private JTextField txtBuscar;
    private JTable tbHospedes;
    private JTable tbReservas;
    private DefaultTableModel modelo;
    private DefaultTableModel modeloHospedes;
    private JLabel labelAtras;
    private JLabel labelExit;
    int xMouse, yMouse;

    private final HotelController hotelController;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Buscar frame = new Buscar();
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
    public Buscar() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(Buscar.class.getResource("/img/lOGO-50PX.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 910, 571);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);
        setUndecorated(true);

        txtBuscar = new JTextField();
        txtBuscar.setBounds(536, 127, 193, 31);
        txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        contentPane.add(txtBuscar);
        txtBuscar.setColumns(10);


        JLabel lblTitulo = new JLabel("SISTEMA DE BUSCA");
        lblTitulo.setForeground(new Color(12, 138, 199));
        lblTitulo.setFont(new Font("Roboto Black", Font.BOLD, 24));
        lblTitulo.setBounds(331, 62, 280, 42);
        contentPane.add(lblTitulo);

        JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
        panel.setBackground(new Color(12, 138, 199));
        panel.setFont(new Font("Roboto", Font.PLAIN, 16));
        panel.setBounds(20, 169, 865, 328);
        contentPane.add(panel);

        tbReservas = new JTable();
        tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
        modelo = (DefaultTableModel) tbReservas.getModel();
        modelo.addColumn("Numero de Reserva");
        modelo.addColumn("Data Check In");
        modelo.addColumn("Data Check Out");
        modelo.addColumn("Valor");
        modelo.addColumn("Forma de Pago");
        JScrollPane scroll_table = new JScrollPane(tbReservas);
        panel.addTab("Reservas", new ImageIcon(Objects.requireNonNull(Buscar.class.getResource("/img/reservado.png"))), scroll_table, null);
        scroll_table.setVisible(true);

        tbHospedes = new JTable();
        tbHospedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbHospedes.setFont(new Font("Roboto", Font.PLAIN, 16));
        modeloHospedes = (DefaultTableModel) tbHospedes.getModel();
        modeloHospedes.addColumn("Numero de Hóspede");
        modeloHospedes.addColumn("Nome");
        modeloHospedes.addColumn("Sobrenome");
        modeloHospedes.addColumn("Data de Nascimento");
        modeloHospedes.addColumn("Nacionalidade");
        modeloHospedes.addColumn("Telefone");
        modeloHospedes.addColumn("Numero de Reserva");
        JScrollPane scroll_tableHuespedes = new JScrollPane(tbHospedes);
        panel.addTab("Huéspedes", new ImageIcon(Objects.requireNonNull(Buscar.class.getResource("/img/pessoas.png"))), scroll_tableHuespedes, null);
        scroll_tableHuespedes.setVisible(true);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(Objects.requireNonNull(Buscar.class.getResource("/img/Ha-100px.png"))));
        lblNewLabel_2.setBounds(56, 51, 104, 107);
        contentPane.add(lblNewLabel_2);

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
        header.setLayout(null);
        header.setBackground(Color.WHITE);
        header.setBounds(0, 0, 910, 36);
        contentPane.add(header);

        JPanel btnAtras = new JPanel();
        btnAtras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MenuUsuario usuario = new MenuUsuario();
                usuario.setVisible(true);
                dispose();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                btnAtras.setBackground(new Color(12, 138, 199));
                labelAtras.setForeground(Color.white);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnAtras.setBackground(Color.white);
                labelAtras.setForeground(Color.black);
            }
        });
        btnAtras.setLayout(null);
        btnAtras.setBackground(Color.WHITE);
        btnAtras.setBounds(0, 0, 53, 36);
        header.add(btnAtras);

        labelAtras = new JLabel("<");
        labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
        labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
        labelAtras.setBounds(0, 0, 53, 36);
        btnAtras.add(labelAtras);

        JPanel btnexit = new JPanel();
        btnexit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MenuUsuario usuario = new MenuUsuario();
                usuario.setVisible(true);
                dispose();
            }
            @Override
            public void mouseEntered(MouseEvent e) { // Quando o usuário passa o mouse sobre o botão, ele muda de cor
                btnexit.setBackground(Color.red);
                labelExit.setForeground(Color.white);
            }
            @Override
            public void mouseExited(MouseEvent e) { //Quando o usuário remove o mouse do botão, ele retornará ao estado original
                btnexit.setBackground(Color.white);
                labelExit.setForeground(Color.black);
            }
        });
        btnexit.setLayout(null);
        btnexit.setBackground(Color.WHITE);
        btnexit.setBounds(857, 0, 53, 36);
        header.add(btnexit);

        labelExit = new JLabel("X");
        labelExit.setHorizontalAlignment(SwingConstants.CENTER);
        labelExit.setForeground(Color.BLACK);
        labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
        labelExit.setBounds(0, 0, 53, 36);
        btnexit.add(labelExit);

        JSeparator separator_1_2 = new JSeparator();
        separator_1_2.setForeground(new Color(12, 138, 199));
        separator_1_2.setBackground(new Color(12, 138, 199));
        separator_1_2.setBounds(539, 159, 193, 2);
        contentPane.add(separator_1_2);

        JPanel btnbuscar = new JPanel();
        btnbuscar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clearTable(modelo);
                clearTable(modeloHospedes);

                switch (panel.getSelectedIndex()) {
                    case 0 -> preencherTabelaDeReservas();
                    case 1 -> preencherTabelaDeHospedes();
                    default -> throw new RuntimeException("Opção invalida");
                }
            }
        });
        btnbuscar.setLayout(null);
        btnbuscar.setBackground(new Color(12, 138, 199));
        btnbuscar.setBounds(748, 125, 122, 35);
        btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contentPane.add(btnbuscar);

        JLabel lblBuscar = new JLabel("BUSCAR");
        lblBuscar.setBounds(0, 0, 122, 35);
        btnbuscar.add(lblBuscar);
        lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
        lblBuscar.setForeground(Color.WHITE);
        lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));

        JPanel btnEditar = new JPanel();
        btnEditar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switch (panel.getSelectedIndex()) {
                    case 0 -> editarReserva();
                    case 1 -> editarHospede();
                    default -> throw new RuntimeException("Opção invalida");
                }
            }
        });
        btnEditar.setLayout(null);
        btnEditar.setBackground(new Color(12, 138, 199));
        btnEditar.setBounds(635, 508, 122, 35);
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contentPane.add(btnEditar);

        JLabel lblEditar = new JLabel("EDITAR");
        lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
        lblEditar.setForeground(Color.WHITE);
        lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblEditar.setBounds(0, 0, 122, 35);
        btnEditar.add(lblEditar);

        JPanel btnDeletar = new JPanel();
        btnDeletar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switch (panel.getSelectedIndex()) {
                    case 0 -> deletarReserva();
                    case 1 -> deletarHospede();
                    default -> throw new RuntimeException("Opção invalida");
                }
            }
        });
        btnDeletar.setLayout(null);
        btnDeletar.setBackground(new Color(12, 138, 199));
        btnDeletar.setBounds(767, 508, 122, 35);
        btnDeletar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contentPane.add(btnDeletar);

        JLabel lblExcluir = new JLabel("DELETAR");
        lblExcluir.setHorizontalAlignment(SwingConstants.CENTER);
        lblExcluir.setForeground(Color.WHITE);
        lblExcluir.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblExcluir.setBounds(0, 0, 122, 35);
        btnDeletar.add(lblExcluir);
        setResizable(false);
        hotelController = new HotelController();
    }

    private void editarHospede() {
        int selectedRow = tbHospedes.getSelectedRow();
        if (selectedRow > -1) {
            String id = modeloHospedes.getValueAt(selectedRow, 0).toString();
            String nome = modeloHospedes.getValueAt(selectedRow, 1).toString();
            String sobrenome = modeloHospedes.getValueAt(selectedRow, 2).toString();
            String dataN = modeloHospedes.getValueAt(selectedRow, 3).toString();
            String nacionalidade = modeloHospedes.getValueAt(selectedRow, 4).toString();
            String telefone = modeloHospedes.getValueAt(selectedRow, 5).toString();
            String reserva = modeloHospedes.getValueAt(selectedRow, 6).toString();

            var dados = new DadosHospede(
                    nome,
                    sobrenome,
                    LocalDate.parse(dataN),
                    nacionalidade,
                    telefone,
                    Long.valueOf(reserva)
            );

            hotelController.editarHospede(id, dados);
        }
    }

    private void editarReserva() {
        int selectedRow = tbReservas.getSelectedRow();
        if (selectedRow > -1) {
            String id = modelo.getValueAt(selectedRow, 0).toString();
            String dataEntrada = modelo.getValueAt(selectedRow, 1).toString();
            String dataSaida = modelo.getValueAt(selectedRow, 2).toString();
            String valor = modelo.getValueAt(selectedRow, 3).toString();
            String formaDePagamento = modelo.getValueAt(selectedRow, 4).toString();

            var dados = new DadosReserva(
                    LocalDate.parse(dataEntrada),
                    LocalDate.parse(dataSaida),
                    new BigDecimal(valor),
                    formaDePagamento
            );

            hotelController.editarReserva(id, dados);
        }
    }

    private void deletarHospede() {
        int selectedRow = tbHospedes.getSelectedRow();
        if (selectedRow > -1) {
            Long id = (Long) modeloHospedes.getValueAt(selectedRow, 0);

            hotelController.deletarHospede(id);
            modeloHospedes.removeRow(selectedRow);
        }
    }

    private void deletarReserva() {
        int selectedRow = tbReservas.getSelectedRow();
        if (selectedRow > -1) {
            Long id = (Long) modelo.getValueAt(selectedRow, 0);

            hotelController.deletarReserva(id);
            modelo.removeRow(selectedRow);
        }
    }

    private void preencherTabelaDeHospedes() {
        String sobrenome = txtBuscar.getText().trim();

        try {
            if (sobrenome.isBlank()) {
                List<DadosCompletosHospede> hospedes = hotelController.buscarHospedes();
                AtomicInteger item = new AtomicInteger();
                hospedes.forEach(hospede -> {
                    modeloHospedes.insertRow(item.getAndIncrement(), new Object[]{
                            hospede.id(),
                            hospede.nome(),
                            hospede.sobrenome(),
                            hospede.dataNascimento(),
                            hospede.nacionalidade(),
                            hospede.telefone(),
                            hospede.reserva()
                    });
                });
            } else {
                List<DadosCompletosHospede> hospedes = hotelController.buscarHospedePorSobrenome(sobrenome);
                AtomicInteger item = new AtomicInteger();
                hospedes.forEach(hospede -> {
                    modeloHospedes.insertRow(item.getAndIncrement(), new Object[]{
                            hospede.id(),
                            hospede.nome(),
                            hospede.sobrenome(),
                            hospede.dataNascimento(),
                            hospede.nacionalidade(),
                            hospede.telefone(),
                            hospede.reserva()
                    });
                });
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(
                    this,
                    exception.getMessage(),
                    "ERRO",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void preencherTabelaDeReservas() {
        try {
            if (txtBuscar.getText().trim().isBlank()) {
                List<DadosCompletosReserva> reservas = hotelController.buscarReservas();
                AtomicInteger item = new AtomicInteger();
                reservas.forEach(reserva -> {
                    modelo.insertRow(item.getAndIncrement(), new Object[]{
                            reserva.id(),
                            reserva.dataEntrada(),
                            reserva.dataSaida(),
                            reserva.valor(),
                            reserva.formaPagamento()
                    });
                });
            } else {
                long idReserva = Long.parseLong(txtBuscar.getText().trim());
                DadosCompletosReserva reserva = hotelController.buscarReservaPorId(idReserva);
                modelo.insertRow(0, new Object[]{
                        reserva.id(),
                        reserva.dataEntrada(),
                        reserva.dataSaida(),
                        reserva.valor(),
                        reserva.formaPagamento()
                });
            }
        }catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Deixe vazio para todas as reservas" + '\n' + "Ou informe o código da reserva",
                    "Informação",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(
                    this,
                    exception.getMessage(),
                    "ERRO",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void clearTable(DefaultTableModel modelo) {
        int rowCount = modelo.getRowCount();
        if (rowCount > 0) {
            for (int i = rowCount - 1; i > -1; i--) {
                modelo.removeRow(i);
            }
        }
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
