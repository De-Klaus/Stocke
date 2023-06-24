create index IX_A6FE4B54 on stocke_CaseApplication (Active, CaseModelId);
create index IX_C8D3C8C8 on stocke_CaseApplication (Archive, CaseModelId);
create index IX_D26E0B8B on stocke_CaseApplication (CaseModelId, EndDate);
create index IX_5614A9D2 on stocke_CaseApplication (CaseModelId, StartDate);
create index IX_B6400D34 on stocke_CaseApplication (CaseModelId, Status[$COLUMN_LENGTH:75$]);
create index IX_4E519030 on stocke_CaseApplication (Hidden, CaseModelId);

create index IX_D59132C8 on stocke_StatusModel (CaseModelId, Internal);