package ru.mg.fanout.rest.model;


import ru.mg.accountservice.Account;

import java.util.List;
import java.util.Objects;

public class AccountsResponse {

    private final int count;
    private final List<Account> accountResponses;

    public AccountsResponse(int count, List<Account> accountResponses) {
        this.count = count;
        this.accountResponses = accountResponses;
    }

    public int getCount() {
        return count;
    }

    public List<Account> getAccountResponses() {
        return accountResponses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountsResponse that = (AccountsResponse) o;
        return count == that.count &&
                accountResponses.equals(that.accountResponses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, accountResponses);
    }
}
