package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.entry.Expense;
import seedu.entry.ExpenseCategory;
import seedu.entry.Income;
import seedu.entry.IncomeCategory;
import seedu.utility.DataManager;
import seedu.utility.FinancialTracker;
import seedu.utility.Parser;
import seedu.utility.Ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataManagerTest {

    @Test
    public void save_validEntries_correctFileContent() {
        FinancialTracker financialTracker = new FinancialTracker();
        LocalDate date = LocalDate.parse("2121-11-11", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        financialTracker.addExpense(new Expense("qwe", 12.5, ExpenseCategory.FOOD, date));
        financialTracker.addExpense(new Expense("qwe", .5, ExpenseCategory.FOOD, date));
        financialTracker.addIncome(new Income("qwe", 12.5, IncomeCategory.ALLOWANCE, date));
        financialTracker.addIncome(new Income("qwe", 12.5, IncomeCategory.ALLOWANCE, date));
        DataManager dataManager = new DataManager();
        Parser parser = new Parser();
        Ui ui = new Ui();
        dataManager.save(parser, financialTracker, ui);
    }

    @Test
    public void load_validFileContent_correctEntries() {
        save_validEntries_correctFileContent();
        Parser parser = new Parser();
        FinancialTracker financialTracker = new FinancialTracker();
        Ui ui = new Ui();
        DataManager dataManager = new DataManager();
        dataManager.load(parser, financialTracker, ui);
        assertEquals(12.5, financialTracker.getExpenses().get(0).getValue());
        assertEquals("qwe", financialTracker.getExpenses().get(0).getDescription());
        assertEquals(ExpenseCategory.FOOD, financialTracker.getExpenses().get(0).getCategory());
        
        assertEquals(.5, financialTracker.getExpenses().get(1).getValue());
        assertEquals("qwe", financialTracker.getExpenses().get(1).getDescription());

        assertEquals(12.5, financialTracker.getIncomes().get(0).getValue());
        assertEquals("qwe", financialTracker.getIncomes().get(0).getDescription());
        
        assertEquals(12.5, financialTracker.getIncomes().get(1).getValue());
        assertEquals("qwe", financialTracker.getIncomes().get(1).getDescription());
    }

    @Test
    public void load_invalidFileContent_detectInvalidDataEntriesAndOutputWarningMessages() {
        FinancialTracker financialTracker = new FinancialTracker();
        LocalDate date = LocalDate.parse("2121-11-11", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        financialTracker.addExpense(new Expense("qwe", 12.5, ExpenseCategory.FOOD, date));
        financialTracker.addIncome(new Income("qwe", 12.5, IncomeCategory.ALLOWANCE, date));
        financialTracker.addIncome(new Income("", 12.5, IncomeCategory.ALLOWANCE, date));
        DataManager dataManager = new DataManager();
        Ui ui = new Ui();
        Parser parser = new Parser();
        dataManager.save(parser, financialTracker, ui);
        dataManager.load(parser, financialTracker, ui);
    }
}