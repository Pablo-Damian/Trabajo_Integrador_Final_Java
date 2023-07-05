import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GeneradorPass extends JFrame {
    private JLabel lblCantidadCaracteres;
    private JTextField txtCantidadCaracteres;
    private JButton btnGenerar;
    private JTextArea txtAreaContraseña;

    public GeneradorPass() {
        setTitle("Generador de Contraseñas");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblCantidadCaracteres = new JLabel("Ingrese la Cantidad de caracteres para generar la contraseña (entre 8 como mínimo y 16 como máximo):");
        txtCantidadCaracteres = new JTextField(10);
        btnGenerar = new JButton("Generar Contraseña");
        txtAreaContraseña = new JTextArea(10, 20);
        txtAreaContraseña.setEditable(false);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);

        panelPrincipal.add(lblCantidadCaracteres, gbc);

        gbc.gridx = 1;
        panelPrincipal.add(txtCantidadCaracteres, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panelPrincipal.add(btnGenerar, gbc);

        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        panelPrincipal.add(new JScrollPane(txtAreaContraseña), gbc);

        // EVENTO CLIC DEL BOTÓN
        btnGenerar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarContraseña();
            }
        });

        // DISEÑO DE LA VENTANA
        add(panelPrincipal);
        pack(); // AJUSTE AUTOMÁTICO
        setLocationRelativeTo(null);
    }

    private void generarContraseña() {
        String cantidadCaracteresStr = txtCantidadCaracteres.getText();
        int cantidadCaracteres;

        try {
            cantidadCaracteres = Integer.parseInt(cantidadCaracteresStr);

            if (cantidadCaracteres < 8 || cantidadCaracteres > 16) {
                JOptionPane.showMessageDialog(this, "La cantidad de caracteres debe estar entre 8 y 16.");
                return;
            }

            String caracteres = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()";
            StringBuilder contraseña = new StringBuilder();

            for (int i = 0; i < cantidadCaracteres; i++) {
                int index = (int) (Math.random() * caracteres.length());
                contraseña.append(caracteres.charAt(index));
            }

            txtAreaContraseña.setText(contraseña.toString());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido para la cantidad de caracteres.");
        }
    }

    public static void ejecutar() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GeneradorPass generador = new GeneradorPass();
                generador.setVisible(true);
            }
        });
    }
}
