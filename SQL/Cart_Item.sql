create table Cart_Items(
	ItemID int IDENTITY(1,1),
	CartID int not null,
	ProID int not null,
	Quantity int default 0 check (Quantity >= 0),
	Create_At datetime default (getdate()),
	primary key (ItemID),
	foreign key (CartID) references Carts(CartID),
	foreign key (ProID) references Products(ProID),
)