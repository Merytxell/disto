package fr.fms;

import fr.fms.dao.CustomerRepository;

import fr.fms.entities.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class SpringStockOrderControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CustomerRepository customerRepository;

    @Test
    @WithMockUser(username = "Robert24", password = "Drago2025!", roles = "users")
    public void testCustomer() throws Exception{
        mvc.perform(get("/customer"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer"));
    }

    @Test
    @WithMockUser(username = "Robert24", password = "Drago2025!", roles = "users")
    public void testOrder() throws Exception{
        mvc.perform(get("/order"))
                .andExpect(status().isOk())
                .andExpect(view().name("order"));
    }
}
