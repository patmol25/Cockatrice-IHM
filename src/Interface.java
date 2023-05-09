/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */



import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class Interface extends JFrame {
    private JLabel nomTxT;
    private JTextField nom;
    private JCheckBox W;
    private JCheckBox U;
    private JCheckBox B;
    private JCheckBox R;
    private JCheckBox G;
    private JLabel manaTxT;
    private JTextField mana;
    private JLabel typeTxT;
    private JTextField type;
    private ButtonGroup RadioGroup;
    private JRadioButton Creature;
    private JRadioButton Permanent;
    private JRadioButton Terrain;
    private JRadioButton InstantSorcery;
    private JLabel CapaciteTxT;
    private JTextArea Capacite;
    private JScrollPane CapaScroll;
    private JLabel ForceTxT;
    private JSpinner Force;
    private JLabel EnduranceTxT;
    private JSpinner Endurance;
    private JButton Ajouter;

    private JPanel panel;
    private JPanel ManaZone;
    private JPanel TypeZone;
    private JPanel FE;
    private JPanel L1;
    private JPanel L2;
    private JPanel L3;
    private JPanel L4;
    private JPanel L5;
    private JPanel L6;
    
    public Interface(){
        super();
        constfen();
    }
    private void constfen(){
    setTitle("Aide à l'ajout de Funcard pour Cockatrice");
    setSize(600, 430);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setContentPane(constpan());
    setAlwaysOnTop (true);
    setVisible(true);
    }
    private JPanel constpan() {
    panel = new JPanel();
    nomTxT = new JLabel("Titre : ");
    nom = new JTextField();
    nom.setPreferredSize( new Dimension( 200, 24 ) );
    W = new JCheckBox("Blanc");
    U = new JCheckBox("Bleu");
    B = new JCheckBox("Noir");
    R = new JCheckBox("Rouge");
    G = new JCheckBox("Vert");
    manaTxT = new JLabel("Coût en Mana : ");
    mana = new JTextField();
    mana.setPreferredSize( new Dimension( 50, 24 ) );
    typeTxT = new JLabel("Type : ");
    type = new JTextField();
    type.setPreferredSize( new Dimension( 200, 24 ) );
    RadioGroup = new ButtonGroup();
    Creature = new JRadioButton("Créature");
    Permanent = new JRadioButton("Permanent non-créature non-terrain");
    Terrain = new JRadioButton("Terrain");
    InstantSorcery = new JRadioButton("Ephémère ou Rituel");
    RadioGroup.add(Creature);
    RadioGroup.add(Permanent);
    RadioGroup.add(Terrain);
    RadioGroup.add(InstantSorcery);
    CapaciteTxT = new JLabel("Texte Box : ");
    Capacite = new JTextArea();
    CapaScroll = new JScrollPane();
    CapaScroll.setPreferredSize(new Dimension(450, 110));
    CapaScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    CapaScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
    CapaScroll.setViewportView(Capacite);
    ForceTxT = new JLabel("Force : ");
    Force = new JSpinner();
    Force.setModel(new SpinnerNumberModel(0, 0, 100, 1));
    EnduranceTxT = new JLabel("Endurance : ");
    Endurance = new JSpinner();
    Endurance.setModel(new SpinnerNumberModel(0, 0, 100, 1));
    Ajouter = new JButton("Ajouter au Fichier");
    
    ManaZone = new JPanel();
    ManaZone.add(W);
    ManaZone.add(U);
    ManaZone.add(B);
    ManaZone.add(R);
    ManaZone.add(G);
    TypeZone = new JPanel();
    TypeZone.add(Terrain);
    TypeZone.add(Permanent);
    TypeZone.add(Creature);
    TypeZone.add(InstantSorcery);
    FE = new JPanel();
    FE.add(ForceTxT);
    FE.add(Force);
    FE.add(EnduranceTxT);
    FE.add(Endurance);
    L1 = new JPanel();
    L1.add(nomTxT);
    L1.add(nom);
    L1.add(manaTxT);
    L1.add(mana);
    L2 = new JPanel();
    L2.add(ManaZone);
    L3 = new JPanel();
    L3.add(typeTxT);
    L3.add(type);
    L4 = new JPanel();
    L4.add(TypeZone);
    L5 = new JPanel();
    L5.add(CapaciteTxT);
    L5.add(CapaScroll);
    L6 = new JPanel();
    L6.add(FE);
    L6.add(Ajouter);
    panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
    panel.add(L1);
    panel.add(L2);
    panel.add(L3);
    panel.add(L4);
    panel.add(L5);
    panel.add(L6);
    
    Ajouter.addMouseListener(new AjoutLisener());
    return panel;
    }
    public static void main(String[] Args){
        Interface ihm = new Interface();
}
    class AjoutLisener implements MouseListener {
    
    @Override
    public void mouseClicked(MouseEvent e) {
        String varTitre = nom.getText();
        if (varTitre .equals("")) {
            System.out.println("Entrez un nom de carte");
        } else {
            System.out.println(varTitre);
        }
        String varMana = mana.getText();
        System.out.println(varMana);
        
        String varCouleur = "";
        if (W.isSelected()) {
            varCouleur += "W";
        }
        if (U.isSelected()) {
            varCouleur += "U";
        }
        if (B.isSelected()) {
            varCouleur += "B";
        }
        if (R.isSelected()) {
            varCouleur += "R";
        }
        if (G.isSelected()) {
            varCouleur += "G";
        }
        if (varCouleur .equals("")) {
            varCouleur = "C";
        }
        System.out.println(varCouleur);
        String varType = type.getText();
        for (int i = 0; i < varType.length(); i++) {
            if (Character.toString(varType.charAt(i) ).equals(":")) {
                varType = varType.substring(0,i)+'-'+varType.substring(i+1);
            }
        }
        if (varType .equals("")) {
            System.out.println("Entrez un Type");
        } else {
            System.out.println(varType);
        }
        int numType = -1;
        if (Terrain.isSelected()) {
        numType = 0;
        } else if (Permanent.isSelected()) {
        numType = 1;
        } else if (Creature.isSelected()) {
        numType = 2;
        } else if (InstantSorcery.isSelected()) {
        numType = 3;
        }
        if (numType == -1) {
            System.out.println("Choisissez une Catégorie");
        } else {
            System.out.println(numType);
        }
        String varTexte = Capacite.getText();
        System.out.println(varTexte);
        String varFE = "";
        if (numType == 2) {
            varFE = Force.getValue() + "/" + Endurance.getValue();
            System.out.println(varFE);
        }
        String toprint = varTitre + " " + varMana + "\n" + varType + " " + numType + "\n\n" + varTexte + "\n" + varFE;
        JOptionPane.showMessageDialog(null, toprint, "resumé de la carte", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
}
