package haditech;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Employee {
	private String name;
	private LocalDate date;
	private int salary;
	private String position;

	public Employee(String name, LocalDate startDate, int salary, String position) {
		this.name = name;
		this.date = startDate;
		this.salary = salary;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public LocalDate getHireDate() {
		return date;
	}

	public int getSalary() {
		return salary;
	}

	public Date getHireDateAsDate() {
		return Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	public String getPosition() {
		return position;
	}
}
