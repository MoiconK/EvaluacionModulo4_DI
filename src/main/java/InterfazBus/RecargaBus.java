package InterfazBus;

import com.toedter.calendar.JMonthChooser;
import javax.swing.*;
import java.awt.event.*;

public class RecargaBus extends JFrame implements WindowListener {
    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        JOptionPane.showMessageDialog(this, "La recarga se va a cancelar");
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    private JPanel root;
    private JPanel header;
    private JLabel l_recargaBus;
    private JPanel body;
    private JTextField text_dni;
    private JLabel l_dni;
    private JLabel l_ntarjeta;
    private JTextField text_numero;
    private JLabel l_mes;
    private JPanel footer;
    private JLabel l_precio;
    private JButton recargarAbonoButton;
    private JMonthChooser monthChooser_mes;

    public RecargaBus() {
        setContentPane(root);
        addWindowListener(this);
        setTitle("Recarga Bus");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        setVisible(true);

        recargarAbonoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dniValido(text_dni.getText()) && tarjetaValida(text_numero.getText())) {
                    JOptionPane.showConfirmDialog(root, "Recarga para el mes de:"+obtenerMes(monthChooser_mes)); //Ventana de confirmación
                } else {
                    JOptionPane.showMessageDialog(root, "El DNI o Nº de tarjeta no es válido", "Error con los campos", JOptionPane.ERROR_MESSAGE); //Ventana de error cuando un dato no está completo o es incorrecto
                }

            }
        });
    }

    public String obtenerMes(JMonthChooser monthChooser){ //Función para mostrar el mes seleccionado en el JMonthChooser
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
        RecargaBus recargaBus = new RecargaBus();
    }
}
