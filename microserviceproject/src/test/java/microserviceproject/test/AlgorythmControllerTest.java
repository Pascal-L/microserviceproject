package microserviceproject.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import microserviceproject.Microservice;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Microservice.class)
@WebAppConfiguration
public class AlgorythmControllerTest {

    private static final String CONTENT_TYPE = "application/json;charset=UTF-8";

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void whenAddAlgorythm_thenListAll() throws Exception {
        String algorythmJson = "{\"name\":\"SHA-256\"}";
        String algorythm2Json = "{\"name\":\"SHA-0\"}";

        this.mockMvc.perform(get("/algorythms/")).andExpect(status().isOk());
        this.mockMvc.perform(post("/algorythms/add").contentType(CONTENT_TYPE).content(algorythmJson))
                .andExpect(status().isCreated());
        this.mockMvc.perform(post("/algorythms/add").contentType(CONTENT_TYPE).content(algorythm2Json))
                .andExpect(status().isCreated());
        this.mockMvc.perform(post("/algorythms/listAll")).andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[2].name", is("SHA-256")))
                .andExpect(jsonPath("$[3].name", is("SHA-0")));
        this.mockMvc.perform(get("/algorythms/allSortedByName")).andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[2].name", is("SHA-0")))
                .andExpect(jsonPath("$[3].name", is("SHA-256")));
    }
    @Test
    public void whenFindOne_NotFound_thenError_thenOK() throws Exception {
        String algorythmNameNotFound = "Algo Test Not Found";
        String algorythmJsonDuplicate = "{\"name\":\"Algo Duplicate\"}";
        String algorythmNameOk = "Algo Test";
        
        this.mockMvc.perform(get("/algorythms/")).andExpect(status().isOk());
        
        //adding a double name
        this.mockMvc.perform(post("/algorythms/add").contentType(CONTENT_TYPE).content(algorythmJsonDuplicate));
        this.mockMvc.perform(post("/algorythms/add").contentType(CONTENT_TYPE).content(algorythmJsonDuplicate));
        
        this.mockMvc.perform(get("/algorythms/named/"+algorythmNameNotFound))
                .andExpect(status().isNotFound());
        
        this.mockMvc.perform(post("/algorythms/listAll").contentType(CONTENT_TYPE))
                .andExpect(jsonPath("$",hasSize(6)))
                .andExpect(jsonPath("$[0].name", is("Algo Test")));
        
        this.mockMvc.perform(get("/algorythms/named/"+algorythmNameOk))
                .andExpect(jsonPath("$.name", is("Algo Test")));
        
    }
    @Test
    public void whenDeleteOne_NotFound_thenOK() throws Exception {
        String algorythmJsonNotFound = "{\"name\":\"Algo Not Found\"}";
        String algorythmJsonOk = "{\"name\":\"Algo Test 3\"}";
        String algorythmJsonDuplicate = "{\"name\":\"Algo Duplicate\"}";
        
        this.mockMvc.perform(get("/algorythms/")).andExpect(status().isOk());
        this.mockMvc.perform(post("/algorythms/add").contentType(CONTENT_TYPE).content(algorythmJsonOk))
                .andExpect(status().isCreated());
        
        this.mockMvc.perform(post("/algorythms/listAll")).andExpect(status().isOk()).andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath("$", hasSize(7)))
                .andExpect(jsonPath("$[6].name", is("Algo Test 3")));
        
        this.mockMvc.perform(post("/algorythms/deleteNamed").contentType(CONTENT_TYPE).content(algorythmJsonNotFound))
                .andExpect(status().isNotFound());
        this.mockMvc.perform(post("/algorythms/deleteNamed").contentType(CONTENT_TYPE).content(algorythmJsonDuplicate))
                .andExpect(status().isInternalServerError());
        this.mockMvc.perform(post("/algorythms/deleteNamed").contentType(CONTENT_TYPE).content(algorythmJsonOk))
                .andExpect(status().isOk());
       
    }
}
