package hello;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CommandControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void rotatingRigth() throws Exception {

        this.mockMvc.perform(get("/rest/mars").param("commands", "MMRMMRMM"))
        .andDo(print()).andExpect(status().isOk())
        .andExpect(jsonPath("$").value("(2,0,S)"));
    }
    @Test
    public void rotatingLeft() throws Exception {

        this.mockMvc.perform(get("/rest/mars").param("commands", "MML"))
        .andDo(print()).andExpect(status().isOk())
        .andExpect(jsonPath("$").value("(0,2,W)"));
    }
    @Test
    public void rotatingLeftAgain() throws Exception {

        this.mockMvc.perform(get("/rest/mars").param("commands", "MML"))
        .andDo(print()).andExpect(status().isOk())
        .andExpect(jsonPath("$").value("(0,2,W)"));
    }
    @Test
    public void invalidCommand() throws Exception {

        this.mockMvc.perform(get("/rest/mars").param("commands", "AAA"))
        .andDo(print()).andExpect(status().is4xxClientError());
    }
    @Test
    public void invalidPosition() throws Exception {
        this.mockMvc.perform(get("/rest/mars").param("commands", "MMMMMMMMMMMMMMMMMMMMMMMM"))
        .andDo(print()).andExpect(status().is4xxClientError());
    }


}
