import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Data[] data = new Data[5];
        data[0] = new Data("K1","AAA,BBB,CCC");
        data[1] = new Data("K2","AAA,BBB");
        data[2] = new Data("K3","AAA,DDD");
        data[3] = new Data("K4","AAA,2,01/01/2015");
        data[4] = new Data("K5","3,ZZZ,5623");

        run();




    }
    public static void run(){
        ReadData readData = new ReadData();
        Scanner scn = new Scanner(System.in);
        System.out.println("�������� �������� � ��:\n1-������� ���������� � ��\n" +
                "2-������� ����������\n" +
                "3-���������� ����������\n" +
                "4-������� ���� ������ (������) �� �������\n" +
                "5-��������� ���� �� ������ �� ������-�� �����\n" +
                "6-������� ���� ������ �� �����\n" +
                "7-������� �� ���� ��������� ����� �������\n" +
                "8-������ ���������� ������� � ����\n" +
                "9-�������� ������ � ����\n" +
                "10-�������� ������ � ����\n" +
                "11-�������� ���������� ������ �� �����\n: ");
        switch (scn.nextInt()){
            case 1:
                readData.openConnection();
                break;
            case 2:
                readData.closeConnection();
                break;
            case 3:
                readData.testConnection();
                break;
            case 4:
                readData.readStringIndex(1);
                break;
            case 5:
                Scanner scnn = new Scanner(System.in);
                System.out.println("������� ���� (������: \"1\"):  ");
                String keys1 = scnn.nextLine();
                readData.checkRecordKey(keys1);
                break;
            case 6:
                Scanner sc = new Scanner(System.in);
                System.out.println("������� �������� (������: \"1\"):  ");
                String keys2 = sc.nextLine();
                readData.readRecordKey(keys2);
                break;
            case 7:
                Data[] dates = readData.readDataBaseRecords(4,1);
                break;
            case 8:
                readData.readNumberOfRecords();
                break;
            case 9:
                Scanner scr = new Scanner(System.in);
                System.out.println("������� ���� � �������� ���� �������� ������");
                System.out.println("����: ");
                String key = scr.nextLine();
                System.out.println("��������: ");
                String val = scr.nextLine();
                readData.addRecDataBase(key, val);
                break;
            case 10:
                readData.updateValIndex();
                break;
            case 11:
                readData.updateContentRecKey();
            default:
                System.out.println("�� ������ �� �������");
        }
    }
}