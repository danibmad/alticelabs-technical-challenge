package com.labseq;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import java.math.BigInteger;

@Path("/labseq")
@Tag(name = "LabSeq API", description = "Compute labseq sequence values")
public class LabseqResource {
    
    @Inject
    LabseqService service;

    @GET
    @Path("/{n}")
    @Operation(
        summary = "Get labseq value",
        description = "Returns the labseq sequence value for index n"
    )
    @APIResponse(
        responseCode = "200",
        description = "Returns the calculation for the labseq sequence of the n index",
        content = @Content(schema = @Schema(implementation = String.class))
    )
    @APIResponse(
        responseCode = "400",
        description = "Invalid input in case of parameter n < 0"
    )
    @APIResponse(
        responseCode = "404",
        description = "Not found in case of parameter n not being a number"
    )
    public String getLabseq(
         @Parameter(
            description = "A non negative integer",
            example = "10",
            required = true
    )
    @PathParam("n") long n)
    {
        BigInteger result = service.calculateLabseq(n);
        return result.toString();
    }
}
