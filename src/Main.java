public class Main {
    public static void main(String[] args) {

//
//        Data[] data = new Data[5];
//        data[0] = new Data("K1","AAA,BBB,CCC");
//        data[1] = new Data("K2","AAA,BBB");
//        data[2] = new Data("K3","AAA,DDD");
//        data[3] = new Data("K4","AAA,2,01/01/2015");
//        data[4] = new Data("K5","3,ZZZ,5623");
        ReadData readData = new ReadData();
        Data[] dates1 = readData.dates;
//        readData.readStringIndex(dates1,2);
        for (Data d : readData.readDataBaseRecords(1,1)) {
            System.out.println(d.getKey()+ d.getValue());
        }
    }
}