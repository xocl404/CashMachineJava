package org.xocl404.domain.models;

import java.util.ArrayList;

public class OperationsHistoryDto extends BaseDto {
    public final ArrayList<Integer> operationsHistory;

    public OperationsHistoryDto (ArrayList<Integer> operationsHistory) {
        this.operationsHistory = operationsHistory;
    }
}
