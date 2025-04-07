package haditech;

import java.time.LocalDate;

public class Holiday {
	private String name;
	private LocalDate date;
	private HolidayType type;

	// Enum to represent the type of recurrence (Weekly or Monthly)
	enum HolidayType {
		ISLAMIC, WORLDWIDE, URUGUAY, BRAZIL
	}

	public Holiday(String name, LocalDate date, HolidayType type) {
		this.name = name;
		this.date = date;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public LocalDate getDate() {
		return date;
	}

	public HolidayType getType() {
		return type;
	}
}
