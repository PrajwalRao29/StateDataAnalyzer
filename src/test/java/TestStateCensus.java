import org.junit.*;
public class TestStateCensus {
    StateCensusAnalyzer c=new StateCensusAnalyzer();
  

    @Test
    public void test1_CorrectFile() throws CustomException{
        int count = c.readData("C:\\Users\\Latha r rao\\Intellij\\StateCensusAnalyzer\\src\\StateCensusData.csv");
        Assert.assertEquals(29,count);
    }

    @Test(expected = CustomException.class)
    public void test2_IncorrectFile() throws CustomException{
            int count=c.readData("C:\\Users\\Latha r rao\\Intellij\\StateCensusAnalyzer\\StateCensusData.csv");
        }
    }

