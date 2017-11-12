import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CsvConverter {

    final String TABLE_NAME = "DosData";

    BufferedReader buffReader;
    BufferedWriter buffWriter;

    public CsvConverter() throws IOException {
        buffWriter = new BufferedWriter(new FileWriter("output.csv"));
        buffReader = new BufferedReader(new FileReader("inputtemplate.csv"));
    }

    void writeToCsv(HashMap<String, List<HashMap<String, String>>> tableData) throws IOException {

        //Getting Column names:
        String colStr = buffReader.readLine();
        buffWriter.write(colStr+"\n");
        colStr = buffReader.readLine();
        buffWriter.write(colStr+"\n");

        String hashValues = buffReader.readLine();
        List<String> hashes = Arrays.asList(hashValues.split(","));

        //Getting Table:
        if (tableData.containsKey(TABLE_NAME)) {
            //Getting rows:
            List<HashMap<String, String>> rowsInfo = tableData.get(TABLE_NAME);

            for (int i = 0, sz = rowsInfo.size(); i < sz; ++i) {
                boolean flag = false;

                //Getting Columns:
                HashMap<String, String> columnsInfo = rowsInfo.get(i);

                //Generating Columns values:
                for (int j =0, hashesSz = hashes.size(); j < hashesSz; ++j){
                    if (flag)
                        buffWriter.write(",");
                    flag = true;
                    buffWriter.write(columnsInfo.get(hashes.get(j)));
                }
                buffWriter.write("\n");
            }
        }

        buffWriter.close();
        buffReader.close();

    }
}
