package dao;

import java.util.ArrayList;

public interface BulkInsertDao {

    public boolean bulkInsert(ArrayList<ArrayList<String>> arr, String type);
}
