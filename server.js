const express = require('express');
const cors = require('cors');
const mysql = require('mysql2');

const app = express();
const port = 5000;

app.use(cors());
app.use(express.json());

const connection = mysql.createConnection({
    host:'localhost',
    user:'root',
    password:'',
    database:'semexam'
});

connection.connect((err)=>{
    if(err){
        console.log(err.stack);
        return;
    }
    console.log("Connected to database successfully");
});


app.get('/', (req,res) => {
    res.send('Hello World');
});

app.post('/addbill',(req,res) => {
    const {userId, description, amount }= req.body;

    if(!userId || !description || !amount){
        return res.status(400).send({message: 'All fields are required'});
    }

    const currentDateTime = new Date().toISOString().slice(0, 19).replace('T', ' ');

    const checkQuery = 'SELECT * FROM bills WHERE id = ?';
    connection.query(checkQuery, [userId], (err, result) => {
        if (result.length > 0) {
            return res.status(400).send({ message: 'Duplicate userId, this bill already exists' });
        }

        const insertQuery = `INSERT INTO bills (id, description, amount, date) VALUES (?, ?, ?, ?)`;
        connection.query(insertQuery, [userId, description, amount, currentDateTime], (err, result) => {
            if (err) {
                console.error('Database error: ',err);
                return res.status(500).send({message: 'Error adding bill'});
            }
            res.status(201).send({message: 'Bill added successfully'});
        });
    });
});

app.get('/viewbill', (req,res) => {
    const selectQuery = `SELECT * FROM bills`;
    connection.query(selectQuery, (err,results) => {
        if(err){
            console.log(err.stack);
            return res.status(500).send(err);
        }
        res.send(results);
    });
});

app.listen(port, () => {
    console.log(`Server running on http://localhost:${port}`);
});