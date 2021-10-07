package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.entry.Expense;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpenseTest {

    @Test
    public void getDescription_stringDescription_returnsDescription() {
        Expense e1 = new Expense("Bubble tea", 4.8);
        assertEquals("Bubble tea", e1.getDescription());
    }

    @Test
    public void getValue_valueInputOfTypeDouble_returnsValueInput() {
        Expense e1 = new Expense("Bubble tea", 4.8);
        assertEquals(4.8, e1.getValue());
    }
}