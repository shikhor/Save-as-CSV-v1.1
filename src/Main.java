import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    static final String TABLE_NAME = "DosData";

    public static void main(String[] args) throws IOException {

        /*Table<        Rows<Columns<              >>> data-structure
            ^^           ^^                             ^^                   */
        HashMap<String, List<HashMap<String, String>>> table = new HashMap<>();

        //Creating Column information:
        HashMap<String, String> columnsInfo = new HashMap<>();
        columnsInfo.put("date", "30-May-17");
        columnsInfo.put("fiid", "31");
        columnsInfo.put("product", "11110000");
        columnsInfo.put("amountbdt", "0");
        columnsInfo.put("reportingarea", "1000");
        columnsInfo.put("31", "GOVERNMENT");
        columnsInfo.put("310158", "");

        //Creating Row information:
        List<HashMap<String, String>> rowInfo = new ArrayList<>();

        rowInfo.add(columnsInfo);
        rowInfo.add(columnsInfo);
        rowInfo.add(columnsInfo);
        rowInfo.add(columnsInfo);
        rowInfo.add(columnsInfo);

        table.put(TABLE_NAME, rowInfo);

        new CsvConverter().writeToCsv(table);
    }
}