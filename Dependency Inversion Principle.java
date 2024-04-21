//************************************************************************
// Title : A Java program to demonstrate Dependency Inversion Principle.
// Author: Audity Saha, Undergraduate student, Khulna University.
//************************************************************************

import java.util.ArrayList;
import java.util.List;

/**
 * Interface representing a transaction method.
 */
interface TransactionMethod {
    /**
     * Executes a transaction.
     *
     * @param amount The amount to be transacted.
     */
    void executeTransaction(double amount);
}

/**
 * Class representing a banking system.
 */
class BankingSystem {
    private final List<TransactionMethod> transactionMethods;

    /**
     * Constructs a new BankingSystem with the given transaction methods.
     *
     * @param transactionMethods The list of transaction methods.
     */
    public BankingSystem(List<TransactionMethod> transactionMethods) {
        this.transactionMethods = transactionMethods;
    }

    /**
     * Performs a transaction using all the configured transaction methods.
     *
     * @param amount The amount to be transacted.
     */
    public void performTransaction(double amount) {
        for (TransactionMethod method : transactionMethods) {
            method.executeTransaction(amount);
        }
    }
}

/**
 * Class representing a deposit transaction method.
 */
class DepositTransaction implements TransactionMethod {
    @Override
    public void executeTransaction(double amount) {
        System.out.println("Performing deposit transaction: $" + amount);
    }
}

/**
 * Class representing a withdrawal transaction method.
 */
class WithdrawalTransaction implements TransactionMethod {
    @Override
    public void executeTransaction(double amount) {
        System.out.println("Performing withdrawal transaction: $" + amount);
    }
}

/**
 * Demo class demonstrating the usage of a banking system with different transaction methods.
 */
public class DependencyInversionPrincipleDemo {
    public static void main(String[] args) {
        // Create deposit and withdrawal transaction methods
        TransactionMethod depositMethod = new DepositTransaction();
        TransactionMethod withdrawalMethod = new WithdrawalTransaction();

        // Create a banking system with deposit and withdrawal transaction methods
        List<TransactionMethod> methods = new ArrayList<>();
        methods.add(depositMethod);
        methods.add(withdrawalMethod);
        BankingSystem bankingSystem = new BankingSystem(methods);

        // Perform a transaction using all methods
        bankingSystem.performTransaction(1000);
    }
}

/**
 * We have an interface TransactionMethod representing a method for performing transactions.
 * The DepositTransaction and WithdrawalTransaction classes implement the TransactionMethod
 * interface to represent deposit and withdrawal transaction methods, respectively.
 * The BankingSystem class represents a banking system that can perform transactions
 * using different methods. It depends on the abstraction provided by the TransactionMethod
 * interface, allowing it to use any transaction method without being coupled to specific implementations.
 * The DependencyInversionPrincipleDemo class demonstrates the usage of the banking system
 * with different transaction methods. It creates instances of DepositTransaction and WithdrawalTransaction
 * and configures the banking system with them, adhering to the Dependency Inversion Principle
 * by depending on abstractions rather than concrete implementations.
 */
