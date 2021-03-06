create index IX_70A75DFA on CT_CTUser (groupId);
create index IX_E61104EA on CT_CTUser (userId);
create index IX_2C102704 on CT_CTUser (uuid_);
create index IX_B66212A4 on CT_CTUser (uuid_, companyId);
create unique index IX_9D6F226 on CT_CTUser (uuid_, groupId);

create index IX_B9B4D73A on CT_Rule (groupId);
create index IX_30AAF044 on CT_Rule (uuid_);
create index IX_14C90164 on CT_Rule (uuid_, companyId);
create unique index IX_4EAA90E6 on CT_Rule (uuid_, groupId);

create index IX_B034D565 on CT_RuleInstance (groupId);
create index IX_29BE548E on CT_RuleInstance (userSegmentId);
create index IX_74DA7D2F on CT_RuleInstance (uuid_);
create index IX_E3BCC399 on CT_RuleInstance (uuid_, companyId);
create unique index IX_B8A35C5B on CT_RuleInstance (uuid_, groupId);

create index IX_34C5416A on CT_UserSegment (groupId);
create index IX_78302674 on CT_UserSegment (uuid_);
create index IX_42550D34 on CT_UserSegment (uuid_, companyId);
create unique index IX_F86750B6 on CT_UserSegment (uuid_, groupId);