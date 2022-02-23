create database BookStore
go
use BookStore
go

create table LOAITHANHVIEN(
	maLoaiThanhVien int identity(1,1) primary key,
	tenLoaiThanhVien nvarchar(255),
	uuDai int
)
create table THANHVIEN(
	maThanhVien int identity(1,1) primary key,
	taiKhoan nvarchar(255),
	matKhau nvarchar(255),
	hoTen nvarchar(MAX),
	soDienThoai nvarchar(50),
	diaChi nvarchar(MAX), 
	email nvarchar(MAX),
	maLoaiThanhVien int,
	foreign key(maLoaiThanhVien) references dbo.LOAITHANHVIEN(maLoaiThanhVien) on delete cascade
)
create table NHASANXUAT(
	maNhaSanXuat int identity(1,1) primary key,
	tenNhaSanXuat nvarchar(255),
	thongTin nvarchar(MAX),
	logo nvarchar(MAX)
)
create table DANHMUC(
	maDanhMuc int identity(1,1) primary key,
	tenDanhMuc nvarchar(255)
)
create table THELOAI(
	maTheLoai int identity(1,1) primary key,
	tenTheLoai nvarchar(255),
	icon nvarchar(MAX),
	maDanhMuc int,
	foreign key(maDanhMuc) references dbo.DANHMUC(maDanhMuc) on delete cascade
)
create table SACH(
	maSach int identity(1,1) primary key,
	tenSach nvarchar(255),
	donGia decimal(18,0),
	moTa nvarchar(MAX),
	ngayCapNhat timestamp,
	ngayTao timestamp,
	hinhAnhChinh nvarchar(MAX),
	dsHinhAnhPhu nvarchar(MAX),
	soLuongMua int,
	soLuongTon int,
	maNhaSanXuat int, 
	maTheLoai int,
	foreign key(maTheLoai) references dbo.THELOAI(maTheLoai) on delete cascade,
	foreign key(maNhaSanXuat) references dbo.NHASANXUAT(maNhaSanXuat) on delete cascade,
	
)
create table KHACHHANG(
	maKhachHang int identity(1,1) primary key,
	tenKhachHang nvarchar(255),
	diaChi nvarchar(MAX),
	email nvarchar(MAX),
	soDienThoai nvarchar(50),
	maThanhVien int,
	foreign key(maThanhVien) references dbo.THANHVIEN(maThanhVien) on delete cascade
)
create table DONHANG(
	maDonHang int identity(1,1) primary key,
	ngayDat timestamp,
	ngayGiaoDuKien timestamp,
	tinhTrangGiaoHang nvarchar(MAX),
	daThanhToan bit default 0,
	maKhachHang int,
	uuDai int,
	foreign key(maKhachHang) references dbo.KHACHHANG(maKhachHang) on delete cascade
)
create table PHANHOI(
	maPhanHoi int identity(1,1) primary key,
	noiDung nvarchar(MAX),
	ngayTao timestamp,
	danhGia int,
	maSach int,
	maThanhVien int,
	foreign key(maThanhVien) references dbo.THANHVIEN(maThanhVien) on delete cascade,
	foreign key(maSach) references dbo.SACH(maSach) on delete cascade
)
create table CHITIETDONHANG (
	maChiTietDH int primary key identity(1,1),
	maDonHang int,
	maSach int,
	tenSach nvarchar(255),
	soLuong int,
	donGia decimal(18,0),
	foreign key(maDonHang) references dbo.DONHANG(maDonHang) on delete cascade,
	foreign key(maSach) references dbo.SACH(maSach) on delete cascade
)
create table VAITRO(
	maVaiTro int primary key identity(1,1),
	tenVaiTro nvarchar(255),
)
create table VAITRO_LOAITHANHVIEN(
	maVaiTro int,
	maLoaiThanhVien int,
	foreign key(maVaiTro) references dbo.VAITRO(maVaiTro) on delete cascade,
	foreign key(maLoaiThanhVien) references dbo.LOAITHANHVIEN(maLoaiThanhVien) on delete cascade,
)