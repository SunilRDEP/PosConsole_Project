package utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser  implements IRetryAnalyzer{
	int counterForRetryAttempts= 0;
	int setMaxLimitForRetry =1;
	@Override
	public boolean retry(ITestResult result) {
		if(counterForRetryAttempts<setMaxLimitForRetry) {
			counterForRetryAttempts++;
			return true;
		}
		return false;
	} 

}
