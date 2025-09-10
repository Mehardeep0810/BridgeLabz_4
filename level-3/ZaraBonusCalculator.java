package Assigned4.level3;

public class ZaraBonusCalculator {

    public static double[][] generateEmployeeData(int count) {
        double[][] data = new double[count][2]; 
        for (int i = 0; i < count; i++) {
            int salary = (int)(Math.random() * 90000) + 10000; 
            int years = (int)(Math.random() * 11); 
            data[i][0] = salary;
            data[i][1] = years;
        }
        return data;
    }

    public static double[][] calculateBonusAndNewSalary(double[][] employeeData) {
        double[][] result = new double[employeeData.length][2]; 
        for (int i = 0; i < employeeData.length; i++) {
            double salary = employeeData[i][0];
            int years = (int)employeeData[i][1];
            double bonusRate = years > 5 ? 0.05 : 0.02;
            double bonus = salary * bonusRate;
            double newSalary = salary + bonus;
            result[i][0] = bonus;
            result[i][1] = newSalary;
        }
        return result;
    }

    public static void displaySummary(double[][] employeeData, double[][] bonusData) {
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;

        System.out.printf("%-10s %-15s %-15s %-15s %-15s%n", "EmpID", "Old Salary", "Years of Service", "Bonus", "New Salary");
        System.out.println("--------------------------------------------------------------------------");

        for (int i = 0; i < employeeData.length; i++) {
            double oldSalary = employeeData[i][0];
            int years = (int)employeeData[i][1];
            double bonus = bonusData[i][0];
            double newSalary = bonusData[i][1];

            totalOldSalary += oldSalary;
            totalBonus += bonus;
            totalNewSalary += newSalary;

            System.out.printf("Emp%-7d ₹%-13.2f %-15d ₹%-13.2f ₹%-13.2f%n", i + 1, oldSalary, years, bonus, newSalary);
        }

        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("Total Old Salary: ₹%.2f%n", totalOldSalary);
        System.out.printf("Total Bonus Paid: ₹%.2f%n", totalBonus);
        System.out.printf("Total New Salary: ₹%.2f%n", totalNewSalary);
    }

    public static void main(String[] args) {
        int employeeCount = 10;
        double[][] employeeData = generateEmployeeData(employeeCount);
        double[][] bonusData = calculateBonusAndNewSalary(employeeData);
        displaySummary(employeeData, bonusData);
    }
}
