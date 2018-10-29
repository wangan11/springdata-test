package com.example.demo;

import com.example.demo.entity.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests {


	/**
	 * @LocalServerPort 提供了 @Value("${local.server.port}") 的代替
	 */
	@LocalServerPort
	private int port;

	private URL base;

	@Autowired
	private TestRestTemplate restTemplate;

	@Before
	public void setUp() throws Exception {
		String url = String.format("http://localhost:%d/", port);
		System.out.println(String.format("port is : [%d]", port));
		this.base = new URL(url);
	}

	/**
	 * 向"/test"地址发送请求，并打印返回结果
	 *
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception {
		Map<String,String > urlParms=new HashMap<>();
		urlParms.put("name","addPerson");
		urlParms.put("name2","person");
		Person person=new Person();
		person.setAge(1);
		person.setName("wangan");
		ResponseEntity<String> response = this.restTemplate.postForEntity(
				this.base.toString() + "/{name2}/{name}",person,String.class,urlParms);
		System.out.println(String.format("测试结果为：%s", response.getBody()));
	}

	@Test
	public void test2(){
		Person person=new Person();
		person.setId(9L);
		ResponseEntity<String> stringResponseEntity = this.restTemplate.postForEntity(this.base.toString() + "/person/deletePerson", person, String.class);
		System.out.println(stringResponseEntity.getBody());
		System.out.println(stringResponseEntity.getHeaders());
	}
}
