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
	foreign key (RoleID) references Roles(RoleID),
)