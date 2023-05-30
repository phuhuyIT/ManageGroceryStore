package Model;

import java.time.LocalDate;

public class monthlySalary {
    private int ID;
    private int workingHours;
    private int overtimeHours;
    private float allowance;
    private float deduction;
    private LocalDate monthSalary;

    public monthlySalary(int ID, LocalDate monthSalary, int workingHours, int overtimeHours, float allowance, float deduction) {
        this.ID = ID;
        this.workingHours = workingHours;
        this.overtimeHours = overtimeHours;
        this.allowance = allowance;
        this.deduction = deduction;
        this.monthSalary = monthSalary;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    public int getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(int overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    public float getAllowance() {
        return allowance;
    }

    public void setAllowance(float allowance) {
        this.allowance = allowance;
    }

    public float getDeduction() {
        return deduction;
    }

    public void setDeduction(float deduction) {
        this.deduction = deduction;
    }

    public LocalDate getMonthSalary() {
        return monthSalary;
    }

    public void setMonthSalary(LocalDate monthSalary) {
        this.monthSalary = monthSalary;
    }
}
