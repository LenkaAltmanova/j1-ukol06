package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Aplikace extends JFrame {

    private JTextField husyField;
    private JLabel husyLabel;
    private JTextField kraliciField;
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

        husyField = new JTextField();
        husyLabel = new JLabel("Husy");
        husyLabel.setDisplayedMnemonic('H');
        husyLabel.setLabelFor(husyField);
        husyField.setHorizontalAlignment(JTextField.TRAILING);
        husyField.setEditable(true);
        add(husyLabel);
        add(husyField);

        kraliciField = new JTextField();
        kraliciLabel = new JLabel("Králíci");
        kraliciLabel.setDisplayedMnemonic('K');
        kraliciLabel.setLabelFor(kraliciField);
        kraliciField.setHorizontalAlignment(JTextField.TRAILING);
        kraliciField.setEditable(true);
        add(kraliciLabel);
        add(kraliciField);


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
        vypocitatButton.setMnemonic('U');

        JPanel buttonBar = new JPanel(new MigLayout(null, "[left, grow]"));
        buttonBar.add(vypocitatButton);
        return buttonBar;
    }


    private void handleVypocitat(ActionEvent actionEvent) {
        int pocetHus = Integer.parseInt(husyField.getText());
        int pocetKraliku = Integer.parseInt(kraliciField.getText());

        int pocetHlav = pocetHus + pocetKraliku;
        int pocetNohou = pocetHus * 2 + pocetKraliku * 4;

        pocetHlavField.setText(String.valueOf(pocetHlav));
        pocetNohouField.setText(String.valueOf(pocetNohou));


    }
}
