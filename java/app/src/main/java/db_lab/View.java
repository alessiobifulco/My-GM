import javax.swing.JFrame;

public class View {

    private Controller controller;
    private final JFrame frame;

    View(Runnable onClose) {
        this.frame = this.createFrame("NBA GM System");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    private JFrame createFrame(String title) {
        return new JFrame(title);
    }
}
