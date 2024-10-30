package core;

import javax.swing.*;
import view.AdministratorPage;
import view.GmPage;
import view.HomePage;
import view.LoginPage;

public class View {

    private final JFrame frame;
    private Controller controller;

    public View(Runnable onClose) {
        this.frame = createFrame("NBA GM System");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(800, 600);
        this.frame.setVisible(true);
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    private JFrame createFrame(String title) {
        return new JFrame(title);
    }

    // Mostra la HomePage
    public void showHomePage() {
        new HomePage(frame, controller); // Crea e mostra la HomePage
    }

    // Mostra la pagina di Login
    public void showLoginPage() {
        new LoginPage(frame, controller); // Crea e mostra la LoginPage
    }

    // Mostra la GmPage
    public void showGmPage() {
        new GmPage(frame, controller); // Crea e mostra la GmPage
    }

    // Mostra la pagina dell'amministratore
    public void showAdministratorPage() {
        new AdministratorPage(frame); // Crea e mostra la AdministratorPage
    }

    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(frame, message, "Errore", JOptionPane.ERROR_MESSAGE);
    }
}
