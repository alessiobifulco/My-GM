import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View {

    private Controller controller;
    private final JFrame frame;

    public View(Runnable onClose) {
        this.frame = this.createFrame("NBA GM System");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLayout(new BorderLayout());
        this.frame.setSize(800, 600);
        frame.setVisible(true);
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    private JFrame createFrame(String title) {
        return new JFrame(title);
    }

    // Mostra la Homepage
    public void showHomePage() {
        // Pulizia della finestra
        frame.getContentPane().removeAll();

        // Creazione della HomePage
        JPanel homePanel = new JPanel();
        homePanel.setLayout(new GridBagLayout());
        JButton loginButton = new JButton("Login");
        JButton adminButton = new JButton("Administrator");

        // ActionListener per il bottone Login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showLoginPage();
            }
        });

        // ActionListener per il bottone Administrator
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAdministratorPage();
            }
        });

        homePanel.add(loginButton);
        homePanel.add(adminButton);
        frame.add(homePanel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }

    // Mostra la pagina di Login
    public void showLoginPage() {
        // Pulizia della finestra
        frame.getContentPane().removeAll();

        // Creazione della Login Page
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridBagLayout());
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20);
        JButton submitButton = new JButton("Submit");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                if (controller.authenticateGm(email, password)) {
                    showGmPage(); // Passa alla GmPage se il login ha successo
                } else {
                    JOptionPane.showMessageDialog(frame, "Credenziali non valide", "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        loginPanel.add(emailLabel);
        loginPanel.add(emailField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(submitButton);

        frame.add(loginPanel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }

    // Mostra la GmPage
    public void showGmPage() {
        // Pulizia della finestra
        frame.getContentPane().removeAll();

        // Creazione della GmPage
        JPanel gmPanel = new JPanel();
        gmPanel.setLayout(new GridBagLayout());
        JLabel welcomeLabel = new JLabel("Benvenuto nella Gm Page!");
        JButton teamButton = new JButton("Team");
        JButton staffButton = new JButton("Staff");
        JButton rosterButton = new JButton("Roster");

        // ActionListener per i pulsanti
        
        gmPanel.add(welcomeLabel);
        gmPanel.add(teamButton);
        gmPanel.add(staffButton);
        gmPanel.add(rosterButton);

        frame.add(gmPanel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }

    // Mostra la pagina dell'amministratore
    public void showAdministratorPage() {
        // Implementazione della pagina dell'amministratore
        JOptionPane.showMessageDialog(frame, "Benvenuto nella pagina dell'amministratore!", "Admin Page", JOptionPane.INFORMATION_MESSAGE);
    }

    // Altri metodi per mostrare TeamPage, StaffPage, e RosterPage
    public void showTeamPage() {
        // Implementa logica per mostrare TeamPage
        JOptionPane.showMessageDialog(frame, "Team Page!", "Team", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showStaffPage() {
        // Implementa logica per mostrare StaffPage
        JOptionPane.showMessageDialog(frame, "Staff Page!", "Staff", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showRosterPage() {
        // Implementa logica per mostrare RosterPage
        JOptionPane.showMessageDialog(frame, "Roster Page!", "Roster", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(frame, message, "Errore", JOptionPane.ERROR_MESSAGE);
    }
    
}
