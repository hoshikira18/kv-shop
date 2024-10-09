use kvshop
create table Users(
	UserID int IDENTITY(1,1),
	UserName nvarchar(30) not null,
	Age int not null check (Age >= 18),
	PhoneNumber varchar(10),
	Address nvarchar(50),
	Email varchar(50) not null,
	Password varchar(100) not null,
	primary key (UserID)
)