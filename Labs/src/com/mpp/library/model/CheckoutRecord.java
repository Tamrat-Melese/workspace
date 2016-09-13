package com.mpp.library.model;

import java.util.ArrayList;
import java.util.List;

public class CheckoutRecord {
    private List<CheckoutRecordEntry> recordEntries;

    public CheckoutRecord() {
        recordEntries = new ArrayList<>();
    }

}
