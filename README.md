#  Expense Tracker – Java Console Application

A simple Java-based expense tracker that allows users to manage daily expenses via the command line. Users can add, view, delete, filter, and save/load expenses using this project.

##  Features

- Add new expenses with amount, category, date, and description
- View all saved expenses
- Delete an expense by index
- Filter expenses by category
- Filter expenses by a date range
- View total expenses
- Save expenses to a file
- Load expenses from a file

## Technologies Used

- Java 8+
- Java IO (`PrintWriter`, `Scanner`, `File`)
- Java `LocalDate` from `java.time` for date handling
- `ArrayList` for storing expenses

##  Project Structure
#  How It Works

1. Run the `main()` method in `Expense.java`.
2. Use the menu to interact:
   - Option 1: Add a new expense
   - Option 2: View all saved expenses
   - Option 3: Delete an expense by index
   - Option 4: Filter expenses by category
   - Option 5: Filter by a date range (format: yyyy-mm-dd)
   - Option 6: View the total of all expenses
   - Option 7: Save all expenses to a file (`expenses.txt`)
   - Option 8: Load expenses from a previously saved file
   - Option 9: Exit the program

##  Notes

- The app uses a global `Scanner` object to handle user input.
- All expenses are stored in memory during runtime using an `ArrayList`.
- When saved, expenses are stored in CSV-like format in `expenses.txt`.

##  Future Improvements 

- GUI interface with JavaFX or Swing
- Export to Excel or PDF
- Expense categories as enums
- Monthly summaries and statistics
