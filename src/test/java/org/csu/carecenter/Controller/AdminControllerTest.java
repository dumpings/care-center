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

@MapperScan("org.csu.carecenter.Persistence")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CarecenterApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AdminControllerTest {

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
    void signonForm() throws Exception {
        setup();
        String responseString = mockMvc.perform(
                MockMvcRequestBuilders.get("/admin/adminLoginForm")          //请求的url,请求的方法是get
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
    void login() throws Exception{
        setup();
        String checkcode = mockMvc.perform(
                MockMvcRequestBuilders.get("/admin/checkCode")          //请求的url,请求的方法是get
                        .contentType(MediaType.APPLICATION_JSON)//数据的格式
        )
                .andExpect(MockMvcResultMatchers.status().isOk())    //返回的状态是200
                .andDo(MockMvcResultHandlers.print())         //打印出请求和相应的内容
                .andReturn()
                .getResponse()
                .getContentAsString();   //将相应的数据转换为字符串
        System.out.println("-----返回的json = " + checkcode);

        String responseString = mockMvc.perform(
                MockMvcRequestBuilders.get("/admin/adminLoginForm")          //请求的url,请求的方法是get
                        .contentType(MediaType.APPLICATION_JSON)//数据的格式
                        .param("adminName","admin")
                        .param("password","admin")
                        .param("code",checkcode)
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
    void checkCode() throws Exception{
        setup();
        String checkcode = mockMvc.perform(
                MockMvcRequestBuilders.get("/admin/checkCode")          //请求的url,请求的方法是get
                        .contentType(MediaType.APPLICATION_JSON)//数据的格式
        )
                .andExpect(MockMvcResultMatchers.status().isOk())    //返回的状态是200
                .andDo(MockMvcResultHandlers.print())         //打印出请求和相应的内容
                .andReturn()
                .getResponse()
                .getContentAsString();   //将相应的数据转换为字符串
        System.out.println("-----返回的json = " + checkcode);
    }

    @Test
    void manageUser()  throws Exception{
        setup();
        String responseString = mockMvc.perform(
                MockMvcRequestBuilders.get("/admin/manageUser")          //请求的url,请求的方法是get
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
    void managerAccount()  throws Exception{
        setup();
        String responseString = mockMvc.perform(
                MockMvcRequestBuilders.get("/admin/managerAccount")          //请求的url,请求的方法是get
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
    void editAccount() throws Exception {
        setup();
        String responseString = mockMvc.perform(
                MockMvcRequestBuilders.get("/admin/editAccountForm")          //请求的url,请求的方法是get
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
    void editUser() throws Exception {
        setup();
        String responseString = mockMvc.perform(
                MockMvcRequestBuilders.get("/admin/editUserForm")          //请求的url,请求的方法是get
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
    void viewUser() throws Exception {
        setup();
        String responseString = mockMvc.perform(
                MockMvcRequestBuilders.get("/admin/editUser")          //请求的url,请求的方法是get
                        .contentType(MediaType.APPLICATION_JSON)//数据的格式
                        .param("userId","10001")
                        .param("username","Lily")
                        .param("sex","1")
                        .param("email","668888@qq.com")
                        .param("age","23")
                        .session(this.session)
                        .param("phoneNumber","88888888")
                        .param("role","医生")
                        .param("password","2333")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())    //返回的状态是200
                .andDo(MockMvcResultHandlers.print())         //打印出请求和相应的内容
                .andReturn()
                .getResponse()
                .getContentAsString();   //将相应的数据转换为字符串
        System.out.println("-----返回的json = " + responseString);
    }

    @Test
    void addUserForm()  throws Exception{
        setup();
        String responseString = mockMvc.perform(
                MockMvcRequestBuilders.get("/admin/addUserForm")          //请求的url,请求的方法是get
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
    void addUser() throws Exception {
        setup();
        String responseString = mockMvc.perform(
                MockMvcRequestBuilders.get("/admin/addUser")          //请求的url,请求的方法是get
                        .contentType(MediaType.APPLICATION_JSON)//数据的格式
                        .param("username","cxy")
                        .param("sex","1")
                        .param("age","23")
                        .param("phone","88888888")
                        .param("role","医生")
                        .param("email","668888@qq.com")
                        .param("password","2333")
                        .param("userId","10020")
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
    void upload() throws Exception {
        setup();
        String responseString = mockMvc.perform(
                MockMvcRequestBuilders.get("/admin/upload")          //请求的url,请求的方法是get
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
    void testEditAccount() throws Exception {
        setup();
        String responseString = mockMvc.perform(
                MockMvcRequestBuilders.get("/admin/editAccount")          //请求的url,请求的方法是get
                        .contentType(MediaType.APPLICATION_JSON)//数据的格式
                        .param("name","admin")
                        .param("password","admin")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())    //返回的状态是200
                .andDo(MockMvcResultHandlers.print())         //打印出请求和相应的内容
                .andReturn()
                .getResponse()
                .getContentAsString();   //将相应的数据转换为字符串
        System.out.println("-----返回的json = " + responseString);
    }

    @Test
    void deleteUser() throws Exception {
        setup();
        String responseString = mockMvc.perform(
                MockMvcRequestBuilders.get("/admin/removeUser")          //请求的url,请求的方法是get
                        .contentType(MediaType.APPLICATION_JSON)//数据的格式
                        .param("userId","10007")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())    //返回的状态是200
                .andDo(MockMvcResultHandlers.print())         //打印出请求和相应的内容
                .andReturn()
                .getResponse()
                .getContentAsString();   //将相应的数据转换为字符串
        System.out.println("-----返回的json = " + responseString);
    }

    @Test
    void getAccount() throws Exception {
        setup();
        String responseString = mockMvc.perform(
                MockMvcRequestBuilders.get("/admin/getAccount")          //请求的url,请求的方法是get
                        .contentType(MediaType.APPLICATION_JSON)//数据的格式
        )
                .andExpect(MockMvcResultMatchers.status().isOk())    //返回的状态是200
                .andDo(MockMvcResultHandlers.print())         //打印出请求和相应的内容
                .andReturn()
                .getResponse()
                .getContentAsString();   //将相应的数据转换为字符串
        System.out.println("-----返回的json = " + responseString);
    }

}