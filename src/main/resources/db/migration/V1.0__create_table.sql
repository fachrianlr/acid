drop table IF EXISTS pajak.tappingbox;
DROP PROCEDURE IF EXISTS pajak.insertTapping;
create table pajak.tappingbox (
id bigint AUTO_INCREMENT PRIMARY KEY,
nama_wapu nvarchar (100) ,
alamat_wapu  nvarchar (100) ,
jenis_pajak nvarchar (50) ,
tanggal_trx datetime default CURRENT_TIMESTAMP,
nominal_total numeric,
nominal_pajak numeric,
nama_vendor nvarchar (100) ,
status_device nvarchar (20) ,
jenis_device nvarchar (20) ,
kabupaten nvarchar (50)
);