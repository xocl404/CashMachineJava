package org.xocl404.infrastructure.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataBase {
    public Map<Long, Integer> userList = new HashMap<>();

    public Map<Long, Integer> accountList = new HashMap<>();

    public Map<Long, ArrayList<Integer>> operationList = new HashMap<>();
}
