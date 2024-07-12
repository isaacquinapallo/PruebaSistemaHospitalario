import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistroPacientes {
    public JPanel mainPanel;
    private JTextField cedulaPacienteTxt;
    private JTextField numeroHistorialClinicoTxt;
    private JTextField nombrePacienteTxt;
    private JTextField apellidoPacienteTxt;
    private JTextField numeroTelefonoTxt;
    private JTextField edadPacienteTxt;
    private JTextField descripcionEnfermedadTxt;
    private JButton registrarInformacionButton;
    private JButton buscarInformacionDelPacienteButton;

    public RegistroPacientes() {
        registrarInformacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String url = "jdbc:mysql://localhost:3306/sistema_hospitalario";
                String user = "root";
                String password = "123456";

                Datos v1=new Datos(cedulaPacienteTxt.getText(), numeroHistorialClinicoTxt.getText(),nombrePacienteTxt.getText(),apellidoPacienteTxt.getText(),numeroTelefonoTxt.getText(),edadPacienteTxt.getText(),descripcionEnfermedadTxt.getText());

                //Insertar Datos
                String sql = "INSERT INTO paciente (cedula,n_historial_clinico,nombre,apellido,telefono,edad,descripcion_enfermedad) values(?,?,?,?,?,?,?)";

                try(Connection connection= DriverManager.getConnection(url,user,password)){
                    PreparedStatement cadenaPreparada= connection.prepareStatement(sql);
                    cadenaPreparada.setString(1, v1.getCedula());
                    cadenaPreparada.setString(2, v1.getN_historial_clinico());
                    cadenaPreparada.setString(3, v1.getNombre());
                    cadenaPreparada.setString(4, v1.getApellido());
                    cadenaPreparada.setString(5, v1.getTelefono());
                    cadenaPreparada.setString(6, v1.getEdad());
                    cadenaPreparada.setString(7, v1.getDescripcion_enfermedad());
                    cadenaPreparada.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Registro actualizado exitosamente");

                }catch(SQLException a) {
                    System.out.println(a.getMessage());
                }
            }
        });
        buscarInformacionDelPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameForm = new JFrame("Busqueda de Pacientes");
                BusquedaPacientes formInstance = new BusquedaPacientes();
                frameForm.setContentPane(formInstance.mainPanel);
                frameForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frameForm.setSize(600, 400); // Ajusta el tamaño a valores razonables
                frameForm.pack();
                frameForm.setVisible(true);
            }
        });
    }
}
