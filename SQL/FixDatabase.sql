/*use kvshop
go
alter table Categories
add Image varchar(max);
go
update Categories
set Image = (select Image from Products where ProID = 1)
go*/
/*
use kvshop
go
alter table Products
add Size nvarchar(100),
	Description nvarchar(max);

update Products
set Price = '100000'
---------*/

select top 1 p.ProID, p.Pro_Name, p.Price, p.Size, p.Description, p.Image, s.SupplierName, c.CategoryName, c.Image
from Products p
join Suppliers s on s.SupplierID = p.SupID
join ProductCategories pc on p.ProID = pc.ProID
join Categories c on pc.CategoryID = c.CategoryID
where p.ProID = 2

-- categoryID
select top 1 c.CategoryID
from Products p
join Suppliers s on s.SupplierID = p.SupID
join ProductCategories pc on p.ProID = pc.ProID
join Categories c on pc.CategoryID = c.CategoryID
where p.ProID = 2

select p.ProID, p.Pro_Name, p.Price, p.Size, p.Description, p.Image, s.SupplierName, c.CategoryName, c.Image
from Products p
join Suppliers s on s.SupplierID = p.SupID
join ProductCategories pc on p.ProID = pc.ProID
join Categories c on pc.CategoryID = c.CategoryID
where pc.CategoryID =  (
	select top 1 c.CategoryID
	from Products p
	join Suppliers s on s.SupplierID = p.SupID
	join ProductCategories pc on p.ProID = pc.ProID
	join Categories c on pc.CategoryID = c.CategoryID
	where p.ProID = 2
)


select p.ProID, p.Pro_Name, p.Price, p.Size, p.Description, p.Image as ProImage,s.SupplierID
, s.SupplierName, c.CategoryID, c.CategoryName, c.Image as CateImage
from (
	select top 1 c.CategoryID
	from Products p
	join Suppliers s on s.SupplierID = p.SupID
	join ProductCategories pc on p.ProID = pc.ProID
	join Categories c on pc.CategoryID = c.CategoryID
	where p.ProID = 2
) as cateID, Products p
join Suppliers s on s.SupplierID = p.SupID
join ProductCategories pc on p.ProID = pc.ProID
join Categories c on pc.CategoryID = c.CategoryID
where pc.CategoryID =  cateID.CategoryID

select * from ProductCategories pc, Categories c where pc.CategoryID = c.CategoryID and c.CategoryName like 'Clothing'



update Cart_Items set Quantity = 1 where CartID = 11 and ProID = 2

update Products
set Description = 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. 
Voluptate, fuga. Quo blanditiis recusandae facere nobis cum optio, inventore 
aperiam placeat, quis maxime nam officiis illum? Optio et nisi eius, inventore
impedit ratione sunt, cumque, eligendi asperiores iste porro non error?',
Size = 'M,L,XL,XXL,XXXL'


select C.CartID, P.ProID, P.Pro_Name, P.Image, COUNT(*) as Quantity, P.Price from Cart_Items CI 
join Products P on CI.ProID = P.ProID join Carts C on CI.CartID = C.CartID 
where C.UserID = 11
group by C.CartID, P.ProID, P.Pro_Name, P.Image
, P.Price order by C.CartID desc, P.ProID asc

select CI.ItemID, CartID.CartID, P.ProID, P.Pro_Name, P.Image, Quantity, P.Price 
from (select CartID from Carts where UserID = 11) as CartID, Cart_Items CI 
join Products P on CI.ProID = P.ProID 
where CartID.CartID = CI.CartID order by ProID asc

select * from Cart_Items where CartID = 11 order by ProID asc

select * from Products where ProID in (select ProID from ProductCategories where CategoryID = 1)
----
select * from Cart_Items where CartID =11 order by ProID asc

update Cart_Items
set Quantity = 1 where CartID = 11 and ProID = 2

delete from Cart_Items where ItemID = 13

---
update Products set Image = (select top 1 Image from Products where ProID = 1) where ProID = 26
select Image from Products where ProID = 26