package statisticker;

import java.util.List;
import java.util.Collections;

public class Statistics 
{
    public static class Stats {
        float average;
        float min;
        float max;
    }
    public static Stats getStatistics(List<Float> numbers) {
        //implement the computation of statistics here
        float sum = 0;
        Statistics.Stats s = new Statistics.Stats();
        for (float number : numbers) {
            sum += number;
        }
        s.average = sum / numbers.size();
        s.min = !numbers.isEmpty() ? Collections.min(numbers) : Float.NaN;
        s.max = !numbers.isEmpty() ? Collections.max(numbers): Float.NaN;
        return s;
    }
}
