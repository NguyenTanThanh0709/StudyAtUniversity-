use master
go

--DROP DATABASE QuanLyGiaoDichATM_CuaCacNganHang

create database QuanLyGiaoDichATM_CuaCacNganHang
go
use QuanLyGiaoDichATM_CuaCacNganHang
go

CREATE TABLE Ngan_Hang
(
  ID_Ngan_Hang VARCHAR(50) NOT NULL,
  Ten_ngan_hang NVARCHAR(50) ,
  soLuong_CN int default 0,
  Quoc_Gia NVARCHAR(50) ,
  PRIMARY KEY (ID_Ngan_Hang)
);

go

CREATE TABLE Thanh_Pho
(
  ID_Thanh_Pho VARCHAR(50) NOT NULL,
  Ten_Thanh_Pho NVARCHAR(50) NOT NULL ,
  PRIMARY KEY (ID_Thanh_Pho)
);

go

CREATE TABLE Khach_Hang
(
  ID_khachHang VARCHAR(50) NOT NULL,
  First_Name NVARCHAR(50) ,
  Last_Name NVARCHAR(50) ,
  NgaySinh DATE ,
  DiaChi NVARCHAR(50) ,
  SoDienThoai VARCHAR(50),
  PRIMARY KEY (ID_khachHang)
);



go

CREATE TABLE Than_Nhan
(
  SoDienThoai VARCHAR(50) NOT NULL,
  HoVaTen NVARCHAR(50) ,
  MoiQuanHe NVARCHAR(50) ,
  NgaySinh DATE ,
  PRIMARY KEY (SoDienThoai)
);


go

CREATE TABLE KhachHang_co_thanNhan
(
  ID_khachHang VARCHAR(50) NOT NULL,
  SoDienThoai_thannhan VARCHAR(50) NOT NULL,
  PRIMARY KEY (ID_khachHang, SoDienThoai_thannhan),
  FOREIGN KEY (ID_khachHang) REFERENCES Khach_Hang(ID_khachHang),
  FOREIGN KEY (SoDienThoai_thannhan) REFERENCES Than_Nhan(SoDienThoai)
);

go

CREATE TABLE Chi_Nhanh
(
  ID_Chi_Nhanh VARCHAR(50) NOT NULL,
  Ten_chi_Nhanh NVARCHAR(50) NOT NULL,
  ID_Ngan_Hang VARCHAR(50) NOT NULL,
  ID_Thanh_Pho VARCHAR(50) NOT NULL,
  PRIMARY KEY (ID_Chi_Nhanh),
  FOREIGN KEY (ID_Ngan_Hang) REFERENCES Ngan_Hang(ID_Ngan_Hang),
  FOREIGN KEY (ID_Thanh_Pho) REFERENCES Thanh_Pho(ID_Thanh_Pho)
);

go

CREATE TABLE May_ATM
(
  ID_ATM VARCHAR(50) NOT NULL,
  Tinh_trang_Hoat_Dong VARCHAR(50) ,
  Noi_dat_cu_the NVARCHAR(50) ,
  ID_Chi_Nhanh VARCHAR(50) NOT NULL,
  PRIMARY KEY (ID_ATM),
  FOREIGN KEY (ID_Chi_Nhanh) REFERENCES Chi_Nhanh(ID_Chi_Nhanh),

);

go

CREATE TABLE TaiKhoan
(
  ID_taikhoan VARCHAR(50) NOT NULL,
  ten_taiKhoan VARCHAR(50) NOT NULL,
  ngay_lap_taiKhoan DATE DEFAULT GETDATE(),
  ID_khachHang VARCHAR(50) NOT NULL,
  ID_Ngan_Hang VARCHAR(50) NOT NULL,
  PRIMARY KEY (ID_taikhoan),
  FOREIGN KEY (ID_khachHang) REFERENCES Khach_Hang(ID_khachHang),
  FOREIGN KEY (ID_Ngan_Hang) REFERENCES Ngan_Hang(ID_Ngan_Hang)
);



go

CREATE TABLE DATRI_Chi_Nhanh_So_dien_thoai
(
  ID_Chi_Nhanh VARCHAR(50) NOT NULL,
  So_dien_thoai VARCHAR(50),
  PRIMARY KEY (So_dien_thoai, ID_Chi_Nhanh),
  FOREIGN KEY (ID_Chi_Nhanh) REFERENCES Chi_Nhanh(ID_Chi_Nhanh)
);

go

