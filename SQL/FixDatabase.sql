use kvshop
go
alter table Categories
add Image varchar(max);
go
update Categories
set Image = (select Image from Products where ProID = 1)
go