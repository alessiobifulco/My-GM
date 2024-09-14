import data.DAOUtils;
import model.Model;

public class Main {
    public static void main(String[] args) {
        // Collega al database NBA_System
        var connection = DAOUtils.localMySQLConnection("NBA_System", "root", "BLS007ab&");
        var model = Model.fromConnection(connection);
        var view = new View(() -> {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        var controller = new Controller(model, view);
        view.setController(controller);

        controller.homePage();
    }
}
