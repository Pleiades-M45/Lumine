const mysql = require('mysql2');

// Create a connection to the database using promises
const connection = mysql.createConnection({
  host: 'localhost',      // MySQL server host
  user: 'root',           // MySQL username (default is 'root' for XAMPP)
  password: '',           // MySQL password (default is empty for XAMPP)
  database: 'node_user'   // Name of the database you're using
});

// Connect to the database and return the promise
connection.connect((err) => {
  if (err) {
    console.error('Error connecting to the database:', err.stack);
    return;
  }
  console.log('Connected to the database.');
});

// Gracefully handle app termination and close the connection
process.on('SIGINT', () => {
  connection.end((err) => {
    if (err) {
      console.error('Error closing the database connection:', err.stack);
    } else {
      console.log('Database connection closed gracefully.');
    }
    process.exit();
  });
});

// Export the connection for use in other files
module.exports = connection;
