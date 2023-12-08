/**
 * 
 */
package fr.eni.papeterie.ihm;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * @author Fanny Roux
 */
public class EcranArticle extends JFrame {

	private static final long serialVersionUID = 1L;

	private JLabel lblRef;
	private JLabel lblDes;
	private JLabel lblMar;
	private JLabel lblSto;
	private JLabel lblPri;
	private JLabel lblTyp;
	private JLabel lblGra;
	private JLabel lblCou;
	
	private JTextField txtRef;
	private JTextField txtDes;
	private JTextField txtMar;
	private JTextField txtSto;
	private JTextField txtPri;
	

	public EcranArticle() {
		this.setTitle("Article");
		this.setSize(new Dimension(380,400));
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initIHM();
	}

	// méthode qui comprend tout le code permettant d'organiser l'écran
	private void initIHM() {

		// instanciation de nouveaux Panels (panel prinipal + panel radio + panel checkbox + panel button)
		JPanel masterPanel = new JPanel();
		JPanel radioPanel = new JPanel();
		JPanel checkBoxPanel = new JPanel();
		JPanel comboBoxPanel = new JPanel();
		JPanel btnPanel = new JPanel();
		
		
		// définition du type de disposition que l'on souhaite pour nos panels
		masterPanel.setLayout(new GridBagLayout());
		radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));
		checkBoxPanel.setLayout(new BoxLayout(checkBoxPanel, BoxLayout.Y_AXIS));
		comboBoxPanel.setLayout(new FlowLayout());
		btnPanel.setLayout(new FlowLayout());
		
		
		// création d'une instance pour gérer les contraintes de disposition des
		// éléments du layout principal 
		GridBagConstraints gbc = new GridBagConstraints();
		Insets inset = new Insets(2,10,2,10);

		// paramétrage des marges des éléments de l'écran principal
		gbc.insets = inset;
		
		// ajout des éléments graphiques au panel radio
		radioPanel.add(new JRadioButton("Ramette"));
		radioPanel.add(new JRadioButton("Stylo"));
		
		// ajout des éléments graphiques au panel checkbox
		checkBoxPanel.add((new JCheckBox ("80 grammes")));
		checkBoxPanel.add((new JCheckBox ("100 grammes")));

		//ajout des éléments graphique au panel combobox
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBoxPanel.add(comboBox);	
		comboBox.addItem("noir");
		comboBox.addItem("rouge");
		comboBox.addItem("vert");
		comboBox.addItem("bleu");
		comboBox.addItem("jaune");
		comboBox.setSelectedItem(null);

		// ajout des éléments graphiques au panel bouton
			// création des icônes pour les boutons
		ImageIcon backButtonIcon = createImageIcon("/images/Back24.gif");
		ImageIcon newButtonIcon = createImageIcon("/images/New24.gif");
		ImageIcon saveButtonIcon = createImageIcon("/images/Save24.gif");
		ImageIcon deleteButtonIcon = createImageIcon("/images/Delete24.gif");
		ImageIcon forwardButtonIcon = createImageIcon("/images/Forward24.gif");
		
		btnPanel.add(new JButton(backButtonIcon));
		btnPanel.add(new JButton(newButtonIcon));
		btnPanel.add(new JButton(saveButtonIcon));
		btnPanel.add(new JButton(deleteButtonIcon));
		btnPanel.add(new JButton(forwardButtonIcon));
		
		// ajout des éléments graphiques au panel principal	
		// Ligne 1 : Référence
		gbc.gridy = 0;
			// colonne 1
		gbc.gridx = 0;
		masterPanel.add(getLblRef(), gbc);
			// colonne 2
		gbc.gridx = 1;
		masterPanel.add(getTxtRef(), gbc);

		// ligne 2 : Designation
		gbc.gridy = 1;
		gbc.gridx = 0;
		masterPanel.add(getLblDes(), gbc);

		gbc.gridx = 1;
		masterPanel.add(getTxtDes(), gbc);
		
		// ligne 3 : Marque
		gbc.gridy = 2;
		gbc.gridx = 0;
		masterPanel.add(getLblMar(), gbc);

		gbc.gridx = 1;
		masterPanel.add(getTxtMar(), gbc);
		
		// ligne 4 : Stock
		gbc.gridy = 3;
		gbc.gridx = 0;
		masterPanel.add(getLblSto(), gbc);

		gbc.gridx = 1;
		masterPanel.add(getTxtSto(), gbc);
		
		// ligne 5 : Prix
		gbc.gridy = 4;
		gbc.gridx = 0;
		masterPanel.add(getLblPri(), gbc);

		gbc.gridx = 1;
		masterPanel.add(getTxtPri(), gbc);
		
		// ligne 6 : Type
		gbc.gridy = 5;
		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		masterPanel.add(getLblTyp(), gbc);
		
		gbc.gridy = 5;
		gbc.gridx = 1;
		masterPanel.add(radioPanel,gbc);
		
		// ligne 7 : Grammage
		gbc.gridy = 6;
		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		masterPanel.add(getLblGra(), gbc);
		
		gbc.gridy = 6;
		gbc.gridx = 1;
		masterPanel.add(checkBoxPanel,gbc);
			
		// ligne 8 : Couleur
		gbc.gridy = 7;
		gbc.gridx = 0;
		masterPanel.add(getLblCou(), gbc);
		
		gbc.gridx=1;
		masterPanel.add(comboBoxPanel,gbc);
		
		// ligne 9 : Panel boutons
		gbc.gridy = 8;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		masterPanel.add(btnPanel,gbc);
		
		// lien du masterPanel à l'écran
		this.setContentPane(masterPanel);

	}
	
