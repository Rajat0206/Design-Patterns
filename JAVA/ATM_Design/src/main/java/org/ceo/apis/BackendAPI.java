package org.ceo.apis;

public interface BackendAPI {
    int createTransaction();
    boolean updateState();
    double getATMAmount(String atmId);
}
