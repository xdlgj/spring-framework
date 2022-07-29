import org.example.staticProxy.AgentProxy;
import org.example.staticProxy.MarryCompany;
import org.example.staticProxy.Owner;
import org.example.staticProxy.You;
import org.junit.Test;

public class MyTest {
    @Test
    public void test01() {
        You you = new You();
        MarryCompany marryCompany = new MarryCompany(you);
        marryCompany.toMarry();
    }
    @Test
    public void test02() {
        Owner owner = new Owner();
        AgentProxy agentProxy = new AgentProxy(owner);
        agentProxy.toRentHouse();
    }
}
