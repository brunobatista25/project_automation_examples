package runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.RegisterUserTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        RegisterUserTest.class
})
public class RunnerTest {

}
