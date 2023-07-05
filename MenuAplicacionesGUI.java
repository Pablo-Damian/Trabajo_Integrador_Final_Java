import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import javax.swing.*;

public class MenuAplicacionesGUI {
    private JFrame frame;
    private JPanel menuPanel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MenuAplicacionesGUI().createAndShowGUI();
            }
        });
    }

    public void createAndShowGUI() {
        frame = new JFrame("Mis Aplicaciones");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //frame.setSize(800, 800);// Tamaño personalizado de la ventana
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // VENTANA MAXIMIZADA
        createMenuPanel();

        frame.getContentPane().setBackground(new Color(230, 230, 230)); // COLOR DE FONDO "MERCURY"
        frame.getContentPane().add(menuPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null); // CENTRA LA VENTANA EN LA PANTALLA
        frame.setVisible(true);
    }

    private void createMenuPanel() {
        menuPanel = new JPanel();
        menuPanel.setLayout(null); // "NULO" PARA COLOCAR LOS BOTONES MANUALMENTE

        // DIMENSIONES Y POSICIÓN DEL PANEL
        Dimension panelSize = new Dimension(700, 650);
        int panelCenterX = panelSize.width / 1;
        int panelCenterY = panelSize.height / 2;

        menuPanel.setPreferredSize(panelSize);
        menuPanel.setBackground(new Color(230, 230, 230));

        /*JLabel titleLabel = new JLabel("Mis Aplicaciones");
        titleLabel.setBounds(0, 20, panelSize.width, 50);
        titleLabel.setFont(titleLabel.getFont().deriveFont(24.0f));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);*/

        RoundButton[] optionButtons = new RoundButton[12]; // BOTÓN EXTRA "SALIR"

        // RADIO DEL "CÍRCULO"
        int centerX = panelCenterX;
        int centerY = panelCenterY;
        int radius = 270;
        double angleIncrement = 2 * Math.PI / 11;
        double angle = 0;

        for (int i = 0; i <= 10; i++) {
            optionButtons[i] = new RoundButton();

            // COORDENADAS DEL BOTÓN EN EL "CÍRCULO"
            int buttonX = centerX + (int) (radius * Math.cos(angle)) - 50;
            int buttonY = centerY + (int) (radius * Math.sin(angle)) - 25;

            optionButtons[i].setBounds(buttonX, buttonY, 95, 95); // TAMAÑO PERSONALIZADO PARA LAS IMÁGENES
            optionButtons[i].setBorder(BorderFactory.createEmptyBorder());
            optionButtons[i].setContentAreaFilled(false);
            optionButtons[i].setHorizontalAlignment(SwingConstants.CENTER);

            String imagePath = "imgBotones/opcion" + i + ".png";
            ImageIcon icon = new RoundIcon(imagePath);
            optionButtons[i].setIcon(icon);

            final int option = i;

            optionButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    onOptionSelected(option);
                }
            });

            menuPanel.add(optionButtons[i]);

            // ACTUALIZA EL ÁNGULO DE LA SIGUIENTE OPCIÓN
            angle += angleIncrement;
        }

        optionButtons[0].setBounds(centerX - 50, centerY - 50, 95, 95); // BOTÓN "SALIR" EN EL CENTRO

        // NOMBRES DE LAS OPCIONES
        String[] optionNames = {
            "SALIR",
            "PAR IMPAR",
            "FACTORIAL !",
            "PROMEDIO",
            "JUEGO PPT",
            "CAJERO",
            "LISTA",
            "AHORCADO",
            "CONVERSOR",
            "CALCULADORA",
            "GEN. PASS"
        };

        for (int i = 0; i <= 10; i++) {
            JLabel nameLabel = new JLabel(optionNames[i]);
            nameLabel.setBounds(optionButtons[i].getX(), optionButtons[i].getY() + 100, 100, 50);
            nameLabel.setHorizontalAlignment(JLabel.CENTER);
            menuPanel.add(nameLabel);
        }

        //menuPanel.add(titleLabel);
    }

    private void onOptionSelected(int option) {
        switch (option) {
            case 0:
                System.out.println("Cerrando la Aplicación...");
                System.exit(0);
                break;
            case 1:
                ParImpar.ejecutar();
                break;
            case 2:
                FactorialNumero.ejecutar();
                break;
            case 3:
                PromedioNotas.ejecutar();
                break;
            case 4:
                PiedraPapelTijera.ejecutar();
                break;
            case 5:
                SimuladorCajero.ejecutar();
                break;
            case 6:
                ListadeCompras.ejecutar();
                break;
            case 7:
                Ahorcado.ejecutar();
                break;
            case 8:
                Conversor.ejecutar();
                break;
            case 9:
                CalculadoraGUI.ejecutar();
                break;
            case 10:
                GeneradorPass.ejecutar();
                break;
            default:
                break;
        }
    }
}

class RoundButton extends JButton {
    public RoundButton() {
        super();
        setPreferredSize(new Dimension(100, 100));
    }

    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.lightGray);
        } else {
            g.setColor(getBackground());
        }
        g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);

        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
    }
}

class RoundIcon extends ImageIcon {
    public RoundIcon(String filename) {
        super(filename);
    }

    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.setClip(new Ellipse2D.Float(x, y, getIconWidth(), getIconHeight()));
        super.paintIcon(c, g, x, y);
    }
} // FIN DEL CÓDIGO ;)