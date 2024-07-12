import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class login {
    public JPanel mainPanel;
    private JTextField usuarioTxt;
    private JPasswordField contraseniaTxt;
    private JButton submitButton;
    private JLabel datosincorrectos;


    public login() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/sistema_hospitalario";
                String user = "root";
                String password = "123456";
                try (Connection connection = DriverManager.getConnection(url, user, password)) {
                    System.out.println("Conectado a Base de Datos");

                    String usuarioIngresado = usuarioTxt.getText();
                    String contraseniaIngresada = new String(contraseniaTxt.getPassword());

                    //Verifica si el usuario existe y la contraseña es correcta
                    String query = "SELECT * FROM usuario WHERE username = ? AND password = ?";
                    try (PreparedStatement statement = connection.prepareStatement(query)) {
                        statement.setString(1, usuarioIngresado);
                        statement.setString(2, contraseniaIngresada);

                        try (ResultSet resultSet = statement.executeQuery()) {
                            if (resultSet.next()) {
                                //Abre opciones
                                JFrame frameForm2 = new JFrame("Opciones");
                                opciones formInstance = new opciones();
                                frameForm2.setContentPane(formInstance.mainPanel);
                                frameForm2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                frameForm2.setSize(600, 400); // Ajusta el tamaño a valores razonables
                                frameForm2.pack();
                                frameForm2.setVisible(true);

                            } else {
                                datosincorrectos.setText("Datos incorrectos, inténtelo de nuevo");
                                usuarioTxt.setText("");
                                contraseniaTxt.setText("");
                            }
                        }
                    }
                } catch (SQLException a) {
                    System.out.println(a.getMessage());
                }
            }
        });
    }
}
