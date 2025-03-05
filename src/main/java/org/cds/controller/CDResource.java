package org.cds.controller;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.cds.entities.CD;
import org.cds.service.CDService;

import java.util.List;

@Path("/cds")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CDResource {

    @Inject
    CDService cdService;

    @GET
    public Response listAll() {
        try {
            List<CD> cds = cdService.listAll();
            return Response.ok(cds).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao listar CDs: " + e.getMessage())
                    .build();
        }
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        try {
            CD cd = cdService.getById(id);
            if (cd == null) {
                return Response.status(Response.Status.NOT_FOUND).entity("CD não encontrado").build();
            }
            return Response.ok(cd).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao buscar CD: " + e.getMessage())
                    .build();
        }
    }

    @POST
    public Response create(CD cd) {
        try {
            CD createdCD = cdService.create(cd);
            return Response.status(Response.Status.CREATED).entity(createdCD).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao criar CD: " + e.getMessage())
                    .build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, CD cd) {
        try {
            CD updatedCD = cdService.update(id, cd);
            if (updatedCD == null) {
                return Response.status(Response.Status.NOT_FOUND).entity("CD não encontrado para atualização").build();
            }
            return Response.ok(updatedCD).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao atualizar CD: " + e.getMessage())
                    .build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        try {
            boolean deleted = cdService.delete(id);
            if (!deleted) {
                return Response.status(Response.Status.NOT_FOUND).entity("CD não encontrado para exclusão").build();
            }
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao deletar CD: " + e.getMessage())
                    .build();
        }
    }

    @GET
    @Path("/banda/{banda}")
    public Response listByBanda(@PathParam("banda") String banda) {
        try {
            List<CD> cds = cdService.listAllByBanda(banda);
            return Response.ok(cds).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao listar CDs por banda: " + e.getMessage())
                    .build();
        }
    }

    @GET
    @Path("/gravadora/{gravadora}")
    public Response listByGravadora(@PathParam("gravadora") String gravadora) {
        try {
            List<CD> cds = cdService.listByGravadora(gravadora);
            return Response.ok(cds).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao listar CDs por gravadora: " + e.getMessage())
                    .build();
        }
    }
}