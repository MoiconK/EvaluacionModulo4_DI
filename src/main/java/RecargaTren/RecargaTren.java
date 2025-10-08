package RecargaTren;

import com.toedter.calendar.JMonthChooser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

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
    private JPanel contador;
    private JLabel l_contador;
    private JComboBox saldosdisponibles;
    private JButton b_idioma;
    private JMonthChooser jmc_calendario;
    private JPanel footer;
    public JPanel panel1;

    public RecargaTren() {
        b_limpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf_dni.setText("");
                tf_ntarjeta.setText("");
                saldosdisponibles.setSelectedIndex(0);
                jmc_calendario.setMonth(0);
            }
        });
        b_idioma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        b_recargartarjeta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dniValido(tf_dni.getText()) && tarjetaValida(tf_ntarjeta.getText())) {
                    JOptionPane.showConfirmDialog(ventanaPrincipal, "Recarga para el mes de:"+obtenerMes(jmc_calendario));
                } else {
                    JOptionPane.showMessageDialog(ventanaPrincipal, "DNI o número de tarjeta inválido", "Campos erróneos", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }

    public String obtenerMes(JMonthChooser monthChooser){
        String mes = null;
        String meses[] = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        for (int i = 0;i<meses.length;i++){
            if (i == monthChooser.getMonth()){
                mes = meses[i];
            }
        }
        return mes;
    }

    public boolean dniValido(String dni){
        if (dni.matches("^\\d{8}[A-HJ-NP-TV-Z]$")){
            return true;
        } else return false;
    }

    public boolean tarjetaValida(String tarjeta){
        if (tarjeta.matches("^.{8}$")){
            return true;
        } else return false;
    }

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

