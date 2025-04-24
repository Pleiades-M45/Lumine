
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
