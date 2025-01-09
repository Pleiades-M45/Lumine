import React, { useEffect, useState } from 'react';
import axios from 'axios';

const ViewBillsPage = () => {
    const [bills, setBills] = useState([]);
    const [error, setError] = useState('');

    useEffect(() => {
        const fetchBills = async () => {
            try {
                const response = await axios.get('http://localhost:5000/viewbill');
                setBills(response.data);
            } catch (err) {
                console.error('Error fetching bills:', err);
                setError('Failed to fetch bills.');
            }
        };

        fetchBills();
    }, []);

    return (
        <div>
            <h2>Bill List</h2>
            {error && <p style={{ color: 'red' }}>{error}</p>}
            <table border="1" style={{ borderCollapse: 'collapse', width: '100%' }}>
                <thead>
                    <tr>
                        <th>User ID</th>
                        <th>Description</th>
                        <th>Amount</th>
                        <th>Date</th>
                        <th>Time</th>
                    </tr>
                </thead>
                <tbody>
                    {bills.map((bill) => {
                        const dateTime = new Date(bill.date); // Parse the datetime
                        const date = dateTime.toLocaleDateString(); // Extract date
                        const time = dateTime.toLocaleTimeString(); // Extract time

                        return (
                            <tr key={bill.id}>
                                <td>{bill.id}</td>
                                <td>{bill.description}</td>
                                <td>{bill.amount}</td>
                                <td>{date}</td>
                                <td>{time}</td>
                            </tr>
                        );
                    })}
                </tbody>
            </table>
        </div>
    );
};

export default ViewBillsPage;
