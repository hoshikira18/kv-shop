create table Categories(
	CategoryID int IDENTITY(1,1),
	CategoryName nvarchar(50) not null,
	Create_At datetime default (getdate()),
	primary key (CategoryID),
)