CREATE DATABASE PoLyBop
GO 

USE PoLyBop 
GO 

CREATE TABLE [LoaiVi] (
  [IDLoaiVi] INT IDENTITY,
  [Ma_LoaiVi] Varchar(50),
  [TenLoaiVi] Nvarchar(50),
  [TrangThai] BIT,
  PRIMARY KEY ([IDLoaiVi])
);

CREATE TABLE [ChatLieu] (
  [IDChatLieu] INT IDENTITY,
  [Ma_ChatLieu] Varchar(50),
  [TenChatLieu] Nvarchar(50),
  [TrangThai] BIT,
  PRIMARY KEY ([IDChatLieu])
);

CREATE TABLE [XuatXu] (
  [IDXuatXu] INT IDENTITY,
  [Ma_XuatXu] Varchar(50),
  [TenXuatXu] Nvarchar(50),
  [TrangThai] BIT,
  PRIMARY KEY ([IDXuatXu])
);

CREATE TABLE [ThuongHieu] (
  [IDThuongHieu] INT IDENTITY,
  [Ma_ThuongHieu] VarChar(50),
  [TenThuongHieu] Nvarchar(50),
  [TrangThai] BIT,
  PRIMARY KEY ([IDThuongHieu])
);

CREATE TABLE [Vi] (
  [IDVi] INT IDENTITY,
  [ID_ThuongHieu] INT,
  [Ma_Vi] VarChar(50),
  [KieuDang] NVARCHAR(50),
  [TenVi] NVARCHAR(100),
  [Url_Anh] VARCHAR(200),
  [TrangThai] BIT,
  PRIMARY KEY ([IDVi]),
  CONSTRAINT [FK_Vi.ID_ThuongHieu]
    FOREIGN KEY ([ID_ThuongHieu])
      REFERENCES [ThuongHieu]([IDThuongHieu])
);

CREATE TABLE [MauSac] (
  [IDMauSac] INT IDENTITY,
  [Ma_MauSac] Varchar(50),
  [TenMauSac] Nvarchar(50),
  [TrangThai] BIT,
  PRIMARY KEY ([IDMauSac])
);

CREATE TABLE [ChiTietVi] (
  [IDChiTietVi] INT IDENTITY,
  [ID_Vi] INT,
  [ID_MauSac] INT,
  [ID_ChatLieu] INT,
  [ID_XuatXu] INT,
  [ID_LoaiVi] INT,
  [Ma_ChiTietVi] VarChar(50),
  [KhoaVi] Nvarchar(50),
  [SoNganDungThe] VARCHAR(50),
  [SoLuong] INT,
  [GiaNhap] Decimal,
  [GiaBan] Decimal,
  [NgayNhap] Date,
  [TrangThai] BIT,
  PRIMARY KEY ([IDChiTietVi]),
  CONSTRAINT [FK_ChiTietVi.ID_LoaiVi]
    FOREIGN KEY ([ID_LoaiVi])
      REFERENCES [LoaiVi]([IDLoaiVi]),
  CONSTRAINT [FK_ChiTietVi.ID_ChatLieu]
    FOREIGN KEY ([ID_ChatLieu])
      REFERENCES [ChatLieu]([IDChatLieu]),
  CONSTRAINT [FK_ChiTietVi.ID_XuatXu]
    FOREIGN KEY ([ID_XuatXu])
      REFERENCES [XuatXu]([IDXuatXu]),
  CONSTRAINT [FK_ChiTietVi.ID_Vi]
    FOREIGN KEY ([ID_Vi])
      REFERENCES [Vi]([IDVi]),
  CONSTRAINT [FK_ChiTietVi.ID_MauSac]
    FOREIGN KEY ([ID_MauSac])
      REFERENCES [MauSac]([IDMauSac])
);

CREATE TABLE [NhanVien] (
  [IDNhanVien] INT IDENTITY,
  [Ma_NhanVien] Varchar(50),
  [HoTen] Nvarchar(50),
  [ChucVu] BIT,
  [NgaySinh] Date,
  [SDT] Nvarchar(10),
  [Email] Nvarchar(50),
  [GioiTinh] BIT,
  [DiaChi] Nvarchar(50),
  [MatKhau] Nvarchar(32),
  [TrangThai] BIT,
  PRIMARY KEY ([IDNhanVien])
);

