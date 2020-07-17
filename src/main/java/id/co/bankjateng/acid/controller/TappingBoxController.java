package id.co.bankjateng.acid.controller;


import id.co.bankjateng.acid.entity.TappingBox;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@Validated
@RequestMapping(path = "/api/1.1")
public class TappingBoxController {
    @PersistenceContext
    private EntityManager entityManager;


    @PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Tag(name = "Insert Data Tapping", description = "fungsi ini digunakan untuk memasukkan data dari device")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success Insert Data",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TappingBox.class))}),
            @ApiResponse(responseCode = "400", description = "Error Message",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content)})
    public String insertTappingBox(
            @Valid @RequestBody TappingBox tappingBox
    ) {
        StoredProcedureQuery theQuery = entityManager.createNamedStoredProcedureQuery("insertTapping");
        theQuery.setParameter("nama_wapu", tappingBox.getNama_wapu());
        theQuery.setParameter("alamat_wapu", tappingBox.getAlamat_wapu());
        theQuery.setParameter("jenis_pajak", tappingBox.getJenis_pajak());
        theQuery.setParameter("tanggal_trx", tappingBox.getTanggal_trx());
        theQuery.setParameter("nominal_total", tappingBox.getNominal_total());
        theQuery.setParameter("nominal_pajak", tappingBox.getNominal_pajak());
        theQuery.setParameter("nama_vendor", tappingBox.getNama_vendor());
        theQuery.setParameter("status_device", tappingBox.getStatus_device());
        theQuery.setParameter("jenis_device", tappingBox.getJenis_device());
        theQuery.setParameter("kabupaten", tappingBox.getKabupaten());

        String responCode = (String) theQuery.getOutputParameterValue("responcode");

        return "{\"responCode\":\"" + responCode + "\"}";


    }

    @DeleteMapping(path = "/del", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Tag(name = "Delete Data Tapping ", description = "fungsi ini digunakan untuk menghapus data tapping berdasarkan parameter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Succes Delete Data By Parameter",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TappingBox.class))}),
            @ApiResponse(responseCode = "400", description = "Error Message",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content)})
    public String deleteTappingBox(
            @Valid @RequestBody TappingBox tappingBox
    ) {
        StoredProcedureQuery theQuery = entityManager.createNamedStoredProcedureQuery("deleteTapping");
        theQuery.setParameter("nama_wapu", tappingBox.getNama_wapu());
        theQuery.setParameter("alamat_wapu", tappingBox.getAlamat_wapu());
        theQuery.setParameter("jenis_pajak", tappingBox.getJenis_pajak());
        theQuery.setParameter("tanggal_trx", tappingBox.getTanggal_trx());
        theQuery.setParameter("nominal_total", tappingBox.getNominal_total());
        theQuery.setParameter("nominal_pajak", tappingBox.getNominal_pajak());
        theQuery.setParameter("nama_vendor", tappingBox.getNama_vendor());
        theQuery.setParameter("status_device", tappingBox.getStatus_device());
        theQuery.setParameter("jenis_device", tappingBox.getJenis_device());
        theQuery.setParameter("kabupaten", tappingBox.getKabupaten());

        String responCode = (String) theQuery.getOutputParameterValue("responcode");

        return "{\"responCode\":\"" + responCode + "\"}";


    }


    @DeleteMapping(path = "/delAll", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Tag(name = "Delete Seluruh Data Tapping ", description = "fungsi ini digunakan untuk menghapus seluruh data tapping")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success Delete All Data",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TappingBox.class))}),
            @ApiResponse(responseCode = "400", description = "Error Message",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content)
    })
    public String deleteAllappingBox() {
        StoredProcedureQuery theQuery = entityManager.createNamedStoredProcedureQuery("deleteAllTapping");

        String responCode = (String) theQuery.getOutputParameterValue("responcode");

        return "{\"responCode\":\"" + responCode + "\"}";


    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}

