package org.ceo.apis;

public interface ATMBackendAPI {
    int createTransaction();
    boolean updateState();
    double getATMAmount(String atmId);
}
