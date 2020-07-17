CREATE PROCEDURE pajak.insertTapping
(
IN nama_wapu_param nvarchar (100) ,
IN alamat_wapu_param  nvarchar (100) ,
IN jenis_pajak_param nvarchar (50) ,
IN tanggal_trx_param TIMESTAMP ,
IN nominal_total_param numeric,
IN nominal_pajak_param numeric,
IN nama_vendor_param nvarchar (100) ,
IN status_device_param nvarchar (20) ,
IN jenis_device_param nvarchar (20) ,
IN kabupaten_param nvarchar (50),
OUT responcode nvarchar (2)
)

BEGIN
declare namawapuparam nvarchar (100);
declare alamatwapuparam  nvarchar (100);
declare jenispajakparam nvarchar (50);
declare tanggaltrxparam TIMESTAMP;
declare nominaltotalparam numeric;
declare nominalpajakparam numeric;
declare namavendorparam nvarchar (100);
declare statusdeviceparam nvarchar (20);
declare jenisdeviceparam nvarchar (20);
declare kabupatenparam nvarchar (50);

	 SELECT nama_wapu, alamat_wapu, jenis_pajak, tanggal_trx, nominal_total, nominal_pajak, nama_vendor, status_device, jenis_device, kabupaten
	 into namawapuparam, alamatwapuparam, jenispajakparam, tanggaltrxparam, nominaltotalparam, nominalpajakparam, namavendorparam, statusdeviceparam,
	 jenisdeviceparam, kabupatenparam
FROM pajak.tappingbox where
nama_wapu = nama_wapu_param and
alamat_wapu= alamat_wapu_param and
jenis_pajak= jenis_pajak_param and
tanggal_trx= tanggal_trx_param and
nominal_total= nominal_total_param and
nominal_pajak= nominal_pajak_param and
nama_vendor= nama_vendor_param and
status_device= status_device_param and
jenis_device= jenis_device_param and
kabupaten=kabupaten_param ;
case
when
namawapuparam = nama_wapu_param and
alamatwapuparam= alamat_wapu_param and
jenispajakparam= jenis_pajak_param and
tanggaltrxparam= tanggal_trx_param and
nominaltotalparam= nominal_total_param and
nominalpajakparam= nominal_pajak_param and
namavendorparam= nama_vendor_param and
statusdeviceparam= status_device_param and
jenisdeviceparam= jenis_device_param and
kabupatenparam=kabupaten_param
then set responcode ='01';

ELSE

INSERT INTO pajak.tappingbox
  (nama_wapu, alamat_wapu, jenis_pajak, tanggal_trx, nominal_total, nominal_pajak, nama_vendor, status_device, jenis_device, kabupaten)
  values
  (
 nama_wapu_param,
 alamat_wapu_param,
 jenis_pajak_param,
 tanggal_trx_param,
 nominal_total_param,
 nominal_pajak_param,
 nama_vendor_param,
 status_device_param,
 jenis_device_param,
 kabupaten_param);
SET responcode ='00';
	END case;
 END;



 CREATE PROCEDURE pajak.deleteTapping
(
IN nama_wapu_param nvarchar (100) ,
IN alamat_wapu_param  nvarchar (100) ,
IN jenis_pajak_param nvarchar (50) ,
IN tanggal_trx_param TIMESTAMP ,
IN nominal_total_param numeric,
IN nominal_pajak_param numeric,
IN nama_vendor_param nvarchar (100) ,
IN status_device_param nvarchar (20) ,
IN jenis_device_param nvarchar (20) ,
IN kabupaten_param nvarchar (50),
OUT responcode nvarchar (2)
)

begin
 delete from pajak.tappingbox where
nama_wapu = nama_wapu_param and
alamat_wapu= alamat_wapu_param and
jenis_pajak= jenis_pajak_param and
tanggal_trx= tanggal_trx_param and
nominal_total= nominal_total_param and
nominal_pajak= nominal_pajak_param and
nama_vendor= nama_vendor_param and
status_device= status_device_param and
jenis_device= jenis_device_param and
kabupaten=kabupaten_param ;

SET responcode ='00';

 END;

CREATE PROCEDURE pajak.deleteAllTapping
(
OUT responcode nvarchar (2)
)

begin
 delete from pajak.tappingbox;

SET responcode ='00';

 END;