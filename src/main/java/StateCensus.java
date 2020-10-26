import com.opencsv.bean.*;

public class StateCensus {

    public class CSVStateCensus {
        @CsvBindByPosition(position = 0)
        private String state;

        @CsvBindByPosition(position = 1)
        private long population;

        @CsvBindByPosition(position = 2)
        private int area;

        @CsvBindByPosition(position = 3)
        private int density;

        @Override
        public String toString() {
            return "[State = " + state +", Population = " + population + ", AreaInSqKm = " + area + ", density = " + density + " ]";
        }

        public String getState() {
            return state;
        }

        public long getPopulation() {
            return population;
        }

        public int getArea() {
            return area;
        }

        public int getDensity() {
            return density;
        }
    }

}