go

CREATE TABLE The
(
  ID_the VARCHAR(50) NOT NULL,
  Ngay_cap DATE DEFAULT GETDATE(),
  ID_taikhoan varchar(50),
  FOREIGN KEY (ID_taikhoan) REFERENCES TaiKhoan(ID_taikhoan),
  PRIMARY KEY (ID_the)
);

go

CREATE TABLE The_Gold
(
  ID_the VARCHAR(50) ,
  do_uu_tien INT ,
  Diem_thuong INT ,
  loaiThe varchar(50),
  check(loaiThe in ('theGOLD')),
  PRIMARY KEY (ID_the),
  FOREIGN KEY (ID_the) REFERENCES The(ID_the)
);

go

CREATE TABLE The_Silver
(
  ID_the VARCHAR(50) NOT NULL,
  gioi_han_giao_dich_trongNgay FLOAT NOT NULL,
  Han_su_dung DATE NOT NULL,
  level INT NOT NULL,
  phi_giao_dich FLOAT NOT NULL,
  loaiThe varchar(50),
  check(loaiThe in ('theSilver')),
  PRIMARY KEY (ID_the),
  FOREIGN KEY (ID_the) REFERENCES The(ID_the)
);

go

CREATE TABLE the_thuc_hien_giaodich_o_ATM
(
  ID_giao_dich VARCHAR(50) NOT NULL,
  ngay_giaodich DATE DEFAULT GETDATE(),
  sotien_giaodich FLOAT NOT NULL,
  tong_tien_giaodich_trongngay FLOAT ,
  ID_ATM VARCHAR(50) NOT NULL,
  ID_the VARCHAR(50) NOT NULL,
  PRIMARY KEY (ID_giao_dich),
  FOREIGN KEY (ID_ATM) REFERENCES May_ATM(ID_ATM),
  FOREIGN KEY (ID_the) REFERENCES The(ID_the),
  UNIQUE (ID_ATM, ID_the),
  check (sotien_giaodich >= 10000)
);

go


-- TẠO FUNCTION SINH KHÓA CHÍNH TỰ ĐỘNG CHO BẢNG NGÂN HÀNG

CREATE FUNCTION AUTO_ID_NganHang(@KYTU VARCHAR(10))
RETURNS VARCHAR(50)
AS
BEGIN
	DECLARE @ID VARCHAR(50)
	DECLARE @soLuong int

	IF (select count(ID_Ngan_Hang) from Ngan_Hang) = 0
		BEGIN
			SET @ID = @KYTU + '1'
		END
	ELSE
		BEGIN
			SELECT @soLuong = MAX(CONVERT(INT, SUBSTRING(ID_Ngan_Hang,4,len(ID_Ngan_Hang)-3)))+1 FROM Ngan_Hang
			--SET @ID = @KYTU + CONVERT(varchar,@soLuong + 1 )
			SET @ID = @KYTU +  CAST(@soLuong AS VARCHAR(50))
		END

	RETURN @ID
END

go

create  proc insertInto_NganHang @tenNganHang varchar(50), @quocGia varchar(50)
as
	insert into Ngan_Hang values([dbo].AUTO_ID_NganHang('NH_'),@tenNganHang,@quocGia,0)

go


-- TẠO FUNCTION SINH KHÓA CHÍNH TỰ ĐỘNG CHO BẢNG THÀNH PHỐ

  
CREATE FUNCTION AUTO_ID_ThanhPho(@KYTU VARCHAR(10))
RETURNS VARCHAR(50)
AS
BEGIN
	DECLARE @ID VARCHAR(50)
	DECLARE @soLuong int

	IF (select count(ID_Thanh_Pho) from Thanh_Pho) = 0
		BEGIN
			SET @ID = @KYTU + '1'
		END
	ELSE
		BEGIN
			SELECT @soLuong = MAX(CONVERT(INT, SUBSTRING(ID_Thanh_Pho,4,len(ID_Thanh_Pho)-3)))+1 FROM Thanh_Pho
			--SET @ID = @KYTU + CONVERT(varchar,@soLuong + 1 )
			SET @ID = @KYTU +  CAST(@soLuong AS VARCHAR(50))
		END

	RETURN @ID
END

go

create  proc insertInto_ThanhPho @tenThanhPho varchar(50)
as
	insert into Thanh_Pho values([dbo].AUTO_ID_ThanhPho('VN_'),@tenThanhPho)

go





GO

