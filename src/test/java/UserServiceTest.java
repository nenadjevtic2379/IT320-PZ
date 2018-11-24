
import com.mycompany.it320.prz.User;
import com.mycompany.it320.prz.service.UserFacadeREST;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Korsn
 */
public class UserServiceTest {

    UserFacadeREST users;
    User user;
    Query mockedQuery;

    @Before
    public void setUp() {
        this.users = new UserFacadeREST();
        this.users.em = mock(EntityManager.class);
        this.user = mock(User.class);
        this.mockedQuery = mock(Query.class);
    }

    @Test
    public void shouldSaveUser() {
        User u = new User();

        doNothing().when(this.users.em).persist(Matchers.anyObject());

        this.users.create(u);

        verify(this.users.em).persist(u);
    }

    @Test
    public void shouldRemoveUser() {
        User u = new User();
        /**
         * doNothing(), doAnswer(), doThrow() used to test void method, the
         * format: doNothing().when(bean).method_name();
         */
        doNothing().when(this.users.em).remove(Matchers.anyInt());

        this.users.remove(u);

        verify(this.users.em).remove(u.getIdRole());
    }

    @Test
    public void shouldGetUserById() {
        User expected = new User();

        when(this.users.em.find(Matchers.<Class<User>>any(), Matchers.anyInt()))
                .thenReturn(expected);

        User actual = this.users.find(expected.getIdUser());

        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void ShouldEditUser() {
        User expected = new User();

        when(this.users.em.find(Matchers.<Class<User>>any(), Matchers.anyInt()))
                .thenReturn(expected);

        this.users.edit(Matchers.anyInt(), expected);

        verify(this.users.em).merge(expected);
    }

    @Test
    public void shouldGetAllUsers() {

        try {

            List<User> u = new ArrayList<>();

            // Userrole role = mock(Userrole.class);
            when(user.getIdUser()).thenReturn(1);

            u.add(user);

            when(mockedQuery.getResultList()).thenReturn(u);
            when(mockedQuery.setParameter("", null) //string-object(key value)
            ).thenReturn(mockedQuery);
            when(this.users.em.createNamedQuery("User.findAll"))
                    .thenReturn(mockedQuery);

            u = this.users.findAll();
            assertThat(u.size(), is(1));
        } catch (NullPointerException n) {
            n.printStackTrace();
        }

    }

}
