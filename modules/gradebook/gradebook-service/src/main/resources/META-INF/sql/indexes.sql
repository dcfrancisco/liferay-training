create index IX_ECC0CAC5 on Assignment_Assignment (groupId);
create index IX_785EDA39 on Assignment_Assignment (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_CE1A9AFB on Assignment_Assignment (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_14D546B8 on Gradebook_Assignment (groupId);
create index IX_51DB1FA6 on Gradebook_Assignment (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_F2D357A8 on Gradebook_Assignment (uuid_[$COLUMN_LENGTH:75$], groupId);