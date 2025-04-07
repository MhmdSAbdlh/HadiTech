package haditech;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import mhmdsabdlh.text.TextEffect;
import raven.toast.Notifications;

public class DataCalc {

	static String dayN = new SimpleDateFormat("dd").format(Calendar.getInstance().getTime());
	static String yearS = new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime());
	static DateModified currentDate = new DateModified(Integer.valueOf(dayN), Integer.valueOf(Intro.monthN),
			Integer.valueOf(yearS));
	static String currentpath = System.getProperty("user.dir");
	static File dataFolder = new File(currentpath + "\\data");

	/* Days Start */

	// total sell of current year
	static int dailySell() {
		int i = 0, counter = 0;
		ArrayList<String> totalMes = new ArrayList<>();
		String line = "";
		try {// open the data for currentDate.y
			File extraFolder = new File(dataFolder + "\\extra");
			File extraFile = new File(extraFolder, currentDate.y + ".dll");
			BufferedReader dataOpened = new BufferedReader(new FileReader(extraFile));
			while ((line = dataOpened.readLine()) != null) {
				totalMes.add(line.toString());
			}
			dataOpened.close();
		} catch (Exception e) {
			Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.CENTER, 2000,
					"ERROR" + e);
		}
		while (i < totalMes.size()) {
			if (TextEffect.isNumeric(totalMes.get(i)))
				counter += Integer.valueOf(totalMes.get(i));
			i++;
		}
		return counter;
	}

	// Daily average of current year
	static int dailyAvg() {
		int i = 0, counter = 0, nbOfDays = 0;
		ArrayList<String> totalMes = new ArrayList<>();
		String line = "";
		try {// open the data for currentDate.y
			File extraFolder = new File(dataFolder + "\\extra");
			File extraFile = new File(extraFolder, currentDate.y + ".dll");
			BufferedReader dataOpened = new BufferedReader(new FileReader(extraFile));
			while ((line = dataOpened.readLine()) != null) {
				totalMes.add(line.toString());
			}
			dataOpened.close();
		} catch (Exception e) {
			Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.CENTER, 2000,
					"ERROR" + e);
		}
		while (i < totalMes.size()) {
			if (TextEffect.isNumeric(totalMes.get(i))) {
				counter += Integer.valueOf(totalMes.get(i));
				nbOfDays++;
			}
			i++;
		}
		return (nbOfDays == 0 ? 0 : counter / nbOfDays);
	}

	// Average for the selected day in the while year like avg of the fridays
	static int avgSellOfDay(DateModified selectDate) {
		DateModified date2 = new DateModified(1, 1, selectDate.y);
		int i = 0, counter = 0, nbOfDays = 0;
		ArrayList<String> data = new ArrayList<>();
		String line = "";
		try {// open the data for current year
			File extraFolder = new File(dataFolder + "\\extra");
			File extraFile = new File(extraFolder, currentDate.y + ".dll");
			BufferedReader dataOpened = new BufferedReader(new FileReader(extraFile));
			while ((line = dataOpened.readLine()) != null) {
				data.add(line.toString());
			}
			dataOpened.close();
		} catch (Exception e) {
			Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.CENTER, 2000,
					"ERROR" + e);
		}
		while (i < data.size()) {
			if (dayName(selectDate, 0).equals(dayName(date2, 0)))
				if (TextEffect.isNumeric(data.get(i))) {
					counter += Integer.valueOf(data.get(i));
					nbOfDays++;
				}
			i++;
			date2 = date2.addDays(1);
		}
		return (nbOfDays == 0 ? 0 : counter / nbOfDays);
	}

	// Min and Max according to the selected day for the entire year
	static int[] maxAccDay(String day, int year) {
		DateModified date2 = new DateModified(1, 1, year);
		int i = 0;
		int[] minmax = { 0, 0 };
		ArrayList<String> data = new ArrayList<>();
		String line = "";
		try {// open the data for current year
			File extraFolder = new File(dataFolder + "\\extra");
			File extraFile = new File(extraFolder, year + ".dll");
			BufferedReader dataOpened = new BufferedReader(new FileReader(extraFile));
			while ((line = dataOpened.readLine()) != null) {
				data.add(line.toString());
			}
			dataOpened.close();
		} catch (Exception e) {
			Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.CENTER, 2000,
					"ERROR" + e);
		}
		ArrayList<Integer> dayValue = new ArrayList<>();
		while (i < data.size()) {
			if (day.equalsIgnoreCase(dayName(date2, 2)))
				if (TextEffect.isNumeric(data.get(i))) {
					dayValue.add(Integer.valueOf(data.get(i)));
				}
			i++;
			date2 = date2.addDays(1);
		}
		i = 0;
		if (dayValue.size() == 0) {
			minmax[0] = -1;
			minmax[1] = -1;
			return minmax;
		}
		while (i < dayValue.size()) {
			if (dayValue.get(i) > minmax[0])
				minmax[0] = dayValue.get(i);
			i++;
		}
		i = 0;
		minmax[1] = dayValue.get(i);
		while (i < dayValue.size()) {
			if (dayValue.get(i) < minmax[1])
				minmax[1] = dayValue.get(i);
			i++;
		}
		return minmax;
	}

	// Average for the selected day for the year
	static int avgSpeDay(String day, int year) {
		DateModified date2 = new DateModified(1, 1, year);
		int i = 0, counter = 0, nbOfDays = 0;
		ArrayList<String> data = new ArrayList<>();
		String line = "";
		try {// open the data for current year
			File extraFolder = new File(dataFolder + "\\extra");
			File extraFile = new File(extraFolder, year + ".dll");
			BufferedReader dataOpened = new BufferedReader(new FileReader(extraFile));
			while ((line = dataOpened.readLine()) != null) {
				data.add(line.toString());
			}
			dataOpened.close();
		} catch (Exception e) {
			Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.CENTER, 2000,
					"ERROR" + e);
		}
		while (i < data.size()) {
			if (day.equalsIgnoreCase(dayName(date2, 2)))
				if (TextEffect.isNumeric(data.get(i))) {
					counter += Integer.valueOf(data.get(i));
					nbOfDays++;
				}
			i++;
			date2 = date2.addDays(1);
		}
		return (nbOfDays == 0 ? 0 : counter / nbOfDays);
	}

	// The value of the sell for the previous years
	static int sellSelectdYear(int d, int year) {
		DateModified date = new DateModified(1, 1, year);
		String dateY[] = new String[366];
		for (int i = 0; i < 366; i++) {
			dateY[i] = date.d + "" + date.m;
			date = date.addDays(1);
		}
		String valueY[] = new String[366];
		try {
			File extraFolder = new File(dataFolder + "\\extra");
			File yearFile = new File(extraFolder, year + ".dll");
			BufferedReader dataOpened = new BufferedReader(new FileReader(yearFile));
			String line = "";
			int z = 0;
			while ((line = dataOpened.readLine()) != null) {
				valueY[z] = line.toString();
				z++;
			}
			dataOpened.close();
		} catch (Exception e) {
		}
		int numero = 0;
		for (int i = 0; i < 366; i++) {
			if (Integer.valueOf(dateY[i]) == d) {
				numero = i;
				break;
			}
		}
		return !TextEffect.isNumeric(valueY[numero]) ? -1 : Integer.valueOf(valueY[numero]);
	}

	// return the max of the year
	static int[] yearMaxMin(int year) {
		ArrayList<String> data = new ArrayList<>();
		String line = "";
		try {// open the data for current year
			File extraFolder = new File(dataFolder + "\\extra");
			File extraFile = new File(extraFolder, year + ".dll");
			BufferedReader dataOpened = new BufferedReader(new FileReader(extraFile));
			while ((line = dataOpened.readLine()) != null) {
				data.add(line.toString());
			}
			dataOpened.close();
		} catch (Exception e) {
			Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.CENTER, 2000,
					"ERROR" + e);
		}
		int[] returned = { 0, 0, 0, 0, 0, 0 };
		if (data.size() > 0) {
			int avgTemp = 0;
			int voidNumber = 0;
			for (String element : data) {
				if (TextEffect.isNumeric(element))
					avgTemp += Integer.valueOf(element);
				else
					voidNumber++;
			}
			avgTemp /= (data.size() - voidNumber);
			int i = 0;
			int[] finalData = new int[data.size()];
			while (i < data.size()) {
				if (TextEffect.isNumeric(data.get(i)))
					finalData[i] = Integer.valueOf(data.get(i));
				else
					finalData[i] = avgTemp;
				i++;
			}
			returned[0] = getMaxValue(finalData)[0];// max value
			returned[1] = getMinValue(finalData)[0];// min value
			returned[2] = getMaxValue(finalData)[1];// max index
			returned[3] = getMinValue(finalData)[1];// min index
			returned[4] = valueCounter(finalData, returned[0]);// max count
			returned[5] = valueCounter(finalData, returned[1]);// min count
		}
		return returned;
	}

	/* Days End */

	/* Month Start */

	// Average for the selected day for the given month
	static int avgSpeDayAccMonth(String day, int month) {
		DateModified date2 = new DateModified(1, month, currentDate.y);
		int i = date2.index(), counter = 0, nbOfDays = 0, maxDays = i + date2.maxDays();
		ArrayList<String> totalMes = new ArrayList<>();
		String line = "";
		try {// open the data for currentDate
			File extraFolder = new File(dataFolder + "\\extra");
			File extraFile = new File(extraFolder, currentDate.y + ".dll");
			BufferedReader dataOpened = new BufferedReader(new FileReader(extraFile));
			while ((line = dataOpened.readLine()) != null) {
				totalMes.add(line.toString());
			}
			dataOpened.close();
		} catch (Exception e) {
			Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.CENTER, 2000,
					"ERROR" + e);
		}
		while (i < maxDays && i < totalMes.size()) {
			if (day.equalsIgnoreCase(dayName(date2, 2)))
				if (TextEffect.isNumeric(totalMes.get(i))) {
					counter += Integer.valueOf(totalMes.get(i));
					nbOfDays++;
				}
			i++;
			date2 = date2.addDays(1);
		}
		return (nbOfDays == 0 ? 0 : counter / nbOfDays);
	}

	// return the max, min and its index for the given month
	static int[] maxMinMes(int month) {
		DateModified tempDate = new DateModified(1, month, currentDate.y);
		int index = tempDate.index();
		int averageM = totalOfMes(month, currentDate.y)[1] == 0 ? 0
				: totalOfMes(month, currentDate.y)[0] / totalOfMes(month, currentDate.y)[1];
		int returned[] = { 0, 0, 0, 0, 0, 0 };
		ArrayList<String> totalMes = new ArrayList<>();
		String line = "";
		try {// open the data for current year
			File extraFolder = new File(dataFolder + "\\extra");
			File extraFile = new File(extraFolder, currentDate.y + ".dll");
			BufferedReader dataOpened = new BufferedReader(new FileReader(extraFile));
			while ((line = dataOpened.readLine()) != null) {
				totalMes.add(line.toString());
			}
			dataOpened.close();
		} catch (Exception e) {
			Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.CENTER, 2000,
					"ERROR" + e);
		}
		int[] valuesMes = new int[tempDate.maxDays()];
		int count = 0;
		for (int i = index; i < index + tempDate.maxDays(); i++) {
			if (i < totalMes.size())
				if (TextEffect.isNumeric(totalMes.get(i)))
					valuesMes[count] = Integer.valueOf(totalMes.get(i));
				else
					valuesMes[count] = averageM;
			else
				valuesMes[count] = averageM;
			count++;
		}
		returned[0] = getMaxValue(valuesMes)[0];// max
		returned[1] = getMinValue(valuesMes)[0];// min
		returned[2] = getMaxValue(valuesMes)[1] + index + 1;// maxDay index(day+index month)
		returned[3] = getMinValue(valuesMes)[1] + index + 1;// minday index(day+index month)
		returned[4] = valueCounter(valuesMes, returned[0]);// max counter
		returned[5] = valueCounter(valuesMes, returned[1]);// min counter

		return returned;
	}

	// return the total for month[0], and the quantity of days[1]
	static int[] totalOfMes(int month, int year) {
		DateModified dateM = new DateModified(1, month, year);
		int index = dateM.index();
		int returned[] = { 0, 0 };
		ArrayList<String> data = new ArrayList<>();
		String line = "";
		try {// open the data for current year
			File extraFolder = new File(dataFolder + "\\extra");
			File extraFile = new File(extraFolder, year + ".dll");
			BufferedReader dataOpened = new BufferedReader(new FileReader(extraFile));
			while ((line = dataOpened.readLine()) != null) {
				data.add(line.toString());
			}
			dataOpened.close();
		} catch (Exception e) {
			Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.CENTER, 2000,
					"ERROR" + e);
		}
		for (int i = index; i < index + dateM.maxDays(); i++) {
			if (i < data.size() && TextEffect.isNumeric(data.get(i))) {
				returned[0] += Integer.valueOf(data.get(i));
				returned[1]++;
			}
		}
		return returned;
	}

	// return the total for month[0], and the quantity of days[1]
	static ArrayList<Integer> sellOfMonth(int month) {
		DateModified dateM = new DateModified(1, month, currentDate.y);
		int index = dateM.index();
		ArrayList<String> totalMes = new ArrayList<>();
		ArrayList<Integer> sellValue = new ArrayList<>();
		String line = "";
		try {// open the data for current year
			File extraFolder = new File(dataFolder + "\\extra");
			File extraFile = new File(extraFolder, currentDate.y + ".dll");
			BufferedReader dataOpened = new BufferedReader(new FileReader(extraFile));
			while ((line = dataOpened.readLine()) != null) {
				totalMes.add(line.toString());
			}
			dataOpened.close();
		} catch (Exception e) {
			Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.CENTER, 2000,
					"ERROR" + e);
		}

		for (int i = index; i < index + dateM.maxDays(); i++) {
			if (i < totalMes.size())
				if (TextEffect.isNumeric(totalMes.get(i)))
					sellValue.add(Integer.valueOf(totalMes.get(i)));
				else if (totalMes.get(i).isBlank())
					sellValue.add(null);
		}
		return sellValue;
	}

	// function to write the total/average min and max for the anteriours months
	static String[] monthsText(int month, int year, int language) {
		DateModified dateFromMonth = new DateModified(Integer.valueOf(dayN), month, year);
		int monthsCount = year == currentDate.y ? dateFromMonth.whatMonthsToAdd() + 1 : 12;
		int avgOfMonths[] = new int[monthsCount];
		int totalOfMonths[] = new int[monthsCount];
		int indexOfMonth = 0;
		// average of every month
		if (monthsCount == 0)
			return null;
		while (indexOfMonth < monthsCount) {
			avgOfMonths[indexOfMonth] = totalOfMes(indexOfMonth + 1, year)[1] == 0 ? 0
					: totalOfMes(indexOfMonth + 1, year)[0] / totalOfMes(indexOfMonth + 1, year)[1];
			totalOfMonths[indexOfMonth] = totalOfMes(indexOfMonth + 1, year)[0];
			indexOfMonth++;
		}
		// max month
		int maxMonth = 0, maxDay = 0;
		maxMonth = getMaxValue(avgOfMonths)[0];
		indexOfMonth = 0;
		while (indexOfMonth < monthsCount) {
			if (maxMonth == avgOfMonths[indexOfMonth])
				break;
			indexOfMonth++;
		}
		maxDay = indexOfMonth;
		// min month
		int minMonth = 0, minDay = 0;
		minMonth = getMinValue(avgOfMonths)[0];
		indexOfMonth = 0;
		while (indexOfMonth < monthsCount) {
			if (minMonth == avgOfMonths[indexOfMonth])
				break;
			indexOfMonth++;
		}
		minDay = indexOfMonth;

		// return the result
		String temp[] = new String[16];
		indexOfMonth = 0;
		while (indexOfMonth < 12) {
			if (indexOfMonth < monthsCount)
				if (language == 0)
					temp[indexOfMonth] = "EN " + getMonthForInt(indexOfMonth, 0) + " VENDISTE R$"
							+ totalOfMonths[indexOfMonth] + " (PROMEDIO = R$" + avgOfMonths[indexOfMonth] + ")\n";
				else if (language == 1)
					temp[indexOfMonth] = "EM " + getMonthForInt(indexOfMonth, 1) + " VENDEU R$"
							+ totalOfMonths[indexOfMonth] + " (MÉDIA = R$" + avgOfMonths[indexOfMonth] + ")\n";
				else if (language == 2)
					temp[indexOfMonth] = "IN " + getMonthForInt(indexOfMonth, 2) + " YOU SOLD R$"
							+ totalOfMonths[indexOfMonth] + " (AVERAGE = R$" + avgOfMonths[indexOfMonth] + ")\n";
				else
					temp[indexOfMonth] = "EN " + getMonthForInt(indexOfMonth, 3) + " TU AS VENDU R$"
							+ totalOfMonths[indexOfMonth] + " (MOYENNE = R$" + avgOfMonths[indexOfMonth] + ")\n";
			else
				temp[indexOfMonth] = "";
			indexOfMonth++;
		} // temp [0] ->[11] total + avg of jan to dec
		temp[12] = "" + maxMonth;// max of all months
		temp[13] = "" + minMonth;// min of all months
		temp[14] = "" + maxDay;// index of max(month-1)
		temp[15] = "" + minDay;// index of min(month-1)
		return temp;
	}

	// return the month number according to the index
	static int monthFromIndex(int index) {
		int indexMonths[] = new int[12];
		int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		indexMonths[0] = 31;
		for (int i = 1; i < 12; i++)
			indexMonths[i] = daysInMonth[i] + indexMonths[i - 1];

		int indexTrue = 0;
		while (indexTrue < 12) {
			if (index < indexMonths[indexTrue])
				break;
			indexTrue++;
		}
		return (indexTrue + 1);
	}

	private static String getMonthForInt(int num, int language) {
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

	/* Month End */

	/* General Functions */
	// Day name according to the date(monday,...)
	static String dayName(DateModified d, int lang) {
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

	// getting the maximum value [0] and the index [1]
	static int[] getMaxValue(int[] array) {
		int index[] = { 0, 0 };
		index[0] = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > index[0]) {
				index[0] = array[i];
				index[1] = i;
			}
		}
		return index;
	}

	// getting the miniumum value [0] and the index [1]
	static int[] getMinValue(int[] array) {
		int index[] = { 0, 0 };
		index[0] = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < index[0]) {
				index[0] = array[i];
				index[1] = i;
			}
		}
		return index;
	}

	// return the times that a value occurs
	static int valueCounter(int[] ventas, int value) {
		int counter = 0;
		if (ventas.length > 0) {
			for (int element : ventas) {
				if (value == element)
					counter++;
			}
		}
		return counter;
	}

}
