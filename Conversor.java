import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Conversor extends JFrame {
    private JTextField celsiusField;
    private JTextField fahrenheitField;
    private JTextField pesosField;
    private JTextField dollarsField;
    private JTextField reaisField;
    private JTextField eurosField;

    private double usdCompra = 257.50;
    private double usdVenta = 270.50;
    private double usdBlueCompra = 488.00;
    private double usdBlueVenta = 493.00;
    private double realCompra = 53.70;
    private double realVenta = 53.75;
    private double euroCompra = 281.18;
    private double euroVenta = 282.20;

    public Conversor() {
        setTitle("Conversor");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 2));

        JPanel temperaturaPanel = new JPanel();
        temperaturaPanel.setLayout(new GridLayout(2, 3));
        temperaturaPanel.setBorder(BorderFactory.createTitledBorder("Temperatura"));

        JLabel celsiusLabel = new JLabel("Grados Celsius:");
        celsiusField = new JTextField(10);

        JButton celsiusButton = new JButton("Convertir a Fahrenheit");
        celsiusButton.addActionListener(new CelsiusListener());

        JLabel fahrenheitLabel = new JLabel("Grados Fahrenheit:");
        fahrenheitField = new JTextField(10);

        JButton fahrenheitButton = new JButton("Convertir a Celsius");
        fahrenheitButton.addActionListener(new FahrenheitListener());

        temperaturaPanel.add(celsiusLabel);
        temperaturaPanel.add(celsiusField);
        temperaturaPanel.add(celsiusButton);
        temperaturaPanel.add(fahrenheitLabel);
        temperaturaPanel.add(fahrenheitField);
        temperaturaPanel.add(fahrenheitButton);

        JPanel divisasPanel = new JPanel();
        divisasPanel.setLayout(new GridLayout(5, 3));
        divisasPanel.setBorder(BorderFactory.createTitledBorder("Conversor de Divisas"));

        JLabel pesosLabel = new JLabel("Pesos Argentinos:");
        pesosField = new JTextField(10);

        JLabel dollarsLabel = new JLabel("Dólares US$:");
        dollarsField = new JTextField(10);

        JButton dollarsButton = new JButton("Convertir a Pesos");
        dollarsButton.addActionListener(new DollarsListener());

        JLabel reaisLabel = new JLabel("Reales R$:");
        reaisField = new JTextField(10);

        JButton reaisButton = new JButton("Convertir a Pesos");
        reaisButton.addActionListener(new ReaisListener());

        JLabel eurosLabel = new JLabel("Euros €:");
        eurosField = new JTextField(10);

        JButton eurosButton = new JButton("Convertir a Pesos");
        eurosButton.addActionListener(new EurosListener());

        pesosField.setEditable(false);

        divisasPanel.add(pesosLabel);
        divisasPanel.add(pesosField);
        divisasPanel.add(new JLabel());
        divisasPanel.add(dollarsLabel);
        divisasPanel.add(dollarsField);
        divisasPanel.add(dollarsButton);
        divisasPanel.add(reaisLabel);
        divisasPanel.add(reaisField);
        divisasPanel.add(reaisButton);
        divisasPanel.add(eurosLabel);
        divisasPanel.add(eurosField);
        divisasPanel.add(eurosButton);

        add(temperaturaPanel);
        add(divisasPanel);

        pack();
        setVisible(true);
    }

    private class CelsiusListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String celsiusText = celsiusField.getText();
            try {
                double celsius = Double.parseDouble(celsiusText);
                double fahrenheit = celsius * 9 / 5 + 32;
                fahrenheitField.setText(String.valueOf(fahrenheit));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(Conversor.this, "Ingresa un número válido en grados Celsius.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class FahrenheitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String fahrenheitText = fahrenheitField.getText();
            try {
                double fahrenheit = Double.parseDouble(fahrenheitText);
                double celsius = (fahrenheit - 32) * 5 / 9;
                celsiusField.setText(String.valueOf(celsius));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(Conversor.this, "Ingresa un número válido en grados Fahrenheit.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class DollarsListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String dollarsText = dollarsField.getText();
            try {
                double dollars = Double.parseDouble(dollarsText);
                double pesosCompra = dollars * usdCompra;
                double pesosVenta = dollars * usdVenta;
                pesosField.setText("Compra: " + pesosCompra + " Venta: " + pesosVenta);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(Conversor.this, "Ingresa un número válido en dólares.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class ReaisListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String reaisText = reaisField.getText();
            try {
                double reais = Double.parseDouble(reaisText);
                double pesosCompra = reais * realCompra;
                double pesosVenta = reais * realVenta;
                pesosField.setText("Compra: " + pesosCompra + " Venta: " + pesosVenta);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(Conversor.this, "Ingresa un número válido en reales.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class EurosListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String eurosText = eurosField.getText();
            try {
                double euros = Double.parseDouble(eurosText);
                double pesosCompra = euros * euroCompra;
                double pesosVenta = euros * euroVenta;
                pesosField.setText("Compra: " + pesosCompra + " Venta: " + pesosVenta);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(Conversor.this, "Ingresa un número válido en euros.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void ejecutar() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Conversor();
            }
        });
    }
}