create table Orders(
	OrderID int IDENTITY(1,1),
	UserID int not null,
	Total real default 0,
	Create_At datetime default (getdate()),
	Status varchar(20) default 'pending',
	primary key (OrderID),
	foreign key (UserID) references Users(UserID),
)