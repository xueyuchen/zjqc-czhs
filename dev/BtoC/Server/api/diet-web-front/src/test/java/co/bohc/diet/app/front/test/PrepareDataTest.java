package co.bohc.diet.app.front.test;

import java.util.HashMap;

import javax.inject.Inject;

import org.apache.commons.codec.binary.Base64;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import co.bohc.diet.domain.common.utils.ClassPathResourceUtils;

public class PrepareDataTest {

    public static String DEFAULT_ENCODING = "UTF-8";

    public static String DEFAULT_CONTENTTYPE = "application/json;charset=UTF-8";
    
    public static String BASIC_AUTH_HEADER = "Authorization";
    
    public static String DF_YYYYMMDD = "YYYY/MM/dd";

    @Inject
    public WebApplicationContext wac;

    @Inject
    public NamedParameterJdbcTemplate jdbcTemplate;
    
    @Inject
    protected FilterChainProxy springSecurityFilterChain;

    public MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).addFilter(springSecurityFilterChain, "/*").build();
    }

    @Rule
    public TestName name = new TestName();

    @Before
    public final void prepareTestData() {
        prepareTestData4Class();
        prepareTestData4Method();
    }

    private void prepareTestData4Method() {
        String filePath = this.getClass().getName().replaceAll("\\.", "/")
                + "_" + name.getMethodName() + ".sql";
        String sql = ClassPathResourceUtils.readClassPathFile(filePath);
        if (sql != null) {
            jdbcTemplate.update(sql, new HashMap<String, Object>());
        }
    }

    private void prepareTestData4Class() {
        String filePath = this.getClass().getName().replaceAll("\\.", "/")
                + ".sql";
        String sql = ClassPathResourceUtils.readClassPathFile(filePath);
        if (sql != null) {
            jdbcTemplate.update(sql, new HashMap<String, Object>());
        }
    }

	public String basicAuthValue(String username,String password){
		String plainText = username + ":" + password;
		byte[] b=plainText.getBytes();  
        Base64 base64=new Base64();  
        b=base64.encode(b);  
        return "Basic " + new String(b); 
	}

}
