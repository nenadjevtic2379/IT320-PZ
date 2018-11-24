
import com.mycompany.it320.prz.Prodavnica;
import com.mycompany.it320.prz.Proizvod;
import com.mycompany.it320.prz.service.ProdavnicaFacadeREST;
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
public class ProdavnicaServiceTest {

    ProdavnicaFacadeREST prodavnice;
    Prodavnica prodavnica;
    Query mockedQuery;

    @Before
    public void setUp() {
        this.prodavnice = new ProdavnicaFacadeREST();
        this.prodavnice.em = mock(EntityManager.class);
        this.prodavnica = mock(Prodavnica.class);
        this.mockedQuery = mock(Query.class);
    }

    @Test
    public void shouldSaveProd() {
        Prodavnica prod = new Prodavnica();

        doNothing().when(this.prodavnice.em).persist(Matchers.anyObject());

        this.prodavnice.create(prod);

        verify(this.prodavnice.em).persist(prod);
    }

    @Test
    public void shouldRemoveProd() {
      Prodavnica prod = new Prodavnica();
        /**
         * doNothing(), doAnswer(), doThrow() used to test void method, the
         * format: doNothing().when(bean).method_name();
         */
        doNothing().when(this.prodavnice.em).remove(Matchers.anyInt());

        this.prodavnice.remove(prod);

        verify(this.prodavnice.em).remove(prod.getIdProdavnica());
    }

    @Test
    public void shouldGetProdById() {
        Prodavnica expected = new Prodavnica();

        when(this.prodavnice.em.find(Matchers.<Class<Prodavnica>>any(), Matchers.anyInt()))
                .thenReturn(expected);

        Prodavnica actual = this.prodavnice.find(expected.getIdProdavnica());

        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void ShouldEditProd() {
        Prodavnica expected = new Prodavnica();

        when(this.prodavnice.em.find(Matchers.<Class<Prodavnica>>any(), Matchers.anyInt()))
                .thenReturn(expected);

        this.prodavnice.edit(Matchers.anyInt(), expected);

        verify(this.prodavnice.em).merge(expected);
    }

    @Test
    public void shouldGetAllProd() {

        try {

            List<Prodavnica> prod = new ArrayList<>();

            // Userrole role = mock(Userrole.class);
            when(prodavnica.getIdProdavnica()).thenReturn(1);

            prod.add(prodavnica);

            when(mockedQuery.getResultList()).thenReturn(prod);
            when(mockedQuery.setParameter("", null) //string-object(key value)
            ).thenReturn(mockedQuery);
            when(this.prodavnice.em.createNamedQuery("Prodavnica.findAll"))
                    .thenReturn(mockedQuery);

            prod = this.prodavnice.findAll();
            assertThat(prod.size(), is(1));
        } catch (NullPointerException n) {
            n.printStackTrace();
        }

    }

}
