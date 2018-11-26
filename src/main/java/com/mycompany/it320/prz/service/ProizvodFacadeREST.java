/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.it320.prz.service;

import com.mycompany.it320.prz.facade.AbstractFacade;
import com.mycompany.it320.prz.entity.Proizvod;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Korsn
 */
@Stateless
@Path("com.mycompany.it320.prz.proizvod")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})

@Api(value = "Proizvodi" )
public class ProizvodFacadeREST extends AbstractFacade<Proizvod> {

    @PersistenceContext(unitName = "com.mycompany_IT320-PRZ_war_1.0-SNAPSHOTPU")
    public EntityManager em;

    public ProizvodFacadeREST() {
        super(Proizvod.class);
    }

   @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
   @ApiOperation(value = "POST")
    public void create(Proizvod entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({ MediaType.APPLICATION_JSON})
    @ApiOperation(value = "EDIT")
    public void edit(@PathParam("id") Integer id, Proizvod entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    @ApiOperation(value = "DELETE")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "FIND BY ID")
    public Proizvod find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({ MediaType.APPLICATION_JSON})
    @ApiOperation(value = "GET ALL")
    public List<Proizvod> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "FROM-TO")
    public List<Proizvod> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    @ApiOperation(value = "COUNT")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
