package haditech;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatCobalt2IJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneLightIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDarkerIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDeepOceanIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatNightOwlIJTheme;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

import haditech.Intro.Language;
import mhmdsabdlh.component.CalculatorPanel;
import mhmdsabdlh.component.RoundButton;
import mhmdsabdlh.dialog.ModernDialog;
import mhmdsabdlh.dialog.ModernDialog.IconType;
import mhmdsabdlh.images.ImageEffect;
import mhmdsabdlh.text.AutoComplete;
import mhmdsabdlh.text.RotatedLabel;
import mhmdsabdlh.text.TextEffect;
import raven.message.SocialMedia;
import raven.message.SocialMedia.APP;
import raven.modal.Toast;

public class FaturaR extends JFrame {
	private final Color redD = new Color(190, 0, 0);
	private final Color redC = new Color(250, 110, 110);
	private final Color violetD = new Color(0x393646);
	private final Color violetC = new Color(0x6D5D6E);
	private final Color turD = new Color(0x245953);
	private final Color turC = new Color(0x408E91);
	private Color fg, bg;
	private URL u100 = getClass().getResource("images/money/100.jpg");
	private ImageIcon i100 = new ImageIcon(u100);
	private URL u50 = getClass().getResource("images/money/50.jpg");
	private ImageIcon i50 = new ImageIcon(u50);
	private URL u20 = getClass().getResource("images/money/20.jpg");
	private ImageIcon i20 = new ImageIcon(u20);
	private URL u10 = getClass().getResource("images/money/10.jpg");
	private ImageIcon i10 = new ImageIcon(u10);
	private URL u5 = getClass().getResource("images/money/5.jpg");
	private ImageIcon i5 = new ImageIcon(u5);
	private URL u2 = getClass().getResource("images/money/2.jpg");
	private ImageIcon i2 = new ImageIcon(u2);
	private URL u1 = getClass().getResource("images/money/1.jpg");
	private ImageIcon i1 = new ImageIcon(u1);
	private URL pixP = getClass().getResource("images/money/wish.jpg");
	private ImageIcon pixI = new ImageIcon(pixP);
	// menubar
	private URL aboutP = getClass().getResource("images/menubar/about.png");
	private ImageIcon aboutI = new ImageIcon(aboutP);
	private URL calcP = getClass().getResource("images/menubar/calc.png");
	private ImageIcon calcI = new ImageIcon(calcP);
	private URL clearmbP = getClass().getResource("images/menubar/delete.png");
	private ImageIcon clearmbI = new ImageIcon(clearmbP);
	private URL creatorP = getClass().getResource("images/menubar/creator.png");
	private ImageIcon creatorI = new ImageIcon(creatorP);
	private URL exitP = getClass().getResource("images/menubar/exit.png");
	private ImageIcon exitI = new ImageIcon(exitP);
	private URL moneyP = getClass().getResource("images/menubar/money.png");
	private ImageIcon moneyI = new ImageIcon(moneyP);
	private URL settingP = getClass().getResource("images/menubar/setting.png");
	private ImageIcon settingI = new ImageIcon(settingP);
	private URL keyboardP = getClass().getResource("images/menubar/keyboard.png");
	private ImageIcon keyboardI = new ImageIcon(keyboardP);
	// sounds
	private URL clearSound = getClass().getResource("sound/clear.wav");

	// Def
	private JTextField details[][] = new JTextField[10][3];
	private JLabel detailsR[] = new JLabel[10];
	static JLabel total = new JLabel("TOTAL");
	private JLabel cambio[] = new JLabel[6];
	static JLabel[][] cajaTroco = new JLabel[2][7];
	private JLabel[] trocoC = new JLabel[7];
	static JFormattedTextField[] trocoCT = new JFormattedTextField[7];
	private JLabel[][] troco = new JLabel[2][7];
	private JLabel[][] troco2 = new JLabel[2][7];
	private JLabel[][] troco3 = new JLabel[2][7];
	static JLabel totalC = new JLabel("TOTAL");
	private JLabel cambioC = new JLabel();
	private JLabel title[] = new JLabel[4];
	private RotatedLabel caja = new RotatedLabel("", -90);
	private JButton cambioN, cambioN2, cambioN3;
	private RoundButton cambioPIX;
	static int totalFatura = 0, totalCV = 0, trocoV = 0, pixValue = 0;
	private static Language language = Language.SPANISH;
	private String currentpath = System.getProperty("user.dir");
	private File dataFolder = new File(currentpath + "\\data");
	private File confFile = new File(dataFolder, "conf.dll");
	private String conf[] = new String[27];

