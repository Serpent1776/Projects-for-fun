import javax.swing.*;
public class CitationWindow {
    JFrame window;
    JPanel panel;
    JScrollPane scrollBar;
    boolean visibleToggle;
    JLabel citations;
    public CitationWindow() {
        this.window = new JFrame("Your Citations");
        this.window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.window.setSize(500, 1000);
        this.panel = new JPanel();
        this.scrollBar = new JScrollPane(panel);
        this.window.getContentPane().add(panel);
        this.citations = new JLabel("");
        this.visibleToggle = true;
    }
    public void toggleVisible() {
        window.setVisible(visibleToggle);
        visibleToggle = !visibleToggle;
    }
}
