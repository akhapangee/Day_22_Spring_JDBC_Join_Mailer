insert into enquiry_status(name, color)
values('Enrolled','green'),('Interested','pink'),
('Not Interested','red'),('Pending','white');

insert into courses(name, code, fees, status)
values('Core Java','CJV',15000,1),('Advanced Java', 'AJV', 25000,1),
('Combo java','CMJ',35000,1),('Asp.net MVC','ASP',35000,1);

insert into mail_templates(slug, name, content, status)
values('Enroll-Confirmation','Enrollment Confirmation','',1);

update enquiry_status set status =1;