CREATE TABLE [KhachHang] (
  [IDKhangHang] INT IDENTITY,
  [TenKhachHang] Nvarchar(50),
  [SDT] Nvarchar(50),
  [NgaySinh] Date,
  [Email] Nvarchar(50),
  [DiaChi] Nvarchar(50),
  [TrangThai] BIT,
  PRIMARY KEY ([IDKhangHang])
);

CREATE TABLE [KhuyenMai] (
  [IDKhuyenMai] INT IDENTITY,
  [Ma_KhuyenMai] Nvarchar(50),
  [GiaTri] INT,
  [NgayBatDau] Date,
  [NgayKetThuc] Date,
  [KieuGiamGia] Decimal,
  [TrangThai] BIT,
  PRIMARY KEY ([IDKhuyenMai])
);

CREATE TABLE [HoaDon] (
  [IDHoaDon] INT IDENTITY,
  [ID_KhachHang] INT,
  [ID_NhanVien] INT,
  [ID_KhuyenMai] INT,
  [Ma_HoaDon] Varchar(50),
  [TienSauGiamGia] Decimal,
  [ThanhTien] Decimal,
  [PhuongThucThanhToan] BIT,
  [NgayThanhToan] Date,
  [TrangThai] BIT,
  PRIMARY KEY ([IDHoaDon]),
  CONSTRAINT [FK_HoaDon.ID_NhanVien]
    FOREIGN KEY ([ID_NhanVien])
      REFERENCES [NhanVien]([IDNhanVien]),
  CONSTRAINT [FK_HoaDon.ID_KhachHang]
    FOREIGN KEY ([ID_KhachHang])
      REFERENCES [KhachHang]([IDKhangHang]),
  CONSTRAINT [FK_HoaDon.ID_KhuyenMai]
    FOREIGN KEY ([ID_KhuyenMai])
      REFERENCES [KhuyenMai]([IDKhuyenMai])
);

CREATE TABLE [HoaDonChiTiet] (
  [IDHoaDonChiTiet] INT IDENTITY,
  [ID_HoaDon] INT,
  [ID_ChiTietVi] INT,
  [Ma_HoaDonChiTiet] Varchar(50),
  [SoLuong] INT,
  [DonGia] Decimal,
  [TrangThai] BIT,
  PRIMARY KEY ([IDHoaDonChiTiet]),
  CONSTRAINT [FK_HoaDonChiTiet.ID_ChiTietVi]
    FOREIGN KEY ([ID_ChiTietVi])
      REFERENCES [ChiTietVi]([IDChiTietVi]),
  CONSTRAINT [FK_HoaDonChiTiet.ID_HoaDon]
    FOREIGN KEY ([ID_HoaDon])
      REFERENCES [HoaDon]([IDHoaDon])
);

CREATE TABLE [GioHang] (
  [IDGioHang] INT IDENTITY,
  [ID_KhachHang] INT,
  [Ma_GioHang] Varchar(50),
  [NgayTao] Date,
  [TrangThai] BIT,
  PRIMARY KEY ([IDGioHang]),
  CONSTRAINT [FK_GioHang.ID_KhachHang]
    FOREIGN KEY ([ID_KhachHang])
      REFERENCES [KhachHang]([IDKhangHang])
);

CREATE TABLE [ChiTietGioHang] (
  [IDChiTietGioHang] INT IDENTITY,
  [ID_GioHang] INT,
  [ID_ChiTietVi] INT,
  [Ma_ChiTietGiohang] Varchar(50),
  [SoLuong] INT,
  [TrangThai] BIT,
  PRIMARY KEY ([IDChiTietGioHang]),
  CONSTRAINT [FK_ChiTietGioHang.ID_GioHang]
    FOREIGN KEY ([ID_GioHang])
      REFERENCES [GioHang]([IDGioHang]),
  CONSTRAINT [FK_ChiTietGioHang.ID_ChiTietVi]
    FOREIGN KEY ([ID_ChiTietVi])
      REFERENCES [ChiTietVi]([IDChiTietVi])
);

