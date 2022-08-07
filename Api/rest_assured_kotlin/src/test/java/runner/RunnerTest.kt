package runner

import org.junit.runner.RunWith
import org.junit.runners.Suite
import org.junit.runners.Suite.SuiteClasses
import tests.RegisterUserTest

@RunWith(Suite::class)
@SuiteClasses(RegisterUserTest::class)
class RunnerTest 