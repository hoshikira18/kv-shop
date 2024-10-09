create table Carts(
	CartID int IDENTITY(1,1),
	UserID int not null,
	Total real default 0,
	Create_At datetime default (getdate()),
	primary key (CartID),
	foreign key (UserID) references Users(UserID),
)