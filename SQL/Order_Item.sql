create table Order_Items(
	ItemID int IDENTITY(1,1),
	OrderID int not null,
	ProID int not null,
	Quantity int default 0 check(Quantity >= 0),
	primary key (ItemID),
	foreign key (ProID) references Products(ProID),
	foreign key (OrderID) references Orders(OrderID),
)