package com.jojoldu.book.springboot.web;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) //스프링 부트 테스트와 JUnit 사이 연결자
@WebMvcTest(controllers = HelloController.class) //스프링 테스트 어노테이션 중 Web(Spring MVC)에 집중할 수 있는 어노테이션
public class HelloControllerTest extends TestCase {

    @Autowired
    private MockMvc mvc; //웹 API를 테스트할 때 사용, 스프링 MVC 테스트의 시작점

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) // /hello 주소로 GET 요청을 함, 체이닝으로 여러 검증 가능
                .andExpect(status().isOk()) //HTTP Header의 Status 검증
                .andExpect(content().string(hello)); //응답 본문의 내용을 검증
    }
}