package statisticker;

import java.util.List;
import java.util.Collections;
class EmailAlert implements IAlerter {
	public boolean emailSent = false;
	public void alert() {
		emailSent = true;
	}
}
class LEDAlert implements IAlerter {
	public boolean ledGlows = false;
	public void alert() {
		ledGlows = true;
	}
}
interface IAlerter {
	public void alert();
}
class StatsChecker {
	private float maxThresld;
	private IAlerter alerts[];
	public StatsChecker(float maxThreshold, IAlerter alerters[]) {
		maxThresld = maxThreshold;
		alerts = alerters;
	}
	public void checkAndAlert(List<Float> numbers) {
		float max = Collections.max(numbers);
		if(max > maxThresld) {
			for(IAlerter alert: alerts) {
				alert.alert();
			}
		}
	}
}
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
