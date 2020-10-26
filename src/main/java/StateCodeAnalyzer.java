import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.regex.*;

public class StateCodeAnalyzer {

    public static boolean checkType(String path)
    {
        if(path.contains(".csv"))
            return true;
        else
            return false;
    }
    public static boolean checkDelimiter(String path)
    {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(path));
            BufferedReader bf = new BufferedReader(reader);
            String line;
            while ((line = bf.readLine()) != null) {
                String[] arr = line.split(",");
                for (String x : arr) {
                    if (Pattern.matches(".*[^A-Za-z0-9 ].*", x)) {
                        return false;
                    }
                }
            }
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public static boolean checkHeader(String path) throws CustomException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(path));
            BufferedReader bf = new BufferedReader(reader);
            String line;
            while ((line = bf.readLine()) != null) {
                String[] arr = line.split(",");
                if (arr[0].equals("SrNo") && arr[1].equals("State") && arr[2].equals("TIN") && arr[3].equals("StateCode"))
                    break;
                else
                    return false;
            }
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public int readData(String path) throws CustomException{
        if(!checkType(path))
        {
            throw new CustomException();
        }
        if(!checkDelimiter(path))
        {
            throw new CustomException();
        }
        if(!checkHeader(path))
        {
            throw new CustomException();
        }
        int count = 0;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(path));
            CsvToBean<StateCensus> csvToBean = new CsvToBeanBuilder<StateCensus>(reader).withIgnoreLeadingWhiteSpace(true).withType(StateCensus.class).build();
            Iterator<StateCensus> i = csvToBean.iterator();
            while (i.hasNext()) {
                count++;
                StateCensus csvData = i.next();
            }
        } catch (IOException e) {
            throw new CustomException();
        }  catch(Exception e)
        {
            throw new CustomException();
        }
        return count;
    }
}


