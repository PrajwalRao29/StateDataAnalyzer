import org.junit.*;

public class TestStateCensus {
    StateCensusAnalyzer c=new StateCensusAnalyzer();

    @Test
    public void test1CorrectFile(){
        int count=c.readData("C:\\Users\\Latha r rao\\Intellij\\StateCensusAnalyzer\\src\\StateCensusData.csv");
        Assert.assertEquals(29,count);
    }
    
}
