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
        System.out.println("Подключение к базе данных...");
    }

    @Override
    public void closeConnection() {
        System.out.println("Закрытие соединения...");
    }

    @Override
    public void testConnection() {
        if (dates[0].getKey().isEmpty()) {
            System.out.println("Ошибка подключения! Повторите еще раз!");
        } else {
            System.out.println("Подключение успешно!");
        }
    }


    @Override
    public void readStringIndex(int index) {
        System.out.printf("Считывание строки по индексу...%n Ответ: key: %s value: %s", dates[index].getKey(), dates[index].getValue());
    }

    @Override
    public void checkRecordKey(String key) {
        for (int i = 0; i < dates.length; i++) {
            if (Objects.equals(dates[i].getKey(), key.toUpperCase())) {
                System.out.println("Элемент найден!");
            } else {
                System.out.println("Элемент не найден!");
            }

        }

    }

    @Override
    public void readRecordKey(String key) {
        for (int i = 0; i < dates.length; i++) {
            if (Objects.equals(dates[i].getKey(), key)) {
                System.out.println("Элемент найден!" + dates[i].getKey());
            }else {
                System.out.println("Элемент не найден!");
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
        System.out.printf("Количество записей в базе: %s", dates.length);
    }

    @Override
    public void addRecDataBase(String key, String val) {
        Data[] dates3 = new Data[5 + 1];
        for (int i = 0; i < dates.length; i++) {
            dates3[i] = dates[i];
            dates3[5] = new Data(key, val);
        }
        System.out.printf("Вы добавили запись: key: %s value: %s", dates3[5].getKey(), dates3[5].getValue());

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
