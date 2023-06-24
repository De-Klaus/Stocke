create table stocke_CaseApplication (
	id_ LONG not null primary key,
	AdditionalFields VARCHAR(75) null,
	Status VARCHAR(75) null,
	CaseModelId LONG,
	OwnerId LONG,
	Active BOOLEAN,
	Archive BOOLEAN,
	Hidden BOOLEAN,
	Type LONG,
	StartDate DATE null,
	EndDate DATE null
);

create table stocke_StatusModel (
	id_ LONG not null primary key,
	CaseModelId LONG,
	Status VARCHAR(75) null,
	Internal BOOLEAN,
	Message VARCHAR(75) null,
	Notification BOOLEAN,
	NotificationCount LONG,
	NotificationType BOOLEAN
);