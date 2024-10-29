import java.sql.SQLException;

import model.Model;

public class Controller {

    private final Model model;
    private final View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void homePage() {
        view.showHomePage();
    }

    public void showLoginPage() {
        view.showLoginPage();
    }

    public boolean authenticateGm(String email, String password) {
        boolean isAuthenticated = false;
    
        try {
            isAuthenticated = model.verifyGmCredentials(email, password);
            
            if (isAuthenticated) {
                view.showGmPage();  // Se autenticato, mostra la pagina GM
            } else {
                view.showErrorMessage("Email o password non corretti.");  // Messaggio di errore
            }
        } catch (SQLException e) {
            // Gestione dell'eccezione
            view.showErrorMessage("Si è verificato un errore durante la verifica delle credenziali: " + e.getMessage());
            e.printStackTrace(); // Stampa lo stack trace per il debug
        }
    
        return isAuthenticated;
    }
    
}
