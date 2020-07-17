package id.co.bankjateng.acid.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@NamedStoredProcedureQuery(name = "insertTapping", procedureName = "insertTapping", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "nama_wapu", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "alamat_wapu", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "jenis_pajak", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "tanggal_trx", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "nominal_total", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "nominal_pajak", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "nama_vendor", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "status_device", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "jenis_device", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "kabupaten", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "responcode", type = String.class)})

@NamedStoredProcedureQuery(name = "deleteTapping", procedureName = "deleteTapping", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "nama_wapu", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "alamat_wapu", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "jenis_pajak", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "tanggal_trx", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "nominal_total", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "nominal_pajak", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "nama_vendor", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "status_device", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "jenis_device", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "kabupaten", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "responcode", type = String.class)})

@NamedStoredProcedureQuery(name = "deleteAllTapping", procedureName = "deleteAllTapping", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "responcode", type = String.class)})

public class TappingBox {
    @Id
    @Schema(hidden = true)
    private int id;

    @Column(length = 100)
    @Size(max = 100, message = "Maksimum 100 karakter")
    @NotBlank(message = "nama wapu is mandatory")
    @Schema(name = "nama_wapu", type = "string", description = "Nama Wapu", required = true, example = "Yohan Bagas")
    private String nama_wapu;

    @Column(length = 100)
    @Size(max = 100, message = "Maksimum 100 karakter")
    @NotBlank(message = "alamat wapu is mandatory")
    @Schema(name = "alamat_wapu", type = "string", description = "Alamat Wapu", required = true, example = "Jalan Pemuda No 142 Semarang")
    private String alamat_wapu;

    @Column(length = 50)
    @Size(max = 50, message = "Maksimum 50 karakter")
    @NotBlank(message = "jenis pajak is mandatory")
    @Schema(name = "jenis_pajak", type = "string", description = "Jenis Pajak", required = true, example = "Hotel")
    private String jenis_pajak;

    @Column
    @NotBlank(message = "tanggal transaksi is mandatory")
    @Schema(name = "tanggal_trx", type = "string", description = "Tanggal Transaksi", required = true, example = "2020-01-12 15:15:30")
    private String tanggal_trx;

    @Column
    @NotNull
    @Min(1)
    @Schema(name = "nominal_total", type = "numeric", description = "Nominal Total Transaksi", required = true, example = "20000")
    private int nominal_total;

    @Column
    @NotNull
    @Min(1)
    @Schema(name = "nominal_pajak", type = "numeric", description = "Nominal Pajak Transaksi", required = true, example = "2000")
    private int nominal_pajak;

    @Column(length = 100)
    @Size(max = 100, message = "Maksimum 100 karakter")
    @NotBlank(message = "nama vendor is mandatory")
    @Schema(name = "nama_vendor", type = "string", description = "Nama Vendor Penyedia Layanan", required = true, example = "PT Cartenz")
    private String nama_vendor;

    @Column(length = 20)
    @Size(max = 20, message = "Maksimum 20 karakter")
    @NotBlank(message = "status device is mandatory")
    @Schema(name = "status_device", type = "string", description = "Status Alat", required = true, example = "Online")
    private String status_device;

    @Column(length = 20)
    @Size(max = 20, message = "Maksimum 20 karakter")
    @NotBlank(message = "jenis device is mandatory")
    @Schema(name = "jenis_device", type = "string", description = "Jenis Alat", required = true, example = "POS/Cash Register")
    private String jenis_device;

    @Column(length = 50)
    @Size(max = 50, message = "Maksimum 50 karakter")
    @NotBlank(message = "kabupaten is mandatory")
    @Schema(name = "kabupaten", type = "string", description = "Nama Kabupaten/Kota", required = true, example = "Kabupaten Sukoharjo")
    private String kabupaten;

}

