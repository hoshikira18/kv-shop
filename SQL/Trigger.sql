--drop trigger insertOrUpdate

CREATE TRIGGER insertOrUpdate
ON Cart_Items
INSTEAD OF INSERT
AS
BEGIN
    SET NOCOUNT ON;

    MERGE INTO Cart_Items AS target
    USING (SELECT CartID, ProID, Quantity, ProSize FROM inserted) AS source
    ON target.CartID = source.CartID AND target.ProID = source.ProID AND target.ProSize = source.ProSize
    WHEN MATCHED THEN
        UPDATE SET target.Quantity = target.Quantity + source.Quantity
    WHEN NOT MATCHED THEN
        INSERT (CartID, ProID, Quantity, ProSize)
        VALUES (source.CartID, source.ProID, source.Quantity, source.ProSize);
END;

