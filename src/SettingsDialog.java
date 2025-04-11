package haditech;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.KeyStroke;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

import haditech.Intro.Language;
import mhmdsabdlh.component.RoundButton;
import mhmdsabdlh.component.OverlayPanel.OverlayPanel;
import mhmdsabdlh.images.ImageEffect;
import mhmdsabdlh.text.TextEffect;
import raven.modal.Toast;
import raven.modal.toast.option.ToastDirection;
import raven.modal.toast.option.ToastLocation;
import raven.modal.toast.option.ToastStyle;
import raven.slider.SliderGradient;
import raven.switchbutton.SwitchButton;
import raven.switchbutton.SwitchListener;

public class SettingsDialog extends JDialog {
	private JPanel rightPanel; // Panel to display the selected settings content
	private String currentpath = System.getProperty("user.dir");
	private File dataFolder = new File(currentpath + "\\data");
	private File confFile = new File(dataFolder, "conf.dll");
	private String conf[] = new String[27];
	private Language language;
	private JComboBox<ImageIcon> languageCombo, iconOption;
	private JComboBox<String>  themeCombo, speedCombo, effectCombo, slideShowO, windowsCombo, sortStockS,
			notPosS;
	private SwitchButton shortKey, autoSaveO, soundOption, alwaysOnTopS, autoUpdateS, dockS, dateS, notS, autoCleanS,
			addStockS, eventSwitcher, saveStockS, showLicS, notBGS;
	private SliderGradient sliderGradient1, notiTimeS;
	private JLabel op2, op1, themeColor, op4, autoSave, soundEffect, op6, speedLabel, effectLabel, slideShowLabel,
			alwaysOnTop, autoUpdate, windowStyle, dockL, dateL, notL, autoCleanL, addStockL, eventD, saveStock,
			sortStockL, showLicL, notPosL, notTimeL, notBGL;
	final int ANIMATION_TIMER = 0, NOTIFICATION_TIMER = 1;
	// Dimension
	private Font font = Intro.myFontS, fontS;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int taskbarHeight = Toolkit.getDefaultToolkit().getScreenInsets(this.getGraphicsConfiguration()).bottom;
	private int height = (int) screenSize.getHeight() - taskbarHeight;
	private final String parentIdentifier;