-- Thêm d? li?u 
-- Lo?i Ví
INSERT INTO LoaiVi (Ma_LoaiVi, TenLoaiVi, TrangThai) VALUES 
('LV001', N'Ví Th??ng', 1),
('LV002', N'Ví Ti?t Ki?m', 1),
('LV003', N'Ví ?i?n T?', 1),
('LV004', N'Ví Công Nghi?p', 0),
('LV005', N'Ví H?c Sinh', 1),
('LV006', N'Ví Du L?ch', 1),
('LV007', N'Ví Cá Nhân', 1),
('LV008', N'Ví Kinh Doanh', 0),
('LV009', N'Ví Th? Thao', 1),
('LV010', N'Ví M? Ph?m', 1),
('LV011', N'Ví Ngh? Thu?t', 1),
('LV012', N'Ví Y T?', 1),
('LV013', N'Ví ??c Bi?t', 1),
('LV014', N'Ví Tài Chính', 0),
('LV015', N'Ví Th?i Trang', 1),
('LV016', N'Ví Âm Nh?c', 1),
('LV017', N'Ví Ph?n M?m', 1),
('LV018', N'Ví Xe H?i', 0),
('LV019', N'Ví ?i?n Tho?i', 1),
('LV020', N'Ví Th?c ?n', 1);
-- Ch?t Li?u 
INSERT INTO ChatLieu (Ma_ChatLieu, TenChatLieu, TrangThai) VALUES 
('CL001', N'V?i', 1),
('CL002', N'G?', 1),
('CL003', N'Nh?a', 1),
('CL004', N'Kim lo?i', 1),
('CL005', N'?á', 1),
('CL006', N'S?', 1),
('CL007', N'Gi?y', 1),
('CL008', N'Nhôm', 1),
('CL009', N'G?m', 1),
('CL010', N'Ch?t li?u t? nhiên', 1),
('CL011', N'Carbon', 1),
('CL012', N'Composite', 1),
('CL013', N'Cao su', 1),
('CL014', N'??ng', 1),
('CL015', N'Silicone', 1),
('CL016', N'Kính', 1),
('CL017', N'L?a', 1),
('CL018', N'Vàng', 1),
('CL019', N'B?c', 1),
('CL020', N'Inox', 1);
-- Xu?t X? 
INSERT INTO XuatXu (Ma_XuatXu, TenXuatXu, TrangThai) VALUES 
('XX001', N'Vi?t Nam', 1),
('XX002', N'M?', 1),
('XX003', N'Trung Qu?c', 1),
('XX004', N'Hàn Qu?c', 1),
('XX005', N'Nh?t B?n', 1),
('XX006', N'Pháp', 1),
('XX007', N'??c', 1),
('XX008', N'Ý', 1),
('XX009', N'Anh', 1),
('XX010', N'Nga', 1),
('XX011', N'Brazil', 1),
('XX012', N'Canada', 1),
('XX013', N'Úc', 1),
('XX014', N'?n ??', 1),
('XX015', N'Thái Lan', 1),
('XX016', N'Malaysia', 1),
('XX017', N'Singapore', 1),
('XX018', N'Indonesia', 1),
('XX019', N'Mexico', 1),
('XX020', N'Tây Ban Nha', 1);
-- Màu S?c 
INSERT INTO MauSac (Ma_MauSac, TenMauSac, TrangThai) VALUES 
('MS001', N'Do', 1),
('MS002', N'Xanh D??ng', 1),
('MS003', N'Vàng', 1),
('MS004', N'Xám', 1),
('MS005', N'?en', 1),
('MS006', N'Tr?ng', 1),
('MS007', N'Xanh Lá', 1),
('MS008', N'H?ng', 1),
('MS009', N'Cam', 1),
('MS010', N'Nâu', 1),
('MS011', N'?? R?c', 1),
('MS012', N'Be', 1),
('MS013', N'Tím', 1),
('MS014', N'Xanh Ng?c', 1),
('MS015', N'?? T??i', 1),
('MS016', N'Nâu ??m', 1),
('MS017', N'Vàng Nh?t', 1),
('MS018', N'Xám ??m', 1),
('MS019', N'?en Bóng', 1),
('MS020', N'H?ng Ph?n', 1);
-- Th??ng hi?u 
INSERT INTO ThuongHieu (Ma_ThuongHieu, TenThuongHieu, TrangThai) VALUES 
('TH001', N'Nike', 1),
('TH002', N'Adidas', 1),
('TH003', N'Gucci', 1),
('TH004', N'Apple', 1),
('TH005', N'Samsung', 1),
('TH006', N'Lacoste', 1),
('TH007', N'Chanel', 1),
('TH008', N'Microsoft', 1),
('TH009', N'Toyota', 1),
('TH010', N'Mercedes-Benz', 1),
('TH011', N'Sony', 1),
('TH012', N'Louis Vuitton', 1),
('TH013', N'BMW', 1),
('TH014', N'Coca-Cola', 1),
('TH015', N'Pepsi', 1),
('TH016', N'Nike', 1),
('TH017', N'McDonald', 1),
('TH018', N'Stella Artois', 1),
('TH019', N'KFC', 1),
('TH020', N'Canon', 1);
-- Ví 
INSERT INTO Vi (ID_ThuongHieu, Ma_Vi, KieuDang, TenVi, Url_Anh, TrangThai) VALUES 
(1, 'V001', N'Bifold', N'Nike Sport Wallet', 'wallet.jpg', 1),
(2, 'V002', N'Trilfold', N'Adidas Originals Wallet', 'wallet.jpg', 1),
(3, 'V003', N'Card Holder', N'Gucci Leather Card Holder', 'holder.jpg', 1),
(4, 'V004', N'iPhone Wallet', N'Apple Leather Wallet Case', 'case.jpg', 1),
(5, 'V005', N'Samsung Galaxy Wallet', N'Samsung Galaxy S21 Wallet Case', 'case.jpg', 1),
(6, 'V006', N'Lacoste Slim Wallet', N'Lacoste Men\', 'wallet.jpg', 1),
(7, 'V007', N'Chanel Quilted Wallet', N'Chanel Classic Quilted Wallet', 'wallet.jpg', 1),
(8, 'V008', N'Surface Wallet', N'Microsoft Surface Duo Wallet Case', 'case.jpg', 1),
(9, 'V009', N'Toyota Leather Wallet', N'Toyota Genuine Leather Wallet', 'wallet.jpg', 1),
(10, 'V010', N'Mercedes-Benz Money Clip', N'Mercedes-Benz Men', 'clip.jpg', 1),
(11, 'V011', N'Sony Passport Holder', N'Sony Travel Passport Holder', 'holder.jpg', 1),
(12, 'V012', N'LV Monogram Wallet', N'Louis Vuitton Monogram Canvas Wallet', 'wallet.jpg', 1),
(13, 'V013', N'BMW Card Wallet', N'BMW Genuine Leather Card Wallet', 'wallet.jpg', 1),
(14, 'V014', N'Coca-Cola Coin Purse', N'Coca-Cola Logo Coin Purse', 'purse.jpg', 1),
(15, 'V015', N'Pepsi Slim Wallet', N'Pepsi Logo Slim Wallet', 'wallet.jpg', 1),
(16, 'V016', N'Nike Tri-fold Wallet', N'Nike Tri-fold Wallet for Men', 'wallet.jpg', 1),
(17, 'V017', N'McDonald\', N'McDonal Clip', 'clip.jpg', 1),
(18, 'V018', N'Stella Artois Card Holder', N'Stella Artois Leather Card Holder', 'holder.jpg', 1),
(19, 'V019', N'KFC Slim Wallet', N'KFC Colonel Slim Wallet', 'wallet.jpg', 1),
(20, 'V020', N'Canon Camera Bag', N'Canon DSLR Camera Bag', 'bag.jpg', 1);
-- Chi ti?t Ví  
INSERT INTO ChiTietVi (ID_Vi, ID_MauSac, ID_ChatLieu, ID_XuatXu, ID_LoaiVi, Ma_ChiTietVi, KhoaVi, SoNganDungThe, SoLuong, GiaNhap, GiaBan, NgayNhap, TrangThai) VALUES 
(1, 1, 1, 1, 1, 'CTV001', N'NikeSportWallet-Red', '10 Card Slots', 50, 150000, 200000, '2023-01-01', 1),
(2, 2, 2, 2, 2, 'CTV002', N'AdidasOriginalsWallet-Blue', '8 Card Slots', 30, 120000, 180000, '2023-01-02', 1),
(3, 3, 3, 3, 3, 'CTV003', N'GucciCardHolder-Black', '4 Card Slots', 20, 300000, 450000, '2023-01-03', 1),
(4, 4, 4, 4, 4, 'CTV004', N'AppleWalletCase-Brown', 'iPhone 12 Pro Max', 15, 250000, 350000, '2023-01-04', 1),
(5, 5, 5, 5, 5, 'CTV005', N'SamsungGalaxyWallet-Green', 'Galaxy S21 Ultra', 25, 200000, 300000, '2023-01-05', 1),
(6, 6, 6, 6, 6, 'CTV006', N'LacosteSlimWallet-White', 'Slim Design', 35, 180000, 250000, '2023-01-06', 1),
(7, 7, 7, 7, 7, 'CTV007', N'ChanelQuiltedWallet-Pink', 'Classic Quilted', 40, 500000, 700000, '2023-01-07', 1),
(8, 8, 8, 8, 8, 'CTV008', N'SurfaceWallet-Gray', 'Microsoft Surface Duo', 10, 400000, 600000, '2023-01-08', 1),
(9, 9, 9, 9, 9, 'CTV009', N'ToyotaLeatherWallet-Brown', 'Genuine Leather', 18, 220000, 320000, '2023-01-09', 1),
(10, 10, 10, 10, 10, 'CTV010', N'MercedesMoneyClip-Black', 'Men Money Clip', 22, 280000, 400000, '2023-01-10', 1),
(11, 11, 11, 11, 11, 'CTV011', N'SonyPassportHolder-Red', 'Travel Passport Holder', 28, 350000, 500000, '2023-01-11', 1),
(12, 12, 12, 12, 12, 'CTV012', N'LVMonogramWallet-Beige', 'Monogram Canvas', 12, 600000, 800000, '2023-01-12', 1),
(13, 13, 13, 13, 13, 'CTV013', N'BMWCardWallet-Blue', 'Genuine Leather', 14, 260000, 380000, '2023-01-13', 1),
(14, 14, 14, 14, 14, 'CTV014', N'CocaColaCoinPurse-Red', 'Logo Coin Purse', 16, 120000, 180000, '2023-01-14', 1),
(15, 15, 15, 15, 15, 'CTV015', N'PepsiSlimWallet-Blue', 'Logo Slim Wallet', 20, 150000, 220000, '2023-01-15', 1),
(16, 16, 16, 16, 16, 'CTV016', N'NikeTrifoldWallet-Black', 'Trifold Wallet', 25, 190000, 270000, '2023-01-16', 1),
(17, 17, 17, 17, 17, 'CTV017', N'McDonaldsMoneyClip-Gold', 'Golden Arches', 30, 320000, 450000, '2023-01-17', 1),
(18, 18, 18, 18, 18, 'CTV018', N'StellaArtoisCardHolder-Brown', 'Leather Card Holder', 14, 280000, 380000, '2023-01-18', 1),
(19, 19, 19, 19, 19, 'CTV019', N'KFCSlimWallet-Red', 'Colonel Slim Wallet', 18, 200000, 300000, '2023-01-19', 1),
(20, 20, 20, 20, 20, 'CTV020', N'CanonCameraBag-Black', 'DSLR Camera Bag', 22, 400000, 600000, '2023-01-20', 1);
-- Khách hàng 
INSERT INTO KhachHang (TenKhachHang, SDT, NgaySinh, Email, DiaChi, TrangThai) VALUES 
( N'Khách hàng lẻ', '0901234567', '1990-05-15', 'nguyenvana@email.com', N'H? Chí Minh', 0),
( N'Tr?n Th? B', '0912345678', '1985-12-10', 'tranthib@email.com', N'Hà N?i', 1),
( N'Lê Minh C', '0987654321', '1995-08-22', 'leminhc@email.com', N'?à N?ng', 1),
( N'Ph?m Thanh D', '0978123456', '1992-03-08', 'phamthanhd@email.com', N'Nha Trang', 1),
( N'Hu?nh Ng?c E', '0923456789', '1988-11-02', 'huynhngoce@email.com', N'C?n Th?', 1),
( N'Lâm V?n F', '0945678901', '1998-06-17', 'lamvanf@email.com', N'H?i Phòng', 1),
( N'Nguy?n Th? G', '0932109876', '1993-09-25', 'nguyenthig@email.com', N'V?ng Tàu', 1),
( N'Võ Minh H', '0965432109', '1991-04-03', 'vominhh@email.com', N'??ng Nai', 1),
( N'??ng Thùy I', '0954321098', '1997-07-12', 'dangthuyi@email.com', N'Tây Ninh', 1),
( N'Hoàng V?n K', '0912345678', '1994-02-20', 'hoangvank@email.com', N'Hà Nam', 1);
-- Khuy?n mãi 
INSERT INTO KhuyenMai (Ma_KhuyenMai, GiaTri, NgayBatDau, NgayKetThuc, KieuGiamGia, TrangThai) VALUES 
('KM001', 10, '2023-01-01', '2023-01-15', 0.1, 1),
('KM002', 20, '2023-02-01', '2023-02-28', 0.2, 1),
('KM003', 15, '2023-03-01', '2023-03-15', 0.15, 1),
('KM004', 25, '2023-04-01', '2023-04-30', 0.25, 1),
('KM005', 30, '2023-05-01', '2023-05-15', 0.3, 1),
('KM006', 18, '2023-06-01', '2023-06-30', 0.18, 1),
('KM007', 12, '2023-07-01', '2023-07-15', 0.12, 1),
('KM008', 22, '2023-08-01', '2023-08-31', 0.22, 1),
('KM009', 28, '2023-09-01', '2023-09-15', 0.28, 1),
('KM010', 35, '2023-10-01', '2023-10-31', 0.35, 1);
-- Nhân viên
INSERT INTO NhanVien (Ma_NhanVien, HoTen, ChucVu, NgaySinh, SDT, Email, GioiTinh, DiaChi, MatKhau, TrangThai) VALUES 
('NV001', N'Nguy?n V?n N', 1, '1990-05-15', '0901234567', 'nguyenvann@email.com', 1, N'H? Chí Minh', 'hashed_password_1', 1),
('NV002', N'Tr?n Th? M', 0, '1985-12-10', '0912345678', 'tranthim@email.com', 0, N'Hà N?i', 'hashed_password_2', 1),
('NV003', N'Lê Minh O', 0, '1995-08-22', '0987654321', 'lemino@email.com', 1, N'?à N?ng', 'hashed_password_3', 1),
('NV004', N'Ph?m Thanh P', 1, '1992-03-08', '0978123456', 'phamthanhp@email.com', 1, N'Nha Trang', 'hashed_password_4', 1),
('NV005', N'Hu?nh Ng?c Q', 0, '1988-11-02', '0923456789', 'huynhngocq@email.com', 0, N'C?n Th?', 'hashed_password_5', 1),
('NV006', N'Lâm V?n R', 1, '1998-06-17', '0945678901', 'lamvanr@email.com', 1, N'H?i Phòng', 'hashed_password_6', 1),
('NV007', N'Nguy?n Th? S', 0, '1993-09-25', '0932109876', 'nguyenthis@email.com', 0, N'V?ng Tàu', 'hashed_password_7', 1),
('NV008', N'Võ Minh T', 1, '1991-04-03', '0965432109', 'vominht@email.com', 1, N'??ng Nai', 'hashed_password_8', 1),
('NV009', N'??ng Thùy U', 0, '1997-07-12', '0954321098', 'dangthuyu@email.com', 0, N'Tây Ninh', 'hashed_password_9', 1),
('NV010', N'Hoàng V?n V', 1, '1994-02-20', '0912345678', 'hoangvanv@email.com', 1, N'Hà Nam', 'hashed_password_10', 1);
-- Hóa ??n 
INSERT INTO HoaDon (ID_KhachHang, ID_NhanVien, ID_KhuyenMai, Ma_HoaDon, TienSauGiamGia, ThanhTien, PhuongThucThanhToan, NgayThanhToan, TrangThai) VALUES 
(1, 1, 1, 'HD001', 180000, 160000, 1, '2023-01-10', 1),
(2, 2, 2, 'HD002', 144000, 120000, 0, '2023-02-15', 1),
(3, 3, 3, 'HD003', 255000, 220000, 1, '2023-03-20', 1),
(4, 4, 4, 'HD004', 337500, 300000, 0, '2023-04-25', 1),
(5, 5, 5, 'HD005', 210000, 180000, 1, '2023-05-30', 1),
(6, 6, 6, 'HD006', 225000, 200000, 0, '2023-06-05', 1),
(7, 7, 7, 'HD007', 525000, 480000, 1, '2023-07-10', 1),
(8, 8, 8, 'HD008', 450000, 400000, 0, '2023-08-15', 1),
(9, 9, 9, 'HD009', 285000, 250000, 1, '2023-09-20', 1),
(10, 10, 10, 'HD010', 390000, 350000, 0, '2023-10-25', 1);
-- Hóa ??n chi ti?t 
INSERT INTO HoaDonChiTiet (ID_HoaDon, ID_ChiTietVi, Ma_HoaDonChiTiet, SoLuong, DonGia, TrangThai) VALUES 
(1, 1, 'HDCT001', 2, 80000, 1),
(1, 2, 'HDCT002', 1, 80000, 1),
(2, 3, 'HDCT003', 3, 40000, 1),
(2, 4, 'HDCT004', 1, 40000, 1),
(3, 5, 'HDCT005', 2, 110000, 1),
(3, 6, 'HDCT006', 1, 110000, 1),
(4, 7, 'HDCT007', 3, 112500, 1),
(4, 8, 'HDCT008', 1, 112500, 1),
(5, 9, 'HDCT009', 2, 90000, 1),
(5, 10, 'HDCT010', 1, 90000, 1),
(6, 11, 'HDCT011', 2, 100000, 1),
(6, 12, 'HDCT012', 1, 100000, 1),
(7, 13, 'HDCT013', 5, 105000, 1),
(7, 14, 'HDCT014', 1, 105000, 1),
(8, 15, 'HDCT015', 4, 112500, 1),
(8, 16, 'HDCT016', 1, 112500, 1),
(9, 17, 'HDCT017', 3, 75000, 1),
(9, 18, 'HDCT018', 1, 75000, 1),
(10, 19, 'HDCT019', 2, 175000, 1),
(10, 20, 'HDCT020', 1, 175000, 1);
-- Gi? hàng 
INSERT INTO GioHang (ID_KhachHang, Ma_GioHang, NgayTao, TrangThai) VALUES 
(1, 'GH001', '2023-01-01', 1),
(2, 'GH002', '2023-02-01', 1),
(3, 'GH003', '2023-03-01', 1),
(4, 'GH004', '2023-04-01', 1),
(5, 'GH005', '2023-05-01', 1),
(6, 'GH006', '2023-06-01', 1),
(7, 'GH007', '2023-07-01', 1),
(8, 'GH008', '2023-08-01', 1),
(9, 'GH009', '2023-09-01', 1),
(10, 'GH010', '2023-10-01', 1);
-- Chi ti?t gi? hàng 
INSERT INTO ChiTietGioHang (ID_GioHang, ID_ChiTietVi, Ma_ChiTietGioHang, SoLuong, TrangThai) VALUES 
(1, 1, 'CTGH001', 2, 1),
(1, 2, 'CTGH002', 1, 1),
(2, 3, 'CTGH003', 3, 1),
(2, 4, 'CTGH004', 1, 1),
(3, 5, 'CTGH005', 2, 1),
(3, 6, 'CTGH006', 1, 1),
(4, 7, 'CTGH007', 3, 1),
(4, 8, 'CTGH008', 1, 1),
(5, 9, 'CTGH009', 2, 1),
(5, 10, 'CTGH010', 1, 1),
(6, 11, 'CTGH011', 2, 1),
(6, 12, 'CTGH012', 1, 1),
(7, 13, 'CTGH013', 5, 1),
(7, 14, 'CTGH014', 1, 1),
(8, 15, 'CTGH015', 4, 1),
(8, 16, 'CTGH016', 1, 1),
(9, 17, 'CTGH017', 3, 1),
(9, 18, 'CTGH018', 1, 1),
(10, 19, 'CTGH019', 2, 1),
(10, 20, 'CTGH020', 1, 1);
-- 




