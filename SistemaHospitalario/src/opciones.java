import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class opciones {
    public JPanel mainPanel;
    private JButton registrarPacientesButton;
    private JButton buscarPacientesButton;

    public opciones() {
        registrarPacientesButton.addActionListener(new ActionListener() {
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

        buscarPacientesButton.addActionListener(new ActionListener() {
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