	FaturaR() {
		// Frame
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int taskbarHeight = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration()).bottom;
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight() - taskbarHeight;
		setTitle(getLocalizedMessage("TITLE"));
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setSize(width, height);
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(width, height));
		setLayout(null);

		openConfiguration();

		// Btns
		cambioN = new JButton(getLocalizedMessage("METHOD1"));
		cambioN2 = new JButton(getLocalizedMessage("METHOD2"));
		cambioN3 = new JButton(getLocalizedMessage("METHOD3"));
		cambioPIX = new RoundButton("", 10);

		// Open values of cash
		BufferedReader dataOpened;
		String line;
		dataOpened = null;
		line = "";
		int z = 0;
		dataFolder.mkdir();
		File newFile2 = new File(dataFolder, "index.dll");
		String numbers[] = new String[162];
		try {
			dataOpened = new BufferedReader(new FileReader(newFile2));
			while ((line = dataOpened.readLine()) != null) {
				numbers[z] = line.toString();
				z++;
			}
			dataOpened.close();
		} catch (Exception e) {
			writeError(e);
		}

		// Invoice detailed
		for (int i = 0; i < 4; i++) {
			title[i] = new JLabel();
			title[i].setForeground(Intro.blackM);
			title[i].setFont(Intro.myFont);
			title[i].setBackground(Intro.grisD);
			title[i].setHorizontalAlignment(0);
			title[i].setBorder(Intro.borderL);
			title[i].setOpaque(true);
			add(title[i]);
		}
		title[0].setBounds(30, 30, getWidth() / 22, getHeight() / 18);
		title[0].setText(getLocalizedMessage("QNT"));
		title[0].setToolTipText(getLocalizedMessage("QUANTITY"));
		title[1].setText(getLocalizedMessage("DET"));
		title[1].setBounds(title[0].getWidth() + title[0].getX() - 1, title[0].getY(), getWidth() * 2 / 15,
				title[0].getHeight());
		title[2].setText("P/U");
		title[2].setBounds(title[1].getWidth() + title[1].getX() - 1, title[0].getY(), getWidth() / 17,
				title[0].getHeight());
		title[2].setToolTipText(getLocalizedMessage("P/U"));
		title[3].setText(getLocalizedMessage("VAL"));
		title[3].setBounds(title[2].getWidth() + title[2].getX() - 1, title[0].getY(), getWidth() * 2 / 25,
				title[0].getHeight());
		ArrayList<String> keywords = listMercadoria();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 3; j++) {
				details[i][j] = new JTextField();
				textFieldStyle(details[i][j]);
				details[i][j].setFont(Intro.myFont);
				details[i][j].setBounds(title[j].getX(),
						title[0].getY() + title[0].getHeight() + i * (title[0].getHeight() - 1) - 1,
						title[j].getWidth(), title[0].getHeight());
				if (conf[2] == null || conf[2].equals("false"))
					tableFocus(i, j);
				add(details[i][j]);
			}
			// Autocomplete
			AutoComplete autoComplete = new AutoComplete(details[i][1], keywords);
			details[i][1].getDocument().addDocumentListener(autoComplete);
			details[i][1].addFocusListener(new FocusListener() {

				@Override
				public void focusLost(FocusEvent e) {
					for (int i = 0; i < 10; i++) // TitleCase gastos and agg
						details[i][1].setText(TextEffect.capitalizeString(details[i][1].getText()));
				}

				@Override
				public void focusGained(FocusEvent e) {
				}
			});
		}
		InitialFocusSetter.setInitialFocus(this, details[0][0]);
		for (int i = 0; i < 10; i++) {
			detailsR[i] = new JLabel();
			detailsR[i].setBounds(title[3].getX(),
					title[0].getY() + title[0].getHeight() + i * (title[0].getHeight() - 1) - 1, getWidth() * 2 / 25,
					title[0].getHeight());
			detailsR[i].setForeground(Intro.lightC);
			detailsR[i].setHorizontalAlignment(0);
			detailsR[i].setBorder(Intro.borderL);
			detailsR[i].setOpaque(false);
			detailsR[i].setFont(Intro.myFont);
			add(detailsR[i]);
		}
		total.setFont(Intro.myFont);
		total.setBounds(detailsR[9].getX(), detailsR[9].getY() + title[0].getHeight() - 1, detailsR[9].getWidth(),
				getHeight() / 18);
		total.setBackground(Intro.grisD);
		total.setForeground(Color.black);
		total.setBorder(Intro.borderL);
		total.setHorizontalAlignment(0);
		total.setOpaque(true);
		add(total);

		// Caja
		caja.setText(getLocalizedMessage("CASH"));
		caja.setBounds(details[9][0].getX(), total.getY() + total.getHeight() + 50, getWidth() / 30, getHeight() / 8);
		caja.setFont(Intro.myFont);
		caja.setHorizontalAlignment(0);
		caja.setBorder(Intro.borderL);
		caja.setForeground(Intro.blackM);
		caja.setBackground(Intro.grisD);
		caja.setOpaque(true);
		add(caja);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 7; j++) {
				cajaTroco[i][j] = new JLabel();
				if (i == 1)
					cajaTroco[i][j].setText("0");
				cajaTroco[i][j].setBounds(caja.getX() + caja.getWidth() + (cajaTroco[0][0].getWidth() - 1) * j - 1,
						caja.getY() + (caja.getHeight() / 2) * i - (i == 1 ? 1 : 0), getWidth() / 22,
						caja.getHeight() / 2 + 2);
				if (i == 0) {
					switch (j) {
					case 0:
						cajaTroco[i][j].setIcon(ImageEffect.getScaledImage(i1.getImage(), cajaTroco[i][j].getWidth(),
								cajaTroco[i][j].getHeight()));
						break;
					case 1:
						cajaTroco[i][j].setIcon(ImageEffect.getScaledImage(i2.getImage(), cajaTroco[i][j].getWidth(),
								cajaTroco[i][j].getHeight()));
						break;
					case 2:
						cajaTroco[i][j].setIcon(ImageEffect.getScaledImage(i5.getImage(), cajaTroco[i][j].getWidth(),
								cajaTroco[i][j].getHeight()));
						break;
					case 3:
						cajaTroco[i][j].setIcon(ImageEffect.getScaledImage(i10.getImage(), cajaTroco[i][j].getWidth(),
								cajaTroco[i][j].getHeight()));
						break;
					case 4:
						cajaTroco[i][j].setIcon(ImageEffect.getScaledImage(i20.getImage(), cajaTroco[i][j].getWidth(),
								cajaTroco[i][j].getHeight()));
						break;
					case 5:
						cajaTroco[i][j].setIcon(ImageEffect.getScaledImage(i50.getImage(), cajaTroco[i][j].getWidth(),
								cajaTroco[i][j].getHeight()));
						break;
					case 6:
						cajaTroco[i][j].setIcon(ImageEffect.getScaledImage(i100.getImage(), cajaTroco[i][j].getWidth(),
								cajaTroco[i][j].getHeight()));
						break;
					default:
						break;
					}
				}
				cajaTroco[i][j].setFont(Intro.myFont);
				cajaTroco[i][j].setHorizontalAlignment(0);
				cajaTroco[i][j].setBorder(Intro.borderL);
				cajaTroco[i][j].setForeground(Color.white);
				add(cajaTroco[i][j]);
			}

		// Cliente
		cambioC.setText(getLocalizedMessage("CLIENT"));
		cambioC.setBounds(cajaTroco[0][6].getX() + cajaTroco[0][6].getWidth() + 20, title[0].getY(),
				cajaTroco[0][0].getWidth() * 7 + 1, getHeight() / 14);
		cambioC.setFont(Intro.myFont);
		cambioC.setBorder(Intro.borderL);
		cambioC.setBackground(Intro.grisD);
		cambioC.setForeground(Intro.blackM);
		cambioC.setHorizontalAlignment(0);
		cambioC.setOpaque(true);
		cambioC.setToolTipText(getLocalizedMessage("CLIENT_C"));
		add(cambioC);
		for (int i = 0; i < 7; i++) {
			trocoC[i] = new JLabel();
			trocoC[i].setBounds(cambioC.getX() + (cambioC.getWidth() / 7) * i, cambioC.getY() + cambioC.getHeight() - 1,
					cajaTroco[0][0].getWidth() + 1, cajaTroco[0][0].getHeight());
			switch (i) {
			case 0:
				trocoC[i].setIcon(ImageEffect.getScaledImage(i1.getImage(), cajaTroco[0][0].getWidth(),
						cajaTroco[0][0].getHeight()));
				break;
			case 1:
				trocoC[i].setIcon(ImageEffect.getScaledImage(i2.getImage(), cajaTroco[0][0].getWidth(),
						cajaTroco[0][0].getHeight()));
				break;
			case 2:
				trocoC[i].setIcon(ImageEffect.getScaledImage(i5.getImage(), cajaTroco[0][0].getWidth(),
						cajaTroco[0][0].getHeight()));
				break;
			case 3:
				trocoC[i].setIcon(ImageEffect.getScaledImage(i10.getImage(), cajaTroco[0][0].getWidth(),
						cajaTroco[0][0].getHeight()));
				break;
			case 4:
				trocoC[i].setIcon(ImageEffect.getScaledImage(i20.getImage(), cajaTroco[0][0].getWidth(),
						cajaTroco[0][0].getHeight()));
				break;
			case 5:
				trocoC[i].setIcon(ImageEffect.getScaledImage(i50.getImage(), cajaTroco[0][0].getWidth(),
						cajaTroco[0][0].getHeight()));
				break;
			case 6:
				trocoC[i].setIcon(ImageEffect.getScaledImage(i100.getImage(), cajaTroco[0][0].getWidth(),
						cajaTroco[0][0].getHeight()));
				break;
			default:
				break;
			}
			trocoC[i].setHorizontalAlignment(0);
			trocoC[i].setBorder(Intro.borderL);
			add(trocoC[i]);
			trocoCT[i] = new JFormattedTextField("0");
			formatedTextFieldStyle(trocoCT[i]);
			trocoCT[i].setFont(Intro.myFont);
			trocoCT[i].setBounds(trocoC[i].getX(), trocoC[i].getY() + trocoC[i].getHeight() - 1, trocoC[i].getWidth(),
					trocoC[i].getHeight());
			trocoCT[i].setForeground(Intro.lightC);
			trocoCT[i].setOpaque(false);
			if (conf[2] == null || conf[2].equals("false"))
				clienteFocus(i);
			add(trocoCT[i]);
		}
		totalC.setBounds(trocoCT[0].getX(), trocoCT[0].getY() + trocoCT[0].getHeight() - 1, cambioC.getWidth(),
				cambioC.getHeight());
		totalC.setFont(Intro.myFont);
		totalC.setBorder(Intro.borderL);
		totalC.setForeground(Intro.blackM);
		totalC.setBackground(new Color(0xe4e4e4));
		totalC.setHorizontalAlignment(0);
		totalC.setOpaque(true);
		add(totalC);

		// Cliente troco
		for (int i = 0; i < 6; i++) {
			cambio[i] = new JLabel();
			cambio[i].setFont(Intro.myFont);
			if (i < 3) {
				cambio[i].setBounds(
						cambioC.getX() + cambioC.getWidth()
								+ (getWidth() - cambioC.getX() - cambioC.getWidth() - getWidth() * 4 / 27) / 2,
						cambioC.getY() + cambioC.getHeight() / 2 + (cambioC.getHeight() - 1) * i, getWidth() * 2 / 27,
						cambioC.getHeight());
				cambio[i].setForeground(Intro.blackM);
				cambio[i].setBackground(Intro.grisD);
			} else {
				cambio[i].setBounds(cambio[i - 3].getX() + cambio[i - 3].getWidth() - 1, cambio[i - 3].getY(),
						getWidth() * 2 / 27, cambioC.getHeight());
				cambio[i].setForeground(Intro.lightC);
				cambio[i].setBackground(Intro.blackM);
			}
			cambio[i].setHorizontalAlignment(0);
			cambio[i].setBorder(Intro.borderL);
			cambio[i].setOpaque(true);
			add(cambio[i]);
		}
		cambio[0].setText(getLocalizedMessage("CLIENT"));
		cambio[1].setText("TOTAL");
		cambio[2].setText(getLocalizedMessage("CHANGE"));

		// 1ST CAMBIO
		cambioN.setBounds(totalC.getX() + 35, totalC.getY() + totalC.getHeight() + getHeight() / 23,
				getWidth() * 2 / 25, cajaTroco[0][0].getHeight() * 2 - 1);
		cambioN.setFont(Intro.myFont);
		cambioN.setBorder(Intro.borderL);
		cambioN.setForeground(Intro.lightC);
		cambioN.setBackground(redD);
		cambioN.setFocusable(false);
		cambioN.setToolTipText(getLocalizedMessage("METHOD1T"));
		cambioN.addActionListener(_ -> {
			if (cambioN.getBackground() != redD) {
				cambioF();
				cambioN.setText(getLocalizedMessage("METHOD1"));
				cambioN2.setText(getLocalizedMessage("METHOD2"));
				cambioN3.setText(getLocalizedMessage("METHOD3"));
				cambioN.setBackground(redD);
				cambioN2.setBackground(violetD);
				cambioN3.setBackground(turD);
				cambioPIX.setBackground(Intro.blackM);
			}
		});
		add(cambioN);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 7; j++) {
				troco[i][j] = new JLabel();
				if (i == 1)
					troco[i][j].setText("0");
				troco[i][j].setBounds(cambioN.getX() + cambioN.getWidth() + (cajaTroco[0][0].getWidth() - 1) * j - 1,
						cambioN.getY() + cajaTroco[0][0].getHeight() * i - (i == 1 ? 1 : 0), cajaTroco[0][0].getWidth(),
						cajaTroco[0][0].getHeight());
				if (i == 0) {
					switch (j) {
					case 0:
						troco[i][j].setIcon(ImageEffect.getScaledImage(i1.getImage(), cajaTroco[0][0].getWidth(),
								cajaTroco[0][0].getHeight()));
						break;
					case 1:
						troco[i][j].setIcon(ImageEffect.getScaledImage(i2.getImage(), cajaTroco[0][0].getWidth(),
								cajaTroco[0][0].getHeight()));
						break;
					case 2:
						troco[i][j].setIcon(ImageEffect.getScaledImage(i5.getImage(), cajaTroco[0][0].getWidth(),
								cajaTroco[0][0].getHeight()));
						break;
					case 3:
						troco[i][j].setIcon(ImageEffect.getScaledImage(i10.getImage(), cajaTroco[0][0].getWidth(),
								cajaTroco[0][0].getHeight()));
						break;
					case 4:
						troco[i][j].setIcon(ImageEffect.getScaledImage(i20.getImage(), cajaTroco[0][0].getWidth(),
								cajaTroco[0][0].getHeight()));
						break;
					case 5:
						troco[i][j].setIcon(ImageEffect.getScaledImage(i50.getImage(), cajaTroco[0][0].getWidth(),
								cajaTroco[0][0].getHeight()));
						break;
					case 6:
						troco[i][j].setIcon(ImageEffect.getScaledImage(i100.getImage(), cajaTroco[0][0].getWidth(),
								cajaTroco[0][0].getHeight()));
						break;
					default:
						break;
					}
				}
				troco[i][j].setFont(Intro.myFont);
				troco[i][j].setHorizontalAlignment(0);
				troco[i][j].setBorder(Intro.borderL);
				troco[i][j].setBackground(redC);
				troco[i][j].setForeground(Color.white);
				troco[i][j].setOpaque(true);
				add(troco[i][j]);
			}

		// 2ND CAMBIO
		cambioN2.setBounds(cambioN.getX(), cambioN.getY() + cambioN.getHeight() + getHeight() / 23, getWidth() * 2 / 25,
				cajaTroco[0][0].getHeight() * 2 - 1);
		cambioN2.setFont(Intro.myFont);
		cambioN2.setBackground(violetD);
		cambioN2.setBorder(Intro.borderL);
		cambioN2.setForeground(Intro.lightC);
		cambioN2.setFocusable(false);
		cambioN2.setToolTipText(getLocalizedMessage("METHOD2T"));
		cambioN2.addActionListener(_ -> {
			if (cambioN2.getBackground() != violetD) {
				cambioF2();
				cambioN.setText(getLocalizedMessage("METHOD1"));
				cambioN2.setText(getLocalizedMessage("METHOD2"));
				cambioN3.setText(getLocalizedMessage("METHOD3"));
				cambioN.setBackground(redD);
				cambioN2.setBackground(violetD);
				cambioN3.setBackground(turD);
				cambioPIX.setBackground(Intro.blackM);
			}
		});
		add(cambioN2);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 7; j++) {
				troco2[i][j] = new JLabel();
				if (i == 1)
					troco2[i][j].setText("0");
				troco2[i][j].setBounds(cambioN2.getX() + cambioN2.getWidth() + (cajaTroco[0][0].getWidth() - 1) * j - 1,
						cambioN2.getY() + cajaTroco[0][0].getHeight() * i - (i == 1 ? 1 : 0),
						cajaTroco[0][0].getWidth(), cajaTroco[0][0].getHeight());
				if (i == 0) {
					switch (j) {
					case 0:
						troco2[i][j].setIcon(ImageEffect.getScaledImage(i1.getImage(), cajaTroco[0][0].getWidth(),
								cajaTroco[0][0].getHeight()));
						break;
					case 1:
						troco2[i][j].setIcon(ImageEffect.getScaledImage(i2.getImage(), cajaTroco[0][0].getWidth(),
								cajaTroco[0][0].getHeight()));
						break;
					case 2:
						troco2[i][j].setIcon(ImageEffect.getScaledImage(i5.getImage(), cajaTroco[0][0].getWidth(),
								cajaTroco[0][0].getHeight()));
						break;
					case 3:
						troco2[i][j].setIcon(ImageEffect.getScaledImage(i10.getImage(), cajaTroco[0][0].getWidth(),
								cajaTroco[0][0].getHeight()));
						break;
					case 4:
						troco2[i][j].setIcon(ImageEffect.getScaledImage(i20.getImage(), cajaTroco[0][0].getWidth(),
								cajaTroco[0][0].getHeight()));
						break;
					case 5:
						troco2[i][j].setIcon(ImageEffect.getScaledImage(i50.getImage(), cajaTroco[0][0].getWidth(),
								cajaTroco[0][0].getHeight()));
						break;
					case 6:
						troco2[i][j].setIcon(ImageEffect.getScaledImage(i100.getImage(), cajaTroco[0][0].getWidth(),
								cajaTroco[0][0].getHeight()));
						break;
					default:
						break;
					}
				}
				troco2[i][j].setFont(Intro.myFont);
				troco2[i][j].setHorizontalAlignment(0);
				troco2[i][j].setBorder(Intro.borderL);
				troco2[i][j].setOpaque(true);
				troco2[i][j].setBackground(violetC);
				troco2[i][j].setForeground(Color.white);
				add(troco2[i][j]);
			}

		// 3RD CAMBIO
		cambioN3.setBounds(cambioN2.getX(), cambioN2.getY() + cambioN2.getHeight() + getHeight() / 23,
				getWidth() * 2 / 25, cajaTroco[0][0].getHeight() * 2 - 1);
		cambioN3.setFont(Intro.myFont);
		cambioN3.setBackground(turD);
		cambioN3.setBorder(Intro.borderL);
		cambioN3.setForeground(Intro.lightC);
		cambioN3.setFocusable(false);
		cambioN3.setToolTipText(getLocalizedMessage("METHOD3T"));
		cambioN3.addActionListener(_ -> {
			if (cambioN3.getBackground() != turD) {
				cambioF3();
				cambioN.setText(getLocalizedMessage("METHOD1"));
				cambioN2.setText(getLocalizedMessage("METHOD2"));
				cambioN3.setText(getLocalizedMessage("METHOD3"));
				cambioN.setBackground(redD);
				cambioN2.setBackground(violetD);
				cambioN3.setBackground(turD);
				cambioPIX.setBackground(Intro.blackM);
			}
		});
		add(cambioN3);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 7; j++) {
				troco3[i][j] = new JLabel();
				if (i == 1)
					troco3[i][j].setText("0");
				troco3[i][j].setBounds(cambioN3.getX() + cambioN3.getWidth() + (cajaTroco[0][0].getWidth() - 1) * j - 1,
						cambioN3.getY() + cajaTroco[0][0].getHeight() * i - (i == 1 ? 1 : 0),
						cajaTroco[0][0].getWidth(), cajaTroco[0][0].getHeight());
				if (i == 0) {
					switch (j) {
					case 0:
						troco3[i][j].setIcon(ImageEffect.getScaledImage(i1.getImage(), cajaTroco[0][0].getWidth(),
								cajaTroco[0][0].getHeight()));
						break;
					case 1:
						troco3[i][j].setIcon(ImageEffect.getScaledImage(i2.getImage(), cajaTroco[0][0].getWidth(),
								cajaTroco[0][0].getHeight()));
						break;
					case 2:
						troco3[i][j].setIcon(ImageEffect.getScaledImage(i5.getImage(), cajaTroco[0][0].getWidth(),
								cajaTroco[0][0].getHeight()));
						break;
					case 3:
						troco3[i][j].setIcon(ImageEffect.getScaledImage(i10.getImage(), cajaTroco[0][0].getWidth(),
								cajaTroco[0][0].getHeight()));
						break;
					case 4:
						troco3[i][j].setIcon(ImageEffect.getScaledImage(i20.getImage(), cajaTroco[0][0].getWidth(),
								cajaTroco[0][0].getHeight()));
						break;
					case 5:
						troco3[i][j].setIcon(ImageEffect.getScaledImage(i50.getImage(), cajaTroco[0][0].getWidth(),
								cajaTroco[0][0].getHeight()));
						break;
					case 6:
						troco3[i][j].setIcon(ImageEffect.getScaledImage(i100.getImage(), cajaTroco[0][0].getWidth(),
								cajaTroco[0][0].getHeight()));
						break;
					default:
						break;
					}
				}
				troco3[i][j].setFont(Intro.myFont);
				troco3[i][j].setHorizontalAlignment(0);
				troco3[i][j].setBorder(Intro.borderL);
				troco3[i][j].setOpaque(true);
				troco3[i][j].setBackground(turC);
				troco3[i][j].setForeground(Color.white);
				add(troco3[i][j]);
			}

		// pix CAMBIO
		cambioPIX.setBounds(troco3[0][3].getX(), cambioN3.getY() + cambioN3.getHeight() + getHeight() / 23,
				cajaTroco[0][0].getWidth(), cajaTroco[0][0].getHeight());
		cambioPIX.setIcon(
				ImageEffect.getScaledImage(pixI.getImage(), cajaTroco[0][0].getWidth(), cajaTroco[0][0].getHeight()));
		cambioPIX.setFillColor(new Color(0xdef7f3));
		cambioPIX.setBorderColorAndRadius(fg);
		cambioPIX.setFocusable(false);
		cambioPIX.setToolTipText(getLocalizedMessage("METHODP"));
		cambioPIX.addActionListener(_ -> {
			if (totalFatura != 0) {
				cambioPIXF();
				cambioN.setText(getLocalizedMessage("METHOD1"));
				cambioN2.setText(getLocalizedMessage("METHOD2"));
				cambioN3.setText(getLocalizedMessage("METHOD3"));
				cambioN.setBackground(redD);
				cambioN2.setBackground(violetD);
				cambioN3.setBackground(turD);
				cambioPIX.setBackground(Intro.blackM);
			}
		});
		cambioPIX.setCursor(new Cursor(HAND_CURSOR));
		add(cambioPIX);

		// Put the valores in the caja
		z = 153;
		for (int i = 0; i < 7; i++) {
			cajaTroco[1][6 - i].setText(numbers[z]);
			z++;
		}

		// MenuBar
		JMenuBar mb = new JMenuBar();
		JMenu file = new JMenu(getLocalizedMessage("FILE"));
		JMenu help = new JMenu(getLocalizedMessage("HELP"));
		JMenuItem keyShortcut = new JMenuItem(getLocalizedMessage("KEYS"));
		JMenuItem creator = new JMenuItem(getLocalizedMessage("ABOUTME"));
		JMenuItem about = new JMenuItem(getLocalizedMessage("ABOUTAPP"));
		JMenuItem calculatorMenu = new JMenuItem(getLocalizedMessage("CALCULATOR"));
		JMenuItem clear = new JMenuItem(getLocalizedMessage("CLEAR"));
		JMenuItem calc = new JMenuItem(getLocalizedMessage("CALC"));
		JMenuItem option = new JMenuItem(getLocalizedMessage("SETTING"));
		JMenuItem exit = new JMenuItem(getLocalizedMessage("EXIT"));
		JMenu goTo = new JMenu(getLocalizedMessage("GO"));
		JMenuItem reales = new JMenuItem("MAIN");
		calculatorMenu.addActionListener(_ -> calculatorFunction());
		calculatorMenu.setMnemonic('C');
		file.setMnemonic(language == Language.SPANISH ? 'A'
				: language == Language.PORTUGUES ? 'A' : language == Language.ENGLISH ? 'F' : 'F');
		clear.setMnemonic(language == Language.SPANISH ? 'B'
				: language == Language.PORTUGUES ? 'L' : language == Language.ENGLISH ? 'C' : 'N');
		calc.setMnemonic('A');
		option.setMnemonic(language == Language.SPANISH ? 'O'
				: language == Language.PORTUGUES ? 'O' : language == Language.ENGLISH ? 'O' : 'P');
		exit.setMnemonic(language == Language.SPANISH ? 'L'
				: language == Language.PORTUGUES ? 'I' : language == Language.ENGLISH ? 'E' : 'O');
		goTo.setMnemonic(language == Language.SPANISH ? 'I'
				: language == Language.PORTUGUES ? 'V' : language == Language.ENGLISH ? 'G' : 'A');
		help.setMnemonic(language == Language.SPANISH ? 'Y'
				: language == Language.PORTUGUES ? 'J' : language == Language.ENGLISH ? 'H' : 'I');
		keyShortcut.setMnemonic(language == Language.SPANISH ? 'T'
				: language == Language.PORTUGUES ? 'T' : language == Language.ENGLISH ? 'K' : 'R');
		creator.setMnemonic('C');
		about.setMnemonic('A');
		reales.setMnemonic('R');
		calc.addActionListener(_ -> calTodo());
		clear.addActionListener(_ -> {
			ModernDialog dialog = new ModernDialog(this, getLocalizedMessage("CLEAR_Q"), false);
			dialog.setIcon(IconType.QUESTION);
			dialog.setColor(bg);
			dialog.setTextColor(fg);
			dialog.setOverlayColor(bg);
			dialog.addSubText(getLocalizedMessage("CANNOT_UNDO"), fg);
			dialog.addButton(getLocalizedMessage("YES"), Intro.greenM, () -> {
				clearAll();
			});
			dialog.addButton(getLocalizedMessage("NO"), Intro.redM, dialog::dispose);
			dialog.setVisible(true);
		});
		option.addActionListener(_ -> {
			new SettingsDialog(this, "faturar");
			openConfiguration();
		});
		exit.addActionListener(_ -> System.exit(0));
		reales.addActionListener(_ -> {
			new Main();
			dispose();
		});
		if (conf[2] == null || conf[2].equals("false"))
			keyShortcut.addActionListener(_ -> {
				ModernDialog keyShort = new ModernDialog(this, getLocalizedMessage("SHORTKEY"), false);
				keyShort.setIcon(IconType.INFO);
				keyShort.addButton(getLocalizedMessage("YES"), Intro.blueM, keyShort::dispose);
				keyShort.setColor(bg);
				keyShort.setTextColor(fg);
				keyShort.setOverlayColor(bg);
				keyShort.setVisible(true);
			});
		else
			keyShortcut.hide();
		creator.addActionListener(_ -> {
			SocialMedia socialMedia = new SocialMedia(this);
			socialMedia.setLinks("https://www.youtube.com/channel/UCzuTm6D0YasEDrVtIlvwjag", "",
					"https://www.facebook.com/mhmdsabdlh", "https://mhmdsabdlh.github.io/",
					"https://www.instagram.com/mhmdsabdlh/", "https://twitter.com/MhmdSAbdlh/",
					"https://www.paypal.com/paypalme/mhmdsabdlh");
			socialMedia.setTxtColor(Color.black);
			socialMedia.setBGColor(Intro.grisD);
			socialMedia.showMessage(getLocalizedMessage("CREDIT"));
		});
		about.addActionListener(_ -> {
			SocialMedia socialMedia = new SocialMedia(this);
			socialMedia.setTxtColor(Color.black);
			socialMedia.setBGColor(Intro.grisD);
			socialMedia.addLinks(APP.FACEBOOK, "https://www.facebook.com/profile.php?id=61574755664555");
			socialMedia.addLinks(APP.INSTAGRAM, "https://www.instagram.com/hadiabdallah33/");
			socialMedia.addLinks(APP.WEBSITE, "https://github.com/MhmdSAbdlh/HadiTech");
			socialMedia.addLinks(APP.WHATSAPP, "https://wa.me/96171228724");
			socialMedia.showMessage(getLocalizedMessage("ABOUT"));
		});
		file.add(calc);
		file.add(clear);
		file.add(option);
		file.add(exit);
		goTo.add(reales);
		help.add(calculatorMenu);
		help.add(keyShortcut);
		help.add(creator);
		help.add(about);
		mb.add(file);
		mb.add(goTo);
		mb.add(help);
		setJMenuBar(mb);

		// Image Icon
		clear.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(clearmbI.getImage(), 35, 35)));
		calc.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(calcI.getImage(), 35, 35)));
		option.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(settingI.getImage(), 35, 35)));
		exit.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(exitI.getImage(), 35, 35)));
		reales.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(moneyI.getImage(), 35, 35)));
		keyShortcut.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(keyboardI.getImage(), 35, 35)));
		creator.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(creatorI.getImage(), 35, 35)));
		about.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(aboutI.getImage(), 35, 35)));
		calculatorMenu.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(calcI.getImage(), 35, 35)));

		/* ACTION LISTENER FOR MENU ITEM */
		option.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_DOWN_MASK));
		clear.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, KeyEvent.CTRL_DOWN_MASK));
		reales.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
		calculatorMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_MULTIPLY, KeyEvent.CTRL_DOWN_MASK));

		/* White Mode */
		if (conf[10].equalsIgnoreCase("2")) {
			/* Part 1 */
			for (int i = 0; i < 4; i++) {
				title[i].setForeground(Intro.blackM);
				title[i].setBackground(Intro.grisD);
				title[i].setBorder(Intro.borderD);
			}
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 3; j++) {
					details[i][j].setForeground(Intro.blackM);
					details[i][j].setBorder(Intro.borderD);
					details[i][j].setCaretColor(Intro.blackM);
				}
				detailsR[i].setForeground(Intro.blackM);
				detailsR[i].setBorder(Intro.borderD);
			}
			total.setBackground(new Color(0x535353));
			total.setForeground(Color.white);
			total.setBorder(Intro.borderD);
			/* Part 2 */
			caja.setBorder(Intro.borderD);
			caja.setForeground(Intro.blackM);
			caja.setBackground(Intro.grisD);
			for (int i = 0; i < 2; i++)
				for (int j = 0; j < 7; j++) {
					cajaTroco[i][j].setBorder(Intro.borderD);
					cajaTroco[i][j].setForeground(Intro.blackM);
				}
			/* Part 3 */
			cambioC.setBorder(Intro.borderD);
			cambioC.setForeground(Intro.blackM);
			cambioC.setBackground(Intro.grisD);
			for (int i = 0; i < 7; i++) {
				trocoC[i].setBorder(Intro.borderD);
				trocoCT[i].setBorder(Intro.borderD);
				trocoCT[i].setForeground(Intro.blackM);
			}
			totalC.setBorder(Intro.borderD);
			totalC.setForeground(Intro.lightC);
			totalC.setBackground(new Color(0x535353));
			/* Part 4 */
			for (int i = 0; i < 6; i++) {
				if (i < 3) {
					cambio[i].setBorder(Intro.borderD);
					cambio[i].setForeground(Intro.blackM);
					cambio[i].setBackground(Intro.grisD);
				} else {
					cambio[i].setBorder(Intro.borderD);
					cambio[i].setForeground(Intro.blackM);
					cambio[i].setBackground(Intro.lightC);
				}
				cambio[i].setBorder(Intro.borderD);
			}
			/* Part 5 */
			cambioN.setBorder(Intro.borderD);
			cambioN2.setBorder(Intro.borderD);
			cambioN3.setBorder(Intro.borderD);
			for (int i = 0; i < 2; i++)
				for (int j = 0; j < 7; j++) {
					troco[i][j].setBorder(Intro.borderD);
					troco2[i][j].setBorder(Intro.borderD);
					troco3[i][j].setBorder(Intro.borderD);
				}
			/* Menubar */
			clear.setIcon(ImageEffect.getScaledImage(clearmbI.getImage(), 35, 35));
			calc.setIcon(ImageEffect.getScaledImage(calcI.getImage(), 35, 35));
			option.setIcon(ImageEffect.getScaledImage(settingI.getImage(), 35, 35));
			exit.setIcon(ImageEffect.getScaledImage(exitI.getImage(), 35, 35));
			reales.setIcon(ImageEffect.getScaledImage(moneyI.getImage(), 35, 35));
			keyShortcut.setIcon(ImageEffect.getScaledImage(keyboardI.getImage(), 35, 35));
			creator.setIcon(ImageEffect.getScaledImage(creatorI.getImage(), 35, 35));
			about.setIcon(ImageEffect.getScaledImage(aboutI.getImage(), 35, 35));
			calculatorMenu.setIcon(ImageEffect.getScaledImage(calcI.getImage(), 35, 35));
		}

		// Frame start
		setVisible(true);

		// Close popup
		addWindowListener(new java.awt.event.WindowAdapter() {

			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				ModernDialog dialog = new ModernDialog(FaturaR.this, getLocalizedMessage("EXIT_Q"), false);
				dialog.addSubText(getLocalizedMessage("CANNOT_UNDO"), fg);
				dialog.setIcon(IconType.ERROR);
				dialog.addButton(getLocalizedMessage("YES"), Intro.greenM, () -> {
					System.exit(0);
				});
				dialog.addButton(getLocalizedMessage("NO"), Intro.redM, dialog::dispose);

				dialog.setColor(bg);
				dialog.setTextColor(fg);
				dialog.setOverlayColor(bg);
				dialog.setVisible(true);
			}

		});
	}

	private ArrayList<String> listMercadoria() {
		ArrayList<String> list = new ArrayList<String>();
		File extraF = new File(dataFolder + "\\stock");
		extraF.mkdir();
		File merchFile = new File(extraF, "stock.dll");
		if (!merchFile.exists()) {
			try {
				merchFile.createNewFile();
			} catch (IOException e) {
				writeError(e);
			}
		}
		try (BufferedReader dataOpened = new BufferedReader(new FileReader(merchFile))) {
			String line;
			while ((line = dataOpened.readLine()) != null) {
				String[] row = line.split(",");
				if (row.length > 0)
					list.add(row[0].toLowerCase());
			}
		} catch (Exception e) {
			writeError(e);
		}
		return list;
	}

	private void openConfiguration() {
		BufferedReader dataOpened = null;
		String line = "";
		int tempC = 0;
		try {
			dataOpened = new BufferedReader(new FileReader(confFile));
			while ((line = dataOpened.readLine()) != null) {
				conf[tempC] = line.toString();
				tempC++;
			}
			dataOpened.close();
		} catch (Exception e) {
			writeError(e);
		}

		/* Always On Top */
		if (conf[12] == null || conf[12].equalsIgnoreCase("null") || conf[12].equals("false"))
			setAlwaysOnTop(true);
		else
			setAlwaysOnTop(false);

		/* THEME ENTER */
		try {
			if (conf[10] == null || conf[10].equalsIgnoreCase("0") || conf[10].equalsIgnoreCase("null")) {
				getContentPane().setBackground(Intro.blackM);
				fg = Intro.lightC;
				bg = Intro.blackM;
				switch (conf[14]) {
				case "0":
					UIManager.setLookAndFeel(new FlatDarkLaf());
					break;
				case "1":
					UIManager.setLookAndFeel(new FlatMacDarkLaf());
					break;
				case "2":
					UIManager.setLookAndFeel(new FlatAtomOneDarkIJTheme());
					break;
				case "3":
					UIManager.setLookAndFeel(new FlatMaterialDarkerIJTheme());
					break;
				default:
					UIManager.setLookAndFeel(new FlatDarkLaf());
					break;
				}
			} else if (conf[10].equalsIgnoreCase("1")) {
				getContentPane().setBackground(Intro.blueM);
				fg = Intro.lightC;
				bg = Intro.blueM;
				switch (conf[14]) {
				case "0":
					UIManager.setLookAndFeel(new FlatCarbonIJTheme());
					break;
				case "1":
					UIManager.setLookAndFeel(new FlatCobalt2IJTheme());
					break;
				case "2":
					UIManager.setLookAndFeel(new FlatNightOwlIJTheme());
					break;
				case "3":
					UIManager.setLookAndFeel(new FlatMaterialDeepOceanIJTheme());
					break;
				default:
					UIManager.setLookAndFeel(new FlatCarbonIJTheme());
					break;
				}
			} else {
				getContentPane().setBackground(Intro.lightC);
				bg = Intro.lightC;
				fg = Intro.blackM;
				switch (conf[14]) {
				case "0":
					UIManager.setLookAndFeel(new FlatIntelliJLaf());
					break;
				case "1":
					UIManager.setLookAndFeel(new FlatMacLightLaf());
					break;
				case "2":
					UIManager.setLookAndFeel(new FlatAtomOneLightIJTheme());
					break;
				case "3":
					UIManager.setLookAndFeel(new FlatMaterialLighterIJTheme());
					break;
				default:
					UIManager.setLookAndFeel(new FlatIntelliJLaf());
					break;
				}
			}
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			writeError(e);
		}
		setIconImage(new ImageIcon(getClass().getResource("images/icon/icon.png")).getImage());

		// LANGUAGE
		if (conf[7] == null || conf[7].equals("0"))
			language = Language.SPANISH;
		else if (conf[7].equals("1"))
			language = Language.PORTUGUES;
		else if (conf[7].equals("2"))
			language = Language.ENGLISH;
		else
			language = Language.FRENCH;

	}

	// Add Sound effect
	private void soundEffect(URL sound) {
		try {// sounds
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(sound);
			Clip clip = AudioSystem.getClip();
			clip.open(audioStream);
			clip.start();
		} catch (Exception e) {
			writeError(e);
		}
	}

	private void clearAll() {
		if (conf[1] == null || conf[1].equalsIgnoreCase("null") || conf[1].equals("false"))
			soundEffect(clearSound);
		for (int i = 0; i < 7; i++)
			trocoCT[i].setText("0");
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 3; j++)
				details[i][j].setText("");
		for (int i = 0; i < 9; i++)
			detailsR[i].setText("");
		pixValue = 0;
		calTodo();
		cambioN.setText(getLocalizedMessage("METHOD1"));
		cambioN2.setText(getLocalizedMessage("METHOD2"));
		cambioN3.setText(getLocalizedMessage("METHOD3"));
		cambioN.setBackground(redD);
		cambioN2.setBackground(violetD);
		cambioN3.setBackground(turD);
		Toast.show(this, Toast.Type.SUCCESS, getLocalizedMessage("CLEAN_S"), Intro.notOption);
	}

	// Focus for the fatura
	private void tableFocus(int i, int j) {
		details[i][j].addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if ((e.getKeyCode() == KeyEvent.VK_SHIFT)) {
					details[i][j].setNextFocusableComponent(trocoCT[0]);
					details[i][j].nextFocus();
				} else if ((e.getKeyCode() == KeyEvent.VK_0) && ((e.getModifiers() & InputEvent.CTRL_MASK) != 0))
					setState(Frame.ICONIFIED);
				else if (e.getKeyCode() == KeyEvent.VK_RIGHT && ((e.getModifiers() & InputEvent.CTRL_MASK) != 0)) {
					/* do Nothing */
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (j < 2) {
						details[i][j].setNextFocusableComponent(details[i][j + 1]);
						details[i][j].nextFocus();
					} else {
						if (i < 9) {
							details[i][j].setNextFocusableComponent(details[i + 1][0]);
							details[i][j].nextFocus();
						} else {
							details[i][j].setNextFocusableComponent(details[0][0]);
							details[i][j].nextFocus();
						}
					}

				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (j > 0) {
						details[i][j].setNextFocusableComponent(details[i][j - 1]);
						details[i][j].nextFocus();
					} else {
						if (i > 0) {
							details[i][j].setNextFocusableComponent(details[i - 1][2]);
							details[i][j].nextFocus();
						} else {
							details[i][j].setNextFocusableComponent(details[9][2]);
							details[i][j].nextFocus();
						}
					}
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					if (i > 0) {
						details[i][j].setNextFocusableComponent(details[i - 1][j]);
						details[i][j].nextFocus();
					} else {
						details[i][j].setNextFocusableComponent(details[9][j]);
						details[i][j].nextFocus();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					if (i < 9) {
						details[i][j].setNextFocusableComponent(details[i + 1][j]);
						details[i][j].nextFocus();
					} else {
						details[i][j].setNextFocusableComponent(details[0][j]);
						details[i][j].nextFocus();
					}
				}
			}
		});
	}

	// Focus for the cliente
	private void clienteFocus(int i) {
		trocoCT[i].addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if ((e.getKeyCode() == KeyEvent.VK_SHIFT)) {
					trocoCT[i].setNextFocusableComponent(details[0][0]);
					trocoCT[i].nextFocus();
				} else if ((e.getKeyCode() == KeyEvent.VK_0) && ((e.getModifiers() & InputEvent.CTRL_MASK) != 0))
					setState(Frame.ICONIFIED);
				else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (i < 6) {
						trocoCT[i].setNextFocusableComponent(trocoCT[i + 1]);
						trocoCT[i].nextFocus();
					} else {
						trocoCT[i].setNextFocusableComponent(trocoCT[0]);
						trocoCT[i].nextFocus();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT)
					if (i > 0) {
						trocoCT[i].setNextFocusableComponent(trocoCT[i - 1]);
						trocoCT[i].nextFocus();
					} else {
						trocoCT[i].setNextFocusableComponent(trocoCT[6]);
						trocoCT[i].nextFocus();
					}
			}
		});
	}

	// Method 1 work
	private void cambioF() {
		for (int i = 0; i < 7; i++)
			cajaTroco[1][i].setText(Integer.valueOf(cajaTroco[1][i].getText()) - Integer.valueOf(troco[1][i].getText())
					+ Integer.valueOf(trocoCT[i].getText()) + "");
		saveProgress();
		Toast.show(this, Toast.Type.SUCCESS, getLocalizedMessage("ADDED_S"), Intro.notOption);
		clearAll();
	}

	// Method 2 work
	private void cambioF2() {
		for (int i = 0; i < 7; i++)
			cajaTroco[1][i].setText(Integer.valueOf(cajaTroco[1][i].getText()) - Integer.valueOf(troco2[1][i].getText())
					+ Integer.valueOf(trocoCT[i].getText()) + "");
		saveProgress();
		Toast.show(this, Toast.Type.SUCCESS, getLocalizedMessage("ADDED_S"), Intro.notOption);
		clearAll();
	}

	// Method 3 work
	private void cambioF3() {
		for (int i = 0; i < 7; i++)
			cajaTroco[1][i].setText(Integer.valueOf(cajaTroco[1][i].getText()) - Integer.valueOf(troco3[1][i].getText())
					+ Integer.valueOf(trocoCT[i].getText()) + "");
		saveProgress();
		Toast.show(this, Toast.Type.SUCCESS, getLocalizedMessage("ADDED_S"), Intro.notOption);
		clearAll();
	}

	// PIX
	private void cambioPIXF() {
		pixValue = Integer.valueOf(totalFatura);
		saveProgress();
		Toast.show(this, Toast.Type.SUCCESS, getLocalizedMessage("ADDED_S"), Intro.notOption);
		clearAll();
	}

	// Calc everything
	private void calTodo() {
		totalFatura = 0;
		for (int i = 0; i < 10; i++) // if input wrong make it 0
			if (!details[i][0].getText().isBlank() && !details[i][2].getText().isBlank()
					&& TextEffect.isInteger(details[i][0].getText()) && TextEffect.isInteger(details[i][2].getText())) {
				detailsR[i].setText(
						Integer.valueOf(details[i][0].getText()) * Integer.valueOf(details[i][2].getText()) + "");
				totalFatura += Integer.valueOf(detailsR[i].getText());
			}
		for (int i = 0; i < 7; i++)// if input wrong make it 0
			if (!TextEffect.isInteger(trocoCT[i].getText()))
				trocoCT[i].setText("0");
		total.setText("R$ " + totalFatura);// total for the invoice
		totalCV = Integer.valueOf(trocoCT[0].getText()) + Integer.valueOf(trocoCT[1].getText()) * 2
				+ Integer.valueOf(trocoCT[2].getText()) * 5 + Integer.valueOf(trocoCT[3].getText()) * 10
				+ Integer.valueOf(trocoCT[4].getText()) * 20 + Integer.valueOf(trocoCT[5].getText()) * 50
				+ Integer.valueOf(trocoCT[6].getText()) * 100;
		totalC.setText("R$ " + totalCV);// total for the cliente
		cambio[3].setText("R$ " + totalFatura);
		cambio[5].setText("R$ " + totalCV);
		trocoV = totalCV - totalFatura;// troco
		if (totalCV < totalFatura)
			cambio[4].setText("-R$ " + (totalFatura - totalCV));
		else
			cambio[4].setText("R$ " + (totalCV - totalFatura));
		// Trocos
		if (trocoV >= 0) {
			// Smart
			int trocoRest = trocoV;
			int nbOf100 = Integer.valueOf(cajaTroco[1][6].getText()),
					nbOf50 = Integer.valueOf(cajaTroco[1][5].getText()),
					nbOf20 = Integer.valueOf(cajaTroco[1][4].getText()),
					nbOf10 = Integer.valueOf(cajaTroco[1][3].getText()),
					nbOf5 = Integer.valueOf(cajaTroco[1][2].getText()),
					nbOf2 = Integer.valueOf(cajaTroco[1][1].getText()),
					nbOf1 = Integer.valueOf(cajaTroco[1][0].getText());
			// 100
			if (trocoRest > 100)
				if (((trocoRest / 10) & 1) == 1 && nbOf10 == 0 && nbOf20 * 20 >= (trocoRest - 50) && trocoRest < 150) {
					if (nbOf50 > 0) {
						nbOf50--;
						trocoRest -= 50;
					}
				} else {
					if (nbOf100 > 0) {
						nbOf100--;
						trocoRest -= 100;
					}
				}
			// 10,20,50
			if (((trocoRest / 10) & 1) == 0 && nbOf10 == 0 && nbOf20 * 20 >= trocoRest)// we dont have 10
				while (trocoRest >= 20 && nbOf20 > 0) {
					nbOf20--;
					trocoRest -= 20;
				}
			else {// normal
				while (trocoRest >= 50 && nbOf50 > 0) {
					nbOf50--;
					trocoRest -= 50;
				}
				while (trocoRest >= 20 && nbOf20 > 0) {
					nbOf20--;
					trocoRest -= 20;
				}
				while (trocoRest >= 10 && nbOf10 > 0) {
					nbOf10--;
					trocoRest -= 10;
				}
			}
			// 1,2,5
			if ((trocoRest & 1) == 0 && nbOf1 == 0)// we dont have 1
				while (trocoRest >= 2 && nbOf2 > 0) {
					nbOf2--;
					trocoRest -= 2;
				}
			else {// normal
				while (trocoRest >= 5 && nbOf5 > 0) {
					nbOf5--;
					trocoRest -= 5;
				}
				while (trocoRest >= 2 && nbOf2 > 0) {
					nbOf2--;
					trocoRest -= 2;
				}
				while (trocoRest >= 1 && nbOf1 > 0) {
					nbOf1--;
					trocoRest--;
				}
			}
			// Method 1
			if (trocoRest == 0) {// smart
				troco[1][6].setText(Integer.valueOf(cajaTroco[1][6].getText()) - nbOf100 + "");
				troco[1][5].setText(Integer.valueOf(cajaTroco[1][5].getText()) - nbOf50 + "");
				troco[1][4].setText(Integer.valueOf(cajaTroco[1][4].getText()) - nbOf20 + "");
				troco[1][3].setText(Integer.valueOf(cajaTroco[1][3].getText()) - nbOf10 + "");
				troco[1][2].setText(Integer.valueOf(cajaTroco[1][2].getText()) - nbOf5 + "");
				troco[1][1].setText(Integer.valueOf(cajaTroco[1][1].getText()) - nbOf2 + "");
				troco[1][0].setText(Integer.valueOf(cajaTroco[1][0].getText()) - nbOf1 + "");
				cambioN.setText("√");
			} else {
				methodeReservo();
				if (Integer.valueOf(troco[1][0].getText()) <= Integer.valueOf((cajaTroco[1][0].getText()))
						&& Integer.valueOf(troco[1][1].getText()) <= Integer.valueOf((cajaTroco[1][1].getText()))
						&& Integer.valueOf(troco[1][2].getText()) <= Integer.valueOf((cajaTroco[1][2].getText()))
						&& Integer.valueOf(troco[1][3].getText()) <= Integer.valueOf((cajaTroco[1][3].getText()))
						&& Integer.valueOf(troco[1][4].getText()) <= Integer.valueOf((cajaTroco[1][4].getText()))
						&& Integer.valueOf(troco[1][5].getText()) <= Integer.valueOf((cajaTroco[1][5].getText()))
						&& Integer.valueOf(troco[1][6].getText()) <= Integer.valueOf((cajaTroco[1][6].getText())))
					cambioN.setText("√");
				else
					cambioN.setText("X");
			}
			// Method 2
			methodPopular();
			if (Integer.valueOf(troco2[1][0].getText()) <= Integer.valueOf((cajaTroco[1][0].getText()))
					&& Integer.valueOf(troco2[1][1].getText()) <= Integer.valueOf((cajaTroco[1][1].getText()))
					&& Integer.valueOf(troco2[1][2].getText()) <= Integer.valueOf((cajaTroco[1][2].getText()))
					&& Integer.valueOf(troco2[1][3].getText()) <= Integer.valueOf((cajaTroco[1][3].getText()))
					&& Integer.valueOf(troco2[1][4].getText()) <= Integer.valueOf((cajaTroco[1][4].getText()))
					&& Integer.valueOf(troco2[1][5].getText()) <= Integer.valueOf((cajaTroco[1][5].getText()))
					&& Integer.valueOf(troco2[1][6].getText()) <= Integer.valueOf((cajaTroco[1][6].getText())))
				cambioN2.setText("√");
			else
				cambioN2.setText("X");
			// Method 3
			methodBasico();
			if (Integer.valueOf(troco3[1][0].getText()) <= Integer.valueOf((cajaTroco[1][0].getText()))
					&& Integer.valueOf(troco3[1][1].getText()) <= Integer.valueOf((cajaTroco[1][1].getText()))
					&& Integer.valueOf(troco3[1][2].getText()) <= Integer.valueOf((cajaTroco[1][2].getText()))
					&& Integer.valueOf(troco3[1][3].getText()) <= Integer.valueOf((cajaTroco[1][3].getText()))
					&& Integer.valueOf(troco3[1][4].getText()) <= Integer.valueOf((cajaTroco[1][4].getText()))
					&& Integer.valueOf(troco3[1][5].getText()) <= Integer.valueOf((cajaTroco[1][5].getText()))
					&& Integer.valueOf(troco3[1][6].getText()) <= Integer.valueOf((cajaTroco[1][6].getText())))
				cambioN3.setText("√");
			else
				cambioN3.setText("X");
		} else {
			troco[1][6].setText("!");
			troco[1][5].setText("!");
			troco[1][4].setText("!");
			troco[1][3].setText("!");
			troco[1][2].setText("!");
			troco[1][1].setText("!");
			troco[1][0].setText("!");
			troco2[1][6].setText("!");
			troco2[1][5].setText("!");
			troco2[1][4].setText("!");
			troco2[1][3].setText("!");
			troco2[1][2].setText("!");
			troco2[1][1].setText("!");
			troco2[1][0].setText("!");
			troco3[1][6].setText("!");
			troco3[1][5].setText("!");
			troco3[1][4].setText("!");
			troco3[1][3].setText("!");
			troco3[1][2].setText("!");
			troco3[1][1].setText("!");
			troco3[1][0].setText("!");
			cambioN.setText("X");
			cambioN2.setText("X");
			cambioN3.setText("X");
		}
		if (totalFatura != 0) {
			if (cambioN.getText().equals("√"))
				cambioN.setBackground(redC);
			else
				cambioN.setBackground(redD);
			if (cambioN2.getText().equals("√"))
				cambioN2.setBackground(violetC);
			else
				cambioN2.setBackground(violetD);
			if (cambioN3.getText().equals("√"))
				cambioN3.setBackground(turC);
			else
				cambioN3.setBackground(turD);
		} else {
			cambioN.setText(getLocalizedMessage("METHOD1"));
			cambioN2.setText(getLocalizedMessage("METHOD2"));
			cambioN3.setText(getLocalizedMessage("METHOD3"));
			cambioN.setBackground(redD);
			cambioN2.setBackground(violetD);
			cambioN3.setBackground(turD);
		}
	}

	private void methodeReservo() {
		troco[1][6].setText((trocoV / 100) + "");// 100
		// Por 10,20,50
		switch ((trocoV - (trocoV / 100) * 100) / 10) {
		case 0: {
			troco[1][5].setText("0");
			troco[1][4].setText("0");
			troco[1][3].setText("0");
			break;
		}
		case 1: {
			troco[1][5].setText("0");
			troco[1][4].setText("0");
			troco[1][3].setText("1");
			break;
		}
		case 2: {
			troco[1][5].setText("0");
			troco[1][4].setText("0");
			troco[1][3].setText("2");
			break;
		}
		case 3: {
			troco[1][5].setText("0");
			troco[1][4].setText("0");
			troco[1][3].setText("3");
			break;
		}
		case 4: {
			troco[1][5].setText("0");
			troco[1][4].setText("0");
			troco[1][3].setText("4");
			break;
		}
		case 5: {
			troco[1][5].setText("0");
			troco[1][4].setText("1");
			troco[1][3].setText("3");
			break;
		}
		case 6: {
			troco[1][5].setText("0");
			troco[1][4].setText("2");
			troco[1][3].setText("2");
			break;
		}
		case 7: {
			troco[1][5].setText("1");
			troco[1][4].setText("0");
			troco[1][3].setText("2");
			break;
		}
		case 8: {
			troco[1][5].setText("1");
			troco[1][4].setText("0");
			troco[1][3].setText("3");
			break;
		}
		case 9: {
			troco[1][5].setText("1");
			troco[1][4].setText("1");
			troco[1][3].setText("2");
			break;
		}
		}
		// Por 1,2,5
		switch ((trocoV - (trocoV / 10) * 10)) {
		case 0: {
			troco[1][2].setText("0");
			troco[1][1].setText("0");
			troco[1][0].setText("0");
			break;
		}
		case 1: {
			troco[1][2].setText("0");
			troco[1][1].setText("0");
			troco[1][0].setText("1");
			break;
		}
		case 2: {
			troco[1][2].setText("0");
			troco[1][1].setText("0");
			troco[1][0].setText("2");
			break;
		}
		case 3: {
			troco[1][2].setText("0");
			troco[1][1].setText("0");
			troco[1][0].setText("3");
			break;
		}
		case 4: {
			troco[1][2].setText("0");
			troco[1][1].setText("0");
			troco[1][0].setText("4");
			break;
		}
		case 5: {
			troco[1][2].setText("0");
			troco[1][1].setText("1");
			troco[1][0].setText("3");
			break;
		}
		case 6: {
			troco[1][2].setText("0");
			troco[1][1].setText("2");
			troco[1][0].setText("2");
			break;
		}
		case 7: {
			troco[1][2].setText("1");
			troco[1][1].setText("0");
			troco[1][0].setText("2");
			break;
		}
		case 8: {
			troco[1][2].setText("1");
			troco[1][1].setText("0");
			troco[1][0].setText("3");
			break;
		}
		case 9: {
			troco[1][2].setText("1");
			troco[1][1].setText("1");
			troco[1][0].setText("2");
			break;
		}
		}
	}

	private void methodBasico() {
		troco3[1][6].setText((trocoV / 100) + "");// 100
		// Por 10,20,50
		switch ((trocoV - (trocoV / 100) * 100) / 10) {
		case 0: {
			troco3[1][5].setText("0");
			troco3[1][4].setText("0");
			troco3[1][3].setText("0");
			break;
		}
		case 1: {
			troco3[1][5].setText("0");
			troco3[1][4].setText("0");
			troco3[1][3].setText("1");
			break;
		}
		case 2: {
			troco3[1][5].setText("0");
			troco3[1][4].setText("1");
			troco3[1][3].setText("0");
			break;
		}
		case 3: {
			troco3[1][5].setText("0");
			troco3[1][4].setText("1");
			troco3[1][3].setText("1");
			break;
		}
		case 4: {
			troco3[1][5].setText("0");
			troco3[1][4].setText("1");
			troco3[1][3].setText("2");
			break;
		}
		case 5: {
			troco3[1][5].setText("0");
			troco3[1][4].setText("2");
			troco3[1][3].setText("1");
			break;
		}
		case 6: {
			troco3[1][5].setText("0");
			troco3[1][4].setText("3");
			troco3[1][3].setText("0");
			break;
		}
		case 7: {
			troco3[1][5].setText("0");
			troco3[1][4].setText("3");
			troco3[1][3].setText("1");
			break;
		}
		case 8: {
			troco3[1][5].setText("0");
			troco3[1][4].setText("4");
			troco3[1][3].setText("0");
			break;
		}
		case 9: {
			troco3[1][5].setText("0");
			troco3[1][4].setText("4");
			troco3[1][3].setText("1");
			break;
		}
		}
		// Por 1,2,5
		switch ((trocoV - (trocoV / 10) * 10)) {
		case 0: {
			troco3[1][2].setText("0");
			troco3[1][1].setText("0");
			troco3[1][0].setText("0");
			break;
		}
		case 1: {
			troco3[1][2].setText("0");
			troco3[1][1].setText("0");
			troco3[1][0].setText("1");
			break;
		}
		case 2: {
			troco3[1][2].setText("0");
			troco3[1][1].setText("1");
			troco3[1][0].setText("0");
			break;
		}
		case 3: {
			troco3[1][2].setText("0");
			troco3[1][1].setText("1");
			troco3[1][0].setText("1");
			break;
		}
		case 4: {
			troco3[1][2].setText("0");
			troco3[1][1].setText("1");
			troco3[1][0].setText("2");
			break;
		}
		case 5: {
			troco3[1][2].setText("0");
			troco3[1][1].setText("2");
			troco3[1][0].setText("1");
			break;
		}
		case 6: {
			troco3[1][2].setText("0");
			troco3[1][1].setText("3");
			troco3[1][0].setText("0");
			break;
		}
		case 7: {
			troco3[1][2].setText("0");
			troco3[1][1].setText("3");
			troco3[1][0].setText("1");
			break;
		}
		case 8: {
			troco3[1][2].setText("0");
			troco3[1][1].setText("4");
			troco3[1][0].setText("0");
			break;
		}
		case 9: {
			troco3[1][2].setText("0");
			troco3[1][1].setText("4");
			troco3[1][0].setText("1");
			break;
		}
		}
	}

	private void methodPopular() {
		troco2[1][6].setText((trocoV / 100) + "");// 100
		// Por 10,20,50
		switch ((trocoV - (trocoV / 100) * 100) / 10) {
		case 0: {
			troco2[1][5].setText("0");
			troco2[1][4].setText("0");
			troco2[1][3].setText("0");
			break;
		}
		case 1: {
			troco2[1][5].setText("0");
			troco2[1][4].setText("0");
			troco2[1][3].setText("1");
			break;
		}
		case 2: {
			troco2[1][5].setText("0");
			troco2[1][4].setText("1");
			troco2[1][3].setText("0");
			break;
		}
		case 3: {
			troco2[1][5].setText("0");
			troco2[1][4].setText("1");
			troco2[1][3].setText("1");
			break;
		}
		case 4: {
			troco2[1][5].setText("0");
			troco2[1][4].setText("2");
			troco2[1][3].setText("0");
			break;
		}
		case 5: {
			troco2[1][5].setText("1");
			troco2[1][4].setText("0");
			troco2[1][3].setText("0");
			break;
		}
		case 6: {
			troco2[1][5].setText("1");
			troco2[1][4].setText("0");
			troco2[1][3].setText("1");
			break;
		}
		case 7: {
			troco2[1][5].setText("1");
			troco2[1][4].setText("1");
			troco2[1][3].setText("0");
			break;
		}
		case 8: {
			troco2[1][5].setText("1");
			troco2[1][4].setText("1");
			troco2[1][3].setText("1");
			break;
		}
		case 9: {
			troco2[1][5].setText("1");
			troco2[1][4].setText("2");
			troco2[1][3].setText("0");
			break;
		}
		}
		// Por 1,2,5
		switch ((trocoV - (trocoV / 10) * 10)) {
		case 0: {
			troco2[1][2].setText("0");
			troco2[1][1].setText("0");
			troco2[1][0].setText("0");
			break;
		}
		case 1: {
			troco2[1][2].setText("0");
			troco2[1][1].setText("0");
			troco2[1][0].setText("1");
			break;
		}
		case 2: {
			troco2[1][2].setText("0");
			troco2[1][1].setText("1");
			troco2[1][0].setText("0");
			break;
		}
		case 3: {
			troco2[1][2].setText("0");
			troco2[1][1].setText("1");
			troco2[1][0].setText("1");
			break;
		}
		case 4: {
			troco2[1][2].setText("0");
			troco2[1][1].setText("2");
			troco2[1][0].setText("0");
			break;
		}
		case 5: {
			troco2[1][2].setText("1");
			troco2[1][1].setText("0");
			troco2[1][0].setText("0");
			break;
		}
		case 6: {
			troco2[1][2].setText("1");
			troco2[1][1].setText("0");
			troco2[1][0].setText("1");
			break;
		}
		case 7: {
			troco2[1][2].setText("1");
			troco2[1][1].setText("1");
			troco2[1][0].setText("0");
			break;
		}
		case 8: {
			troco2[1][2].setText("1");
			troco2[1][1].setText("1");
			troco2[1][0].setText("1");
			break;
		}
		case 9: {
			troco2[1][2].setText("1");
			troco2[1][1].setText("2");
			troco2[1][0].setText("0");
			break;
		}
		}
	}

	private static boolean moreCases() {
		// Open values of cash
		String currentpath = System.getProperty("user.dir"), line = "";
		File tempFile0 = new File(currentpath + "\\data");
		tempFile0.mkdir();
		File newFile = new File(tempFile0, "index.dll");
		BufferedReader dataOpened = null;
		String detailsReales[] = new String[162];
		int z = 0;
		try {
			if (!newFile.exists())
				newFile.createNewFile();
			dataOpened = new BufferedReader(new FileReader(newFile));
			while ((line = dataOpened.readLine()) != null) {
				detailsReales[z] = line.toString();
				z++;
			}
			dataOpened.close();
		} catch (Exception e) {
		}
		for (int i = 0; i < 120; i++)
			if (detailsReales[i] != null && detailsReales[i].isBlank())
				return false;
		return true;
	}

	// SAVE NEW VALUE
	private static void saveProgress() {
		String temp = totalFatura + "";
		int z = 0;

		/* Open values of cash */
		String currentpath = System.getProperty("user.dir");
		File tempFile0 = new File(currentpath + "\\data");
		tempFile0.mkdir();
		File newFile = new File(tempFile0, "index.dll");
		BufferedReader dataOpened = null;
		String line = "";
		String numbers[] = new String[162];
		try {
			dataOpened = new BufferedReader(new FileReader(newFile));
			while ((line = dataOpened.readLine()) != null) {
				numbers[z] = line.toString();
				z++;
			}
			dataOpened.close();
		} catch (Exception e) {
		}
		/* Save the new value */
		try {
			FileWriter savedF = new FileWriter(newFile);
			int i = 0;
			while (i < 120) {// Ventas + total
				if ((numbers[i].isBlank() || Integer.valueOf(numbers[i]) == 0 || !TextEffect.isInteger(numbers[i]))
						&& Integer.valueOf(temp) != 0 && !totalC.getText().isBlank()) {
					savedF.write(temp + System.lineSeparator());
					temp = "0";
					i++;
				} else {
					savedF.write(numbers[i] + System.lineSeparator());
					i++;
				}
			} // Initial value
			savedF.write(numbers[i] + System.lineSeparator());
			i++;
			z = i + 16;
			while (i < z) {// gastos
				savedF.write(numbers[i] + System.lineSeparator());
				i++;
			}
			z = i + 16;
			while (i < z) {// agregados
				savedF.write(numbers[i] + System.lineSeparator());
				i++;
			}
			z = i + 7;
			while (i < z) {// Valores from 1 to 100
				savedF.write(cajaTroco[1][z - i - 1].getText() + System.lineSeparator());
				i++;
			}
			int existedPix = TextEffect.isInteger(numbers[i]) ? (Integer.valueOf(numbers[i]) + pixValue) : pixValue;
			savedF.write(existedPix + System.lineSeparator());// pix save
			savedF.close();
		} catch (Exception e) {
		}

		/* Check if the table is full */
		if (moreCases()) {
			File tempFile1 = new File(tempFile0 + "\\extra");
			tempFile1.mkdir();
			File moreFile = new File(tempFile1, "indexM" + ".dll");
			if (!moreFile.exists())
				try {
					moreFile.createNewFile();
				} catch (IOException e) {
				}
			String moreCasesNumbers[] = new String[121];
			z = 0;
			try {
				dataOpened = new BufferedReader(new FileReader(moreFile));
				while ((line = dataOpened.readLine()) != null) {
					moreCasesNumbers[z] = line.toString();
					z++;
				}
				dataOpened.close();
			} catch (Exception e) {
			}
			/* Save the new value */
			try {
				FileWriter savedF = new FileWriter(moreFile);
				int i = 0;
				while (i < 100) {// Ventas + total
					if ((moreCasesNumbers[i].isBlank() || Integer.valueOf(moreCasesNumbers[i]) == 0
							|| !TextEffect.isInteger(moreCasesNumbers[i])) && Integer.valueOf(temp) != 0
							&& !totalC.getText().isBlank()) {
						savedF.write(temp + System.lineSeparator());
						temp = "0";
						i++;
					} else {
						savedF.write(moreCasesNumbers[i] + System.lineSeparator());
						i++;
					}
				}
				savedF.close();
			} catch (Exception e) {
			}
		}

		/* Save the last update time */
		File logFolder = new File(tempFile0 + "\\LOG");
		logFolder.mkdir();
		File lastChangeF = new File(logFolder,
				Intro.dayN + Intro.monthN + new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime()));
		/* open already file */
		try {
			FileWriter lastChangeW = new FileWriter(lastChangeF);
			lastChangeW.write(new SimpleDateFormat("HH").format(Calendar.getInstance().getTime()) + ":"
					+ new SimpleDateFormat("mm").format(Calendar.getInstance().getTime()) + ":"
					+ new SimpleDateFormat("ss").format(Calendar.getInstance().getTime()));
			lastChangeW.close();
		} catch (Exception e) {
		}
	}

	// Style of textField
	private void textFieldStyle(JTextField tf) {
		tf.setOpaque(false);
		tf.setForeground(Intro.lightC);
		tf.setFont(Intro.myFont);
		tf.setBorder(Intro.borderL);
		tf.setHorizontalAlignment(0);
		tf.setCaretColor(Intro.lightC);
		tf.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				String str = tf.getText();
				tf.setText(str);
				tf.selectAll();
			}

			@Override
			public void focusLost(FocusEvent e) {
				totalFatura = 0;
				for (int i = 0; i < 10; i++) {// if input wrong make it 0
					if (!details[i][0].getText().isBlank() && !details[i][2].getText().isBlank()
							&& TextEffect.isInteger(details[i][0].getText())
							&& TextEffect.isInteger(details[i][2].getText())) {
						detailsR[i].setText(
								Integer.valueOf(details[i][0].getText()) * Integer.valueOf(details[i][2].getText())
										+ "");
						totalFatura += Integer.valueOf(detailsR[i].getText());
					} else
						detailsR[i].setText("");
					details[i][1].setFont(Intro.myFontS);
					TextEffect.adjustFontSize(details[i][1]);
				}
				total.setText("R$ " + totalFatura);// total for the invoice
			}
		});

	}

	// Style of formattedTextField
	private void formatedTextFieldStyle(JFormattedTextField tf) {
		tf.setFont(Intro.myFont);
		tf.setBorder(Intro.borderL);
		tf.setHorizontalAlignment(0);
		tf.setCaretColor(Intro.blackM);
		tf.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				String str = tf.getText();
				tf.setText(str);
				tf.selectAll();
			}

			@Override
			public void focusLost(FocusEvent e) {
				calTodo();
			}
		});

	}

	/* Return a text according to the language */
	private String getLocalizedMessage(String key) {
		// Localization logic...
		switch (language) {
		case SPANISH:
			return switch (key) {
			case "SHORTKEY" -> "• CTRL + S → ir la inicio.\n" + "• CTRL + O → esconder los botones.\n"
					+ "• SHIFT → cambiar entre las dos tablas.\n" + "• FLECHAS → subir, abajo, derecha e izquierda.\n"
					+ "• CTRL + C → abrir el configuración.\n" + "• CTRL + 0 → Minimizar la aplicación.\n"
					+ "• CTRL + W → cerrar el aplicativo.\n" + "• ALT + - → Abrir la calculadora.";
			case "KEYS" -> "ATAJOS DE TECLADO";
			case "CREDIT" -> "CRÉDITO Y DISEÑADO POR MHMDSABDLH ©";
			case "ABOUT" -> "ESTA APLICACIÓN ESTÁ DISEÑADA PARA HACER LA CAJA DE HADI-TECHP";
			case "SETTING" -> "CONFIGURACIÓN";
			case "YES" -> "SI";
			case "NO" -> "NO";
			case "EXIT_Q" -> "¿SEGURO QUE QUIERES SALIR?";
			case "FILE" -> "ARCHIVO";
			case "PRINT" -> "IMPRÍMELO";
			case "PRINT_T" -> "LA NOTA ESTÁ IMPRIMIENDO...";
			case "EXIT" -> "SALIR";
			case "CLEAR_Q" -> "¿QUIERES BORRAR TODO?";
			case "CLEAR" -> "BORRAR TODO";
			case "TITLE" -> "FACTURA - R$";
			case "ABOUTME" -> "SOBRE MI";
			case "ABOUTAPP" -> "SOBRE EL APLICATIVO";
			case "HOW_MUCH" -> "CUANTO";
			case "QNT" -> "CANT";
			case "P/U" -> "PRECIO POR UNIDAD";
			case "DET" -> "DETALLE";
			case "DESC" -> "DESCRIPCIÓN";
			case "VAL" -> "IMPORTE";
			case "CASH" -> "CAJA";
			case "CLIENT" -> "CLIENTE";
			case "CHANGE" -> "TROCÓ";
			case "METHOD1" -> "<html><center>" + "MÉTODO" + "<br>" + "SMART" + "</center></html>";
			case "METHOD2" -> "<html><center>" + "MÉTODO" + "<br>" + "POPULAR" + "</center></html>";
			case "METHOD3" -> "<html><center>" + "MÉTODO" + "<br>" + "BÁSICO" + "</center></html>";
			case "CANNOT_UNDO" -> "¡ESTO NO SE PUEDE DESHACER!";
			case "CALC" -> "ASUMAR";
			case "GO" -> "IR A";
			case "CALCULATOR" -> "CALCULADORA";
			case "CLEAN_S" -> "LIMPIEZA EXITOSAMENTE";
			case "HELP" -> "AYUDA";
			case "QUANTITY" -> "CANTIDAD";
			case "CLIENT_C" -> "QUE EL CLIENTE DA?";
			case "ADDED_S" -> "AÑADIDO AL EFECTIVO";
			case "METHOD1T" -> "ESTE MÉTODO UTILIZA MATEMÁTICAS PURAS PARA DAR EL CAMBIO";
			case "METHOD2T" -> "ESTE MÉTODO UTILIZA EL INTERCAMBIO COMÚN";
			case "METHOD3T" -> "ESTE MÉTODO UTILIZA EL CAMBIO ALTERNATIVO";
			case "METHODP" -> "ESTE MÉTODO UTILIZA WISH";
			default -> "";
			};
		case PORTUGUES:
			return switch (key) {
			case "SHORTKEY" -> "• CTRL + S → ir para o real.\n" + "• CTRL + O → ocultar os botões.\n"
					+ "• SHIFT → alternar entre as duas tabelas.\n" + "• SETAS → cima, baixo, direita e esquerda.\n"
					+ "• CTRL + C → avrir o configuracion.\n" + "• CTRL + 0 → Minimizar o aplicativo.\n"
					+ "• CTRL + W → fechar o aplicativo.\n" + "• ALT + - → Abra a calculadora.";
			case "KEYS" -> "ATALHOS DE TECLAS";
			case "CREDIT" -> "CRÉDITO E DESENHADO POR MHMDSABDLH ©";
			case "ABOUT" -> "ESTE APLICATIVO FOI PROJETADO PARA FAZER A CAIXA DO HADI-TECH";
			case "SETTING" -> "CONFIGURAÇÃO";
			case "YES" -> "SIM";
			case "NO" -> "NÃO";
			case "FILE" -> "ARQUIVO";
			case "PRINT" -> "IMPRIMA";
			case "PRINT_T" -> "A NOTA ESTÁ IMPRIMINDO...";
			case "EXIT_Q" -> "TEM CERTEZA QUE QUER SAIR?";
			case "EXIT" -> "SAIR";
			case "CLEAR_Q" -> "VOCÊ QUER APAGAR TUDO?";
			case "CLEAR" -> "LIMPAR TUDO";
			case "TITLE" -> "FATURA - R$";
			case "ABOUTME" -> "SOBRE MIM";
			case "ABOUTAPP" -> "SOBRE O APLICATIVO";
			case "HOW_MUCH" -> "QUANTO";
			case "QNT" -> "CANT";
			case "P/U" -> "PREÇO POR UNIDADE";
			case "DET" -> "DETALHE";
			case "DESC" -> "DESCRIÇÃO";
			case "VAL" -> "VALOR";
			case "CASH" -> "CAIXA";
			case "CLIENT" -> "CLIENTE";
			case "CHANGE" -> "TROCÓ";
			case "METHOD1" -> "<html><center>" + "METHODE" + "<br>" + "SMART" + "</center></html>";
			case "METHOD2" -> "<html><center>" + "MÉTODO" + "<br>" + "POPULAR" + "</center></html>";
			case "METHOD3" -> "<html><center>" + "MÉTODO" + "<br>" + "BÁSICO" + "</center></html>";
			case "CANNOT_UNDO" -> "ISTO NÃO PODE SER DESFEITO!";
			case "CALC" -> "ASSUMIR";
			case "GO" -> "VAI";
			case "CALCULATOR" -> "CALCULADORA";
			case "CLEAN_S" -> "LIMPE COM SUCESSO";
			case "HELP" -> "AJUDA";
			case "QUANTITY" -> "QUANTIDADE";
			case "CLIENT_C" -> "O QUE O CLIENTE DÁ?";
			case "ADDED_S" -> "ADICIONADO AO CAIXA";
			case "METHOD1T" -> "ESTE MÉTODO USA MATEMÁTICA PURA PARA DAR A TROCA";
			case "METHOD2T" -> "ESTE MÉTODO USA A COMUNIDADE DE TROCA";
			case "METHOD3T" -> "ESTE MÉTODO USA A TROCA ALTERNATIVA";
			case "METHODP" -> "ESTE MÉTODO USA WISH";
			default -> "";
			};
		case ENGLISH:
			return switch (key) {
			case "SHORTKEY" -> "• CTRL + S → go to real.\n" + "• CTRL + O → hide buttons.\n"
					+ "• SHIFT → switch between the two tables.\n" + "• ARROWS → up, down, right and left.\n"
					+ "• CTRL + C → open the settings.\n" + "• CTRL + 0 → Minimize the app.\n"
					+ "• CTRL + W → exit the application.\n" + "• ALT + - → Open the calculator.";
			case "KEYS" -> "KEY SHORTCUTS";
			case "CREDIT" -> "CREDIT AND DESIGNED BY MHMDSABDLH ©";
			case "ABOUT" -> "THIS APP IS DESIGNED TO DO THE CASH FOR HADI-TECH";
			case "SETTING" -> "CONFIGURATION";
			case "YES" -> "YES";
			case "NO" -> "NO";
			case "EXIT_Q" -> "ARE YOU SURE YOU WANT TO LEAVE?";
			case "FILE" -> "FILE";
			case "PRINT" -> "PRINT IT";
			case "PRINT_T" -> "THE NOTE IS PRINTING...";
			case "EXIT" -> "EXIT";
			case "CLEAR_Q" -> "DO YOU WANT TO DELETE EVERYTHING?";
			case "CLEAR" -> "DELETE EVERYTHING";
			case "TITLE" -> "INVOICE - R$";
			case "ABOUTME" -> "ABOUT ME";
			case "ABOUTAPP" -> "ABOUT THE APP";
			case "HOW_MUCH" -> "HOW MUCH";
			case "QNT" -> "QNT";
			case "P/U" -> "PRICE PER UNIT";
			case "DESC" -> "DESCRIPTION";
			case "DET" -> "DETAIL";
			case "VAL" -> "VALUE";
			case "CASH" -> "CASH";
			case "CLIENT" -> "CLIENT";
			case "CHANGE" -> "CHANGE";
			case "METHOD1" -> "<html><center>" + "METHOD" + "<br>" + "SMART" + "</center></html>";
			case "METHOD2" -> "<html><center>" + "METHOD" + "<br>" + "POPULAR" + "</center></html>";
			case "METHOD3" -> "<html><center>" + "METHOD" + "<br>" + "BASIC" + "</center></html>";
			case "CANNOT_UNDO" -> "THIS CANNOT BE UNDONE!";
			case "CALC" -> "ASSUME";
			case "GO" -> "GO";
			case "CALCULATOR" -> "CALCULATOR";
			case "CLEAN_S" -> "CLEAN SUCCESSFULLY";
			case "HELP" -> "HELP";
			case "QUANTITY" -> "QUANTITY";
			case "CLIENT_C" -> "WHAT DOES THE CUSTOMER GIVE?";
			case "ADDED_S" -> "ADDED TO THE CASH";
			case "METHOD1T" -> "THIS METHOD USE PURE MATH TO GIVE THE EXCHANGEE";
			case "METHOD2T" -> "THIS METHOD USE THE EXCHANGE COMMUN";
			case "METHOD3T" -> "THIS METHOD USE THE ALTERNATIVE EXCHANGE";
			case "METHODP" -> "THIS METHOD USE WISH";
			default -> "";
			};
		case FRENCH:
			return switch (key) {
			case "SHORTKEY" -> "• CTRL + S → aller au réel.\n" + "• CTRL + O → masquer les boutons.\n"
					+ "• MAJ → basculer entre les deux tableaux.\n" + "• FLECHES → haut, bas, droite et gauche.\n"
					+ "CTRL + C → ouvrir les paramètres.\n" + "• CTRL + 0 → Réduire l'application.\n"
					+ "• CTRL + W → quitter l'application.\n" + "• ALT + - → Ouvrez la calculatrice.";
			case "KEYS" -> "RACCOURCIS TOUCHES";
			case "CREDIT" -> "CRÉDIT ET CONÇU PAR MHMDSABDLH ©";
			case "ABOUT" -> "CETTE APP EST CONÇUE POUR GAGNER DE L'ARGENT POUR HADI-TECH";
			case "SETTING" -> "CONFIGURATION";
			case "YES" -> "OUI";
			case "NO" -> "NON";
			case "EXIT_Q" -> "ÊTES-VOUS SÛR DE VOULOIR PARTIR ?";
			case "FILE" -> "FICHER";
			case "PRINT" -> "IMPRIMER";
			case "PRINT_T" -> "LA NOTE EST EN COURS D'IMPRESSION...";
			case "EXIT" -> "QUITTER";
			case "CLEAR_Q" -> "VOULEZ-VOUS TOUT SUPPRIMER ?";
			case "CLEAR" -> "SUPPRIMER TOUT";
			case "TITLE" -> "FACTURE - R$";
			case "ABOUTME" -> "À PROPOS DE MOI";
			case "ABOUTAPP" -> "À PROPOS DE L'APPLICATION";
			case "QNT" -> "QNT";
			case "HOW_MUCH" -> "COMBIEN";
			case "DET" -> "DÉTAIL";
			case "P/U" -> "PRIX PAR UNITÉ";
			case "DESC" -> "DESCRIPTION";
			case "VAL" -> "VALEUR";
			case "CASH" -> "CASH";
			case "CLIENT" -> "CLIENT";
			case "CHANGE" -> "CHANGER";
			case "METHOD1" -> "<html><center>" + "METHODE" + "<br>" + "SMART" + "</center></html>";
			case "METHOD2" -> "<html><center>" + "METHODE" + "<br>" + "POPULAR" + "</center></html>";
			case "METHOD3" -> "<html><center>" + "METHODE" + "<br>" + "BASIQUE" + "</center></html>";
			case "CANNOT_UNDO" -> "CELA NE PEUT PAS ÊTRE DÉFAIT !";
			case "CALC" -> "ASSUMER";
			case "GO" -> "ALLER";
			case "CALCULATOR" -> "CALCULATRICE";
			case "CLEAN_S" -> "NETTOYER AVEC SUCCÈS";
			case "HELP" -> "AIDER";
			case "QUANTITY" -> "QUANTITÉ";
			case "CLIENT_C" -> "QUE DONNE LE CLIENT ?";
			case "ADDED_S" -> "AJOUTÉ À LA CAISSE";
			case "METHOD1T" -> "CETTE MÉTHODE UTILISE DES MATHÉMATIQUES PURES POUR DONNER L'ÉCHANGE";
			case "METHOD2T" -> "CETTE MÉTHODE UTILISE LA COMMUNICATION D'ÉCHANGE";
			case "METHOD3T" -> "CETTE MÉTHODE UTILISE L'ÉCHANGE ALTERNATIF";
			case "METHODP" -> "CETTE MÉTHODE UTILISE WISH";
			default -> "";
			};
		default:
			return "";
		}
	}

	/* Calculator panel */
	private void calculatorFunction() {
		JDialog calculator = new JDialog(this, getLocalizedMessage("CALCULATOR"), true);
		calculator.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		calculator.setAlwaysOnTop(true);
		calculator.setPreferredSize(new Dimension(400, 400));
		calculator.setIconImage(
				conf[10].equalsIgnoreCase("2") ? ImageEffect.getScaledImage(calcI.getImage(), 35, 35).getImage()
						: ImageEffect.invertColor(ImageEffect.getScaledImage(calcI.getImage(), 35, 35)).getImage());

		CalculatorPanel calculatorPanel = new CalculatorPanel(calculator);
		calculator.add(calculatorPanel);
		calculator.pack();
		calculator.setLocationRelativeTo(null);
		calculator.setResizable(false);
		calculator.setVisible(true);
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
			Toast.show(this, Toast.Type.ERROR, "ERROR -> " + e.getMessage(), Intro.notOption);
			e.printStackTrace();
		} catch (IOException e1) {
			writeError(e1);
			return; // Stop execution if writing fails
		}
	}
}
