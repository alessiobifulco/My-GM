import model.Model;
import data.DAOUtils;

public class Controller {

    private final Model model;
    private final View view;

    Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void homePage() {
        model.updateOdM();
    }

    public View getView() {
        return view;
    }
}
