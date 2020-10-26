import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

    public class StateCensusAnalyzer {

        public int readData(String path) {
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
                e.printStackTrace();
            }
            return count;
        }
    }

