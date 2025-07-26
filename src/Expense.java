import java.time.LocalDate;
import java.util.*;
import java.io.*;

public class Expense {
	static Scanner sc = new Scanner(System.in);
	double amount;
    String category;
    LocalDate date;
    String description;
       
    public Expense(double amount, String category, LocalDate date, String description) {
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.description = description;
    }
    public static void addExpense(ArrayList<Expense> expenses) {
        try {
            System.out.print("Enter amount: ");
            double amount = sc.nextDouble();
            sc.nextLine(); // consume leftover newline

            System.out.print("Enter category: ");
            String category = sc.nextLine();

            System.out.print("Enter date (yyyy-mm-dd): ");
            LocalDate date = LocalDate.parse(sc.nextLine());

            System.out.print("Enter description: ");
            String description = sc.nextLine();

            Expense e = new Expense(amount, category, date, description);
            expenses.add(e);

            System.out.println("Expense added successfully!");
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public void display() {
        System.out.println("Amount: ₹" + amount);
        System.out.println("Category: " + category);
        System.out.println("Date: " + date);
        System.out.println("Description: " + description);
        System.out.println("-------------------------");
    }
    public static void viewExpenses(ArrayList<Expense> expenses) {
        if (expenses.isEmpty()) {
            System.out.println("No expenses to show.");
            return;
        }

        System.out.println("--- All Expenses ---");
        for (int i = 0; i < expenses.size(); i++) {
            System.out.println("Index: " + i);
            expenses.get(i).display();
        }
    }

    public static void deleteExpense(ArrayList<Expense> expenses) {
        if (expenses.isEmpty()) {
            System.out.println("No expenses to delete.");
            return;
        }

        System.out.println("--- Delete Expense ---");
        for (int i = 0; i < expenses.size(); i++) {
            System.out.println("Index: " + i);
            expenses.get(i).display();
        }

        System.out.print("Enter index to delete: ");
        int idx = sc.nextInt();

        if (idx >= 0 && idx < expenses.size()) {
            expenses.remove(idx);
            System.out.println("Expense deleted successfully!");
        } else {
            System.out.println("Invalid index!");
        }
    }
    public static void filterByCategory(ArrayList<Expense> expenses) {
        System.out.print("Enter category to filter: ");
        String category = sc.nextLine().toLowerCase();

        boolean found = false;
        for (int i = 0; i < expenses.size(); i++) {
            if (expenses.get(i).category.toLowerCase().equals(category)) {
                expenses.get(i).display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No expenses found for category: " + category);
        }
    }
    public static void filterByDateRange(ArrayList<Expense> expenses) {
        try {
            System.out.print("Enter start date (yyyy-mm-dd): ");
            LocalDate start = LocalDate.parse(sc.nextLine());

            System.out.print("Enter end date (yyyy-mm-dd): ");
            LocalDate end = LocalDate.parse(sc.nextLine());

            boolean found = false;
            for (int i = 0; i < expenses.size(); i++) {
                LocalDate expenseDate = expenses.get(i).date;

                if ((expenseDate.isEqual(start) || expenseDate.isAfter(start)) &&
                    (expenseDate.isEqual(end) || expenseDate.isBefore(end))) {

                    expenses.get(i).display();
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No expenses found in that date range.");
            }
        } catch (Exception ex) {
            System.out.println("Invalid date format!");
        }
    }
    public static void viewTotal(ArrayList<Expense> expenses) {
        double total = 0;
        for (int i = 0; i < expenses.size(); i++) {
            total += expenses.get(i).amount;
        }
        System.out.println("Total Expense: ₹" + total);
    }
    public static void saveToFile(ArrayList<Expense> expenses) {
        try {
            PrintWriter pw = new PrintWriter("expenses.txt");
            for (int i = 0; i < expenses.size(); i++) {
                Expense e = expenses.get(i);
                pw.println(e.amount + "," + e.category + "," + e.date + "," + e.description);
            }
            pw.close();
            System.out.println("Expenses saved to expenses.txt");
        } catch (IOException ex) {
            System.out.println("Error saving file: " + ex.getMessage());
        }
    }
    public static void loadFromFile(ArrayList<Expense> expenses) {
        expenses.clear();

        try {
            File file = new File("expenses.txt");
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",", 4);
                double amount = Double.parseDouble(parts[0]);
                String category = parts[1];
                LocalDate date = LocalDate.parse(parts[2]);
                String description = parts[3];

                Expense e = new Expense(amount, category, date, description);
                expenses.add(e);
            }

            fileScanner.close();
            System.out.println("Expenses loaded from file.");
        } catch (Exception ex) {
            System.out.println("Error loading file: " + ex.getMessage());
        }
    }

	public static void main(String[] args) {

		        ArrayList<Expense> expenses = new ArrayList<>();

		        while (true) {
		            System.out.println("\n===== Expense Tracker =====");
		            System.out.println("1. Add Expense");
		            System.out.println("2. View All Expenses");
		            System.out.println("3. Delete Expense");
		            System.out.println("4. Filter by Category");
		            System.out.println("5. Filter by Date Range");
		            System.out.println("6. View Total Expense");
		            System.out.println("7. Save to File");
		            System.out.println("8. Load from File");
		            System.out.println("9. Exit");
		            System.out.print("Enter your choice: ");

		            int choice = sc.nextInt();
		            sc.nextLine();  // consume leftover newline

		            switch (choice) {
		                case 1:
		                    addExpense(expenses);
		                    break;
		                case 2:
		                    viewExpenses(expenses);
		                    break;
		                case 3:
		                    deleteExpense(expenses);
		                    break;
		                case 4:
		                    filterByCategory(expenses);
		                    break;
		                case 5:
		                    filterByDateRange(expenses);
		                    break;
		                case 6:
		                    viewTotal(expenses);
		                    break;
		                case 7:
		                    saveToFile(expenses);
		                    break;
		                case 8:
		                    loadFromFile(expenses);
		                    break;
		                case 9:
		                    System.out.println("Exiting... Goodbye!");
		                    return;
		                default:
		                    System.out.println("Invalid choice. Please try again.");
		            }
		        }
		    }
		}
