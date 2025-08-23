package org.xocl404.domain.models;

public class User {
    private static long currentAccountNumber;

    public final long accountNumber;

    public final int pinCode;

    public User(int pinCode) {
        accountNumber = ++currentAccountNumber;
        this.pinCode = pinCode;
    }

    public User(long accountNumber, int pinCode) {
        this.accountNumber = accountNumber;
        this.pinCode = pinCode;
    }
}
