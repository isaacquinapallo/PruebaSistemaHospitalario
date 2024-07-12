import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class BusquedaPacientes {
    public JPanel mainPanel;
    private JTextField cedulaPacienteBuscarTxt;
    private JButton buscarPacienteButton;
    private JLabel mostrarInfoPaciente;
    private JButton registrarPacienteButton;
    private JButton regresarAlLoginButton;

    public BusquedaPacientes() {
        buscarPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url="jdbc:mysql://localhost:3306/sistema_hospitalario";
                String user="root";
                String password="123456";

                try(Connection connection= DriverManager.getConnection(url,user,password)) {
                    System.out.println("Conectado a Base de Datos Paciente");
                    String query = "select * from paciente where cedula='"+cedulaPacienteBuscarTxt.getText()+"'";
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query);
                    while (resultSet.next()) {
                            mostrarInfoPaciente.setText(String.valueOf("Segun el registro el paciente de cedula: "+resultSet.getString("cedula")+" de la numero de historial clinico: "+resultSet.getString("n_historial_clinico")+" con nombre: "+resultSet.getString("nombre")+", de apellido: "+resultSet.getString("apellido")+", con numero de telefono "+resultSet.getString("telefono")+", con edad: "+resultSet.getString("edad")+", presenta la enfermedad de: "+resultSet.getString("descripcion_enfermedad")));
                    }
                }catch(
                        SQLException a) {
                    System.out.println(a.getMessage());
                }
            }
        });
        registrarPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameForm = new JFrame("Registro de Pacientes");
                RegistroPacientes formInstance = new RegistroPacientes();
                frameForm.setContentPane(formInstance.mainPanel);
                frameForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frameForm.setSize(600, 400); // Ajusta el tamaño a valores razonables
                frameForm.pack();
                frameForm.setVisible(true);
            }
        });
        regresarAlLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Login de Usuario");
                frame.setContentPane(new login().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cerrar procesos
                frame.setSize(20000, 1000);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
