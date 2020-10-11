package com.ankhar.usermanager;

import com.ankhar.usermanager.entities.User;
import com.ankhar.usermanager.services.UserManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UsermanagerApplicationTests {

    @Autowired
    private UserManager userManager;
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @BeforeEach
    void setMockMvcBuilders() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    void contextLoads() {
        User user = userManager.createUser("TEST", "TEST", 12312L);
        Long id = user.getId();
        assertThat(user)
                .withFailMessage("Can't create entity.")
                .isNotNull();
        User tempUser = userManager.getById(id);
        assertThat(tempUser)
                .withFailMessage("Can't find created entity.")
                .isNotNull();
        userManager.updateUser(id, "TEST_NAME", "TEST_TITLE", user.getSecureNumber());
        tempUser = userManager.getById(id);
        assertThat(tempUser.getName())
                .withFailMessage("Entity 'name' field update failure.")
                .isEqualTo("TEST_NAME");
        assertThat(tempUser.getTitle())
                .withFailMessage("Entity 'title' field update failure.")
                .isEqualTo("TEST_TITLE");
        userManager.deleteById(id);
        User user3 = userManager.getById(id);
        assertThat(user3)
                .withFailMessage("Deleted test entity still exists in database.")
                .isNull();
    }

    @Test
    public void controllerBeanLoadCheck() {
        ServletContext servletContext = wac.getServletContext();
        assertThat(servletContext).isNotNull();
        assertThat(wac.getBean("generalController")).isNotNull();
    }

    @Test
    public void urlHandlingTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/list"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.view().name("list"));
    }
}
