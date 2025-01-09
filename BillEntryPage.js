import React, {useState} from 'react';
import axios from 'axios';

const BillEntryPage = () => {
    const [formData, setFormData] = useState({
        userId: '',
        description: '',
        amount: ''
    });

    const [message, setMessage] = useState('');

    const handleChange = (e) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value
        });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        setMessage('');

        if (isNaN(formData.userId)) {
            setMessage('User Id must be a valid number');
            return;
        }

        if (isNaN(formData.amount)) {
            setMessage('Amount must be a valid number');
            return;
        }

        try{
            const response = await axios.post('http://localhost:5000/addbill', formData);
            console.log('Bill added successfully',response.data);
            setMessage('Bill added successfully');
        }
        catch(error)
        {
            setMessage('Error adding bill');
            console.log('Error adding bill',error);
        }
    };

    return(
        <div>
            <h2>Bill Entry Page</h2>
            {message && <p style={{ color: 'red' }}>{message}</p>}
            <form onSubmit={handleSubmit}>
                <div>
                    <label>User Id:</label>
                    <input type="text" name='userId' required value={formData.userId} onChange={handleChange}/>
                </div>
                <div>
                    <label>Description:</label>
                    <input type="text" name='description' required value={formData.description} onChange={handleChange}/>
                </div>
                <div>
                    <label>Amount:</label>
                    <input type="text" name='amount' required value={formData.amount} onChange={handleChange}/>
                </div>
                <button type="submit">Add Bill</button>
            </form>
        </div>
    );
};

export default BillEntryPage;