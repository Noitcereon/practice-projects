CREATE TABLE [dbo].[Game]
(
	[Id] NVARCHAR(68) NOT NULL PRIMARY KEY, 
    [Title] NVARCHAR(50) NOT NULL, 
    [Description] NVARCHAR(250) NOT NULL, 
    [ReleaseYear] NVARCHAR(4) NOT NULL, 
    [Price] DECIMAL(18, 2) NULL
)
