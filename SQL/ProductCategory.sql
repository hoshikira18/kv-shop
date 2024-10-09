create table ProductCategories(
	ProCateID int IDENTITY(1,1),
	ProID int not null,
	CategoryID int not null,
	Create_At datetime default (getdate()),
	primary key (ProCateID),
	foreign key (ProID) references Products(ProID),
	foreign key (CategoryID) references Categories(CategoryID),
)