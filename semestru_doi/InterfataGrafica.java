package semestru_doi;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InterfataGrafica extends JFrame {
  private List<Object> objects = new ArrayList<>();
  private JTextArea textArea;
  private static final String FILE_PATH = "objects.txt";

  public InterfataGrafica() {
    super("Object Manager");

    // Creare componentele interfeței grafice
    JButton createButton = new JButton("Create Object");
    JButton destroyButton = new JButton("Destroy Object");
    JButton processButton = new JButton("Process Objects");
    textArea = new JTextArea(20, 40);

    // Adăugare acțiuni la butoane
    createButton.addActionListener(e -> createObject());
    destroyButton.addActionListener(e -> destroyObject());
    processButton.addActionListener(e -> processObjects());

    // Creare layout și adăugare componentelor
    JPanel buttonPanel = new JPanel();
    buttonPanel.add(createButton);
    buttonPanel.add(destroyButton);
    buttonPanel.add(processButton);

    Container contentPane = getContentPane();
    contentPane.setLayout(new BorderLayout());
    contentPane.add(buttonPanel, BorderLayout.NORTH);
    contentPane.add(new JScrollPane(textArea), BorderLayout.CENTER);

    // Încărcare obiecte salvate în fișier
    loadObjects();

    // Configurare fereastră
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
    setLocationRelativeTo(null); // Centrare fereastră
    setVisible(true);
  }

  private void createObject() {
    // Implementare logica pentru crearea unui obiect
    String object = JOptionPane.showInputDialog(this, "Enter object data:");
    if (object != null) {
      objects.add(object);
      saveObjects();
      updateTextArea();
    }
  }

  private void destroyObject() {
    // Implementare logica pentru distrugerea unui obiect
    if (!objects.isEmpty()) {
      objects.remove(objects.size() - 1);
      saveObjects();
      updateTextArea();
    }
  }

  private void processObjects() {
    // Implementare logica pentru prelucrarea obiectelor
    StringBuilder sb = new StringBuilder();
    for (Object object : objects) {
      // Procesează fiecare obiect și adaugă rezultatul în șirul sb
    }
    textArea.setText(sb.toString());
  }

  private void updateTextArea() {
    StringBuilder sb = new StringBuilder();
    for (Object object : objects) {
      sb.append(object.toString()).append("\n");
    }
    textArea.setText(sb.toString());
  }

  private void saveObjects() {
    try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
      for (Object object : objects) {
        writer.println(object.toString());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void loadObjects() {
    try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
      String line;
      while ((line = reader.readLine()) != null) {
        objects.add(line);
      }
      updateTextArea();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(InterfataGrafica::new);
  }
}