-- TẠO FUNCTION SINH KHÓA CHÍNH TỰ ĐỘNG CHO BẢNG CHI NHÁNH
CREATE FUNCTION AUTO_ID_ChiNhanh()
RETURNS VARCHAR(50)
AS
BEGIN
	DECLARE @id VARCHAR(50)
	DECLARE @SoLuong int
	IF (SELECT COUNT(ID_Chi_Nhanh) FROM Chi_Nhanh) = 0
		SET @id = CONVERT(VARCHAR,GETDATE(),112) + '_CN_' + '1'
	ELSE
		BEGIN 
			SELECT  @soLuong = MAX(CONVERT(INT, SUBSTRING(ID_Chi_Nhanh,13,len(ID_Chi_Nhanh)-12)))+1 FROM Chi_Nhanh
			SET @ID = CONVERT(VARCHAR,GETDATE(),112) + '_CN_' + CAST(@soLuong AS VARCHAR(50))
		END
	RETURN @id
END

GO

create proc insertSDT_CN @ID_CN varchar(50), @SDT varchar(50)
as
begin
	insert into Chi_Nhanh_So_dien_thoai values(@ID_CN, @SDT)
end

GO

create  proc insertInto_ChiNhanh @tenChiNhanh varchar(50), @ID_NganHang varchar(50), @id_thanhPho varchar(50), @SDT VARCHAR(50)
as
begin
	DECLARE @ID VARCHAR(50)
	SET @ID = [dbo].AUTO_ID_ChiNhanh()
	insert into Chi_Nhanh values(@ID,@tenChiNhanh, @ID_NganHang, @id_thanhPho)
	EXEC insertSDT_CN @ID, @SDT
end
go

-- TRIGGER KIỂM TRA CÁC RÀNG BUỘC KHÓA NGOẠI VÀ THAM CHIẾU

/* cập nhất (tăng) số lượng chi nhánh của ngân hàng khi ngân hàng mở thêm một chi nhánh mới */
go

CREATE TRIGGER TANG_SL_CN_NGANHANG ON Chi_Nhanh after insert, update 
as
begin
	update Ngan_Hang
	set soLuong_CN = soLuong_CN + 1
	from Ngan_Hang join inserted on Ngan_Hang.ID_Ngan_Hang = inserted.ID_Ngan_Hang
end

go
/* cập nhất (giảm) số lượng chi nhánh của ngân hàng khi ngân hàng dừng hoạt động một chi nhánh */

CREATE TRIGGER GIAM_SL_CN_NGANHANG ON Chi_Nhanh after delete, update 
as
begin
	update Ngan_Hang
	set soLuong_CN = case 
						when soLuong_CN = 0 then 0
						when soLuong_CN > 0 then soLuong_CN-1
					end
	from Ngan_Hang join deleted on Ngan_Hang.ID_Ngan_Hang = deleted.ID_Ngan_Hang
end


/* Trigger kiểm tra điều kiện ràng buộc của tình trạng hoạt động*/
go
create trigger Check_rangBuocHoatDong_MAY_ATM on May_ATM for insert, update
as 
	if(select Tinh_trang_Hoat_Dong from inserted) not in ('hong','hoat dong', 'bao tri')
		begin
			print N'Tình trạng hoạt động không hợp lệ! vui long kiểm tra lại';
			rollback tran
		end

/* Trigger kiểm tra ràng buộc rút tiền khi thực hiện giao dịch tại ATM the_thuc_hien_giaodich_o_ATM */
go

create trigger Check_rangBuocGiaoDich_ATM on the_thuc_hien_giaodich_o_ATM for insert, update
as 
	if(select sotien_giaodich from inserted) <= 10000
		begin
			print N'Số tiền giao dịch quá bé! không thể thực hiện được';
			RaisError ('Số tiền giao dịch quá bé! không thể thực hiện được', 16, 1)
			rollback tran
		end

go

/* Trigger kiểm tra ràng buộc khóa ngoại của máy ATM */
create trigger Check_rangBuocKhoaNgoai_MAY_ATM on May_ATM for insert, update
as 
	if(select ID_Chi_Nhanh from inserted) not in (select ID_Chi_Nhanh from Chi_Nhanh)
		begin
			print N'Chi nhánh của máy ATM này không tồn tại! vui lòng kiểm tra lại';
			RaisError ('Chi nhánh của máy ATM này không tồn tại! vui lòng kiểm tra lại', 16, 1)
			rollback tran
		end
go
