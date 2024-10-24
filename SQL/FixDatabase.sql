/*use kvshop
go
alter table Categories
add Image varchar(max);
go
update Categories
set Image = (select Image from Products where ProID = 1)
go*/

use kvshop
go
alter table Products
add Size nvarchar(100),
	Description nvarchar(max);

update Products
set Price = '100000'


/*select p.ProID, p.Pro_Name, p.Price, p.Size, p.Description, p.Image, s.SupplierName, c.CategoryName, c.Image
from Products p
join Suppliers s on s.SupplierID = p.SupID
join ProductCategories pc on p.ProID = pc.ProID
join Categories c on pc.CategoryID = c.CategoryID
where p.ProID = 11*/

update Products
set Description = 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. 
Voluptate, fuga. Quo blanditiis recusandae facere nobis cum optio, inventore 
aperiam placeat, quis maxime nam officiis illum? Optio et nisi eius, inventore
impedit ratione sunt, cumque, eligendi asperiores iste porro non error?',
Size = 'M,L,XL,XXL,XXXL'

