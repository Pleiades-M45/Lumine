const express = require('express');
const bodyParser = require('body-parser');

// Import the database connection from database.js
const connection = require('./database.js');

const path = require('path');

// Create an Express app
const app = express();

// Serve static files from the 'public' folder
app.use(express.static(path.join(__dirname, 'public')));

// Middleware to parse form data
app.use(bodyParser.urlencoded({ extended: true }));

// Serve the HTML form on the root URL
app.get('/', (req, res) => {
    res.sendFile(__dirname + '/index.html'); // Path to your HTML file
});

// Handle form submission (POST request)
app.post('/submit', (req, res) => {
    // Extract form data from the request body
    const { course, name, gender, dob, address, phone, hobbies } = req.body;

    // Ensure 'hobbies' is always an array (even if only one checkbox is selected)
    const hobbiesList = Array.isArray(hobbies) ? hobbies.join(', ') : hobbies ? hobbies : '';

    // Prepare the SQL query to insert data into the database
    const query = `INSERT INTO registrations (course, name, gender, dob, address, phone, hobbies) VALUES (?, ?, ?, ?, ?, ?, ?)`;

    // Execute the query with form data using the correct connection object
    connection.query(query, [course, name, gender, dob, address, phone, hobbiesList], (err, result) => {
        if (err) {
            console.error(err);
            res.status(500).send('Error inserting data');
        } else {
            res.send('Registration successful');
        }
    });
});

// Start the server
const PORT = 3000;
app.listen(PORT, () => {
    console.log(`Server running at http://localhost:${PORT}/`);
});
