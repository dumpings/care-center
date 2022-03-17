package org.csu.carecenter.Controller;

import org.csu.carecenter.CarecenterApplication;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@MapperScan("org.csu.carecenter.Persistence")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CarecenterApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerControllerTest {

    protected MockMvc mockMvc;
    private MockHttpSession session;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  //构建MockMVC
        session = new MockHttpSession();
    }

    @Test
    void getAllOutList() throws Exception{
        setup();
        String responseString = mockMvc.perform(
                MockMvcRequestBuilders.get("/customer/selectAllOutList")          //请求的url,请求的方法是get
                        .contentType(MediaType.APPLICATION_JSON)//数据的格式
        )
                .andExpect(MockMvcResultMatchers.status().isOk())    //返回的状态是200
                .andDo(MockMvcResultHandlers.print())         //打印出请求和相应的内容
                .andReturn()
                .getResponse()
                .getContentAsString();   //将相应的数据转换为字符串
        System.out.println("-----返回的json = " + responseString);
    }

    @Test
    void editOutForm() throws Exception{
        String responseString = mockMvc.perform(
                MockMvcRequestBuilders.get("/customer/editOutForm")          //请求的url,请求的方法是get
                        .contentType(MediaType.APPLICATION_JSON)//数据的格式
                        .session(this.session)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())    //返回的状态是200
                .andDo(MockMvcResultHandlers.print())         //打印出请求和相应的内容
                .andReturn()
                .getResponse()
                .getContentAsString();   //将相应的数据转换为字符串
        System.out.println("-----返回的json = " + responseString);
    }

    @Test
    void editOut() throws Exception{
        String responseString = mockMvc.perform(
                MockMvcRequestBuilders.get("/customer/editOutForm")          //请求的url,请求的方法是get
                        .contentType(MediaType.APPLICATION_JSON)//数据的格式
                        .param("custid","10001")
                        .param("reason","Lily")
                        .param("starttime","20201010")
                        .param("exptime","20201011")
                        .param("acttime","20201011")
                        .param("aidphone","88888888")
                        .session(this.session)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())    //返回的状态是200
                .andDo(MockMvcResultHandlers.print())         //打印出请求和相应的内容
                .andReturn()
                .getResponse()
                .getContentAsString();   //将相应的数据转换为字符串
        System.out.println("-----返回的json = " + responseString);
    }

    @Test
    void addOutForm()  throws Exception{
        String responseString = mockMvc.perform(
                MockMvcRequestBuilders.get("/customer/addOutForm")          //请求的url,请求的方法是get
                        .contentType(MediaType.APPLICATION_JSON)//数据的格式
                        .session(this.session)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())    //返回的状态是200
                .andDo(MockMvcResultHandlers.print())         //打印出请求和相应的内容
                .andReturn()
                .getResponse()
                .getContentAsString();   //将相应的数据转换为字符串
        System.out.println("-----返回的json = " + responseString);
    }

    @Test
    void addOut()  throws Exception{
        String responseString = mockMvc.perform(
                MockMvcRequestBuilders.get("/customer/addOut")          //请求的url,请求的方法是get
                        .contentType(MediaType.APPLICATION_JSON)//数据的格式
                        .param("custid","10001")
                        .param("reason","Lily")
                        .param("starttime","20201010")
                        .param("exptime","20201011")
                        .param("acttime","20201011")
                        .param("aidphone","88888888")
                        .session(this.session)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())    //返回的状态是200
                .andDo(MockMvcResultHandlers.print())         //打印出请求和相应的内容
                .andReturn()
                .getResponse()
                .getContentAsString();   //将相应的数据转换为字符串
        System.out.println("-----返回的json = " + responseString);
    }

    @Test
    void deleteOut() throws Exception{
        String responseString = mockMvc.perform(
                MockMvcRequestBuilders.get("/customer/deleteOut")          //请求的url,请求的方法是get
                        .contentType(MediaType.APPLICATION_JSON)//数据的格式
                        .param("custid","10001")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())    //返回的状态是200
                .andDo(MockMvcResultHandlers.print())         //打印出请求和相应的内容
                .andReturn()
                .getResponse()
                .getContentAsString();   //将相应的数据转换为字符串
        System.out.println("-----返回的json = " + responseString);
    }
}