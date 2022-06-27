public interface ConnectDataBase {

    void openConnection();

    void closeConnection();

    void testConnection();


    void readStringIndex(Data[] dates, int index);


    void checkRecordKey(String key);


    void readRecordKey(String key);

    Data[] readDataBaseRecords(int quantity, int startIndex);

    void readNumberOfRecords();

    void addRecDataBase();

    void updateValIndex();

    void updateContentRecKey();

}
