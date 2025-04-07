package haditech;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import raven.toast.Notifications;

public class DateModified {
	static int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	public int m;
	public int d;
	public int y;

	String currentpath = System.getProperty("user.dir");
	File dataFolder = new File(currentpath + "\\data");
	File extraFolder = new File(dataFolder + "\\extra");
	File yearFile = new File(extraFolder, y + ".dll");

	DateModified(int d, int m, int y) {
		this.d = d;
		this.m = m;
		this.y = y;
	}

	LocalDate toLocalDate() {
		return LocalDate.of(y, m, d);
	}

	int dayFromIndex(int index) {// return the day in the month according to the index
		int indexMonths[] = new int[12];
		indexMonths[0] = daysInMonth[0];
		for (int i = 1; i < 12; i++)
			indexMonths[i] = daysInMonth[i] + indexMonths[i - 1];
		int indexTrue = 0;
		while (indexTrue < 12) {
			if (index < indexMonths[indexTrue])
				break;
			indexTrue++;
		}
		if (indexTrue == 0)
			return index + 1;
		else
			return index - indexMonths[indexTrue - 1] + 1;
	}

	int maxDays() {
		return daysInMonth[m - 1];
	}

	int index() {
		int index = 0;
		for (int i = 0; i < m - 1; i++)
			index += daysInMonth[i];
		return index;
	}

	int weekNumber() {
		if (d < 8)
			return 1;
		else if (d < 15)
			return 2;
		else if (d < 22)
			return 3;
		else if (d < 29)
			return 4;
		else
			return 5;
	}

	DateModified addDays(int n) {
		int d = this.d += n;
		int m = this.m;
		int y = this.y;
		while (d > maxDays()) {
			d = d - maxDays();
			m++;
			if (m > 12) {
				y++;
				m = 1;
			}
		}
		return new DateModified(d, m, y);
	}

	int whatMonthsToAdd() {// return number of months to be added -1
		int k = 0;
		DateModified date = new DateModified(1, 1, y);
		int index = this.index();
		while (date.index() < index) {
			k++;
			date = new DateModified(1, k + 1, y);
		}
		return k;
	}

	String getMonthForInt(int language) {
		String months[][] = {
				{ "enero", "febrero", "marzo", "Abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre",
						"noviembre", "diciembre" },
				{ "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro",
						"Novembro", "Dezembro" },
				{ "January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
						"November", "December" },
				{ "janvier", "février", "mars", "avril", "mai", "juin", "juillet", "août", "septembre", "octobre",
						"novembre", "décembre" } };
		return months[language][m - 1].toUpperCase();
	}

	String getToday() {
		return (d < 10 ? "0" + d : d) + "/" + (m < 10 ? "0" + m : m) + "/" + y;
	}

	String getYesterday() {
		if (d > 1)
			return (d < 11 ? "0" + (d - 1) : (d - 1)) + "/" + (m < 10 ? "0" + m : m) + "/" + y;
		else if (m > 1)
			return daysInMonth[m - 2] + "/" + ((m - 1) < 10 ? "0" + (m - 1) : (m - 1)) + "/" + y;
		else
			return 31 + "/" + 12 + "/" + (y - 1);
	}

	String getLastWeek() {
		if (d > 7)
			return (d < 17 ? "0" + (d - 7) : (d - 7)) + "/" + (m < 10 ? "0" + m : m) + "/" + y;
		else if (m > 1)
			return (daysInMonth[m - 2] - d) + "/" + ((m - 1) < 10 ? "0" + (m - 1) : (m - 1)) + "/" + y;
		else
			return (31 - d) + "/" + 12 + "/" + (y - 1);
	}

	String getLastMonth() {
		if (m > 1)
			return (d < daysInMonth[m - 2] ? (d < 10 ? "0" + d : d) : daysInMonth[m - 2]) + "/"
					+ ((m - 1) < 10 ? "0" + (m - 1) : (m - 1)) + "/" + y;
		else
			return (d < 10 ? "0" + d : d) + "/" + 12 + "/" + (y - 1);
	}

	String getLastYear() {
		return (d < 10 ? "0" + d : d) + "/" + (m < 10 ? "0" + m : m) + "/" + (y - 1);
	}

	String dayName(int lang) {
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

	/* Day name according to the date(monday,...) */
	String dayName(String date, String formatter, int lang) {
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

	boolean isValidDate(String dateStr, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		sdf.setLenient(false);

		try {
			@SuppressWarnings("unused")
			Date date = sdf.parse(dateStr);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	void saveToday(int total) {
		// save what will rest for tmrw
		BufferedReader data = null;
		String line = "";
		dataFolder.mkdir();
		extraFolder.mkdir();
		File yearFile = new File(extraFolder, y + ".dll");
		ArrayList<String> dataAL = new ArrayList<>();
		try {// open the data for currentDate
			data = new BufferedReader(new FileReader(yearFile));
			while ((line = data.readLine()) != null) {
				dataAL.add(line.toString());
			}
			data.close();
		} catch (Exception e) {
			writeError(e);
		}
		/* save the data */
		try {
			FileWriter save = new FileWriter(yearFile);
			int count = 0, dataCount = dataAL.size();
			for (String element : dataAL) /* Write the data */
				if (count++ < (index() + Integer.valueOf(d)) - 1) /* Write the data without today if exists */
					save.write(element + System.lineSeparator());
			while (dataCount++ < (this.index() + Integer.valueOf(d) - 1))
				save.write(System.lineSeparator()); /* Write the days that we did not open as void */
			save.write(total + System.lineSeparator());/* Write the current day */
			save.close();
		} catch (Exception e2) {
			writeError(e2);
		}
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
			Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.CENTER, 2000,
					"ERROR" + e.getMessage());
		} catch (IOException e1) {
			writeError(e1);
			return; // Stop execution if writing fails
		}
	}
}
