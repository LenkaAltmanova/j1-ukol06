package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Aplikace extends JFrame {

    private JSpinner husySpinner;
    private JLabel husyLabel;
    private JSpinner kraliciSpinner;
    private JLabel kraliciLabel;
    private JButton vypocitatButton;
    private JTextField pocetHlavField;
    private JLabel pocetHlavLabel;
    private JTextField pocetNohouField;
    private JLabel pocetNohouLabel;


    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Aplikace().start();
    }

    public Aplikace() throws HeadlessException {
        super("Farmářka 1.0");
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right]rel[50:120:150,grow,fill]"));
        setMinimumSize(new Dimension(250, 200));

        husySpinner = new JSpinner();
        husyLabel = new JLabel("Husy");
        husyLabel.setDisplayedMnemonic('H');
        husyLabel.setLabelFor(husySpinner);
        add(husyLabel);
        add(husySpinner);

        kraliciSpinner = new JSpinner();
        kraliciLabel = new JLabel("Králíci");
        kraliciLabel.setDisplayedMnemonic('K');
        kraliciLabel.setLabelFor(kraliciSpinner);
        SpinnerNumberModel model = new SpinnerNumberModel(0, 0, 1000000, 1);
        model.getValue();
        add(kraliciLabel);
        add(kraliciSpinner);

        pocetHlavField = new JTextField();
        pocetHlavLabel = new JLabel("Počet hlav");
        pocetHlavLabel.setDisplayedMnemonic('P');
        pocetHlavLabel.setLabelFor(pocetHlavField);
        pocetHlavField.setHorizontalAlignment(JTextField.TRAILING);
        pocetHlavField.setEditable(false);
        add(pocetHlavLabel);
        add(pocetHlavField);

        pocetNohouField = new JTextField();
        pocetNohouLabel = new JLabel("Počet nohou");
        pocetNohouLabel.setDisplayedMnemonic('N');
        pocetNohouLabel.setLabelFor(pocetNohouField);
        pocetNohouField.setHorizontalAlignment(JTextField.TRAILING);
        pocetNohouField.setEditable(false);
        add(pocetNohouLabel);
        add(pocetNohouField);
        add(createButtonBar(), "span");

        pack();

        getRootPane().setDefaultButton(vypocitatButton);

        vypocitatButton.addActionListener(this::handleVypocitat);
        return createButtonBar();
    }

    private JPanel createButtonBar() {
        vypocitatButton = new JButton("Vypočítat");
        vypocitatButton.setMnemonic('V');

        JPanel buttonBar = new JPanel(new MigLayout(null, "[left, grow]"));
        buttonBar.add(vypocitatButton);
        return buttonBar;
    }


    private void handleVypocitat(ActionEvent actionEvent) {
        int pocetHus = (int) husySpinner.getValue();
        int pocetKraliku = (int) kraliciSpinner.getValue();

        int pocetHlav = pocetHus + pocetKraliku;
        int pocetNohou = pocetHus * 2 + pocetKraliku * 4;

        pocetHlavField.setText(String.valueOf(pocetHlav));
        pocetNohouField.setText(String.valueOf(pocetNohou));
    }
}
