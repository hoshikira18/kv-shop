create table Suppliers(
	SupplierID int IDENTITY(1,1),
	SupplierName nvarchar(50) not null,
	Create_At datetime default (getdate()),
	primary key (SupplierID),
)