//------------------------------------------------------------------------
	public JLabel getLblRef() {
		if (lblRef == null) {
			lblRef = new JLabel("Référence ");
		}
		return lblRef;
	}

	public JTextField getTxtRef() {
		if (txtRef == null) {
			txtRef = new JTextField(20);
		}
		return txtRef;
	}

	public JLabel getLblDes() {
		if (lblDes == null) {
			lblDes = new JLabel("Désignation ");
		}
		return lblDes;
	}

	public JTextField getTxtDes() {
		if (txtDes == null) {
			txtDes = new JTextField(20);
		}
		return txtDes;
	}

	public JLabel getLblMar() {
		if (lblMar == null) {
			lblMar = new JLabel("Marque ");
		}
		return lblMar;
	}
	
	public JTextField getTxtMar() {
		if (txtMar == null) {
			txtMar = new JTextField(20);
		}
		return txtMar;
	}

	public JLabel getLblSto() {
		if (lblSto == null) {
			lblSto = new JLabel("Stock ");
		}
		return lblSto;
	}
	
	public JTextField getTxtSto() {
		if (txtSto == null) {
			txtSto = new JTextField(20);
		}
		return txtSto;
	}


	public JLabel getLblPri() {
		if (lblPri == null) {
			lblPri = new JLabel("Prix ");
		}
		return lblPri;
	}
	
	public JTextField getTxtPri() {
		if (txtPri == null) {
			txtPri = new JTextField(20);
		}
		return txtPri;
	}

	public JLabel getLblTyp() {
		if (lblTyp == null) {
			lblTyp = new JLabel("Type ");
		}
		return lblTyp;
	}


	public JLabel getLblGra() {
		if (lblGra == null) {
			lblGra = new JLabel("Grammage ");
		}
		return lblGra;
	}

	public JLabel getLblCou() {
		if (lblCou == null) {
			lblCou = new JLabel("Couleur ");
		}
		return lblCou;
	}
//-------------------------------------------------------------------------
	protected static ImageIcon createImageIcon(String path) {
	    java.net.URL imgURL = EcranArticle.class.getResource(path);
	    return new ImageIcon(imgURL);
	}
}
