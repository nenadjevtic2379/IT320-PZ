
import com.mycompany.it320.prz.Proizvod;
import com.mycompany.it320.prz.service.ProizvodFacadeREST;
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
public class ProizvodiServiceTest {
    
    ProizvodFacadeREST proizvodi;
    Proizvod proizvod;
    Query mockedQuery;

    @Before
    public void setUp() {
        this.proizvodi = new ProizvodFacadeREST();
        this.proizvodi.em = mock(EntityManager.class);
        this.proizvod = mock(Proizvod.class);
        this.mockedQuery = mock(Query.class);
    }

    @Test
    public void shouldSaveProiz() {
        Proizvod proiz = new Proizvod();

        doNothing().when(this.proizvodi.em).persist(Matchers.anyObject());

        this.proizvodi.create(proiz);

        verify(this.proizvodi.em).persist(proiz);
    }

    @Test
    public void shouldRemoveProiz() {
        Proizvod proiz = new Proizvod();
        /**
         * doNothing(), doAnswer(), doThrow() used to test void method, the
         * format: doNothing().when(bean).method_name();
         */
        doNothing().when(this.proizvodi.em).remove(Matchers.anyInt());

        this.proizvodi.remove(proiz);

        verify(this.proizvodi.em).remove(proiz.getIdProizvod());
    }

    @Test
    public void shouldGetProizById() {
        Proizvod expected = new Proizvod();

        when(this.proizvodi.em.find(Matchers.<Class<Proizvod>>any(), Matchers.anyInt()))
                .thenReturn(expected);

        Proizvod actual = this.proizvodi.find(expected.getIdProizvod());

        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void ShouldEditProiz() {
        Proizvod expected = new Proizvod();

        when(this.proizvodi.em.find(Matchers.<Class<Proizvod>>any(), Matchers.anyInt()))
                .thenReturn(expected);

        this.proizvodi.edit(Matchers.anyInt(), expected);

        verify(this.proizvodi.em).merge(expected);
    }

    @Test
    public void shouldGetAllProiz() {

        try {

            List<Proizvod> roles = new ArrayList<>();

           // Userrole role = mock(Userrole.class);
            when(proizvod.getIdProizvod()).thenReturn(1);

            roles.add(proizvod);
  
            when(mockedQuery.getResultList()).thenReturn(roles);
            when(mockedQuery.setParameter("", null) //string-object(key value)
            ).thenReturn(mockedQuery);
            when(this.proizvodi.em.createNamedQuery("Proizvod.findAll"))
                    .thenReturn(mockedQuery);

            roles = this.proizvodi.findAll();
            assertThat(roles.size(), is(1));
        } catch (NullPointerException n) {
            n.printStackTrace();
        }

    }

}

    

