import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class ReadData implements ConnectDataBase {
    public Data[] dates = readFile();


    @Override
    public void openConnection() {
        System.out.println("����������� � ���� ������...");
    }

    @Override
    public void closeConnection() {
        System.out.println("�������� ����������...");
    }

    @Override
    public void testConnection() {
        if (dates[0].getKey().isEmpty()) {
            System.out.println("������ �����������! ��������� ��� ���!");
        } else {
            System.out.println("����������� �������!");
        }
    }


    @Override
    public void readStringIndex(int index) {
        System.out.printf("���������� ������ �� �������...%n �����: key: %s value: %s", dates[index].getKey(), dates[index].getValue());
    }

    @Override
    public void checkRecordKey(String key) {
        for (int i = 0; i < dates.length; i++) {
            if (Objects.equals(dates[i].getKey(), key.toUpperCase())) {
                System.out.println("������� ������!");
            } else {
                System.out.println("������� �� ������!");
            }

        }

    }

    @Override
    public void readRecordKey(String key) {
        for (int i = 0; i < dates.length; i++) {
            if (Objects.equals(dates[i].getKey(), key)) {
                System.out.println("������� ������!" + dates[i].getKey());
            }else {
                System.out.println("������� �� ������!");
                break;
            }
        }
    }

    @Override
    public Data[] readDataBaseRecords(int quantity, int startIndex) {
        Data[] dates2 = new Data[quantity + 1];
        for (int i = 0; i < dates.length; i++) {
            if (i >= startIndex) {
                dates2[i] = dates[i];
            }
        }
        return dates2;
    }

    @Override
    public void readNumberOfRecords() {
        System.out.printf("���������� ������� � ����: %s", dates.length);
    }

    @Override
    public void addRecDataBase(String key, String val) {
        Data[] dates3 = new Data[5 + 1];
        for (int i = 0; i < dates.length; i++) {
            dates3[i] = dates[i];
            dates3[5] = new Data(key, val);
        }
        System.out.printf("�� �������� ������: key: %s value: %s", dates3[5].getKey(), dates3[5].getValue());

        for (Data d : dates3) {
            System.out.printf("%nkey: %s value: %s", d.getKey(), d.getValue());
        }
    }

    @Override
    public void updateValIndex() {
        System.out.println();
    }

    @Override
    public void updateContentRecKey() {
        System.out.println();
    }

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path PATH = Paths.get("./data.json");

    public static Data[] readFile() {
        String json = "";
        try {
            json = Files.readString(PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return GSON.fromJson(json, Data[].class);
    }

}
