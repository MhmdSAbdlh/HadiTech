/*
 CTRL + / Folding enabled or disable using toggle switch
Ctrl + * : expands code block After folding is enabled, The below command works
Collapse All -> Ctrl + Shift + / (Numpad Divide)
Expand All -> Ctrl + Shift + * (Numpad Multiply)

Ctrl + Shift + F : clean code
 */
package haditech;

import java.awt.AWTEvent;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.chrono.HijrahDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.EventObject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TimerTask;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.ListCellRenderer;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import javax.swing.text.JTextComponent;
import javax.swing.text.MaskFormatter;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.autocomplete.ComboBoxCellEditor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.CategoryItemEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.ui.RectangleAnchor;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.chart.util.ExportUtils;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

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
import haditech.Intro.Language;
import jnafilechooser.api.JnaFileChooser;
import mhmdsabdlh.component.ButtonColumn;
import mhmdsabdlh.component.CalculatorPanel;
import mhmdsabdlh.component.HalfCircleLabel;
import mhmdsabdlh.component.ModernTabbedPane;
import mhmdsabdlh.component.ModernTabbedPane.TAB_LAYOUT;
import mhmdsabdlh.component.RoundButton;
import mhmdsabdlh.component.SnowPanel;
import mhmdsabdlh.component.SnowPanel.Shape;
import mhmdsabdlh.component.OverlayPanel.OverlayFrame;
import mhmdsabdlh.dialog.ModernDialog;
import mhmdsabdlh.dialog.ModernDialog.IconType;
import mhmdsabdlh.dialog.ModernInputDialog;
import mhmdsabdlh.dialog.PasswordDialog;
import mhmdsabdlh.images.BadgeIconGenerator;
import mhmdsabdlh.images.IconWithText;
import mhmdsabdlh.images.IconWithText.Position;
import mhmdsabdlh.images.ImageBlur;
import mhmdsabdlh.images.ImageEffect;
import mhmdsabdlh.text.AutoComplete;
import mhmdsabdlh.text.Encryption;
import mhmdsabdlh.text.TextEffect;
import raven.component.PasswordStrengthStatus;
import raven.datetime.component.date.DatePicker;
import raven.message.SocialMedia;
import raven.message.SocialMedia.APP;
import raven.modal.Toast;

public class Main extends JFrame {
	/* Colores */
	private final Color skyblueC = new Color(0xdef7f3);
	private final Color whiteC = new Color(0xcfd8dc);
	private final Color turqC = new Color(0x6fa39f);
	private final Color greenT = new Color(30, 84, 25);
	private final Color redT = new Color(107, 35, 35);
	private final Color orangeC = new Color(0xd7841c);
	private final Color greyC = new Color(0xa2a2a2);
	private final Color blueC = new Color(0x64b5f6);
	private final Color greenC = new Color(0xaed581);
	private final Color redC = new Color(0xe57373);
	private final SnowPanel snowPanel;
	private Color fg, bg;
	private Border uBorder;
	/* Images */
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
	private URL lockDockP = getClass().getResource("images/lock.png");
	private ImageIcon lockDockI = new ImageIcon(lockDockP);
	private URL closeURL = getClass().getResource("images/status/close.png");
	private ImageIcon closeImage = new ImageIcon(closeURL);
	private ImageIcon notIcon = new ImageIcon(getClass().getResource("images/notification.png"));
	// menubar
	private URL overviewP = getClass().getResource("images/menubar/overview.png");
	private ImageIcon overviewI = new ImageIcon(overviewP);
	private URL aboutP = getClass().getResource("images/menubar/about.png");
	private ImageIcon aboutI = new ImageIcon(aboutP);
	private URL calcP = getClass().getResource("images/menubar/calc.png");
	private ImageIcon calcI = new ImageIcon(calcP);
	private URL reminderP = getClass().getResource("images/menubar/reminder.png");
	private ImageIcon reminderI = new ImageIcon(reminderP);
	private URL viewBillsP = getClass().getResource("images/menubar/viewbills.png");
	private ImageIcon viewBillsI = new ImageIcon(viewBillsP);
	private URL editBillsP = getClass().getResource("images/menubar/editbills.png");
	private ImageIcon editBillsI = new ImageIcon(editBillsP);
	private URL clearP = getClass().getResource("images/menubar/clear.png");
	private ImageIcon clearI = new ImageIcon(clearP);
	private URL deleteP = getClass().getResource("images/menubar/delete.png");
	private ImageIcon deleteI = new ImageIcon(deleteP);
	private URL creatorP = getClass().getResource("images/menubar/creator.png");
	private ImageIcon creatorI = new ImageIcon(creatorP);
	private URL exitP = getClass().getResource("images/menubar/exit.png");
	private ImageIcon exitI = new ImageIcon(exitP);
	private URL IntroP = getClass().getResource("images/menubar/first.png");
	private ImageIcon IntroI = new ImageIcon(IntroP);
	private URL invoiceP = getClass().getResource("images/menubar/invoice.png");
	private ImageIcon invoiceI = new ImageIcon(invoiceP);
	private URL keyboardP = getClass().getResource("images/menubar/keyboard.png");
	private ImageIcon keyboardI = new ImageIcon(keyboardP);
	private URL newdayP = getClass().getResource("images/menubar/newday.png");
	private ImageIcon newdayI = new ImageIcon(newdayP);
	private URL saveP = getClass().getResource("images/menubar/save.png");
	private ImageIcon saveI = new ImageIcon(saveP);
	private URL pngP = getClass().getResource("images/menubar/png.png");
	private ImageIcon pngI = new ImageIcon(pngP);
	private URL pdfP = getClass().getResource("images/menubar/pdf.png");
	private ImageIcon pdfI = new ImageIcon(pdfP);
	private URL svgP = getClass().getResource("images/menubar/svg.png");
	private ImageIcon svgI = new ImageIcon(svgP);
	private URL screenshotP = getClass().getResource("images/menubar/screenshot.png");
	private ImageIcon screenshotI = new ImageIcon(screenshotP);
	private URL settingP = getClass().getResource("images/menubar/setting.png");
	private ImageIcon settingI = new ImageIcon(settingP);
	private URL speedP = getClass().getResource("images/menubar/speed.png");
	private ImageIcon speedI = new ImageIcon(speedP);
	private URL summaryP = getClass().getResource("images/menubar/summary.png");
	private ImageIcon summaryI = new ImageIcon(summaryP);
	private URL summP = getClass().getResource("images/menubar/sum.png");
	private ImageIcon summI = new ImageIcon(summP);
	private URL oldSummP = getClass().getResource("images/menubar/oldsum.png");
	private ImageIcon oldSummI = new ImageIcon(oldSummP);
	private URL sumMP = getClass().getResource("images/menubar/summenu.png");
	private ImageIcon sumMI = new ImageIcon(sumMP);
	private URL themeP = getClass().getResource("images/menubar/theme.png");
	private ImageIcon themeI = new ImageIcon(themeP);
	private URL slowP = getClass().getResource("images/menubar/slow.png");
	private ImageIcon slowI = new ImageIcon(slowP);
	private URL normalP = getClass().getResource("images/menubar/normal.png");
	private ImageIcon normalI = new ImageIcon(normalP);
	private URL fastP = getClass().getResource("images/menubar/fast.png");
	private ImageIcon fastI = new ImageIcon(fastP);
	private URL effect1P = getClass().getResource("images/menubar/effect1.png");
	private ImageIcon effect1I = new ImageIcon(effect1P);
	private URL effect2P = getClass().getResource("images/menubar/effect2.png");
	private ImageIcon effect2I = new ImageIcon(effect2P);
	private URL effect3P = getClass().getResource("images/menubar/effect3.png");
	private ImageIcon effect3I = new ImageIcon(effect3P);
	private URL effect4P = getClass().getResource("images/menubar/effect4.png");
	private ImageIcon effect4I = new ImageIcon(effect4P);
	private URL sepP = getClass().getResource("images/menubar/sep.png");
	private ImageIcon sepI = new ImageIcon(sepP);
	private URL graphicP = getClass().getResource("images/menubar/diagram.png");
	private ImageIcon graphicI = new ImageIcon(graphicP);
	private URL lockP = getClass().getResource("images/menubar/padlock.png");
	private ImageIcon lockI = new ImageIcon(lockP);
	private URL passwordP = getClass().getResource("images/menubar/password.png");
	private ImageIcon passwordI = new ImageIcon(passwordP);
	private URL holidayMP = getClass().getResource("images/menubar/holidays.png");
	private ImageIcon holidayMI = new ImageIcon(holidayMP);
	private URL holidayVP = getClass().getResource("images/menubar/holidayview.png");
	private ImageIcon holidayVI = new ImageIcon(holidayVP);
	private URL birthdayP = getClass().getResource("images/menubar/birthday.png");
	private ImageIcon birthdayI = new ImageIcon(birthdayP);
	private URL birthdayOP = getClass().getResource("images/menubar/birthdayo.png");
	private ImageIcon birthdayOI = new ImageIcon(birthdayOP);
	private URL birthdayCP = getClass().getResource("images/menubar/birthdayc.png");
	private ImageIcon birthdayCI = new ImageIcon(birthdayCP);
	private URL viewStockP = getClass().getResource("images/menubar/merchandise.png");
	private ImageIcon viewStockI = new ImageIcon(viewStockP);
	private URL addSellP = getClass().getResource("images/menubar/sell.png");
	private ImageIcon addSellI = new ImageIcon(addSellP);
	private URL changeStockP = getClass().getResource("images/menubar/stock.png");
	private ImageIcon changeStockI = new ImageIcon(changeStockP);
	private URL stockManP = getClass().getResource("images/menubar/stock-man.png");
	private ImageIcon stockManI = new ImageIcon(stockManP);
	private URL sellDateP = getClass().getResource("images/menubar/sell_date.png");
	private ImageIcon sellDateI = new ImageIcon(sellDateP);
	private URL topSellP = getClass().getResource("images/menubar/top_sell.png");
	private ImageIcon topSellI = new ImageIcon(topSellP);
	private URL viewAddedP = getClass().getResource("images/menubar/viewadded.png");
	private ImageIcon viewAddedI = new ImageIcon(viewAddedP);
	private URL salesTrackP = getClass().getResource("images/menubar/salestrack.png");
	private ImageIcon salesTrackI = new ImageIcon(salesTrackP);
	private URL addStockP = getClass().getResource("images/menubar/addstock.png");
	private ImageIcon addStockI = new ImageIcon(addStockP);
	private URL noSalesP = getClass().getResource("images/menubar/nosales.png");
	private ImageIcon noSalesI = new ImageIcon(noSalesP);
	private URL licenseP = getClass().getResource("images/menubar/license.png");
	private ImageIcon licenseI = new ImageIcon(licenseP);
	private URL employeeP = getClass().getResource("images/menubar/employee.png");
	private ImageIcon employeeI = new ImageIcon(employeeP);
	private URL freedayP = getClass().getResource("images/menubar/freeday.png");
	private ImageIcon freedayI = new ImageIcon(freedayP);
	private URL faltaP = getClass().getResource("images/menubar/falta.png");
	private ImageIcon faltaI = new ImageIcon(faltaP);
	private URL weekP = getClass().getResource("images/menubar/week.png");
	private ImageIcon weekI = new ImageIcon(weekP);
	private URL workersP = getClass().getResource("images/menubar/workers.png");
	private ImageIcon workersI = new ImageIcon(workersP);
	private URL keywordP = getClass().getResource("images/menubar/keyword.png");
	private ImageIcon keywordI = new ImageIcon(keywordP);
	private ImageIcon badgeIcon;
	// months
	private URL monthP[] = new URL[12];
	private ImageIcon monthI[] = new ImageIcon[12];
	private URL monthlyP = getClass().getResource("images/menubar/month.png");
	private ImageIcon monthlyI = new ImageIcon(monthlyP);
	private URL yearP = getClass().getResource("images/menubar/year.png");
	private ImageIcon yearI = new ImageIcon(yearP);
	private URL thisYearP = getClass().getResource("images/menubar/thisyear.png");
	private ImageIcon thisYearI = new ImageIcon(thisYearP);
	private URL oldYearP = getClass().getResource("images/menubar/oldy.png");
	private ImageIcon oldYearI = new ImageIcon(oldYearP);
	private URL previousP = getClass().getResource("images/menubar/previous.png");
	private ImageIcon previousI = new ImageIcon(previousP);

	// sounds
	private URL enterSound = getClass().getResource("sound/enter.wav");
	private URL notSound = getClass().getResource("sound/notification.wav");
	private URL wrongSound = getClass().getResource("sound/wrong.wav");
	private URL screenSound = getClass().getResource("sound/screenshot.wav");
	private URL clearSound = getClass().getResource("sound/clear.wav");
	private URL lockSound = getClass().getResource("sound/lock.wav");

	// Define Parameter
	private static JTextField initialDay = new JTextField("0");// How much begin the day
	private static JTextField agregadoTable[] = new JTextField[16];// Added to cash detailed
	private static JTextField gastosTable[] = new JTextField[16];// Spend of the day detailed
	private static JTextField panelCnum[] = new JTextField[8];
	private static JTextField details[][] = new JTextField[6][20];// Numbers of notes
	private static JTextField detailsM[][] = new JTextField[6][20];// Numbers of notes
	private JTextField gTable[] = new JTextField[16];
	private JTextField aTable[] = new JTextField[16];
	private JButton aggPanel = new JButton();
	private JButton gastosPanel = new JButton();
	private JButton pixMore = new JButton();
	private JLabel total[] = new JLabel[9];// Total of every column
	private JLabel boletoN[] = new JLabel[6]; // B1,2,3,4,5
	private JLabel summaryT[] = new JLabel[9];// Summary table
	private JLabel panelFoto[] = new JLabel[8];// Photo row
	private HalfCircleLabel diffResult = new HalfCircleLabel("");// calculate the difference
	private String sepData[] = new String[43];// separated values
	private OverlayFrame overlay;
	// Define values
	private int totalCol = 0, totalVenta = 0, totalO = 0;
	private int gastosT = 0, agregadoT = 0;
	private int restN, totalCaja = 0, totalSep = 0;
	private Language language = Language.SPANISH;
	private int colorX = 0, order = 0, speedValue, wordL, effChooser;
	private boolean status = false, isBlured = false, customSeparated = false, isClickCopyEnabled = false;
	static private boolean separadoYa = true, doesLoaded = false;
	private Timer timer;
	private String conf[] = new String[27];
	private String dayMessage = "";
	private ModernTabbedPane tabbedPane = new ModernTabbedPane();
	private List<DefaultTableModel> invoiceModels = new ArrayList<>();
	private List<JComboBox<String>> paymentComboBoxes = new ArrayList<>();
	private Map<Integer, Merchandise> merchandiseMap = new HashMap<>();
	// date
	private JLabel dateLabel = new JLabel();
	private DateModified currentDate;
	private String dayN = new SimpleDateFormat("dd").format(Calendar.getInstance().getTime());
	private String yearS = new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime());
	private String monthS, dayS, correctPassword = "0000";
	private int valueLY, valueLY2, valueLY3, valueLY4, colorSelected = 0, langIndex = 0, lastID = 0;
	private int sameDayAvg, dailyAvg, monthlyAvg, dailyAvgLY, dailyAvgLY2, dailyAvgLY3, dailyAvgLY4;
	private ArrayList<String> conThisYear = new ArrayList<>(), conLY = new ArrayList<>(), conLY2 = new ArrayList<>(),
			conLY3 = new ArrayList<>(), conLY4 = new ArrayList<>();
	private JMenuBar mb = new JMenuBar();
	private PasswordDialog lockDialog;
	private JLabel lastChange = new JLabel();
	private DatePicker datePicker;
	private List<Merchandise> merchandise = new ArrayList<>();
	private Map<String, List<String>> data = new HashMap<String, List<String>>();
	private Map<String, Integer> sellerTotal = new LinkedHashMap<>();
	private JTable table;
	private DefaultTableModel tableModel;
	private TableRowSorter<DefaultTableModel> rowSorter;
	// Notification
	private JButton notificationButton = new JButton();
	private JPanel notificationPanel;
	private JDialog listDialog = new JDialog(this, "NOTIFICATION", true);
	private JButton showAllButton;
	private boolean isExpanded = false;
	private int dialogWidth = 250;
	private int dialogHeight = 200;

	private String currentpath = System.getProperty("user.dir");
	private File dataFolder = new File(currentpath + "\\data");
	private File confFile = new File(dataFolder, "conf.dll");
	private Encryption encrypt = new Encryption();
	private JButton moreCases = new JButton();
	private List<RecurringBill> bills = new ArrayList<>();
	private List<Holiday> holidays = new ArrayList<>(), birthdayL = new ArrayList<Holiday>();
	private List<Employee> employee = new ArrayList<>();
	private Component focusedComponent;
	private java.util.Timer inactivityTimer;
	private int INACTIVITY_DELAY = 10 * 60 * 1000; // 5 seconds for demo purposes
	private boolean isAppInForeground = false;
	private int optionChoosing = 0;

	Main() {
		/* Frame */
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int taskbarHeight = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration()).bottom;
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight() - taskbarHeight;
		setTitle(getLocalizedMessage("TITLE"));
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setSize(width, height);
		setLocationRelativeTo(null);
		setLayout(null);
		setMinimumSize(new Dimension(width, height));

		/* Open Conf */
		openConfiguration();

		// Pre-Buttons
		File hiddenPath = new File(System.getenv("PROGRAMDATA") + File.separator + "HADI-TECH");
		File usersF = new File(hiddenPath, "lock.dll");
		if (usersF.exists()) {
			try (BufferedReader userOP = new BufferedReader(new FileReader(usersF))) {
				String userL;
				if ((userL = userOP.readLine()) != null) {
					correctPassword = encrypt.decrypt(userL);
				}
			} catch (Exception e) {
				writeError(e);
			}
		}
		lockDialog = new PasswordDialog(this);
		lockDialog.setPassword(correctPassword);
		lockDialog.setFillColor(bg);
		lockDialog.setTextColor(fg);

		overlay = new OverlayFrame(this);

		/* Open values of sell */
		dateLang(language);// date according to lang
		currentDate = new DateModified(Integer.valueOf(dayN), Integer.valueOf(Intro.monthN), Integer.valueOf(yearS));
		valueLY = DataCalc.sellSelectdYear(Integer.valueOf(dayN + "" + currentDate.m), currentDate.y - 1);
		valueLY2 = DataCalc.sellSelectdYear(Integer.valueOf(dayN + "" + currentDate.m), currentDate.y - 2);
		valueLY3 = DataCalc.sellSelectdYear(Integer.valueOf(dayN + "" + currentDate.m), currentDate.y - 3);
		valueLY4 = DataCalc.sellSelectdYear(Integer.valueOf(dayN + "" + currentDate.m), currentDate.y - 4);
		try {// open the data for current year
			File extraFolder = new File(dataFolder + "\\extra");
			File extraFile = new File(extraFolder, currentDate.y + ".dll");
			BufferedReader dataThisYear = new BufferedReader(new FileReader(extraFile));
			String lnThisYear = "";
			while ((lnThisYear = dataThisYear.readLine()) != null) {
				conThisYear.add(lnThisYear.toString());
			}
			dataThisYear.close();
		} catch (Exception e) {
			try {// save the data
				File extraFolder = new File(dataFolder + "\\extra");
				extraFolder.mkdirs();
				File extraFile = new File(extraFolder, currentDate.y + ".dll");
				FileWriter saveThisYear = new FileWriter(extraFile);
				saveThisYear.close();
			} catch (Exception e2) {
				writeError(e2);
			}
		}
		sameDayAvg = DataCalc.avgSellOfDay(currentDate);
		dailyAvg = DataCalc.dailyAvg();
		monthlyAvg = DataCalc.totalOfMes(currentDate.m, currentDate.y)[1] == 0 ? 0
				: DataCalc.totalOfMes(currentDate.m, currentDate.y)[0]
						/ DataCalc.totalOfMes(currentDate.m, currentDate.y)[1];
		try {// open the data for last year
			String appV = (currentDate.y - 1) + ".dll";
			File extraFolder = new File(dataFolder + "\\extra");
			File extraFile = new File(extraFolder, appV);
			BufferedReader dataLY = new BufferedReader(new FileReader(extraFile));
			String lnLY = "";
			while ((lnLY = dataLY.readLine()) != null) {
				conLY.add(lnLY.toString());
			}
			dataLY.close();
			// daily average
			int var = 0, counter = 0, nbOfDays = 0;
			while (var < conLY.size()) {
				if (TextEffect.isInteger(conLY.get(var))) {
					counter += Integer.valueOf(conLY.get(var));
					nbOfDays++;
				}
				var++;
			}
			if (nbOfDays > 0)
				dailyAvgLY = counter / nbOfDays;
		} catch (Exception e) {
			try {// save the data
				String appV = (currentDate.y - 1) + ".dll";
				File extraFolder = new File(dataFolder + "\\extra");
				extraFolder.mkdirs();
				File extraFile = new File(extraFolder, appV);
				FileWriter saveLYYear = new FileWriter(extraFile);
				saveLYYear.close();
			} catch (Exception e2) {
				writeError(e2);
			}
		}
		try {// open the data for 2 year BEFORE
			String appV = (currentDate.y - 2) + ".dll";
			File extraFolder = new File(dataFolder + "\\extra");
			File extraFile = new File(extraFolder, appV);
			BufferedReader dataLY2 = new BufferedReader(new FileReader(extraFile));
			String lnLY2 = "";
			while ((lnLY2 = dataLY2.readLine()) != null) {
				conLY2.add(lnLY2.toString());
			}
			dataLY2.close();
			// daily average
			int var = 0, counter = 0, nbOfDays = 0;
			while (var < conLY2.size()) {
				if (TextEffect.isInteger(conLY2.get(var))) {
					counter += Integer.valueOf(conLY2.get(var));
					nbOfDays++;
				}
				var++;
			}
			if (nbOfDays > 0)
				dailyAvgLY2 = counter / nbOfDays;
		} catch (Exception e) {
			try {// save the data
				String appV = (currentDate.y - 2) + ".dll";
				File extraFolder = new File(dataFolder + "\\extra");
				extraFolder.mkdirs();
				File extraFile = new File(extraFolder, appV);
				FileWriter saveLYYear = new FileWriter(extraFile);
				saveLYYear.close();
			} catch (Exception e2) {
				writeError(e2);
			}
		}
		try {// open the data for 3 year BEFORE
			String appV = (currentDate.y - 3) + ".dll";
			File extraFolder = new File(dataFolder + "\\extra");
			File extraFile = new File(extraFolder, appV);
			BufferedReader dataLY3 = new BufferedReader(new FileReader(extraFile));
			String lnLY3 = "";
			while ((lnLY3 = dataLY3.readLine()) != null) {
				conLY3.add(lnLY3.toString());
			}
			dataLY3.close();
			// daily average
			int var = 0, counter = 0, nbOfDays = 0;
			while (var < conLY3.size()) {
				if (TextEffect.isInteger(conLY3.get(var))) {
					counter += Integer.valueOf(conLY3.get(var));
					nbOfDays++;
				}
				var++;
			}
			if (nbOfDays > 0)
				dailyAvgLY3 = counter / nbOfDays;
		} catch (Exception e) {
			try {// save the data
				String appV = (currentDate.y - 3) + ".dll";
				File extraFolder = new File(dataFolder + "\\extra");
				extraFolder.mkdirs();
				File extraFile = new File(extraFolder, appV);
				FileWriter saveLYYear = new FileWriter(extraFile);
				saveLYYear.close();
			} catch (Exception e2) {
				writeError(e2);
			}
		}
		try {// open the data for 4 year BEFORE
			String appV = (currentDate.y - 4) + ".dll";
			File extraFolder = new File(dataFolder + "\\extra");
			File extraFile = new File(extraFolder, appV);
			BufferedReader dataLY4 = new BufferedReader(new FileReader(extraFile));
			String lnLY4 = "";
			while ((lnLY4 = dataLY4.readLine()) != null) {
				conLY4.add(lnLY4.toString());
			}
			dataLY4.close();
			// daily average
			int var = 0, counter = 0, nbOfDays = 0;
			while (var < conLY4.size()) {
				if (TextEffect.isInteger(conLY4.get(var))) {
					counter += Integer.valueOf(conLY4.get(var));
					nbOfDays++;
				}
				var++;
			}
			if (nbOfDays > 0)
				dailyAvgLY4 = counter / nbOfDays;
		} catch (Exception e) {
			try {// save the data
				String appV = (currentDate.y - 4) + ".dll";
				File extraFolder = new File(dataFolder + "\\extra");
				extraFolder.mkdirs();
				File extraFile = new File(extraFolder, appV);
				FileWriter saveLYYear = new FileWriter(extraFile);
				saveLYYear.close();
			} catch (Exception e2) {
				writeError(e2);
			}
		}
		loadStockData();

		/* Start of mes make a folder for the payments */
		File yearFolder = new File(dataFolder + "\\" + yearS);
		yearFolder.mkdir();
		File monthFolder = new File(yearFolder + "\\" + currentDate.m + "-" + monthS);
		monthFolder.mkdir();
		File pagosFolder = new File(monthFolder + "\\PAGOS");
		pagosFolder.mkdir();
		snowPanel = new SnowPanel();
		snowPanel.setBounds(0, 0, width, height);
		add(snowPanel);
		/* Close values of sell */

		/* Open Panel 1 -> left table + total */
		for (int i = 0; i < 6; i++) {
			boletoN[i] = new JLabel("C" + (i + 1));
			boletoN[i].setBounds(30 + i * (getWidth() / 18 - 1), getHeight() / 36, getWidth() / 18, getHeight() / 25);
			boletoN[i].setForeground(Intro.blackM);
			boletoN[i].setBackground(greyC);
			boletoN[i].setBorder(uBorder);
			boletoN[i].setHorizontalAlignment(0);
			boletoN[i].setOpaque(true);
			boletoN[i].setFont(Intro.myFont);
			add(boletoN[i]);
			for (int j = 0; j < 20; j++) {
				details[i][j] = new JTextField("");
				detailsM[i][j] = new JTextField("");
				textFieldStyle(details[i][j]);
				textFieldStyle(detailsM[i][j]);
				details[i][j].setBounds(boletoN[i].getX(),
						boletoN[i].getY() - 1 + boletoN[i].getHeight() + j * (boletoN[i].getHeight() - 1),
						boletoN[i].getWidth(), boletoN[i].getHeight());
				details[i][j].setFont(Intro.myFontS);
				detailsM[i][j].setBounds(boletoN[i].getX(),
						boletoN[i].getY() - 1 + boletoN[i].getHeight() + j * (boletoN[i].getHeight() - 1),
						boletoN[i].getWidth(), boletoN[i].getHeight());
				detailsM[i][j].setFont(Intro.myFontS);
				details[i][j].setOpaque(false);
				detailsM[i][j].setOpaque(false);
				details[i][j].setForeground(fg);
				details[i][j].setBorder(uBorder);
				details[i][j].setCaretColor(fg);
				detailsM[i][j].setForeground(fg);
				detailsM[i][j].setBorder(uBorder);
				detailsM[i][j].setCaretColor(fg);
				if (conf[2] == null || conf[2].equals("false")) {
					tableFocus(i, j, details);
					tableFocus(i, j, detailsM);
				}
				detailsM[i][j].setVisible(false);
				add(details[i][j]);
				add(detailsM[i][j]);
			}
			total[i] = new JLabel("");
			Intro.labelStyle(total[i]);
			total[i].setFont(Intro.myFont);
			total[i].setBounds(details[i][19].getX(), details[i][19].getY() + details[i][19].getHeight() - 1,
					details[i][19].getWidth(), details[i][19].getHeight());
			total[i].setBorder(uBorder);
			total[i].setBackground(greyC);
			add(total[i]);
		}
		moreCases.setBounds(details[5][19].getX() + details[5][19].getWidth() - 1, details[5][19].getY(), 20,
				details[5][19].getHeight());
		Intro.btnStyle(moreCases);
		moreCases.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 18));
		moreCases.setBackground(new Color(0xD2D2D));
		moreCases.setForeground(new Color(0x20B2AA));
		moreCases.setVisible(false);
		moreCases.setBorder(uBorder);
		moreCases.addActionListener(_ -> moreTables());
		moreCases.setToolTipText(getLocalizedMessage("MORE"));/* Position for the more cases button */
		moreCases.setBounds(details[5][19].getX() + details[5][19].getWidth() - 1, details[5][19].getY(), 20,
				details[5][19].getHeight());
		moreCases.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseExited(MouseEvent e) {
				moreCases.setText("");
				moreCases.setBounds(moreCases.getX(), moreCases.getY(), 20, moreCases.getHeight());
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				moreCases.setText("➕");
				moreCases.setBounds(moreCases.getX(), moreCases.getY(), details[5][19].getWidth() * 45 / 100,
						moreCases.getHeight());
			}
		});
		add(moreCases);
		total[6] = new JLabel("0");
		Intro.labelStyle(total[6]);
		total[6].setFont(Intro.myFont);
		total[6].setBounds(moreCases.getX() + 50, total[5].getY(), boletoN[0].getWidth() + 15, boletoN[0].getHeight());
		total[6].setBackground(bg);
		total[6].setForeground(fg);
		total[6].setBorder(uBorder);
		add(total[6]);
		total[8] = new JLabel("Total");
		total[8].setBounds(total[6].getX(), total[6].getY() - total[6].getHeight() + 1, boletoN[0].getWidth() + 15,
				boletoN[0].getHeight());
		Intro.labelStyle(total[8]);
		total[8].setFont(Intro.myFont);
		total[8].setBackground(Intro.grisD);
		total[8].setForeground(Color.black);
		total[8].setBorder(uBorder);
		add(total[8]);

		/* Last Change */
		dataFolder.mkdir();
		File logFolder = new File(dataFolder + "\\LOG");
		logFolder.mkdir();
		File lastChangeF = new File(logFolder, dayN + currentDate.m + currentDate.y);
		String changelogString = "";
		try {
			// Check if the file exists
			if (!lastChangeF.exists()) {
				lastChangeF.createNewFile();
			}
			// Read the content of the file into a String
			changelogString = Files.readString(lastChangeF.toPath());
		} catch (IOException e) {
			writeError(e);
		}
		if (changelogString.equalsIgnoreCase(""))
			lastChange.setText(getLocalizedMessage("LAST_UPDATE") + "NaN");
		else
			lastChange.setText(getLocalizedMessage("LAST_UPDATE") + changelogString);
		lastChange.setForeground(fg);
		lastChange.setFont(Intro.myFontXS);
		lastChange.setHorizontalAlignment(0);
		lastChange.setVerticalAlignment(0);
		lastChange.setBounds(30, total[0].getY() + (getHeight() - total[0].getY() - total[0].getHeight()) / 2,
				total[5].getX() - total[0].getX() + total[5].getWidth(), 30);
		add(lastChange);
		/* Close Panel 1 -> left table + total */

		/* Open Panel 2 -> Summary of the sell */
		for (int i = 0; i < 5; i++) {
			summaryT[i] = new JLabel();
			Intro.labelStyle(summaryT[i]);
			summaryT[i].setFont(Intro.myFont);
			summaryT[i].setBounds(boletoN[5].getX() + boletoN[5].getWidth() + 50, 100 + i * (getHeight() / 16 - 1),
					getWidth() / 11, getHeight() / 16);
			summaryT[i].setBorder(uBorder);
			summaryT[i].setBackground(Intro.grisD);
			summaryT[i].setForeground(Color.black);
			add(summaryT[i]);
		}
		summaryT[0].setText(TextEffect.capitalizeString(getLocalizedMessage("INITIAL")));
		summaryT[1].setText(TextEffect.capitalizeString(getLocalizedMessage("SPENT")));
		summaryT[2].setText(TextEffect.capitalizeString(getLocalizedMessage("AGG")));
		summaryT[3].setText(TextEffect.capitalizeString(getLocalizedMessage("SELL")));
		summaryT[4].setText("Total");
		textFieldStyle(initialDay);
		initialDay.setCaretColor(Intro.blackM);
		initialDay.setBackground(whiteC);
		initialDay.setForeground(Color.black);
		initialDay.setFont(Intro.myFont);
		initialDay.setBorder(uBorder);
		initialDay.setBounds(summaryT[0].getX() + summaryT[0].getWidth() - 1, 100, getWidth() / 15,
				summaryT[0].getHeight());
		add(initialDay);
		for (int i = 5; i < 9; i++) {
			summaryT[i] = new JLabel("0");
			summaryT[i].setFont(Intro.myFont);
			summaryT[i].setBounds(summaryT[0].getX() + summaryT[0].getWidth() - 1, summaryT[i - 4].getY(),
					getWidth() / 15, summaryT[0].getHeight());
			summaryT[i].setForeground(Intro.blackM);
			summaryT[i].setBorder(uBorder);
			summaryT[i].setFocusable(false);
			summaryT[i].setOpaque(true);
			summaryT[i].setHorizontalAlignment(0);
			add(summaryT[i]);
		}
		summaryT[5].setBackground(colorSelected == 2 ? new Color(0xfccece) : redC);
		summaryT[6].setBackground(colorSelected == 2 ? new Color(0xd3fcce) : greenC);
		summaryT[7].setBackground(colorSelected == 2 ? new Color(0xceedfc) : blueC);
		summaryT[8].setBackground(colorSelected == 2 ? new Color(0xc0c0c0) : greyC);
		/* Close Panel 2 -> Summary of the sell */

		/* Open Panel 3 -> Spent and Aggregates */
		Intro.btnStyle(gastosPanel);
		gastosPanel.setBounds(initialDay.getX() + initialDay.getWidth() + 50, 100, getWidth() / 6, getHeight() / 16);
		gastosPanel.setFont(Intro.myFont);
		gastosPanel.setText("<html><span style='text-decoration: underline;'>" + getLocalizedMessage("SPENT")
				+ "	</span>&nbsp;" + "<span style='font-size: 15px;'>&#9654;</span></html>");
		gastosPanel.setBackground(colorSelected == 2 ? new Color(0xe6bebe) : redT);
		gastosPanel.setForeground(fg);
		gastosPanel.setBorder(uBorder);
		gastosPanel.setToolTipText(getLocalizedMessage("MORE"));
		gastosPanel.addActionListener(_ -> {
			gastosFrame();
		});
		add(gastosPanel);
		dateLabel.setText(dayS + ", " + dayN + " " + monthS);
		dateLabel.setForeground(fg);
		dateLabel.setFont(Intro.myFont);
		dateLabel.setBounds(gastosPanel.getX(), 30, getWidth() - gastosPanel.getX(), 30);
		add(dateLabel);
		List<String> keywords = loadKeywords();
		for (int i = 0; i < 16; i++) {
			gastosTable[i] = new JTextField();
			gTable[i] = new JTextField();
			// Autocomplete
			AutoComplete autoComplete = new AutoComplete(gastosTable[i], keywords);
			gastosTable[i].getDocument().addDocumentListener(autoComplete);
			autoComplete = new AutoComplete(gTable[i], keywords);
			gTable[i].getDocument().addDocumentListener(autoComplete);
			textFieldStyle(gastosTable[i]);
			gastosTable[i].setBackground(colorSelected == 2 ? new Color(0xffd4d4) : redC);
			gastosTable[i].setForeground(Intro.blackM);
			gastosTable[i].setCaretColor(Intro.blackM);
			gastosTable[i].setBorder(uBorder);
			if (i < 4)
				gastosTable[i].setBounds(gastosPanel.getX(),
						gastosPanel.getY() + (gastosPanel.getHeight() - 1) * (i + 1), gastosPanel.getWidth() * 7 / 10,
						gastosPanel.getHeight());
			else if (i > 7 && i < 12)
				gastosTable[i].setBounds(gastosTable[i - 8].getX() + gastosTable[i - 8].getWidth() - 1,
						gastosPanel.getY() + (gastosPanel.getHeight() - 1) * (i - 7),
						gastosPanel.getWidth() - gastosTable[i - 8].getWidth() + 1, getHeight() / 16);
			gastosTable[i].setFont(Intro.myFont);
			if (conf[2] == null || conf[2].equals("false"))
				gasFocus(i);
			add(gastosTable[i]);
		}
		// Aggregates
		Intro.btnStyle(aggPanel);
		aggPanel.setBounds(gastosPanel.getX() + gastosPanel.getWidth() + 50, 100, getWidth() / 6, getHeight() / 16);
		aggPanel.setText("<html><span style='text-decoration: underline;'>" + getLocalizedMessage("AGG")
				+ "	</span>&nbsp;" + "<span style='font-size: 15px;'>&#9654;</span></html>");
		aggPanel.setBackground(colorSelected == 2 ? new Color(0xcde6be) : greenT);
		aggPanel.setForeground(fg);
		aggPanel.setBorder(uBorder);
		aggPanel.setToolTipText(getLocalizedMessage("MORE"));
		aggPanel.addActionListener(_ -> {
			aggFrame();
		});
		add(aggPanel);
		for (int i = 0; i < 16; i++) {
			aTable[i] = new JTextField();
			agregadoTable[i] = new JTextField();
			// Autocomplete
			AutoComplete autoComplete = new AutoComplete(agregadoTable[i], keywords);
			agregadoTable[i].getDocument().addDocumentListener(autoComplete);
			autoComplete = new AutoComplete(aTable[i], keywords);
			aTable[i].getDocument().addDocumentListener(autoComplete);
			textFieldStyle(agregadoTable[i]);
			if (i < 4)
				agregadoTable[i].setBounds(aggPanel.getX(), aggPanel.getY() + (aggPanel.getHeight() - 1) * (i + 1),
						aggPanel.getWidth() * 7 / 10 - 1, aggPanel.getHeight());
			else if (i > 7 && i < 12)
				agregadoTable[i].setBounds(agregadoTable[i - 8].getX() + agregadoTable[i - 8].getWidth() - 1,
						aggPanel.getY() + (aggPanel.getHeight() - 1) * (i - 7),
						aggPanel.getWidth() - agregadoTable[i - 8].getWidth() + 1, getHeight() / 16);
			agregadoTable[i].setFont(Intro.myFont);
			agregadoTable[i].setBackground(colorSelected == 2 ? new Color(0xd3fcce) : greenC);
			agregadoTable[i].setForeground(Intro.blackM);
			agregadoTable[i].setCaretColor(Intro.blackM);
			agregadoTable[i].setBorder(uBorder);
			if (conf[2] == null || conf[2].equals("false"))
				aggFocus(i);
			add(agregadoTable[i]);
		}
		/* Close Panel 3 -> Spent and Aggregates */

		/* Open Panel 4 -> Caja detailed */
		int cajaX = details[5][19].getX() + details[5][19].getWidth()
				+ (getWidth() - details[5][19].getX() - details[5][19].getWidth() - getWidth() / 21 * 8) / 2;
		int cajaY = summaryT[4].getY() + summaryT[4].getHeight()
				+ (total[8].getY() - summaryT[4].getY() - summaryT[4].getWidth()) / 2 - 25;
		for (int i = 0; i < 8; i++) {
			panelFoto[i] = new JLabel();
			panelFoto[i].setBounds(cajaX + (getWidth() / 21 - 1) * i, cajaY, getWidth() / 21, getHeight() / 15);
			Intro.labelStyle(panelFoto[i]);
			panelFoto[i].setBorder(uBorder);
			switch (i) {
			case 0:
				panelFoto[i].setIcon(ImageEffect.getScaledImage(i100.getImage(), getWidth() / 21, getHeight() / 15));
				break;
			case 1:
				panelFoto[i].setIcon(ImageEffect.getScaledImage(i50.getImage(), getWidth() / 21, getHeight() / 15));
				break;
			case 2:
				panelFoto[i].setIcon(ImageEffect.getScaledImage(i20.getImage(), getWidth() / 21, getHeight() / 15));
				break;
			case 3:
				panelFoto[i].setIcon(ImageEffect.getScaledImage(i10.getImage(), getWidth() / 21, getHeight() / 15));
				break;
			case 4:
				panelFoto[i].setIcon(ImageEffect.getScaledImage(i5.getImage(), getWidth() / 21, getHeight() / 15));
				break;
			case 5:
				panelFoto[i].setIcon(ImageEffect.getScaledImage(i2.getImage(), getWidth() / 21, getHeight() / 15));
				break;
			case 6:
				panelFoto[i].setIcon(ImageEffect.getScaledImage(i1.getImage(), getWidth() / 21, getHeight() / 15));
				break;
			case 7:
				panelFoto[i].setIcon(ImageEffect.getScaledImage(pixI.getImage(), getWidth() / 21, getHeight() / 15));
				break;
			default:
				break;
			}
			add(panelFoto[i]);
		}
		for (int i = 0; i < 8; i++) {
			panelCnum[i] = new JTextField("0");
			panelCnum[i].setBounds(panelFoto[i].getX(), panelFoto[i].getY() + panelFoto[i].getHeight() - 1,
					getWidth() / 21, getHeight() / 15);
			textFieldStyle(panelCnum[i]);
			panelCnum[i].setFont(Intro.myFont);
			panelCnum[i].setCaretColor(Intro.blackM);
			panelCnum[i].setForeground(Intro.blackM);
			panelCnum[i].setBackground(Intro.grisD);
			panelCnum[i].setBorder(uBorder);
			if (conf[2] == null || conf[2].equals("false"))
				cajaFocus(i);
			add(panelCnum[i]);
		}
		panelFoto[7].setBackground(skyblueC);
		total[7] = new JLabel("TOTAL");// Total Label
		total[7].setBounds(panelCnum[0].getX(), panelCnum[0].getY() + panelCnum[0].getHeight() - 1,
				panelCnum[7].getX() - panelCnum[0].getX() + panelCnum[7].getWidth(), 50);
		Intro.labelStyle(total[7]);
		total[7].setFont(Intro.myFont);
		total[7].setBackground(bg);
		total[7].setForeground(fg);
		total[7].setBorder(uBorder);
		add(total[7]);
		pixMore.setText(getLocalizedMessage("MORE"));
		pixMore.setBackground(skyblueC);
		pixMore.setForeground(skyblueC);
		pixMore.setBorder(uBorder);
		pixMore.setBounds(panelFoto[7].getX(), panelFoto[7].getY() - 8, getWidth() / 21, 9);
		pixMore.setFont(Intro.myFontS);
		pixMore.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseExited(MouseEvent e) {
				pixMore.setForeground(skyblueC);
				pixMore.setBounds(panelFoto[7].getX(), panelFoto[7].getY() - 8, getWidth() / 21, 9);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				pixMore.setForeground(Intro.blackM);
				pixMore.setBounds(panelFoto[7].getX(), panelFoto[7].getY() - 20, getWidth() / 21, 21);
			}
		});
		pixMore.addActionListener(_ -> pixFrame());
		pixMore.setCursor(new Cursor(HAND_CURSOR));
		add(pixMore);
		/* Close Panel 4 -> Caja detailed */

		/* Open Panel 5 -> Results */
		diffResult = new HalfCircleLabel("No Hay Diferencia"); // Set the circle fill color
		diffResult.setBounds(total[7].getX(), total[7].getY() + 10, total[7].getWidth(), 50);
		diffResult.setFont(Intro.myFont);
		add(diffResult);
		/* Position for the difference check */
		total[7].addMouseListener(new MouseAdapter() {

			@Override
			public void mouseExited(MouseEvent e) {
				diffResult.setBounds(total[7].getX(), total[7].getY() + 10, total[7].getWidth(), 50);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				diffResult.setBounds(total[7].getX(), diffResult.getY() + 40, total[7].getWidth(), 50);
			}
		});

		JButton magic = new JButton();
		magic.addActionListener(_ -> sumF());
		/* Close Panel 5 -> Results */

		/* ADD BILLS, HOLIDAYS, BIRTHDAYS */
		billsAdd();
		holidayAddEvents();
		birthdaysAddEvents();

		/* Notification */
		notificationButton.setToolTipText(getLocalizedMessage("NOTIFICATION"));
		int notCount = notificationCount();
		if (colorSelected == 2) {
			badgeIcon = ImageEffect.changeOpacity(BadgeIconGenerator.generateBadgeIcon(notIcon, notCount).getImage(),
					0.5f);
			notificationButton.setIcon(badgeIcon);
		} else {
			badgeIcon = ImageEffect.changeOpacity(
					BadgeIconGenerator.generateBadgeIcon(ImageEffect.invertColor(notIcon), notCount).getImage(), 0.5f);
			notificationButton.setIcon(badgeIcon);
		}
		Intro.opacityEffect(notificationButton,
				() -> BadgeIconGenerator.generateBadgeIcon(ImageEffect.invertColor(notIcon), notificationCount()),
				conf[10]);
		notificationButton.addActionListener(_ -> {
			if (notificationCount() > 0)
				toggleNotificationPanel();
			else
				Toast.show(this, Toast.Type.INFO, getLocalizedMessage("NO") + " " + getLocalizedMessage("NOTIFICATION"),
						Intro.notOption);
		});
		add(notificationButton);

		// Create the notification panel
		notificationPanel = new JPanel();
		notificationPanel.setBackground(Color.WHITE);
		notificationPanel.setLayout(new BorderLayout());
		notificationButton.setBounds(getWidth() - 80, 30, 50, 50);

		/* Open Menubar */
		/* 1 FILE */
		JMenu file = new JMenu(getLocalizedMessage("FILE"));
		JMenuItem novo = new JMenuItem(getLocalizedMessage("NEWDAY"));
		JMenuItem clear = new JMenuItem(getLocalizedMessage("CLEAR"));
		JMenuItem calc = new JMenuItem(getLocalizedMessage("CALC"));
		JMenuItem save = new JMenuItem(getLocalizedMessage("SAVE"));
		JMenuItem screenShot = new JMenuItem(getLocalizedMessage("SCREENSHOT"));
		JMenuItem option = new JMenuItem(getLocalizedMessage("SETTING"));
		JMenuItem exit = new JMenuItem(getLocalizedMessage("EXIT"));
		file.setMnemonic(language == Language.SPANISH ? 'A'
				: language == Language.PORTUGUES ? 'A' : language == Language.ENGLISH ? 'F' : 'F');
		novo.setMnemonic('N');
		clear.setMnemonic(language == Language.SPANISH ? 'B'
				: language == Language.PORTUGUES ? 'L' : language == Language.ENGLISH ? 'C' : 'N');
		calc.setMnemonic('A');
		save.setMnemonic('S');
		screenShot.setMnemonic(language == Language.SPANISH ? 'C'
				: language == Language.PORTUGUES ? 'C' : language == Language.ENGLISH ? 'R' : 'T');
		option.setMnemonic(language == Language.SPANISH ? 'O'
				: language == Language.PORTUGUES ? 'O' : language == Language.ENGLISH ? 'O' : 'P');
		exit.setMnemonic(language == Language.SPANISH ? 'L'
				: language == Language.PORTUGUES ? 'I' : language == Language.ENGLISH ? 'E' : 'O');
		novo.addActionListener(_ -> newDay());
		calc.addActionListener(_ -> sumF());
		clear.addActionListener(_ -> clearAll());
		save.addActionListener(_ -> {
			saveProgress();
			Toast.show(this, Toast.Type.SUCCESS, getLocalizedMessage("SAVE_A"), Intro.notOption);
		});
		screenShot.addActionListener(_ -> {
			screenShooter();
			Toast.show(this, Toast.Type.SUCCESS, getLocalizedMessage("SCREENSHOT_A"), Intro.notOption);
		});
		option.addActionListener(_ -> {
			SettingsDialog sett = new SettingsDialog(this, "reales");
			INACTIVITY_DELAY = sett.returnSliderValue(0);
			openConfiguration();
		});
		exit.addActionListener(_ -> System.exit(0));
		file.add(novo);
		file.add(calc);
		file.add(clear);
		file.add(save);
		file.add(screenShot);
		file.add(option);
		file.add(exit);
		/* 2 GOTO */
		JMenu goTo = new JMenu(getLocalizedMessage("GO"));
		JMenuItem fatura = new JMenuItem(getLocalizedMessage("INVOICE"));
		JMenuItem IntroFrame = new JMenuItem(getLocalizedMessage("Intro_FRAME"));
		goTo.setMnemonic(language == Language.SPANISH ? 'I'
				: language == Language.PORTUGUES ? 'V' : language == Language.ENGLISH ? 'G' : 'A');
		fatura.setMnemonic(language == Language.SPANISH ? 'F'
				: language == Language.PORTUGUES ? 'F' : language == Language.ENGLISH ? 'I' : 'f');
		IntroFrame.setMnemonic(language == Language.SPANISH ? 'P'
				: language == Language.PORTUGUES ? 'P' : language == Language.ENGLISH ? 'f' : 'P');

		fatura.addActionListener(_ -> {
			FaturaR.totalC.setText("0");
			FaturaR.total.setText("0");
			dispose();
			new FaturaR();
		});
		IntroFrame.addActionListener(_ -> {
			dispose();
			new Intro();
		});
		goTo.add(IntroFrame);
		goTo.add(fatura);

		/* 3 STOCK */
		JMenu stockM = new JMenu("STOCK");
		JMenu merchandiseMenu = new JMenu(getLocalizedMessage("STOCK_MAN"));
		JMenuItem viewMerchandise = new JMenuItem(getLocalizedMessage("VIEW_STOCK"));
		JMenuItem changeStock = new JMenuItem(getLocalizedMessage("CHANGE_STOCK"));
		JMenuItem addStockDate = new JMenuItem(getLocalizedMessage("DATE_STOCK"));
		JMenu salesTrack = new JMenu(getLocalizedMessage("SALES_TRAKING"));
		JMenuItem summaryItem = new JMenuItem(getLocalizedMessage("SUMMARY") + " ITEM");
		JMenuItem itemByDates = new JMenuItem(getLocalizedMessage("SEARCH_STOCK"));
		JMenuItem viewAddedStockDate = new JMenuItem(getLocalizedMessage("SEARCH_DATES"));
		JMenuItem topItems = new JMenuItem(getLocalizedMessage("TOP_SELL"));
		JMenuItem noSalesM = new JMenuItem(getLocalizedMessage("NO_SALES"));
		JMenu invoiceMenu = new JMenu(getLocalizedMessage("INVOICE_MAN"));
		JMenuItem todaySell = new JMenuItem(getLocalizedMessage("ADD_STOCK"));
		JMenuItem changeOldSell = new JMenuItem(getLocalizedMessage("DELETE_SELL"));
		JMenuItem oldInvoices = new JMenuItem(getLocalizedMessage("OLD_INVOICES"));
		changeOldSell.setToolTipText(getLocalizedMessage("DELETE_TOOLTIP"));
		viewMerchandise.addActionListener(_ -> {
			loadStockData();
			openMerchandiseDialog();
		});
		addStockDate.addActionListener(_ -> {
			loadStockData();
			addDateStock();
		});
		changeStock.addActionListener(_ -> {
			loadStockData();
			changeStock();
		});
		itemByDates.addActionListener(_ -> {
			loadStockData();
			searchItemByDates();
		});
		viewAddedStockDate.addActionListener(_ -> {
			loadStockData();
			searchAddedByDates();
		});
		topItems.addActionListener(_ -> {
			loadStockData();
			searchTopMechandise();
		});
		todaySell.addActionListener(_ -> {
			loadStockData();
			tabbedPane.removeAll();
			invoiceModels.clear();
			loadInvoices(currentDate);
			invoiceTab(currentDate);
		});
		noSalesM.addActionListener(_ -> searchUnsellMechandise());
		oldInvoices.addActionListener(_ -> viewOldInvoices());
		summaryItem.addActionListener(_ -> merchandiseSummDialog());
		changeOldSell.addActionListener(_ -> removeOldSale());
		merchandiseMenu.add(viewMerchandise);
		merchandiseMenu.add(addStockDate);
		merchandiseMenu.add(changeStock);
		salesTrack.add(summaryItem);
		salesTrack.add(itemByDates);
		salesTrack.add(viewAddedStockDate);
		salesTrack.add(topItems);
		salesTrack.add(noSalesM);
		invoiceMenu.add(todaySell);
		invoiceMenu.add(changeOldSell);
		invoiceMenu.add(oldInvoices);
		stockM.add(merchandiseMenu);
		stockM.add(salesTrack);
		stockM.add(invoiceMenu);

		/* 4 SUMMARY */
		JMenu overviewM = new JMenu(getLocalizedMessage("ANALYSE"));
		JMenu extraM = new JMenu(getLocalizedMessage("SUMMARY"));
		JMenu monthAvg = new JMenu(getLocalizedMessage("MONTH_SUM"));
		JMenu oldMonth = new JMenu(getLocalizedMessage("OTHER"));
		JMenu yearSum = new JMenu(getLocalizedMessage("YEAR_SUMM"));
		JMenuItem thisYearSum = new JMenuItem(getLocalizedMessage("THIS_YEAR"));
		JMenuItem year21 = new JMenuItem(getLocalizedMessage("YEAR") + " " + (currentDate.y - 4));
		JMenuItem year22 = new JMenuItem(getLocalizedMessage("YEAR") + " " + (currentDate.y - 3));
		JMenuItem year23 = new JMenuItem(getLocalizedMessage("YEAR") + " " + (currentDate.y - 2));
		JMenuItem year24 = new JMenuItem(getLocalizedMessage("YEAR") + " " + (currentDate.y - 1));
		JMenuItem monthSelected[] = new JMenuItem[13];
		JSeparator monthSepSumm = new JSeparator();
		JMenu summary = new JMenu(getLocalizedMessage("SETTING"));
		JMenu dailyMenu = new JMenu(getLocalizedMessage("DAILY_SUMMARY"));
		JMenuItem sumV = new JMenuItem(getLocalizedMessage("TODAY_SUMMARY"));
		JMenuItem sumOld = new JMenuItem(getLocalizedMessage("OLD_SUMMARY"));
		JMenu effectChooser = new JMenu(getLocalizedMessage("EFFECT"));
		JMenuItem sumV1 = new JMenuItem(getLocalizedMessage("FADE"));
		JMenuItem sumV2 = new JMenuItem(getLocalizedMessage("WORD_WORD"));
		JMenuItem sumV3 = new JMenuItem(getLocalizedMessage("LETTER_LETTER"));
		JMenuItem sumV4 = new JMenuItem(getLocalizedMessage("SCRAMBLE"));
		JMenu speedChooser = new JMenu(getLocalizedMessage("SPEED"));
		JMenuItem speed1 = new JMenuItem(getLocalizedMessage("SLOW"));
		JMenuItem speed2 = new JMenuItem(getLocalizedMessage("MEDUIM"));
		JMenuItem speed3 = new JMenuItem(getLocalizedMessage("FAST"));

		/* B graph */
		JMenu graphMenu = new JMenu(getLocalizedMessage("GRAPH"));
		JMenu monthMenu = new JMenu(getLocalizedMessage("MONTH"));
		JMenuItem graphMonth[] = new JMenuItem[13];
		JMenu oldMonth2 = new JMenu(getLocalizedMessage("OTHER"));
		JSeparator monthSepGraph = new JSeparator();
		JMenu yearMenu = new JMenu(getLocalizedMessage("YEAR"));
		JMenuItem graphThisYear = new JMenuItem(getLocalizedMessage("THIS_YEAR"));
		JSeparator yearSepGraph = new JSeparator();
		JMenu oldYears = new JMenu(getLocalizedMessage("OTHER"));
		JMenuItem graph21 = new JMenuItem(getLocalizedMessage("YEAR") + " " + (currentDate.y - 4));
		JMenuItem graph22 = new JMenuItem(getLocalizedMessage("YEAR") + " " + (currentDate.y - 3));
		JMenuItem graph23 = new JMenuItem(getLocalizedMessage("YEAR") + " " + (currentDate.y - 2));
		JMenuItem graph24 = new JMenuItem(getLocalizedMessage("YEAR") + " " + (currentDate.y - 1));
		JMenuItem graphDiffYear = new JMenuItem(getLocalizedMessage("ALL_YEAR"));
		overviewM.setMnemonic('N');
		extraM.setMnemonic('S');
		graphMenu.setMnemonic('G');
		/* effect choose default conf */
		if (conf[8] == null || conf[8].equals("0")) {
			effChooser = 0;
			sumV1.setEnabled(false);
			sumV2.setEnabled(true);
			sumV3.setEnabled(true);
			sumV4.setEnabled(true);
		} else if (conf[8].equals("1")) {
			effChooser = 1;
			sumV1.setEnabled(true);
			sumV2.setEnabled(false);
			sumV3.setEnabled(true);
			sumV4.setEnabled(true);
		} else if (conf[8].equals("2")) {
			effChooser = 2;
			sumV1.setEnabled(true);
			sumV2.setEnabled(true);
			sumV3.setEnabled(false);
			sumV4.setEnabled(true);
		} else {
			effChooser = 3;
			sumV1.setEnabled(true);
			sumV2.setEnabled(true);
			sumV3.setEnabled(true);
			sumV4.setEnabled(false);
		}
		summaryActionListener(sumV1, sumV2, sumV3, sumV4);
		/* speed default conf */
		if (conf[6] == null || conf[6].equals("1")) {
			speed1.setEnabled(true);
			speed2.setEnabled(false);
			speed3.setEnabled(true);
		} else if (conf[6].equals("0")) {
			speed1.setEnabled(false);
			speed2.setEnabled(true);
			speed3.setEnabled(true);
		} else {
			speed1.setEnabled(true);
			speed2.setEnabled(true);
			speed3.setEnabled(false);
		}
		speedActionListener(speed1, speed2, speed3);
		/* Summary */
		monthSelected[0] = new JMenuItem(currentDate.getMonthForInt(langIndex));
		monthSelected[0].addActionListener(_ -> monthAvgFrame(Integer.valueOf(currentDate.m)));
		for (int i = 1; i < 13; i++)
			monthSelected[i] = new JMenuItem(getMonthForInt(i - 1, langIndex));
		monthSelected[1].addActionListener(_ -> monthAvgFrame(1));
		monthSelected[2].addActionListener(_ -> monthAvgFrame(2));
		monthSelected[3].addActionListener(_ -> monthAvgFrame(3));
		monthSelected[4].addActionListener(_ -> monthAvgFrame(4));
		monthSelected[5].addActionListener(_ -> monthAvgFrame(5));
		monthSelected[6].addActionListener(_ -> monthAvgFrame(6));
		monthSelected[7].addActionListener(_ -> monthAvgFrame(7));
		monthSelected[8].addActionListener(_ -> monthAvgFrame(8));
		monthSelected[9].addActionListener(_ -> monthAvgFrame(9));
		monthSelected[10].addActionListener(_ -> monthAvgFrame(10));
		monthSelected[11].addActionListener(_ -> monthAvgFrame(11));
		monthSelected[12].addActionListener(_ -> monthAvgFrame(12));
		for (int i = 1; i < 13; i++)
			if (i > Integer.valueOf(currentDate.m) - 1)
				monthSelected[i].hide();
		thisYearSum.addActionListener(_ -> yearSumFram());
		year21.addActionListener(_ -> oldYearSumm(currentDate.y - 4));
		year22.addActionListener(_ -> oldYearSumm(currentDate.y - 3));
		year23.addActionListener(_ -> oldYearSumm(currentDate.y - 2));
		year24.addActionListener(_ -> oldYearSumm(currentDate.y - 1));
		monthAvg.add(monthSelected[0]);
		if (Integer.valueOf(currentDate.m) > 1) {
			monthAvg.add(monthSepSumm);
			monthAvg.add(oldMonth);
			for (int i = 1; i < 13; i++)
				oldMonth.add(monthSelected[i]);
		}

		/* Graph */
		graphMonth[0] = new JMenuItem(currentDate.getMonthForInt(langIndex));
		graphMonth[0].addActionListener(_ -> monthGraph(Integer.valueOf(currentDate.m)));
		for (int i = 1; i < 13; i++)
			graphMonth[i] = new JMenuItem(getMonthForInt(i - 1, langIndex));
		graphMonth[1].addActionListener(_ -> monthGraph(1));
		graphMonth[2].addActionListener(_ -> monthGraph(2));
		graphMonth[3].addActionListener(_ -> monthGraph(3));
		graphMonth[4].addActionListener(_ -> monthGraph(4));
		graphMonth[5].addActionListener(_ -> monthGraph(5));
		graphMonth[6].addActionListener(_ -> monthGraph(6));
		graphMonth[7].addActionListener(_ -> monthGraph(7));
		graphMonth[8].addActionListener(_ -> monthGraph(8));
		graphMonth[9].addActionListener(_ -> monthGraph(9));
		graphMonth[10].addActionListener(_ -> monthGraph(10));
		graphMonth[11].addActionListener(_ -> monthGraph(11));
		graphMonth[12].addActionListener(_ -> monthGraph(12));
		for (int i = 1; i < 13; i++)
			if (i > Integer.valueOf(currentDate.m) - 1)
				graphMonth[i].hide();
		graphThisYear.addActionListener(_ -> yearGraph(currentDate.y));
		graph21.addActionListener(_ -> yearGraph(currentDate.y - 4));
		graph22.addActionListener(_ -> yearGraph(currentDate.y - 3));
		graph23.addActionListener(_ -> yearGraph(currentDate.y - 2));
		graph24.addActionListener(_ -> yearGraph(currentDate.y - 1));
		graphDiffYear.addActionListener(_ -> diffYearsGraph());
		sumV.addActionListener(_ -> summaryFrame());
		sumOld.addActionListener(_ -> viewOldSummary());
		graphMenu.add(monthMenu);
		monthMenu.add(graphMonth[0]);
		if (Integer.valueOf(currentDate.m) > 1) {
			monthMenu.add(monthSepGraph);
			monthMenu.add(oldMonth2);
			for (int i = 1; i < 13; i++)
				oldMonth2.add(graphMonth[i]);
		}
		if (Integer.valueOf(currentDate.m) <= 1) {
			graphThisYear.setEnabled(false);
			graphDiffYear.setEnabled(false);
		}
		dailyMenu.add(sumV);
		dailyMenu.add(sumOld);
		yearMenu.add(graphThisYear);
		yearMenu.add(graphDiffYear);
		if (conLY4.size() > 0)
			oldYears.add(graph21);
		if (conLY3.size() > 0)
			oldYears.add(graph22);
		if (conLY2.size() > 0)
			oldYears.add(graph23);
		if (conLY.size() > 0)
			oldYears.add(graph24);
		if (conLY.size() == 0 && conLY2.size() == 0 && conLY3.size() == 0 && conLY4.size() == 0) {
			graphDiffYear.setVisible(false);
			oldYears.setVisible(false);
			yearSepGraph.setVisible(false);
		}
		yearMenu.add(yearSepGraph);
		yearMenu.add(oldYears);
		graphMenu.add(yearMenu);
		speedChooser.add(speed1);
		speedChooser.add(speed2);
		speedChooser.add(speed3);
		effectChooser.add(sumV1);
		effectChooser.add(sumV2);
		effectChooser.add(sumV3);
		effectChooser.add(sumV4);
		summary.add(effectChooser);
		summary.add(speedChooser);
		extraM.add(dailyMenu);
		extraM.add(monthAvg);
		extraM.add(yearSum);
		yearSum.add(thisYearSum);
		if (conLY4.size() > 0)
			yearSum.add(year21);
		if (conLY3.size() > 0)
			yearSum.add(year22);
		if (conLY2.size() > 0)
			yearSum.add(year23);
		if (conLY.size() > 0)
			yearSum.add(year24);
		extraM.add(summary);
		overviewM.add(extraM);
		overviewM.add(graphMenu);
		if (conThisYear.size() == 0) {// disable the summary month/year when there is no data
			monthAvg.setEnabled(false);
			thisYearSum.setEnabled(false);
			monthMenu.setEnabled(false);
			graphThisYear.setEnabled(false);
			graphDiffYear.setEnabled(false);
		}

		/* 5 EMPLOYEE */
		JMenu empMenu = new JMenu(getLocalizedMessage("EMPLOYEE"));
		JMenu workDays = new JMenu(getLocalizedMessage("WORK_DAYS"));
		JMenu browseFreeDays = new JMenu(getLocalizedMessage("FREE_DAYS"));
		JMenuItem weeklyFreeDays = new JMenuItem(getLocalizedMessage("WEEK_DAYS"));
		JMenuItem vacDays = new JMenuItem(getLocalizedMessage("VACATION"));
		JMenuItem unauthDays = new JMenuItem(getLocalizedMessage("UNAUTH"));
		JMenu sellsEmp = new JMenu(getLocalizedMessage("SELL"));
		JMenuItem sellsDate = new JMenuItem(getLocalizedMessage("TABLE"));
		JMenuItem sellsGraph = new JMenuItem(getLocalizedMessage("GRAPH"));
		JMenuItem sellsDiag = new JMenuItem(getLocalizedMessage("DIAGRAM"));
		JMenuItem editEmp = new JMenuItem(getLocalizedMessage("EDIT_EMPLOYEE"));
		List<JMenuItem> empLibres = new ArrayList<JMenuItem>();
		JMenuItem summSeller = new JMenuItem(getLocalizedMessage("SUMMARY"));
		employeeAddEvents();
		for (int i = 0; i < employee.size(); i++) {
			String name = employee.get(i).getName();
			JMenuItem emp = new JMenuItem(name);
			emp.addActionListener(_ -> employeeFDDialog(emp.getText()));
			if (colorSelected == 2)
				emp.setIcon(ImageEffect.getScaledImage(employeeI.getImage(), 35, 35));
			else
				emp.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(employeeI.getImage(), 35, 35)));

			if (!employee.get(i).getPosition().equalsIgnoreCase(getLocalizedMessage("BOSS")))
				empLibres.add(emp);
		}
		sellsDate.addActionListener(_ -> searchSellerByDates("", "table"));
		summSeller.addActionListener(_ -> searchSellerByDates("", "summary"));
		for (JMenuItem emp : empLibres)
			browseFreeDays.add(emp);
		weeklyFreeDays.addActionListener(_ -> weekFreeDays());
		vacDays.addActionListener(_ -> vacDays());
		editEmp.addActionListener(_ -> employeeChange());
		unauthDays.addActionListener(_ -> unauthDays());
		sellsGraph.addActionListener(_ -> searchSellerByDates("", "graph"));
		sellsDiag.addActionListener(_ -> searchSellerByDates("", "diagram"));
		if (employee.size() == 0) {
			workDays.setEnabled(false);
			sellsEmp.setEnabled(false);
		}
		workDays.add(browseFreeDays);
		workDays.add(weeklyFreeDays);
		workDays.add(vacDays);
		workDays.add(unauthDays);
		sellsEmp.add(sellsDate);
		sellsEmp.add(sellsGraph);
		sellsEmp.add(sellsDiag);
		sellsEmp.add(summSeller);
		empMenu.add(workDays);
		empMenu.add(sellsEmp);
		empMenu.add(editEmp);

		/* 5 EXTRA */
		JMenu extraMenu = new JMenu("EXTRA");
		JMenu billsMenu = new JMenu(getLocalizedMessage("BILLS"));
		JMenuItem openBills = new JMenuItem(getLocalizedMessage("BILLS_O"));
		JMenuItem changeBills = new JMenuItem(getLocalizedMessage("BILLS_C"));
		JMenu holidayMenu = new JMenu(getLocalizedMessage("HOLIDAY"));
		JMenuItem openHoliday = new JMenuItem(getLocalizedMessage("HOLIDAY_O"));
		JMenuItem changeHoliday = new JMenuItem(getLocalizedMessage("HOLIDAY_C"));
		JMenu birthdayMenu = new JMenu(getLocalizedMessage("BIRTHDAY"));
		JMenuItem openBirthday = new JMenuItem(getLocalizedMessage("BIRTHDAY_O"));
		JMenuItem changeBirthday = new JMenuItem(getLocalizedMessage("BIRTHDAY_C"));
		JMenuItem calculatorMenu = new JMenuItem(getLocalizedMessage("CALCULATOR"));
		JMenuItem billsAndAgg = new JMenuItem(getLocalizedMessage("KEYWORDS"));
		billsMenu.setMnemonic(language == Language.SPANISH ? 'F'
				: language == Language.PORTUGUES ? 'O' : language == Language.ENGLISH ? 'B' : 'F');
		JMenuItem cleanLog = new JMenuItem(getLocalizedMessage("CLEAR_CACHE"));
		holidayMenu.setMnemonic('H');
		extraMenu.setMnemonic('E');
		billsAndAgg.setMnemonic('K');
		billsAndAgg.setToolTipText(getLocalizedMessage("KEYWORDS_H"));
		calculatorMenu.addActionListener(_ -> calculatorFunction());
		openBills.addActionListener((_) -> {
			if (bills.size() == 0)
				Toast.show(this, Toast.Type.INFO, getLocalizedMessage("NO_EVENT"), Intro.notOption);
			else
				viewBillDialog();
		});
		changeBills.addActionListener(_ -> billsChange());
		billsAndAgg.addActionListener(_ -> keywordsDialog());
		openHoliday.addActionListener((_) -> {
			holidays = getHolidaysFromToday();
			if (holidays.size() == 0)
				Toast.show(this, Toast.Type.INFO, getLocalizedMessage("NO_EVENT"), Intro.notOption);
			else
				HolidayDialog();
		});
		changeHoliday.addActionListener(_ -> holidaysChange());
		cleanLog.addActionListener(_ -> {
			ModernDialog dialog = new ModernDialog(this, cleanLog.getText(), false);
			dialog.addSubText(getLocalizedMessage("CANNOT_UNDO"), fg);
			dialog.setIcon(IconType.QUESTION);
			dialog.addButton(getLocalizedMessage("YES"), Intro.greenM, () -> {
				if (deleteFolder(logFolder))
					Toast.show(this, Toast.Type.SUCCESS, getLocalizedMessage("CLEAN_S"), Intro.notOption);
				else
					Toast.show(this, Toast.Type.ERROR, getLocalizedMessage("CLEAN_U"));

			});
			dialog.addButton(getLocalizedMessage("NO"), Intro.redM, dialog::dispose);

			dialog.setColor(bg);
			dialog.setTextColor(fg);
			dialog.setOverlayColor(bg);
			dialog.setVisible(true);
		});
		openBirthday.addActionListener(_ -> {
			if (birthdayL.size() == 0)
				Toast.show(this, Toast.Type.INFO, getLocalizedMessage("NO_EVENT"), Intro.notOption);
			else
				BirthdayDialog();
		});
		changeBirthday.addActionListener(_ -> BirthdayChange());
		cleanLog.setMnemonic('L');
		billsMenu.add(openBills);
		billsMenu.add(changeBills);
		holidayMenu.add(openHoliday);
		holidayMenu.add(changeHoliday);
		birthdayMenu.add(openBirthday);
		birthdayMenu.add(changeBirthday);
		extraMenu.add(billsMenu);
		extraMenu.add(holidayMenu);
		extraMenu.add(birthdayMenu);
		extraMenu.add(calculatorMenu);
		extraMenu.add(billsAndAgg);
		extraMenu.add(cleanLog);

		/* 5 SECURITY */
		JMenu securityMenu = new JMenu(getLocalizedMessage("SECURITY"));
		JMenuItem lockFrame = new JMenuItem(getLocalizedMessage("LOCK"));
		JMenuItem separadosM = new JMenuItem(getLocalizedMessage("SEP"));
		JMenuItem passwordM = new JMenuItem(getLocalizedMessage("PASSWORD"));
		securityMenu.setMnemonic('S');
		lockFrame.setMnemonic(language == Language.SPANISH ? 'B'
				: language == Language.PORTUGUES ? 'B' : language == Language.ENGLISH ? 'L' : 'V');
		separadosM.setMnemonic('S');
		lockFrame.addActionListener(_ -> lockFrame());
		separadosM.addActionListener(_ -> separatedDialog(false));
		passwordM.addActionListener(_ -> passwordChange(usersF));
		securityMenu.add(lockFrame);
		securityMenu.add(separadosM);
		securityMenu.add(passwordM);
		/* 6 HELP */
		JMenu help = new JMenu(getLocalizedMessage("HELP"));
		JMenuItem keyShortcut = new JMenuItem(getLocalizedMessage("KEYS"));
		JMenuItem creator = new JMenuItem(getLocalizedMessage("ABOUTME"));
		JMenuItem about = new JMenuItem(getLocalizedMessage("ABOUTAPP"));
		help.setMnemonic(language == Language.SPANISH ? 'Y'
				: language == Language.PORTUGUES ? 'J' : language == Language.ENGLISH ? 'H' : 'I');
		keyShortcut.setMnemonic(language == Language.SPANISH ? 'T'
				: language == Language.PORTUGUES ? 'T' : language == Language.ENGLISH ? 'K' : 'R');
		creator.setMnemonic('C');
		about.setMnemonic('A');
		if (conf[2] == null || conf[2].equals("false"))
			keyShortcut.addActionListener(_ -> {
				ModernDialog keyShort = new ModernDialog(this, getLocalizedMessage("SHORTKEY"), false);
				keyShort.setIcon(IconType.INFO);
				keyShort.addButton(getLocalizedMessage("YES"), blueC, keyShort::dispose);
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
		help.add(keyShortcut);
		help.add(creator);
		help.add(about);

		/* 7 Menubar Icon */
		novo.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(newdayI.getImage(), 35, 35)));
		screenShot.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(screenshotI.getImage(), 35, 35)));
		save.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(saveI.getImage(), 35, 35)));
		clear.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(deleteI.getImage(), 35, 35)));
		calc.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(calcI.getImage(), 35, 35)));
		option.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(settingI.getImage(), 35, 35)));
		exit.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(exitI.getImage(), 35, 35)));

		IntroFrame.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(IntroI.getImage(), 35, 35)));
		fatura.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(invoiceI.getImage(), 35, 35)));

		merchandiseMenu.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(stockManI.getImage(), 35, 35)));
		viewMerchandise.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(viewStockI.getImage(), 35, 35)));
		changeStock.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(changeStockI.getImage(), 35, 35)));
		addStockDate.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(addStockI.getImage(), 35, 35)));
		salesTrack.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(salesTrackI.getImage(), 35, 35)));
		summaryItem.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(sumMI.getImage(), 35, 35)));
		itemByDates.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(sellDateI.getImage(), 35, 35)));
		viewAddedStockDate.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(viewAddedI.getImage(), 35, 35)));
		topItems.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(topSellI.getImage(), 35, 35)));
		invoiceMenu.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(invoiceI.getImage(), 35, 35)));
		noSalesM.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(noSalesI.getImage(), 35, 35)));
		todaySell.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(addSellI.getImage(), 35, 35)));
		oldInvoices.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(oldSummI.getImage(), 35, 35)));
		changeOldSell.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(deleteI.getImage(), 35, 35)));

		extraM.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(overviewI.getImage(), 35, 35)));
		dailyMenu.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(sumMI.getImage(), 35, 35)));
		sumV.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(summaryI.getImage(), 35, 35)));
		sumOld.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(oldSummI.getImage(), 35, 35)));
		monthAvg.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(monthlyI.getImage(), 35, 35)));
		oldMonth.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(previousI.getImage(), 35, 35)));
		for (int i = 0; i < 12; i++) {// month foto
			monthP[i] = getClass().getResource("images/menubar/month/" + (i + 1) + ".png");
			monthI[i] = new ImageIcon(monthP[i]);
		}
		monthSelected[0].setIcon(ImageEffect.invertColor(
				ImageEffect.getScaledImage(monthI[Integer.valueOf(currentDate.m) - 1].getImage(), 35, 35)));
		for (int i = 1; i < 12; i++)
			monthSelected[i]
					.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(monthI[i - 1].getImage(), 35, 35)));
		yearSum.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(yearI.getImage(), 35, 35)));
		thisYearSum.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(thisYearI.getImage(), 35, 35)));
		year21.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(yearI.getImage(), 35, 35)));
		year22.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(yearI.getImage(), 35, 35)));
		year23.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(yearI.getImage(), 35, 35)));
		year24.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(yearI.getImage(), 35, 35)));

		oldMonth2.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(previousI.getImage(), 35, 35)));
		oldYears.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(previousI.getImage(), 35, 35)));
		monthMenu.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(monthlyI.getImage(), 35, 35)));
		graphMonth[0].setIcon(ImageEffect.invertColor(
				ImageEffect.getScaledImage(monthI[Integer.valueOf(currentDate.m) - 1].getImage(), 35, 35)));
		for (int i = 1; i < 12; i++)
			graphMonth[i]
					.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(monthI[i - 1].getImage(), 35, 35)));
		yearMenu.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(yearI.getImage(), 35, 35)));
		graphThisYear.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(thisYearI.getImage(), 35, 35)));
		graph21.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(yearI.getImage(), 35, 35)));
		graph22.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(yearI.getImage(), 35, 35)));
		graph23.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(yearI.getImage(), 35, 35)));
		graph24.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(yearI.getImage(), 35, 35)));
		graphDiffYear.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(oldYearI.getImage(), 35, 35)));

		graphMenu.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(graphicI.getImage(), 35, 35)));
		summary.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(settingI.getImage(), 35, 35)));
		effectChooser.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(themeI.getImage(), 35, 35)));
		speedChooser.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(speedI.getImage(), 35, 35)));
		sumV1.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(effect1I.getImage(), 35, 35)));
		sumV2.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(effect2I.getImage(), 35, 35)));
		sumV3.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(effect3I.getImage(), 35, 35)));
		sumV4.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(effect4I.getImage(), 35, 35)));
		speed1.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(slowI.getImage(), 35, 35)));
		speed2.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(normalI.getImage(), 35, 35)));
		speed3.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(fastI.getImage(), 35, 35)));

		workDays.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(freedayI.getImage(), 35, 35)));
		browseFreeDays.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(freedayI.getImage(), 35, 35)));
		weeklyFreeDays.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(weekI.getImage(), 35, 35)));
		vacDays.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(licenseI.getImage(), 35, 35)));
		unauthDays.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(faltaI.getImage(), 35, 35)));
		editEmp.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(workersI.getImage(), 35, 35)));
		sellsEmp.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(oldSummI.getImage(), 35, 35)));
		sellsDate.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(sellDateI.getImage(), 35, 35)));
		summSeller.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(sumMI.getImage(), 35, 35)));
		sellsGraph.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(graphicI.getImage(), 35, 35)));
		sellsDiag.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(stockManI.getImage(), 35, 35)));

		calculatorMenu.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(calcI.getImage(), 35, 35)));
		billsMenu.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(reminderI.getImage(), 35, 35)));
		openBills.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(viewBillsI.getImage(), 35, 35)));
		changeBills.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(editBillsI.getImage(), 35, 35)));
		holidayMenu.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(holidayMI.getImage(), 35, 35)));
		openHoliday.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(holidayVI.getImage(), 35, 35)));
		changeHoliday.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(holidayMI.getImage(), 35, 35)));
		birthdayMenu.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(birthdayI.getImage(), 35, 35)));
		openBirthday.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(birthdayOI.getImage(), 35, 35)));
		changeBirthday.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(birthdayCI.getImage(), 35, 35)));
		cleanLog.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(clearI.getImage(), 35, 35)));
		billsAndAgg.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(keywordI.getImage(), 35, 35)));

		lockFrame.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(lockI.getImage(), 35, 35)));
		separadosM.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(sepI.getImage(), 35, 35)));
		passwordM.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(passwordI.getImage(), 35, 35)));

		keyShortcut.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(keyboardI.getImage(), 35, 35)));
		creator.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(creatorI.getImage(), 35, 35)));
		about.setIcon(ImageEffect.invertColor(ImageEffect.getScaledImage(aboutI.getImage(), 35, 35)));

		/* ACTION LISTENER FOR MENU ITEM */
		option.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_DOWN_MASK));
		clear.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, KeyEvent.CTRL_DOWN_MASK));
		screenShot.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.ALT_DOWN_MASK));
		IntroFrame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.ALT_DOWN_MASK));
		novo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
		fatura.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
		calculatorMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_MULTIPLY, KeyEvent.CTRL_DOWN_MASK));
		openBills.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK));
		openHoliday.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.ALT_DOWN_MASK));
		lockFrame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, KeyEvent.CTRL_DOWN_MASK));

		/* 9 ADD TO MENUBAR */
		mb.add(file);
		mb.add(goTo);
		mb.add(stockM);
		mb.add(overviewM);
		mb.add(empMenu);
		mb.add(extraMenu);
		mb.add(securityMenu);
		mb.add(help);
		setJMenuBar(mb);
		/* Close MenuBar */

		/* White Mode */
		if (colorSelected == 2) {
			novo.setIcon(ImageEffect.getScaledImage(newdayI.getImage(), 35, 35));
			screenShot.setIcon(ImageEffect.getScaledImage(screenshotI.getImage(), 35, 35));
			save.setIcon(ImageEffect.getScaledImage(saveI.getImage(), 35, 35));
			clear.setIcon(ImageEffect.getScaledImage(deleteI.getImage(), 35, 35));
			calc.setIcon(ImageEffect.getScaledImage(calcI.getImage(), 35, 35));
			option.setIcon(ImageEffect.getScaledImage(settingI.getImage(), 35, 35));
			exit.setIcon(ImageEffect.getScaledImage(exitI.getImage(), 35, 35));

			IntroFrame.setIcon(ImageEffect.getScaledImage(IntroI.getImage(), 35, 35));
			fatura.setIcon(ImageEffect.getScaledImage(invoiceI.getImage(), 35, 35));

			merchandiseMenu.setIcon(ImageEffect.getScaledImage(stockManI.getImage(), 35, 35));
			viewMerchandise.setIcon(ImageEffect.getScaledImage(viewStockI.getImage(), 35, 35));
			changeStock.setIcon(ImageEffect.getScaledImage(changeStockI.getImage(), 35, 35));
			addStockDate.setIcon(ImageEffect.getScaledImage(addStockI.getImage(), 35, 35));
			salesTrack.setIcon(ImageEffect.getScaledImage(salesTrackI.getImage(), 35, 35));
			itemByDates.setIcon(ImageEffect.getScaledImage(sellDateI.getImage(), 35, 35));
			viewAddedStockDate.setIcon(ImageEffect.getScaledImage(viewAddedI.getImage(), 35, 35));
			topItems.setIcon(ImageEffect.getScaledImage(topSellI.getImage(), 35, 35));
			summaryItem.setIcon(ImageEffect.getScaledImage(sumMI.getImage(), 35, 35));
			noSalesM.setIcon(ImageEffect.getScaledImage(noSalesI.getImage(), 35, 35));
			invoiceMenu.setIcon(ImageEffect.getScaledImage(invoiceI.getImage(), 35, 35));
			oldInvoices.setIcon(ImageEffect.getScaledImage(invoiceI.getImage(), 35, 35));
			todaySell.setIcon(ImageEffect.getScaledImage(addSellI.getImage(), 35, 35));
			changeOldSell.setIcon(ImageEffect.getScaledImage(deleteI.getImage(), 35, 35));

			extraM.setIcon(ImageEffect.getScaledImage(overviewI.getImage(), 35, 35));
			sumV.setIcon(ImageEffect.getScaledImage(summaryI.getImage(), 35, 35));
			dailyMenu.setIcon(ImageEffect.getScaledImage(sumMI.getImage(), 35, 35));
			sumOld.setIcon(ImageEffect.getScaledImage(oldSummI.getImage(), 35, 35));
			monthAvg.setIcon(ImageEffect.getScaledImage(monthlyI.getImage(), 35, 35));
			oldMonth.setIcon(ImageEffect.getScaledImage(previousI.getImage(), 35, 35));
			for (int i = 0; i < 12; i++) {// month foto
				monthP[i] = getClass().getResource("images/menubar/month/" + (i + 1) + ".png");
				monthI[i] = new ImageIcon(monthP[i]);
			}
			monthSelected[0]
					.setIcon(ImageEffect.getScaledImage(monthI[Integer.valueOf(currentDate.m) - 1].getImage(), 35, 35));
			for (int i = 1; i < 12; i++)
				monthSelected[i].setIcon(ImageEffect.getScaledImage(monthI[i - 1].getImage(), 35, 35));
			yearSum.setIcon(ImageEffect.getScaledImage(yearI.getImage(), 35, 35));
			thisYearSum.setIcon(ImageEffect.getScaledImage(thisYearI.getImage(), 35, 35));
			year21.setIcon(ImageEffect.getScaledImage(yearI.getImage(), 35, 35));
			year22.setIcon(ImageEffect.getScaledImage(yearI.getImage(), 35, 35));
			year23.setIcon(ImageEffect.getScaledImage(yearI.getImage(), 35, 35));
			year24.setIcon(ImageEffect.getScaledImage(yearI.getImage(), 35, 35));

			oldMonth2.setIcon(ImageEffect.getScaledImage(previousI.getImage(), 35, 35));
			oldYears.setIcon(ImageEffect.getScaledImage(previousI.getImage(), 35, 35));
			monthMenu.setIcon(ImageEffect.getScaledImage(monthlyI.getImage(), 35, 35));
			graphMonth[0]
					.setIcon(ImageEffect.getScaledImage(monthI[Integer.valueOf(currentDate.m) - 1].getImage(), 35, 35));
			for (int i = 1; i < 12; i++)
				graphMonth[i].setIcon(ImageEffect.getScaledImage(monthI[i - 1].getImage(), 35, 35));
			yearMenu.setIcon(ImageEffect.getScaledImage(yearI.getImage(), 35, 35));
			graphThisYear.setIcon(ImageEffect.getScaledImage(thisYearI.getImage(), 35, 35));
			graph21.setIcon(ImageEffect.getScaledImage(yearI.getImage(), 35, 35));
			graph22.setIcon(ImageEffect.getScaledImage(yearI.getImage(), 35, 35));
			graph23.setIcon(ImageEffect.getScaledImage(yearI.getImage(), 35, 35));
			graph24.setIcon(ImageEffect.getScaledImage(yearI.getImage(), 35, 35));
			graphDiffYear.setIcon(ImageEffect.getScaledImage(oldYearI.getImage(), 35, 35));

			graphMenu.setIcon(ImageEffect.getScaledImage(graphicI.getImage(), 35, 35));
			summary.setIcon(ImageEffect.getScaledImage(settingI.getImage(), 35, 35));
			effectChooser.setIcon(ImageEffect.getScaledImage(themeI.getImage(), 35, 35));
			speedChooser.setIcon(ImageEffect.getScaledImage(speedI.getImage(), 35, 35));
			sumV1.setIcon(ImageEffect.getScaledImage(effect1I.getImage(), 35, 35));
			sumV2.setIcon(ImageEffect.getScaledImage(effect2I.getImage(), 35, 35));
			sumV3.setIcon(ImageEffect.getScaledImage(effect3I.getImage(), 35, 35));
			sumV4.setIcon(ImageEffect.getScaledImage(effect4I.getImage(), 35, 35));
			speed1.setIcon(ImageEffect.getScaledImage(slowI.getImage(), 35, 35));
			speed2.setIcon(ImageEffect.getScaledImage(normalI.getImage(), 35, 35));
			speed3.setIcon(ImageEffect.getScaledImage(fastI.getImage(), 35, 35));

			workDays.setIcon(ImageEffect.getScaledImage(freedayI.getImage(), 35, 35));
			browseFreeDays.setIcon(ImageEffect.getScaledImage(freedayI.getImage(), 35, 35));
			weeklyFreeDays.setIcon(ImageEffect.getScaledImage(weekI.getImage(), 35, 35));
			vacDays.setIcon(ImageEffect.getScaledImage(licenseI.getImage(), 35, 35));
			unauthDays.setIcon(ImageEffect.getScaledImage(faltaI.getImage(), 35, 35));
			editEmp.setIcon(ImageEffect.getScaledImage(workersI.getImage(), 35, 35));
			sellsEmp.setIcon(ImageEffect.getScaledImage(oldSummI.getImage(), 35, 35));
			sellsDate.setIcon(ImageEffect.getScaledImage(sellDateI.getImage(), 35, 35));
			sellsGraph.setIcon(ImageEffect.getScaledImage(graphicI.getImage(), 35, 35));
			sellsDiag.setIcon(ImageEffect.getScaledImage(stockManI.getImage(), 35, 35));
			summSeller.setIcon(ImageEffect.getScaledImage(sumMI.getImage(), 35, 35));

			calculatorMenu.setIcon(ImageEffect.getScaledImage(calcI.getImage(), 35, 35));
			billsMenu.setIcon(ImageEffect.getScaledImage(reminderI.getImage(), 35, 35));
			openBills.setIcon(ImageEffect.getScaledImage(viewBillsI.getImage(), 35, 35));
			changeBills.setIcon(ImageEffect.getScaledImage(editBillsI.getImage(), 35, 35));
			holidayMenu.setIcon(ImageEffect.getScaledImage(holidayMI.getImage(), 35, 35));
			openHoliday.setIcon(ImageEffect.getScaledImage(holidayVI.getImage(), 35, 35));
			changeHoliday.setIcon(ImageEffect.getScaledImage(holidayMI.getImage(), 35, 35));
			birthdayMenu.setIcon(ImageEffect.getScaledImage(birthdayI.getImage(), 35, 35));
			openBirthday.setIcon(ImageEffect.getScaledImage(birthdayOI.getImage(), 35, 35));
			changeBirthday.setIcon(ImageEffect.getScaledImage(birthdayCI.getImage(), 35, 35));
			cleanLog.setIcon(ImageEffect.getScaledImage(clearI.getImage(), 35, 35));
			billsAndAgg.setIcon(ImageEffect.getScaledImage(keywordI.getImage(), 35, 35));

			lockFrame.setIcon(ImageEffect.getScaledImage(lockI.getImage(), 35, 35));
			separadosM.setIcon(ImageEffect.getScaledImage(sepI.getImage(), 35, 35));
			passwordM.setIcon(ImageEffect.getScaledImage(passwordI.getImage(), 35, 35));

			keyShortcut.setIcon(ImageEffect.getScaledImage(keyboardI.getImage(), 35, 35));
			creator.setIcon(ImageEffect.getScaledImage(creatorI.getImage(), 35, 35));
			about.setIcon(ImageEffect.getScaledImage(aboutI.getImage(), 35, 35));
		}

		/* Frame Run */
		openProgress();// Open the values
		setupAWTEventListener();// autolock timer

		sumF();// Calculate total

		importSep();// import separated values
		if (!dayName(currentDate, 2).equalsIgnoreCase("sunday"))
			timeToClose();// END THE DAY
		InitialFocusSetter.setInitialFocus(this, details[lastEmpty()[0]][lastEmpty()[1]]);
		getRootPane().setDefaultButton(magic);
		setVisible(true);
		/* End Frame Run */

		/* Auto screenshot with notification */
		if (!doesLoaded) {
			/* Notification to view what you need to pay tomorrow */
			ArrayList<String> lists = getBillsDueToday(bills, WhatDay.TODAY);
			if (lists.size() != 0) {
				StringBuilder billsDescription = new StringBuilder();
				for (int i = 0; i < lists.size(); i++) {
					if (billsDescription.length() > 0) {
						billsDescription.append("\n"); // Add newline only between entries
					}
					billsDescription.append(lists.get(i));
				}
				Toast.show(this, Toast.Type.INFO, getLocalizedMessage("INVOICE_T") + billsDescription, Intro.notOption);
			}
			autoUpdate(8, 0);
			autoUpdate(10, 15);
			autoUpdate(12, 30);
			autoUpdate(14, 45);
			autoUpdate(17, 0);
			doesLoaded = true;
		}
		if (!status)
			status = true;

		/* Close windows popup */
		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				ModernDialog dialog = new ModernDialog(Main.this, getLocalizedMessage("EXIT_Q"), false);
				dialog.setIcon(IconType.ERROR);
				dialog.addSubText(getLocalizedMessage("CANNOT_UNDO"), fg);
				dialog.setColor(bg);
				dialog.setTextColor(fg);
				dialog.setOverlayColor(bg);
				// Adding a main button YES AND NO
				dialog.addButton(getLocalizedMessage("YES"), Intro.greenM, () -> {
					System.exit(0);
				});
				dialog.addButton(getLocalizedMessage("NO"), Intro.redM, dialog::dispose);

				// Adding an extra button, YES AND DO THE CASH FOR TOMORROW
				dialog.addButton(getLocalizedMessage("YEW_W"), Intro.blueM, () -> {

					if (!details[0][0].isVisible()) {// switch to the main table to take screenshot
						for (int i = 0; i < 6; i++)
							for (int j = 0; j < 20; j++) {
								details[i][j].setVisible(true);
								detailsM[i][j].setVisible(false);
								nextFocus();
							}
					} // hide the notification button to take screenshot cleaner
					notificationButton.setVisible(false);
					if (conf[1] == null || conf[1].equalsIgnoreCase("null") || conf[1].equals("false"))
						soundEffect(notSound);
					exBtn();
					/* If full delete the new table values */
					if (checkIfFull())
						try {
							String currentpath = System.getProperty("user.dir");
							File dataFolder = new File(currentpath + "\\data");
							dataFolder.mkdir();
							File extraFolder = new File(dataFolder + "\\extra");
							extraFolder.mkdir();
							File sepFile = new File(extraFolder, "indexM" + ".dll");

							FileWriter savedF = new FileWriter(sepFile);
							for (int i = 0; i < 6; i++)
								for (int j = 0; j < 20; j++)
									savedF.write("" + System.lineSeparator());
							savedF.close();
						} catch (Exception e) {
							writeError(e);
						}
					// cajas values
					for (int i = 0; i < 6; i++)// table detail
						for (int j = 0; j < 20; j++) {
							details[i][j].setText("");
							detailsM[i][j].setText("");
						}
					for (int i = 0; i < 16; i++) {// gastos nad agregados
						gastosTable[i].setText("");
						agregadoTable[i].setText("");
						gTable[i].setText("");
						aTable[i].setText("");
					} // DEFAULT NEXT DAY VALUES
					initialDay.setText(restN + "");
					for (int i = 0; i < 3; i++)// set of 1000 -> 50
						panelCnum[i].setText("");
					panelCnum[7].setText("");// pix
					sumF();

					/* NEXT DAY VALUES FOR DIFFERENT REASON */
					BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
					paint(img.getGraphics());
					File tempFile1 = new File(dataFolder + "\\extra");
					tempFile1.mkdir();
					File newFile = new File(tempFile1, "TEMP_NEXT_DAY.png");
					try {
						ImageIO.write(img, "png", newFile);
					} catch (IOException e) {
						writeError(e);
					}
					System.exit(0);
				});
				dialog.setVisible(true);

			}

			@Override
			public void windowActivated(WindowEvent e) {
				isAppInForeground = true;
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				isAppInForeground = false;
			}
		});
	}

	/* Frame to show the monthly graph */
	private void monthGraph(int month) {
		JDialog frame = new JDialog(this, getLocalizedMessage("GRAPH"), true);
		overlay.showOverlay();

		JFreeChart lineChart = monthChart(month);

		// Create and display the panel
		ChartPanel chartPanel = new ChartPanel(lineChart);
		chartPanel.setPreferredSize(new Dimension(getWidth() * 2 / 3, getHeight() * 2 / 3));

		// Create a JPanel to hold both the chart and the custom legend
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		// Add the chart to the center of the panel
		panel.add(chartPanel, BorderLayout.CENTER);

		// Create a JLabel for the custom legend
		String legend = "<html><head><style> body {color" + (colorSelected == 2 ? ": black;" : ": white;")
				+ "} </style></head>" + getLocalizedMessage("LEGEND") + "<br></html>";
		JLabel customLegend = new JLabel(legend);
		customLegend.setOpaque(true);
		customLegend.setBackground(bg);
		customLegend.setHorizontalAlignment(SwingConstants.CENTER); // Center the legend text
		customLegend.setFont(new Font("Arial", Font.PLAIN, 12)); // Set font for the legend

		// Add the custom legend below the chart
		panel.add(customLegend, BorderLayout.SOUTH);

		// Menubar
		JMenuBar menu = new JMenuBar();
		JMenu file = new JMenu(getLocalizedMessage("FILE"));
		JMenu save = new JMenu(getLocalizedMessage("SAVE"));
		JMenuItem exit = new JMenuItem(getLocalizedMessage("EXIT"));
		JMenuItem saveAsPng = new JMenuItem("PNG");
		JMenuItem saveAsPdf = new JMenuItem("PDF");
		JMenuItem saveAsSvg = new JMenuItem("SVG");
		saveAsPng.setIcon(colorSelected == 2 ? ImageEffect.getScaledImage(pngI.getImage(), 35, 35)
				: ImageEffect.invertColor(ImageEffect.getScaledImage(pngI.getImage(), 35, 35)));
		saveAsPdf.setIcon(colorSelected == 2 ? ImageEffect.getScaledImage(pdfI.getImage(), 35, 35)
				: ImageEffect.invertColor(ImageEffect.getScaledImage(pdfI.getImage(), 35, 35)));
		saveAsSvg.setIcon(colorSelected == 2 ? ImageEffect.getScaledImage(svgI.getImage(), 35, 35)
				: ImageEffect.invertColor(ImageEffect.getScaledImage(svgI.getImage(), 35, 35)));
		save.setIcon(colorSelected == 2 ? ImageEffect.getScaledImage(saveI.getImage(), 35, 35)
				: ImageEffect.invertColor(ImageEffect.getScaledImage(saveI.getImage(), 35, 35)));
		exit.setIcon(colorSelected == 2 ? ImageEffect.getScaledImage(exitI.getImage(), 35, 35)
				: ImageEffect.invertColor(ImageEffect.getScaledImage(exitI.getImage(), 35, 35)));
		chartPanel.setPopupMenu(null);
		saveAsPng.addActionListener(_ -> saveChartByExt(lineChart, "png"));
		saveAsPdf.addActionListener(_ -> saveChartByExt(lineChart, "pdf"));
		saveAsSvg.addActionListener(_ -> saveChartByExt(lineChart, "svg"));
		exit.addActionListener(_ -> {
			frame.dispose();
			overlay.hideOverlay();
		});

		file.add(save);
		save.add(saveAsPng);
		save.add(saveAsPdf);
		save.add(saveAsSvg);
		file.add(exit);
		menu.add(file);

		// Add ESC key listener to close the frame
		InputMap inputMap = frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap = frame.getRootPane().getActionMap();
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "closeDialog");
		actionMap.put("closeDialog", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				overlay.hideOverlay();
			}
		});
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				overlay.hideOverlay();
			}
		});

		// Set focus on the frame to make sure key events are captured
		frame.setFocusable(true);
		frame.requestFocusInWindow();

		frame.setJMenuBar(menu);
		frame.getContentPane().add(panel); // Add the panel to the frame
		frame.setIconImage(colorSelected == 2 ? ImageEffect.getScaledImage(monthlyI.getImage(), 35, 35).getImage()
				: ImageEffect.invertColor(ImageEffect.getScaledImage(monthlyI.getImage(), 35, 35)).getImage());
		frame.pack();
		frame.setLocationRelativeTo(null);

		frame.setVisible(true);
	}

	/* Return the chart of month */
	private JFreeChart monthChart(int month) {
		/* The values of the month */
		ArrayList<Integer> values = DataCalc.sellOfMonth(month);
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (int day = 0; day < values.size(); day++)
			dataset.addValue(values.get(day) == null ? null : values.get(day), getLocalizedMessage("SELL"),
					(day + 1) + "");

		// Create the chart
		JFreeChart lineChart = ChartFactory.createLineChart(getMonthForInt(month - 1, langIndex),
				getLocalizedMessage("DAY"), getLocalizedMessage("SELL"), dataset);

		// Customize chart background color
		lineChart.setBackgroundPaint(bg);
		lineChart.getTitle().setPaint(fg);
		lineChart.removeLegend();
		CategoryPlot plot = lineChart.getCategoryPlot();
		plot.setBackgroundPaint(bg);
		plot.setOutlineVisible(false);
		// X-Axis (Domain Axis) customization
		plot.getDomainAxis().setAxisLinePaint(fg);
		plot.getDomainAxis().setTickLabelPaint(fg);
		plot.getDomainAxis().setLabelPaint(fg);

		// Y-Axis (Range Axis) customization
		plot.getRangeAxis().setAxisLinePaint(fg);
		plot.getRangeAxis().setTickLabelPaint(fg);
		plot.getRangeAxis().setLabelPaint(fg);

		// Customize the line and point rendering
		/* get max and min */
		int maximo = 0;
		if (values.size() > 0) {
			if (values.get(0) != null)
				maximo = values.get(0);
			for (int i = 1; i < values.size(); i++) {
				if (values.get(i) != null && values.get(i) > maximo) {
					maximo = values.get(i);
				}
			}
		}
		int minimo = maximo;
		if (values.size() > 0) {
			if (values.get(0) != null)
				minimo = values.get(0);
			for (int i = 1; i < values.size(); i++) {
				if (values.get(i) != null && values.get(i) < minimo) {
					minimo = values.get(i);
				}
			}
		}
		/* the line average */
		double total = 0, nbOfDays = 0;
		for (int i = 0; i < values.size(); i++) {
			if (values.get(i) != null) {
				total += values.get(i).doubleValue();
				nbOfDays++;
			}
		}
		double average = nbOfDays == 0 ? 0 : total / nbOfDays;
		// Add average line
		ValueMarker averageMarker = new ValueMarker(average);
		averageMarker.setPaint(colorSelected == 2 ? Intro.blackM : skyblueC);
		averageMarker.setStroke(new BasicStroke(2.0f));
		averageMarker.setLabel("$ " + String.format("%.2f", average)); // Format the average
		averageMarker.setLabelAnchor(RectangleAnchor.BOTTOM_RIGHT); // Position the label
		averageMarker.setLabelTextAnchor(TextAnchor.BOTTOM_RIGHT);
		averageMarker.setLabelPaint(Color.black);
		averageMarker.setLabelBackgroundColor(Color.white);
		plot.addRangeMarker(averageMarker);
		CustomLineAndShapeRenderer renderer = new CustomLineAndShapeRenderer(maximo, minimo);
		renderer.setSeriesPaint(0, fg);
		renderer.setDefaultToolTipGenerator(new CategoryToolTipGenerator() {
			@Override
			public String generateToolTip(org.jfree.data.category.CategoryDataset dataset, int row, int column) {
				String day = dataset.getColumnKey(column).toString();
				String dayN = dayName(new DateModified(Integer.valueOf(day), month, currentDate.y), langIndex);
				Number value = dataset.getValue(row, column);
				return (dayN + " " + day + " -> " + "$ " + value.toString());
			}
		});
		plot.setRenderer(renderer);

		return lineChart;
	}

	/* Frame to show the monthly graph */
	private void yearGraph(int year) {
		JDialog frame = new JDialog(this, getLocalizedMessage("GRAPH") + " " + year, true);
		overlay.showOverlay();

		JFreeChart lineChart = yearChart(year);

		// Create and display the panel
		ChartPanel chartPanel = new ChartPanel(lineChart);
		chartPanel.setPreferredSize(new Dimension(getWidth() * 3 / 4, getHeight() * 3 / 4));

		// Create a JPanel to hold both the chart and the custom legend
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		// Add the chart to the center of the panel
		panel.add(chartPanel, BorderLayout.CENTER);

		// Create a JLabel for the custom legend
		String legend = "<html><head><style> body {color" + (colorSelected == 2 ? ": black;" : ": white;")
				+ "} </style></head>" + getLocalizedMessage("LEGEND") + "<br></html>";
		JLabel customLegend = new JLabel(legend);
		customLegend.setOpaque(true);
		customLegend.setBackground(bg);
		customLegend.setHorizontalAlignment(SwingConstants.CENTER); // Center the legend text
		customLegend.setFont(new Font("Arial", Font.PLAIN, 12)); // Set font for the legend

		// Add the custom legend below the chart
		panel.add(customLegend, BorderLayout.SOUTH);

		// Menubar
		JMenuBar menu = new JMenuBar();
		JMenu file = new JMenu(getLocalizedMessage("FILE"));
		JMenu save = new JMenu(getLocalizedMessage("SAVE"));
		JMenuItem exit = new JMenuItem(getLocalizedMessage("EXIT"));
		JMenuItem saveAsPng = new JMenuItem("PNG");
		JMenuItem saveAsPdf = new JMenuItem("PDF");
		JMenuItem saveAsSvg = new JMenuItem("SVG");
		saveAsPng.setIcon(colorSelected == 2 ? ImageEffect.getScaledImage(pngI.getImage(), 35, 35)
				: ImageEffect.invertColor(ImageEffect.getScaledImage(pngI.getImage(), 35, 35)));
		saveAsPdf.setIcon(colorSelected == 2 ? ImageEffect.getScaledImage(pdfI.getImage(), 35, 35)
				: ImageEffect.invertColor(ImageEffect.getScaledImage(pdfI.getImage(), 35, 35)));
		saveAsSvg.setIcon(colorSelected == 2 ? ImageEffect.getScaledImage(svgI.getImage(), 35, 35)
				: ImageEffect.invertColor(ImageEffect.getScaledImage(svgI.getImage(), 35, 35)));
		save.setIcon(colorSelected == 2 ? ImageEffect.getScaledImage(saveI.getImage(), 35, 35)
				: ImageEffect.invertColor(ImageEffect.getScaledImage(saveI.getImage(), 35, 35)));
		exit.setIcon(colorSelected == 2 ? ImageEffect.getScaledImage(exitI.getImage(), 35, 35)
				: ImageEffect.invertColor(ImageEffect.getScaledImage(exitI.getImage(), 35, 35)));
		chartPanel.setPopupMenu(null);
		saveAsPng.addActionListener(_ -> saveChartByExt(lineChart, "png"));
		saveAsPdf.addActionListener(_ -> saveChartByExt(lineChart, "pdf"));
		saveAsSvg.addActionListener(_ -> saveChartByExt(lineChart, "svg"));
		exit.addActionListener(_ -> {
			frame.dispose();
			overlay.hideOverlay();
		});

		file.add(save);
		save.add(saveAsPng);
		save.add(saveAsPdf);
		save.add(saveAsSvg);
		file.add(exit);
		menu.add(file);

		// Add ESC key listener to close the frame
		InputMap inputMap = frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap = frame.getRootPane().getActionMap();
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "closeDialog");
		actionMap.put("closeDialog", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				overlay.hideOverlay();
			}
		});
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				overlay.hideOverlay();
			}
		});
		// Set focus on the frame to make sure key events are captured
		frame.setFocusable(true);
		frame.requestFocusInWindow();

		frame.setJMenuBar(menu);
		frame.getContentPane().add(panel); // Add the panel to the frame
		frame.setIconImage(colorSelected == 2 ? ImageEffect.getScaledImage(yearI.getImage(), 35, 35).getImage()
				: ImageEffect.invertColor(ImageEffect.getScaledImage(yearI.getImage(), 35, 35)).getImage());
		frame.pack();
		frame.setLocationRelativeTo(null);

		frame.setVisible(true);
	}

	/* Return the chart of month */
	private JFreeChart yearChart(int year) {
		/* The values of the month */
		int averageM[] = null, newAvg[] = null;
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		if (year != currentDate.y) {
			averageM = new int[12];
			newAvg = new int[12];
			for (int i = 0; i < 12; i++) {
				averageM[i] = DataCalc.totalOfMes(i + 1, year)[1] == 0 ? 0
						: DataCalc.totalOfMes(i + 1, year)[0] / DataCalc.totalOfMes(i + 1, year)[1];
				dataset.addValue(averageM[i] == 0 ? null : averageM[i], getLocalizedMessage("SELL"),
						TextEffect.getFirstThreeLetters(getMonthForInt(i, langIndex)) + "(" + (i + 1) + ")");
			}
		} else {
			averageM = new int[currentDate.m];
			newAvg = new int[currentDate.m];
			for (int i = 0; i < currentDate.m; i++)
				averageM[i] = DataCalc.totalOfMes(i + 1, currentDate.y)[1] == 0 ? 0
						: DataCalc.totalOfMes(i + 1, currentDate.y)[0] / DataCalc.totalOfMes(i + 1, currentDate.y)[1];
			for (int index = 0; index < averageM.length; index++) {
				dataset.addValue(averageM[index], getLocalizedMessage("SELL"),
						TextEffect.getFirstThreeLetters(getMonthForInt(index, langIndex)) + "(" + (index + 1) + ")");
			}
		}
		double total = 0;
		for (int i = 0; i < averageM.length; i++) {
			total += averageM[i];
		}
		double average = total / averageM.length;
		for (int i = 0; i < averageM.length; i++)
			newAvg[i] = (int) (averageM[i] == 0 ? average : averageM[i]);
		/* get max and min */
		int maximo = DataCalc.getMaxValue(newAvg)[0];
		int minimo = DataCalc.getMinValue(newAvg)[0];
		// Create the chart
		JFreeChart lineChart = ChartFactory.createLineChart(year + "", getLocalizedMessage("MONTH"),
				getLocalizedMessage("SELL"), dataset);

		// Customize chart background color
		lineChart.setBackgroundPaint(bg);
		lineChart.getTitle().setPaint(Intro.lightC);
		lineChart.removeLegend();
		CategoryPlot plot = lineChart.getCategoryPlot();
		plot.setBackgroundPaint(bg);
		plot.setOutlineVisible(false);
		// X-Axis (Domain Axis) customization
		plot.getDomainAxis().setAxisLinePaint(fg);
		plot.getDomainAxis().setTickLabelPaint(fg);
		plot.getDomainAxis().setLabelPaint(fg);

		// Y-Axis (Range Axis) customization
		plot.getRangeAxis().setAxisLinePaint(fg);
		plot.getRangeAxis().setTickLabelPaint(fg);
		plot.getRangeAxis().setLabelPaint(fg);

		// Customize the line and point rendering
		/* the line average */
		ValueMarker averageMarker = new ValueMarker(average);
		averageMarker.setPaint(colorSelected == 2 ? Intro.blackM : skyblueC);
		averageMarker.setStroke(new BasicStroke(2.0f));
		averageMarker.setLabel("$ " + String.format("%.2f", average)); // Format the average
		averageMarker.setLabelAnchor(RectangleAnchor.BOTTOM_RIGHT); // Position the label
		averageMarker.setLabelTextAnchor(TextAnchor.BOTTOM_RIGHT);
		averageMarker.setLabelPaint(Color.black);
		averageMarker.setLabelBackgroundColor(Color.white);
		plot.addRangeMarker(averageMarker);
		CustomLineAndShapeRenderer renderer = new CustomLineAndShapeRenderer(maximo, minimo);
		renderer.setSeriesPaint(0, fg);
		renderer.setDefaultToolTipGenerator(new CategoryToolTipGenerator() {
			@Override
			public String generateToolTip(org.jfree.data.category.CategoryDataset dataset, int row, int column) {
				Number value = dataset.getValue(row, column);
				String month = dataset.getColumnKey(column).toString();
				return (month + " -> " + "$ " + value.toString());
			}
		});
		plot.setRenderer(renderer);

		return lineChart;
	}

	/* Frame to show the monthly graph */
	private void diffYearsGraph() {
		JDialog frame = new JDialog(this, getLocalizedMessage("GRAPH"), true);
		overlay.showOverlay();

		JFreeChart lineChart = diffYearChart();

		// Create and display the panel
		ChartPanel chartPanel = new ChartPanel(lineChart);
		chartPanel.setPreferredSize(new Dimension(getWidth() * 3 / 4, getHeight() * 3 / 4));

		// Create a JPanel to hold both the chart and the custom legend
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		// Add the chart to the center of the panel
		panel.add(chartPanel, BorderLayout.CENTER);

		// Create a JLabel for the custom legend
		String legend = "<html><head><style> body {color" + (colorSelected == 2 ? ": black;" : ": white;")
				+ "} </style></head>" + getLocalizedMessage("LEGEND") + "<br></html>";
		JLabel customLegend = new JLabel(legend);
		customLegend.setOpaque(true);
		customLegend.setBackground(bg);
		customLegend.setHorizontalAlignment(SwingConstants.CENTER); // Center the legend text
		customLegend.setFont(new Font("Arial", Font.PLAIN, 12)); // Set font for the legend

		// Add the custom legend below the chart
		panel.add(customLegend, BorderLayout.SOUTH);

		// Create the popup menu
		chartPanel.setPopupMenu(null);
		JPopupMenu popupMenu = new JPopupMenu();
		JMenu save = new JMenu(getLocalizedMessage("SAVE"));
		JMenuItem exit = new JMenuItem(getLocalizedMessage("EXIT"));
		JMenuItem saveAsPng = new JMenuItem("PNG");
		JMenuItem saveAsPdf = new JMenuItem("PDF");
		JMenuItem saveAsSvg = new JMenuItem("SVG");
		saveAsPng.addActionListener(_ -> saveChartByExt(lineChart, "png"));
		saveAsPdf.addActionListener(_ -> saveChartByExt(lineChart, "pdf"));
		saveAsSvg.addActionListener(_ -> saveChartByExt(lineChart, "svg"));
		save.add(saveAsPng);
		save.add(saveAsPdf);
		save.add(saveAsSvg);
		popupMenu.add(save);
		exit.addActionListener(_ -> {
			frame.dispose();
			overlay.hideOverlay();
		});
		popupMenu.add(exit);

		// Add MouseListener to show popup menu
		chartPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					popupMenu.show(chartPanel, e.getX(), e.getY());
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					popupMenu.show(chartPanel, e.getX(), e.getY());
				}
			}
		});

		// Add ESC key listener to close the frame
		InputMap inputMap = frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap = frame.getRootPane().getActionMap();
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "closeDialog");
		actionMap.put("closeDialog", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				overlay.hideOverlay();
			}
		});
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				overlay.hideOverlay();
			}
		});
		// Set focus on the frame to make sure key events are captured
		frame.setFocusable(true);
		frame.requestFocusInWindow();

		frame.getContentPane().add(panel); // Add the panel to the frame
		frame.setIconImage(colorSelected == 2 ? ImageEffect.getScaledImage(yearI.getImage(), 35, 35).getImage()
				: ImageEffect.invertColor(ImageEffect.getScaledImage(yearI.getImage(), 35, 35)).getImage());
		frame.pack();
		frame.setLocationRelativeTo(null);

		frame.setVisible(true);
	}

	/* Return the chart of month */
	private JFreeChart diffYearChart() {
		/* The values of the month */
		int averageMLY4[] = new int[currentDate.m];
		if (conLY4.size() > 0)
			for (int i = 0; i < currentDate.m; i++)
				averageMLY4[i] = DataCalc.totalOfMes(i + 1, currentDate.y - 4)[1] == 0 ? 0
						: DataCalc.totalOfMes(i + 1, currentDate.y - 4)[0]
								/ DataCalc.totalOfMes(i + 1, currentDate.y - 4)[1];

		int averageMLY3[] = new int[currentDate.m];
		if (conLY3.size() > 0)
			for (int i = 0; i < currentDate.m; i++)
				averageMLY3[i] = DataCalc.totalOfMes(i + 1, currentDate.y - 3)[1] == 0 ? 0
						: DataCalc.totalOfMes(i + 1, currentDate.y - 3)[0]
								/ DataCalc.totalOfMes(i + 1, currentDate.y - 3)[1];

		int averageMLY2[] = new int[currentDate.m];
		if (conLY2.size() > 0)
			for (int i = 0; i < currentDate.m; i++)
				averageMLY2[i] = DataCalc.totalOfMes(i + 1, currentDate.y - 2)[1] == 0 ? 0
						: DataCalc.totalOfMes(i + 1, currentDate.y - 2)[0]
								/ DataCalc.totalOfMes(i + 1, currentDate.y - 2)[1];

		int averageMLY[] = new int[currentDate.m];
		if (conLY.size() > 0)
			for (int i = 0; i < currentDate.m; i++)
				averageMLY[i] = DataCalc.totalOfMes(i + 1, currentDate.y - 1)[1] == 0 ? 0
						: DataCalc.totalOfMes(i + 1, currentDate.y - 1)[0]
								/ DataCalc.totalOfMes(i + 1, currentDate.y - 1)[1];

		int averageM[] = new int[currentDate.m];
		for (int i = 0; i < currentDate.m; i++)
			averageM[i] = DataCalc.totalOfMes(i + 1, currentDate.y)[1] == 0 ? 0
					: DataCalc.totalOfMes(i + 1, currentDate.y)[0] / DataCalc.totalOfMes(i + 1, currentDate.y)[1];

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (int index = 0; index < averageM.length; index++) {
			if (conLY4.size() > 0)
				dataset.addValue(averageMLY4[index] == 0 ? null : averageMLY4[index], "" + (currentDate.y - 4),
						TextEffect.getFirstThreeLetters(getMonthForInt((index + 1) - 1, langIndex)) + "(" + (index + 1)
								+ ")");
			if (conLY3.size() > 0)
				dataset.addValue(averageMLY3[index] == 0 ? null : averageMLY3[index], "" + (currentDate.y - 3),
						TextEffect.getFirstThreeLetters(getMonthForInt((index + 1) - 1, langIndex)) + "(" + (index + 1)
								+ ")");
			if (conLY2.size() > 0)
				dataset.addValue(averageMLY2[index] == 0 ? null : averageMLY2[index], "" + (currentDate.y - 2),
						TextEffect.getFirstThreeLetters(getMonthForInt((index + 1) - 1, langIndex)) + "(" + (index + 1)
								+ ")");
			if (conLY.size() > 0)
				dataset.addValue(averageMLY[index] == 0 ? null : averageMLY[index], "" + (currentDate.y - 1),
						TextEffect.getFirstThreeLetters(getMonthForInt((index + 1) - 1, langIndex)) + "(" + (index + 1)
								+ ")");
			dataset.addValue(averageM[index] == 0 ? null : averageM[index], yearS,
					TextEffect.getFirstThreeLetters(getMonthForInt((index + 1) - 1, langIndex)) + "(" + (index + 1)
							+ ")");
		}

		// Create the chart
		JFreeChart lineChart = ChartFactory.createLineChart("ALL YEARS", getLocalizedMessage("MONTH"),
				getLocalizedMessage("SELL"), dataset);

		// Customize chart background color
		lineChart.setBackgroundPaint(bg);
		lineChart.getTitle().setPaint(bg);
		CategoryPlot plot = lineChart.getCategoryPlot();
		plot.setBackgroundPaint(bg);
		plot.setOutlineVisible(false);
		// X-Axis (Domain Axis) customization
		plot.getDomainAxis().setAxisLinePaint(fg);
		plot.getDomainAxis().setTickLabelPaint(fg);
		plot.getDomainAxis().setLabelPaint(fg);

		// Y-Axis (Range Axis) customization
		plot.getRangeAxis().setAxisLinePaint(fg);
		plot.getRangeAxis().setTickLabelPaint(fg);
		plot.getRangeAxis().setLabelPaint(fg);

		// Customize the line and point rendering
		LineAndShapeRenderer renderer = new LineAndShapeRenderer();
		Color[] seriesColors = { turqC, Intro.blueC, Intro.greenC, Intro.redC, Intro.grisD };
		for (int i = 0; i < seriesColors.length; i++) {
			renderer.setSeriesPaint(i, seriesColors[i]);
			renderer.setSeriesShapesVisible(i, true);
			renderer.setSeriesStroke(i, new BasicStroke(2.0f));
		}
		// Custom tooltip generator to remove "Sales" from the tooltip
		renderer.setDefaultToolTipGenerator(new CategoryToolTipGenerator() {
			@Override
			public String generateToolTip(org.jfree.data.category.CategoryDataset dataset, int row, int column) {
				String day = dataset.getColumnKey(column).toString();
				String year = dataset.getRowKey(row).toString();
				Number value = dataset.getValue(row, column);
				return (day + " " + year + " -> $ " + value.toString());
			}
		});
		plot.setRenderer(renderer);

		return lineChart;
	}

	/* Summary for the previous year */
	private void oldYearSumm(int year) {
		JDialog extraF = new JDialog(this, getLocalizedMessage("YEAR_SUMM"), true);
		extraF.setSize(700, 600);
		extraF.setLocationRelativeTo(null);
		extraF.setResizable(false);
		extraF.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		// Center horizontally and vertically
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		extraF.getContentPane().setBackground(bg);
		overlay.showOverlay();

		// Menubar
		JMenuBar menu = new JMenuBar();
		JMenu file = new JMenu(getLocalizedMessage("FILE"));
		JMenuItem save = new JMenuItem(getLocalizedMessage("SAVE"));
		JMenuItem exit = new JMenuItem(getLocalizedMessage("EXIT"));
		save.setIcon(colorSelected == 2 ? ImageEffect.getScaledImage(saveI.getImage(), 35, 35)
				: ImageEffect.invertColor(ImageEffect.getScaledImage(saveI.getImage(), 35, 35)));
		exit.setIcon(colorSelected == 2 ? ImageEffect.getScaledImage(exitI.getImage(), 35, 35)
				: ImageEffect.invertColor(ImageEffect.getScaledImage(exitI.getImage(), 35, 35)));
		exit.addActionListener(_ -> {
			extraF.dispose();
			overlay.hideOverlay();
		});
		file.add(save);
		file.add(exit);
		menu.add(file);
		extraF.setJMenuBar(menu);

		// LABEL
		JTextPane sumItem = new JTextPane();
		StyledDocument doc = sumItem.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		sumItem.setFont(new Font("Tahoma", Font.BOLD, 18));
		sumItem.setEditable(false);
		sumItem.setCaret(null);
		sumItem.setOpaque(false);
		Color fadeColor = colorSelected == 2 ? new Color(0, 0, 0, 255) : new Color(255, 255, 255, 255);
		sumItem.setForeground(fadeColor);
		int temp[] = DataCalc.yearMaxMin(year);
		DateModified newDate = new DateModified(1, 1, year);
		int maxDIndex = newDate.dayFromIndex(temp[2]);
		String maxDayString = dayName(new DateModified(maxDIndex, DataCalc.monthFromIndex(temp[2]), year), langIndex);
		int minDIndex = newDate.dayFromIndex(temp[3]);
		String minDayString = dayName(new DateModified(minDIndex, DataCalc.monthFromIndex(temp[3]), year), langIndex);
		String[] avgOfMonths = DataCalc.monthsText(Integer.valueOf(currentDate.m), year, langIndex);
		int daysAvg[] = new int[7];
		double daysPerc[] = new double[7];
		int minmaxV[][] = new int[7][2];
		// Min and max according the day
		minmaxV[0] = DataCalc.maxAccDay("monday", year);
		minmaxV[1] = DataCalc.maxAccDay("tuesday", year);
		minmaxV[2] = DataCalc.maxAccDay("wednesday", year);
		minmaxV[3] = DataCalc.maxAccDay("thursday", year);
		minmaxV[4] = DataCalc.maxAccDay("friday", year);
		minmaxV[5] = DataCalc.maxAccDay("saturday", year);
		minmaxV[6] = DataCalc.maxAccDay("sunday", year);
		// days avg
		daysAvg[0] = DataCalc.avgSpeDay("monday", year);
		daysAvg[1] = DataCalc.avgSpeDay("tuesday", year);
		daysAvg[2] = DataCalc.avgSpeDay("Wednesday", year);
		daysAvg[3] = DataCalc.avgSpeDay("thursday", year);
		daysAvg[4] = DataCalc.avgSpeDay("friday", year);
		daysAvg[5] = DataCalc.avgSpeDay("saturday", year);
		daysAvg[6] = DataCalc.avgSpeDay("sunday", year);
		for (int i = 0; i < 7; i++) {
			daysPerc[i] = (double) daysAvg[i] * 100
					/ (daysAvg[0] + daysAvg[1] + daysAvg[2] + daysAvg[3] + daysAvg[4] + daysAvg[5] + daysAvg[6]);
			daysPerc[i] = Math.round(daysPerc[i] * 100);
			daysPerc[i] = daysPerc[i] / 100;
		}
		/* Max and Min Counter */
		int maxCounter = temp[4];
		int minCounter = temp[5];
		/* Max and Min Counter */

		sumItem.addKeyListener(new KeyAdapter() {// Escape to close
			@Override
			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
					colorX = 0;
					order = 0;
					wordL = 0;
					timer.stop();
					overlay.hideOverlay();
					extraF.dispose();
				}
			}
		});
		// TIMER
		order = 0;
		wordL = 0;
		colorX = 0;
		status = true;
		String[] espSumm = { "I. EXTREMOS DEL AÑO", (maxCounter > 1
				? "LA MEJOR VENTA POR DIA DEL AÑO\n\nPASÓ " + maxCounter + " VECES Y ESO ES $" + temp[0]
				: "EL MEJOR DÍA DE ESTE AÑO ES " + maxDayString + " " + maxDIndex + "-"
						+ getMonthForInt(DataCalc.monthFromIndex(temp[2]) - 1, 0) + "\n\nLO QUE VENDIMOS $" + temp[0])
				+ "\n\n\n"
				+ (minCounter > 1
						? "LA PEOR VENTA POR DIA DEL AÑO\n\nPASÓ " + minCounter + " VECES Y ESO ES $" + temp[1]
						: "EL PEOR DÍA DE ESTE AÑO ES " + minDayString + " " + minDIndex + "-"
								+ getMonthForInt(DataCalc.monthFromIndex(temp[3]) - 1, 0) + "\n\nLO QUE VENDIMOS $"
								+ temp[1]), // 1
				"II. DIFERENCIA CON MESES ANTERIORES",
				avgOfMonths[0] + "\n" + avgOfMonths[1] + "\n" + avgOfMonths[2] + "\n" + avgOfMonths[3] + "\n"
						+ avgOfMonths[4] + "\n" + avgOfMonths[5], // 2
				"\n" + avgOfMonths[6] + "\n" + avgOfMonths[7] + "\n" + avgOfMonths[8] + "\n" + avgOfMonths[9] + "\n"
						+ avgOfMonths[10] + "\n" + avgOfMonths[11], // 3 months
				"III. EXTREMOS DEL MES",
				"EL MEJOR MES DEL AÑO FUE " + getMonthForInt(Integer.valueOf(avgOfMonths[14]), 0) + "\n\n"
						+ "LO QUE VENDIMOS UN PROMEDIO DE $" + avgOfMonths[12] + "\n\n\n" + "EL PEOR MES DEL AÑO FUE "
						+ getMonthForInt(Integer.valueOf(avgOfMonths[15]), 0) + "\n\n"
						+ "LO QUE VENDIMOS UN PROMEDIO DE $" + avgOfMonths[13], // 4 MAX AND MIN FOR THE MONTH
				"IV. LA MEDIA SEGÚN EL DÍA SON",
				"LUNES -> $" + daysAvg[0] + " (%" + daysPerc[0] + ")\n\nMARTES -> $" + daysAvg[1] + " (%" + daysPerc[1]
						+ ")\n\nMIÉRCOLES -> $" + daysAvg[2] + " (%" + daysPerc[2] + ")\n\nJUEVES -> $" + daysAvg[3]
						+ " (%" + daysPerc[3] + ")\n\nVIERNES -> $" + daysAvg[4] + " (%" + daysPerc[4]
						+ ")\n\nSÁBADO -> $" + daysAvg[5] + " (%" + daysPerc[5] + ")\n\nDOMINGO -> $" + daysAvg[6]
						+ " (%" + daysPerc[6] + ")", // 5
				"V. EL MÍNIMO Y MÁXIMO SEGÚN EL DÍA",
				"LUNES -> MAX: $" + minmaxV[0][0] + ", MIN: $" + minmaxV[0][1] + "\n\nMARTES -> MAX: $" + minmaxV[1][0]
						+ ", MIN: $" + minmaxV[1][1] + "\n\nMIÉRCOLES -> MAX: $" + minmaxV[2][0] + ", MIN: $"
						+ minmaxV[2][1] + "\n\nJUEVES -> MAX: $" + minmaxV[3][0] + ", MIN: $" + minmaxV[3][1]
						+ "\n\nVIERNES -> MAX: $" + minmaxV[4][0] + ", MIN: $" + minmaxV[4][1] + "\n\nSÁBADO -> MAX: $"
						+ minmaxV[5][0] + ", MIN: $" + minmaxV[5][1] + "\n\nDOMINGO -> MAX: $" + minmaxV[6][0]
						+ ", MIN: $" + minmaxV[6][1], // 6
		};
		String[] porSumm = { "I. EXTREMOS DO ANO", (maxCounter > 1
				? "A MELHOR PROMOÇÃO POR DIA DO ANO\n\nPASSOU " + maxCounter + " VEZES E ISSO É $" + temp[0]
				: "O MELHOR DIA DESTE ANO É " + maxDayString + " " + maxDIndex + "-"
						+ getMonthForInt(DataCalc.monthFromIndex(temp[2]) - 1, 1) + "\n\nO QUE VENDEMOS $" + temp[0])
				+ "\n\n\n"
				+ (minCounter > 1
						? "A PIOR VENDA POR DIA DO ANO\n\nPASSOU " + minCounter + " VEZES E ISSO É $" + temp[1]
						: "O PIOR DIA DO ANO É " + minDayString + " " + minDIndex + "-"
								+ getMonthForInt(DataCalc.monthFromIndex(temp[3]) - 1, 1) + "\n\nO QUE VENDEMOS $"
								+ temp[1]), // 1
				"II. DIFERENÇA DOS MESES ANTERIORES",
				avgOfMonths[0] + "\n" + avgOfMonths[1] + "\n" + avgOfMonths[2] + "\n" + avgOfMonths[3] + "\n"
						+ avgOfMonths[4] + "\n" + avgOfMonths[5], // 2
				avgOfMonths[6] + "\n" + avgOfMonths[7] + "\n" + avgOfMonths[8] + "\n" + avgOfMonths[9] + "\n"
						+ avgOfMonths[10] + "\n" + avgOfMonths[11], // 3
				"III. EXTREMOS DO MÊS",
				"O MELHOR MÊS DO ANO FOI " + getMonthForInt(Integer.valueOf(avgOfMonths[14]), 1) + "\n\n"
						+ "O QUE VENDEMOS EM MÉDIA $" + avgOfMonths[12] + "\n\n\n" + "O PIOR MÊS DO ANO FOI "
						+ getMonthForInt(Integer.valueOf(avgOfMonths[15]), 1) + "\n\n" + "O QUE VENDEMOS EM MÉDIA $"
						+ avgOfMonths[13], // 4 MAX AND MIN FOR THE MONTH
				"IV. A MÉDIA DE ACORDO COM O DIA SÃO",
				"SEGUNDA-FEIRA -> $" + daysAvg[0] + " (%" + daysPerc[0] + ")\n\nTERÇA-FEIRA -> $" + daysAvg[1] + " (%"
						+ daysPerc[1] + ")\n\nQUARTA-FEIRA -> $" + daysAvg[2] + " (%" + daysPerc[2]
						+ ")\n\nQUINTA-FEIRA -> $" + daysAvg[3] + " (%" + daysPerc[3] + ")\n\nSEXTA-FEIRA -> $"
						+ daysAvg[4] + " (%" + daysPerc[4] + ")\n\nSÁBADO -> $" + daysAvg[5] + " (%" + daysPerc[5]
						+ ")\n\nDOMINGO -> $" + daysAvg[6] + " (%" + daysPerc[6] + ")", // 5
				"V. O MÍNIMO E MÁXIMO DE ACORDO COM O DIA",
				"SEGUNDA-FEIRA -> MAX: $" + minmaxV[0][0] + ", MIN: $" + minmaxV[0][1] + "\n\nTERÇA-FEIRA -> MAX: $"
						+ minmaxV[1][0] + ", MIN: $" + minmaxV[1][1] + "\n\nQUARTA-FEIRA -> MAX: $" + minmaxV[2][0]
						+ ", MIN: $" + minmaxV[2][1] + "\n\nQUINTA-FEIRA -> MAX: $" + minmaxV[3][0] + ", MIN: $"
						+ minmaxV[3][1] + "\n\nSEXTA-FEIRA -> MAX: $" + minmaxV[4][0] + ", MIN: $" + minmaxV[4][1]
						+ "\n\nSÁBADO -> MAX: $" + minmaxV[5][0] + ", MIN: $" + minmaxV[5][1] + "\n\nDOMINGO -> MAX: $"
						+ minmaxV[6][0] + ", MIN: $" + minmaxV[6][1], // 6
		};
		String[] engSumm = { "I. EXTREMES OF THE YEAR", (maxCounter > 1
				? "THE BEST SELL PER DAY OF THE YEAR\n\nHAPPENED " + maxCounter + " TIMES AND IT'S $" + temp[0]
				: "THE BEST DAY OF THIS YEAR IS " + maxDayString + " " + maxDIndex + "-"
						+ getMonthForInt(DataCalc.monthFromIndex(temp[2]) - 1, 2) + "\n\nWHAT WE SOLD $" + temp[0])
				+ "\n\n\n"
				+ (minCounter > 1
						? "THE WORSRT SELL PER DAY OF THE YEAR\n\nHAPPENED " + minCounter + " TIMES AND IT'S $"
								+ temp[1]
						: "THE WORST DAY OF THIS YEAR IS " + minDayString + " " + minDIndex + "-"
								+ getMonthForInt(DataCalc.monthFromIndex(temp[3]) - 1, 2) + "\n\nWHAT WE SOLD $"
								+ temp[1]), // 1
				"II. DIFFERENCE FROM PREVIOUS MONTHS",
				avgOfMonths[0] + "\n" + avgOfMonths[1] + "\n" + avgOfMonths[2] + "\n" + avgOfMonths[3] + "\n"
						+ avgOfMonths[4] + "\n" + avgOfMonths[5], // 2
				avgOfMonths[6] + "\n" + avgOfMonths[7] + "\n" + avgOfMonths[8] + "\n" + avgOfMonths[9] + "\n"
						+ avgOfMonths[10] + "\n" + avgOfMonths[11], // 3
				"III. EXTREMES OF THE MONTH",
				"THE BEST MONTH OF THE YEAR WAS " + getMonthForInt(Integer.valueOf(avgOfMonths[14]), 2) + "\n\n"
						+ "WHAT WE SOLD AN AVERAGE OF $" + avgOfMonths[12] + "\n\n\n"
						+ "THE WORST MONTH OF THE YEAR WAS " + getMonthForInt(Integer.valueOf(avgOfMonths[15]), 2)
						+ "\n\n" + "WHAT WE SOLD AN AVERAGE OF $" + avgOfMonths[13], // 4 MAX AND MIN FOR THE MONTH
				"IV. THE AVERAGE ACCORDING TO THE DAY ARE",
				"MONDAY -> $" + daysAvg[0] + " (%" + daysPerc[0] + ")\n\nTUESDAY -> $" + daysAvg[1] + " (%"
						+ daysPerc[1] + ")\n\nWEDNESDAY -> $" + daysAvg[2] + " (%" + daysPerc[2] + ")\n\nTHURSDAY -> $"
						+ daysAvg[3] + " (%" + daysPerc[3] + ")\n\nFRIDAY -> $" + daysAvg[4] + " (%" + daysPerc[4]
						+ ")\n\nSATURDAY -> $" + daysAvg[5] + " (%" + daysPerc[5] + ")\n\nSUNDAY -> $" + daysAvg[6]
						+ " (%" + daysPerc[6] + ")", // 5
				"V. THE MINIMUM AND MAXIMUM ACCORDING THE DAY",
				"MONDAY -> MAX: $" + minmaxV[0][0] + ", MIN: $" + minmaxV[0][1] + "\n\nTUESDAY -> MAX: $"
						+ minmaxV[1][0] + ", MIN: $" + minmaxV[1][1] + "\n\nWEDNESDAY -> MAX: $" + minmaxV[2][0]
						+ ", MIN: $" + minmaxV[2][1] + "\n\nTHURSDAY -> MAX: $" + minmaxV[3][0] + ", MIN: $"
						+ minmaxV[3][1] + "\n\nFRIDAY -> MAX: $" + minmaxV[4][0] + ", MIN: $" + minmaxV[4][1]
						+ "\n\nSATURDAY -> MAX: $" + minmaxV[5][0] + ", MIN: $" + minmaxV[5][1] + "\n\nSUNDAY -> MAX: $"
						+ minmaxV[6][0] + ", MIN: $" + minmaxV[6][1], // 6
		};
		String[] frSumm = { "I. EXTREMES DE L'ANNÉE", (maxCounter > 1
				? "LA MEILLEURE VENTE PAR JOUR DE L'ANNÉE\n\nPASSÉ  " + maxCounter + " FOIS ET C'EST $" + temp[0]
				: "LE MEILLEUR JOUR DE CETTE ANNÉE EST " + maxDayString + " " + maxDIndex + "-"
						+ getMonthForInt(DataCalc.monthFromIndex(temp[2]) - 1, 3) + "\n\nCE QUE NOUS AVONS VENDU $"
						+ temp[0])
				+ "\n\n\n"
				+ (minCounter > 1
						? "LA PIRE VENTE PAR JOUR DE L'ANNÉE\n\nPASSÉ " + minCounter + " FOIS ET C'EST $" + temp[1]
						: " LE PIRE JOUR DE CETTE ANNÉE EST " + minDayString + " " + minDIndex + "-"
								+ getMonthForInt(DataCalc.monthFromIndex(temp[3]) - 1, 3)
								+ "\n\nCE QUE NOUS AVONS VENDU $" + temp[1]), // 1
				"II. DIFFÉRENCE AVEC LES MOIS PRÉCÉDENTS",
				avgOfMonths[0] + "\n" + avgOfMonths[1] + "\n" + avgOfMonths[2] + "\n" + avgOfMonths[3] + "\n"
						+ avgOfMonths[4] + "\n" + avgOfMonths[5], // 2
				avgOfMonths[6] + "\n" + avgOfMonths[7] + "\n" + avgOfMonths[8] + "\n" + avgOfMonths[9] + "\n"
						+ avgOfMonths[10] + "\n" + avgOfMonths[11], // 3
				"III. EXTREMES DE MOIS",
				"LE MEILLEUR MOIS DE L'ANNÉE A ÉTÉ " + getMonthForInt(Integer.valueOf(avgOfMonths[14]), 3) + "\n\n"
						+ "CE QUE NOUS AVONS VENDU EN MOYENNE DE $" + avgOfMonths[12] + "\n\n\n"
						+ " LE PIRE MOIS DE L'ANNÉE A ÉTÉ " + getMonthForInt(Integer.valueOf(avgOfMonths[15]), 3)
						+ "\n\n" + "CE QUE NOUS AVONS VENDU EN MOYENNE DE $" + avgOfMonths[13], // 4 MAX ET MIN POUR LE
																								// MOIS
				"IV. LA MOYENNE SELON LE JOUR EST",
				"LUNDI -> $" + daysAvg[0] + " (%" + daysPerc[0] + ")\n\nMARDI -> $" + daysAvg[1] + " (%" + daysPerc[1]
						+ ")\n\nMERCREDI -> $" + daysAvg[2] + " (%" + daysPerc[2] + ")\n\nJEUDI -> $" + daysAvg[3]
						+ " (%" + daysPerc[3] + ")\n\nVENDREDI -> $" + daysAvg[4] + " (%" + daysPerc[4]
						+ ")\n\nSAMEDI -> $" + daysAvg[5] + " (%" + daysPerc[5] + ")\n\nDIMANCHE -> $" + daysAvg[6]
						+ " (%" + daysPerc[6] + ")", // 5
				"V. LE MINIMUM ET LE MAXIMUM SELON LE JOUR",
				"LUNDI -> MAX: $" + minmaxV[0][0] + ", MIN: $" + minmaxV[0][1] + "\n\nMARDI -> MAX: $" + minmaxV[1][0]
						+ ", MIN: $" + minmaxV[1][1] + "\n\nMERCREDI -> MAX: $" + minmaxV[2][0] + ", MIN: $"
						+ minmaxV[2][1] + "\n\nnJEUDI -> MAX: $" + minmaxV[3][0] + ", MIN: $" + minmaxV[3][1]
						+ "\n\nVENDREDI -> MAX: $" + minmaxV[4][0] + ", MIN: $" + minmaxV[4][1] + "\n\nSAMEDI -> MAX: $"
						+ minmaxV[5][0] + ", MIN: $" + minmaxV[5][1] + "\n\nDIMANCHE -> MAX: $" + minmaxV[6][0]
						+ ", MIN: $" + minmaxV[6][1], // 6
		};
		ActionListener letterByLetter = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (order >= espSumm.length) {
					timer.stop();
					return;
				}

				// Determine the text array based on the language and current order
				String currentText = (language == Language.SPANISH ? espSumm[order]
						: language == Language.PORTUGUES ? porSumm[order]
								: language == Language.ENGLISH ? engSumm[order] : frSumm[order]);

				// Convert the current text to a char array
				char[] wordT = currentText.toCharArray();

				// If text is empty and we're not at the last case, move to the next order
				if (wordT.length == 0 && order != 10) {
					order++;
					wordL = 0;
					sumItem.setText("");
					return;
				}

				// Handle typing the text letter by letter
				if (wordL < wordT.length) {
					sumItem.setText(sumItem.getText() + wordT[wordL++]);
				} else if (wordL < wordT.length + 15) {
					wordL++;
				} else {
					// When finished with the current order, move to the next one
					if (order != 10) {
						order++;
						wordL = 0;
						sumItem.setText("");
					} else {
						// Stop after the last case (case 12)
						timer.stop();
					}
				}
			}
		};
		ActionListener fadeTimer = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Select the appropriate text for the current language and order
				String[] summaries = { espSumm[order], porSumm[order], engSumm[order], frSumm[order] };
				String text = summaries[language.ordinal()];
				sumItem.setText(text);

				// Handle special case for order 6 (skip to next order if text is blank)
				if (order == 4 && sumItem.getText().isBlank()) {
					order++; // Move to the next order if the text is blank
					status = true; // Start fading in the next item
					return; // Skip the rest of the fade logic for case 6
				}

				// Set the fade color (black for dark mode, white for light mode)
				Color fadeColor = (colorSelected == 2) ? new Color(0, 0, 0, colorX) : new Color(255, 255, 255, colorX);
				sumItem.setForeground(fadeColor);

				if (status) {
					// Fade in
					if (colorX < 254) {
						colorX++; // Fade in
					} else {
						// When fully faded in, start fading out
						status = false;
					}
				} else {
					// Fade out
					if (colorX > 0 && order != 10) {
						colorX -= 2; // Fade out
					} else {
						// Once fully faded out, move to the next order
						if (order < 10) {
							order++; // Go to the next order
							status = true; // Start fading in again
						} else {
							timer.stop(); // Stop the timer after all orders are shown
						}
					}
				}
			}
		};
		ActionListener wordByWord = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				switch (order) {
				case 0: {
					String[] wordT = language == Language.SPANISH ? espSumm[0].split(" ")
							: language == Language.PORTUGUES ? porSumm[0].split(" ")
									: language == Language.ENGLISH ? engSumm[0].split(" ") : frSumm[0].split(" ");
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 1: {
					String[] wordT = language == Language.SPANISH ? espSumm[1].split(" ")
							: language == Language.PORTUGUES ? porSumm[1].split(" ")
									: language == Language.ENGLISH ? engSumm[1].split(" ") : frSumm[1].split(" ");
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 2: {// AVG FOR EACH DAY
					String[] wordT = language == Language.SPANISH ? espSumm[2].split(" ")
							: language == Language.PORTUGUES ? porSumm[2].split(" ")
									: language == Language.ENGLISH ? engSumm[2].split(" ") : frSumm[2].split(" ");
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							sumItem.setText("");
							wordL = 0;
						}
					}
					break;
				}
				case 3: {// AVG FOR EACH DAY
					String[] wordT = language == Language.SPANISH ? espSumm[3].split(" ")
							: language == Language.PORTUGUES ? porSumm[3].split(" ")
									: language == Language.ENGLISH ? engSumm[3].split(" ") : frSumm[3].split(" ");
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							sumItem.setText("");
							wordL = 0;
						}
					}
					break;
				}
				case 4: {// AVG FOR EACH DAY
					String[] wordT = language == Language.SPANISH ? espSumm[4].split(" ")
							: language == Language.PORTUGUES ? porSumm[4].split(" ")
									: language == Language.ENGLISH ? engSumm[4].split(" ") : frSumm[4].split(" ");
					if (wordT.length == 1) {
						order++;
						wordL = 0;
						sumItem.setText("");
					} else if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							sumItem.setText("");
							wordL = 0;
						}
					}
					break;
				}
				case 5: {
					String[] wordT = language == Language.SPANISH ? espSumm[5].split(" ")
							: language == Language.PORTUGUES ? porSumm[5].split(" ")
									: language == Language.ENGLISH ? engSumm[5].split(" ") : frSumm[5].split(" ");
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 6: {
					String[] wordT = language == Language.SPANISH ? espSumm[6].split(" ")
							: language == Language.PORTUGUES ? porSumm[6].split(" ")
									: language == Language.ENGLISH ? engSumm[6].split(" ") : frSumm[6].split(" ");
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 7: {
					String[] wordT = language == Language.SPANISH ? espSumm[7].split(" ")
							: language == Language.PORTUGUES ? porSumm[7].split(" ")
									: language == Language.ENGLISH ? engSumm[7].split(" ") : frSumm[7].split(" ");
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 8: {
					String[] wordT = language == Language.SPANISH ? espSumm[8].split(" ")
							: language == Language.PORTUGUES ? porSumm[8].split(" ")
									: language == Language.ENGLISH ? engSumm[8].split(" ") : frSumm[8].split(" ");
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 9: {
					String[] wordT = language == Language.SPANISH ? espSumm[9].split(" ")
							: language == Language.PORTUGUES ? porSumm[9].split(" ")
									: language == Language.ENGLISH ? engSumm[9].split(" ") : frSumm[9].split(" ");
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 10: {
					String[] wordT = language == Language.SPANISH ? espSumm[10].split(" ")
							: language == Language.PORTUGUES ? porSumm[10].split(" ")
									: language == Language.ENGLISH ? engSumm[10].split(" ") : frSumm[10].split(" ");
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						order++;
						timer.stop();
					}
					break;
				}
				default:
					wordL = 0;
					timer.stop();
					break;
				}
			}
		};
		ActionListener movingTB = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (order > 10) {
					wordL = 0;
					timer.stop();
					return;
				}
				String[] summaries = (language == Language.SPANISH ? espSumm
						: language == Language.PORTUGUES ? porSumm : language == Language.ENGLISH ? engSumm : frSumm);

				String originalText = summaries[order];
				if (originalText == null || originalText.isBlank()) {
					order++;
					return;
				}

				String scrambledText = TextEffect.scrambleText(originalText);
				sumItem.setText(scrambledText);
				wordL++;
				if (wordL >= 20) {
					sumItem.setText(originalText);
					if (wordL < 500) {
						wordL++;
					} else {
						order++;
						wordL = 0;
					}
				}

			}
		};

		if (effChooser == 0) {
			// Speed
			if (conf[6] == null || conf[6].equals("1"))
				speedValue = 15;
			else if (conf[6].equals("0"))
				speedValue = 20;
			else
				speedValue = 1;
			timer = new Timer(speedValue, fadeTimer);
		} else if (effChooser == 1) {
			// Speed
			if (conf[6] == null || conf[6].equals("1"))
				speedValue = 400;
			else if (conf[6].equals("0"))
				speedValue = 500;
			else
				speedValue = 300;
			timer = new Timer(speedValue, wordByWord);
		} else if (effChooser == 2) {
			// Speed
			if (conf[6] == null || conf[6].equals("1"))
				speedValue = 150;
			else if (conf[6].equals("0"))
				speedValue = 300;
			else
				speedValue = 50;
			timer = new Timer(speedValue, letterByLetter);
		} else {
			// Speed
			if (conf[6] == null || conf[6].equals("1"))
				speedValue = 15;
			else if (conf[6].equals("0"))
				speedValue = 20;
			else
				speedValue = 1;
			timer = new Timer(speedValue, movingTB);
		}
		timer.start();

		save.addActionListener(_ -> {
			JnaFileChooser fileChooser = new JnaFileChooser();
			fileChooser.setCurrentDirectory(currentpath);
			fileChooser.setTitle(getLocalizedMessage("SAVE"));
			fileChooser.setDefaultFileName("SAVE");
			fileChooser.addFilter("Text", "txt");
			if (fileChooser.showSaveDialog(extraF)) {
				File chartFile = fileChooser.getSelectedFile();
				if (!chartFile.getAbsolutePath().endsWith(".txt")) {
					chartFile = new File(chartFile + ".txt");
				}
				try {
					FileWriter savedF = new FileWriter(chartFile);
					savedF.write("HADI-TECH"
							+ (language == Language.SPANISH ? (" - SUMARIO DE ESTE AÑO")
									: language == Language.PORTUGUES ? (" - RESUMO DESTE ANO")
											: language == Language.ENGLISH ? (" - SUMMARY OF THIS YEAR")
													: " - SOMMAIRE DE CETTE ANNEE")
							+ System.lineSeparator() + System.lineSeparator() + System.lineSeparator());
					savedF.write((language == Language.SPANISH ? espSumm[0]
							: language == Language.PORTUGUES ? porSumm[0]
									: language == Language.ENGLISH ? engSumm[0] : frSumm[0])
							+ ":" + System.lineSeparator() + System.lineSeparator());
					savedF.write((language == Language.SPANISH ? espSumm[1]
							: language == Language.PORTUGUES ? porSumm[1]
									: language == Language.ENGLISH ? engSumm[1] : frSumm[1])
							+ System.lineSeparator() + System.lineSeparator() + System.lineSeparator());
					savedF.write((language == Language.SPANISH ? espSumm[2]
							: language == Language.PORTUGUES ? porSumm[2]
									: language == Language.ENGLISH ? engSumm[2] : frSumm[2])
							+ System.lineSeparator() + System.lineSeparator());
					savedF.write(language == Language.SPANISH ? espSumm[3]
							: language == Language.PORTUGUES ? porSumm[3]
									: language == Language.ENGLISH ? engSumm[3] : frSumm[3]);
					savedF.write((language == Language.SPANISH ? espSumm[4]
							: language == Language.PORTUGUES ? porSumm[4]
									: language == Language.ENGLISH ? engSumm[4] : frSumm[4])
							+ System.lineSeparator() + System.lineSeparator());
					savedF.write((language == Language.SPANISH ? espSumm[5]
							: language == Language.PORTUGUES ? porSumm[5]
									: language == Language.ENGLISH ? engSumm[5] : frSumm[5])
							+ System.lineSeparator() + System.lineSeparator());
					savedF.write((language == Language.SPANISH ? espSumm[6]
							: language == Language.PORTUGUES ? porSumm[6]
									: language == Language.ENGLISH ? engSumm[6] : frSumm[6])
							+ System.lineSeparator() + System.lineSeparator());
					savedF.write((language == Language.SPANISH ? espSumm[7]
							: language == Language.PORTUGUES ? porSumm[7]
									: language == Language.ENGLISH ? engSumm[7] : frSumm[7])
							+ System.lineSeparator() + System.lineSeparator());
					savedF.write((language == Language.SPANISH ? espSumm[8]
							: language == Language.PORTUGUES ? porSumm[8]
									: language == Language.ENGLISH ? engSumm[8] : frSumm[8])
							+ System.lineSeparator() + System.lineSeparator());
					savedF.write((language == Language.SPANISH ? espSumm[9]
							: language == Language.PORTUGUES ? porSumm[9]
									: language == Language.ENGLISH ? engSumm[9] : frSumm[9])
							+ System.lineSeparator() + System.lineSeparator());
					savedF.write((language == Language.SPANISH ? espSumm[10]
							: language == Language.PORTUGUES ? porSumm[10]
									: language == Language.ENGLISH ? engSumm[10] : frSumm[10]));
					savedF.close();
					Toast.show(this, Toast.Type.SUCCESS, getLocalizedMessage("SAVE_A"), Intro.notOption);
				} catch (Exception e1) {
					writeError(e1);
				}
			}
			if (conf[1] == null || conf[1].equalsIgnoreCase("null") || conf[1].equals("false"))
				soundEffect(screenSound);
		});

		// If close stop the timer
		extraF.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				colorX = 0;
				order = 0;
				wordL = 0;
				timer.stop();
				overlay.hideOverlay();
			}
		});

		extraF.add(sumItem, gbc);
		extraF.setIconImage(colorSelected == 2 ? ImageEffect.getScaledImage(monthlyI.getImage(), 35, 35).getImage()
				: ImageEffect.invertColor(ImageEffect.getScaledImage(monthlyI.getImage(), 35, 35)).getImage());

		extraF.setVisible(true);
	}

	/* year frame */
	private void yearSumFram() {
		JDialog extraF = new JDialog(this, getLocalizedMessage("YEAR_SUMM"), true);
		extraF.setSize(700, 600);
		extraF.setLocationRelativeTo(null);
		extraF.setResizable(false);
		extraF.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		// Center horizontally and vertically
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		extraF.getContentPane().setBackground(bg);
		overlay.showOverlay();

		// Menubar
		JMenuBar menu = new JMenuBar();
		JMenu file = new JMenu(getLocalizedMessage("FILE"));
		JMenuItem save = new JMenuItem(getLocalizedMessage("SAVE"));
		JMenuItem exit = new JMenuItem(getLocalizedMessage("EXIT"));
		save.addActionListener(_ -> exYearFrame());
		save.setIcon(colorSelected == 2 ? ImageEffect.getScaledImage(saveI.getImage(), 35, 35)
				: ImageEffect.invertColor(ImageEffect.getScaledImage(saveI.getImage(), 35, 35)));
		exit.setIcon(colorSelected == 2 ? ImageEffect.getScaledImage(exitI.getImage(), 35, 35)
				: ImageEffect.invertColor(ImageEffect.getScaledImage(exitI.getImage(), 35, 35)));
		exit.addActionListener(_ -> {
			extraF.dispose();
			overlay.hideOverlay();
		});
		file.add(save);
		file.add(exit);
		menu.add(file);
		extraF.setJMenuBar(menu);
		// LABEL
		JTextPane sumItem = new JTextPane();
		StyledDocument doc = sumItem.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		sumItem.setFont(new Font("Tahoma", Font.BOLD, 18));
		sumItem.setEditable(false);
		sumItem.setCaret(null);
		sumItem.setOpaque(false);
		Color fadeColor = colorSelected == 2 ? new Color(0, 0, 0, 255) : new Color(255, 255, 255, 255);
		sumItem.setForeground(fadeColor);

		int temp[] = DataCalc.yearMaxMin(currentDate.y);
		int maxDIndex = currentDate.dayFromIndex(temp[2]);
		String maxDayString = dayName(new DateModified(maxDIndex, DataCalc.monthFromIndex(temp[2]), currentDate.y),
				langIndex);
		int minDIndex = currentDate.dayFromIndex(temp[3]);
		String minDayString = dayName(new DateModified(minDIndex, DataCalc.monthFromIndex(temp[3]), currentDate.y),
				langIndex);
		String[] avgOfMonths = DataCalc.monthsText(Integer.valueOf(currentDate.m), currentDate.y, langIndex);
		int daysAvg[] = new int[7];
		double daysPerc[] = new double[7];
		int minmaxV[][] = new int[7][2];
		// Min and max according the day
		minmaxV[0] = DataCalc.maxAccDay("monday", currentDate.y);
		minmaxV[1] = DataCalc.maxAccDay("tuesday", currentDate.y);
		minmaxV[2] = DataCalc.maxAccDay("wednesday", currentDate.y);
		minmaxV[3] = DataCalc.maxAccDay("thursday", currentDate.y);
		minmaxV[4] = DataCalc.maxAccDay("friday", currentDate.y);
		minmaxV[5] = DataCalc.maxAccDay("saturday", currentDate.y);
		minmaxV[6] = DataCalc.maxAccDay("sunday", currentDate.y);
		// days avg
		daysAvg[0] = DataCalc.avgSpeDay("monday", currentDate.y);
		daysAvg[1] = DataCalc.avgSpeDay("tuesday", currentDate.y);
		daysAvg[2] = DataCalc.avgSpeDay("Wednesday", currentDate.y);
		daysAvg[3] = DataCalc.avgSpeDay("thursday", currentDate.y);
		daysAvg[4] = DataCalc.avgSpeDay("friday", currentDate.y);
		daysAvg[5] = DataCalc.avgSpeDay("saturday", currentDate.y);
		daysAvg[6] = DataCalc.avgSpeDay("sunday", currentDate.y);
		for (int i = 0; i < 7; i++) {
			daysPerc[i] = (double) daysAvg[i] * 100
					/ (daysAvg[0] + daysAvg[1] + daysAvg[2] + daysAvg[3] + daysAvg[4] + daysAvg[5] + daysAvg[6]);
			daysPerc[i] = Math.round(daysPerc[i] * 100);
			daysPerc[i] = daysPerc[i] / 100;
		}
		/* Max and Min Counter */
		int maxCounter = temp[4];
		int minCounter = temp[5];
		// top 10 merchandise sell
		List<Map.Entry<String, Integer>> top10 = getTop10MonthlySales(currentDate.y, -1);
		List<Map.Entry<String, Double>> top10Price = getTop10MonthlyPrice(currentDate.y, -1);
		String top10S = "", top10P = "";
		int rank = 1;
		for (int i = 0; i < top10.size(); i++) {
			if (i > 0 && i < top10.size())
				if (top10.get(i).getValue() == top10.get(i - 1).getValue()) {
					if (i == top10.size() - 1)
						top10S += --rank + "- " + top10.get(i).getKey() + " -> " + top10.get(i).getValue();
					else
						top10S += --rank + "- " + top10.get(i).getKey() + " -> " + top10.get(i).getValue() + "\n\n";
				} else {
					top10S += (i + 1) + "- " + top10.get(i).getKey() + " -> " + top10.get(i).getValue() + "\n\n";
					rank = i + 1;
				}
			else if (i == 0)
				top10S += rank + "- " + top10.get(i).getKey() + " -> " + top10.get(i).getValue() + "\n\n";
			rank++;
		}
		rank = 1;
		for (int i = 0; i < top10Price.size(); i++) {
			if (i > 0 && i < top10Price.size()) {
				if (top10Price.get(i).getValue().equals(top10Price.get(i - 1).getValue())) {
					if (i == top10.size() - 1)
						top10P += --rank + "- " + top10Price.get(i).getKey() + " -> $" + top10Price.get(i).getValue();
					else
						top10P += --rank + "- " + top10Price.get(i).getKey() + " -> $" + top10Price.get(i).getValue()
								+ "\n\n";
				} else {
					top10P += (i + 1) + "- " + top10Price.get(i).getKey() + " -> $" + top10Price.get(i).getValue()
							+ "\n\n";
					rank = i + 1;
				}
			} else if (i == 0)
				top10P += rank + "- " + top10Price.get(i).getKey() + " -> $" + top10Price.get(i).getValue() + "\n\n";
			rank++;
		}
		String sellerText = "";
		rank = 1;
		Map<String, Integer> sortedMap = new HashMap<String, Integer>();
		for (int i = 0; i < employee.size(); i++) {
			int totalMonth = getSalesOfMonthYear(employee.get(i).getName(), -1, currentDate.y);
			if (totalMonth > 0)
				sortedMap.put(employee.get(i).getName(),
						getSalesOfMonthYear(employee.get(i).getName(), -1, currentDate.y));
		}
		sortedMap = sortedMap.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
				.collect(LinkedHashMap::new, (map, entry) -> map.put(entry.getKey(), entry.getValue()), Map::putAll);
		int totalSell = 0;
		for (Map.Entry<String, Integer> entry : sortedMap.entrySet())
			totalSell += entry.getValue();
		for (Map.Entry<String, Integer> entry : sortedMap.entrySet())
			sellerText += (rank++) + "- " + entry.getKey() + " -> $" + entry.getValue() + " ("
					+ (entry.getValue() * 100 / totalSell) + "%)\n\n";

		sumItem.addKeyListener(new KeyAdapter() {// Escape to close
			@Override
			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
					colorX = 0;
					order = 0;
					wordL = 0;
					timer.stop();
					overlay.hideOverlay();
					extraF.dispose();
				}
			}
		});
		// TIMER
		order = 0;
		wordL = 0;
		colorX = 0;
		status = true;
		String[] espSumm = { "I. COMPARACIÓN CON LOS AÑOS PASADOS", // 0 + 1
				"ESTE AÑO\n\nVENDIMOS POR AHORA UN PROMEDIO DE $" + dailyAvg + "\n\n\n"
						+ (conLY.size() == 0 ? ""
								: "EN " + (currentDate.y - 1) + "\n\nVENDIMOS UN PROMEDIO DE $" + dailyAvgLY + "\n\n\n")
						+ (conLY2.size() == 0 ? ""
								: "EN " + (currentDate.y - 2) + "\n\nVENDIMOS UN PROMEDIO DE $" + dailyAvgLY2
										+ "\n\n\n")
						+ (conLY3.size() == 0 ? ""
								: "EN " + (currentDate.y - 3) + "\n\nVENDIMOS UN PROMEDIO DE $" + dailyAvgLY3
										+ "\n\n\n")
						+ (conLY4.size() == 0 ? ""
								: "EN " + (currentDate.y - 4) + "\n\nVENDIMOS UN PROMEDIO DE $" + dailyAvgLY4),
				"II. EXTREMOS DEL AÑO", // 2 + 3
				(maxCounter > 1 ? "LA MEJOR VENTA POR DIA DEL AÑO\n\nPASÓ " + maxCounter + " VECES Y ESO ES $" + temp[0]
						: "EL MEJOR DÍA DE ESTE AÑO ES " + maxDayString + " " + maxDIndex + "-"
								+ getMonthForInt(DataCalc.monthFromIndex(temp[2]) - 1, 0) + "\n\nLO QUE VENDIMOS $"
								+ temp[0])
						+ "\n\n\n\n"
						+ (minCounter > 1
								? "LA PEOR VENTA POR DIA DEL AÑO\n\nPASÓ " + minCounter + " VECES Y ESO ES $" + temp[1]
								: "EL PEOR DÍA DE ESTE AÑO ES " + minDayString + " " + minDIndex + "-"
										+ getMonthForInt(DataCalc.monthFromIndex(temp[3]) - 1, 0)
										+ "\n\nLO QUE VENDIMOS $" + temp[1]),
				"III. DIFERENCIA CON MESES ANTERIORES", // 4 + 5 + 6
				avgOfMonths[0] + "\n\n" + avgOfMonths[1] + "\n\n" + avgOfMonths[2] + "\n\n" + avgOfMonths[3] + "\n\n"
						+ avgOfMonths[4] + "\n\n" + avgOfMonths[5],
				"\n\n" + avgOfMonths[6] + "\n\n" + avgOfMonths[7] + "\n\n" + avgOfMonths[8] + "\n\n" + avgOfMonths[9]
						+ "\n\n" + avgOfMonths[10] + "\n\n" + avgOfMonths[11],
				"IV. EXTREMOS DEL MES", // 7 + 8
				"EL MEJOR MES DEL AÑO FUE " + getMonthForInt(Integer.valueOf(avgOfMonths[14]), 0) + "\n\n"
						+ "LO QUE VENDIMOS UN PROMEDIO DE $" + avgOfMonths[12] + "\n\n\n\n" + "EL PEOR MES DEL AÑO FUE "
						+ getMonthForInt(Integer.valueOf(avgOfMonths[15]), 0) + "\n\n"
						+ "LO QUE VENDIMOS UN PROMEDIO DE $" + avgOfMonths[13],
				"V. LA MEDIA SEGÚN EL DÍA SON", // 9 + 10
				"LUNES -> $" + daysAvg[0] + " (%" + daysPerc[0] + ")\n\n\nMARTES -> $" + daysAvg[1] + " (%"
						+ daysPerc[1] + ")\n\n\nMIÉRCOLES -> $" + daysAvg[2] + " (%" + daysPerc[2]
						+ ")\n\n\nJUEVES -> $" + daysAvg[3] + " (%" + daysPerc[3] + ")\n\n\nVIERNES -> $" + daysAvg[4]
						+ " (%" + daysPerc[4] + ")\n\n\nSÁBADO -> $" + daysAvg[5] + " (%" + daysPerc[5]
						+ ")\n\n\nDOMINGO -> $" + daysAvg[6] + " (%" + daysPerc[6] + ")",
				"VI. EL MÍNIMO Y MÁXIMO SEGÚN EL DÍA", // 11 + 12
				"LUNES -> MAX: $" + minmaxV[0][0] + ", MIN: $" + minmaxV[0][1] + "\n\nMARTES -> MAX: $" + minmaxV[1][0]
						+ ", MIN: $" + minmaxV[1][1] + "\n\nMIÉRCOLES -> MAX: $" + minmaxV[2][0] + ", MIN: $"
						+ minmaxV[2][1] + "\n\nJUEVES -> MAX: $" + minmaxV[3][0] + ", MIN: $" + minmaxV[3][1]
						+ "\n\nVIERNES -> MAX: $" + minmaxV[4][0] + ", MIN: $" + minmaxV[4][1] + "\n\nSÁBADO -> MAX: $"
						+ minmaxV[5][0] + ", MIN: $" + minmaxV[5][1] + "\n\nDOMINGO -> MAX: $" + minmaxV[6][0]
						+ ", MIN: $" + minmaxV[6][1],
				"VII. MAYOR VENTA DEL AÑO POR CANTIDAD", top10S, //
				"VIII. MAYOR VENTA DEL AÑO POR PRECIO", top10P, //
				"IX. EL MEJOR VENDEDOR DE ESTE AÑO", sellerText, //
		};
		String[] porSumm = { "I. COMPARAÇÃO COM OS ANOS PASSADOS", "ESTE ANO\n\nVENDEMOS POR AGORA UMA MÉDIA DE $"
				+ dailyAvg + "\n\n\n"
				+ (conLY.size() == 0 ? ""
						: "EM " + (currentDate.y - 1) + "\n\nVENDEMOS EM MÉDIA DE $" + dailyAvgLY + "\n\n\n")
				+ (conLY2.size() == 0 ? ""
						: "EM " + (currentDate.y - 2) + "\n\nVENDEMOS EM MÉDIA DE $" + dailyAvgLY2 + "\n\n\n")
				+ (conLY3.size() == 0 ? ""
						: "EM " + (currentDate.y - 3) + "\n\nVENDEMOS EM MÉDIA DE $" + dailyAvgLY3 + "\n\n\n")
				+ (conLY4.size() == 0 ? "" : "EM " + (currentDate.y - 4) + "\n\nVENDEMOS EM MÉDIA DE $" + dailyAvgLY4), // 0
				"II. EXTREMOS DO ANO",
				(maxCounter > 1
						? "A MELHOR PROMOÇÃO POR DIA DO ANO\n\nPASSOU " + maxCounter + " VEZES E ISSO É $" + temp[0]
						: "O MELHOR DIA DESTE ANO É " + maxDayString + " " + maxDIndex + "-"
								+ getMonthForInt(DataCalc.monthFromIndex(temp[2]) - 1, 1) + "\n\nO QUE VENDEMOS $"
								+ temp[0])
						+ "\n\n\n\n"
						+ (minCounter > 1
								? "A PIOR VENDA POR DIA DO ANO\n\nPASSOU " + minCounter + " VEZES E ISSO É $" + temp[1]
								: "O PIOR DIA DO ANO É " + minDayString + " " + minDIndex + "-"
										+ getMonthForInt(DataCalc.monthFromIndex(temp[3]) - 1, 1)
										+ "\n\nO QUE VENDEMOS $" + temp[1]), // 1
				"III. DIFERENÇA DOS MESES ANTERIORES",
				avgOfMonths[0] + "\n\n" + avgOfMonths[1] + "\n\n" + avgOfMonths[2] + "\n\n" + avgOfMonths[3] + "\n\n"
						+ avgOfMonths[4] + "\n\n" + avgOfMonths[5], // 2
				avgOfMonths[6] + "\n\n" + avgOfMonths[7] + "\n\n" + avgOfMonths[8] + "\n\n" + avgOfMonths[9] + "\n\n"
						+ avgOfMonths[10] + "\n\n" + avgOfMonths[11], // 3
				"IV. EXTREMOS DO MÊS",
				"O MELHOR MÊS DO ANO FOI " + getMonthForInt(Integer.valueOf(avgOfMonths[14]), 1) + "\n\n"
						+ "O QUE VENDEMOS EM MÉDIA $" + avgOfMonths[12] + "\n\n\n\n" + "O PIOR MÊS DO ANO FOI "
						+ getMonthForInt(Integer.valueOf(avgOfMonths[15]), 1) + "\n\n" + "O QUE VENDEMOS EM MÉDIA $"
						+ avgOfMonths[13], // 4 MAX AND MIN FOR THE MONTH
				"V. A MÉDIA DE ACORDO COM O DIA SÃO",
				"SEGUNDA-FEIRA -> $" + daysAvg[0] + " (%" + daysPerc[0] + ")\n\nTERÇA-FEIRA -> $" + daysAvg[1] + " (%"
						+ daysPerc[1] + ")\n\nQUARTA-FEIRA -> $" + daysAvg[2] + " (%" + daysPerc[2]
						+ ")\n\nQUINTA-FEIRA -> $" + daysAvg[3] + " (%" + daysPerc[3] + ")\n\nSEXTA-FEIRA -> $"
						+ daysAvg[4] + " (%" + daysPerc[4] + ")\n\nSÁBADO -> $" + daysAvg[5] + " (%" + daysPerc[5]
						+ ")\n\nDOMINGO -> $" + daysAvg[6] + " (%" + daysPerc[6] + ")", // 5
				"VI. O MÍNIMO E MÁXIMO DE ACORDO COM O DIA",
				"SEGUNDA-FEIRA -> MAX: $" + minmaxV[0][0] + ", MIN: $" + minmaxV[0][1] + "\n\nTERÇA-FEIRA -> MAX: $"
						+ minmaxV[1][0] + ", MIN: $" + minmaxV[1][1] + "\n\nQUARTA-FEIRA -> MAX: $" + minmaxV[2][0]
						+ ", MIN: $" + minmaxV[2][1] + "\n\nQUINTA-FEIRA -> MAX: $" + minmaxV[3][0] + ", MIN: $"
						+ minmaxV[3][1] + "\n\nSEXTA-FEIRA -> MAX: $" + minmaxV[4][0] + ", MIN: $" + minmaxV[4][1]
						+ "\n\nSÁBADO -> MAX: $" + minmaxV[5][0] + ", MIN: $" + minmaxV[5][1] + "\n\nDOMINGO -> MAX: $"
						+ minmaxV[6][0] + ", MIN: $" + minmaxV[6][1],
				"VII. MAIS VENDIDOS DO ANO POR QUANTIDADE", top10S, //
				"VIII. MAIS VENDIDOS DO ANO POR PREÇO", top10P, //
				"IX. O MELHOR VENDEDOR DESTE ANO", sellerText, //
		};
		String[] engSumm = { "I. COMPARISON WITH LAST YEARS", "THIS YEAR\n\nWE SOLD FOR NOW AN AVERAGE OF $" + dailyAvg
				+ "\n\n\n"
				+ (conLY.size() == 0 ? ""
						: "IN " + (currentDate.y - 1) + "\n\nWE SOLD AN AVERAGE OF $" + dailyAvgLY + "\n\n\n")
				+ (conLY2.size() == 0 ? ""
						: "IN " + (currentDate.y - 2) + "\n\nWE SOLD AN AVERAGE OF $" + dailyAvgLY2 + "\n\n\n")
				+ (conLY3.size() == 0 ? ""
						: "IN " + (currentDate.y - 3) + "\n\nWE SOLD AN AVERAGE OF $" + dailyAvgLY3 + "\n\n\n")
				+ (conLY4.size() == 0 ? "" : "IN " + (currentDate.y - 4) + "\n\nWE SOLD AN AVERAGE OF $" + dailyAvgLY4), // 0
				"II. EXTREMES OF THE YEAR",
				(maxCounter > 1
						? "THE BEST SELL PER DAY OF THE YEAR\n\nHAPPENED " + maxCounter + " TIMES AND IT'S $" + temp[0]
						: "THE BEST DAY OF THIS YEAR IS " + maxDayString + " " + maxDIndex + "-"
								+ getMonthForInt(DataCalc.monthFromIndex(temp[2]) - 1, 2) + "\n\nWHAT WE SOLD $"
								+ temp[0])
						+ "\n\n\n\n"
						+ (minCounter > 1
								? "THE WORSRT SELL PER DAY OF THE YEAR\n\nHAPPENED " + minCounter + " TIMES AND IT'S $"
										+ temp[1]
								: "THE WORST DAY OF THIS YEAR IS " + minDayString + " " + minDIndex + "-"
										+ getMonthForInt(DataCalc.monthFromIndex(temp[3]) - 1, 2) + "\n\nWHAT WE SOLD $"
										+ temp[1]), // 1
				"III. DIFFERENCE FROM PREVIOUS MONTHS",
				avgOfMonths[0] + "\n\n" + avgOfMonths[1] + "\n\n" + avgOfMonths[2] + "\n\n" + avgOfMonths[3] + "\n\n"
						+ avgOfMonths[4] + "\n\n" + avgOfMonths[5], // 2
				avgOfMonths[6] + "\n\n" + avgOfMonths[7] + "\n\n" + avgOfMonths[8] + "\n\n" + avgOfMonths[9] + "\n\n"
						+ avgOfMonths[10] + "\n\n" + avgOfMonths[11], // 3
				"IV. EXTREMES OF THE MONTH",
				"THE BEST MONTH OF THE YEAR WAS " + getMonthForInt(Integer.valueOf(avgOfMonths[14]), 2) + "\n\n"
						+ "WHAT WE SOLD AN AVERAGE OF $" + avgOfMonths[12] + "\n\n\n\n"
						+ "THE WORST MONTH OF THE YEAR WAS " + getMonthForInt(Integer.valueOf(avgOfMonths[15]), 2)
						+ "\n\n" + "WHAT WE SOLD AN AVERAGE OF $" + avgOfMonths[13], // 4 MAX AND MIN FOR THE MONTH
				"V. THE AVERAGE ACCORDING TO THE DAY ARE",
				"MONDAY -> $" + daysAvg[0] + " (%" + daysPerc[0] + ")\n\nTUESDAY -> $" + daysAvg[1] + " (%"
						+ daysPerc[1] + ")\n\nWEDNESDAY -> $" + daysAvg[2] + " (%" + daysPerc[2] + ")\n\nTHURSDAY -> $"
						+ daysAvg[3] + " (%" + daysPerc[3] + ")\n\nFRIDAY -> $" + daysAvg[4] + " (%" + daysPerc[4]
						+ ")\n\nSATURDAY -> $" + daysAvg[5] + " (%" + daysPerc[5] + ")\n\nSUNDAY -> $" + daysAvg[6]
						+ " (%" + daysPerc[6] + ")", // 5
				"VI. THE MINIMUM AND MAXIMUM ACCORDING THE DAY",
				"MONDAY -> MAX: $" + minmaxV[0][0] + ", MIN: $" + minmaxV[0][1] + "\n\nTUESDAY -> MAX: $"
						+ minmaxV[1][0] + ", MIN: $" + minmaxV[1][1] + "\n\nWEDNESDAY -> MAX: $" + minmaxV[2][0]
						+ ", MIN: $" + minmaxV[2][1] + "\n\nTHURSDAY -> MAX: $" + minmaxV[3][0] + ", MIN: $"
						+ minmaxV[3][1] + "\n\nFRIDAY -> MAX: $" + minmaxV[4][0] + ", MIN: $" + minmaxV[4][1]
						+ "\n\nSATURDAY -> MAX: $" + minmaxV[5][0] + ", MIN: $" + minmaxV[5][1] + "\n\nSUNDAY -> MAX: $"
						+ minmaxV[6][0] + ", MIN: $" + minmaxV[6][1],
				"VII. TOP SELL OF YEAR BY QUANTITY", top10S, //
				"VIII. TOP SELL OF YEAR BY PRICE", top10P, //
				"IX. TOP SELLERS OF THIS YEAR", sellerText, //
		};
		String[] frSumm = { "I. COMPARAISON AVEC LES ANNÉES PASSÉES", // 0
				"CETTE ANNÉE\n\nNOUS AVONS VENDU POUR L'INSTANT UNE MOYENNE DE $" + dailyAvg + "\n\n\n"
						+ (conLY.size() == 0 ? ""
								: "EN " + (currentDate.y - 1) + "\n\nNOUS AVONS VENDU UNE MOYENNE DE $" + dailyAvgLY)
						+ (conLY2.size() == 0 ? ""
								: "\n\n\n" + "EN " + (currentDate.y - 2) + "\n\nNOUS AVONS VENDU UNE MOYENNE DE $"
										+ dailyAvgLY2)
						+ (conLY3.size() == 0 ? ""
								: "\n\n\n" + "EN " + (currentDate.y - 3) + "\n\nNOUS AVONS VENDU UNE MOYENNE DE $"
										+ dailyAvgLY3)
						+ (conLY4.size() == 0 ? ""
								: "\n\n\n" + "EN " + (currentDate.y - 4) + "\n\nNOUS AVONS VENDU UNE MOYENNE DE $"
										+ dailyAvgLY4), // 1
				"II. EXTREMES DE L'ANNÉE", // 2
				(maxCounter > 1
						? "LA MEILLEURE VENTE PAR JOUR DE L'ANNÉE\n\nPASSÉ  " + maxCounter + " FOIS ET C'EST $"
								+ temp[0]
						: "LE MEILLEUR JOUR DE CETTE ANNÉE EST " + maxDayString + " " + maxDIndex + "-"
								+ getMonthForInt(DataCalc.monthFromIndex(temp[2]) - 1, 3)
								+ "\n\nCE QUE NOUS AVONS VENDU $" + temp[0])
						+ "\n\n\n\n"
						+ (minCounter > 1
								? "LA PIRE VENTE PAR JOUR DE L'ANNÉE\n\nPASSÉ " + minCounter + " FOIS ET C'EST $"
										+ temp[1]
								: " LE PIRE JOUR DE CETTE ANNÉE EST " + minDayString + " " + minDIndex + "-"
										+ getMonthForInt(DataCalc.monthFromIndex(temp[3]) - 1, 3)
										+ "\n\nCE QUE NOUS AVONS VENDU $" + temp[1]), // 3
				"III. DIFFÉRENCE AVEC LES MOIS PRÉCÉDENTS", // 4
				avgOfMonths[0] + "\n\n" + avgOfMonths[1] + "\n\n" + avgOfMonths[2] + "\n\n" + avgOfMonths[3] + "\n\n"
						+ avgOfMonths[4] + "\n\n" + avgOfMonths[5], // 5
				avgOfMonths[6] + "\n\n" + avgOfMonths[7] + "\n\n" + avgOfMonths[8] + "\n\n" + avgOfMonths[9] + "\n\n"
						+ avgOfMonths[10] + "\n\n" + avgOfMonths[11], // 6
				"IV. EXTREMES DE MOIS", // 7
				"LE MEILLEUR MOIS DE L'ANNÉE A ÉTÉ " + getMonthForInt(Integer.valueOf(avgOfMonths[14]), 3) + "\n\n"
						+ "CE QUE NOUS AVONS VENDU EN MOYENNE DE $" + avgOfMonths[12] + "\n\n\n\n"
						+ " LE PIRE MOIS DE L'ANNÉE A ÉTÉ " + getMonthForInt(Integer.valueOf(avgOfMonths[15]), 3)
						+ "\n\n" + "CE QUE NOUS AVONS VENDU EN MOYENNE DE $" + avgOfMonths[13], // 8
				"V. LA MOYENNE SELON LE JOUR EST", // 9
				"LUNDI -> $" + daysAvg[0] + " (%" + daysPerc[0] + ")\n\nMARDI -> $" + daysAvg[1] + " (%" + daysPerc[1]
						+ ")\n\nMERCREDI -> $" + daysAvg[2] + " (%" + daysPerc[2] + ")\n\nJEUDI -> $" + daysAvg[3]
						+ " (%" + daysPerc[3] + ")\n\nVENDREDI -> $" + daysAvg[4] + " (%" + daysPerc[4]
						+ ")\n\nSAMEDI -> $" + daysAvg[5] + " (%" + daysPerc[5] + ")\n\nDIMANCHE -> $" + daysAvg[6]
						+ " (%" + daysPerc[6] + ")", // 10
				"VI. LE MINIMUM ET LE MAXIMUM SELON LE JOUR", // 11
				"LUNDI -> MAX: $" + minmaxV[0][0] + ", MIN: $" + minmaxV[0][1] + "\n\nMARDI -> MAX: $" + minmaxV[1][0]
						+ ", MIN: $" + minmaxV[1][1] + "\n\nMERCREDI -> MAX: $" + minmaxV[2][0] + ", MIN: $"
						+ minmaxV[2][1] + "\n\nnJEUDI -> MAX: $" + minmaxV[3][0] + ", MIN: $" + minmaxV[3][1]
						+ "\n\nVENDREDI -> MAX: $" + minmaxV[4][0] + ", MIN: $" + minmaxV[4][1] + "\n\nSAMEDI -> MAX: $"
						+ minmaxV[5][0] + ", MIN: $" + minmaxV[5][1] + "\n\nDIMANCHE -> MAX: $" + minmaxV[6][0]
						+ ", MIN: $" + minmaxV[6][1], // 12
				"VII. MEILLEURE VENTE DE L'ANNÉE PAR QUANTITÉ", top10S, // 14
				"VIII. MEILLEURE VENTE DE L'ANNÉE PAR PRIX", top10P, // 16
				"IX. MEILLEUR VENDEUR DE CETTE ANNÉE", sellerText, //
		};
		ActionListener letterByLetter = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (order >= espSumm.length) {
					timer.stop();
					return;
				}
				if (order == 0
						&& (conLY.size() == 0 && conLY2.size() == 0 && conLY3.size() == 0 && conLY4.size() == 0)) {
					order = 2;
					wordL = 0;
					sumItem.setText("");
					return;
				}
				if ((order == 13 && top10.size() == 0) || (order == 15 && top10Price.size() == 0)
						|| (order == 17 && employee.size() == 0)) {
					order += 2;
					wordL = 0;
					sumItem.setText("");
					return;
				}

				// Determine the text array based on the language and current order
				String currentText = (language == Language.SPANISH ? espSumm[order]
						: language == Language.PORTUGUES ? porSumm[order]
								: language == Language.ENGLISH ? engSumm[order] : frSumm[order]);

				// Convert the current text to a char array
				char[] wordT = currentText.toCharArray();

				// If text is empty and we're not at the last case, move to the next order
				if (wordT.length == 0 && order != 18) {
					order++;
					wordL = 0;
					sumItem.setText("");
					return;
				}

				// Handle typing the text letter by letter
				if (wordL < wordT.length) {
					sumItem.setText(sumItem.getText() + wordT[wordL++]);
				} else if (wordL < wordT.length + 15) {
					wordL++;
				} else {
					// When finished with the current order, move to the next one
					if (order < 18) {
						order++;
						wordL = 0;
						sumItem.setText("");
					} else {
						// Stop after the last case (case 12)
						timer.stop();
					}
				}
			}
		};
		ActionListener fadeTimer = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Select the appropriate text for the current language and order
				String[] summaries = { espSumm[order], porSumm[order], engSumm[order], frSumm[order] };
				String text = summaries[language.ordinal()];
				sumItem.setText(text);

				// Handle special case for order 6 (skip to next order if text is blank)
				if (order == 6 && sumItem.getText().isBlank()) {
					order++; // Move to the next order if the text is blank
					status = true; // Start fading in the next item
					return; // Skip the rest of the fade logic for case 6
				}
				if (order == 0
						&& (conLY.size() == 0 && conLY2.size() == 0 && conLY3.size() == 0 && conLY4.size() == 0)) {
					order = 2; // Move to the next order if the text is blank
					status = true; // Start fading in the next item
					return; // Skip the rest of the fade logic for case 6
				}
				if ((order == 13 && top10.size() == 0) || (order == 15 && top10Price.size() == 0)
						|| (order == 17 && employee.size() == 0)) {
					order += 2;
					status = true;
					return;
				}

				// Set the fade color (black for dark mode, white for light mode)
				Color fadeColor = (colorSelected == 2) ? new Color(0, 0, 0, colorX) : new Color(255, 255, 255, colorX);
				sumItem.setForeground(fadeColor);

				if (status) {
					// Fade in
					if (colorX < 254) {
						colorX++; // Fade in
					} else {
						// When fully faded in, start fading out
						status = false;
					}
				} else {
					// Fade out
					if (colorX > 0 && order < 18) {
						colorX -= 2; // Fade out
					} else {
						// Once fully faded out, move to the next order
						if (order < 18) {
							order++; // Go to the next order
							status = true; // Start fading in again
						} else {
							timer.stop(); // Stop the timer after all orders are shown
						}
					}
				}
			}
		};
		ActionListener wordByWord = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				switch (order) {
				case 0: {
					if (order == 0
							&& (conLY.size() == 0 && conLY2.size() == 0 && conLY3.size() == 0 && conLY4.size() == 0)) {
						order = 2;
						wordL = 0;
						sumItem.setText("");
					} else {
						String[] wordT = language == Language.SPANISH ? espSumm[0].split(" ")
								: language == Language.PORTUGUES ? porSumm[0].split(" ")
										: language == Language.ENGLISH ? engSumm[0].split(" ") : frSumm[0].split(" ");
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					}
					break;
				}
				case 1: {
					String[] wordT = language == Language.SPANISH ? espSumm[1].split(" ")
							: language == Language.PORTUGUES ? porSumm[1].split(" ")
									: language == Language.ENGLISH ? engSumm[1].split(" ") : frSumm[1].split(" ");
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 2: {// AVG FOR EACH DAY
					String[] wordT = language == Language.SPANISH ? espSumm[2].split(" ")
							: language == Language.PORTUGUES ? porSumm[2].split(" ")
									: language == Language.ENGLISH ? engSumm[2].split(" ") : frSumm[2].split(" ");
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							sumItem.setText("");
							wordL = 0;
						}
					}
					break;
				}
				case 3: {// AVG FOR EACH DAY
					String[] wordT = language == Language.SPANISH ? espSumm[3].split(" ")
							: language == Language.PORTUGUES ? porSumm[3].split(" ")
									: language == Language.ENGLISH ? engSumm[3].split(" ") : frSumm[3].split(" ");
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							sumItem.setText("");
							wordL = 0;
						}
					}
					break;
				}
				case 4: {// AVG FOR EACH DAY
					String[] wordT = language == Language.SPANISH ? espSumm[4].split(" ")
							: language == Language.PORTUGUES ? porSumm[4].split(" ")
									: language == Language.ENGLISH ? engSumm[4].split(" ") : frSumm[4].split(" ");
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							sumItem.setText("");
							wordL = 0;
						}
					}
					break;
				}
				case 5: {
					String[] wordT = language == Language.SPANISH ? espSumm[5].split(" ")
							: language == Language.PORTUGUES ? porSumm[5].split(" ")
									: language == Language.ENGLISH ? engSumm[5].split(" ") : frSumm[5].split(" ");
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 6: {
					String[] wordT = language == Language.SPANISH ? espSumm[6].split(" ")
							: language == Language.PORTUGUES ? porSumm[6].split(" ")
									: language == Language.ENGLISH ? engSumm[6].split(" ") : frSumm[6].split(" ");
					if (wordT.length == 1) {
						order++;
						wordL = 0;
						sumItem.setText("");
					} else if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 7: {
					String[] wordT = language == Language.SPANISH ? espSumm[7].split(" ")
							: language == Language.PORTUGUES ? porSumm[7].split(" ")
									: language == Language.ENGLISH ? engSumm[7].split(" ") : frSumm[7].split(" ");
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 8: {
					String[] wordT = language == Language.SPANISH ? espSumm[8].split(" ")
							: language == Language.PORTUGUES ? porSumm[8].split(" ")
									: language == Language.ENGLISH ? engSumm[8].split(" ") : frSumm[8].split(" ");
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 9: {
					String[] wordT = language == Language.SPANISH ? espSumm[9].split(" ")
							: language == Language.PORTUGUES ? porSumm[9].split(" ")
									: language == Language.ENGLISH ? engSumm[9].split(" ") : frSumm[9].split(" ");
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 10: {
					String[] wordT = language == Language.SPANISH ? espSumm[10].split(" ")
							: language == Language.PORTUGUES ? porSumm[10].split(" ")
									: language == Language.ENGLISH ? engSumm[10].split(" ") : frSumm[10].split(" ");
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 11: {
					String[] wordT = language == Language.SPANISH ? espSumm[11].split(" ")
							: language == Language.PORTUGUES ? porSumm[11].split(" ")
									: language == Language.ENGLISH ? engSumm[11].split(" ") : frSumm[11].split(" ");
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 12: {
					String[] wordT = language == Language.SPANISH ? espSumm[12].split(" ")
							: language == Language.PORTUGUES ? porSumm[12].split(" ")
									: language == Language.ENGLISH ? engSumm[12].split(" ") : frSumm[12].split(" ");
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 13: {
					String[] wordT = language == Language.SPANISH ? espSumm[13].split(" ")
							: language == Language.PORTUGUES ? porSumm[13].split(" ")
									: language == Language.ENGLISH ? engSumm[13].split(" ") : frSumm[13].split(" ");
					if (top10.size() == 0) {
						order += 2;
						wordL = 0;
						sumItem.setText("");
					} else if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 14: {
					String[] wordT = language == Language.SPANISH ? espSumm[14].split(" ")
							: language == Language.PORTUGUES ? porSumm[14].split(" ")
									: language == Language.ENGLISH ? engSumm[14].split(" ") : frSumm[14].split(" ");
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 15: {
					String[] wordT = language == Language.SPANISH ? espSumm[15].split(" ")
							: language == Language.PORTUGUES ? porSumm[15].split(" ")
									: language == Language.ENGLISH ? engSumm[15].split(" ") : frSumm[15].split(" ");
					if (top10Price.size() == 0) {
						order += 2;
						wordL = 0;
						sumItem.setText("");
					} else if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 16: {
					String[] wordT = language == Language.SPANISH ? espSumm[16].split(" ")
							: language == Language.PORTUGUES ? porSumm[16].split(" ")
									: language == Language.ENGLISH ? engSumm[16].split(" ") : frSumm[16].split(" ");
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 17: {
					String[] wordT = language == Language.SPANISH ? espSumm[17].split(" ")
							: language == Language.PORTUGUES ? porSumm[17].split(" ")
									: language == Language.ENGLISH ? engSumm[17].split(" ") : frSumm[17].split(" ");
					if (employee.size() == 0) {
						order += 2;
						wordL = 0;
						sumItem.setText("");
						timer.stop();
					} else if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 18: {
					String[] wordT = language == Language.SPANISH ? espSumm[18].split(" ")
							: language == Language.PORTUGUES ? porSumm[18].split(" ")
									: language == Language.ENGLISH ? engSumm[18].split(" ") : frSumm[18].split(" ");
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						order++;
						timer.stop();
					}
					break;
				}
				default:
					wordL = 0;
					timer.stop();
					break;
				}
			}
		};
		ActionListener movingTB = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (order > 18) {
					wordL = 0;
					timer.stop();
					return;
				}
				if (order == 0
						&& (conLY.size() == 0 && conLY2.size() == 0 && conLY3.size() == 0 && conLY4.size() == 0)) {
					order = 2;
					wordL = 0;
					return;
				}
				if ((order == 13 && top10.size() == 0) || (order == 15 && top10Price.size() == 0)
						|| (order == 17 && employee.size() == 0)) {
					order += 2;
					wordL = 0;
					sumItem.setText("");
					return;
				}

				String[] summaries = (language == Language.SPANISH ? espSumm
						: language == Language.PORTUGUES ? porSumm : language == Language.ENGLISH ? engSumm : frSumm);

				String originalText = summaries[order];
				if (originalText == null || originalText.isBlank()) {
					order++;
					return;
				}

				String scrambledText = TextEffect.scrambleText(originalText);
				sumItem.setText(scrambledText);
				wordL++;
				if (wordL >= 20) {
					sumItem.setText(originalText);
					if (wordL < 500) {
						wordL++;
					} else {
						order++;
						wordL = 0;
					}
				}

			}
		};

		if (effChooser == 0) {
			// Speed
			if (conf[6] == null || conf[6].equals("1"))
				speedValue = 15;
			else if (conf[6].equals("0"))
				speedValue = 20;
			else
				speedValue = 1;
			timer = new Timer(speedValue, fadeTimer);
		} else if (effChooser == 1) {
			// Speed
			if (conf[6] == null || conf[6].equals("1"))
				speedValue = 400;
			else if (conf[6].equals("0"))
				speedValue = 500;
			else
				speedValue = 300;
			timer = new Timer(speedValue, wordByWord);
		} else if (effChooser == 2) {
			// Speed
			if (conf[6] == null || conf[6].equals("1"))
				speedValue = 150;
			else if (conf[6].equals("0"))
				speedValue = 300;
			else
				speedValue = 50;
			timer = new Timer(speedValue, letterByLetter);
		} else {
			// Speed
			if (conf[6] == null || conf[6].equals("1"))
				speedValue = 15;
			else if (conf[6].equals("0"))
				speedValue = 20;
			else
				speedValue = 1;
			timer = new Timer(speedValue, movingTB);
		}
		timer.start();

		// If close stop the timer
		extraF.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				colorX = 0;
				order = 0;
				wordL = 0;
				timer.stop();
				overlay.hideOverlay();
			}
		});

		extraF.add(sumItem, gbc);
		extraF.setIconImage(colorSelected == 2 ? ImageEffect.getScaledImage(monthlyI.getImage(), 35, 35).getImage()
				: ImageEffect.invertColor(ImageEffect.getScaledImage(monthlyI.getImage(), 35, 35)).getImage());

		extraF.setVisible(true);
	}

	/* Month compare frame */
	private void monthAvgFrame(int month) {
		JDialog extraF = new JDialog(this, getLocalizedMessage("MONTH_SUM"), true);
		extraF.setSize(700, 600);
		extraF.setLocationRelativeTo(null);
		extraF.setResizable(false);
		extraF.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		// Center horizontally and vertically
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		extraF.getContentPane().setBackground(bg);
		overlay.showOverlay();

		// Menubar
		JMenuBar menu = new JMenuBar();
		JMenu file = new JMenu(getLocalizedMessage("FILE"));
		JMenuItem save = new JMenuItem(getLocalizedMessage("SAVE"));
		JMenuItem exit = new JMenuItem(getLocalizedMessage("EXIT"));
		save.addActionListener(_ -> exMonthFrame(month));
		save.setIcon(colorSelected == 2 ? ImageEffect.getScaledImage(saveI.getImage(), 35, 35)
				: ImageEffect.invertColor(ImageEffect.getScaledImage(saveI.getImage(), 35, 35)));
		exit.setIcon(colorSelected == 2 ? ImageEffect.getScaledImage(exitI.getImage(), 35, 35)
				: ImageEffect.invertColor(ImageEffect.getScaledImage(exitI.getImage(), 35, 35)));
		exit.addActionListener(_ -> {
			extraF.dispose();
			overlay.hideOverlay();
		});
		file.add(save);
		file.add(exit);
		menu.add(file);
		extraF.setJMenuBar(menu);
		// LABEL
		DateModified dateFromMonth = new DateModified(Integer.valueOf(dayN), month, Integer.valueOf(yearS));
		int[] optMonth = DataCalc.maxMinMes(month);
		int max = optMonth[0], min = optMonth[1];
		int maxDIndex = optMonth[2] - dateFromMonth.index();
		String maxDayString = dayName(new DateModified(maxDIndex, month, currentDate.y), langIndex);
		int minDIndex = optMonth[3] - dateFromMonth.index();
		String minDayString = dayName(new DateModified(minDIndex, month, currentDate.y), langIndex);
		int maxCounter = optMonth[4], minCounter = optMonth[5];
		int totalLY[] = DataCalc.totalOfMes(month, currentDate.y - 1);
		int avgMLY = totalLY[1] == 0 ? 0 : totalLY[0] / totalLY[1];
		int totalLY2[] = DataCalc.totalOfMes(month, currentDate.y - 2);
		int avgMLY2 = totalLY2[1] == 0 ? 0 : totalLY2[0] / totalLY2[1];
		int totalLY3[] = DataCalc.totalOfMes(month, currentDate.y - 3);
		int avgMLY3 = totalLY3[1] == 0 ? 0 : totalLY3[0] / totalLY3[1];
		int totalLY4[] = DataCalc.totalOfMes(month, currentDate.y - 4);
		int avgMLY4 = totalLY4[1] == 0 ? 0 : totalLY4[0] / totalLY4[1];
		int totalCY[] = DataCalc.totalOfMes(month, currentDate.y);
		int avgM = totalCY[1] == 0 ? 0 : totalCY[0] / totalCY[1];
		int daysAvg[] = new int[7];
		double daysPerc[] = new double[7];
		String[] avgOfMonths = DataCalc.monthsText(month, currentDate.y, langIndex);
		JTextPane sumItem = new JTextPane();
		StyledDocument doc = sumItem.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		sumItem.setFont(new Font("Tahoma", Font.BOLD, 18));
		sumItem.setEditable(false);
		sumItem.setCaret(null);
		sumItem.setOpaque(false);
		Color fadeColor = colorSelected == 2 ? new Color(0, 0, 0, 255) : new Color(255, 255, 255, 255);
		sumItem.setForeground(fadeColor);
		if (avgOfMonths == null) {
			avgOfMonths = new String[15];
			for (int i = 0; i < 12; i++)
				avgOfMonths[i] = "";
			avgOfMonths[12] = "0";
			avgOfMonths[13] = "0";
		}
		// days avg
		daysAvg[0] = DataCalc.avgSpeDayAccMonth("Monday", month);
		daysAvg[1] = DataCalc.avgSpeDayAccMonth("Tuesday", month);
		daysAvg[2] = DataCalc.avgSpeDayAccMonth("Wednesday", month);
		daysAvg[3] = DataCalc.avgSpeDayAccMonth("Thursday", month);
		daysAvg[4] = DataCalc.avgSpeDayAccMonth("Friday", month);
		daysAvg[5] = DataCalc.avgSpeDayAccMonth("Saturday", month);
		daysAvg[6] = DataCalc.avgSpeDayAccMonth("Sunday", month);
		for (int i = 0; i < 7; i++) {
			daysPerc[i] = (double) daysAvg[i] * 100
					/ (daysAvg[0] + daysAvg[1] + daysAvg[2] + daysAvg[3] + daysAvg[4] + daysAvg[5] + daysAvg[6]);
			daysPerc[i] = Math.round(daysPerc[i] * 100);
			daysPerc[i] = daysPerc[i] / 100;
		}
		// top 10 merchandise sell
		List<Map.Entry<String, Integer>> top10 = getTop10MonthlySales(currentDate.y, month);
		List<Map.Entry<String, Double>> top10Price = getTop10MonthlyPrice(currentDate.y, month);
		String top10S = "", top10P = "";
		int rank = 1;
		for (int i = 0; i < top10.size(); i++) {
			if (i > 0 && i < top10.size())
				if (top10.get(i).getValue() == top10.get(i - 1).getValue()) {
					if (i == top10.size() - 1)
						top10S += --rank + "- " + top10.get(i).getKey() + " -> " + top10.get(i).getValue();
					else
						top10S += --rank + "- " + top10.get(i).getKey() + " -> " + top10.get(i).getValue() + "\n\n";
				} else {
					top10S += (i + 1) + "- " + top10.get(i).getKey() + " -> " + top10.get(i).getValue() + "\n\n";
					rank = i + 1;
				}
			else if (i == 0)
				top10S += rank + "- " + top10.get(i).getKey() + " -> " + top10.get(i).getValue() + "\n\n";
			rank++;
		}
		rank = 1;
		for (int i = 0; i < top10Price.size(); i++) {
			if (i > 0 && i < top10Price.size()) {
				if (top10Price.get(i).getValue().equals(top10Price.get(i - 1).getValue())) {
					if (i == top10.size() - 1)
						top10P += --rank + "- " + top10Price.get(i).getKey() + " -> $" + top10Price.get(i).getValue();
					else
						top10P += --rank + "- " + top10Price.get(i).getKey() + " -> $" + top10Price.get(i).getValue()
								+ "\n\n";
				} else {
					top10P += (i + 1) + "- " + top10Price.get(i).getKey() + " -> $" + top10Price.get(i).getValue()
							+ "\n\n";
					rank = i + 1;
				}
			} else
				top10P += rank + "- " + top10Price.get(i).getKey() + " -> $" + top10Price.get(i).getValue() + "\n\n";
			rank++;
		}
		// seller sales of this month
		String sellerText = "";
		rank = 1;
		Map<String, Integer> sortedMap = new HashMap<String, Integer>();
		for (int i = 0; i < employee.size(); i++) {
			int totalMonth = getSalesOfMonthYear(employee.get(i).getName(), month, currentDate.y);
			if (totalMonth > 0)
				sortedMap.put(employee.get(i).getName(),
						getSalesOfMonthYear(employee.get(i).getName(), month, currentDate.y));
		}
		sortedMap = sortedMap.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
				.collect(LinkedHashMap::new, (map, entry) -> map.put(entry.getKey(), entry.getValue()), Map::putAll);
		int totalM = 0;
		for (Map.Entry<String, Integer> entry : sortedMap.entrySet())
			totalM += entry.getValue();
		for (Map.Entry<String, Integer> entry : sortedMap.entrySet())
			sellerText += (rank++) + "- " + entry.getKey() + " -> $" + entry.getValue() + "("
					+ (entry.getValue() * 100 / totalM) + "%)\n\n";

		sumItem.addKeyListener(new KeyAdapter() {// Escape to close
			@Override
			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
					colorX = 0;
					order = 0;
					wordL = 0;
					timer.stop();
					overlay.hideOverlay();
					extraF.dispose();
				}
			}
		});
		// TIMER
		order = 0;
		wordL = 0;
		colorX = 0;
		status = true;
		String[] espSumm = { // Comparation between years 0 + 1
				"I. COMPARACIÓN ENTRE ESTE AÑO Y AÑOS ANTERIORES", // 0
				(conLY4.size() == 0 ? ""
						: "EN " + getMonthForInt(month - 1, 0) + " " + (currentDate.y - 4)
								+ (totalLY4[0] == 0 ? " NO ABRIMOS LA TIENDA!"
										: " VENDISTE EN TOTAL $" + totalLY4[0] + "\n(PROMEDIO = $" + avgMLY4 + ")"))
						+ (conLY3.size() == 0 ? ""
								: "\n\n\nEN " + getMonthForInt(month - 1, 0) + " " + (currentDate.y - 3)
										+ (totalLY3[0] == 0 ? " NO ABRIMOS LA TIENDA!"
												: " VENDISTE EN TOTAL $" + totalLY3[0] + "\n(PROMEDIO = $" + avgMLY3
														+ ")"))
						+ (conLY2.size() == 0 ? ""
								: "\n\n\nEN " + getMonthForInt(month - 1, 0) + " " + (currentDate.y - 2)
										+ (totalLY2[0] == 0 ? " NO ABRIMOS LA TIENDA!"
												: " VENDISTE EN TOTAL $" + totalLY2[0] + "\n(PROMEDIO = $" + avgMLY2
														+ ")"))
						+ (conLY.size() == 0 ? ""
								: "\n\n\nEN " + getMonthForInt(month - 1, 0) + " " + (currentDate.y - 1)
										+ (totalLY[0] == 0 ? " NO ABRIMOS LA TIENDA!"
												: " VENDISTE EN TOTAL $" + totalLY[0] + "\n(PROMEDIO = $" + avgMLY
														+ ")"))
						+ "\n\n\nEN " + getMonthForInt(month - 1, 0) + " DE ESTE AÑO VENDISTE EN TOTAL $" + totalCY[0]
						+ "\n(PROMEDIO = $" + avgM + ")",
				// EXTREMUIM OF THE YEAR 2 + 3
				"II. EXTREMA DEL MES",
				(minCounter > 1
						? "LA PEOR VENTA POR DIA DE " + getMonthForInt(month - 1, 0) + "\n\nPASÓ " + minCounter
								+ " VECES Y ESO ES $" + min
						: "EL PEOR DÍA EN " + getMonthForInt(month - 1, 0) + " ES UN " + minDayString + " " + minDIndex
								+ "-" + month + "\n\nLO QUE VENDIMOS $" + min)
						+ "\n\n\n\n"
						+ (maxCounter > 1
								? "LA MEJOR VENTA POR DIA DE " + getMonthForInt(month - 1, 0) + "\n\nPASÓ " + maxCounter
										+ " VECES Y ESO ES $" + max
								: "EL MEJOR DÍA EN " + getMonthForInt(month - 1, 0) + " ES UN " + maxDayString + " "
										+ maxDIndex + "-" + month + "\n\nLO QUE VENDIMOS $" + max),
				// THE AVERAGE ACCORDING TO THE DAY 4 + 5
				"III. LA MEDIA SEGÚN EL DÍA SON",
				"LUNES -> $" + daysAvg[0] + " (%" + daysPerc[0] + ")\n\n\nMARTES -> $" + daysAvg[1] + " (%"
						+ daysPerc[1] + ")\n\n\nMIÉRCOLES -> $" + daysAvg[2] + " (%" + daysPerc[2]
						+ ")\n\n\nJUEVES -> $" + daysAvg[3] + " (%" + daysPerc[3] + ")\n\n\nVIERNES -> $" + daysAvg[4]
						+ " (%" + daysPerc[4] + ")\n\n\nSÁBADO -> $" + daysAvg[5] + " (%" + daysPerc[5] + ")"
						+ (daysAvg[6] == 0 ? "" : "\n\n\nDOMINGO -> $" + daysAvg[6] + " (%" + daysPerc[6] + ")"),
				// THE AVERAGE OF EVERYMONTH 6 + 7 + 8 + 9
				"IV. EL PROMEDIO DE CADA MES",
				avgOfMonths[0] + "\n\n" + avgOfMonths[1] + "\n\n" + avgOfMonths[2] + "\n\n" + avgOfMonths[3] + "\n\n"
						+ avgOfMonths[4] + "\n\n" + avgOfMonths[5],
				avgOfMonths[6] + "\n\n" + avgOfMonths[7] + "\n\n" + avgOfMonths[8] + "\n\n" + avgOfMonths[9] + "\n\n"
						+ avgOfMonths[10] + "\n\n" + avgOfMonths[11],
				"SE PARECE QUE EN ESTE MES\n\n\nVENDIMOS "
						+ (avgM <= Integer.valueOf(avgOfMonths[13]) ? "MENOS QUE TODOS LOS MESES ANTERIORES"
								: avgM >= Integer.valueOf(avgOfMonths[12]) ? "MÁS QUE TODOS LOS MESES ANTERIORES"
										: "MÁS QUE UNOS MESES Y MENOS QUE OTROS"), // 5 compare mnths
				"V. MAYOR VENTA DEL MES POR CANTIDAD", top10S, //
				"VI. MAYOR VENTA DEL MES POR PRECIO", top10P, //
				"VII. EL MEJOR VENDEDOR DE ESTE MES", sellerText, //
				"NO HAY DATOS TODAVÍA" };
		String[] porSumm = { "I. COMPARAÇÃO ENTRE ESTE ANO E OS ANTERIORES",
				(conLY4.size() == 0 ? ""
						: "EM " + getMonthForInt(month - 1, 1) + " " + (currentDate.y - 4)
								+ (totalLY4[0] == 0 ? " NÃO ABRIMOS A LOJA!"
										: " VENDEU EM TOTAL $" + totalLY4[0] + "\n(MÉDIA = $" + avgMLY4 + ")"))
						+ (conLY3.size() == 0 ? ""
								: "\n\n\nEM " + getMonthForInt(month - 1, 1) + " " + (currentDate.y - 3)
										+ (totalLY3[0] == 0 ? " NÃO ABRIMOS A LOJA!"
												: " VENDEU EM TOTAL $" + totalLY3[0] + "\n(MÉDIA = $" + avgMLY3 + ")"))
						+ (conLY2.size() == 0 ? ""
								: "\n\n\nEM " + getMonthForInt(month - 1, 1) + " " + (currentDate.y - 2)
										+ (totalLY2[0] == 0 ? " NÃO ABRIMOS A LOJA!"
												: " VENDEU EM TOTAL $" + totalLY2[0] + "\n(MÉDIA = $" + avgMLY2 + ")"))
						+ (conLY.size() == 0 ? ""
								: "\n\n\nEM " + getMonthForInt(month - 1, 1) + " " + (currentDate.y - 1)
										+ (totalLY[0] == 0 ? " NÃO ABRIMOS A LOJA!"
												: " VENDEU EM TOTAL $" + totalLY4[0] + "\n(MÉDIA = $" + avgMLY + ")"))
						+ "\n\n\nEM " + getMonthForInt(month - 1, 1) + " ESTE ANO VOCÊ VENDEU NO TOTAL $" + totalCY[0]
						+ "\n(MÉDIA = $" + avgM + ")", // 2021-2022-2023
				"II. EXTREMO DO MÊS",
				(minCounter > 1
						? "A PIOR VENDA POR DIA DE " + getMonthForInt(month - 1, 1) + "\n\nPASSOU " + minCounter
								+ " TEMPOS E ISSO É $" + min
						: "O PIOR DIA EM " + getMonthForInt(month - 1, 1) + " É UM " + minDayString + " " + minDIndex
								+ "-" + month + "\n\nO QUE VENDEMOS $" + min)
						+ "\n\n\n\n"
						+ (maxCounter > 1
								? "A MELHOR VENDA POR DIA DE " + getMonthForInt(month - 1, 1) + "\n\nPASSOU "
										+ maxCounter + " TEMPOS E ISSO É $" + max
								: "O MELHOR DIA EM " + getMonthForInt(month - 1, 1) + " É UM " + maxDayString + " "
										+ maxDIndex + "-" + month + "\n\nO QUE VENDEMOS $" + max), // 1
				"III. A MÉDIA DE ACORDO COM O DIA É",
				"SEGUNDA-FEIRA -> $" + daysAvg[0] + " (%" + daysPerc[0] + ")\n\n\nTERÇA-FEIRA -> $" + daysAvg[1] + " (%"
						+ daysPerc[1] + ")\n\n\nQUARTA-FEIRA -> $" + daysAvg[2] + " (%" + daysPerc[2]
						+ ")\n\n\nQUINTA-FEIRA -> $" + daysAvg[3] + " (%" + daysPerc[3] + ")\n\n\nSEXTA-FEIRA -> $"
						+ daysAvg[4] + " (%" + daysPerc[4] + ")\n\n\nSÁBADO -> $" + daysAvg[5] + " (%" + daysPerc[5]
						+ ")" + (daysAvg[6] == 0 ? "" : "\n\n\nDOMINGO -> $" + daysAvg[6] + " (%" + daysPerc[6] + ")"), // 5
				"IV. A MÉDIA DE CADA MÊS",
				avgOfMonths[0] + "\n\n" + avgOfMonths[1] + "\n\n" + avgOfMonths[2] + "\n\n" + avgOfMonths[3] + "\n\n"
						+ avgOfMonths[4] + "\n\n" + avgOfMonths[5], // 1
				avgOfMonths[6] + "\n\n" + avgOfMonths[7] + "\n\n" + avgOfMonths[8] + "\n\n" + avgOfMonths[9] + "\n\n"
						+ avgOfMonths[10] + "\n\n" + avgOfMonths[11], // 2
				"PARECE QUE EM NESSE MÊS\n\n\nVENDEMOS "
						+ (avgM <= Integer.valueOf(avgOfMonths[13]) ? "MENOS DO QUE TODOS OS MESES ANTERIORES"
								: avgM >= Integer.valueOf(avgOfMonths[12]) ? "MAIS DO QUE TODOS OS MESES ANTERIORES"
										: "MAIS QUE ALGUNS MESES E MENOS QUE OUTROS"), // 3
				"V. MAIS VENDIDOS DO MÊS POR QUANTIDADE", top10S, //
				"VI. MAIS VENDIDOS DO MÊS POR PREÇO", top10P, //
				"VII. O MELHOR VENDEDOR DESTE MÊS", sellerText, //
				"SEM DADOS AINDA" };
		String[] engSumm = { "I. COMPARISON BETWEEN THIS AND PREVIOUS YEARS", // 0
				(conLY4.size() == 0 ? ""
						: "IN " + getMonthForInt(month - 1, 2) + " " + (currentDate.y - 4)
								+ (totalLY4[0] == 0 ? " WE DO NOT OPEN THE STORE!"
										: " YOU SOLD IN TOTAL $" + totalLY4[0] + "\n(AVERAGE = $" + avgMLY4 + ")"))
						+ (conLY3.size() == 0 ? ""
								: "\n\n\nIN " + getMonthForInt(month - 1, 2) + " " + (currentDate.y - 3)
										+ (totalLY3[0] == 0 ? " WE DO NOT OPEN THE STORE!"
												: " YOU SOLD IN TOTAL $" + totalLY3[0] + "\n(AVERAGE = $" + avgMLY3
														+ ")"))
						+ (conLY2.size() == 0 ? ""
								: "\n\n\nIN " + getMonthForInt(month - 1, 2) + " " + (currentDate.y - 2)
										+ (totalLY2[0] == 0 ? " WE DO NOT OPEN THE STORE!"
												: " YOU SOLD IN TOTAL $" + totalLY2[0] + "\n(AVERAGE = $" + avgMLY2
														+ ")"))
						+ (conLY.size() == 0 ? ""
								: "\n\n\nIN " + getMonthForInt(month - 1, 2) + " " + (currentDate.y - 1)
										+ (totalLY[0] == 0 ? " WE DO NOT OPEN THE STORE!"
												: " YOU SOLD IN TOTAL $" + totalLY[0] + "\n(AVERAGE = $" + avgMLY
														+ ")"))
						+ "\n\n\nIN " + getMonthForInt(month - 1, 2) + " OF THIS YEAR YOU SOLD IN TOTAL $" + totalCY[0]
						+ "\n(AVERAGE = $" + avgM + ")", // 0
				"II. EXTREMUM OF THE MONTH",
				(minCounter > 1
						? "THE WORST SALE PER DAY OF " + getMonthForInt(month - 1, 2) + "\n\nHAPPENED " + minCounter
								+ " TIMES AND IT'S $" + min
						: "THE WORST DAY IN " + getMonthForInt(month - 1, 2) + " IT'S A " + minDayString + " "
								+ minDIndex + "-" + month + "\n\nWHAT WE SOLD $" + min)
						+ "\n\n\n\n"
						+ (maxCounter > 1
								? "THE BEST SALE PER DAY OF " + getMonthForInt(month - 1, 2) + "\n\nHAPPENED "
										+ maxCounter + " TIMES AND IT'S $" + max
								: "THE BEST DAY IN " + getMonthForInt(month - 1, 2) + " IT'S A " + maxDayString + " "
										+ maxDIndex + "-" + month + "\n\nWHAT WE SOLD $" + max), // 1
				"III. THE AVERAGE ACCORDING TO THE DAY ARE",
				"MONDAY -> $" + daysAvg[0] + " (%" + daysPerc[0] + ")\n\n\nTUESDAY -> $" + daysAvg[1] + " (%"
						+ daysPerc[1] + ")\n\n\nWEDNESDAY -> $" + daysAvg[2] + " (%" + daysPerc[2]
						+ ")\n\n\nTHURSDAY -> $" + daysAvg[3] + " (%" + daysPerc[3] + ")\n\n\nFRIDAY -> $" + daysAvg[4]
						+ " (%" + daysPerc[4] + ")\n\n\nSATURDAY -> $" + daysAvg[5] + " (%" + daysPerc[5] + ")"
						+ (daysAvg[6] == 0 ? "" : "\n\n\nSUNDAY -> $" + daysAvg[6] + " (%" + daysPerc[6] + ")"), // 5
				"IV. THE AVERAGE OF EVERY MONTH",
				avgOfMonths[0] + "\n\n" + avgOfMonths[1] + "\n\n" + avgOfMonths[2] + "\n\n" + avgOfMonths[3] + "\n\n"
						+ avgOfMonths[4] + "\n\n" + avgOfMonths[5], // 2
				avgOfMonths[6] + "\n\n" + avgOfMonths[7] + "\n\n" + avgOfMonths[8] + "\n\n" + avgOfMonths[9] + "\n\n"
						+ avgOfMonths[10] + "\n\n" + avgOfMonths[11], // 3
				"IT SEEMS THAT IN THIS MONTH\n\n\nWE SOLD "
						+ (avgM <= Integer.valueOf(avgOfMonths[13]) ? "LESS THAN ALL PREVIOUS MONTHS"
								: avgM >= Integer.valueOf(avgOfMonths[12]) ? "MORE THAN ALL PREVIOUS MONTHS"
										: "MORE THAN SOME MONTHS AND LESS THAN OTHERS"), // 4
				"V. TOP SELL OF MONTH BY QUANTITY", top10S, //
				"VI. TOP SELL OF MONTH BY PRICE", top10P, //
				"VII. SELLERS TOTAL SALE OF THIS MONTH", sellerText, //
				"NO DATA YET" };
		String[] frSumm = { "I. COMPARAISON ENTRE CETTE ANNÉE ET LES ANNÉES PRÉCÉDENTES", // 0
				(conLY4.size() == 0 ? ""
						: "EN " + getMonthForInt(month - 1, 3) + " " + (currentDate.y - 4)
								+ (totalLY4[0] == 0 ? " NOUS N'OUVRONS PAS LE MAGASIN!"
										: " VOUS AVEZ VENDU AU TOTAL $" + totalLY4[0] + "\n(MOYENNE = $" + avgMLY4
												+ ")"))
						+ (conLY3.size() == 0 ? ""
								: "\n\n\nEN " + getMonthForInt(month - 1, 3) + " " + (currentDate.y - 3)
										+ (totalLY3[0] == 0 ? " NOUS N'OUVRONS PAS LE MAGASIN!"
												: " VOUS AVEZ VENDU AU TOTAL $" + totalLY3[0] + "\n(MOYENNE = $"
														+ avgMLY3 + ")"))
						+ (conLY2.size() == 0 ? ""
								: "\n\n\nEN " + getMonthForInt(month - 1, 3) + " " + (currentDate.y - 2)
										+ (totalLY2[0] == 0 ? " NOUS N'OUVRONS PAS LE MAGASIN!"
												: " VOUS AVEZ VENDU AU TOTAL $" + totalLY2[0] + "\n(MOYENNE = $"
														+ avgMLY2 + ")"))
						+ (conLY.size() == 0 ? ""
								: "\n\n\nEN " + getMonthForInt(month - 1, 3) + " " + (currentDate.y - 1)
										+ (totalLY[0] == 0 ? " NOUS N'OUVRONS PAS LE MAGASIN!"
												: " VOUS AVEZ VENDU AU TOTAL $" + totalLY[0] + "\n(MOYENNE = $" + avgMLY
														+ ")"))
						+ "\n\n\n" + "EN " + getMonthForInt(month - 1, 3)
						+ " DE CETTE ANNÉE, VOUS AVEZ VENDU AU TOTAL $" + totalCY[0] + "\n(MOYENNE = $" + avgM + ")", // 1
				"II. EXTREMUM DU MOIS", // 2
				(minCounter > 1
						? "LA PIRE VENTE PAR JOUR DE " + getMonthForInt(month - 1, 3) + "\n\nARRIVÉE " + minCounter
								+ " TEMPS ET C'EST $" + min
						: "LE PIRE JOUR EN " + getMonthForInt(month - 1, 3) + " C'EST UN " + minDayString + " "
								+ minDIndex + "-" + month + "\n\nCE QUE NOUS AVONS VENDU $" + min)
						+ "\n\n\n\n"
						+ (maxCounter > 1
								? "LA MEILLEURE VENTE PAR JOUR DE " + getMonthForInt(month - 1, 3) + "\n\nARRIVÉE "
										+ maxCounter + " TEMPS ET C'EST $" + max
								: "LE MEILLEUR JOUR EN " + getMonthForInt(month - 1, 3) + " C'EST UN " + maxDayString
										+ " " + maxDIndex + "-" + month + "\n\nCE QUE NOUS AVONS VENDU $" + max), // 3
				"III. LA MOYENNE SELON LE JOUR EST", // 4
				"LUNDI -> $" + daysAvg[0] + " (%" + daysPerc[0] + ")\n\n\nMARDI -> $" + daysAvg[1] + " (%" + daysPerc[1]
						+ ")\n\n\nMERCREDI -> $" + daysAvg[2] + " (%" + daysPerc[2] + ")\n\n\nJEUDI -> $" + daysAvg[3]
						+ " (%" + daysPerc[3] + ")\n\n\nVENDREDI -> $" + daysAvg[4] + " (%" + daysPerc[4]
						+ ")\n\n\nSAMEDI -> $" + daysAvg[5] + " (%" + daysPerc[5] + ")"
						+ (daysAvg[6] == 0 ? "" : "\n\n\nDIMANCHE -> $" + daysAvg[6] + " (%" + daysPerc[6] + ")"), // 5
				"IV. LA MOYENNE DE CHAQUE MOIS", // 6
				avgOfMonths[0] + "\n\n" + avgOfMonths[1] + "\n\n" + avgOfMonths[2] + "\n\n" + avgOfMonths[3] + "\n\n"
						+ avgOfMonths[4] + "\n\n" + avgOfMonths[5], // 7
				avgOfMonths[6] + "\n\n" + avgOfMonths[7] + "\n\n" + avgOfMonths[8] + "\n\n" + avgOfMonths[9] + "\n\n"
						+ avgOfMonths[10] + "\n\n" + avgOfMonths[11], // 8
				"IL SEMBLE QUE CE MOIS\n\n\nNOUS AVONS VENDU "
						+ (avgM <= Integer.valueOf(avgOfMonths[13]) ? "MOINS QUE TOUS LES MOIS PRÉCÉDENTS"
								: avgM >= Integer.valueOf(avgOfMonths[12]) ? "PLUS QUE TOUS LES MOIS PRÉCÉDENTS"
										: "PLUS QUE CERTAINS MOIS ET MOINS QUE D'AUTRES"), // 9
				"V. MEILLEURE VENTE DU MOIS PAR QUANTITÉ", top10S, // 11
				"VI. MEILLEURE VENTE DU MOIS PAR PRIX", top10P, // 13
				"VII. MEILLEUR VENDEUR DE CE MOIS", sellerText, // 14
				"PAS DE DONNÉES ENCORE"// 15
		};
		ActionListener letterByLetter = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (order >= espSumm.length) {
					timer.stop();
					return;
				}
				if (totalCY[0] == 0)
					order = 16;
				if (order == 0
						&& (conLY.size() == 0 && conLY2.size() == 0 && conLY3.size() == 0 && conLY4.size() == 0)) {
					order = 2;
					wordL = 0;
					sumItem.setText("");
					return;
				}
				if ((order == 10 && top10.size() == 0) || (order == 12 && top10Price.size() == 0)
						|| (order == 14 && employee.size() == 0)) {
					order += 2;
					wordL = 0;
					sumItem.setText("");
					return;
				}

				// Determine the text array based on the language and current order
				String currentText = (language == Language.SPANISH ? espSumm[order]
						: language == Language.PORTUGUES ? porSumm[order]
								: language == Language.ENGLISH ? engSumm[order] : frSumm[order]);

				// Convert the current text to a char array
				char[] wordT = currentText.toCharArray();

				// If text is empty and we're not at the last case, move to the next order
				if (wordT.length == 0 && order != 15) {
					order++;
					wordL = 0;
					sumItem.setText("");
					return;
				}

				// Handle typing the text letter by letter
				if (wordL < wordT.length) {
					sumItem.setText(sumItem.getText() + wordT[wordL++]);
				} else if (wordL < wordT.length + 15) {
					wordL++;
				} else {
					// When finished with the current order, move to the next one
					if (order < 15) {
						if ((month == 1 && order == 5)) {
							order = 10;
							wordL = 0;
							sumItem.setText("");
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					} else {
						// Stop after the last case (case 12)
						timer.stop();
					}
				}
			}
		};
		ActionListener fadeTimer = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (order == 0
						&& (conLY.size() == 0 && conLY2.size() == 0 && conLY3.size() == 0 && conLY4.size() == 0)) {
					order = 2; // Move to the next order if the text is blank
					status = true; // Start fading in the next item
					return; // Skip the rest of the fade logic for case 5
				}

				// Select the appropriate text for the current language and order
				String[] summaries = { espSumm[order], porSumm[order], engSumm[order], frSumm[order] };
				String text = summaries[language.ordinal()];
				sumItem.setText(text);

				// no data
				if (totalCY[0] == 0)
					order = 16;

				// Handle special case for order 6 (skip to next order if text is blank)
				if (order == 8 && sumItem.getText().isBlank()) {
					order++; // Move to the next order if the text is blank
					status = true; // Start fading in the next item
					return; // Skip the rest of the fade logic for case 5
				}

				if ((order == 10 && top10.size() == 0) || (order == 12 && top10Price.size() == 0)
						|| (order == 14 && employee.size() == 0)) {
					order += 2;
					status = true;
					return;
				}

				// Set the fade color (black for dark mode, white for light mode)
				Color fadeColor = (colorSelected == 2) ? new Color(0, 0, 0, colorX) : new Color(255, 255, 255, colorX);
				sumItem.setForeground(fadeColor);

				if (status) {
					// Fade in
					if (colorX < 254) {
						colorX++; // Fade in
					} else {
						// When fully faded in, start fading out
						status = false;
					}
				} else {
					// Fade out
					if (colorX > 0 && order < 15)
						colorX -= 2; // Fade out
					else {
						if ((month == 1 && order == 5)) {
							order = 10;
							status = true; // Start fading in again
						}
						// Once fully faded out, move to the next order
						else if (order < 15) {
							order++; // Go to the next order
							status = true; // Start fading in again
						} else {
							timer.stop(); // Stop the timer after all orders are shown
						}
					}
				}
			}
		};
		ActionListener wordByWord = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				switch (order) {
				case 0: {// COMPARE 2022 AND 2023
					if (order == 0
							&& (conLY.size() == 0 && conLY2.size() == 0 && conLY3.size() == 0 && conLY4.size() == 0)) {
						order = 2;
						wordL = 0;
						sumItem.setText("");
					} else {
						String[] wordT = language == Language.SPANISH ? espSumm[0].split(" ")
								: language == Language.PORTUGUES ? porSumm[0].split(" ")
										: language == Language.ENGLISH ? engSumm[0].split(" ") : frSumm[0].split(" ");
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					}
					break;
				}
				case 1: {// COMPARE 2022 AND 2023
					String[] wordT = language == Language.SPANISH ? espSumm[1].split(" ")
							: language == Language.PORTUGUES ? porSumm[1].split(" ")
									: language == Language.ENGLISH ? engSumm[1].split(" ") : frSumm[1].split(" ");
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							if (DataCalc.monthsText(month, currentDate.y, langIndex) == null)
								break;
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 2: {// BEST AND WORST DAY
					String[] wordT = language == Language.SPANISH ? espSumm[2].split(" ")
							: language == Language.PORTUGUES ? porSumm[2].split(" ")
									: language == Language.ENGLISH ? engSumm[2].split(" ") : frSumm[2].split(" ");
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 3: {// BEST AND WORST DAY
					String[] wordT = language == Language.SPANISH ? espSumm[3].split(" ")
							: language == Language.PORTUGUES ? porSumm[3].split(" ")
									: language == Language.ENGLISH ? engSumm[3].split(" ") : frSumm[3].split(" ");
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 4: {// AVG FOR EACH DAY
					String[] wordT = language == Language.SPANISH ? espSumm[4].split(" ")
							: language == Language.PORTUGUES ? porSumm[4].split(" ")
									: language == Language.ENGLISH ? engSumm[4].split(" ") : frSumm[4].split(" ");
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 5: {// AVG FOR EACH DAY
					String[] wordT = language == Language.SPANISH ? espSumm[5].split(" ")
							: language == Language.PORTUGUES ? porSumm[5].split(" ")
									: language == Language.ENGLISH ? engSumm[5].split(" ") : frSumm[5].split(" ");
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							if (month == 1) {
								order = 10;
								sumItem.setText("");
							} else {
								order++;
								sumItem.setText("");
							}
							wordL = 0;
						}
					}
					break;
				}
				case 6: {// MONTHS
					String[] wordT = language == Language.SPANISH ? espSumm[6].split(" ")
							: language == Language.PORTUGUES ? porSumm[6].split(" ")
									: language == Language.ENGLISH ? engSumm[6].split(" ") : frSumm[6].split(" ");
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 7: {// MONTHS
					String[] wordT = language == Language.SPANISH ? espSumm[7].split(" ")
							: language == Language.PORTUGUES ? porSumm[7].split(" ")
									: language == Language.ENGLISH ? engSumm[7].split(" ") : frSumm[7].split(" ");
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 8: {
					String[] wordT = language == Language.SPANISH ? espSumm[8].split(" ")
							: language == Language.PORTUGUES ? porSumm[8].split(" ")
									: language == Language.ENGLISH ? engSumm[8].split(" ") : frSumm[8].split(" ");
					if (wordT.length == 1) {
						order++;
						wordL = 0;
						sumItem.setText("");
					} else if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 9: {// COMPARE MONTHS
					String[] wordT = language == Language.SPANISH ? espSumm[9].split(" ")
							: language == Language.PORTUGUES ? porSumm[9].split(" ")
									: language == Language.ENGLISH ? engSumm[9].split(" ") : frSumm[9].split(" ");
					if (wordT.length == 1) {
						order++;
						wordL = 0;
						sumItem.setText("");
					} else if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 10: {// COMPARE MONTHS
					String[] wordT = language == Language.SPANISH ? espSumm[10].split(" ")
							: language == Language.PORTUGUES ? porSumm[10].split(" ")
									: language == Language.ENGLISH ? engSumm[10].split(" ") : frSumm[10].split(" ");

					if (top10.size() == 0) {
						order += 2;
						wordL = 0;
						sumItem.setText("");
					} else if (wordT.length == 1) {
						order++;
						wordL = 0;
						sumItem.setText("");
					} else if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 11: {// COMPARE MONTHS
					String[] wordT = language == Language.SPANISH ? espSumm[11].split(" ")
							: language == Language.PORTUGUES ? porSumm[11].split(" ")
									: language == Language.ENGLISH ? engSumm[11].split(" ") : frSumm[11].split(" ");

					if (wordT.length == 1) {
						order++;
						wordL = 0;
						sumItem.setText("");
					} else if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 12: {// COMPARE MONTHS
					String[] wordT = language == Language.SPANISH ? espSumm[12].split(" ")
							: language == Language.PORTUGUES ? porSumm[12].split(" ")
									: language == Language.ENGLISH ? engSumm[12].split(" ") : frSumm[12].split(" ");
					if (top10Price.size() == 0) {
						order += 2;
						wordL = 0;
						sumItem.setText("");
					} else if (wordT.length == 1) {
						order++;
						wordL = 0;
						sumItem.setText("");
					} else if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 13: {// COMPARE MONTHS
					String[] wordT = language == Language.SPANISH ? espSumm[13].split(" ")
							: language == Language.PORTUGUES ? porSumm[13].split(" ")
									: language == Language.ENGLISH ? engSumm[13].split(" ") : frSumm[13].split(" ");
					if (wordT.length == 1) {
						order++;
						wordL = 0;
						sumItem.setText("");
					} else if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 14: {// COMPARE MONTHS
					String[] wordT = language == Language.SPANISH ? espSumm[14].split(" ")
							: language == Language.PORTUGUES ? porSumm[14].split(" ")
									: language == Language.ENGLISH ? engSumm[14].split(" ") : frSumm[14].split(" ");
					if (employee.size() == 0) {
						order += 2;
						wordL = 0;
						sumItem.setText("");
					} else if (wordT.length == 1) {
						order++;
						wordL = 0;
						sumItem.setText("");
					} else if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 15: {// COMPARE MONTHS
					String[] wordT = language == Language.SPANISH ? espSumm[15].split(" ")
							: language == Language.PORTUGUES ? porSumm[15].split(" ")
									: language == Language.ENGLISH ? engSumm[15].split(" ") : frSumm[15].split(" ");
					if (wordT.length == 1) {
						order++;
						wordL = 0;
						sumItem.setText("");
					} else if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 16: {// COMPARE MONTHS
					String[] wordT = language == Language.SPANISH ? espSumm[16].split(" ")
							: language == Language.PORTUGUES ? porSumm[16].split(" ")
									: language == Language.ENGLISH ? engSumm[16].split(" ") : frSumm[16].split(" ");
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						order++;
						timer.stop();
					}
					break;
				}
				default:
					wordL = 0;
					timer.stop();
					break;
				}
			}
		};
		ActionListener movingTB = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (order == 0
						&& (conLY.size() == 0 && conLY2.size() == 0 && conLY3.size() == 0 && conLY4.size() == 0)) {
					order = 2;
					return;
				}
				if (order > 15) {
					wordL = 0;
					timer.stop();
					return;
				}

				if ((order == 10 && top10.size() == 0) || (order == 12 && top10Price.size() == 0)
						|| (order == 14 && employee.size() == 0)) {
					order += 2;
					wordL = 0;
					sumItem.setText("");
					return;
				}

				String[] summaries = (language == Language.SPANISH ? espSumm
						: language == Language.PORTUGUES ? porSumm : language == Language.ENGLISH ? engSumm : frSumm);

				String originalText = summaries[order];
				if (originalText == null || originalText.isBlank()) {
					order++;
					return;
				}

				String scrambledText = TextEffect.scrambleText(originalText);

				// no data
				if (totalCY[0] == 0) {
					order = 16;
					sumItem.setText(summaries[order]);
				} else {
					sumItem.setText(scrambledText);
					wordL++;
					if (wordL >= 20) {
						sumItem.setText(originalText);
						if (wordL < 500) {
							wordL++;
						} else {
							if ((month == 1 && order == 5))
								order = 9;
							else {
								order++;
								wordL = 0;
							}
						}
					}
				}
			}
		};

		if (effChooser == 0) {
			// Speed
			if (conf[6] == null || conf[6].equals("1"))
				speedValue = 15;
			else if (conf[6].equals("0"))
				speedValue = 20;
			else
				speedValue = 1;
			timer = new Timer(speedValue, fadeTimer);
		} else if (effChooser == 1) {
			// Speed
			if (conf[6] == null || conf[6].equals("1"))
				speedValue = 400;
			else if (conf[6].equals("0"))
				speedValue = 500;
			else
				speedValue = 300;
			timer = new Timer(speedValue, wordByWord);
		} else if (effChooser == 2) {
			// Speed
			if (conf[6] == null || conf[6].equals("1"))
				speedValue = 150;
			else if (conf[6].equals("0"))
				speedValue = 300;
			else
				speedValue = 50;
			timer = new Timer(speedValue, letterByLetter);
		} else {
			// Speed
			if (conf[6] == null || conf[6].equals("1"))
				speedValue = 15;
			else if (conf[6].equals("0"))
				speedValue = 20;
			else
				speedValue = 1;
			timer = new Timer(speedValue, movingTB);
		}
		timer.start();

		// If close stop the timer
		extraF.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				colorX = 0;
				order = 0;
				wordL = 0;
				timer.stop();
				overlay.hideOverlay();
			}
		});

		extraF.add(sumItem, gbc);
		extraF.setIconImage(colorSelected == 2 ? ImageEffect.getScaledImage(monthlyI.getImage(), 35, 35).getImage()
				: ImageEffect.invertColor(ImageEffect.getScaledImage(monthlyI.getImage(), 35, 35)).getImage());

		extraF.setVisible(true);
	}

	/* Frame summary of the day */
	private void summaryFrame() {
		JDialog sum = new JDialog(this, "", true);
		sum.setTitle(getLocalizedMessage("TODAY") + " " + getLocalizedMessage("SUMMARY"));
		sum.setSize(700, 600);
		sum.setLocationRelativeTo(null);
		sum.setResizable(false);
		sum.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		// Center horizontally and vertically
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		sum.getContentPane().setBackground(bg);
		overlay.showOverlay();

		// Menubar
		JMenuBar menu = new JMenuBar();
		JMenu file = new JMenu(getLocalizedMessage("FILE"));
		JMenuItem save = new JMenuItem(getLocalizedMessage("SAVE"));
		JMenuItem exit = new JMenuItem(getLocalizedMessage("EXIT"));
		save.addActionListener(_ -> exBtn());
		save.setIcon(colorSelected == 2 ? ImageEffect.getScaledImage(saveI.getImage(), 35, 35)
				: ImageEffect.invertColor(ImageEffect.getScaledImage(saveI.getImage(), 35, 35)));
		exit.setIcon(colorSelected == 2 ? ImageEffect.getScaledImage(exitI.getImage(), 35, 35)
				: ImageEffect.invertColor(ImageEffect.getScaledImage(exitI.getImage(), 35, 35)));
		exit.addActionListener(_ -> {
			sum.dispose();
			overlay.hideOverlay();
		});
		file.add(save);
		file.add(exit);
		menu.add(file);
		sum.setJMenuBar(menu);

		// LABEL
		JTextPane sumItem = new JTextPane();
		StyledDocument doc = sumItem.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		sumItem.setFont(new Font("Tahoma", Font.BOLD, 18));
		sumItem.setEditable(false);
		sumItem.setCaret(null);
		sumItem.setOpaque(false);
		Color fadeColor = colorSelected == 2 ? new Color(0, 0, 0, 255) : new Color(255, 255, 255, 255);
		sumItem.setForeground(fadeColor);
		sumItem.addKeyListener(new KeyAdapter() {// Escape to close
			@Override
			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
					colorX = 0;
					order = 0;
					wordL = 0;
					timer.stop();
					overlay.hideOverlay();
					sum.dispose();
				}
			}
		});
		// TIMER
		order = 0;
		wordL = 0;
		colorX = 0;
		status = true;
		String[] espSumm = { "USTED NO VENDIÓ NADA", // 0
				"USTED VENDIÓ UNA VENTA SOLO QUE VALE $" + totalVenta, // 1
				"USTED VENDIÓ $" + totalVenta + "\n\nDIVIDIENDO EN " + nbVentas() + " VENTAS\n\n"
						+ "CON UN PROMEDIO DE $" + (nbVentas() == 0 ? 0 : totalVenta / nbVentas()) + " POR VENTA", // 2
				"NO TIENES GASTOS!", // 3
				"TIENES EN TOTAL UN GASTO QUE VALE $" + gastosT + "\n\n" + "DETALLADO COMO:\n" + gastosDetalles(), // 4
				"TIENES EN TOTAL $" + gastosT + " COMO GASTOS\n\n" + "DIVIDIDO POR " + nbGastos() + " COSAS\n\n"
						+ "CON UN PROMEDIO DE $" + (nbGastos() == 0 ? 0 : gastosT / nbGastos()) + "\n\n"
						+ "DETALLADO COMO:\n" + gastosDetalles(), // 5
				"NO TIENES AGREGADOS!", // 6
				"TIENES EN TOTAL UN AGREGADO QUE VALE $" + agregadoT + "\n\n" + "DETALLADO COMO:\n"
						+ agregadoDetalles(), // 7
				"TIENES EN TOTAL $" + agregadoT + " COMO AGREGADOS\n\n" + "DIVIDIDO POR " + nbAgregados() + " COSAS\n\n"
						+ "CON UN PROMEDIO DE $" + (nbAgregados() == 0 ? 0 : agregadoT / nbAgregados()) + "\n\n"
						+ "DETALLADO COMO:\n" + agregadoDetalles(), // 8
				"PARA RESUMIR\n\n" + "EMPEZAMOS EL DÍA CON $" + initialDay.getText() + "\n\nY VENDIMOS $" + totalVenta
						+ "\n\nY GASTO $" + gastosT + "\n\nQUE TERMINARÁ CON $" + totalO + " EN TOTAL", // 9
				"PARA RESUMIR\n\n" + "EMPEZAMOS EL DÍA CON $" + initialDay.getText() + "\n\nY VENDIMOS $" + totalVenta
						+ "\n\nY GASTO $" + gastosT + "\n\nY AGREGÓ $" + agregadoT + "\n\nQUE TERMINARÁ CON $" + totalO
						+ " EN TOTAL", // 10
				"LA CAJA DIO BIEN\n\n" + "NO HAY DIFERENCIA\n\n" + ":)", // 11
				"LA CAJA NO DIO BIEN\n\n" + "PARECE QUE " + diffResult.getText().toUpperCase()
						+ "\n\nREVISA LOS BOLETOS Y LA CAJA", // 12
				"QUEDARÁ PARA MAÑANA APROXIMADAMENTE\n\n$" + restN, // 13
				(conLY4.size() == 0 ? ""
						: "EN " + dayN + "-" + monthS + "-" + (currentDate.y - 4) + ",\n\nLO QUE ES UN "// 2021
								+ dayName(new DateModified(Integer.valueOf(dayN), Integer.valueOf(currentDate.m),
										currentDate.y - 4), 0)
								+ (valueLY4 == -1 ? " NO ABRIMOS LA TIENDA!" : ", VENDISTE $" + valueLY4 + " EN TOTAL"))
						+ (conLY3.size() == 0 ? ""
								: "\n\nEN " + dayN + "-" + monthS + "-" + (currentDate.y - 3) + ",\n\nLO QUE ES UN "// 2022
										+ dayName(new DateModified(Integer.valueOf(dayN),
												Integer.valueOf(currentDate.m), currentDate.y - 3), 0)
										+ (valueLY3 == -1 ? " NO ABRIMOS LA TIENDA!"
												: ", VENDISTE $" + valueLY3 + " EN TOTAL"))
						+ (conLY2.size() == 0 ? ""
								: "\n\nEN " + dayN + "-" + monthS + "-" + (currentDate.y - 2) + ",\n\nLO QUE ES UN "// 2023
										+ dayName(new DateModified(Integer.valueOf(dayN),
												Integer.valueOf(currentDate.m), currentDate.y - 2), 0)
										+ (valueLY2 == -1 ? " NO ABRIMOS LA TIENDA!"
												: ", VENDISTE $" + valueLY2 + " EN TOTAL"))
						+ (conLY.size() == 0 ? ""
								: "\n\nEN " + dayN + "-" + monthS + "-" + (currentDate.y - 1) + ",\n\nLO QUE ES UN "// 2024
										+ dayName(new DateModified(Integer.valueOf(dayN),
												Integer.valueOf(currentDate.m), currentDate.y - 1), 0)
										+ (valueLY == -1 ? " NO ABRIMOS LA TIENDA!"
												: ", VENDISTE $" + valueLY + " EN TOTAL"))
						+ "\n\nHOY, " + dayS + " VENDISTE POR AHORA $" + totalVenta, // 14
				"HOY, VENDEMOS EN TOTAL $" + totalVenta + "\n\n\nESTE AÑO VENDIMOS UN PROMEDIO DIARIO DE $" + dailyAvg
						+ (sameDayAvg == 0 ? ""
								: "\n\n\nUN PROMEDIO DE LOS " + dayName(currentDate, 0) + " $" + sameDayAvg)
						+ (monthlyAvg == 0 ? ""
								: "\n\n\nUN PROMEDIO MENSUAL DE " + currentDate.getMonthForInt(0) + " $" + monthlyAvg), // 15
				"SE PARECE QUE VENDIMOS" + (sameDayAvg == 0 ? ""
						: "\n\n$" + (sameDayAvg > totalVenta
								? sameDayAvg - totalVenta + " MENOS QUE EL PROMEDIO DE LOS " + dayName(currentDate, 0)
										+ " ▼ " + 100 * (sameDayAvg - totalVenta) / sameDayAvg
								: (totalVenta - sameDayAvg + " MÁS QUE EL PROMEDIO DE LOS " + dayName(currentDate, 0))
										+ " ▲ " + 100 * (-sameDayAvg + totalVenta) / sameDayAvg)
								+ "%")
						+ "\n\n$"
						+ (dailyAvg > totalVenta
								? dailyAvg - totalVenta + " MENOS QUE EL PROMEDIO DIARIO" + " ▼ "
										+ (dailyAvg == 0 ? 0 : 100 * (dailyAvg - totalVenta) / dailyAvg)
								: (totalVenta - dailyAvg + " MÁS QUE EL PROMEDIO DIARIO") + " ▲ "
										+ (dailyAvg == 0 ? 0 : 100 * (-dailyAvg + totalVenta) / dailyAvg))
						+ "%"
						+ (monthlyAvg == 0 ? ""
								: "\n\n$" + (monthlyAvg > totalVenta
										? monthlyAvg - totalVenta + " MENOS QUE PROMEDIO MENSUAL DE "
												+ currentDate.getMonthForInt(0) + " ▼ "
												+ 100 * (monthlyAvg - totalVenta) / monthlyAvg
										: (totalVenta - monthlyAvg + " MÁS QUE EL PPROMEDIO MENSUAL DE "
												+ currentDate.getMonthForInt(0) + " ▲ "
												+ 100 * (-monthlyAvg + totalVenta) / monthlyAvg))
										+ "%") // 16
		};
		String[] porSumm = { "VOCÊ NÃO VENDEU NADA", // 0
				"VOCÊ VENDEU UMA VENDA SÓ QUE VALE $" + totalVenta, // 1
				"VOCÊ VENDEU $" + totalVenta + "\n\nDIVIDINDO EM " + nbVentas() + " VENDAS\n\n" + "COM MÉDIA DE $"
						+ (nbVentas() == 0 ? 0 : totalVenta / nbVentas()) + " À VENDA", // 2
				"VOCÊ NÃO TEM GASTOS!", // 3
				"VOCÊ TEM NO TOTAL UM GASTO NO VALOR DE $" + gastosT + "\n\n" + "DETALHADO COMO:\n" + gastosDetalles(), // 4
				"VOCÊ TEM NO TOTAL $" + gastosT + " COMO GASTOS\n\n" + "DIVIDIDO POR " + nbGastos() + " COISAS\n\n"
						+ "COM MÉDIA DE $" + (nbGastos() == 0 ? 0 : gastosT / nbGastos()) + "\n\n" + "DETALHADO COMO:\n"
						+ gastosDetalles(), // 5
				"VOCÊ NÃO TEM AGREGADOS!", // 6
				"VOCÊ TEM NO TOTAL UM AGREGADO NO VALOR DE $" + agregadoT + "\n\n" + "DETALHADO COMO:\n"
						+ agregadoDetalles(), // 7
				"VOCÊ TEM NO TOTAL $" + agregadoT + " COMO AGREGADOS\n\n" + "DIVIDIDO POR " + nbAgregados()
						+ " COISAS\n\n" + "COM MÉDIA DE $" + (nbAgregados() == 0 ? 0 : agregadoT / nbAgregados())
						+ "\n\n" + "DETALHADO COMO:\n" + agregadoDetalles(), // 8
				"PARA RESUMIR\n\n" + "COMEÇAMOS O DIA COM $" + initialDay.getText() + "\n\nE VENDEMOS $" + totalVenta
						+ "\n\nE GASTO $" + gastosT + "\n\nQUE VAI ACABAR EM $" + totalO + " EM TOTAL", // 9
				"PARA RESUMIR\n\n" + "COMEÇAMOS O DIA COM $" + initialDay.getText() + "\n\nE VENDEMOS $" + totalVenta
						+ "\n\nE GASTO $" + gastosT + "\n\nE ADICIONO $" + agregadoT + "\n\nQUE VAI ACABAR EM $"
						+ totalO + " EM TOTAL", // 10
				"A CAIXA DEU BEM\n\n" + "NÃO HÁ DIFERENÇA\n\n" + ":)", // 11
				"A CAIXA NÃO DEU BEM\n\n" + "PARECE QUE " + diffResult.getText().toUpperCase()
						+ "\n\nCONFIRA OS INGRESSOS E A CAIXA", // 12
				"FICARÁ PARA AMANHÃ APROXIMADAMENTE\n\n$" + restN, // 13
				(conLY4.size() == 0 ? ""
						: "EM " + dayN + "-" + monthS + "-" + (currentDate.y - 4) + ",\n\nO QUE É UM "
								+ dayName(new DateModified(Integer.valueOf(dayN), Integer.valueOf(currentDate.m),
										currentDate.y - 4), 1)
								+ (valueLY4 == -1 ? " NÃO ABRIMOS A LOJA!"
										: ", VOCÊ VENDEU $" + valueLY4 + " EM TOTAL"))
						+ (conLY3.size() == 0 ? ""
								: "\n\nEM " + dayN + "-" + monthS + "-" + (currentDate.y - 3) + ",\n\nO QUE É UM "
										+ dayName(new DateModified(Integer.valueOf(dayN),
												Integer.valueOf(currentDate.m), currentDate.y - 3), 1)
										+ (valueLY3 == -1 ? " NÃO ABRIMOS A LOJA!"
												: ", VOCÊ VENDEU $" + valueLY3 + " EM TOTAL"))
						+ (conLY2.size() == 0 ? ""
								: "\n\nEM " + dayN + "-" + monthS + "-" + (currentDate.y - 2) + ",\n\nO QUE É UM "
										+ dayName(new DateModified(Integer.valueOf(dayN),
												Integer.valueOf(currentDate.m), currentDate.y - 2), 1)
										+ (valueLY2 == -1 ? " NÃO ABRIMOS A LOJA!"
												: ", VOCÊ VENDEU $" + valueLY2 + " EM TOTAL"))
						+ (conLY.size() == 0 ? ""
								: "\n\nEM " + dayN + "-" + monthS + "-" + (currentDate.y - 1) + ",\n\nO QUE É UM "
										+ dayName(new DateModified(Integer.valueOf(dayN),
												Integer.valueOf(currentDate.m), currentDate.y - 1), 1)
										+ (valueLY == -1 ? " NÃO ABRIMOS A LOJA!"
												: ", VOCÊ VENDEU $" + valueLY + " EM TOTAL"))
						+ "\n\nHOJE, " + dayS + " VENDEU POR AGORA $" + totalVenta, // 15
				"HOJE, VENDEMOS NO TOTAL $" + totalVenta + "\n\n\nESTE ANO VENDEMOS UM MÉDIA DIÁRIA DO $" + dailyAvg
						+ (sameDayAvg == 0 ? "" : "\n\n\nEM MÉDIA DO " + dayName(currentDate, 1) + " $" + sameDayAvg)
						+ (monthlyAvg == 0 ? ""
								: "\n\n\nEM MÉDIA MENSAL DO " + currentDate.getMonthForInt(1) + " $" + monthlyAvg), // 16
				"PARECE QUE VENDEMOS" + (sameDayAvg == 0 ? ""
						: "\n\n$" + (sameDayAvg > totalVenta
								? sameDayAvg - totalVenta + " MENOS QUE A MÉDIA DE OS " + dayName(currentDate, 1)
										+ " ▼ " + 100 * (sameDayAvg - totalVenta) / sameDayAvg
								: totalVenta - sameDayAvg + " MAIS QUE A MÉDIA DE OS " + (dayName(currentDate, 1))
										+ " ▲ " + 100 * (-sameDayAvg + totalVenta) / sameDayAvg)
								+ "%")
						+ "\n\n$"
						+ (dailyAvg > totalVenta
								? dailyAvg - totalVenta + " MENOS QUE A MÉDIA DIÁRIA" + " ▼ "
										+ (dailyAvg == 0 ? 0 : 100 * (dailyAvg - totalVenta) / dailyAvg)
								: totalVenta - dailyAvg + " MAIS QUE A MÉDIA DIÁRIA" + " ▲ "
										+ (dailyAvg == 0 ? 0 : 100 * (-dailyAvg + totalVenta) / dailyAvg))
						+ "%"
						+ (monthlyAvg == 0 ? ""
								: "\n\n$" + (monthlyAvg > totalVenta
										? monthlyAvg - totalVenta + " MENOS QUE A MÉDIA MENSAL "
												+ currentDate.getMonthForInt(1) + " ▼ "
												+ 100 * (monthlyAvg - totalVenta) / monthlyAvg
										: totalVenta - monthlyAvg + " MAIS QUE A MÉDIA MENSAL "
												+ currentDate.getMonthForInt(1) + " ▲ "
												+ 100 * (-monthlyAvg + totalVenta) / monthlyAvg + "%")) };
		String[] engSumm = { "YOU DIDN'T SELL ANYTHING", // 0
				"YOU SELL ONE SALE ONLY WORTH $" + totalVenta, // 1
				"YOU SELL $" + totalVenta + "\n\nDIVIDING INTO " + nbVentas() + " SALES\n\n" + "WITH AVERAGE $"
						+ (nbVentas() == 0 ? 0 : totalVenta / nbVentas()) + " FOR SALE", // 2
				"YOU HAVE NO EXPENSES!", // 3
				"YOU HAVE IN TOTAL A SPENT WORTH $" + gastosT + "\n\n" + "DETAILED LIKE:\n" + gastosDetalles(), // 4
				"YOU HAVE A TOTAL $" + gastosT + " AS EXPENSES\n\n" + "DIVIDED BY " + nbGastos() + " THINGS\n\n"
						+ "WITH AVERAGE OF $" + (nbGastos() == 0 ? 0 : gastosT / nbGastos()) + "\n\n" + "DETAILED AS:\n"
						+ gastosDetalles(), // 5
				"YOU HAVE NO AGGREGATE!", // 6
				"YOU HAVE IN TOTAL AN AGGREGATE WORTH $" + agregadoT + "\n\n" + "DETAILED LIKE:\n" + agregadoDetalles(), // 7
				"YOU HAVE IN TOTAL A $" + agregadoT + " AS AGGREGATES\n\n" + "DIVIDED BY " + nbAgregados()
						+ " THINGS\n\n" + "WITH AVERAGE OF $" + (nbAgregados() == 0 ? 0 : agregadoT / nbAgregados())
						+ "\n\n" + "DETAILED AS:\n" + agregadoDetalles(), // 8
				"TO SUMMARIZE\n\n" + "WE START THE DAY WITH $" + initialDay.getText() + "\n\nAND WE SELL $" + totalVenta
						+ "\n\nAND WE SPENT $" + gastosT + "\n\nWHAT WILL END IN $" + totalO + " IN TOTAL", // 9
				"TO SUMMARIZE\n\n" + "WE START THE DAY WITH $" + initialDay.getText() + "\n\nAND WE SELL $" + totalVenta
						+ "\n\nAND WE SPENT $" + gastosT + "\n\nAND WE ADD $" + agregadoT + "\n\nWHAT WILL END IN $"
						+ totalO + " IN TOTAL", // 10
				"THE CASH DID WELL\n\n" + "NO DIFFERENCE\n\n" + ":)", // 11
				"THE CASH DIDN'T FIT\n\n" + "LOOKS LIKE THERE ARE " + diffResult.getText().toUpperCase()
						+ "\n\nRE-CHECK THE TICKETS AND THE BOX", // 12
				"WILL BE OUT TOMORROW APPROXIMATELY\n\n$" + restN, // 13
				(conLY4.size() == 0 ? ""
						: "ON " + dayN + "-" + monthS + "-" + (currentDate.y - 4) + ",\n\nWHICH IS A "
								+ dayName(new DateModified(Integer.valueOf(dayN), Integer.valueOf(currentDate.m),
										currentDate.y - 4), 2)
								+ (valueLY4 == -1 ? " WE DO NOT OPEN THE STORE!"
										: ", YOU SOLD $" + valueLY4 + " IN TOTAL"))
						+ (conLY3.size() == 0 ? ""
								: "\n\nON " + dayN + "-" + monthS + "-" + (currentDate.y - 3) + ",\n\nWHICH IS A "
										+ dayName(new DateModified(Integer.valueOf(dayN),
												Integer.valueOf(currentDate.m), currentDate.y - 3), 2)
										+ (valueLY3 == -1 ? " WE DO NOT OPEN THE STORE!"
												: ", YOU SOLD $" + valueLY3 + " IN TOTAL"))
						+ (conLY2.size() == 0 ? ""
								: "\n\nON " + dayN + "-" + monthS + "-" + (currentDate.y - 2) + ",\n\nWHICH IS A "
										+ dayName(new DateModified(Integer.valueOf(dayN),
												Integer.valueOf(currentDate.m), currentDate.y - 2), 2)
										+ (valueLY2 == -1 ? " WE DO NOT OPEN THE STORE!"
												: ", YOU SOLD $" + valueLY2 + " IN TOTAL"))
						+ (conLY.size() == 0 ? ""
								: "\n\nON " + dayN + "-" + monthS + "-" + (currentDate.y - 1) + ",\n\nWHICH IS A "
										+ dayName(new DateModified(Integer.valueOf(dayN),
												Integer.valueOf(currentDate.m), currentDate.y - 1), 2)
										+ (valueLY == -1 ? " WE DO NOT OPEN THE STORE!"
												: ", YOU SOLD $" + valueLY + " IN TOTAL"))
						+ "\n\nTODAY, " + dayS + " YOU SOLD FOR NOW $" + totalVenta, // 15
				"TODAY, WE SOLD IN TOTAL $" + totalVenta + "\n\n\nTHIS YEAR WE SOLD A DAILY AVERAGE OF $" + dailyAvg
						+ (sameDayAvg == 0 ? ""
								: "\n\n\nAN AVERAGE OF THE " + dayName(currentDate, 2) + " $" + sameDayAvg)
						+ (monthlyAvg == 0 ? ""
								: "\n\n\nA MONTHLY AVERAGE OF " + currentDate.getMonthForInt(2) + " $" + monthlyAvg), // 16
				"IT LOOKS LIKE WE SOLD" + (sameDayAvg == 0 ? ""
						: "\n\n$" + (sameDayAvg > totalVenta
								? sameDayAvg - totalVenta + " LESS THAN THE AVERAGE OF THE " + dayName(currentDate, 2)
										+ " ▼ " + 100 * (sameDayAvg - totalVenta) / sameDayAvg
								: (totalVenta - sameDayAvg + " MORE THAN THE AVERAGE OF THE " + dayName(currentDate, 2)
										+ " ▲ " + 100 * (-sameDayAvg + totalVenta) / sameDayAvg))
								+ "%")
						+ "\n\n$"
						+ (dailyAvg > totalVenta
								? dailyAvg - totalVenta + " LESS THAN THE DAILY AVERAGE" + " ▼ "
										+ (dailyAvg == 0 ? 0 : 100 * (dailyAvg - totalVenta) / dailyAvg)
								: (totalVenta - dailyAvg + " MORE THAN THE DAILY AVERAGE" + " ▲ "
										+ (dailyAvg == 0 ? 0 : 100 * (-dailyAvg + totalVenta) / dailyAvg)))
						+ "%"
						+ (monthlyAvg == 0 ? ""
								: "\n\n$" + (monthlyAvg > totalVenta
										? monthlyAvg - totalVenta + " LESS THAN THE MONTHLY AVERAGE OF "
												+ currentDate.getMonthForInt(2) + " ▼ "
												+ 100 * (monthlyAvg - totalVenta) / monthlyAvg
										: (totalVenta - monthlyAvg + " MORE THAN THE MONTHLY AVERAGE OF "
												+ currentDate.getMonthForInt(2) + " ▲ "
												+ 100 * (-monthlyAvg + totalVenta) / monthlyAvg))
										+ "%") };
		String[] frSumm = { "VOUS N'AVEZ RIEN VENDU", // 0
				"VOUS VENDEZ UNE SEULE VENTE D'UNE VALEUR $" + totalVenta, // 1
				" VOUS VENDEZ $ " + totalVenta + " \n\nDIVISER EN " + nbVentas() + " VENTES\n\n " + " AVEC MOYENNE $ "
						+ (nbVentas() == 0 ? 0 : totalVenta / nbVentas()) + " A VENDRE", // 2
				"VOUS N'AVEZ PAS DE DÉPENSES !", // 3
				"VOUS AVEZ DÉPENSÉ AU TOTAL $" + gastosT + "\n\n" + "DÉTAILLÉ COMME :\n" + gastosDetalles(), // 4
				"VOUS AVEZ UN TOTAL $" + gastosT + " COMME DÉPENSES\n\n" + "DIVISÉ PAR " + nbGastos() + " CHOSES\n\n"
						+ "AVEC MOYENNE DE $" + (nbGastos() == 0 ? 0 : gastosT / nbGastos()) + "\n\n"
						+ "DÉTAILLÉ COMME :\n" + gastosDetalles(), // 5
				"VOUS N'AVEZ PAS D'AGRÉGAT !", // 6
				"VOUS AVEZ AU TOTAL UNE VALEUR GLOBALE DE $" + agregadoT + "\n\n" + "DÉTAILLÉ COMME :\n"
						+ agregadoDetalles(), // 7
				"VOUS AVEZ AU TOTAL UN $" + agregadoT + " COMME AGRÉGATS\n\n" + "DIVISÉ PAR " + nbAgregados()
						+ " CHOSES\n\n" + "AVEC MOYENNE DE $" + (nbAgregados() == 0 ? 0 : agregadoT / nbAgregados())
						+ "\n\n" + "DÉTAILLÉ COMME :\n" + agregadoDetalles(), // 8
				"POUR RÉSUMER\n\n" + "NOUS COMMENÇONS LA JOURNÉE AVEC $" + initialDay.getText()
						+ "\n\nET NOUS VENDONS $" + totalVenta + "\n\nET NOUS AVONS DÉPENSÉ $" + gastosT
						+ "\n\nCE QUI SE TERMINERA EN $" + totalO + " AU TOTAL ", // 9
				"POUR RÉSUMER\n\n" + "NOUS COMMENÇONS LA JOURNÉE AVEC $" + initialDay.getText()
						+ "\n\nET NOUS VENDONS $" + totalVenta + "\n\nET NOUS AVONS DÉPENSÉ $" + gastosT
						+ "\n\nET NOUS AJOUTONS $" + agregadoT + "\n\nCE QUI SE TERMINERA EN $" + totalO + " AU TOTAL", // 10
				"LE CASH A BIEN FAIT\n\n" + "PAS DE DIFFÉRENCE\n\n" + ":)", // 11
				"L'ARGENT N'A PAS CONVENU\n\n" + "SEMBLE COMME IL Y EN A" + diffResult.getText().toUpperCase()
						+ "\n\nREVÉRIFIEZ LES BILLETS ET LA BOÎTE", // 12
				"SERA DEHORS DEMAIN ENVIRON\n\n$" + restN, // 13
				(conLY4.size() == 0 ? ""
						: "EN " + dayN + "-" + monthS + "-" + (currentDate.y - 4) + ",\n\nQUI EST UN "
								+ dayName(new DateModified(Integer.valueOf(dayN), Integer.valueOf(currentDate.m),
										currentDate.y - 4), 3)
								+ (valueLY4 == -1 ? " NOUS N'OUVRONS PAS LE MAGASIN!"
										: ", VOUS AVEZ VENDU $" + valueLY4 + " EN TOTAL"))
						+ (conLY3.size() == 0 ? ""
								: "\n\nEN " + dayN + "-" + monthS + "-" + (currentDate.y - 3) + ",\n\nQUI EST UN "
										+ dayName(new DateModified(Integer.valueOf(dayN),
												Integer.valueOf(currentDate.m), currentDate.y - 3), 3)
										+ (valueLY3 == -1 ? " NOUS N'OUVRONS PAS LE MAGASIN!"
												: ", VOUS AVEZ VENDU $" + valueLY3 + " EN TOTAL"))
						+ (conLY2.size() == 0 ? ""
								: "\n\nEN " + dayN + "-" + monthS + "-" + (currentDate.y - 2) + ",\n\nQUI EST UN "
										+ dayName(new DateModified(Integer.valueOf(dayN),
												Integer.valueOf(currentDate.m), currentDate.y - 2), 3)
										+ (valueLY2 == -1 ? " NOUS N'OUVRONS PAS LE MAGASIN!"
												: ", VOUS AVEZ VENDU $" + valueLY2 + " EN TOTAL"))
						+ (conLY.size() == 0 ? ""
								: "\n\nEN " + dayN + "-" + monthS + "-" + (currentDate.y - 1) + ",\n\nQUI EST UN "
										+ dayName(new DateModified(Integer.valueOf(dayN),
												Integer.valueOf(currentDate.m), currentDate.y - 1), 3)
										+ (valueLY == -1 ? " NOUS N'OUVRONS PAS LE MAGASIN!"
												: ", VOUS AVEZ VENDU $" + valueLY + " EN TOTAL"))
						+ "\n\nAUJOURD'HUI, " + dayS + " VOUS AVEZ VENDU POUR MAINTENANT $" + totalVenta, // 15
				"AUJOURD'HUI, NOUS AVONS VENDU AU TOTAL $" + totalVenta
						+ "\n\n\nCETTE ANNÉE, NOUS AVONS VENDU UNE MOYENNE QUOTIDIENNE DE $" + dailyAvg
						+ (sameDayAvg == 0 ? ""
								: "\n\n\nUNE MOYENNE DES " + dayName(currentDate, 3) + " $" + sameDayAvg)
						+ (monthlyAvg == 0 ? ""
								: "\n\n\nUNE monthlyAvg DE " + currentDate.getMonthForInt(3) + " $" + monthlyAvg), // 16
				"IL SEMBLE QUE NOUS AVONS VENDU" + (sameDayAvg == 0 ? ""
						: "\n\n$" + (sameDayAvg > totalVenta
								? sameDayAvg - totalVenta + " MOINS QUE LA MOYENNE DES " + dayName(currentDate, 3)
										+ " ▼ " + 100 * (sameDayAvg - totalVenta) / sameDayAvg
								: (totalVenta - sameDayAvg + " PLUS QUE LA MOYENNE DES " + dayName(currentDate, 3)
										+ " ▲ " + 100 * (-sameDayAvg + totalVenta) / sameDayAvg))
								+ "%")
						+ "\n\n$"
						+ (dailyAvg > totalVenta
								? dailyAvg - totalVenta + " MOINS QUE LA MOYENNE QUOTIDIENNE" + " ▼ "
										+ (dailyAvg == 0 ? 0 : 100 * (dailyAvg - totalVenta) / dailyAvg)
								: (totalVenta - dailyAvg + " PLUS QUE LA MOYENNE QUOTIDIENNE" + " ▲ "
										+ (dailyAvg == 0 ? 0 : 100 * (-dailyAvg + totalVenta) / dailyAvg)))
						+ "%"
						+ (monthlyAvg == 0 ? ""
								: "\n\n$" + (monthlyAvg > totalVenta
										? monthlyAvg - totalVenta + " MOINS QUE LA monthlyAvg DE "
												+ currentDate.getMonthForInt(3) + " ▼ "
												+ 100 * (monthlyAvg - totalVenta) / monthlyAvg
										: (totalVenta - monthlyAvg + " PLUS QUE LA monthlyAvg DE "
												+ currentDate.getMonthForInt(3) + " ▲ "
												+ 100 * (-monthlyAvg + totalVenta) / monthlyAvg))
										+ "%") };

		ActionListener fadeTimer = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Color fadeColor = colorSelected == 2 ? new Color(0, 0, 0, colorX) : new Color(255, 255, 255, colorX);
				sumItem.setForeground(fadeColor);
				switch (order) {
				case 0: {// details start
					if (totalVenta == 0) {
						sumItem.setText(language == Language.SPANISH ? espSumm[0]
								: language == Language.PORTUGUES ? porSumm[0]
										: language == Language.ENGLISH ? engSumm[0] : frSumm[0]);
					} else {
						if (nbVentas() == 1) {
							sumItem.setText(language == Language.SPANISH ? espSumm[1]
									: language == Language.PORTUGUES ? porSumm[1]
											: language == Language.ENGLISH ? engSumm[1] : frSumm[1]);
						} else {
							sumItem.setText(language == Language.SPANISH ? espSumm[2]
									: language == Language.PORTUGUES ? porSumm[2]
											: language == Language.ENGLISH ? engSumm[2] : frSumm[2]);
						}
					}
					if (colorX < 254 && status)// Details fade in
						colorX++;
					else {
						status = false;
						if (colorX > 0)// Details fade out
							colorX -= 2;
						else
							order++;
					}
					break;
				}
				case 1: {// gastos start
					if (gastosT == 0) {
						sumItem.setText(language == Language.SPANISH ? espSumm[3]
								: language == Language.PORTUGUES ? porSumm[3]
										: language == Language.ENGLISH ? engSumm[3] : frSumm[3]);
					} else {
						if (nbGastos() == 1) {
							sumItem.setText(language == Language.SPANISH ? espSumm[4]
									: language == Language.PORTUGUES ? porSumm[4]
											: language == Language.ENGLISH ? engSumm[4] : frSumm[4]);
						} else {
							sumItem.setText(language == Language.SPANISH ? espSumm[5]
									: language == Language.PORTUGUES ? porSumm[5]
											: language == Language.ENGLISH ? engSumm[5] : frSumm[5]);
						}
					}
					if (colorX < 254 && !status)// gastos fade in
						colorX++;
					else {
						status = true;
						if (colorX > 0)// gastos fade out
							colorX -= 2;
						else
							order++;
					}
					break;
				}
				case 2: {// agg start
					if (agregadoT == 0) {
						sumItem.setText(language == Language.SPANISH ? espSumm[6]
								: language == Language.PORTUGUES ? porSumm[6]
										: language == Language.ENGLISH ? engSumm[6] : frSumm[6]);
					} else {
						if (nbAgregados() == 1) {
							sumItem.setText(language == Language.SPANISH ? espSumm[7]
									: language == Language.PORTUGUES ? porSumm[7]
											: language == Language.ENGLISH ? engSumm[7] : frSumm[7]);
						} else {
							sumItem.setText(language == Language.SPANISH ? espSumm[8]
									: language == Language.PORTUGUES ? porSumm[8]
											: language == Language.ENGLISH ? engSumm[8] : frSumm[8]);
						}
					}
					if (colorX < 254 && status)// agg fade in
						colorX++;
					else {
						status = false;
						if (colorX > 0)// agg fade out
							colorX -= 2;
						else
							order++;
					}
					break;
				}
				case 3: {// SUMMARY start
					if (agregadoT == 0) {
						sumItem.setText(language == Language.SPANISH ? espSumm[9]
								: language == Language.PORTUGUES ? porSumm[9]
										: language == Language.ENGLISH ? engSumm[9] : frSumm[9]);
					} else {
						sumItem.setText(language == Language.SPANISH ? espSumm[10]
								: language == Language.PORTUGUES ? porSumm[10]
										: language == Language.ENGLISH ? engSumm[10] : frSumm[10]);
					}
					if (colorX < 254 && !status)// summ fade in
						colorX++;
					else {
						status = true;
						if (colorX > 0)// agg fade out
							colorX -= 2;
						else
							order++;
					}
					break;
				}
				case 4: {// diferrence
					if (totalO == totalCaja)
						sumItem.setText(language == Language.SPANISH ? espSumm[11]
								: language == Language.PORTUGUES ? porSumm[11]
										: language == Language.ENGLISH ? engSumm[11] : frSumm[11]);
					else
						sumItem.setText(language == Language.SPANISH ? espSumm[12]
								: language == Language.PORTUGUES ? porSumm[12]
										: language == Language.ENGLISH ? engSumm[12] : frSumm[12]);
					// diferrence fade in
					if (colorX < 254 && status)
						colorX += 2;
					else {
						status = false;
						if (colorX > 0)// diferrence fade out
							colorX -= 2;
						else
							order++;
					}
					break;
				}
				case 5: {// remain for tmrw
					sumItem.setText(language == Language.SPANISH ? espSumm[13]
							: language == Language.PORTUGUES ? porSumm[13]
									: language == Language.ENGLISH ? engSumm[13] : frSumm[13]);
					if (colorX < 254 && !status)// remain fade in
						colorX += 2;
					else {
						status = true;
						if (colorX > 0)// remain fade out
							colorX -= 2;
						else
							order++;
					}
					break;
				}
				case 6: {// last years sell
					sumItem.setText(language == Language.SPANISH ? espSumm[14]
							: language == Language.PORTUGUES ? porSumm[14]
									: language == Language.ENGLISH ? engSumm[14] : frSumm[14]);
					if ((currentDate.d == 29 && currentDate.m == 2)
							|| (conLY.size() == 0 && conLY2.size() == 0 && conLY3.size() == 0 && conLY4.size() == 0)) {
						order++;
						status = false;
					} else if (colorX < 254 && status)// remain fade in
						colorX += 2;
					else {
						status = false;
						if (colorX > 0)// remain fade out
							colorX -= 2;
						else
							order++;
					}
					break;

				}
				case 7: {// this year averages
					sumItem.setText(language == Language.SPANISH ? espSumm[15]
							: language == Language.PORTUGUES ? porSumm[15]
									: language == Language.ENGLISH ? engSumm[15] : frSumm[15]);
					if (colorX < 254 && !status)// remain fade in
						colorX += 2;
					else {
						status = true;
						if (colorX > 0)// remain fade out
							colorX -= 2;
						else
							order++;
					}
					break;

				}
				case 8: {// compare with avg
					sumItem.setText(language == Language.SPANISH ? espSumm[16]
							: language == Language.PORTUGUES ? porSumm[16]
									: language == Language.ENGLISH ? engSumm[16] : frSumm[16]);
					if (colorX < 254)// export label fade in
						colorX += 2;
					else {
						timer.stop();
					}
					break;
				}
				default:
					break;
				}
			}
		};
		ActionListener wordByWord = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				switch (order) {
				case 0: {// details start
					if (totalVenta == 0) {// if ventas = 0
						String[] wordT = language == Language.SPANISH ? espSumm[0].split(" ")
								: language == Language.PORTUGUES ? porSumm[0].split(" ")
										: language == Language.ENGLISH ? engSumm[0].split(" ") : frSumm[0].split(" ");
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
						else {
							if (wordL < wordT.length + 15) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					} else if (nbVentas() == 1) {// if = 1
						String[] wordT = language == Language.SPANISH ? espSumm[1].split(" ")
								: language == Language.PORTUGUES ? porSumm[1].split(" ")
										: language == Language.ENGLISH ? engSumm[1].split(" ") : frSumm[1].split(" ");
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					} else {// if >1
						String[] wordT = language == Language.SPANISH ? espSumm[2].split(" ")
								: language == Language.PORTUGUES ? porSumm[2].split(" ")
										: language == Language.ENGLISH ? engSumm[2].split(" ") : frSumm[2].split(" ");
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					}
					break;
				}
				case 1: {// gastos start
					if (gastosT == 0) {
						String[] wordT = language == Language.SPANISH ? espSumm[3].split(" ")
								: language == Language.PORTUGUES ? porSumm[3].split(" ")
										: language == Language.ENGLISH ? engSumm[3].split(" ") : frSumm[3].split(" ");
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					} else if (nbGastos() == 1) {
						String[] wordT = language == Language.SPANISH ? espSumm[4].split(" ")
								: language == Language.PORTUGUES ? porSumm[4].split(" ")
										: language == Language.ENGLISH ? engSumm[4].split(" ") : frSumm[4].split(" ");
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					} else {
						String[] wordT = language == Language.SPANISH ? espSumm[5].split(" ")
								: language == Language.PORTUGUES ? porSumm[5].split(" ")
										: language == Language.ENGLISH ? engSumm[5].split(" ") : frSumm[5].split(" ");
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					}
					break;
				}
				case 2: {// agg start
					if (agregadoT == 0) {
						String[] wordT = language == Language.SPANISH ? espSumm[6].split(" ")
								: language == Language.PORTUGUES ? porSumm[6].split(" ")
										: language == Language.ENGLISH ? engSumm[6].split(" ") : frSumm[6].split(" ");
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					} else if (nbAgregados() == 1) {
						String[] wordT = language == Language.SPANISH ? espSumm[7].split(" ")
								: language == Language.PORTUGUES ? porSumm[7].split(" ")
										: language == Language.ENGLISH ? engSumm[7].split(" ") : frSumm[7].split(" ");
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					} else {
						String[] wordT = language == Language.SPANISH ? espSumm[8].split(" ")
								: language == Language.PORTUGUES ? porSumm[8].split(" ")
										: language == Language.ENGLISH ? engSumm[8].split(" ") : frSumm[8].split(" ");
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					}
					break;
				}
				case 3: {// SUMMARY start
					if (agregadoT == 0) {
						String[] wordT = language == Language.SPANISH ? espSumm[9].split(" ")
								: language == Language.PORTUGUES ? porSumm[9].split(" ")
										: language == Language.ENGLISH ? engSumm[9].split(" ") : frSumm[9].split(" ");
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					} else {
						String[] wordT = language == Language.SPANISH ? espSumm[10].split(" ")
								: language == Language.PORTUGUES ? porSumm[10].split(" ")
										: language == Language.ENGLISH ? engSumm[10].split(" ") : frSumm[10].split(" ");
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					}
					break;
				}
				case 4: {// diferrence start
					if (totalO == totalCaja) {
						String[] wordT = language == Language.SPANISH ? espSumm[11].split(" ")
								: language == Language.PORTUGUES ? porSumm[11].split(" ")
										: language == Language.ENGLISH ? engSumm[11].split(" ") : frSumm[11].split(" ");
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					} else {
						String[] wordT = language == Language.SPANISH ? espSumm[12].split(" ")
								: language == Language.PORTUGUES ? porSumm[12].split(" ")
										: language == Language.ENGLISH ? engSumm[12].split(" ") : frSumm[12].split(" ");
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					}
					break;
				}
				case 5: {// remain for tmrw
					String[] wordT = language == Language.SPANISH ? espSumm[13].split(" ")
							: language == Language.PORTUGUES ? porSumm[13].split(" ")
									: language == Language.ENGLISH ? engSumm[13].split(" ") : frSumm[13].split(" ");
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 6: {// last year values
					String[] wordT = language == Language.SPANISH ? espSumm[14].split(" ")
							: language == Language.PORTUGUES ? porSumm[14].split(" ")
									: language == Language.ENGLISH ? engSumm[14].split(" ") : frSumm[14].split(" ");
					if ((currentDate.d == 29 && currentDate.m == 2)
							|| (conLY.size() == 0 && conLY2.size() == 0 && conLY3.size() == 0 && conLY4.size() == 0)) {
						order++;
						wordL = 0;
						sumItem.setText("");
					} else if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 7: {// this year averages
					String[] wordT = language == Language.SPANISH ? espSumm[15].split(" ")
							: language == Language.PORTUGUES ? porSumm[15].split(" ")
									: language == Language.ENGLISH ? engSumm[15].split(" ") : frSumm[15].split(" ");
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 8: {// compare with avgs
					String[] wordT = language == Language.SPANISH ? espSumm[16].split(" ")
							: language == Language.PORTUGUES ? porSumm[16].split(" ")
									: language == Language.ENGLISH ? engSumm[16].split(" ") : frSumm[16].split(" ");
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText().concat(wordT[wordL++] + " "));
					else {
						order++;
						timer.stop();
					}
					break;
				}
				default:
					timer.stop();
					break;
				}
			}
		};
		ActionListener letterByLetter = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				switch (order) {
				case 0: {// details start
					if (totalVenta == 0) {
						char[] wordT = language == Language.SPANISH ? espSumm[0].toCharArray()
								: language == Language.PORTUGUES ? porSumm[0].toCharArray()
										: language == Language.ENGLISH ? engSumm[0].toCharArray()
												: frSumm[0].toCharArray();
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText() + wordT[wordL++]);
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					} else if (nbVentas() == 1) {
						char[] wordT = language == Language.SPANISH ? espSumm[1].toCharArray()
								: language == Language.PORTUGUES ? porSumm[1].toCharArray()
										: language == Language.ENGLISH ? engSumm[1].toCharArray()
												: frSumm[1].toCharArray();
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText() + wordT[wordL++]);
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					} else {
						char[] wordT = language == Language.SPANISH ? espSumm[2].toCharArray()
								: language == Language.PORTUGUES ? porSumm[2].toCharArray()
										: language == Language.ENGLISH ? engSumm[2].toCharArray()
												: frSumm[2].toCharArray();
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText() + wordT[wordL++]);
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					}
					break;
				}
				case 1: {// gastos start
					if (gastosT == 0) {
						char[] wordT = language == Language.SPANISH ? espSumm[3].toCharArray()
								: language == Language.PORTUGUES ? porSumm[3].toCharArray()
										: language == Language.ENGLISH ? engSumm[3].toCharArray()
												: frSumm[3].toCharArray();
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText() + wordT[wordL++]);
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					} else if (nbGastos() == 1) {
						char[] wordT = language == Language.SPANISH ? espSumm[4].toCharArray()
								: language == Language.PORTUGUES ? porSumm[4].toCharArray()
										: language == Language.ENGLISH ? engSumm[4].toCharArray()
												: frSumm[4].toCharArray();
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText() + (wordT[wordL++]));
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					} else {
						char[] wordT = language == Language.SPANISH ? espSumm[5].toCharArray()
								: language == Language.PORTUGUES ? porSumm[5].toCharArray()
										: language == Language.ENGLISH ? engSumm[5].toCharArray()
												: frSumm[5].toCharArray();
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText() + (wordT[wordL++]));
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					}
					break;
				}
				case 2: {// agg start
					if (agregadoT == 0) {
						char[] wordT = language == Language.SPANISH ? espSumm[6].toCharArray()
								: language == Language.PORTUGUES ? porSumm[6].toCharArray()
										: language == Language.ENGLISH ? engSumm[6].toCharArray()
												: frSumm[6].toCharArray();
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText() + (wordT[wordL++]));
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					} else if (nbAgregados() == 1) {
						char[] wordT = language == Language.SPANISH ? espSumm[7].toCharArray()
								: language == Language.PORTUGUES ? porSumm[7].toCharArray()
										: language == Language.ENGLISH ? engSumm[7].toCharArray()
												: frSumm[7].toCharArray();
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText() + (wordT[wordL++]));
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					} else {
						char[] wordT = language == Language.SPANISH ? espSumm[8].toCharArray()
								: language == Language.PORTUGUES ? porSumm[8].toCharArray()
										: language == Language.ENGLISH ? engSumm[8].toCharArray()
												: frSumm[8].toCharArray();
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText() + (wordT[wordL++]));
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					}
					break;
				}
				case 3: {// SUMMARY start
					if (agregadoT == 0) {
						char[] wordT = language == Language.SPANISH ? espSumm[9].toCharArray()
								: language == Language.PORTUGUES ? porSumm[9].toCharArray()
										: language == Language.ENGLISH ? engSumm[9].toCharArray()
												: frSumm[9].toCharArray();
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText() + (wordT[wordL++]));
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					} else {
						char[] wordT = language == Language.SPANISH ? espSumm[10].toCharArray()
								: language == Language.PORTUGUES ? porSumm[10].toCharArray()
										: language == Language.ENGLISH ? engSumm[10].toCharArray()
												: frSumm[10].toCharArray();
						if (wordL < wordT.length) {
							sumItem.setText(sumItem.getText() + (wordT[wordL++]));
						} else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					}
					break;
				}
				case 4: {// diferrence start
					if (totalO == totalCaja) {
						char[] wordT = language == Language.SPANISH ? espSumm[11].toCharArray()
								: language == Language.PORTUGUES ? porSumm[11].toCharArray()
										: language == Language.ENGLISH ? engSumm[11].toCharArray()
												: frSumm[11].toCharArray();
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText() + (wordT[wordL++]));
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					} else {
						char[] wordT = language == Language.SPANISH ? espSumm[12].toCharArray()
								: language == Language.PORTUGUES ? porSumm[12].toCharArray()
										: language == Language.ENGLISH ? engSumm[12].toCharArray()
												: frSumm[12].toCharArray();
						if (wordL < wordT.length)
							sumItem.setText(sumItem.getText() + (wordT[wordL++]));
						else {
							if (wordL < wordT.length + 3) {
								wordL++;
							} else {
								order++;
								wordL = 0;
								sumItem.setText("");
							}
						}
					}
					break;
				}
				case 5: {// remain for tmrw
					char[] wordT = language == Language.SPANISH ? espSumm[13].toCharArray()
							: language == Language.PORTUGUES ? porSumm[13].toCharArray()
									: language == Language.ENGLISH ? engSumm[13].toCharArray()
											: frSumm[13].toCharArray();
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText() + (wordT[wordL++]));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 6: {// last year values
					char[] wordT = language == Language.SPANISH ? espSumm[14].toCharArray()
							: language == Language.PORTUGUES ? porSumm[14].toCharArray()
									: language == Language.ENGLISH ? engSumm[14].toCharArray()
											: frSumm[14].toCharArray();
					if ((currentDate.d == 29 && currentDate.m == 2)
							|| (conLY.size() == 0 && conLY2.size() == 0 && conLY3.size() == 0 && conLY4.size() == 0)) {
						order++;
						wordL = 0;
						sumItem.setText("");
					} else if (wordL < wordT.length)
						sumItem.setText(sumItem.getText() + (wordT[wordL++]));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 7: {// this year averages
					char[] wordT = language == Language.SPANISH ? espSumm[15].toCharArray()
							: language == Language.PORTUGUES ? porSumm[15].toCharArray()
									: language == Language.ENGLISH ? engSumm[15].toCharArray()
											: frSumm[15].toCharArray();
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText() + (wordT[wordL++]));
					else {
						if (wordL < wordT.length + 3) {
							wordL++;
						} else {
							order++;
							wordL = 0;
							sumItem.setText("");
						}
					}
					break;
				}
				case 8: {// compare with avgs
					char[] wordT = language == Language.SPANISH ? espSumm[16].toCharArray()
							: language == Language.PORTUGUES ? porSumm[16].toCharArray()
									: language == Language.ENGLISH ? engSumm[16].toCharArray()
											: frSumm[16].toCharArray();
					if (wordL < wordT.length)
						sumItem.setText(sumItem.getText() + (wordT[wordL++]));
					else {
						order++;
						wordL = 0;
						timer.stop();
					}
					break;
				}
				default:
					timer.stop();
					break;
				}
			}
		};
		ActionListener movingTB = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String originalText;
				switch (order) {
				case 0: {
					if (totalVenta == 0) {
						originalText = language == Language.SPANISH ? espSumm[0]
								: language == Language.PORTUGUES ? porSumm[0]
										: language == Language.ENGLISH ? engSumm[0] : frSumm[0];
					} else {
						if (nbVentas() == 1) {
							originalText = language == Language.SPANISH ? espSumm[1]
									: language == Language.PORTUGUES ? porSumm[1]
											: language == Language.ENGLISH ? engSumm[1] : frSumm[1];
						} else {
							originalText = language == Language.SPANISH ? espSumm[2]
									: language == Language.PORTUGUES ? porSumm[2]
											: language == Language.ENGLISH ? engSumm[2] : frSumm[2];
						}
					}
					String scrambledText = TextEffect.scrambleText(originalText);
					sumItem.setText(scrambledText);
					wordL++;
					if (wordL >= 20) {
						sumItem.setText(originalText);
						if (wordL < 500) {
							wordL++;
						} else {
							order++;
							wordL = 0;
						}
					}
					break;
				}
				case 1: {
					if (gastosT == 0) {
						originalText = language == Language.SPANISH ? espSumm[3]
								: language == Language.PORTUGUES ? porSumm[3]
										: language == Language.ENGLISH ? engSumm[3] : frSumm[3];
					} else {
						if (nbGastos() == 1) {
							originalText = language == Language.SPANISH ? espSumm[4]
									: language == Language.PORTUGUES ? porSumm[4]
											: language == Language.ENGLISH ? engSumm[4] : frSumm[4];
						} else {
							originalText = language == Language.SPANISH ? espSumm[5]
									: language == Language.PORTUGUES ? porSumm[5]
											: language == Language.ENGLISH ? engSumm[5] : frSumm[5];
						}
					}
					String scrambledText = TextEffect.scrambleText(originalText);
					sumItem.setText(scrambledText);
					wordL++;
					if (wordL >= 20) {
						sumItem.setText(originalText);
						if (wordL < 500) {
							wordL++;
						} else {
							order++;
							wordL = 0;
						}
					}
					break;
				}
				case 2: {
					if (agregadoT == 0) {
						originalText = language == Language.SPANISH ? espSumm[6]
								: language == Language.PORTUGUES ? porSumm[6]
										: language == Language.ENGLISH ? engSumm[6] : frSumm[6];
					} else {
						if (nbAgregados() == 1) {
							originalText = language == Language.SPANISH ? espSumm[7]
									: language == Language.PORTUGUES ? porSumm[7]
											: language == Language.ENGLISH ? engSumm[7] : frSumm[7];
						} else {
							originalText = language == Language.SPANISH ? espSumm[8]
									: language == Language.PORTUGUES ? porSumm[8]
											: language == Language.ENGLISH ? engSumm[8] : frSumm[8];
						}
					}
					String scrambledText = TextEffect.scrambleText(originalText);
					sumItem.setText(scrambledText);
					wordL++;
					if (wordL >= 20) {
						sumItem.setText(originalText);
						if (wordL < 500) {
							wordL++;
						} else {
							order++;
							wordL = 0;
						}
					}
					break;
				}
				case 3: {// SUMMARY start
					if (agregadoT == 0) {
						originalText = language == Language.SPANISH ? espSumm[9]
								: language == Language.PORTUGUES ? porSumm[9]
										: language == Language.ENGLISH ? engSumm[9] : frSumm[9];
					} else {
						originalText = language == Language.SPANISH ? espSumm[10]
								: language == Language.PORTUGUES ? porSumm[10]
										: language == Language.ENGLISH ? engSumm[10] : frSumm[10];
					}
					String scrambledText = TextEffect.scrambleText(originalText);
					sumItem.setText(scrambledText);
					wordL++;
					if (wordL >= 20) {
						sumItem.setText(originalText);
						if (wordL < 500) {
							wordL++;
						} else {
							order++;
							wordL = 0;
						}
					}
					break;
				}
				case 4: {// diferrence
					if (totalO == totalCaja) {
						originalText = language == Language.SPANISH ? espSumm[11]
								: language == Language.PORTUGUES ? porSumm[11]
										: language == Language.ENGLISH ? engSumm[11] : frSumm[11];
					} else {
						originalText = language == Language.SPANISH ? espSumm[12]
								: language == Language.PORTUGUES ? porSumm[12]
										: language == Language.ENGLISH ? engSumm[12] : frSumm[12];
					}
					String scrambledText = TextEffect.scrambleText(originalText);
					sumItem.setText(scrambledText);
					wordL++;
					if (wordL >= 20) {
						sumItem.setText(originalText);
						if (wordL < 500) {
							wordL++;
						} else {
							order++;
							wordL = 0;
						}
					}
					break;
				}
				case 5: {// remain for tmrw
					originalText = language == Language.SPANISH ? espSumm[13]
							: language == Language.PORTUGUES ? porSumm[13]
									: language == Language.ENGLISH ? engSumm[13] : frSumm[13];
					String scrambledText = TextEffect.scrambleText(originalText);
					sumItem.setText(scrambledText);
					wordL++;
					if (wordL >= 20) {
						sumItem.setText(originalText);
						if (wordL < 500) {
							wordL++;
						} else {
							order++;
							wordL = 0;
						}
					}
					break;
				}
				case 6: {// last years sell
					if ((currentDate.d == 29 && currentDate.m == 2)
							|| (conLY.size() == 0 && conLY2.size() == 0 && conLY3.size() == 0 && conLY4.size() == 0))
						order++;
					else {
						originalText = language == Language.SPANISH ? espSumm[14]
								: language == Language.PORTUGUES ? porSumm[14]
										: language == Language.ENGLISH ? engSumm[14] : frSumm[14];
						String scrambledText = TextEffect.scrambleText(originalText);
						sumItem.setText(scrambledText);
						wordL++;
						if (wordL >= 20) {
							sumItem.setText(originalText);
							if (wordL < 500) {
								wordL++;
							} else {
								order++;
								wordL = 0;
							}
						}
					}
					break;
				}
				case 7: {// this year averages
					originalText = language == Language.SPANISH ? espSumm[15]
							: language == Language.PORTUGUES ? porSumm[15]
									: language == Language.ENGLISH ? engSumm[15] : frSumm[15];
					String scrambledText = TextEffect.scrambleText(originalText);
					sumItem.setText(scrambledText);
					wordL++;
					if (wordL >= 20) {
						sumItem.setText(originalText);
						if (wordL < 500) {
							wordL++;
						} else {
							order++;
							wordL = 0;
						}
					}
					break;
				}
				case 8: {// compare with avg
					originalText = language == Language.SPANISH ? espSumm[16]
							: language == Language.PORTUGUES ? porSumm[16]
									: language == Language.ENGLISH ? engSumm[16] : frSumm[16];
					String scrambledText = TextEffect.scrambleText(originalText);
					sumItem.setText(scrambledText);
					wordL++;
					if (wordL == 50) {
						sumItem.setText(originalText);
						wordL = 0;
						timer.stop();
					}
					break;
				}
				default:
					wordL = 0;
					timer.stop();
					break;
				}
			}
		};

		if (effChooser == 0) {
			// Speed
			if (conf[6] == null || conf[6].equals("1"))
				speedValue = 15;
			else if (conf[6].equals("0"))
				speedValue = 20;
			else
				speedValue = 1;
			timer = new Timer(speedValue, fadeTimer);
		} else if (effChooser == 1) {
			// Speed
			if (conf[6] == null || conf[6].equals("1"))
				speedValue = 400;
			else if (conf[6].equals("0"))
				speedValue = 500;
			else
				speedValue = 300;
			timer = new Timer(speedValue, wordByWord);
		} else if (effChooser == 2) {
			// Speed
			if (conf[6] == null || conf[6].equals("1"))
				speedValue = 150;
			else if (conf[6].equals("0"))
				speedValue = 300;
			else
				speedValue = 50;
			timer = new Timer(speedValue, letterByLetter);
		} else {
			// Speed
			if (conf[6] == null || conf[6].equals("1"))
				speedValue = 15;
			else if (conf[6].equals("0"))
				speedValue = 20;
			else
				speedValue = 1;
			timer = new Timer(speedValue, movingTB);
		}
		timer.start();

		// If close stop the timer
		sum.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				colorX = 0;
				order = 0;
				wordL = 0;
				timer.stop();
				overlay.hideOverlay();
			}
		});

		sum.add(sumItem);
		sum.setIconImage(colorSelected == 2 ? ImageEffect.getScaledImage(summI.getImage(), 35, 35).getImage()
				: ImageEffect.invertColor(ImageEffect.getScaledImage(summI.getImage(), 35, 35)).getImage());

		sum.setVisible(true);
	}

	/* View old invoices according to date */
	private void viewOldSummary() {
		JDialog dialog = new JDialog(this, getLocalizedMessage("DAILY_SUMMARY"), true);
		dialog.setUndecorated(true);
		dialog.setSize(getWidth() / 2, getHeight() / 2);
		dialog.setShape(new RoundRectangle2D.Double(0, 0, getWidth() / 2, getHeight() / 2, 20, 20));
		dialog.setLocationRelativeTo(this);
		dialog.setLayout(new GridBagLayout());
		dialog.setResizable(false);
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

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weightx = 1; // Allow horizontal centering
		gbc.weighty = 1; // Allow vertical centering

		// Date Field (Non-editable)
		JFormattedTextField dateSelected = new JFormattedTextField();
		dateSelected.setFont(new Font("Tahoma", Font.BOLD, 18));
		dateSelected.setForeground(fg);
		dateSelected.setBackground(bg);
		dateSelected.setBorder(new LineBorder(fg, 1));
		dateSelected.setHorizontalAlignment(0);
		dateSelected.setPreferredSize(new Dimension(dialog.getWidth() / 2, 30));

		datePicker = new DatePicker();
		datePicker.now();
		datePicker.setEditor(dateSelected);
		datePicker.setDateSelectionMode(DatePicker.DateSelectionMode.SINGLE_DATE_SELECTED);
		datePicker.setUsePanelOption(true);
		datePicker.setCloseAfterSelected(true);
		datePicker.setEditorValidation(true);
		datePicker.setValidationOnNull(true);

		// Buttons
		JButton yesterday = new JButton(getLocalizedMessage("YESTERDAY"));
		JButton lastWeek = new JButton(getLocalizedMessage("LAST_WEEK").toUpperCase());
		JButton lastMonth = new JButton(
				language == Language.ENGLISH ? getLocalizedMessage("LAST") + " " + getLocalizedMessage("MONTH")
						: getLocalizedMessage("MONTH") + " " + getLocalizedMessage("LAST"));
		JButton lastYear = new JButton(
				language == Language.ENGLISH ? getLocalizedMessage("LAST") + " " + getLocalizedMessage("YEAR")
						: getLocalizedMessage("YEAR") + " " + getLocalizedMessage("LAST"));
		yesterday.addActionListener(_ -> dateSelected.setText(currentDate.getYesterday()));
		lastWeek.addActionListener(_ -> dateSelected.setText(currentDate.getLastWeek()));
		lastMonth.addActionListener(_ -> dateSelected.setText(currentDate.getLastMonth()));
		lastYear.addActionListener(_ -> dateSelected.setText(currentDate.getLastYear()));
		lastWeek.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lastMonth.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lastYear.setFont(new Font("Segoe UI", Font.BOLD, 14));
		yesterday.setFont(new Font("Segoe UI", Font.BOLD, 14));
		// Load Button
		JButton loadButton = new JButton(getLocalizedMessage("LOAD") + " " + getLocalizedMessage("SUMMARY"));
		loadButton.addActionListener(_ -> {
			if (dateSelected.getText().equals("--/--/----"))
				Toast.show(this, Toast.Type.ERROR, getLocalizedMessage("DATE_E"), Intro.notOption);
			else {
				DateModified selectedDate = new DateModified(datePicker.getSelectedDate().getDayOfMonth(),
						datePicker.getSelectedDate().getMonthValue(), datePicker.getSelectedDate().getYear());
				dataFolder.mkdir();
				File yearFolder = new File(dataFolder + "\\" + selectedDate.y);
				yearFolder.mkdir();
				File monthFolder = new File(yearFolder + "\\" + selectedDate.m + "-"
						+ getMonthForInt(selectedDate.m - 1, langIndex).toUpperCase());
				monthFolder.mkdir();
				File todayFile = new File(monthFolder,
						"$ " + (selectedDate.d < 10 ? "0" + selectedDate.d : selectedDate.d) + "-" + selectedDate.m
								+ " (" + dayName(selectedDate, langIndex) + ").txt");
				if (!todayFile.exists())
					Toast.show(this, Toast.Type.INFO, getLocalizedMessage("NO_DATA"), Intro.notOption);
				else
					oldDailySumm(selectedDate);
			}
		});
		loadButton.setFont(new Font("Segoe UI", Font.BOLD, 14));

		// Close Button
		JButton closeButton = new JButton(ImageEffect.getScaledImage(closeImage.getImage(), 15, 15));
		closeButton.setBorderPainted(false);
		closeButton.setFocusPainted(false);
		closeButton.setContentAreaFilled(false);
		closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		closeButton.setToolTipText(getLocalizedMessage("EXIT"));
		closeButton.addActionListener(_ -> {
			dialog.dispose();
			overlay.hideOverlay();
		});
		JPanel borderLay = new JPanel(new GridBagLayout());
		borderLay.setOpaque(false);
		// Add Components to Dialog
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 4;
		borderLay.add(
				new JLabel("<html><b><u><font size='5'>" + getLocalizedMessage("DATE_S") + "</font></u></b></html>"),
				gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		borderLay.add(yesterday, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		borderLay.add(lastWeek, gbc);
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		borderLay.add(lastMonth, gbc);
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		borderLay.add(lastYear, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 4;
		borderLay.add(dateSelected, gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 4;
		borderLay.add(loadButton, gbc);
		JPanel northPanel = new JPanel(new BorderLayout());
		northPanel.setOpaque(false);
		northPanel.add(closeButton, BorderLayout.EAST);
		contentPane.add(northPanel, BorderLayout.NORTH);
		contentPane.add(borderLay, BorderLayout.CENTER);

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
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				overlay.hideOverlay();
			}
		});

		dialog.setVisible(true);
	}

	/* Show the daily summary in dialog */
	private void oldDailySumm(DateModified date) {
		JDialog dialog = new JDialog(this, getLocalizedMessage("SUMMARY"), true);
		dialog.setUndecorated(true); // Removes default borders
		dialog.setSize(getWidth() * 2 / 3, getHeight() * 2 / 3);
		dialog.setLocationRelativeTo(this);
		dialog.setLayout(new BorderLayout());

		dataFolder.mkdir();
		File yearFolder = new File(dataFolder + "\\" + date.y);
		yearFolder.mkdir();
		File monthFolder = new File(
				yearFolder + "\\" + date.m + "-" + getMonthForInt(date.m - 1, langIndex).toUpperCase());
		monthFolder.mkdir();
		File summaryFile = new File(monthFolder, "$ " + (date.d < 10 ? "0" + date.d : date.d) + "-" + date.m + " ("
				+ dayName(date, langIndex) + ").txt");

		// Rounded Panel
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 2, true));
		mainPanel.setBackground(bg);

		// Title Panel with Rounded Icon
		JPanel titlePanel = new JPanel(new BorderLayout());
		titlePanel.setOpaque(false);
		titlePanel.setBorder(new EmptyBorder(5, 10, 5, 10));

		JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
		JLabel iconLabel = new JLabel(
				colorSelected == 2 ? new ImageIcon(summaryI.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH))
						: ImageEffect.invertColor(
								new ImageIcon(summaryI.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH))));
		JLabel titleLabel = new JLabel(
				getLocalizedMessage("SUMMARY") + " " + getLocalizedMessage("OF") + " " + date.getToday());
		titleLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		leftPanel.setOpaque(false);
		leftPanel.add(iconLabel);
		leftPanel.add(titleLabel);

		JButton closeButton = new JButton(closeImage);
		closeButton.setPreferredSize(new Dimension(40, 30));
		closeButton.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		closeButton.setBorderPainted(false);
		closeButton.setFocusPainted(false);
		closeButton.setContentAreaFilled(false);
		closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		closeButton.setToolTipText(getLocalizedMessage("EXIT"));
		closeButton.addActionListener(_ -> dialog.dispose());

		titlePanel.add(leftPanel, BorderLayout.WEST);
		titlePanel.add(closeButton, BorderLayout.EAST);

		JLabel summaryLabel = new JLabel();
		summaryLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		summaryLabel.setBorder(new EmptyBorder(10, 10, 10, 10));

		JScrollPane scrollPane = new JScrollPane(summaryLabel);
		scrollPane.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		mainPanel.add(titlePanel, BorderLayout.NORTH);
		mainPanel.add(scrollPane, BorderLayout.CENTER);
		dialog.add(mainPanel);

		try (BufferedReader reader = new BufferedReader(new FileReader(summaryFile))) {
			StringBuilder summary = new StringBuilder("<html>"); // Wrap text
			String line;
			while ((line = reader.readLine()) != null) {
				summary.append(line).append("<br>");
			}
			summary.append("</html>");
			summaryLabel.setText(summary.toString());
		} catch (Exception ex) {
			summaryLabel.setText("<html><center>Error loading summary.</center></html>");
			ex.printStackTrace();
		}

		// Key listener for ESC key to close the dialog
		InputMap inputMap = dialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap = dialog.getRootPane().getActionMap();
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "closeDialog");
		actionMap.put("closeDialog", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
			}
		});

		dialog.setVisible(true);
	}

	/* Check if we already exported the summary of the day */
	private boolean isNewDayExisted() {
		dateLang(language);
		dataFolder.mkdir();
		File yearFolder = new File(dataFolder + "\\" + yearS);
		yearFolder.mkdir();
		File monthFolder = new File(yearFolder + "\\" + currentDate.m + "-" + monthS);
		monthFolder.mkdir();
		File todayFile = new File(monthFolder, "$ " + dayN + "-" + currentDate.m + " (" + dayS + ").txt");
		if (todayFile.exists()) {
			return true;
		} else
			return false;
	}

	/* Save the summary of the day */
	private void exBtn() {
		dateLang(language);
		dataFolder.mkdir();
		File yearFolder = new File(dataFolder + "\\" + yearS);
		yearFolder.mkdir();
		File monthFolder = new File(yearFolder + "\\" + currentDate.m + "-" + monthS);
		monthFolder.mkdir();
		File todayFile = new File(monthFolder, "$ " + dayN + "-" + currentDate.m + " (" + dayS + ").txt");
		if (currentDate.d != 29 || currentDate.m != 2)
			currentDate.saveToday(totalVenta);
		screenShooter();/* AUTO SCREENSHOOT */

		List<Map.Entry<String, Integer>> top3 = getTop3QtToday();
		List<Map.Entry<String, Double>> top3P = getTop3PriceToday();
		String top3S = "";
		int rank = 1;
		for (int i = 0; i < top3.size(); i++) {
			if (i > 0 && i < top3.size())
				if (top3.get(i).getValue() == top3.get(i - 1).getValue()) {
					top3S += --rank + "- " + top3.get(i).getKey() + " -> " + top3.get(i).getValue() + "\n";
				} else {
					top3S += (i + 1) + "- " + top3.get(i).getKey() + " -> " + top3.get(i).getValue() + "\n";
					rank = i + 1;
				}
			else
				top3S += rank + "- " + top3.get(i).getKey() + " -> " + top3.get(i).getValue() + "\n";
			rank++;
		}
		rank = 1;
		String top3PS = "";
		for (int i = 0; i < top3P.size(); i++) {
			if (i > 0 && i < top3P.size()) {
				if (top3P.get(i).getValue().equals(top3P.get(i - 1).getValue())) {
					top3PS += --rank + "- " + top3P.get(i).getKey() + " -> $" + top3P.get(i).getValue() + "\n";
				} else {
					top3PS += (i + 1) + "- " + top3P.get(i).getKey() + " -> $" + top3P.get(i).getValue() + "\n";
					rank = i + 1;
				}
			} else
				top3PS += rank + "- " + top3P.get(i).getKey() + " -> $" + top3P.get(i).getValue() + "\n";
			rank++;
		}
		// seller sales of this month
		String sellerText = "";
		rank = 1;
		Map<String, Integer> sortedMap = sellerTotal.entrySet().stream()
				.sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())) // Descending order
				.collect(LinkedHashMap::new, (map, entry) -> map.put(entry.getKey(), entry.getValue()), Map::putAll);
		int totalSales = 0;
		for (Map.Entry<String, Integer> entry : sortedMap.entrySet())
			totalSales += entry.getValue();
		for (Map.Entry<String, Integer> entry : sortedMap.entrySet())
			sellerText += (rank++) + "- " + entry.getKey() + " -> $" + entry.getValue() + " ("
					+ (totalSales != 0 ? (entry.getValue() * 100 / totalSales) : 0) + "%)\n";
		try {
			FileWriter savedF = new FileWriter(todayFile);
			String[] espSumm = { "VENTAS:\nUSTED NO VENDIÓ NADA" + System.lineSeparator(), // 0
					"VENTAS:\nUSTED VENDIÓ UNA VENTA SOLO QUE VALE $" + totalVenta + System.lineSeparator(), // 1
					"VENTAS:\nUSTED VENDIÓ $" + totalVenta + ", DIVIDIENDO EN " + nbVentas() + " VENTAS, "
							+ "CON UN PROMEDIO DE $" + (nbVentas() == 0 ? 0 : totalVenta / nbVentas()) + " POR VENTA"
							+ System.lineSeparator(), // 2
					"GASTOS:\nNO TIENES GASTOS!" + System.lineSeparator(), // 3
					"GASTOS:\nTIENES EN TOTAL UN GASTO QUE VALE $" + gastosT + "\n" + "DETALLADO COMO:\n"
							+ gastosDetalles(), // 4
					"GASTOS:\nTIENES EN TOTAL $" + gastosT + " COMO GASTOS, " + "DIVIDIDO POR " + nbGastos()
							+ " COSAS, " + "CON UN PROMEDIO DE $" + (nbGastos() == 0 ? 0 : gastosT / nbGastos()) + "\n"
							+ "DETALLADO COMO:\n" + gastosDetalles(), // 5
					"AGREGADOS:\nTIENES EN TOTAL UN AGREGADO QUE VALE $" + agregadoT + "\n" + "DETALLADO COMO:\n"
							+ agregadoDetalles(), // 6
					"AGREGADOS:\nTIENES EN TOTAL $" + agregadoT + " COMO AGREGADOS, " + "DIVIDIDO POR " + nbAgregados()
							+ " COSAS, " + "CON UN PROMEDIO DE $" + (nbAgregados() == 0 ? 0 : agregadoT / nbAgregados())
							+ "\n" + "DETALLADO COMO:\n" + agregadoDetalles(), // 7
					"PARA RESUMIR:\n" + "EMPEZAMOS EL DÍA CON $" + initialDay.getText() + "\nVENDIMOS $" + totalVenta
							+ "\nGASTO $" + gastosT + "\nQUE TERMINARÁ CON $" + totalO + " EN TOTAL"
							+ System.lineSeparator(), // 8
					"PARA RESUMIR:\n" + "EMPEZAMOS EL DÍA CON $" + initialDay.getText() + "\nVENDIMOS $" + totalVenta
							+ "\nGASTO $" + gastosT + "\nAGREGÓ $" + agregadoT + "\nQUE TERMINARÁ CON $" + totalO
							+ " EN TOTAL" + System.lineSeparator(), // 9
					"LA CAJA DIO BIEN, NO HAY DIFERENCIA" + System.lineSeparator(), // 10
					"LA CAJA NO DIO BIEN, PARECE QUE " + diffResult.getText().toUpperCase() + System.lineSeparator(), // 11
					"RECUERDOS DE HOY:"
							+ (conLY4.size() == 0 ? ""
									: "\nEN " + dayN + "-" + monthS + "-" + (currentDate.y - 4) + ", LO QUE ES UN "
											+ dayName(new DateModified(Integer.valueOf(dayN),
													Integer.valueOf(currentDate.m), currentDate.y - 4), 0)
											+ (valueLY4 == -1 ? " NO ABRIMOS LA TIENDA"
													: ", VENDISTE $" + valueLY4 + " EN TOTAL"))
							+ (conLY3.size() == 0 ? ""
									: "\nEN " + dayN + "-" + monthS + "-" + (currentDate.y - 3) + ", LO QUE ES UN "
											+ dayName(new DateModified(Integer.valueOf(dayN),
													Integer.valueOf(currentDate.m), currentDate.y - 3), 0)
											+ (valueLY3 == -1 ? " NO ABRIMOS LA TIENDA"
													: ", VENDISTE $" + valueLY3 + " EN TOTAL"))
							+ (conLY2.size() == 0 ? ""
									: "\nEN " + dayN + "-" + monthS + "-" + (currentDate.y - 2) + ", LO QUE ES UN "
											+ dayName(new DateModified(Integer.valueOf(dayN),
													Integer.valueOf(currentDate.m), currentDate.y - 2), 0)
											+ (valueLY2 == -1 ? " NO ABRIMOS LA TIENDA"
													: ", VENDISTE $" + valueLY2 + " EN TOTAL"))
							+ (conLY.size() == 0 ? ""
									: "\nEN " + dayN + "-" + monthS + "-" + (currentDate.y - 1) + ", LO QUE ES UN "
											+ dayName(new DateModified(Integer.valueOf(dayN),
													Integer.valueOf(currentDate.m), currentDate.y - 1), 0)
											+ (valueLY == -1 ? " NO ABRIMOS LA TIENDA"
													: ", VENDISTE $" + valueLY + " EN TOTAL"))
							+ "\nHOY, " + dayS + " VENDISTE $" + totalVenta
							+ ((valueLY4 == -1 && valueLY3 == -1 && valueLY2 == -1
									&& valueLY == -1)
											? ""
											: " CORRESPONDIENTE A:"
													+ (valueLY4 == -1 ? ""
															: "\n • $"
																	+ (totalVenta > valueLY4
																			? totalVenta - valueLY4 + " MÁS QUE "
																					+ (currentDate.y - 4) + " (%"
																					+ (valueLY4 < 1
																							? 100
																							: 100 * (totalVenta
																									- valueLY4)
																									/ valueLY4)
																			: valueLY4 - totalVenta + " MENOS QUE "
																					+ (currentDate.y - 4) + " (%"
																					+ (valueLY4 < 1 ? 100
																							: 100 * (valueLY4
																									- totalVenta)
																									/ valueLY4))
																	+ ")")
													+ (valueLY3 == -1 ? ""
															: "\n • $"
																	+ (totalVenta > valueLY3
																			? totalVenta - valueLY3 + " MÁS QUE "
																					+ (currentDate.y - 3) + " (%"
																					+ (valueLY3 < 1 ? 100
																							: 100 * (totalVenta
																									- valueLY3)
																									/ valueLY3)
																			: valueLY3 - totalVenta + " MENOS QUE "
																					+ (currentDate.y - 3) + " (%"
																					+ (valueLY3 == 0 ? 0
																							: 100 * (valueLY3
																									- totalVenta)
																									/ valueLY3))
																	+ ")")
													+ (valueLY2 == -1 ? ""
															: "\n • $"
																	+ (totalVenta > valueLY2
																			? totalVenta - valueLY2 + " MÁS QUE "
																					+ (currentDate.y - 2) + " (%"
																					+ (valueLY2 < 1
																							? 100
																							: 100 * (totalVenta
																									- valueLY2)
																									/ valueLY2)
																			: valueLY2 - totalVenta + " MENOS QUE "
																					+ (currentDate.y - 2) + " (%"
																					+ (valueLY2 == 0 ? 0
																							: 100 * (valueLY2
																									- totalVenta)
																									/ valueLY2))
																	+ ")")
													+ (valueLY == -1 ? ""
															: "\n • $"
																	+ (totalVenta > valueLY
																			? totalVenta - valueLY + " MÁS QUE "
																					+ (currentDate.y - 1) + " (%"
																					+ (valueLY < 1
																							? 100
																							: 100 * (totalVenta
																									- valueLY)
																									/ valueLY)
																			: valueLY - totalVenta + " MENOS QUE "
																					+ (currentDate.y - 1) + " (%"
																					+ (valueLY == 0 ? 0
																							: 100 * (valueLY
																									- totalVenta)
																									/ valueLY))
																	+ ")"))
							+ System.lineSeparator(), // 15
					(dailyAvg == 0 ? ""
							: "COMPARACIÓN CON LOS PROMEDIOS DE ESTE AÑO:\n" + "HOY, VENDEMOS EN TOTAL $" + totalVenta
									+ "\nESTE AÑO VENDIMOS UN PROMEDIO DIARIO DE $" + dailyAvg
									+ (sameDayAvg == 0 ? ""
											: "\nUN PROMEDIO DE LOS " + dayName(currentDate, 0) + " $" + sameDayAvg)
									+ (monthlyAvg == 0 ? ""
											: "\nUN PROMEDIO MENSUAL DE " + currentDate.getMonthForInt(0) + " $"
													+ monthlyAvg)
									+ System.lineSeparator())
							+ (dailyAvg == 0 ? ""
									: "SE PARECE QUE VENDIMOS: "
											+ (sameDayAvg == 0 ? ""
													: "\n • $"
															+ (sameDayAvg > totalVenta ? sameDayAvg - totalVenta
																	+ " MENOS QUE EL PROMEDIO DE LOS "
																	+ dayName(currentDate, 0) + " ▼ "
																	+ 100 * (sameDayAvg - totalVenta) / sameDayAvg
																	: (totalVenta - sameDayAvg
																			+ " MÁS QUE EL PROMEDIO DE LOS "
																			+ dayName(currentDate, 0))
																			+ " ▲ "
																			+ 100 * (-sameDayAvg + totalVenta)
																					/ sameDayAvg)
															+ "%")
											+ "\n • $"
											+ (dailyAvg > totalVenta
													? dailyAvg - totalVenta + " MENOS QUE EL PROMEDIO DIARIO" + " ▼ "
															+ 100 * (dailyAvg - totalVenta) / dailyAvg
													: (totalVenta - dailyAvg + " MÁS QUE EL PROMEDIO DIARIO") + " ▲ "
															+ 100 * (-dailyAvg + totalVenta) / dailyAvg)
											+ "%"
											+ (monthlyAvg == 0 ? ""
													: "\n • $"
															+ (monthlyAvg > totalVenta
																	? monthlyAvg - totalVenta
																			+ " MENOS QUE PROMEDIO MENSUAL DE "
																			+ currentDate.getMonthForInt(

																					0)
																			+ " ▼ " + 100
																					* (monthlyAvg - totalVenta)
																					/ monthlyAvg
																	: (totalVenta - monthlyAvg
																			+ " MÁS QUE EL PPROMEDIO MENSUAL DE "
																			+ currentDate.getMonthForInt(

																					0)
																			+ " ▲ "
																			+ 100 * (-monthlyAvg + totalVenta)
																					/ monthlyAvg))
															+ "%")
											+ System.lineSeparator()), // 17
					"TOP VENTAS DEL DÍA POR CANTIDAD:\n" + top3S, // 18
					"TOP VENTAS DEL DÍA POR PRECIO:\n" + top3PS, // 19
					"TOP VENDEDORES:\n" + sellerText, // 19
					System.lineSeparator() + "GRACIAS Y HASTA MAÑANA :)", // 19
			};
			String[] porSumm = { "VENDAS:\nVOCÊ NÃO VENDEU NADA" + System.lineSeparator(), // 0
					"VENDAS:\nVOCÊ VENDEU UMA VENDA SÓ QUE VALE $" + totalVenta + System.lineSeparator(), // 1
					"VENDAS:\nVOCÊ VENDEU $" + totalVenta + ", DIVIDINDO EM " + nbVentas() + " VENDAS, "
							+ "COM MÉDIA DE $" + (nbVentas() == 0 ? 0 : totalVenta / nbVentas()) + " À VENDA"
							+ System.lineSeparator(), // 2
					"GASTOS:\nVOCÊ NÃO TEM GASTOS!" + System.lineSeparator(), // 3
					"GASTOS:\nVOCÊ TEM NO TOTAL UM GASTO NO VALOR DE $" + gastosT + "\n" + "DETALHADO COMO:\n"
							+ gastosDetalles(), // 4
					"GASTOS:\nVOCÊ TEM NO TOTAL $" + gastosT + " COMO GASTOS, " + "DIVIDIDO POR " + nbGastos()
							+ " COISAS, " + "COM MÉDIA DE $" + (nbGastos() == 0 ? 0 : gastosT / nbGastos()) + "\n"
							+ "DETALHADO COMO:\n" + gastosDetalles(), // 5
					"AGREGADOS:\nVOCÊ TEM NO TOTAL UM AGREGADO NO VALOR DE $" + agregadoT + "\n" + "DETALHADO COMO:\n"
							+ agregadoDetalles(), // 6
					"AGREGADOS:\nVOCÊ TEM NO TOTAL $" + agregadoT + " COMO AGREGADOS, " + "DIVIDIDO POR "
							+ nbAgregados() + " COISAS, " + "COM MÉDIA DE $"
							+ (nbAgregados() == 0 ? 0 : agregadoT / nbAgregados()) + "\n" + "DETALHADO COMO:\n"
							+ agregadoDetalles() + System.lineSeparator(), // 7
					"PARA RESUMIR:\n" + "COMEÇAMOS O DIA COM $" + initialDay.getText() + "\nVENDEMOS $" + totalVenta
							+ "\nGASTO $" + gastosT + "\nQUE VAI ACABAR EM $" + totalO + " EM TOTAL"
							+ System.lineSeparator(), // 9
					"PARA RESUMIR:\n" + "COMEÇAMOS O DIA COM $" + initialDay.getText() + "\nVENDEMOS $" + totalVenta
							+ "\nGASTO $" + gastosT + "\nADICIONO $" + agregadoT + "\nQUE VAI ACABAR EM $" + totalO
							+ " EM TOTAL" + System.lineSeparator(), // 11
					"A CAIXA DEU BEM, " + "NÃO HÁ DIFERENÇA" + System.lineSeparator(), // 12
					"A CAIXA NÃO DEU BEM, " + "PARECE QUE " + diffResult.getText().toUpperCase()
							+ System.lineSeparator(), // 13
					"MEMÓRIAS DE HOJE:"
							+ (conLY4.size() == 0 ? ""
									: "\nEM " + dayN + "-" + monthS + "-" + (currentDate.y - 4) + ", O QUE É UM "
											+ dayName(new DateModified(Integer.valueOf(dayN),
													Integer.valueOf(currentDate.m), currentDate.y - 4), 1)
											+ (valueLY4 == -1 ? " NÃO ABRIMOS A LOJA"
													: ", VOCÊ VENDEU $" + valueLY4 + " EM TOTAL"))
							+ (conLY3.size() == 0 ? ""
									: "\nEM " + dayN + "-" + monthS + "-" + (currentDate.y - 3) + ", O QUE É UM "
											+ dayName(new DateModified(Integer.valueOf(dayN),
													Integer.valueOf(currentDate.m), currentDate.y - 3), 1)
											+ (valueLY3 == -1 ? " NÃO ABRIMOS A LOJA"
													: ", VOCÊ VENDEU $" + valueLY3 + " EM TOTAL"))
							+ (conLY2.size() == 0 ? ""
									: "\nEM " + dayN + "-" + monthS + "-" + (currentDate.y - 2) + ", O QUE É UM "
											+ dayName(new DateModified(Integer.valueOf(dayN),
													Integer.valueOf(currentDate.m), currentDate.y - 2), 1)
											+ (valueLY2 == -1 ? " NÃO ABRIMOS A LOJA"
													: ", VOCÊ VENDEU $" + valueLY2 + " EM TOTAL"))
							+ (conLY.size() == 0 ? ""
									: "\nEM " + dayN + "-" + monthS + "-" + (currentDate.y - 1) + ", O QUE É UM "
											+ dayName(new DateModified(Integer.valueOf(dayN),
													Integer.valueOf(currentDate.m), currentDate.y - 1), 1)
											+ (valueLY == -1 ? " NÃO ABRIMOS A LOJA"
													: ", VOCÊ VENDEU $" + valueLY + " EM TOTAL"))
							+ "\nHOJE, " + dayS + " VENDEU $" + totalVenta
							+ ((valueLY4 == -1 && valueLY3 == -1 && valueLY2 == -1 && valueLY == -1) ? ""
									: " CORRESPONDE A" + (valueLY4 == -1 ? ""
											: "\n$" + (totalVenta > valueLY4 ? totalVenta - valueLY4 + " MAIS QUE "
													+ (currentDate.y - 4) + " (%"
													+ (valueLY4 < 1 ? 100 : 100 * (totalVenta - valueLY4) / valueLY4)
													: valueLY4 - totalVenta + " MENOS QUE " + (currentDate.y - 4)
															+ " (%"
															+ (valueLY4 < 1 ? 100
																	: 100 * (valueLY4 - totalVenta) / valueLY4))
													+ ")")
											+ (valueLY3 == -1 ? ""
													: "\n$" + (totalVenta > valueLY3 ? totalVenta - valueLY3
															+ " MAIS QUE " + (currentDate.y - 3) + " (%"
															+ (valueLY3 < 1 ? 100
																	: 100 * (totalVenta - valueLY3) / valueLY3)
															: valueLY3 - totalVenta + " MENOS QUE "
																	+ (currentDate.y - 3) + " (%"
																	+ (valueLY3 == 0 ? 0
																			: 100 * (valueLY3 - totalVenta) / valueLY3))
															+ ")")
											+ (valueLY2 == -1 ? ""
													: "\n$" + (totalVenta > valueLY2 ? totalVenta - valueLY2
															+ " MAIS QUE " + (currentDate.y - 2) + " (%"
															+ (valueLY2 < 1 ? 100
																	: 100 * (totalVenta - valueLY2) / valueLY2)
															: valueLY2 - totalVenta + " MENOS QUE "
																	+ (currentDate.y - 2) + " (%"
																	+ (valueLY2 == 0 ? 0
																			: 100 * (valueLY2 - totalVenta) / valueLY2))
															+ ")")
											+ (valueLY == -1 ? ""
													: "\n$" + (totalVenta > valueLY
															? totalVenta - valueLY + " MAIS QUE " + (currentDate.y - 1)
																	+ " (%"
																	+ (valueLY < 1 ? 100
																			: 100 * (totalVenta - valueLY) / valueLY)
															: valueLY - totalVenta + " MENOS QUE " + (currentDate.y - 1)
																	+ " (%"
																	+ (valueLY == 0 ? 0
																			: 100 * (valueLY - totalVenta) / valueLY))
															+ ")"))
							+ System.lineSeparator(), // 15
					(dailyAvg == 0 ? ""
							: "COMPARAÇÃO COM AS MÉDIAS DESTE ANO:\n" + "HOJE, VENDEMOS NO TOTAL $" + totalVenta
									+ "\nESTE ANO VENDEMOS UM MÉDIA DIÁRIA DO $" + dailyAvg
									+ (sameDayAvg == 0 ? ""
											: "\nEM MÉDIA DO " + dayName(currentDate, 1) + " $" + sameDayAvg)
									+ (monthlyAvg == 0 ? ""
											: "\nEM MÉDIA MENSAL DO " + currentDate.getMonthForInt(1) + " $"
													+ monthlyAvg)
									+ System.lineSeparator())
							+ (dailyAvg == 0 ? ""
									: "PARECE QUE VENDEMOS"
											+ (sameDayAvg == 0 ? ""
													: "\n • $"
															+ (sameDayAvg > totalVenta ? sameDayAvg - totalVenta
																	+ " MENOS QUE A MÉDIA DE OS "
																	+ dayName(currentDate, 1) + " ▼ "
																	+ 100 * (sameDayAvg - totalVenta) / sameDayAvg
																	: (totalVenta - sameDayAvg
																			+ " MAIS QUE A MÉDIA DE OS "
																			+ dayName(currentDate, 1))
																			+ " ▲ "
																			+ 100 * (-sameDayAvg + totalVenta)
																					/ sameDayAvg)
															+ "%")
											+ "\n • $"
											+ (dailyAvg > totalVenta
													? dailyAvg - totalVenta + " MENOS QUE A MÉDIA DIÁRIA" + " ▼ "
															+ 100 * (dailyAvg - totalVenta) / dailyAvg
													: (totalVenta - dailyAvg + " MAIS QUE A MÉDIA DIÁRIA") + " ▲ "
															+ 100 * (-dailyAvg + totalVenta) / dailyAvg)
											+ "%"
											+ (monthlyAvg == 0 ? ""
													: "\n • $"
															+ (monthlyAvg > totalVenta
																	? monthlyAvg - totalVenta
																			+ " MENOS QUE A MÉDIA MENSAL "
																			+ currentDate.getMonthForInt(

																					1)
																			+ " ▼ " + 100
																					* (monthlyAvg - totalVenta)
																					/ monthlyAvg
																	: (totalVenta - monthlyAvg
																			+ " MAIS QUE A MÉDIA MENSAL "
																			+ currentDate.getMonthForInt(

																					1)
																			+ " ▲ "
																			+ 100 * (-monthlyAvg + totalVenta)
																					/ monthlyAvg))
															+ "%")
											+ System.lineSeparator()), // 17
					"MAIS VENDIDOS DE HOJE POR QUANTIDADE:\n" + top3S, // 18
					"MAIS VENDIDOS DE HOJE POR PREÇO:\n" + top3PS, // 19
					"TOP VENDEDORES:\n" + sellerText, // 19
					System.lineSeparator() + "OBRIGADO E ATÉ AMANHÃ :)"// 18
			};
			String[] engSumm = { "SALES:\nYOU DIDN'T SELL ANYTHING" + System.lineSeparator(), // 0
					"SALES:\nYOU SELL ONE SALE ONLY WORTH $" + totalVenta + System.lineSeparator(), // 1
					"SALES:\nYOU SELL $" + totalVenta + ", DIVIDING INTO " + nbVentas() + " SALES, " + "WITH AVERAGE $"
							+ (nbVentas() == 0 ? 0 : totalVenta / nbVentas()) + System.lineSeparator(), // 2
					"EXPENSES:\nYOU HAVE NO EXPENSES!" + System.lineSeparator(), // 3
					"EXPENSES:\nYOU HAVE IN TOTAL A SPENT WORTH $" + gastosT + "\n" + "DETAILED LIKE:\n"
							+ gastosDetalles(), // 4
					"EXPENSES:\nYOU HAVE A TOTAL $" + gastosT + " AS EXPENSES, " + "DIVIDED BY " + nbGastos()
							+ " THINGS, " + "WITH AVERAGE OF $" + (nbGastos() == 0 ? 0 : gastosT / nbGastos()) + "\n"
							+ "DETAILED AS:\n" + gastosDetalles(), // 5
					"AGGREGATES:\nYOU HAVE IN TOTAL AN AGGREGATE WORTH $" + agregadoT + "\n" + "DETAILED LIKE:\n"
							+ agregadoDetalles(), // 6
					"AGGREGATES:\nYOU HAVE A TOTAL $" + agregadoT + " AS AGGREGATES, " + "DIVIDED BY " + nbAgregados()
							+ " THINGS, " + "WITH AVERAGE OF $" + (nbAgregados() == 0 ? 0 : agregadoT / nbAgregados())
							+ "\n" + "DETAILED AS:\n" + agregadoDetalles(), // 7
					"TO SUMMARIZE:\n" + "WE START THE DAY WITH $" + initialDay.getText() + "\nSELL $" + totalVenta
							+ "\nSPENT $" + gastosT + "\nWHAT WILL END IN $" + totalO + " IN TOTAL"
							+ System.lineSeparator(), // 8
					"TO SUMMARIZE:\n" + "WE START THE DAY WITH $" + initialDay.getText() + "\nSELL $" + totalVenta
							+ "\nSPENT $" + gastosT + "\nADD $" + agregadoT + "\nWHAT WILL END IN $" + totalO
							+ " IN TOTAL" + System.lineSeparator(), // 9
					"THE CASH DID WELL, " + "NO DIFFERENCE" + System.lineSeparator(), // 10
					"THE CASH DIDN'T FIT, " + "LOOKS LIKE " + diffResult.getText().toUpperCase()
							+ System.lineSeparator(), // 11
					"MEMORIES OF TODAY:"
							+ (conLY4.size() == 0 ? ""
									: "\nON " + dayN + "-" + monthS + "-" + (currentDate.y - 4) + ", WHICH IS A "
											+ dayName(new DateModified(Integer.valueOf(dayN),
													Integer.valueOf(currentDate.m), currentDate.y - 4), 2)
											+ (valueLY4 == -1 ? " WE DO NOT OPEN THE STORE!"
													: ", YOU SOLD $" + valueLY4 + " IN TOTAL"))
							+ (conLY3.size() == 0 ? ""
									: "\nON " + dayN + "-" + monthS + "-" + (currentDate.y - 3) + ", WHICH IS A "
											+ dayName(new DateModified(Integer.valueOf(dayN),
													Integer.valueOf(currentDate.m), currentDate.y - 3), 2)
											+ (valueLY3 == -1 ? " WE DO NOT OPEN THE STORE!"
													: ", YOU SOLD $" + valueLY3 + " IN TOTAL"))
							+ (conLY2.size() == 0 ? ""
									: "\nON " + dayN + "-" + monthS + "-" + (currentDate.y - 2) + ", WHICH IS A "
											+ dayName(new DateModified(Integer.valueOf(dayN),
													Integer.valueOf(currentDate.m), currentDate.y - 2), 2)
											+ (valueLY2 == -1 ? " WE DO NOT OPEN THE STORE!"
													: ", YOU SOLD $" + valueLY2 + " IN TOTAL"))
							+ (conLY.size() == 0 ? ""
									: "\nON " + dayN + "-" + monthS + "-" + (currentDate.y - 1) + ", WHICH IS A "
											+ dayName(new DateModified(Integer.valueOf(dayN),
													Integer.valueOf(currentDate.m), currentDate.y - 1), 2)
											+ (valueLY == -1 ? " WE DO NOT OPEN THE STORE!"
													: ", YOU SOLD $" + valueLY + " IN TOTAL"))
							+ "\nTODAY, " + dayS + " YOU SOLD $" + totalVenta
							+ ((valueLY4 == -1 && valueLY3 == -1 && valueLY2 == -1 && valueLY == -1) ? ""
									: " CORRESPONDING TO" + (valueLY4 == -1 ? ""
											: "\n$" + (totalVenta > valueLY4
													? totalVenta - valueLY4 + " MORE THAN " + (currentDate.y - 4)
															+ " (%" + (valueLY4 < 1 ? 100
																	: 100 * (totalVenta - valueLY4) / valueLY4)
													: valueLY4 - totalVenta + " LESS THAN " + (currentDate.y - 4)
															+ " (%"
															+ (valueLY4 < 1 ? 100
																	: 100 * (valueLY4 - totalVenta) / valueLY4))
													+ ")")
											+ (valueLY3 == -1 ? ""
													: "\n$" + (totalVenta > valueLY3
															? totalVenta - valueLY3 + " MORE THAN "
																	+ (currentDate.y - 3) + " (%" + (valueLY3 < 1 ? 100
																			: 100 * (totalVenta - valueLY3) / valueLY3)
															: valueLY3 - totalVenta + " LESS THAN "
																	+ (currentDate.y - 3) + " (%"
																	+ (valueLY3 == 0 ? 0
																			: 100 * (valueLY3 - totalVenta) / valueLY3))
															+ ")")
											+ (valueLY2 == -1 ? ""
													: "\n$" + (totalVenta > valueLY2
															? totalVenta - valueLY2 + " MORE THAN "
																	+ (currentDate.y - 2) + " (%" + (valueLY2 < 1 ? 100
																			: 100 * (totalVenta - valueLY2) / valueLY2)
															: valueLY2 - totalVenta + " LESS THAN "
																	+ (currentDate.y - 2) + " (%"
																	+ (valueLY2 == 0 ? 0
																			: 100 * (valueLY2 - totalVenta) / valueLY2))
															+ ")")
											+ (valueLY == -1 ? ""
													: "\n$" + (totalVenta > valueLY
															? totalVenta - valueLY + " MORE THAN " + (currentDate.y - 1)
																	+ " (%"
																	+ (valueLY < 1 ? 100
																			: 100 * (totalVenta - valueLY) / valueLY)
															: valueLY - totalVenta + " LESS THAN " + (currentDate.y - 1)
																	+ " (%"
																	+ (valueLY == 0 ? 0
																			: 100 * (valueLY - totalVenta) / valueLY))
															+ ")"))
							+ System.lineSeparator(), // 15
					(dailyAvg == 0 ? ""
							: "COMPARISON WITH THIS YEAR'S AVERAGES:\n" + "TODAY, WE SOLD IN TOTAL $" + totalVenta
									+ "\nTHIS YEAR WE SOLD A DAILY AVERAGE OF $" + dailyAvg
									+ (sameDayAvg == 0 ? ""
											: "\nAN AVERAGE OF THE " + dayName(currentDate, 2) + " $" + sameDayAvg)
									+ (monthlyAvg == 0 ? ""
											: "\nA MONTHLY AVERAGE OF " + currentDate.getMonthForInt(2) + " $"
													+ monthlyAvg)
									+ System.lineSeparator())
							+ (dailyAvg == 0 ? ""
									: "IT LOOKS LIKE WE SOLD"
											+ (sameDayAvg == 0 ? ""
													: "\n • $" + (sameDayAvg > totalVenta ? sameDayAvg
															- totalVenta + " LESS THAN THE AVERAGE OF THE "
															+ dayName(currentDate, 2) + " ▼ "
															+ 100 * (sameDayAvg - totalVenta) / sameDayAvg
															: (totalVenta - sameDayAvg
																	+ " MORE THAN THE AVERAGE OF THE "
																	+ dayName(currentDate, 2)) + " ▲ "
																	+ 100 * (-sameDayAvg + totalVenta) / sameDayAvg)
															+ "%")
											+ "\n • $"
											+ (dailyAvg > totalVenta
													? dailyAvg - totalVenta + " LESS THAN THE DAILY AVERAGE" + " ▼ "
															+ 100 * (dailyAvg - totalVenta) / dailyAvg
													: (totalVenta - dailyAvg + " MORE THAN THE DAILY AVERAGE") + " ▲ "
															+ 100 * (-dailyAvg + totalVenta) / dailyAvg)
											+ "%"
											+ (monthlyAvg == 0 ? ""
													: "\n • $"
															+ (monthlyAvg > totalVenta
																	? monthlyAvg - totalVenta
																			+ " LESS THAN THE MONTHLY AVERAGE OF "
																			+ currentDate.getMonthForInt(

																					2)
																			+ " ▼ " + 100
																					* (monthlyAvg - totalVenta)
																					/ monthlyAvg
																	: (totalVenta - monthlyAvg
																			+ " MORE THAN THE MONTHLY AVERAGE OF "
																			+ currentDate.getMonthForInt(

																					2)
																			+ " ▲ "
																			+ 100 * (-monthlyAvg + totalVenta)
																					/ monthlyAvg))
															+ "%")
											+ System.lineSeparator()), // 17
					"TOP SELL OF TODAY BY QUANTITY:\n" + top3S, // 18
					"TOP SELL OF TODAY BY PRICE:\n" + top3PS, // 19
					"TOP SELLERS:\n" + sellerText, // 19
					System.lineSeparator() + "THANKS AND SEE YOU TOMORROW :)" // 16
			};
			String[] frSumm = { "VENTES :\nVOUS N'AVEZ RIEN VENDU" + System.lineSeparator(), // 0
					"VENTES :\nVOUS VENDEZ UNE SEULE VENTE D'UNE VALEUR $" + totalVenta + System.lineSeparator(), // 1
					"VENTES :\nVOUS VENDEZ $" + totalVenta + ", SE DIVISANT EN " + nbVentas() + " VENTES, "
							+ "AVEC $ MOYEN" + (nbVentas() == 0 ? 0 : totalVenta / nbVentas()) + System.lineSeparator(), // 2
					"COÛTS :\nVOUS N'AVEZ PAS DE COÛTS !" + System.lineSeparator(), // 3
					"COÛTS :\nVOUS AVEZ DÉPENSÉ AU TOTAL $" + gastosT + "\n" + "COMME DÉTAILLÉ :\n" + gastosDetalles(), // 4
					"COÛTS :\nVOUS AVEZ UN TOTAL $" + gastosT + " COMME COÛTS, " + "DIVISÉ PAR " + nbGastos()
							+ " CHOSES, " + "AVEC MOYENNE DE $" + (nbGastos() == 0 ? 0 : gastosT / nbGastos()) + "\n"
							+ "DÉTAILLÉ COMME:\n" + gastosDetalles(), // 5
					"AGRÉGATS :\nVOUS AVEZ AU TOTAL UNE VALEUR AGRÉGÉE $" + agregadoT + "\n" + "DETAILED LIKE :\n"
							+ agregadoDetalles(), // 6
					"AGRÉGATS :\nVOUS AVEZ UN TOTAL $" + agregadoT + " COMME AGRÉGATS, " + "DIVISE PAR " + nbAgregados()
							+ " CHOSES, " + "AVEC MOYENNE DE $" + (nbAgregados() == 0 ? 0 : agregadoT / nbAgregados())
							+ "\n" + "DÉTAILLÉ COMME:\n" + agregadoDetalles(), // 7
					"POUR RÉSUMER :\n" + "NOUS COMMENÇONS LA JOURNÉE AVEC $" + initialDay.getText() + "\nVENDRE $"
							+ totalVenta + "\nDÉPENSER $" + gastosT + "\nCE QUI SE TERMINERA EN $" + totalO
							+ " AU TOTAL" + System.lineSeparator(), // 8
					"POUR RÉSUMER :\n" + "NOUS COMMENÇONS LA JOURNÉE AVEC $" + initialDay.getText() + "\nVENDRE $"
							+ totalVenta + "\nDÉPENSER $" + gastosT + "\nAJOUTER $" + agregadoT
							+ "\nCE QUI SE TERMINERA EN $" + totalO + " AU TOTAL" + System.lineSeparator(), // 9
					"L'ARGENT A BIEN FAIT, " + "PAS DE DIFFERENCE" + System.lineSeparator(), // 10
					"L'ARGENT N'A PAS CONVENU," + "RESSEMBLE À" + diffResult.getText().toUpperCase()
							+ System.lineSeparator(), // 11
					"MÉMOIRES D'AUJOURD'HUI:"
							+ (conLY4.size() == 0 ? ""
									: "\nON " + dayN + "-" + monthS + "-" + (currentDate.y - 4) + ", QUI EST UN "
											+ dayName(new DateModified(Integer.valueOf(dayN),
													Integer.valueOf(currentDate.m), currentDate.y - 4), 3)
											+ (valueLY4 == -1 ? " NOUS N'OUVRONS PAS LE MAGASIN!"
													: ", VOUS AVEZ VENDU $" + valueLY4 + " AU TOTAL"))
							+ (conLY3.size() == 0 ? ""
									: "\nON " + dayN + "-" + monthS + "-" + (currentDate.y - 3) + ", QUI EST UN "
											+ dayName(new DateModified(Integer.valueOf(dayN),
													Integer.valueOf(currentDate.m), currentDate.y - 3), 3)
											+ (valueLY3 == -1 ? " NOUS N'OUVRONS PAS LE MAGASIN!"
													: ", VOUS AVEZ VENDU $" + valueLY3 + " AU TOTAL"))
							+ (conLY2.size() == 0 ? ""
									: "\nON " + dayN + "-" + monthS + "-" + (currentDate.y - 2) + ", QUI EST UN "
											+ dayName(new DateModified(Integer.valueOf(dayN),
													Integer.valueOf(currentDate.m), currentDate.y - 2), 3)
											+ (valueLY2 == -1 ? " NOUS N'OUVRONS PAS LE MAGASIN!"
													: ", VOUS AVEZ VENDU $" + valueLY2 + " AU TOTAL"))
							+ (conLY.size() == 0 ? ""
									: "\nON " + dayN + "-" + monthS + "-" + (currentDate.y - 1) + ", QUI EST UN "
											+ dayName(new DateModified(Integer.valueOf(dayN),
													Integer.valueOf(currentDate.m), currentDate.y - 1), 3)
											+ (valueLY == -1 ? " NOUS N'OUVRONS PAS LE MAGASIN!"
													: ", VOUS AVEZ VENDU $" + valueLY + " AU TOTAL"))
							+ "\nAUJOURD'HUI, " + dayS + " VOUS AVEZ VENDU $" + totalVenta
							+ ((valueLY4 == -1 && valueLY3 == -1 && valueLY2 == -1 && valueLY == -1) ? ""
									: " CORRESPOND À" + (valueLY4 == -1 ? ""
											: "\n$" + (totalVenta > valueLY4 ? totalVenta - valueLY4 + " PLUS QUE "
													+ (currentDate.y - 4) + " (%"
													+ (valueLY4 < 1 ? 100 : 100 * (totalVenta - valueLY4) / valueLY4)
													: valueLY4 - totalVenta + " MOINS QUE " + (currentDate.y - 4)
															+ " (%"
															+ (valueLY4 < 1 ? 100
																	: 100 * (valueLY4 - totalVenta) / valueLY4))
													+ ")")
											+ (valueLY3 == -1 ? ""
													: "\n$" + (totalVenta > valueLY3 ? totalVenta - valueLY3
															+ " PLUS QUE " + (currentDate.y - 3) + " (%"
															+ (valueLY3 < 1 ? 100
																	: 100 * (totalVenta - valueLY3) / valueLY3)
															: valueLY3 - totalVenta + " MOINS QUE "
																	+ (currentDate.y - 3) + " (%"
																	+ (valueLY3 == 0 ? 0
																			: 100 * (valueLY3 - totalVenta) / valueLY3))
															+ ")")
											+ (valueLY2 == -1 ? ""
													: "\n$" + (totalVenta > valueLY2 ? totalVenta - valueLY2
															+ " PLUS QUE " + (currentDate.y - 2) + " (%"
															+ (valueLY2 < 1 ? 100
																	: 100 * (totalVenta - valueLY2) / valueLY2)
															: valueLY2 - totalVenta + " MOINS QUE "
																	+ (currentDate.y - 2) + " (%"
																	+ (valueLY2 == 0 ? 0
																			: 100 * (valueLY2 - totalVenta) / valueLY2))
															+ ")")
											+ (valueLY == -1 ? ""
													: "\n$" + (totalVenta > valueLY
															? totalVenta - valueLY + " PLUS QUE " + (currentDate.y - 1)
																	+ " (%"
																	+ (valueLY < 1 ? 100
																			: 100 * (totalVenta - valueLY) / valueLY)
															: valueLY - totalVenta + " MOINS QUE " + (currentDate.y - 1)
																	+ " (%"
																	+ (valueLY == 0 ? 0
																			: 100 * (valueLY - totalVenta) / valueLY))
															+ ")"))
							+ System.lineSeparator(), // 15
					(dailyAvg == 0 ? ""
							: "COMPARAISON AVEC LES MOYENNES DE CETTE ANNÉE:\n"
									+ "AUJOURD'HUI, NOUS AVONS VENDU AU TOTAL $" + totalVenta
									+ "\nCETTE ANNÉE, NOUS AVONS VENDU UNE MOYENNE QUOTIDIENNE DE $" + dailyAvg
									+ (sameDayAvg == 0 ? ""
											: "\nUNE MOYENNE DU " + dayName(currentDate, 3) + " $" + sameDayAvg)
									+ (monthlyAvg == 0 ? ""
											: "\nUNE MOYENNE MENSUELLE DE " + currentDate.getMonthForInt(3) + " $"
													+ monthlyAvg)
									+ System.lineSeparator())
							+ (dailyAvg == 0 ? ""
									: "IL RESSEMBLE QUE NOUS AVONS VENDU"
											+ (sameDayAvg == 0 ? ""
													: "\n • $"
															+ (sameDayAvg > totalVenta ? sameDayAvg - totalVenta
																	+ " MOINS QUE LA MOYENNE DES "
																	+ dayName(currentDate, 3) + " ▼ "
																	+ 100 * (sameDayAvg - totalVenta) / sameDayAvg
																	: (totalVenta - sameDayAvg
																			+ " PLUS QUE LA MOYENNE DES "
																			+ dayName(currentDate, 3))
																			+ " ▲ "
																			+ 100 * (-sameDayAvg + totalVenta)
																					/ sameDayAvg)
															+ "%")
											+ "\n • $"
											+ (dailyAvg > totalVenta
													? dailyAvg - totalVenta + " MOINS QUE LA MOYENNE QUOTIDIENNE"
															+ " ▼ " + 100 * (dailyAvg - totalVenta) / dailyAvg
													: (totalVenta - dailyAvg + " PLUS QUE LA MOYENNE QUOTIDIENNE")
															+ " ▲ " + 100 * (-dailyAvg + totalVenta) / dailyAvg)
											+ "%"
											+ (monthlyAvg == 0 ? ""
													: "\n • $"
															+ (monthlyAvg > totalVenta
																	? monthlyAvg - totalVenta
																			+ " MOINS QUE LA MOYENNE MENSUELLE DE "
																			+ currentDate.getMonthForInt(

																					3)
																			+ " ▼ " + 100
																					* (monthlyAvg - totalVenta)
																					/ monthlyAvg
																	: (totalVenta - monthlyAvg
																			+ " PLUS QUE EL PLA MOYENNE MENSUELLE DE "
																			+ currentDate.getMonthForInt(

																					3)
																			+ " ▲ "
																			+ 100 * (-monthlyAvg + totalVenta)
																					/ monthlyAvg))
															+ "%")
											+ System.lineSeparator()), // 17
					"MEILLEURES VENTES DU JOUR PAR QUANTITÉ:\n" + top3S, // 18
					"MEILLEURES VENTES DU JOUR PAR PRIX:\n" + top3PS, // 19
					"MEILLEURS VENDEURS:\n" + sellerText, // 19
					System.lineSeparator() + "MERCI ET A DEMAIN :)" // 16
			};
			savedF.write("HADI-TECH"
					+ (language == Language.SPANISH ? " - SUMARIO POR EL DIA "
							: language == Language.PORTUGUES ? " - SUMÁRIO DO DIA "
									: language == Language.ENGLISH ? " - SUMMARY OF THE DAY "
											: " - RÉSUMÉ DE LA JOURNÉE ")
					+ dayS + " " + dayN + "-" + monthS + "-" + yearS + System.lineSeparator() + System.lineSeparator());
			if (totalVenta == 0)
				savedF.write("I. " + (language == Language.SPANISH ? espSumm[0]
						: language == Language.PORTUGUES ? porSumm[0]
								: language == Language.ENGLISH ? engSumm[0] : frSumm[0]));
			else if (nbVentas() == 1)
				savedF.write("I. " + (language == Language.SPANISH ? espSumm[1]
						: language == Language.PORTUGUES ? porSumm[1]
								: language == Language.ENGLISH ? engSumm[1] : frSumm[1]));
			else
				savedF.write("I. " + (language == Language.SPANISH ? espSumm[2]
						: language == Language.PORTUGUES ? porSumm[2]
								: language == Language.ENGLISH ? engSumm[2] : frSumm[2]));
			if (gastosT == 0)// GASTOS SAVE
				savedF.write(System.lineSeparator() + "II. "
						+ (language == Language.SPANISH ? espSumm[3]
								: language == Language.PORTUGUES ? porSumm[3]
										: language == Language.ENGLISH ? engSumm[3] : frSumm[3]));
			else if (nbGastos() == 1)
				savedF.write(System.lineSeparator() + "II. "
						+ (language == Language.SPANISH ? espSumm[4]
								: language == Language.PORTUGUES ? porSumm[4]
										: language == Language.ENGLISH ? engSumm[4] : frSumm[4]));
			else
				savedF.write(System.lineSeparator() + "II. "
						+ (language == Language.SPANISH ? espSumm[5]
								: language == Language.PORTUGUES ? porSumm[5]
										: language == Language.ENGLISH ? engSumm[5] : frSumm[5]));
			if (nbAgregados() != 0) { // AGG SAVE if 1
				if (nbAgregados() == 1)
					savedF.write(System.lineSeparator() + "III. "
							+ (language == Language.SPANISH ? espSumm[6]
									: language == Language.PORTUGUES ? porSumm[6]
											: language == Language.ENGLISH ? engSumm[6] : frSumm[6]));
				else
					savedF.write(System.lineSeparator() + "III. "
							+ (language == Language.SPANISH ? espSumm[7]
									: language == Language.PORTUGUES ? porSumm[7]
											: language == Language.ENGLISH ? engSumm[7] : frSumm[7]));
				savedF.write(System.lineSeparator() + "IV. "
						+ (language == Language.SPANISH ? espSumm[9]
								: language == Language.PORTUGUES ? porSumm[9]
										: language == Language.ENGLISH ? engSumm[9] : frSumm[9]));
				if (totalO == totalCaja)
					savedF.write(System.lineSeparator() + "V. "
							+ (language == Language.SPANISH ? espSumm[10]
									: language == Language.PORTUGUES ? porSumm[10]
											: language == Language.ENGLISH ? engSumm[10] : frSumm[10]));
				else
					savedF.write(System.lineSeparator() + "V. "
							+ (language == Language.SPANISH ? espSumm[11]
									: language == Language.PORTUGUES ? porSumm[11]
											: language == Language.ENGLISH ? engSumm[11] : frSumm[11]));
				if ((currentDate.d == 29 && currentDate.m == 2)
						|| (conLY.size() == 0 && conLY2.size() == 0 && conLY3.size() == 0 && conLY4.size() == 0)) {
					savedF.write(System.lineSeparator() + "VI. "
							+ (language == Language.SPANISH ? espSumm[13]
									: language == Language.PORTUGUES ? porSumm[13]
											: language == Language.ENGLISH ? engSumm[13] : frSumm[13]));// 2
					if (!dayMessage.isBlank()) {
						savedF.write(System.lineSeparator() + "VII. " + getLocalizedMessage("NOTE") + ":"
								+ System.lineSeparator() + dayMessage.toUpperCase() + System.lineSeparator()); // note
						if (top3.size() > 1 || (top3.size() == 1 && !top3.get(0).getKey().isBlank())) {
							savedF.write(System.lineSeparator() + "VIII. "
									+ (language == Language.SPANISH ? espSumm[14]
											: language == Language.PORTUGUES ? porSumm[14]
													: language == Language.ENGLISH ? engSumm[14] : frSumm[14])); // TOP
							savedF.write(System.lineSeparator() + "IX. "
									+ (language == Language.SPANISH ? espSumm[15]
											: language == Language.PORTUGUES ? porSumm[15]
													: language == Language.ENGLISH ? engSumm[15] : frSumm[15])); // TOP
							savedF.write(System.lineSeparator() + "X. "
									+ (language == Language.SPANISH ? espSumm[16]
											: language == Language.PORTUGUES ? porSumm[16]
													: language == Language.ENGLISH ? engSumm[16] : frSumm[16])); // SELLER
						}
					} else {
						if (top3.size() > 1 || (top3.size() == 1 && !top3.get(0).getKey().isBlank())) {
							savedF.write(System.lineSeparator() + "VI. "
									+ (language == Language.SPANISH ? espSumm[14]
											: language == Language.PORTUGUES ? porSumm[14]
													: language == Language.ENGLISH ? engSumm[14] : frSumm[14])); // TOP
							savedF.write(System.lineSeparator() + "VII. "
									+ (language == Language.SPANISH ? espSumm[15]
											: language == Language.PORTUGUES ? porSumm[15]
													: language == Language.ENGLISH ? engSumm[15] : frSumm[15])); // TOP
							savedF.write(System.lineSeparator() + "VIII. "
									+ (language == Language.SPANISH ? espSumm[16]
											: language == Language.PORTUGUES ? porSumm[16]
													: language == Language.ENGLISH ? engSumm[16] : frSumm[16])); // SELLER
						}
					}
				} else {
					savedF.write(System.lineSeparator() + "VI. "
							+ (language == Language.SPANISH ? espSumm[12]
									: language == Language.PORTUGUES ? porSumm[12]
											: language == Language.ENGLISH ? engSumm[12] : frSumm[12]));// mem
					savedF.write(System.lineSeparator() + "VII. "
							+ (language == Language.SPANISH ? espSumm[13]
									: language == Language.PORTUGUES ? porSumm[13]
											: language == Language.ENGLISH ? engSumm[13] : frSumm[13]));// 2
					if (!dayMessage.isBlank()) {
						savedF.write(System.lineSeparator() + "VIII. " + getLocalizedMessage("NOTE") + ":"
								+ System.lineSeparator() + dayMessage.toUpperCase() + System.lineSeparator()); // note
						if (top3.size() > 1 || (top3.size() == 1 && !top3.get(0).getKey().isBlank())) {
							savedF.write(System.lineSeparator() + "IX. "
									+ (language == Language.SPANISH ? espSumm[14]
											: language == Language.PORTUGUES ? porSumm[14]
													: language == Language.ENGLISH ? engSumm[14] : frSumm[14])); // TOP
							savedF.write(System.lineSeparator() + "X. "
									+ (language == Language.SPANISH ? espSumm[15]
											: language == Language.PORTUGUES ? porSumm[15]
													: language == Language.ENGLISH ? engSumm[15] : frSumm[15])); // TOP
							savedF.write(System.lineSeparator() + "XI. "
									+ (language == Language.SPANISH ? espSumm[16]
											: language == Language.PORTUGUES ? porSumm[16]
													: language == Language.ENGLISH ? engSumm[16] : frSumm[16])); // SELLER
						}
					} else if (top3.size() > 1 || (top3.size() == 1 && !top3.get(0).getKey().isBlank())) {
						savedF.write(System.lineSeparator() + "VIII. "
								+ (language == Language.SPANISH ? espSumm[14]
										: language == Language.PORTUGUES ? porSumm[14]
												: language == Language.ENGLISH ? engSumm[14] : frSumm[14])); // TOP
						savedF.write(System.lineSeparator() + "IX. "
								+ (language == Language.SPANISH ? espSumm[15]
										: language == Language.PORTUGUES ? porSumm[15]
												: language == Language.ENGLISH ? engSumm[15] : frSumm[15])); // TOP
						savedF.write(System.lineSeparator() + "X. "
								+ (language == Language.SPANISH ? espSumm[16]
										: language == Language.PORTUGUES ? porSumm[16]
												: language == Language.ENGLISH ? engSumm[16] : frSumm[16])); // SELLER
					}
				}
			} else {
				savedF.write(System.lineSeparator() + "III. "
						+ (language == Language.SPANISH ? espSumm[8]
								: language == Language.PORTUGUES ? porSumm[8]
										: language == Language.ENGLISH ? engSumm[8] : frSumm[8]));
				if (totalO == totalCaja)
					savedF.write(System.lineSeparator() + "IV. "
							+ (language == Language.SPANISH ? espSumm[10]
									: language == Language.PORTUGUES ? porSumm[10]
											: language == Language.ENGLISH ? engSumm[10] : frSumm[10]));
				else
					savedF.write(System.lineSeparator() + "IV. "
							+ (language == Language.SPANISH ? espSumm[11]
									: language == Language.PORTUGUES ? porSumm[11]
											: language == Language.ENGLISH ? engSumm[11] : frSumm[11]));
				if ((currentDate.d == 29 && currentDate.m == 2)
						|| (conLY.size() == 0 && conLY2.size() == 0 && conLY3.size() == 0 && conLY4.size() == 0)) {
					savedF.write(System.lineSeparator() + "V. "
							+ (language == Language.SPANISH ? espSumm[13]
									: language == Language.PORTUGUES ? porSumm[13]
											: language == Language.ENGLISH ? engSumm[13] : frSumm[13]));// 2
					if (!dayMessage.isBlank()) {
						savedF.write(System.lineSeparator() + "VI. " + getLocalizedMessage("NOTE") + ":"
								+ System.lineSeparator() + dayMessage.toUpperCase() + System.lineSeparator()); // note
						if (top3.size() > 1 || (top3.size() == 1 && !top3.get(0).getKey().isBlank())) {
							savedF.write(System.lineSeparator() + "VII. "
									+ (language == Language.SPANISH ? espSumm[14]
											: language == Language.PORTUGUES ? porSumm[14]
													: language == Language.ENGLISH ? engSumm[14] : frSumm[14])); // TOP
							savedF.write(System.lineSeparator() + "VIII. "
									+ (language == Language.SPANISH ? espSumm[15]
											: language == Language.PORTUGUES ? porSumm[15]
													: language == Language.ENGLISH ? engSumm[15] : frSumm[15])); // TOP
							savedF.write(System.lineSeparator() + "IX. "
									+ (language == Language.SPANISH ? espSumm[16]
											: language == Language.PORTUGUES ? porSumm[16]
													: language == Language.ENGLISH ? engSumm[16] : frSumm[16])); // SELLER
						}
					} else {
						if (top3.size() > 1 || (top3.size() == 1 && !top3.get(0).getKey().isBlank())) {
							savedF.write(System.lineSeparator() + "VI. "
									+ (language == Language.SPANISH ? espSumm[14]
											: language == Language.PORTUGUES ? porSumm[14]
													: language == Language.ENGLISH ? engSumm[14] : frSumm[14])); // TOP
							savedF.write(System.lineSeparator() + "VII. "
									+ (language == Language.SPANISH ? espSumm[15]
											: language == Language.PORTUGUES ? porSumm[15]
													: language == Language.ENGLISH ? engSumm[15] : frSumm[15])); // TOP
							savedF.write(System.lineSeparator() + "VIII. "
									+ (language == Language.SPANISH ? espSumm[16]
											: language == Language.PORTUGUES ? porSumm[16]
													: language == Language.ENGLISH ? engSumm[16] : frSumm[16])); // SELLER
						}
					}
				} else {
					savedF.write(System.lineSeparator() + "V. "
							+ (language == Language.SPANISH ? espSumm[12]
									: language == Language.PORTUGUES ? porSumm[12]
											: language == Language.ENGLISH ? engSumm[12] : frSumm[12]));// mem
					savedF.write(System.lineSeparator() + "VI. "
							+ (language == Language.SPANISH ? espSumm[13]
									: language == Language.PORTUGUES ? porSumm[13]
											: language == Language.ENGLISH ? engSumm[13] : frSumm[13]));// 2
					if (!dayMessage.isBlank()) {
						savedF.write(System.lineSeparator() + "VII. " + getLocalizedMessage("NOTE") + ":"
								+ System.lineSeparator() + dayMessage.toUpperCase() + System.lineSeparator()); // note
						if (top3.size() > 1 || (top3.size() == 1 && !top3.get(0).getKey().isBlank())) {
							savedF.write(System.lineSeparator() + "VIII. "
									+ (language == Language.SPANISH ? espSumm[14]
											: language == Language.PORTUGUES ? porSumm[14]
													: language == Language.ENGLISH ? engSumm[14] : frSumm[14])); // TOP
							savedF.write(System.lineSeparator() + "IX. "
									+ (language == Language.SPANISH ? espSumm[15]
											: language == Language.PORTUGUES ? porSumm[15]
													: language == Language.ENGLISH ? engSumm[15] : frSumm[15])); // TOP
							savedF.write(System.lineSeparator() + "X. "
									+ (language == Language.SPANISH ? espSumm[16]
											: language == Language.PORTUGUES ? porSumm[16]
													: language == Language.ENGLISH ? engSumm[16] : frSumm[16])); // SELLER
						}
					} else {
						if (top3.size() > 1 || (top3.size() == 1 && !top3.get(0).getKey().isBlank())) {
							savedF.write(System.lineSeparator() + "VII. "
									+ (language == Language.SPANISH ? espSumm[14]
											: language == Language.PORTUGUES ? porSumm[14]
													: language == Language.ENGLISH ? engSumm[14] : frSumm[14])); // TOP
							savedF.write(System.lineSeparator() + "VIII. "
									+ (language == Language.SPANISH ? espSumm[15]
											: language == Language.PORTUGUES ? porSumm[15]
													: language == Language.ENGLISH ? engSumm[15] : frSumm[15])); // TOP
							savedF.write(System.lineSeparator() + "IX. "
									+ (language == Language.SPANISH ? espSumm[16]
											: language == Language.PORTUGUES ? porSumm[16]
													: language == Language.ENGLISH ? engSumm[16] : frSumm[16])); // SELLER
						}
					}
				}
			}
			savedF.write(language == Language.SPANISH ? espSumm[17]
					: language == Language.PORTUGUES ? porSumm[17]
							: language == Language.ENGLISH ? engSumm[17] : frSumm[17]);// thanks
			savedF.close();
			Toast.show(this, Toast.Type.SUCCESS, getLocalizedMessage("EXP_TXT"), Intro.notOption);
			// export at the end of the month
			if (Integer.valueOf(dayN) == currentDate.maxDays())
				exMonthFrame(Integer.valueOf(currentDate.m));
			// Verification if the month summary is save
			if (currentDate.m > 1) {
				File previousMonthFolder = new File(
						yearFolder + "\\" + (currentDate.m - 1) + "-" + getMonthForInt(currentDate.m - 2, langIndex));
				previousMonthFolder.mkdir();
				File monthFile = new File(previousMonthFolder,
						getLocalizedMessage("SUMMARY") + " - " + getMonthForInt(currentDate.m - 2, langIndex) + ".txt");
				if (!monthFile.exists())
					exMonthFrame(currentDate.m - 1);
			}
			// Export the summary of the current year
			if ((Integer.valueOf(dayN) == 31 && Integer.valueOf(currentDate.m) == 12))
				exYearFrame();
		} catch (Exception e2) {
			writeError(e2);
		}
	}

	/* Export the month overview */
	private void exMonthFrame(int month) {
		DateModified dateFromMonth = new DateModified(Integer.valueOf(dayN), month, currentDate.y);
		int total24[] = DataCalc.totalOfMes(month, currentDate.y - 1);
		int avgM24 = total24[0] == 0 ? 0 : total24[0] / total24[1];
		int total23[] = DataCalc.totalOfMes(month, currentDate.y - 2);
		int avgM23 = total23[0] == 0 ? 0 : total23[0] / total23[1];
		int total22[] = DataCalc.totalOfMes(month, currentDate.y - 3);
		int avgM22 = total22[0] == 0 ? 0 : total22[0] / total22[1];
		int total21[] = DataCalc.totalOfMes(month, currentDate.y - 4);
		int avgM21 = total21[1] == 0 ? 0 : total21[0] / total21[1];
		int totalCY[] = DataCalc.totalOfMes(month, currentDate.y);
		int avgM = totalCY[1] == 0 ? 0 : totalCY[0] / totalCY[1];
		int[] optMonth = DataCalc.maxMinMes(month);
		int max = optMonth[0], min = optMonth[1];
		int maxDIndex = optMonth[2] - dateFromMonth.index();
		String maxDayString = dayName(new DateModified(maxDIndex, month, currentDate.y), langIndex);
		int minDIndex = optMonth[3] - dateFromMonth.index();
		String minDayString = dayName(new DateModified(minDIndex, month, currentDate.y), langIndex);
		int maxCounter = optMonth[4], minCounter = optMonth[5];
		String[] avfOfMonths = DataCalc.monthsText(month, currentDate.y, langIndex);
		int daysAvg[] = new int[7];
		// days avg
		daysAvg[0] = DataCalc.avgSpeDayAccMonth("Monday", month);
		daysAvg[1] = DataCalc.avgSpeDayAccMonth("Tuesday", month);
		daysAvg[2] = DataCalc.avgSpeDayAccMonth("Wednesday", month);
		daysAvg[3] = DataCalc.avgSpeDayAccMonth("Thursday", month);
		daysAvg[4] = DataCalc.avgSpeDayAccMonth("Friday", month);
		daysAvg[5] = DataCalc.avgSpeDayAccMonth("Saturday", month);
		daysAvg[6] = DataCalc.avgSpeDayAccMonth("Sunday", month);
		double daysPerc[] = new double[7];
		for (int i = 0; i < 7; i++) {
			daysPerc[i] = (double) daysAvg[i] * 100
					/ (daysAvg[0] + daysAvg[1] + daysAvg[2] + daysAvg[3] + daysAvg[4] + daysAvg[5] + daysAvg[6]);
			daysPerc[i] = Math.round(daysPerc[i] * 100);
			daysPerc[i] = daysPerc[i] / 100;
		}

		// top 10 merchandise sell
		List<Map.Entry<String, Integer>> top10 = getTop10MonthlySales(currentDate.y, month);
		List<Map.Entry<String, Double>> top10Price = getTop10MonthlyPrice(currentDate.y, month);
		String top10S = "", top10P = "";
		int rank = 1;
		for (int i = 0; i < top10.size(); i++) {
			if (i > 0 && i < top10.size())
				if (top10.get(i).getValue() == top10.get(i - 1).getValue()) {
					top10S += " " + --rank + "- " + top10.get(i).getKey() + " -> " + top10.get(i).getValue() + "\n";
				} else {
					top10S += " " + (i + 1) + "- " + top10.get(i).getKey() + " -> " + top10.get(i).getValue() + "\n";
					rank = i + 1;
				}
			else
				top10S += " " + rank + "- " + top10.get(i).getKey() + " -> " + top10.get(i).getValue() + "\n";
			rank++;
		}
		rank = 1;
		for (int i = 0; i < top10Price.size(); i++) {
			if (i > 0 && i < top10Price.size()) {
				if (top10Price.get(i).getValue().equals(top10Price.get(i - 1).getValue())) {
					top10P += " " + --rank + "- " + top10Price.get(i).getKey() + " -> $" + top10Price.get(i).getValue()
							+ "\n";
				} else {
					top10P += " " + (i + 1) + "- " + top10Price.get(i).getKey() + " -> $" + top10Price.get(i).getValue()
							+ "\n";
					rank = i + 1;
				}
			} else
				top10P += " " + rank + "- " + top10Price.get(i).getKey() + " -> $" + top10Price.get(i).getValue()
						+ "\n";
			rank++;
		}
		// seller sales of this month
		String sellerText = "", avgSeller = "", rankSeller = "";
		rank = 1;
		Map<String, Integer> sortedMap = new HashMap<String, Integer>(), avgMap = new HashMap<String, Integer>(),
				IntroRankMap = new HashMap<String, Integer>();
		for (int i = 0; i < employee.size(); i++) {
			String name = employee.get(i).getName();
			int totalMonth = getSalesOfMonthYear(name, month, currentDate.y);
			int avgMonth = avgSales(name, month, currentDate.y);
			int IntroRank = findIntroRankDays(name, month, currentDate.y);
			if (totalMonth > 0) {
				sortedMap.put(name, totalMonth);
				avgMap.put(name, avgMonth);
				IntroRankMap.put(name, IntroRank);
			}
		}
		sortedMap = sortedMap.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
				.collect(LinkedHashMap::new, (map, entry) -> map.put(entry.getKey(), entry.getValue()), Map::putAll);
		avgMap = avgMap.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
				.collect(LinkedHashMap::new, (map, entry) -> map.put(entry.getKey(), entry.getValue()), Map::putAll);
		IntroRankMap = IntroRankMap.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
				.collect(LinkedHashMap::new, (map, entry) -> map.put(entry.getKey(), entry.getValue()), Map::putAll);
		int totalM = 0, avgSell = 0, rankValue = 0;
		for (Map.Entry<String, Integer> entry : sortedMap.entrySet())
			totalM += entry.getValue();
		for (Map.Entry<String, Integer> entry : sortedMap.entrySet())
			sellerText += "  " + (rank++) + "- " + entry.getKey() + " -> $" + entry.getValue() + " ("
					+ (entry.getValue() * 100 / totalM) + "%)\n";
		rank = 1;
		for (Map.Entry<String, Integer> entry : avgMap.entrySet())
			avgSell += entry.getValue();
		for (Map.Entry<String, Integer> entry : avgMap.entrySet())
			avgSeller += "  " + (rank++) + "- " + entry.getKey() + " -> $" + entry.getValue()
					+ (avgSell == 0 ? "" : " (" + (entry.getValue() * 100 / avgSell) + "%)") + "\n";
		rank = 1;
		for (Map.Entry<String, Integer> entry : IntroRankMap.entrySet())
			rankValue += entry.getValue();
		for (Map.Entry<String, Integer> entry : IntroRankMap.entrySet())
			rankSeller += "  " + (rank++) + "- " + entry.getKey() + " -> " + entry.getValue()
					+ (langIndex == 0 ? " DÍAS" : langIndex == 1 ? " DIAS" : langIndex == 2 ? " DAYS" : " JOURS")
					+ (rankValue == 0 ? "" : " (" + (entry.getValue() * 100 / rankValue) + "%)") + "\n";
		try {
			dataFolder.mkdir();
			File yearFolder = new File(dataFolder + "\\" + yearS);
			yearFolder.mkdir();
			File monthFolder = new File(yearFolder + "\\" + month + "-" + getMonthForInt(month - 1, langIndex));
			monthFolder.mkdir();
			File monthFile = new File(monthFolder,
					getLocalizedMessage("SUMMARY") + " - " + getMonthForInt(month - 1, langIndex) + ".txt");
			FileWriter savedF = new FileWriter(monthFile);
			String[] espSumm = {
					"COMPARACIÓN CON LOS AÑOS PASADOS:"
							+ (conLY4.size() == 0 ? ""
									: "\nEN " + (currentDate.y - 4)
											+ (total21[0] == 0 ? " NO ABRIMOS LA TIENDA!"
													: " VENDISTE EN TOTAL $" + total21[0] + " CON UN PROMEDIO DE $"
															+ avgM21))
							+ (conLY3.size() == 0 ? ""
									: "\nEN " + (currentDate.y - 3)
											+ (total22[0] == 0 ? " NO ABRIMOS LA TIENDA!"
													: " VENDISTE EN TOTAL $" + total22[0] + " CON UN PROMEDIO DE $"
															+ avgM22))
							+ (conLY2.size() == 0 ? ""
									: "\nEN " + (currentDate.y - 2)
											+ (total23[0] == 0 ? " NO ABRIMOS LA TIENDA!"
													: " VENDISTE EN TOTAL $" + total23[0] + " CON UN PROMEDIO DE $"
															+ avgM23))
							+ (conLY.size() == 0 ? ""
									: "\nEN " + (currentDate.y - 1)
											+ (total24[0] == 0 ? " NO ABRIMOS LA TIENDA!"
													: " VENDISTE EN TOTAL $" + total24[0] + " CON UN PROMEDIO DE $"
															+ avgM24))
							+ "\nESTE AÑO VENDISTE EN TOTAL $" + totalCY[0] + " CON UN PROMEDIO DE $" + avgM
							+ ((total21[0] == 0 && total22[0] == 0 && total23[0] == 0
									&& total24[0] == 0)
											? ""
											: "\nCORRESPONDIENTE A:"
													+ (total21[0] == 0 ? ""
															: "\n • $"
																	+ (avgM > avgM21
																			? avgM - avgM21 + " MÁS QUE "
																					+ (currentDate.y - 4) + " (%"
																					+ (avgM21 < 1 ? 100
																							: 100 * (avgM - avgM21)
																									/ avgM21)
																			: avgM21 - avgM + " MENOS QUE "
																					+ (currentDate.y - 4) + " (%"
																					+ (avgM21 == 0
																							? 0
																							: 100 * (avgM21 - avgM)
																									/ avgM21))
																	+ ")")
													+ (total22[0] == 0 ? ""
															: "\n • $"
																	+ (avgM > avgM22
																			? avgM - avgM22 + " MÁS QUE "
																					+ (currentDate.y - 3) + " (%"
																					+ (avgM22 < 1 ? 100
																							: 100 * (avgM - avgM22)
																									/ avgM22)
																			: avgM22 - avgM + " MENOS QUE "
																					+ (currentDate.y - 3) + " (%"
																					+ (avgM22 == 0 ? 0
																							: 100 * (avgM22 - avgM)
																									/ avgM22))
																	+ ")")
													+ (total23[0] == 0 ? ""
															: "\n • $"
																	+ (avgM > avgM23
																			? avgM - avgM23 + " MÁS QUE "
																					+ (currentDate.y - 2) + " (%"
																					+ (avgM23 < 1 ? 100
																							: 100 * (avgM - avgM23)
																									/ avgM23)
																			: avgM23 - avgM + " MENOS QUE "
																					+ (currentDate.y - 2) + " (%"
																					+ (avgM23 == 0
																							? 0
																							: 100 * (avgM23 - avgM)
																									/ avgM23))
																	+ ")")
													+ (total24[0] == 0 ? ""
															: "\n • $"
																	+ (avgM > avgM24
																			? avgM - avgM24 + " MÁS QUE "
																					+ (currentDate.y - 1) + " (%"
																					+ (avgM24 < 1 ? 100
																							: 100 * (avgM - avgM24)
																									/ avgM24)
																			: avgM24 - avgM + " MENOS QUE "
																					+ (currentDate.y - 1) + " (%"
																					+ (avgM24 == 0 ? 0
																							: 100 * (avgM24 - avgM)
																									/ avgM24))
																	+ ")")), // 0
					"EXTREMOS DEL MES:\n"
							+ (minCounter > 1
									? "LA PEOR VENTA POR DIA DE " + getMonthForInt(month - 1, 0) + " PASÓ " + minCounter
											+ " VECES Y ESO ES $" + min
									: "EL PEOR DÍA EN " + getMonthForInt(month - 1, 0) + " ES UN " + minDayString + " "
											+ minDIndex + "-" + month + ", LO QUE VENDIMOS $" + min)
							+ "\n"
							+ (maxCounter > 1
									? "LA MEJOR VENTA POR DIA DE " + getMonthForInt(month - 1, 0) + " PASÓ "
											+ maxCounter + " VECES Y ESO ES $" + max
									: "EL MEJOR DÍA EN " + getMonthForInt(month - 1, 0) + " ES UN " + maxDayString + " "
											+ maxDIndex + "-" + month + ", LO QUE VENDIMOS $" + max), // 1
					"LA MEDIA SEGÚN EL DÍA EN ESTE MES SON:\nLUNES -> $" + daysAvg[0] + " (%" + daysPerc[0]
							+ ")\nMARTES -> $" + daysAvg[1] + " (%" + daysPerc[1] + ")\nMIÉRCOLES -> $" + daysAvg[2]
							+ " (%" + daysPerc[2] + ")\nJUEVES -> $" + daysAvg[3] + " (%" + daysPerc[3]
							+ ")\nVIERNES -> $" + daysAvg[4] + " (%" + daysPerc[4] + ")\nSÁBADO -> $" + daysAvg[5]
							+ " (%" + daysPerc[5] + ")"
							+ (daysAvg[6] == 0 ? "" : "\nDOMINGO -> $" + daysAvg[6] + " (%" + daysPerc[6] + ")"), // 2DAVG
					"DIFERENCIA CON MESES ANTERIORES:\n" + avfOfMonths[0] + avfOfMonths[1] + avfOfMonths[2]
							+ avfOfMonths[3] + avfOfMonths[4] + avfOfMonths[5] + avfOfMonths[6] + avfOfMonths[7]
							+ avfOfMonths[8] + avfOfMonths[9] + avfOfMonths[10] + avfOfMonths[11]
							+ "SE PARECE QUE EN ESTE MES, VENDIMOS "
							+ (avgM <= Integer.valueOf(avfOfMonths[13]) ? "MENOS QUE TODOS LOS MESES ANTERIORES"
									: avgM >= Integer.valueOf(avfOfMonths[12]) ? "MÁS QUE TODOS LOS MESES ANTERIORES"
											: "MÁS QUE UNOS MESES Y MENOS QUE OTROS."), // 3
					"TOP VENTAS DEL MES POR CANTIDAD:\n" + top10S, //
					"TOP VENTAS DEL MES POR PRECIO:\n" + top10P, //
					"TOP VENDEDORES:\n" + " • TOTAL:\n" + sellerText + " • PROMEDIO:\n" + avgSeller
							+ " • DÍAS CON MAYORES VENTAS POR VENDEDOR:\n" + rankSeller, //
					"GRACIAS Y HASTA MAÑANA :)", // 4
			};
			String[] porSumm = {
					"COMPARAÇÃO COM OS ANOS PASSADOS:"
							+ (conLY4.size() == 0 ? ""
									: "\nEM " + (currentDate.y - 4)
											+ (total21[0] == 0 ? " NÃO ABRIMOS A LOJA!"
													: " VOCÊ VENDEU NO TOTAL $" + total21[0] + " COM MÉDIA DO $"
															+ avgM21))
							+ (conLY3.size() == 0 ? ""
									: "\nEM " + (currentDate.y - 3)
											+ (total22[0] == 0 ? " NÃO ABRIMOS A LOJA!"
													: " VOCÊ VENDEU NO TOTAL $" + total22[0] + " COM MÉDIA DO $"
															+ avgM22))
							+ (conLY2.size() == 0 ? ""
									: "\nEM " + (currentDate.y - 2)
											+ (total23[0] == 0 ? " NÃO ABRIMOS A LOJA!"
													: " VOCÊ VENDEU NO TOTAL $" + total23[0] + " COM MÉDIA DO $"
															+ avgM23))
							+ (conLY.size() == 0 ? ""
									: "\nEM " + (currentDate.y - 1)
											+ (total24[0] == 0 ? " NÃO ABRIMOS A LOJA!"
													: " VOCÊ VENDEU NO TOTAL $" + total24[0] + " COM MÉDIA DO $"
															+ avgM24))
							+ "\nNESSE ANO VOCÊ VENDEU NO TOTAL $" + totalCY[0] + " COM MÉDIA DO $" + avgM
							+ ((total21[0] == 0 && total22[0] == 0 && total23[0] == 0
									&& total24[0] == 0)
											? ""
											: "\nCORRESPONDIENTE A:"
													+ (total21[0] == 0 ? ""
															: "\n • $"
																	+ (avgM > avgM21
																			? avgM - avgM21 + " MAIS QUE "
																					+ (currentDate.y - 4) + " (%"
																					+ (avgM21 < 1 ? 100
																							: 100 * (avgM - avgM21)
																									/ avgM21)
																			: avgM21 - avgM + " MENOS QUE "
																					+ (currentDate.y - 4) + " (%"
																					+ (avgM21 == 0
																							? 0
																							: 100 * (avgM21 - avgM)
																									/ avgM21))
																	+ ")")
													+ (total22[0] == 0 ? ""
															: "\n • $"
																	+ (avgM > avgM22
																			? avgM - avgM22 + " MAIS QUE "
																					+ (currentDate.y - 3) + " (%"
																					+ (avgM22 < 1 ? 100
																							: 100 * (avgM - avgM22)
																									/ avgM22)
																			: avgM22 - avgM + " MENOS QUE "
																					+ (currentDate.y - 3) + " (%"
																					+ (avgM22 == 0 ? 0
																							: 100 * (avgM22 - avgM)
																									/ avgM22))
																	+ ")")
													+ (total23[0] == 0 ? ""
															: "\n • $"
																	+ (avgM > avgM23
																			? avgM - avgM23 + " MAIS QUE "
																					+ (currentDate.y - 2) + " (%"
																					+ (avgM23 < 1 ? 100
																							: 100 * (avgM - avgM23)
																									/ avgM23)
																			: avgM23 - avgM + " MENOS QUE "
																					+ (currentDate.y - 2) + " (%"
																					+ (avgM23 == 0
																							? 0
																							: 100 * (avgM23 - avgM)
																									/ avgM23))
																	+ ")")
													+ (total24[0] == 0 ? ""
															: "\n • $"
																	+ (avgM > avgM24
																			? avgM - avgM24 + " MAIS QUE "
																					+ (currentDate.y - 1) + " (%"
																					+ (avgM24 < 1 ? 100
																							: 100 * (avgM - avgM24)
																									/ avgM24)
																			: avgM24 - avgM + " MENOS QUE "
																					+ (currentDate.y - 1) + " (%"
																					+ (avgM24 == 0 ? 0
																							: 100 * (avgM24 - avgM)
																									/ avgM24))
																	+ ")")), // 0
					"EXTREMOS DO MÊS:\n"
							+ (minCounter > 1
									? "A PIOR VENDA POR DIA DE " + getMonthForInt(month - 1, 1) + " PASSOU "
											+ minCounter + " TEMPOS E ISSO É $" + min
									: "O PIOR DIA EM " + getMonthForInt(month - 1, 1) + " É UM " + minDayString + " "
											+ minDIndex + "-" + month + ", O QUE VENDEMOS $" + min)
							+ "\n"
							+ (maxCounter > 1
									? "A MELHOR VENDA POR DIA DE " + getMonthForInt(month - 1, 1) + " PASSOU "
											+ maxCounter + " TEMPOS E ISSO É $" + max
									: "O MELHOR DIA EM " + getMonthForInt(month - 1, 1) + " É UM " + maxDayString + " "
											+ maxDIndex + "-" + month + ", O QUE VENDEMOS $" + max), // 1
					"A MÉDIA DE ACORDO COM O DIA EM ESTE MES SÃO:\nSEGUNDA-FEIRA -> $" + daysAvg[0] + " (%"
							+ daysPerc[0] + ")\nTERÇA-FEIRA -> $" + daysAvg[1] + " (%" + daysPerc[1]
							+ ")\nQUARTA-FEIRA -> $" + daysAvg[2] + " (%" + daysPerc[2] + ")\nQUINTA-FEIRA -> $"
							+ daysAvg[3] + " (%" + daysPerc[3] + ")\nSEXTA-FEIRA -> $" + daysAvg[4] + " (%"
							+ daysPerc[4] + ")\nSÁBADO -> $" + daysAvg[5] + " (%" + daysPerc[5] + ")"
							+ (daysAvg[6] == 0 ? "" : "\nDOMINGO -> $" + daysAvg[6] + " (%" + daysPerc[6] + ")"), // 5
					"DIFERENÇA DOS MESES ANTERIORES:\n" + avfOfMonths[0] + avfOfMonths[1] + avfOfMonths[2]
							+ avfOfMonths[3] + avfOfMonths[4] + avfOfMonths[5] + avfOfMonths[6] + avfOfMonths[7]
							+ avfOfMonths[8] + avfOfMonths[9] + avfOfMonths[10] + avfOfMonths[11]
							+ "PARECE QUE EM NESSE MÊS, VENDEMOS "
							+ (avgM <= Integer.valueOf(avfOfMonths[13]) ? "MENOS DO QUE TODOS OS MESES ANTERIORES"
									: avgM >= Integer.valueOf(avfOfMonths[12]) ? "MAIS DO QUE TODOS OS MESES ANTERIORES"
											: "MAIS QUE ALGUNS MESES E MENOS QUE OUTROS"), // 3
					"MAIS VENDIDOS DO MÊS POR QUANTIDADE:\n" + top10S, //
					"MAIS VENDIDOS DO MÊS POR PREÇO:\n" + top10P, //
					"TOP VENDEDORES:\n" + " • TOTAL:\n" + sellerText + " • MEDIA:\n" + avgSeller
							+ " • DIAS COM MAIORES VENDAS POR VENDEDOR:\n" + rankSeller, //
					"OBRIGADO E ATÉ AMANHÃ :)"// 2
			};
			String[] engSumm = {
					"COMPARISON WITH LAST YEARS:"
							+ (conLY4.size() == 0 ? ""
									: "\nIN " + (currentDate.y - 4)
											+ (total21[0] == 0 ? " WE DO NOT OPEN THE STORE!"
													: " YOU SOLD IN TOTAL $" + total21[0] + " WITH AN AVERAGE OF $"
															+ avgM21))
							+ (conLY3.size() == 0 ? ""
									: "\nIN " + (currentDate.y - 3)
											+ (total22[0] == 0 ? " WE DO NOT OPEN THE STORE!"
													: " YOU SOLD IN TOTAL $" + total22[0] + " WITH AN AVERAGE OF $"
															+ avgM22))
							+ (conLY2.size() == 0 ? ""
									: "\nIN " + (currentDate.y - 2)
											+ (total23[0] == 0 ? " WE DO NOT OPEN THE STORE!"
													: " YOU SOLD IN TOTAL $" + total23[0] + " WITH AN AVERAGE OF $"
															+ avgM23))
							+ (conLY.size() == 0 ? ""
									: "\nIN " + (currentDate.y - 1)
											+ (total24[0] == 0 ? " WE DO NOT OPEN THE STORE!"
													: " YOU SOLD IN TOTAL $" + total24[0] + " WITH AN AVERAGE OF $"
															+ avgM24))
							+ "\nTHIS YEAR YOU SOLD IN TOTAL $" + totalCY[0] + " WITH AN AVERAGE OF $" + avgM
							+ ((total21[0] == 0 && total22[0] == 0 && total23[0] == 0
									&& total24[0] == 0)
											? ""
											: "\nCORRESPONDING TO:"
													+ (total21[0] == 0 ? ""
															: "\n • $"
																	+ (avgM > avgM21
																			? avgM - avgM21 + " MORE THAN "
																					+ (currentDate.y - 4) + " (%"
																					+ (avgM21 < 1
																							? 100
																							: 100 * (avgM - avgM21)
																									/ avgM21)
																			: avgM21 - avgM + " LESS THAN "
																					+ (currentDate.y - 4) + " (%"
																					+ (avgM21 == 0
																							? 0
																							: 100 * (avgM21 - avgM)
																									/ avgM21))
																	+ ")")
													+ (total22[0] == 0 ? ""
															: "\n • $"
																	+ (avgM > avgM22 ? avgM - avgM22 + " MORE THAN "
																			+ (currentDate.y - 3) + " (%" + (avgM22 < 1
																					? 100
																					: 100 * (avgM - avgM22) / avgM22)
																			: avgM22 - avgM + " LESS THAN "
																					+ (currentDate.y - 3) + " (%"
																					+ (avgM22 == 0 ? 0
																							: 100 * (avgM22 - avgM)
																									/ avgM22))
																	+ ")")
													+ (total23[0] == 0 ? ""
															: "\n • $" + (avgM > avgM23 ? avgM - avgM23 + " MORE THAN "
																	+ (currentDate.y - 2) + " (%" + (avgM23 < 1 ? 100
																			: 100 * (avgM - avgM23) / avgM23)
																	: avgM23 - avgM + " LESS THAN "
																			+ (currentDate.y - 2) + " (%"
																			+ (avgM23 == 0 ? 0
																					: 100 * (avgM23 - avgM) / avgM23))
																	+ ")")
													+ (total24[0] == 0 ? ""
															: "\n • $"
																	+ (avgM > avgM24
																			? avgM - avgM24 + " MORE THAN "
																					+ (currentDate.y - 1) + " (%"
																					+ (avgM24 < 1 ? 100
																							: 100 * (avgM - avgM24)
																									/ avgM24)
																			: avgM24 - avgM + " LESS THAN "
																					+ (currentDate.y - 1) + " (%"
																					+ (avgM24 == 0 ? 0
																							: 100 * (avgM24 - avgM)
																									/ avgM24))
																	+ ")")), // 0
					"EXTREMES OF THE MONTH:\n"
							+ (minCounter > 1
									? "THE WORST SALE PER DAY OF " + getMonthForInt(month - 1, 2) + " HAPPENED "
											+ minCounter + " TIMES AND IT'S $" + min
									: "THE WORST DAY IN " + getMonthForInt(month - 1, 2) + " IT'S A " + minDayString
											+ " " + minDIndex + "-" + month + ", WHAT WE SOLD $" + min)
							+ "\n"
							+ (maxCounter > 1
									? "THE BEST SALE PER DAY OF " + getMonthForInt(month - 1, 2) + " HAPPENED "
											+ maxCounter + " TIMES AND IT'S $" + max
									: "THE BEST DAY IN " + getMonthForInt(month - 1, 2) + " IT'S A " + maxDayString
											+ " " + maxDIndex + "-" + month + ", WHAT WE SOLD $" + max), // 1
					"THE AVERAGE ACCORDING TO THE DAY IN THIS MONTH ARE:\nMONDAY -> $" + daysAvg[0] + " (%"
							+ daysPerc[0] + ")\nTUESDAY -> $" + daysAvg[1] + " (%" + daysPerc[1] + ")\nWEDNESDAY -> $"
							+ daysAvg[2] + " (%" + daysPerc[2] + ")\nTHURSDAY -> $" + daysAvg[3] + " (%" + daysPerc[3]
							+ ")\nFRIDAY -> $" + daysAvg[4] + " (%" + daysPerc[4] + ")\nSATURDAY -> $" + daysAvg[5]
							+ " (%" + daysPerc[5] + ")"
							+ (daysAvg[6] == 0 ? "" : "\nSUNDAY -> $" + daysAvg[6] + " (%" + daysPerc[6] + ")"), // 5
					"DIFFERENCE FROM PREVIOUS MONTHS:\n" + avfOfMonths[0] + avfOfMonths[1] + avfOfMonths[2]
							+ avfOfMonths[3] + avfOfMonths[4] + avfOfMonths[5] + avfOfMonths[6] + avfOfMonths[7]
							+ avfOfMonths[8] + avfOfMonths[9] + avfOfMonths[10] + avfOfMonths[11]
							+ "IT SEEMS THAT IN THIS MONTH, WE SOLD "
							+ (avgM <= Integer.valueOf(avfOfMonths[13]) ? "LESS THAN ALL PREVIOUS MONTHS"
									: avgM > Integer.valueOf(avfOfMonths[12]) ? "MORE THAN ALL PREVIOUS MONTHS"
											: "MORE THAN SOME MONTHS AND LESS THAN OTHERS"), // 3
					"TOP SELL OF MONTH BY QUANTITY:\n" + top10S, //
					"TOP SELL OF MONTH BY PRICE:\n" + top10P, //
					"TOP SELLERS:\n" + " • TOTAL:\n" + sellerText + " • AVERAGE:\n" + avgSeller
							+ " • DAYS WITH HIGHEST SALES BY SELLER:\n" + rankSeller, //
					"THANKS AND SEE YOU TOMORROW :)" // 4
			};
			String[] frSumm = {
					"COMPARAISON ENTRE LES ANNÉES PASSÉES:"
							+ (conLY4.size() == 0 ? ""
									: "\nEN " + (currentDate.y - 4)
											+ (total21[0] == 0 ? " NOUS N'OUVRONS PAS LE MAGASIN!"
													: " VOUS AVEZ VENDU AU TOTAL $" + total21[0]
															+ " AVEC UNE MOYENNE DE $" + avgM21))
							+ (conLY3.size() == 0 ? ""
									: "\nEN " + (currentDate.y - 3)
											+ (total22[0] == 0 ? " NOUS N'OUVRONS PAS LE MAGASIN!"
													: " VOUS AVEZ VENDU AU TOTAL $" + total22[0]
															+ " AVEC UNE MOYENNE DE $" + avgM22))
							+ (conLY2.size() == 0 ? ""
									: "\nEN " + (currentDate.y - 1)
											+ (total23[0] == 0 ? " NOUS N'OUVRONS PAS LE MAGASIN!"
													: " VOUS AVEZ VENDU AU TOTAL $" + total23[0]
															+ " AVEC UNE MOYENNE DE $" + avgM23))
							+ (conLY.size() == 0 ? ""
									: "\nEN " + (currentDate.y - 1)
											+ (total24[0] == 0 ? " NOUS N'OUVRONS PAS LE MAGASIN!"
													: " VOUS AVEZ VENDU AU TOTAL $" + total24[0]
															+ " AVEC UNE MOYENNE DE $" + avgM24))
							+ "\nCETTE ANNÉE, VOUS AVEZ VENDU AU TOTAL $" + totalCY[0] + " AVEC UNE MOYENNE DE $" + avgM
							+ ((total21[0] == 0 && total22[0] == 0 && total23[0] == 0 && total24[0] == 0) ? ""
									: "\nCORRESPOND À:"
											+ (total21[0] == 0 ? ""
													: "\n • $"
															+ (avgM > avgM21
																	? avgM - avgM21 + " PLUS QUE " + (currentDate.y - 4)
																			+ " (%"
																			+ (avgM21 < 1 ? 100
																					: 100 * (avgM - avgM21) / avgM21)
																	: avgM21 - avgM + " MOINS QUE "
																			+ (currentDate.y - 4) + " (%"
																			+ (avgM21 == 0 ? 0
																					: 100 * (avgM21 - avgM) / avgM21))
															+ ")")
											+ (total22[0] == 0 ? ""
													: "\n • $" + (avgM > avgM22 ? avgM - avgM22 + " PLUS QUE "
															+ (currentDate.y - 3) + " (%" + (avgM22 < 1 ? 100
																	: 100 * (avgM - avgM22) / avgM22)
															: avgM22 - avgM + " MOINS QUE " + (currentDate.y - 3)
																	+ " (%" + (avgM22 == 0 ? 0
																			: 100 * (avgM22 - avgM) / avgM22))
															+ ")")
											+ (total23[0] == 0 ? ""
													: "\n • $" + (avgM > avgM23
															? avgM - avgM23 + " PLUS QUE " + (currentDate.y - 2) + " (%"
																	+ (avgM23 < 1 ? 100
																			: 100 * (avgM - avgM23) / avgM23)
															: avgM23 - avgM + " MOINS QUE " + (currentDate.y - 2)
																	+ " (%" + (avgM23 == 0 ? 0
																			: 100 * (avgM23 - avgM) / avgM23))
															+ ")")
											+ (total24[0] == 0 ? ""
													: "\n • $"
															+ (avgM > avgM24
																	? avgM - avgM24 + " PLUS QUE " + (currentDate.y - 1)
																			+ " (%"
																			+ (avgM24 < 1 ? 100
																					: 100 * (avgM - avgM24) / avgM24)
																	: avgM24 - avgM + " MOINS QUE "
																			+ (currentDate.y - 1) + " (%"
																			+ (avgM24 == 0 ? 0
																					: 100 * (avgM24 - avgM) / avgM24))
															+ ")")), // 0
					"EXTREMES DU MOIS :\n"
							+ (minCounter > 1
									? "LA PIRE VENTE PAR JOUR DE " + getMonthForInt(month - 1, 3) + " ARRIVÉE "
											+ minCounter + " TEMPS ET C'EST $" + min
									: "LE PIRE JOUR EN " + getMonthForInt(month - 1, 3) + " C'EST UN " + minDayString
											+ " " + minDIndex + "-" + month + ", CE QUE NOUS AVONS VENDU $" + min)
							+ "\n"
							+ (maxCounter > 1
									? "LA MEILLEURE VENTE PAR JOUR DE " + getMonthForInt(month - 1, 3) + " ARRIVÉE "
											+ maxCounter + " TEMPS ET C'EST $" + max
									: "LE MEILLEUR JOUR EN " + getMonthForInt(month - 1, 3) + " C'EST UN "
											+ maxDayString + " " + maxDIndex + "-" + month
											+ ", CE QUE NOUS AVONS VENDU $" + max), // 1
					"LA MOYENNE SELON LE JOUR DE CE MOIS EST :\nLUNDI -> $" + daysAvg[0] + " (%" + daysPerc[0]
							+ ")\nMARDI -> $" + daysAvg[1] + " (%" + daysPerc[1] + ")\nMERCREDI -> $" + daysAvg[2]
							+ " (%" + daysPerc[2] + ")\nJEUDI -> $" + daysAvg[3] + " (%" + daysPerc[3]
							+ ")\nVENDREDI -> $" + daysAvg[4] + " (%" + daysPerc[4] + ")\nSAMEDI -> $" + daysAvg[5]
							+ " (%" + daysPerc[5] + ")"
							+ (daysAvg[6] == 0 ? "" : "\nDIMANCHE -> $" + daysAvg[6] + " (%" + daysPerc[6] + ")"), // 2
					"DIFFÉRENCE AVEC LES MOIS PRÉCÉDENTS :\n" + avfOfMonths[0] + avfOfMonths[1] + avfOfMonths[2]
							+ avfOfMonths[3] + avfOfMonths[4] + avfOfMonths[5] + avfOfMonths[6] + avfOfMonths[7]
							+ avfOfMonths[8] + avfOfMonths[9] + avfOfMonths[10] + avfOfMonths[11]
							+ "IL SEMBLE QUE CE MOIS, NOUS AVONS VENDU "
							+ (avgM <= Integer.valueOf(avfOfMonths[13]) ? "MOINS QUE TOUS LES MOIS PRÉCÉDENTS"
									: avgM > Integer.valueOf(avfOfMonths[12]) ? "PLUS QUE TOUS LES MOIS PRÉCÉDENTS"
											: "PLUS QUE CERTAINS MOIS ET MOINS QUE D'AUTRES"), // 3
					"MEILLEURE VENTE DU MOIS PAR QUANTITÉ:\n" + top10S, // 4
					"MEILLEURE VENTE DU MOIS PAR PRIX:\n" + top10P, // 5
					"MEILLEURS VENDEURES:\n" + " • TOTAL:\n" + sellerText + " • MOYENNE:\n" + avgSeller
							+ " • JOURS AVEC LES PLUS GRANDES VENTES PAR VENDEUR:\n" + rankSeller, //
					"MERCI ET A DEMAIN :)" // 7
			};
			savedF.write("HADI-TECH" + (language == Language.SPANISH ? (" - RESUMEN DE " + getMonthForInt(month - 1, 0))
					: language == Language.PORTUGUES ? (" - RESUMO DE " + getMonthForInt(month - 1, 1))
							: language == Language.ENGLISH ? (" - SUMMARY OF " + getMonthForInt(month - 1, 2))
									: (" - RÉSUMÉ DE ") + getMonthForInt(month - 1, 3)));
			if (conLY.size() == 0 && conLY2.size() == 0 && conLY3.size() == 0 && conLY4.size() == 0) {
				savedF.write("\n\nI. " + (language == Language.SPANISH ? espSumm[1]
						: language == Language.PORTUGUES ? porSumm[1]
								: language == Language.ENGLISH ? engSumm[1] : frSumm[1]));
				savedF.write("\n\nII. " + (language == Language.SPANISH ? espSumm[2]
						: language == Language.PORTUGUES ? porSumm[2]
								: language == Language.ENGLISH ? engSumm[2] : frSumm[2]));
				if (month > 1) {
					savedF.write("\n\nIII. " + (language == Language.SPANISH ? espSumm[3]
							: language == Language.PORTUGUES ? porSumm[3]
									: language == Language.ENGLISH ? engSumm[3] : frSumm[3]));
					if (top10.size() > 0) {
						savedF.write("\n\nIV. " + (language == Language.SPANISH ? espSumm[4]
								: language == Language.PORTUGUES ? porSumm[4]
										: language == Language.ENGLISH ? engSumm[4] : frSumm[4]));
						savedF.write("\nV. " + (language == Language.SPANISH ? espSumm[5]
								: language == Language.PORTUGUES ? porSumm[5]
										: language == Language.ENGLISH ? engSumm[5] : frSumm[5]));
					}
					if (sortedMap.size() > 0)
						savedF.write("\nVI. " + (language == Language.SPANISH ? espSumm[6]
								: language == Language.PORTUGUES ? porSumm[6]
										: language == Language.ENGLISH ? engSumm[6] : frSumm[6]));
				} else {
					if (top10.size() > 0) {
						savedF.write("\n\nIII. " + (language == Language.SPANISH ? espSumm[4]
								: language == Language.PORTUGUES ? porSumm[4]
										: language == Language.ENGLISH ? engSumm[4] : frSumm[4]));
						savedF.write("\nIV. " + (language == Language.SPANISH ? espSumm[5]
								: language == Language.PORTUGUES ? porSumm[5]
										: language == Language.ENGLISH ? engSumm[5] : frSumm[5]));
					}
					if (sortedMap.size() > 0)
						savedF.write("\n\nV. " + (language == Language.SPANISH ? espSumm[6]
								: language == Language.PORTUGUES ? porSumm[6]
										: language == Language.ENGLISH ? engSumm[6] : frSumm[6]));
				}
			} else {
				savedF.write("\n\nI. " + (language == Language.SPANISH ? espSumm[0]
						: language == Language.PORTUGUES ? porSumm[0]
								: language == Language.ENGLISH ? engSumm[0] : frSumm[0]));
				savedF.write("\n\nII. " + (language == Language.SPANISH ? espSumm[1]
						: language == Language.PORTUGUES ? porSumm[1]
								: language == Language.ENGLISH ? engSumm[1] : frSumm[1]));
				savedF.write("\n\nIII. " + (language == Language.SPANISH ? espSumm[2]
						: language == Language.PORTUGUES ? porSumm[2]
								: language == Language.ENGLISH ? engSumm[2] : frSumm[2]));
				if (month > 1) {
					savedF.write("\n\nIV. " + (language == Language.SPANISH ? espSumm[3]
							: language == Language.PORTUGUES ? porSumm[3]
									: language == Language.ENGLISH ? engSumm[3] : frSumm[3]));
					if (top10.size() > 0) {
						savedF.write("\n\nV. " + (language == Language.SPANISH ? espSumm[4]
								: language == Language.PORTUGUES ? porSumm[4]
										: language == Language.ENGLISH ? engSumm[4] : frSumm[4]));
						savedF.write("\nVI. " + (language == Language.SPANISH ? espSumm[5]
								: language == Language.PORTUGUES ? porSumm[5]
										: language == Language.ENGLISH ? engSumm[5] : frSumm[5]));
					}
					if (sortedMap.size() > 0)
						savedF.write("\n\nVII. " + (language == Language.SPANISH ? espSumm[6]
								: language == Language.PORTUGUES ? porSumm[6]
										: language == Language.ENGLISH ? engSumm[6] : frSumm[6]));
				} else {
					if (top10.size() > 0) {
						savedF.write("\n\nIV. " + (language == Language.SPANISH ? espSumm[4]
								: language == Language.PORTUGUES ? porSumm[4]
										: language == Language.ENGLISH ? engSumm[4] : frSumm[4]));
						savedF.write("\nV. " + (language == Language.SPANISH ? espSumm[5]
								: language == Language.PORTUGUES ? porSumm[5]
										: language == Language.ENGLISH ? engSumm[5] : frSumm[5]));
					}
					if (sortedMap.size() > 0)
						savedF.write("\n\nVII. " + (language == Language.SPANISH ? espSumm[6]
								: language == Language.PORTUGUES ? porSumm[6]
										: language == Language.ENGLISH ? engSumm[6] : frSumm[6]));
				}
			}
			savedF.write("\n" + (language == Language.SPANISH ? espSumm[7]
					: language == Language.PORTUGUES ? porSumm[7]
							: language == Language.ENGLISH ? engSumm[7] : frSumm[7]));
			savedF.close();
			// save month graph
			File imgFolder = new File(monthFolder + "\\IMG");
			imgFolder.mkdir();
			File merchFolder = new File(imgFolder + "\\STOCK");
			merchFolder.mkdir();
			File empFolder = new File(imgFolder, "\\" + getLocalizedMessage("EMPLOYEE"));
			empFolder.mkdir();
			File chartFile = new File(imgFolder, getLocalizedMessage("GRAPH") + " - " + getLocalizedMessage("SELL")
					+ " " + getLocalizedMessage("OF") + " " + getMonthForInt(month - 1, langIndex) + ".PNG");
			saveGraph(monthChart(month), chartFile);
			if (conf[21] == null || conf[21].equalsIgnoreCase("null") || conf[21].equals("false")) {
				/* Save top 10 merchandise as png */
				File qtyStock = new File(merchFolder,
						getLocalizedMessage("TOP_ITEMS") + "-" + getLocalizedMessage("GRAPH") + " "
								+ getLocalizedMessage("OF") + " " + getLocalizedMessage("QUANTITY") + ".png");
				File priceStock = new File(merchFolder,
						getLocalizedMessage("TOP_ITEMS") + "-" + getLocalizedMessage("GRAPH") + " "
								+ getLocalizedMessage("OF") + " " + getLocalizedMessage("PRICE") + ".png");
				File sellersGraph = new File(empFolder,
						getLocalizedMessage("EMPLOYEE") + " - " + getLocalizedMessage("GRAPH") + " "
								+ getLocalizedMessage("OF") + " " + getLocalizedMessage("SELL") + ".png");
				File sellersDiag = new File(empFolder,
						getLocalizedMessage("EMPLOYEE") + " - " + getLocalizedMessage("DIAGRAM") + " "
								+ getLocalizedMessage("OF") + " " + getLocalizedMessage("SELL") + " (TOTAL).png");
				File sellersDiagAvg = new File(empFolder,
						getLocalizedMessage("EMPLOYEE") + " - " + getLocalizedMessage("DIAGRAM") + " "
								+ getLocalizedMessage("OF") + " " + getLocalizedMessage("SELL") + " ("
								+ getLocalizedMessage("AVERAGE") + ").png");
				saveGraph(topMerchChart(getLocalizedMessage("QUANTITY"), month), qtyStock);
				saveGraph(topMerchChart(getLocalizedMessage("PRICE"), month), priceStock);
				saveGraph(sellersChart(month, currentDate.y), sellersGraph);
				saveGraph(sellersDiag(month, currentDate.y, "TOTAL"), sellersDiag);
				saveGraph(sellersDiag(month, currentDate.y, "AVG"), sellersDiagAvg);
				exEmpSum(month, currentDate.y, empFolder);
			}
			if (conf[18].equals("false")) {
				File logFolder = new File(dataFolder + "\\LOG");
				logFolder.mkdir();
				if (deleteFolder(logFolder)) {
					Toast.show(this, Toast.Type.SUCCESS, getLocalizedMessage("CLEAN_S"), Intro.notOption);
				} else {
					Toast.show(this, Toast.Type.ERROR, getLocalizedMessage("CLEAN_U"));
				}
			}
			Toast.show(this, Toast.Type.SUCCESS, getLocalizedMessage("MONTH_E"), Intro.notOption);
		} catch (Exception e2) {
			writeError(e2);
		}
	}

	/* Export the year overview */
	private void exYearFrame() {
		dailyAvg = DataCalc.dailyAvg();
		monthlyAvg = DataCalc.totalOfMes(currentDate.m, currentDate.y)[1] == 0 ? 0
				: DataCalc.totalOfMes(currentDate.m, currentDate.y)[0]
						/ DataCalc.totalOfMes(currentDate.m, currentDate.y)[1];
		int temp[] = DataCalc.yearMaxMin(currentDate.y);
		int maxDIndex = currentDate.dayFromIndex(temp[2]);
		String maxDayString = dayName(new DateModified(maxDIndex, DataCalc.monthFromIndex(temp[2]), currentDate.y),
				langIndex);
		int minDIndex = currentDate.dayFromIndex(temp[3]);
		String minDayString = dayName(new DateModified(minDIndex, DataCalc.monthFromIndex(temp[3]), currentDate.y),
				langIndex);
		String[] avgOfMonths = DataCalc.monthsText(Integer.valueOf(currentDate.m), currentDate.y, langIndex);
		int daysAvg[] = new int[7];
		double daysPerc[] = new double[7];
		int minmaxV[][] = new int[7][2];
		// Min and max according the day
		minmaxV[0] = DataCalc.maxAccDay("monday", currentDate.y);
		minmaxV[1] = DataCalc.maxAccDay("tuesday", currentDate.y);
		minmaxV[2] = DataCalc.maxAccDay("wednesday", currentDate.y);
		minmaxV[3] = DataCalc.maxAccDay("thursday", currentDate.y);
		minmaxV[4] = DataCalc.maxAccDay("friday", currentDate.y);
		minmaxV[5] = DataCalc.maxAccDay("saturday", currentDate.y);
		minmaxV[6] = DataCalc.maxAccDay("sunday", currentDate.y);
		// days avg
		daysAvg[0] = DataCalc.avgSpeDay("monday", currentDate.y);
		daysAvg[1] = DataCalc.avgSpeDay("tuesday", currentDate.y);
		daysAvg[2] = DataCalc.avgSpeDay("wednesday", currentDate.y);
		daysAvg[3] = DataCalc.avgSpeDay("thursday", currentDate.y);
		daysAvg[4] = DataCalc.avgSpeDay("friday", currentDate.y);
		daysAvg[5] = DataCalc.avgSpeDay("saturday", currentDate.y);
		daysAvg[6] = DataCalc.avgSpeDay("sunday", currentDate.y);
		for (int i = 0; i < 7; i++) {
			daysPerc[i] = (double) daysAvg[i] * 100
					/ (daysAvg[0] + daysAvg[1] + daysAvg[2] + daysAvg[3] + daysAvg[4] + daysAvg[5] + daysAvg[6]);
			daysPerc[i] = Math.round(daysPerc[i] * 100);
			daysPerc[i] = daysPerc[i] / 100;
		}
		/* Max and Min Counter */
		int maxCounter = temp[4];
		int minCounter = temp[5];
		// top 10 merchandise sell
		List<Map.Entry<String, Integer>> top10 = getTop10MonthlySales(currentDate.y, -1);
		List<Map.Entry<String, Double>> top10Price = getTop10MonthlyPrice(currentDate.y, -1);
		String top10S = "", top10P = "";
		int rank = 1;
		for (int i = 0; i < top10.size(); i++) {
			if (i > 0 && i < top10.size())
				if (top10.get(i).getValue() == top10.get(i - 1).getValue()) {
					top10S += " " + --rank + "- " + top10.get(i).getKey() + " -> " + top10.get(i).getValue() + "\n";
				} else {
					top10S += " " + (i + 1) + "- " + top10.get(i).getKey() + " -> " + top10.get(i).getValue() + "\n";
					rank = i + 1;
				}
			else
				top10S += " " + rank + "- " + top10.get(i).getKey() + " -> " + top10.get(i).getValue() + "\n";
			rank++;
		}
		rank = 1;
		for (int i = 0; i < top10Price.size(); i++) {
			if (i > 0 && i < top10Price.size()) {
				if (top10Price.get(i).getValue().equals(top10Price.get(i - 1).getValue())) {
					top10P += " " + --rank + "- " + top10Price.get(i).getKey() + " -> $" + top10Price.get(i).getValue()
							+ "\n";
				} else {
					top10P += " " + (i + 1) + "- " + top10Price.get(i).getKey() + " -> $" + top10Price.get(i).getValue()
							+ "\n";
					rank = i + 1;
				}
			} else
				top10P += " " + rank + "- " + top10Price.get(i).getKey() + " -> $" + top10Price.get(i).getValue()
						+ "\n";
			rank++;
		}
		// seller sales of this year
		String sellerText = "", avgSeller = "", rankD = "", rankM = "";
		rank = 1;
		Map<String, Integer> sortedMap = new HashMap<String, Integer>(), avgMap = new HashMap<String, Integer>(),
				IntroRankMap = new HashMap<String, Integer>(), IntroRankMonth = new HashMap<String, Integer>();
		for (int i = 0; i < employee.size(); i++) {
			String name = employee.get(i).getName();
			int totalMonth = getSalesOfMonthYear(name, -1, currentDate.y), avgMonth = avgSales(name, -1, currentDate.y),
					IntroRank = findIntroRankDays(name, -1, currentDate.y),
					IntroRankM = findIntroRankMonth(name, currentDate.y);
			if (totalMonth > 0) {
				sortedMap.put(name, totalMonth);
				avgMap.put(name, avgMonth);
				IntroRankMap.put(name, IntroRank);
				IntroRankMonth.put(name, IntroRankM);
			}
		}
		sortedMap = sortedMap.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
				.collect(LinkedHashMap::new, (map, entry) -> map.put(entry.getKey(), entry.getValue()), Map::putAll);
		avgMap = avgMap.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
				.collect(LinkedHashMap::new, (map, entry) -> map.put(entry.getKey(), entry.getValue()), Map::putAll);
		IntroRankMap = IntroRankMap.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
				.collect(LinkedHashMap::new, (map, entry) -> map.put(entry.getKey(), entry.getValue()), Map::putAll);
		IntroRankMonth = IntroRankMonth.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
				.collect(LinkedHashMap::new, (map, entry) -> map.put(entry.getKey(), entry.getValue()), Map::putAll);
		int totalM = 0, avgSell = 0, rankValue = 0, rankMonth = 0;
		for (Map.Entry<String, Integer> entry : sortedMap.entrySet())
			totalM += entry.getValue();
		for (Map.Entry<String, Integer> entry : sortedMap.entrySet())
			sellerText += "  " + (rank++) + "- " + entry.getKey() + " -> $" + entry.getValue() + " ("
					+ (entry.getValue() * 100 / totalM) + "%)\n";
		rank = 1;
		for (Map.Entry<String, Integer> entry : avgMap.entrySet())
			avgSell += entry.getValue();
		for (Map.Entry<String, Integer> entry : avgMap.entrySet())
			avgSeller += "  " + (rank++) + "- " + entry.getKey() + " -> $" + entry.getValue()
					+ (avgSell == 0 ? "" : " (" + (entry.getValue() * 100 / avgSell) + "%)") + "\n";
		rank = 1;
		for (Map.Entry<String, Integer> entry : IntroRankMap.entrySet())
			rankValue += entry.getValue();
		for (Map.Entry<String, Integer> entry : IntroRankMap.entrySet())
			rankD += "  " + (rank++) + "- " + entry.getKey() + " -> " + entry.getValue()
					+ (langIndex == 0 ? " DÍAS" : langIndex == 1 ? " DIAS" : langIndex == 2 ? " DAYS" : " JOURS")
					+ (rankValue == 0 ? "" : " (" + (entry.getValue() * 100 / rankValue) + "%)") + "\n";
		rank = 1;
		for (Map.Entry<String, Integer> entry : IntroRankMonth.entrySet())
			rankMonth += entry.getValue();
		for (Map.Entry<String, Integer> entry : IntroRankMonth.entrySet())
			rankM += "  " + (rank++) + "- " + entry.getKey() + " -> " + entry.getValue()
					+ (langIndex == 0 ? " MESES" : langIndex == 1 ? " MESES" : langIndex == 2 ? " MONTHS" : " MOIS")
					+ (rankMonth == 0 ? "" : " (" + (entry.getValue() * 100 / rankMonth) + "%)") + "\n";
		try {
			dataFolder.mkdir();
			File yearFolder = new File(dataFolder + "\\" + yearS);
			yearFolder.mkdir();
			File yearFile = new File(yearFolder, getLocalizedMessage("SUMMARY") + " - " + yearS + ".txt");
			FileWriter savedF = new FileWriter(yearFile);
			String[] espSumm = {
					"COMPARACIÓN CON LOS AÑOS PASADOS:"
							+ (conLY4.size() == 0 ? ""
									: "\nEN " + (currentDate.y - 4) + ", VENDIMOS UN PROMEDIO DE $" + dailyAvgLY4)
							+ (conLY3.size() == 0 ? ""
									: "\nEN " + (currentDate.y - 3) + ", VENDIMOS UN PROMEDIO DE $" + dailyAvgLY3)
							+ (conLY2.size() == 0 ? ""
									: "\nEN " + (currentDate.y - 2) + ", VENDIMOS UN PROMEDIO DE $" + dailyAvgLY2)
							+ (conLY.size() == 0 ? ""
									: "\nEN " + (currentDate.y - 1) + ", VENDIMOS UN PROMEDIO DE $" + dailyAvgLY)
							+ "\nESTE AÑO, VENDIMOS UN PROMEDIO DE $" + dailyAvg + "\nCORRESPONDIENTE A:"
							+ (conLY.size() == 0 ? ""
									: "\n • $" + (dailyAvg > dailyAvgLY
											? dailyAvg - dailyAvgLY + " MÁS QUE " + (currentDate.y - 1) + " (%"
													+ 100 * (dailyAvg - dailyAvgLY) / dailyAvgLY
											: dailyAvgLY - dailyAvg + " MENOS QUE " + (currentDate.y - 1) + " (%"
													+ 100 * (dailyAvgLY - dailyAvg) / dailyAvgLY)
											+ ")")
							+ (conLY2.size() == 0 ? ""
									: "\n • $"
											+ (dailyAvg > dailyAvgLY2
													? dailyAvg - dailyAvgLY2 + " MÁS QUE " + (currentDate.y - 2) + " (%"
															+ 100 * (dailyAvg - dailyAvgLY2) / dailyAvgLY2
													: dailyAvgLY2 - dailyAvg + " MENOS QUE " + (currentDate.y - 2)
															+ " (%" + 100 * (dailyAvgLY2 - dailyAvg) / dailyAvgLY2)
											+ ")")
							+ (conLY3.size() == 0 ? ""
									: "\n • $" + (dailyAvg > dailyAvgLY3
											? dailyAvg - dailyAvgLY3 + " MÁS QUE " + (currentDate.y - 3) + " (%"
													+ 100 * (dailyAvg - dailyAvgLY3) / dailyAvgLY3
											: dailyAvgLY3 - dailyAvg + " MENOS QUE " + (currentDate.y - 3) + " (%"
													+ 100 * (dailyAvgLY3 - dailyAvg) / dailyAvgLY3)
											+ ")")
							+ (conLY4.size() == 0 ? ""
									: "\n • $"
											+ (dailyAvg > dailyAvgLY4
													? dailyAvg - dailyAvgLY4 + " MÁS QUE " + (currentDate.y - 4) + " (%"
															+ 100 * (dailyAvg - dailyAvgLY4) / dailyAvgLY4
													: dailyAvgLY4 - dailyAvg + " MENOS QUE " + (currentDate.y - 4)
															+ " (%" + 100 * (dailyAvgLY4 - dailyAvg) / dailyAvgLY4)
											+ ")"), // 0
					"EXTREMOS DEL AÑO:\n" + (maxCounter > 1
							? "LA MEJOR VENTA POR DIA DEL AÑO PASÓ " + maxCounter + " VECES Y ESO ES $" + temp[0]
							: "EL MEJOR DÍA DE ESTE AÑO ES " + maxDayString + " " + maxDIndex + "-"
									+ getMonthForInt(DataCalc.monthFromIndex(temp[2]) - 1, 0) + ", LO QUE VENDIMOS $"
									+ temp[0])
							+ "\n"
							+ (minCounter > 1
									? "LA PEOR VENTA POR DIA DEL AÑO PASÓ " + minCounter + " VECES Y ESO ES $" + temp[1]
									: "EL PEOR DÍA DE ESTE AÑO ES " + minDayString + " " + minDIndex + "-"
											+ getMonthForInt(DataCalc.monthFromIndex(temp[3]) - 1, 0)
											+ ", LO QUE VENDIMOS $" + temp[1]), // 1
					"DIFERENCIA CON MESES ANTERIORES:\n" + avgOfMonths[0] + avgOfMonths[1] + avgOfMonths[2]
							+ avgOfMonths[3] + avgOfMonths[4] + avgOfMonths[5] + avgOfMonths[6] + avgOfMonths[7]
							+ avgOfMonths[8] + avgOfMonths[9] + avgOfMonths[10] + avgOfMonths[11], // 3 months
					"EXTREMOS DEL MES:\nEL MEJOR MES DEL AÑO FUE " + getMonthForInt(Integer.valueOf(avgOfMonths[14]), 0)
							+ ", LO QUE VENDIMOS UN PROMEDIO DE $" + avgOfMonths[12] + "\nEL PEOR MES DEL AÑO FUE "
							+ getMonthForInt(Integer.valueOf(avgOfMonths[15]), 0) + ", LO QUE VENDIMOS UN PROMEDIO DE $"
							+ avgOfMonths[13], // 4 MAX AND MIN FOR THE MONTH
					"LA MEDIA SEGÚN EL DÍA SON:\nLUNES -> $" + daysAvg[0] + " (%" + daysPerc[0] + ")\nMARTES -> $"
							+ daysAvg[1] + " (%" + daysPerc[1] + ")\nMIÉRCOLES -> $" + daysAvg[2] + " (%" + daysPerc[2]
							+ ")\nJUEVES -> $" + daysAvg[3] + " (%" + daysPerc[3] + ")\nVIERNES -> $" + daysAvg[4]
							+ " (%" + daysPerc[4] + ")\nSÁBADO -> $" + daysAvg[5] + " (%" + daysPerc[5]
							+ ")\nDOMINGO -> $" + daysAvg[6] + " (%" + daysPerc[6] + ")", // 5
					"EL MÍNIMO Y MÁXIMO SEGÚN EL DÍA:\nLUNES -> MAX: $" + minmaxV[0][0] + ", MIN: $" + minmaxV[0][1]
							+ "\nMARTES -> MAX: $" + minmaxV[1][0] + ", MIN: $" + minmaxV[1][1]
							+ "\nMIÉRCOLES -> MAX: $" + minmaxV[2][0] + ", MIN: $" + minmaxV[2][1]
							+ "\nJUEVES -> MAX: $" + minmaxV[3][0] + ", MIN: $" + minmaxV[3][1] + "\nVIERNES -> MAX: $"
							+ minmaxV[4][0] + ", MIN: $" + minmaxV[4][1] + "\nSÁBADO -> MAX: $" + minmaxV[5][0]
							+ ", MIN: $" + minmaxV[5][1] + "\nDOMINGO -> MAX: $" + minmaxV[6][0] + ", MIN: $"
							+ minmaxV[6][1], // 6
					"TOP VENTAS DEL AÑO POR PRECIO:\n" + top10S, //
					"TOP VENTAS DEL AÑO POR PRECIO:\n" + top10P, //
					"TOP VENDEDORES:\n" + " • TOTAL:\n" + sellerText + " • PROMEDIO:\n" + avgSeller
							+ " • DÍAS CON MAYORES VENTAS POR VENDEDOR:\n" + rankD
							+ " • MESES CON MAYORES VENTAS POR VENDEDOR:\n" + rankM, //
					"GRACIAS Y HASTA MAÑANA :)", // 6
			};
			String[] porSumm = {
					"COMPARAÇÃO COM OS ANOS PASSADOS:"
							+ (conLY4.size() == 0 ? ""
									: "\nEM " + (currentDate.y - 4) + ", VENDEMOS EM MÉDIA DE $" + dailyAvgLY4)
							+ (conLY3.size() == 0 ? ""
									: "\nEM " + (currentDate.y - 3) + ", VENDEMOS EM MÉDIA DE $" + dailyAvgLY3)
							+ (conLY2.size() == 0 ? ""
									: "\nEM " + (currentDate.y - 2) + ", VENDEMOS EM MÉDIA DE $" + dailyAvgLY2)
							+ (conLY.size() == 0 ? ""
									: "\nEM " + (currentDate.y - 1) + ", VENDEMOS EM MÉDIA DE $" + dailyAvgLY)
							+ "\nESTE ANO, VENDEMOS UMA MÉDIA DE $" + dailyAvg + "\nCORRESPONDE A:" + (conLY.size() == 0
									? ""
									: "\n • $" + (dailyAvg > dailyAvgLY ? dailyAvg - dailyAvgLY + " MAIS QUE "
											+ (currentDate.y - 1) + " (%" + 100 * (dailyAvg - dailyAvgLY) / dailyAvgLY
											: dailyAvgLY - dailyAvg + " MENOS QUE " + (currentDate.y - 1) + " (%" + 100
													* (dailyAvgLY - dailyAvg) / dailyAvgLY)
											+ ")")
							+ (conLY2.size() == 0 ? ""
									: "\n • $"
											+ (dailyAvg > dailyAvgLY2
													? dailyAvg - dailyAvgLY2 + " MAIS QUE " + (currentDate.y - 2)
															+ " (%" + 100 * (dailyAvg - dailyAvgLY2) / dailyAvgLY2
													: dailyAvgLY2 - dailyAvg + " MENOS QUE " + (currentDate.y - 2)
															+ " (%" + 100 * (dailyAvgLY2 - dailyAvg) / dailyAvgLY2)
											+ ")")
							+ (conLY3.size() == 0 ? ""
									: "\n • $" + (dailyAvg > dailyAvgLY3
											? dailyAvg - dailyAvgLY3 + " MAIS QUE " + (currentDate.y - 3) + " (%"
													+ 100 * (dailyAvg - dailyAvgLY3) / dailyAvgLY3
											: dailyAvgLY3 - dailyAvg + " MENOS QUE " + (currentDate.y - 3) + " (%"
													+ 100 * (dailyAvgLY3 - dailyAvg) / dailyAvgLY3)
											+ ")")
							+ (conLY4.size() == 0 ? ""
									: "\n • $"
											+ (dailyAvg > dailyAvgLY4
													? dailyAvg - dailyAvgLY4 + " MAIS QUE " + (currentDate.y - 4)
															+ " (%" + 100 * (dailyAvg - dailyAvgLY4) / dailyAvgLY4
													: dailyAvgLY4 - dailyAvg + " MENOS QUE " + (currentDate.y - 4)
															+ " (%" + 100 * (dailyAvgLY4 - dailyAvg) / dailyAvgLY4)
											+ ")"), // 0
					"EXTREMOS DO ANO:\n" + (maxCounter > 1
							? "A MELHOR PROMOÇÃO POR DIA DO ANO PASSOU " + maxCounter + " VEZES E ISSO É $" + temp[0]
							: "O MELHOR DIA DESTE ANO É " + maxDayString + " " + maxDIndex + "-"
									+ getMonthForInt(DataCalc.monthFromIndex(temp[2]) - 1, 1) + ", O QUE VENDEMOS $"
									+ temp[0])
							+ "\n"
							+ (minCounter > 1
									? "A PIOR VENDA POR DIA DO ANO PASSOU " + minCounter + " VEZES E ISSO É $" + temp[1]
									: "O PIOR DIA DO ANO É " + minDayString + " " + minDIndex + "-"
											+ getMonthForInt(DataCalc.monthFromIndex(temp[3]) - 1, 1)
											+ ", O QUE VENDEMOS $" + temp[1]), // 1
					"DIFERENÇA DOS MESES ANTERIORES:\n" + avgOfMonths[0] + avgOfMonths[1] + avgOfMonths[2]
							+ avgOfMonths[3] + avgOfMonths[4] + avgOfMonths[5] + avgOfMonths[6] + avgOfMonths[7]
							+ avgOfMonths[8] + avgOfMonths[9] + avgOfMonths[10] + avgOfMonths[11], // 3 months
					"EXTREMOS DO MÊS:\nO MELHOR MÊS DO ANO FOI " + getMonthForInt(Integer.valueOf(avgOfMonths[14]), 1)
							+ ", O QUE VENDEMOS EM MÉDIA $" + avgOfMonths[12] + "\nO PIOR MÊS DO ANO FOI "
							+ getMonthForInt(Integer.valueOf(avgOfMonths[15]), 1) + ", O QUE VENDEMOS EM MÉDIA $"
							+ avgOfMonths[13], // 4 MAX AND MIN FOR THE MONTH
					"A MÉDIA DE ACORDO COM O DIA SÃO:\nSEGUNDA-FEIRA -> $" + daysAvg[0] + " (%" + daysPerc[0]
							+ ")\nTERÇA-FEIRA -> $" + daysAvg[1] + " (%" + daysPerc[1] + ")\nQUARTA-FEIRA -> $"
							+ daysAvg[2] + " (%" + daysPerc[2] + ")\nQUINTA-FEIRA -> $" + daysAvg[3] + " (%"
							+ daysPerc[3] + ")\nSEXTA-FEIRA -> $" + daysAvg[4] + " (%" + daysPerc[4] + ")\nSÁBADO -> $"
							+ daysAvg[5] + " (%" + daysPerc[5] + ")\nDOMINGO -> $" + daysAvg[6] + " (%" + daysPerc[6]
							+ ")", // 5
					"O MÍNIMO E MÁXIMO DE ACORDO COM O DIA:\nSEGUNDA-FEIRA -> MAX: $" + minmaxV[0][0] + ", MIN: $"
							+ minmaxV[0][1] + "\nTERÇA-FEIRA -> MAX: $" + minmaxV[1][0] + ", MIN: $" + minmaxV[1][1]
							+ "\nQUARTA-FEIRA -> MAX: $" + minmaxV[2][0] + ", MIN: $" + minmaxV[2][1]
							+ "\nQUINTA-FEIRA -> MAX: $" + minmaxV[3][0] + ", MIN: $" + minmaxV[3][1]
							+ "\nSEXTA-FEIRA -> MAX: $" + minmaxV[4][0] + ", MIN: $" + minmaxV[4][1]
							+ "\nSÁBADO -> MAX: $" + minmaxV[5][0] + ", MIN: $" + minmaxV[5][1] + "\nDOMINGO -> MAX: $"
							+ minmaxV[6][0] + ", MIN: $" + minmaxV[6][1], // 6
					"MAIS VENDIDOS DO ANO POR QUANTIDADE:\n" + top10S, //
					"MAIS VENDIDOS DO ANO POR PREÇO:\n" + top10P, //
					"TOP VENDEDORES:\n" + " • TOTAL:\n" + sellerText + " • MEDIA:\n" + avgSeller
							+ " • DIAS COM MAIORES VENDAS POR VENDEDOR:\n" + rankD
							+ " • MESES COM MAIORES VENDAS POR VENDEDOR:\n" + rankM, //
					"OBRIGADO E ATÉ AMANHÃ :)"// 2
			};
			String[] engSumm = {
					"COMPARISON WITH LAST YEARS:"
							+ (conLY4.size() == 0 ? ""
									: "\nIN " + (currentDate.y - 4) + ", WE SOLD AN AVERAGE OF $" + dailyAvgLY4)
							+ (conLY3.size() == 0 ? ""
									: "\nIN " + (currentDate.y - 3) + ", WE SOLD AN AVERAGE OF $" + dailyAvgLY3)
							+ (conLY2.size() == 0 ? ""
									: "\nIN " + (currentDate.y - 2) + ", WE SOLD AN AVERAGE OF $" + dailyAvgLY2)
							+ (conLY.size() == 0 ? ""
									: "\nIN " + (currentDate.y - 1) + ", WE SOLD AN AVERAGE OF $" + dailyAvgLY)
							+ "\nTHIS YEAR, WE SOLD AN AVERAGE OF $" + dailyAvg + "\nCORRESPONDING TO:"
							+ (conLY.size() == 0 ? ""
									: "\n • $" + (dailyAvg > dailyAvgLY
											? dailyAvg - dailyAvgLY + " MORE THAN " + (currentDate.y - 1) + " (%"
													+ 100 * (dailyAvg - dailyAvgLY) / dailyAvgLY
											: dailyAvgLY - dailyAvg + " LESS THAN " + (currentDate.y - 1) + " (%"
													+ 100 * (dailyAvgLY - dailyAvg) / dailyAvgLY)
											+ ")")
							+ (conLY2.size() == 0 ? ""
									: "\n • $"
											+ (dailyAvg > dailyAvgLY2
													? dailyAvg - dailyAvgLY2 + " MORE THAN " + (currentDate.y - 2)
															+ " (%" + 100 * (dailyAvg - dailyAvgLY2) / dailyAvgLY2
													: dailyAvgLY2 - dailyAvg + " LESS THAN " + (currentDate.y - 2)
															+ " (%" + 100 * (dailyAvgLY2 - dailyAvg) / dailyAvgLY2)
											+ ")")
							+ (conLY3.size() == 0 ? ""
									: "\n • $" + (dailyAvg > dailyAvgLY3
											? dailyAvg - dailyAvgLY3 + " MORE THAN " + (currentDate.y - 3) + " (%"
													+ 100 * (dailyAvg - dailyAvgLY3) / dailyAvgLY3
											: dailyAvgLY3 - dailyAvg + " LESS THAN " + (currentDate.y - 3) + " (%"
													+ 100 * (dailyAvgLY3 - dailyAvg) / dailyAvgLY3)
											+ ")")
							+ (conLY4.size() == 0 ? ""
									: "\n • $"
											+ (dailyAvg > dailyAvgLY4
													? dailyAvg - dailyAvgLY4 + " MORE THAN " + (currentDate.y - 4)
															+ " (%" + 100 * (dailyAvg - dailyAvgLY4) / dailyAvgLY4
													: dailyAvgLY4 - dailyAvg + " LESS THAN " + (currentDate.y - 4)
															+ " (%" + 100 * (dailyAvgLY4 - dailyAvg) / dailyAvgLY4)
											+ ")"), // 0
					"EXTREMES OF THE YEAR:\n" + (maxCounter > 1
							? "THE BEST SELL PER DAY OF THE YEAR HAPPENED " + maxCounter + " TIMES AND IT'S $" + temp[0]
							: "THE BEST DAY OF THIS YEAR IS " + maxDayString + " " + maxDIndex + "-"
									+ getMonthForInt(DataCalc.monthFromIndex(temp[2]) - 1, 2) + ", WHAT WE SOLD $"
									+ temp[0])
							+ "\n"
							+ (minCounter > 1
									? "THE WORSRT SELL PER DAY OF THE YEAR HAPPENED " + minCounter + " TIMES AND IT'S $"
											+ temp[1]
									: "THE WORST DAY OF THIS YEAR IS " + minDayString + " " + minDIndex + "-"
											+ getMonthForInt(DataCalc.monthFromIndex(temp[3]) - 1, 2)
											+ ", WHAT WE SOLD $" + temp[1]), // 1
					"DIFFERENCE FROM PREVIOUS MONTHS:\n" + avgOfMonths[0] + avgOfMonths[1] + avgOfMonths[2]
							+ avgOfMonths[3] + avgOfMonths[4] + avgOfMonths[5] + avgOfMonths[6] + avgOfMonths[7]
							+ avgOfMonths[8] + avgOfMonths[9] + avgOfMonths[10] + avgOfMonths[11], // 3 months
					"EXTREMES OF THE MONTH:\nTHE BEST MONTH OF THE YEAR WAS "
							+ getMonthForInt(Integer.valueOf(avgOfMonths[14]), 2) + ", WHAT WE SOLD AN AVERAGE OF $"
							+ avgOfMonths[12] + "\nTHE WORST MONTH OF THE YEAR WAS "
							+ getMonthForInt(Integer.valueOf(avgOfMonths[15]), 2) + ", WHAT WE SOLD AN AVERAGE OF $"
							+ avgOfMonths[13], // 4 MAX AND MIN FOR THE MONTH
					"THE AVERAGE ACCORDING TO THE DAY ARE:\nMONDAY -> $" + daysAvg[0] + " (%" + daysPerc[0]
							+ ")\nTUESDAY -> $" + daysAvg[1] + " (%" + daysPerc[1] + ")\nWEDNESDAY -> $" + daysAvg[2]
							+ " (%" + daysPerc[2] + ")\nTHURSDAY -> $" + daysAvg[3] + " (%" + daysPerc[3]
							+ ")\nFRIDAY -> $" + daysAvg[4] + " (%" + daysPerc[4] + ")\nSATURDAY -> $" + daysAvg[5]
							+ " (%" + daysPerc[5] + ")\nSUNDAY -> $" + daysAvg[6] + " (%" + daysPerc[6] + ")", // 5
					"THE MINIMUM AND MAXIMUM ACCORDING THE DAY:\nMONDAY -> MAX: $" + minmaxV[0][0] + ", MIN: $"
							+ minmaxV[0][1] + "\nTUESDAY -> MAX: $" + minmaxV[1][0] + ", MIN: $" + minmaxV[1][1]
							+ "\nWEDNESDAY -> MAX: $" + minmaxV[2][0] + ", MIN: $" + minmaxV[2][1]
							+ "\nTHURSDAY -> MAX: $" + minmaxV[3][0] + ", MIN: $" + minmaxV[3][1] + "\nFRIDAY -> MAX: $"
							+ minmaxV[4][0] + ", MIN: $" + minmaxV[4][1] + "\nSATURDAY -> MAX: $" + minmaxV[5][0]
							+ ", MIN: $" + minmaxV[5][1] + "\nSUNDAY -> MAX: $" + minmaxV[6][0] + ", MIN: $"
							+ minmaxV[6][1], // 6
					"TOP SELL OF YEAR BY QUANTITY:\n" + top10S, //
					"TOP SELL OF YEAR BY PRICE:\n" + top10P, //
					"TOP SELLERS:\n" + " • TOTAL:\n" + sellerText + " • AVERAGE:\n" + avgSeller
							+ " • DAYS WITH HIGHEST SALES BY SELLER:\n" + rankD
							+ " • MONTHS WITH HIGHEST SALES BY SELLER:\n" + rankM, //
					"THANKS AND SEE YOU TOMORROW :)" // 4
			};
			String[] frSumm = {
					"COMPARAISON AVEC LES ANNÉES PASSÉES:"
							+ (conLY4.size() == 0 ? ""
									: "\nEN " + (currentDate.y - 4) + ", NOUS AVONS VENDU UNE MOYENNE DE $"
											+ dailyAvgLY4)
							+ (conLY3.size() == 0 ? ""
									: "\nEN " + (currentDate.y - 3) + ", NOUS AVONS VENDU UNE MOYENNE DE $"
											+ dailyAvgLY3)
							+ (conLY2.size() == 0 ? ""
									: "\nEN " + (currentDate.y - 2) + ", NOUS AVONS VENDU UNE MOYENNE DE $"
											+ dailyAvgLY2)
							+ (conLY.size() == 0 ? ""
									: "\nEN " + (currentDate.y - 1) + ", NOUS AVONS VENDU UNE MOYENNE DE $"
											+ dailyAvgLY)
							+ "\nCETTE ANNÉE, NOUS AVONS VENDU UNE MOYENNE DE $" + dailyAvg + "\nCORRESPOND À:"
							+ (conLY.size() == 0 ? ""
									: "\n • $" + (dailyAvg > dailyAvgLY
											? dailyAvg - dailyAvgLY + " PLUS QUE " + (currentDate.y - 1) + " (%"
													+ 100 * (dailyAvg - dailyAvgLY) / dailyAvgLY
											: dailyAvgLY - dailyAvg + " MOINS QUE " + (currentDate.y - 1) + " (%"
													+ 100 * (dailyAvgLY - dailyAvg) / dailyAvgLY)
											+ ")")
							+ (conLY2.size() == 0 ? ""
									: "\n • $"
											+ (dailyAvg > dailyAvgLY2
													? dailyAvg - dailyAvgLY2 + " PLUS QUE " + (currentDate.y - 2)
															+ " (%" + 100 * (dailyAvg - dailyAvgLY2) / dailyAvgLY2
													: dailyAvgLY2 - dailyAvg + " MOINS QUE " + (currentDate.y - 2)
															+ " (%" + 100 * (dailyAvgLY2 - dailyAvg) / dailyAvgLY2)
											+ ")")
							+ (conLY3.size() == 0 ? ""
									: "\n • $" + (dailyAvg > dailyAvgLY3
											? dailyAvg - dailyAvgLY3 + " PLUS QUE " + (currentDate.y - 3) + " (%"
													+ 100 * (dailyAvg - dailyAvgLY3) / dailyAvgLY3
											: dailyAvgLY3 - dailyAvg + " MOINS QUE " + (currentDate.y - 3) + " (%"
													+ 100 * (dailyAvgLY3 - dailyAvg) / dailyAvgLY3)
											+ ")")
							+ (conLY4.size() == 0 ? ""
									: "\n • $"
											+ (dailyAvg > dailyAvgLY4
													? dailyAvg - dailyAvgLY4 + " PLUS QUE " + (currentDate.y - 4)
															+ " (%" + 100 * (dailyAvg - dailyAvgLY4) / dailyAvgLY4
													: dailyAvgLY4 - dailyAvg + " MOINS QUE " + (currentDate.y - 4)
															+ " (%" + 100 * (dailyAvgLY4 - dailyAvg) / dailyAvgLY4)
											+ ")"), // 0
					"EXTREMES DE L'ANNÉE:\n"
							+ (maxCounter > 1
									? "LA MEILLEURE VENTE PAR JOUR DE L'ANNÉE PASSÉ  " + maxCounter + " FOIS ET C'EST $"
											+ temp[0]
									: "LE MEILLEUR JOUR DE CETTE ANNÉE EST " + maxDayString + " " + maxDIndex + "-"
											+ getMonthForInt(DataCalc.monthFromIndex(temp[2]) - 1, 3)
											+ ", CE QUE NOUS AVONS VENDU $" + temp[0])
							+ "\n"
							+ (minCounter > 1
									? "LA PIRE VENTE PAR JOUR DE L'ANNÉE PASSÉ " + minCounter + " FOIS ET C'EST $"
											+ temp[1]
									: " LE PIRE JOUR DE CETTE ANNÉE EST " + minDayString + " " + minDIndex + "-"
											+ getMonthForInt(DataCalc.monthFromIndex(temp[3]) - 1, 3)
											+ ", CE QUE NOUS AVONS VENDU $" + temp[1]), // 1
					"DIFFÉRENCE AVEC LES MOIS PRÉCÉDENTS:\n" + avgOfMonths[0] + avgOfMonths[1] + avgOfMonths[2]
							+ avgOfMonths[3] + avgOfMonths[4] + avgOfMonths[5] + avgOfMonths[6] + avgOfMonths[7]
							+ avgOfMonths[8] + avgOfMonths[9] + avgOfMonths[10] + avgOfMonths[11], // 2 mois
					"EXTREMES DE MOIS:\nLE MEILLEUR MOIS DE L'ANNÉE A ÉTÉ "
							+ getMonthForInt(Integer.valueOf(avgOfMonths[14]), 3)
							+ ", CE QUE NOUS AVONS VENDU EN MOYENNE DE $" + avgOfMonths[12]
							+ "\nLE PIRE MOIS DE L'ANNÉE A ÉTÉ " + getMonthForInt(Integer.valueOf(avgOfMonths[15]), 3)
							+ ", CE QUE NOUS AVONS VENDU EN MOYENNE DE $" + avgOfMonths[13], // 3 MAX
					"LA MOYENNE SELON LE JOUR EST:\nLUNDI -> $" + daysAvg[0] + " (%" + daysPerc[0] + ")\nMARDI -> $"
							+ daysAvg[1] + " (%" + daysPerc[1] + ")\nMERCREDI -> $" + daysAvg[2] + " (%" + daysPerc[2]
							+ ")\nJEUDI -> $" + daysAvg[3] + " (%" + daysPerc[3] + ")\nVENDREDI -> $" + daysAvg[4]
							+ " (%" + daysPerc[4] + ")\nSAMEDI -> $" + daysAvg[5] + " (%" + daysPerc[5]
							+ ")\nDIMANCHE -> $" + daysAvg[6] + " (%" + daysPerc[6] + ")", // 4
					"LE MINIMUM ET LE MAXIMUM SELON LE JOUR :\nLUNDI -> MAX: $" + minmaxV[0][0] + ", MIN: $"
							+ minmaxV[0][1] + "\nMARDI -> MAX: $" + minmaxV[1][0] + ", MIN: $" + minmaxV[1][1]
							+ "\nMERCREDI -> MAX: $" + minmaxV[2][0] + ", MIN: $" + minmaxV[2][1] + "\nJEUDI -> MAX: $"
							+ minmaxV[3][0] + ", MIN: $" + minmaxV[3][1] + "\nVENDREDI -> MAX: $" + minmaxV[4][0]
							+ ", MIN: $" + minmaxV[4][1] + "\nSAMEDI -> MAX: $" + minmaxV[5][0] + ", MIN: $"
							+ minmaxV[5][1] + "\nDIMANCHE -> MAX: $" + minmaxV[6][0] + ", MIN: $" + minmaxV[6][1], // 5
					"MEILLEURE VENTE DU L'ANNÉE PAR QUANTITÉ:\n" + top10S, // 6
					"MEILLEURE VENTE DU L'ANNÉE PAR PRIX:\n" + top10P, // 7
					"MEILLEURS VENDEURS:\n" + " • TOTAL:\n" + sellerText + " • MOYENNE:\n" + avgSeller
							+ " • JOURS AVEC LES PLUS GRANDES VENTES PAR VENDEUR:\n" + rankD
							+ " • MOIS AVEC LES PLUS GRANDES VENTES PAR VENDEUR:\n" + rankM, //
					"MERCI ET À DEMAIN :)" // 9
			};
			savedF.write("HADI-TECH" + (language == Language.SPANISH ? (" - SUMARIO DE ESTE AÑO")
					: language == Language.PORTUGUES ? (" - RESUMO DESTE ANO")
							: language == Language.ENGLISH ? (" - SUMMARY OF THIS YEAR")
									: " - SOMMAIRE DE CETTE ANNEE"));
			if (conLY.size() == 0 && conLY2.size() == 0 && conLY3.size() == 0 && conLY4.size() == 0) {
				savedF.write("\n\nI. " + (language == Language.SPANISH ? espSumm[1]
						: language == Language.PORTUGUES ? porSumm[1]
								: language == Language.ENGLISH ? engSumm[1] : frSumm[1]));
				savedF.write("\n\nII. " + (language == Language.SPANISH ? espSumm[2]
						: language == Language.PORTUGUES ? porSumm[2]
								: language == Language.ENGLISH ? engSumm[2] : frSumm[2]));
				savedF.write("\nIII. " + (language == Language.SPANISH ? espSumm[3]
						: language == Language.PORTUGUES ? porSumm[3]
								: language == Language.ENGLISH ? engSumm[3] : frSumm[3]));
				savedF.write("\n\nIV. " + (language == Language.SPANISH ? espSumm[4]
						: language == Language.PORTUGUES ? porSumm[4]
								: language == Language.ENGLISH ? engSumm[4] : frSumm[4]));
				savedF.write("\n\nV. " + (language == Language.SPANISH ? espSumm[5]
						: language == Language.PORTUGUES ? porSumm[5]
								: language == Language.ENGLISH ? engSumm[5] : frSumm[5]));
				if (top10.size() > 0) {
					savedF.write("\n\nVI. " + (language == Language.SPANISH ? espSumm[6]
							: language == Language.PORTUGUES ? porSumm[6]
									: language == Language.ENGLISH ? engSumm[6] : frSumm[6]));
					savedF.write("\nVII. " + (language == Language.SPANISH ? espSumm[7]
							: language == Language.PORTUGUES ? porSumm[7]
									: language == Language.ENGLISH ? engSumm[7] : frSumm[7]));
				}
				if (sortedMap.size() > 0)
					savedF.write("\nVIII. " + (language == Language.SPANISH ? espSumm[8]
							: language == Language.PORTUGUES ? porSumm[8]
									: language == Language.ENGLISH ? engSumm[8] : frSumm[8]));
			} else {
				savedF.write("\n\nI. " + (language == Language.SPANISH ? espSumm[0]
						: language == Language.PORTUGUES ? porSumm[0]
								: language == Language.ENGLISH ? engSumm[0] : frSumm[0]));
				savedF.write("\n\nII. " + (language == Language.SPANISH ? espSumm[1]
						: language == Language.PORTUGUES ? porSumm[1]
								: language == Language.ENGLISH ? engSumm[1] : frSumm[1]));
				savedF.write("\n\nIII. " + (language == Language.SPANISH ? espSumm[2]
						: language == Language.PORTUGUES ? porSumm[2]
								: language == Language.ENGLISH ? engSumm[2] : frSumm[2]));
				savedF.write("\nIV. " + (language == Language.SPANISH ? espSumm[3]
						: language == Language.PORTUGUES ? porSumm[3]
								: language == Language.ENGLISH ? engSumm[3] : frSumm[3]));
				savedF.write("\n\nV. " + (language == Language.SPANISH ? espSumm[4]
						: language == Language.PORTUGUES ? porSumm[4]
								: language == Language.ENGLISH ? engSumm[4] : frSumm[4]));
				savedF.write("\n\nVI. " + (language == Language.SPANISH ? espSumm[5]
						: language == Language.PORTUGUES ? porSumm[5]
								: language == Language.ENGLISH ? engSumm[5] : frSumm[5]));
				if (top10.size() > 0) {
					savedF.write("\n\nVII. " + (language == Language.SPANISH ? espSumm[6]
							: language == Language.PORTUGUES ? porSumm[6]
									: language == Language.ENGLISH ? engSumm[6] : frSumm[6]));
					savedF.write("\nVIII. " + (language == Language.SPANISH ? espSumm[7]
							: language == Language.PORTUGUES ? porSumm[7]
									: language == Language.ENGLISH ? engSumm[7] : frSumm[7]));
				}
				if (sortedMap.size() > 0)
					savedF.write("\nIX. " + (language == Language.SPANISH ? espSumm[8]
							: language == Language.PORTUGUES ? porSumm[8]
									: language == Language.ENGLISH ? engSumm[8] : frSumm[8]));
			}
			savedF.write("\n" + (language == Language.SPANISH ? espSumm[9]
					: language == Language.PORTUGUES ? porSumm[9]
							: language == Language.ENGLISH ? engSumm[9] : frSumm[9]));
			savedF.close();
			// save year graph
			File merchFolder = new File(yearFolder + "\\STOCK");
			merchFolder.mkdir();
			File empFolder = new File(yearFolder, "\\" + getLocalizedMessage("EMPLOYEE"));
			empFolder.mkdir();
			File chartFile = new File(yearFolder, getLocalizedMessage("GRAPH") + " - " + getLocalizedMessage("SELL")
					+ " " + getLocalizedMessage("OF") + " " + currentDate.y + ".PNG");
			saveGraph(yearChart(currentDate.y), chartFile);
			if (conLY.size() != 0 || conLY2.size() != 0 || conLY3.size() != 0 || conLY4.size() != 0) {
				File diffYears = new File(yearFolder, getLocalizedMessage("GRAPH") + " - " + getLocalizedMessage("SELL")
						+ " " + getLocalizedMessage("OF") + " " + getLocalizedMessage("ALL_YEAR") + ".PNG");
				saveGraph(diffYearChart(), diffYears);
			}
			if (conf[21] == null || conf[21].equalsIgnoreCase("null") || conf[21].equals("false")) {
				/* Save top 10 merchandises as png */
				File qtyStock = new File(merchFolder,
						getLocalizedMessage("TOP_ITEMS") + "-" + getLocalizedMessage("GRAPH") + " "
								+ getLocalizedMessage("OF") + " " + getLocalizedMessage("QUANTITY") + ".png");
				File priceStock = new File(merchFolder,
						getLocalizedMessage("TOP_ITEMS") + "-" + getLocalizedMessage("GRAPH") + " "
								+ getLocalizedMessage("OF") + " " + getLocalizedMessage("PRICE") + ".png");
				saveGraph(topMerchChart(getLocalizedMessage("QUANTITY"), -1), qtyStock);
				saveGraph(topMerchChart(getLocalizedMessage("PRICE"), -1), priceStock);
				File sellersGraph = new File(empFolder,
						getLocalizedMessage("EMPLOYEE") + " - " + getLocalizedMessage("GRAPH") + " "
								+ getLocalizedMessage("OF") + " " + getLocalizedMessage("SELL") + ".png");
				File sellersDiag = new File(empFolder,
						getLocalizedMessage("EMPLOYEE") + " - " + getLocalizedMessage("DIAGRAM") + " "
								+ getLocalizedMessage("OF") + " " + getLocalizedMessage("SELL") + " (TOTAL).png");
				File sellersDiagAvg = new File(empFolder,
						getLocalizedMessage("EMPLOYEE") + " - " + getLocalizedMessage("DIAGRAM") + " "
								+ getLocalizedMessage("OF") + " " + getLocalizedMessage("SELL") + " ("
								+ getLocalizedMessage("AVERAGE") + ").png");
				saveGraph(sellersChart(-1, currentDate.y), sellersGraph);
				saveGraph(sellersDiag(-1, currentDate.y, "TOTAL"), sellersDiag);
				saveGraph(sellersDiag(-1, currentDate.y, "AVG"), sellersDiagAvg);
				exEmpSum(-1, currentDate.y, empFolder);
			}
			Toast.show(this, Toast.Type.SUCCESS, getLocalizedMessage("YEAR_E"), Intro.notOption);
		} catch (Exception e2) {
			writeError(e2);
		}
	}

	/* Export employee Summary */
	private void exEmpSum(int month, int year, File folder) {
		try {
			for (Employee emp : employee) {
				String empName = emp.getName();
				List<String> empSum = summEmpCalc(empName, month, year);
				File empFile = new File(folder, empName + ".txt");

				FileWriter savedF = new FileWriter(empFile);
				if (month == -1)
					savedF.write(getLocalizedMessage("SUMMARY") + " " + getLocalizedMessage("OF") + " " + year + " "
							+ getLocalizedMessage("OF") + " " + empName);
				else
					savedF.write(getLocalizedMessage("SUMMARY") + " " + getLocalizedMessage("OF") + " "
							+ getMonthForInt(month - 1, langIndex) + " " + getLocalizedMessage("OF") + " " + empName);
				int index = 1;
				for (int i = 0; i < empSum.size(); i++) {
					String line = empSum.get(i);
					if (line.startsWith("---")) {
						line = line.replaceFirst("^---", "");
						line = line.replaceFirst("---$", "");
						savedF.write("\n\n" + TextEffect.toRoman(index++) + ". " + line);
					} else
						savedF.write("\n" + line);
				}
				if (month != -1) {
					data = loadFreeDays(getLocalizedMessage("WEEK_DAYS"));
					List<String> weekDays = new ArrayList<String>(), weekDaysM = new ArrayList<String>();
					if (data.containsKey(empName))
						weekDays = data.get(empName);

					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					weekDaysM = weekDays.stream().filter(dateStr -> {
						try {
							LocalDate date = LocalDate.parse(dateStr, formatter);
							return date.getMonthValue() == month;
						} catch (Exception e) {
							return false;
						}
					}).collect(Collectors.toList());
					if (weekDaysM.size() > 0) {
						savedF.write("\n\n" + TextEffect.toRoman(index++) + ". " + getLocalizedMessage("WEEK_DAYS"));
						for (String date : weekDaysM)
							savedF.write("\n • " + date);
					}
				} else {
					// license
					data = loadFreeDays(getLocalizedMessage("LICENSE"));
					List<String> licDays = new ArrayList<String>(), faltasD = new ArrayList<String>();
					if (data.containsKey(empName))
						licDays = data.get(empName);
					if (licDays.size() > 0) {
						savedF.write("\n\n" + TextEffect.toRoman(index++) + ". " + getLocalizedMessage("VACATION") + "("
								+ licDays.size() + ")");
						for (String date : licDays)
							savedF.write("\n • " + date);
					}
					// faltas
					data = loadFreeDays(getLocalizedMessage("UNAUTH"));
					if (data.containsKey(empName))
						faltasD = data.get(empName);
					if (faltasD.size() > 0) {
						savedF.write("\n\n" + TextEffect.toRoman(index++) + ". " + getLocalizedMessage("UNAUTH") + "("
								+ faltasD.size() + ")");
						for (String date : faltasD)
							savedF.write("\n • " + date);
					}
				}

				savedF.close();
			}
		} catch (Exception e2) {
			writeError(e2);
		}
	}

	/* Open Configurarion */
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
				colorSelected = 0;
				fg = Intro.lightC;
				bg = Intro.blackM;
				uBorder = Intro.borderL;
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
				colorSelected = 1;
				fg = Intro.lightC;
				bg = Intro.blueM;
				uBorder = Intro.borderL;
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
				uBorder = Intro.borderD;
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
				colorSelected = 2;
			}
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			writeError(e);
		}
		/* icon */
		setIconImage(new ImageIcon(getClass().getResource("images/icon/icon.png")).getImage());
		/* LANGUAGE */
		if (conf[7] == null || conf[7].equals("0")) {
			language = Language.SPANISH;
			langIndex = 0;
		} else if (conf[7].equals("1")) {
			language = Language.PORTUGUES;
			langIndex = 1;
		} else if (conf[7].equals("2")) {
			language = Language.ENGLISH;
			langIndex = 2;
		} else {
			language = Language.FRENCH;
			langIndex = 3;
		}
		/* AUTOLOCK TIME */
		if (conf[3] == null || !TextEffect.isInteger(conf[3])) {
			INACTIVITY_DELAY = 10 * 60 * 1000;
		} else {
			if (Integer.valueOf(conf[3]) < 1)
				INACTIVITY_DELAY = 1 * 60 * 1000;
			else if (Integer.valueOf(conf[3]) > 60)
				INACTIVITY_DELAY = 60 * 60 * 1000;
			else
				INACTIVITY_DELAY = Integer.valueOf(conf[3]) * 60 * 1000;
		}

		if (conf[16].equals("false"))
			dateLabel.setVisible(true);
		else
			dateLabel.setVisible(false);
		if (conf[17].equals("false"))
			notificationButton.setVisible(true);
		else
			notificationButton.setVisible(false);
	}

	/* Add Sound effect */
	private void soundEffect(URL sound) {
		try {// sounds
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(sound);
			Clip clip = AudioSystem.getClip();
			clip.open(audioStream);
			clip.start();
		} catch (Exception e1) {
			writeError(e1);
		}
	}

	/* Clear all */
	private void clearAll() {
		ModernDialog dialog = new ModernDialog(this, getLocalizedMessage("CLEAR_Q"), false);
		dialog.setIcon(IconType.QUESTION);
		dialog.addSubText(getLocalizedMessage("CANNOT_UNDO"), fg);
		dialog.addButton(getLocalizedMessage("YES"), Intro.greenM, () -> {
			if (conf[1] == null || conf[1].equalsIgnoreCase("null") || conf[1].equals("false"))
				soundEffect(clearSound);
			for (int i = 0; i < 6; i++)
				for (int j = 0; j < 20; j++) {
					details[i][j].setText("");
					detailsM[i][j].setText("");
				}
			initialDay.setText("");
			for (int i = 0; i < 16; i++) {
				gastosTable[i].setText("");
				agregadoTable[i].setText("");
				gTable[i].setText("");
				aTable[i].setText("");
			}
			for (int i = 0; i < 8; i++)
				panelCnum[i].setText("");
			sumF();
			Toast.show(this, Toast.Type.SUCCESS, getLocalizedMessage("CLEAN_S"), Intro.notOption);
		});
		dialog.addButton(getLocalizedMessage("NO"), Intro.redM, dialog::dispose);

		dialog.setColor(bg);
		dialog.setTextColor(fg);
		dialog.setOverlayColor(bg);
		dialog.setVisible(true);
	}

	/* New day */
	private void newDay() {
		if (!details[0][0].isVisible()) {// switch to the main table to take screenshot
			for (int i = 0; i < 6; i++)
				for (int j = 0; j < 20; j++) {
					details[i][j].setVisible(true);
					detailsM[i][j].setVisible(false);
					nextFocus();
				}
		}
		ModernDialog newDayDialog = new ModernDialog(this, getLocalizedMessage("EXP_RESULT"), false);
		newDayDialog.setIcon(IconType.QUESTION);
		if (isNewDayExisted())
			newDayDialog.addSubText(getLocalizedMessage("OVERWRITE") + "\n\n" + getLocalizedMessage("CANNOT_UNDO"), fg);
		else
			newDayDialog.addSubText(getLocalizedMessage("CANNOT_UNDO"), fg);
		newDayDialog.addButton(getLocalizedMessage("YES"), Intro.greenM, () -> {
			notificationButton.setVisible(false);
			tabbedPane.removeAll();
			invoiceModels.clear();
			loadInvoices(currentDate);
			invoiceTab(currentDate);
			ModernInputDialog userMessage = new ModernInputDialog(this,
					(language == Language.SPANISH ? "¿QUÉ ES "
							: language == Language.PORTUGUES ? "O QUE É O "
									: language == Language.ENGLISH ? "WHAT IS THE " : "QU'EST-CE QUE LE ")
							+ getLocalizedMessage("NOTE") + "?",
					true);
			userMessage.setIcon(ModernInputDialog.IconType.QUESTION);
			userMessage.addSubText(getLocalizedMessage("EMPTY"), fg);
			userMessage.addButton(getLocalizedMessage("YES"), Intro.greenM, () -> {
				dayMessage = userMessage.getTextField();
				separatedDialog(true);
			}, true);
			userMessage.setColor(bg);
			userMessage.setTextColor(fg);
			userMessage.setOverlayColor(bg);
			userMessage.setVisible(true);// SET VISIBLE

		});
		newDayDialog.addButton(getLocalizedMessage("NO"), Intro.redM, newDayDialog::dispose);// NO BUTTON
		newDayDialog.setColor(bg);
		newDayDialog.setTextColor(fg);
		newDayDialog.setOverlayColor(bg);
		newDayDialog.setVisible(true);// SET VISIBLE
		// Restore the focus back to the previously focused component
		if (focusedComponent != null) {
			focusedComponent.requestFocusInWindow();
		}
	}

	/* How do you separate after the end the day */
	private void afterNewDay(boolean customize) {
		if (conf[1] == null || conf[1].equalsIgnoreCase("null") || conf[1].equals("false"))
			soundEffect(notSound);

		SwingWorker<Void, Void> worker = new SwingWorker<>() {
			@Override
			protected Void doInBackground() {
				exBtn();
				/* If full delete the new table values */
				if (checkIfFull())
					try {
						String currentpath = System.getProperty("user.dir");
						File dataFolder = new File(currentpath + "\\data");
						dataFolder.mkdir();
						File extraFolder = new File(dataFolder + "\\extra");
						extraFolder.mkdir();
						File sepFile = new File(extraFolder, "indexM" + ".dll");
						FileWriter savedF = new FileWriter(sepFile);
						for (int i = 0; i < 6; i++)
							for (int j = 0; j < 20; j++)
								savedF.write("" + System.lineSeparator());
						savedF.close();
					} catch (Exception e) {
						writeError(e);
					}
				// cajas values
				for (int i = 0; i < 6; i++)// table detail
					for (int j = 0; j < 20; j++) {
						details[i][j].setText("");
						detailsM[i][j].setText("");
					}
				for (int i = 0; i < 16; i++) {// gastos nad agregados
					gastosTable[i].setText("");
					agregadoTable[i].setText("");
					gTable[i].setText("");
					aTable[i].setText("");
				}
				if (customSeparated) { // CUSTOMIZATION THE NEXT DAY VALUES
					String nextDayValues[] = customSep();
					for (int i = 0; i < 7; i++)// set of 1000 -> 50
						panelCnum[i].setText(TextEffect.isInteger(nextDayValues[i])
								? (Integer.valueOf(panelCnum[i].getText()) - Integer.valueOf(nextDayValues[i]) + "")
								: "0");
					panelCnum[7].setText("");// pix
					initialDay.setText(Integer.valueOf(panelCnum[0].getText()) * 100
							+ Integer.valueOf(panelCnum[1].getText()) * 50
							+ Integer.valueOf(panelCnum[2].getText()) * 20
							+ Integer.valueOf(panelCnum[3].getText()) * 10 + Integer.valueOf(panelCnum[4].getText()) * 5
							+ Integer.valueOf(panelCnum[5].getText()) * 2 + Integer.valueOf(panelCnum[6].getText()) * 1
							+ "");
					sumF();
				} else { // DEFAULT NEXT DAY VALUES
					initialDay.setText(restN + "");
					for (int i = 0; i < 3; i++)// set of 1000 -> 50
						panelCnum[i].setText("");
					panelCnum[7].setText("");// pix
					sumF();
				}

				/* NEXT DAY VALUES FOR DIFFERENT REASON */
				BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
				paint(img.getGraphics());
				File tempFile1 = new File(dataFolder + "\\extra");
				tempFile1.mkdir();
				File newFile = new File(tempFile1, "TEMP_NEXT_DAY.png");
				try {
					ImageIO.write(img, "png", newFile);
				} catch (IOException e) {
					writeError(e);
				}
				return null;
			}

			@Override
			protected void done() {
				if (customize)
					separadosFrame();
				/* Notification to view what you need to pay tomorrow */
				ArrayList<String> lists = getBillsDueToday(bills, WhatDay.TOMORROW);
				if (lists.size() != 0) {
					StringBuilder billsDescription = new StringBuilder();
					for (int i = 0; i < lists.size(); i++) {
						if (billsDescription.length() > 0) {
							billsDescription.append("\n"); // Add newline only between entries
						}
						billsDescription.append(lists.get(i));
					}
					Toast.show(Main.this, Toast.Type.INFO, getLocalizedMessage("BILLS_TMRW") + billsDescription,
							Intro.notOption);
				}
				/* Notification to re-check the money in the cash */
				Toast.show(Main.this, Toast.Type.WARNING, getLocalizedMessage("REVIEW_M"), Intro.notOption);
			}
		};
		worker.execute();
	}

	/* The dialog with pass to open the separated panel */
	private void separatedDialog(boolean endDay) {
		/* Password Dialog */
		PasswordDialog sepDialog = new PasswordDialog(this);
		int countAttemp = 0;
		sepDialog.setPassword(correctPassword);
		sepDialog.setFillColor(bg);
		sepDialog.setTextColor(fg);
		sepDialog.showMessage(getLocalizedMessage("PASSWORD_W"), getLocalizedMessage("TRIES") + (5 - countAttemp));
		String usario = sepDialog.getPassword();
		while (!usario.equalsIgnoreCase(correctPassword)) {
			if (conf[1] == null || conf[1].equalsIgnoreCase("null") || conf[1].equals("false"))
				soundEffect(wrongSound);
			if (sepDialog.getMessageType() == PasswordDialog.MessageType.CANCEL || countAttemp == 4)
				break;
			sepDialog.showMessage(getLocalizedMessage("TRY_AGAIN"),
					(getLocalizedMessage("TRIES")) + (5 - (++countAttemp)));
			usario = sepDialog.getPassword();
		}
		if (countAttemp != 4 && sepDialog.getMessageType() == PasswordDialog.MessageType.OK) {
			if (conf[1] == null || conf[1].equalsIgnoreCase("null") || conf[1].equals("false"))
				soundEffect(enterSound);
			if (endDay) {
				ModernDialog separatedMethod = new ModernDialog(this, getLocalizedMessage("SEP_Q"), true);
				separatedMethod.setIcon(IconType.QUESTION);
				separatedMethod.addButton("AUTO", Intro.goldM, () -> {
					customSeparated = false;
					separatedMethod.dispose();
					afterNewDay(true);
				});
				separatedMethod.addButton(getLocalizedMessage("CUSTOM"), Intro.blueM, () -> {
					customSeparated = true;
					separatedMethod.dispose();
					afterNewDay(true);
				});
				separatedMethod.setColor(bg);
				separatedMethod.setTextColor(fg);
				separatedMethod.setOverlayColor(bg);
				separatedMethod.setVisible(true);// SET VISIBLE
			} else
				separadosFrame();
		} else if (endDay) {
			customSeparated = false;
			afterNewDay(false);
		}
	}

	/* Custom separe money using a new panel */
	private String[] customSep() {
		// dialog to choose the money to separete
		JDialog dialog = new JDialog(this, "My Modal Dialog", true);
		// Customize dialog's look
		dialog.setUndecorated(true); // Removes the default window frame
		dialog.setLayout(new BorderLayout());
		overlay.showOverlay();
		int moneyValues[] = new int[8];
		for (int i = 0; i < 8; i++)
			moneyValues[i] = Integer.valueOf(panelCnum[i].getText());

		JPanel buttonPanel, textPanel;
		JLabel messageLabel;
		JLabel iconLabel; // New label for the icon
		String[] values = { "", "", "", "", "", "", "", "", "", "" };

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
				g2.drawRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 20, 20); // Draw border with small
																					// padding
			}
		};
		panel.setLayout(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		// Create icon label
		JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		northPanel.setBackground(bg);
		iconLabel = new JLabel();
		iconLabel.setIcon(UIManager.getIcon("OptionPane.questionIcon")); // Set the icon based on the type
		northPanel.add(iconLabel); // Add the button to the panel

		// Add multiline support using HTML in JLabel
		textPanel = new JPanel(new BorderLayout());
		textPanel.setBackground(bg);
		messageLabel = new JLabel("<html>" + getLocalizedMessage("SEPARAR_Q").replace("\n", "<br>") + "</html>",
				JLabel.CENTER);
		messageLabel.setForeground(fg);
		messageLabel.setFont(new Font("Arial", Font.BOLD, 16));

		JPanel moneyPanel = new JPanel(new BorderLayout(0, 0));
		JPanel moneyPhotoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		JPanel moneyValuePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		JLabel panelFoto[] = new JLabel[8];// Photo row
		JTextField panelValue[] = new JTextField[8];// Photo row
		moneyPanel.setBackground(bg);
		moneyPhotoPanel.setBackground(bg);
		moneyValuePanel.setBackground(bg);
		for (int i = 0; i < 7; i++) {
			int index = i;
			panelFoto[i] = new JLabel();
			panelValue[i] = new JTextField("0");
			if (i < 5)
				panelValue[i].setText(moneyValues[i] + "");
			values[i] = panelValue[i].getText();
			textFieldStyle(panelValue[i]);
			panelValue[i].setCaretColor(Intro.blackM);
			panelValue[i].setForeground(Intro.blackM);
			panelValue[i].setBackground(Intro.grisD);
			panelValue[i].addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if ((e.getKeyCode() == KeyEvent.VK_ESCAPE) && ((e.getModifiers() & InputEvent.CTRL_MASK) != 0))
						dialog.dispose();
					else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
						if (index < 7) {
							panelValue[index].setNextFocusableComponent(panelValue[index + 1]);
							panelValue[index].nextFocus();
						} else {
							panelValue[index].setNextFocusableComponent(panelValue[0]);
							panelValue[index].nextFocus();
						}
					} else if (e.getKeyCode() == KeyEvent.VK_LEFT)
						if (index > 0) {
							panelValue[index].setNextFocusableComponent(panelValue[index - 1]);
							panelValue[index].nextFocus();
						} else {
							panelValue[index].setNextFocusableComponent(panelValue[7]);
							panelValue[index].nextFocus();
						}
				}
			});
			panelValue[i].addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent e) {
					if (!TextEffect.isInteger(panelValue[index].getText()))
						panelValue[index].setText("0");
					else if (Integer.valueOf(panelValue[index].getText()) > moneyValues[index]) {
						Intro.startBorderAnimation(panelValue[index]);
						panelValue[index].setText(moneyValues[index] + "");
					} else {
						values[index] = panelValue[index].getText();
						totalSep = Integer.valueOf(panelValue[0].getText()) * 100
								+ Integer.valueOf(panelValue[1].getText()) * 50
								+ Integer.valueOf(panelValue[2].getText()) * 20
								+ Integer.valueOf(panelValue[3].getText()) * 10
								+ Integer.valueOf(panelValue[4].getText()) * 5
								+ Integer.valueOf(panelValue[5].getText()) * 2
								+ Integer.valueOf(panelValue[6].getText()) * 1;
					}
				}
			});
			panelValue[i].setPreferredSize(new Dimension(50, 40));
			panelFoto[i].setPreferredSize(new Dimension(50, 40));
			Intro.labelStyle(panelFoto[i]);
			panelFoto[i].setBorder(new LineBorder(fg, 1));
			panelValue[i].setBorder(new LineBorder(fg, 1));
			switch (i) {
			case 0:
				panelFoto[i].setIcon(new IconWithText(ImageEffect.getScaledImage(i100.getImage(), 50, 40),
						moneyValues[i] + "", Intro.blackM, Position.BOTTOM_RIGHT, Intro.myFontXS));
				break;
			case 1:
				panelFoto[i].setIcon(new IconWithText(ImageEffect.getScaledImage(i50.getImage(), 50, 40),
						moneyValues[i] + "", Intro.blackM, Position.BOTTOM_RIGHT, Intro.myFontXS));
				break;
			case 2:
				panelFoto[i].setIcon(new IconWithText(ImageEffect.getScaledImage(i20.getImage(), 50, 40),
						moneyValues[i] + "", Intro.blackM, Position.BOTTOM_RIGHT, Intro.myFontXS));
				break;
			case 3:
				panelFoto[i].setIcon(new IconWithText(ImageEffect.getScaledImage(i10.getImage(), 50, 40),
						moneyValues[i] + "", Intro.blackM, Position.BOTTOM_RIGHT, Intro.myFontXS));
				break;
			case 4:
				panelFoto[i].setIcon(new IconWithText(ImageEffect.getScaledImage(i5.getImage(), 50, 40),
						moneyValues[i] + "", Intro.blackM, Position.BOTTOM_RIGHT, Intro.myFontXS));
				break;
			case 5:
				panelFoto[i].setIcon(new IconWithText(ImageEffect.getScaledImage(i2.getImage(), 50, 40),
						moneyValues[i] + "", Intro.blackM, Position.BOTTOM_RIGHT, Intro.myFontXS));
				break;
			case 6:
				panelFoto[i].setIcon(new IconWithText(ImageEffect.getScaledImage(i1.getImage(), 50, 40),
						moneyValues[i] + "", Intro.blackM, Position.BOTTOM_RIGHT, Intro.myFontXS));
				break;
			default:
				break;
			}
			moneyPhotoPanel.add(panelFoto[i]);
			moneyValuePanel.add(panelValue[i]);
		}
		moneyPanel.add(moneyPhotoPanel, BorderLayout.CENTER);
		moneyPanel.add(moneyValuePanel, BorderLayout.SOUTH);

		textPanel.add(northPanel, BorderLayout.NORTH);
		textPanel.add(messageLabel, BorderLayout.CENTER);
		textPanel.add(moneyPanel, BorderLayout.SOUTH);
		northPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0)); // Adds space below the icon
		messageLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 15, 0)); // Adds space above and below the
		moneyPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 8, 0)); // Adds space above and below the

		buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
		buttonPanel.setOpaque(false); // Transparent background for buttons

		// BUTTONS
		RoundButton yesButton = new RoundButton("OK", 10);
		yesButton.setFillColor(Intro.greenM);
		yesButton.setForeground(Intro.lightC);
		yesButton.setBorderColorAndRadius(fg);
		Component old = focusedComponent;
		yesButton.addActionListener(_ -> {
			overlay.hideOverlay();
			// Restore the focus back to the previously focused component
			if (focusedComponent != null) {
				old.requestFocusInWindow();
			}
			for (int index = 0; index < 8; index++) {
				if (!TextEffect.isInteger(panelValue[index].getText()))
					panelValue[index].setText("0");
				else if (Integer.valueOf(panelValue[index].getText()) > moneyValues[index]) {
					Intro.startBorderAnimation(panelValue[index]);
					panelValue[index].setText(moneyValues[index] + "");
				} else
					totalSep = Integer.valueOf(panelValue[0].getText()) * 100
							+ Integer.valueOf(panelValue[1].getText()) * 50
							+ Integer.valueOf(panelValue[2].getText()) * 20
							+ Integer.valueOf(panelValue[3].getText()) * 10
							+ Integer.valueOf(panelValue[4].getText()) * 5
							+ Integer.valueOf(panelValue[5].getText()) * 2
							+ Integer.valueOf(panelValue[6].getText()) * 1;
			}
			if (totalSep != 0) {
				if (conf[1] == null || conf[1].equalsIgnoreCase("null") || conf[1].equals("false"))
					soundEffect(enterSound);
				copyToClipboard(totalSep + "");
				dialog.dispose();
			} else
				dialog.dispose();
		});
		buttonPanel.add(yesButton);

		// Spacing
		textPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 8, 0)); // Adds space above and below the
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(8, 0, 0, 0)); // Adds space above the button panel

		panel.add(textPanel, BorderLayout.NORTH); // Icon on top
		panel.add(buttonPanel, BorderLayout.SOUTH);
		dialog.add(panel);

		// Adjust dialog size based on the message height
		dialog.pack(); // Adjust size to fit content
		int messageHeight = textPanel.getPreferredSize().height;
		int buttonPanelHeight = buttonPanel.getPreferredSize().height;

		// Calculate preferred width based on the buttons
		int totalWidth = 0;
		for (Component button : buttonPanel.getComponents()) {
			totalWidth += button.getPreferredSize().width;
		}
		int totalButtonWidth = totalWidth + (buttonPanel.getComponentCount() - 1) * 20;
		int messageWidth = textPanel.getPreferredSize().width;

		int dialogWidth = Math.max(totalButtonWidth, messageWidth) + 60; // Add padding
		int dialogHeight = messageHeight + buttonPanelHeight + 60; // Add padding for margins

		dialog.setSize(dialogWidth, dialogHeight);

		// Update rounded shape based on new size
		dialog.setShape(new RoundRectangle2D.Double(0, 0, dialogWidth, dialogHeight, 20, 20));

		// Set position
		dialog.setLocationRelativeTo(this);

		// Key listener to close the dialog on Esc key press
		dialog.getRootPane().setDefaultButton(yesButton);
		dialog.setVisible(true);
		return values;

	}

	/* The ammount of money we separate with the date */
	private void separadosFrame() {
		JDialog separadoDialog = new JDialog(this, getLocalizedMessage("SEP"), true);
		separadoDialog.setSize(614, 614);
		separadoDialog.setLocationRelativeTo(null);
		separadoDialog.setResizable(false);
		separadoDialog.setLayout(null);

		JFormattedTextField[][] sepLabel = new JFormattedTextField[14][3];
		JLabel titleSep[] = new JLabel[3];
		JLabel totalSep = new JLabel("T O T A L");
		importSep();
		int k = 0, temp_value = 0;
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 0) {
					titleSep[j] = new JLabel();
					titleSep[j].setBounds(0 + 199 * j, 0, 200, 50);
					titleSep[j].setFont(new Font("Tahoma", Font.BOLD, 20));
					titleSep[j].setForeground(Intro.blackM);
					titleSep[j].setBackground(Intro.grisD);
					titleSep[j].setOpaque(true);
					titleSep[j].setHorizontalAlignment(0);
					titleSep[j].setBorder(new LineBorder(fg, 1));
					separadoDialog.add(titleSep[j]);
				}
				int indexX = i, indexY = j;
				sepLabel[i][j] = new JFormattedTextField(sepData[k++]);
				sepLabel[i][j].addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent ke) {
						if (indexY == 2 && (ke.getKeyCode() == KeyEvent.VK_T
								&& (ke.getModifiers() & InputEvent.CTRL_MASK) != 0)) {
							sepLabel[indexX][2].setText(currentDate.getToday());
						} else if (indexY == 2 && (ke.getKeyCode() == KeyEvent.VK_Y
								&& (ke.getModifiers() & InputEvent.CTRL_MASK) != 0)) {
							sepLabel[indexX][2].setText(currentDate.getYesterday());
						} else if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
							try {
								dataFolder.mkdir();
								File tempFile1 = new File(dataFolder + "\\extra");
								tempFile1.mkdir();
								File sepFile = new File(tempFile1, "SEP" + ".dll");
								FileWriter savedF = new FileWriter(sepFile);
								for (int i = 0; i < 14; i++)
									for (int j = 0; j < 3; j++) {
										if (sepLabel[i][j].getText().equalsIgnoreCase("--/--/----"))
											savedF.write(System.lineSeparator());
										else
											savedF.write(
													encrypt.encrypt(sepLabel[i][j].getText()) + System.lineSeparator());
									}
								savedF.close();
								/* Copy the last negative value */
								int LAST_ITEM = 0;
								while (LAST_ITEM < 14 && !sepLabel[0][0].getText().isBlank()) {
									if (sepLabel[LAST_ITEM][0].getText().isBlank()) {
										if (TextEffect.isInteger(sepLabel[LAST_ITEM - 1][0].getText())) {
											if (Integer.valueOf(sepLabel[LAST_ITEM - 1][0].getText()) < 0)
												copyToClipboard(
														(-1 * Integer.valueOf(sepLabel[LAST_ITEM - 1][0].getText()))
																+ "");
										}
										break;
									}
									LAST_ITEM++;
								}
								if (LAST_ITEM == 14)
									if (TextEffect.isInteger(sepLabel[13][0].getText())) {
										if (Integer.valueOf(sepLabel[13][0].getText()) < 0)
											copyToClipboard((-1 * Integer.valueOf(sepLabel[13][0].getText())) + "");
									}
								/* ScreenShoot of Separated */
								dataFolder.mkdir();
								File yearFolder = new File(dataFolder + "\\" + yearS);
								yearFolder.mkdir();
								File monthFolder = new File(yearFolder + "\\" + currentDate.m + "-" + monthS);
								monthFolder.mkdir();
								File sepFolder = new File(monthFolder + "\\IMG");
								sepFolder.mkdir();
								File sepImg = new File(sepFolder + "\\SEP");
								sepImg.mkdir();
								File newFile = new File(sepImg, "Sep " + currentDate.weekNumber() + ".png");
								Boolean alreadyNewDay = isNewDayExisted();
								if (dayName(currentDate, 2).equalsIgnoreCase("saturday") && alreadyNewDay
										&& !newFile.exists()) {
									Container contentPane = separadoDialog.getContentPane();
									Point loc = contentPane.getLocationOnScreen();
									Dimension size = contentPane.getSize();
									Rectangle captureArea = new Rectangle(loc.x, loc.y, size.width, size.height);
									BufferedImage screenshot = new Robot().createScreenCapture(captureArea);
									ImageIO.write(screenshot, "png", newFile);
									/* Calculate the total */
									int temp_value = 0;
									for (int i = 0; i < 14; i++)
										temp_value += (TextEffect.isInteger(sepLabel[i][0].getText())
												? Integer.valueOf(sepLabel[i][0].getText())
												: 0);
									/* Clean the values for next week */
									FileWriter newSep = new FileWriter(sepFile);
									newSep.write(encrypt.encrypt(temp_value + "") + System.lineSeparator());
									newSep.write(
											encrypt.encrypt(getLocalizedMessage("LAST_WEEK")) + System.lineSeparator());
									datePicker.setSelectedDate(LocalDate.now());
									newSep.write(encrypt.encrypt(datePicker.getSelectedDateAsString())
											+ System.lineSeparator());
									for (int k = 1; k < 14; k++)
										for (int j = 0; j < 3; j++)// save it encrypted
											newSep.write("" + System.lineSeparator());
									newSep.close();
								}
							} catch (Exception e2) {
								writeError(e2);
							}
							separadoDialog.dispose();
						} else if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
							if (indexY < 2) {
								sepLabel[indexX][indexY].setNextFocusableComponent(sepLabel[indexX][indexY + 1]);
								sepLabel[indexX][indexY].nextFocus();
							} else {
								sepLabel[indexX][indexY].setNextFocusableComponent(sepLabel[indexX][0]);
								sepLabel[indexX][indexY].nextFocus();
							}
						} else if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
							if (indexY > 0) {
								sepLabel[indexX][indexY].setNextFocusableComponent(sepLabel[indexX][indexY - 1]);
								sepLabel[indexX][indexY].nextFocus();
							} else {
								sepLabel[indexX][indexY].setNextFocusableComponent(sepLabel[indexX][2]);
								sepLabel[indexX][indexY].nextFocus();
							}
						} else if (ke.getKeyCode() == KeyEvent.VK_UP) {
							if (indexX > 0) {
								sepLabel[indexX][indexY].setNextFocusableComponent(sepLabel[indexX - 1][indexY]);
								sepLabel[indexX][indexY].nextFocus();
							} else {
								sepLabel[indexX][indexY].setNextFocusableComponent(sepLabel[13][indexY]);
								sepLabel[indexX][indexY].nextFocus();
							}
						} else if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
							if (indexX < 13) {
								sepLabel[indexX][indexY].setNextFocusableComponent(sepLabel[indexX + 1][indexY]);
								sepLabel[indexX][indexY].nextFocus();
							} else {
								sepLabel[indexX][indexY].setNextFocusableComponent(sepLabel[0][indexY]);
								sepLabel[indexX][indexY].nextFocus();
							}
						}
					}
				});
				sepLabel[i][j].setBounds(0 + 199 * j, 49 + 34 * i, 200, 35);
				sepLabel[i][j].setFont(new Font("Tahoma", Font.BOLD, 18));
				sepLabel[i][j].setForeground(fg);
				sepLabel[i][j].setBackground(bg);
				sepLabel[i][j].setBorder(new LineBorder(fg, 1));
				sepLabel[i][j].setHorizontalAlignment(0);
				sepLabel[i][j].addFocusListener(new FocusAdapter() {
					@Override
					public void focusLost(FocusEvent e) {
						int temp_value = 0;
						for (int i = 0; i < 14; i++) {
							sepLabel[i][1].setText(TextEffect.capitalizeString(sepLabel[i][1].getText()));
							TextEffect.adjustFontSize(sepLabel[i][1]);
							/* Make the positive values green and the negative one red */
							if (TextEffect.isInteger(sepLabel[i][0].getText())) {
								if (Integer.valueOf(sepLabel[i][0].getText()) > 0) {
									for (int j = 0; j < 3; j++) {
										sepLabel[i][j].setBackground(Intro.greenC);
										sepLabel[i][j].setForeground(Intro.greenM);
									}
								} else {
									for (int j = 0; j < 3; j++) {
										sepLabel[i][j].setBackground(Intro.redC);
										sepLabel[i][j].setForeground(Intro.redM);
									}
								}
							} else {
								for (int j = 0; j < 3; j++) {
									sepLabel[i][j].setForeground(fg);
									sepLabel[i][j].setBackground(bg);
								}
							}
							/* Calculate the total */
							temp_value += (TextEffect.isInteger(sepLabel[i][0].getText())
									? Integer.valueOf(sepLabel[i][0].getText())
									: 0);
						}
						totalSep.setText("$" + temp_value);
					}

					@Override
					public void focusGained(FocusEvent e) {
						// Select all text in the specific JFormattedTextField that gained focus
						JFormattedTextField field = (JFormattedTextField) e.getSource();
						SwingUtilities.invokeLater(field::selectAll);
					}
				});
				separadoDialog.add(sepLabel[i][j]);
			}
			datePicker = new DatePicker();
			datePicker.now();
			datePicker.setEditor(sepLabel[i][2]);
			datePicker.setDateSelectionMode(DatePicker.DateSelectionMode.SINGLE_DATE_SELECTED);
			datePicker.setUsePanelOption(true);
			datePicker.setCloseAfterSelected(true);
			datePicker.setEditorValidation(true);
			datePicker.setValidationOnNull(true);
		}
		for (int i = 0; i < 14; i++)
			temp_value += (TextEffect.isInteger(sepLabel[i][0].getText()) ? Integer.valueOf(sepLabel[i][0].getText())
					: 0);
		totalSep.setText("$" + temp_value);
		totalSep.setBounds(0, 525, 598, 50);
		totalSep.setFont(new Font("Tahoma", Font.BOLD, 24));
		totalSep.setForeground(Intro.blackM);
		totalSep.setBackground(whiteC);
		totalSep.setOpaque(true);
		totalSep.setHorizontalAlignment(0);
		totalSep.setBorder(new LineBorder(fg, 1));
		separadoDialog.add(totalSep);
		titleSep[0].setText(getLocalizedMessage("HOW_MUCH"));
		titleSep[1].setText(getLocalizedMessage("DESC"));
		titleSep[2].setText(getLocalizedMessage("DATE"));

		/* Make the positive values green and the negative one red */
		int position = 0;
		for (int i = 0; i < 14; i++) {
			if (!sepLabel[i][0].getText().isBlank())
				position = i;
			/* Make the positive values green and the negative one red */
			if (TextEffect.isInteger(sepLabel[i][0].getText())) {
				if (Integer.valueOf(sepLabel[i][0].getText()) > 0) {
					for (int j = 0; j < 3; j++) {
						sepLabel[i][j].setBackground(Intro.greenC);
						sepLabel[i][j].setForeground(Intro.greenM);
					}
				} else {
					for (int j = 0; j < 3; j++) {
						sepLabel[i][j].setBackground(Intro.redC);
						sepLabel[i][j].setForeground(Intro.redM);
					}
				}
			} else {
				for (int j = 0; j < 3; j++) {
					sepLabel[i][j].setForeground(fg);
					sepLabel[i][j].setBackground(bg);
				}
			}
		}

		// If close stop the timer
		InitialFocusSetter.setInitialFocus(separadoDialog, sepLabel[position == 13 ? 0 : position + 1][0]);
		separadoDialog.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent we) {
				try {// save the results
					dataFolder.mkdir();
					File tempFile1 = new File(dataFolder + "\\extra");
					tempFile1.mkdir();
					File sepFile = new File(tempFile1, "SEP" + ".dll");
					FileWriter savedF = new FileWriter(sepFile);
					for (int i = 0; i < 14; i++)
						for (int j = 0; j < 3; j++) {
							if (sepLabel[i][j].getText().equalsIgnoreCase("--/--/----"))
								savedF.write(System.lineSeparator());
							else
								savedF.write(encrypt.encrypt(sepLabel[i][j].getText()) + System.lineSeparator());
						}
					savedF.close();
					/* Copy the last value */
					int LAST_ITEM = 0;
					while (LAST_ITEM < 14 && !sepLabel[0][0].getText().isBlank()) {
						if (sepLabel[LAST_ITEM][0].getText().isBlank()) {
							if (Integer.valueOf(sepLabel[LAST_ITEM - 1][0].getText()) < 0)
								copyToClipboard((-1 * Integer.valueOf(sepLabel[LAST_ITEM - 1][0].getText())) + "");
							break;
						}
						LAST_ITEM++;
					}
					if (LAST_ITEM == 14)
						if (TextEffect.isInteger(sepLabel[13][0].getText())) {
							if (Integer.valueOf(sepLabel[13][0].getText()) < 0)
								copyToClipboard((-1 * Integer.valueOf(sepLabel[13][0].getText())) + "");
						}
					/* ScreenShoot of Separated */
					File yearFolder = new File(dataFolder + "\\" + yearS);
					yearFolder.mkdir();
					File monthFolder = new File(yearFolder + "\\" + currentDate.m + "-" + monthS);
					monthFolder.mkdir();
					File sepFolder = new File(monthFolder + "\\IMG");
					sepFolder.mkdir();
					File sepImg = new File(sepFolder + "\\SEP");
					sepImg.mkdir();
					File newFile = new File(sepImg, "Sep " + currentDate.weekNumber() + ".png");
					Boolean alreadyNewDay = isNewDayExisted();
					if (dayName(currentDate, 2).equalsIgnoreCase("saturday") && alreadyNewDay && !newFile.exists()) {
						Container contentPane = separadoDialog.getContentPane();
						Point loc = contentPane.getLocationOnScreen();
						Dimension size = contentPane.getSize();
						Rectangle captureArea = new Rectangle(loc.x, loc.y, size.width, size.height);
						BufferedImage screenshot = new Robot().createScreenCapture(captureArea);
						ImageIO.write(screenshot, "png", newFile);
						/* Calculate the total */
						int temp_value = 0;
						for (int i = 0; i < 14; i++)
							temp_value += (TextEffect.isInteger(sepLabel[i][0].getText())
									? Integer.valueOf(sepLabel[i][0].getText())
									: 0);
						/* Clean the values for next week */
						FileWriter newSep = new FileWriter(sepFile);
						newSep.write(encrypt.encrypt(temp_value + "") + System.lineSeparator());
						newSep.write(encrypt.encrypt(getLocalizedMessage("LAST_WEEK")) + System.lineSeparator());
						datePicker.setSelectedDate(LocalDate.now());
						newSep.write(encrypt.encrypt(datePicker.getSelectedDateAsString()) + System.lineSeparator());
						for (int k = 1; k < 14; k++)
							for (int j = 0; j < 3; j++)// save it encrypted
								newSep.write("" + System.lineSeparator());
						newSep.close();
					}
				} catch (Exception e4) {
					writeError(e4);
				}
			}

		});
		separadoDialog.setIconImage(colorSelected == 2 ? ImageEffect.getScaledImage(sepI.getImage(), 35, 35).getImage()
				: ImageEffect.invertColor(ImageEffect.getScaledImage(sepI.getImage(), 35, 35)).getImage());
		separadoDialog.setVisible(true);
	}

	/* saveProgress */
	private static void saveProgress() {
		try {
			String currentpath = System.getProperty("user.dir");
			File dataFolder = new File(currentpath + "\\data");
			dataFolder.mkdir();
			File dataFile = new File(dataFolder, "index.dll");
			FileWriter savedF = new FileWriter(dataFile);
			for (int i = 0; i < 6; i++)
				for (int j = 0; j < 20; j++)
					savedF.write(details[i][j].getText() + System.lineSeparator());
			savedF.write(initialDay.getText() + System.lineSeparator());
			for (int i = 0; i < 16; i++)
				savedF.write(gastosTable[i].getText() + System.lineSeparator());
			for (int i = 0; i < 16; i++)
				savedF.write(agregadoTable[i].getText() + System.lineSeparator());
			for (int i = 0; i < 8; i++)
				savedF.write(panelCnum[i].getText() + System.lineSeparator());
			savedF.close();
		} catch (Exception e) {
		}
		if (!details[0][0].isVisible()) {
			try {
				String currentpath = System.getProperty("user.dir");
				File dataFolder = new File(currentpath + "\\data");
				dataFolder.mkdir();
				File extraFolder = new File(dataFolder + "\\extra");
				extraFolder.mkdir();
				File sepFile = new File(extraFolder, "indexM" + ".dll");
				FileWriter savedF = new FileWriter(sepFile);
				for (int i = 0; i < 6; i++)
					for (int j = 0; j < 20; j++)
						savedF.write(detailsM[i][j].getText() + System.lineSeparator());
				savedF.close();
			} catch (Exception e) {
			}
		}
	}

	/* Open Progress */
	private void openProgress() {
		BufferedReader dataOpened = null;
		String line = "";
		int z = 0;
		String numbers[] = new String[165];
		dataFolder.mkdir();
		File dataFile = new File(dataFolder, "index.dll");
		try {
			if (!dataFile.exists())
				dataFile.createNewFile();
			dataOpened = new BufferedReader(new FileReader(dataFile));
			while ((line = dataOpened.readLine()) != null) {
				numbers[z] = line.toString();
				z++;
			}
			z = 0;
			for (int i = 0; i < 6; i++)
				for (int k = 0; k < 20; k++) {
					details[i][k].setText(numbers[z]);
					z++;
				}
			initialDay.setText(numbers[z]);
			z++;
			for (int i = 0; i < 16; i++) {
				gTable[i].setText(numbers[z]);
				gastosTable[i].setText(numbers[z]);
				z++;
			}
			for (int i = 0; i < 16; i++) {
				aTable[i].setText(numbers[z]);
				agregadoTable[i].setText(numbers[z]);
				z++;
			}
			for (int i = 0; i < 8; i++) {
				panelCnum[i].setText(numbers[z]);
				z++;
			}
			dataOpened.close();
		} catch (Exception e) {
			writeError(e);
		}
		dataOpened = null;
		line = "";
		z = 0;
		String valuesMas[] = new String[121];
		File extraFolder = new File(dataFolder + "\\extra");
		extraFolder.mkdir();
		File sepFile = new File(extraFolder, "indexM.dll");
		try {
			if (!sepFile.exists())
				sepFile.createNewFile();
			dataOpened = new BufferedReader(new FileReader(sepFile));
			while ((line = dataOpened.readLine()) != null) {
				valuesMas[z] = line.toString();
				z++;
			}
			z = 0;
			for (int i = 0; i < 6; i++)
				for (int j = 0; j < 20; j++)
					detailsM[i][j].setText(valuesMas[z++]);
			dataOpened.close();
		} catch (Exception e) {
			writeError(e);
		}
	}

	/* Calculate everything */
	private void sumF() {
		pixMore.setBounds(panelFoto[7].getX(), panelFoto[7].getY() - 8, getWidth() / 21, 9);
		diffResult.setBounds(total[7].getX(), total[7].getY() + 10, total[7].getWidth(), 50);
		int ventaTemp = totalVenta;
		for (int i = 0; i < 4; i++) {
			gTable[i].setText(gastosTable[i].getText());
			aTable[i].setText(agregadoTable[i].getText());
		}
		for (int i = 8; i < 12; i++) {
			gTable[i].setText(gastosTable[i].getText());
			aTable[i].setText(agregadoTable[i].getText());
		}
		if (conf[4] == null || conf[4].equals("false"))
			saveProgress();
		for (int i = 0; i < 8; i++)// Caja empty values 0
			if (!TextEffect.isInteger(panelCnum[i].getText())
					|| (TextEffect.isInteger(panelCnum[i].getText()) && Integer.valueOf(panelCnum[i].getText()) < 0))
				panelCnum[i].setText(0 + "");
		if (!TextEffect.isInteger(initialDay.getText())
				|| (TextEffect.isInteger(initialDay.getText()) && Integer.valueOf(initialDay.getText()) < 0))
			initialDay.setText(0 + "");
		for (int i = 8; i < 16; i++)// spent 0
			if (!TextEffect.isInteger(gastosTable[i].getText()) || (TextEffect.isInteger(gastosTable[i].getText())
					&& Integer.valueOf(gastosTable[i].getText()) < 0))
				gastosTable[i].setText("");
		for (int i = 8; i < 16; i++)// added 0
			if (!TextEffect.isInteger(agregadoTable[i].getText()) || (TextEffect.isInteger(agregadoTable[i].getText())
					&& Integer.valueOf(agregadoTable[i].getText()) < 0))
				agregadoTable[i].setText("");
		for (int i = 0; i < 8; i++) {// TitleCase gastos and agg
			gastosTable[i].setText(TextEffect.capitalizeString(gastosTable[i].getText()));
			gTable[i].setText(TextEffect.capitalizeString(gTable[i].getText()));
			agregadoTable[i].setText(TextEffect.capitalizeString(agregadoTable[i].getText()));
			aTable[i].setText(TextEffect.capitalizeString(aTable[i].getText()));
			gastosTable[i].setFont(Intro.myFont);
			agregadoTable[i].setFont(Intro.myFont);
			gTable[i].setFont(Intro.myFont);
			aTable[i].setFont(Intro.myFont);
			TextEffect.adjustFontSize(gastosTable[i]);
			TextEffect.adjustFontSize(gTable[i]);
			TextEffect.adjustFontSize(agregadoTable[i]);
			TextEffect.adjustFontSize(aTable[i]);
		}
		for (int i = 8; i < 16; i++) {
			gastosTable[i].setFont(Intro.myFontS);
			agregadoTable[i].setFont(Intro.myFontS);
			gTable[i].setFont(Intro.myFontS);
			aTable[i].setFont(Intro.myFontS);
			TextEffect.adjustFontSize(gastosTable[i]);
			TextEffect.adjustFontSize(gTable[i]);
			TextEffect.adjustFontSize(agregadoTable[i]);
			TextEffect.adjustFontSize(aTable[i]);
		}
		// Calculate the totals
		totalVenta = 0;
		for (int i = 0; i < 6; i++) {
			totalCol = 0;
			for (int j = 0; j < 20; j++) {
				String text = details[i][j].getText();
				int value = TextEffect.isInteger(text) ? Integer.valueOf(text) : -1;
				if (value >= 0) {
					totalCol += value;
				} else {
					details[i][j].setText("");
				}
			}
			total[i].setText(totalCol + "");
			totalVenta += totalCol;
		}
		if (conf[17].equals("true"))
			notificationButton.setVisible(false);
		else if (isBlured)
			notificationButton.setVisible(false);
		else {
			notificationButton.setVisible(true);
			/* Notification */
			int notCount = notificationCount();
			if (colorSelected == 2) {
				badgeIcon = ImageEffect
						.changeOpacity(BadgeIconGenerator.generateBadgeIcon(notIcon, notCount).getImage(), 0.5f);
				notificationButton.setIcon(badgeIcon);
			} else {
				badgeIcon = ImageEffect.changeOpacity(
						BadgeIconGenerator.generateBadgeIcon(ImageEffect.invertColor(notIcon), notCount).getImage(),
						0.5f);
				notificationButton.setIcon(badgeIcon);
			}
		}
		if (checkIfFull()) {
			if (isBlured)
				moreCases.setVisible(false);
			else
				moreCases.setVisible(true);
			for (int i = 0; i < 6; i++) {
				totalCol = 0;
				for (int j = 0; j < 20; j++) {
					String text = detailsM[i][j].getText();
					int value = TextEffect.isInteger(text) ? Integer.valueOf(text) : -1;
					if (value >= 0) {
						totalCol += value;
					} else {
						detailsM[i][j].setText("");
					}
				}
				if (!details[0][0].isVisible())
					total[i].setText(totalCol + "");
				totalVenta += totalCol;
			}
		} else {
			moreCases.setVisible(false);
		}
		total[6].setText("$" + totalVenta);
		// check if we sold something
		if (totalVenta != ventaTemp && status) {
			dataFolder.mkdir();
			File logFolder = new File(dataFolder + "\\LOG");
			logFolder.mkdir();
			File logToday = new File(logFolder, "log.txt");
			File lastChangeF = new File(logFolder, dayN + currentDate.m + currentDate.y);
			/* open already file */
			BufferedReader logOpened = null;
			String line = "";
			int z = 0;
			String numbers[] = new String[121];
			/* change the last update */
			lastChange.setText(getLocalizedMessage("LAST_UPDATE")
					+ new SimpleDateFormat("HH").format(Calendar.getInstance().getTime()) + ":"
					+ new SimpleDateFormat("mm").format(Calendar.getInstance().getTime()) + ":"
					+ new SimpleDateFormat("ss").format(Calendar.getInstance().getTime()));
			try {
				FileWriter lastChangeW = new FileWriter(lastChangeF);
				lastChangeW.write(new SimpleDateFormat("HH").format(Calendar.getInstance().getTime()) + ":"
						+ new SimpleDateFormat("mm").format(Calendar.getInstance().getTime()) + ":"
						+ new SimpleDateFormat("ss").format(Calendar.getInstance().getTime()));
				lastChangeW.close();
			} catch (Exception e) {
				writeError(e);
			}
			try {
				if (!logToday.exists())
					logToday.createNewFile();
				logOpened = new BufferedReader(new FileReader(logToday));
				while ((line = logOpened.readLine()) != null) {
					numbers[z] = line.toString();
					z++;
				}
				logOpened.close();
			} catch (Exception e) {
				writeError(e);
			}
			try {
				FileWriter logFile = new FileWriter(logToday);
				z = 0;
				for (int i = 0; i < 6; i++)
					for (int j = 0; j < 20; j++) {
						if (!details[i][j].getText().isBlank() && TextEffect.isInteger(details[i][j].getText()))
							if (numbers[z] == null)
								logFile.write(Integer.valueOf(details[i][j].getText()) + " - "
										+ new SimpleDateFormat("HH").format(Calendar.getInstance().getTime()) + ":"
										+ new SimpleDateFormat("mm").format(Calendar.getInstance().getTime()) + ":"
										+ new SimpleDateFormat("ss").format(Calendar.getInstance().getTime())
										+ System.lineSeparator());
							else
								logFile.write(numbers[z] + System.lineSeparator());
						z++;
					}
				logFile.close();
			} catch (Exception e) {
				writeError(e);
			}
		}
		// Calculate total of spent
		gastosT = ((gastosTable[8].getText().equals("") ? 0 : Integer.valueOf(gastosTable[8].getText()))
				+ (gastosTable[9].getText().equals("") ? 0 : Integer.valueOf(gastosTable[9].getText()))
				+ (gastosTable[10].getText().equals("") ? 0 : Integer.valueOf(gastosTable[10].getText()))
				+ (gastosTable[11].getText().equals("") ? 0 : Integer.valueOf(gastosTable[11].getText()))
				+ (gastosTable[12].getText().equals("") ? 0 : Integer.valueOf(gastosTable[12].getText()))
				+ (gastosTable[13].getText().equals("") ? 0 : Integer.valueOf(gastosTable[13].getText()))
				+ (gastosTable[14].getText().equals("") ? 0 : Integer.valueOf(gastosTable[14].getText()))
				+ (gastosTable[15].getText().equals("") ? 0 : Integer.valueOf(gastosTable[15].getText())));
		summaryT[5].setText("" + gastosT);
		// Calculate total of added
		agregadoT = ((agregadoTable[8].getText().equals("") ? 0 : Integer.valueOf(agregadoTable[8].getText()))
				+ (agregadoTable[9].getText().equals("") ? 0 : Integer.valueOf(agregadoTable[9].getText()))
				+ (agregadoTable[10].getText().equals("") ? 0 : Integer.valueOf(agregadoTable[10].getText()))
				+ (agregadoTable[11].getText().equals("") ? 0 : Integer.valueOf(agregadoTable[11].getText()))
				+ (agregadoTable[12].getText().equals("") ? 0 : Integer.valueOf(agregadoTable[12].getText()))
				+ (agregadoTable[13].getText().equals("") ? 0 : Integer.valueOf(agregadoTable[13].getText()))
				+ (agregadoTable[14].getText().equals("") ? 0 : Integer.valueOf(agregadoTable[14].getText()))
				+ (agregadoTable[15].getText().equals("") ? 0 : Integer.valueOf(agregadoTable[15].getText())));
		summaryT[6].setText("" + agregadoT);
		summaryT[7].setText("" + totalVenta);// Total of sells
		// Calculate total
		totalO = ((initialDay.getText().equals("") ? 0 : Integer.valueOf(initialDay.getText())) - gastosT + agregadoT
				+ totalVenta);
		summaryT[8].setText("" + totalO);
		// Calculate total of caja
		totalCaja = ((panelCnum[0].getText().equals("") ? 0 : Integer.valueOf(panelCnum[0].getText()) * 100)
				+ (panelCnum[1].getText().equals("") ? 0 : Integer.valueOf(panelCnum[1].getText()) * 50)
				+ (panelCnum[2].getText().equals("") ? 0 : Integer.valueOf(panelCnum[2].getText()) * 20)
				+ (panelCnum[3].getText().equals("") ? 0 : Integer.valueOf(panelCnum[3].getText()) * 10)
				+ (panelCnum[4].getText().equals("") ? 0 : Integer.valueOf(panelCnum[4].getText()) * 5)
				+ (panelCnum[5].getText().equals("") ? 0 : Integer.valueOf(panelCnum[5].getText()) * 2)
				+ (panelCnum[6].getText().equals("") ? 0 : Integer.valueOf(panelCnum[6].getText()) * 1)
				+ (panelCnum[7].getText().equals("") ? 0 : Integer.valueOf(panelCnum[7].getText()) * 1));
		total[7].setText("$" + totalCaja);
		// Calculate the diferencia
		if (totalCaja == totalO) {
			diffResult.setText(getLocalizedMessage("NO_DIFFERENCE"));
			diffResult.setCircleColor(greenC);
			diffResult.setForeground(Color.black);
		} else {
			if (totalCaja > totalO) {
				diffResult.setText(getLocalizedMessage("MORE_DIFF") + (totalCaja - totalO));
				diffResult.setCircleColor(orangeC);
				diffResult.setForeground(Color.black);
			} else {
				diffResult.setText(getLocalizedMessage("LESS_DIFF") + (totalO - totalCaja));
				diffResult.setCircleColor(redC);
				diffResult.setForeground(Color.black);
			}
		}
		// Calculate the restTmrw
		restN = totalCaja - Integer.valueOf(panelCnum[0].getText()) * 100 - Integer.valueOf(panelCnum[1].getText()) * 50
				- Integer.valueOf(panelCnum[2].getText()) * 20;
	}

	/* Return a text according to the language */
	private String getLocalizedMessage(String key) {
		switch (language) {
		case SPANISH:
			return switch (key.toUpperCase()) {
			case "SHORTKEY" -> "• CTRL + S → ir la fatura.\n" + "• CTRL + P → ir al pesos.\n"
					+ "• CTRL + B → borrar todo.\n" + "• CTRL + N → prepárate para el día siguiente.\n"
					+ "• FLECHAS → subir, abajo, derecha e izquierda.\n" + "• CTRL + D → ir al detalles.\n"
					+ "• CTRL + I → ir al inicio.\n" + "• CTRL + G → ir al gastos.\n" + "• CTRL + A → ir al agregado.\n"
					+ "• CTRL + T → ir a la caja.\n" + "• CTRL + E → ir al ultimo numero.\n"
					+ "• CTRL + M → mas un 100 o de 1000 si posible.\n" + "• CTRL + C → abrir el configuración.\n"
					+ "• ALT + - → Abrir la calculadora.\n" + "• CTRL + L → Bloquear el aplicativo.\n"
					+ "• ALT + P → Tomar una captura de pantalla.\n" + "• CTRL + 0 → Minimizar la aplicación.\n"
					+ "• CTRL + R → Abrir el panel recordarme.\n" + "• CTRL + W → cerrar el aplicativo.";
			case "KEYS" -> "ATAJOS DE TECLADO";
			case "CREDIT" -> "CRÉDITO Y DISEÑADO POR MHMDSABDLH ©";
			case "ABOUT" -> "ESTA APLICACIÓN ESTÁ DISEÑADA PARA HACER LA CAJA DE HADI-TECH";
			case "SETTING" -> "CONFIGURACIÓN";
			case "SAVE" -> "GUARDAR";
			case "YES" -> "SI";
			case "NO" -> "NO";
			case "IS" -> "ES EL";
			case "EXIT_Q" -> "¿SEGURO QUE QUIERES SALIR?";
			case "FILE" -> "ARCHIVO";
			case "EXIT" -> "SALIR";
			case "YEW_W" -> "SI /NUEVO DIA";
			case "EXP_RESULT" -> "¿GUARDAR EL RESUMEN DEL DÍA?";
			case "NEWDAY" -> "NUEVO DIA";
			case "CLEAR_Q" -> "¿QUIERES BORRAR TODO?";
			case "CLEAR" -> "BORRAR TODO";
			case "NO_DIFFERENCE" -> "<html><center>NO HAY DIFERENCIA</html>";
			case "MORE_DIFF" -> "SOBRÓ $";
			case "LESS_DIFF" -> "FALTÓ $";
			case "NO_SET" -> "NO HAY NADA PARA ARMAR!";
			case "SCREENSHOT" -> "CAPTURA DE PANTALLA";
			case "SCREENSHOT_A" -> "LA CAPTURA DE PANTALLA SE TOMA CON ÉXITO";
			case "SAVE_A" -> "SALVADO CON ÉXITO, GRACIAS";
			case "TITLE" -> "CIERRE DE CAJA - $";
			case "ABOUTME" -> "SOBRE MI";
			case "ABOUTAPP" -> "SOBRE EL APLICATIVO";
			case "SPENT" -> "GASTOS";
			case "AGG" -> "AGREGADOS";
			case "SEP" -> "SEPARADOS";
			case "MONTH_SUM" -> "REVISIÓN DEL MES";
			case "OTHER" -> "OTROS";
			case "HOW_MUCH" -> "CUANTO";
			case "DATE" -> "FECHA";
			case "YEAR_SUMM" -> "REVISIÓN DEL AÑO";
			case "MORE" -> "MÁS";
			case "LOCK" -> "BLOQUEAR LA APP";
			case "THEME" -> "TEMA";
			case "DESC" -> "DESCRIPCIÓN";
			case "CANNOT_UNDO" -> "¡ESTO NO SE PUEDE DESHACER!";
			case "OVERWRITE" -> "YA EXISTE UN ARCHIVO, LO SOBRESCRIBIRÁS";
			case "NOTE" -> "NOTA DE HOY";
			case "SEP_Q" -> "¿CÓMO QUIERES SEPARAR EL DINERO?";
			case "CUSTOM" -> "PERSONALIZADO";
			case "EMPTY" -> "UN VALOR VACÍO PARA SALTARLO";
			case "LAST_WEEK" -> "Semana Pasada";
			case "BILLS_TMRW" -> "LAS FACTURAS PARA MAÑANA: \n";
			case "SEPARAR_Q" -> "¿CUÁNTA QUIERES SEPARAR?";
			case "TRIES" -> "INTENTO RESTANTE: ";
			case "TRY_AGAIN" -> "INTENTA DE NUEVO";
			case "PASSWORD_W" -> "ESCRIBE LA CONTRASEÑA";
			case "BILLS" -> "FACTURAS";
			case "BILLS_O" -> "VER FACTURAS";
			case "BILLS_C" -> "EDITAR FACTURAS";
			case "LAST_UPDATE" -> "ÚLTIMA ACTUALIZACIÓN: ";
			case "INITIAL" -> "INICIO";
			case "SELL" -> "VENTAS";
			case "NOTIFICATION" -> "NOTIFICACIÓN";
			case "CALC" -> "ASUMAR";
			case "GO" -> "IR A";
			case "INVOICE" -> "FACTURA";
			case "Intro_FRAME" -> "PRIMER CUADRO";
			case "ANALYSE" -> "ANÁLISIS";
			case "SUMMARY" -> "SUMARIO";
			case "THIS_YEAR" -> "ESTE AÑO";
			case "DAILY_SUMMARY" -> "RESUMEN DEL DÍA";
			case "OLD_SUMMARY" -> "RESUMEN DE LOS PASADOS DÍAS";
			case "TODAY_SUMMARY" -> "RESUMEN DE HOY";
			case "EFFECT" -> "EFECTO";
			case "FADE" -> "APARIENCIA GRADUAL";
			case "WORD_WORD" -> "APARECE PALABRA POR PALABRA";
			case "LETTER_LETTER" -> "APARECE LETRA POR LETRA";
			case "SCRAMBLE" -> "LETRAS REVUELTAS";
			case "SPEED" -> "VELOCIDAD DE ANIMACIÓN";
			case "SLOW" -> "LENTO";
			case "MEDUIM" -> "MEDIANO";
			case "FAST" -> "RÁPIDO";
			case "GRAPH" -> "GRÁFICO";
			case "TODAY" -> "HOY";
			case "DAY" -> "DÍA";
			case "MONTH" -> "MES";
			case "YEAR" -> "AÑO";
			case "YESTERDAY" -> "AYER";
			case "LAST" -> "PASADO";
			case "ALL_YEAR" -> "TODOS LOS AÑOS";
			case "CALCULATOR" -> "CALCULADORA";
			case "HOLIDAY" -> "FERIADO";
			case "HOLIDAY_O" -> "VER VACACIONES";
			case "HOLIDAY_C" -> "EDITAR VACACIONES";
			case "NO_EVENT" -> "NO HAY NADA QUE MOSTRAR AQUÍ";
			case "CLEAR_CACHE" -> "LIMPIAR CACHÉ";
			case "CLEAN_S" -> "LIMPIEZA EXITOSAMENTE";
			case "CLEAN_U" -> "LIMPIEZA SIN ÉXITO";
			case "SECURITY" -> "SEGURIDAD";
			case "HELP" -> "AYUDA";
			case "INVOICE_T" -> "LAS FACTURAS PARA HOY: \n";
			case "LEGEND" ->
				"<span margin-right: 50px;'>Eje X: Dias</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ "<span margin-right: 50px;'>Eje Y: Ventas</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ "<span margin-right: 50px;'>No Punto: Cerrado</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ "<span margin-right: 50px;'>Punto Rojo: Valor Máximo</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ "<span margin-right: 50px;'>Línea Horizontal: Valor Promedio</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ "<span margin-right: 50px;'>Punto Azul: Valor Mínimo</span><br>" + "<br>";
			case "REVIEW_M" -> "¡REVISA EL DINERO EN LA CAJA!";
			case "THIS" -> "ESTA";
			case "WEEK" -> "SEMANA";
			case "UPDATE_C" -> "ATUALIZE A CAIXA";
			case "SHOW_ALL" -> "MONSTRAR TODO";
			case "BIRTHDAY" -> "CUMPLEAÑOS";
			case "BIRTHDAY_O" -> "VER CUMPLEAÑOS";
			case "BIRTHDAY_C" -> "EDITAR CUMPLEAÑOS";
			case "THIS_DAY" -> "OCASIÓN DE HOY";
			case "CLOSE_TIME" -> "YA ES CASI LA HORA DE CERRAR!\n\n" + "HAZ LA CAJA!";
			case "MONTH_E" -> "RESUMEN MENSUAL EXPORTADO CON ÉXITO";
			case "YEAR_E" -> "RESUMEN ANUAL EXPORTADO CON ÉXITO";
			case "EXP_TXT" -> "RESUMEN EXPORTADO CON ÉXITO";
			case "COPY_S" -> "COPIADO EXITOSAMENTE";
			case "COPY" -> "CLIC PARA COPIAR";
			case "HIDE/SHOW" -> "OCULTAR/MOSTRAR";
			case "HIDE_ALL" -> "OCULTAR TODO";
			case "KEYWORDS" -> "PALABRAS DE ATAJO";
			case "KEYWORDS_H" -> "AGREGAR ACCESO DIRECTO A LAS FACTURAS/AGREGADOS";
			case "STOCK_MAN" -> "GESTIÓN DE STOCK";
			case "VIEW_STOCK" -> "EXPLORAR STOCK";
			case "CHANGE_STOCK" -> "EDITAR STOCK*";
			case "DATE_STOCK" -> "AÑADIR STOCK";
			case "SALES_TRAKING" -> "GESTIÓN DE VENTAS";
			case "SEARCH_STOCK" -> "VENTAS DE MERCANCÍAS SEGÚN FECHA";
			case "SEARCH_DATES" -> "MERCANCÍA AÑADIDA SEGÚN FECHA";
			case "INVOICE_MAN" -> "GESTIÓN DE FACTURAS";
			case "ADD_STOCK" -> "FACTURAS DE HOY";
			case "OLD_INVOICES" -> "EXPLORAR FACTURAS ANTIGUAS";
			case "CATEGORY" -> "CATEGORÍA";
			case "QUANTITY" -> "CANTIDAD";
			case "PRICE" -> "PRECIO";
			case "UNIT_PRICE" -> "PRECIO DE COSTO";
			case "ADD" -> "AGREGAR";
			case "FILTER_P" -> "MOSTRAR ARTICULOS DISPONIBLES";
			case "FILTER_Z" -> "MOSTRAR ARTICULOS NO DISPONIBLES";
			case "FILTER_A" -> "MOSTRAR TODOS LOS ARTICULOS";
			case "FILTER_C" -> "FILTRAR POR CATEGORÍA";
			case "FILTER_S" -> "FILTRAR POR STOCK";
			case "SEARCH" -> "BUSCAR";
			case "UPDATE" -> "ACTUALIZAR";
			case "DELETE" -> "BORRAR";
			case "DATE_E" -> "NECESITAS SELECCIONAR FECHA";
			case "DATE_S" -> "FECHA SELECCIONADA";
			case "LOAD" -> "CARGAR";
			case "NO_DATA" -> "NO HAY DATOS PARA ESTA FECHA";
			case "OF" -> "DE";
			case "BETWEEN" -> "ENTER";
			case "ITEM_S" -> "ARTICULO SELECCIONADO";
			case "GRAPH_NOTE" -> "¡EL GRÁFICO FUNCIONA SOLO EN MESES Y AÑO!";
			case "ALL_TIME" -> "TODO EL TIEMPO";
			case "TOP_SELL" -> "MERCANCÍA MÁS VENDIDA";
			case "TOP_ITEMS" -> "TOP ITEMS";
			case "F5" -> "PRESIONE (F5) PARA BUSCAR MEJOR";
			case "F5-EXTRA" ->
				"PRESIONE (F5) EN EL ARTÍCULO PARA BUSCAR MEJOR<br>Y EN LAS FECHAS PARA BUSCAR LAS VENTAS DEL ARTÍCULO SELECCIONADO POR FECHAS";
			case "WEEKLY" -> "SEMANAL";
			case "MONTHLY" -> "MENSUAL";
			case "NAME" -> "NOMBRE";
			case "TYPE" -> "TIPO";
			case "LEFT" -> "RESTANTE";
			case "TO_BIRTH" -> "PARA CUMPLIR";
			case "ISLAM" -> "CUANDO EL TIPO ES ISLÁMICO, LA FECHA SERÁ HIJRAH";
			case "EMPLOYEE" -> "EMPLEADOS";
			case "LICENSE" -> "LICENCIA";
			case "WORK_DAYS" -> "HORARIO DE TRABAJO";
			case "FREE_DAYS" -> "VER DÍAS LIBRES";
			case "WEEK_DAYS" -> "DÍA LIBRE SEMANAL";
			case "VACATION" -> "DÍAS DE LICENCIA";
			case "UNAUTH" -> "FALTAS";
			case "EDIT_EMPLOYEE" -> "EDITAR EMPLEADOS";
			case "SALARY" -> "SALARIO";
			case "BY_EMP" -> "POR EMPLEADO";
			case "LEGEND_S" -> "COLOQUE EL RATÓN EN EL PUNTO/DIAGRAMA DÍA/MES PARA VER SU VALOR CON PRECISIÓN";
			case "DIAGRAM" -> "DIAGRAMA";
			case "TABLE" -> "TABLA";
			case "SELL_ANA" -> "ANÁLISIS";
			case "COMPARISON" -> "COMPARACIÓN";
			case "BOSS" -> "GERENTE";
			case "CASHIER" -> "CAJERO";
			case "WORKER" -> "EMPLEADO";
			case "POSITION" -> "POSICIÓN";
			case "PASSWORD" -> "CONTRASEÑA";
			case "OLD_PASS" -> "CONTRASEÑA ACTUAL";
			case "NEW_PASS" -> "NUEVA CONTRASEÑA";
			case "RE_PASS" -> "CONFIRMAR";
			case "OLDP_INCORRECT" -> "CONTRASEÑA ACTUAL INCORRECTA";
			case "NEWP_INCORRECT" -> "LA CONTRASEÑA NO COINCIDE";
			case "PASSWORD_EMPTY" -> "NUEVA CONTRASEÑA VACÍA";
			case "DEFAULT_PASS" -> "CONTRASEÑA PREDETERMINADA";
			case "NO_SALES" -> "MERCANCÍAS NO VENDIDAS";
			case "WEAK" -> "FLOJO";
			case "MEDIUM" -> "MEDIO";
			case "STRONG" -> "FUERTE";
			case "HOLLOW_POINT" -> "PUNTO HUECO PRESENTA UN DÍA LIBRE SEMANAL";
			case "AVERAGE" -> "PROMEDIO";
			case "DELETE_SELL" -> "RETIRAR ARTÍCULO ANTIGUO VENDIDO";
			case "DELETE_TOOLTIP" -> "SI UN CLIENTE DEVUELVE UN ARTÍCULO, PUEDE DEVOLVERLO AL STOCK DESDE AQUÍ";
			case "NO_SELLER" -> "SIN VENDADOR";
			case "SALES_EXCCED" -> " VENTAS SUPERARON LA CANTIDAD DISPONIBLE";
			case "EXISTED" -> "ARTÍCULO EXISTENTE";
			case "NEW" -> "ARTÍCULO NUEVO";
			default -> "";
			};
		case PORTUGUES:
			return switch (key) {
			case "SHORTKEY" -> "• CTRL + S → ir para a fatura.\n" + "• CTRL + P → ir para os pesos.\n"
					+ "• CTRL + B → excluir tudo.\n" + "• CTRL + N → prepare-se para o dia seguinte.\n"
					+ "• SETAS → cima, baixo, esquerda e direita.\n" + "• CTRL + D → ir para detalhes.\n"
					+ "• CTRL + I → ir para o início.\n" + "• CTRL + G → ir para as despesas.\n"
					+ "• CTRL + A → ir para agregar.\n" + "• CTRL + T → ir para finalizar a compra.\n"
					+ "• CTRL + E → ir para o último número.\n" + "• CTRL + M → mais 100 ou 1000 se possível.\n"
					+ "• CTRL + C → abrir configurações.\n" + "• ALT + - → Abra a calculadora.\n"
					+ "• CTRL + L → Bloqueie o aplicativo.\n" + "• ALT + P → Faça uma captura de tela.\n"
					+ "• CTRL + 0 → Minimizar o aplicativo.\n" + "• CTRL + R → Abra o painel de lembrete.\n"
					+ "• CTRL + W → fechar o aplicativo.";
			case "KEYS" -> "ATALHOS DE TECLAS";
			case "CREDIT" -> "CRÉDITO E DESENHADO POR MHMDSABDLH ©";
			case "ABOUT" -> "ESTE APLICATIVO FOI PROJETADO PARA FAZER A CAIXA DO HADI-TECH";
			case "SETTING" -> "CONFIGURAÇÃO";
			case "SAVE" -> "SALVAR";
			case "YES" -> "SIM";
			case "NO" -> "NÃO";
			case "IS" -> "É O";
			case "FILE" -> "ARQUIVO";
			case "EXIT_Q" -> "TEM CERTEZA QUE QUER SAIR?";
			case "EXIT" -> "SAIR";
			case "YEW_W" -> "SIM / NOVO DIA";
			case "EXP_RESULT" -> "SALVAR O RESUMO DO DIA?";
			case "NEWDAY" -> "NOVO DIA";
			case "CLEAR_Q" -> "VOCÊ QUER APAGAR TUDO?";
			case "CLEAR" -> "LIMPAR TUDO";
			case "NO_DIFFERENCE" -> "<html><center>NÃO HÁ DIFERENÇA</html>";
			case "MORE_DIFF" -> "SOBRA $";
			case "LESS_DIFF" -> "FALTOU $";
			case "NO_SET" -> "NÃO HÁ NADA PARA MONTAR!";
			case "SCREENSHOT" -> "CAPTURA DE TELA";
			case "SCREENSHOT_A" -> "A CAPTURA DE TELA FOI REALIZADA COM SUCESSO";
			case "SAVE_A" -> "SALVO COM SUCESSO, OBRIGADO";
			case "TITLE" -> "FECHAMENTO DE CAIXA - $";
			case "ABOUTME" -> "SOBRE MIM";
			case "ABOUTAPP" -> "SOBRE O APLICATIVO";
			case "SPENT" -> "GASTOS";
			case "AGG" -> "AGREGADOS";
			case "SEP" -> "SEPARADAS";
			case "MONTH_SUM" -> "REVISÃO DO MÊS";
			case "OTHER" -> "OUTROS";
			case "HOW_MUCH" -> "QUANTO";
			case "DATE" -> "DATA";
			case "YEAR_SUMM" -> "REVISÃO DO ANO";
			case "MORE" -> "MAIS";
			case "LOCK" -> "BLOQUEAR O APP";
			case "THEME" -> "TEMA";
			case "DESC" -> "DESCRIÇÃO";
			case "CANNOT_UNDO" -> "ISTO NÃO PODE SER DESFEITO!";
			case "OVERWRITE" -> "SE JÁ EXISTIR UM ARQUIVO, VOCÊ IRÁ SOBRESCREVER ELE";
			case "NOTE" -> "NOTA DE HOJE";
			case "SEP_Q" -> "COMO VOCÊ QUER SEPARAR O DINHEIRO?";
			case "CUSTOM" -> "PERSONALIZADO";
			case "EMPTY" -> "UM VALOR VAZIO PARA IGNORAR";
			case "LAST_WEEK" -> "Semana Passada";
			case "BILLS_TMRW" -> "AS CONTAS DE AMANHÃ: \n";
			case "SEPARAR_Q" -> "QUANTO VOCÊ QUER SEPARAR?";
			case "TRIES" -> "TENTATIVA RESTANTE: ";
			case "TRY_AGAIN" -> "TENTE NOVAMENTE";
			case "PASSWORD_W" -> "ESCREVA A SENHA";
			case "BILLS" -> "CONTAS";
			case "BILLS_O" -> "VER CONTAS";
			case "BILLS_C" -> "EDITAR CONTAS";
			case "LAST_UPDATE" -> "ÚLTIMA ATUALIZAÇÃO: ";
			case "INITIAL" -> "Início";
			case "SELL" -> "VENDAS";
			case "NOTIFICATION" -> "NOTIFICAÇÃO";
			case "CALC" -> "ASSUMIR";
			case "GO" -> "VAI";
			case "INVOICE" -> "FATURA";
			case "Intro_FRAME" -> "PRIMEIRA TELA";
			case "ANALYSE" -> "ANÁLISE";
			case "SUMMARY" -> "SUMARIO";
			case "THIS_YEAR" -> "ESTE ANO";
			case "DAILY_SUMMARY" -> "RESUMO DO DIA";
			case "OLD_SUMMARY" -> "RESUMO DOS ÚLTIMOS DIAS";
			case "TODAY_SUMMARY" -> "RESUMO DE HOJE";
			case "EFFECT" -> "EFEITO";
			case "FADE" -> "APARECIMENTO GRADUAL";
			case "WORD_WORD" -> "APARECE PALAVRA POR PALAVRA";
			case "LETTER_LETTER" -> "APARECE LETRA POR LETRA";
			case "SCRAMBLE" -> "LETRAS EMBARALHADAS";
			case "SPEED" -> "VELOCIDADE DA ANIMAÇÃO";
			case "SLOW" -> "LENTO";
			case "MEDUIM" -> "MÉDIO";
			case "FAST" -> "RÁPIDO";
			case "GRAPH" -> "GRÁFICO";
			case "TODAY" -> "HOJE";
			case "DAY" -> "DIA";
			case "MONTH" -> "MÊS";
			case "YEAR" -> "ANO";
			case "YESTERDAY" -> "ONTEM";
			case "LAST" -> "PASSADO";
			case "ALL_YEAR" -> "TODOS OS ANOS";
			case "CALCULATOR" -> "CALCULADORA";
			case "HOLIDAY" -> "FERIADO";
			case "HOLIDAY_O" -> "VER FERIADOS";
			case "HOLIDAY_C" -> "EDITAR FERIADOS";
			case "NO_EVENT" -> "NÃO HÁ NADA PARA MOSTRAR AQUI";
			case "CLEAR_CACHE" -> "LIMPAR CACHE";
			case "CLEAN_S" -> "LIMPE COM SUCESSO";
			case "CLEAN_U" -> "LIMPE SEM SUCESSO";
			case "SECURITY" -> "SEGURANÇA";
			case "HELP" -> "AJUDA";
			case "INVOICE_T" -> "AS CONTAS DE HOJE: \n";
			case "LEGEND" ->
				"<span margin-right: 50px;'>Eixo X: Dias</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ "<span margin-right: 50px;'>Eixo Y: Vendas</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ "<span margin-right: 50px;'>Ponto Vermelho: Valor Máximo</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ "<span margin-right: 50px;'>Ponto Azul: Valor Mínimo</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ "<span margin-right: 50px;'>Linha Horizontal: Valor Médio</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ "<span margin-right: 50px;'>Nenhum ponto: Fechado</span><br><br>";
			case "REVIEW_M" -> "VERIFIQUE O DINHEIRO NO CAIXA!";
			case "THIS" -> "ESTA";
			case "WEEK" -> "SEMANA";
			case "SHOW_ALL" -> "MOSTRAR TUDO";
			case "UPDATE_C" -> "ATUALIZE A CAIXA";
			case "BIRTHDAY" -> "ANIVERSÁRIO";
			case "BIRTHDAY_O" -> "VER ANIVERSÁRIO";
			case "BIRTHDAY_C" -> "EDITAR ANIVERSÁRIO";
			case "THIS_DAY" -> "OCASIÃO DE HOJE";
			case "CLOSE_TIME" -> "ESTÁ QUASE NA HORA DE FECHAR\n" + "FAÇA A CAIXA!";
			case "MONTH_E" -> "RESUMO MENSAL EXPORTADO COM SUCESSO";
			case "YEAR_E" -> "RESUMO ANUAL EXPORTADO COM SUCESSO";
			case "EXP_TXT" -> "RESUMO EXPORTADO COM SUCESSO";
			case "COPY_S" -> "COPIADO COM SUCESSO";
			case "COPY" -> "CLIQUE PARA COPIAR";
			case "HIDE/SHOW" -> "OCULTAR/MOSTRAR";
			case "HIDE_ALL" -> "OCULTAR TUDO";
			case "KEYWORDS" -> "PALAVRAS DE ATALHO";
			case "KEYWORDS_H" -> "ADICIONE ATALHO PARA AS CONTAS/AGREGADOS";
			case "STOCK_MAN" -> "GESTÃO DE ESTOQUE";
			case "VIEW_STOCK" -> "NAVEGAR PELO ESTOQUE";
			case "CHANGE_STOCK" -> "EDITAR ESTOQUE*";
			case "DATE_STOCK" -> "ADICIONAR ESTOQUE";
			case "SALES_TRAKING" -> "GESTÃO DE VENDAS";
			case "SEARCH_STOCK" -> "VENDAS DE MERCADORIAS POR DATA";
			case "SEARCH_DATES" -> "MERCADORIA ADICIONADA POR DATA";
			case "INVOICE_MAN" -> "GESTÃO DE FATURAS";
			case "ADD_STOCK" -> "FATURAS DE HOJE";
			case "OLD_INVOICES" -> "NAVEGAR FATURAS ANTIGAS";
			case "CATEGORY" -> "CATEGORIA";
			case "QUANTITY" -> "QUANTIDADE";
			case "PRICE" -> "PREÇO";
			case "UNIT_PRICE" -> "PREÇO DE CUSTO";
			case "ADD" -> "ADICIONAR";
			case "FILTER_P" -> "MOSTRAR ITENS DISPONÍVEIS";
			case "FILTER_Z" -> "MOSTRAR ITENS INDISPONÍVEIS";
			case "FILTER_A" -> "MOSTRAR TODOS OS ITENS";
			case "FILTER_C" -> "FILTRAR POR CATEGORÍA";
			case "FILTER_S" -> "FILTRAR POR STOCK";
			case "SEARCH" -> "PROCURAR";
			case "UPDATE" -> "ATUALIZAR";
			case "DELETE" -> "EXCLUIR";
			case "DATE_E" -> "VOCÊ PRECISA SELECIONAR A DATA";
			case "DATE_S" -> "DATA SELECIONADA";
			case "LOAD" -> "CARREGAR FATURA";
			case "NO_DATA" -> "SEM DADOS PARA ESTA DATA";
			case "OF" -> "DE";
			case "BETWEEN" -> "ENTER";
			case "ITEM_S" -> "ARTICULO SELECCIONADO";
			case "GRAPH_NOTE" -> "O GRÁFICO FUNCIONA SOMENTE EM MESES E ANO!";
			case "ALL_TIME" -> "TODOS OS TEMPOS";
			case "TOP_SELL" -> "MERCANCÍA MÁS VENDIDA";
			case "TOP_ITEMS" -> "TOP ITENS";
			case "F5" -> "PRESSIONE (F5) PARA PESQUISAR MELHOR";
			case "F5-EXTRA" ->
				"PRESSIONE (F5) NO ITEM PARA PESQUISAR MELHOR<br>E NAS DATAS PARA PESQUISAR AS VENDAS DO ITEM SELECIONADO POR DATAS";
			case "WEEKLY" -> "SEMANALMENTE";
			case "MONTHLY" -> "MENSAL";
			case "NAME" -> "NOME";
			case "TYPE" -> "TIPO";
			case "LEFT" -> "RESTANTE";
			case "TO_BIRTH" -> "PARA COMPLETAR";
			case "ISLAM" -> "QUANDO O TIPO FOR ISLÂMICO, A DATA SERÁ HÉJRA";
			case "EMPLOYEE" -> "FUNCIONÁRIOS";
			case "LICENSE" -> "LICENÇA";
			case "WORK_DAYS" -> "HORÁRIO DE TRABALHO";
			case "FREE_DAYS" -> "VER DIAS LIVRES";
			case "WEEK_DAYS" -> "DIA SEMANAL LIVRE";
			case "VACATION" -> "DIAS DE LICENÇA";
			case "UNAUTH" -> "FALTAS";
			case "EDIT_EMPLOYEE" -> "EDITAR FUNCIONÁRIOS";
			case "SALARY" -> "SALÁRIO";
			case "BY_EMP" -> "POR FUNCIONÁRIO";
			case "LEGEND_S" -> "PEGUE O MOUSE NO PONTO/DIAGRAMA DIA/MÊS PARA VER SEU VALOR COM PRECISÃO";
			case "DIAGRAM" -> "DIAGRAMA";
			case "TABLE" -> "TABELA";
			case "SELL_ANA" -> "ANÁLISE";
			case "COMPARISON" -> "COMPARAÇÃO";
			case "BOSS" -> "GERENTE";
			case "CASHIER" -> "CAIXA";
			case "WORKER" -> "FUNCIONÁRIO";
			case "POSITION" -> "POSIÇÃO";
			case "PASSWORD" -> "SENHA";
			case "OLD_PASS" -> "SENHA ATUAL";
			case "NEW_PASS" -> "NOVA SENHA";
			case "RE_PASS" -> "CONFIRMAR";
			case "OLDP_INCORRECT" -> "SENHA ATUAL INCORRECTA";
			case "NEWP_INCORRECT" -> "A SENHA NÃO CORRESPONDE";
			case "PASSWORD_EMPTY" -> "NOVA SENHA VAZIA";
			case "DEFAULT_PASS" -> "SENHA PADRÃO";
			case "NO_SALES" -> "MERCADORIAS NÃO VENDIDAS";
			case "WEAK" -> "FRACO";
			case "MEDIUM" -> "MÉDIO";
			case "STRONG" -> "FORTE";
			case "HOLLOW_POINT" -> "HOLLOW POINT APRESENTA UM DIA SEMANAL LIVRE";
			case "AVERAGE" -> "MÉDIA";
			case "DELETE_SELL" -> "REMOVER ITEM ANTIGO VENDIDO";
			case "DELETE_TOOLTIP" -> "SE UM CLIENTE DEVOLVER UM ITEM, VOCÊ PODE DEVOLVÊ-LO AO ESTOQUE AQUI";
			case "NO_SELLER" -> "SEM VENDEDOR";
			case "SALES_EXCCED" -> " VENDAS EXCEDERAM A QUANTIDADE DISPONÍVEL";
			case "EXISTED" -> "ITEM EXISTENTE";
			case "NEW" -> "NOVO ITEM";
			default -> "";
			};
		case ENGLISH:
			return switch (key) {
			case "SHORTKEY" ->
				"• CTRL + S → go to invoice.\n" + "• CTRL + P → go to the pesos.\n" + "• CTRL + B → delete all.n"
						+ "• CTRL + N → get ready for the next day.\n" + "• ARROWS → up, down, left and right.\n"
						+ "• CTRL + D → go to details.\n" + "• CTRL + I → go to the beginning.\n"
						+ "• CTRL + G → go to expenses.\n" + "• CTRL + A → go to aggregate.\n"
						+ "• CTRL + T → go to checkout.\n" + "• CTRL + E → go to the last number.\n"
						+ "• CTRL + M → add set of 100 or 1000 if possible.\n" + "• CTRL + C → open settings.\n"
						+ "• ALT + - → Open the calculator.\n" + "• CTRL + L → Lock the application.\n"
						+ "• ALT + P → Take a screenshot.\n" + "• CTRL + 0 → Minimize the app.\n"
						+ "• CTRL + R → Open the remind me panel.\n" + "• CTRL + W → exit the application.";
			case "KEYS" -> "KEY SHORTCUTS";
			case "CREDIT" -> "CREDIT AND DESIGNED BY MHMDSABDLH ©";
			case "ABOUT" -> "THIS APP IS DESIGNED TO DO THE CASH FOR HADI-TECH";
			case "SETTING" -> "CONFIGURATION";
			case "SAVE" -> "SAVE";
			case "YES" -> "YES";
			case "NO" -> "NO";
			case "IS" -> "IS THE";
			case "EXIT_Q" -> "ARE YOU SURE YOU WANT TO LEAVE?";
			case "FILE" -> "FILE";
			case "EXIT" -> "EXIT";
			case "YEW_W" -> "YES /NEW DAY";
			case "EXP_RESULT" -> "SAVE THE SUMMARY OF THE DAY?";
			case "NEWDAY" -> "NEW DAY";
			case "CLEAR_Q" -> "DO YOU WANT TO DELETE EVERYTHING?";
			case "CLEAR" -> "DELETE EVERYTHING";
			case "NO_DIFFERENCE" -> "<html><center>THERE IS NO DIFFERENCE</html>";
			case "MORE_DIFF" -> "MORE $";
			case "LESS_DIFF" -> "MISSED $";
			case "NO_SET" -> "THERE IS NOTHING TO ASSEMBLE!";
			case "SCREENSHOT" -> "SCREENSHOT";
			case "SCREENSHOT_A" -> "THE SCREENSHOT IS TAKING SUCCESSFULY";
			case "SAVE_A" -> "SUCCESSFULLY SAVED, THANK YOU";
			case "TITLE" -> "CASH CLOSING - $";
			case "ABOUTME" -> "ABOUT ME";
			case "ABOUTAPP" -> "ABOUT THE APP";
			case "SPENT" -> "BILLS";
			case "AGG" -> "AGGREGATES";
			case "SEP" -> "SEPARATED";
			case "MONTH_SUM" -> "MONTHLY REVIEW";
			case "OTHER" -> "OTHERS";
			case "HOW_MUCH" -> "HOW MUCH";
			case "DATE" -> "DATE";
			case "YEAR_SUMM" -> "ANNUAL REVIEW";
			case "MORE" -> "MORE";
			case "LOCK" -> "LOCK THE APP";
			case "THEME" -> "THEME";
			case "DESC" -> "DESCRIPTION";
			case "CANNOT_UNDO" -> "THIS CANNOT BE UNDONE!";
			case "OVERWRITE" -> "THERE AN ALREADY FILE, YOU WILL OVERWRITE IT";
			case "NOTE" -> "TODAY'S NOTE";
			case "SEP_Q" -> "HOW DO YOU WANT TO SEPARATE THE MONEY?";
			case "CUSTOM" -> "PERSONALIZED";
			case "EMPTY" -> "AN EMPTY VALUE TO SKIP IT";
			case "LAST_WEEK" -> "Last Week";
			case "BILLS_TMRW" -> "THE BILLS FOR TOMORROW: \n";
			case "SEPARAR_Q" -> "HOW MUCH DO YOU WANT TO SEPARATE?";
			case "TRIES" -> "REMAINING ATTEMPT: ";
			case "TRY_AGAIN" -> "TRY AGAIN";
			case "PASSWORD_W" -> "WRITE THE PASSWORD";
			case "BILLS" -> "BILLS";
			case "BILLS_O" -> "VIEW BILLS";
			case "BILLS_C" -> "EDIT BILLS";
			case "LAST_UPDATE" -> "LAST UPDATE: ";
			case "INITIAL" -> "INITIAL";
			case "SELL" -> "SALES";
			case "NOTIFICATION" -> "NOTIFICATION";
			case "CALC" -> "ASSUME";
			case "GO" -> "GO";
			case "INVOICE" -> "INVOICE";
			case "Intro_FRAME" -> "FIRST FRAME";
			case "ANALYSE" -> "ANALYSIS";
			case "SUMMARY" -> "SUMMARY";
			case "THIS_YEAR" -> "THIS YEAR";
			case "DAILY_SUMMARY" -> "SUMMARY OF THE DAY";
			case "OLD_SUMMARY" -> "PAST DAYS SUMMARY";
			case "TODAY_SUMMARY" -> "TODAY'S SUMMARY";
			case "EFFECT" -> "EFFECT";
			case "FADE" -> "FADING";
			case "WORD_WORD" -> "APPEAR WORD BY WORD";
			case "LETTER_LETTER" -> "APPEAR LETTER BY LETTER";
			case "SCRAMBLE" -> "LETTERS SCRAMBLE";
			case "SPEED" -> "ANIMATION SPEED";
			case "SLOW" -> "SLOW";
			case "MEDUIM" -> "MEDUIM";
			case "FAST" -> "FAST";
			case "GRAPH" -> "GRAPH";
			case "TODAY" -> "TODAY";
			case "DAY" -> "DAY";
			case "MONTH" -> "MONTH";
			case "YEAR" -> "YEAR";
			case "YESTERDAY" -> "YESTERDAY";
			case "LAST" -> "LAST";
			case "ALL_YEAR" -> "ALL YEAR";
			case "CALCULATOR" -> "CALCULATOR";
			case "HOLIDAY" -> "HOLIDAY";
			case "HOLIDAY_O" -> "VIEW HOLIDAYS";
			case "HOLIDAY_C" -> "EDIT HOLIDAYS";
			case "NO_EVENT" -> "THERE IS NOTHING TO SHOW HERE";
			case "CLEAR_CACHE" -> "CLEAN CACHE";
			case "CLEAN_S" -> "CLEAN SUCCESSFULLY";
			case "CLEAN_U" -> "CLEAN UNSUCCESSFULLY";
			case "SECURITY" -> "SECURITY";
			case "HELP" -> "HELP";
			case "INVOICE_T" -> "THE BILLS FOR TODAY: \n";
			case "LEGEND" -> "<span margin-right: 50px;'>"
					+ "X-axis: Days</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
					+ "<span margin-right: 50px;'>Y-axis: Sales</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
					+ "<span margin-right: 50px;'>Red Point: Maximum Value</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
					+ "<span margin-right: 50px;'>Blue Point: Minimum Value</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
					+ "<span margin-right: 50px;'>Horizontal Line: Average Value</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
					+ "<span margin-right: 50px;'>No Point: Unopened</span><br><br>";
			case "REVIEW_M" -> "CHECK THE MONEY AT THE CASHIER!";
			case "THIS" -> "THIS";
			case "WEEK" -> "WEEK";
			case "SHOW_ALL" -> "SHOW ALL";
			case "UPDATE_C" -> "UPDATE THE BOX";
			case "BIRTHDAY" -> "BIRTHDAY";
			case "BIRTHDAY_O" -> "VIEW BIRTHDAY";
			case "BIRTHDAY_C" -> "EDIT BIRTHDAY";
			case "THIS_DAY" -> "TODAY'S OCCASION";
			case "CLOSE_TIME" -> "IT'S ALMOST CLOSING TIME\n" + "MAKE THE CASH!";
			case "MONTH_E" -> "MONTHLY SUMMARY EXPORTED SUCCESSFULLY";
			case "YEAR_E" -> "YEARLY SUMMARY EXPORTED SUCCESSFULLY";
			case "EXP_TXT" -> "SUMMARY EXPORTED SUCCESSFULLY";
			case "COPY_S" -> "COPIED SUCCESSFULLY";
			case "COPY" -> "CLICK TO COPY";
			case "HIDE/SHOW" -> "HIDE/SHOW";
			case "HIDE_ALL" -> "HIDE ALL";
			case "KEYWORDS" -> "SHORTCUT WORDS";
			case "KEYWORDS_H" -> "ADD SHORTCUT TO THE BILLS/AGGREGATES";
			case "STOCK_MAN" -> "STOCK MANAGEMENT";
			case "VIEW_STOCK" -> "BROWSE STOCK";
			case "CHANGE_STOCK" -> "EDIT STOCK*";
			case "DATE_STOCK" -> "ADD STOCK";
			case "SALES_TRAKING" -> "SALES MANAGEMENT";
			case "SEARCH_STOCK" -> "MERCHANDISE SALES BY DATE";
			case "SEARCH_DATES" -> "ADDED MERCHANDISE BY DATE";
			case "INVOICE_MAN" -> "INVOICE MANAGEMENT";
			case "ADD_STOCK" -> "TODAY'S INVOICE";
			case "OLD_INVOICES" -> "VIEW OLD INVOICES";
			case "CATEGORY" -> "CATEGORY";
			case "QUANTITY" -> "QUANTITY";
			case "PRICE" -> "PRICE";
			case "UNIT_PRICE" -> "COST PRICE";
			case "ADD" -> "ADD";
			case "FILTER_P" -> "SHOW AVAILABLE ITEMS";
			case "FILTER_Z" -> "SHOW UNAVAILABLE ITEMS";
			case "FILTER_A" -> "SHOW ALL ITEMS";
			case "FILTER_C" -> "FILTER BY CATEGORY";
			case "FILTER_S" -> "FILTER BY STOCK";
			case "SEARCH" -> "SEARCH";
			case "UPDATE" -> "UPDATE";
			case "DELETE" -> "DELETE";
			case "DATE_E" -> "YOU NEED TO SELECT DATE";
			case "DATE_S" -> "SELECTED DATE";
			case "LOAD" -> "LOAD INVOICE";
			case "NO_DATA" -> "NO DATA FOR THIS DATE";
			case "OF" -> "OF";
			case "BETWEEN" -> "BETWEEN";
			case "ITEM_S" -> "ITEM SELECTED";
			case "GRAPH_NOTE" -> "GRAPH WORKS ONLY IN MONTHS AND YEAR!";
			case "ALL_TIME" -> "ALL TIME";
			case "TOP_SELL" -> "TOP SELL OF MERCHANDISE";
			case "TOP_ITEMS" -> "TOP ITEMS";
			case "F5" -> "PRESS (F5) TO SEARCH BETTER";
			case "F5-EXTRA" ->
				"PRESS (F5) IN THE ITEM TO SEARCH BETTER<br>AND IN THE DATES TO SEARCH THE SALES OF THE SELECTED ITEM BY DATES";
			case "WEEKLY" -> "WEEKLY";
			case "MONTHLY" -> "MONTHLY";
			case "NAME" -> "NAME";
			case "TYPE" -> "TYPE";
			case "LEFT" -> "LEFT";
			case "TO_BIRTH" -> "UNTIL TURNING";
			case "ISLAM" -> "WHEN THE TYPE IS ISLAMIC, THE DATE WILL BE HIJRAH";
			case "EMPLOYEE" -> "EMPLOYEES";
			case "LICENSE" -> "LICENSE";
			case "WORK_DAYS" -> "WORK SCHEDULE";
			case "FREE_DAYS" -> "VIEW FREE DAYS";
			case "WEEK_DAYS" -> "WEEKLY FREE DAY";
			case "VACATION" -> "LICENSE DAYS";
			case "UNAUTH" -> "ABSENCES";
			case "EDIT_EMPLOYEE" -> "EDIT EMPLOYEES";
			case "SALARY" -> "SALARY";
			case "BY_EMP" -> "BY EMPLOYEE";
			case "LEGEND_S" -> "GET THE MOUSE AT THE DAY/MONTH POINT/DIAGRAM TO SEE ITS VALUE PRECISELY";
			case "DIAGRAM" -> "DIAGRAM";
			case "TABLE" -> "TABLE";
			case "SELL_ANA" -> "ANALYTICS";
			case "COMPARISON" -> "COMPARISON";
			case "BOSS" -> "MANAGER";
			case "CASHIER" -> "CASHIER";
			case "WORKER" -> "EMPLOYEE";
			case "POSITION" -> "POSITION";
			case "PASSWORD" -> "PASSWORD";
			case "OLD_PASS" -> "CURRENT PASSWORD";
			case "NEW_PASS" -> "NEW PASSWORD";
			case "RE_PASS" -> "CONFIRM";
			case "OLDP_INCORRECT" -> "CURRENT PASSWORD INCORRECT";
			case "NEWP_INCORRECT" -> "NPASSWORD DOES NOT MATCH";
			case "PASSWORD_EMPTY" -> "NEW PASSWORD EMPTY";
			case "DEFAULT_PASS" -> "DEFAULT PASSWORD";
			case "NO_SALES" -> "UNSOLD MERCHANDISE";
			case "WEAK" -> "WEAK";
			case "MEDIUM" -> "MEDIUM";
			case "STRONG" -> "STRONG";
			case "HOLLOW_POINT" -> "HOLLOW POINT PRESENT A WEEKLY FREE DAY";
			case "AVERAGE" -> "AVERAGE";
			case "DELETE_SELL" -> "REMOVE OLD ITEM SOLD";
			case "DELETE_TOOLTIP" -> "IF A CLIENT RETURN AN ITEM, YOU CAN RETURN IT TO STOCK FROM HERE";
			case "NO_SELLER" -> "WITHOUT SELLER";
			case "SALES_EXCCED" -> " SALES EXCEEDED THE AVAILABLE QUANTITY";
			case "EXISTED" -> "EXISTED ITEM";
			case "NEW" -> "NEW ITEM";
			default -> "";
			};
		case FRENCH:
			return switch (key) {
			case "SHORTKEY" -> "• CTRL + S → aller à la facture.\n" + "• CTRL + B → tout supprimer.\n"
					+ "• CTRL + N → préparez-vous pour le lendemain.\n" + "• FLÈCHES → haut, bas, gauche et droite.\n"
					+ "• CTRL + D → aller aux détails.\n" + "• CTRL + I → aller au début.\n"
					+ "• CTRL + G → aller aux dépenses.\n" + "• CTRL + A → aller à l'agrégat.\n"
					+ "• CTRL + T → aller à la caisse.\n" + "• CTRL + E → aller au dernier numéro.\n"
					+ "• CTRL + M → ajouter un ensemble de 100 ou 1000 si possible.\n"
					+ "• CTRL + C → ouvrir les paramètres.\n" + "• ALT + - → Ouvrez la calculatrice.\n"
					+ "• CTRL + L → Verrouillez l'application..\n" + "• ALT + P → Prendre une capture d'écran.\n"
					+ "• CTRL + 0 → Verrouiller l'application.\n" + "• CTRL + R → Ouvrir le panneau de rappel.\n"
					+ "• CTRL + W → quitter l'application.";
			case "KEYS" -> "RACCOURCIS TOUCHES";
			case "CREDIT" -> "CRÉDIT ET CONÇU PAR MHMDSABDLH ©";
			case "ABOUT" -> "CETTE APP EST CONÇUE POUR GAGNER DE L'ARGENT POUR HADI-TECH";
			case "SETTING" -> "CONFIGURATION";
			case "SAVE" -> "SAVUVER";
			case "YES" -> "OUI";
			case "NO" -> "NON";
			case "IS" -> "EST LE";
			case "EXIT_Q" -> "ÊTES-VOUS SÛR DE VOULOIR PARTIR ?";
			case "FILE" -> "FICHER";
			case "EXIT" -> "QUITTER";
			case "YEW_W" -> "OUI /NOUVEAU JOUR";
			case "EXP_RESULT" -> "SAUVER LE RÉSUMÉ DE LA JOURNÉE?";
			case "NEWDAY" -> "NOUVEAU JOUR";
			case "CLEAR_Q" -> "VOULEZ-VOUS TOUT SUPPRIMER ?";
			case "CLEAR" -> "SUPPRIMER TOUT";
			case "NO_DIFFERENCE" -> "<html><center>IL N'Y A PAS DE DIFFÉRENCE</html>";
			case "MORE_DIFF" -> "PLUS DE $";
			case "LESS_DIFF" -> "MANQUÉ $";
			case "NO_SET" -> "IL N'Y A RIEN A ASSEMBLER!";
			case "SCREENSHOT" -> "CAPTURE D'ÉCRAN";
			case "SCREENSHOT_A" -> "LA CAPTURE D'ÉCRAN PREND BIEN";
			case "SAVE_A" -> "SAUVEGARDER AVEC SUCCÈS, MERCI";
			case "TITLE" -> "FERMETURE DE LA BOITE - $";
			case "ABOUTME" -> "À PROPOS DE MOI";
			case "ABOUTAPP" -> "À PROPOS DE L'APPLICATION";
			case "SPENT" -> "FACTURES";
			case "AGG" -> "GRANULATS";
			case "SEP" -> "SEPARE";
			case "MONTH_SUM" -> "REVUE MENSUELLE";
			case "OTHER" -> "AUTRES";
			case "HOW_MUCH" -> "COMBIEN";
			case "DATE" -> "DATE";
			case "YEAR_SUMM" -> "REVUE ANNUELLE";
			case "MORE" -> "PLUS";
			case "LOCK" -> "VERROUILLER L'APP";
			case "THEME" -> "THÈME";
			case "DESC" -> "DESCRIPTION";
			case "CANNOT_UNDO" -> "CELA NE PEUT PAS ÊTRE DÉFAIT !";
			case "OVERWRITE" -> "IL Y A DÉJÀ UN FICHIER, VOUS ALLEZ L'ÉCRASER";
			case "NOTE" -> "NOTE DU JOUR";
			case "SEP_Q" -> "COMMENT VOULEZ-VOUS SÉPARER L'ARGENT ?";
			case "CUSTOM" -> "PERSONNALISÉ";
			case "EMPTY" -> "UNE VALEUR VID POUR L'IGNORER";
			case "LAST_WEEK" -> "Dernière Semaine";
			case "BILLS_TMRW" -> "LES FACTURES DE DEMAIN: \n";
			case "SEPARAR_Q" -> "COMBIEN VOULEZ-VOUS SÉPARER?";
			case "TRIES" -> "TENTATIVE RESTANTE: ";
			case "TRY_AGAIN" -> "RÉESSAYER";
			case "PASSWORD_W" -> "ÉCRIVEZ LE MOT DE PASSE";
			case "BILLS" -> "FACTURES";
			case "BILLS_O" -> "VOIR LES FACTURES";
			case "BILLS_C" -> "MODIFIER LES FACTURES";
			case "LAST_UPDATE" -> "DERNIÈRE MISE À JOUR: ";
			case "INITIAL" -> "INICIAL";
			case "SELL" -> "VENTES";
			case "NOTIFICATION" -> "NOTIFICATION";
			case "CALC" -> "ASSUMER";
			case "GO" -> "ALLER";
			case "INVOICE" -> "FACTURE";
			case "Intro_FRAME" -> "PREMIER CADRE";
			case "ANALYSE" -> "ANALYSE";
			case "SUMMARY" -> "SOMMAIRE";
			case "THIS_YEAR" -> "CETTE ANNÉE";
			case "DAILY_SUMMARY" -> "RÉSUMÉ DE LA JOURNÉE";
			case "OLD_SUMMARY" -> "RÉSUMÉ DES JOURS PASSÉS";
			case "TODAY_SUMMARY" -> "RÉSUMÉ D'AUJOURD'HUI";
			case "EFFECT" -> "EFFET";
			case "FADE" -> "DÉCOLORATION";
			case "WORD_WORD" -> "APPARAÎTRE MOT PAR MOT";
			case "LETTER_LETTER" -> "APPARAÎTRE LETTRE PAR LETTRE";
			case "SCRAMBLE" -> "LETTRES SCRAMBLE";
			case "SPEED" -> "LA VITESSE D'ANIMATION";
			case "SLOW" -> "LENTE";
			case "MEDUIM" -> "MOYEN";
			case "FAST" -> "RAPIDE";
			case "GRAPH" -> "GRAPHIQUE";
			case "TODAY" -> "AUJOURD'HUI";
			case "DAY" -> "JOUR";
			case "MONTH" -> "MOIS";
			case "YEAR" -> "ANNÉE";
			case "YESTERDAY" -> "HIER";
			case "LAST" -> "DERNIÈRE";
			case "ALL_YEAR" -> "TOUTES LES ANNÉES";
			case "CALCULATOR" -> "CALCULATRICE";
			case "HOLIDAY" -> "VACANCES";
			case "HOLIDAY_O" -> "VOIR LES VACANCES";
			case "HOLIDAY_C" -> "MODIFIER LES JOURS FÉRIÉS";
			case "NO_EVENT" -> "IL N'Y A RIEN À MONTRER ICI";
			case "CLEAR_CACHE" -> "NETTOYER LE CACHE";
			case "CLEAN_S" -> "NETTOYER AVEC SUCCÈS";
			case "CLEAN_U" -> "NETTOYER SANS SUCCÈS";
			case "SECURITY" -> "SÉCURITÉ";
			case "HELP" -> "AIDER";
			case "INVOICE_T" -> "LES FACTURES D´ AUJOURD'HUI: \n";
			case "LEGEND" -> "<span margin-right: 50px;'>"
					+ "Axe X: Jours</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
					+ "<span margin-right: 50px;'>Axe Y: Ventes</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
					+ "<span margin-right: 50px;'>Point Rouge: Valeur maximale</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
					+ "<span margin-right: 50px;'>Point Bleu: Valeur minimale</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
					+ "<span margin-right: 50px;'>Ligne Horizontale : Valeur Moyenne</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
					+ "<span margin-right: 50px;'>Aucun intérêt: fermé</span><br><br>";
			case "REVIEW_M" -> "VÉRIFIEZ L'ARGENT DANS LA CAISSE !";
			case "THIS" -> "CE";
			case "WEEK" -> "SEMAINE";
			case "SHOW_ALL" -> "AFFICHER TOUT";
			case "UPDATE_C" -> "METTRE À JOUR LA BOÎTE";
			case "BIRTHDAY" -> "ANNIVERSAIRE";
			case "BIRTHDAY_O" -> "VOIR LES  ANNIVERSAIRE";
			case "BIRTHDAY_C" -> "MODIFIER LES JOURS ANNIVERSAIRE";
			case "THIS_DAY" -> "L'OCCASION D'AUJOURD'HUI";
			case "CLOSE_TIME" -> "C'EST PRESQUE L'HEURE DE LA FERMETURE\n" + "FAIRE LA BOÎTE!";
			case "MONTH_E" -> "SOMMAIRE MENSUEL EXPORTÉ AVEC SUCCÈS";
			case "YEAR_E" -> "SOMMAIRE ANNUEL EXPORTÉ AVEC SUCCÈS";
			case "EXP_TXT" -> "SOMMAIRE EXPORTÉ AVEC SUCCÈS";
			case "COPY_S" -> "COPIÉ AVEC SUCCÈS";
			case "COPY" -> "CLIQUEZ POUR COPIER";
			case "HIDE/SHOW" -> "MASQUER/AFFICHER";
			case "HIDE_ALL" -> "MASQUER TOUT";
			case "KEYWORDS" -> "RACCOURCIS";
			case "KEYWORDS_H" -> "AJOUTER UN RACCOURCI VERS LES FACTURES/AGRÉGATS";
			case "STOCK_MAN" -> "GESTION DES STOCKS";
			case "VIEW_STOCK" -> "PARCOURIR LES STOCKS";
			case "CHANGE_STOCK" -> "MODIFIER LE STOCK*";
			case "DATE_STOCK" -> "AJOUTER DU STOCK";
			case "SALES_TRAKING" -> "GESTION DES VENTES";
			case "SEARCH_STOCK" -> "VENTES DE MARCHANDISES PAR DATE";
			case "SEARCH_DATES" -> "MARCHANDISE AJOUTÉE PAR DATE";
			case "INVOICE_MAN" -> "GESTION DES FACTURES";
			case "ADD_STOCK" -> "AJOUTER LES VENTES D'AUJOURD'HUI";
			case "OLD_INVOICES" -> "FACTURES ANCIENNES";
			case "CATEGORY" -> "CATÉGORIE";
			case "QUANTITY" -> "QUANTITÉ";
			case "PRICE" -> "PRIX";
			case "UNIT_PRICE" -> "PRIX DE COÛT";
			case "ADD" -> "AJOUTER";
			case "FILTER_P" -> "AFFICHER LES ARTICLES DISPONIBLES";
			case "FILTER_Z" -> "AFFICHER LES ARTICLES INDISPONIBLES";
			case "FILTER_A" -> "AFFICHER TOUS LES ARTICLES";
			case "FILTER_C" -> "FILTRER PAR CATÉGORIE";
			case "FILTER_S" -> "FILTRER PAR STOCK";
			case "SEARCH" -> "RECHERCHE";
			case "UPDATE" -> "MISE À JOUR";
			case "DELETE" -> "SUPPRIMER";
			case "DATE_E" -> "VOUS DEVEZ SÉLECTIONNER LA DATE";
			case "DATE_S" -> "DATE SÉLECTIONNÉE";
			case "LOAD" -> "CHARGEMENT FACTURE";
			case "NO_DATA" -> "AUCUNE DONNEE POUR CETTE DATE";
			case "OF" -> "DE";
			case "BETWEEN" -> "ENTER";
			case "ITEM_S" -> "ARTICLE SÉLECTIONNÉ";
			case "GRAPH_NOTE" -> "GRAPHIQUE NE FONCTIONNE QUE PAR MOIS ET ANNÉE!";
			case "ALL_TIME" -> "TOUS LES TEMPS";
			case "TOP_SELL" -> "MEILLEURES VENTES DE MARCHANDISES";
			case "TOP_ITEMS" -> "TOP ARTICLES";
			case "F5" -> "APPUYEZ SUR (F5) POUR MIEUX RECHERCHER";
			case "F5-EXTRA" ->
				"APPUYEZ SUR (F5) DANS L'ARTICLE POUR MIEUX RECHERCHER<br>ET DANS LES DATES POUR RECHERCHER LES VENTES DE L'ARTICLE SÉLECTIONNÉ PAR DATES";
			case "WEEKLY" -> "HEBDOMADAIRE";
			case "MONTHLY" -> "MENSUELLE";
			case "NAME" -> "NOM";
			case "TYPE" -> "TYPE";
			case "LEFT" -> "RESTANT";
			case "TO_BIRTH" -> "AVANT D'AVOIR";
			case "ISLAM" -> "QUAND LE TYPE EST ISLAMIQUE, LA DATE SERA HIJRAH";
			case "EMPLOYEE" -> "EMPLOYÉS";
			case "LICENSE" -> "LICENCE";
			case "WORK_DAYS" -> "HORAIRE DE TRAVAIL";
			case "FREE_DAYS" -> "VOIR JOURS LIBRES";
			case "WEEK_DAYS" -> "JOURNÉE HEBDOMADAIRE LIBRE";
			case "VACATION" -> "JOURS DE LICENCE";
			case "UNAUTH" -> "ABSENCES";
			case "EDIT_EMPLOYEE" -> "PAR EMPLOYÉ";
			case "SALARY" -> "SALAIRE";
			case "LEGEND_S" -> "OBTENEZ LA SOURIS AU POINT/DIAGRAMME JOUR/MOIS POUR VOIR SA VALEUR PRÉCISÉMENT";
			case "DIAGRAM" -> "DIAGRAMME";
			case "TABLE" -> "TABLEAU";
			case "SELL_ANA" -> "ANALYTIQUE";
			case "COMPARISON" -> "COMPARAISON";
			case "BOSS" -> "MANAGER";
			case "CASHIER" -> "CAISSIER";
			case "WORKER" -> "EMPLOYÉ";
			case "POSITION" -> "POSITION";
			case "PASSWORD" -> "MOT DE PASSE";
			case "OLD_PASS" -> "MOT DE PASSE ACTUEL";
			case "NEW_PASS" -> "NOUVEAU MOT DE PASSE";
			case "RE_PASS" -> "CONFIRMER";
			case "OLDP_INCORRECT" -> "MOT DE PASSE ACTUEL INCORRECT";
			case "NEWP_INCORRECT" -> "LE MOT DE PASSE NE CORRESPOND PAS";
			case "PASSWORD_EMPTY" -> "NOUVEAU MOT DE PASSE VIDE";
			case "DEFAULT_PASS" -> "MOT DE PASSE PAR DÉFAUT";
			case "NO_SALES" -> "MARCHANDISES NON VENDUES";
			case "WEAK" -> "FAIBLE";
			case "MEDIUM" -> "MOYEN";
			case "STRONG" -> "FORT";
			case "HOLLOW_POINT" -> "HOLLOW POINT PRÉSENTE UNE JOURNÉE GRATUITE HEBDOMADAIRE";
			case "AVERAGE" -> "MOYENNE";
			case "DELETE_SELL" -> "SUPPRIMER L'ANCIEN ARTICLE VENDU";
			case "DELETE_TOOLTIP" ->
				"SI UN CLIENT RETOURNE UN ARTICLE, VOUS POUVEZ LE RETOURNER AU STOCK À PARTIR D'ICI";
			case "NO_SELLER" -> "PAS DE VENDEUR";
			case "SALES_EXCCED" -> " VENTES ONT DÉPASSÉ LA QUANTITÉ DISPONIBLE";
			case "EXISTED" -> "ARTICLE EXISTANT";
			case "NEW" -> "NOUVEL ARTICLE";
			default -> "";
			};
		default:
			return "";
		}
	}

	/* Go to the Intro empty value */
	private int[] lastEmpty() {
		int last[] = { 0, 0 };
		schiffe_loop: while (last[0] < 6) {
			last[1] = 0;
			while (last[1] < 20) {
				if (details[last[0]][last[1]].getText().isBlank()) {
					break schiffe_loop;
				}
				last[1]++;
			}
			last[0]++;
		}
		if (last[0] == 6 && last[1] == 20)
			last[0] = last[1] = 0;
		return last;
	}

	/* Key listener for the table */
	private void tableFocus(int i, int j, JTextField[][] table) {
		table[i][j].addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// GO TO Notas
				if ((e.getKeyCode() == KeyEvent.VK_M) && ((e.getModifiers() & InputEvent.CTRL_MASK) != 0)
						&& ((e.getModifiers() & InputEvent.ALT_MASK) != 0))
					separadosFrame();
				else if ((e.getKeyCode() == KeyEvent.VK_0) && ((e.getModifiers() & InputEvent.CTRL_MASK) != 0))
					setState(Frame.ICONIFIED);
				else// Direction
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (i < 5) {
						table[i][j].setNextFocusableComponent(table[i + 1][j]);
						table[i][j].nextFocus();
					} else {
						if (j != 19) {
							table[i][j].setNextFocusableComponent(table[0][j + 1]);
							table[i][j].nextFocus();
						} else {
							table[i][j].setNextFocusableComponent(table[0][0]);
							table[i][j].nextFocus();
						}
					}
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (i > 0) {
						table[i][j].setNextFocusableComponent(table[i - 1][j]);
						table[i][j].nextFocus();
					} else {
						if (j != 0) {
							table[i][j].setNextFocusableComponent(table[5][j - 1]);
							table[i][j].nextFocus();
						} else {
							table[i][j].setNextFocusableComponent(table[5][19]);
							table[i][j].nextFocus();
						}
					}
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					if (j > 0) {
						table[i][j].setNextFocusableComponent(table[i][j - 1]);
						table[i][j].nextFocus();
					} else {
						if (i != 0) {
							table[i][j].setNextFocusableComponent(table[i - 1][19]);
							table[i][j].nextFocus();
						} else {
							table[i][j].setNextFocusableComponent(table[5][19]);
							table[i][j].nextFocus();
						}
					}
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					if (j < 19) {
						table[i][j].setNextFocusableComponent(table[i][j + 1]);
						table[i][j].nextFocus();
					} else {
						if (i != 5) {
							table[i][j].setNextFocusableComponent(table[i + 1][0]);
							table[i][j].nextFocus();
						} else {
							table[i][j].setNextFocusableComponent(table[0][0]);
							table[i][j].nextFocus();
						}
					}
				} else// GO TO INITIAL
				if ((e.getKeyCode() == KeyEvent.VK_I) && ((e.getModifiers() & InputEvent.CTRL_MASK) != 0)) {
					table[i][j].setNextFocusableComponent(initialDay);
					table[i][j].nextFocus();
				} else// GO TO GASTOS
				if ((e.getKeyCode() == KeyEvent.VK_G) && ((e.getModifiers() & InputEvent.CTRL_MASK) != 0)) {
					table[i][j].setNextFocusableComponent(gastosTable[0]);
					table[i][j].nextFocus();
				} else// GO TO AGGREG
				if ((e.getKeyCode() == KeyEvent.VK_A) && ((e.getModifiers() & InputEvent.CTRL_MASK) != 0)) {
					table[i][j].setNextFocusableComponent(agregadoTable[0]);
					table[i][j].nextFocus();
				} else// GO TO TROCO
				if ((e.getKeyCode() == KeyEvent.VK_T) && ((e.getModifiers() & InputEvent.CTRL_MASK) != 0)) {
					table[i][j].setNextFocusableComponent(panelCnum[0]);
					table[i][j].nextFocus();
				} else// |Go to the last one
				if ((e.getKeyCode() == KeyEvent.VK_E) && ((e.getModifiers() & InputEvent.CTRL_MASK) != 0)) {
					table[i][j].setNextFocusableComponent(table[lastEmpty()[0]][lastEmpty()[1]]);
					table[i][j].nextFocus();
				}
			}
		});
	}

	/* Key listener for the ADDITION */
	private void aggFocus(int i) {
		agregadoTable[i].addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if ((e.getKeyCode() == KeyEvent.VK_I) && ((e.getModifiers() & InputEvent.CTRL_MASK) != 0)) {
					agregadoTable[i].setNextFocusableComponent(initialDay);
					agregadoTable[i].nextFocus();
				} else// GO TO GASTOS
				if ((e.getKeyCode() == KeyEvent.VK_G) && ((e.getModifiers() & InputEvent.CTRL_MASK) != 0)) {
					agregadoTable[i].setNextFocusableComponent(gastosTable[0]);
					agregadoTable[i].nextFocus();
				} else// GO TO Details
				if ((e.getKeyCode() == KeyEvent.VK_D) && ((e.getModifiers() & InputEvent.CTRL_MASK) != 0)) {
					agregadoTable[i].setNextFocusableComponent(details[0][0]);
					agregadoTable[i].nextFocus();
				} else// GO TO Troco
				if ((e.getKeyCode() == KeyEvent.VK_T) && ((e.getModifiers() & InputEvent.CTRL_MASK) != 0)) {
					agregadoTable[i].setNextFocusableComponent(panelCnum[0]);
					agregadoTable[i].nextFocus();
				} else if ((e.getKeyCode() == KeyEvent.VK_0) && ((e.getModifiers() & InputEvent.CTRL_MASK) != 0))
					setState(Frame.ICONIFIED);
				else// Direction
				if (e.getKeyCode() == KeyEvent.VK_RIGHT && ((e.getModifiers() & InputEvent.CTRL_MASK) != 0)) {
					/* do Nothing */
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					if (i > 0 && i < 4 || i > 8 && i < 12) {
						agregadoTable[i].setNextFocusableComponent(agregadoTable[i - 1]);
						agregadoTable[i].nextFocus();
					} else if (i == 0) {
						agregadoTable[i].setNextFocusableComponent(agregadoTable[11]);
						agregadoTable[i].nextFocus();
					} else if (i == 8) {
						agregadoTable[i].setNextFocusableComponent(agregadoTable[3]);
						agregadoTable[i].nextFocus();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					if (i < 3 || i > 7 && i < 11) {
						agregadoTable[i].setNextFocusableComponent(agregadoTable[i + 1]);
						agregadoTable[i].nextFocus();
					} else if (i == 3) {
						agregadoTable[i].setNextFocusableComponent(agregadoTable[8]);
						agregadoTable[i].nextFocus();
					} else if (i == 11) {
						agregadoTable[i].setNextFocusableComponent(agregadoTable[0]);
						agregadoTable[i].nextFocus();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (i != 11) {
						if (i < 8) {
							agregadoTable[i].setNextFocusableComponent(agregadoTable[i + 8]);
							agregadoTable[i].nextFocus();
						} else {
							agregadoTable[i].setNextFocusableComponent(agregadoTable[i - 7]);
							agregadoTable[i].nextFocus();
						}
					} else {
						agregadoTable[i].setNextFocusableComponent(agregadoTable[0]);
						agregadoTable[i].nextFocus();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (i != 0) {
						if (i < 8) {
							agregadoTable[i].setNextFocusableComponent(agregadoTable[i + 7]);
							agregadoTable[i].nextFocus();
						} else {
							agregadoTable[i].setNextFocusableComponent(agregadoTable[i - 8]);
							agregadoTable[i].nextFocus();
						}
					} else {
						agregadoTable[i].setNextFocusableComponent(agregadoTable[11]);
						agregadoTable[i].nextFocus();
					}
				} else// |Go to the last one
				if ((e.getKeyCode() == KeyEvent.VK_E) && ((e.getModifiers() & InputEvent.CTRL_MASK) != 0)) {
					int k = 0;
					while (k < 3) {
						if (agregadoTable[k].getText().isBlank())
							break;
						k++;
					}
					if (k == 3)
						k = 0;
					agregadoTable[i].setNextFocusableComponent(agregadoTable[k]);
					agregadoTable[i].nextFocus();
				}
			}
		});
	}

	/* Key listener for the SPENT */
	private void gasFocus(int i) {
		gastosTable[i].addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if ((e.getKeyCode() == KeyEvent.VK_I) && ((e.getModifiers() & InputEvent.CTRL_MASK) != 0)) {
					gastosTable[i].setNextFocusableComponent(initialDay);
					gastosTable[i].nextFocus();
				} else// GO TO AGG
				if ((e.getKeyCode() == KeyEvent.VK_A) && ((e.getModifiers() & InputEvent.CTRL_MASK) != 0)) {
					gastosTable[i].setNextFocusableComponent(agregadoTable[0]);
					gastosTable[i].nextFocus();
				} else// GO TO Details
				if ((e.getKeyCode() == KeyEvent.VK_D) && ((e.getModifiers() & InputEvent.CTRL_MASK) != 0)) {
					gastosTable[i].setNextFocusableComponent(details[0][0]);
					gastosTable[i].nextFocus();
				} else// GO TO Troco
				if ((e.getKeyCode() == KeyEvent.VK_T) && ((e.getModifiers() & InputEvent.CTRL_MASK) != 0)) {
					gastosTable[i].setNextFocusableComponent(panelCnum[0]);
					gastosTable[i].nextFocus();
				} else if ((e.getKeyCode() == KeyEvent.VK_0) && ((e.getModifiers() & InputEvent.CTRL_MASK) != 0))
					setState(Frame.ICONIFIED);
				else// Direction
				if (e.getKeyCode() == KeyEvent.VK_RIGHT && ((e.getModifiers() & InputEvent.CTRL_MASK) != 0)) {
					/* do Nothing */
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					if (i > 0 && i < 4 || i > 8 && i < 12) {
						gastosTable[i].setNextFocusableComponent(gastosTable[i - 1]);
						gastosTable[i].nextFocus();
					} else if (i == 0) {
						gastosTable[i].setNextFocusableComponent(gastosTable[11]);
						gastosTable[i].nextFocus();
					} else if (i == 8) {
						gastosTable[i].setNextFocusableComponent(gastosTable[3]);
						gastosTable[i].nextFocus();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					if (i < 3 || i > 7 && i < 11) {
						gastosTable[i].setNextFocusableComponent(gastosTable[i + 1]);
						gastosTable[i].nextFocus();
					} else if (i == 3) {
						gastosTable[i].setNextFocusableComponent(gastosTable[8]);
						gastosTable[i].nextFocus();
					} else if (i == 11) {
						gastosTable[i].setNextFocusableComponent(gastosTable[0]);
						gastosTable[i].nextFocus();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (i != 11) {
						if (i < 8) {
							gastosTable[i].setNextFocusableComponent(gastosTable[i + 8]);
							gastosTable[i].nextFocus();
						} else {
							gastosTable[i].setNextFocusableComponent(gastosTable[i - 7]);
							gastosTable[i].nextFocus();
						}
					} else {
						gastosTable[i].setNextFocusableComponent(gastosTable[0]);
						gastosTable[i].nextFocus();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (i != 0) {
						if (i < 8) {
							gastosTable[i].setNextFocusableComponent(gastosTable[i + 7]);
							gastosTable[i].nextFocus();
						} else {
							gastosTable[i].setNextFocusableComponent(gastosTable[i - 8]);
							gastosTable[i].nextFocus();
						}
					} else {
						gastosTable[i].setNextFocusableComponent(gastosTable[11]);
						gastosTable[i].nextFocus();
					}
				} else// |Go to the last one
				if ((e.getKeyCode() == KeyEvent.VK_E) && ((e.getModifiers() & InputEvent.CTRL_MASK) != 0)) {
					int k = 0;
					while (k < 3) {
						if (gastosTable[k].getText().isBlank())
							break;
						k++;
					}
					if (k == 3)
						k = 0;
					gastosTable[i].setNextFocusableComponent(gastosTable[k]);
					gastosTable[i].nextFocus();
				}
			}
		});
	}

	/* Key listener for the CASH */
	private void cajaFocus(int i) {
		panelCnum[i].addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if ((e.getKeyCode() == KeyEvent.VK_I) && ((e.getModifiers() & InputEvent.CTRL_MASK) != 0)) {
					panelCnum[i].setNextFocusableComponent(initialDay);
					panelCnum[i].nextFocus();
				} else if ((e.getKeyCode() == KeyEvent.VK_A) && ((e.getModifiers() & InputEvent.CTRL_MASK) != 0)) {
					panelCnum[i].setNextFocusableComponent(agregadoTable[0]);
					panelCnum[i].nextFocus();
				} else if ((e.getKeyCode() == KeyEvent.VK_D) && ((e.getModifiers() & InputEvent.CTRL_MASK) != 0)) {
					panelCnum[i].setNextFocusableComponent(details[0][0]);
					panelCnum[i].nextFocus();
				} else if ((e.getKeyCode() == KeyEvent.VK_G) && ((e.getModifiers() & InputEvent.CTRL_MASK) != 0)) {
					panelCnum[i].setNextFocusableComponent(gastosTable[0]);
					panelCnum[i].nextFocus();
				} else if ((e.getKeyCode() == KeyEvent.VK_0) && ((e.getModifiers() & InputEvent.CTRL_MASK) != 0))
					setState(Frame.ICONIFIED);
				else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (i < 7) {
						panelCnum[i].setNextFocusableComponent(panelCnum[i + 1]);
						panelCnum[i].nextFocus();
					} else {
						panelCnum[i].setNextFocusableComponent(panelCnum[0]);
						panelCnum[i].nextFocus();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT)
					if (i > 0) {
						panelCnum[i].setNextFocusableComponent(panelCnum[i - 1]);
						panelCnum[i].nextFocus();
					} else {
						panelCnum[i].setNextFocusableComponent(panelCnum[7]);
						panelCnum[i].nextFocus();
					}
			}
		});
	}

	/* Style of textField */
	private void textFieldStyle(JTextField tf) {
		tf.setBackground(Intro.blackM);
		tf.setForeground(Intro.lightC);
		tf.setFont(Intro.myFont);
		tf.setBorder(Intro.borderL);
		tf.setHorizontalAlignment(0);
		tf.setCaretColor(Intro.lightC);
		tf.addFocusListener(textFocus);
	}

	/* Detailling the agregados */
	private String agregadoDetalles() {
		String aggString = "";
		int num = 1;
		for (int i = 8; i < 16; i++)
			if (TextEffect.isInteger(agregadoTable[i].getText())) {
				aggString += num + "- "
						+ (agregadoTable[i - 8].getText().isBlank() ? "XXX" : agregadoTable[i - 8].getText()) + " -> $"
						+ agregadoTable[i].getText() + "\n";
				num++;
			}
		return aggString;
	}

	/* Calculate the nbrs of agregados */
	private int nbAgregados() {
		int agregado = 0;
		for (int i = 8; i < 16; i++)
			if (TextEffect.isInteger(agregadoTable[i].getText()))
				agregado++;
		return agregado;
	}

	/* Detailling the gastos */
	private String gastosDetalles() {
		String gasString = "";
		int num = 1;
		for (int i = 8; i < 16; i++)
			if (TextEffect.isInteger(gastosTable[i].getText())) {
				gasString += num + "- "
						+ (gastosTable[i - 8].getText().isBlank() ? "XXX" : gastosTable[i - 8].getText()) + " -> $"
						+ gastosTable[i].getText() + "\n";
				num++;
			}
		return gasString;
	}

	/* Calculate the nbrs of gastos */
	private int nbGastos() {
		int gastos = 0;
		for (int i = 8; i < 16; i++)
			if (TextEffect.isInteger(gastosTable[i].getText()))
				gastos++;
		return gastos;
	}

	/* Calculate the nbrs of ventas */
	private int nbVentas() {
		int ventas = 0;
		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 20; j++)
				if (TextEffect.isInteger(details[i][j].getText()))
					ventas++;
		return ventas;
	}

	/* pix frame */
	private void pixFrame() {
		JDialog pixDialog = new JDialog(this, "WISH", true);
		pixDialog.setUndecorated(true);
		pixDialog.setSize(pixMore.getWidth(), 0);
		pixDialog.setLocation(pixMore.getLocationOnScreen().x,
				pixMore.getLocationOnScreen().y + pixMore.getHeight() - 1);
		pixDialog.setResizable(false);
		pixDialog.setLayout(null);

		pixDialog.setIconImage(pixI.getImage());
		JButton closeButton = new JButton(
				ImageEffect.changeOpacity(ImageEffect.getScaledImage(closeImage.getImage(), 10, 10).getImage(), 0.8f));
		closeButton.setBounds(pixDialog.getWidth() - 12, 2, 10, 10); // Adjust button size
		closeButton.setBorderPainted(false);
		closeButton.setFocusPainted(false);
		closeButton.setContentAreaFilled(false);
		closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		closeButton.setToolTipText(getLocalizedMessage("EXIT"));
		closeButton.addActionListener(_ -> {
			// Animation to increase height gradually
			int targetHeight = pixDialog.getHeight();
			int dialogWidth = pixDialog.getWidth();
			Timer fadeIn = new Timer(5, new ActionListener() {
				private int newHeight = targetHeight; // Start height at zero
				// Target size for the dialog

				@Override
				public void actionPerformed(ActionEvent e) {
					if (newHeight > 0) {
						newHeight -= 5; // Increase height by 5 pixels
						pixDialog.setSize(dialogWidth, newHeight); // Set new size
						pixDialog.revalidate();
						pixDialog.repaint();
					} else {
						((Timer) e.getSource()).stop(); // Stop the timer once target height is reached
						pixDialog.dispose(); // Close the dialog when focus is lost
					}
				}
			});
			fadeIn.start(); // Start the animation timer
		});
		pixDialog.add(closeButton);

		JTextField pixNmb[] = new JTextField[5];
		for (int i = 0; i < 5; i++) {
			pixNmb[i] = new JTextField();
			textFieldStyle(pixNmb[i]);
			pixNmb[i].setBounds(0, 39 * i, pixMore.getWidth(), 40);
			pixNmb[i].setBackground(skyblueC);
			pixNmb[i].removeFocusListener(textFocus);
			pixNmb[i].setForeground(Intro.blackM);
			pixNmb[i].setCaretColor(Intro.blackM);
			pixNmb[i].setBorder(Intro.borderD);
			pixKA(pixDialog, pixMore, pixNmb, i);
			pixDialog.add(pixNmb[i]);
		}
		pixNmb[0].setText(panelCnum[7].getText());
		// Target size for the dialog
		int targetHeight = (pixNmb[0].getHeight() - 1) * 5 + 1;
		int dialogWidth = pixNmb[0].getWidth();

		// Animation to increase height gradually
		Timer fadeIn = new Timer(5, new ActionListener() {

			private int newHeight = 0; // Start height at zero

			@Override
			public void actionPerformed(ActionEvent e) {
				if (newHeight < targetHeight) {
					newHeight += 5; // Increase height by 5 pixels
					pixDialog.setSize(dialogWidth, newHeight); // Set new size
					pixDialog.revalidate();
					pixDialog.repaint();
				} else {
					pixDialog.setSize(dialogWidth, targetHeight); // Set new size
					((Timer) e.getSource()).stop(); // Stop the timer once target height is reached
				}
			}

		});
		fadeIn.start(); // Start the animation timer
		pixDialog.setVisible(true);
	}

	/* pix key listener */
	private void pixKA(JDialog pixFrame, JButton pixbtn, JTextField[] pixNmb, int i) {
		pixNmb[i].addKeyListener(new KeyAdapter() {// Escape to close
			@Override

			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
					int pix = 0;
					for (int i = 0; i < 5; i++)
						if (TextEffect.isInteger(pixNmb[i].getText()))
							pix += Integer.valueOf(pixNmb[i].getText());
					panelCnum[7].setText(pix + "");
					sumF();
					// Animation to increase height gradually
					int targetHeight = pixFrame.getHeight();
					int dialogWidth = pixFrame.getWidth();
					Timer fadeIn = new Timer(5, new ActionListener() {
						private int newHeight = targetHeight; // Start height at zero
						// Target size for the dialog

						@Override
						public void actionPerformed(ActionEvent e) {
							if (newHeight > 0) {
								newHeight -= 5; // Increase height by 5 pixels
								pixFrame.setSize(dialogWidth, newHeight); // Set new size
								pixFrame.revalidate();
								pixFrame.repaint();
							} else {
								((Timer) e.getSource()).stop(); // Stop the timer once target height is reached
								pixFrame.dispose();
							}
						}
					});
					fadeIn.start(); // Start the animation timer
				} else if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
					if (i < 4) {
						pixNmb[i].setNextFocusableComponent(pixNmb[i + 1]);
						pixNmb[i].nextFocus();
					} else {
						pixNmb[i].setNextFocusableComponent(pixNmb[0]);
						pixNmb[i].nextFocus();
					}
				} else if (ke.getKeyCode() == KeyEvent.VK_UP) {
					if (i > 0) {
						pixNmb[i].setNextFocusableComponent(pixNmb[i - 1]);
						pixNmb[i].nextFocus();
					} else {
						pixNmb[i].setNextFocusableComponent(pixNmb[4]);
						pixNmb[i].nextFocus();
					}
				}
			}
		});
	}

	/* Gastos frame if there is more than 4 */
	private void gastosFrame() {
		JDialog gastosDialog = new JDialog(this, gastosPanel.getText(), true);
		gastosDialog.setUndecorated(true);
		gastosDialog.setSize(gastosPanel.getWidth(), 0);
		gastosDialog.setLocation(gastosPanel.getLocationOnScreen().x,
				gastosPanel.getLocationOnScreen().y + gastosPanel.getHeight());
		gastosDialog.setResizable(false);
		gastosDialog.setLayout(null);

		JButton closeButton = new JButton(
				ImageEffect.changeOpacity(ImageEffect.getScaledImage(closeImage.getImage(), 10, 10).getImage(), 0.8f));
		closeButton.setBounds(gastosDialog.getWidth() - 12, 2, 10, 10); // Adjust button size
		closeButton.setBorderPainted(false);
		closeButton.setFocusPainted(false);
		closeButton.setContentAreaFilled(false);
		closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		closeButton.setToolTipText(getLocalizedMessage("EXIT"));
		closeButton.addActionListener(_ -> {
			// Animation to increase height gradually
			int targetHeight = gastosDialog.getHeight();
			int dialogWidth = gastosDialog.getWidth();
			Timer fadeIn = new Timer(5, new ActionListener() {
				private int newHeight = targetHeight; // Start height at zero
				// Target size for the dialog

				@Override
				public void actionPerformed(ActionEvent e) {
					if (newHeight > targetHeight / 2) {
						newHeight -= 5; // Increase height by 5 pixels
						gastosDialog.setSize(dialogWidth, newHeight); // Set new size
						gastosDialog.revalidate();
						gastosDialog.repaint();
					} else {
						((Timer) e.getSource()).stop(); // Stop the timer once target height is reached
						gastosDialog.dispose(); // Close the dialog when focus is lost
					}
				}
			});
			fadeIn.start(); // Start the animation timer
		});
		gastosDialog.add(closeButton);
		// Add the 16 text fields
		for (int i = 0; i < 16; i++) {
			textFieldStyle(gTable[i]);
			gTable[i].setBackground(gastosTable[i].getBackground());
			gTable[i].setCaretColor(gastosTable[i].getCaretColor());
			gTable[i].setBorder(gastosTable[i].getBorder());
			if (i < 8)
				gTable[i].setBounds(0, (gastosPanel.getHeight() - 1) * i, gastosTable[0].getWidth(),
						gastosPanel.getHeight());
			else
				gTable[i].setBounds(gastosTable[0].getWidth() - 1, (gastosPanel.getHeight() - 1) * (i - 8),
						gastosTable[8].getWidth(), gastosPanel.getHeight());
			gTable[i].removeFocusListener(textFocus);
			gTable[i].setForeground(Color.black);
			framesKA(gastosDialog, gastosPanel, i, gTable, gastosTable);

			gastosDialog.add(gTable[i]);

			gTable[i].addFocusListener(new FocusListener() {

				@Override
				public void focusLost(FocusEvent e) {
					for (int j = 0; j < 16; j++) { // TitleCase gastos and adjust font
						gTable[j].setText(TextEffect.capitalizeString(gTable[j].getText()));
						gTable[j].setFont(Intro.myFont);
						TextEffect.adjustFontSize(gTable[j]);
					}
				}

				@Override
				public void focusGained(FocusEvent e) {
					((JTextField) e.getSource()).selectAll();
				}
			});

		}

		// Target size for the dialog
		int targetHeight = (gastosPanel.getHeight() - 1) * 8 + 1;
		int dialogWidth = gastosPanel.getWidth();

		// Animation to increase height gradually
		Timer fadeIn = new Timer(5, new ActionListener() {
			private int newHeight = gastosPanel.getHeight() * 4; // Start height at zero

			@Override
			public void actionPerformed(ActionEvent e) {
				if (newHeight < targetHeight) {
					newHeight += 5; // Increase height by 5 pixels
					gastosDialog.setSize(dialogWidth, newHeight); // Set new size
					gastosDialog.revalidate();
					gastosDialog.repaint();
				} else {
					gastosDialog.setSize(dialogWidth, targetHeight); // Set new size
					((Timer) e.getSource()).stop(); // Stop the timer once target height is reached
				}
			}
		});
		fadeIn.start(); // Start the animation timer

		gastosDialog.setVisible(true); // Make the dialog visible
	}

	/* Agregados frame if there is more than 4 */
	private void aggFrame() {
		JDialog aggDialog = new JDialog(this, aggPanel.getText(), true);
		aggDialog.setUndecorated(true);
		aggDialog.setSize(aggPanel.getWidth(), 0);
		aggDialog.setLocation(aggPanel.getLocationOnScreen().x,
				aggPanel.getLocationOnScreen().y + aggPanel.getHeight());
		aggDialog.setResizable(false);
		aggDialog.setLayout(null);

		JButton closeButton = new JButton(
				ImageEffect.changeOpacity(ImageEffect.getScaledImage(closeImage.getImage(), 10, 10).getImage(), 0.8f));
		closeButton.setBounds(aggDialog.getWidth() - 12, 2, 10, 10); // Adjust button size
		closeButton.setBorderPainted(false);
		closeButton.setFocusPainted(false);
		closeButton.setContentAreaFilled(false);
		closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		closeButton.setToolTipText(getLocalizedMessage("EXIT"));
		closeButton.addActionListener(_ -> {
			// Animation to increase height gradually
			int targetHeight = aggDialog.getHeight();
			int dialogWidth = aggDialog.getWidth();
			Timer fadeIn = new Timer(5, new ActionListener() {
				private int newHeight = targetHeight; // Start height at zero
				// Target size for the dialog

				@Override
				public void actionPerformed(ActionEvent e) {
					if (newHeight > targetHeight / 2) {
						newHeight -= 5; // Increase height by 5 pixels
						aggDialog.setSize(dialogWidth, newHeight); // Set new size
						aggDialog.revalidate();
						aggDialog.repaint();
					} else {
						((Timer) e.getSource()).stop(); // Stop the timer once target height is reached
						aggDialog.dispose(); // Close the dialog when focus is lost
					}
				}
			});
			fadeIn.start(); // Start the animation timer
		});
		aggDialog.add(closeButton);
		for (int i = 0; i < 16; i++) {
			textFieldStyle(aTable[i]);
			aTable[i].setBackground(agregadoTable[i].getBackground());
			aTable[i].setCaretColor(agregadoTable[i].getCaretColor());
			aTable[i].setBorder(agregadoTable[i].getBorder());
			if (i < 8)
				aTable[i].setBounds(0, (aggPanel.getHeight() - 1) * i, agregadoTable[0].getWidth(),
						aggPanel.getHeight());
			else
				aTable[i].setBounds(agregadoTable[0].getWidth() - 1, (aggPanel.getHeight() - 1) * (i - 8),
						agregadoTable[8].getWidth(), aggPanel.getHeight());
			aTable[i].removeFocusListener(textFocus);
			aTable[i].setForeground(Color.black);
			framesKA(aggDialog, aggPanel, i, aTable, agregadoTable);
			aTable[i].addFocusListener(new FocusListener() {

				@Override
				public void focusLost(FocusEvent e) {
					for (int i = 0; i < 16; i++) { // TitleCase gastos and agg
						if (aTable[i].getText().equalsIgnoreCase("Separado") && !separadoYa) {
							separadoYa = true;
							separatedDialog(false);
						}
						aTable[i].setText(TextEffect.capitalizeString(aTable[i].getText()));
						aTable[i].setFont(Intro.myFont);
						TextEffect.adjustFontSize(aTable[i]);
					}
					int index = 0;
					while (index < 16) {
						if (aTable[index].getText().equalsIgnoreCase("Separado"))
							break;
						index++;
					}
					if (index == 16)
						separadoYa = false;
				}

				@Override
				public void focusGained(FocusEvent e) {
					((JTextField) e.getSource()).selectAll();
				}
			});
			aggDialog.add(aTable[i]);
		}

		// Target size for the dialog
		int targetHeight = (aggPanel.getHeight() - 1) * 8 + 1;
		int dialogWidth = aggPanel.getWidth();

		// Animation to increase height gradually
		Timer fadeIn = new Timer(5, new ActionListener() {
			private int newHeight = aggPanel.getHeight() * 4; // Start height at zero

			@Override
			public void actionPerformed(ActionEvent e) {
				if (newHeight < targetHeight) {
					newHeight += 5; // Increase height by 5 pixels
					aggDialog.setSize(dialogWidth, newHeight); // Set new size
					aggDialog.revalidate();
					aggDialog.repaint();
				} else {
					aggDialog.setSize(dialogWidth, targetHeight); // Set new size
					((Timer) e.getSource()).stop(); // Stop the timer once target height is reached
				}
			}
		});
		fadeIn.start(); // Start the animation timer

		aggDialog.setVisible(true);
	}

	/* gastos and agregador key listener */
	private void framesKA(JDialog gastosFrame, JButton btn, int i, JTextField[] table, JTextField[] tableG) {
		table[i].addKeyListener(new KeyAdapter() {// Escape to close

			@Override
			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
					for (int i = 0; i < 16; i++)
						tableG[i].setText(table[i].getText());
					sumF();
					// Animation to increase height gradually
					int targetHeight = gastosFrame.getHeight();
					int dialogWidth = gastosFrame.getWidth();
					Timer fadeIn = new Timer(5, new ActionListener() {
						private int newHeight = targetHeight; // Start height at zero
						// Target size for the dialog

						@Override
						public void actionPerformed(ActionEvent e) {
							if (newHeight > targetHeight / 2) {
								newHeight -= 5; // Increase height by 5 pixels
								gastosFrame.setSize(dialogWidth, newHeight); // Set new size
								gastosFrame.revalidate();
								gastosFrame.repaint();
							} else {
								((Timer) e.getSource()).stop(); // Stop the timer once target height is reached
								gastosFrame.dispose(); // Close the dialog when focus is lost
							}
						}
					});
					fadeIn.start(); // Start the animation timer
				} else if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
					if (i == 7) {
						table[i].setNextFocusableComponent(table[0]);
						table[i].nextFocus();
					} else if (i == 15) {
						table[i].setNextFocusableComponent(table[8]);
						table[i].nextFocus();
					} else {
						table[i].setNextFocusableComponent(table[i + 1]);
						table[i].nextFocus();
					}
				} else if (ke.getKeyCode() == KeyEvent.VK_UP) {
					if (i == 0) {
						table[i].setNextFocusableComponent(table[7]);
						table[i].nextFocus();
					} else if (i == 8) {
						table[i].setNextFocusableComponent(table[15]);
						table[i].nextFocus();
					} else {
						table[i].setNextFocusableComponent(table[i - 1]);
						table[i].nextFocus();
					}
				} else if (ke.getKeyCode() == KeyEvent.VK_RIGHT || ke.getKeyCode() == KeyEvent.VK_LEFT) {
					if (i < 8) {
						table[i].setNextFocusableComponent(table[i + 8]);
						table[i].nextFocus();
					} else {
						table[i].setNextFocusableComponent(table[i - 8]);
						table[i].nextFocus();
					}
				}
			}
		});
	}

	/* Import the Separated values */
	private void importSep() {
		// separated decrypt
		BufferedReader sepOpened = null;
		String sepLine = "";
		int sepInt = 0;
		dataFolder.mkdir();
		File tempFile1 = new File(dataFolder + "\\extra");
		tempFile1.mkdir();
		File sepFile = new File(tempFile1, "SEP" + ".dll");
		try {
			if (!sepFile.exists())
				sepFile.createNewFile();
			sepOpened = new BufferedReader(new FileReader(sepFile));
			while ((sepLine = sepOpened.readLine()) != null)
				sepData[sepInt++] = sepLine.toString();
			sepOpened.close();
		} catch (Exception e) {
			writeError(e);
		}
		/* Check if there is no saved data */
		if (sepData[0] == null || sepInt != 42) {
			sepInt = 0;
			while (sepInt < 42) {
				sepData[sepInt] = "";
				sepInt++;
			}
		}
		/* Check if there is no saved data End */
		/* Decrypt the values Start */
		sepInt = 0;
		for (int i = 0; i < 14; i++)
			for (int j = 0; j < 3; j++)
				sepData[sepInt] = encrypt.decrypt(sepData[sepInt++]);
		/* Decrypt the values End */
	}

	/* The date according to the choosing language */
	private void dateLang(Language lang) {
		if (lang == Language.SPANISH) {
			monthS = new SimpleDateFormat("MMMM", new Locale("es")).format(Calendar.getInstance().getTime())
					.toUpperCase();
			dayS = new SimpleDateFormat("EEEE", new Locale("es")).format(Calendar.getInstance().getTime())
					.toUpperCase();
		} else if (lang == Language.PORTUGUES) {
			monthS = new SimpleDateFormat("MMMM", new Locale("pt")).format(Calendar.getInstance().getTime())
					.toUpperCase();
			dayS = new SimpleDateFormat("EEEE", new Locale("pt")).format(Calendar.getInstance().getTime())
					.toUpperCase();
		} else if (lang == Language.ENGLISH) {
			monthS = new SimpleDateFormat("MMMM", new Locale("en")).format(Calendar.getInstance().getTime())
					.toUpperCase();
			dayS = new SimpleDateFormat("EEEE", new Locale("en")).format(Calendar.getInstance().getTime())
					.toUpperCase();
		} else {
			monthS = new SimpleDateFormat("MMMM", new Locale("fr")).format(Calendar.getInstance().getTime())
					.toUpperCase();
			dayS = new SimpleDateFormat("EEEE", new Locale("fr")).format(Calendar.getInstance().getTime())
					.toUpperCase();
		}
	}

	/* Locked Frame */
	private void lockFrame() {
		if (conf[1] == null || conf[1].equalsIgnoreCase("null") || conf[1].equals("false"))
			soundEffect(lockSound);
		// blured THE BACKGROUND
		Container contentPane = getContentPane();
		Point loc = contentPane.getLocationOnScreen();
		Dimension size = contentPane.getSize();
		JLabel blurI = new JLabel();
		try {
			Rectangle captureArea = new Rectangle(loc.x, loc.y, size.width, size.height);
			BufferedImage screenshot = new Robot().createScreenCapture(captureArea);
			blurI.setIcon(new ImageIcon(new ImageBlur().blurImage(screenshot)));
		} catch (Exception e) {
			writeError(e);
		}
		blurI.setBounds(0, 0, size.width, size.height);
		// HIDE ALL COMPONENT
		boolean table1 = details[0][0].isVisible();
		Component[] components = getContentPane().getComponents();
		for (Component component : components) {
			if (component instanceof JComponent) {
				((JComponent) component).setVisible(false);
			}
		}
		isBlured = true;
		add(blurI);

		int countAttemp = 0;
		lockDialog.showMessage(getLocalizedMessage("PASSWORD_W"), getLocalizedMessage("TRIES") + (5 - countAttemp));
		String usario = lockDialog.getPassword();
		while (!usario.equalsIgnoreCase(correctPassword)) {
			if (conf[1] == null || conf[1].equalsIgnoreCase("null") || conf[1].equals("false"))
				soundEffect(wrongSound);
			if (lockDialog.getMessageType() == PasswordDialog.MessageType.CANCEL || countAttemp == 4)
				System.exit(0);
			lockDialog.showMessage(getLocalizedMessage("TRY_AGAIN"),
					getLocalizedMessage("TRIES") + (5 - (++countAttemp)));
			usario = lockDialog.getPassword();
		}
		if (conf[1] == null || conf[1].equalsIgnoreCase("null") || conf[1].equals("false"))
			soundEffect(enterSound);
		remove(blurI);
		for (Component component : getContentPane().getComponents()) {
			boolean isPartOfDetails = false;
			if (table1)
				for (JTextField[] row : detailsM) {
					for (JTextField field : row) {
						if (component == field) {
							isPartOfDetails = true;
							break;
						}
					}
					if (isPartOfDetails)
						break;
				}
			else
				for (JTextField[] row : details) {
					for (JTextField field : row) {
						if (component == field) {
							isPartOfDetails = true;
							break;
						}
					}
					if (isPartOfDetails)
						break;
				}
			if (!isPartOfDetails) {
				component.setVisible(true); // Make visible if not part of details
			}
		}
		if (conf[16].equals("false"))
			dateLabel.setVisible(true);
		else
			dateLabel.setVisible(false);
		isBlured = false;
		SwingUtilities.updateComponentTreeUI(this);
		sumF();

		// Restore the focus back to the previously focused component
		if (focusedComponent != null) {
			focusedComponent.requestFocusInWindow();
		}
	}

	/* ScreenShoot the main frame */
	private void screenShooter() {
		File yearF = new File(dataFolder + "\\" + yearS);
		yearF.mkdir();
		File monthF = new File(yearF + "\\" + currentDate.m + "-" + monthS);
		monthF.mkdir();
		File imgFolder = new File(monthF + "\\IMG");
		imgFolder.mkdir();
		File screenshootFile = new File(imgFolder, "$ " + dayN + "-" + monthS + "-" + yearS + ".png");
		try {
			Container contentPane = getContentPane();
			Point loc = contentPane.getLocationOnScreen();
			Dimension size = contentPane.getSize();
			Rectangle captureArea = new Rectangle(loc.x, loc.y, size.width, size.height);
			BufferedImage screenshot = new Robot().createScreenCapture(captureArea);
			ImageIO.write(screenshot, "png", screenshootFile);

		} catch (Exception e) {
			writeError(e);
		}
		if (conf[1] == null || conf[1].equalsIgnoreCase("null") || conf[1].equals("false"))
			soundEffect(screenSound);
	}

	/* Auto screenshot */
	public void autoUpdate(int hour, int min) {
		java.util.Timer refreshTimer = new java.util.Timer();
		java.util.TimerTask refreshTask = new java.util.TimerTask() {

			@Override
			public void run() {
				/* Check if we already did the cash */
				dataFolder.mkdir();
				File tempFile1 = new File(dataFolder + "\\" + yearS);
				tempFile1.mkdir();
				File tempFile2 = new File(tempFile1 + "\\" + currentDate.m + "-" + monthS);
				tempFile2.mkdir();
				File newFile = new File(tempFile2, "$ " + dayN + "-" + currentDate.m + " (" + dayS + ").txt");
				/* Check if we already did the cash */
				/* If we did the cash */
				if (!newFile.exists()) {
					// Bring the frame to the front
					setState(Frame.NORMAL); // Restore if minimized
					toFront(); // Bring the frame to the front
					requestFocus(); // Request focus for the frame
					if (!isBlured) {// if the screen is not locked
						screenShooter();// SCREENSHOT
						Toast.show(Main.this, Toast.Type.INFO, getLocalizedMessage("UPDATE_C"), Intro.notOption);
					} else {// if the screen is locked
						new SwingWorker<Void, Void>() {
							@Override
							protected Void doInBackground() throws Exception {
								// Unlock the dialog
								lockDialog.autoUnlock();

								// Wait for 1.4 seconds to allow unlocking to complete
								Thread.sleep(1400);

								// Capture the screenshot
								screenShooter();
								return null;
							}

							@Override
							protected void done() {
								// Re-lock the frame once screenshot is taken
								lockFrame();
							}
						}.execute();
					}
				}
				/* If we did not the cash = Do nothing */
			}
		};
		Calendar date = Calendar.getInstance();
		Calendar date1 = Calendar.getInstance();
		date1.set(Calendar.HOUR_OF_DAY, hour);
		date1.set(Calendar.MINUTE, min);
		date1.set(Calendar.SECOND, 0);
		date1.set(Calendar.MILLISECOND, 0);
		if ((date.getTime().getHours() == hour && date.getTime().getMinutes() > min)
				|| date.getTime().getHours() > hour)
			refreshTimer.cancel();
		else
			refreshTimer.schedule(refreshTask, date1.getTime());
	}

	/* Summary change action listener */
	private void summaryActionListener(JMenuItem sumV1, JMenuItem sumV2, JMenuItem sumV3, JMenuItem sumV4) {
		sumV1.addActionListener(_ -> {
			effChooser = 0;
			sumV1.setEnabled(false);
			sumV2.setEnabled(true);
			sumV3.setEnabled(true);
			sumV4.setEnabled(true);
			conf[8] = "0";
			try {
				FileWriter savedF = new FileWriter(confFile);
				savedF.write((conf[0].equals("null") ? 0 : conf[0]) + System.lineSeparator());
				savedF.write((conf[1].equals("null") ? "false" : conf[1]) + System.lineSeparator());
				savedF.write((conf[2].equals("null") ? "false" : conf[2]) + System.lineSeparator());
				savedF.write((conf[3].equals("null") ? 10 : conf[3]) + System.lineSeparator());
				savedF.write((conf[4].equals("null") ? "false" : conf[4]) + System.lineSeparator());
				savedF.write((conf[5].equals("null") ? 0 : conf[5]) + System.lineSeparator());
				savedF.write((conf[6].equals("null") ? 0 : conf[6]) + System.lineSeparator());// speed
				savedF.write((conf[7].equals("null") ? 0 : conf[7]) + System.lineSeparator());// lan
				savedF.write(0 + System.lineSeparator());// effect chooser
				savedF.write((conf[9].equals("null") ? "true" : conf[9]) + System.lineSeparator());// intro
				savedF.write((conf[10].equals("null") ? "0" : conf[10]) + System.lineSeparator());// theme
				savedF.write((conf[11].equals("null") ? "1" : conf[11]) + System.lineSeparator());// ani
				savedF.write((conf[12].equals("null") ? "true" : conf[12]) + System.lineSeparator());// alwaystop
				savedF.write((conf[13].equals("null") ? "false" : conf[13]) + System.lineSeparator());// autoupdate
				savedF.write((conf[14].equals("null") ? "0" : conf[14]) + System.lineSeparator());// style
				savedF.write((conf[15].equals("null") ? "false" : conf[15]) + System.lineSeparator());// DOCK
				savedF.write((conf[16].equals("null") ? "false" : conf[16]) + System.lineSeparator());// DATE
				savedF.write((conf[17].equals("null") ? "false" : conf[17]) + System.lineSeparator());// NOT
				savedF.write((conf[18].equals("null") ? "false" : conf[18]) + System.lineSeparator());// autoclean
				savedF.write((conf[19].equals("null") ? "false" : conf[19]) + System.lineSeparator());// stock
				savedF.write((conf[20].equals("null") ? "false" : conf[20]) + System.lineSeparator());// EVENT
				savedF.write((conf[21].equals("null") ? "false" : conf[21]) + System.lineSeparator());// SAVE STK
				savedF.write((conf[22].equals("null") ? "0" : conf[22]) + System.lineSeparator());// SORT ST
				savedF.write((conf[23].equals("null") ? "true" : conf[23]) + System.lineSeparator());// SHOW LIC
				savedF.write((conf[24].equals("null") ? "0" : conf[24]) + System.lineSeparator());// not pos
				savedF.write((conf[25].equals("null") ? 3 : conf[25]) + System.lineSeparator()); // not timer
				savedF.write((conf[26].equals("null") ? "false" : conf[26]) + System.lineSeparator());// not bg
				savedF.close();
			} catch (Exception e) {
				writeError(e);
			}
		});
		sumV2.addActionListener(_ -> {
			effChooser = 1;
			sumV1.setEnabled(true);
			sumV2.setEnabled(false);
			sumV3.setEnabled(true);
			sumV4.setEnabled(true);
			conf[8] = "1";
			try {
				FileWriter savedF = new FileWriter(confFile);
				savedF.write((conf[0].equals("null") ? 0 : conf[0]) + System.lineSeparator());
				savedF.write((conf[1].equals("null") ? "false" : conf[1]) + System.lineSeparator());
				savedF.write((conf[2].equals("null") ? "false" : conf[2]) + System.lineSeparator());
				savedF.write((conf[3].equals("null") ? 10 : conf[3]) + System.lineSeparator());
				savedF.write((conf[4].equals("null") ? "false" : conf[4]) + System.lineSeparator());
				savedF.write((conf[5].equals("null") ? 0 : conf[5]) + System.lineSeparator());
				savedF.write((conf[6].equals("null") ? 0 : conf[6]) + System.lineSeparator());// speed
				savedF.write((conf[7].equals("null") ? 0 : conf[7]) + System.lineSeparator());// lan
				savedF.write(1 + System.lineSeparator());// effect chooser
				savedF.write((conf[9].equals("null") ? "true" : conf[9]) + System.lineSeparator());// intro
				savedF.write((conf[10].equals("null") ? "0" : conf[10]) + System.lineSeparator());// theme
				savedF.write((conf[11].equals("null") ? "1" : conf[11]) + System.lineSeparator());// theme
				savedF.write((conf[12].equals("null") ? "true" : conf[12]) + System.lineSeparator());// alwaystop
				savedF.write((conf[13].equals("null") ? "false" : conf[13]) + System.lineSeparator());// autoupdate
				savedF.write((conf[14].equals("null") ? "0" : conf[14]) + System.lineSeparator());// style
				savedF.write((conf[15].equals("null") ? "false" : conf[15]) + System.lineSeparator());// DOCK
				savedF.write((conf[16].equals("null") ? "false" : conf[16]) + System.lineSeparator());// DATE
				savedF.write((conf[17].equals("null") ? "false" : conf[17]) + System.lineSeparator());// NOT
				savedF.write((conf[18].equals("null") ? "false" : conf[18]) + System.lineSeparator());// autoclean
				savedF.write((conf[19].equals("null") ? "false" : conf[19]) + System.lineSeparator());// stock
				savedF.write((conf[20].equals("null") ? "false" : conf[20]) + System.lineSeparator());// EVENT
				savedF.write((conf[21].equals("null") ? "false" : conf[21]) + System.lineSeparator());// SAVE STK
				savedF.write((conf[22].equals("null") ? "0" : conf[22]) + System.lineSeparator());// SORT ST
				savedF.write((conf[23].equals("null") ? "true" : conf[23]) + System.lineSeparator());// SHOW LIC
				savedF.write((conf[24].equals("null") ? "0" : conf[24]) + System.lineSeparator());// not pos
				savedF.write((conf[25].equals("null") ? 3 : conf[25]) + System.lineSeparator()); // not timer
				savedF.write((conf[26].equals("null") ? "false" : conf[26]) + System.lineSeparator());// not bg
				savedF.close();
			} catch (Exception e) {
				writeError(e);
			}
		});
		sumV3.addActionListener(_ -> {
			effChooser = 2;
			sumV1.setEnabled(true);
			sumV2.setEnabled(true);
			sumV3.setEnabled(false);
			conf[8] = "2";
			try {
				FileWriter savedF = new FileWriter(confFile);
				savedF.write((conf[0].equals("null") ? 0 : conf[0]) + System.lineSeparator());
				savedF.write((conf[1].equals("null") ? "false" : conf[1]) + System.lineSeparator());
				savedF.write((conf[2].equals("null") ? "false" : conf[2]) + System.lineSeparator());
				savedF.write((conf[3].equals("null") ? 10 : conf[3]) + System.lineSeparator());
				savedF.write((conf[4].equals("null") ? "false" : conf[4]) + System.lineSeparator());
				savedF.write((conf[5].equals("null") ? 0 : conf[5]) + System.lineSeparator());
				savedF.write((conf[6].equals("null") ? 0 : conf[6]) + System.lineSeparator());// speed
				savedF.write((conf[7].equals("null") ? 0 : conf[7]) + System.lineSeparator());// lan
				savedF.write(2 + System.lineSeparator());// effect chooser
				savedF.write((conf[9].equals("null") ? "true" : conf[9]) + System.lineSeparator());// intro
				savedF.write((conf[10].equals("null") ? 0 : conf[10]) + System.lineSeparator());// theme
				savedF.write((conf[11].equals("null") ? "1" : conf[11]) + System.lineSeparator());// theme
				savedF.write((conf[12].equals("null") ? "true" : conf[12]) + System.lineSeparator());// alwaystop
				savedF.write((conf[13].equals("null") ? "false" : conf[13]) + System.lineSeparator());// autoupdate
				savedF.write((conf[14].equals("null") ? "0" : conf[14]) + System.lineSeparator());// style
				savedF.write((conf[15].equals("null") ? "false" : conf[15]) + System.lineSeparator());// DOCK
				savedF.write((conf[16].equals("null") ? "false" : conf[16]) + System.lineSeparator());// DATE
				savedF.write((conf[17].equals("null") ? "false" : conf[17]) + System.lineSeparator());// NOT
				savedF.write((conf[18].equals("null") ? "false" : conf[18]) + System.lineSeparator());// autoclean
				savedF.write((conf[19].equals("null") ? "false" : conf[19]) + System.lineSeparator());// stock
				savedF.write((conf[20].equals("null") ? "false" : conf[20]) + System.lineSeparator());// EVENT
				savedF.write((conf[21].equals("null") ? "false" : conf[21]) + System.lineSeparator());// SAVE STK
				savedF.write((conf[22].equals("null") ? "0" : conf[22]) + System.lineSeparator());// SORT ST
				savedF.write((conf[23].equals("null") ? "true" : conf[23]) + System.lineSeparator());// SHOW LIC
				savedF.write((conf[24].equals("null") ? "0" : conf[24]) + System.lineSeparator());// not pos
				savedF.write((conf[25].equals("null") ? 3 : conf[25]) + System.lineSeparator()); // not timer
				savedF.write((conf[26].equals("null") ? "false" : conf[26]) + System.lineSeparator());// not bg
				savedF.close();
			} catch (Exception e) {
				writeError(e);
			}
		});
		sumV4.addActionListener(_ -> {
			effChooser = 3;
			sumV1.setEnabled(true);
			sumV2.setEnabled(true);
			sumV3.setEnabled(true);
			sumV4.setEnabled(false);
			conf[8] = "3";
			try {
				FileWriter savedF = new FileWriter(confFile);
				savedF.write((conf[0].equals("null") ? 0 : conf[0]) + System.lineSeparator());
				savedF.write((conf[1].equals("null") ? "false" : conf[1]) + System.lineSeparator());
				savedF.write((conf[2].equals("null") ? "false" : conf[2]) + System.lineSeparator());
				savedF.write((conf[3].equals("null") ? 10 : conf[3]) + System.lineSeparator());
				savedF.write((conf[4].equals("null") ? "false" : conf[4]) + System.lineSeparator());
				savedF.write((conf[5].equals("null") ? 0 : conf[5]) + System.lineSeparator());
				savedF.write((conf[6].equals("null") ? 0 : conf[6]) + System.lineSeparator());// speed
				savedF.write((conf[7].equals("null") ? 0 : conf[7]) + System.lineSeparator());// lan
				savedF.write(3 + System.lineSeparator());// effect chooser
				savedF.write((conf[9].equals("null") ? "true" : conf[9]) + System.lineSeparator());// intro
				savedF.write((conf[10].equals("null") ? "0" : conf[10]) + System.lineSeparator());// theme
				savedF.write((conf[11].equals("null") ? "1" : conf[11]) + System.lineSeparator());// theme
				savedF.write((conf[12].equals("null") ? "true" : conf[12]) + System.lineSeparator());// alwaystop
				savedF.write((conf[13].equals("null") ? "false" : conf[13]) + System.lineSeparator());// autoupdate
				savedF.write((conf[14].equals("null") ? "0" : conf[14]) + System.lineSeparator());// style
				savedF.write((conf[15].equals("null") ? "false" : conf[15]) + System.lineSeparator());// DOCK
				savedF.write((conf[16].equals("null") ? "false" : conf[16]) + System.lineSeparator());// DATE
				savedF.write((conf[17].equals("null") ? "false" : conf[17]) + System.lineSeparator());// NOT
				savedF.write((conf[18].equals("null") ? "false" : conf[18]) + System.lineSeparator());// autoclean
				savedF.write((conf[19].equals("null") ? "false" : conf[19]) + System.lineSeparator());// stock
				savedF.write((conf[20].equals("null") ? "false" : conf[20]) + System.lineSeparator());// EVENT
				savedF.write((conf[21].equals("null") ? "false" : conf[21]) + System.lineSeparator());// SAVE STK
				savedF.write((conf[22].equals("null") ? "0" : conf[22]) + System.lineSeparator());// SORT ST
				savedF.write((conf[23].equals("null") ? "true" : conf[23]) + System.lineSeparator());// SHOW LIC
				savedF.write((conf[24].equals("null") ? "0" : conf[24]) + System.lineSeparator());// not pos
				savedF.write((conf[25].equals("null") ? 3 : conf[25]) + System.lineSeparator()); // not timer
				savedF.write((conf[26].equals("null") ? "false" : conf[26]) + System.lineSeparator());// not bg
				savedF.close();
			} catch (Exception e) {
				writeError(e);
			}
		});
	}

	/* Change speed of animation action listener */
	private void speedActionListener(JMenuItem speed1, JMenuItem speed2, JMenuItem speed3) {
		speed1.addActionListener(_ -> {
			conf[6] = "0";
			try {
				FileWriter savedF = new FileWriter(confFile);
				savedF.write((conf[0].equals("null") ? 0 : conf[0]) + System.lineSeparator());
				savedF.write((conf[1].equals("null") ? "false" : conf[1]) + System.lineSeparator());
				savedF.write((conf[2].equals("null") ? "false" : conf[2]) + System.lineSeparator());
				savedF.write((conf[3].equals("null") ? 10 : conf[3]) + System.lineSeparator());
				savedF.write((conf[4].equals("null") ? "false" : conf[4]) + System.lineSeparator());
				savedF.write((conf[5].equals("null") ? 0 : conf[5]) + System.lineSeparator());
				savedF.write(0 + System.lineSeparator());// speed
				savedF.write((conf[7].equals("null") ? 0 : conf[7]) + System.lineSeparator());// lan
				savedF.write((conf[8].equals("null") ? 0 : conf[8]) + System.lineSeparator());// effchooser
				savedF.write((conf[9].equals("null") ? "true" : conf[9]) + System.lineSeparator());// intro
				savedF.write((conf[10].equals("null") ? "0" : conf[10]) + System.lineSeparator());// theme
				savedF.write((conf[11].equals("null") ? "1" : conf[11]) + System.lineSeparator());// theme
				savedF.write((conf[12].equals("null") ? "true" : conf[12]) + System.lineSeparator());// alwaystop
				savedF.write((conf[13].equals("null") ? "false" : conf[13]) + System.lineSeparator());// autoupdate
				savedF.write((conf[14].equals("null") ? "0" : conf[14]) + System.lineSeparator());// style
				savedF.write((conf[15].equals("null") ? "false" : conf[15]) + System.lineSeparator());// DOCK
				savedF.write((conf[16].equals("null") ? "false" : conf[16]) + System.lineSeparator());// DATE
				savedF.write((conf[17].equals("null") ? "false" : conf[17]) + System.lineSeparator());// NOT
				savedF.write((conf[18].equals("null") ? "false" : conf[18]) + System.lineSeparator());// autoclean
				savedF.write((conf[19].equals("null") ? "false" : conf[19]) + System.lineSeparator());// stock
				savedF.write((conf[20].equals("null") ? "false" : conf[20]) + System.lineSeparator());// EVENT
				savedF.write((conf[21].equals("null") ? "false" : conf[21]) + System.lineSeparator());// SAVE STK
				savedF.write((conf[22].equals("null") ? "0" : conf[22]) + System.lineSeparator());// SORT ST
				savedF.write((conf[23].equals("null") ? "true" : conf[23]) + System.lineSeparator());// SHOW LIC
				savedF.write((conf[24].equals("null") ? "0" : conf[24]) + System.lineSeparator());// not pos
				savedF.write((conf[25].equals("null") ? 3 : conf[25]) + System.lineSeparator()); // not timer
				savedF.write((conf[26].equals("null") ? "false" : conf[26]) + System.lineSeparator());// not bg
				savedF.close();
			} catch (Exception e) {
				writeError(e);
			}
			speed1.setEnabled(false);
			speed2.setEnabled(true);
			speed3.setEnabled(true);
		});
		speed2.addActionListener(_ -> {
			conf[6] = "1";
			try {
				FileWriter savedF = new FileWriter(confFile);
				savedF.write((conf[0].equals("null") ? 0 : conf[0]) + System.lineSeparator());
				savedF.write((conf[1].equals("null") ? "false" : conf[1]) + System.lineSeparator());
				savedF.write((conf[2].equals("null") ? "false" : conf[2]) + System.lineSeparator());
				savedF.write((conf[3].equals("null") ? 10 : conf[3]) + System.lineSeparator());
				savedF.write((conf[4].equals("null") ? "false" : conf[4]) + System.lineSeparator());
				savedF.write((conf[5].equals("null") ? 0 : conf[5]) + System.lineSeparator());
				savedF.write(1 + System.lineSeparator());
				savedF.write((conf[7].equals("null") ? 0 : conf[7]) + System.lineSeparator());// lan
				savedF.write((conf[8].equals("null") ? 0 : conf[8]) + System.lineSeparator());// effchooser
				savedF.write((conf[9].equals("null") ? "true" : conf[9]) + System.lineSeparator());// intro
				savedF.write((conf[10].equals("null") ? "0" : conf[10]) + System.lineSeparator());// theme
				savedF.write((conf[11].equals("null") ? "1" : conf[11]) + System.lineSeparator());// theme
				savedF.write((conf[12].equals("null") ? "true" : conf[12]) + System.lineSeparator());// alwaystop
				savedF.write((conf[13].equals("null") ? "false" : conf[13]) + System.lineSeparator());// autoupdate
				savedF.write((conf[14].equals("null") ? "0" : conf[14]) + System.lineSeparator());// style
				savedF.write((conf[15].equals("null") ? "false" : conf[15]) + System.lineSeparator());// DOCK
				savedF.write((conf[16].equals("null") ? "false" : conf[16]) + System.lineSeparator());// DATE
				savedF.write((conf[17].equals("null") ? "false" : conf[17]) + System.lineSeparator());// NOT
				savedF.write((conf[18].equals("null") ? "false" : conf[18]) + System.lineSeparator());// autoclean
				savedF.write((conf[19].equals("null") ? "false" : conf[19]) + System.lineSeparator());// stock
				savedF.write((conf[20].equals("null") ? "false" : conf[20]) + System.lineSeparator());// EVENT
				savedF.write((conf[21].equals("null") ? "false" : conf[21]) + System.lineSeparator());// SAVE STK
				savedF.write((conf[22].equals("null") ? "0" : conf[22]) + System.lineSeparator());// SORT ST
				savedF.write((conf[23].equals("null") ? "true" : conf[23]) + System.lineSeparator());// SHOW LIC
				savedF.write((conf[24].equals("null") ? "0" : conf[24]) + System.lineSeparator());// not pos
				savedF.write((conf[25].equals("null") ? 3 : conf[25]) + System.lineSeparator()); // not timer
				savedF.write((conf[26].equals("null") ? "false" : conf[26]) + System.lineSeparator());// not bg
				savedF.close();
			} catch (Exception e) {
				writeError(e);
			}
			speed1.setEnabled(true);
			speed2.setEnabled(false);
			speed3.setEnabled(true);
		});
		speed3.addActionListener(_ -> {
			conf[6] = "2";
			try {
				FileWriter savedF = new FileWriter(confFile);
				savedF.write((conf[0].equals("null") ? 0 : conf[0]) + System.lineSeparator());
				savedF.write((conf[1].equals("null") ? "false" : conf[1]) + System.lineSeparator());
				savedF.write((conf[2].equals("null") ? "false" : conf[2]) + System.lineSeparator());
				savedF.write((conf[3].equals("null") ? 10 : conf[3]) + System.lineSeparator());
				savedF.write((conf[4].equals("null") ? "false" : conf[4]) + System.lineSeparator());
				savedF.write((conf[5].equals("null") ? 0 : conf[5]) + System.lineSeparator());
				savedF.write(2 + System.lineSeparator());
				savedF.write((conf[7].equals("null") ? 0 : conf[7]) + System.lineSeparator());// lan
				savedF.write((conf[8].equals("null") ? 0 : conf[8]) + System.lineSeparator());// effchooser
				savedF.write((conf[9].equals("null") ? "true" : conf[9]) + System.lineSeparator());// intro
				savedF.write((conf[10].equals("null") ? "0" : conf[10]) + System.lineSeparator());// theme
				savedF.write((conf[11].equals("null") ? "1" : conf[11]) + System.lineSeparator());// theme
				savedF.write((conf[12].equals("null") ? "true" : conf[12]) + System.lineSeparator());// alwaystop
				savedF.write((conf[13].equals("null") ? "false" : conf[13]) + System.lineSeparator());// autoupdate
				savedF.write((conf[14].equals("null") ? "0" : conf[14]) + System.lineSeparator());// style
				savedF.write((conf[15].equals("null") ? "false" : conf[15]) + System.lineSeparator());// DOCK
				savedF.write((conf[16].equals("null") ? "false" : conf[16]) + System.lineSeparator());// DATE
				savedF.write((conf[17].equals("null") ? "false" : conf[17]) + System.lineSeparator());// NOT
				savedF.write((conf[18].equals("null") ? "false" : conf[18]) + System.lineSeparator());// autoclean
				savedF.write((conf[19].equals("null") ? "false" : conf[19]) + System.lineSeparator());// stock
				savedF.write((conf[20].equals("null") ? "false" : conf[20]) + System.lineSeparator());// EVENT
				savedF.write((conf[21].equals("null") ? "false" : conf[21]) + System.lineSeparator());// SAVE STK
				savedF.write((conf[22].equals("null") ? "0" : conf[22]) + System.lineSeparator());// SORT ST
				savedF.write((conf[23].equals("null") ? "true" : conf[23]) + System.lineSeparator());// SHOW LIC
				savedF.write((conf[24].equals("null") ? "0" : conf[24]) + System.lineSeparator());// not pos
				savedF.write((conf[25].equals("null") ? 3 : conf[25]) + System.lineSeparator()); // not timer
				savedF.write((conf[26].equals("null") ? "false" : conf[26]) + System.lineSeparator());// not bg
				savedF.close();
			} catch (Exception e) {
				writeError(e);
			}
			speed1.setEnabled(true);
			speed2.setEnabled(true);
			speed3.setEnabled(false);
		});
	}

	/* Day name according to the date(monday,...) */
	private String dayName(DateModified d, int lang) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, d.d);
		calendar.set(Calendar.MONTH, d.m - 1);
		calendar.set(Calendar.YEAR, d.y);

		return lang == 0 ? new SimpleDateFormat("EEEEE", new Locale("es")).format(calendar.getTime()).toUpperCase()
				: lang == 1 ? new SimpleDateFormat("EEEE", new Locale("pt")).format(calendar.getTime()).toUpperCase()
						: lang == 2
								? new SimpleDateFormat("EEEEE", new Locale("en")).format(calendar.getTime())
										.toUpperCase()
								: new SimpleDateFormat("EEEEE", new Locale("fr")).format(calendar.getTime())
										.toUpperCase();
	}

	/* Day name according to the date(monday,...) */
	private String dayName(String date, int lang) {
		int d = Integer.valueOf(date.substring(0, 2)), m = Integer.valueOf(date.substring(3, 5)),
				y = Integer.valueOf(date.substring(6, 10));
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, d);
		calendar.set(Calendar.MONTH, m - 1);
		calendar.set(Calendar.YEAR, y);

		return lang == 0 ? new SimpleDateFormat("EEEEE", new Locale("es")).format(calendar.getTime()).toUpperCase()
				: lang == 1 ? new SimpleDateFormat("EEEE", new Locale("pt")).format(calendar.getTime()).toUpperCase()
						: lang == 2
								? new SimpleDateFormat("EEEEE", new Locale("en")).format(calendar.getTime())
										.toUpperCase()
								: new SimpleDateFormat("EEEEE", new Locale("fr")).format(calendar.getTime())
										.toUpperCase();
	}

	/* return the month name acc to its number and language */
	private String getMonthForInt(int num, int language) {
		String months[][] = {
				{ "enero", "febrero", "marzo", "Abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre",
						"noviembre", "diciembre" },
				{ "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro",
						"Novembro", "Dezembro" },
				{ "January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
						"November", "December" },
				{ "janvier", "février", "mars", "avril", "mai", "juin", "juillet", "août", "septembre", "octobre",
						"novembre", "décembre" } };
		return months[language][num].toUpperCase();
	}

	/* Calculator panel */
	private void calculatorFunction() {
		JDialog calculator = new JDialog(this, getLocalizedMessage("CALCULATOR"), true);
		calculator.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		calculator.setAlwaysOnTop(true);
		calculator.setPreferredSize(new Dimension(400, 400));
		calculator.setIconImage(colorSelected == 2 ? ImageEffect.getScaledImage(calcI.getImage(), 35, 35).getImage()
				: ImageEffect.invertColor(ImageEffect.getScaledImage(calcI.getImage(), 35, 35)).getImage());

		CalculatorPanel calculatorPanel = new CalculatorPanel(calculator);
		calculator.add(calculatorPanel);
		calculator.pack();
		calculator.setLocationRelativeTo(null);
		calculator.setResizable(false);
		calculator.setVisible(true);
	}

	/* Copy the text to the clipboard */
	private void copyToClipboard(String text) {
		long integerValue = (long) Double.parseDouble(text);
		StringSelection stringSelection = new StringSelection(String.valueOf(integerValue));
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
	}

	/* The panel of the new more table */
	private void moreTables() {
		if (details[0][0].isVisible())
			for (int i = 0; i < 6; i++)
				for (int j = 0; j < 20; j++) {
					details[i][j].setVisible(false);
					detailsM[i][j].setVisible(true);
					details[i][j].setNextFocusableComponent(detailsM[0][0]);
					details[i][j].nextFocus();
				}
		else {
			for (int i = 0; i < 6; i++)
				for (int j = 0; j < 20; j++) {
					details[i][j].setVisible(true);
					detailsM[i][j].setVisible(false);
					detailsM[i][j].setNextFocusableComponent(details[0][0]);
					detailsM[i][j].nextFocus();
				}
		}
	}

	/* Check if the tables is full to show the more button */
	private boolean checkIfFull() {
		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 20; j++)
				if (details[i][j].getText().isBlank())
					return false;
		return true;

	}

	/* Notification when its time to end the day */
	private void timeToClose() {
		java.util.Timer timer = new java.util.Timer();
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				Toast.show(Main.this, Toast.Type.WARNING, getLocalizedMessage("CLOSE_TIME"), Intro.notOption);
			}
		};
		Calendar date = Calendar.getInstance();
		Calendar date1 = Calendar.getInstance();
		date.set(Calendar.HOUR_OF_DAY, 17);
		date.set(Calendar.MINUTE, 29);
		date.set(Calendar.SECOND, 59);
		date.set(Calendar.MILLISECOND, 0);
		if ((date1.getTime().getHours() == 17 && date1.getTime().getMinutes() > 58) || date1.getTime().getHours() > 17)
			timer.cancel();
		else
			timer.schedule(task, date.getTime());
	}

	/* Dialog to add/remove shortkey for bills and aggregates */
	private void keywordsDialog() {
		// Create a dialog for the merchandise table
		JDialog dialog = new JDialog(this, getLocalizedMessage("KEYWORDS"), true);
		dialog.setSize(getWidth() / 2, getHeight() / 2);
		dialog.setLocationRelativeTo(this);
		overlay.showOverlay();

		// Create a table model and table
		tableModel = new DefaultTableModel(new String[] { getLocalizedMessage("NAME"), getLocalizedMessage("DELETE") },
				0);

		List<String> keywords = loadKeywords();
		for (String keys : keywords)
			tableModel.addRow(new Object[] { keys.toUpperCase(), "X" });

		table = new JTable(tableModel);
		table.setFont(new Font("Arial", Font.PLAIN, 16));
		table.setRowHeight(30);
		table.setShowGrid(true);
		table.setIntercellSpacing(new Dimension(0, 0));

		// Add the table to a scroll pane
		JScrollPane scrollPane = new JScrollPane(table);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.setDefaultRenderer(Object.class, centerRenderer);

		TableColumn column[] = new TableColumn[2];
		for (int i = 0; i < 2; i++) {
			column[i] = table.getColumnModel().getColumn(i);
			if ((i == 1)) {
				column[i].setPreferredWidth(120);
				column[i].setMinWidth(120);
				column[i].setMaxWidth(120);
			}
			column[i].setCellRenderer(centerRenderer);
		}
		javax.swing.Action deleteAction = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTable table = (JTable) e.getSource();
				int row = Integer.parseInt(e.getActionCommand());
				((DefaultTableModel) table.getModel()).removeRow(row);
			}
		};
		new ButtonColumn(table, deleteAction, 1);

		// Customize the table header
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Arial", Font.BOLD, 18));
		header.setBackground(new Color(220, 220, 220));
		header.setForeground(Color.DARK_GRAY);
		header.setReorderingAllowed(false);
		header.setResizingAllowed(false);

		// Add a row sorter for filtering
		rowSorter = new TableRowSorter<>(tableModel);
		table.setRowSorter(rowSorter);

		// BOTTOM PANEL
		JPanel bottomPanel = new JPanel(new BorderLayout());
		JPanel flowPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton addRowButton = new JButton(getLocalizedMessage("ADD") + " ITEM");
		addRowButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		addRowButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		addRowButton.addActionListener(_ -> tableModel.addRow(new Object[] { "", "X" }));

		JButton clearT = new JButton(getLocalizedMessage("CLEAR"));
		clearT.setFont(new Font("Segoe UI", Font.BOLD, 14));
		clearT.setCursor(new Cursor(Cursor.HAND_CURSOR));
		clearT.addActionListener(_ -> {
			ModernDialog clearD = new ModernDialog(this, getLocalizedMessage("CLEAR"), true);
			clearD.addSubText(getLocalizedMessage("CANNOT_UNDO"), fg);
			clearD.setIcon(IconType.WARNING);
			clearD.setColor(bg);
			clearD.setTextColor(fg);
			clearD.setOverlayColor(bg);
			clearD.addButton(getLocalizedMessage("YES"), Intro.redM, () -> {
				tableModel.setRowCount(0);
				clearD.dispose();
			});
			clearD.addButton(getLocalizedMessage("NO"), Intro.greenM, clearD::dispose);
			clearD.setVisible(true);
		});
		flowPanel.add(addRowButton);
		flowPanel.add(clearT);

		// Add total Label
		JTextField searchTF = new JTextField();
		searchTF.setBackground(new Color(220, 220, 220));
		searchTF.setForeground(Color.DARK_GRAY);
		searchTF.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2),
				BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		searchTF.setToolTipText(getLocalizedMessage("SEARCH"));
		searchTF.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				updateFilter();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				updateFilter();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				updateFilter();
			}

			private void updateFilter() {
				String query = searchTF.getText().trim().toLowerCase();

				if (query.isEmpty()) {
					rowSorter.setRowFilter(null); // Show all rows if query is empty
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + query)); // Case-insensitive filter
				}
			}
		});
		bottomPanel.add(searchTF, BorderLayout.CENTER);
		bottomPanel.add(flowPanel, BorderLayout.SOUTH);

		// Add the scroll pane to the dialog
		dialog.add(scrollPane, BorderLayout.CENTER);
		dialog.add(bottomPanel, BorderLayout.SOUTH);

		// Key listener for ESC key to close the dialog
		InputMap inputMap = dialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap = dialog.getRootPane().getActionMap();
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "closeDialog");
		actionMap.put("closeDialog", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
				overlay.hideOverlay();
				saveKeywords();
			}
		});
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				overlay.hideOverlay();
				saveKeywords();
			}
		});
		// Show the dialog
		dialog.setVisible(true);
	}

	// Load keywords
	private List<String> loadKeywords() {
		// Load merchandise data
		List<String> keywords = new ArrayList<String>();
		File extraF = new File(dataFolder + "\\extra");
		extraF.mkdir();
		File keywordF = new File(extraF, "keywords.txt");
		if (!keywordF.exists()) {
			try {
				keywordF.createNewFile();
			} catch (IOException e) {
				writeError(e);
			}
		}
		try (BufferedReader dataOpened = new BufferedReader(new FileReader(keywordF))) {
			String line;

			while ((line = dataOpened.readLine()) != null) {
				keywords.add(line.toLowerCase());
			}
		} catch (Exception e) {
			writeError(e);
		}
		return keywords;
	}

	// Save keywords
	private void saveKeywords() {
		File extraF = new File(dataFolder + "\\extra");
		extraF.mkdir();
		File keywordsF = new File(extraF, "keywords.txt");
		try (PrintWriter writer = new PrintWriter(new FileWriter(keywordsF))) {
			for (int row = 0; row < tableModel.getRowCount(); row++) {

				String name = tableModel.getValueAt(row, 0) != null ? tableModel.getValueAt(row, 0).toString() : "";
				if (name.isEmpty()) {
					System.err.println("Skipping row due to missing values: " + name);
					continue;
				}

				writer.println(name.toLowerCase());
			}
		} catch (IOException e1) {
			writeError(e1);
			return; // Stop execution if writing fails
		}
	}

	/* Stock */
	/* Choose merchandise you want its summary */
	private void merchandiseSummDialog() {
		JDialog dialog = new JDialog(this, "", true);
		dialog.setUndecorated(true);
		dialog.setSize(getWidth() / 3, getHeight() / 3);
		dialog.setShape(new RoundRectangle2D.Double(0, 0, getWidth() / 3, getHeight() / 3, 20, 20));
		dialog.setLocationRelativeTo(this);
		dialog.setResizable(false);
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

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weightx = 1; // Allow horizontal centering
		gbc.weighty = 1; // Allow vertical centering

		// Buttons
		JButton loadTable = new JButton(getLocalizedMessage("LOAD"));
		loadTable.setFont(new Font("Segoe UI", Font.BOLD, 14));

		List<String> merchandiseNames = new ArrayList<String>();
		for (int index = 0; index < merchandise.size(); index++)
			merchandiseNames.add(merchandise.get(index).getName());

		JComboBox<String> combo = new JComboBox<String>(merchandiseNames.toArray(new String[0]));
		combo.setFont(new Font("Segoe UI", Font.BOLD, 14));
		combo.setEditable(false);
		combo.setPreferredSize(new Dimension(dialog.getWidth() * 2 / 3, 30));
		combo.setRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected,
						cellHasFocus);
				label.setHorizontalAlignment(SwingConstants.CENTER); // Center text in dropdown
				return label;
			}
		});
		JTextField editor = (JTextField) combo.getEditor().getEditorComponent();
		editor.setHorizontalAlignment(JTextField.CENTER);
		combo.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				String text = ((JTextComponent) combo.getEditor().getEditorComponent()).getText();
				if (!merchandiseNames.contains(text))
					combo.setSelectedItem(null);
			}
		});
		AutoCompleteDecorator.decorate(combo);

		// Loads
		loadTable.addActionListener(_ -> merchandiseSummary(combo.getSelectedItem().toString()));
		// Close Button
		JButton closeButton = new JButton(ImageEffect.getScaledImage(closeImage.getImage(), 15, 15));
		closeButton.setBorderPainted(false);
		closeButton.setFocusPainted(false);
		closeButton.setContentAreaFilled(false);
		closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		closeButton.setToolTipText(getLocalizedMessage("EXIT"));
		closeButton.addActionListener(_ -> {
			dialog.dispose();
			overlay.hideOverlay();
		});

		// Add Components to Dialog
		JPanel borderLay = new JPanel(new GridBagLayout());
		borderLay.setOpaque(false);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		borderLay.add(
				new JLabel("<html><b><u><font size='5'>" + getLocalizedMessage("ITEM_S") + "</font></u></b></html>"),
				gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		borderLay.add(combo, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		borderLay.add(loadTable, gbc);
		contentPane.add(borderLay, BorderLayout.CENTER);
		JPanel northPanel = new JPanel(new BorderLayout());
		northPanel.setOpaque(false);
		northPanel.add(closeButton, BorderLayout.EAST);
		contentPane.add(northPanel, BorderLayout.NORTH);

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
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				overlay.hideOverlay();
			}
		});

		dialog.setVisible(true);
	}

	/* Summary for certain merchandise */
	private void merchandiseSummary(String itemName) {
		ArrayList<String> summaryList = new ArrayList<String>();

		// Load merchandise data
		Map<String, Integer> dateQuantity = searchItemDates(itemName);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		// Filter the map while keeping quantity
		Map<String, Integer> allTimeMap = dateQuantity.entrySet().stream().filter(entry -> {
			LocalDate date = LocalDate.parse(entry.getKey(), formatter);
			return !date.isBefore(LocalDate.parse("01/01/2025", formatter))
					&& !date.isAfter(LocalDate.parse(LocalDate.now().format(formatter), formatter));
		}).sorted(Comparator.comparing(entry -> LocalDate.parse(entry.getKey(), formatter))) // Sort by date
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, _) -> oldValue,
						LinkedHashMap::new // Preserve order
				));
		Map<String, Integer> monthMap = dateQuantity.entrySet().stream().filter(entry -> {
			LocalDate date = LocalDate.parse(entry.getKey(), formatter);
			return !date.isBefore(LocalDate.parse(
					"01/" + (currentDate.m < 10 ? "0" + currentDate.m : currentDate.m) + "/" + currentDate.y,
					formatter)) && !date.isAfter(LocalDate.parse(LocalDate.now().format(formatter), formatter));
		}).sorted(Comparator.comparing(entry -> LocalDate.parse(entry.getKey(), formatter))) // Sort by date
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, _) -> oldValue,
						LinkedHashMap::new // Preserve order
				));
		int totalYear = 0, totalMonth = 0, daysYear = 0, daysMonth = 0;

		for (Map.Entry<String, Integer> entry : allTimeMap.entrySet()) {
			int qty = entry.getValue();
			totalYear += qty;
		}
		for (Map.Entry<String, Integer> entry : monthMap.entrySet()) {
			int qty = entry.getValue();
			totalMonth += qty;
		}
		int stockQ = searchQty(itemName), posM = getPosition(currentDate.y, currentDate.m, itemName),
				posY = getPosition(currentDate.y, -1, itemName),
				posMP = getPositionPerPrice(currentDate.y, currentDate.m, itemName),
				posYP = getPositionPerPrice(currentDate.y, -1, itemName);
		daysMonth = (int) ChronoUnit.DAYS.between(LocalDate.of(currentDate.y, currentDate.m, 1), LocalDate.now());
		daysYear = (int) ChronoUnit.DAYS.between(LocalDate.of(currentDate.y, 1, 1), LocalDate.now());
		// month
		double price = itemPrice(itemName);
		double monthAvg = daysMonth > 0 ? totalMonth / (double) daysMonth : 0,
				yearAvg = daysYear > 0 ? totalYear / (double) daysYear : 0;
		double monthPriceA = monthAvg * price, yearPriceA = yearAvg * price;
		if (totalMonth > 0) {
			if (language == Language.SPANISH) {
				summaryList.add("---------------------------------------MES---------------------------------------");
				summaryList.add("VENDISTE EN TOTAL ESTE MES " + totalMonth
						+ (daysMonth > 0 ? " CON PROMEDIO " + String.format("%.2f", monthAvg) + " POR DÍA" : ""));
				if (stockQ > 0 && daysMonth > 0)
					summaryList.add("CON ESTE PROMEDIO VENDERÁS TODA LA CANTIDAD EN "
							+ String.format("%.2f", stockQ / monthAvg) + " DÍAS");
				summaryList.add("VENDISTE EN TOTAL ESTE MES $" + (totalMonth * price)
						+ (daysMonth > 0 ? " CON PROMEDIO $" + String.format("%.2f", monthPriceA) + " POR DÍA" : ""));
				if (posM != -1)
					summaryList.add("PARECE QUE ESTE MES," + " ES EL " + posM + ".º MAS VENDIDA SEGÚN CANTIDAD");
				if (posMP != -1)
					summaryList.add("PARECE QUE ESTE MES," + " ES EL " + posMP + ".º MAS VENDIDA SEGÚN PRECIO");
			} else if (language == Language.PORTUGUES) {
				summaryList.add("---------------------------------------MÊS---------------------------------------");
				summaryList.add("VOCÊ VENDEU NO TOTAL ESTE MÊS " + totalMonth
						+ (daysMonth > 0 ? " COM MÉDIA " + String.format("%.2f", monthAvg) + " POR DIA" : ""));
				if (stockQ > 0 && daysMonth > 0)
					summaryList.add("COM ESSA MÉDIA VOCÊ VENDERÁ TODA A QUANTIDADE EM "
							+ String.format("%.2f", stockQ / monthAvg) + " DIAS");
				summaryList.add("VOCÊ VENDEU NO TOTAL ESTE MES $" + (totalMonth * price)
						+ (daysMonth > 0 ? " COM MÉDIA $" + String.format("%.2f", monthPriceA) + " POR DIA" : ""));
				if (posM != -1)
					summaryList.add("PARECE QUE ESTE MÊS," + " É O " + posM + ".º MAIS VENDIDO POR QUANTIDADE");
				if (posMP != -1)
					summaryList.add("PARECE QUE ESTE MÊS," + " É O " + posMP + ".º MAIS VENDIDO POR PREÇO");
			} else if (language == Language.ENGLISH) {
				summaryList.add("---------------------------------------MONTH---------------------------------------");
				summaryList.add("YOU SOLD IN TOTAL THIS MONTH " + totalMonth
						+ (daysMonth > 0 ? " WITH AVERAGE " + String.format("%.2f", monthAvg) + " PER DAY" : ""));
				if (stockQ > 0 && daysMonth > 0)
					summaryList.add("WITH THIS AVERAGE YOU WILL SELL THE ENTIRE QUANTITY IN "
							+ String.format("%.2f", stockQ / monthAvg) + " DAYS");
				summaryList.add("YOU SOLD IN TOTAL THIS MONTH $" + (totalMonth * price)
						+ (daysMonth > 0 ? " WITH AVERAGE $" + String.format("%.2f", monthPriceA) + " PER DAY" : ""));
				if (posM != -1)
					summaryList.add("IT SEEMS THAT THIS MONTH," + " IS THE " + posM + ".º BEST SELLER BY QUANTITY");
				if (posMP != -1)
					summaryList.add("IT SEEMS THAT THIS MONTH," + " IS THE " + posMP + ".º BEST SELLER BY PRICE");
			} else {
				summaryList.add("---------------------------------------MOIS---------------------------------------");
				summaryList.add("VOUS AVEZ VENDU AU TOTAL CE MOIS-CI " + totalMonth
						+ (daysMonth > 0 ? " AVEC MOYENNE " + String.format("%.2f", monthAvg) + " PAR JOUR" : ""));
				if (stockQ > 0 && daysMonth > 0)
					summaryList.add("AVEC CETTE MOYENNE VOUS VENDREZ TOUTE LA QUANTITÉ EN "
							+ String.format("%.2f", stockQ / monthAvg) + " JOURS");
				summaryList.add("VOUS AVEZ VENDU AU TOTAL CE MOIS-CI $" + (totalMonth * price)
						+ (daysMonth > 0 ? " AVEC MOYENNE $" + String.format("%.2f", monthPriceA) + " PAR JOUR" : ""));
				if (posM != -1)
					summaryList.add(
							"IL SEMBLE QUE CE MOIS-CI," + " C'EST LE " + posM + ".º MEILLEUR VENDEUR PAR QUANTITÉ");
				if (posMP != -1)
					summaryList
							.add("IL SEMBLE QUE CE MOIS-CI," + " C'EST LE " + posMP + ".º MEILLEUR VENDEUR PAR PRIX");
			}
		} else {
			if (language == Language.SPANISH) {
				summaryList.add("---------------------------------------MES---------------------------------------");
				summaryList.add("PARECE QUE NO VENDEMOS NADA ESTE MES TODAVIA");
			} else if (language == Language.PORTUGUES) {
				summaryList.add("---------------------------------------MÊS---------------------------------------");
				summaryList.add("PARECE QUE NÃO VENDEMOS NADA ESTE MÊS AINDA");
			} else if (language == Language.ENGLISH) {
				summaryList.add("---------------------------------------MONTH---------------------------------------");
				summaryList.add("IT SEEMS THAT WE DON'T SELL ANYTHING THIS MONTH YET");
			} else {
				summaryList.add("---------------------------------------MOIS---------------------------------------");
				summaryList.add("IL SEMBLE QUE NOUS NE VENDONS RIEN CE MOIS-CI ENCORE");
			}
		}
		// year
		if (totalYear > 0) {
			if (language == Language.SPANISH) {
				summaryList.add("---------------------------------------AÑO---------------------------------------");
				summaryList.add("VENDISTE EN TOTAL ESTE AÑO " + totalYear
						+ (daysYear > 0 ? " CON PROMEDIO " + String.format("%.2f", yearAvg) + " POR DIA" : ""));
				if (stockQ > 0 && daysYear > 0)
					summaryList.add("CON ESTE PROMEDIO VENDERÁS TODA LA CANTIDAD EN "
							+ String.format("%.2f", stockQ / yearAvg) + " DÍAS");
				summaryList.add("VENDISTE EN TOTAL ESTE AÑO $" + (totalYear * price)
						+ (daysYear > 0 ? " CON PROMEDIO $" + String.format("%.2f", yearPriceA) + " POR DIA" : ""));
				if (posY != -1)
					summaryList.add("PARECE QUE ESTE AÑO," + " ES EL " + posY + ".º MAS VENDIDA SEGÚN CANTIDAD");
				if (posYP != -1)
					summaryList.add("PARECE QUE ESTE AÑO," + " ES EL " + posYP + ".º MAS VENDIDA SEGÚN PRECIO");
			} else if (language == Language.PORTUGUES) {
				summaryList.add("---------------------------------------ANO---------------------------------------");
				summaryList.add("VOCÊ VENDEU NO TOTAL ESTE ANO " + totalYear
						+ (daysYear > 0 ? " COM MÉDIA " + String.format("%.2f", yearAvg) + " POR DIA" : ""));
				if (stockQ > 0 && daysYear > 0)
					summaryList.add("COM ESSA MÉDIA VOCÊ VENDERÁ TODA A QUANTIDADE EM "
							+ String.format("%.2f", stockQ / yearAvg) + " DIAS");
				summaryList.add("VOCÊ VENDEU NO TOTAL ESTE ANO $" + (totalYear * price)
						+ (daysYear > 0 ? " COM MÉDIA $" + String.format("%.2f", yearPriceA) + " POR DIA" : ""));
				if (posY != -1)
					summaryList.add("PARECE QUE ESTE ANO," + " É O " + posY + ".º MAIS VENDIDO POR QUANTIDADE");
				if (posYP != -1)
					summaryList.add("PARECE QUE ESTE ANO," + " É O " + posYP + ".º MAIS VENDIDO POR PREÇO");
			} else if (language == Language.ENGLISH) {
				summaryList.add("---------------------------------------YEAR---------------------------------------");
				summaryList.add("YOU SOLD IN TOTAL THIS YEAR " + totalYear
						+ (daysYear > 0 ? " WITH AVERAGE " + String.format("%.2f", yearAvg) + " PER DAY" : ""));
				if (stockQ > 0 && daysYear > 0)
					summaryList.add("WITH THIS AVERAGE YOU WILL SELL THE ENTIRE QUANTITY IN "
							+ String.format("%.2f", stockQ / yearAvg) + " DAYS");
				summaryList.add("YOU SOLD IN TOTAL THIS YEAR $" + (totalYear * price)
						+ (daysYear > 0 ? " WITH AVERAGE $" + String.format("%.2f", yearPriceA) + " PER DAY" : ""));
				if (posY != -1)
					summaryList.add("IT SEEMS THAT THIS YEAR," + " IS THE " + posY + ".º BEST SELLER BY QUANTITY");
				if (posYP != -1)
					summaryList.add("IT SEEMS THAT THIS YEAR," + " IS THE " + posYP + ".º BEST SELLER BY PRICE");
			} else {
				summaryList.add("---------------------------------------ANNÉE---------------------------------------");
				summaryList.add("VOUS AVEZ VENDU AU TOTAL CETTE ANNÉE " + totalYear
						+ (daysYear > 0 ? " AVEC MOYENNE " + String.format("%.2f", yearAvg) + " PAR JOUR" : ""));
				if (stockQ > 0 && daysYear > 0)
					summaryList.add("AVEC CETTE MOYENNE VOUS VENDREZ TOUTE LA QUANTITÉ EN "
							+ String.format("%.2f", stockQ / yearAvg) + " JOURS");
				summaryList.add("VOUS AVEZ VENDU AU TOTAL CETTE ANNÉE $" + (totalYear * price)
						+ (daysYear > 0 ? " AVEC MOYENNE $" + String.format("%.2f", yearPriceA) + " PAR JOUR" : ""));
				if (posY != -1)
					summaryList.add(
							"IL SEMBLE QUE CETTE ANNÉE," + " C'EST LE " + posY + ".º MEILLEUR VENDEUR PAR QUANTITÉ");
				if (posYP != -1)
					summaryList
							.add("IL SEMBLE QUE CETTE ANNÉE," + " C'EST LE " + posYP + ".º MEILLEUR VENDEUR PAR PRIX");
			}
		} else {
			if (language == Language.SPANISH) {
				summaryList.add("---------------------------------------AÑO---------------------------------------");
				summaryList.add("PARECE QUE NO VENDEMOS NADA ESTE AÑO TODAVIA");
			} else if (language == Language.PORTUGUES) {
				summaryList.add("---------------------------------------ANO---------------------------------------");
				summaryList.add("PARECE QUE NÃO VENDEMOS NADA ESTE ANO AINDA");
			} else if (language == Language.ENGLISH) {
				summaryList.add("---------------------------------------YEAR---------------------------------------");
				summaryList.add("IT SEEMS THAT WE DON'T SELL ANYTHING THIS YEAR YET");
			} else {
				summaryList.add("---------------------------------------ANNÉE---------------------------------------");
				summaryList.add("IL SEMBLE QUE NOUS NE VENDONS RIEN CETTE ANNÉE ENCORE");
			}
		}
		JDialog itemSummary = new JDialog(this, "", true);
		itemSummary.setDefaultCloseOperation(HIDE_ON_CLOSE);
		itemSummary.setUndecorated(true);
		itemSummary.setSize(getWidth() / 2, getHeight() / 2);
		itemSummary.setLocationRelativeTo(this);
		itemSummary.setLayout(new BorderLayout());
		itemSummary.setIconImage(colorSelected == 2 ? ImageEffect.getScaledImage(effect2I.getImage(), 35, 35).getImage()
				: ImageEffect.invertColor(ImageEffect.getScaledImage(effect2I.getImage(), 35, 35)).getImage());
		itemSummary.setShape(new RoundRectangle2D.Double(0, 0, getWidth() / 2, getHeight() / 2, 20, 20));

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
		contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		itemSummary.setContentPane(contentPane);

		// Title Panel
		JPanel northPanel = new JPanel(new BorderLayout());
		northPanel.setOpaque(false);
		JLabel titleLabel = new JLabel(
				getLocalizedMessage("SUMMARY") + " " + getLocalizedMessage("OF") + " " + itemName.toUpperCase());
		titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		titleLabel.setForeground(fg);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		JButton closeButton = new JButton(ImageEffect.getScaledImage(closeImage.getImage(), 15, 15));
		closeButton.setBorderPainted(false);
		closeButton.setFocusPainted(false);
		closeButton.setContentAreaFilled(false);
		closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		closeButton.setToolTipText(getLocalizedMessage("EXIT"));
		closeButton.addActionListener(_ -> itemSummary.dispose());
		northPanel.add(titleLabel, BorderLayout.CENTER);
		northPanel.add(closeButton, BorderLayout.EAST);
		contentPane.add(northPanel, BorderLayout.NORTH);

		// Holiday List
		DefaultListModel<String> model = new DefaultListModel<>();
		summaryList.forEach(model::addElement);
		JList<String> empSumList = new JList<>(model);
		empSumList.setCellRenderer(new EmployeeRender());
		empSumList.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		empSumList.setBackground(bg);
		JScrollPane scrollPane = new JScrollPane(empSumList);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		contentPane.add(scrollPane, BorderLayout.CENTER);

		// Key listener for ESC key to close the dialog
		InputMap inputMap = itemSummary.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap = itemSummary.getRootPane().getActionMap();
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "closeDialog");
		actionMap.put("closeDialog", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				itemSummary.dispose();
			}
		});

		itemSummary.setVisible(true);
	}

	/* Load the stock data */
	private void loadStockData() {
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
			merchandise.clear(); // Clear old data before reloading

			while ((line = dataOpened.readLine()) != null) {
				String[] row = line.split(",");

				String[] values = new String[] { "", "0", "0", "", "0", "0", "0" }; // Default values

				for (int i = 0; i < row.length && i < 7; i++) {
					String val = row[i].trim();
					switch (i) {
					case 1:
					case 2:
					case 5: // Numeric fields
						values[i] = TextEffect.isInteger(val) ? val : "0";
						break;
					case 4:
					case 6: // Double fields
						values[i] = TextEffect.isDouble(val) ? val : "0";
						break;
					default: // String fields (0, 3)
						values[i] = val;
					}
				}
				try {
					merchandise.add(new Merchandise(values[0], Integer.parseInt(values[1]), Integer.parseInt(values[2]),
							values[3], Double.parseDouble(values[4]), Integer.parseInt(values[5]),
							Double.parseDouble(values[6])));
				} catch (NumberFormatException e) {
					writeError(e);
				}
			}
		} catch (Exception e) {
			writeError(e);
		}

		for (Merchandise m : merchandise) {
			merchandiseMap.put(m.getID(), m);
			lastID = Math.max(lastID, m.getID());
		}
		if (conf[22] == null || conf[22].equalsIgnoreCase("null") || conf[22].equalsIgnoreCase("0"))
			merchandise.sort(Comparator.comparing(Merchandise::getName));
		else if (conf[22].equalsIgnoreCase("1"))
			merchandise.sort(Comparator.comparing(Merchandise::getName).reversed());
		else
			merchandise.sort(Comparator.comparing(Merchandise::getID));
	}

	/* View Stock */
	private void openMerchandiseDialog() {
		// Create a dialog for the merchandise table
		JDialog dialog = new JDialog(this, getLocalizedMessage("VIEW_STOCK"), true);
		dialog.setSize(getWidth() * 2 / 3, getHeight() * 2 / 3);
		dialog.setLocationRelativeTo(this);
		overlay.showOverlay();

		// Create a table model and table
		tableModel = new DefaultTableModel(new String[] { "ITEM", "TOTAL", "STOCK", getLocalizedMessage("SELL"),
				getLocalizedMessage("UNIT_PRICE") + "($)", getLocalizedMessage("PRICE") + "($)",
				getLocalizedMessage("CATEGORY") }, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // All cells are non-editable
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				// Specify column types
				switch (columnIndex) {
				case 1: // Total
				case 2: // Sold
				case 3: // Stock
					return Integer.class; // Numeric columns
				case 4: // price
				case 5: // price
					return Double.class; // Numeric column
				default:
					return String.class; // Default to String
				}
			}
		};

		// Load merchandise data
		List<Merchandise> merchandiseList = merchandise;
		for (Merchandise merchandise : merchandiseList) {
			int availableStock = merchandise.getTotal() - merchandise.getSold();
			if (conf[19].equals("false")) {
				if (availableStock > 0)
					tableModel.addRow(new Object[] { merchandise.getName(), merchandise.getTotal(),
							(merchandise.getTotal() - merchandise.getSold()), merchandise.getSold(),
							merchandise.getUnitPrice(), merchandise.getPrice(), merchandise.getCategory() });
			} else
				tableModel.addRow(new Object[] { merchandise.getName(), merchandise.getTotal(),
						(merchandise.getTotal() - merchandise.getSold()), merchandise.getSold(),
						merchandise.getUnitPrice(), merchandise.getPrice(), merchandise.getCategory() });
		}

		table = new JTable(tableModel);
		table.setFont(new Font("Arial", Font.PLAIN, 16));
		table.setRowHeight(30);
		table.setShowGrid(true);
		table.setIntercellSpacing(new Dimension(0, 0));

		// Add the table to a scroll pane
		JScrollPane scrollPane = new JScrollPane(table);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.setDefaultRenderer(Object.class, centerRenderer);

		TableColumn column[] = new TableColumn[7];
		for (int i = 0; i < 7; i++) {
			column[i] = table.getColumnModel().getColumn(i);
			if ((i > 0 && i < 6)) {
				column[i].setPreferredWidth(120);
				column[i].setMinWidth(120);
				column[i].setMaxWidth(120);
				column[i].setCellRenderer(centerRenderer);
			}
		}

		// Customize the table header
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Arial", Font.BOLD, 18));
		header.setBackground(new Color(220, 220, 220)); // Light gray background for header
		header.setForeground(Color.DARK_GRAY); // Dark gray text for header
		header.setReorderingAllowed(false); // Prevent column reordering
		header.setResizingAllowed(false); // Prevent column resizing

		// Add a row sorter for filtering
		rowSorter = new TableRowSorter<>(tableModel);
		table.setRowSorter(rowSorter);

		// Add right-click filter menu
		addRightClickFilter();

		// ADD SEARCH BUTTON
		JPanel southPanel = new JPanel(new BorderLayout());
		JTextField searchTF = new JTextField();
		searchTF.setBackground(new Color(220, 220, 220));
		searchTF.setForeground(Color.DARK_GRAY);
		searchTF.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2),
				BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		searchTF.setToolTipText(getLocalizedMessage("SEARCH"));
		searchTF.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				updateFilter();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				updateFilter();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				updateFilter();
			}

			private void updateFilter() {
				String query = searchTF.getText().trim().toLowerCase();

				if (query.isEmpty()) {
					rowSorter.setRowFilter(null); // Show all rows if query is empty
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + query)); // Case-insensitive filter
				}
			}
		});
		JLabel totalL = new JLabel(table.getRowSorter().getViewRowCount()
				+ (table.getRowSorter().getViewRowCount() > 1 ? " ITEMS" : " ITEM"));
		totalL.setFont(new Font("Arial", Font.BOLD, 18));
		totalL.setHorizontalAlignment(0);
		totalL.setForeground(fg);
		totalL.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2),
				BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		totalL.setToolTipText("TOTAL");

		rowSorter.addRowSorterListener(_ -> {
			int rowCount = table.getRowSorter().getViewRowCount();
			totalL.setText(rowCount + (rowCount > 1 ? " ITEMS" : " ITEM"));
		});
		// Add total Label
		southPanel.add(totalL, BorderLayout.EAST);
		southPanel.add(searchTF, BorderLayout.CENTER);
		// Add the scroll pane to the dialog
		dialog.add(scrollPane, BorderLayout.CENTER);
		dialog.add(southPanel, BorderLayout.SOUTH);

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
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				overlay.hideOverlay();
			}
		});
		// Show the dialog
		dialog.setVisible(true);
	}

	/* Update the stock when we sell */
	private void updateMerchandiseCSV() {
		File extraF = new File(dataFolder + "\\Stock");
		extraF.mkdir();
		File merchFile = new File(extraF, "stock.dll");

		// Map to accumulate quantities of the same item
		Map<String, Integer> accumulatedQuantities = new HashMap<>();

		// Collect item names and quantities from the invoices
		for (DefaultTableModel model : invoiceModels) {
			for (int row = 0; row < model.getRowCount(); row++) {
				String item = model.getValueAt(row, 0) != null ? model.getValueAt(row, 0).toString() : "";
				int quantity = model.getValueAt(row, 1) != null ? Integer.parseInt(model.getValueAt(row, 1).toString())
						: 0;
				// Accumulate the quantity for the same item
				accumulatedQuantities.put(item, accumulatedQuantities.getOrDefault(item, 0) + quantity);
			}
		}

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(merchFile))) {
			for (int index = 0; index < merchandise.size(); index++) {
				String currentName = merchandise.get(index).getName();
				int currentSold = merchandise.get(index).getSold();

				// Get the accumulated sold quantity from the invoices
				int accumulatedSold = accumulatedQuantities.getOrDefault(currentName, 0);

				// Calculate updated values for sold and stock
				int newSold = currentSold + accumulatedSold;

				// Write the updated data to the CSV file
				writer.write(currentName + "," + merchandise.get(index).getTotal() + "," + newSold + ","
						+ merchandise.get(index).getCategory() + "," + merchandise.get(index).getPrice() + ","
						+ merchandise.get(index).getID() + "," + merchandise.get(index).getUnitPrice());
				writer.newLine();
			}
		} catch (IOException e) {
			writeError(e);
		}
	}

	/* Admin: Change stock */
	private void changeStock() {
		/* Overlay */
		overlay.showOverlay();

		/* Password Dialog */
		PasswordDialog sepDialog = new PasswordDialog(this);
		int countAttemp = 0;
		sepDialog.setPassword(correctPassword);
		sepDialog.setFillColor(bg);
		sepDialog.setTextColor(fg);
		sepDialog.showMessage(getLocalizedMessage("PASSWORD_W"), getLocalizedMessage("TRIES") + (5 - countAttemp));
		String usario = sepDialog.getPassword();
		while (!usario.equalsIgnoreCase(correctPassword)) {
			if (conf[1] == null || conf[1].equalsIgnoreCase("null") || conf[1].equals("false"))
				soundEffect(wrongSound);
			if (sepDialog.getMessageType() == PasswordDialog.MessageType.CANCEL || countAttemp == 4)
				break;
			sepDialog.showMessage(getLocalizedMessage("TRY_AGAIN"),
					(getLocalizedMessage("TRIES")) + (5 - (++countAttemp)));
			usario = sepDialog.getPassword();
		}
		if (countAttemp != 4 && sepDialog.getMessageType() == PasswordDialog.MessageType.OK) {
			if (conf[1] == null || conf[1].equalsIgnoreCase("null") || conf[1].equals("false"))
				soundEffect(enterSound);

			// Create a dialog for the merchandise table
			JDialog dialog = new JDialog(this, getLocalizedMessage("CHANGE_STOCK"), true);
			dialog.setSize(getWidth() * 2 / 3, getHeight() * 2 / 3);
			dialog.setLocationRelativeTo(this);

			// Create a table model and table
			tableModel = new DefaultTableModel(new String[] { "ITEM", "TOTAL", getLocalizedMessage("SELL"), "STOCK",
					getLocalizedMessage("UNIT_PRICE") + "($)", getLocalizedMessage("PRICE") + "($)",
					getLocalizedMessage("CATEGORY"), "ID", getLocalizedMessage("DELETE") }, 0) {
				@Override
				public boolean isCellEditable(int row, int column) {
					return column != 7;
				}

				@Override
				public Class<?> getColumnClass(int columnIndex) {
					// Specify column types
					switch (columnIndex) {
					case 1: // Total
					case 2: // Sold
					case 3: // Stocks
						return Integer.class; // Numeric columns
					case 4: // price
					case 5: // price
						return Double.class; // Numeric column
					case 7:
						return Integer.class; // Numeric columns
					default:
						return String.class; // Default to String
					}
				}
			};

			// Load merchandise data
			List<Merchandise> merchandiseList = merchandise;
			for (Merchandise merchandise : merchandiseList)
				tableModel.addRow(new Object[] { merchandise.getName(), merchandise.getTotal(), merchandise.getSold(),
						merchandise.getTotal() - merchandise.getSold(), merchandise.getUnitPrice(),
						merchandise.getPrice(), merchandise.getCategory(), merchandise.getID(), "X" });

			table = new JTable(tableModel);
			table.setFont(new Font("Arial", Font.PLAIN, 16));
			table.setRowHeight(30);
			table.setShowGrid(true);
			table.setIntercellSpacing(new Dimension(0, 0));

			// Add the table to a scroll pane
			JScrollPane scrollPane = new JScrollPane(table);
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
			table.setDefaultRenderer(Object.class, centerRenderer);

			TableColumn column[] = new TableColumn[9];
			for (int i = 0; i < 9; i++) {
				column[i] = table.getColumnModel().getColumn(i);
				if ((i > 0 && i < 6)) {
					column[i].setPreferredWidth(120);
					column[i].setMinWidth(120);
					column[i].setMaxWidth(120);
					column[i].setCellRenderer(centerRenderer);
				} else if (i >= 7) {
					column[i].setPreferredWidth(90);
					column[i].setMinWidth(90);
					column[i].setMaxWidth(90);
				}
			}

			// Customize the table header
			JTableHeader header = table.getTableHeader();
			header.setFont(new Font("Arial", Font.BOLD, 18));
			header.setBackground(new Color(220, 220, 220)); // Light gray background for header
			header.setForeground(Color.DARK_GRAY); // Dark gray text for header
			header.setReorderingAllowed(false); // Prevent column reordering
			header.setResizingAllowed(false); // Prevent column resizing

			// Add a row sorter for filtering
			rowSorter = new TableRowSorter<>(tableModel);
			table.setRowSorter(rowSorter);

			// Add right-click filter menu
			addRightClickFilter();

			// Add listener to update stock automatically
			tableModel.addTableModelListener(e -> {
				int row = e.getFirstRow();

				if (e.getColumn() == 1 || e.getColumn() == 2) { // Total or Sold column updated
					try {
						int total = Integer.parseInt(tableModel.getValueAt(row, 1).toString());
						int sold = Integer.parseInt(tableModel.getValueAt(row, 2).toString());
						int stock = total - sold;

						// Update stock column
						tableModel.setValueAt(stock, row, 3);
					} catch (NumberFormatException ex) {
						writeError(ex);
					}
				}
			});
			javax.swing.Action deleteAction = new AbstractAction() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JTable table = (JTable) e.getSource();
					int row = Integer.parseInt(e.getActionCommand());
					((DefaultTableModel) table.getModel()).removeRow(row);
				}
			};
			new ButtonColumn(table, deleteAction, 8);

			JLabel totalL = new JLabel(merchandiseList.size() + (merchandiseList.size() > 1 ? " ITEMS" : " ITEM"));
			totalL.setFont(new Font("Arial", Font.BOLD, 18));
			totalL.setHorizontalAlignment(0);
			totalL.setForeground(fg);
			totalL.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2),
					BorderFactory.createEmptyBorder(5, 10, 5, 10)));
			totalL.setToolTipText("TOTAL");

			rowSorter.addRowSorterListener(_ -> {
				int rowCount = table.getRowSorter().getViewRowCount();
				totalL.setText(rowCount + (rowCount > 1 ? " ITEMS" : " ITEM"));
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
					saveStock();
				}
			});
			dialog.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent we) {
					overlay.hideOverlay();
					saveStock();
				}
			});

			// BOTTOM PANEL
			JPanel bottomPanel = new JPanel(new BorderLayout());
			JPanel flowPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JButton addRowButton = new JButton(getLocalizedMessage("ADD") + " ITEM");
			addRowButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
			addRowButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			addRowButton.addActionListener(_ -> {
				tableModel.addRow(new Object[] { "", 0, 0, 0, 0, 0, "", lastID() + 1, "X" });
				int rowCount = table.getRowSorter().getViewRowCount();
				totalL.setText(rowCount + (rowCount > 1 ? " ITEMS" : " ITEM"));
			});
			JButton clearT = new JButton(getLocalizedMessage("CLEAR"));
			clearT.setFont(new Font("Segoe UI", Font.BOLD, 14));
			clearT.setCursor(new Cursor(Cursor.HAND_CURSOR));
			clearT.addActionListener(_ -> {
				ModernDialog clearD = new ModernDialog(this, getLocalizedMessage("CLEAR"), true);
				clearD.addSubText(getLocalizedMessage("CANNOT_UNDO"), fg);
				clearD.setIcon(IconType.WARNING);
				clearD.setColor(bg);
				clearD.setTextColor(fg);
				clearD.setOverlayColor(bg);
				clearD.addButton(getLocalizedMessage("YES"), Intro.redM, () -> {
					tableModel.setRowCount(0);
					clearD.dispose();
					int rowCount = table.getRowSorter().getViewRowCount();
					totalL.setText(rowCount + (rowCount > 1 ? " ITEMS" : " ITEM"));
				});
				clearD.addButton(getLocalizedMessage("NO"), Intro.greenM, clearD::dispose);
				clearD.setVisible(true);
			});
			flowPanel.add(addRowButton);
			flowPanel.add(clearT);

			JTextField searchTF = new JTextField();
			searchTF.setBackground(new Color(220, 220, 220));
			searchTF.setForeground(Color.DARK_GRAY);
			searchTF.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2),
					BorderFactory.createEmptyBorder(5, 10, 5, 10)));
			searchTF.setToolTipText(getLocalizedMessage("SEARCH"));
			searchTF.getDocument().addDocumentListener(new DocumentListener() {
				@Override
				public void insertUpdate(DocumentEvent e) {
					updateFilter();
				}

				@Override
				public void removeUpdate(DocumentEvent e) {
					updateFilter();
				}

				@Override
				public void changedUpdate(DocumentEvent e) {
					updateFilter();
				}

				private void updateFilter() {
					String query = searchTF.getText().trim().toLowerCase();

					if (query.isEmpty()) {
						rowSorter.setRowFilter(null); // Show all rows if query is empty
					} else {
						rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + query)); // Case-insensitive filter
					}
				}
			});
			bottomPanel.add(searchTF, BorderLayout.CENTER);
			bottomPanel.add(totalL, BorderLayout.EAST);
			bottomPanel.add(flowPanel, BorderLayout.SOUTH);

			// Add the scroll pane to the dialog
			dialog.add(scrollPane, BorderLayout.CENTER);
			dialog.add(bottomPanel, BorderLayout.SOUTH);

			// Show the dialog
			dialog.setVisible(true);
		} else
			overlay.hideOverlay();
	}

	/* Save stock file */
	private void saveStock() {
		File extraF = new File(dataFolder + "\\Stock");
		extraF.mkdir();
		File merchFile = new File(extraF, "stock.dll");
		File tempFile = new File(extraF, "temp_stock.dll");
		Map<String, String> nameChanges = new HashMap<>();
		List<Merchandise> newMerch = new ArrayList<Merchandise>();
		try (PrintWriter writer = new PrintWriter(
				new OutputStreamWriter(new FileOutputStream(tempFile), StandardCharsets.UTF_8))) {
			for (int row = 0; row < tableModel.getRowCount(); row++) {
				String name = tableModel.getValueAt(row, 0).toString();
				String total = tableModel.getValueAt(row, 1).toString();
				String sold = tableModel.getValueAt(row, 2).toString();
				String category = tableModel.getValueAt(row, 6).toString();
				String price = tableModel.getValueAt(row, 5).toString();
				String unitprice = tableModel.getValueAt(row, 4).toString();
				String tableID = tableModel.getValueAt(row, 7).toString();
				int id = Integer.parseInt(tableID);
				// Ensure data integrity before writing
				if (name.isEmpty() || category.isEmpty()) {
					System.err.println("Skipping row due to missing values: " + name);
					continue;
				}
				if (total.isEmpty())
					total = "0";
				if (sold.isEmpty())
					sold = "0";
				if (price.isEmpty())
					price = "0";
				if (unitprice.isEmpty())
					unitprice = "0";

				String sanitizedName = name.replace(",", "");
				String sanitizedCategory = category.replace(",", "");

				if (merchandiseMap.containsKey(id)) {
					Merchandise existing = merchandiseMap.get(id);
					String newName = existing.getName().replace(",", "");
					if (!newName.equals(name))
						nameChanges.put(newName, name); // Track name change
				} else
					newMerch.add(new Merchandise(sanitizedName, Integer.parseInt(total), Integer.parseInt(sold),
							sanitizedCategory, Double.parseDouble(price), id, Double.parseDouble(unitprice)));

				// Build CSV line safely
				writer.print(sanitizedName + ",");
				writer.print(total + ",");
				writer.print(sold + ",");
				writer.print(sanitizedCategory + ",");
				writer.print(price + ",");
				writer.print(id + ",");
				writer.println(unitprice);
			}
		} catch (IOException e1) {
			writeError(e1);
			throw new RuntimeException("Save failed", e1); // Prevent silent failure
		}
		// Safely replace the file only if writing was successful
		try {
			if (merchFile.exists()) {
				Files.delete(merchFile.toPath()); // More reliable deletion
			}
			Files.move(tempFile.toPath(), merchFile.toPath(), StandardCopyOption.ATOMIC_MOVE);
		} catch (IOException finalEx) {
			writeError(finalEx);
			throw new RuntimeException("File replacement failed", finalEx);
		}

		if (!nameChanges.isEmpty()) {
			/* Update the sales index if we change item names */
			Map<String, Map<String, Integer>> salesMap = new LinkedHashMap<>();
			for (int year = 2025; year <= currentDate.y; year++) {
				File salesData = new File(extraF, "sales_index_" + year + ".csv");

				if (salesData.exists()) {
					try (BufferedReader reader = new BufferedReader(new FileReader(salesData))) {
						String line;
						reader.readLine(); // Skip header ("item,dates")
						while ((line = reader.readLine()) != null) {
							String[] parts = line.split(",");
							String item = parts[0];
							if (nameChanges.containsKey(item))
								item = nameChanges.get(item);
							Map<String, Integer> dateQtyMap = new LinkedHashMap<>();
							for (int i = 1; i < parts.length; i++) {
								String[] dateQty = parts[i].split(":");
								if (dateQty.length == 2)
									dateQtyMap.put(dateQty[0], Integer.parseInt(dateQty[1]));
							}
							salesMap.put(item, dateQtyMap);
						}
					} catch (IOException e) {
						writeError(e);
					}
					// Write updated index to file
					try (BufferedWriter writer = new BufferedWriter(new FileWriter(salesData))) {
						writer.write("ITEM,DATE:QUANTITY");
						writer.newLine();
						for (Map.Entry<String, Map<String, Integer>> entry : salesMap.entrySet()) {
							StringBuilder line = new StringBuilder(entry.getKey());
							for (Map.Entry<String, Integer> dateEntry : entry.getValue().entrySet()) {
								line.append(",").append(dateEntry.getKey()).append(":").append(dateEntry.getValue());
							}
							writer.write(line.toString());
							writer.newLine();
						}
					} catch (IOException e) {
						writeError(e);
					}
				}
			}

			/* Update the added table */
			File dates = new File(extraF, "dates.dll");
			Map<String, Map<String, Integer>> datesMap = new LinkedHashMap<>();
			if (dates.exists()) {
				try (BufferedReader reader = new BufferedReader(new FileReader(dates))) {
					reader.readLine();
					String line;
					while ((line = reader.readLine()) != null) {
						String[] parts = line.split(",");
						String item = parts[0];
						if (nameChanges.containsKey(item))
							item = nameChanges.get(item);
						Map<String, Integer> dateQtyMap = new LinkedHashMap<>();
						for (int i = 1; i < parts.length; i++) {
							String[] dateQty = parts[i].split(":");
							if (dateQty.length == 2)
								dateQtyMap.put(dateQty[0], Integer.parseInt(dateQty[1]));
						}
						datesMap.put(item, dateQtyMap);
					}
				} catch (IOException e) {
					writeError(e);
				}
				// Write updated index to file
				try (BufferedWriter writer = new BufferedWriter(new FileWriter(dates))) {
					writer.write("ITEM,DATE:QUANTITY");
					writer.newLine();
					for (Map.Entry<String, Map<String, Integer>> entry : datesMap.entrySet()) {
						StringBuilder line = new StringBuilder(entry.getKey());
						for (Map.Entry<String, Integer> dateEntry : entry.getValue().entrySet()) {
							line.append(",").append(dateEntry.getKey()).append(":").append(dateEntry.getValue());
						}
						writer.write(line.toString());
						writer.newLine();
					}
				} catch (IOException e) {
					writeError(e);
				}
			}
		}
		/* Add to the dates if there is a new merchandise */
		if (newMerch.size() > 0) {
			File dates = new File(extraF, "dates.dll");
			Map<String, Map<String, Integer>> datesMap = new LinkedHashMap<>();
			if (dates.exists()) {
				try (BufferedReader reader = new BufferedReader(new FileReader(dates))) {
					reader.readLine();
					String line;
					while ((line = reader.readLine()) != null) {
						String[] parts = line.split(",");
						String item = parts[0];
						Map<String, Integer> dateQtyMap = new LinkedHashMap<>();
						for (int i = 1; i < parts.length; i++) {
							String[] dateQty = parts[i].split(":");
							if (dateQty.length == 2)
								dateQtyMap.put(dateQty[0], Integer.parseInt(dateQty[1]));
						}
						datesMap.put(item, dateQtyMap);
					}
				} catch (IOException e) {
					writeError(e);
				}
				// Write updated index to file
				try (BufferedWriter writer = new BufferedWriter(new FileWriter(dates))) {
					writer.write("ITEM,DATE:QUANTITY");
					writer.newLine();
					for (Map.Entry<String, Map<String, Integer>> entry : datesMap.entrySet()) {
						StringBuilder line = new StringBuilder(entry.getKey());
						for (Map.Entry<String, Integer> dateEntry : entry.getValue().entrySet()) {
							line.append(",").append(dateEntry.getKey()).append(":").append(dateEntry.getValue());
						}
						writer.write(line.toString());
						writer.newLine();
					}
					for (Merchandise merch : newMerch) {
						writer.write(merch.getName() + "," + currentDate.getToday() + ":" + merch.getTotal());
						writer.newLine();
					}
				} catch (IOException e) {
					writeError(e);
				}
			}
		}
	}

	/* Add more qty to existed merchandise */
	private void addDateStock() {
		// Create a dialog for the merchandise table
		JDialog dialog = new JDialog(this, getLocalizedMessage("ADD") + " STOCK", true);
		dialog.setSize(getWidth() * 2 / 3, getHeight() * 2 / 3);
		dialog.setLocationRelativeTo(this);
		overlay.showOverlay();

		ModernTabbedPane tabbedPane = new ModernTabbedPane();

		// EXISTED TABLE
		DefaultTableModel existedModel = new DefaultTableModel(new String[] { "ITEM", "TOTAL",
				getLocalizedMessage("AGG"), getLocalizedMessage("DATE"), getLocalizedMessage("DELETE") }, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column != 1;
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				// Specify column types
				switch (columnIndex) {
				case 1: // Total
				case 2: // Sold
					return Integer.class; // Numeric columns
				case 3:
					return Date.class;
				default:
					return String.class; // Default to String
				}
			}
		};
		existedModel.addRow(new Object[] { "", 0, 0, new Date(), "X" });

		JTable stockTable = new JTable(existedModel) {
			@Override
			public boolean editCellAt(int row, int column, EventObject e) {
				boolean result = super.editCellAt(row, column, e);
				final Component editor = getEditorComponent();

				if (editor instanceof JTextField) {
					JTextField textField = (JTextField) editor;

					// Select all text when editing starts
					if (e instanceof KeyEvent) {
						textField.setText(""); // Clear text for overwrite
						textField.requestFocusInWindow();
					} else {
						// If triggered by focus or mouse, select all text
						SwingUtilities.invokeLater(textField::selectAll);
					}
				}
				return result;
			}
		};
		stockTable.setFont(new Font("Arial", Font.PLAIN, 16));
		stockTable.setRowHeight(30);
		stockTable.setShowGrid(true);
		stockTable.setIntercellSpacing(new Dimension(0, 0));

		// Add the table to a scroll pane
		JScrollPane scrollPane = new JScrollPane(stockTable);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		stockTable.setDefaultRenderer(Object.class, centerRenderer);

		TableColumn column[] = new TableColumn[5];
		for (int i = 0; i < 5; i++) {
			column[i] = stockTable.getColumnModel().getColumn(i);
			if (i == 1) {
				column[i].setPreferredWidth(120);
				column[i].setMinWidth(120);
				column[i].setMaxWidth(120);
			}
			if (i == 2) {
				column[i].setPreferredWidth(180);
				column[i].setMinWidth(180);
				column[i].setMaxWidth(180);
			}
			if (i == 3) {
				column[i].setPreferredWidth(220);
				column[i].setMinWidth(220);
				column[i].setMaxWidth(220);
			}
			if (i == 4) {
				column[i].setPreferredWidth(90);
				column[i].setMinWidth(90);
				column[i].setMaxWidth(90);
			}
			column[i].setCellRenderer(centerRenderer);
		}

		// Load merchandise data
		List<String> merchandiseNames = new ArrayList<String>();
		for (int index = 0; index < merchandise.size(); index++)
			merchandiseNames.add(merchandise.get(index).getName());
		JComboBox<String> combo = new JComboBox<String>(merchandiseNames.toArray(new String[0]));
		combo.setEditable(false);
		combo.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_F5) {
					openSearchDialog(combo);
				}
			}
		});
		AutoCompleteDecorator.decorate(combo);
		column[0].setCellEditor(new ComboBoxCellEditor(combo) {
			@Override
			public boolean stopCellEditing() {
				Object selectedObject = combo.getEditor().getItem();
				if (selectedObject == null) {
					return super.stopCellEditing(); // Prevents NullPointerException
				}

				String selectedItem = selectedObject.toString().trim();
				// Find the row index of the edited cell
				int row = stockTable.getEditingRow();
				if (row != -1) {
					// Find the price from the merchandise list
					for (Merchandise m : merchandise) {
						if (m.getName().equalsIgnoreCase(selectedItem)) {
							stockTable.setValueAt(m.getTotal(), row, 1);
							break;
						}
					}
				}
				return super.stopCellEditing();
			}
		});
		JFormattedTextField textField;
		MaskFormatter dateMask;
		try {
			dateMask = new MaskFormatter("##/##/####");
			dateMask.setPlaceholderCharacter('_'); // Show underscores for empty spaces
			textField = new JFormattedTextField(dateMask);
			textField.setColumns(10);
		} catch (ParseException e1) {
			throw new RuntimeException("Invalid mask format", e1);
		}
		column[3].setCellEditor(new DefaultCellEditor(textField) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			@Override
			public Object getCellEditorValue() {
				try {
					return sdf.parse(textField.getText()); // Convert text to Date
				} catch (ParseException e) {
					return null;
				}
			}

			@Override
			public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
					int column) {
				textField.setText(value instanceof Date ? sdf.format((Date) value) : "");
				return textField;
			}
		});
		column[3].setCellRenderer(new DefaultTableCellRenderer() {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			@Override
			protected void setValue(Object value) {
				setHorizontalAlignment(SwingConstants.CENTER);
				if (value instanceof Date) {
					setText(sdf.format((Date) value)); // Format Date object
				} else {
					setText(""); // Empty for null values
				}
			}
		});

		// Customize the table header
		JTableHeader header = stockTable.getTableHeader();
		header.setFont(new Font("Arial", Font.BOLD, 18));
		header.setBackground(new Color(220, 220, 220)); // Light gray background for header
		header.setForeground(Color.DARK_GRAY); // Dark gray text for header
		header.setReorderingAllowed(false); // Prevent column reordering
		header.setResizingAllowed(false); // Prevent column resizing

		// BOTTOM PANEL
		JPanel bottomPanel = new JPanel(new BorderLayout());
		JLabel legend = new JLabel(
				"<html><b><u><font size='5'>" + getLocalizedMessage("F5") + "</font></u></b></html>");
		legend.setHorizontalAlignment(0);
		JPanel buttonsP = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton addRowButton = new JButton(getLocalizedMessage("ADD") + " ITEM");
		addRowButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		addRowButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		addRowButton.addActionListener(_ -> existedModel.addRow(new Object[] { "", 0, 0, new Date(), "X" }));
		JButton clearTable = new JButton(getLocalizedMessage("CLEAR"));
		clearTable.setFont(new Font("Segoe UI", Font.BOLD, 14));
		clearTable.setCursor(new Cursor(Cursor.HAND_CURSOR));
		clearTable.addActionListener(_ -> existedModel.setRowCount(0));
		buttonsP.add(addRowButton);
		buttonsP.add(clearTable);
		// Add Delete button
		javax.swing.Action deleteAction = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTable table = (JTable) e.getSource();
				int row = Integer.parseInt(e.getActionCommand());
				((DefaultTableModel) table.getModel()).removeRow(row);
			}
		};
		new ButtonColumn(stockTable, deleteAction, 4);

		bottomPanel.add(legend, BorderLayout.CENTER);
		bottomPanel.add(buttonsP, BorderLayout.SOUTH);

		// new item table
		JPanel existingItemsPanel = new JPanel(new BorderLayout());
		existingItemsPanel.add(scrollPane, BorderLayout.CENTER);
		existingItemsPanel.add(bottomPanel, BorderLayout.SOUTH);
		existingItemsPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		tabbedPane.addTab(getLocalizedMessage("EXISTED"), existingItemsPanel);

		DefaultTableModel newItemTableModel = new DefaultTableModel(
				new String[] { getLocalizedMessage("NAME"), "TOTAL", getLocalizedMessage("UNIT_PRICE"),
						getLocalizedMessage("PRICE"), getLocalizedMessage("CATEGORY"), getLocalizedMessage("DELETE") },
				0) {

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				switch (columnIndex) {
				case 1:
					return Integer.class;
				case 2:
				case 3:
					return Double.class;
				case 5:
					return String.class;
				default:
					return String.class;
				}
			}
		};
		newItemTableModel.addRow(new Object[] { "", 0, 0.0, 0.0, "", "X" });
		JTable newItemTable = new JTable(newItemTableModel);
		stockTable.setFont(new Font("Arial", Font.PLAIN, 16));
		newItemTable.setRowHeight(30);
		newItemTable.setShowGrid(true);
		newItemTable.setIntercellSpacing(new Dimension(0, 0));
		newItemTable.setDefaultRenderer(Object.class, centerRenderer);
		header = newItemTable.getTableHeader();
		header.setFont(new Font("Arial", Font.BOLD, 18));
		header.setBackground(new Color(220, 220, 220)); // Light gray background for header
		header.setForeground(Color.DARK_GRAY); // Dark gray text for header
		header.setReorderingAllowed(false); // Prevent column reordering
		header.setResizingAllowed(false); // Prevent column resizing

		for (int i = 0; i < 6; i++)
			newItemTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);

		JScrollPane newItemScrollPane = new JScrollPane(newItemTable);

		JPanel newItemBottomPanel = new JPanel(new FlowLayout());
		JButton addNewItemRowButton = new JButton(getLocalizedMessage("NEW"));
		addNewItemRowButton.addActionListener(_ -> newItemTableModel.addRow(new Object[] { "", 0, 0.0, 0.0, "", "X" }));
		addNewItemRowButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		addNewItemRowButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		JButton clearNewTable = new JButton(getLocalizedMessage("CLEAR"));
		clearNewTable.setFont(new Font("Segoe UI", Font.BOLD, 14));
		clearNewTable.setCursor(new Cursor(Cursor.HAND_CURSOR));
		clearNewTable.addActionListener(_ -> newItemTableModel.setRowCount(0));
		newItemBottomPanel.add(addNewItemRowButton);
		newItemBottomPanel.add(clearNewTable);

		// Delete button for new items
		javax.swing.Action deleteNewItemAction = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = Integer.parseInt(e.getActionCommand());
				newItemTableModel.removeRow(row);
			}
		};
		new ButtonColumn(newItemTable, deleteNewItemAction, 5);

		JPanel newItemPanel = new JPanel(new BorderLayout());
		newItemPanel.add(newItemScrollPane, BorderLayout.CENTER);
		newItemPanel.add(newItemBottomPanel, BorderLayout.SOUTH);
		newItemPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		tabbedPane.addTab(getLocalizedMessage("ADD") + " ITEM", newItemPanel);

		// Key listener for ESC key to close the dialog
		InputMap inputMap = dialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap = dialog.getRootPane().getActionMap();
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "closeDialog");
		actionMap.put("closeDdialog", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
				overlay.hideOverlay();
			}
		});
		dialog.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent we) {
				dialog.dispose();
				overlay.hideOverlay();
			}
		});

		dialog.add(tabbedPane, BorderLayout.CENTER);

		JButton saveA = new JButton(getLocalizedMessage("SAVE"));
		saveA.setFont(new Font("Segoe UI", Font.BOLD, 14));
		saveA.setCursor(new Cursor(Cursor.HAND_CURSOR));
		saveA.addActionListener(_ -> {
			if (addAndSaveMerch(existedModel, newItemTableModel)) {
				dialog.dispose();
				overlay.hideOverlay();

			}
		});
		dialog.add(saveA, BorderLayout.SOUTH);
		// Show the dialog
		dialog.setVisible(true);
	}

	/* Save the added value for the existed item and the new item */
	private boolean addAndSaveMerch(DefaultTableModel existedModel, DefaultTableModel newItemTableModel) {
		int qty = 0, merchSize = merchandise.size();
		boolean title = false;
		for (int row = 0; row < existedModel.getRowCount(); row++) {
			String name = existedModel.getValueAt(row, 0) != null ? existedModel.getValueAt(row, 0).toString() : "";
			int quantity = existedModel.getValueAt(row, 2) != null
					? Integer.parseInt(existedModel.getValueAt(row, 2).toString())
					: 0;
			// Ensure data integrity before writing
			if (!name.isEmpty())
				title = true;
			qty += quantity;
		}

		if (title && qty > 0) {
			saveAddedStock(existedModel);
			saveDateAddedStock(existedModel);
			existedModel.setRowCount(0);
			Toast.show(this, Toast.Type.SUCCESS, getLocalizedMessage("EXISTED") + " " + getLocalizedMessage("TABLE")
					+ " " + getLocalizedMessage("SAVE_A"), Intro.notOption);
		}
		// Process new items
		int newID = 1;
		List<String> merchNames = new ArrayList<String>();
		for (Merchandise merch : merchandise) {
			if (merch.getID() > newID)
				newID = merch.getID();
			merchNames.add(merch.getName().toLowerCase());
		}

		for (int row = 0; row < newItemTableModel.getRowCount(); row++) {
			String name = (String) newItemTableModel.getValueAt(row, 0);
			Integer total = (Integer) newItemTableModel.getValueAt(row, 1);
			Double costPrice = (Double) newItemTableModel.getValueAt(row, 2);
			Double sellPrice = (Double) newItemTableModel.getValueAt(row, 3);
			String category = (String) newItemTableModel.getValueAt(row, 4);
			int id = newID++ + 1;
			if (name != null && !name.trim().isEmpty() && total != null && total > 0 && costPrice != null
					&& costPrice > 0 && sellPrice != null && sellPrice > 0
					&& !merchNames.contains(name.toLowerCase())) {
				Merchandise newItem = new Merchandise(name, total, 0, category, sellPrice, id, costPrice);
				merchandise.add(newItem);
			} else if (merchNames.contains(name.toLowerCase())) {
				Toast.show(this, Toast.Type.ERROR, getLocalizedMessage("EXISTED") + " (" + name.toUpperCase() + ")",
						Intro.notOption);
				return false;
			}
		}
		if (merchSize < merchandise.size()) {
			// add to stock file
			File extraF = new File(dataFolder + "\\Stock");
			extraF.mkdir();
			File merchFile = new File(extraF, "stock.dll");

			try (BufferedWriter writer = new BufferedWriter(new FileWriter(merchFile, true))) {
				for (Merchandise merch : merchandise.subList(merchSize, merchandise.size())) {
					writer.write(
							merch.getName() + "," + merch.getTotal() + "," + merch.getSold() + "," + merch.getCategory()
									+ "," + merch.getPrice() + "," + merch.getID() + "," + merch.getUnitPrice());
					writer.newLine();
				}
			} catch (IOException e1) {
				writeError(e1);
			}
			// add to dates file
			File dates = new File(extraF, "dates.dll");
			Map<String, Map<String, Integer>> salesMap = new LinkedHashMap<>();
			// Read existing index
			try (BufferedReader reader = new BufferedReader(new FileReader(dates))) {
				reader.readLine();
				String line;
				while ((line = reader.readLine()) != null) {
					String[] parts = line.split(",");
					String item = parts[0];
					Map<String, Integer> dateQtyMap = new LinkedHashMap<>();
					for (int i = 1; i < parts.length; i++) {
						String[] dateQty = parts[i].split(":");
						if (dateQty.length == 2) {
							dateQtyMap.put(dateQty[0], Integer.parseInt(dateQty[1]));
						}
					}
					salesMap.put(item, dateQtyMap);
				}
			} catch (IOException e2) {
				writeError(e2);
			}
			// Write updated index to file
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(dates))) {
				writer.write("ITEM,DATE:QUANTITY");
				writer.newLine();
				for (Map.Entry<String, Map<String, Integer>> entry : salesMap.entrySet()) {
					StringBuilder line = new StringBuilder(entry.getKey());
					for (Map.Entry<String, Integer> dateEntry : entry.getValue().entrySet()) {
						line.append(",").append(dateEntry.getKey()).append(":").append(dateEntry.getValue());
					}
					writer.write(line.toString());
					writer.newLine();
				}
				for (Merchandise merch : merchandise.subList(merchSize, merchandise.size())) {
					writer.write(merch.getName() + "," + currentDate.getToday() + ":" + merch.getTotal());
					writer.newLine();
				}
			} catch (IOException e1) {
				writeError(e1);
			}
			newItemTableModel.setRowCount(0);
			Toast.show(this, Toast.Type.SUCCESS, getLocalizedMessage("NEW") + " " + getLocalizedMessage("TABLE") + " "
					+ getLocalizedMessage("SAVE_A"), Intro.notOption);
		} else if (!title || qty == 0) {
			Toast.show(this, Toast.Type.ERROR, getLocalizedMessage("NO_DATA"), Intro.notOption);
			return false;
		}
		return true;
	}

	/* Update the total for the stock file */
	private void saveAddedStock(DefaultTableModel tableModel) {
		File extraF = new File(dataFolder + "\\Stock");
		extraF.mkdir();
		File merchFile = new File(extraF, "stock.dll");

		// Map to accumulate quantities of the same item
		Map<String, Integer> accumulatedQuantities = new HashMap<>();
		for (int row = 0; row < tableModel.getRowCount(); row++) {
			String name = tableModel.getValueAt(row, 0) != null ? tableModel.getValueAt(row, 0).toString() : "";
			int quantity = tableModel.getValueAt(row, 2) != null
					? Integer.parseInt(tableModel.getValueAt(row, 2).toString())
					: 0;
			// Ensure data integrity before writing
			if (name.isEmpty() || quantity == 0) {
				continue;
			}
			accumulatedQuantities.put(name, accumulatedQuantities.getOrDefault(name, 0) + quantity);
		}

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(merchFile))) {
			for (int index = 0; index < merchandise.size(); index++) {
				String currentName = merchandise.get(index).getName();
				int currentTotal = merchandise.get(index).getTotal();

				// Get the accumulated sold quantity from the invoices
				int accumulatedTotal = accumulatedQuantities.getOrDefault(currentName, 0);

				// Calculate updated values for sold and stock
				int newTotal = currentTotal + accumulatedTotal;

				// Write the updated data to the CSV file
				writer.write(currentName + "," + newTotal + "," + merchandise.get(index).getSold() + ","
						+ merchandise.get(index).getCategory() + "," + merchandise.get(index).getPrice() + ","
						+ merchandise.get(index).getID() + "," + merchandise.get(index).getUnitPrice());
				writer.newLine();
			}
		} catch (IOException e1) {
			writeError(e1);
		}
	}

	/* Save the dates for the added merchandise */
	private void saveDateAddedStock(DefaultTableModel tableModel) {
		File extraF = new File(dataFolder + "\\Stock");
		extraF.mkdir();
		File dates = new File(extraF, "dates.dll");

		Map<String, Map<String, Integer>> salesMap = new LinkedHashMap<>();

		if (!dates.exists())
			try {
				dates.createNewFile();
			} catch (IOException e) {
				writeError(e);
			}
		else {
			// Read existing index
			try (BufferedReader reader = new BufferedReader(new FileReader(dates))) {
				reader.readLine();
				String line;
				while ((line = reader.readLine()) != null) {
					String[] parts = line.split(",");
					String item = parts[0];
					Map<String, Integer> dateQtyMap = new LinkedHashMap<>();
					for (int i = 1; i < parts.length; i++) {
						String[] dateQty = parts[i].split(":");
						if (dateQty.length == 2) {
							dateQtyMap.put(dateQty[0], Integer.parseInt(dateQty[1]));
						}
					}
					salesMap.put(item, dateQtyMap);
				}
			} catch (IOException e) {
				writeError(e);
			}
		}

		// Add new items/dates from today's sales
		for (int row = 0; row < tableModel.getRowCount(); row++) {
			String item = tableModel.getValueAt(row, 0) != null ? tableModel.getValueAt(row, 0).toString() : "";
			int qty = tableModel.getValueAt(row, 2) != null ? Integer.parseInt(tableModel.getValueAt(row, 2).toString())
					: 1;
			String dateString = tableModel.getValueAt(row, 3) != null ? tableModel.getValueAt(row, 3).toString()
					: new Date() + "";
			DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss VV yyyy",
					Locale.ENGLISH);
			ZonedDateTime zonedDateTime = ZonedDateTime.parse(dateString, inputFormatter);

			// Format it into "dd/MM/yyyy"
			DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String formattedDate = zonedDateTime.format(outputFormatter);
			if (!item.isBlank() && qty > 0) {
				salesMap.putIfAbsent(item, new LinkedHashMap<>());
				salesMap.get(item).put(formattedDate, salesMap.get(item).getOrDefault(formattedDate, 0) + qty);
			}
		}

		// Write updated index to file
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(dates))) {
			writer.write("ITEM,DATE:QUANTITY");
			writer.newLine();
			for (Map.Entry<String, Map<String, Integer>> entry : salesMap.entrySet()) {
				StringBuilder line = new StringBuilder(entry.getKey());
				for (Map.Entry<String, Integer> dateEntry : entry.getValue().entrySet()) {
					line.append(",").append(dateEntry.getKey()).append(":").append(dateEntry.getValue());
				}
				writer.write(line.toString());
				writer.newLine();
			}
		} catch (IOException e) {
			writeError(e);
		}
	}

	/* Add the invoice panel */
	private void invoiceTab(DateModified date) {
		JDialog salesDialog = new JDialog(this, getLocalizedMessage("ADD_STOCK"), true);
		salesDialog.setSize(getWidth() * 2 / 3, getHeight() * 2 / 3);
		salesDialog.setLocationRelativeTo(null);
		if (date.equals(currentDate))
			salesDialog.setTitle(getLocalizedMessage("ADD_STOCK"));
		else
			salesDialog.setTitle(getLocalizedMessage("INVOICE") + " " + date.getToday());
		overlay.showOverlay();

		tabbedPane.tabLayout(TAB_LAYOUT.SCROLL);
		tabbedPane.showSeparator(true);

		JPanel topPanel = new JPanel(new BorderLayout());
		// Button to add new invoice tabs
		JButton addRowButton = new JButton(getLocalizedMessage("ADD") + " " + getLocalizedMessage("INVOICE"));
		addRowButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		addRowButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		addRowButton.addActionListener(_ -> {
			addNewInvoiceTab(date, true);
			tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
		});
		JPanel leftPanel = new JPanel(new BorderLayout());
		leftPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0)); // Left padding
		leftPanel.add(addRowButton, BorderLayout.CENTER);
		// Legend
		JLabel legend = new JLabel(
				"<html><b><u><font size='5'>" + getLocalizedMessage("F5") + "</font></u></b></html>");
		legend.setHorizontalAlignment(0);
		// UPDATE STOCK
		JButton saveButton = new JButton(getLocalizedMessage("UPDATE") + " STOCK");
		saveButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		saveButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		saveButton.addActionListener(_ -> {
			Map<String, Integer> accumulatedQuantities = new HashMap<>();
			for (DefaultTableModel model : invoiceModels) {
				for (int row = 0; row < model.getRowCount(); row++) {
					String item = model.getValueAt(row, 0) != null ? model.getValueAt(row, 0).toString() : "";
					int quantity = model.getValueAt(row, 1) != null
							? Integer.parseInt(model.getValueAt(row, 1).toString())
							: 0;
					accumulatedQuantities.put(item, accumulatedQuantities.getOrDefault(item, 0) + quantity);
				}
			}
			for (String keys : accumulatedQuantities.keySet()) {
				int value = accumulatedQuantities.get(keys);
				int qty = searchQty(keys);
				if (value > qty) {
					Toast.show(this, Toast.Type.ERROR,
							"'" + keys.toUpperCase() + "' " + getLocalizedMessage("SALES_EXCCED"), Intro.notOption);
					return;
				}
			}
			try {
				saveInvoices();// save current invoice
				updateMerchandiseCSV(); // update the stock file
				saveIndexItem(); // update the sales for today
				updateMainTable(); // add values to table
				if (employee.size() > 0)
					saveSellerTotal(); // save the sales for each seller
			} catch (Exception e) {
				writeError(e);
			}
			salesDialog.dispose();
			overlay.hideOverlay();
		});

		JPanel rightPanel = new JPanel(new BorderLayout());
		rightPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
		rightPanel.add(saveButton, BorderLayout.CENTER);
		topPanel.add(leftPanel, BorderLayout.WEST);
		topPanel.add(legend, BorderLayout.CENTER);
		topPanel.add(rightPanel, BorderLayout.EAST);
		topPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

		if (!date.equals(currentDate))
			topPanel.setVisible(false);

		salesDialog.add(topPanel, BorderLayout.NORTH);
		salesDialog.add(tabbedPane, BorderLayout.CENTER);

		// Key listener for ESC key to close the dialog
		InputMap inputMap = salesDialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap = salesDialog.getRootPane().getActionMap();
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "closeDialog");
		actionMap.put("closeDialog", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				salesDialog.dispose();
				if (date.equals(currentDate)) {
					saveInvoices();
					updateMainTable();
				}
				overlay.hideOverlay();
			}
		});
		salesDialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				if (date.equals(currentDate)) {
					saveInvoices();
					updateMainTable();
				}
				overlay.hideOverlay();
			}
		});

		salesDialog.setVisible(true);
	}

	/* The invoice multitab panel */
	private void addNewInvoiceTab(DateModified date, boolean addDefaultRow) {
		JLabel totalLabel = new JLabel();
		totalLabel.setOpaque(true);
		totalLabel.setBackground(Color.white);
		totalLabel.setForeground(Color.black);
		totalLabel.setFont(new Font("Arial", Font.BOLD, 20));
		totalLabel.setHorizontalAlignment(0);
		totalLabel.setToolTipText("TOTAL");
		totalLabel.setBorder(
				BorderFactory.createCompoundBorder(new LineBorder(fg, 1), BorderFactory.createEmptyBorder(5, 5, 5, 5)));

		// Create a new table model for the invoice
		String[] columnNames = { "ITEM", getLocalizedMessage("QUANTITY"), getLocalizedMessage("PRICE"), "TOTAL",
				getLocalizedMessage("DELETE") };
		String[] columnOldNames = { "ITEM", getLocalizedMessage("QUANTITY"), getLocalizedMessage("PRICE"), "TOTAL" };
		DefaultTableModel salesModel = new DefaultTableModel(date.equals(currentDate) ? columnNames : columnOldNames,
				0);

		JTable salesTable = new JTable(salesModel) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return date.equals(currentDate) ? column != 3 : false; // Disable editing for all cells
			}

			@Override
			public boolean editCellAt(int row, int column, EventObject e) {
				boolean result = super.editCellAt(row, column, e);
				final Component editor = getEditorComponent();

				if (editor instanceof JTextField) {
					JTextField textField = (JTextField) editor;

					// Select all text when editing starts
					if (e instanceof KeyEvent) {
						textField.setText(""); // Clear text for overwrite
						textField.requestFocusInWindow();
					} else {
						// If triggered by focus or mouse, select all text
						SwingUtilities.invokeLater(textField::selectAll);
					}
				}
				return result;
			}

		};
		invoiceModels.add(salesModel);

		// Add a ChangeListener to update the total when switching tabs
		tabbedPane.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateTotal(totalLabel);
			}
		});

		// Customize the table header
		JTableHeader header = salesTable.getTableHeader();
		header.setFont(new Font("Arial", Font.BOLD, 18));
		header.setBackground(new Color(220, 220, 220)); // Light gray background for header
		header.setForeground(Color.DARK_GRAY); // Dark gray text for header
		header.setReorderingAllowed(false); // Prevent column reordering
		header.setResizingAllowed(false); // Prevent column resizing

		salesTable.setFont(new Font("Arial", Font.PLAIN, 12));
		salesTable.setRowHeight(25);
		salesTable.setShowGrid(true);
		salesTable.setIntercellSpacing(new Dimension(0, 0));

		if (addDefaultRow && salesModel.getRowCount() == 0)
			if (date.equals(currentDate))
				salesModel.addRow(new Object[] { "", 1, 0, 0, "X" });

		// Center align table cells
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < 4; i++)
			salesTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);

		TableColumn column[] = new TableColumn[4];
		for (int i = 0; i < 4; i++) {
			column[i] = salesTable.getColumnModel().getColumn(i);
			if (i > 0) {
				column[i].setPreferredWidth(150);
				column[i].setMinWidth(150);
				column[i].setMaxWidth(150);
			}
		}
		if (date.equals(currentDate)) {
			salesTable.getColumnModel().getColumn(4).setPreferredWidth(150);
			salesTable.getColumnModel().getColumn(4).setMinWidth(150);
			salesTable.getColumnModel().getColumn(4).setMaxWidth(150);
		}
		// Custom editor for numeric columns
		DefaultCellEditor numericEditor = new DefaultCellEditor(new JTextField()) {
			{
				JTextField textField = (JTextField) getComponent();
				// Ensure only numeric input
				textField.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != '.') {
							e.consume(); // Ignore non-numeric input
						}
					}
				});
			}

			@Override
			public Object getCellEditorValue() {
				String text = ((JTextField) getComponent()).getText();
				if (TextEffect.isInteger(text)) {
					int number = Integer.parseInt(text);
					if (number <= 0)
						number = 1;
					return number;
				}
				return 1;
			}
		};
		DefaultCellEditor doubleEditor = new DefaultCellEditor(new JTextField()) {
			{
				JTextField textField = (JTextField) getComponent();
				// Ensure only numeric input
				textField.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != '.') {
							e.consume(); // Ignore non-numeric input
						}
					}
				});
			}

			@Override
			public Object getCellEditorValue() {
				String text = ((JTextField) getComponent()).getText();
				if (TextEffect.isDouble(text)) {
					double number = Double.parseDouble(text);
					if (number <= 0)
						number = 1;
					return number;
				}
				return 1;
			}
		};

		column[1].setCellEditor(numericEditor);
		column[2].setCellEditor(doubleEditor);

		List<String> merchandiseNames = new ArrayList<String>();
		for (int index = 0; index < merchandise.size(); index++)
			if (merchandise.get(index).getTotal() != merchandise.get(index).getSold())
				merchandiseNames.add(merchandise.get(index).getName());
		Collections.sort(merchandiseNames);

		JComboBox<String> combo = new JComboBox<String>(merchandiseNames.toArray(new String[0]));
		combo.setEditable(false);
		combo.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String text = ((JTextComponent) combo.getEditor().getEditorComponent()).getText();
				if (!merchandiseNames.contains(text))
					combo.setSelectedItem(null);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_F5)
					openSearchDialog(combo);
			}
		});
		AutoCompleteDecorator.decorate(combo);
		column[0].setCellEditor(new ComboBoxCellEditor(combo) {
			@Override
			public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
					int column) {
				Component editor = super.getTableCellEditorComponent(table, value, isSelected, row, column);
				SwingUtilities.invokeLater(() -> {
					combo.requestFocus();
					if (combo.isShowing())
						combo.showPopup();
				});
				return editor;
			}

			@Override
			public boolean stopCellEditing() {
				Object selectedObject = combo.getEditor().getItem();

				if (selectedObject == null) {
					return super.stopCellEditing(); // Prevents NullPointerException
				}

				String selectedItem = selectedObject.toString().trim();
				// Find the row index of the edited cell
				int row = salesTable.getEditingRow();
				if (row != -1) {
					// Find the price from the merchandise list
					for (Merchandise m : merchandise) {
						if (m.getName().equalsIgnoreCase(selectedItem)) {
							salesModel.setValueAt(m.getPrice(), row, 2); // Set price in PRICE column
							if (m.getTotal() == m.getSold())
								Toast.show(Main.this, Toast.Type.WARNING, getLocalizedMessage("NO") + " STOCK",
										Intro.notOption);
							break;
						}
					}
				}
				return super.stopCellEditing();
			}
		});

		// Add Delete button
		javax.swing.Action deleteAction = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTable table = (JTable) e.getSource();
				int row = Integer.parseInt(e.getActionCommand());
				((DefaultTableModel) table.getModel()).removeRow(row);
				updateTotal(totalLabel);
			}
		};
		if (date.equals(currentDate))
			new ButtonColumn(salesTable, deleteAction, 4); // Column index 3 for "Action"

		// Buttons to save or add rows
		JPanel tabPanel = new JPanel(new BorderLayout());

		JButton addRowButton = new JButton(getLocalizedMessage("ADD") + " ITEM");
		addRowButton.setFont(Intro.myFontS);
		addRowButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		addRowButton.addActionListener(_ -> salesModel.addRow(new Object[] { "", 1, 0, 0, "X" }));
		JButton closeButton = new JButton(getLocalizedMessage("DELETE") + " " + getLocalizedMessage("INVOICE"));
		closeButton.setFont(Intro.myFontS);
		closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		closeButton.addActionListener(_ -> {
			int index = tabbedPane.indexOfComponent(tabPanel);
			tabbedPane.remove(index);
			invoiceModels.remove(salesModel);
		});

		// invoice seller
		JComboBox<String> sellerName = new JComboBox<>();
		for (int i = 0; i < employee.size(); i++)
			if (!employee.get(i).getName().isBlank())
				sellerName.addItem(employee.get(i).getName());
		if (employee.size() > 0)
			sellerName.addItem(getLocalizedMessage("NO_SELLER"));
		sellerName.setFont(Intro.myFontS);
		sellerName.setRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected,
						cellHasFocus);
				label.setHorizontalAlignment(SwingConstants.CENTER);
				return label;
			}
		});
		paymentComboBoxes.add(sellerName);

		// Layout for the dialog
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 0));
		buttonPanel.add(addRowButton);
		if (employee.size() > 0)
			buttonPanel.add(sellerName);
		if (!date.equals(currentDate)) {
			if (employee.size() > 0)
				tabPanel.add(sellerName, BorderLayout.SOUTH);
			sellerName.setEnabled(false);
		} else {
			buttonPanel.add(closeButton);
			tabPanel.add(buttonPanel, BorderLayout.SOUTH);
		}
		tabPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));

		// Add components to the tab
		JPanel northPanel = new JPanel(new BorderLayout());
		northPanel.add(new JScrollPane(salesTable), BorderLayout.CENTER);
		northPanel.add(totalLabel, BorderLayout.SOUTH);
		northPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 10, 0));
		tabPanel.add(northPanel, BorderLayout.CENTER);

		updateTotal(totalLabel); // Initialize total
		salesModel.addTableModelListener(e -> {
			if (e.getType() == TableModelEvent.UPDATE) {
				int row = e.getFirstRow();
				int col = e.getColumn();
				// Update total when Qty (col 1) or Price (col 2) changes
				if (col == 1 || col == 2) {
					Object qtyObj = salesModel.getValueAt(row, 1);
					Object priceObj = salesModel.getValueAt(row, 2);
					if (qtyObj instanceof Number && priceObj instanceof Number) {
						int qty = ((Number) qtyObj).intValue();
						double price = ((Number) priceObj).doubleValue();
						salesModel.setValueAt(TextEffect.roundedDouble(qty * price), row, 3);
					}
				}
			}
			updateTotal(totalLabel); // Update grand total
		});

		// Add the tab with a default name (e.g., "Invoice 1")
		String tabTitle = getLocalizedMessage("INVOICE") + " " + (tabbedPane.getTabCount() + 1);
		tabbedPane.addTab(tabTitle, tabPanel);

	}

	/* Add more qty to existed merchandise */
	private void removeOldSale() {
		// Create a dialog for the merchandise table
		JDialog dialog = new JDialog(this, getLocalizedMessage("CHANGE_STOCK"), true);
		dialog.setSize(getWidth() / 2, getHeight() / 2);
		dialog.setLocationRelativeTo(this);
		overlay.showOverlay();

		// Create a table model and table
		DefaultTableModel tableModel = new DefaultTableModel(new String[] { "ITEM", getLocalizedMessage("DATE"),
				getLocalizedMessage("QUANTITY"), getLocalizedMessage("DELETE") }, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return true;
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				// Specify column types
				switch (columnIndex) {
				case 1:
					return Date.class;
				case 2:
					return Integer.class;
				default:
					return String.class;
				}
			}
		};
		tableModel.addRow(new Object[] { "", new Date(), 1, "X" });

		JTable stockTable = new JTable(tableModel);
		stockTable.setFont(new Font("Arial", Font.PLAIN, 16));
		stockTable.setRowHeight(30);
		stockTable.setShowGrid(true);
		stockTable.setIntercellSpacing(new Dimension(0, 0));

		// Add the table to a scroll pane
		JScrollPane scrollPane = new JScrollPane(stockTable);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		stockTable.setDefaultRenderer(Object.class, centerRenderer);

		TableColumn column[] = new TableColumn[4];
		for (int i = 0; i < 4; i++) {
			column[i] = stockTable.getColumnModel().getColumn(i);
			if (i == 3) {
				column[i].setPreferredWidth(90);
				column[i].setMinWidth(90);
				column[i].setMaxWidth(90);
			}
			column[i].setCellRenderer(centerRenderer);
		}

		// Load merchandise data
		List<String> merchandiseNames = new ArrayList<String>();
		for (int index = 0; index < merchandise.size(); index++)
			merchandiseNames.add(merchandise.get(index).getName());
		JComboBox<String> combo = new JComboBox<String>(merchandiseNames.toArray(new String[0]));
		combo.setEditable(false);
		combo.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_F5) {
					openSearchDialog(combo);
				}
			}
		});
		AutoCompleteDecorator.decorate(combo);
		column[0].setCellEditor(new ComboBoxCellEditor(combo) {
			@Override
			public boolean stopCellEditing() {
				Object selectedObject = combo.getEditor().getItem();
				if (selectedObject == null) {
					return super.stopCellEditing();
				}

				String selectedItem = selectedObject.toString().trim();

				int row = stockTable.getEditingRow();
				if (row != -1) {
					for (Merchandise m : merchandise) {
						if (m.getName().equalsIgnoreCase(selectedItem)) {
							stockTable.setValueAt(m.getTotal(), row, 0);
							break;
						}
					}
				}
				return super.stopCellEditing();
			}
		});
		JFormattedTextField textField, numberField = new JFormattedTextField();
		MaskFormatter dateMask;
		try {
			dateMask = new MaskFormatter("##/##/####");
			dateMask.setPlaceholderCharacter('_');
			textField = new JFormattedTextField(dateMask);
			textField.setColumns(10);
		} catch (ParseException e1) {
			throw new RuntimeException("Invalid mask format", e1);
		}
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_F5) {
					String name = combo.getSelectedItem() != null ? combo.getSelectedItem().toString() : "";
					if (!name.isBlank())
						viewItemAccToDate(name, "01/01/2020", currentDate.getToday(), 3);
				}
			}
		});
		column[1].setCellEditor(new DefaultCellEditor(textField) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			@Override
			public Object getCellEditorValue() {
				try {
					return sdf.parse(textField.getText());
				} catch (ParseException e) {
					return null;
				}
			}

			@Override
			public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
					int column) {
				textField.setText(value instanceof Date ? sdf.format((Date) value) : "");
				return textField;
			}
		});
		column[1].setCellRenderer(new DefaultTableCellRenderer() {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			@Override
			protected void setValue(Object value) {
				setHorizontalAlignment(SwingConstants.CENTER);
				if (value instanceof Date) {
					setText(sdf.format((Date) value));
				} else {
					setText("");
				}
			}
		});
		numberField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
					e.consume(); // Ignore non-numeric input
				}
				if (c == '0' && textField.getText().isEmpty()) {
					e.consume();
				}
				if (c == '.' || c == ',') {
					e.consume();
				}
			}
		});

		column[2].setCellEditor(new DefaultCellEditor(numberField));
		// Customize the table header
		JTableHeader header = stockTable.getTableHeader();
		header.setFont(new Font("Arial", Font.BOLD, 18));
		header.setBackground(new Color(220, 220, 220)); // Light gray background for header
		header.setForeground(Color.DARK_GRAY); // Dark gray text for header
		header.setReorderingAllowed(false); // Prevent column reordering
		header.setResizingAllowed(false); // Prevent column resizing

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
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				overlay.hideOverlay();
			}
		});

		// BOTTOM PANEL
		JPanel bottomPanel = new JPanel(new BorderLayout());
		JLabel legend = new JLabel("<html><b><u><center><font size='4'>" + getLocalizedMessage("F5-EXTRA")
				+ "</font></center></u></b></html>");
		legend.setHorizontalAlignment(0);
		JPanel buttonsP = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton addRowButton = new JButton(getLocalizedMessage("ADD") + " ITEM");
		addRowButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		addRowButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		addRowButton.addActionListener(_ -> tableModel.addRow(new Object[] { "", new Date(), 1, "X" }));
		JButton clearTable = new JButton(getLocalizedMessage("CLEAR"));
		clearTable.setFont(new Font("Segoe UI", Font.BOLD, 14));
		clearTable.setCursor(new Cursor(Cursor.HAND_CURSOR));
		clearTable.addActionListener(_ -> tableModel.setRowCount(0));
		JButton saveChanges = new JButton(getLocalizedMessage("SAVE"));
		saveChanges.setFont(new Font("Segoe UI", Font.BOLD, 14));
		saveChanges.setCursor(new Cursor(Cursor.HAND_CURSOR));
		saveChanges.addActionListener(_ -> {
			for (int row = 0; row < tableModel.getRowCount(); row++) {
				String name = tableModel.getValueAt(row, 0) != null ? tableModel.getValueAt(row, 0).toString() : "";
				String date = tableModel.getValueAt(row, 1) != null ? tableModel.getValueAt(row, 1).toString()
						: new Date() + "";
				String qtyS = tableModel.getValueAt(row, 2) != null ? tableModel.getValueAt(row, 2).toString() : "";
				int qty = TextEffect.isInteger(qtyS) ? Integer.parseInt(qtyS) : 0;
				DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss VV yyyy",
						Locale.ENGLISH);
				ZonedDateTime zonedDateTime = ZonedDateTime.parse(date, inputFormatter);

				DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				String formattedDate = zonedDateTime.format(outputFormatter);
				if (!name.isBlank() && !formattedDate.isBlank() && qty > 0)
					updateIndexItem(name, formattedDate, qty);
				dialog.dispose();
				overlay.hideOverlay();
			}
		});
		buttonsP.add(addRowButton);
		buttonsP.add(clearTable);
		buttonsP.add(saveChanges);
		// Add Delete button
		javax.swing.Action deleteAction = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTable table = (JTable) e.getSource();
				int row = Integer.parseInt(e.getActionCommand());
				((DefaultTableModel) table.getModel()).removeRow(row);
			}
		};
		new ButtonColumn(stockTable, deleteAction, 3);

		bottomPanel.add(legend, BorderLayout.CENTER);
		bottomPanel.add(buttonsP, BorderLayout.SOUTH);

		// Add the scroll pane to the dialog
		dialog.add(scrollPane, BorderLayout.CENTER);
		dialog.add(bottomPanel, BorderLayout.SOUTH);

		// Show the dialog
		dialog.setVisible(true);
	}

	/* Update the total of each invoice automatically */
	private void updateTotal(JLabel label) {
		int selectedIndex = tabbedPane.getSelectedIndex();
		if (selectedIndex < 0 || selectedIndex >= invoiceModels.size())
			return;

		DefaultTableModel model = invoiceModels.get(selectedIndex);
		double total = 0;
		for (int i = 0; i < model.getRowCount(); i++) {
			try {
				int quantity = Integer.parseInt(model.getValueAt(i, 1).toString());
				double unitPrice = Double.parseDouble(model.getValueAt(i, 2).toString());
				total += quantity * unitPrice;
			} catch (NumberFormatException | NullPointerException ignored) {
			}
		}
		total = roundedDouble(total);
		label.setText("$" + total);
	}

	/* Update the main table */
	private void updateMainTable() {
		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 20; j++) {
				details[i][j].setText("");
				detailsM[i][j].setText("");
			}
		List<Integer> sales = new ArrayList<>();
		for (int i = 0; i < invoiceModels.size(); i++) {
			DefaultTableModel model = invoiceModels.get(i);
			int totalI = 0;
			for (int row = 0; row < model.getRowCount(); row++) {
				int quantity = model.getValueAt(row, 1) != null ? Integer.parseInt(model.getValueAt(row, 1).toString())
						: 0;
				double price = model.getValueAt(row, 2) != null
						? Double.parseDouble(model.getValueAt(row, 2).toString())
						: 0;
				totalI += quantity * price;
			}
			if (totalI > 0)
				sales.add(totalI);
		}
		int indexX = 0, indexY = 0;
		for (int i = 0; i < sales.size(); i++)
			if (indexX < 20 && indexY < 6) {
				details[indexY][indexX].setText(sales.get(i) + "");
				indexX++;
			} else if (indexX == 20 && indexY < 6) {
				indexX = 0;
				indexY++;
				details[indexY][indexX].setText(sales.get(i) + "");
				indexX++;
			}
		sumF();
	}

	/* Search the merchandise in the invoice */
	private void openSearchDialog(JComboBox<String> combo) {
		JDialog searchDialog = new JDialog(this, getLocalizedMessage("ITEM_S"), true);
		searchDialog.setSize(combo.getWidth(), this.getHeight() / 2);
		Point location = combo.getLocationOnScreen();
		searchDialog.setLocation((int) location.getX(), (int) location.getY() + combo.getHeight());
		searchDialog.setLayout(new BorderLayout());

		DefaultTableModel tableModel = new DefaultTableModel(
				new String[] { "ITEM", "STOCK", getLocalizedMessage("UNIT_PRICE"), getLocalizedMessage("PRICE") }, 0);
		JTable searchTable = new JTable(tableModel) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		searchTable.setDefaultRenderer(Object.class, centerRenderer);

		searchTable.setFont(new Font("Arial", Font.PLAIN, 16));
		searchTable.setRowHeight(30);
		searchTable.setShowGrid(true);
		searchTable.setIntercellSpacing(new Dimension(0, 0));

		JTextField searchField = new JTextField();
		for (Merchandise m : merchandise) {
			int availableStock = m.getTotal() - m.getSold();
			if (availableStock > 0)
				tableModel.addRow(new Object[] { m.getName(), availableStock, m.getUnitPrice(), m.getPrice() });
		}

		JTableHeader header = searchTable.getTableHeader();
		header.setFont(new Font("Arial", Font.BOLD, 18));
		header.setBackground(new Color(220, 220, 220)); // Light gray background for header
		header.setForeground(Color.DARK_GRAY); // Dark gray text for header
		header.setReorderingAllowed(false); // Prevent column reordering
		header.setResizingAllowed(false); // Prevent column resizing

		searchTable.getColumnModel().getColumn(1).setPreferredWidth(80);
		searchTable.getColumnModel().getColumn(1).setMinWidth(80);
		searchTable.getColumnModel().getColumn(1).setMaxWidth(80);
		searchTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		searchTable.getColumnModel().getColumn(2).setPreferredWidth(90);
		searchTable.getColumnModel().getColumn(2).setMinWidth(90);
		searchTable.getColumnModel().getColumn(2).setMaxWidth(90);
		searchTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		searchTable.getColumnModel().getColumn(3).setPreferredWidth(90);
		searchTable.getColumnModel().getColumn(3).setMinWidth(90);
		searchTable.getColumnModel().getColumn(3).setMaxWidth(90);
		searchTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

		// Search filter
		searchField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String text = searchField.getText().toLowerCase();
				tableModel.setRowCount(0); // Clear table
				for (Merchandise m : merchandise) {
					if (m.getName().toLowerCase().contains(text)) {
						int availableStock = m.getTotal() - m.getSold();
						if (conf[19].equals("false")) {
							if (availableStock > 0)
								tableModel.addRow(
										new Object[] { m.getName(), availableStock, m.getUnitPrice(), m.getPrice() });
						} else
							tableModel.addRow(
									new Object[] { m.getName(), availableStock, m.getUnitPrice(), m.getPrice() });
					}
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					searchDialog.dispose();
				}
			}
		});
		searchTable.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					searchDialog.dispose();
				}

				else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					int row = searchTable.getSelectedRow();
					if (row != -1) {
						String selectedItem = searchTable.getValueAt(row, 0).toString();
						combo.setSelectedItem(selectedItem); // Set selected item in combo box
						searchDialog.dispose(); // Close dialog
					}
				}
			}
		});
		searchTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) { // Double click selects the item
					int row = searchTable.getSelectedRow();
					if (row != -1) {
						String selectedItem = searchTable.getValueAt(row, 0).toString();
						combo.setSelectedItem(selectedItem); // Set selected item in combo box
						searchDialog.dispose(); // Close dialog
					}
					;
				}
			}
		});

		searchDialog.add(searchField, BorderLayout.NORTH);
		searchDialog.add(new JScrollPane(searchTable), BorderLayout.CENTER);
		searchDialog.setVisible(true);
	}

	/* Load sales data */
	private Map<String, Map<String, Integer>> loadSalesData(int year) {
		File extraF = new File(dataFolder + "\\Stock");
		extraF.mkdir();
		File salesData = new File(extraF, "sales_index_" + year + ".csv");
		Map<String, Map<String, Integer>> salesMap = new LinkedHashMap<>();

		if (!salesData.exists())
			try {
				salesData.createNewFile();
			} catch (IOException e) {
				writeError(e);
			}
		else {// Read existing index
			try (BufferedReader reader = new BufferedReader(new FileReader(salesData))) {
				reader.readLine();
				String line;
				while ((line = reader.readLine()) != null) {
					String[] parts = line.split(",");
					String item = parts[0];
					Map<String, Integer> dateQtyMap = new LinkedHashMap<>();
					for (int i = 1; i < parts.length; i++) {
						String[] dateQty = parts[i].split(":");
						if (dateQty.length == 2)
							dateQtyMap.put(dateQty[0], Integer.parseInt(dateQty[1]));
					}
					salesMap.put(item, dateQtyMap);
				}
			} catch (IOException e) {
				writeError(e);
			}
		}
		return salesMap;
	}

	/* Save the item we sell today in an index file acc to date */
	private void saveIndexItem() {
		String date = currentDate.getToday();
		File extraF = new File(dataFolder + "\\Stock");
		extraF.mkdir();
		File salesData = new File(extraF, "sales_index_" + currentDate.y + ".csv");
		Map<String, Map<String, Integer>> salesMap = loadSalesData(currentDate.y);

		// Add new items/dates from today's sales
		for (DefaultTableModel model : invoiceModels) {
			for (int row = 0; row < model.getRowCount(); row++) {
				String item = model.getValueAt(row, 0) != null ? model.getValueAt(row, 0).toString() : "";
				int qty = model.getValueAt(row, 1) != null ? Integer.parseInt(model.getValueAt(row, 1).toString()) : 1;
				if (item.equals("---"))
					continue;

				salesMap.putIfAbsent(item, new LinkedHashMap<>());
				salesMap.get(item).put(date, salesMap.get(item).getOrDefault(date, 0) + qty);
			}
		}

		// Write updated index to file
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(salesData))) {
			writer.write("ITEM,DATE:QUANTITY");
			writer.newLine();
			for (Map.Entry<String, Map<String, Integer>> entry : salesMap.entrySet()) {
				StringBuilder line = new StringBuilder(entry.getKey());
				for (Map.Entry<String, Integer> dateEntry : entry.getValue().entrySet()) {
					line.append(",").append(dateEntry.getKey()).append(":").append(dateEntry.getValue());
				}
				writer.write(line.toString());
				writer.newLine();
			}
		} catch (IOException e) {
			writeError(e);
		}
	}

	/* Save the item we sell today in an index file acc to date */
	private void updateIndexItem(String targetItem, String targetDate, int quantityToRemove) {
		String year = targetDate.substring(6);
		File extraF = new File(dataFolder + "\\Stock");
		extraF.mkdir();
		File salesFile = new File(extraF, "sales_index_" + year + ".csv");
		List<String> updatedLines = new ArrayList<>();
		int qty = 0;

		if (salesFile.exists()) {
			try (BufferedReader reader = new BufferedReader(new FileReader(salesFile))) {
				String line;
				while ((line = reader.readLine()) != null) {
					String[] parts = line.split(",", 2);
					if (parts.length < 2)
						continue;

					String itemName = parts[0];
					String salesData = parts[1];

					if (itemName.equals(targetItem)) {// item found
						List<String> newEntries = new ArrayList<>();
						for (String entry : salesData.split(",")) {
							String[] dateQty = entry.split(":");// date w/ qty
							if (dateQty.length == 2) {
								String date = dateQty[0];
								int quantity = Integer.parseInt(dateQty[1]);
								if (date.equals(targetDate)) {// find date
									if (quantity > quantityToRemove) {// quantity to remove is correct
										newEntries.add(date + ":" + (quantity - quantityToRemove));
										qty = Integer.parseInt(dateQty[1]);
									} else if (quantity == quantityToRemove)
										qty = Integer.parseInt(dateQty[1]);
								} else
									newEntries.add(entry); // Keep other date
							}
						}
						if (!newEntries.isEmpty())
							updatedLines.add(itemName + "," + String.join(",", newEntries));
					} else
						updatedLines.add(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
			// Write back the modified data
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(salesFile))) {
				for (String updatedLine : updatedLines) {
					writer.write(updatedLine);
					writer.newLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// update sold value
		if (qty > 0) {
			loadStockData();
			File merchFile = new File(extraF, "stock.dll");
			try (PrintWriter writer = new PrintWriter(new FileWriter(merchFile))) {
				for (int row = 0; row < merchandise.size(); row++) {
					String name = merchandise.get(row).getName();
					int total = merchandise.get(row).getTotal();
					int sold = merchandise.get(row).getSold();
					String category = merchandise.get(row).getCategory();
					double price = merchandise.get(row).getPrice();
					double unitprice = merchandise.get(row).getUnitPrice();
					int id = merchandise.get(row).getID();
					if (name.equalsIgnoreCase(targetItem) && sold >= quantityToRemove)
						writer.println(String.join(",", name, total + "", (sold - quantityToRemove) + "", category,
								price + "", id + "", unitprice + ""));
					else
						writer.println(String.join(",", name, total + "", sold + "", category, price + "", id + "",
								unitprice + ""));
				}
			} catch (IOException e1) {
				writeError(e1);
			}
		}
	}

	/* Save Today invoices */
	private void saveInvoices() {
		File stockF = new File(dataFolder + "\\stock");
		stockF.mkdir();
		File yearFolder = new File(stockF + "\\" + yearS);
		yearFolder.mkdir();
		File monthFolder = new File(yearFolder + "\\" + currentDate.m + "-" + monthS);
		monthFolder.mkdir();
		File todayFile = new File(monthFolder, currentDate.d + "-" + currentDate.m + " (" + dayS + ").csv");
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(todayFile))) {
			writer.write("ITEM," + getLocalizedMessage("QUANTITY") + "," + getLocalizedMessage("PRICE"));
			writer.newLine();
			for (int i = 0; i < invoiceModels.size(); i++) {
				DefaultTableModel model = invoiceModels.get(i);
				String paymentMethod = paymentComboBoxes.get(i).getSelectedItem() != null
						? paymentComboBoxes.get(i).getSelectedItem().toString()
						: "";
				if (!paymentMethod.isEmpty()) {
					writer.write("SELLER," + paymentMethod);
					writer.newLine();
				}
				// Write items from this invoice
				for (int row = 0; row < model.getRowCount(); row++) {
					String item = model.getValueAt(row, 0) != null ? model.getValueAt(row, 0).toString() : "";
					int quantity = model.getValueAt(row, 1) != null
							? Integer.parseInt(model.getValueAt(row, 1).toString())
							: 0;
					double price = model.getValueAt(row, 2) != null
							? Double.parseDouble(model.getValueAt(row, 2).toString())
							: 0;
					if (!item.isEmpty() && quantity > 0) {
						writer.write(item + "," + quantity + "," + price);
						writer.newLine();

					}
				}
				// Add separator between invoices
				writer.write("---,---,---");
				writer.newLine();
			}
		} catch (IOException e) {
			writeError(e);
		}
	}

	/* Load invoice acc to date */
	private boolean loadInvoices(DateModified date) {
		paymentComboBoxes.clear();
		File stockF = new File(dataFolder + "\\stock");
		stockF.mkdir();
		File yearFolder = new File(stockF + "\\" + date.y);
		yearFolder.mkdir();
		File monthFolder = new File(yearFolder + "\\" + date.m + "-" + getMonthForInt(date.m - 1, langIndex));
		monthFolder.mkdir();
		File todayFile = new File(monthFolder, date.d + "-" + date.m + " (" + dayName(date, langIndex) + ").csv");
		if (todayFile.exists()) {
			try (BufferedReader reader = new BufferedReader(new FileReader(todayFile))) {
				String line;
				DefaultTableModel currentModel = null;
				JComboBox<String> currentComboBox = null;
				boolean skipHeader = true; // Skip the header line
				while ((line = reader.readLine()) != null) {
					if (skipHeader) {
						skipHeader = false;
						continue;
					}
					if (line.equals("---,---,---")) {
						// Separator: Prepare for a new invoice
						currentModel = null;
						currentComboBox = null;
					} else {
						String[] parts = line.split(",");
						if (parts[0].equals("SELLER")) {
							addNewInvoiceTab(date, false);
							currentModel = invoiceModels.get(invoiceModels.size() - 1);
							currentComboBox = paymentComboBoxes.get(invoiceModels.size() - 1);
							currentComboBox.setSelectedItem(parts[1]); // Restore payment method

						} else {
							if (parts.length == 3) {
								String itemName = parts[0];
								int qty = TextEffect.isInteger(parts[1]) ? Integer.parseInt(parts[1]) : 0;
								double price = TextEffect.isDouble(parts[2]) ? Double.parseDouble(parts[2]) : 0;
								double total = TextEffect.roundedDouble(qty * price);
								if (currentModel == null) {
									addNewInvoiceTab(date, false);
									currentModel = invoiceModels.get(invoiceModels.size() - 1);
									currentComboBox = paymentComboBoxes.get(invoiceModels.size() - 1);
								}
								currentModel.addRow(new Object[] { itemName, qty, price, total });
							}
						}
					}
				}

			} catch (IOException e) {
				writeError(e);
			}
		} else if (!date.equals(currentDate)) {
			return false;
		} else
			addNewInvoiceTab(date, true);

		return true;
	}

	/* View old invoices according to date */
	private void viewOldInvoices() {
		JDialog dialog = new JDialog(this, getLocalizedMessage("OLD_INVOICES"), true);
		dialog.setUndecorated(true);
		dialog.setSize(getWidth() / 2, getHeight() / 2);
		dialog.setShape(new RoundRectangle2D.Double(0, 0, getWidth() / 2, getHeight() / 2, 20, 20));
		dialog.setLocationRelativeTo(this);
		dialog.setLayout(new GridBagLayout());
		dialog.setResizable(false);
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

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weightx = 1; // Allow horizontal centering
		gbc.weighty = 1; // Allow vertical centering

		// Date Field (Non-editable)
		JFormattedTextField dateSelected = new JFormattedTextField();
		dateSelected.setFont(new Font("Tahoma", Font.BOLD, 18));
		dateSelected.setForeground(fg);
		dateSelected.setBackground(bg);
		dateSelected.setBorder(new LineBorder(fg, 1));
		dateSelected.setHorizontalAlignment(0);
		dateSelected.setPreferredSize(new Dimension(dialog.getWidth() / 2, 30));

		datePicker = new DatePicker();
		datePicker.now();
		datePicker.setEditor(dateSelected);
		datePicker.setDateSelectionMode(DatePicker.DateSelectionMode.SINGLE_DATE_SELECTED);
		datePicker.setUsePanelOption(true);
		datePicker.setCloseAfterSelected(true);
		datePicker.setEditorValidation(true);
		datePicker.setValidationOnNull(true);

		// Buttons
		JButton yesterday = new JButton(getLocalizedMessage("YESTERDAY"));
		JButton lastWeek = new JButton(getLocalizedMessage("LAST_WEEK").toUpperCase());
		JButton lastMonth = new JButton(
				language == Language.ENGLISH ? getLocalizedMessage("LAST") + " " + getLocalizedMessage("MONTH")
						: getLocalizedMessage("MONTH") + " " + getLocalizedMessage("LAST"));
		JButton lastYear = new JButton(
				language == Language.ENGLISH ? getLocalizedMessage("LAST") + " " + getLocalizedMessage("YEAR")
						: getLocalizedMessage("YEAR") + " " + getLocalizedMessage("LAST"));
		yesterday.addActionListener(_ -> dateSelected.setText(currentDate.getYesterday()));
		lastWeek.addActionListener(_ -> dateSelected.setText(currentDate.getLastWeek()));
		lastMonth.addActionListener(_ -> dateSelected.setText(currentDate.getLastMonth()));
		lastYear.addActionListener(_ -> dateSelected.setText(currentDate.getLastYear()));
		lastWeek.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lastMonth.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lastYear.setFont(new Font("Segoe UI", Font.BOLD, 14));
		yesterday.setFont(new Font("Segoe UI", Font.BOLD, 14));

		// Load Button
		JButton loadButton = new JButton(getLocalizedMessage("LOAD") + " " + getLocalizedMessage("INVOICE"));
		loadButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		loadButton.addActionListener(_ -> {
			if (dateSelected.getText().equals("--/--/----"))
				Toast.show(this, Toast.Type.ERROR, getLocalizedMessage("DATE_E"), Intro.notOption);
			else {
				DateModified selectedDate = new DateModified(datePicker.getSelectedDate().getDayOfMonth(),
						datePicker.getSelectedDate().getMonthValue(), datePicker.getSelectedDate().getYear());
				// Clear existing invoices before loading new ones
				tabbedPane.removeAll();
				invoiceModels.clear();
				Boolean existedDate = loadInvoices(selectedDate);
				if (!existedDate)
					Toast.show(this, Toast.Type.INFO, getLocalizedMessage("NO_DATA"), Intro.notOption);
				else
					invoiceTab(selectedDate);
			}
		});

		// Close Button
		JButton closeButton = new JButton(ImageEffect.getScaledImage(closeImage.getImage(), 15, 15));
		closeButton.setBorderPainted(false);
		closeButton.setFocusPainted(false);
		closeButton.setContentAreaFilled(false);
		closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		closeButton.setToolTipText(getLocalizedMessage("EXIT"));
		closeButton.addActionListener(_ -> {
			dialog.dispose();
			overlay.hideOverlay();
		});

		// Add Components to Dialog
		JPanel borderLay = new JPanel(new GridBagLayout());
		borderLay.setOpaque(false);
		// Add Components to Dialog
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 4;
		borderLay.add(
				new JLabel("<html><b><u><font size='5'>" + getLocalizedMessage("DATE_S") + "</font></u></b></html>"),
				gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		borderLay.add(yesterday, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		borderLay.add(lastWeek, gbc);
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		borderLay.add(lastMonth, gbc);
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		borderLay.add(lastYear, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 4;
		borderLay.add(dateSelected, gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 4;
		borderLay.add(loadButton, gbc);
		JPanel northPanel = new JPanel(new BorderLayout());
		northPanel.setOpaque(false);
		northPanel.add(closeButton, BorderLayout.EAST);
		contentPane.add(northPanel, BorderLayout.NORTH);
		contentPane.add(borderLay, BorderLayout.CENTER);

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
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				overlay.hideOverlay();
			}
		});

		dialog.setVisible(true);
	}

	/* Present the sales of an item acc to a period of time */
	private void searchItemByDates() {
		JDialog dialog = new JDialog(this, "", true);
		dialog.setUndecorated(true);
		dialog.setSize(getWidth() / 2, getHeight() / 2);
		dialog.setShape(new RoundRectangle2D.Double(0, 0, getWidth() / 2, getHeight() / 2, 20, 20));
		dialog.setLocationRelativeTo(this);
		dialog.setResizable(false);
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

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weightx = 1; // Allow horizontal centering
		gbc.weighty = 1; // Allow vertical centering

		// Date Field (Non-editable)
		JFormattedTextField dateSelected = new JFormattedTextField();
		dateSelected.setFont(new Font("Tahoma", Font.BOLD, 18));
		dateSelected.setForeground(fg);
		dateSelected.setBackground(bg);
		dateSelected.setBorder(new LineBorder(fg, 1));
		dateSelected.setHorizontalAlignment(0);
		dateSelected.setPreferredSize(new Dimension(dialog.getWidth() * 2 / 3, 30));
		dateSelected.setVisible(false);

		datePicker = new DatePicker();
		datePicker.now();
		datePicker.setEditor(dateSelected);
		datePicker.setDateSelectionMode(DatePicker.DateSelectionMode.BETWEEN_DATE_SELECTED);
		datePicker.setUsePanelOption(true);
		datePicker.setCloseAfterSelected(true);
		datePicker.setEditorValidation(true);
		datePicker.setValidationOnNull(true);

		// Buttons
		JButton allTime = new JButton(getLocalizedMessage("ALL_TIME"));
		JButton lastWeek = new JButton(getLocalizedMessage("LAST_WEEK").toUpperCase());
		JButton certainMonth = new JButton(getLocalizedMessage("MONTH"));
		JButton certainYear = new JButton(getLocalizedMessage("YEAR"));
		JButton betwenDate = new JButton(getLocalizedMessage("BETWEEN") + " " + getLocalizedMessage("DATE"));
		JButton loadTable = new JButton(getLocalizedMessage("LOAD") + " STOCK");
		JButton loadGraph = new JButton(getLocalizedMessage("LOAD") + " " + getLocalizedMessage("GRAPH"));
		String[] months = new String[12];
		for (int i = 0; i < 12; i++)
			months[i] = getMonthForInt(i, langIndex);
		JComboBox<String> monthCombo = new JComboBox<String>(months);
		DefaultListCellRenderer monthsRender = new DefaultListCellRenderer() {
			private final int currentMonth = currentDate.m;

			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {

				Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if (index >= currentMonth) {
					c.setForeground(Color.GRAY); // Grays out future months
				}
				return c;
			}
		};
		monthCombo.setRenderer(monthsRender);
		monthCombo.setEditable(false);
		monthCombo.setSelectedIndex(currentDate.m - 1);
		monthCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = monthCombo.getSelectedIndex();
				DateModified selectedDate = new DateModified(1, selectedIndex + 1, currentDate.y);
				if (selectedIndex > currentDate.m - 1) {
					monthCombo.setSelectedIndex(currentDate.m - 1);
				} else if (selectedIndex == currentDate.m - 1)
					dateSelected
							.setText("01" + ((selectedIndex + 1) < 10 ? "0" + (selectedIndex + 1) : (selectedIndex + 1))
									+ selectedDate.y + " to " + currentDate.getToday());
				else
					dateSelected
							.setText("01" + ((selectedIndex + 1) < 10 ? "0" + (selectedIndex + 1) : (selectedIndex + 1))
									+ selectedDate.y + " to " + selectedDate.maxDays()
									+ ((selectedIndex + 1) < 10 ? "0" + (selectedIndex + 1) : (selectedIndex + 1))
									+ +selectedDate.y);
				dateSelected.setVisible(false);
			}
		});
		monthCombo.setVisible(false);
		allTime.addActionListener(_ -> {
			optionChoosing = 3;
			monthCombo.setVisible(false);
			dateSelected.setText("01/01/2020 to " + currentDate.getToday());
			dateSelected.setVisible(false);
			loadGraph.setEnabled(false);
			lastWeek.setEnabled(true);
			allTime.setEnabled(false);
			certainMonth.setEnabled(true);
			certainYear.setEnabled(true);
			betwenDate.setEnabled(true);
		});
		lastWeek.addActionListener(_ -> {
			optionChoosing = 0;
			dateSelected.setText(currentDate.getLastWeek() + " to " + currentDate.getToday());
			monthCombo.setVisible(false);
			dateSelected.setVisible(false);
			loadGraph.setEnabled(false);
			lastWeek.setEnabled(false);
			allTime.setEnabled(true);
			certainMonth.setEnabled(true);
			certainYear.setEnabled(true);
			betwenDate.setEnabled(true);
		});
		certainMonth.addActionListener(_ -> {
			optionChoosing = 1;
			monthCombo.setVisible(true);
			dateSelected.setVisible(false);
			loadGraph.setEnabled(true);
			dateSelected.setText("01/" + (currentDate.m < 10 ? "0" + currentDate.m : currentDate.m) + "/"
					+ currentDate.y + " to " + currentDate.getToday());
			lastWeek.setEnabled(true);
			allTime.setEnabled(true);
			certainMonth.setEnabled(false);
			certainYear.setEnabled(true);
			betwenDate.setEnabled(true);
		});
		certainYear.addActionListener(_ -> {
			optionChoosing = 2;
			dateSelected.setText("01/01/" + currentDate.y + " to " + currentDate.getToday());
			monthCombo.setVisible(false);
			dateSelected.setVisible(false);
			loadGraph.setEnabled(true);
			lastWeek.setEnabled(true);
			allTime.setEnabled(true);
			certainMonth.setEnabled(true);
			certainYear.setEnabled(false);
			betwenDate.setEnabled(true);
		});
		betwenDate.addActionListener(_ -> {
			optionChoosing = 4;
			dateSelected.setText(null);
			dateSelected.setVisible(true);
			datePicker.showPopup();
			loadGraph.setEnabled(false);
			lastWeek.setEnabled(true);
			allTime.setEnabled(true);
			certainMonth.setEnabled(true);
			certainYear.setEnabled(true);
			betwenDate.setEnabled(false);
		});
		lastWeek.setFont(new Font("Segoe UI", Font.BOLD, 14));
		allTime.setFont(new Font("Segoe UI", Font.BOLD, 14));
		certainMonth.setFont(new Font("Segoe UI", Font.BOLD, 14));
		certainYear.setFont(new Font("Segoe UI", Font.BOLD, 14));
		betwenDate.setFont(new Font("Segoe UI", Font.BOLD, 14));
		loadTable.setFont(new Font("Segoe UI", Font.BOLD, 14));
		loadGraph.setFont(new Font("Segoe UI", Font.BOLD, 14));

		List<String> merchandiseNames = new ArrayList<String>();
		for (int index = 0; index < merchandise.size(); index++)
			merchandiseNames.add(merchandise.get(index).getName());

		JComboBox<String> combo = new JComboBox<String>(merchandiseNames.toArray(new String[0]));
		combo.setFont(new Font("Segoe UI", Font.BOLD, 14));
		combo.setEditable(false);
		combo.setPreferredSize(new Dimension(dialog.getWidth() * 2 / 3, 30));
		combo.setRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected,
						cellHasFocus);
				label.setHorizontalAlignment(SwingConstants.CENTER); // Center text in dropdown
				return label;
			}
		});
		JTextField editor = (JTextField) combo.getEditor().getEditorComponent();
		editor.setHorizontalAlignment(JTextField.CENTER);
		combo.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				String text = ((JTextComponent) combo.getEditor().getEditorComponent()).getText();
				if (!merchandiseNames.contains(text))
					combo.setSelectedItem(null);
			}
		});
		AutoCompleteDecorator.decorate(combo);

		// Loads
		loadTable.addActionListener(_ -> {
			if (dateSelected.getText().equals("--/--/---- to --/--/----"))
				Toast.show(this, Toast.Type.ERROR, getLocalizedMessage("DATE_E"), Intro.notOption);
			else {
				String[] dates = dateSelected.getText().split(" to ");
				if (dates.length == 2) {
					String IntroDate = dates[0];
					String secondDate = dates[1];
					viewItemAccToDate(combo.getSelectedItem().toString(), IntroDate, secondDate, optionChoosing);
				}
			}
		});
		loadGraph.addActionListener(_ -> {
			if (dateSelected.getText().equals("--/--/---- to --/--/----"))
				Toast.show(this, Toast.Type.ERROR, getLocalizedMessage("DATE_E"), Intro.notOption);
			else {
				String[] dates = dateSelected.getText().split(" to ");
				if (dates.length == 2) {
					String IntroDate = dates[0];
					String secondDate = dates[1];
					viewItemAccToGraph(combo.getSelectedItem().toString(), IntroDate, secondDate);
				}
			}
		});
		loadGraph.setEnabled(false);

		// Close Button
		JButton closeButton = new JButton(ImageEffect.getScaledImage(closeImage.getImage(), 15, 15));
		closeButton.setBorderPainted(false);
		closeButton.setFocusPainted(false);
		closeButton.setContentAreaFilled(false);
		closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		closeButton.setToolTipText(getLocalizedMessage("EXIT"));
		closeButton.addActionListener(_ -> {
			dialog.dispose();
			overlay.hideOverlay();
		});

		// Add Components to Dialog
		JPanel borderLay = new JPanel(new GridBagLayout());
		borderLay.setOpaque(false);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 5;
		borderLay.add(
				new JLabel("<html><b><u><font size='5'>" + getLocalizedMessage("DATE_S") + "</font></u></b></html>"),
				gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		borderLay.add(lastWeek, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		borderLay.add(certainMonth, gbc);
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		borderLay.add(certainYear, gbc);
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		borderLay.add(allTime, gbc);
		gbc.gridx = 4;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		borderLay.add(betwenDate, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 5;
		borderLay.add(monthCombo, gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 5;
		borderLay.add(dateSelected, gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 5;
		borderLay.add(
				new JLabel("<html><b><u><font size='5'>" + getLocalizedMessage("ITEM_S") + "</font></u></b></html>"),
				gbc);
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 5;
		borderLay.add(combo, gbc);
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 2;
		borderLay.add(loadTable, gbc);
		gbc.gridx = 3;
		gbc.gridy = 6;
		gbc.gridwidth = 2;
		borderLay.add(loadGraph, gbc);
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 5;
		borderLay.add(
				new JLabel(
						"<html><i><u><font size='4'>" + getLocalizedMessage("GRAPH_NOTE") + "</font></u></i></html>"),
				gbc);
		contentPane.add(borderLay, BorderLayout.CENTER);
		JPanel northPanel = new JPanel(new BorderLayout());
		northPanel.setOpaque(false);
		northPanel.add(closeButton, BorderLayout.EAST);
		contentPane.add(northPanel, BorderLayout.NORTH);

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
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				overlay.hideOverlay();
			}
		});

		dialog.setVisible(true);
	}

	/* Show the sales as table */
	private void viewItemAccToDate(String itemName, String IntroDate, String endDate, int option) {
		// Create a dialog for the merchandise table
		JDialog dialog = new JDialog(this, getLocalizedMessage("SEARCH_STOCK"), true);
		dialog.setSize(getWidth() * 2 / 3, getHeight() * 2 / 3);
		dialog.setLocationRelativeTo(this);

		// Create a table model and table
		tableModel = new DefaultTableModel(
				new String[] { getLocalizedMessage("DATE"), getLocalizedMessage("HOW_MUCH") }, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // All cells are non-editable
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				// Specify column types
				switch (columnIndex) {
				case 1: // Total
					return Integer.class; // Numeric columns
				default:
					return String.class; // Default to String
				}
			}
		};

		// Load merchandise data
		Map<String, Integer> dateQuantity = searchItemDates(itemName);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		// Define start and end dates
		LocalDate startDate = LocalDate.parse(IntroDate, formatter);
		LocalDate lastDate = LocalDate.parse(endDate, formatter);
		// Filter the map while keeping quantity
		Map<String, Integer> filteredMap = dateQuantity.entrySet().stream().filter(entry -> {
			LocalDate date = LocalDate.parse(entry.getKey(), formatter);
			return !date.isBefore(startDate) && !date.isAfter(lastDate);
		}).sorted(Comparator.comparing(entry -> LocalDate.parse(entry.getKey(), formatter))) // Sort by date
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, _) -> oldValue,
						LinkedHashMap::new // Preserve order
				));
		int total = 0;
		for (Map.Entry<String, Integer> entry : filteredMap.entrySet()) {
			String date = entry.getKey();
			int qty = entry.getValue();
			total += qty;
			tableModel.addRow(new Object[] { date, qty });
		}

		if (total == 0) {
			dialog.dispose();
			Toast.show(this, Toast.Type.INFO, getLocalizedMessage("NO_DATA"), Intro.notOption);
		} else {
			table = new JTable(tableModel);
			table.setFont(new Font("Arial", Font.PLAIN, 16));
			table.setRowHeight(30);
			table.setShowGrid(true);
			table.setIntercellSpacing(new Dimension(0, 0));

			// Add the table to a scroll pane
			JScrollPane scrollPane = new JScrollPane(table);
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
			table.setDefaultRenderer(Object.class, centerRenderer);
			table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

			// Customize the table header
			JTableHeader header = table.getTableHeader();
			header.setFont(new Font("Arial", Font.BOLD, 18));
			header.setBackground(new Color(220, 220, 220)); // Light gray background for header
			header.setForeground(Color.DARK_GRAY); // Dark gray text for header
			header.setReorderingAllowed(false); // Prevent column reordering
			header.setResizingAllowed(false); // Prevent column resizing

			// Add a row sorter for filtering
			TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
			sorter.setComparator(0, (String date1, String date2) -> { // Sorting column 0 (Dates)
				LocalDate d1 = LocalDate.parse(date1, formatter);
				LocalDate d2 = LocalDate.parse(date2, formatter);
				return d1.compareTo(d2); // Sort past → future
			});

			table.setRowSorter(sorter);

			// Add title
			String address;
			if (option == 0)
				address = getLocalizedMessage("LAST_WEEK").toUpperCase();
			else if (option == 1)
				address = getMonthForInt(startDate.getMonthValue() - 1, langIndex);
			else if (option == 2)
				address = currentDate.y + "";
			else if (option == 3)
				address = getLocalizedMessage("ALL_TIME");
			else
				address = getLocalizedMessage("BETWEEN") + " " + IntroDate + " " + getLocalizedMessage("AND") + " "
						+ endDate;
			JLabel title = new JLabel(getLocalizedMessage("SELL") + " " + getLocalizedMessage("OF") + " "
					+ itemName.toUpperCase() + " (" + address + ")");
			title.setFont(new Font("Arial", Font.BOLD, 18));
			title.setHorizontalAlignment(0);
			title.setForeground(fg);
			title.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2),
					BorderFactory.createEmptyBorder(5, 10, 5, 10)));

			JLabel totalL = new JLabel("T O T A L :  " + total);
			totalL.setFont(new Font("Arial", Font.BOLD, 18));
			totalL.setHorizontalAlignment(0);
			totalL.setForeground(fg);
			totalL.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2),
					BorderFactory.createEmptyBorder(5, 10, 5, 10)));

			// Add the scroll pane to the dialog
			dialog.add(title, BorderLayout.NORTH);
			dialog.add(scrollPane, BorderLayout.CENTER);
			dialog.add(totalL, BorderLayout.SOUTH);

			// Key listener for ESC key to close the dialog
			InputMap inputMap = dialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
			ActionMap actionMap = dialog.getRootPane().getActionMap();
			inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "closeDialog");
			actionMap.put("closeDialog", new AbstractAction() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dialog.dispose();
				}
			});

			// Show the dialog
			dialog.setVisible(true);
		}
	}

	/* Show the sales as graph */
	private void viewItemAccToGraph(String itemName, String IntroDate, String endDate) {
		// Create a dialog for the merchandise table
		JDialog dialog = new JDialog(this, getLocalizedMessage("SEARCH_STOCK"), true);
		dialog.setSize(getWidth() * 2 / 3, getHeight() * 2 / 3);
		dialog.setLocationRelativeTo(this);

		// Load merchandise data
		Map<String, Integer> dateQuantity = searchItemDates(itemName);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		// Define start and end dates
		LocalDate startDate = LocalDate.parse(IntroDate, formatter);
		LocalDate lastDate = LocalDate.parse(endDate, formatter);
		// Filter the map while keeping quantity
		Map<String, Integer> filteredMap = dateQuantity.entrySet().stream().filter(entry -> {
			LocalDate date = LocalDate.parse(entry.getKey(), formatter);
			return !date.isBefore(startDate) && !date.isAfter(lastDate);
		}).sorted(Comparator.comparing(entry -> LocalDate.parse(entry.getKey(), formatter))) // Sort by date
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, _) -> oldValue,
						LinkedHashMap::new // Preserve order
				));
		if (filteredMap.size() == 0) {
			dialog.dispose();
			Toast.show(this, Toast.Type.INFO, getLocalizedMessage("NO_DATA"), Intro.notOption);
		} else {
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			ArrayList<Integer> quant = new ArrayList<Integer>(), quantY = new ArrayList<Integer>();
			Boolean isYear = IntroDate.equals("01/01/" + currentDate.y) && endDate.equals(currentDate.getToday());
			for (LocalDate date = startDate; !date.isAfter(lastDate); date = date.plusDays(1)) {
				String dateStr = date.format(formatter);
				int qty = filteredMap.getOrDefault(dateStr, 0); // Default 0 if missing
				quant.add(qty);
				if (!isYear)
					dataset.addValue(qty == 0 ? null : qty, "SELL", dateStr.substring(0, 2)); // Use day as X-axis label
			}
			if (isYear) {
				DateModified dateN;
				int indexMonth = 0, currentIndex = 0;
				int totalMonth[] = new int[currentDate.m];
				for (int i = 0; i < currentDate.m; i++) {
					totalMonth[i] = 0;
					dateN = new DateModified(currentDate.d, i + 1, currentDate.y);
					indexMonth = dateN.m == currentDate.m ? dateN.d : dateN.maxDays();
					for (int j = 0; j < indexMonth; j++) {
						totalMonth[i] += quant.get(currentIndex + j);
					}
					currentIndex += dateN.maxDays();
					quantY.add(totalMonth[i]);
					dataset.addValue(quantY.get(i) == 0 ? null : quantY.get(i), getLocalizedMessage("SELL"),
							getMonthForInt(i, langIndex));
				}
			}
			// Create the chart
			JFreeChart lineChart = ChartFactory
					.createLineChart(
							getLocalizedMessage("SELL") + " " + getLocalizedMessage("OF") + " " + itemName.toUpperCase()
									+ " ("
									+ (isYear ? currentDate.y + ""
											: getMonthForInt(startDate.getMonthValue() - 1, langIndex))
									+ ")",
							isYear ? getLocalizedMessage("MONTH") : getLocalizedMessage("DAY"),
							getLocalizedMessage("SELL"), dataset);

			// Customize chart background color
			lineChart.setBackgroundPaint(bg);
			lineChart.getTitle().setPaint(fg);
			lineChart.removeLegend();
			CategoryPlot plot = lineChart.getCategoryPlot();
			plot.setBackgroundPaint(bg);
			plot.setOutlineVisible(false);
			// X-Axis (Domain Axis) customization
			plot.getDomainAxis().setAxisLinePaint(fg);
			plot.getDomainAxis().setTickLabelPaint(fg);
			plot.getDomainAxis().setLabelPaint(fg);

			// Y-Axis (Range Axis) customization
			plot.getRangeAxis().setAxisLinePaint(fg);
			plot.getRangeAxis().setTickLabelPaint(fg);
			plot.getRangeAxis().setLabelPaint(fg);

			// Customize the line and point rendering
			/* get max and min */
			int maximo = 0;
			if (isYear) {
				if (quantY.size() > 0) {
					if (quantY.get(0) != null)
						maximo = quantY.get(0);
					for (int i = 1; i < quantY.size(); i++)
						if (quantY.get(i) != null && quantY.get(i) > maximo)
							maximo = quantY.get(i);
				}
			} else if (quant.size() > 0) {
				if (quant.get(0) != null)
					maximo = quant.get(0);
				for (int i = 1; i < quant.size(); i++)
					if (quant.get(i) != null && quant.get(i) > maximo)
						maximo = quant.get(i);
			}
			int minimo = maximo;
			if (isYear) {
				if (quantY.size() > 0) {
					if (quantY.get(0) != null)
						minimo = quantY.get(0);
					for (int i = 1; i < quantY.size(); i++)
						if (quantY.get(i) != null && quantY.get(i) < minimo)
							minimo = quantY.get(i);
				}
			} else if (quant.size() > 0) {
				if (quant.get(0) != null)
					minimo = quant.get(0);
				for (int i = 1; i < quant.size(); i++)
					if (quant.get(i) != null && quant.get(i) < minimo)
						minimo = quant.get(i);
			}
			/* the line average */
			double total = 0, nbOfDays = 0;
			if (isYear) {
				for (int i = 0; i < quantY.size(); i++) {
					if (quantY.get(i) != null) {
						total += quantY.get(i).doubleValue();
						nbOfDays++;
					}
				}
			} else
				for (int i = 0; i < quant.size(); i++) {
					if (quant.get(i) != null) {
						total += quant.get(i).doubleValue();
						nbOfDays++;
					}
				}
			double average = nbOfDays == 0 ? 0 : total / nbOfDays;
			// Add average line
			ValueMarker averageMarker = new ValueMarker(average);
			averageMarker.setPaint(colorSelected == 2 ? Intro.blackM : skyblueC);
			averageMarker.setStroke(new BasicStroke(2.0f));
			averageMarker.setLabel("$ " + String.format("%.2f", average)); // Format the average
			averageMarker.setLabelAnchor(RectangleAnchor.BOTTOM_RIGHT); // Position the label
			averageMarker.setLabelTextAnchor(TextAnchor.BOTTOM_RIGHT);
			averageMarker.setLabelPaint(Color.black);
			averageMarker.setLabelBackgroundColor(Color.white);
			plot.addRangeMarker(averageMarker);
			CustomLineAndShapeRenderer renderer = new CustomLineAndShapeRenderer(maximo, minimo);
			renderer.setSeriesPaint(0, fg);
			renderer.setDefaultToolTipGenerator(new CategoryToolTipGenerator() {
				@Override
				public String generateToolTip(org.jfree.data.category.CategoryDataset dataset, int row, int column) {
					return dataset.getValue(row, column) + "";
				}
			});
			plot.setRenderer(renderer);

			// Create and display the panel
			ChartPanel chartPanel = new ChartPanel(lineChart);
			chartPanel.setPreferredSize(new Dimension(getWidth() * 2 / 3, getHeight() * 2 / 3));

			// Menubar
			JMenuBar menu = new JMenuBar();
			JMenu file = new JMenu(getLocalizedMessage("FILE"));
			JMenu save = new JMenu(getLocalizedMessage("SAVE"));
			JMenuItem exit = new JMenuItem(getLocalizedMessage("EXIT"));
			JMenuItem saveAsPng = new JMenuItem("PNG");
			JMenuItem saveAsPdf = new JMenuItem("PDF");
			JMenuItem saveAsSvg = new JMenuItem("SVG");
			saveAsPng.setIcon(colorSelected == 2 ? ImageEffect.getScaledImage(pngI.getImage(), 35, 35)
					: ImageEffect.invertColor(ImageEffect.getScaledImage(pngI.getImage(), 35, 35)));
			saveAsPdf.setIcon(colorSelected == 2 ? ImageEffect.getScaledImage(pdfI.getImage(), 35, 35)
					: ImageEffect.invertColor(ImageEffect.getScaledImage(pdfI.getImage(), 35, 35)));
			saveAsSvg.setIcon(colorSelected == 2 ? ImageEffect.getScaledImage(svgI.getImage(), 35, 35)
					: ImageEffect.invertColor(ImageEffect.getScaledImage(svgI.getImage(), 35, 35)));
			save.setIcon(colorSelected == 2 ? ImageEffect.getScaledImage(saveI.getImage(), 35, 35)
					: ImageEffect.invertColor(ImageEffect.getScaledImage(saveI.getImage(), 35, 35)));
			exit.setIcon(colorSelected == 2 ? ImageEffect.getScaledImage(exitI.getImage(), 35, 35)
					: ImageEffect.invertColor(ImageEffect.getScaledImage(exitI.getImage(), 35, 35)));
			chartPanel.setPopupMenu(null);
			saveAsPng.addActionListener(_ -> saveChartByExt(lineChart, "png"));
			saveAsPdf.addActionListener(_ -> saveChartByExt(lineChart, "pdf"));
			saveAsSvg.addActionListener(_ -> saveChartByExt(lineChart, "svg"));
			exit.addActionListener(_ -> {
				dialog.dispose();
				overlay.hideOverlay();
			});

			file.add(save);
			save.add(saveAsPng);
			save.add(saveAsPdf);
			save.add(saveAsSvg);
			file.add(exit);
			menu.add(file);

			// Create a JPanel to hold both the chart and the custom legend
			JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout());

			// Add the chart to the center of the panel
			panel.add(chartPanel, BorderLayout.CENTER);

			// Create a JLabel for the custom legend
			String legend = "<html><head><style> body {color" + (colorSelected == 2 ? ": black;" : ": white;")
					+ "} </style></head>" + getLocalizedMessage("LEGEND") + "<br></html>";
			JLabel customLegend = new JLabel(legend);
			customLegend.setOpaque(true);
			customLegend.setBackground(bg);
			customLegend.setHorizontalAlignment(SwingConstants.CENTER); // Center the legend text
			customLegend.setFont(new Font("Arial", Font.PLAIN, 12)); // Set font for the legend

			// Add the custom legend below the chart
			panel.add(customLegend, BorderLayout.SOUTH);

			// Key listener for ESC key to close the dialog
			InputMap inputMap = dialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
			ActionMap actionMap = dialog.getRootPane().getActionMap();
			inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "closeDialog");
			actionMap.put("closeDialog", new AbstractAction() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dialog.dispose();
				}
			});

			// Show the dialog
			dialog.setJMenuBar(menu);
			dialog.add(panel);
			dialog.setVisible(true);
		}
	}

	/* Dialog to choose a period of time to show the added stock */
	private void searchAddedByDates() {
		JDialog dialog = new JDialog(this, getLocalizedMessage("AGG") + " STOCK", true);
		dialog.setUndecorated(true);
		dialog.setSize(getWidth() / 2, getHeight() / 2);
		dialog.setShape(new RoundRectangle2D.Double(0, 0, getWidth() / 2, getHeight() / 2, 20, 20));
		dialog.setLocationRelativeTo(this);
		dialog.setResizable(false);
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

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weightx = 1; // Allow horizontal centering
		gbc.weighty = 1; // Allow vertical centering

		// Date Field (Non-editable)
		JFormattedTextField dateSelected = new JFormattedTextField();
		dateSelected.setFont(new Font("Tahoma", Font.BOLD, 18));
		dateSelected.setForeground(fg);
		dateSelected.setBackground(bg);
		dateSelected.setBorder(new LineBorder(fg, 1));
		dateSelected.setHorizontalAlignment(0);
		dateSelected.setPreferredSize(new Dimension(dialog.getWidth() * 2 / 3, 30));
		dateSelected.setVisible(false);

		datePicker = new DatePicker();
		datePicker.now();
		datePicker.setEditor(dateSelected);
		datePicker.setDateSelectionMode(DatePicker.DateSelectionMode.BETWEEN_DATE_SELECTED);
		datePicker.setUsePanelOption(true);
		datePicker.setCloseAfterSelected(true);
		datePicker.setEditorValidation(true);
		datePicker.setValidationOnNull(true);

		// Buttons
		JButton allTime = new JButton(getLocalizedMessage("ALL_TIME"));
		JButton lastWeek = new JButton(getLocalizedMessage("LAST_WEEK").toUpperCase());
		JButton certainMonth = new JButton(getLocalizedMessage("MONTH"));
		JButton certainYear = new JButton(getLocalizedMessage("YEAR"));
		JButton betwenDate = new JButton(getLocalizedMessage("BETWEEN") + " " + getLocalizedMessage("DATE"));
		JButton loadTable = new JButton(getLocalizedMessage("LOAD") + " " + getLocalizedMessage("DATE"));
		String[] months = new String[12];
		for (int i = 0; i < 12; i++)
			months[i] = getMonthForInt(i, langIndex);
		JComboBox<String> monthCombo = new JComboBox<String>(months);
		DefaultListCellRenderer monthsRender = new DefaultListCellRenderer() {
			private final int currentMonth = currentDate.m;

			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {

				Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				c.setFont(new Font("Segoe UI", Font.BOLD, 14));
				if (index >= currentMonth) {
					c.setForeground(Color.GRAY); // Grays out future months
				}
				return c;
			}
		};
		monthCombo.setRenderer(monthsRender);
		monthCombo.setEditable(false);
		monthCombo.setSelectedIndex(currentDate.m - 1);
		monthCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = monthCombo.getSelectedIndex();
				DateModified selectedDate = new DateModified(1, selectedIndex + 1, currentDate.y);
				if (selectedIndex > currentDate.m - 1) {
					monthCombo.setSelectedIndex(currentDate.m - 1);
				} else if (selectedIndex == currentDate.m - 1)
					dateSelected
							.setText("01" + ((selectedIndex + 1) < 10 ? "0" + (selectedIndex + 1) : (selectedIndex + 1))
									+ selectedDate.y + " to " + currentDate.getToday());
				else
					dateSelected
							.setText("01" + ((selectedIndex + 1) < 10 ? "0" + (selectedIndex + 1) : (selectedIndex + 1))
									+ selectedDate.y + " to " + selectedDate.maxDays()
									+ ((selectedIndex + 1) < 10 ? "0" + (selectedIndex + 1) : (selectedIndex + 1))
									+ +selectedDate.y);
				dateSelected.setVisible(false);
			}
		});
		monthCombo.setVisible(false);
		allTime.addActionListener(_ -> {
			optionChoosing = 3;
			monthCombo.setVisible(false);
			dateSelected.setText("01/01/2020 to " + currentDate.getToday());
			dateSelected.setVisible(false);
			lastWeek.setEnabled(true);
			allTime.setEnabled(false);
			certainMonth.setEnabled(true);
			certainYear.setEnabled(true);
			betwenDate.setEnabled(true);
		});
		lastWeek.addActionListener(_ -> {
			optionChoosing = 0;
			dateSelected.setText(currentDate.getLastWeek() + " to " + currentDate.getToday());
			monthCombo.setVisible(false);
			dateSelected.setVisible(false);
			lastWeek.setEnabled(false);
			allTime.setEnabled(true);
			certainMonth.setEnabled(true);
			certainYear.setEnabled(true);
			betwenDate.setEnabled(true);
		});
		certainMonth.addActionListener(_ -> {
			optionChoosing = 1;
			monthCombo.setVisible(true);
			dateSelected.setVisible(false);
			dateSelected.setText("01/" + (currentDate.m < 10 ? "0" + currentDate.m : currentDate.m) + "/"
					+ currentDate.y + " to " + currentDate.getToday());
			lastWeek.setEnabled(true);
			allTime.setEnabled(true);
			certainMonth.setEnabled(false);
			certainYear.setEnabled(true);
			betwenDate.setEnabled(true);
		});
		certainYear.addActionListener(_ -> {
			optionChoosing = 2;
			dateSelected.setText("01/01/" + currentDate.y + " to " + currentDate.getToday());
			monthCombo.setVisible(false);
			dateSelected.setVisible(false);
			lastWeek.setEnabled(true);
			allTime.setEnabled(true);
			certainMonth.setEnabled(true);
			certainYear.setEnabled(false);
			betwenDate.setEnabled(true);
		});
		betwenDate.addActionListener(_ -> {
			optionChoosing = 4;
			dateSelected.setText(null);
			dateSelected.setVisible(true);
			datePicker.showPopup();
			lastWeek.setEnabled(true);
			allTime.setEnabled(true);
			certainMonth.setEnabled(true);
			certainYear.setEnabled(true);
			betwenDate.setEnabled(false);
		});
		lastWeek.setFont(new Font("Segoe UI", Font.BOLD, 14));
		allTime.setFont(new Font("Segoe UI", Font.BOLD, 14));
		certainMonth.setFont(new Font("Segoe UI", Font.BOLD, 14));
		certainYear.setFont(new Font("Segoe UI", Font.BOLD, 14));
		betwenDate.setFont(new Font("Segoe UI", Font.BOLD, 14));
		loadTable.setFont(new Font("Segoe UI", Font.BOLD, 14));

		List<String> merchandiseNames = new ArrayList<String>();
		for (int index = 0; index < merchandise.size(); index++)
			merchandiseNames.add(merchandise.get(index).getName());

		JComboBox<String> combo = new JComboBox<String>(merchandiseNames.toArray(new String[0]));
		combo.setFont(new Font("Segoe UI", Font.BOLD, 14));
		combo.setEditable(false);
		combo.setPreferredSize(new Dimension(dialog.getWidth() * 2 / 3, 30));
		combo.setRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected,
						cellHasFocus);
				label.setHorizontalAlignment(SwingConstants.CENTER); // Center text in dropdown
				return label;
			}
		});
		JTextField editor = (JTextField) combo.getEditor().getEditorComponent();
		editor.setHorizontalAlignment(JTextField.CENTER);
		combo.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				String text = ((JTextComponent) combo.getEditor().getEditorComponent()).getText();
				if (!merchandiseNames.contains(text))
					combo.setSelectedItem(null);
			}
		});
		AutoCompleteDecorator.decorate(combo);

		// Loads
		loadTable.addActionListener(_ -> {
			if (dateSelected.getText().equals("--/--/---- to --/--/----"))
				Toast.show(this, Toast.Type.ERROR, getLocalizedMessage("DATE_E"), Intro.notOption);
			else {
				String[] dates = dateSelected.getText().split(" to ");
				if (dates.length == 2) {
					String IntroDate = dates[0];
					String secondDate = dates[1];
					viewAddedAccToDate(combo.getSelectedItem().toString(), IntroDate, secondDate, optionChoosing);
				}
			}
		});

		// Close Button
		JButton closeButton = new JButton(ImageEffect.getScaledImage(closeImage.getImage(), 15, 15));
		closeButton.setBorderPainted(false);
		closeButton.setFocusPainted(false);
		closeButton.setContentAreaFilled(false);
		closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		closeButton.setToolTipText(getLocalizedMessage("EXIT"));
		closeButton.addActionListener(_ -> {
			dialog.dispose();
			overlay.hideOverlay();
		});

		// Add Components to Dialog
		JPanel borderLay = new JPanel(new GridBagLayout());
		borderLay.setOpaque(false);
		// Add Components to Dialog
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 5;
		borderLay.add(
				new JLabel("<html><b><u><font size='5'>" + getLocalizedMessage("DATE_S") + "</font></u></b></html>"),
				gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		borderLay.add(lastWeek, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		borderLay.add(certainMonth, gbc);
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		borderLay.add(certainYear, gbc);
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		borderLay.add(allTime, gbc);
		gbc.gridx = 4;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		borderLay.add(betwenDate, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 5;
		borderLay.add(monthCombo, gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 5;
		borderLay.add(dateSelected, gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 5;
		borderLay.add(
				new JLabel("<html><b><u><font size='5'>" + getLocalizedMessage("ITEM_S") + "</font></u></b></html>"),
				gbc);
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 5;
		borderLay.add(combo, gbc);
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 5;
		borderLay.add(loadTable, gbc);
		JPanel northPanel = new JPanel(new BorderLayout());
		northPanel.setOpaque(false);
		northPanel.add(closeButton, BorderLayout.EAST);
		contentPane.add(northPanel, BorderLayout.NORTH);
		contentPane.add(borderLay, BorderLayout.CENTER);

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
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				overlay.hideOverlay();
			}
		});

		dialog.setVisible(true);
	}

	/* Show the added stock as table */
	private void viewAddedAccToDate(String itemName, String IntroDate, String endDate, int option) {
		// Create a dialog for the merchandise table
		JDialog dialog = new JDialog(this, getLocalizedMessage("SEARCH_DATES"), true);
		dialog.setSize(getWidth() * 2 / 3, getHeight() * 2 / 3);
		dialog.setLocationRelativeTo(this);

		// Create a table model and table
		tableModel = new DefaultTableModel(
				new String[] { getLocalizedMessage("DATE"), getLocalizedMessage("HOW_MUCH") }, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // All cells are non-editable
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				// Specify column types
				switch (columnIndex) {
				case 1: // Total
					return Integer.class; // Numeric columns
				default:
					return String.class; // Default to String
				}
			}
		};

		// Load merchandise data
		Map<String, Integer> dateQuantity = searchAddDates(itemName);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		// Define start and end dates
		LocalDate startDate = LocalDate.parse(IntroDate, formatter);
		LocalDate lastDate = LocalDate.parse(endDate, formatter);
		// Filter the map while keeping quantity
		Map<String, Integer> filteredMap = dateQuantity.entrySet().stream().filter(entry -> {
			LocalDate date = LocalDate.parse(entry.getKey(), formatter);
			return !date.isBefore(startDate) && !date.isAfter(lastDate);
		}).sorted(Comparator.comparing(entry -> LocalDate.parse(entry.getKey(), formatter))) // Sort by date
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, _) -> oldValue,
						LinkedHashMap::new // Preserve order
				));
		int total = 0;
		for (Map.Entry<String, Integer> entry : filteredMap.entrySet()) {
			String date = entry.getKey();
			int qty = entry.getValue();
			total += qty;
			tableModel.addRow(new Object[] { date, qty });
		}

		if (total == 0) {
			dialog.dispose();
			Toast.show(this, Toast.Type.INFO, getLocalizedMessage("NO_DATA"), Intro.notOption);
		} else {
			table = new JTable(tableModel);
			table.setFont(new Font("Arial", Font.PLAIN, 16));
			table.setRowHeight(30);
			table.setShowGrid(true);
			table.setIntercellSpacing(new Dimension(0, 0));

			// Add the table to a scroll pane
			JScrollPane scrollPane = new JScrollPane(table);
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
			table.setDefaultRenderer(Object.class, centerRenderer);
			table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

			// Customize the table header
			JTableHeader header = table.getTableHeader();
			header.setFont(new Font("Arial", Font.BOLD, 18));
			header.setBackground(new Color(220, 220, 220)); // Light gray background for header
			header.setForeground(Color.DARK_GRAY); // Dark gray text for header
			header.setReorderingAllowed(false); // Prevent column reordering
			header.setResizingAllowed(false); // Prevent column resizing

			// Add a row sorter for filtering
			TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
			sorter.setComparator(0, (String date1, String date2) -> { // Sorting column 0 (Dates)
				LocalDate d1 = LocalDate.parse(date1, formatter);
				LocalDate d2 = LocalDate.parse(date2, formatter);
				return d1.compareTo(d2); // Sort past → future
			});

			table.setRowSorter(sorter);

			// Add title
			String address;
			if (option == 0)
				address = getLocalizedMessage("LAST_WEEK").toUpperCase();
			else if (option == 1)
				address = getMonthForInt(startDate.getMonthValue() - 1, langIndex);
			else if (option == 2)
				address = currentDate.y + "";
			else if (option == 3)
				address = getLocalizedMessage("ALL_TIME");
			else
				address = getLocalizedMessage("BETWEEN") + " " + IntroDate + " " + getLocalizedMessage("AND") + " "
						+ endDate;
			JLabel title = new JLabel(getLocalizedMessage("AGG") + " " + getLocalizedMessage("OF") + " "
					+ itemName.toUpperCase() + " (" + address + ")");
			title.setFont(new Font("Arial", Font.BOLD, 18));
			title.setHorizontalAlignment(0);
			title.setForeground(fg);
			title.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2),
					BorderFactory.createEmptyBorder(5, 10, 5, 10)));

			JLabel totalL = new JLabel("T O T A L :  " + total);
			totalL.setFont(new Font("Arial", Font.BOLD, 18));
			totalL.setHorizontalAlignment(0);
			totalL.setForeground(fg);
			totalL.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2),
					BorderFactory.createEmptyBorder(5, 10, 5, 10)));

			// Add the scroll pane to the dialog
			dialog.add(title, BorderLayout.NORTH);
			dialog.add(scrollPane, BorderLayout.CENTER);
			dialog.add(totalL, BorderLayout.SOUTH);

			// Key listener for ESC key to close the dialog
			InputMap inputMap = dialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
			ActionMap actionMap = dialog.getRootPane().getActionMap();
			inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "closeDialog");
			actionMap.put("closeDialog", new AbstractAction() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dialog.dispose();
				}
			});

			// Show the dialog
			dialog.setVisible(true);
		}
	}

	/* Dialog to choose how to show the top sales item acc to month/year */
	private void searchTopMechandise() {
		JDialog dialog = new JDialog(this, getLocalizedMessage("TOP_SELL"), true);
		dialog.setUndecorated(true);
		dialog.setSize(getWidth() / 2, getHeight() / 2);
		dialog.setShape(new RoundRectangle2D.Double(0, 0, getWidth() / 2, getHeight() / 2, 20, 20));
		dialog.setLocationRelativeTo(this);
		dialog.setLayout(new GridBagLayout());
		dialog.setResizable(false);
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

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weightx = 1; // Allow horizontal centering
		gbc.weighty = 1; // Allow vertical centering

		// Buttons
		JButton certainMonth = new JButton(getLocalizedMessage("MONTH"));
		JButton certainYear = new JButton(getLocalizedMessage("YEAR"));
		JButton loadTable = new JButton(getLocalizedMessage("LOAD") + " TABLE");
		JButton loadGraph = new JButton(getLocalizedMessage("LOAD") + " " + getLocalizedMessage("DIAGRAM"));
		String[] months = new String[12];
		for (int i = 0; i < 12; i++)
			months[i] = getMonthForInt(i, langIndex);
		JComboBox<String> monthCombo = new JComboBox<String>(months);
		DefaultListCellRenderer monthsRender = new DefaultListCellRenderer() {
			private final int currentMonth = currentDate.m;

			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {

				Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if (index >= currentMonth) {
					c.setForeground(Color.GRAY); // Grays out future months
				}
				return c;
			}
		};
		monthCombo.setRenderer(monthsRender);
		monthCombo.setEditable(false);
		monthCombo.setSelectedIndex(currentDate.m - 1);
		monthCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = monthCombo.getSelectedIndex();
				if (selectedIndex > currentDate.m - 1) {
					monthCombo.setSelectedIndex(currentDate.m - 1);
				}
			}
		});
		certainMonth.addActionListener(_ -> monthCombo.setVisible(true));
		certainYear.addActionListener(_ -> monthCombo.setVisible(false));
		certainMonth.setFont(new Font("Segoe UI", Font.BOLD, 14));
		certainYear.setFont(new Font("Segoe UI", Font.BOLD, 14));
		loadGraph.setFont(new Font("Segoe UI", Font.BOLD, 14));
		loadTable.setFont(new Font("Segoe UI", Font.BOLD, 14));

		// RADIO BUTTONS
		JRadioButton r1 = new JRadioButton(getLocalizedMessage("QUANTITY"));
		JRadioButton r2 = new JRadioButton(getLocalizedMessage("PRICE"));
		r1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		r2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		r1.setSelected(true);
		r1.addActionListener(_ -> r2.setSelected(false));
		r2.addActionListener(_ -> r1.setSelected(false));

		// Loads
		loadTable.addActionListener(_ -> {
			if (monthCombo.isVisible())
				if (getTop10MonthlySales(currentDate.y, monthCombo.getSelectedIndex() + 1).size() == 0)
					Toast.show(this, Toast.Type.INFO, getLocalizedMessage("NO_DATA"), Intro.notOption);
				else {
					if (r1.isSelected())
						topMerchandiseTable(getLocalizedMessage("QUANTITY"), monthCombo.getSelectedIndex() + 1);
					else
						topMerchandiseTable(getLocalizedMessage("PRICE"), monthCombo.getSelectedIndex() + 1);
				}
			else {
				if (getTop10MonthlySales(currentDate.y, -1).size() == 0)
					Toast.show(this, Toast.Type.INFO, getLocalizedMessage("NO_DATA"), Intro.notOption);
				else {
					if (r1.isSelected())
						topMerchandiseTable(getLocalizedMessage("QUANTITY"), -1);
					else
						topMerchandiseTable(getLocalizedMessage("PRICE"), -1);
				}
			}
		});
		loadGraph.addActionListener(_ -> {
			if (monthCombo.isVisible())
				if (getTop10MonthlySales(currentDate.y, monthCombo.getSelectedIndex() + 1).size() == 0)
					Toast.show(this, Toast.Type.INFO, getLocalizedMessage("NO_DATA"), Intro.notOption);
				else {
					if (r1.isSelected())
						topMerchandiseGraph(getLocalizedMessage("QUANTITY"), monthCombo.getSelectedIndex() + 1);
					else
						topMerchandiseGraph(getLocalizedMessage("PRICE"), monthCombo.getSelectedIndex() + 1);
				}
			else {
				if (getTop10MonthlySales(currentDate.y, -1).size() == 0)
					Toast.show(this, Toast.Type.INFO, getLocalizedMessage("NO_DATA"), Intro.notOption);
				else {
					if (r1.isSelected())
						topMerchandiseGraph(getLocalizedMessage("QUANTITY"), -1);
					else
						topMerchandiseGraph(getLocalizedMessage("PRICE"), -1);
				}
			}
		});

		// Close Button
		JButton closeButton = new JButton(ImageEffect.getScaledImage(closeImage.getImage(), 15, 15));
		closeButton.setBorderPainted(false);
		closeButton.setFocusPainted(false);
		closeButton.setContentAreaFilled(false);
		closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		closeButton.setToolTipText(getLocalizedMessage("EXIT"));
		closeButton.addActionListener(_ -> {
			dialog.dispose();
			overlay.hideOverlay();
		});

		// Add Components to Dialog
		JPanel borderLay = new JPanel(new GridBagLayout());
		borderLay.setOpaque(false);
		// Add Components to Dialog
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		borderLay.add(
				new JLabel("<html><b><u><font size='5'>" + getLocalizedMessage("DATE_S") + "</font></u></b></html>"),
				gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		borderLay.add(certainMonth, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		borderLay.add(certainYear, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		borderLay.add(monthCombo, gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		borderLay.add(r1, gbc);
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		borderLay.add(r2, gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		borderLay.add(loadTable, gbc);
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		borderLay.add(loadGraph, gbc);
		JPanel northPanel = new JPanel(new BorderLayout());
		northPanel.setOpaque(false);
		northPanel.add(closeButton, BorderLayout.EAST);
		contentPane.add(northPanel, BorderLayout.NORTH);
		contentPane.add(borderLay, BorderLayout.CENTER);

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
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				overlay.hideOverlay();
			}
		});

		dialog.setVisible(true);
	}

	/* View Top Sell for month/year as table */
	private void topMerchandiseTable(String type, int month) {
		// Create a dialog for the merchandise table
		JDialog dialog = new JDialog(this, getLocalizedMessage("TOP_ITEMS"), true);
		dialog.setSize(getWidth() * 2 / 3, getHeight() * 2 / 3);
		dialog.setLocationRelativeTo(this);
		tableModel = new DefaultTableModel(new String[] { "RANK", "ITEM", type }, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				// Specify column types
				switch (columnIndex) {
				case 1: // Rank
					return Integer.class; // Numeric columns
				default:
					return String.class; // Default to String
				}
			}
		};

		// top 10 merchandise sell
		List<Map.Entry<String, Integer>> top10 = getTop10MonthlySales(currentDate.y, month);
		List<Map.Entry<String, Double>> top10Price = getTop10MonthlyPrice(currentDate.y, month);
		int rank = 1;
		if (type.equalsIgnoreCase(getLocalizedMessage("QUANTITY")))
			for (int i = 0; i < top10.size(); i++) {
				if (i > 0 && i < top10.size())
					if (top10.get(i).getValue() == top10.get(i - 1).getValue()) {
						tableModel.addRow(new Object[] { --rank, top10.get(i).getKey(), top10.get(i).getValue() });
					} else {
						tableModel.addRow(new Object[] { i + 1, top10.get(i).getKey(), top10.get(i).getValue() });
						rank = i + 1;
					}
				else
					tableModel.addRow(new Object[] { rank, top10.get(i).getKey(), top10.get(i).getValue() });
				rank++;
			}
		else {
			for (int i = 0; i < top10Price.size(); i++) {
				if (i > 0 && i < top10Price.size())
					if (top10Price.get(i).getValue().equals(top10Price.get(i - 1).getValue())) {
						tableModel.addRow(new Object[] { --rank, top10Price.get(i).getKey(),
								"$" + top10Price.get(i).getValue() });
					} else {
						tableModel.addRow(
								new Object[] { i + 1, top10Price.get(i).getKey(), "$" + top10Price.get(i).getValue() });
						rank = i + 1;
					}
				else
					tableModel.addRow(
							new Object[] { rank, top10Price.get(i).getKey(), "$" + top10Price.get(i).getValue() });
				rank++;
			}
		}

		table = new JTable(tableModel);
		table.setFont(new Font("Arial", Font.PLAIN, 16));
		table.setRowHeight(30);
		table.setShowGrid(true);
		table.setIntercellSpacing(new Dimension(0, 0));

		// Add the table to a scroll pane
		JScrollPane scrollPane = new JScrollPane(table);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.setDefaultRenderer(Object.class, centerRenderer);

		TableColumn column[] = new TableColumn[3];
		for (int i = 0; i < 3; i++) {
			column[i] = table.getColumnModel().getColumn(i);
			column[i].setCellRenderer(centerRenderer);
			if (i == 0) {
				column[i].setPreferredWidth(120);
				column[i].setMinWidth(120);
				column[i].setMaxWidth(120);
			}
		}

		// Customize the table header
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Arial", Font.BOLD, 18));
		header.setBackground(new Color(220, 220, 220)); // Light gray background for header
		header.setForeground(Color.DARK_GRAY); // Dark gray text for header
		header.setReorderingAllowed(false); // Prevent column reordering
		header.setResizingAllowed(false); // Prevent column resizing

		JLabel title = new JLabel(getLocalizedMessage("TOP_SELL") + " ("
				+ (month == -1 ? currentDate.y : getMonthForInt(month - 1, langIndex)) + ")");
		title.setFont(new Font("Arial", Font.BOLD, 18));
		title.setHorizontalAlignment(0);
		title.setForeground(fg);
		title.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2),
				BorderFactory.createEmptyBorder(5, 10, 5, 10)));

		// Add the scroll pane to the dialog
		dialog.add(title, BorderLayout.NORTH);
		dialog.add(scrollPane, BorderLayout.CENTER);

		// Key listener for ESC key to close the dialog
		InputMap inputMap = dialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap = dialog.getRootPane().getActionMap();
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "closeDialog");
		actionMap.put("closeDialog", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
			}
		});
		// Show the dialog
		dialog.setVisible(true);
	}

	/* View Top Sell for month/year as graph */
	private void topMerchandiseGraph(String type, int month) {
		// Create a dialog for the merchandise table
		JDialog dialog = new JDialog(this, getLocalizedMessage("DIAGRAM") + " " + getLocalizedMessage("TOP_ITEMS"),
				true);
		dialog.setSize(getWidth() * 2 / 3, getHeight() * 2 / 3);
		dialog.setLocationRelativeTo(this);

		// Add chart to panel
		JFreeChart barChart = topMerchChart(type, month);
		ChartPanel chartPanel = new ChartPanel(barChart);

		// Add the scroll pane to the dialog
		dialog.add(chartPanel, BorderLayout.CENTER);

		// Key listener for ESC key to close the dialog
		InputMap inputMap = dialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap = dialog.getRootPane().getActionMap();
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "closeDialog");
		actionMap.put("closeDialog", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
			}
		});

		// Show the dialog
		dialog.setVisible(true);
	}

	/* Return the chart of top merchandise */
	private JFreeChart topMerchChart(String type, int month) {
		// top 10 merchandise sell
		List<Map.Entry<String, Integer>> top10 = getTop10MonthlySales(currentDate.y, month);
		List<Map.Entry<String, Double>> top10Price = getTop10MonthlyPrice(currentDate.y, month);
		// Create dataset
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		if (type.equalsIgnoreCase(getLocalizedMessage("QUANTITY")))
			for (Map.Entry<String, Integer> entry : top10)
				dataset.addValue(entry.getValue(), getLocalizedMessage("QUANTITY"), entry.getKey());
		else
			for (Map.Entry<String, Double> entry : top10Price)
				dataset.addValue(entry.getValue(), getLocalizedMessage("PRICE"), entry.getKey());

		// Create chart
		JFreeChart barChart = ChartFactory.createBarChart(
				getLocalizedMessage("TOP_SELL") + " ("
						+ (month == -1 ? currentDate.y : getMonthForInt(month - 1, langIndex)) + ")",
				"ITEMS", // X-Axis Label
				type.equalsIgnoreCase(getLocalizedMessage("QUANTITY")) ? type : getLocalizedMessage("PRICE") + "($)", // Y-A
				dataset);
		barChart.setBackgroundPaint(bg);
		barChart.getTitle().setPaint(fg);
		barChart.removeLegend();
		// Customize chart appearance
		CategoryPlot plot = barChart.getCategoryPlot();
		BarRenderer renderer = new BarRenderer() {
			@Override
			public void drawItem(Graphics2D g2, CategoryItemRendererState state, Rectangle2D dataArea,
					CategoryPlot plot, CategoryAxis domainAxis, ValueAxis rangeAxis, CategoryDataset dataset, int row,
					int column, int pass) {

				double barWidth = state.getBarWidth();
				double barHeight = dataArea.getHeight() * dataset.getValue(row, column).doubleValue()
						/ rangeAxis.getUpperBound();
				double x = domainAxis.getCategoryMiddle(column, getColumnCount(), dataArea, plot.getDomainAxisEdge())
						- barWidth / 2;
				double y = dataArea.getMaxY() - barHeight;

				java.awt.Shape bar = new RoundRectangle2D.Double(x, y + 20, barWidth, barHeight, barWidth * 0.5,
						barWidth * 0.5);

				// Set bar colors
				if (column == 0)
					g2.setPaint(Intro.blueC);
				else if (column == 1)
					g2.setPaint(Intro.goldM);
				else if (column == 2)
					g2.setPaint(Intro.redM);
				else
					g2.setPaint(getItemPaint(row, column));

				g2.fill(bar); // Draw bar
				// ✅ Remove outlines (prevents extra lines around bars)
				setDrawBarOutline(false);

				// ✅ Restore tooltip support
				EntityCollection entities = state.getEntityCollection();
				if (entities != null) {
					String tooltip = (dataset.getColumnKey(column).toString() + " -> "
							+ (type.equalsIgnoreCase(getLocalizedMessage("QUANTITY")) ? "" : "$")
							+ dataset.getValue(row, column).toString());
					CategoryItemEntity entity = new CategoryItemEntity(bar, tooltip, null, dataset,
							dataset.getRowKey(row), dataset.getColumnKey(column));
					entities.add(entity);
				}
			}
		};
		// X-Axis (Domain Axis) customization
		plot.getDomainAxis().setAxisLinePaint(fg);
		plot.getDomainAxis().setTickLabelPaint(fg);
		plot.getDomainAxis().setLabelPaint(fg);

		// Y-Axis (Range Axis) customization
		plot.getRangeAxis().setAxisLinePaint(fg);
		plot.getRangeAxis().setTickLabelPaint(fg);
		plot.getRangeAxis().setLabelPaint(fg);
		renderer.setDrawBarOutline(false);

		CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setTickLabelFont(new Font("SansSerif", Font.PLAIN, 10));
		renderer.setSeriesPaint(0, fg); // Custom color for bars

		plot.setRenderer(renderer);
		plot.setBackgroundPaint(bg);
		plot.setOutlineVisible(false);
		return barChart;
	}

	/* Return the top 3 merchandise sales of today as qty */
	private List<Map.Entry<String, Integer>> getTop3QtToday() {
		Map<String, Map<String, Integer>> salesMap = new LinkedHashMap<>();
		sellerTotal = new HashMap<String, Integer>();
		String date = currentDate.getToday();
		// Add new items/dates from today's sales
		List<String> empName = new ArrayList<String>();
		for (Employee emp : employee)
			empName.add(emp.getName());
		for (int i = 0; i < invoiceModels.size(); i++) {
			String sellerName = empName.size() == 0 ? "" : paymentComboBoxes.get(i).getSelectedItem().toString();
			int total = 0;
			for (int row = 0; row < invoiceModels.get(i).getRowCount(); row++) {
				String item = invoiceModels.get(i).getValueAt(row, 0) != null
						? invoiceModels.get(i).getValueAt(row, 0).toString()
						: "";
				int qty = invoiceModels.get(i).getValueAt(row, 1) != null
						? Integer.parseInt(invoiceModels.get(i).getValueAt(row, 1).toString())
						: 0;
				int price = invoiceModels.get(i).getValueAt(row, 2) != null
						? Integer.parseInt(invoiceModels.get(i).getValueAt(row, 2).toString())
						: 0;
				if (item.equals("---"))
					continue; // Skip separators
				if (qty > 0 && price > 0)
					total = price * qty;

				salesMap.putIfAbsent(item, new LinkedHashMap<>());
				salesMap.get(item).put(date, salesMap.get(item).getOrDefault(date, 0) + qty);
				if (empName.contains(sellerName))
					sellerTotal.put(sellerName, sellerTotal.getOrDefault(sellerName, 0) + total);
			}
		}
		Map<String, Integer> newMap = new LinkedHashMap<>();
		for (Map.Entry<String, Map<String, Integer>> entry : salesMap.entrySet()) {
			for (Map.Entry<String, Integer> dateEntry : entry.getValue().entrySet()) {
				newMap.put(entry.getKey(), dateEntry.getValue());
			}
		}
		return newMap.entrySet().stream().sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue())).limit(3)
				.collect(Collectors.toList()); // Convert to list;
	}

	/* Return the top 3 merchandise sales of today as price */
	private List<Map.Entry<String, Double>> getTop3PriceToday() {
		Map<String, Map<String, Double>> salesMap = new LinkedHashMap<>();
		String date = currentDate.getToday();
		// Add new items/dates from today's sales
		for (DefaultTableModel model : invoiceModels) {
			for (int row = 0; row < model.getRowCount(); row++) {
				String item = model.getValueAt(row, 0) != null ? model.getValueAt(row, 0).toString() : "";
				int qty = model.getValueAt(row, 1) != null ? Integer.parseInt(model.getValueAt(row, 1).toString()) : 0;
				double price = model.getValueAt(row, 2) != null
						? Double.parseDouble(model.getValueAt(row, 2).toString())
						: 0;
				if (item.equals("---"))
					continue; // Skip separators

				salesMap.putIfAbsent(item, new LinkedHashMap<>());
				salesMap.get(item).put(date, salesMap.get(item).getOrDefault(date, 0.0) + qty * price);
			}
		}
		Map<String, Double> newMap = new LinkedHashMap<>();
		for (Map.Entry<String, Map<String, Double>> entry : salesMap.entrySet()) {
			for (Map.Entry<String, Double> dateEntry : entry.getValue().entrySet()) {
				newMap.put(entry.getKey(), dateEntry.getValue());
			}
		}
		return newMap.entrySet().stream().sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue())).limit(3)
				.collect(Collectors.toList()); // Convert to list;
	}

	/* Return the price of given merchandise */
	private double itemPrice(String item) {
		for (int index = 0; index < merchandise.size(); index++)
			if (item.equalsIgnoreCase(merchandise.get(index).getName()))
				return roundedDouble(merchandise.get(index).getPrice());
		return -1;
	}

	/* return the date sell with its qty for a given item */
	private int searchQty(String targetItem) {
		for (int index = 0; index < merchandise.size(); index++)
			if (targetItem.equalsIgnoreCase(merchandise.get(index).getName()))
				return (merchandise.get(index).getTotal() - merchandise.get(index).getSold());
		return -1;
	}

	/* return the date to sell item with its qty */
	private Map<String, Integer> searchItemDates(String targetItem) {
		Map<String, Integer> dateQtyMap = new LinkedHashMap<>();
		File extraF = new File(dataFolder + "\\Stock");
		extraF.mkdir();
		for (int year = 2025; year <= currentDate.y; year++) {
			File salesData = new File(extraF, "sales_index_" + year + ".csv");
			if (salesData.exists())
				try (BufferedReader reader = new BufferedReader(new FileReader(salesData))) {
					String line;
					reader.readLine(); // Skip header ("item,dates")
					while ((line = reader.readLine()) != null) {
						String[] parts = line.split(",");
						String item = parts[0];
						if (item.equalsIgnoreCase(targetItem)) {
							for (int i = 1; i < parts.length; i++) {
								String[] dateQty = parts[i].split(":");
								if (dateQty.length == 2) {
									String date = dateQty[0];
									int qty = Integer.parseInt(dateQty[1]);
									dateQtyMap.put(date, qty);
								}
							}
							break;
						}
					}
				} catch (IOException e) {
					writeError(e);
				}
		}
		return dateQtyMap;
	}

	/* return the date to added item with its qty */
	private Map<String, Integer> searchAddDates(String targetItem) {
		Map<String, Integer> dateQtyMap = new LinkedHashMap<>();
		File extraF = new File(dataFolder + "\\Stock");
		extraF.mkdir();
		File salesData = new File(extraF, "dates.dll");

		if (salesData.exists())
			try (BufferedReader reader = new BufferedReader(new FileReader(salesData))) {
				String line;
				reader.readLine(); // Skip header ("item,dates")
				while ((line = reader.readLine()) != null) {
					String[] parts = line.split(",");
					String item = parts[0];
					if (item.equalsIgnoreCase(targetItem)) {
						for (int i = 1; i < parts.length; i++) {
							String[] dateQty = parts[i].split(":");
							if (dateQty.length == 2) {
								String date = dateQty[0];
								int qty = Integer.parseInt(dateQty[1]);
								dateQtyMap.put(date, qty);
							}
						}
						break;
					}
				}
			} catch (IOException e) {
				writeError(e);
			}
		return dateQtyMap;
	}

	/* Return the total sales of an item for month/year(-1 for month) */
	private int getMonthlySales(String item, int year, int month) {
		Map<String, Integer> dateQuantity = searchItemDates(item);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		if (dateQuantity.isEmpty())
			return 0;
		else {
			// Define start and end dates
			if (month == -1) {
				LocalDate startDate = LocalDate.of(year, 1, 1);
				LocalDate lastDate = LocalDate.of(year, 12, 31);

				// Sum up sales for the given month
				int total = dateQuantity.entrySet().stream().filter(entry -> {
					try {
						LocalDate entryDate = LocalDate.parse(entry.getKey(), formatter);
						return !entryDate.isBefore(startDate) && !entryDate.isAfter(lastDate);
					} catch (Exception e) {
						writeError(e);
						return false;
					}
				}).mapToInt(Map.Entry::getValue).sum();

				return total;
			} else {
				LocalDate startDate = LocalDate.of(year, month, 1);
				DateModified date = new DateModified(1, month, year);
				LocalDate lastDate = LocalDate.of(year, month, date.maxDays());

				// Sum up sales for the given month
				int total = dateQuantity.entrySet().stream().filter(entry -> {
					try {
						LocalDate entryDate = LocalDate.parse(entry.getKey(), formatter);
						return !entryDate.isBefore(startDate) && !entryDate.isAfter(lastDate);
					} catch (Exception e) {
						writeError(e);
						return false;
					}
				}).mapToInt(Map.Entry::getValue).sum();

				return total;
			}
		}
	}

	/* Return the top 10 PER MONTH merchandise sell as qty */
	private List<Map.Entry<String, Integer>> getTop10MonthlySales(int year, int month) {
		Map<String, Integer> totalSalesMap = new HashMap<>();

		File extraF = new File(dataFolder + "\\Stock");
		extraF.mkdir();
		File salesData = new File(extraF, "sales_index_" + year + ".csv");
		if (!salesData.exists())
			return new ArrayList<Map.Entry<String, Integer>>();

		// Loop through all items
		List<String> merchandiseNames = new ArrayList<String>();
		for (int index = 0; index < merchandise.size(); index++)
			merchandiseNames.add(merchandise.get(index).getName());
		for (String item : merchandiseNames) {
			int totalSales = getMonthlySales(item, year, month);
			if (totalSales != 0)
				totalSalesMap.put(item, totalSales);
		}

		// Get top 10 items sorted by sales in descending order
		return totalSalesMap.entrySet().stream().sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
				.limit(10) // Keep only top 10
				.collect(Collectors.toList()); // Convert to list
	}

	/* Return the top 10 PER MONTH merchandise sell as price */
	private List<Map.Entry<String, Double>> getTop10MonthlyPrice(int year, int month) {
		Map<String, Double> totalSalesMap = new HashMap<>();

		File extraF = new File(dataFolder + "\\Stock");
		extraF.mkdir();
		File salesData = new File(extraF, "sales_index_" + year + ".csv");
		if (!salesData.exists())
			return new ArrayList<Map.Entry<String, Double>>();

		// Loop through all items
		List<String> merchandiseNames = new ArrayList<String>();
		for (int index = 0; index < merchandise.size(); index++)
			merchandiseNames.add(merchandise.get(index).getName());
		for (String item : merchandiseNames) {
			int totalSales = getMonthlySales(item, year, month);
			if (totalSales != 0)
				totalSalesMap.put(item, roundedDouble(totalSales * itemPrice(item)));
		}

		// Get top 10 items sorted by sales in descending order
		return totalSalesMap.entrySet().stream().sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()))
				.limit(10) // Keep only top 10
				.collect(Collectors.toList()); // Convert to list
	}

	/* Dialog to choose how to show the no sales item acc to month/year */
	private void searchUnsellMechandise() {
		JDialog dialog = new JDialog(this, getLocalizedMessage("NO_SALES"), true);
		dialog.setUndecorated(true);
		dialog.setSize(getWidth() / 3, getHeight() / 3);
		dialog.setShape(new RoundRectangle2D.Double(0, 0, getWidth() / 3, getHeight() / 3, 20, 20));
		dialog.setLocationRelativeTo(this);
		dialog.setLayout(new GridBagLayout());
		dialog.setResizable(false);
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

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weightx = 1; // Allow horizontal centering
		gbc.weighty = 1; // Allow vertical centering

		// Buttons
		JButton certainMonth = new JButton(getLocalizedMessage("MONTH"));
		JButton certainYear = new JButton(getLocalizedMessage("YEAR"));
		JButton loadTable = new JButton(getLocalizedMessage("LOAD") + " TABLE");
		String[] months = new String[12];
		for (int i = 0; i < 12; i++)
			months[i] = getMonthForInt(i, langIndex);
		JComboBox<String> monthCombo = new JComboBox<String>(months);
		DefaultListCellRenderer monthsRender = new DefaultListCellRenderer() {
			private final int currentMonth = currentDate.m;

			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {

				Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if (index >= currentMonth) {
					c.setForeground(Color.GRAY); // Grays out future months
				}
				return c;
			}
		};
		monthCombo.setRenderer(monthsRender);
		monthCombo.setEditable(false);
		monthCombo.setSelectedIndex(currentDate.m - 1);
		monthCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = monthCombo.getSelectedIndex();
				if (selectedIndex > currentDate.m - 1) {
					monthCombo.setSelectedIndex(currentDate.m - 1);
				}
			}
		});
		certainMonth.addActionListener(_ -> monthCombo.setVisible(true));
		certainYear.addActionListener(_ -> monthCombo.setVisible(false));
		certainMonth.setFont(new Font("Segoe UI", Font.BOLD, 14));
		certainYear.setFont(new Font("Segoe UI", Font.BOLD, 14));
		loadTable.setFont(new Font("Segoe UI", Font.BOLD, 14));

		// Loads
		loadTable.addActionListener(_ -> {
			if (monthCombo.isVisible())
				if (getUnsells(monthCombo.getSelectedIndex() + 1).size() == 0)
					Toast.show(this, Toast.Type.INFO, getLocalizedMessage("NO_DATA"), Intro.notOption);
				else
					UnsellMerchandiseTable(monthCombo.getSelectedIndex() + 1);
			else if (getUnsells(-1).size() == 0)
				Toast.show(this, Toast.Type.INFO, getLocalizedMessage("NO_DATA"), Intro.notOption);
			else
				UnsellMerchandiseTable(-1);
		});

		// Close Button
		JButton closeButton = new JButton(ImageEffect.getScaledImage(closeImage.getImage(), 15, 15));
		closeButton.setBorderPainted(false);
		closeButton.setFocusPainted(false);
		closeButton.setContentAreaFilled(false);
		closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		closeButton.setToolTipText(getLocalizedMessage("EXIT"));
		closeButton.addActionListener(_ -> {
			dialog.dispose();
			overlay.hideOverlay();
		});

		// Add Components to Dialog
		JPanel borderLay = new JPanel(new GridBagLayout());
		borderLay.setOpaque(false);
		// Add Components to Dialog
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		borderLay.add(
				new JLabel("<html><b><u><font size='5'>" + getLocalizedMessage("DATE_S") + "</font></u></b></html>"),
				gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		borderLay.add(certainMonth, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		borderLay.add(certainYear, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		borderLay.add(monthCombo, gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		borderLay.add(loadTable, gbc);
		JPanel northPanel = new JPanel(new BorderLayout());
		northPanel.setOpaque(false);
		northPanel.add(closeButton, BorderLayout.EAST);
		contentPane.add(northPanel, BorderLayout.NORTH);
		contentPane.add(borderLay, BorderLayout.CENTER);

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
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				overlay.hideOverlay();
			}
		});

		dialog.setVisible(true);
	}

	/* View no Sell for month/year as table */
	private void UnsellMerchandiseTable(int month) {
		// Create a dialog for the merchandise table
		JDialog dialog = new JDialog(this, getLocalizedMessage("NO_SALES"), true);
		dialog.setSize(getWidth() * 2 / 3, getHeight() * 2 / 3);
		dialog.setLocationRelativeTo(this);

		tabbedPane = new ModernTabbedPane();

		List<Merchandise> unsellI = getUnsells(month);
		Map<String, List<Merchandise>> categoryMap = new LinkedHashMap<>();
		for (Merchandise merch : unsellI) {
			String category = merch.getCategory();
			categoryMap.computeIfAbsent(category, _ -> new ArrayList<>()).add(merch);
		}

		for (Map.Entry<String, List<Merchandise>> entry : categoryMap.entrySet()) {
			String category = entry.getKey();
			List<Merchandise> items = entry.getValue();

			String[] columnNames = { "ITEM", getLocalizedMessage("QUANTITY"), getLocalizedMessage("PRICE") + " ($)" };
			DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};

			for (Merchandise item : items)
				model.addRow(new Object[] { item.getName(), (item.getTotal() - item.getSold()), item.getPrice() });

			JTable table = new JTable(model);
			table.setFont(new Font("Arial", Font.PLAIN, 16));
			table.setRowHeight(30);
			table.setShowGrid(true);
			table.setIntercellSpacing(new Dimension(0, 0));

			TableColumn column[] = new TableColumn[3];
			for (int i = 0; i < 3; i++) {
				column[i] = table.getColumnModel().getColumn(i);
				if ((i > 0)) {
					column[i].setPreferredWidth(150);
					column[i].setMinWidth(150);
					column[i].setMaxWidth(150);
				}
			}

			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
			table.setDefaultRenderer(Object.class, centerRenderer);

			// Customize the table header
			JTableHeader header = table.getTableHeader();
			header.setFont(new Font("Arial", Font.BOLD, 18));
			header.setBackground(new Color(220, 220, 220)); // Light gray background for header
			header.setForeground(Color.DARK_GRAY); // Dark gray text for header
			header.setReorderingAllowed(false); // Prevent column reordering
			header.setResizingAllowed(false); // Prevent column resizing

			JScrollPane scrollPane = new JScrollPane(table);

			tabbedPane.addTab(category, scrollPane);
		}
		dialog.add(tabbedPane);
		// Key listener for ESC key to close the dialog
		InputMap inputMap = dialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap = dialog.getRootPane().getActionMap();
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "closeDialog");
		actionMap.put("closeDialog", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
			}
		});

		// Show the dialog
		dialog.setVisible(true);
	}

	/* Return the no sales PER MONTH */
	private List<Merchandise> getUnsells(int month) {
		List<Merchandise> totalSalesMap = new ArrayList<Merchandise>();

		File extraF = new File(dataFolder + "\\Stock");
		extraF.mkdir();
		File salesData = new File(extraF, "sales_index_" + currentDate.y + ".csv");
		if (!salesData.exists())
			return new ArrayList<Merchandise>();

		// Loop through all items
		for (int index = 0; index < merchandise.size(); index++) {
			String item = merchandise.get(index).getName();
			int stock = merchandise.get(index).getTotal() - merchandise.get(index).getSold();
			int totalSales = getMonthlySales(item, currentDate.y, month);
			if (totalSales == 0 && stock > 0)
				totalSalesMap.add(merchandise.get(index));
		}

		return totalSalesMap;
	}

	/* Return the last ID */
	private int lastID() {
		if (tableModel != null && tableModel.getRowCount() > 0) {
			int maxID = Integer.parseInt(tableModel.getValueAt(0, 7).toString());
			for (int row = 1; row < tableModel.getRowCount(); row++) {
				int id = Integer.parseInt(tableModel.getValueAt(row, 7).toString());
				if (id > maxID)
					maxID = id;
			}
			return maxID;
		} else
			return 0;
	}

	/* Return the position of an item per qty sell */
	private int getPosition(int year, int month, String itemName) {
		Map<String, Integer> totalSalesMap = new HashMap<>();

		// Loop through all items
		List<String> merchandiseNames = new ArrayList<String>();
		for (int index = 0; index < merchandise.size(); index++)
			merchandiseNames.add(merchandise.get(index).getName());

		for (String item : merchandiseNames) {
			int totalSales = getMonthlySales(item, year, month);
			totalSalesMap.put(item, totalSales);
		}
		List<Map.Entry<String, Integer>> arrMap = totalSalesMap.entrySet().stream()
				.sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue())).collect(Collectors.toList());

		// Find position of the given itemName
		for (int i = 0; i < arrMap.size(); i++) {
			if (arrMap.get(i).getKey().equals(itemName)) {
				return i + 1; // Position (1-based index)
			}
		}

		return -1; // Return -1 if item is not found
	}

	/* Return the position of an item per price sell */
	private int getPositionPerPrice(int year, int month, String itemName) {
		Map<String, Double> totalSalesMap = new HashMap<>();

		// Loop through all items
		List<String> merchandiseNames = new ArrayList<String>();
		for (int index = 0; index < merchandise.size(); index++)
			merchandiseNames.add(merchandise.get(index).getName());

		for (String item : merchandiseNames) {
			int totalSales = getMonthlySales(item, year, month);
			totalSalesMap.put(item, totalSales * itemPrice(item));
		}
		List<Map.Entry<String, Double>> arrMap = totalSalesMap.entrySet().stream()
				.sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue())).collect(Collectors.toList());

		// Find position of the given itemName
		for (int i = 0; i < arrMap.size(); i++) {
			if (arrMap.get(i).getKey().equals(itemName)) {
				return i + 1; // Position (1-based index)
			}
		}

		return -1; // Return -1 if item is not found
	}

	/* Add right click poup gesture */
	private void addRightClickFilter() {
		JPopupMenu popupMenu = new JPopupMenu();

		addStockFilterToPopup(popupMenu);
		// Add category filter menu
		addCategoryFilterToPopup(popupMenu);

		JTableHeader header = table.getTableHeader();
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showPopupMenu(e);
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showPopupMenu(e);
				}
			}

			private void showPopupMenu(MouseEvent e) {
				popupMenu.show(header, e.getX(), e.getY());
			}
		});
	}

	/* Stock filter */
	private void addStockFilterToPopup(JPopupMenu popupMenu) {
		JMenu stockMenu = new JMenu(getLocalizedMessage("FILTER_S"));

		JMenuItem filterNoZeroStock = new JMenuItem(getLocalizedMessage("FILTER_P"));
		filterNoZeroStock.addActionListener(
				_ -> rowSorter.setRowFilter(RowFilter.numberFilter(RowFilter.ComparisonType.NOT_EQUAL, 0, 2)));

		JMenuItem filterZeroStock = new JMenuItem(getLocalizedMessage("FILTER_Z"));
		filterZeroStock.addActionListener(
				_ -> rowSorter.setRowFilter(RowFilter.numberFilter(RowFilter.ComparisonType.EQUAL, 0, 2)));

		JSeparator sep = new JSeparator();

		JMenuItem showAllItems = new JMenuItem(getLocalizedMessage("FILTER_A"));
		showAllItems.addActionListener(
				_ -> rowSorter.setRowFilter(RowFilter.numberFilter(RowFilter.ComparisonType.NOT_EQUAL, -1, 2)));

		stockMenu.add(filterNoZeroStock);
		stockMenu.add(filterZeroStock);
		stockMenu.add(sep);
		stockMenu.add(showAllItems);

		popupMenu.add(stockMenu);
	}

	/* Category filter */
	private void addCategoryFilterToPopup(JPopupMenu popupMenu) {
		JMenu categoryMenu = new JMenu(getLocalizedMessage("FILTER_C"));

		// Get unique categories from the table
		Set<String> categories = new HashSet<>();
		for (int i = 0; i < table.getRowCount(); i++) {
			String category = table.getValueAt(i, 6).toString().toUpperCase();
			categories.add(category);
		}

		// Create menu items for each category
		for (String category : categories) {
			JMenuItem categoryItem = new JMenuItem(category);
			categoryItem
					.addActionListener(_ -> rowSorter.setRowFilter(RowFilter.regexFilter("(?i)^" + category + "$", 6)));
			categoryMenu.add(categoryItem);
		}

		// Add "Show All" option
		JSeparator sep = new JSeparator();
		JMenuItem showAll = new JMenuItem(getLocalizedMessage("SHOW_ALL"));
		showAll.addActionListener(
				_ -> rowSorter.setRowFilter(RowFilter.numberFilter(RowFilter.ComparisonType.NOT_EQUAL, -1, 2)));
		categoryMenu.add(sep);
		categoryMenu.add(showAll);

		popupMenu.add(categoryMenu);
	}

	// download the file from internet(url) to the des(location)
	public void saveFileFromWeb(URL url, File location) {
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

				// 4. Transfer data with progress tracking
				byte[] buffer = new byte[2048];
				int bytesRead;

				while ((bytesRead = in.read(buffer)) > 0) {
					out.write(buffer, 0, bytesRead);
				}
			} catch (IOException e) {
				writeError(e);
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
	}

	/* E M P L O Y E E S T A R T */
	/* Add/Remove employee */
	private void employeeChange() {
		employeeAddEvents();
		// Create a dialog for the table
		JDialog dialog = new JDialog(this, getLocalizedMessage("EMPLOYEE"), true);
		dialog.setSize(getWidth() * 2 / 3, getHeight() * 2 / 3);
		dialog.setLocationRelativeTo(this);
		overlay.showOverlay();

		// Create a table model and table
		tableModel = new DefaultTableModel(new String[] { getLocalizedMessage("NAME"), getLocalizedMessage("DATE"),
				getLocalizedMessage("SALARY"), getLocalizedMessage("POSITION"), getLocalizedMessage("DELETE") }, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return true;
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				// Specify column types
				switch (columnIndex) {
				case 1:
					return Date.class;
				case 2: // DATE
					return Integer.class; // Numeric columns
				default:
					return String.class; // Default to String
				}
			}
		};

		for (int i = 0; i < employee.size(); i++)
			tableModel
					.addRow(new Object[] { employee.get(i).getName().toUpperCase(), employee.get(i).getHireDateAsDate(),
							employee.get(i).getSalary(), employee.get(i).getPosition(), "X" });

		table = new JTable(tableModel) {

			@Override
			public boolean editCellAt(int row, int column, EventObject e) {
				boolean result = super.editCellAt(row, column, e);
				final Component editor = getEditorComponent();

				if (editor instanceof JTextField) {
					JTextField textField = (JTextField) editor;

					// Select all text when editing starts
					if (e instanceof KeyEvent) {
						textField.setText(""); // Clear text for overwrite
						textField.requestFocusInWindow();
					} else {
						// If triggered by focus or mouse, select all text
						SwingUtilities.invokeLater(textField::selectAll);
					}
				}
				return result;
			}
		};
		table.setFont(new Font("Arial", Font.PLAIN, 16));
		table.setRowHeight(30);
		table.setShowGrid(true);
		table.setIntercellSpacing(new Dimension(0, 0));

		// Add the table to a scroll pane
		JScrollPane scrollPane = new JScrollPane(table);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.setDefaultRenderer(Object.class, centerRenderer);

		TableColumn column[] = new TableColumn[5];
		for (int i = 0; i < 5; i++) {
			column[i] = table.getColumnModel().getColumn(i);
			if (i > 1) {
				column[i].setPreferredWidth(120);
				column[i].setMinWidth(120);
				column[i].setMaxWidth(120);
			}
			column[i].setCellRenderer(centerRenderer);
		}
		JFormattedTextField textField;
		MaskFormatter dateMask;
		try {
			dateMask = new MaskFormatter("##/##/####");
			dateMask.setPlaceholderCharacter('_'); // Show underscores for empty spaces
			textField = new JFormattedTextField(dateMask);
			textField.setColumns(10);
		} catch (ParseException e1) {
			throw new RuntimeException("Invalid mask format", e1);
		}
		column[1].setCellEditor(new DefaultCellEditor(textField) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			@Override
			public Object getCellEditorValue() {
				try {
					return sdf.parse(textField.getText()); // Convert text to Date
				} catch (ParseException e) {
					return null;
				}
			}

			@Override
			public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
					int column) {
				textField.setText(value instanceof Date ? sdf.format((Date) value) : "");
				return textField;
			}
		});
		column[1].setCellRenderer(new DefaultTableCellRenderer() {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			@Override
			protected void setValue(Object value) {
				setHorizontalAlignment(SwingConstants.CENTER);
				if (value instanceof Date) {
					setText(sdf.format((Date) value)); // Format Date object
				} else {
					setText(""); // Empty for null values
				}
			}
		});

		JComboBox<String> positionComboBox = new JComboBox<>(new String[] { getLocalizedMessage("BOSS"),
				getLocalizedMessage("CASHIER"), getLocalizedMessage("WORKER") });
		positionComboBox.setEditable(false);
		column[3].setCellEditor(new ComboBoxCellEditor(positionComboBox) {
			@Override
			public boolean stopCellEditing() {
				Object selectedObject = positionComboBox.getEditor().getItem();

				if (selectedObject == null) {
					return super.stopCellEditing(); // Prevents NullPointerException
				}
				return super.stopCellEditing();
			}
		});
		AutoCompleteDecorator.decorate(positionComboBox);

		// Customize the table header
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Arial", Font.BOLD, 18));
		header.setBackground(new Color(220, 220, 220)); // Light gray background for header
		header.setForeground(Color.DARK_GRAY); // Dark gray text for header
		header.setReorderingAllowed(false); // Prevent column reordering
		header.setResizingAllowed(false); // Prevent column resizing

		// Key listener for ESC key to close the dialog
		InputMap inputMap = dialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap = dialog.getRootPane().getActionMap();
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "closeDialog");
		actionMap.put("closeDialog", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
				overlay.hideOverlay();
				employeeSave();
			}
		});
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				overlay.hideOverlay();
				employeeSave();
			}
		});

		// BOTTOM PANEL
		JPanel bottomRow = new JPanel(new BorderLayout());
		JPanel buttonsP = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton addRowButton = new JButton(getLocalizedMessage("ADD") + " ITEM");
		addRowButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		addRowButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		addRowButton.addActionListener(
				_ -> tableModel.addRow(new Object[] { "", new Date(), 1, positionComboBox.getItemAt(0), "X" }));
		JButton clearTable = new JButton(getLocalizedMessage("CLEAR"));
		clearTable.setFont(new Font("Segoe UI", Font.BOLD, 14));
		clearTable.setCursor(new Cursor(Cursor.HAND_CURSOR));
		clearTable.addActionListener(_ -> tableModel.setRowCount(0));
		buttonsP.add(addRowButton);
		buttonsP.add(clearTable);
		bottomRow.add(buttonsP, BorderLayout.SOUTH);
		// Add Delete button
		javax.swing.Action deleteAction = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTable table = (JTable) e.getSource();
				int row = Integer.parseInt(e.getActionCommand());
				((DefaultTableModel) table.getModel()).removeRow(row);
			}
		};
		new ButtonColumn(table, deleteAction, 4);

		// Add the scroll pane to the dialog
		dialog.add(scrollPane, BorderLayout.CENTER);
		dialog.add(bottomRow, BorderLayout.SOUTH);

		// Show the dialog
		dialog.setVisible(true);
	}

	/* Save employee file */
	private void employeeSave() {
		File extraF = new File(dataFolder + "\\" + TextEffect.capitalizeString(getLocalizedMessage("EMPLOYEE")));
		extraF.mkdir();
		File employeeF = new File(extraF, "employee.csv");
		File tempFile = new File(extraF, "temp_employee.csv");
		Map<String, String> nameChanges = new HashMap<>();
		try (PrintWriter writer = new PrintWriter(new FileWriter(tempFile))) {
			writer.println("ITEM,START DATE,SALARY");
			for (int row = 0; row < tableModel.getRowCount(); row++) {
				String name = tableModel.getValueAt(row, 0) != null ? tableModel.getValueAt(row, 0).toString() : "";
				String date = tableModel.getValueAt(row, 1) != null ? tableModel.getValueAt(row, 1).toString()
						: currentDate.getToday();
				String salary = tableModel.getValueAt(row, 2) != null ? tableModel.getValueAt(row, 2).toString() : "";
				String pos = tableModel.getValueAt(row, 3) != null ? tableModel.getValueAt(row, 3).toString() : "";
				DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss VV yyyy",
						Locale.ENGLISH);
				ZonedDateTime zonedDateTime = ZonedDateTime.parse(date, inputFormatter);

				// Format it into "dd/MM/yyyy"
				DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				String formattedDate = zonedDateTime.format(outputFormatter);

				// Ensure data integrity before writing
				if (name.isEmpty() || formattedDate.isEmpty() || salary.isEmpty() || pos.isEmpty()) {
					System.err.println("Skipping row due to missing values: " + name);
					continue;
				}
				if (employee.size() > 0) {
					String oldName = employee.get(row).getName();
					String newName = (String) tableModel.getValueAt(row, 0);

					if (!oldName.equals(newName)) { // If the name has changed
						nameChanges.put(oldName, newName);
					}
				}
				writer.println(String.join(",", name, formattedDate, salary, pos));
			}
		} catch (IOException e1) {
			writeError(e1);
			return; // Stop execution if writing fails
		}
		// Safely replace the file only if writing was successful
		if (employeeF.exists() && !employeeF.delete()) {
			System.err.println("Failed to delete original file!");
		} else if (!tempFile.renameTo(employeeF)) {
			System.err.println("Failed to rename temp file!");
		}

		if (!nameChanges.isEmpty()) {
			// week days
			data = loadFreeDays(getLocalizedMessage("WEEK_DAYS"));
			File weekF = new File(extraF + "\\" + TextEffect.capitalizeString(getLocalizedMessage("WORK_DAYS")));
			weekF.mkdir();
			File weekFile = new File(weekF, getLocalizedMessage("WEEK_DAYS") + "-" + currentDate.y + ".csv");
			List<String> newMap = new ArrayList<String>();
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(weekFile))) {
				// Write header
				writer.write("Name,Date\n");
				for (Map.Entry<String, List<String>> entry : data.entrySet()) {
					newMap.clear();
					String name = entry.getKey();
					if (nameChanges.containsKey(name))
						name = nameChanges.get(name);
					List<String> vacationDays = entry.getValue();
					for (String date : vacationDays) {
						newMap.add(date);
					}
					writer.write(name + "," + String.join(",", newMap) + "\n");
				}
				for (int row = 0; row < employee.size(); row++) {
					if (!employee.get(row).getName().isBlank() && !data.containsKey(employee.get(row).getName()))
						if (!employee.get(row).getPosition().equalsIgnoreCase(getLocalizedMessage("BOSS")))
							writer.write(employee.get(row).getName() + "," + "\n");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			// week days
			data = loadFreeDays(getLocalizedMessage("LICENSE"));
			File licFile = new File(weekF, getLocalizedMessage("LICENSE") + "-" + currentDate.y + ".csv");
			newMap = new ArrayList<String>();
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(licFile))) {
				// Write header
				writer.write("Name,Date\n");
				for (Map.Entry<String, List<String>> entry : data.entrySet()) {
					newMap.clear();
					String name = entry.getKey();
					if (nameChanges.containsKey(name))
						name = nameChanges.get(name);
					List<String> vacationDays = entry.getValue();
					for (String date : vacationDays) {
						newMap.add(date);
					}
					writer.write(name + "," + String.join(",", newMap) + "\n");
				}
				for (int row = 0; row < employee.size(); row++) {
					if (!employee.get(row).getName().isBlank() && !data.containsKey(employee.get(row).getName()))
						if (!employee.get(row).getPosition().equalsIgnoreCase(getLocalizedMessage("BOSS")))
							writer.write(employee.get(row).getName() + "," + "\n");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			// faltas
			data = loadFreeDays(getLocalizedMessage("UNAUTH"));
			File faltasFile = new File(weekF, getLocalizedMessage("UNAUTH") + "-" + currentDate.y + ".csv");
			newMap = new ArrayList<String>();
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(faltasFile))) {
				// Write header
				writer.write("Name,Date\n");
				for (Map.Entry<String, List<String>> entry : data.entrySet()) {
					newMap.clear();
					String name = entry.getKey();
					if (nameChanges.containsKey(name))
						name = nameChanges.get(name);
					List<String> vacationDays = entry.getValue();
					for (String date : vacationDays) {
						newMap.add(date);
					}
					writer.write(name + "," + String.join(",", newMap) + "\n");
				}
				for (int row = 0; row < employee.size(); row++) {
					if (!employee.get(row).getName().isBlank() && !data.containsKey(employee.get(row).getName()))
						if (!employee.get(row).getPosition().equalsIgnoreCase(getLocalizedMessage("BOSS")))
							writer.write(employee.get(row).getName() + "," + "\n");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			File sellF = new File(extraF + "\\" + TextEffect.capitalizeString(getLocalizedMessage("SELL")));
			sellF.mkdir();
			File todayFile = new File(sellF,
					TextEffect.capitalizeString(getLocalizedMessage("SELL")) + "-" + currentDate.y + ".csv");
			Map<String, Map<String, Integer>> salesMap = LoadSellerTotal(currentDate.y);

			// Write updated index to file
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(todayFile))) {
				writer.write("ITEM,DATE:QUANTITY");
				writer.newLine();
				for (Map.Entry<String, Map<String, Integer>> entry : salesMap.entrySet()) {
					StringBuilder sellerName = new StringBuilder(entry.getKey());
					if (nameChanges.containsKey(sellerName.toString())) {
						String oldName = sellerName.toString();
						sellerName.setLength(0);
						sellerName.append(nameChanges.get(oldName));
					}
					for (Map.Entry<String, Integer> dateEntry : entry.getValue().entrySet()) {
						sellerName.append(",").append(dateEntry.getKey()).append(":").append(dateEntry.getValue());
					}
					writer.write(sellerName.toString());
					writer.newLine();
				}
			} catch (IOException e) {
				writeError(e);
			}
		}
	}

	/* Load data from file */
	private void employeeAddEvents() {
		employee.clear();
		File extraF = new File(dataFolder + "\\" + TextEffect.capitalizeString(getLocalizedMessage("EMPLOYEE")));
		extraF.mkdir();
		File todayFile = new File(extraF, "employee.csv");
		if (todayFile.exists()) {
			try (BufferedReader reader = new BufferedReader(new FileReader(todayFile))) {
				String line;
				boolean IntroLine = true; // Skip the header line
				while ((line = reader.readLine()) != null) {
					if (IntroLine) {
						IntroLine = false;
						continue;
					}
					String[] parts = line.split(",");
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					if (parts.length == 4)
						if (TextEffect.isInteger(parts[2])) {
							String name = parts[0];
							LocalDate date = LocalDate.parse(parts[1], formatter);
							int salary = Integer.parseInt(parts[2]);
							String position = parts[3];
							employee.add(new Employee(name, date, salary, position));
						}
				}
			} catch (IOException e) {
				writeError(e);
			}
		}
	}

	/* Employee Free days browse */
	private void employeeFDDialog(String name) {
		JDialog employeeD = new JDialog(this, "", true);
		employeeD.setDefaultCloseOperation(HIDE_ON_CLOSE);
		employeeD.setUndecorated(true);
		employeeD.setSize(getWidth() / 3, getHeight() / 2);
		employeeD.setLocationRelativeTo(this);
		employeeD.setLayout(new BorderLayout());
		employeeD.setShape(new RoundRectangle2D.Double(0, 0, getWidth() / 3, getHeight() / 2, 20, 20));
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
		employeeD.setContentPane(contentPane);

		// Title Panel
		JLabel titleLabel = new JLabel(name.toUpperCase());
		titleLabel.setFont(Intro.myFont);
		titleLabel.setForeground(fg);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

		// LOAD FREE DAYS
		List<String> weekDays = new ArrayList<String>(), licDays = new ArrayList<String>(),
				faltas = new ArrayList<String>();
		data = loadFreeDays(getLocalizedMessage("WEEK_DAYS"));
		if (data.containsKey(name)) {
			weekDays = data.get(name);
		}
		data = loadFreeDays(getLocalizedMessage("LICENSE"));
		if (data.containsKey(name)) {
			licDays = data.get(name);
		}
		data = loadFreeDays(getLocalizedMessage("UNAUTH"));
		if (data.containsKey(name)) {
			faltas = data.get(name);
		}

		tabbedPane = new ModernTabbedPane();
		tabbedPane.setBackground(bg);

		tabbedPane.add(getLocalizedMessage("WEEK_DAYS"), createPanelWithTable(weekDays));
		tabbedPane.add(getLocalizedMessage("LICENSE"), createPanelWithTable(licDays));
		tabbedPane.add(getLocalizedMessage("UNAUTH"), createPanelWithTable(faltas));

		// Close Button
		JButton closeButton = new JButton(ImageEffect.getScaledImage(closeImage.getImage(), 15, 15));
		closeButton.setBorderPainted(false);
		closeButton.setFocusPainted(false);
		closeButton.setContentAreaFilled(false);
		closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		closeButton.setToolTipText(getLocalizedMessage("EXIT"));
		closeButton.addActionListener(_ -> {
			employeeD.dispose();
			overlay.hideOverlay();
		});

		JPanel buttonPanel = new JPanel(new BorderLayout());
		buttonPanel.setOpaque(false);
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(15, 10, 20, 0));
		buttonPanel.add(closeButton, BorderLayout.EAST);
		buttonPanel.add(titleLabel, BorderLayout.CENTER);

		JLabel totalLabel = new JLabel("TOTAL: " + licDays.size(), SwingConstants.CENTER);
		totalLabel.setFont(new Font("Arial", Font.BOLD, 16));
		totalLabel.setVisible(false);
		totalLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		int licD = licDays.size(), faltasD = faltas.size();
		tabbedPane.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				if (tabbedPane.getSelectedIndex() == 1) {
					if (conf[23] == null || conf[23].equalsIgnoreCase("null") || conf[23].equals("false")) {
						LocalDate startDate = null;
						for (int i = 0; i < employee.size(); i++)
							if (employee.get(i).getName().equalsIgnoreCase(name))
								startDate = employee.get(i).getHireDate();
						if (startDate != null) {
							int days = 20, years = (int) ChronoUnit.YEARS.between(startDate, LocalDate.now()) / 5;
							if ((int) ChronoUnit.YEARS.between(startDate, LocalDate.now()) >= 5)
								days += years;
							totalLabel.setText(licD + " " + getLocalizedMessage("DAY") + "S "
									+ getLocalizedMessage("OF") + " " + days);
						} else
							totalLabel.setText(
									"TOTAL: " + licD + " " + getLocalizedMessage("DAY") + (licD > 1 ? "S" : ""));
						totalLabel.setVisible(true);
					} else {
						totalLabel.setText("TOTAL: " + licD + " " + getLocalizedMessage("DAY") + (licD > 1 ? "S" : ""));
						totalLabel.setVisible(true);
					}
				} else if (tabbedPane.getSelectedIndex() == 2) {
					if (faltasD > 0) {
						totalLabel.setText(
								"TOTAL: " + faltasD + " " + getLocalizedMessage("DAY") + (faltasD > 1 ? "S" : ""));
						totalLabel.setVisible(true);
					} else
						totalLabel.setVisible(false);
				} else
					totalLabel.setVisible(false);
			}
		});

		contentPane.add(buttonPanel, BorderLayout.NORTH);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		contentPane.add(totalLabel, BorderLayout.SOUTH);

		// Key listener for ESC key to close the dialog
		InputMap inputMap = employeeD.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap = employeeD.getRootPane().getActionMap();
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "closeDialog");
		actionMap.put("closeDialog", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				employeeD.dispose();
				overlay.hideOverlay();
			}
		});

		// Make the dialog focusable so it can capture key events
		employeeD.setFocusable(true);
		employeeD.requestFocusInWindow();

		employeeD.setVisible(true);
	}

	/* Edit free day of the week */
	private void weekFreeDays() {
		employeeAddEvents();
		// Create a dialog for the table
		JDialog dialog = new JDialog(this, getLocalizedMessage("WEEK_DAYS"), true);
		dialog.setSize(getWidth() * 2 / 3, getHeight() * 2 / 3);
		dialog.setLocationRelativeTo(this);
		overlay.showOverlay();

		tabbedPane = new ModernTabbedPane();

		// open the license days
		data = loadFreeDays(getLocalizedMessage("WEEK_DAYS"));

		// Create tabs for each name
		if (data.size() == 0) {
			for (int row = 0; row < employee.size(); row++)
				if (!employee.get(row).getPosition().equalsIgnoreCase(getLocalizedMessage("BOSS"))
						&& !employee.get(row).getName().isBlank() && !data.containsKey(employee.get(row).getName())) {
					data.computeIfAbsent(employee.get(row).getName(), _ -> new ArrayList<>());
					addTabFreeDays(employee.get(row).getName());
				}
		} else
			for (String name : data.keySet()) {
				addTabFreeDays(name);
			}

		// Key listener for ESC key to close the dialog
		InputMap inputMap = dialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap = dialog.getRootPane().getActionMap();
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "closeDialog");
		actionMap.put("closeDialog", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
				overlay.hideOverlay();
				saveCsvFile(getLocalizedMessage("WEEK_DAYS"));
			}
		});
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				overlay.hideOverlay();
				saveCsvFile(getLocalizedMessage("WEEK_DAYS"));
			}
		});
		dialog.add(tabbedPane);

		// Show the dialog
		dialog.setVisible(true);
	}

	/* Edit the license days */
	private void vacDays() {
		employeeAddEvents();
		// Create a dialog for the table
		JDialog dialog = new JDialog(this, getLocalizedMessage("VACATION"), true);
		dialog.setSize(getWidth() * 2 / 3, getHeight() * 2 / 3);
		dialog.setLocationRelativeTo(this);
		overlay.showOverlay();

		tabbedPane = new ModernTabbedPane();

		// open the license days
		data = loadFreeDays(getLocalizedMessage("LICENSE"));

		// Create tabs for each name
		if (data.size() == 0) {
			for (int row = 0; row < employee.size(); row++) {
				if (!employee.get(row).getPosition().equalsIgnoreCase(getLocalizedMessage("BOSS"))
						&& !employee.get(row).getName().isBlank() && !data.containsKey(employee.get(row).getName())) {
					data.computeIfAbsent(employee.get(row).getName(), _ -> new ArrayList<>());
					addTabFreeDays(employee.get(row).getName());
				}
			}

		} else
			for (String name : data.keySet()) {
				addTabFreeDays(name);
			}

		// Key listener for ESC key to close the dialog
		InputMap inputMap = dialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap = dialog.getRootPane().getActionMap();
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "closeDialog");
		actionMap.put("closeDialog", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
				overlay.hideOverlay();
				saveCsvFile(getLocalizedMessage("LICENSE"));
			}
		});
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				overlay.hideOverlay();
				saveCsvFile(getLocalizedMessage("LICENSE"));
			}
		});
		dialog.add(tabbedPane);

		// Show the dialog
		dialog.setVisible(true);
	}

	/* Edit the unathorized days */
	private void unauthDays() {
		employeeAddEvents();
		// Create a dialog for the table
		JDialog dialog = new JDialog(this, getLocalizedMessage("UNAUTH"), true);
		dialog.setSize(getWidth() * 2 / 3, getHeight() * 2 / 3);
		dialog.setLocationRelativeTo(this);
		overlay.showOverlay();

		tabbedPane = new ModernTabbedPane();

		// open the license days
		data = loadFreeDays(getLocalizedMessage("UNAUTH"));

		// Create tabs for each name
		if (data.size() == 0) {
			for (int row = 0; row < employee.size(); row++)
				if (!employee.get(row).getName().isBlank()) {
					data.computeIfAbsent(employee.get(row).getName(), _ -> new ArrayList<>());
					addTabFreeDays(employee.get(row).getName());
				}
		} else
			for (String name : data.keySet()) {
				addTabFreeDays(name);
			}

		// Key listener for ESC key to close the dialog
		InputMap inputMap = dialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap = dialog.getRootPane().getActionMap();
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "closeDialog");
		actionMap.put("closeDialog", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
				overlay.hideOverlay();
				saveCsvFile(getLocalizedMessage("UNAUTH"));
			}
		});
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				overlay.hideOverlay();
				saveCsvFile(getLocalizedMessage("UNAUTH"));
			}
		});
		dialog.add(tabbedPane);

		// Show the dialog
		dialog.setVisible(true);
	}

	/* Create panel for each free day */
	private JPanel createPanelWithTable(List<String> dates) {
		JPanel panel = new JPanel(new BorderLayout());

		if (dates.isEmpty()) {
			JLabel emptyLabel = new JLabel(getLocalizedMessage("NO_DATA"), SwingConstants.CENTER);
			emptyLabel.setFont(new Font("Arial", Font.BOLD, 16));
			panel.add(emptyLabel, BorderLayout.CENTER);
			return panel;
		}

		// Convert list to a table model with separators
		DefaultTableModel tableModel = new DefaultTableModel(new Object[] { getLocalizedMessage("DATE") }, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // Make table read-only
			}
		};
		Map<Integer, List<String>> sortedDates = new TreeMap<>();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		for (String dateStr : dates) {
			try {
				Date date = sdf.parse(dateStr);
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				int month = cal.get(Calendar.MONTH) + 1; // Get month (1 = January)

				sortedDates.computeIfAbsent(month, _ -> new ArrayList<>()).add(dateStr);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		for (Map.Entry<Integer, List<String>> entry : sortedDates.entrySet()) {
			tableModel.addRow(new Object[] { "--- " + getMonthForInt(entry.getKey() - 1, langIndex) + " ---" });
			for (String date : entry.getValue()) {
				String parts[] = date.split("/");
				DateModified dateM = new DateModified(Integer.valueOf(parts[0]), Integer.valueOf(parts[1]),
						Integer.valueOf(parts[2]));
				tableModel.addRow(new Object[] { dayName(dateM, langIndex) + " " + date });
			}
		}

		JTable table = new JTable(tableModel);
		table.setRowHeight(30);
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				JLabel label = new JLabel(value.toString(), JLabel.CENTER);
				label.setFont(new Font("SansSerif", Font.PLAIN, 16));
				label.setOpaque(true);
				label.setBackground(bg);

				if (value.toString().startsWith("---")) { // Month Header Styling
					label.setFont(new Font("SansSerif", Font.BOLD, 18));
					label.setBackground(Intro.redM);
					label.setBorder(uBorder);
					label.setForeground(Intro.lightC);
				} else {
					label.setFont(new Font("SansSerif", Font.PLAIN, 16));
					label.setBorder(new LineBorder(fg, 1));
				}
				return label;
			}
		});
		table.setTableHeader(null);

		JScrollPane scrollPane = new JScrollPane(table);
		panel.add(scrollPane, BorderLayout.CENTER);
		return panel;
	}

	/* Add tab for free days */
	private void addTabFreeDays(String name) {
		JPanel panel = new JPanel(new BorderLayout());

		// Table setup
		String[] columnNames = { getLocalizedMessage("DATE"), getLocalizedMessage("DELETE") };
		tableModel = new DefaultTableModel(columnNames, 0);
		JTable table = new JTable(tableModel) {

			@Override
			public boolean editCellAt(int row, int column, EventObject e) {
				boolean result = super.editCellAt(row, column, e);
				final Component editor = getEditorComponent();

				if (editor instanceof JTextField) {
					JTextField textField = (JTextField) editor;

					// Select all text when editing starts
					if (e instanceof KeyEvent) {
						textField.setText(""); // Clear text for overwrite
						textField.requestFocusInWindow();
					} else {
						// If triggered by focus or mouse, select all text
						SwingUtilities.invokeLater(textField::selectAll);
					}
				}
				return result;
			}
		};

		table.setFont(new Font("Arial", Font.PLAIN, 16));
		table.setRowHeight(30);
		table.setShowGrid(true);
		table.setIntercellSpacing(new Dimension(0, 0));
		for (String date : data.get(name)) {
			tableModel.addRow(new Object[] { date });
		}

		// Add the table to a scroll pane
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.setDefaultRenderer(Object.class, centerRenderer);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(1).setMinWidth(90);
		table.getColumnModel().getColumn(1).setMaxWidth(90);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		JFormattedTextField textField = new JFormattedTextField();
		datePicker = new DatePicker();
		datePicker.now();
		datePicker.setEditor(textField);
		datePicker.setDateSelectionMode(DatePicker.DateSelectionMode.SINGLE_DATE_SELECTED);
		datePicker.setUsePanelOption(true);
		datePicker.setCloseAfterSelected(true);
		datePicker.setEditorValidation(true);
		datePicker.setValidationOnNull(true);
		table.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(textField) {
			@Override
			public Object getCellEditorValue() {
				data.get(name).add(textField.getText());
				return textField.getText();
			}
		});

		// Customize the table header
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Arial", Font.BOLD, 18));
		header.setBackground(new Color(220, 220, 220)); // Light gray background for header
		header.setForeground(Color.DARK_GRAY); // Dark gray text for header
		header.setReorderingAllowed(false); // Prevent column reordering
		header.setResizingAllowed(false); // Prevent column resizing

		// Total count label
		JLabel totalLabel = new JLabel("TOTAL: " + tableModel.getRowCount(), SwingConstants.CENTER);
		totalLabel.setFont(new Font("Arial", Font.BOLD, 14));

		// Add Delete button
		javax.swing.Action deleteAction = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTable table = (JTable) e.getSource();
				int row = Integer.parseInt(e.getActionCommand());

				// Get the selected tab index
				int selectedIndex = tabbedPane.getSelectedIndex();
				if (selectedIndex == -1)
					return;

				// Get the name associated with the selected tab
				String name = tabbedPane.getTitleAt(selectedIndex);

				// Remove the corresponding date from the data map
				if (data.containsKey(name) && row >= 0 && row < data.get(name).size()) {
					data.get(name).remove(row);
				}
				((DefaultTableModel) table.getModel()).removeRow(row);
			}
		};
		new ButtonColumn(table, deleteAction, 1);

		// BOTTOM PANEL
		JPanel bottomRow = new JPanel(new BorderLayout());
		JPanel buttonsP = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton addRowButton = new JButton(getLocalizedMessage("ADD") + " ITEM");
		addRowButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		addRowButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		addRowButton.addActionListener(_ -> {
			int selectedIndex = tabbedPane.getSelectedIndex(); // Get active tab index
			if (selectedIndex == -1)
				return; // No tab is selected

			// Get the JPanel at the selected index
			JPanel selectedPanel = (JPanel) tabbedPane.getComponentAt(selectedIndex);
			// Get the JScrollPane from the selected panel
			JScrollPane scrollPane = (JScrollPane) selectedPanel.getComponent(0);
			// Get the JTable from the JScrollPane
			JTable table2 = (JTable) scrollPane.getViewport().getView();

			// Add row to the table
			DefaultTableModel model = (DefaultTableModel) table2.getModel();
			model.addRow(new Object[] { currentDate.getToday(), "X" }); // Add the row
			totalLabel.setText("TOTAL: " + model.getRowCount());
		});

		JButton clearTable = new JButton(getLocalizedMessage("CLEAR"));
		clearTable.setFont(new Font("Segoe UI", Font.BOLD, 14));
		clearTable.setCursor(new Cursor(Cursor.HAND_CURSOR));
		clearTable.addActionListener(_ -> {
			int selectedIndex = tabbedPane.getSelectedIndex(); // Get active tab index
			if (selectedIndex == -1)
				return; // No tab is selected

			// Get the JPanel at the selected index
			JPanel selectedPanel = (JPanel) tabbedPane.getComponentAt(selectedIndex);
			// Get the JScrollPane from the selected panel
			JScrollPane scrollPane = (JScrollPane) selectedPanel.getComponent(0);
			// Get the JTable from the JScrollPane
			JTable table2 = (JTable) scrollPane.getViewport().getView();

			// Add row to the table
			DefaultTableModel model = (DefaultTableModel) table2.getModel();
			model.setRowCount(0);
			totalLabel.setText("TOTAL: " + model.getRowCount());
		});
		buttonsP.add(addRowButton);
		buttonsP.add(clearTable);
		bottomRow.add(totalLabel, BorderLayout.CENTER);
		bottomRow.add(buttonsP, BorderLayout.SOUTH);

		panel.add(new JScrollPane(table), BorderLayout.CENTER);
		panel.add(bottomRow, BorderLayout.SOUTH);
		tabbedPane.addTab(name, panel);
	}

	// Load the saved days of licensia
	private Map<String, List<String>> loadFreeDays(String type) {
		Map<String, List<String>> data = new HashMap<String, List<String>>();
		File extraF = new File(dataFolder + "\\" + TextEffect.capitalizeString(getLocalizedMessage("EMPLOYEE")));
		extraF.mkdir();
		File licF = new File(extraF + "\\" + TextEffect.capitalizeString(getLocalizedMessage("WORK_DAYS")));
		licF.mkdir();
		File todayFile = new File(licF, type + "-" + currentDate.y + ".csv");
		if (todayFile.exists()) {
			try (BufferedReader br = new BufferedReader(new FileReader(todayFile))) {
				String headerLine = br.readLine(); // Read the header (Name, Date)
				if (headerLine == null) {
					for (int row = 0; row < employee.size(); row++) {
						if (!employee.get(row).getPosition().equalsIgnoreCase(getLocalizedMessage("BOSS"))
								&& !employee.get(row).getName().isBlank())
							data.computeIfAbsent(employee.get(row).getName(), _ -> new ArrayList<>());
					}
					try (PrintWriter writer = new PrintWriter(new FileWriter(todayFile))) {
						writer.println("NAME,DATES");
						for (int row = 0; row < employee.size(); row++) {
							if (!employee.get(row).getPosition().equalsIgnoreCase(getLocalizedMessage("BOSS"))
									&& !employee.get(row).getName().isBlank())
								writer.println(employee.get(row).getName());
						}
					} catch (IOException e1) {
						writeError(e1);
					}
				} else {
					String line;
					while ((line = br.readLine()) != null) {
						String[] parts = line.split(",");
						String name = parts[0].trim();
						if (parts.length == 1)
							data.computeIfAbsent(name, _ -> new ArrayList<>());
						else
							for (int i = 1; i < parts.length; i++) {
								String dateStr = parts[i].trim();
								data.computeIfAbsent(name, _ -> new ArrayList<>()).add(dateStr);
							}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try (PrintWriter writer = new PrintWriter(new FileWriter(todayFile))) {
				writer.println("NAME,DATES");
				for (int row = 0; row < employee.size(); row++) {
					if (!employee.get(row).getPosition().equalsIgnoreCase(getLocalizedMessage("BOSS"))
							&& !employee.get(row).getName().isBlank()) {
						data.computeIfAbsent(employee.get(row).getName(), _ -> new ArrayList<>());
						writer.println(employee.get(row).getName());
					}
				}
			} catch (IOException e1) {
				writeError(e1);
			}
		}
		return data;
	}

	// Save the FREE DAYS days
	private void saveCsvFile(String type) {
		File extraF = new File(dataFolder + "\\" + TextEffect.capitalizeString(getLocalizedMessage("EMPLOYEE")));
		extraF.mkdir();
		File licF = new File(extraF + "\\" + TextEffect.capitalizeString(getLocalizedMessage("WORK_DAYS")));
		licF.mkdir();
		File licFile = new File(licF, type + "-" + currentDate.y + ".csv");
		List<String> newMap = new ArrayList<String>();
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(licFile))) {
			// Write header
			writer.write("Name,Date\n");
			for (Map.Entry<String, List<String>> entry : data.entrySet()) {
				newMap.clear();
				String name = entry.getKey();
				List<String> vacationDays = entry.getValue();
				for (String date : vacationDays) {
					newMap.add(date);
				}
				if (searchEmp(name))
					writer.write(name + "," + String.join(",", newMap) + "\n");
			}
			for (int row = 0; row < employee.size(); row++) {
				if (!employee.get(row).getName().isBlank() && !data.containsKey(employee.get(row).getName()))
					if (!employee.get(row).getPosition().equalsIgnoreCase(getLocalizedMessage("BOSS")))
						writer.write(employee.get(row).getName() + "," + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Search if the employee exist before saving it
	private boolean searchEmp(String name) {
		for (int i = 0; i < employee.size(); i++)
			if (employee.get(i).getName().equalsIgnoreCase(name))
				return true;
		return false;
	}

	/* Choose date to filter seller total sales */
	private void searchSellerByDates(String name, String type) {
		JDialog dialog = new JDialog(this, "", true);
		dialog.setUndecorated(true);
		dialog.setSize(getWidth() / 3, getHeight() / 3);
		dialog.setShape(new RoundRectangle2D.Double(0, 0, getWidth() / 3, getHeight() / 3, 20, 20));
		dialog.setLocationRelativeTo(this);
		dialog.setLayout(new GridBagLayout());
		dialog.setResizable(false);
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

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weightx = 1; // Allow horizontal centering
		gbc.weighty = 1; // Allow vertical centering

		// Buttons
		JButton certainMonth = new JButton(getLocalizedMessage("MONTH"));
		JButton certainYear = new JButton(getLocalizedMessage("YEAR"));
		JButton loadData = new JButton(getLocalizedMessage("LOAD") + " "
				+ (type.equalsIgnoreCase("graph") ? getLocalizedMessage("GRAPH")
						: type.equalsIgnoreCase("table") ? getLocalizedMessage("TABLE")
								: type.equalsIgnoreCase("diagram") ? getLocalizedMessage("DIAGRAM")
										: getLocalizedMessage("SUMMARY")));
		String[] months = new String[12];
		for (int i = 0; i < 12; i++)
			months[i] = getMonthForInt(i, langIndex);
		JComboBox<String> monthCombo = new JComboBox<String>(months);
		DefaultListCellRenderer monthsRender = new DefaultListCellRenderer() {
			private final int currentMonth = currentDate.m;

			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {

				Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if (index >= currentMonth) {
					c.setForeground(Color.GRAY); // Grays out future months
				}
				return c;
			}
		};
		monthCombo.setRenderer(monthsRender);
		monthCombo.setEditable(false);
		monthCombo.setSelectedIndex(currentDate.m - 1);
		monthCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = monthCombo.getSelectedIndex();
				if (selectedIndex > currentDate.m - 1) {
					monthCombo.setSelectedIndex(currentDate.m - 1);
				}
			}
		});
		certainMonth.addActionListener(_ -> {
			optionChoosing = 0;
			monthCombo.setVisible(true);
		});
		certainYear.addActionListener(_ -> {
			optionChoosing = 1;
			monthCombo.setVisible(false);
		});
		certainMonth.setFont(new Font("Segoe UI", Font.BOLD, 14));
		certainYear.setFont(new Font("Segoe UI", Font.BOLD, 14));
		loadData.setFont(new Font("Segoe UI", Font.BOLD, 14));

		// Loads
		loadData.addActionListener(_ -> {
			if (type.equalsIgnoreCase("table")) {
				if (monthCombo.isVisible())
					viewSellerTableAccDate(monthCombo.getSelectedIndex() + 1, currentDate.y);
				else
					viewSellerTableAccDate(-1, currentDate.y);
			} else if (type.equalsIgnoreCase("graph")) {
				if (monthCombo.isVisible())
					viewSellerGraphAccDate(monthCombo.getSelectedIndex() + 1, currentDate.y);
				else
					viewSellerGraphAccDate(-1, currentDate.y);
			} else if (type.equalsIgnoreCase("diagram")) {
				if (monthCombo.isVisible())
					viewSellerDiagAccDate(monthCombo.getSelectedIndex() + 1, currentDate.y);
				else
					viewSellerDiagAccDate(-1, currentDate.y);
			} else {
				if (monthCombo.isVisible())
					summaryEmployee(monthCombo.getSelectedIndex() + 1, currentDate.y);
				else
					summaryEmployee(-1, currentDate.y);
			}
		});

		// Close Button
		JButton closeButton = new JButton(ImageEffect.getScaledImage(closeImage.getImage(), 15, 15));
		closeButton.setBorderPainted(false);
		closeButton.setFocusPainted(false);
		closeButton.setContentAreaFilled(false);
		closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		closeButton.setToolTipText(getLocalizedMessage("EXIT"));
		closeButton.addActionListener(_ -> {
			dialog.dispose();
			overlay.hideOverlay();
		});

		// Add Components to Dialog
		JPanel borderLay = new JPanel(new GridBagLayout());
		borderLay.setOpaque(false);
		// Add Components to Dialog
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		borderLay.add(
				new JLabel("<html><b><u><font size='5'>" + getLocalizedMessage("DATE_S") + "</font></u></b></html>"),
				gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		borderLay.add(certainMonth, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		borderLay.add(certainYear, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		borderLay.add(monthCombo, gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		borderLay.add(loadData, gbc);
		JPanel northPanel = new JPanel(new BorderLayout());
		northPanel.setOpaque(false);
		northPanel.add(closeButton, BorderLayout.EAST);
		contentPane.add(northPanel, BorderLayout.NORTH);
		contentPane.add(borderLay, BorderLayout.CENTER);

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
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				overlay.hideOverlay();
			}
		});

		dialog.setVisible(true);
	}

	/* get the dates and total sales for each seller */
	private Map<String, Integer> getSellerSalesAccDate(String sellerName, int month, int year) {
		Map<String, Map<String, Integer>> salesMap = LoadSellerTotal(year);
		Map<String, Integer> dateQuantity = new HashMap<String, Integer>();
		for (Map.Entry<String, Map<String, Integer>> entry : salesMap.entrySet()) {
			if (entry.getKey().equalsIgnoreCase(sellerName))
				dateQuantity = entry.getValue();
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		// Define start and end dates
		LocalDate startDate, lastDate;
		if (month == -1) {
			startDate = LocalDate.of(year, 1, 1);
			lastDate = LocalDate.of(year, 12, 31);
		} else {
			startDate = LocalDate.of(year, month, 1);
			DateModified date = new DateModified(1, month, year);
			lastDate = LocalDate.of(year, month, date.maxDays());
		}
		// Filter the map while keeping quantity
		Map<String, Integer> filteredMap = dateQuantity.entrySet().stream().filter(entry -> {
			LocalDate date = LocalDate.parse(entry.getKey(), formatter);
			return !date.isBefore(startDate) && !date.isAfter(lastDate);
		}).sorted(Comparator.comparing(entry -> LocalDate.parse(entry.getKey(), formatter))) // Sort by date
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, _) -> oldValue,
						LinkedHashMap::new // Preserve order
				));
		return filteredMap;
	}

	/* View MERCHANDISE BY DATE AS TABLE */
	private void viewSellerTableAccDate(int month, int year) {
		JDialog dialog = new JDialog(this, "", true);
		dialog.setUndecorated(true);
		dialog.setSize(getWidth() * 2 / 3, getHeight() * 2 / 3);
		dialog.setShape(new RoundRectangle2D.Double(0, 0, getWidth() * 2 / 3, getHeight() * 2 / 3, 10, 10));
		dialog.setLocationRelativeTo(this);
		dialog.setLayout(new GridBagLayout());
		dialog.setResizable(false);

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
				g2d.setStroke(new BasicStroke(1)); // Example border thickness (3 pixels)
				g2d.drawRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 20, 20); // Draw border with small padding
			}
		};
		contentPane.setLayout(new BorderLayout());
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		dialog.setContentPane(contentPane);

		tabbedPane = new ModernTabbedPane();
		tabbedPane.setBackground(bg);
		for (Employee emp : employee) {
			String emName = emp.getName();
			Map<String, Integer> filteredMap = getSellerSalesAccDate(emName, month, year);
			int total = 0;
			// Create a table model and table
			DefaultTableModel employeeTableModel = new DefaultTableModel(
					new String[] { getLocalizedMessage("DATE"), getLocalizedMessage("HOW_MUCH") + "($)" }, 0) {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			int mIndex = 1;
			if (month == -1) {
				while (mIndex <= currentDate.m) {
					Map<String, Integer> newMap = getSellerSalesAccDate(emName, mIndex, year);
					int totalM = 0;
					for (int value : newMap.values())
						totalM += value;
					employeeTableModel.addRow(new Object[] { getMonthForInt(mIndex - 1, langIndex), totalM });
					total += totalM;
					mIndex++;
				}

			} else
				for (Map.Entry<String, Integer> entry : filteredMap.entrySet()) {
					String date = entry.getKey();
					int qty = entry.getValue();
					total += qty;
					employeeTableModel.addRow(new Object[] { date, qty });
				}

			if (total > 0) {
				JPanel panel = new JPanel(new BorderLayout());
				panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
				panel.setOpaque(false);
				JTable employeeTable = new JTable(employeeTableModel);
				employeeTable.setFont(new Font("Arial", Font.PLAIN, 16));
				employeeTable.setRowHeight(30);
				employeeTable.setShowGrid(true);
				employeeTable.setBackground(
						conf[10] == null || conf[10].equalsIgnoreCase("0") || conf[10].equalsIgnoreCase("null")
								? bg.darker()
								: bg.brighter());
				employeeTable.setIntercellSpacing(new Dimension(0, 0));

				// Add the employeeTable to a scroll pane
				JScrollPane scrollPane = new JScrollPane(employeeTable);
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
				employeeTable.setDefaultRenderer(Object.class, centerRenderer);
				employeeTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

				// Customize the table header
				JTableHeader header = employeeTable.getTableHeader();
				header.setFont(new Font("Arial", Font.BOLD, 18));
				header.setBackground(new Color(220, 220, 220)); // Light gray background for header
				header.setForeground(Color.DARK_GRAY); // Dark gray text for header
				header.setReorderingAllowed(false); // Prevent column reordering
				header.setResizingAllowed(false); // Prevent column resizing

				// Add a row sorter for filtering
				TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(employeeTableModel);
				sorter.setComparator(0, (String date1, String date2) -> { // Sorting column 0 (Dates)
					LocalDate d1 = LocalDate.parse(date1, formatter);
					LocalDate d2 = LocalDate.parse(date2, formatter);
					return d1.compareTo(d2); // Sort past → future
				});

				employeeTable.setRowSorter(sorter);

				JLabel totalV = new JLabel("T O T A L :  $" + total);
				totalV.setFont(new Font("Arial", Font.BOLD, 18));
				totalV.setHorizontalAlignment(0);
				totalV.setForeground(fg);
				totalV.setBorder(BorderFactory.createEmptyBorder(15, 0, 5, 0));
				panel.add(scrollPane, BorderLayout.CENTER);
				panel.add(totalV, BorderLayout.SOUTH);
				tabbedPane.add(emp.getName(), panel);
			}
		}

		if (tabbedPane == null || tabbedPane.getTabCount() == 0) {
			Toast.show(this, Toast.Type.INFO, getLocalizedMessage("NO_DATA"), Intro.notOption);
			dialog.dispose();
		} else {
			// north panel
			JPanel northPanel = new JPanel(new BorderLayout());
			northPanel.setOpaque(false);
			String address;
			if (month == -1)
				address = currentDate.y + "";
			else
				address = getMonthForInt(month - 1, langIndex);
			JLabel title = new JLabel(getLocalizedMessage("SELL") + " " + getLocalizedMessage("OF") + " " + address);
			title.setFont(new Font("Arial", Font.BOLD, 20));
			title.setHorizontalAlignment(0);
			title.setForeground(fg);
			title.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
			JButton closeButton = new JButton(ImageEffect.getScaledImage(closeImage.getImage(), 15, 15));
			closeButton.setBorderPainted(false);
			closeButton.setFocusPainted(false);
			closeButton.setContentAreaFilled(false);
			closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			closeButton.setToolTipText(getLocalizedMessage("EXIT"));
			closeButton.addActionListener(_ -> dialog.dispose());
			northPanel.add(title, BorderLayout.CENTER);
			northPanel.add(closeButton, BorderLayout.EAST);

			// Add the scroll pane to the dialog
			contentPane.add(northPanel, BorderLayout.NORTH);
			contentPane.add(tabbedPane, BorderLayout.CENTER);

			// Key listener for ESC key to close the dialog
			InputMap inputMap = dialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
			ActionMap actionMap = dialog.getRootPane().getActionMap();
			inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "closeDialog");
			actionMap.put("closeDialog", new AbstractAction() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dialog.dispose();
				}
			});

			// Show the dialog
			dialog.setVisible(true);
		}
	}

	/* View seller sales acc to month/year as graph */
	private void viewSellerGraphAccDate(int month, int year) {
		// Create a dialog for the merchandise table
		JDialog dialog = new JDialog(this,
				getLocalizedMessage("GRAPH") + " " + getLocalizedMessage("OF") + " " + getLocalizedMessage("SELL"),
				true);
		dialog.setSize(getWidth() * 2 / 3, getHeight() * 2 / 3);
		dialog.setLocationRelativeTo(this);

		// Create and display the panel
		JFreeChart lineChart = sellersChart(month, year);
		CategoryDataset dataset = lineChart.getCategoryPlot().getDataset();
		if (dataset != null && dataset.getRowCount() > 1) {
			ChartPanel chartPanel = new ChartPanel(lineChart);
			chartPanel.setPreferredSize(new Dimension(getWidth() * 2 / 3, getHeight() * 2 / 3));
			// Create a JPanel to hold both the chart and the custom legend
			JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout());

			// Add the chart to the center of the panel
			panel.add(chartPanel, BorderLayout.CENTER);

			// Create a JLabel for the custom legend
			String legend;
			if (month != -1)
				legend = "<html><head><style> body {color" + (colorSelected == 2 ? ": black;" : ": white;")
						+ "} </style></head><br>• " + getLocalizedMessage("LEGEND_S") + "<br><br>• "
						+ getLocalizedMessage("HOLLOW_POINT") + "<br></html>";
			else
				legend = "<html><head><style> body {color" + (colorSelected == 2 ? ": black;" : ": white;")
						+ "} </style></head><br>• " + getLocalizedMessage("LEGEND_S") + "<br>" + "</html>";
			JLabel customLegend = new JLabel(legend);
			customLegend.setOpaque(true);
			customLegend.setBackground(bg);
			customLegend.setHorizontalAlignment(SwingConstants.CENTER); // Center the legend text
			customLegend.setFont(new Font("Arial", Font.PLAIN, 12)); // Set font for the legend
			customLegend.setBorder(new EmptyBorder(20, 0, 20, 0));

			// Add the custom legend below the chart
			panel.add(customLegend, BorderLayout.SOUTH);

			// Key listener for ESC key to close the dialog
			InputMap inputMap = dialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
			ActionMap actionMap = dialog.getRootPane().getActionMap();
			inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "closeDialog");
			actionMap.put("closeDialog", new AbstractAction() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dialog.dispose();
				}
			});

			// Show the dialog
			dialog.add(panel);
			dialog.setVisible(true);
		} else
			Toast.show(this, Toast.Type.INFO, getLocalizedMessage("NO_DATA"), Intro.notOption);
	}

	/* Return the chart for sellers */
	private JFreeChart sellersChart(int month, int year) {
		// Load merchandise data
		Map<String, Map<String, Integer>> salesMap = LoadSellerTotal(year);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate startDate, lastDate;
		if (month == -1) {
			startDate = LocalDate.of(year, 1, 1);
			lastDate = LocalDate.of(year, currentDate.m, currentDate.d);
		} else {
			startDate = LocalDate.of(year, month, 1);
			DateModified date = new DateModified(1, month, year);
			if (month == currentDate.m)
				lastDate = LocalDate.of(year, month, currentDate.d);
			else
				lastDate = LocalDate.of(year, month, date.maxDays());
		}
		// FILTER THE SALES BY DATES
		Map<String, Map<String, Integer>> filteredMap = new HashMap<>();
		for (String employee : salesMap.keySet()) {
			Map<String, Integer> filteredDates = new TreeMap<>(
					Comparator.comparing(d -> LocalDate.parse(d, formatter)));
			for (Map.Entry<String, Integer> entry : salesMap.get(employee).entrySet()) {
				LocalDate entryDate = LocalDate.parse(entry.getKey(), formatter);
				if (!entryDate.isBefore(startDate) && !entryDate.isAfter(lastDate)) {
					filteredDates.put(entry.getKey(), entry.getValue());
				}
			}
			if (!filteredDates.isEmpty()) {
				filteredMap.put(employee, filteredDates);
			}
		}
		// FILTER THE FREE DAYS BY DATES
		data = loadFreeDays(getLocalizedMessage("WEEK_DAYS"));
		LineAndShapeRenderer renderer;
		if (month == -1)
			renderer = new LineAndShapeRenderer();
		else
			renderer = new LineAndShapeRenderer() {
				@Override
				public Paint getItemOutlinePaint(int row, int column) {
					return Color.BLACK;
				}

				@Override
				public boolean getItemShapeFilled(int row, int column) {
					String employee = (String) getPlot().getDataset().getRowKey(row);
					String date = (String) getPlot().getDataset().getColumnKey(column) + "/"
							+ (month < 10 ? "0" + month : month) + "/" + year;

					// Check if date is a free day for this employee
					List<String> freeDates = data.get(employee);
					if (freeDates != null && freeDates.contains(date))
						return false;
					else
						return true;
				}
			};
		renderer.setDefaultToolTipGenerator(new CategoryToolTipGenerator() {
			@Override
			public String generateToolTip(org.jfree.data.category.CategoryDataset dataset, int row, int column) {
				String name = dataset.getRowKey(row).toString();
				Number value = dataset.getValue(row, column);

				return (name + " -> $ " + value.toString());
			}
		});
		int seriesIndex = 1;
		Color[] seriesColors = { Intro.greenM, Intro.goldM, blueC, orangeC, turqC };

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		ArrayList<Integer> quant = new ArrayList<Integer>(), quantY = new ArrayList<Integer>();
		Set<LocalDate> allDates = new TreeSet<>();
		// Add all dates
		for (LocalDate d = startDate; !d.isAfter(lastDate); d = d.plusDays(1))
			allDates.add(d);

		// calculate the total of the day
		Map<String, Integer> totalSalesByDate = new HashMap<>();
		for (Map<String, Integer> employeeSales : filteredMap.values()) {
			for (Map.Entry<String, Integer> entry : employeeSales.entrySet()) {
				String date = entry.getKey();
				int sales = entry.getValue();
				totalSalesByDate.put(date, totalSalesByDate.getOrDefault(date, 0) + sales);
			}
		}
		// Add the total of the month to graph
		renderer.setSeriesShapesVisible(0, true);
		renderer.setSeriesStroke(0, new BasicStroke(2.0f));
		renderer.setSeriesPaint(0, Intro.redM);
		for (LocalDate date : allDates) {
			String dateStr = date.format(formatter);
			int sales = totalSalesByDate.getOrDefault(dateStr, 0);
			quant.add(sales);
			if (month != -1)
				dataset.addValue(sales == 0 ? null : sales, getMonthForInt(month, langIndex) + "",
						dateStr.substring(0, 2));
		}
		if (month == -1) {
			int total[] = new int[currentDate.m];
			DateModified monthA = currentDate;
			int indexM = 0;
			for (int i = 0; i < currentDate.m; i++) {
				monthA = new DateModified(1, i, currentDate.y);
				if (i > 0) {
					indexM += monthA.maxDays();
				}
				DateModified dateN = new DateModified(currentDate.d, i + 1, currentDate.y);
				int indexMonth = dateN.m == currentDate.m ? dateN.d : dateN.maxDays();
				total[i] = 0;
				for (int j = 0; j < indexMonth; j++)
					total[i] += quant.get(j + indexM);
				dataset.addValue(total[i], currentDate.y + "",
						TextEffect.getFirstThreeLetters(getMonthForInt(i, langIndex)) + "(" + (i + 1) + ")");
			}
		}
		for (String employee : filteredMap.keySet()) {
			Map<String, Integer> salesData = salesMap.get(employee);
			quant.clear();
			for (LocalDate date : allDates) {
				String dateStr = date.format(formatter);
				int sales = salesData.getOrDefault(dateStr, 0); // Default 0 if missing
				quant.add(sales);
				if (month != -1) {
					dataset.addValue(sales == 0 ? null : sales, employee, dateStr.substring(0, 2));
				}
			}
			if (month == -1) {
				quantY.clear();
				DateModified dateN;
				int indexMonth = 0, currentIndex = 0;
				int totalMonth[] = new int[currentDate.m];
				for (int i = 0; i < currentDate.m; i++) {
					totalMonth[i] = 0;
					dateN = new DateModified(currentDate.d, i + 1, currentDate.y);
					indexMonth = dateN.m == currentDate.m ? dateN.d : dateN.maxDays();
					for (int j = 0; j < indexMonth; j++)
						totalMonth[i] += quant.get(currentIndex + j);
					currentIndex += dateN.maxDays();
					quantY.add(totalMonth[i]);
					dataset.addValue(quantY.get(i) == 0 ? null : quantY.get(i), employee,
							TextEffect.getFirstThreeLetters(getMonthForInt(i, langIndex)) + "(" + (i + 1) + ")");
				}
			}
			renderer.setSeriesShapesVisible(seriesIndex, true);
			renderer.setSeriesStroke(seriesIndex, new BasicStroke(2.0f));
			if (seriesIndex < seriesColors.length - 1)
				renderer.setSeriesPaint(seriesIndex, seriesColors[seriesIndex - 1]);
			seriesIndex++;
		}
		// Create the chart
		JFreeChart lineChart = ChartFactory
				.createLineChart(
						getLocalizedMessage("COMPARISON") + " " + getLocalizedMessage("OF") + " "
								+ getLocalizedMessage("SELL") + " " + getLocalizedMessage("OF") + " "
								+ (month == -1 ? currentDate.y + ""
										: getMonthForInt(startDate.getMonthValue() - 1, langIndex)),
						month == -1 ? getLocalizedMessage("MONTH") : getLocalizedMessage("DAY"),
						getLocalizedMessage("SELL") + "($)", dataset);

		// Customize chart background color
		lineChart.setBackgroundPaint(bg);
		lineChart.getTitle().setPaint(fg);
		CategoryPlot plot = lineChart.getCategoryPlot();
		plot.setBackgroundPaint(bg);
		plot.setOutlineVisible(false);
		// X-Axis (Domain Axis) customization
		plot.getDomainAxis().setAxisLinePaint(fg);
		plot.getDomainAxis().setTickLabelPaint(fg);
		plot.getDomainAxis().setLabelPaint(fg);

		// Y-Axis (Range Axis) customization
		plot.getRangeAxis().setAxisLinePaint(fg);
		plot.getRangeAxis().setTickLabelPaint(fg);
		plot.getRangeAxis().setLabelPaint(fg);
		plot.setRenderer(renderer);

		return lineChart;
	}

	/* View seller sales acc to month/year as graph */
	private void viewSellerDiagAccDate(int month, int year) {
		JDialog dialog = new JDialog(this,
				getLocalizedMessage("DIAGRAM") + " " + getLocalizedMessage("OF") + " " + getLocalizedMessage("SELL"),
				true);
		dialog.setSize(getWidth() * 2 / 3, getHeight() * 2 / 3);
		dialog.setLocationRelativeTo(this);

		// Create and display the panel
		JFreeChart lineChart = sellersDiag(month, year, "TOTAL");
		CategoryDataset dataset = lineChart.getCategoryPlot().getDataset();
		if (dataset != null && dataset.getRowCount() > 0) {
			ChartPanel chartPanelT = new ChartPanel(lineChart);
			chartPanelT.setPreferredSize(new Dimension(getWidth() * 2 / 3, getHeight() * 2 / 3));

			JFreeChart lineChartA = sellersDiag(month, year, "AVG");
			ChartPanel chartPanelA = new ChartPanel(lineChartA);
			chartPanelA.setPreferredSize(new Dimension(getWidth() * 2 / 3, getHeight() * 2 / 3));

			// Create a tabbed pane and add both charts
			tabbedPane = new ModernTabbedPane();
			tabbedPane.addTab("Total", chartPanelT);
			tabbedPane.addTab("Average", chartPanelA);

			// Create a JPanel to hold both the chart and the custom legend
			JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout());

			// Add the chart to the center of the panel
			panel.add(tabbedPane, BorderLayout.CENTER);

			// Create a JLabel for the custom legend
			String legend = "<html><head><style> body {color" + (colorSelected == 2 ? ": black;" : ": white;")
					+ "} </style></head> •" + getLocalizedMessage("LEGEND_S") + "<br></html>";
			JLabel customLegend = new JLabel(legend);
			customLegend.setOpaque(true);
			customLegend.setBackground(bg);
			customLegend.setHorizontalAlignment(SwingConstants.CENTER); // Center the legend text
			customLegend.setFont(new Font("Arial", Font.PLAIN, 12)); // Set font for the legend
			customLegend.setBorder(new EmptyBorder(20, 0, 20, 0));

			// Add the custom legend below the chart
			panel.add(customLegend, BorderLayout.SOUTH);
			// Key listener for ESC key to close the dialog
			InputMap inputMap = dialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
			ActionMap actionMap = dialog.getRootPane().getActionMap();
			inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "closeDialog");
			actionMap.put("closeDialog", new AbstractAction() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dialog.dispose();
				}
			});

			// Show the dialog
			dialog.add(panel);
			dialog.setVisible(true);
		} else
			Toast.show(this, Toast.Type.INFO, getLocalizedMessage("NO_DATA"), Intro.notOption);
	}

	/* Return the chart for sellers */
	private JFreeChart sellersDiag(int month, int year, String type) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (Employee emp : employee) {
			String name = emp.getName();
			int total = getSalesOfMonthYear(name, month, year);
			int avg = avgSales(name, month, year);
			if (type.equals("TOTAL")) {
				if (total > 0)
					dataset.addValue(total, (month == -1 ? currentDate.y + "" : getMonthForInt(month - 1, langIndex)),
							name);
			} else if (total > 0)
				dataset.addValue(avg, (month == -1 ? currentDate.y + "" : getMonthForInt(month - 1, langIndex)), name);
		}
		// Create the chart
		JFreeChart lineChart = ChartFactory.createBarChart(
				getLocalizedMessage("COMPARISON") + " " + getLocalizedMessage("OF") + " " + getLocalizedMessage("SELL")
						+ " " + getLocalizedMessage("OF") + " "
						+ (month == -1 ? currentDate.y + "" : getMonthForInt(month - 1, langIndex)) + " ("
						+ (type.equals("TOTAL") ? "TOTAL" : getLocalizedMessage("AVERAGE")) + ")",
				getLocalizedMessage("EMPLOYEE"), getLocalizedMessage("SELL") + "($)", dataset);

		// Customize chart background color
		lineChart.setBackgroundPaint(bg);
		lineChart.getTitle().setPaint(fg);
		lineChart.removeLegend();
		CategoryPlot plot = lineChart.getCategoryPlot();
		plot.setBackgroundPaint(bg);
		plot.setOutlineVisible(false);
		// X-Axis (Domain Axis) customization
		plot.getDomainAxis().setAxisLinePaint(fg);
		plot.getDomainAxis().setTickLabelPaint(fg);
		plot.getDomainAxis().setLabelPaint(fg);
		// Y-Axis (Range Axis) customization
		plot.getRangeAxis().setAxisLinePaint(fg);
		plot.getRangeAxis().setTickLabelPaint(fg);
		plot.getRangeAxis().setLabelPaint(fg);
		BarRenderer renderer = new BarRenderer() {
			@Override
			public void drawItem(Graphics2D g2, CategoryItemRendererState state, Rectangle2D dataArea,
					CategoryPlot plot, CategoryAxis domainAxis, ValueAxis rangeAxis, CategoryDataset dataset, int row,
					int column, int pass) {

				double barWidth = state.getBarWidth();
				double barHeight = dataArea.getHeight() * dataset.getValue(row, column).doubleValue()
						/ rangeAxis.getUpperBound();
				double x = domainAxis.getCategoryMiddle(column, getColumnCount(), dataArea, plot.getDomainAxisEdge())
						- barWidth / 2;
				double y = dataArea.getMaxY() - barHeight;

				java.awt.Shape bar = new RoundRectangle2D.Double(x, y + 20, barWidth, barHeight, 20, 20);

				// Set bar colors
				if (column == 0)
					g2.setPaint(Intro.blueC);
				else if (column == 1)
					g2.setPaint(Intro.goldM);
				else if (column == 2)
					g2.setPaint(Intro.redM);
				else
					g2.setPaint(getItemPaint(row, column));

				g2.fill(bar); // Draw bar
				// ✅ Remove outlines (prevents extra lines around bars)
				setDrawBarOutline(false);

				// ✅ Restore tooltip support
				EntityCollection entities = state.getEntityCollection();
				if (entities != null) {
					Number value = dataset.getValue(row, column);
					CategoryItemEntity entity = new CategoryItemEntity(bar,
							"$ " + value.toString() + " (" + generateLabel(dataset, row, column) + ")", null, dataset,
							dataset.getRowKey(row), dataset.getColumnKey(column));
					entities.add(entity);
				}
			}

			public String generateLabel(CategoryDataset dataset, int row, int column) {
				Number value = dataset.getValue(row, column);
				double total = 0.0;
				for (int r = 0; r < dataset.getRowCount(); r++) {
					for (int c = 0; c < dataset.getColumnCount(); c++) {
						Number val = dataset.getValue(r, c);
						total += val != null ? val.doubleValue() : 0.0;
					}
				}
				double percent = (value.doubleValue() / total) * 100;
				return String.format("%.1f%%", percent);
			}
		};
		renderer.setDrawBarOutline(false);
		plot.setRenderer(renderer);

		CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setTickLabelFont(new Font("SansSerif", Font.PLAIN, 10));
		renderer.setSeriesPaint(0, fg); // Custom color for bars

		return lineChart;
	}

	/* Load sellers sales */
	private Map<String, Map<String, Integer>> LoadSellerTotal(int year) {
		File employeeF = new File(dataFolder + "\\" + TextEffect.capitalizeString(getLocalizedMessage("EMPLOYEE")));
		employeeF.mkdir();
		File sellF = new File(employeeF + "\\" + TextEffect.capitalizeString(getLocalizedMessage("SELL")));
		sellF.mkdir();
		File todayFile = new File(sellF,
				TextEffect.capitalizeString(getLocalizedMessage("SELL")) + "-" + year + ".csv");
		if (!todayFile.exists()) {
			try {
				todayFile.createNewFile();
			} catch (IOException e) {
				writeError(e);
			}
		}

		Map<String, Map<String, Integer>> salesMap = new LinkedHashMap<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(todayFile))) {
			reader.readLine();
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				String name = parts[0];
				Map<String, Integer> dateQtyMap = new LinkedHashMap<>();
				for (int i = 1; i < parts.length; i++) {
					String[] dateQty = parts[i].split(":");
					if (dateQty.length == 2) {
						dateQtyMap.put(dateQty[0], Integer.parseInt(dateQty[1]));
					}
				}
				salesMap.put(name, dateQtyMap);
			}
		} catch (IOException e) {
			writeError(e);
		}
		return salesMap;
	}

	// save the totals of sell for each employee
	private void saveSellerTotal() {
		File employeeF = new File(dataFolder + "\\" + TextEffect.capitalizeString(getLocalizedMessage("EMPLOYEE")));
		employeeF.mkdir();
		File sellF = new File(employeeF + "\\" + TextEffect.capitalizeString(getLocalizedMessage("SELL")));
		sellF.mkdir();
		File todayFile = new File(sellF,
				TextEffect.capitalizeString(getLocalizedMessage("SELL")) + "-" + currentDate.y + ".csv");

		Map<String, Map<String, Integer>> salesMap = LoadSellerTotal(currentDate.y);

		Map<String, Integer> sellerTotal = new LinkedHashMap<>();
		for (int i = 0; i < invoiceModels.size(); i++) {
			DefaultTableModel model = invoiceModels.get(i);
			String sellerName = paymentComboBoxes.get(i).getSelectedItem() != null
					? paymentComboBoxes.get(i).getSelectedItem().toString()
					: "";
			int total = 0;
			// Write items from this invoice
			for (int row = 0; row < model.getRowCount(); row++) {
				int quantity = model.getValueAt(row, 1) != null ? Integer.parseInt(model.getValueAt(row, 1).toString())
						: 0;
				int price = model.getValueAt(row, 2) != null ? Integer.parseInt(model.getValueAt(row, 2).toString())
						: 0;
				if (quantity == 0 || price == 0) {
					continue;
				}
				total += price * quantity;
			}
			salesMap.putIfAbsent(sellerName, new LinkedHashMap<>());
			salesMap.get(sellerName).put(currentDate.getToday(),
					salesMap.get(sellerName).getOrDefault(currentDate.getToday(), 0) + total);

			sellerTotal.put(sellerName, sellerTotal.getOrDefault(sellerName, 0) + total);
		}

		// Write updated index to file
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(todayFile))) {
			writer.write("ITEM,DATE:QUANTITY");
			writer.newLine();
			for (Map.Entry<String, Map<String, Integer>> entry : salesMap.entrySet()) {
				StringBuilder line = new StringBuilder(entry.getKey());
				if (searchEmp(line.toString())) {
					for (Map.Entry<String, Integer> dateEntry : entry.getValue().entrySet()) {
						line.append(",").append(dateEntry.getKey()).append(":").append(dateEntry.getValue());
					}
					writer.write(line.toString());
					writer.newLine();
				}
			}
		} catch (IOException e) {
			writeError(e);
		}
	}

	/* Calculate the summary for each seller */
	private ArrayList<String> summEmpCalc(String name, int month, int year) {
		ArrayList<String> sumList = new ArrayList<String>();

		int totalS = getSalesOfMonthYear(name, month, year), avgS = avgSales(name, month, year);
		Map.Entry<String, Integer> minS = getMinEntry(name, month, year), maxS = getMaxEntry(name, month, year);
		int rankByTotal = findRankByTotal(name, month, year), rankByAvg = findRankByAvg(name, month, year);
		String perByTotal = getPerSalesOfMonthYear(name, month, year),
				perByAvg = getPerAvgSalesOfMonthYear(name, month, year);

		// best and worst month
		int bestMonth = 1, bestValue = 0, worstMonth = 1, worstValue = 0, bestMonthA = 1, bestValueA = 0,
				worstMonthA = 1, worstValueA = 0;
		Map<Integer, Integer> totalOM = new HashMap<Integer, Integer>(), avgOM = new HashMap<Integer, Integer>(),
				rankMonthsT = new HashMap<Integer, Integer>(), rankMonthsA = new HashMap<Integer, Integer>();
		Map<Integer, String> perMonthT = new HashMap<Integer, String>(), perMonthA = new HashMap<Integer, String>();
		for (int m = 1; m <= currentDate.m; m++) {
			int totalO = getSalesOfMonthYear(name, m, currentDate.y), avgO = avgSales(name, m, currentDate.y);
			if (totalO > 0) {
				bestValue = totalO;
				worstValue = totalO;
				bestMonth = m;
				worstMonth = m;
				bestValueA = avgO;
				worstValueA = avgO;
				bestMonthA = m;
				worstMonthA = m;
				totalOM.put(m, totalO);
				avgOM.put(m, avgO);
				rankMonthsT.put(m, findRankByTotal(name, m, year));
				rankMonthsA.put(m, findRankByAvg(name, m, year));
				perMonthT.put(m, getPerSalesOfMonthYear(name, m, year));
				perMonthA.put(m, getPerAvgSalesOfMonthYear(name, m, year));
			}
		}

		if (totalOM.size() > 1) {
			for (Entry<Integer, Integer> monthT : totalOM.entrySet()) {
				if (bestValue < monthT.getValue()) {
					bestMonth = monthT.getKey();
					bestValue = monthT.getValue();
				}
				if (worstValue > monthT.getValue()) {
					worstMonth = monthT.getKey();
					worstValue = monthT.getValue();
				}
			}
			for (Entry<Integer, Integer> monthT : avgOM.entrySet()) {
				if (bestValueA < monthT.getValue()) {
					bestMonthA = monthT.getKey();
					bestValueA = monthT.getValue();
				}
				if (worstValueA > monthT.getValue()) {
					worstMonthA = monthT.getKey();
					worstValueA = monthT.getValue();
				}
			}
		}
		int IntroRank = findIntroRankDays(name, month, year), IntroRankMonth = findIntroRankMonth(name, year);
		if (totalS > 0) {
			if (language == Language.SPANISH) {
				sumList.add("--- VENTAS ---");
				if (month == -1) {
					sumList.add("LAS VENTAS TOTALES DE " + year + " ES $" + totalS + " (" + perByTotal + " DE TOTAL)");
					sumList.add("LAS VENTAS PROMEDIO DE " + year + " ES $" + avgS + " (" + perByAvg + " DE TOTAL)");
					sumList.add("--- CLASIFICACIÓN ---");
					sumList.add("EL RANKING DE " + year + " SEGÚN EL TOTAL '" + rankByTotal + "' "
							+ rankSymbol(rankByTotal));
					sumList.add("EL RANKING DE " + year + " SEGÚN EL PROMEDIO ES '" + rankByAvg + "' "
							+ rankSymbol(rankByAvg));
					sumList.add(name + " TUVO LAS MAYORES VENTAS " + IntroRank + " DÍA" + (IntroRank > 1 ? "S" : ""));
					sumList.add(name + " TUVO LAS MAYORES VENTAS " + IntroRankMonth + " MES"
							+ (IntroRankMonth > 1 ? "ES" : ""));
					if (totalOM.size() > 1) {
						sumList.add("--- VENTAS TOTAL DE CADA MES ---");
						for (int monthKey : totalOM.keySet()) {
							int i = monthKey - 1;
							sumList.add("LAS VENTAS TOTALES DE " + getMonthForInt(i, 0) + " ES $"
									+ totalOM.getOrDefault(monthKey, 0) + " CORRESPONDIENTE AL "
									+ perMonthT.getOrDefault(monthKey, "") + " DE TOTAL ('"
									+ rankMonthsT.getOrDefault(monthKey, 0) + "' "
									+ rankSymbol(rankMonthsT.getOrDefault(monthKey, 0)) + ")");
						}
						sumList.add("--- VENTAS PROMEDIO DE CADA MES ---");
						for (int monthKey : totalOM.keySet()) {
							int i = monthKey - 1;
							sumList.add("LAS VENTAS PROMEDIO DE " + getMonthForInt(i, 0) + " ES $"
									+ avgOM.getOrDefault(monthKey, 0) + " CORRESPONDIENTE AL "
									+ perMonthA.getOrDefault(monthKey, "") + " DE TOTAL ('"
									+ rankMonthsA.getOrDefault(monthKey, 0) + "' "
									+ rankSymbol(rankMonthsA.getOrDefault(monthKey, 0)) + ")");
						}
					}
					sumList.add("--- PICOS ---");
					sumList.add("EL MÁXIMO VENTA DE " + year + " ES $" + maxS.getValue() + ", OCURRIDO EN "
							+ dayName(maxS.getKey(), 0) + " " + maxS.getKey());
					sumList.add("EL MÍNIMO VENTA DE " + year + " ES $" + minS.getValue() + ", OCURRIDO EN "
							+ dayName(minS.getKey(), 0) + " " + minS.getKey());
					if (totalOM.size() > 1) {
						sumList.add("EL MÁXIMO MES SEGÚN EL TOTAL DE " + year + " ES $" + bestValue + ", OCURRIDO EN "
								+ getMonthForInt(bestMonth - 1, 0));
						sumList.add("EL MÍNIMO MES SEGÚN EL TOTAL DE " + year + " ES $" + worstValue + ", OCURRIDO EN "
								+ getMonthForInt(worstMonth - 1, 0));
						sumList.add("EL MÁXIMO MES SEGÚN EL PROMDEIO DE " + year + " ES $" + bestValueA
								+ ", OCURRIDO EN " + getMonthForInt(bestMonthA - 1, 0));
						sumList.add("EL MÍNIMO MES SEGÚN EL PROMDEIO DE " + year + " ES $" + worstValueA
								+ ", OCURRIDO EN " + getMonthForInt(worstMonthA - 1, 0));
					}
				} else {
					sumList.add("LAS VENTAS TOTALES DE " + getMonthForInt(month - 1, 0) + " ES $" + totalS + " ("
							+ perByTotal + " DE TOTAL)");
					sumList.add("LAS VENTAS PROMEDIO DE " + getMonthForInt(month - 1, 0) + " ES $" + avgS + " ("
							+ perByAvg + " DE TOTAL)");
					sumList.add("--- CLASIFICACIÓN ---");
					sumList.add("EL RANKING DE " + getMonthForInt(month - 1, 0) + " SEGÚN EL TOTAL ES '" + rankByTotal
							+ "' " + rankSymbol(rankByTotal));
					sumList.add("EL RANKING DE " + getMonthForInt(month - 1, 0) + " SEGÚN EL PROMDEIO ES '" + rankByAvg
							+ "' " + rankSymbol(rankByAvg));
					sumList.add(name + " TUVO LAS MAYORES VENTAS " + IntroRank + " DÍA" + (IntroRank > 1 ? "S" : ""));
					sumList.add("--- PICOS ---");
					sumList.add("EL MÁXIMO VENTA DE " + getMonthForInt(month - 1, 0) + " ES $" + maxS.getValue()
							+ ", OCURRIDO EN " + dayName(maxS.getKey(), 0) + " " + maxS.getKey());
					sumList.add("EL MÍNIMO VENTA DE " + getMonthForInt(month - 1, 0) + " ES $" + minS.getValue()
							+ ", OCURRIDO EN " + dayName(minS.getKey(), 0) + " " + minS.getKey());
				}
			} else if (language == Language.PORTUGUES) {
				sumList.add("--- VENTAS ---");
				if (month == -1) {
					sumList.add("O TOTAL DE VENDAS DE " + year + " É ES $" + totalS + " (" + perByTotal + " DE TOTAL)");
					sumList.add("O MÉDIO DE VENDAS DE " + year + " É ES $" + avgS + " (" + perByAvg + " DE TOTAL)");
					sumList.add("--- CLASIFICACIÓN ---");
					sumList.add("A CLASSIFICAÇÃO DE " + year + " DE ACORDO COM O TOTAL É '" + rankByTotal + "' "
							+ rankSymbol(rankByTotal));
					sumList.add("A CLASSIFICAÇÃO DE " + year + " DE ACORDO COM O MÉDIO É  '" + rankByAvg + "' "
							+ rankSymbol(rankByAvg));
					sumList.add(name + " TEVE AS MAIORES VENDAS " + IntroRank + " DIA" + (IntroRank > 1 ? "S" : ""));
					sumList.add(name + " TEVE AS MAIORES VENDAS " + IntroRankMonth + " MÊS"
							+ (IntroRankMonth > 1 ? "ES" : ""));
					if (totalOM.size() > 1) {
						sumList.add("--- VENDAS TOTAL DO CADA MÊS ---");
						for (int monthKey : totalOM.keySet()) {
							int i = monthKey - 1;
							sumList.add("O TOTAL DE VENDAS DE " + getMonthForInt(i, 1) + " É $"
									+ totalOM.getOrDefault(monthKey, 0) + " CORRESPONDENTE A "
									+ perMonthT.getOrDefault(monthKey, "") + " DO TOTAL ('"
									+ rankMonthsT.getOrDefault(monthKey, 0) + "' "
									+ rankSymbol(rankMonthsT.getOrDefault(monthKey, 0)) + ")");
						}
						sumList.add("--- VENDAS MÉDIO DE CADA MÊS ---");
						for (int monthKey : totalOM.keySet()) {
							int i = monthKey - 1;
							sumList.add("O MÉDIO DE VENDAS DE " + getMonthForInt(i, 1) + " É $"
									+ avgOM.getOrDefault(monthKey, 0) + " CORRESPONDENTE A "
									+ perMonthA.getOrDefault(monthKey, "") + " DO TOTAL ('"
									+ rankMonthsA.getOrDefault(monthKey, 0) + "' "
									+ rankSymbol(rankMonthsA.getOrDefault(monthKey, 0)) + ")");
						}
					}
					sumList.add("--- PICOS ---");
					sumList.add("O MÁXIMO VENDA DE " + year + " É $" + maxS.getValue() + ", OCORREU EM "
							+ dayName(maxS.getKey(), 1) + " " + maxS.getKey());
					sumList.add("O MÍNIMO VENDA DE " + year + " É $" + minS.getValue() + ", OCORREU EM "
							+ dayName(minS.getKey(), 1) + " " + minS.getKey());
					if (totalOM.size() > 1) {
						sumList.add("O MÁXIMO MÊS DE ACORDO COM O TOTAL DE " + year + " É $" + bestValue
								+ ", OCORREU EM " + getMonthForInt(bestMonth - 1, 1));
						sumList.add("EL MÍNIMO MÊS DE ACORDO COM O TOTAL DE " + year + " É $" + worstValue
								+ ", OCORREU EM " + getMonthForInt(worstMonth - 1, 1));
						sumList.add("O MÁXIMO MÊS DE ACORDO COM O MÉDIO DE " + year + " É $" + bestValueA
								+ ", OCORREU EM " + getMonthForInt(bestMonthA - 1, 1));
						sumList.add("EL MÍNIMO MÊS DE ACORDO COM O MÉDIO DE " + year + " É $" + worstValueA
								+ ", OCORREU EM " + getMonthForInt(worstMonthA - 1, 1));
					}
				} else {
					sumList.add("O TOTAL DE VENDAS DE " + getMonthForInt(month - 1, 1) + " É $" + totalS + " ("
							+ perByTotal + " DE TOTAL)");
					sumList.add("O MÉDIO DE VENDAS DE " + getMonthForInt(month - 1, 1) + " É $" + avgS + " (" + perByAvg
							+ " DE TOTAL)");
					sumList.add("--- CLASIFICACIÓN ---");
					sumList.add("A CLASSIFICAÇÃO DE " + getMonthForInt(month - 1, 1) + " DE ACORDO COM O TOTAL É '"
							+ rankByTotal + "' " + rankSymbol(rankByTotal));
					sumList.add("A CLASSIFICAÇÃO DE " + getMonthForInt(month - 1, 1) + " DE ACORDO COM O MÉDIO É '"
							+ rankByAvg + "' " + rankSymbol(rankByAvg));
					sumList.add(name + " TEVE AS MAIORES VENDAS " + IntroRank + " DIA" + (IntroRank > 1 ? "S" : ""));
					sumList.add("--- PICOS ---");
					sumList.add("O MÁXIMO VENDA DE " + getMonthForInt(month - 1, 1) + " É $" + maxS.getValue()
							+ ", OCORREU EM " + dayName(maxS.getKey(), 1) + " " + maxS.getKey());
					sumList.add("O MÍNIMO VENDA DE " + getMonthForInt(month - 1, 1) + " ÉS $" + minS.getValue()
							+ ", OCORREU EM " + dayName(minS.getKey(), 1) + " " + minS.getKey());
				}
			} else if (language == Language.ENGLISH) {
				sumList.add("--- SALES ---");
				if (month == -1) {
					sumList.add("TOTAL SALES OF " + year + " IS $" + totalS + " (" + perByTotal + " OF THE TOTAL)");
					sumList.add("THE AVERAGE OF " + year + " SALES ARE $" + avgS + " (" + perByAvg + " OF THE TOTAL)");
					sumList.add("--- CLASSIFICATION ---");
					sumList.add(year + "'S RANKING ACCORDING TO THE TOTAL IS '" + rankByTotal + "' "
							+ rankSymbol(rankByTotal));
					sumList.add(year + "'S RANKING ACCORDING TO THE AVERAGE IS '" + rankByAvg + "' "
							+ rankSymbol(rankByAvg));
					sumList.add(name + " HAD THE HIGHEST SALES " + IntroRank + " DAY" + (IntroRank > 1 ? "S" : ""));
					sumList.add(name + " HAD THE HIGHEST SALES " + IntroRankMonth + " MONTH"
							+ (IntroRankMonth > 1 ? "S" : ""));
					if (totalOM.size() > 1) {
						sumList.add("--- TOTAL SALES OF MONTHS ---");
						for (int monthKey : totalOM.keySet()) {
							int i = monthKey - 1;
							sumList.add("TOTAL SALES OF " + getMonthForInt(i, 2) + " IS $"
									+ totalOM.getOrDefault(monthKey, 0) + " CORRESPONDENT TO "
									+ perMonthT.getOrDefault(monthKey, "") + " OF THE TOTAL ('"
									+ rankMonthsT.getOrDefault(monthKey, 0) + "' "
									+ rankSymbol(rankMonthsT.getOrDefault(monthKey, 0)) + ")");
						}
						sumList.add("--- AVERAGE OF MONTHS ---");
						for (int monthKey : totalOM.keySet()) {
							int i = monthKey - 1;
							sumList.add("THE AVERAGE OF " + getMonthForInt(i, 2) + " SALES IS $"
									+ avgOM.getOrDefault(monthKey, 0) + " CORRESPONDENT TO "
									+ perMonthA.getOrDefault(monthKey, "") + " OF THE TOTAL ('"
									+ rankMonthsA.getOrDefault(monthKey, 0) + "' "
									+ rankSymbol(rankMonthsA.getOrDefault(monthKey, 0)) + ")");
						}
					}
					sumList.add("--- PEAKS ---");
					sumList.add(year + "'S MAXIMUM SALE IS $" + maxS.getValue() + ", OCCURRED IN "
							+ dayName(maxS.getKey(), 2) + " " + maxS.getKey());
					sumList.add(year + "'S MINIMUM SALE IS $" + minS.getValue() + ", OCCURRED IN "
							+ dayName(minS.getKey(), 2) + " " + minS.getKey());
					if (totalOM.size() > 1) {
						sumList.add(year + "'S MAXIMUM MONTH ACCORDING TO THE TOTAL IS $" + bestValue + ", OCCURRED IN "
								+ getMonthForInt(bestMonth - 1, 2));
						sumList.add(year + "'S MINIMUM MONTH ACCORDING TO THE TOTAL IS $" + worstValue
								+ ", OCCURRED IN " + getMonthForInt(worstMonth - 1, 2));
						sumList.add(year + "'S MAXIMUM MONTH ACCORDING TO THE AVERAGE IS $" + bestValueA
								+ ", OCCURRED IN " + getMonthForInt(bestMonthA - 1, 2));
						sumList.add(year + "'S MINIMUM MONTH ACCORDING TO THE AVERAGE IS $" + worstValueA
								+ ", OCCURRED IN " + getMonthForInt(worstMonthA - 1, 2));
					}
				} else {
					sumList.add("TOTAL SALES OF " + getMonthForInt(month - 1, 2) + " IS $" + totalS + " (" + perByTotal
							+ " OF THE TOTAL)");
					sumList.add(getMonthForInt(month - 1, 2) + "'S AVERAGE SALES ARE $" + avgS + " (" + perByAvg
							+ " OF THE TOTAL)");
					sumList.add("--- CLASSIFICATION ---");
					sumList.add(getMonthForInt(month - 1, 2) + "'S RANKING ACCORDING TO THE TOTAL IS '" + rankByTotal
							+ "' " + rankSymbol(rankByTotal));
					sumList.add(getMonthForInt(month - 1, 2) + "'S RANKING ACCORDING TO THE AVERAGE IS '" + rankByAvg
							+ "' " + rankSymbol(rankByAvg));
					sumList.add(name + " HAD THE HIGHEST SALES " + IntroRank + " DAY" + (IntroRank > 1 ? "S" : ""));
					sumList.add("--- PEAKS ---");
					sumList.add(getMonthForInt(month - 1, 2) + "'S MAXIMUM SALE IS $" + maxS.getValue()
							+ ", OCCURRED IN " + dayName(maxS.getKey(), 2) + " " + maxS.getKey());
					sumList.add(getMonthForInt(month - 1, 2) + "'S MINIMUM SALE IS $" + minS.getValue()
							+ ", OCCURRED IN " + dayName(minS.getKey(), 2) + " " + minS.getKey());
				}
			} else {
				sumList.add("--- VENTES ---");
				if (month == -1) {
					sumList.add(
							"LES VENTES TOTALES DE " + year + " SONT $" + totalS + " (" + perByTotal + " DE TOTAL)");
					sumList.add("LES VENTES MOYENNES DE " + year + " SONT $" + avgS + " (" + perByAvg + " DE TOTAL)");
					sumList.add("--- CLASSIFICATION ---");
					sumList.add("LE CLASSEMENT DE " + year + " SELON LE TOTAL EST '" + rankByTotal + "' "
							+ rankSymbol(rankByTotal));
					sumList.add("LE CLASSEMENT DE " + year + " SELON LA MOYENNE EST '" + rankByAvg + "' "
							+ rankSymbol(rankByAvg));
					sumList.add(name + " A RÉALISÉ LES VENTES LES PLUS ÉLEVÉES EN " + IntroRank + " JOUR"
							+ (IntroRank > 1 ? "S" : ""));
					sumList.add(name + " A RÉALISÉ LES VENTES LES PLUS ÉLEVÉES EN " + IntroRankMonth + " MOIS");
					if (totalOM.size() > 1) {
						sumList.add("--- VENTES DE MOIS ---");
						for (int monthKey : totalOM.keySet()) {
							int i = monthKey - 1;
							sumList.add("LES VENTES TOTALES DE " + getMonthForInt(i, 3) + " SONT $"
									+ totalOM.getOrDefault(monthKey, 0) + " CORRESPONDANT À "
									+ perMonthT.getOrDefault(monthKey, "") + " DU TOTAL ('"
									+ rankMonthsT.getOrDefault(monthKey, 0) + "' "
									+ rankSymbol(rankMonthsT.getOrDefault(monthKey, 0)) + ")");
						}
						for (int monthKey : totalOM.keySet()) {
							int i = monthKey - 1;
							sumList.add("LES VENTES MOYENNES DE " + getMonthForInt(i, 3) + " SONT $"
									+ avgOM.getOrDefault(monthKey, 0) + " CORRESPONDANT À "
									+ perMonthT.getOrDefault(monthKey, "") + " DU TOTAL ('"
									+ rankMonthsT.getOrDefault(monthKey, 0) + "' "
									+ rankSymbol(rankMonthsT.getOrDefault(monthKey, 0)) + ")");
						}
					}
					sumList.add("--- LES PICS ---");
					sumList.add("LE MAXIMUM VENTE DE " + year + " EST $" + maxS.getValue() + ", SURVENU À "
							+ dayName(maxS.getKey(), 3) + " " + maxS.getKey());
					sumList.add("LE MINIMUM VENTE DE " + year + " EST $" + minS.getValue() + ", SURVENU À "
							+ dayName(minS.getKey(), 3) + " " + minS.getKey());
					if (totalOM.size() > 1) {
						sumList.add("LE MAXIMUM MOIS SELON LE TOTAL DE " + year + " EST $" + bestValue + ", SURVENU À "
								+ getMonthForInt(bestMonth - 1, 3));
						sumList.add("LE MINIMUM MOIS SELON LE TOTAL DE " + year + " EST $" + worstValue + ", SURVENU À "
								+ getMonthForInt(worstMonth - 1, 3));
						sumList.add("LE MAXIMUM MOIS SELON LA MOYENNE DE " + year + " EST $" + bestValueA
								+ ", SURVENU À " + getMonthForInt(bestMonthA - 1, 3));
						sumList.add("LE MINIMUM MOIS SELON LA MOYENNE DE " + year + " EST $" + worstValueA
								+ ", SURVENU À " + getMonthForInt(worstMonthA - 1, 3));
					} else {
						sumList.add("LE TOTAL DES VENTES " + getMonthForInt(month - 1, 3) + " SONT $" + totalS + " ("
								+ perByTotal + " DE TOTAL)");
						sumList.add("LES VENTES MOYENNES DE " + getMonthForInt(month - 1, 3) + " SONT $" + avgS + " ("
								+ perByAvg + " DE TOTAL)");
						sumList.add("--- CLASSIFICATION ---");
						sumList.add("LE CLASSEMENT DE " + getMonthForInt(month - 1, 3) + " SELON LE TOTAL EST '"
								+ rankByTotal + "' " + rankSymbol(rankByTotal));
						sumList.add("LE CLASSEMENT DE " + getMonthForInt(month - 1, 2) + " SELON LA MOYENNE EST '"
								+ rankByAvg + "' " + rankSymbol(rankByAvg));
						sumList.add(name + " A RÉALISÉ LES VENTES LES PLUS ÉLEVÉES EN " + IntroRank + " JOUR"
								+ (IntroRank > 1 ? "S" : ""));
						sumList.add("--- LES PICS ---");
						sumList.add("LE MAXIMUM VENTE DE " + getMonthForInt(month - 1, 2) + " EST $" + maxS.getValue()
								+ ", SURVENU À " + dayName(maxS.getKey(), 3) + " " + maxS.getKey());
						sumList.add("LE MINIMUM VENTE DE " + getMonthForInt(month - 1, 2) + " EST $" + minS.getValue()
								+ ", SURVENU À " + dayName(minS.getKey(), 3) + " " + minS.getKey());
					}
				}
			}
		}
		return sumList;
	}

	/* Create the panel for each one */
	private JPanel empSummPanel(String name, int month, int year, ArrayList<String> sumList) {
		JPanel panel = new JPanel(new BorderLayout());

		// Content List
		DefaultListModel<String> model = new DefaultListModel<>();
		sumList.forEach(model::addElement);
		JList<String> empList = new JList<>(model);
		empList.setCellRenderer(new EmployeeRender());
		empList.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		empList.setBackground(bg);

		JScrollPane scrollPane = new JScrollPane(empList);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		panel.add(scrollPane, BorderLayout.CENTER);

		// Close tab button
		JPanel tabHeader = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		tabHeader.setOpaque(false);

		return panel;
	}

	/* Summary for sellers */
	private void summaryEmployee(int month, int year) {
		JDialog sellerSumDialog = new JDialog(this, "", true);
		sellerSumDialog.setDefaultCloseOperation(HIDE_ON_CLOSE);
		sellerSumDialog.setUndecorated(true);
		sellerSumDialog.setSize(getWidth() / 2, getHeight() / 2);
		sellerSumDialog.setLocationRelativeTo(this);
		sellerSumDialog.setLayout(new BorderLayout());
		sellerSumDialog
				.setIconImage(colorSelected == 2 ? ImageEffect.getScaledImage(effect2I.getImage(), 35, 35).getImage()
						: ImageEffect.invertColor(ImageEffect.getScaledImage(effect2I.getImage(), 35, 35)).getImage());
		sellerSumDialog.setShape(new RoundRectangle2D.Double(0, 0, getWidth() / 2, getHeight() / 2, 20, 20));

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
				g2d.setStroke(new BasicStroke(2));
				g2d.drawRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 20, 20); // Draw border with small padding
			}
		};
		contentPane.setLayout(new BorderLayout());
		contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		sellerSumDialog.setContentPane(contentPane);

		// Title
		String title = getLocalizedMessage("SUMMARY") + " " + getLocalizedMessage("OF") + " ("
				+ (month == -1 ? year : getMonthForInt(month - 1, langIndex)) + ")";
		JLabel titleLabel = new JLabel(title);
		titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		titleLabel.setForeground(fg);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		// Close Button
		JButton closeButton = new JButton(ImageEffect.getScaledImage(closeImage.getImage(), 15, 15));
		closeButton.setBorderPainted(false);
		closeButton.setToolTipText(getLocalizedMessage("EXIT"));
		closeButton.setFocusPainted(false);
		closeButton.setContentAreaFilled(false);
		closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		closeButton.addActionListener(_ -> sellerSumDialog.dispose());
		JPanel northPanel = new JPanel(new BorderLayout());
		northPanel.setOpaque(false);
		northPanel.add(titleLabel, BorderLayout.CENTER);
		northPanel.add(closeButton, BorderLayout.EAST);
		northPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 15, 0));
		contentPane.add(northPanel, BorderLayout.NORTH);

		// List
		tabbedPane = new ModernTabbedPane();
		tabbedPane.setBackground(bg);
		tabbedPane.setBorder(BorderFactory.createEmptyBorder(10, 5, 0, 5));

		boolean isVoid = true;
		for (Employee emp : employee) {
			String name = emp.getName();
			ArrayList<String> sumList = summEmpCalc(name, month, year);
			JPanel summaryPanel = empSummPanel(name, month, year, sumList);
			if (sumList.size() > 0) {
				isVoid = false;
				tabbedPane.addTab(name, summaryPanel);
				summaryPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
			}
		}
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		if (isVoid) {
			Toast.show(this, Toast.Type.INFO, getLocalizedMessage("NO_DATA"), Intro.notOption);
			sellerSumDialog.dispose();
		} else {
			sellerSumDialog.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
						sellerSumDialog.dispose();
				}
			});
			sellerSumDialog.setFocusable(true);
			sellerSumDialog.requestFocusInWindow();
			sellerSumDialog.setVisible(true);
		}
	}

	/* return total of month/year */
	private int getSalesOfMonthYear(String sellerName, int month, int year) {
		Map<String, Integer> sales = getSellerSalesAccDate(sellerName, month, year);
		int total = 0;
		for (Map.Entry<String, Integer> entry : sales.entrySet()) {
			total += entry.getValue();
		}
		return total;
	}

	/* return percentage of sales */
	private String getPerSalesOfMonthYear(String sellerName, int month, int year) {
		int sales = getSalesOfMonthYear(sellerName, month, year);
		int total = 0;
		for (Employee emp : employee)
			total += getSalesOfMonthYear(emp.getName(), month, year);

		double percent = total > 0 ? 100.0 * sales / total : 0;
		return String.format("%.1f%%", percent);
	}

	// Return tha average of sales for employee acc to month year
	private int avgSales(String employee, int month, int year) {
		int total = 0, days = 0;
		Map<String, Integer> sales = getSellerSalesAccDate(employee, month, year);
		days = sales.size();
		for (Map.Entry<String, Integer> entry : sales.entrySet()) {
			total += entry.getValue();
		}
		return days > 0 ? total / days : 0;
	}

	/* return percentage of sales */
	private String getPerAvgSalesOfMonthYear(String sellerName, int month, int year) {
		int sales = avgSales(sellerName, month, year);
		int total = 0;
		for (Employee emp : employee)
			total += avgSales(emp.getName(), month, year);

		double percent = total > 0 ? 100.0 * sales / total : 0;
		return String.format("%.1f%%", percent);
	}

	/* return max of month/year */
	private Map.Entry<String, Integer> getMaxEntry(String name, int month, int year) {
		Map<String, Integer> sales = getSellerSalesAccDate(name, month, year);
		return sales.entrySet().stream().max(Map.Entry.comparingByValue()).orElse(null);
	}

	/* return min of month/year */
	private Map.Entry<String, Integer> getMinEntry(String name, int month, int year) {
		Map<String, Integer> sales = getSellerSalesAccDate(name, month, year);
		return sales.entrySet().stream().min(Map.Entry.comparingByValue()).orElse(null);
	}

	// Find ranking by total
	private int findRankByTotal(String name, int month, int year) {
		Map<String, Integer> sortedMap = new HashMap<String, Integer>();
		for (int i = 0; i < employee.size(); i++) {
			String empName = employee.get(i).getName();
			int totalMonth = getSalesOfMonthYear(empName, month, year);
			if (totalMonth > 0)
				sortedMap.put(empName, totalMonth);
		}
		if (!sortedMap.containsKey(name))
			return -1; // Return -1 if name is not found

		int targetValue = sortedMap.get(name);

		// Count how many values are greater than the target value
		long rank = sortedMap.values().stream().filter(value -> value > targetValue).count();

		return (int) rank + 1; // Rank starts from 1
	}

	// Find Intro ranking by days
	private int findIntroRankDays(String name, int month, int year) {
		Map<String, Map<String, Integer>> salesData = LoadSellerTotal(year);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate startDate, lastDate;
		if (month == -1) {
			startDate = LocalDate.of(year, 1, 1);
			lastDate = LocalDate.of(year, 12, 31);
		} else {
			startDate = LocalDate.of(year, month, 1);
			DateModified date = new DateModified(1, month, year);
			lastDate = LocalDate.of(year, month, date.maxDays());
		}
		Map<String, Integer> dailyMaxSales = new HashMap<>();

		// Find the maximum sales for each day across all sellers
		for (Map<String, Integer> sellerSales : salesData.values()) {
			for (Map.Entry<String, Integer> entry : sellerSales.entrySet()) {
				String date = entry.getKey();
				LocalDate dateS = LocalDate.parse(date, formatter);
				int sales = entry.getValue();
				if (!dateS.isBefore(startDate) && !dateS.isAfter(lastDate))
					dailyMaxSales.put(date, Math.max(dailyMaxSales.getOrDefault(date, 0), sales));
			}
		}

		// Count how many times the target seller reached the daily max
		int count = 0;
		if (salesData.containsKey(name)) {
			for (Map.Entry<String, Integer> entry : salesData.get(name).entrySet()) {
				String date = entry.getKey();
				int sales = entry.getValue();
				Integer maxSales = dailyMaxSales.get(date);
				if (maxSales != null && sales == maxSales) {
					count++;
				}
			}
		}

		return count;
	}

	// Find Intro ranking by days
	private int findIntroRankMonth(String name, int year) {
		Map<String, Map<String, Integer>> salesData = LoadSellerTotal(year);
		Map<String, Map<String, Integer>> monthlySales = new HashMap<>();

		// Find the maximum sales for each day across all sellers
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		for (Map.Entry<String, Map<String, Integer>> sellerEntry : salesData.entrySet()) {
			String seller = sellerEntry.getKey();
			for (Map.Entry<String, Integer> entry : sellerEntry.getValue().entrySet()) {
				Date saleDate;
				try {
					saleDate = dateFormat.parse(entry.getKey());
					String monthKey = new SimpleDateFormat("MM/yyyy").format(saleDate);

					monthlySales.putIfAbsent(monthKey, new HashMap<>());
					monthlySales.get(monthKey).put(seller,
							monthlySales.get(monthKey).getOrDefault(seller, 0) + entry.getValue());
				} catch (ParseException e) {
				}
			}
		}

		// Count how many times the target seller reached the daily max
		int count = 0;
		for (Map.Entry<String, Map<String, Integer>> monthEntry : monthlySales.entrySet()) {
			Map<String, Integer> sellerTotals = monthEntry.getValue();

			// Determine the highest total sales for the month
			int maxSales = Collections.max(sellerTotals.values());

			// Check if the target seller had the highest sales that month
			if (sellerTotals.getOrDefault(name, 0) == maxSales)
				count++;
		}

		return count;
	}

	// Find ranking by average
	private int findRankByAvg(String name, int month, int year) {
		Map<String, Integer> sortedMap = new HashMap<String, Integer>();
		for (int i = 0; i < employee.size(); i++) {
			String empName = employee.get(i).getName();
			int totalMonth = avgSales(empName, month, year);
			if (totalMonth > 0)
				sortedMap.put(empName, totalMonth);
		}
		if (!sortedMap.containsKey(name))
			return -1; // Return -1 if name is not found

		int targetValue = sortedMap.get(name);

		// Count how many values are greater than the target value
		long rank = sortedMap.values().stream().filter(value -> value > targetValue).count();

		return (int) rank + 1; // Rank starts from 1
	}

	// return the rank
	private String rankSymbol(int rank) {
		switch (rank) {
		case 1: {
			return "🥇";
		}
		case 2:
			return "🥈";
		default:
			return "🥉";
		}
	}
	/* EMPLOYEE END */

	/* Save the graph acc to chart and file */
	private void saveGraph(JFreeChart chart, File file) {
		try {
			ChartUtils.saveChartAsPNG(file, chart, 1920, 1080);
		} catch (IOException e) {
			writeError(e);
		}
	}

	/* Save the chat as extension */
	private void saveChartByExt(JFreeChart chart, String extension) {
		JnaFileChooser fileChooser = new JnaFileChooser();
		fileChooser.setCurrentDirectory(currentpath);
		fileChooser.setTitle("SAVE AS " + extension.toUpperCase());
		fileChooser.setDefaultFileName("Graphic");
		fileChooser.addFilter("Files", extension);
		if (fileChooser.showSaveDialog(this)) {
			File chartFile = fileChooser.getSelectedFile();
			if (!chartFile.getAbsolutePath().endsWith("." + extension)) {
				chartFile = new File(chartFile + "." + extension);
			}
			try {
				switch (extension) {
				case "png":
					ExportUtils.writeAsPNG(chart, 1920, 1080, chartFile);
					break;
				case "pdf":
					ExportUtils.writeAsPDF(chart, 1920, 1080, chartFile);
					break;
				case "svg":
					ExportUtils.writeAsSVG(chart, 1920, 1080, chartFile);
					break;
				}
				Toast.show(this, Toast.Type.SUCCESS, getLocalizedMessage("SAVE_A"), Intro.notOption);
			} catch (Exception e) {
				writeError(e);
			}
		}
	}

	/* BILLS START */
	/* Method to display the reminder panel */
	private void viewBillDialog() {
		billsAdd();
		JDialog reminderDialog = new JDialog(this, getLocalizedMessage("BILLS"), true);
		reminderDialog.setSize(getWidth() / 2, getHeight() / 2);
		reminderDialog.setLayout(new BorderLayout());
		reminderDialog
				.setIconImage(colorSelected == 2 ? ImageEffect.getScaledImage(reminderI.getImage(), 35, 35).getImage()
						: ImageEffect.invertColor(ImageEffect.getScaledImage(reminderI.getImage(), 35, 35)).getImage());
		reminderDialog.setBackground(bg);
		reminderDialog.setLocationRelativeTo(this);
		overlay.showOverlay();

		// Create daily, weekly, and monthly tables dynamically
		JTable dailyTable = createBillTable(filterBillsByCategory(bills, "daily"));
		JTable weeklyTable = createBillTable(filterBillsByCategory(bills, "weekly"));
		JTable monthlyTable = createBillTable(filterBillsByCategory(bills, "monthly"));

		// Center the text in the JTable
		centerTableText(dailyTable);
		centerTableText(weeklyTable);
		centerTableText(monthlyTable);

		// Add each table to its respective tab
		tabbedPane.removeAll();
		tabbedPane.add(getLocalizedMessage("TODAY"), new JScrollPane(dailyTable));
		tabbedPane.add(getLocalizedMessage("THIS") + " " + getLocalizedMessage("WEEK"), new JScrollPane(weeklyTable));
		tabbedPane.add(getLocalizedMessage("THIS") + " " + getLocalizedMessage("MONTH"), new JScrollPane(monthlyTable));

		reminderDialog.add(tabbedPane, BorderLayout.CENTER);

		// Key listener for ESC key to close the dialog
		InputMap inputMap = reminderDialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap = reminderDialog.getRootPane().getActionMap();
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "closeDialog");
		actionMap.put("closeDialog", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				reminderDialog.dispose();
				overlay.hideOverlay();
			}
		});
		reminderDialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				overlay.hideOverlay();
			}
		});

		// Menubar
		JMenuBar mb = new JMenuBar();
		JMenu file = new JMenu(getLocalizedMessage("FILE"));
		JMenuItem exit = new JMenuItem(getLocalizedMessage("EXIT"));
		JMenuItem toggleClickCopy = new JMenuItem("⚪ " + getLocalizedMessage("COPY"));
		// Add the toggle action
		toggleClickCopy.addActionListener(_ -> {
			isClickCopyEnabled = !isClickCopyEnabled; // Toggle the state
			toggleClickCopy.setText(
					isClickCopyEnabled ? "✖ " + getLocalizedMessage("COPY") : "⚪ " + getLocalizedMessage("COPY"));
		});
		exit.addActionListener(_ -> {
			overlay.hideOverlay();
			reminderDialog.dispose();
		});
		file.add(toggleClickCopy);
		file.add(exit);
		mb.add(file);
		reminderDialog.setJMenuBar(mb);

		// Make the dialog focusable so it can capture key events
		reminderDialog.setFocusable(true);
		reminderDialog.requestFocusInWindow();

		// Display the reminder dialog
		reminderDialog.setVisible(true);
	}

	/* Method to create a table from a list of bills */
	private JTable createBillTable(List<RecurringBill> bills) {
		String[] columns = { "Descripción", "Fecha" }; // Swapped the order of columns
		String[][] data = new String[bills.size()][2];

		columns[0] = getLocalizedMessage("DESC");
		columns[1] = getLocalizedMessage("DATE");

		// Populate the table data with bill info
		for (int i = 0; i < bills.size(); i++) {
			RecurringBill bill = bills.get(i);
			data[i][0] = bill.getDescription();
			data[i][1] = formatDateWithDay(bill.getNextDueDate());
		}

		// Create a table model that prevents editing
		DefaultTableModel model = new DefaultTableModel(data, columns) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // Disable editing for all cells
			}
		};
		JTable table = new JTable(model);
		table.setFont(new Font("Arial", Font.PLAIN, 16));
		table.setRowHeight(30);
		table.setShowGrid(true);
		table.setIntercellSpacing(new Dimension(0, 0));

		// Customize the table header
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Arial", Font.BOLD, 18));
		header.setBackground(new Color(220, 220, 220)); // Light gray background for header
		header.setForeground(Color.DARK_GRAY); // Dark gray text for header
		header.setReorderingAllowed(false); // Prevent column reordering
		header.setResizingAllowed(false); // Prevent column resizing

		// Add MouseListener to the table
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (isClickCopyEnabled && e.getClickCount() == 2) {

					// Get selected row and column
					int row = table.rowAtPoint(e.getPoint());
					int column = table.columnAtPoint(e.getPoint());

					// Check if a valid cell is clicked
					if (row >= 0 && column == 0) {
						// Get the value of the clicked cell
						Object cellValue = table.getValueAt(row, column);
						if (cellValue != null) {
							// Copy value to clipboard
							StringSelection selection = new StringSelection(cellValue.toString());
							Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
							Toast.show(Main.this, Toast.Type.SUCCESS, getLocalizedMessage("COPY_S"), Intro.notOption);
						}
					}
				}
			}
		});
		return table;
	}

	/* Add bills */
	private void billsAdd() {
		bills.clear();
		File extraF = new File(dataFolder + "\\extra");
		extraF.mkdir();
		File todayFile = new File(extraF, "bills.csv");
		if (todayFile.exists()) {
			try (BufferedReader reader = new BufferedReader(new FileReader(todayFile))) {
				String line;
				boolean IntroLine = true; // Skip the header line
				while ((line = reader.readLine()) != null) {
					if (IntroLine) {
						IntroLine = false;
						continue;
					}
					String[] parts = line.split(",");
					if (TextEffect.isInteger(parts[2]))
						if (parts[1].equalsIgnoreCase("m"))
							bills.add(new RecurringBill(parts[0], LocalDate.now(), RecurrenceType.MONTHLY,
									Integer.valueOf(parts[2]), null));
						else
							switch (Integer.valueOf(parts[2])) {
							case 1:
								bills.add(new RecurringBill(parts[0], LocalDate.now(), RecurrenceType.WEEKLY, -1,
										DayOfWeek.MONDAY));
								break;
							case 2:
								bills.add(new RecurringBill(parts[0], LocalDate.now(), RecurrenceType.WEEKLY, -1,
										DayOfWeek.TUESDAY));
								break;
							case 3:
								bills.add(new RecurringBill(parts[0], LocalDate.now(), RecurrenceType.WEEKLY, -1,
										DayOfWeek.WEDNESDAY));
								break;
							case 4:
								bills.add(new RecurringBill(parts[0], LocalDate.now(), RecurrenceType.WEEKLY, -1,
										DayOfWeek.THURSDAY));
								break;
							case 5:
								bills.add(new RecurringBill(parts[0], LocalDate.now(), RecurrenceType.WEEKLY, -1,
										DayOfWeek.FRIDAY));
								break;
							case 6:
								bills.add(new RecurringBill(parts[0], LocalDate.now(), RecurrenceType.WEEKLY, -1,
										DayOfWeek.SATURDAY));
								break;
							case 7:
								bills.add(new RecurringBill(parts[0], LocalDate.now(), RecurrenceType.WEEKLY, -1,
										DayOfWeek.SUNDAY));
								break;
							default:
								break;
							}
				}
			} catch (IOException e) {
				writeError(e);
			}
		}
	}

	/* Change bills */
	private void billsChange() {
		billsAdd();
		// Create a dialog for the table
		JDialog dialog = new JDialog(this, getLocalizedMessage("BILLS"), true);
		dialog.setSize(getWidth() / 2, getHeight() / 2);
		dialog.setLocationRelativeTo(this);
		overlay.showOverlay();

		// Create the tabbed pane
		tabbedPane = new ModernTabbedPane();

		// Weekly Bills Table Model
		DefaultTableModel weeklyTableModel = new DefaultTableModel(new String[] { getLocalizedMessage("BILLS"),
				getLocalizedMessage("WEEKLY"), getLocalizedMessage("DELETE") }, 0);

		// Monthly Bills Table Model
		DefaultTableModel monthlyTableModel = new DefaultTableModel(new String[] { getLocalizedMessage("BILLS"),
				getLocalizedMessage("MONTHLY"), getLocalizedMessage("DELETE") }, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return true;
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				// Specify column types
				switch (columnIndex) {
				case 1: // DAY
					return Integer.class; // Numeric columns
				default:
					return String.class; // Default to String
				}
			}
		};

		File extraF = new File(dataFolder + "\\extra");
		extraF.mkdir();
		File todayFile = new File(extraF, "bills.csv");
		if (todayFile.exists()) {
			try (BufferedReader reader = new BufferedReader(new FileReader(todayFile))) {
				String line;
				boolean IntroLine = true; // Skip header
				while ((line = reader.readLine()) != null) {
					if (IntroLine) {
						IntroLine = false;
						continue;
					}
					String[] parts = line.split(",");
					String lang = langIndex == 0 ? "es" : langIndex == 1 ? "pt" : langIndex == 2 ? "en" : "fr";

					if (TextEffect.isInteger(parts[2])) {
						int dayOrDate = Integer.parseInt(parts[2]);
						if (parts[1].equalsIgnoreCase("m")) {
							monthlyTableModel.addRow(new Object[] { parts[0], dayOrDate, "X" });
						} else {
							DayOfWeek day = DayOfWeek.of(dayOrDate);
							String dayName = day.getDisplayName(TextStyle.FULL, Locale.forLanguageTag(lang))
									.toUpperCase();
							weeklyTableModel.addRow(new Object[] { parts[0], dayName, "X" });
						}
					}
				}
			} catch (IOException e) {
				writeError(e);
			}
		}

		// Create Tables
		JPanel weeklyPanel = new JPanel(new BorderLayout());
		JPanel monthlyPanel = new JPanel(new BorderLayout());
		JTable weeklyTable = createBillsTable(weeklyTableModel);
		JTable monthlyTable = createBillsTable(monthlyTableModel);
		JButton addWRowButton = new JButton(getLocalizedMessage("ADD") + " ITEM");
		JButton addMRowButton = new JButton(getLocalizedMessage("ADD") + " ITEM");
		JPanel buttonsWP = new JPanel(new FlowLayout(FlowLayout.CENTER)),
				buttonsMP = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton clearWTable = new JButton(getLocalizedMessage("CLEAR")),
				clearMTable = new JButton(getLocalizedMessage("CLEAR"));
		clearWTable.setFont(new Font("Segoe UI", Font.BOLD, 14));
		clearWTable.setCursor(new Cursor(Cursor.HAND_CURSOR));
		clearWTable.addActionListener(_ -> weeklyTableModel.setRowCount(0));
		clearMTable.setFont(new Font("Segoe UI", Font.BOLD, 14));
		clearMTable.setCursor(new Cursor(Cursor.HAND_CURSOR));
		clearMTable.addActionListener(_ -> monthlyTableModel.setRowCount(0));
		addWRowButton.addActionListener(_ -> {
			String lang = langIndex == 0 ? "es" : langIndex == 1 ? "pt" : langIndex == 2 ? "en" : "fr";
			weeklyTableModel.addRow(new Object[] { "",
					DayOfWeek.of(1).getDisplayName(TextStyle.FULL, Locale.forLanguageTag(lang)).toUpperCase(), "X" });

		});
		addMRowButton.addActionListener(_ -> monthlyTableModel.addRow(new Object[] { "", 1, "X" }));
		addWRowButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		addWRowButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		addMRowButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		addMRowButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonsWP.add(addWRowButton);
		buttonsWP.add(clearWTable);
		buttonsMP.add(addMRowButton);
		buttonsMP.add(clearMTable);
		weeklyPanel.add(new JScrollPane(weeklyTable), BorderLayout.CENTER);
		weeklyPanel.add(buttonsWP, BorderLayout.SOUTH);
		monthlyPanel.add(new JScrollPane(monthlyTable), BorderLayout.CENTER);
		monthlyPanel.add(buttonsMP, BorderLayout.SOUTH);
		tabbedPane.addTab(getLocalizedMessage("WEEKLY"), weeklyPanel);
		tabbedPane.addTab(getLocalizedMessage("MONTHLY"), monthlyPanel);

		// Key listener for ESC key to close the dialog
		InputMap inputMap = dialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap = dialog.getRootPane().getActionMap();
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "closeDialog");
		actionMap.put("closeDialog", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
				overlay.hideOverlay();
				saveBills(weeklyTableModel, monthlyTableModel);
			}
		});
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				overlay.hideOverlay();
				saveBills(weeklyTableModel, monthlyTableModel);
			}
		});

		// Add the scroll pane to the dialog
		dialog.add(tabbedPane, BorderLayout.CENTER);

		// Show the dialog
		dialog.setVisible(true);
	}

	// Helper method to create and format tables
	private JTable createBillsTable(DefaultTableModel model) {
		JTable table = new JTable(model) {

			@Override
			public boolean editCellAt(int row, int column, EventObject e) {
				boolean result = super.editCellAt(row, column, e);
				final Component editor = getEditorComponent();

				if (editor instanceof JTextField) {
					JTextField textField = (JTextField) editor;

					// Select all text when editing starts
					if (e instanceof KeyEvent) {
						textField.setText(""); // Clear text for overwrite
						textField.requestFocusInWindow();
					} else {
						// If triggered by focus or mouse, select all text
						SwingUtilities.invokeLater(textField::selectAll);
					}
				}
				return result;
			}
		};
		table.setFont(new Font("Arial", Font.PLAIN, 16));
		table.setRowHeight(30);
		table.setShowGrid(true);
		table.setIntercellSpacing(new Dimension(0, 0));

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.setDefaultRenderer(Object.class, centerRenderer);

		TableColumn column[] = new TableColumn[3];
		for (int i = 0; i < 3; i++) {
			column[i] = table.getColumnModel().getColumn(i);
			if ((i > 0 && i < 2)) {
				column[i].setPreferredWidth(150);
				column[i].setMinWidth(150);
				column[i].setMaxWidth(150);
				column[i].setCellRenderer(centerRenderer);
			} else if (i == 2) {
				column[i].setPreferredWidth(90);
				column[i].setMinWidth(90);
				column[i].setMaxWidth(90);
			}
		}

		String lang = langIndex == 0 ? "es" : langIndex == 1 ? "pt" : langIndex == 2 ? "en" : "fr";
		DayOfWeek[] date = { DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY,
				DayOfWeek.FRIDAY, DayOfWeek.SATURDAY, DayOfWeek.SUNDAY };
		String[] dateM = new String[7];
		for (int i = 0; i < 7; i++)
			dateM[i] = date[i].getDisplayName(TextStyle.FULL, Locale.forLanguageTag(lang)).toUpperCase();
		JComboBox<String> dateCombo = new JComboBox<String>(dateM);
		DefaultCellEditor comboEditor = new DefaultCellEditor(dateCombo);
		// Integer Field for Column 3 (When Option 2 is selected)
		JTextField integerField = new JTextField();
		integerField.setHorizontalAlignment(JTextField.CENTER);

		DefaultCellEditor integerEditor = new DefaultCellEditor(integerField) {
			@Override
			public boolean stopCellEditing() {
				try {
					int value = Integer.parseInt((String) getCellEditorValue());
					if (value < 1 || value > 30) {
						throw new NumberFormatException();
					}
					return super.stopCellEditing();
				} catch (NumberFormatException e) {
					Toast.show(Main.this, Toast.Type.ERROR, "ERROR", Intro.notOption);
					return false;
				}
			}
		};

		// Listener to change column 3 dynamically
		if (getLocalizedMessage("WEEKLY").equals(table.getModel().getColumnName(1))) {
			column[1].setCellEditor(comboEditor); // Set ComboBox
		} else {
			column[1].setCellEditor(integerEditor); // Set Integer Fiel
		}
		table.getModel().addTableModelListener(_ -> {
			String selectedOption = table.getModel().getColumnName(1);
			if (getLocalizedMessage("WEEKLY").equals(selectedOption)) {
				column[1].setCellEditor(comboEditor); // Set ComboBox
			} else {
				column[1].setCellEditor(integerEditor); // Set Integer Fiel
			}
		});

		// Add Delete button
		javax.swing.Action deleteAction = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTable table = (JTable) e.getSource();
				int row = Integer.parseInt(e.getActionCommand());
				((DefaultTableModel) table.getModel()).removeRow(row);
			}
		};
		new ButtonColumn(table, deleteAction, 2); // Column index 5 for "Action"

		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Arial", Font.BOLD, 18));
		header.setBackground(new Color(220, 220, 220)); // Light gray background
		header.setForeground(Color.DARK_GRAY); // Dark gray text
		header.setReorderingAllowed(false);
		header.setResizingAllowed(false);

		return table;
	}

	/* Save bills file */
	private void saveBills(DefaultTableModel weeklyTableModel, DefaultTableModel monthlyTableModel) {
		File extraF = new File(dataFolder + "\\extra");
		extraF.mkdir();
		File billsF = new File(extraF, "bills.csv");
		File tempFile = new File(extraF, "temp_bills.csv");
		try (PrintWriter writer = new PrintWriter(new FileWriter(tempFile))) {
			writer.println("Bill,Type,Day/Date");
			for (int j = 0; j < weeklyTableModel.getRowCount(); j++) {
				String name = weeklyTableModel.getValueAt(j, 0) != null ? weeklyTableModel.getValueAt(j, 0).toString()
						: "";
				String day = weeklyTableModel.getValueAt(j, 1) != null ? weeklyTableModel.getValueAt(j, 1).toString()
						: "";
				String lang = langIndex == 0 ? "es" : langIndex == 1 ? "pt" : langIndex == 2 ? "en" : "fr";
				// Map days of the week to their numeric values (1 = Monday, ..., 7 = Sunday)
				DayOfWeek[] daysOfWeek = { DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY,
						DayOfWeek.FRIDAY, DayOfWeek.SATURDAY, DayOfWeek.SUNDAY };

				// Determine the numeric index for the day selected in the ComboBox
				int index = 1; // Default value (Monday)
				if (TextEffect.isInteger(day)) {
					index = Integer.parseInt(day); // If the value is already numeric (e.g., 1 for Monday)
				} else {
					for (int i = 0; i < daysOfWeek.length; i++) {
						if (day.equalsIgnoreCase(
								daysOfWeek[i].getDisplayName(TextStyle.FULL, Locale.forLanguageTag(lang)))) {
							index = i + 1; // DayOfWeek values start at 1 (Monday) and go to 7 (Sunday)
							break;
						}
					}
				}
				// Ensure data integrity before writing
				if (name.isEmpty() || day == null) {
					System.err.println("Skipping row due to missing values: " + name);
					continue;
				}
				writer.println(name + ",w," + index + "");
			}
			for (int i = 0; i < monthlyTableModel.getRowCount(); i++) {
				String name = monthlyTableModel.getValueAt(i, 0) != null ? monthlyTableModel.getValueAt(i, 0).toString()
						: "";
				String day = monthlyTableModel.getValueAt(i, 1) != null ? monthlyTableModel.getValueAt(i, 1).toString()
						: "";
				// Ensure data integrity before writing
				if (name.isEmpty() || day == null) {
					System.err.println("Skipping row due to missing values: " + name);
					continue;
				}
				writer.println(name + ",m," + day);
			}
		} catch (IOException e) {
			writeError(e);
			return;
		}

		// Safely replace the file only if writing was successful
		if (billsF.exists() && !billsF.delete()) {
			System.err.println("Failed to delete original file!");
		} else if (!tempFile.renameTo(billsF)) {
			System.err.println("Failed to rename temp file!");
		}
	}

	/* Helper method to filter bills based on category (daily, weekly, monthly) */

	private List<RecurringBill> filterBillsByCategory(List<RecurringBill> bills, String category) {
		List<RecurringBill> filteredBills = new ArrayList<>();
		LocalDate today = LocalDate.now();
		LocalDate endOfWeek = today.plusDays(7);

		for (RecurringBill bill : bills) {
			// Calculate the next due date based on the recurrence type
			bill.calculateNextDueDate();

			if (category.equals("daily") && bill.getNextDueDate().isEqual(today)) {
				filteredBills.add(bill); // Add bills due today to "daily" category
			} else if (category.equals("weekly") && bill.getNextDueDate().isAfter(today)
					&& bill.getNextDueDate().isBefore(endOfWeek)) {
				filteredBills.add(bill); // Add bills due within 7 days but not today to "weekly"
			} else if (category.equals("monthly") && bill.getNextDueDate().isAfter(endOfWeek)) {
				filteredBills.add(bill); // Add bills due after 7 days to "monthly"
			}
		}

		// Sort the filtered bills by next due date in ascending order
		filteredBills.sort(Comparator.comparing(RecurringBill::getNextDueDate));

		return filteredBills;
	}

	/* Return the bills for tomorrow as a String */
	private ArrayList<String> getBillsDueToday(List<RecurringBill> bills, WhatDay day) {
		LocalDate tomorrow = LocalDate.now().plusDays(1); // Get the current date
		ArrayList<String> lists = new ArrayList<String>();

		// Iterate through the list of bills
		for (RecurringBill bill : bills) {

			bill.calculateNextDueDate(); // Ensure next due date is calculated correctly

			// Check if the bill is due tomorrow
			if (day == WhatDay.TOMORROW) {
				if (bill.getNextDueDate().isEqual(tomorrow)) {
					lists.add(bill.getDescription());
				}
			} else if (day == WhatDay.TODAY)
				if (bill.getNextDueDate().isEqual(LocalDate.now())) {
					lists.add(bill.getDescription());
				}
		}

		return lists; // Return the description of bills due today
	}

	/* Enum to define icon types */
	private enum WhatDay {
		TODAY, TOMORROW, YESTERDAY
	}
	/* BILLS END */

	/* HOLIDAY START */
	/* Holiday Dialog */
	private void HolidayDialog() {
		holidayAddEvents();
		holidays = getHolidaysFromToday();
		JDialog holidayD = new JDialog(this, "", true);
		holidayD.setDefaultCloseOperation(HIDE_ON_CLOSE);
		holidayD.setUndecorated(true);
		holidayD.setSize(getWidth() / 2, getHeight() / 2);
		holidayD.setLocationRelativeTo(this);
		holidayD.setLayout(new BorderLayout());
		holidayD.setShape(new RoundRectangle2D.Double(0, 0, getWidth() / 2, getHeight() / 2, 20, 20));
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
		holidayD.setContentPane(contentPane);

		// NORTH Panel
		JPanel buttonPanel = new JPanel(new BorderLayout());
		buttonPanel.setOpaque(false);

		// Close Button
		JButton closeButton = new JButton(ImageEffect.getScaledImage(closeImage.getImage(), 15, 15));
		closeButton.setBorderPainted(false);
		closeButton.setFocusPainted(false);
		closeButton.setContentAreaFilled(false);
		closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		closeButton.setToolTipText(getLocalizedMessage("EXIT"));
		closeButton.addActionListener(_ -> {
			holidayD.dispose();
			overlay.hideOverlay();
		});
		JLabel titleLabel = new JLabel(currentDate.y + " " + getLocalizedMessage("HOLIDAY"));
		titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		titleLabel.setForeground(fg);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

		buttonPanel.add(titleLabel, BorderLayout.CENTER);
		buttonPanel.add(closeButton, BorderLayout.EAST);
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 15, 0));

		// Holiday List
		DefaultListModel<Holiday> model = new DefaultListModel<>();
		holidays.forEach(model::addElement);
		JList<Holiday> holidayList = new JList<>(model);
		holidayList.setCellRenderer(new HolidayRenderer());
		holidayList.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		holidayList.setBackground(Intro.grisD);
		holidayList.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		holidayList.setSelectionBackground(Intro.blackM);

		JScrollPane scrollPane = new JScrollPane(holidayList);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		contentPane.add(scrollPane, BorderLayout.CENTER);
		contentPane.add(buttonPanel, BorderLayout.NORTH);

		// Key listener for ESC key to close the dialog
		InputMap inputMap = holidayD.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap = holidayD.getRootPane().getActionMap();
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "closeDialog");
		actionMap.put("closeDialog", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				holidayD.dispose();
				overlay.hideOverlay();
			}
		});

		// Make the dialog focusable so it can capture key events
		holidayD.setFocusable(true);
		holidayD.requestFocusInWindow();

		holidayD.setVisible(true);
	}

	/* Change bills */
	private void holidaysChange() {
		holidayAddEvents();
		// Create a dialog for the table
		JDialog dialog = new JDialog(this, getLocalizedMessage("HOLIDAY"), true);
		dialog.setSize(getWidth() * 2 / 3, getHeight() * 2 / 3);
		dialog.setLocationRelativeTo(this);
		overlay.showOverlay();

		// Create a table model and table
		tableModel = new DefaultTableModel(new String[] { getLocalizedMessage("HOLIDAY"), getLocalizedMessage("DAY"),
				getLocalizedMessage("MONTH"), getLocalizedMessage("TYPE"), getLocalizedMessage("DELETE") }, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return true;
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				// Specify column types
				switch (columnIndex) {
				case 1: // DAY
				case 2: // MONTH
					return Integer.class; // Numeric columns
				default:
					return String.class; // Default to String
				}
			}
		};

		File extraF = new File(dataFolder + "\\extra");
		extraF.mkdir();
		File todayFile = new File(extraF, "holiday.csv");
		if (todayFile.exists()) {
			try (BufferedReader reader = new BufferedReader(new FileReader(todayFile))) {
				String line;
				boolean IntroLine = true; // Skip the header line
				while ((line = reader.readLine()) != null) {
					if (IntroLine) {
						IntroLine = false;
						continue;
					}
					String[] parts = line.split(",");
					if (parts.length == 4)
						if (TextEffect.isInteger(parts[1]) && TextEffect.isInteger(parts[2])) {
							HolidayType type = parts[3].equalsIgnoreCase("ISLAMIC") ? HolidayType.ISLAMIC
									: HolidayType.WORLDWIDE;
							tableModel
									.addRow(new Object[] { parts[0], parts[1], Integer.valueOf(parts[2]), type, "X" });
						}
				}
			} catch (IOException e) {
				writeError(e);
			}
		}

		table = new JTable(tableModel) {

			@Override
			public boolean editCellAt(int row, int column, EventObject e) {
				boolean result = super.editCellAt(row, column, e);
				final Component editor = getEditorComponent();

				if (editor instanceof JTextField) {
					JTextField textField = (JTextField) editor;

					// Select all text when editing starts
					if (e instanceof KeyEvent) {
						textField.setText(""); // Clear text for overwrite
						textField.requestFocusInWindow();
					} else {
						// If triggered by focus or mouse, select all text
						SwingUtilities.invokeLater(textField::selectAll);
					}
				}
				return result;
			}
		};
		table.setFont(new Font("Arial", Font.PLAIN, 16));
		table.setRowHeight(30);
		table.setShowGrid(true);
		table.setIntercellSpacing(new Dimension(0, 0));

		// Add the table to a scroll pane
		JScrollPane scrollPane = new JScrollPane(table);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.setDefaultRenderer(Object.class, centerRenderer);

		TableColumn column[] = new TableColumn[5];
		for (int i = 0; i < 5; i++) {
			column[i] = table.getColumnModel().getColumn(i);
			if ((i > 0 && i < 3)) {
				column[i].setPreferredWidth(150);
				column[i].setMinWidth(150);
				column[i].setMaxWidth(150);
				column[i].setCellRenderer(centerRenderer);
			} else if (i == 4) {
				column[i].setPreferredWidth(90);
				column[i].setMinWidth(90);
				column[i].setMaxWidth(90);
			}
		}

		// Integer Field for Column 3 (When Option 2 is selected)
		JTextField integerField = new JTextField();
		integerField.setHorizontalAlignment(JTextField.CENTER);

		DefaultCellEditor dayEditor = new DefaultCellEditor(integerField) {
			@Override
			public boolean stopCellEditing() {
				try {
					int value = Integer.parseInt((String) getCellEditorValue());
					if (value < 1 || value > 31) {
						throw new NumberFormatException();
					}
					return super.stopCellEditing();
				} catch (NumberFormatException e) {
					Toast.show(Main.this, Toast.Type.ERROR, "ERROR", Intro.notOption);
					return false;
				}
			}
		};
		DefaultCellEditor monthEditor = new DefaultCellEditor(integerField) {
			@Override
			public boolean stopCellEditing() {
				try {
					int value = Integer.parseInt((String) getCellEditorValue());
					if (value < 1 || value > 12) {
						throw new NumberFormatException();
					}
					return super.stopCellEditing();
				} catch (NumberFormatException e) {
					Toast.show(Main.this, Toast.Type.ERROR, "ERROR", Intro.notOption);
					return false;
				}
			}
		};
		column[1].setCellRenderer(centerRenderer);
		column[1].setCellEditor(dayEditor);
		column[2].setCellRenderer(centerRenderer);
		column[2].setCellEditor(monthEditor);

		// Customize the table header
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Arial", Font.BOLD, 18));
		header.setBackground(new Color(220, 220, 220)); // Light gray background for header
		header.setForeground(Color.DARK_GRAY); // Dark gray text for header
		header.setReorderingAllowed(false); // Prevent column reordering
		header.setResizingAllowed(false); // Prevent column resizing

		// Key listener for ESC key to close the dialog
		InputMap inputMap = dialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap = dialog.getRootPane().getActionMap();
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "closeDialog");
		actionMap.put("closeDialog", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
				overlay.hideOverlay();
				saveHolidays();
			}
		});
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				overlay.hideOverlay();
				saveHolidays();
			}
		});

		// BOTTOM PANEL
		JPanel bottomRow = new JPanel(new BorderLayout());
		JLabel legend = new JLabel(
				"<html><b><u><font size='5'>" + getLocalizedMessage("ISLAM") + "</font></u></b></html>");
		legend.setHorizontalAlignment(0);
		JPanel buttonsP = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton addRowButton = new JButton(getLocalizedMessage("ADD") + " ITEM");
		addRowButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		addRowButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		addRowButton.addActionListener(_ -> tableModel.addRow(new Object[] { "", 1, 1, "WORLDWIDE", "X" }));
		JButton clearTable = new JButton(getLocalizedMessage("CLEAR"));
		clearTable.setFont(new Font("Segoe UI", Font.BOLD, 14));
		clearTable.setCursor(new Cursor(Cursor.HAND_CURSOR));
		clearTable.addActionListener(_ -> tableModel.setRowCount(0));
		buttonsP.add(addRowButton);
		buttonsP.add(clearTable);
		bottomRow.add(legend, BorderLayout.CENTER);
		bottomRow.add(buttonsP, BorderLayout.SOUTH);
		// Add Delete button
		javax.swing.Action deleteAction = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTable table = (JTable) e.getSource();
				int row = Integer.parseInt(e.getActionCommand());
				((DefaultTableModel) table.getModel()).removeRow(row);
			}
		};
		new ButtonColumn(table, deleteAction, 4); // Column index 5 for "Action"

		// Add the scroll pane to the dialog
		dialog.add(scrollPane, BorderLayout.CENTER);
		dialog.add(bottomRow, BorderLayout.SOUTH);

		// Show the dialog
		dialog.setVisible(true);
	}

	/* Save bills file */
	private void saveHolidays() {
		File extraF = new File(dataFolder + "\\extra");
		extraF.mkdir();
		File holidayF = new File(extraF, "holiday.csv");
		File tempFile = new File(extraF, "temp_holiday.csv");
		try (PrintWriter writer = new PrintWriter(new FileWriter(tempFile))) {
			writer.println("ITEM,DAY,MONTH,TYPE");
			for (int row = 0; row < tableModel.getRowCount(); row++) {
				String name = tableModel.getValueAt(row, 0) != null ? tableModel.getValueAt(row, 0).toString() : "";
				String day = tableModel.getValueAt(row, 1) != null ? tableModel.getValueAt(row, 1).toString() : "";
				String month = tableModel.getValueAt(row, 2) != null ? tableModel.getValueAt(row, 2).toString() : "";
				String type = tableModel.getValueAt(row, 3) != null ? tableModel.getValueAt(row, 3).toString() : "";

				// Ensure data integrity before writing
				if (name.isEmpty() || type.isEmpty() || day.isEmpty() || month.isEmpty()) {
					System.err.println("Skipping row due to missing values: " + name);
					continue;
				}
				writer.println(String.join(",", name, day, month, type));
			}
		} catch (IOException e1) {
			writeError(e1);
			return; // Stop execution if writing fails
		}
		// Safely replace the file only if writing was successful
		if (holidayF.exists() && !holidayF.delete()) {
			System.err.println("Failed to delete original file!");
		} else if (!tempFile.renameTo(holidayF)) {
			System.err.println("Failed to rename temp file!");
		}
	}

	/* Add holidays events */
	private void holidayAddEvents() {
		holidays.clear();
		File extraF = new File(dataFolder + "\\extra");
		extraF.mkdir();
		File todayFile = new File(extraF, "holiday.csv");
		if (todayFile.exists()) {
			try (BufferedReader reader = new BufferedReader(new FileReader(todayFile))) {
				String line;
				boolean IntroLine = true; // Skip the header line
				while ((line = reader.readLine()) != null) {
					if (IntroLine) {
						IntroLine = false;
						continue;
					}
					String[] parts = line.split(",");
					if (parts.length == 4)
						if (TextEffect.isInteger(parts[1]) && TextEffect.isInteger(parts[2])) {
							int day = Integer.parseInt(parts[1]);
							int month = Integer.parseInt(parts[2]);
							HolidayType type = parts[3].equalsIgnoreCase("ISLAMIC") ? HolidayType.ISLAMIC
									: HolidayType.WORLDWIDE;
							if (parts[3].equalsIgnoreCase("ISLAMIC")) {
								LocalDate gregorianDate = LocalDate
										.from(HijrahDate.of(Intro.hijrihtDate.get(ChronoField.YEAR), month, day));
								holidays.add(new Holiday(parts[0], LocalDate.of(gregorianDate.getYear(),
										gregorianDate.getMonthValue(), gregorianDate.getDayOfMonth()), type));
							} else
								holidays.add(new Holiday(parts[0], LocalDate.of(currentDate.y, month, day), type));
						}
				}
			} catch (IOException e) {
				writeError(e);
			}
		}
	}
	/* Holidays End */

	/* Birthday Start */
	/* Birthday Dialog */
	private void BirthdayDialog() {
		birthdaysAddEvents();
		birthdayL = getBirthdayFromToday();
		JDialog birthdayD = new JDialog(this, "", true);
		birthdayD.setDefaultCloseOperation(HIDE_ON_CLOSE);
		birthdayD.setUndecorated(true);
		birthdayD.setSize(getWidth() / 2, getHeight() / 2);
		birthdayD.setLocationRelativeTo(this);
		birthdayD.setLayout(new BorderLayout());
		birthdayD.setShape(new RoundRectangle2D.Double(0, 0, getWidth() / 2, getHeight() / 2, 20, 20));
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
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		birthdayD.setContentPane(contentPane);

		DefaultListModel<Holiday> model = new DefaultListModel<>();
		birthdayL.forEach(model::addElement);
		JList<Holiday> birthdayList = new JList<>(model);
		birthdayList.setCellRenderer(new BirthdayRenderer());
		birthdayList.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		birthdayList.setBackground(Intro.grisD);
		birthdayList.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		birthdayList.setSelectionBackground(Intro.blackM);

		JScrollPane scrollPane = new JScrollPane(birthdayList);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		contentPane.add(scrollPane, BorderLayout.CENTER);

		// NORTH PANEL
		JPanel buttonPanel = new JPanel(new BorderLayout());
		buttonPanel.setOpaque(false);
		JLabel titleLabel = new JLabel(getLocalizedMessage("BIRTHDAY"));
		titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		titleLabel.setForeground(fg);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		JButton closeButton = new JButton(ImageEffect.getScaledImage(closeImage.getImage(), 15, 15));
		closeButton.setBorderPainted(false);
		closeButton.setFocusPainted(false);
		closeButton.setContentAreaFilled(false);
		closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		closeButton.setToolTipText(getLocalizedMessage("EXIT"));
		closeButton.addActionListener(_ -> {
			birthdayD.dispose();
			overlay.hideOverlay();
		});
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 15, 0));
		buttonPanel.add(titleLabel, BorderLayout.CENTER);
		buttonPanel.add(closeButton, BorderLayout.EAST);

		contentPane.add(buttonPanel, BorderLayout.NORTH);

		// Key listener for ESC key to close the dialog
		InputMap inputMap = birthdayD.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap = birthdayD.getRootPane().getActionMap();
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "closeDialog");
		actionMap.put("closeDialog", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				birthdayD.dispose();
				overlay.hideOverlay();
			}
		});

		// Make the dialog focusable so it can capture key events
		birthdayD.setFocusable(true);
		birthdayD.requestFocusInWindow();

		birthdayD.setVisible(true);
	}

	/* Change bills */
	private void BirthdayChange() {
		birthdaysAddEvents();
		// Create a dialog for the table
		JDialog dialog = new JDialog(this, getLocalizedMessage("BIRTHDAY"), true);
		dialog.setSize(getWidth() / 2, getHeight() / 2);
		dialog.setLocationRelativeTo(this);
		overlay.showOverlay();

		// Create a table model and table
		tableModel = new DefaultTableModel(new String[] { getLocalizedMessage("NAME"), getLocalizedMessage("DAY"),
				getLocalizedMessage("MONTH"), getLocalizedMessage("YEAR"), getLocalizedMessage("DELETE") }, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return true;
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				// Specify column types
				switch (columnIndex) {
				case 1: // DAY
				case 2: // MONTH
				case 3: // MONTH
					return Integer.class; // Numeric columns
				default:
					return String.class; // Default to String
				}
			}
		};

		File extraF = new File(dataFolder + "\\extra");
		extraF.mkdir();
		File todayFile = new File(extraF, "birthday.csv");
		if (todayFile.exists()) {
			try (BufferedReader reader = new BufferedReader(new FileReader(todayFile))) {
				String line;
				boolean IntroLine = true; // Skip the header line
				while ((line = reader.readLine()) != null) {
					if (IntroLine) {
						IntroLine = false;
						continue;
					}
					String[] parts = line.split(",");
					if (parts.length == 4)
						if (TextEffect.isInteger(parts[1]) && TextEffect.isInteger(parts[2])
								&& TextEffect.isInteger(parts[3])) {
							tableModel.addRow(new Object[] { parts[0], parts[1], parts[2], parts[3], "X" });
						}
				}
			} catch (IOException e) {
				writeError(e);
			}
		}

		table = new JTable(tableModel) {

			@Override
			public boolean editCellAt(int row, int column, EventObject e) {
				boolean result = super.editCellAt(row, column, e);
				final Component editor = getEditorComponent();

				if (editor instanceof JTextField) {
					JTextField textField = (JTextField) editor;

					// Select all text when editing starts
					if (e instanceof KeyEvent) {
						textField.setText(""); // Clear text for overwrite
						textField.requestFocusInWindow();
					} else {
						// If triggered by focus or mouse, select all text
						SwingUtilities.invokeLater(textField::selectAll);
					}
				}
				return result;
			}
		};
		table.setFont(new Font("Arial", Font.PLAIN, 16));
		table.setRowHeight(30);
		table.setShowGrid(true);
		table.setIntercellSpacing(new Dimension(0, 0));

		// Add the table to a scroll pane
		JScrollPane scrollPane = new JScrollPane(table);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.setDefaultRenderer(Object.class, centerRenderer);

		TableColumn column[] = new TableColumn[5];
		for (int i = 0; i < 5; i++) {
			column[i] = table.getColumnModel().getColumn(i);
			if ((i > 0 && i < 3)) {
				column[i].setPreferredWidth(150);
				column[i].setMinWidth(150);
				column[i].setMaxWidth(150);
				column[i].setCellRenderer(centerRenderer);
			} else if (i == 4) {
				column[i].setPreferredWidth(90);
				column[i].setMinWidth(90);
				column[i].setMaxWidth(90);
			}
		}

		// Integer Field for Column 3 (When Option 2 is selected)
		JTextField integerField = new JTextField();
		integerField.setHorizontalAlignment(JTextField.CENTER);

		DefaultCellEditor dayEditor = new DefaultCellEditor(integerField) {
			@Override
			public boolean stopCellEditing() {
				try {
					int value = Integer.parseInt((String) getCellEditorValue());
					if (value < 1 || value > 31) {
						throw new NumberFormatException();
					}
					return super.stopCellEditing();
				} catch (NumberFormatException e) {
					e.printStackTrace();
					return false;
				}
			}
		};
		DefaultCellEditor monthEditor = new DefaultCellEditor(integerField) {
			@Override
			public boolean stopCellEditing() {
				try {
					int value = Integer.parseInt((String) getCellEditorValue());
					if (value < 1 || value > 12) {
						throw new NumberFormatException();
					}
					return super.stopCellEditing();
				} catch (NumberFormatException e) {
					e.printStackTrace();
					return false;
				}
			}
		};
		DefaultCellEditor yearEditor = new DefaultCellEditor(integerField) {
			@Override
			public boolean stopCellEditing() {
				try {
					int value = Integer.parseInt((String) getCellEditorValue());
					if (value < 1900 || value > 2025) {
						throw new NumberFormatException();
					}
					return super.stopCellEditing();
				} catch (NumberFormatException e) {
					return false;
				}
			}
		};
		column[1].setCellRenderer(centerRenderer);
		column[1].setCellEditor(dayEditor);
		column[2].setCellRenderer(centerRenderer);
		column[2].setCellEditor(monthEditor);
		column[3].setCellRenderer(centerRenderer);
		column[3].setCellEditor(yearEditor);

		// Customize the table header
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Arial", Font.BOLD, 18));
		header.setBackground(new Color(220, 220, 220)); // Light gray background for header
		header.setForeground(Color.DARK_GRAY); // Dark gray text for header
		header.setReorderingAllowed(false); // Prevent column reordering
		header.setResizingAllowed(false); // Prevent column resizing

		// Key listener for ESC key to close the dialog
		InputMap inputMap = dialog.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap = dialog.getRootPane().getActionMap();
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "closeDialog");
		actionMap.put("closeDialog", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
				overlay.hideOverlay();
				saveBirthday();
			}
		});
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				overlay.hideOverlay();
				saveBirthday();
			}
		});

		// BOTTOM PANEL
		JPanel buttonsP = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton addRowButton = new JButton(getLocalizedMessage("ADD") + " ITEM");
		addRowButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		addRowButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		addRowButton.addActionListener(_ -> tableModel.addRow(new Object[] { "", 1, 1, 1990, "X" }));
		JButton clearTable = new JButton(getLocalizedMessage("CLEAR"));
		clearTable.setFont(new Font("Segoe UI", Font.BOLD, 14));
		clearTable.setCursor(new Cursor(Cursor.HAND_CURSOR));
		clearTable.addActionListener(_ -> tableModel.setRowCount(0));
		buttonsP.add(addRowButton);
		buttonsP.add(clearTable);
		// Add Delete button
		javax.swing.Action deleteAction = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTable table = (JTable) e.getSource();
				int row = Integer.parseInt(e.getActionCommand());
				((DefaultTableModel) table.getModel()).removeRow(row);
			}
		};
		new ButtonColumn(table, deleteAction, 4); // Column index 5 for "Action"

		// Add the scroll pane to the dialog
		dialog.add(scrollPane, BorderLayout.CENTER);
		dialog.add(buttonsP, BorderLayout.SOUTH);

		// Show the dialog
		dialog.setVisible(true);
	}

	/* Save bills file */
	private void saveBirthday() {
		File extraF = new File(dataFolder + "\\extra");
		extraF.mkdir();
		File holidayF = new File(extraF, "birthday.csv");
		File tempFile = new File(extraF, "temp_birthday.csv");
		try (PrintWriter writer = new PrintWriter(new FileWriter(tempFile))) {
			writer.println("ITEM,DAY,MONTH,YEAR,TYPE");
			for (int row = 0; row < tableModel.getRowCount(); row++) {
				String name = tableModel.getValueAt(row, 0) != null ? tableModel.getValueAt(row, 0).toString() : "";
				String day = tableModel.getValueAt(row, 1) != null ? tableModel.getValueAt(row, 1).toString() : "";
				String month = tableModel.getValueAt(row, 2) != null ? tableModel.getValueAt(row, 2).toString() : "";
				String year = tableModel.getValueAt(row, 3) != null ? tableModel.getValueAt(row, 3).toString() : "";

				// Ensure data integrity before writing
				if (name.isEmpty() || year.isEmpty() || day.isEmpty() || month.isEmpty()) {
					System.err.println("Skipping row due to missing values: " + name);
					continue;
				}
				writer.println(String.join(",", name, day, month, year));
			}
		} catch (IOException e1) {
			writeError(e1);
			return; // Stop execution if writing fails
		}
		// Safely replace the file only if writing was successful
		if (holidayF.exists() && !holidayF.delete()) {
			System.err.println("Failed to delete original file!");
		} else if (!tempFile.renameTo(holidayF)) {
			System.err.println("Failed to rename temp file!");
		}
	}

	/* Add BIRTHDAY events */
	private void birthdaysAddEvents() {
		birthdayL.clear();
		File extraF = new File(dataFolder + "\\extra");
		extraF.mkdir();
		File todayFile = new File(extraF, "birthday.csv");
		if (todayFile.exists()) {
			try (BufferedReader reader = new BufferedReader(new FileReader(todayFile))) {
				String line;
				boolean IntroLine = true; // Skip the header line
				while ((line = reader.readLine()) != null) {
					if (IntroLine) {
						IntroLine = false;
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
	/* Birthday End */

	/* Method to center the text in the JTable */
	private void centerTableText(JTable table) {
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, centerRenderer);
	}

	/* Format date with day of the week in Spanish */
	private String formatDateWithDay(LocalDate date) {
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		String dayFull;
		if (language == Language.SPANISH)
			dayFull = dayOfWeek.getDisplayName(TextStyle.FULL, new Locale("es", "ES")).toUpperCase();
		else if (language == Language.PORTUGUES)
			dayFull = dayOfWeek.getDisplayName(TextStyle.FULL, new Locale("pt", "PT")).toUpperCase();
		else if (language == Language.ENGLISH)
			dayFull = dayOfWeek.getDisplayName(TextStyle.FULL, new Locale("en", "EN")).toUpperCase();
		else
			dayFull = dayOfWeek.getDisplayName(TextStyle.FULL, new Locale("fr", "FR")).toUpperCase();
		return dayFull + ", " + date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	/* Method to toggle the notification panel visibility */
	private void toggleNotificationPanel() {
		overlay.showOverlay();
		listDialog.setUndecorated(true);
		listDialog.setBounds(getWidth() - 250 + notificationButton.getWidth() - 10,
				notificationButton.getLocationOnScreen().y + notificationButton.getHeight(), 300, 0);
		listDialog.add(notificationPanel);
		displayNotifications();
		listDialog.setVisible(true);
	}

	/* Display the notification */
	private void displayNotifications() {
		notificationPanel.removeAll();

		JPanel listPanel = new JPanel();
		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
		listPanel.setBackground(bg);
		listPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		notificationPanel.setBorder(Intro.borderD);

		ArrayList<String> notifications = new ArrayList<String>();
		ArrayList<String> titles = new ArrayList<String>();
		ArrayList<Icon> icons = new ArrayList<Icon>();

		ArrayList<String> notificationToday = new ArrayList<String>();
		notificationToday = getBillsDueToday(bills, WhatDay.TODAY);

		// Sample titles and types for each notification
		ImageIcon birthdayIcon = ImageEffect
				.getScaledImage(new ImageIcon(getClass().getResource("images/status/birthday.png")).getImage(), 40, 40);
		ImageIcon infoIcon = ImageEffect
				.getScaledImage(new ImageIcon(getClass().getResource("images/status/info.png")).getImage(), 40, 40);
		ImageIcon warningIcon = ImageEffect
				.getScaledImage(new ImageIcon(getClass().getResource("images/status/warning.png")).getImage(), 40, 40);
		ImageIcon islamIcon = ImageEffect
				.getScaledImage(new ImageIcon(getClass().getResource("images/status/islam.png")).getImage(), 40, 40);
		ImageIcon holidayIcon = ImageEffect
				.getScaledImage(new ImageIcon(getClass().getResource("images/status/holiday.png")).getImage(), 40, 40);

		/* Bills */
		if (notificationToday.size() > 0) {
			StringBuilder billsDescription = new StringBuilder();
			for (int i = 0; i < notificationToday.size(); i++) {
				if (billsDescription.length() > 0) {
					billsDescription.append("\n");
				}
				billsDescription.append(notificationToday.get(i));
			}
			notifications.add(billsDescription.toString());
			icons.add(warningIcon);
			titles.add(getLocalizedMessage("INVOICE"));
		}

		if (currentDate.dayName(2).equalsIgnoreCase("saturday")) {
			notifications.add(getLocalizedMessage("ADD") + " " + getLocalizedMessage("WEEK_DAYS"));
			icons.add(infoIcon);
			titles.add(getLocalizedMessage("EMPLOYEE"));
		}

		/* Check money */
		if (isNewDayExisted()) {
			notifications.add(getLocalizedMessage("REVIEW_M"));
			icons.add(warningIcon);
			titles.add(language == Language.SPANISH ? "REVISIÓN DE EFECTIVO"
					: language == Language.PORTUGUES ? "REVISÃO DE DINHEIRO"
							: language == Language.ENGLISH ? "CASH REVIEW" : "REVUE DE LA TRÉSORERIE");
		}
		/* Intro DAY OF THE MONTH */
		if (dayN.equals("01")) {
			String theme = language == Language.SPANISH ? "¿NUEVO MES = NUEVO TEMA?"
					: language == Language.PORTUGUES ? "NOVO MÊS = NOVO TEMA?"
							: language == Language.ENGLISH ? "NEW MONTH = NEW THEME?"
									: "NOUVEAU MOIS = NOUVEAU THÈME ?";
			notifications.add(theme);
			icons.add(infoIcon);
			titles.add(getLocalizedMessage("THEME"));
		}
		/* Holidays */
		for (int i = 0; i < holidays.size(); i++) {
			if (holidays.get(i).getDate().equals(LocalDate.now())) {
				notifications.add(holidays.get(i).getName());
				if (holidays.get(i).getType() == HolidayType.ISLAMIC)
					icons.add(islamIcon);
				else
					icons.add(holidayIcon);
				titles.add(getLocalizedMessage("THIS_DAY"));
			}
		}

		/* BIRTHDAYS */
		for (int i = 0; i < birthdayL.size(); i++) {
			LocalDate birthdayToday = LocalDate.of(currentDate.y, birthdayL.get(i).getDate().getMonthValue(),
					birthdayL.get(i).getDate().getDayOfMonth());
			int years = currentDate.y - birthdayL.get(i).getDate().getYear();
			if (birthdayToday.equals(LocalDate.now())) {
				notifications.add(getLocalizedMessage("BIRTHDAY") + " " + getLocalizedMessage("OF") + " "
						+ birthdayL.get(i).getName().toUpperCase() + " (" + years + " " + getLocalizedMessage("YEAR")
						+ "S)");
				icons.add(birthdayIcon);
				titles.add(getLocalizedMessage("BIRTHDAY"));
			}
		}

		int itemsToShow = isExpanded ? notifications.size() : Math.min(3, notifications.size());
		// Display each notification item
		int totalHeight = 0; // Accumulate height

		for (int i = 0; i < itemsToShow; i++) {
			String content = notifications.get(i);

			// Notification panel
			JPanel itemPanel = new JPanel(new BorderLayout());
			Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
			Border innerBorder = i != itemsToShow - 1 ? BorderFactory.createMatteBorder(0, 0, 2, 0, fg) : null;
			itemPanel.setBorder(
					innerBorder != null ? BorderFactory.createCompoundBorder(outerBorder, innerBorder) : outerBorder);
			itemPanel.setBackground(bg);

			// Icon label
			JLabel iconLabel = new JLabel(icons.get(i));
			iconLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));

			// Title label
			JLabel titleLabel = new JLabel(titles.get(i));
			titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
			titleLabel.setForeground(fg);

			// Content label
			JLabel contentLabel = new JLabel("<html>" + content.replace("\n", "<br>") + "</html>");
			contentLabel.setFont(new Font("Arial", Font.PLAIN, 11));
			contentLabel.setForeground(fg);

			// Add components to item panel
			JPanel textPanel = new JPanel();
			textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
			textPanel.setBackground(bg);
			textPanel.add(titleLabel);
			textPanel.add(contentLabel);

			itemPanel.add(iconLabel, BorderLayout.WEST);
			itemPanel.add(textPanel, BorderLayout.CENTER);

			listPanel.add(itemPanel);

			// Accumulate height
			totalHeight += itemPanel.getPreferredSize().height + 10; // Include spacing
		}

		// Set dialog size and position after the loop
		dialogWidth = Math.max(dialogWidth, listPanel.getPreferredSize().width + 40); // Adjust width dynamically

		if (notifications.size() > 3)
			dialogHeight = totalHeight + 60; // Add padding for the dialog
		else
			dialogHeight = totalHeight + 40; // Add padding for the dialog
		listDialog.setSize(dialogWidth, dialogHeight);
		listDialog.setLocation(getWidth() - dialogWidth - 20, listDialog.getY());

		JPanel topPanel = new JPanel(new BorderLayout());
		topPanel.setPreferredSize(new Dimension(listDialog.getWidth(), 30));
		topPanel.setBackground(Intro.grisD);
		JLabel titleN = new JLabel(listDialog.getTitle());
		titleN.setFont(Intro.myFontS);
		titleN.setForeground(Intro.blackM);
		titleN.setBackground(Intro.grisD);
		titleN.setOpaque(true);
		titleN.setHorizontalAlignment(0);
		titleN.setPreferredSize(new Dimension(listDialog.getWidth() - 30, 30)); // Adjust button size
		JButton closeButton = new JButton(
				ImageEffect.changeOpacity(ImageEffect.getScaledImage(closeImage.getImage(), 15, 15).getImage(), 0.8f));
		closeButton.setPreferredSize(new Dimension(30, 30)); // Adjust button size
		closeButton.setBorderPainted(false);
		closeButton.setFocusPainted(false);
		closeButton.setContentAreaFilled(false);
		closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		closeButton.setToolTipText(getLocalizedMessage("EXIT"));
		closeButton.addActionListener(_ -> closeDialog(listDialog, dialogHeight, dialogWidth));
		topPanel.add(titleN);
		topPanel.add(closeButton, BorderLayout.EAST);

		openDialog(listDialog, dialogHeight, dialogWidth);

		// "Show All" button logic remains the same
		if (notifications.size() > 3 && !isExpanded) {
			showAllButton = new JButton(getLocalizedMessage("SHOW_ALL"));
			showAllButton.addActionListener(_ -> {
				isExpanded = true;
				displayNotifications(); // Refresh panel to show all items
			});
			JPanel buttonPanel = new JPanel();
			buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			buttonPanel.setBackground(bg);
			buttonPanel.add(showAllButton);
			listPanel.add(buttonPanel);
		}

		listDialog.getRootPane().registerKeyboardAction(_ -> closeDialog(listDialog, dialogHeight, dialogWidth),
				KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);

		notificationPanel.add(listPanel, BorderLayout.CENTER);
		notificationPanel.add(topPanel, BorderLayout.NORTH);
		notificationPanel.revalidate();
		notificationPanel.repaint();
	}

	/* Return the count of notification */
	private int notificationCount() {
		int counter = 0;
		counter += getBillsDueToday(bills, WhatDay.TODAY).size();

		/* Check money */
		if (isNewDayExisted())
			counter++;
		/* Intro DAY OF THE MONTH */
		if (dayN.equals("01"))
			counter++;
		/* Holidays */
		for (int i = 0; i < holidays.size(); i++)
			if (holidays.get(i).getDate().equals(LocalDate.now()))
				counter++;

		/* BIRTHDAYS */
		for (int i = 0; i < birthdayL.size(); i++) {
			LocalDate birthdayToday = LocalDate.of(currentDate.y, birthdayL.get(i).getDate().getMonthValue(),
					birthdayL.get(i).getDate().getDayOfMonth());
			if (birthdayToday.equals(LocalDate.now()))
				counter++;
		}
		if (currentDate.dayName(2).equalsIgnoreCase("saturday"))
			counter++;

		return counter;
	}

	/* Animation to close the Dialog */
	private void closeDialog(JDialog dialog, int dialogH, int dialogW) {
		isExpanded = false;
		// Start the animation
		Timer timer = new Timer(10, new ActionListener() {
			int usedHeight = dialogH;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (usedHeight > 0) {
					usedHeight -= 5; // Increase height by 5 pixels
					dialog.setSize(dialogW, usedHeight); // Set the new height and the same width
				} else {
					((Timer) e.getSource()).stop(); // Stop the timer once the target height is reached
					dialog.dispose();
					overlay.hideOverlay();
				}
			}
		});
		timer.start(); // Start the animation timer
	}

	/* Animation to open the Dialog */
	private void openDialog(JDialog dialog, int dialogH, int dialogW) {
		// Start the animation
		Timer fadeIn = new Timer(10, new ActionListener() {
			private int height = 0;
			private final int targetHeight = dialogH; // Target height for the dialog

			@Override
			public void actionPerformed(ActionEvent e) {
				if (height < targetHeight) {
					height += 5; // Increase height by 5 pixels
					listDialog.setSize(dialogW, height); // Set the new height and the same width
				} else {
					((Timer) e.getSource()).stop(); // Stop the timer once the target height is reached
				}
			}
		});
		fadeIn.start(); // Start the animation timer
	}

	/* Filter holidays according to today */
	public List<Holiday> getHolidaysFromToday() {
		LocalDate today = LocalDate.now();
		return holidays.stream().filter(h -> !h.getDate().isBefore(today) && h.getDate().getYear() == today.getYear())
				.sorted(Comparator.comparing(Holiday::getDate)).collect(Collectors.toList());
	}

	/* Filter Birthday according to today */
	public List<Holiday> getBirthdayFromToday() {
		return birthdayL.stream()
				.sorted(Comparator.comparingInt(h -> h.getDate().getMonthValue() * 100 + h.getDate().getDayOfMonth()))
				.collect(Collectors.toList());
	}

	/* SlideShow */
	private void setupAWTEventListener() {
		Toolkit.getDefaultToolkit().addAWTEventListener(event -> {
			if (event instanceof KeyEvent || event instanceof MouseEvent) {
				resetInactivityTimer();
			}
		}, AWTEvent.KEY_EVENT_MASK | AWTEvent.MOUSE_EVENT_MASK | AWTEvent.MOUSE_MOTION_EVENT_MASK);

		startInactivityTimer();
	}

	/* Start the timer of the animation */
	private void startInactivityTimer() {
		inactivityTimer = new java.util.Timer();
		if (!isBlured && !conf[11].equals("0")) {
			inactivityTimer.schedule(new TimerTask() {
				@Override
				public void run() {
					if (conf[11].equals("1")) {
						setState(Frame.NORMAL); // Restore if minimized
						toFront(); // Bring the frame to the front
						requestFocus(); // Request focus for the frame
						SwingUtilities.invokeLater(Main.this::lockFrame);
					} else if (conf[11].equals("2")) {
						if (isAppInForeground)
							SwingUtilities.invokeLater(Main.this::startAnimation);
					}
					// Restore the focus back to the previously focused component
					if (focusedComponent != null) {
						focusedComponent.requestFocusInWindow();
					}
				}
			}, INACTIVITY_DELAY, INACTIVITY_DELAY);
		}
	}

	/* Start the animation */
	private void startAnimation() {
		Random random = new Random();
		Shape[] allShape = { Shape.BALLON, Shape.BLOOD, Shape.CHRISTMAS_STAR, Shape.CHRISTMAS_TREE, Shape.CIRCLE,
				Shape.CONFETTI, Shape.FIREWORK, Shape.FRACTAL, Shape.MOON, Shape.STAR };
		Shape randomShape = allShape[random.nextInt(10)];
		snowPanel.setFillColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
		snowPanel.setShape(randomShape);
		snowPanel.startSnow();
	}

	/* Reset the timer */
	private void resetInactivityTimer() {
		snowPanel.stopNow();
		inactivityTimer.cancel();
		startInactivityTimer(); // Restart the timer
	}

	/* Change the default password */
	private void passwordChange(File usersF) {
		if (usersF.exists()) {
			try (BufferedReader userOP = new BufferedReader(new FileReader(usersF))) {
				String userL;
				if ((userL = userOP.readLine()) != null) {
					correctPassword = encrypt.decrypt(userL);
				}
			} catch (Exception e) {
				writeError(e);
			}
		} else
			try {
				usersF.createNewFile();
			} catch (IOException e1) {
				writeError(e1);
			}
		JDialog dialog = new JDialog(this, "", true);
		dialog.setUndecorated(true);
		dialog.setSize(2 * getWidth() / 5, getHeight() / 2);
		dialog.setShape(new RoundRectangle2D.Double(0, 0, 2 * getWidth() / 5, getHeight() / 2, 20, 20));
		dialog.setLocationRelativeTo(this);
		dialog.setLayout(new GridBagLayout());
		dialog.setResizable(false);
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
		contentPane.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		dialog.setContentPane(contentPane);

		// Icon
		JLabel iconLabel = new JLabel(lockDockI);
		iconLabel.setHorizontalAlignment(SwingConstants.CENTER);

		// LABEL
		JLabel oldPass = new JLabel(getLocalizedMessage("OLD_PASS"));
		JLabel newPass = new JLabel(getLocalizedMessage("NEW_PASS"));
		JLabel rePass = new JLabel(getLocalizedMessage("RE_PASS"));
		oldPass.setFont(new Font("Segoe UI", Font.BOLD, 15));
		rePass.setFont(new Font("Segoe UI", Font.BOLD, 15));
		newPass.setFont(new Font("Segoe UI", Font.BOLD, 15));

		// Field
		JPasswordField oldPF = new JPasswordField(15);
		JPasswordField newPF = new JPasswordField(15);
		JPasswordField rePF = new JPasswordField(15);
		oldPF.setFont(new Font("Impact", Font.ITALIC, 15));
		newPF.setFont(new Font("Impact", Font.ITALIC, 15));
		rePF.setFont(new Font("Impact", Font.ITALIC, 15));

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weightx = 1; // Allow horizontal centering
		gbc.weighty = 1; // Allow vertical centering

		// Load Button
		JButton saveButton = new JButton(getLocalizedMessage("SAVE"));
		saveButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
		saveButton.addActionListener(_ -> {
			String oldPassword = new String(oldPF.getPassword());
			String newPassword = new String(newPF.getPassword());
			String rePassword = new String(rePF.getPassword());
			if (oldPassword.equals(correctPassword) && newPassword.equals(rePassword) && !newPassword.isBlank())
				try {
					FileWriter savedF = new FileWriter(usersF);
					savedF.write(encrypt.encrypt(newPassword));
					Toast.show(this, Toast.Type.SUCCESS, getLocalizedMessage("SAVE_A"), Intro.notOption);
					savedF.close();
					correctPassword = newPassword;
					dialog.dispose();
					overlay.hideOverlay();
				} catch (Exception e) {
					writeError(e);
				}
			else if (!oldPassword.equals(correctPassword))
				Toast.show(this, Toast.Type.ERROR, getLocalizedMessage("OLDP_INCORRECT"), Intro.notOption);
			else if (!newPassword.equals(rePassword))
				Toast.show(this, Toast.Type.ERROR, getLocalizedMessage("NEWP_INCORRECT"), Intro.notOption);
			else if (newPassword.isBlank())
				Toast.show(this, Toast.Type.ERROR, getLocalizedMessage("PASSWORD_EMPTY"), Intro.notOption);
		});

		PasswordStrengthStatus passwordStrengthStatus = new PasswordStrengthStatus();
		passwordStrengthStatus.initPasswordField(newPF);
		passwordStrengthStatus.setText(getLocalizedMessage("WEAK"), getLocalizedMessage("MEDIUM"),
				getLocalizedMessage("STRONG"));
		passwordStrengthStatus.setOpaque(false);

		// Close Button
		JButton closeButton = new JButton(ImageEffect.getScaledImage(closeImage.getImage(), 15, 15));
		closeButton.setBorderPainted(false);
		closeButton.setFocusPainted(false);
		closeButton.setContentAreaFilled(false);
		closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		closeButton.setToolTipText(getLocalizedMessage("EXIT"));
		closeButton.addActionListener(_ -> {
			dialog.dispose();
			overlay.hideOverlay();
		});
		JPanel borderLay = new JPanel(new GridBagLayout());
		borderLay.setOpaque(false);
		// Add Components to Dialog
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		borderLay.add(oldPass, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		borderLay.add(oldPF, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		borderLay.add(newPass, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		borderLay.add(newPF, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		borderLay.add(rePass, gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		borderLay.add(rePF, gbc);
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		borderLay.add(passwordStrengthStatus, gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		borderLay.add(new JLabel(
				"<html><u><font size='3'>" + getLocalizedMessage("DEFAULT_PASS") + ": 0000" + "</font></u></html>"),
				gbc);
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 2;
		borderLay.add(saveButton, gbc);
		JPanel northPanel = new JPanel(new BorderLayout());
		northPanel.setOpaque(false);
		northPanel.add(closeButton, BorderLayout.EAST);
		northPanel.add(iconLabel, BorderLayout.CENTER);
		northPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
		contentPane.add(northPanel, BorderLayout.NORTH);
		contentPane.add(borderLay, BorderLayout.CENTER);

		// Key listener for ESC key to close the dialog
		dialog.getRootPane().setDefaultButton(saveButton);
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
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				overlay.hideOverlay();
			}
		});

		dialog.setVisible(true);
	}

	/* Save error log as txt */
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
		} catch (IOException e1) {
			writeError(e1);
			return; // Stop execution if writing fails
		}
		e.printStackTrace();
	}

	/* Delete given folder */
	private static boolean deleteFolder(File folder) {
		if (folder.isDirectory()) {
			// Get all files and subdirectories in the directory
			File[] files = folder.listFiles();
			if (files != null) { // Check if the directory is not empty
				for (File file : files) {
					// Recursively delete each file or subdirectory
					deleteFolder(file);
				}
			}
		}
		// Delete the empty folder or file
		return folder.delete();
	}

	/* return the double */
	private double roundedDouble(double value) {
		return Math.round(value * 100.0) / 100.0;
	}

	// Custom Renderer for Holiday List
	private class EmployeeRender extends JLabel implements ListCellRenderer<String> {
		@Override
		public Component getListCellRendererComponent(JList<? extends String> list, String facts, int index,
				boolean isSelected, boolean cellHasFocus) {
			setText(facts);
			// Styling
			setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
			setHorizontalAlignment(0);
			setOpaque(true);
			setBackground(isSelected ? new Color(0, 112, 192) : bg);
			setForeground(isSelected ? Color.BLACK : fg);
			setBorder(uBorder);
			if (getText().startsWith("---")) { // Month Header Styling
				setFont(new Font("SansSerif", Font.BOLD, 16));
				setBackground(Intro.redM);
				setForeground(Color.white);
			}

			return this;
		}
	}

	// Custom Renderer for Holiday List
	private class HolidayRenderer extends JPanel implements ListCellRenderer<Holiday> {

		private final JLabel label;
		private final JSeparator separator;
		private static int lastMonth = -1;

		public HolidayRenderer() {
			setLayout(new BorderLayout());
			label = new JLabel();
			separator = new JSeparator(SwingConstants.HORIZONTAL);
			separator.setForeground(Color.GRAY);
			add(separator, BorderLayout.NORTH);
			add(label, BorderLayout.CENTER);
		}

		@Override
		public Component getListCellRendererComponent(JList<? extends Holiday> list, Holiday holiday, int index,
				boolean isSelected, boolean cellHasFocus) {

			int currentMonth = holiday.getDate().getMonthValue();
			label.setText(holiday.getDate() + " " + holiday.getName() + " ("
					+ ChronoUnit.DAYS.between(LocalDate.now(), holiday.getDate()) + " " + getLocalizedMessage("DAY")
					+ "S " + getLocalizedMessage("LEFT") + ")");

			if (lastMonth != currentMonth) {
				separator.setVisible(true);
			} else {
				separator.setVisible(false);
			}
			lastMonth = currentMonth;
			// Set icon based on holiday name (examples for Uruguay and Brazil)
			if (holiday.getType() == HolidayType.WORLDWIDE) {
				label.setIcon(ImageEffect.getScaledImage(
						new ImageIcon(getClass().getResource("images/status/worldwide.png")).getImage(), 40, 40));
			} else
				label.setIcon(ImageEffect.getScaledImage(
						new ImageIcon(getClass().getResource("images/status/islam.png")).getImage(), 40, 40));

			// Styling
			label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			label.setOpaque(true);
			label.setBackground(isSelected ? new Color(200, 200, 255) : Intro.grisD);
			label.setForeground(isSelected ? Color.BLACK : Color.black);
			label.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

			return this;
		}
	}

	// Custom Renderer for Holiday List
	private class BirthdayRenderer extends JPanel implements ListCellRenderer<Holiday> {
		private final JSeparator separator;
		private final JLabel label;

		public BirthdayRenderer() {
			setLayout(new BorderLayout());
			label = new JLabel();
			separator = new JSeparator(SwingConstants.HORIZONTAL);
			separator.setForeground(Color.GRAY);
			add(separator, BorderLayout.NORTH);
			add(label, BorderLayout.CENTER);
		}

		@Override
		public Component getListCellRendererComponent(JList<? extends Holiday> list, Holiday birthday, int index,
				boolean isSelected, boolean cellHasFocus) {
			int currentAge = Period.between(birthday.getDate(), LocalDate.now()).getYears() + 1;

			LocalDate birthThisYear;
			if (currentDate.m > birthday.getDate().getMonthValue()
					|| (birthday.getDate().getMonthValue() == currentDate.m
							&& currentDate.d > birthday.getDate().getDayOfMonth()))
				birthThisYear = LocalDate.of(currentDate.y + 1, birthday.getDate().getMonthValue(),
						birthday.getDate().getDayOfMonth());
			else
				birthThisYear = LocalDate.of(currentDate.y, birthday.getDate().getMonthValue(),
						birthday.getDate().getDayOfMonth());
			if (ChronoUnit.DAYS.between(LocalDate.now(), birthThisYear) == 0)
				label.setText(birthday.getName() + " " + birthday.getDate() + " (" + getLocalizedMessage("TODAY") + " "
						+ getLocalizedMessage("IS") + " " + (currentAge - 1) + " " + getLocalizedMessage("BIRTHDAY")
						+ ")");
			else
				label.setText(birthday.getName() + " " + birthday.getDate() + " ("
						+ ChronoUnit.DAYS.between(LocalDate.now(), birthThisYear) + " " + getLocalizedMessage("DAY")
						+ "S " + getLocalizedMessage("LEFT") + " " + getLocalizedMessage("TO_BIRTH") + " " + currentAge
						+ " " + getLocalizedMessage("YEAR") + "S)");
			if (index != 0)
				separator.setVisible(true);
			else
				separator.setVisible(false);

			// Styling
			label.setIcon(ImageEffect.getScaledImage(
					new ImageIcon(getClass().getResource("images/status/birthday.png")).getImage(), 40, 40));

			// Styling
			label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			label.setOpaque(true);
			label.setBackground(isSelected ? new Color(200, 200, 255) : Intro.grisD);
			label.setForeground(isSelected ? Color.BLACK : Color.black);
			label.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

			return this;
		}
	}

	FocusListener textFocus = new FocusListener() {

		@Override
		public void focusGained(FocusEvent e) {
			focusedComponent = e.getComponent();
			((JTextField) e.getSource()).selectAll();
		}

		@Override
		public void focusLost(FocusEvent e) {
			sumF();
			for (int i = 0; i < 16; i++)
				if (agregadoTable[i].getText().equalsIgnoreCase("Separado") && !separadoYa) {
					separadoYa = true;
					separatedDialog(false);
				}
			int index = 0;
			while (index < 16) {
				if (agregadoTable[index].getText().equalsIgnoreCase("Separado"))
					break;
				index++;
			}
			if (index == 16)
				separadoYa = false;
		}
	};
}

class CustomLineAndShapeRenderer extends LineAndShapeRenderer {
	private final double maxValue;
	private final double minValue;

	public CustomLineAndShapeRenderer(double maxValue, double minValue) {
		this.maxValue = maxValue;
		this.minValue = minValue;
		setSeriesPaint(0, Intro.lightC);
		setSeriesShapesVisible(0, true);
		setSeriesStroke(0, new BasicStroke(2.0f));
	}

	@Override
	public void drawItem(Graphics2D g2, CategoryItemRendererState state, Rectangle2D dataArea, CategoryPlot plot,
			CategoryAxis domainAxis, ValueAxis rangeAxis, CategoryDataset dataset, int row, int column, int pass) {
		// Draw the item normally (optional, can be omitted if you are drawing all
		// points yourself).
		super.drawItem(g2, state, dataArea, plot, domainAxis, rangeAxis, dataset, row, column, pass);

		// Get the value of the current item.
		Number value = dataset.getValue(row, column);
		if (value == null) {
			return; // Skip drawing if no value
		}

		// Calculate the x and y coordinates for the point.
		double x = domainAxis.getCategoryMiddle(column, getColumnCount(), dataArea, plot.getDomainAxisEdge());
		double y = rangeAxis.valueToJava2D(value.doubleValue(), dataArea, plot.getRangeAxisEdge());

		// Define the size of the circle.
		double radius = 5.0; // You can adjust this value to change the size of the circle.
		java.awt.Shape shape = new Ellipse2D.Double(x - radius, y - radius, 2 * radius, 2 * radius);

		// Save the original paint (color).
		Paint originalPaint = g2.getPaint();

		// Set a specific color for max and min points, otherwise use default paint.
		if (value.doubleValue() == maxValue) {
			g2.setPaint(Color.RED); // Red for max value.
		} else if (value.doubleValue() == minValue) {
			g2.setPaint(Color.BLUE); // Blue for min value.
		} else {
			g2.setPaint(getItemPaint(row, column)); // Default paint for other points.
		}

		// Draw the circle.
		g2.fill(shape);

		// Restore the original paint.
		g2.setPaint(originalPaint);
	}
}
