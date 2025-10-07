package RecargaTren;

import javax.swing.*;

public class RecargaTren {
    private JPanel ventanaPrincipal;
    private JLabel l_titulo;
    private JPanel header;
    private JPanel body;
    private JLabel L_DNI;
    private JLabel l_ntarjeta;
    private JTextField tf_dni;
    private JTextField tf_ntarjeta;
    private JPanel botones;
    private JButton b_recargartarjeta;
    private JButton b_limpiar;
    public JPanel panel1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("RecargaTren");
        frame.setContentPane(new RecargaTren().ventanaPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);


    }
}
