
import com.mycompany.it320.prz.Userrole;
import com.mycompany.it320.prz.service.UserroleFacadeREST;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.AdditionalMatchers.not;
import org.mockito.Matchers;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Korsn
 */
public class UserRoleServiceTest {

    UserroleFacadeREST userRole;
    Userrole role;
    Query mockedQuery;

    @Before
    public void setUp() {
        this.userRole = new UserroleFacadeREST();
        this.userRole.em = mock(EntityManager.class);
        this.role = mock(Userrole.class);
        this.mockedQuery = mock(Query.class);
    }

    @Test
    public void shouldSaveRole() {
        Userrole role = new Userrole();

        doNothing().when(this.userRole.em).persist(Matchers.anyObject());

        this.userRole.create(role);

        verify(this.userRole.em).persist(role);
    }

    @Test
    public void shouldRemoveRole() {
        Userrole r = new Userrole();
        /**
         * doNothing(), doAnswer(), doThrow() used to test void method, the
         * format: doNothing().when(bean).method_name();
         */
        doNothing().when(this.userRole.em).remove(Matchers.anyInt());

        this.userRole.remove(r);

        verify(this.userRole.em).remove(r.getIdRole());
    }

    @Test
    public void shouldGetRoleById() {
        Userrole expected = new Userrole();

        when(this.userRole.em.find(Matchers.<Class<Userrole>>any(), Matchers.anyInt()))
                .thenReturn(expected);

        Userrole actual = this.userRole.find(expected.getIdRole());

        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void ShouldEditUserRole() {
        Userrole expected = new Userrole();

        when(this.userRole.em.find(Matchers.<Class<Userrole>>any(), Matchers.anyInt()))
                .thenReturn(expected);

        this.userRole.edit(Matchers.anyInt(), expected);

        verify(this.userRole.em).merge(expected);
    }

    @Test
    public void shouldGetAllRoles() {

        try {

            List<Userrole> roles = new ArrayList<>();

           // Userrole role = mock(Userrole.class);
            when(role.getIdRole()).thenReturn(1);

            roles.add(role);
  
            when(mockedQuery.getResultList()).thenReturn(roles);
            when(mockedQuery.setParameter("", null) //string-object(key value)
            ).thenReturn(mockedQuery);
            when(this.userRole.em.createNamedQuery("Userrole.findAll"))
                    .thenReturn(mockedQuery);

            roles = this.userRole.findAll();
            assertThat(roles.size(), is(1));
        } catch (NullPointerException n) {
            n.printStackTrace();
        }

    }

}
