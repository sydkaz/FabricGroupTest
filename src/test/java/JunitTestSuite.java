import com.test.fabricgroup.CorrectDataTest;

import com.test.fabricgroup.TankerRulesTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        CorrectDataTest.class, TankerRulesTest.class
})

public class JunitTestSuite {
}
