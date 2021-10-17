create index IX_ECC0CAC5 on Assignment_Assignment (groupId);
create index IX_785EDA39 on Assignment_Assignment (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_CE1A9AFB on Assignment_Assignment (uuid_[$COLUMN_LENGTH:75$], groupId);