	public SettingsDialog(JFrame parent, String frameTitle) {
		/* DIALOG DEF */
		super(parent, "Settings", true);
		setSize(parent.getWidth() * 2 / 3, parent.getHeight() * 2 / 3);
		setLocationRelativeTo(parent);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.parentIdentifier = frameTitle;
		fontS = new Font("Tahoma", Font.BOLD, parent.getWidth() / 114);

		/* Overlay */
		OverlayPanel overlay = new OverlayPanel();
		overlay.setBounds(0, 0, parent.getWidth(), parent.getHeight());
		overlay.setOpaque(false);
		overlay.setOverlayColor(getBackground());
		parent.getLayeredPane().add(overlay, JLayeredPane.PALETTE_LAYER);

		/* CONFIGURATION OPEN */
		openConfiguration();

		/* LEFT PANEL */
		JPanel leftPanel = new JPanel(new GridBagLayout()); // Center components vertically and horizontally

		// Create buttons for menu
		JButton generalButton = createMenuButton((language == Language.SPANISH ? "GENERAL"
				: language == Language.PORTUGUES ? "GERAL" : language == Language.ENGLISH ? "GENERAL" : "GÉNÉRAL"));
		JButton stockButton = createMenuButton("STOCK");
		JButton appearanceButton = createMenuButton(language == Language.SPANISH ? "APARIENCIA"
				: language == Language.PORTUGUES ? "APARÊNCIA"
						: language == Language.ENGLISH ? "APPEARANCE" : "SYSTÈME");
		JButton systemButton = createMenuButton(language == Language.SPANISH ? "SISTEMA"
				: language == Language.PORTUGUES ? "SISTEMA" : language == Language.ENGLISH ? "SYSTEM" : "SYSTÈME");
		JButton animationButton = createMenuButton(language == Language.SPANISH ? "ANIMACIÓN"
				: language == Language.PORTUGUES ? "ANIMAÇÃO"
						: language == Language.ENGLISH ? "ANIMATION" : "ANIMATION");

		generalButton.setBackground(getBackground());
		stockButton.setBackground(getBackground());
		appearanceButton.setBackground(getBackground());
		systemButton.setBackground(getBackground());
		animationButton.setBackground(getBackground());

		// Add buttons to the left panel
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.weighty = 1.0; // Distribute space vertically
		gbc.insets = new Insets(10, 0, 10, 0); // Add padding around buttons
		gbc.fill = GridBagConstraints.NONE; // Let buttons keep their size

		leftPanel.add(generalButton, gbc);
		leftPanel.add(stockButton, gbc);
		leftPanel.add(appearanceButton, gbc);
		leftPanel.add(systemButton, gbc);
		leftPanel.add(animationButton, gbc);

		/* RIGHT PANEL */
		rightPanel = new JPanel(new GridBagLayout()); // Use GridBagLayout for centering
		rightPanel.setBackground(getBackground()); // Default background for the content area

		// Add action listeners to buttons
		generalButton.addActionListener(_ -> showGeneralSettings());
		stockButton.addActionListener(_ -> showStockSettings());
		appearanceButton.addActionListener(_ -> showAppearanceSettings());
		systemButton.addActionListener(_ -> showSystemSettings());
		animationButton.addActionListener(_ -> showAnimationSettings());

		DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
		dlcr.setHorizontalAlignment(SwingConstants.CENTER);

		/* PANEL 1 : GENERAL */
		/* LANGUAGE */
		op2 = new JLabel(idiomaString(language)[2] + "*");
		op2.setFont(font);
		op2.setOpaque(true);
		URL englP = getClass().getResource("images/eng.png");
		URL esplP = getClass().getResource("images/esp.png");
		URL frlP = getClass().getResource("images/france.png");
		URL porlP = getClass().getResource("images/por.png");
		ImageIcon iconImages2[] = new ImageIcon[4];
		iconImages2[0] = ImageEffect.getScaledImage(new ImageIcon(esplP).getImage(), 180, 50);
		iconImages2[1] = ImageEffect.getScaledImage(new ImageIcon(porlP).getImage(), 180, 50);
		iconImages2[2] = ImageEffect.getScaledImage(new ImageIcon(englP).getImage(), 180, 50);
		iconImages2[3] = ImageEffect.getScaledImage(new ImageIcon(frlP).getImage(), 180, 50);
		languageCombo = new JComboBox<>(iconImages2);
		languageCombo.setPreferredSize(new Dimension(250, 40));
		languageCombo.setBackground(Intro.lightC);
		languageCombo.setForeground(Intro.blueD);
		languageCombo.setRenderer(dlcr);
		if (conf[7] != null)
			languageCombo.setSelectedIndex(Integer.valueOf(conf[7]));

		/* ALWAYS ON TOP */
		alwaysOnTop = new JLabel(idiomaString(language)[10]);
		alwaysOnTop.setFont(font);
		alwaysOnTop.setOpaque(true);
		alwaysOnTop.setToolTipText(idiomaString(language)[13]);
		alwaysOnTopS = new SwitchButton();
		if (conf[12] == null || !conf[12].equals("true")) {
			alwaysOnTopS.setOn(true);
		} else {
			alwaysOnTopS.setOn(false);
		}
		alwaysOnTopS.setPreferredSize(new Dimension(80, 40));
		alwaysOnTopS.setSwitchColor(Intro.goldM);
		alwaysOnTopS.setRound(999);

		/* AUTO UPDATE */
		autoUpdate = new JLabel(idiomaString(language)[11]);
		autoUpdate.setFont(font);
		autoUpdate.setOpaque(true);
		autoUpdate.setToolTipText(idiomaString(language)[12]);
		autoUpdateS = new SwitchButton();
		if (conf[13] == null || !conf[13].equals("true")) {
			autoUpdateS.setOn(true);
		} else {
			autoUpdateS.setOn(false);
		}
		autoUpdateS.setPreferredSize(new Dimension(80, 40));
		autoUpdateS.setSwitchColor(Intro.goldM);
		autoUpdateS.setRound(999);

		/* AUTO CLEAN */
		autoCleanL = new JLabel(idiomaString(language)[19]);
		autoCleanL.setFont(font);
		autoCleanL.setOpaque(true);
		autoCleanL.setToolTipText(idiomaString(language)[20]);
		autoCleanS = new SwitchButton();
		if (conf[18] == null || !conf[18].equals("true")) {
			autoCleanS.setOn(true);
		} else {
			autoCleanS.setOn(false);
		}
		autoCleanS.setPreferredSize(new Dimension(80, 40));
		autoCleanS.setSwitchColor(Intro.goldM);
		autoCleanS.setRound(999);

		/* PANEL 2 : STOCK */
		// show empty stock
		addStockL = new JLabel(idiomaString(language)[21]);
		addStockL.setFont(font);
		addStockL.setOpaque(true);
		addStockS = new SwitchButton();
		if (conf[19] == null || !conf[19].equals("true")) {
			addStockS.setOn(true);
		} else {
			addStockS.setOn(false);
		}
		addStockS.setSwitchColor(Intro.goldM);
		addStockS.setRound(999);
		addStockS.setPreferredSize(new Dimension(80, 40));
		// export summary of stock
		saveStock = new JLabel(idiomaString(language)[23]);
		saveStock.setToolTipText(idiomaString(language)[24]);
		saveStock.setFont(font);
		saveStock.setOpaque(true);
		saveStockS = new SwitchButton();
		if (conf[21] == null || !conf[21].equals("true")) {
			saveStockS.setOn(true);
		} else {
			saveStockS.setOn(false);
		}
		saveStockS.setSwitchColor(Intro.goldM);
		saveStockS.setRound(999);
		saveStockS.setPreferredSize(new Dimension(80, 40));
		// Sort stock
		sortStockL = new JLabel(idiomaString(language)[25]);
		sortStockL.setFont(font);
		sortStockL.setOpaque(true);
		String sortS[] = { "A-Z", "Z-A", idiomaString(language)[26] };
		sortStockS = new JComboBox<>(sortS);
		sortStockS.setRenderer(dlcr);
		sortStockS.setPreferredSize(new Dimension(180, 40));
		sortStockS.setFont(fontS);
		if (conf[22] != null)
			sortStockS.setSelectedIndex(Integer.valueOf(conf[22]));
		sortStockS.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sortStockS.setSelectedIndex(sortStockS.getSelectedIndex());
			}
		});
		// show totla of license days
		showLicL = new JLabel(idiomaString(language)[27]);
		showLicL.setToolTipText(idiomaString(language)[28]);
		showLicL.setFont(font);
		showLicL.setOpaque(true);
		showLicS = new SwitchButton();
		if (conf[23] == null || !conf[23].equals("true")) {
			showLicS.setOn(true);
		} else {
			showLicS.setOn(false);
		}
		showLicS.setSwitchColor(Intro.goldM);
		showLicS.setRound(999);
		showLicS.setPreferredSize(new Dimension(80, 40));

		/* PANEL 3 : STYLE */
		/* ICON */
		op1 = new JLabel(idiomaString(language)[0]);
		op1.setFont(font);
		URL cedros1 = getClass().getResource("images/icon/logo1.png");
		URL cedros2 = getClass().getResource("images/icon/logo2.png");
		URL cedros3 = getClass().getResource("images/icon/logo3.png");
		URL cedros4 = getClass().getResource("images/icon/logo4.png");
		URL cedros5 = getClass().getResource("images/icon/logo5.png");
		URL narjes = getClass().getResource("images/icon/logo6.png");
		ImageIcon iconImages[] = new ImageIcon[6];
		iconImages[0] = ImageEffect.getScaledImage(new ImageIcon(cedros1).getImage(), 50, 50);
		iconImages[1] = ImageEffect.getScaledImage(new ImageIcon(cedros2).getImage(), 50, 50);
		iconImages[2] = ImageEffect.getScaledImage(new ImageIcon(cedros3).getImage(), 50, 50);
		iconImages[3] = ImageEffect.getScaledImage(new ImageIcon(cedros4).getImage(), 50, 50);
		iconImages[4] = ImageEffect.getScaledImage(new ImageIcon(cedros5).getImage(), 50, 50);
		iconImages[5] = ImageEffect.getScaledImage(new ImageIcon(narjes).getImage(), 50, 50);
		iconOption = new JComboBox<>(iconImages);
		iconOption.setBorder(new LineBorder(Intro.grisD, 1));
		iconOption.setPreferredSize(new Dimension(80, 40));
		iconOption.setRenderer(dlcr);
		if (conf[0] != null)
			if (!conf[0].equalsIgnoreCase("null"))
				iconOption.setSelectedIndex(Integer.valueOf(conf[0]));
		iconOption.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				iconImages[0] = ImageEffect.getScaledImage(new ImageIcon(cedros1).getImage(), height / 3, height / 3);
				iconImages[1] = ImageEffect.getScaledImage(new ImageIcon(cedros2).getImage(), height / 3, height / 3);
				iconImages[2] = ImageEffect.getScaledImage(new ImageIcon(cedros3).getImage(), height / 3, height / 3);
				iconImages[3] = ImageEffect.getScaledImage(new ImageIcon(cedros4).getImage(), height / 3, height / 3);
				iconImages[4] = ImageEffect.getScaledImage(new ImageIcon(cedros5).getImage(), height / 3, height / 3);
				iconImages[5] = ImageEffect.getScaledImage(new ImageIcon(narjes).getImage(), height / 3, height / 3);
				Intro.icon1.setImage(iconImages[iconOption.getSelectedIndex()]);
				iconOption.setSelectedIndex(iconOption.getSelectedIndex());
			}
		});

		/* MODE */
		themeColor = new JLabel(idiomaString(language)[7] + "*");
		themeColor.setFont(font);
		String darkText = language == Language.SPANISH ? "MODO OSCURO"
				: language == Language.PORTUGUES ? "MODO ESCURO"
						: language == Language.ENGLISH ? "DARK MODE" : "MODE SOMBRE";
		String blueText = language == Language.SPANISH ? "MODO AZUL"
				: language == Language.PORTUGUES ? "MODO AZUL"
						: language == Language.ENGLISH ? "BLUE MODE" : "MODE BLEU";
		String lightText = language == Language.SPANISH ? "MODO CLARO"
				: language == Language.PORTUGUES ? "MODO CLARO"
						: language == Language.ENGLISH ? "LIGHT MODE" : "MODE CLAIR";
		String themeIcon[] = { darkText, blueText, lightText };
		themeCombo = new JComboBox<>(themeIcon);
		themeCombo.setRenderer(new ListCellRenderer<>() {
			@Override
			public Component getListCellRendererComponent(JList<? extends String> list, String value, int index,
					boolean isSelected, boolean cellHasFocus) {

				JLabel label = new JLabel(value);
				label.setOpaque(true); // Make the label's background visible
				label.setFont(fontS);
				label.setHorizontalAlignment(0);
				// Set background color based on item value
				if (darkText.equals(value)) {
					label.setBackground(Intro.blackM);
					label.setForeground(Intro.lightC);
					themeCombo.setBackground(Intro.blackM);
					themeCombo.setForeground(Intro.lightC);
				} else if (blueText.equals(value)) {
					label.setBackground(Intro.blueM);
					label.setForeground(Intro.lightC);
					themeCombo.setBackground(Intro.blueM);
					themeCombo.setForeground(Intro.lightC);
				} else {
					label.setBackground(Intro.lightC);
					label.setForeground(Intro.blackM);
					themeCombo.setBackground(Intro.lightC);
					themeCombo.setForeground(Intro.blackM);
				}

				// Change the color if the item is selected
				if (isSelected) {
					label.setBackground(label.getBackground().darker());
				}

				return label;
			}
		});
		themeCombo.setPreferredSize(new Dimension(180, 40));
		themeCombo.setFont(fontS);
		if (conf[10] != null)
			themeCombo.setSelectedIndex(Integer.valueOf(conf[10]));

		/* STYLE */
		windowStyle = new JLabel(idiomaString(language)[16] + "*");
		windowStyle.setFont(font);
		String themeText[] = { "FlatLaf", "MacOS", "Atom", "Material" };
		windowsCombo = new JComboBox<>(themeText);
		windowsCombo.setRenderer(dlcr);
		windowsCombo.setPreferredSize(new Dimension(180, 40));
		windowsCombo.setFont(fontS);
		if (conf[14] != null)
			windowsCombo.setSelectedIndex(Integer.valueOf(conf[14]));

		/* NOTIFICATION */
		notL = new JLabel(idiomaString(language)[18]);
		notL.setFont(font);
		notL.setToolTipText(language == Language.SPANISH ? "MOSTRAR/OCULTAR EL BOTÓN DE NOTIFICACIÓN"
				: language == Language.PORTUGUES ? "MOSTRAR/OCULTAR O BOTÃO DE NOTIFICAÇÃO"
						: language == Language.ENGLISH ? "SHOW/HIDE THE NOTIFICATION BUTTON"
								: "AFFICHER/MASQUER LE BOUTON DE NOTIFICATION");
		notS = new SwitchButton();
		if (conf[17] == null || !conf[17].equals("true")) {
			notS.setOn(true);
		} else {
			notS.setOn(false);
		}
		notS.setPreferredSize(new Dimension(80, 40));
		notS.setSwitchColor(Intro.goldM);
		notS.setRound(999);

		/* NOTIFICATION POS */
		notPosL = new JLabel(idiomaString(language)[29]);
		notPosL.setFont(font);
		String notText[] = { idiomaString(language)[30], idiomaString(language)[31], idiomaString(language)[32],
				idiomaString(language)[33], idiomaString(language)[34], idiomaString(language)[35],
				idiomaString(language)[36] };
		notPosS = new JComboBox<>(notText);
		notPosS.setRenderer(dlcr);
		notPosS.setPreferredSize(new Dimension(180, 40));
		notPosS.setFont(fontS);
		if (conf[24] != null)
			notPosS.setSelectedIndex(Integer.valueOf(conf[24]));

		/* NOTIFICATION timer */
		notTimeL = new JLabel(idiomaString(language)[37]);
		notTimeL.setFont(font);
		notiTimeS = new SliderGradient();
		if (conf[25] == null || !TextEffect.isInteger(conf[25])) {
			notiTimeS.setValue(3);
		} else {
			if (Integer.valueOf(conf[25]) < 1)
				notiTimeS.setValue(1);
			else if (Integer.valueOf(conf[25]) > 60)
				notiTimeS.setValue(60);
			else
				notiTimeS.setValue(Integer.valueOf(conf[25]));
		}
		notiTimeS.setPreferredSize(new Dimension(100, 50));
		notiTimeS.setOpaque(true);
		notiTimeS.setMajorTickSpacing(10);
		notiTimeS.setMinimum(0);
		notiTimeS.setMaximum(60);
		notiTimeS.setMinorTickSpacing(5);
		notiTimeS.setPaintLabels(true);
		notiTimeS.setPaintTicks(true);
		notiTimeS.setColor1(Intro.redM);
		notiTimeS.setColor2(Intro.goldM);
		notiTimeS.setToolTipText(notiTimeS.getValue() + " sec");
		notiTimeS.setTicksColor(getForeground());
		notiTimeS.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				if (notiTimeS.getValue() == 0)
					notiTimeS.setToolTipText("1 sec");
				else
					notiTimeS.setToolTipText(notiTimeS.getValue() + " sec");
			}
		});

		// not bg
		notBGL = new JLabel(idiomaString(language)[38]);
		notBGL.setFont(font);
		notBGL.setOpaque(true);
		notBGS = new SwitchButton();
		if (conf[26] == null || !conf[26].equals("true")) {
			notBGS.setOn(true);
		} else {
			notBGS.setOn(false);
		}
		notBGS.setSwitchColor(Intro.goldM);
		notBGS.setRound(999);
		notBGS.setPreferredSize(new Dimension(80, 40));

		/* PANEL 3 : SYSTEM */
		/* SHORTKEY */
		op4 = new JLabel(idiomaString(language)[3] + "*");
		op4.setFont(font);
		op4.setToolTipText(idiomaString(language)[15]);
		shortKey = new SwitchButton();
		if (conf[2] == null || !conf[2].equals("true")) {
			shortKey.setOn(true);
		} else {
			shortKey.setOn(false);
		}
		shortKey.setSwitchColor(Intro.goldM);
		shortKey.setRound(999);
		shortKey.setPreferredSize(new Dimension(80, 40));

		/* AUTO SAVE */
		autoSave = new JLabel(idiomaString(language)[4]);
		autoSave.setFont(font);
		autoSave.setToolTipText(
				(language == Language.SPANISH ? "Habilitar guardar automáticamente cada cambio automáticamente"
						: language == Language.PORTUGUES
								? "Activer l'enregistrement automatique de chaque modification automatiquement"
								: language == Language.ENGLISH ? "Enable auto save every change automatically"
										: "Activer l'enregistrement automatique de chaque modification automatiquement")
						.toUpperCase());
		autoSaveO = new SwitchButton();
		if (conf[4] == null || !conf[4].equals("true")) {
			autoSaveO.setOn(true);
		} else {
			autoSaveO.setOn(false);
		}
		autoSaveO.setPreferredSize(new Dimension(80, 40));
		autoSaveO.setSwitchColor(Intro.goldM);
		autoSaveO.setRound(999);

		/* SOUND EFFECT */
		soundEffect = new JLabel(idiomaString(language)[8]);
		soundEffect.setFont(font);
		soundEffect.setToolTipText(language == Language.SPANISH ? "HACER EFECTO CUANDO ALGO SUCEDE"
				: language == Language.PORTUGUES ? "FAÇA UM EFEITO QUANDO ALGO ACONTECER"
						: language == Language.ENGLISH ? "MAKE AN EFFECT WHEN SOMETHING HAPPEN"
								: "PRODUIRE UN EFFET QUAND QUELQUE CHOSE SE PRODUIT");
		soundOption = new SwitchButton();
		if (conf[1] == null || !conf[1].equals("true")) {
			soundOption.setOn(true);
		} else {
			soundOption.setOn(false);
		}
		soundOption.setPreferredSize(new Dimension(80, 40));
		soundOption.setSwitchColor(Intro.goldM);
		soundOption.setRound(999);

		/* DOCK */
		dockL = new JLabel("DOCK");
		dockL.setFont(font);
		dockL.setToolTipText(language == Language.SPANISH ? "MOSTRAR/OCULTAR EL DOCK"
				: language == Language.PORTUGUES ? "MOSTRAR/OCULTAR O DOCK"
						: language == Language.ENGLISH ? "SHOW/HIDE THE DOCK" : "AFFICHER/MASQUER LE DOCK");
		dockS = new SwitchButton();
		if (conf[15] == null || !conf[15].equals("true")) {
			dockS.setOn(true);
		} else {
			dockS.setOn(false);
		}
		dockS.setPreferredSize(new Dimension(80, 40));
		dockS.setSwitchColor(Intro.goldM);
		dockS.setRound(999);

		/* DATE */
		dateL = new JLabel(idiomaString(language)[17]);
		dateL.setFont(font);
		dateL.setToolTipText(language == Language.SPANISH ? "MOSTRAR/OCULTAR LA FECHA"
				: language == Language.PORTUGUES ? "MOSTRAR/OCULTAR A DATA"
						: language == Language.ENGLISH ? "SHOW/HIDE THE DATE" : "AFFICHER/MASQUER LA DATE");
		dateS = new SwitchButton();
		if (conf[16] == null || !conf[16].equals("true")) {
			dateS.setOn(true);
		} else {
			dateS.setOn(false);
		}
		dateS.setPreferredSize(new Dimension(80, 40));
		dateS.setSwitchColor(Intro.goldM);
		dateS.setRound(999);

		/* PANEL 4 : ANIMATION */
		/* SLIDESHOW */
		slideShowLabel = new JLabel(idiomaString(language)[9]);
		slideShowLabel.setFont(font);
		slideShowLabel.setToolTipText(language == Language.SPANISH
				? "REPRODUCE ALGÚN EFECTO O BLOQUEA LA APLICACIÓN CUANDO LA PANTALLA NO SE MUEVE DURANTE X MINUTOS"
				: language == Language.PORTUGUES
						? "REPRODUZA ALGUM EFEITO OU BLOQUEIE O APLICATIVO QUANDO A TELA NÃO SE MOVIMENTAR POR X MINUTOS"
						: language == Language.ENGLISH
								? "PLAY SOME EFFECT OR LOCK THE APP WHEN THE SCREEN IS NOT MOVING FOR X MINUTES"
								: "JOUER UN EFFET OU VERROUILLER L'APPLICATION LORSQUE L'ÉCRAN NE BOUGE PAS PENDANT X MINUTES");
		String disable = language == Language.SPANISH ? "DESACTIVAR"
				: language == Language.PORTUGUES ? "DESATIVAR"
						: language == Language.ENGLISH ? "DISABLE" : "DÉSACTIVER";
		String lock = language == Language.SPANISH ? "BLOQUEO AUTOMÁTICO"
				: language == Language.PORTUGUES ? "BLOQUEIO AUTOMÁTICO"
						: language == Language.ENGLISH ? "AUTO-LOCK" : "VERROUILLAGE AUTOMATIQUE";
		String effect = language == Language.SPANISH ? "EFECTO"
				: language == Language.PORTUGUES ? "EFEITO" : language == Language.ENGLISH ? "EFFECT" : "EFFET";
		String slideShow[] = { disable, lock, effect };
		slideShowO = new JComboBox<>(slideShow);
		slideShowO.setPreferredSize(new Dimension(250, 40));
		slideShowO.setFont(fontS);
		slideShowO.setRenderer(dlcr);
		if (conf[11] != null)
			slideShowO.setSelectedIndex(Integer.valueOf(conf[11]));

		/* TIME OF SLIDESHOW */
		op6 = new JLabel(
				(language == Language.SPANISH ? "TIEMPO "
						: language == Language.PORTUGUES ? "TEMPO DE "
								: language == Language.ENGLISH ? "TIME FOR " : "TEMPS DE ")
						+ idiomaString(language)[9]);
		op6.setFont(font);
		sliderGradient1 = new SliderGradient();
		if (conf[3] == null || !TextEffect.isInteger(conf[3])) {
			sliderGradient1.setValue(10);
		} else {
			if (Integer.valueOf(conf[3]) < 1)
				sliderGradient1.setValue(1);
			else if (Integer.valueOf(conf[3]) > 60)
				sliderGradient1.setValue(60);
			else
				sliderGradient1.setValue(Integer.valueOf(conf[3]));
		}
		sliderGradient1.setPreferredSize(new Dimension(100, 50));
		sliderGradient1.setOpaque(true);
		sliderGradient1.setMajorTickSpacing(10);
		sliderGradient1.setMinimum(0);
		sliderGradient1.setMaximum(60);
		sliderGradient1.setMinorTickSpacing(5);
		sliderGradient1.setPaintLabels(true);
		sliderGradient1.setPaintTicks(true);
		sliderGradient1.setColor1(Intro.redM);
		sliderGradient1.setColor2(Intro.goldM);
		sliderGradient1.setToolTipText(sliderGradient1.getValue() + " min");
		sliderGradient1.setTicksColor(getForeground());
		sliderGradient1.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				if (sliderGradient1.getValue() == 0)
					sliderGradient1.setToolTipText("1 min");
				else
					sliderGradient1.setToolTipText(sliderGradient1.getValue() + " min");
			}
		});

		/* SPEED OF ANIMATION */
		speedLabel = new JLabel(language == Language.SPANISH ? "VELOCIDAD DE ANIMACIÓN"
				: language == Language.PORTUGUES ? "VELOCIDADE DA ANIMAÇÃO"
						: language == Language.ENGLISH ? "ANIMATION SPEED" : "LA VITESSE D'ANIMATION");
		speedLabel.setFont(font);
		String slow = language == Language.SPANISH ? "LENTO"
				: language == Language.PORTUGUES ? "LENTO" : language == Language.ENGLISH ? "SLOW" : "LENTE";
		String meduim = language == Language.SPANISH ? "MEDIANO"
				: language == Language.PORTUGUES ? "MÉDIO" : language == Language.ENGLISH ? "MEDIUM" : "MOYEN";
		String fast = language == Language.SPANISH ? "RÁPIDO"
				: language == Language.PORTUGUES ? "RÁPIDO" : language == Language.ENGLISH ? "FAST" : "RAPIDE";
		String speedText[] = { slow, meduim, fast };
		speedCombo = new JComboBox<>(speedText);
		speedCombo.setRenderer(dlcr);
		speedCombo.setPreferredSize(new Dimension(250, 40));
		speedCombo.setFont(fontS);
		if (conf[6] != null)
			speedCombo.setSelectedIndex(Integer.valueOf(conf[6]));

		/* EFFECT OF ANIMATION */
		effectLabel = new JLabel(language == Language.SPANISH ? "EFECTO"
				: language == Language.PORTUGUES ? "EFEITO" : language == Language.ENGLISH ? "EFFECT" : "EFFET");
		effectLabel.setFont(font);
		String eff1 = language == Language.SPANISH ? "APARIENCIA GRADUAL"
				: language == Language.PORTUGUES ? "APARECIMENTO GRADUAL"
						: language == Language.ENGLISH ? "FADING" : "DÉCOLORATION";
		String eff2 = language == Language.SPANISH ? "APARECE PALABRA POR PALABRA"
				: language == Language.PORTUGUES ? "APARECE PALAVRA POR PALAVRA"
						: language == Language.ENGLISH ? "APPEAR WORD BY WORD" : "APPARAÎTRE MOT PAR MOT";
		String eff3 = language == Language.SPANISH ? "APARECE LETRA POR LETRA"
				: language == Language.PORTUGUES ? "APARECE LETRA POR LETRA"
						: language == Language.ENGLISH ? "APPEAR LETTER BY LETTER" : "APPARAÎTRE LETTRE PAR LETTRE";
		String eff4 = language == Language.SPANISH ? "LETRAS REVUELTAS"
				: language == Language.PORTUGUES ? "LETRAS EMBARALHADAS"
						: language == Language.ENGLISH ? "LETTERS SCRAMBLE" : "LETTRES SCRAMBLE";
		String effString[] = { eff1, eff2, eff3, eff4 };
		effectCombo = new JComboBox<>(effString);
		effectCombo.setRenderer(dlcr);
		effectCombo.setPreferredSize(new Dimension(220, 40));
		effectCombo.setFont(fontS);
		if (conf[8] != null)
			effectCombo.setSelectedIndex(Integer.valueOf(conf[8]));

		/* event bg */
		eventD = new JLabel(idiomaString(language)[22]);
		eventD.setFont(font);
		eventD.setOpaque(true);
		eventSwitcher = new SwitchButton();
		if (conf[20] == null || !conf[20].equals("true")) {
			eventSwitcher.setOn(true);
		} else {
			eventSwitcher.setOn(false);
		}
		eventSwitcher.setSwitchColor(Intro.goldM);
		eventSwitcher.setRound(999);

		// Create panel for bottom buttons (Save & Default)
		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		RoundButton saveButton = new RoundButton(idiomaString(language)[6], 10);
		RoundButton defaultButton = new RoundButton(idiomaString(language)[5], 10);
		saveButton.setFillColor(Intro.goldM);
		saveButton.setForeground(Intro.lightC);
		saveButton.setBorderColorAndRadius(getForeground());

		defaultButton.setFillColor(Intro.redM);
		defaultButton.setForeground(Intro.lightC);
		defaultButton.setBorderColorAndRadius(getForeground());
		defaultButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				iconOption.setSelectedIndex(1);
				setIconImage(iconImages[1].getImage());
				sliderGradient1.setValue(10);
				soundOption.setOn(true);
				shortKey.setOn(true);
				autoSaveO.setOn(true);
				languageCombo.setSelectedIndex(0);
				themeCombo.setSelectedIndex(0);
				effectCombo.setSelectedIndex(0);
				speedCombo.setSelectedIndex(0);
				slideShowO.setSelectedIndex(1);
				alwaysOnTopS.setOn(false);
				autoSaveO.setOn(true);
				windowsCombo.setSelectedIndex(0);
				dockS.setOn(true);
				dateS.setOn(true);
				notS.setOn(true);
				autoCleanS.setOn(true);
				addStockS.setOn(true);
				eventSwitcher.setOn(true);
				saveStockS.setOn(true);
				sortStockS.setSelectedIndex(0);
				showLicS.setOn(true);
				notPosS.setSelectedIndex(0);
				notiTimeS.setValue(3);
				notBGS.setOn(true);
			}
		});
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String shortk = conf[2], langS = conf[7], themeS = conf[10], styleS = conf[14];
				try {
					dataFolder.mkdir();
					FileWriter savedF = new FileWriter(confFile);
					savedF.write(iconOption.getSelectedIndex() + System.lineSeparator());// icon 0 1 2 3 4 5
					savedF.write(!soundOption.isOn() + System.lineSeparator());// SOUND EFFECT true false
					savedF.write(!shortKey.isOn() + System.lineSeparator());// key shortcut true false
					savedF.write(sliderGradient1.getValue() + System.lineSeparator());// autolock
					savedF.write(!autoSaveO.isOn() + System.lineSeparator());// auto save true false
					savedF.write( System.lineSeparator());// Intro frame 0 1 2 3
					savedF.write(speedCombo.getSelectedIndex() + System.lineSeparator());// speed 0 1 2
					savedF.write(languageCombo.getSelectedIndex() + System.lineSeparator());// lang 0 1 2 3
					savedF.write(effectCombo.getSelectedIndex() + System.lineSeparator());// effect 0 1 2 3
					savedF.write("" + System.lineSeparator());// intro
					savedF.write(themeCombo.getSelectedIndex() + System.lineSeparator());// theme 0 1 2
					savedF.write(slideShowO.getSelectedIndex() + System.lineSeparator());// slideshow option
					savedF.write(!alwaysOnTopS.isOn() + System.lineSeparator());// alwaysontop
					savedF.write(!autoUpdateS.isOn() + System.lineSeparator());// autoupdate
					savedF.write(windowsCombo.getSelectedIndex() + System.lineSeparator());// style
					savedF.write(!dockS.isOn() + System.lineSeparator());// dock
					savedF.write(!dateS.isOn() + System.lineSeparator());// date
					savedF.write(!notS.isOn() + System.lineSeparator());// notification
					savedF.write(!autoCleanS.isOn() + System.lineSeparator());// autoclean
					savedF.write(!addStockS.isOn() + System.lineSeparator());// no0 stock
					savedF.write(!eventSwitcher.isOn() + System.lineSeparator());// EVE
					savedF.write(!saveStockS.isOn() + System.lineSeparator());// SAVE stock
					savedF.write(sortStockS.getSelectedIndex() + System.lineSeparator());// SORT 0 1 2
					savedF.write(!showLicS.isOn() + System.lineSeparator());// SHOW LIC
					savedF.write(notPosS.getSelectedIndex() + System.lineSeparator());// POS 0 1 2 3 4 5 6
					savedF.write(notiTimeS.getValue() + System.lineSeparator());// not timer 1-60
					savedF.write(!notBGS.isOn() + System.lineSeparator());// not bg
					savedF.close();
				} catch (Exception e2) {
					writeError(e2);
				}
				if (!shortk.equalsIgnoreCase(!shortKey.isOn() + "")
						|| !langS.equalsIgnoreCase(languageCombo.getSelectedIndex() + "")
						|| !themeS.equalsIgnoreCase(themeCombo.getSelectedIndex() + "")
						|| !styleS.equalsIgnoreCase(windowsCombo.getSelectedIndex() + "")) {
					dispose();
					parent.getLayeredPane().remove(overlay);
					parent.getLayeredPane().repaint();
					parent.dispose();
					switch (parentIdentifier) {
					case "Intro":
						new Intro();
						break;
					case "reales":
						new Main();
						break;
					case "faturar":
						new FaturaR();
						break;
					default:
						throw new IllegalStateException("Unknown parent identifier: " + parentIdentifier);
					}
				} else {
					conf[0] = iconOption.getSelectedIndex() + "";
					conf[1] = !soundOption.isOn() + "";// sound
					conf[3] = sliderGradient1.getValue() + "";// slider
					conf[4] = !autoSaveO.isOn() + "";// autosave
					conf[6] = speedCombo.getSelectedIndex() + "";
					conf[8] = effectCombo.getSelectedIndex() + "";
					conf[9] = "";
					conf[11] = slideShowO.getSelectedIndex() + "";
					conf[12] = !alwaysOnTopS.isOn() + "";
					conf[13] = !autoUpdateS.isOn() + "";
					conf[14] = windowsCombo.getSelectedIndex() + "";
					conf[15] = !dockS.isOn() + "";
					conf[16] = !dateS.isOn() + "";
					conf[17] = !notS.isOn() + "";
					conf[18] = !autoCleanS.isOn() + "";
					conf[19] = !addStockS.isOn() + "";
					conf[20] = !eventSwitcher.isOn() + "";
					conf[21] = !saveStockS.isOn() + "";
					conf[22] = sortStockS.getSelectedIndex() + "";
					conf[23] = !showLicS.isOn() + "";
					conf[24] = notPosS.getSelectedIndex() + "";
					conf[25] = notiTimeS.getValue() + "";
					if (notPosS.getSelectedIndex() == 0)
						Intro.notOption.getLayoutOption().setLocation(0f, taskbarHeight)
								.setDirection(ToastDirection.TOP_TO_BOTTOM);
					else if (notPosS.getSelectedIndex() == 1)
						Intro.notOption.getLayoutOption().setLocation(0.5f, taskbarHeight)
								.setDirection(ToastDirection.TOP_TO_BOTTOM);
					else if (notPosS.getSelectedIndex() == 2)
						Intro.notOption.getLayoutOption().setLocation(1f, taskbarHeight)
								.setDirection(ToastDirection.TOP_TO_BOTTOM);
					else if (notPosS.getSelectedIndex() == 3)
						Intro.notOption.getLayoutOption().setLocation(0.5f, 0.5f)
								.setDirection(ToastDirection.TOP_TO_BOTTOM);
					else if (notPosS.getSelectedIndex() == 4)
						Intro.notOption.getLayoutOption().setLocation(ToastLocation.BOTTOM_LEADING)
								.setDirection(ToastDirection.TOP_TO_BOTTOM);
					else if (notPosS.getSelectedIndex() == 5)
						Intro.notOption.getLayoutOption().setLocation(ToastLocation.BOTTOM_CENTER)
								.setDirection(ToastDirection.TOP_TO_BOTTOM);
					else
						Intro.notOption.getLayoutOption().setLocation(ToastLocation.BOTTOM_TRAILING)
								.setDirection(ToastDirection.TOP_TO_BOTTOM);
					Intro.notOption.setDelay(notiTimeS.getValue() == 0 ? 1000 : notiTimeS.getValue() * 1000);
					if (notBGS.isOn())
						Intro.notOption.getStyle().setBackgroundType(ToastStyle.BackgroundType.GRADIENT);
					else
						Intro.notOption.getStyle().setBackgroundType(ToastStyle.BackgroundType.DEFAULT);
					Timer fadeOutTimer = new Timer(5, null);
					fadeOutTimer.addActionListener(_ -> {
						float currentAlpha = overlay.getAlpha();
						if (currentAlpha > 0.05f) {
							overlay.setAlpha(currentAlpha - 0.05f); // Increase opacity gradually
						} else {
							overlay.setAlpha(currentAlpha);
							fadeOutTimer.stop(); // Stop timer when fully transparent
							dispose(); // Dispose the dialog
							parent.getLayeredPane().remove(overlay);
							parent.getLayeredPane().repaint();
						}
					});
					fadeOutTimer.start(); // Start fade-out effect
				}
			}
		});

		bottomPanel.add(saveButton);
		bottomPanel.add(defaultButton);
		// Changelistener
		shortKey.addEventSwitchSelected(new SwitchListener() {
			@Override
			public void selectChange(boolean on) {
				String shortk = conf[2], langS = conf[7], themeS = conf[10], styleS = conf[14];
				if (styleS.equalsIgnoreCase(windowsCombo.getSelectedIndex() + "")
						&& themeS.equalsIgnoreCase(themeCombo.getSelectedIndex() + "")
						&& langS.equalsIgnoreCase(languageCombo.getSelectedIndex() + ""))
					if (!shortk.equalsIgnoreCase(!shortKey.isOn() + "")) {
						String dialogSubtitle = language == Language.SPANISH ? "LA APLICACIÓN SE REINICIARÁ"
								: language == Language.PORTUGUES ? "O APLICATIVO SERÁ REINICIADO"
										: language == Language.ENGLISH ? "THE APP WILL RESTART"
												: "L'APPLICATION VA REDÉMARRER";
						saveButton.setToolTipText(dialogSubtitle);
						saveButton.setText(idiomaString(language)[6] + "*");
					} else {
						saveButton.setToolTipText("");
						saveButton.setText(idiomaString(language)[6]);
					}
			}
		});
		themeCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String shortk = conf[2], langS = conf[7], themeS = conf[10], styleS = conf[14];
				int selected = themeCombo.getSelectedIndex();
				if (styleS.equalsIgnoreCase(windowsCombo.getSelectedIndex() + "")
						&& shortk.equalsIgnoreCase(!shortKey.isOn() + "")
						&& langS.equalsIgnoreCase(languageCombo.getSelectedIndex() + ""))
					if (!themeS.equalsIgnoreCase(selected + "")) {
						String dialogSubtitle = language == Language.SPANISH ? "LA APLICACIÓN SE REINICIARÁ"
								: language == Language.PORTUGUES ? "O APLICATIVO SERÁ REINICIADO"
										: language == Language.ENGLISH ? "THE APP WILL RESTART"
												: "L'APPLICATION VA REDÉMARRER";
						saveButton.setToolTipText(dialogSubtitle);
						saveButton.setText(idiomaString(language)[6] + "*");
					} else {
						saveButton.setToolTipText("");
						saveButton.setText(idiomaString(language)[6]);
					}
				themeCombo.setSelectedIndex(selected);
			}
		});
		languageCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String shortk = conf[2], langS = conf[7], themeS = conf[10], styleS = conf[14];
				int selected = languageCombo.getSelectedIndex();
				if (styleS.equalsIgnoreCase(windowsCombo.getSelectedIndex() + "")
						&& shortk.equalsIgnoreCase(!shortKey.isOn() + "")
						&& themeS.equalsIgnoreCase(themeCombo.getSelectedIndex() + ""))
					if (!langS.equalsIgnoreCase(selected + "")) {
						String dialogSubtitle = language == Language.SPANISH ? "LA APLICACIÓN SE REINICIARÁ"
								: language == Language.PORTUGUES ? "O APLICATIVO SERÁ REINICIADO"
										: language == Language.ENGLISH ? "THE APP WILL RESTART"
												: "L'APPLICATION VA REDÉMARRER";
						saveButton.setToolTipText(dialogSubtitle);
						saveButton.setText(idiomaString(language)[6] + "*");
					} else {
						saveButton.setToolTipText("");
						saveButton.setText(idiomaString(language)[6]);
					}
				languageCombo.setSelectedIndex(selected);
			}
		});
		windowsCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String shortk = conf[2], langS = conf[7], themeS = conf[10], styleS = conf[14];
				int selected = windowsCombo.getSelectedIndex();
				if (themeS.equalsIgnoreCase(selected + "") && shortk.equalsIgnoreCase(!shortKey.isOn() + "")
						&& langS.equalsIgnoreCase(languageCombo.getSelectedIndex() + ""))
					if (!styleS.equalsIgnoreCase(windowsCombo.getSelectedIndex() + "")) {
						String dialogSubtitle = language == Language.SPANISH ? "LA APLICACIÓN SE REINICIARÁ"
								: language == Language.PORTUGUES ? "O APLICATIVO SERÁ REINICIADO"
										: language == Language.ENGLISH ? "THE APP WILL RESTART"
												: "L'APPLICATION VA REDÉMARRER";
						saveButton.setToolTipText(dialogSubtitle);
						saveButton.setText(idiomaString(language)[6] + "*");
					} else {
						saveButton.setToolTipText("");
						saveButton.setText(idiomaString(language)[6]);
					}
				windowsCombo.setSelectedIndex(selected);
			}
		});

		// Escape to close
		getRootPane().registerKeyboardAction(_ -> {
			Timer fadeOutTimer = new Timer(5, null);
			fadeOutTimer.addActionListener(_ -> {
				float currentAlpha = overlay.getAlpha();
				if (currentAlpha > 0.05f) {
					overlay.setAlpha(currentAlpha - 0.05f); // Increase opacity gradually
				} else {
					overlay.setAlpha(currentAlpha);
					fadeOutTimer.stop(); // Stop timer when fully transparent
					dispose(); // Dispose the dialog
					parent.getLayeredPane().remove(overlay);
					parent.getLayeredPane().repaint();
				}
			});
			fadeOutTimer.start(); // Start fade-out effect
		}, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				try {
					Timer fadeOutTimer = new Timer(5, null);
					fadeOutTimer.addActionListener(_ -> {
						float currentAlpha = overlay.getAlpha();
						if (currentAlpha > 0.05f) {
							overlay.setAlpha(currentAlpha - 0.05f); // Increase opacity gradually
						} else {
							overlay.setAlpha(currentAlpha);
							fadeOutTimer.stop(); // Stop timer when fully transparent
							dispose(); // Dispose the dialog
							parent.getLayeredPane().remove(overlay);
							parent.getLayeredPane().repaint();
						}
					});
					fadeOutTimer.start(); // Start fade-out effect
				} catch (Exception e4) {
					writeError(e4);
				}
			}
		});

		showGeneralSettings(); // Show "General" settings by default

		// Combine left and right panels using JSplitPane
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
		splitPane.setDividerSize(5); // Size of the divider
		splitPane.setDividerLocation(150); // Initial position of the divider
		splitPane.setOneTouchExpandable(true); // Allow resizing of panels
		splitPane.setBackground(getForeground());

		// Add split pane and bottom panel to dialog
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(splitPane, BorderLayout.CENTER);
		getContentPane().add(bottomPanel, BorderLayout.SOUTH);

		// Inside the constructor, after the dialog size and location configuration
		overlay.setAlpha(0);
		Timer fadeInTimer = new Timer(5, null);
		fadeInTimer.addActionListener(_ -> {
			float currentAlpha = overlay.getAlpha();
			if (currentAlpha < 0.5f) {
				overlay.setAlpha(currentAlpha + 0.05f); // Increase opacity gradually
			} else {
				overlay.setAlpha(currentAlpha);
				fadeInTimer.stop(); // Stop timer when fully visible
			}
		});
		fadeInTimer.start(); // Start fade-in effect

		// Set dialog window to be non-resizable for better layout control
		setResizable(false);
		setVisible(true);
	}

	private void openConfiguration() {
		dataFolder.mkdir();
		BufferedReader dataOpened = null;
		String line = "";
		int z = 0;
		try {
			dataOpened = new BufferedReader(new FileReader(confFile));
			while ((line = dataOpened.readLine()) != null) {
				conf[z] = line.toString();
				z++;
			}
			dataOpened.close();
		} catch (Exception e) {
			// Check if a conf file exist
			if (conf[0] == null || !confFile.exists()) {
				try {
					FileWriter savedF = new FileWriter(confFile);
					savedF.write(0 + System.lineSeparator());// icon
					savedF.write("false" + System.lineSeparator());/// sound effect
					savedF.write("false" + System.lineSeparator());// key shortcut
					savedF.write(10 + System.lineSeparator());// autolock
					savedF.write("false" + System.lineSeparator());// auto save
					savedF.write(0 + System.lineSeparator());// Intro frame
					savedF.write(1 + System.lineSeparator());// speed
					savedF.write(0 + System.lineSeparator());// lang
					savedF.write(0 + System.lineSeparator());// effect chooser
					savedF.write("true" + System.lineSeparator());// intro
					savedF.write("0" + System.lineSeparator());// theme
					savedF.write("1" + System.lineSeparator());// ANIMATION
					savedF.write("true" + System.lineSeparator());// ALWAYS ON TOP
					savedF.write("false" + System.lineSeparator());// AUTO UPDATE
					savedF.write("0" + System.lineSeparator());// WINDOW STYLE
					savedF.write("false" + System.lineSeparator());// dock
					savedF.write("false" + System.lineSeparator());// date
					savedF.write("false" + System.lineSeparator());// not
					savedF.write("false" + System.lineSeparator());// autoclean
					savedF.write("false" + System.lineSeparator());// ST
					savedF.write("false" + System.lineSeparator());// EVENT
					savedF.write("false" + System.lineSeparator());// SAVE STK
					savedF.write("0" + System.lineSeparator());// sort
					savedF.write("false" + System.lineSeparator());// show lic
					savedF.write("0" + System.lineSeparator());// not pos
					savedF.write(3 + System.lineSeparator());// not tim
					savedF.write("false" + System.lineSeparator());// not grad
					savedF.close();
				} catch (Exception e1) {
					writeError(e1);
				}
				conf[0] = "0";
				conf[1] = "false";
				conf[2] = "false";
				conf[3] = "10";
				conf[4] = "false";
				conf[5] = "0";
				conf[6] = "1";
				conf[7] = "0";
				conf[8] = "0";
				conf[9] = "true";
				conf[10] = "0";
				conf[11] = "1";
				conf[12] = "true";
				conf[13] = "false";
				conf[14] = "0";
				conf[15] = "false";
				conf[16] = "false";
				conf[17] = "false";
				conf[18] = "false";
				conf[19] = "false";
				conf[20] = "false";
				conf[21] = "false";
				conf[22] = "0";
				conf[23] = "false";
				conf[24] = "0";
				conf[25] = "3";
				conf[26] = "false";
			}
		}
		confNull();
		/* LANGUAGE */
		if (conf[7].equals("0"))
			language = Language.SPANISH;
		else if (conf[7].equals("1"))
			language = Language.PORTUGUES;
		else if (conf[7].equals("2"))
			language = Language.ENGLISH;
		else
			language = Language.FRENCH;
	}

	private JButton createMenuButton(String title) {
		JButton button = new JButton(title);
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setFocusPainted(false);
		button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		return button;
	}

	private void showGeneralSettings() {
		rightPanel.removeAll();

		// Panel for section content
		JPanel contentPanel = new JPanel(new GridBagLayout());

		// Layout constraints
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10); // Padding around components
		gbc.fill = GridBagConstraints.BOTH;

		// Label
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		contentPanel.add(op2, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 0.0;
		contentPanel.add(languageCombo, gbc);

		// op3 auto update
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 1.0;
		contentPanel.add(autoUpdate, gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weightx = 0.0;
		contentPanel.add(autoUpdateS, gbc);

		// op4 always on top
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 1.0;
		contentPanel.add(alwaysOnTop, gbc);
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.weightx = 0.0;
		contentPanel.add(alwaysOnTopS, gbc);

		// o5 auto clean
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.weightx = 1.0;
		contentPanel.add(autoCleanL, gbc);
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.weightx = 0.0;
		contentPanel.add(autoCleanS, gbc);

		// Add to right panel
		rightPanel.add(contentPanel);
		rightPanel.revalidate();
		rightPanel.repaint();
	}

	private void showStockSettings() {
		rightPanel.removeAll();

		// Panel for section content
		JPanel contentPanel = new JPanel(new GridBagLayout());

		// Layout constraints
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10); // Padding around components
		gbc.fill = GridBagConstraints.BOTH;

		// Label
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		contentPanel.add(addStockL, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		contentPanel.add(addStockS, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		contentPanel.add(saveStock, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		contentPanel.add(saveStockS, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 1.0;
		contentPanel.add(sortStockL, gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weightx = 1.0;
		contentPanel.add(sortStockS, gbc);

		// LABEL
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 0.0;
		contentPanel.add(new JPanel(), gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.weightx = 1.0;
		contentPanel.add(showLicL, gbc);
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.weightx = 1.0;
		contentPanel.add(showLicS, gbc);

		// Add to right panel
		rightPanel.add(contentPanel);
		rightPanel.revalidate();
		rightPanel.repaint();
	}

	private void showAppearanceSettings() {
		rightPanel.removeAll();

		// Panel for section content
		JPanel contentPanel = new JPanel(new GridBagLayout());

		// Layout constraints
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10); // Padding around components
		gbc.fill = GridBagConstraints.BOTH;

		// op1 icon
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		contentPanel.add(op1, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 0.0;
		contentPanel.add(iconOption, gbc);

		// op2 theme
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		contentPanel.add(themeColor, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		contentPanel.add(themeCombo, gbc);

		// op3 style
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0.0;
		contentPanel.add(windowStyle, gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weightx = 0.0;
		contentPanel.add(windowsCombo, gbc);

		// empty
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 0.0;
		contentPanel.add(new JPanel(), gbc);

		// op4 not pos
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.weightx = 0.0;
		contentPanel.add(notPosL, gbc);
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.weightx = 0.0;
		contentPanel.add(notPosS, gbc);

		// op5 not time
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.weightx = 0.0;
		contentPanel.add(notTimeL, gbc);
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.weightx = 0.0;
		contentPanel.add(notiTimeS, gbc);

		// op6 not bg
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.weightx = 0.0;
		contentPanel.add(notBGL, gbc);
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.weightx = 0.0;
		contentPanel.add(notBGS, gbc);

		// Add to right panel
		rightPanel.add(contentPanel);
		rightPanel.revalidate();
		rightPanel.repaint();
	}

	private void showSystemSettings() {
		rightPanel.removeAll();

		// Panel for section content
		JPanel contentPanel = new JPanel(new GridBagLayout());

		// Layout constraints
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 10, 10, 20); // Padding around components
		gbc.fill = GridBagConstraints.BOTH;

		// shortkey
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.0;
		contentPanel.add(op4, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 0.0;
		contentPanel.add(shortKey, gbc);

		// autosave
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		contentPanel.add(autoSave, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		contentPanel.add(autoSaveO, gbc);

		// sound
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0.0;
		contentPanel.add(soundEffect, gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weightx = 0.0;
		contentPanel.add(soundOption, gbc);

		// dock
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 0.0;
		contentPanel.add(dockL, gbc);
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.weightx = 0.0;
		contentPanel.add(dockS, gbc);

		// intro
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.weightx = 0.0;
		contentPanel.add(dateL, gbc);
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.weightx = 0.0;
		contentPanel.add(dateS, gbc);

		// op4 not button
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.weightx = 0.0;
		contentPanel.add(notL, gbc);
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.weightx = 0.0;
		contentPanel.add(notS, gbc);

		// Add to right panel
		rightPanel.add(contentPanel);
		rightPanel.revalidate();
		rightPanel.repaint();
	}

	private void showAnimationSettings() {
		rightPanel.removeAll();

		// Panel for section content
		JPanel contentPanel = new JPanel(new GridBagLayout());

		// Layout constraints
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10); // Padding around components
		gbc.fill = GridBagConstraints.BOTH;

		// 1 event
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		contentPanel.add(eventD, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		contentPanel.add(eventSwitcher, gbc);

		// 2 slideshow
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		contentPanel.add(slideShowLabel, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		contentPanel.add(slideShowO, gbc);

		// 3 slideshow slider
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0.0;
		contentPanel.add(op6, gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		contentPanel.add(sliderGradient1, gbc);

		// 4 effect
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 1.0;
		contentPanel.add(effectLabel, gbc);
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.weightx = 1.0;
		contentPanel.add(effectCombo, gbc);

		// 5 speed
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.weightx = 1.0;
		contentPanel.add(speedLabel, gbc);
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.weightx = 1.0;
		contentPanel.add(speedCombo, gbc);

		// Add to right panel
		rightPanel.add(contentPanel);
		rightPanel.revalidate();
		rightPanel.repaint();
	}

	public int returnSliderValue(int animation) {
		if (animation == ANIMATION_TIMER)
			if (sliderGradient1.getValue() < 1)
				return 1 * 60 * 1000;
			else if (sliderGradient1.getValue() > 60)
				return 60 * 60 * 1000;
			else
				return sliderGradient1.getValue() * 60 * 1000;
		else if (notiTimeS.getValue() < 1)
			return 1 * 1000;
		else if (notiTimeS.getValue() > 60)
			return 60 * 1000;
		else
			return notiTimeS.getValue() * 1000;
	}

	private void confNull() {
		if (conf[0] == null || conf[0].equalsIgnoreCase("null")
				|| (!conf[0].equalsIgnoreCase("0") && !conf[0].equalsIgnoreCase("1") && !conf[0].equalsIgnoreCase("2")
						&& !conf[0].equalsIgnoreCase("3") && !conf[0].equalsIgnoreCase("4")
						&& !conf[0].equalsIgnoreCase("5")))
			conf[0] = "0";
		if (conf[1] == null || conf[1].equalsIgnoreCase("null")
				|| (!conf[1].equalsIgnoreCase("true") && !conf[1].equalsIgnoreCase("false")))
			conf[1] = "false";
		if (conf[2] == null || conf[2].equalsIgnoreCase("null")
				|| (!conf[2].equalsIgnoreCase("true") && !conf[2].equalsIgnoreCase("false")))
			conf[2] = "false";
		if (conf[3] == null || conf[3].equalsIgnoreCase("null") || (!TextEffect.isInteger(conf[3])))
			conf[3] = "10";
		if (conf[4] == null || conf[4].equalsIgnoreCase("null")
				|| (!conf[4].equalsIgnoreCase("true") && !conf[4].equalsIgnoreCase("false")))
			conf[4] = "false";
		if (conf[5] == null || conf[5].equalsIgnoreCase("null") || (!conf[5].equalsIgnoreCase("0")
				&& !conf[5].equalsIgnoreCase("1") && !conf[5].equalsIgnoreCase("2") && !conf[5].equalsIgnoreCase("3")))
			conf[5] = "0";
		if (conf[6] == null || conf[6].equalsIgnoreCase("null")
				|| (!conf[6].equalsIgnoreCase("0") && !conf[6].equalsIgnoreCase("1") && !conf[6].equalsIgnoreCase("2")))
			conf[6] = "0";
		if (conf[7] == null || conf[7].equalsIgnoreCase("null") || (!conf[7].equalsIgnoreCase("0")
				&& !conf[7].equalsIgnoreCase("1") && !conf[7].equalsIgnoreCase("2") && !conf[7].equalsIgnoreCase("3")))
			conf[7] = "0";
		if (conf[8] == null || conf[8].equalsIgnoreCase("null") || (!conf[8].equalsIgnoreCase("0")
				&& !conf[8].equalsIgnoreCase("1") && !conf[8].equalsIgnoreCase("2") && !conf[8].equalsIgnoreCase("3")))
			conf[8] = "0";
		if (conf[9] == null || conf[9].equalsIgnoreCase("null")
				|| (!conf[9].equalsIgnoreCase("true") && !conf[9].equalsIgnoreCase("false")))
			conf[9] = "true";
		if (conf[10] == null || conf[10].equalsIgnoreCase("null") || (!conf[10].equalsIgnoreCase("0")
				&& !conf[10].equalsIgnoreCase("1") && !conf[10].equalsIgnoreCase("2")))
			conf[10] = "0";
		if (conf[11] == null || conf[11].equalsIgnoreCase("null") || (!conf[11].equalsIgnoreCase("0")
				&& !conf[11].equalsIgnoreCase("1") && !conf[11].equalsIgnoreCase("2")))
			conf[11] = "1";
		if (conf[12] == null || conf[12].equalsIgnoreCase("null")
				|| (!conf[12].equalsIgnoreCase("true") && !conf[12].equalsIgnoreCase("false")))
			conf[12] = "true";
		if (conf[13] == null || conf[13].equalsIgnoreCase("null")
				|| (!conf[13].equalsIgnoreCase("true") && !conf[13].equalsIgnoreCase("false")))
			conf[13] = "false";
		if (conf[14] == null || conf[14].equalsIgnoreCase("null")
				|| (!conf[14].equalsIgnoreCase("0") && !conf[14].equalsIgnoreCase("1")
						&& !conf[14].equalsIgnoreCase("2") && !conf[14].equalsIgnoreCase("3")))
			conf[14] = "0";
		if (conf[15] == null || conf[15].equalsIgnoreCase("null")
				|| (!conf[15].equalsIgnoreCase("true") && !conf[15].equalsIgnoreCase("false")))
			conf[15] = "false";
		if (conf[16] == null || conf[16].equalsIgnoreCase("null")
				|| (!conf[16].equalsIgnoreCase("true") && !conf[16].equalsIgnoreCase("false")))
			conf[16] = "false";
		if (conf[17] == null || conf[17].equalsIgnoreCase("null")
				|| (!conf[17].equalsIgnoreCase("true") && !conf[17].equalsIgnoreCase("false")))
			conf[17] = "false";
		if (conf[18] == null || conf[18].equalsIgnoreCase("null")
				|| (!conf[18].equalsIgnoreCase("true") && !conf[18].equalsIgnoreCase("false")))
			conf[18] = "false";
		if (conf[19] == null || conf[19].equalsIgnoreCase("null")
				|| (!conf[19].equalsIgnoreCase("true") && !conf[19].equalsIgnoreCase("false")))
			conf[19] = "false";
		if (conf[20] == null || conf[20].equalsIgnoreCase("null")
				|| (!conf[20].equalsIgnoreCase("true") && !conf[20].equalsIgnoreCase("false")))
			conf[20] = "false";
		if (conf[21] == null || conf[21].equalsIgnoreCase("null")
				|| (!conf[21].equalsIgnoreCase("true") && !conf[21].equalsIgnoreCase("false")))
			conf[21] = "false";
		if (conf[22] == null || conf[22].equalsIgnoreCase("null")
				|| (!conf[22].equalsIgnoreCase("0") && !conf[22].equalsIgnoreCase("1")
						&& !conf[22].equalsIgnoreCase("2") && !conf[22].equalsIgnoreCase("3")))
			conf[22] = "0";
		if (conf[23] == null || conf[23].equalsIgnoreCase("null")
				|| (!conf[23].equalsIgnoreCase("true") && !conf[23].equalsIgnoreCase("false")))
			conf[23] = "false";
		if (conf[24] == null || conf[24].equalsIgnoreCase("null")
				|| (!conf[24].equalsIgnoreCase("0") && !conf[24].equalsIgnoreCase("1")
						&& !conf[24].equalsIgnoreCase("2") && !conf[24].equalsIgnoreCase("3")
						&& !conf[24].equalsIgnoreCase("4") && !conf[24].equalsIgnoreCase("5")
						&& !conf[24].equalsIgnoreCase("6")))
			conf[24] = "0";
		if (conf[25] == null || conf[5].equalsIgnoreCase("null") || (!TextEffect.isInteger(conf[25])))
			conf[25] = "3";
		if (conf[26] == null || conf[26].equalsIgnoreCase("null")
				|| (!conf[26].equalsIgnoreCase("true") && !conf[26].equalsIgnoreCase("false")))
			conf[26] = "false";
		try {
			FileWriter savedF = new FileWriter(confFile);
			savedF.write(conf[0] + System.lineSeparator());// icon
			savedF.write(conf[1] + System.lineSeparator());/// sound effect
			savedF.write(conf[2] + System.lineSeparator());// key shortcut
			savedF.write(conf[3] + System.lineSeparator());// res
			savedF.write(conf[4] + System.lineSeparator());// auto save
			savedF.write(conf[5] + System.lineSeparator());// Intro frame
			savedF.write(conf[6] + System.lineSeparator());// speed
			savedF.write(conf[7] + System.lineSeparator());// lang
			savedF.write(conf[8] + System.lineSeparator());// effect chooser
			savedF.write(conf[9] + System.lineSeparator());// intro
			savedF.write(conf[10] + System.lineSeparator());// theme
			savedF.write(conf[11] + System.lineSeparator());// theme
			savedF.write(conf[12] + System.lineSeparator());// theme
			savedF.write(conf[13] + System.lineSeparator());// theme
			savedF.write(conf[14] + System.lineSeparator());// style
			savedF.write(conf[15] + System.lineSeparator());// dock
			savedF.write(conf[16] + System.lineSeparator());// date
			savedF.write(conf[17] + System.lineSeparator());// not
			savedF.write(conf[18] + System.lineSeparator());// autoclean
			savedF.write(conf[19] + System.lineSeparator());// stock
			savedF.write(conf[20] + System.lineSeparator());// EVENT
			savedF.write(conf[21] + System.lineSeparator());// EVENT
			savedF.write(conf[22] + System.lineSeparator());// SORT STOCK
			savedF.write(conf[23] + System.lineSeparator());// SHOW LIC
			savedF.write(conf[24] + System.lineSeparator());// NOT POS
			savedF.write(conf[25] + System.lineSeparator());// NOT TIME
			savedF.write(conf[26] + System.lineSeparator());// NOT bg
			savedF.close();
		} catch (Exception e1) {
			writeError(e1);
		}
	}

	private String[] idiomaString(Language lang) {
		String[] espanol = { "ICONO"// icon 0
				, "PRIMER CUADRO"// Intro FRAME 1
				, "IDIOMA"// LANGUAGE 2
				, "ATAJO DE TECLADO"// KEY SHORTCUT 3
				, "AUTOGUARDAR"// AUTO SAVE 4
				, "POR DEFECTO"// DEFAULT 5
				, "GUARDAR"// SAVE 6
				, "TEMA"// THEME 7
				, "EFECTO DE SONIDO" // 8
				, "PRESENTACIÓN DE DIAPOSITIVAS"// 9
				, "SIEMPRE EN LA CIMA" // 10
				, "ACTUALIZACIÓN AUTOMÁTICA"// 11
				, "CUANDO HAY UNA ACTUALIZACIÓN APARECE UN BOTÓN"// 12
				, "HAZ QUE LA APLICACIÓN ESTÉ SIEMPRE EN LA PARTE SUPERIOR"// 13
				, "CUÁL ES EL PRIMER MARCO QUE SE ABRE AL DESBLOQUEAR LA APLICACIÓN"// 14
				, "ACTIVAR TECLA DE ACCESO DIRECTO PARA FACILITAR LAS FUNCIONES"// 15
				, "ESTILO"// 16
				, "FECHA"// 17
				, "NOTIFICACIÓN" // 18
				, "LIMPIEZA AUTOMÁTICA"// 19
				, "LIMPIAR EL CACHÉ A FINAL DE MES AUTOMÁTICAMENTE"// 20
				, "MOSTRAR SOLO STOCK DISPONIBLE"// 21
				, "ANIMACIÓN DE EVENTOS"// 22
				, "GUARDAR GRÁFICO"// 23
				, "GUARDE EL DIAGRAMA DE VENTAS DE ARTÍCULOS MÁS IMPORTANTES AL FINAL DEL MES/AÑO DE FORMA AUTOMÁTICA"// 24
				, "ORDENAR STOCK"// 25
				, "FECHA AÑADIDA"// 26
				, "DÍAS DE LICENCIA"// 27
				, "MOSTRAR TOTAL DE DÍAS DE LICENCIA SEGÚN FECHA DE CONTRATACIÓN"// 28
				, "POSICIÓN DE NOTIFICACIÓN"// 29
				, "ARRIBA A LA IZQUIERDA"// 30
				, "CENTRO SUPERIOR"// 31
				, "ARRIBA A LA DERECHA"// 32
				, "CENTRO"// 33
				, "ABAJO IZQUIERDA"// 34
				, "CENTRO INFERIOR"// 35
				, "ABAJO A LA DERECHA"// 36
				, "DURACIÓN DE LA NOTIFICACIÓN"// 37
				, "TOSTADA DEGRADADA"// 38
		};
		String[] portugues = { "ÍCONE"// icon0
				, "PRIMEIRA TABELA"// Intro FRAME1
				, "LINGUAGEM"// LANGUAGE2
				, "ATALHO DE TECLADO"// KEY SHORTCUT3
				, "AUTO-SALVAR"// AUTO SAVE4
				, "POR PADRÃO"// DEFAULT5
				, "GUARDA"// SAVE6
				, "TEMA"// THEME7
				, "EFEITO SONORO"// 8
				, "APRESENTAÇÃO DE SLIDES"// 9
				, "SEMPRE NO TOPO"// 10
				, "ATUALIZAÇÃO AUTOMÁTICA"// 11
				, "QUANDO HÁ UMA ATUALIZAÇÃO UM BOTÃO APARECE"// 12
				, "DEIXE O APLICATIVO SEMPRE NO TOPO"// 13
				, "QUAL É O PRIMEIRO QUADRO QUE ABRE AO DESBLOQUEAR O APLICATIVO"// 14
				, "ATIVE A TECLA DE ATALHO PARA FACILITAR AS FUNÇÕES"// 15
				, "ESTILO"// 16
				, "DATA"// 17
				, "NOTIFICAÇÃO"// 18
				, "LIMPEZA AUTOMÁTICA"// 19
				, "LIMPE O CACHE NO FINAL DO MÊS AUTOMATICAMENTE"// 20
				, "MOSTRAR SOMENTE ESTOQUE DISPONÍVEL"// 21
				, "ANIMAÇÃO DE EVENTOS"// 22
				, "SALVAR GRÁFICO"// 23
				, "SALVE O DIAGRAMA DE VENDAS DOS ITENS MAIS VENDIDOS NO FINAL DO MÊS/ANO AUTOMATICAMENTE"// 24
				, "CLASSIFICAR ESTOQUE"// 25
				, "DATA ADICIONADA"// 26
				, "DIAS DE LICENÇA"// 27
				, "MOSTRAR TOTAL DE DIAS DE LICENÇA DE ACORDO COM A DATA DE CONTRATAÇÃO"// 28
				, "POSIÇÃO DE NOTIFICAÇÃO"// 29
				, "CIMA ESQUERDO"// 30
				, "CENTRO SUPERIOR"// 31
				, "CIMA DIREITA"// 32
				, "CENTRO"// 33
				, "INFERIOR ESQUERDO"// 33
				, "CENTRO INFERIOR"// 34
				, "INFERIOR DIREITO"// 35
				, "DURAÇÃO DA NOTIFICAÇÃO"// 37
				, "BRINDE DEGRADIENTE"// 38
		};
		String[] english = { "ICON"// icon 0
				, "Intro FRAME"// Intro FRAME 1
				, "LANGUAGE"// LANGUAGE 2
				, "KEY SHORTCUT"// KEY SHORTCUT 3
				, "AUTO SAVE"// AUTO SAVE 4
				, "DEFAULT"// DEFAULT 5
				, "SAVE"// SAVE 6
				, "THEME"// THEME 7
				, "SOUND EFFECT"// 8
				, "SLIDESHOW"// 9
				, "ALWAYS ON TOP"// 10
				, "AUTO UPDATE" // 11
				, "WHEN THERE IS AN UPDATE A BUTTON APPEAR"// 12
				, "MAKE THE APP ALWAYS ON TOP"// 13
				, "WHAT IS THE Intro FRAME THAT OPEN WHEN UNLOCK THE APP"// 14
				, "ACTIVATE SHORTCUT KEY TO FACILITATE THE FUNCTIONS"// 15
				, "STYLE"// 16
				, "DATE"// 17
				, "NOTIFICATION"// 18
				, "AUTOCLEAN"// 19
				, "CLEAN THE CACHE AT THE END OF THE MONTH AUTOMATICALLY"// 20
				, "SHOW ONLY AVAILABLE STOCK"// 21
				, "EVENT ANIMATION"// 22
				, "SAVE GRAPH"// 23
				, "SAVE THE TOP ITEMS SELL DIAGRAM AT THE END OF THE MONTH/YEAR AUTOMATICALLY"// 24
				, "SORT STOCK"// 25
				, "ADDED DATE" // 26
				, "LICENSE DAYS"// 27
				, "SHOW TOTAL OF DAYS OF LICENSE ACC TO HIRING DATE"// 28
				, "NOTIFICATION POSITION"// 29
				, "TOP LEFT"// 30
				, "TOP CENTER"// 31
				, "TOP RIGHT"// 32
				, "CENTER"// 33
				, "BOTTOM LEFT"// 33
				, "BOTTOM CENTER"// 34
				, "BOTTOM RIGHT"// 35
				, "NOTIFICATION DURATION"// 37
				, "GRADIENT TOAST"// 38
		};
		String[] french = { "ICÔNE" // icône
				, "PREMIÈRE IMAGE"// PREMIÈRE IMAGE
				, "LANGUE"// LANGUE
				, "RACCOURCI TOUCHE"// RACCOURCI TOUCHE
				, "AUTO-SAUVER"// ENREGISTREMENT AUTO
				, "DEFAUT"// PAR DEFAUT
				, "SAUVER"// ENREGISTRER
				, "THÈME"// THEME16
				, "EFFET SONORE", "DIAPORAMA"//
				, "TOUJOURS AU TOP"//
				, "MISE À JOUR AUTOMATIQUE"//
				, "LORSQU'IL Y A UNE MISE À JOUR UN BOUTON APPARAÎT"//
				, "FAITES EN SORTE QUE L'APPLICATION SOIT TOUJOURS AU TOP"//
				, "QUELLE EST LA PREMIÈRE CADRE QUI S'OUVRE LORS DU DÉVERROUILLAGE DE L'APPLICATION"//
				, "ACTIVER LA TOUCHE DE RACCOURCI POUR FACILITER LES FONCTIONS"//
				, "STYLE"//
				, "DATE", "NOTIFICATION", "AUTONETTOYAGE"//
				, "NETTOYER LE CACHE À LA FIN DU MOIS AUTOMATIQUEMENT"//
				, "AFFICHER UNIQUEMENT LES STOCKS DISPONIBLES"// 20
				, "ANIMATION D'ÉVÉNEMENTS"// 22
				, "ENREGISTRER LE GRAPHIQUE"// 23
				, "ENREGISTREZ AUTOMATIQUEMENT LES MEILLEURS ARTICLES VENDUS À LA FIN DU MOIS/DE L'ANNÉE"// 24
				, "TRIER LE STOCK"// 25
				, "DATE D'AJOUT"// 26
				, "JOURS DE LICENCE"// 27
				, "AFFICHER LE TOTAL DES JOURS DE PERMIS SELON LA DATE D'EMBAUCHE"// 28
				, "POSITION DE NOTIFICATION"// 29
				, "EN HAUT À GAUCHE"// 30
				, "CENTRE SUPÉRIEUR"// 31
				, "EN HAUT À DROITE"// 32
				, "CENTRE"// 33
				, "EN BAS À GAUCHE"// 33
				, "EN BAS AU CENTRE"// 34
				, "EN BAS À DROITE"// 35
				, "DURÉE DE NOTIFICATION"// 37
				, "TOAST DÉGRADÉ"// 38
		};
		if (lang == Language.SPANISH)
			return espanol;
		else if (lang == Language.PORTUGUES)
			return portugues;
		else if (lang == Language.ENGLISH)
			return english;
		else
			return french;
	}

	private void writeError(Exception e) {
		File logF = new File(dataFolder + "\\LOG");
		logF.mkdir();
		String timeFolder = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		File errorF = new File(logF, timeFolder + ".txt");
		// Get the current date and time
		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

		try (PrintWriter writer = new PrintWriter(new FileWriter(errorF, true))) {
			writer.println("[" + timestamp + "] ERROR: " + e.getMessage());
			// Get only the Intro line of the stack trace (where the error happened)
			if (e != null) {
				StackTraceElement[] stackTrace = e.getStackTrace();
				if (stackTrace.length > 0) {
					writer.println("    at " + stackTrace[0]); // Logs only the Intro relevant line
				}
			}
			writer.println("-------------------------------------------------");
			Toast.show(this, Toast.Type.ERROR, "ERROR" + e.getMessage(), Intro.notOption);
		} catch (IOException e1) {
			writeError(e1);
			return; // Stop execution if writing fails
		}
	}
}
