package jp.co.axa.apidemo.controller;

import com.github.database.rider.core.api.dataset.DataSet;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import com.github.database.rider.spring.api.DBRider;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
@DBRider
public class ApiDemoApplicationTests {

    private static final String GET_EMPLOYEE_ENDPOINT = "/api/v1/employees";

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DataSet("200_expected.yml")
    public void test_200_getEmployees() throws Exception {
        String response = mockMvc.perform(
                get(GET_EMPLOYEE_ENDPOINT)).andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        log.info("response {}", response);
        assertSameJson(response, "src/test/resources/200_getEmployee_Response.json");
    }

    private void assertSameJson(String response, String filePath) throws Exception {
        String expected = new String(Files.readAllBytes(Paths.get(filePath)));
        JSONAssert.assertEquals(expected, response, true);
    }

}
