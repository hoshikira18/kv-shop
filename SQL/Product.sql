create table Products(
	ProID int IDENTITY(1, 1),
	Pro_Name nvarchar(50) NOT NULL,
	Image varchar(100),
	Price real NOT NULL,
	SupID int not null,
	Inventory int default 0 check(Inventory >= 0),
	Create_At datetime default (getdate()),
	PRIMARY KEY(ProID),
	foreign key (CategoryID) references Categories(CategoryID),
	foreign key (SupID) references Suppliers(SupID),
)