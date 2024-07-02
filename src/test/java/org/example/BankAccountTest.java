package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ResourceBundle;
import java.util.Locale; // Добавлен импорт Locale
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    public void setUp() {
        ResourceBundle messages = ResourceBundle.getBundle("ATM/messages", new Locale("ru", "RU"));
        account = new BankAccount("1234", 1000.0, messages);
    }

    @Test
    public void testDeposit() {
        account.deposit(500);
        assertEquals(1500, account.getBalance());
    }

    @Test
    public void testWithdraw() {
        account.withdraw(500);
        assertEquals(500, account.getBalance());
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(2000));
    }

    @Test
    public void testGetBalance() {
        assertEquals(1000, account.getBalance());
    }
}