
db.employees.insertMany([
  {empId: 1, name: 'Clark', dept: 'Sales', salary: 5000 },
  {empId: 2, name: 'Dave', dept: 'Accounting', salary: 6000  },
  {empId: 3, name: 'Lumine', dept: 'Sales', salary: 7000  }
]);

//db.employees.find();

//db.employees.find({ name: { $regex:/e$/, $options: 'i' } });

//db.employees.updateMany( {}, { $inc: {salary: -1000} } );

//db.employees.aggregate([ { $group: { _id: "$dept", totalSalary: { $sum: "$salary" } } } ]);

//db.employees.deleteMany({ dept: "Sales", name: { $regex:/e$/, $options: 'i' }});

db.createUser({ user: "orca", pwd: "123", roles: [{ role: "read", db: "abc" }] });

db.runCommand({ connectionStatus: 1});

//db.getUser("orca");

mongo -u "orca" -p "123" --authenticationDatabase "abc"

//db.employees.find();


PROG  21: Create a database named "Company" in MongoDB and add a collection called Customer" with the following fields: id, name, email, phone and address.
a)Update the email of a customer where id is "C123".
b)Delete all customers who have not placed an order in the last year.
c)Find all customers whose name starts with "A" and have placed more than five orders.

use Company; // Create and switch to the Company database

// Create the Customer collection and insert sample data
db.Customer.insertMany([

  { id: "C123", name: "Alice", email: "alice@example.com", phone: "123-456-7890", address: "123 Main St" },

  { id: "C124", name: "Bob", email: "bob@example.com", phone: "234-567-8901", address: "456 Elm St" },

  { id: "C125", name: "Charlie", email: "charlie@example.com", phone: "345-678-9012", address: "789 Oak St" }

]);


db.Customer.updateOne(
  { id: "C123" },
  { $set: { email: "alice.new@example.com" } }
);


db.Customer.deleteMany(
  { lastOrderDate: { $lt: new Date(new Date().setFullYear(new Date().getFullYear() - 1)) } }
);


db.Customer.find(
  { name: { $regex: /^A/ }, orderCount: { $gt: 5 } }
);



PROG  22: Create a database named "College" in MongoDB and add a collection called "Student" with the following fields: Id, Name, Age, Gender, Department, Sub1, Sub2, Attendance.
a)Find students who scored more than 80 in both subjects.
b)List students who are either in the "Computer Science" department or are older than 22.
c)Find students who are not in the "Electronics" department.
d)Retrieve students who neither scored above 80 in sub1 nor have attendance more than 85%.
e)Find students who are neither in "Mechanical" nor in "Civil" departments.
  
use College; // Create and switch to the College database

// Create the Student collection and insert sample data
db.Student.insertMany([
  { Id: "S001", Name: "Alice", Age: 21, Gender: "Female", Department: "Computer Science", Sub1: 85, Sub2: 90, Attendance: 88 },

  { Id: "S002", Name: "Bob", Age: 23, Gender: "Male", Department: "Mechanical", Sub1: 75, Sub2: 80, Attendance: 90 },

  { Id: "S003", Name: "Charlie", Age: 22, Gender: "Male", Department: "Electronics", Sub1: 82, Sub2: 78, Attendance: 80 },

  { Id: "S004", Name: "David", Age: 24, Gender: "Male", Department: "Computer Science", Sub1: 90, Sub2: 95, Attendance: 92 },

  { Id: "S005", Name: "Eva", Age: 21, Gender: "Female", Department: "Civil", Sub1: 70, Sub2: 60, Attendance: 84 }

]);


db.Student.find(
  { Sub1: { $gt: 80 }, Sub2: { $gt: 80 } }
);


db.Student.find(
  { $or: [ { Department: "Computer Science" }, { Age: { $gt: 22 } } ] }
);


db.Student.find(
  { Department: { $ne: "Electronics" } }
);


$nor: Used for multiple conditions that must all be false. It can combine various fields and conditions.
// db.collection.find({
// $nor: [
//   { field1: value1 },
//   { field2: value2 }
// ]
// });
This query will return documents where neither field1 equals value1 nor field2 equals value2.
db.Student.find(
  { $nor: [ { Sub1: { $gt: 80 } }, { Attendance: { $gt: 85 } } ] }
);


$nin: Used for a single field to check that its value is not in a specified list of values.
// db.collection.find({
//   field: { $nin: [value1, value2, value3] }
// });
This query will return documents where field does not have a value of value1, value2, or value3.
db.Student.find(
  { Department: { $nin: ["Mechanical", "Civil"] } }
);
