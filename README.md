# Data Hound
Our project is a central data management system which provides insightful analytics, and existing data porting.

# Inspiration
Creating a way for non-profit companies to centralize their data from the many different sources it comes from and manage/report/analyze it.

# What it does
Our primary focus was a centralized location to store data that was robust like it was built only for "Lost Our Homes" but versatile like it was an open source product. To accomplish this we created a website which reads in CSV files to handle any current your company might be holding on to all the while allowing you to manually create future tables preventing the Organization from relying on any other data formatting software. The Key behind the sites dynamic data storage is a two-table system we designed. The first tables role is to keep track of column/field names while the second table stores the data values that relate to the column names.

Functionality: The ability to export data in the form of a .csv file, Graphs that update and change size to meet users needs, Loading wheel, Our unique dashboard that displays tables and grants quick access to a table editing feature, and two-step employee authentification as well as an "employees" view available to admin.

# How we built it
Split up modules into small tasks that were evenly divided out to team members, Github for source control, Mysql for DB, Java Spring MVC for web framework, Apache Tomcat for Server

# My (Trevor Moore's) Contribution
I developed the back-end services and business logic for the app. I integrated .csv file upload and download by utilizing the SuperCSV and OpenCSV opensource API's. I created two REST Spring HTTP POST API's that return all the data from whichever dataset/table specified. Finally, I designed the homepage, login, and register front-end and back-end (java for back-end and used html and css with bootstrap) and wrote the flow for the login/register process.

# Challenges we ran into
Collaborating on modules at the same time (git), visually displaying analytics calculations, deciding on an overall design structure

# Accomplishments that we're proud of
Completing a finished product, dynamically importing data and storing it in sql, displaying visual analytics of imported data

# What we learned
how to communicate and collaborate on a project, how to use source control, how to design and plan a system before execution

# What's next for Data Hound
More detailed analytics and file import/export types, Native Mobile App
