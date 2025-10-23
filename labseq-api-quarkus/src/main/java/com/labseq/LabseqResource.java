package com.labseq;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/labseq")
public class LabseqResource {
    
    @Inject
    LabseqService service;

    @GET
    @Path("/{n}")
    public long getLabseq(@PathParam("n") long n)
    {
        return service.calculateLabseq(n);
    }
}
