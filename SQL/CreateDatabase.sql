--create database kvshop
use kvshop
go
create table Roles(
	RoleID int IDENTITY(1,1),
	RoleName nvarchar(30),
	Create_At datetime default (getdate()),
	primary key (RoleID),
)
go
create table Users(
	UserID int IDENTITY(1,1),
	UserName nvarchar(30) not null,
	Age int not null check (Age >= 18),
	PhoneNumber varchar(10),
	Address nvarchar(50),
	Email varchar(50) not null,
	Password varchar(100) not null,
	RoleID int not null,
	Create_At datetime default (getdate()),
	primary key (UserID),
	constraint UR_FK foreign key (RoleID) references Roles(RoleID),
)
go
create table Suppliers(
	SupplierID int IDENTITY(1,1),
	SupplierName nvarchar(50) not null,
	Create_At datetime default (getdate()),
	primary key (SupplierID),
)
go
create table Products(
	ProID int IDENTITY(1, 1),
	Pro_Name nvarchar(50) NOT NULL,
	Image varchar(100),
	Price real not null,
	SupID int not null,
	Inventory int default 0 check(Inventory >= 0),
	Create_At datetime default (getdate()),
	primary key (ProID),
	constraint PS_FK foreign key (SupID) references Suppliers(SupplierID),
)
go
create table Categories(
	CategoryID int IDENTITY(1,1),
	CategoryName nvarchar(50) not null,
	Create_At datetime default (getdate()),
	primary key (CategoryID),
)
go
create table ProductCategories(
	ProCateID int IDENTITY(1,1),
	ProID int not null,
	CategoryID int not null,
	Create_At datetime default (getdate()),
	primary key (ProCateID),
	constraint PCP_FK foreign key (ProID) references Products(ProID),
	constraint PCC_FK foreign key (CategoryID) references Categories(CategoryID),
)
go
create table Carts(
	CartID int IDENTITY(1,1),
	UserID int not null,
	Total real default 0,
	Create_At datetime default (getdate()),
	primary key (CartID),
	constraint CU_FK foreign key (UserID) references Users(UserID),
)
go
create table Cart_Items(
	ItemID int IDENTITY(1,1),
	CartID int not null,
	ProID int not null,
	Quantity int default 0 check (Quantity >= 0),
	Create_At datetime default (getdate()),
	primary key (ItemID),
	constraint CIC_FK foreign key (CartID) references Carts(CartID),
	constraint CIP_FK foreign key (ProID) references Products(ProID),
)
go
create table Orders(
	OrderID int IDENTITY(1,1),
	UserID int not null,
	Total real default 0,
	Create_At datetime default (getdate()),
	Status varchar(20) default 'pending',
	primary key (OrderID),
	constraint OU_FK foreign key (UserID) references Users(UserID),
)
go
create table Order_Items(
	ItemID int IDENTITY(1,1),
	OrderID int not null,
	ProID int not null,
	Quantity int default 0 check(Quantity >= 0),
	primary key (ItemID),
	constraint OIP_FK foreign key (ProID) references Products(ProID),
	constraint OIO_FK foreign key (OrderID) references Orders(OrderID),
)
go

insert into Roles (RoleName) values ('admin'), ('customer');
