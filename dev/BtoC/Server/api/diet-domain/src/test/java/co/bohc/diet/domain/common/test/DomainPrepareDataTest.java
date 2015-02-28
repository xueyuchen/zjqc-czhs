package co.bohc.diet.domain.common.test;

import java.util.HashMap;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import co.bohc.diet.domain.common.utils.ClassPathResourceUtils;

public abstract class DomainPrepareDataTest {

	@Inject
	public NamedParameterJdbcTemplate jdbcTemplate;

	@Rule
	public TestName name = new TestName();

	@Before
	public final void prepareTestData() {
		prepareTestData4Class();
		prepareTestData4Method();
	}

	private void prepareTestData4Method() {
		String filePath = this.getClass().getName()
				.replaceAll("\\.", "/")
				+ "_" + name.getMethodName() + ".sql";
		String sql = ClassPathResourceUtils.readClassPathFile(filePath);
		if (sql != null) {
			jdbcTemplate.update(sql, new HashMap<String, Object>());
		}
	}

	private void prepareTestData4Class() {
		String filePath = this.getClass().getName()
				.replaceAll("\\.", "/")
				+ ".sql";
		String sql = ClassPathResourceUtils.readClassPathFile(filePath);
		if (sql != null) {
			jdbcTemplate.update(sql, new HashMap<String, Object>());
		}
	}

}
