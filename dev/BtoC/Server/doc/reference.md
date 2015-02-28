# Reference

## Development Document

### REST
http://blog.csdn.net/it_man/article/details/39647597

### Test
测试用例设计 http://blog.csdn.net/wangwencong/article/details/8190825
http://jinnianshilongnian.iteye.com/blog/2004660
10.3.6 Spring MVC Test Framework
http://docs.spring.io/spring/docs/4.0.0.RELEASE/spring-framework-reference/htmlsingle/#spring-mvc-test-framework

http://download.csdn.net/download/liujun13579/4783847
Junit4断言 http://yingfangming.blog.163.com/blog/static/165802470201092964526324/
http://toplchx.iteye.com/blog/1537542
单元测试覆盖率：http://www.ibm.com/developerworks/cn/java/j-lo-jacoco/index.html

### TERASOLUNA Global Framework

* guideline: http://terasolunaorg.github.io/guideline/
* Blank multi project for web application using TERASOLUNA Global Framework: https://github.com/terasolunaorg/terasoluna-gfw-web-multi-blank
* Sample application: https://github.com/terasolunaorg/terasoluna-tourreservation

### Spring 3 + Quartz 1.8.6 Scheduler Example
http://www.mkyong.com/spring/spring-quartz-scheduler-example/

### Spring Data JPA

* http://sishuok.com/forum/posts/list/7000.html
* http://z276356445t.iteye.com/blog/1596277
* http://www.ibm.com/developerworks/cn/opensource/os-cn-spring-jpa/
* http://docs.spring.io/spring-data/data-jpa/docs/current/reference/html/

### hibernate reverse hbm code by Maven
http://blog.csdn.net/nsrainbow/article/details/9315229

### Backbone.Marionette
* http://marionettejs.com/
* https://github.com/mrichard/generator-marionette
* http://www.freeshow.net.cn/questions/373a3ea76ad8076bd3126b7ea6300f85ccac02ce5318a590bec2cb68cefca3a5/
* http://blog.csdn.net/yingyiledi/article/details/39994145
* http://blog.csdn.net/yingyiledi/article/details/40188983
* http://download.csdn.net/detail/yingyiledi/8049363
* https://github.com/asciidisco/Backbone.Marionette.Handlebars
* http://yujianshenbing.iteye.com/category/256978
* http://resthub.org/docs/backbone/


* https://github.com/ChiperSoft/HandlebarsHelperHoard
* http://www.cnblogs.com/iyangyuan/archive/2013/12/12/3471227.html

## video
* http://aws.amazon.com/jp/elastictranscoder/
* http://www.streamingmedia.com/Articles/ReadArticle.aspx?ArticleID=94188&PageNum=2
* http://johndyer.name/mediaelement-jsa-magic-unicorn-html5-video-library/
* http://www.jplayer.org/
*
* http://docs.aws.amazon.com/zh_cn/AmazonCloudFront/latest/DeveloperGuide/TutorialStreamingJWPlayer.html

## File upload
* http://www.iteye.com/news/25065
* http://viljamis.com/blog/2012/file-upload-support-on-mobile/
* http://www.cnblogs.com/silentjesse/p/3770253.html

##Dozer
* http://blog.sina.com.cn/s/blog_71b8dd040100ron3.html
* http://dozer.sourceforge.net/dozer-user-guide.pdf

## requirejs
http://www.requirejs.cn/

## Development Tools

###JOSN
https://chrome.google.com/webstore/detail/json-editor/lhkmoheomjbkfloacpgllgjcamhihfaj


### Git, Github, SourceTree
* http://www.bootcss.com/p/git-guide/
http://jingyan.baidu.com/article/4d58d541310ea39dd4e9c0f4.html
* http://blog.csdn.net/collonn/article/details/39259227

### Maven
* http://www.oracle.com/technetwork/cn/community/java/apache-maven-getting-started-1-406235-zhs.html

### npm
* http://npm.taobao.org/

### Grunt Bower Yeoman
* http://www.gruntjs.net/docs/getting-started/
* http://blog.fens.me/nodejs-bower-intro/
* http://yeomanjs.org/

### Phonegap
http://blog.csdn.net/aaawqqq/article/details/20125837
http://cordova.apache.org/docs/en/4.0.0/guide_platforms_ios_webview.md.html#iOS%20WebViews
http://www.ituring.com.cn/article/130434

###Base64
http://blog.chinaunix.net/uid-26884465-id-3327002.html

```java
/**
 *
 */
package co.bohc.diet.app.admin.api.mealcomment;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

/**
 * @author senon
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:META-INF/spring/applicationContext.xml",
		"classpath*:META-INF/spring/spring-security.xml",
		"classpath*:META-INF/spring/spring-mvc-rest.xml",
		"classpath:test-context-admin.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class MealCommentControllerTest {

	@Inject
	RestTemplate restTemplate;
	@Inject
	MealCommentController controller;

	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private Map<String, String> uriTemplateVars;

	@Before
	public void before() {
		request = new MockHttpServletRequest();
		request.setCharacterEncoding("UTF-8");
		response = new MockHttpServletResponse();
		uriTemplateVars = new HashMap<String,String>();
		request.setAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE, uriTemplateVars);
	}

	@Inject
	RequestMappingHandlerAdapter handlerAdapter;

	@Test
	public void testFindOne01() throws Exception {

		request.setParameter("mealCommentId", String.valueOf(1));
		uriTemplateVars.put("mealCommentId", String.valueOf(1));

		handlerAdapter.handle(request, response, new HandlerMethod(controller, "findOne",Integer.class));
		System.out.println(response.getStatus());
		System.out.println(response.getContentAsString());

	}

}

```





