const connection = require('./database.js');

// Create a table
const createTableQuery = `
CREATE TABLE registrations (
  id INT AUTO_INCREMENT PRIMARY KEY,
  course VARCHAR(255),
  name VARCHAR(255),
  gender VARCHAR(10),
  dob DATE,
  address TEXT,
  phone VARCHAR(15),
  hobbies TEXT
);
`;

connection.query(createTableQuery, (err, results) => {
  if (err) {
    console.error('Error creating table:', err);
    return;
  }
  console.log('Table "users" created successfully');
});
