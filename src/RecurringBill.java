package haditech;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class RecurringBill {
	private String description;
	private LocalDate nextDueDate;
	private RecurrenceType recurrenceType;
	private int dayOfMonth; // For monthly recurrence
	private DayOfWeek dayOfWeek; // For weekly recurrence

	public RecurringBill(String description, LocalDate creationDate, RecurrenceType recurrenceType, int dayOfMonth,
			DayOfWeek dayOfWeek) {
		this.description = description;
		this.recurrenceType = recurrenceType;
		this.dayOfMonth = dayOfMonth;
		this.dayOfWeek = dayOfWeek;
	}

	public String getDescription() {
		return description;
	}

	public LocalDate getNextDueDate() {
		return nextDueDate;
	}

	// Method to calculate the next due date based on recurrence type
	public void calculateNextDueDate() {
		if (recurrenceType == RecurrenceType.MONTHLY) {
			nextDueDate = getNextMonthlyDate(dayOfMonth);
		} else if (recurrenceType == RecurrenceType.WEEKLY) {
			nextDueDate = getNextWeeklyDate(dayOfWeek);
		}
	}

	// Helper method to get the next occurrence of a weekly recurring bill
	private LocalDate getNextWeeklyDate(DayOfWeek dayOfWeek) {
		LocalDate today = LocalDate.now();
		LocalDate nextDue = today.with(dayOfWeek);
		if (today.isAfter(nextDue)) {
			nextDue = nextDue.plusWeeks(1);
		}
		return nextDue;
	}

	// Helper method to get the next occurrence of a bill due monthly
	public static LocalDate getNextMonthlyDate(int dayOfMonth) {
		LocalDate today = LocalDate.now();
		LocalDate nextDueDate;

		// Try to set the given day in the current month
		try {
			nextDueDate = today.withDayOfMonth(dayOfMonth);
		} catch (DateTimeException e) {
			nextDueDate = today.with(TemporalAdjusters.lastDayOfMonth());
		}

		// If today is after the calculated date, move to next month
		if (today.isAfter(nextDueDate)) {
			nextDueDate = today.plusMonths(1).withDayOfMonth(1); // Move to next month

			try {
				nextDueDate = nextDueDate.withDayOfMonth(dayOfMonth);
			} catch (DateTimeException e) {
				nextDueDate = nextDueDate.with(TemporalAdjusters.lastDayOfMonth());
			}
		}
		// Special case: February 29th on a non-leap year
		if (dayOfMonth == 29 && nextDueDate.getMonthValue() == 2 && !nextDueDate.isLeapYear()) {
			nextDueDate = nextDueDate.withDayOfMonth(28);
		}
		return nextDueDate;
	}
}

//Enum to represent the type of recurrence (Weekly or Monthly)
enum RecurrenceType {
	WEEKLY, MONTHLY
}