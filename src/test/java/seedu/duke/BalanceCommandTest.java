package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.entry.Expense;
import seedu.entry.ExpenseCategory;
import seedu.entry.Income;
import seedu.entry.IncomeCategory;
import seedu.utility.FinancialTracker;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BalanceCommandTest {
    private FinancialTracker testTracker = new FinancialTracker();
    
    @Test
    public void execute_twoValidDateInputs_validTotalSum() {
        Income testIncome = new Income("Salary", 400.00, IncomeCategory.SALARY);
        Expense testExpense = new Expense("Burger", 500.00, ExpenseCategory.FOOD);
        testTracker.addIncome(testIncome);
        testTracker.addExpense(testExpense);
        assertEquals(-100.00, testTracker.getBalance());
    }
}