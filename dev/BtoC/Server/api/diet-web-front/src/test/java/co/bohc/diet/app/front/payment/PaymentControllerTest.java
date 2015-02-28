package co.bohc.diet.app.front.payment;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import co.bohc.diet.app.front.test.PrepareDataTest;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/wabapp")
@ContextHierarchy({
        @ContextConfiguration(name = "parent", locations = {
                "classpath*:META-INF/spring/applicationContext.xml",
                "classpath*:META-INF/spring/spring-security.xml",
                "classpath*:test-context-front.xml" }),
        @ContextConfiguration(name = "child", locations = "classpath*:META-INF/spring/spring-mvc-rest.xml") })
@Transactional
@TransactionConfiguration(defaultRollback = true)
/**
 * 
 * @author Administrator
 *
 */
public class PaymentControllerTest extends PrepareDataTest {

//    @Test
//    public void testUxxxxGet() throws Exception{
//        MvcResult result = mockMvc
//                .perform(get("/payments")
//                        .header(BASIC_AUTH_HEADER, this.basicAuthValue("user6@163.com", "123"))
//                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(status().isOk())
//                .andExpect(content().encoding(DEFAULT_ENCODING))
//                .andExpect(content().contentType(DEFAULT_CONTENTTYPE))
//                .andExpect(jsonPath("$.shopId").value("tshop00017590"))
//                .andReturn();
//        assertThat(result.getModelAndView(), is(nullValue()));
//    }
//    @Test
//    public void testUxxxxPost() throws Exception{
//        MvcResult result = mockMvc
//                .perform(post("/payments")
//                        .header(BASIC_AUTH_HEADER, this.basicAuthValue("user2@163.com", "123"))
//                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
//                        .accept(MediaType.APPLICATION_JSON))
//                        .andDo(MockMvcResultHandlers.print())
//                        .andExpect(status().isOk())
//                        .andExpect(content().encoding(DEFAULT_ENCODING))
//                        .andExpect(content().contentType(DEFAULT_CONTENTTYPE))
//                        .andExpect(jsonPath("$.shopID").value("tshop00017590"))
//                        .andReturn();
//        assertThat(result.getModelAndView(), is(nullValue()));
//    }

}
